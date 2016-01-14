package com.ckhgame.villagebento.entity.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.ai.villager.VillagerAISleeping;
import com.ckhgame.villagebento.ai.villager.VillagerAIVisiting;
import com.ckhgame.villagebento.ai.villager.VillagerAIWandering;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchInteractTarget;
import com.ckhgame.villagebento.ai.villager.VillagerAIWorking;
import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.config.ConfigDev;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.VBVillagerMgr;
import com.ckhgame.villagebento.gui.GuiVillagerDialogMenu;
import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.data.Vec3Int;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.village.HelperVillager;
import com.ckhgame.villagebento.util.village.HelperVisiting;
import com.ckhgame.villagebento.util.village.PlayerMsg;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityVBVillager extends EntityAgeable {

	private Profession profession; 	// profession of the villager
	private int buidlingID = -1; // village building ID (used to find the related
	
	private int visitingBuildingID = -1; 		//ID of the building the villager is visiting...
	private boolean visitingSkipSleep = false; 	//if the visiting should ignore sleeping schedule, e.g. the villager is staying in tavern over night
	
	//components of the villager (is created by profession)
	private ArrayList<VillagerComponent> components = new ArrayList<VillagerComponent>();
	
	//initialized position relates to the building
	private int initPosX, initPosY, initPosZ;
	
	private boolean isTraveler = false; // if this villager is a traveler
	private int travelTimer;
	
	public EntityVBVillager(World w) {
		super(w);
		this.setSize(0.4F, 1.8F);
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setEnterDoors(true);
		this.initAITasks();	
		this.setAlwaysRenderNameTag(true);
		if(!w.isRemote){
			VBVillagerMgr.get().addVillager(this);
		}
	}
	
	public void initAITasks(){
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMob.class, 6.0F, 0.4D, 0.4D));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));

		this.tasks.addTask(3, new VillagerAIWatchInteractTarget(this, ConfigVillager.MaxInteractDistance));
		this.tasks.addTask(3, new VillagerAIWatchClosest(this, EntityPlayer.class, ConfigVillager.MaxInteractDistance, 1.0F));
		this.tasks.addTask(3, new VillagerAIWatchClosest(this, EntityVBVillager.class, 5.0F, 0.02F));
		this.tasks.addTask(3, new VillagerAIWatchClosest(this, EntityLiving.class, 8.0F, 0.02F));
		
		this.tasks.addTask(4, new VillagerAISleeping(this));
		this.tasks.addTask(5, new VillagerAIWorking(this));
		this.tasks.addTask(6, new VillagerAIVisiting(this));
		this.tasks.addTask(7, new VillagerAIWandering(this));
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(17, new Integer(-1));	//profession
        this.dataWatcher.addObject(18, new Integer(-1));	//sleeping <0: false, others: true ( >= 0indicates the sleep orientation as well:0 90 180 270)
        this.dataWatcher.addObject(19, new Integer(0));	//level
        
        if(ConfigDev.VillagerDebugEnabled){
        	this.debugInit();
        }
    }
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(ConfigVillager.AIVillagerSearchDistance);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}

	public int getProfessionID(){
		return this.dataWatcher.getWatchableObjectInt(17);
	}
	
	protected void setProfessionID(int professionID){
		this.dataWatcher.updateObject(17, professionID);
		initProfession();
	}
	
	public void setProfession(Profession profession) {
		this.setProfessionID(profession.getProfessionID());
	}

	public Profession getProfession() {		
		initProfession();
		return this.profession;
	}
	
	protected void initProfession(){
		//don't have profession instance or changed the profession
		if(this.profession == null || this.getProfessionID() != this.profession.getProfessionID())
		{
			if(this.getProfessionID() >= 0){
				this.profession = Profession.registry.get(this.getProfessionID());
				this.components.clear();
				this.profession.createVillagerComponents(this.components,this);
			}
			else{
				this.profession = null;
			}
		}
	}

	public void setBuildingID(int buildingID) {
		this.buidlingID = buildingID;
	}

	public int getBuildingID() {
		return this.buidlingID;
	}

	public int getLevel(){
		return this.dataWatcher.getWatchableObjectInt(19);
	}
	
	protected void setLevel(int level){
		this.dataWatcher.updateObject(19,level);
	}
	
	public void upgradeLevel(){
		this.setLevel(this.getLevel() + 1);
		onLevelUpgraded();
	}
	
	public void onLevelUpgraded(){
		float hp = 8.0F + this.getLevel() * 3;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(hp);
		if (this.getHealth() > hp)
			this.setHealth(hp);
	}

	/**
	 * must be called before set profession since setProfession will finally set
	 * the custom tag name
	 */
	public void setName(String name) {
		this.setCustomNameTag(name);
	}

	public String getName() {
		return this.getCustomNameTag();
	}

	//-- sleeping --
	public void setSleepingValue(int value){
		this.dataWatcher.updateObject(18, value);
	}
	
	public int getSleepingValue(){
		return this.dataWatcher.getWatchableObjectInt(18);
	}
	
	public void setSleeping(boolean sleeping) {
		//it's actually saving the bed orientation when it >= 0, which is used on rendering sleeping...
		this.dataWatcher.updateObject(18, sleeping?this.getBedOrientationInDegrees():-1);
	}
	
	public int getSleepingOrientation(){
		if(this.isSleeping()){
			return this.dataWatcher.getWatchableObjectInt(18);
		}
		else{
			return 0;
		}
	}

	public boolean isSleeping() {
		return this.dataWatcher.getWatchableObjectInt(18) < 0?false:true;
	}
	
	public void startSleeping(){
		if(!this.worldObj.isRemote && this.bedPosition != null){
			this.setSleeping(true);
			this.getNavigator().clearPathEntity();
			this.setPosition(this.bedPosition.x + 0.5D, this.bedPosition.y + 1.0D, this.bedPosition.z + 0.5D);
		}
	}
	
	public void endSleeping(){
		if(!this.worldObj.isRemote){
			this.setSleeping(false);
			//find a passable block near the bed
			if(this.isNearBed()){
				Vec3 p = HelperVillager.findWalkableBlockNearPos(this.worldObj,this.bedPosition.x,this.bedPosition.y, this.bedPosition.z);
				this.setPosition(p.xCoord,p.yCoord,p.zCoord);
			}	
		}
	}
	
	//-- init position --
	public void setInitPos(int x, int y, int z){
		this.initPosX = x;
		this.initPosY = y;
		this.initPosZ = z;
	}
	
	public int getInitPosX(){
		return this.initPosX;
	}
	
	public int getInitPosY(){
		return this.initPosY;
	}
	
	public int getInitPosZ(){
		return this.initPosZ;
	}
	
	public void moveToInitPos(){
		this.setPosition(this.initPosX + 0.5D, this.initPosY + 0.1D, this.initPosZ + 0.5D);
	}
	
	//-- villager components --
	public int getVillagerComponentsSize(){
		return this.components.size();
	}
	
	public int findVillagerComponentIdx(VillagerComponent component){
		int idx = 0;
		for(VillagerComponent comp : components){
			if(component == comp){
				return idx;
			}	
			idx++;
		}
		return -1;
	}
	
	public VillagerComponent getVillagerComponent(int idx){
		if(idx < this.components.size())
			return this.components.get(idx);
		else
			return null;
	}
	
	public VillagerComponent getVillagerComponent(Class<? extends VillagerComponent> compClass){
		for(VillagerComponent comp : this.components ){
			if(comp.getClass() == compClass){
				return comp;
			}
		}
		return null;
	}
	
	public void updateVillagerComponentsByTime(int time){
		for(VillagerComponent component : components)
			component.update(time);
	}
	
	public void firstTimeInitComponents(){
		for(VillagerComponent component : components)
			component.firstTimeInit();
	}

	//-- visiting --	
	public void startRandomVisiting(){	
	 HelperVisiting.startRandomVisiting(this);
	}
	
	public void cancelVisiting(){
		this.visitingBuildingID = -1;
		if(this.isRiding()){
			this.mountEntity(null);
		}
	}
	
	public boolean isVisiting(){
		return (this.visitingBuildingID >= 0);
	}
	
	public int getVisitingBuildingID(){
		return this.visitingBuildingID;
	}
	
	public void setVisitingBuidlingID(int bid){
		this.visitingBuildingID = bid;
	}
	
	public void setVisitingSkipSleeping(boolean skip){
		this.visitingSkipSleep = skip;
	}
	
	public boolean isVisitingSkipSleeping(){
		return this.visitingSkipSleep;
	}
	
	//traveler
	public void setTraveler(int travelTime){
		if(travelTime > 0){
			this.isTraveler = true;
			this.travelTimer = travelTime;
		}
		else{
			this.isTraveler = false;
		}
	}
	
	public boolean isTraveler(){
		return this.isTraveler;
	}
	
	public int getTravelTimer(){
		return this.travelTimer;
	}
	
	public void stepTravelTimer(){
		this.travelTimer--;
	}
	
	// temp caches
	public Entity InteractTarget;
	public int buildingX, buildingY, buildingZ;
	public int buildingSizeX, buildingSizeZ;
	public int bedIdx = -1;
	public Vec3Int bedPosition = null;
	public int bedOritation;
	
	private void refreshBuildingCaches(){
		if(!this.worldObj.isRemote){//server only
			DataVillageBento dataVB = DataVillageBento.get();
			DataBuilding db = HelperDataVB.findBuildingByID(dataVB, this.getBuildingID());
			buildingX = db.x;
			buildingY = db.y;
			buildingZ = db.z;
			buildingSizeX = db.sizeX;
			buildingSizeZ = db.sizeZ;		
			System.out.println("apply bed!");
			//when we spawn a traveler, we have to set the initialized position, which requires the bed position, 
			//so in this case the bed index will be generated before the entity is actually spawned, that's why we
			//check the bed index before apply since we don't want the villager apply the bed twice.
			if(bedIdx < 0){ 
				bedIdx = db.applyForBed(this.getName());
			}
			bedPosition =  db.getBedPosition(bedIdx);
			if(bedPosition == null)
				System.out.println("BED ISNULL!!!");
			else
				System.out.println("=====" + bedPosition.x + "," + bedPosition.y + "," + bedPosition.z);
		}
	}

	public boolean isNearBed() {
		if (this.bedPosition == null) {
			return false;
		} else {
			double dy = Math.abs(this.posY - this.bedPosition.y);
			double dx = this.bedPosition.x + 0.5D - this.posX;
			double dz = this.bedPosition.z + 0.5D - this.posZ;
			double dxz = Math.sqrt(dx * dx + dz * dz);
			// System.out.println("dy:" + dy + ",dxz:" + dxz);
			return (dy <= 1.0D && dxz <= 1.6D);
		}
	}

	public int getBedOrientationInDegrees() {
		if (this.bedPosition != null) {
			int x = bedPosition.x;
			int y = bedPosition.y;
			int z = bedPosition.z;
			int j = worldObj.getBlock(x, y, z).getBedDirection(worldObj, x, y, z);
			
			switch (j) {
			case 0:
				return 90;
			case 1:
				return 0;
			case 2:
				return 270;
			case 3:
				return 180;
			}
		}

		return 0;
	}

	@Override
	public EntityVBVillager createChild(EntityAgeable p_90011_1_) {
		return null;
	}


	public void openVillagerGui() {
		
		Minecraft.getMinecraft().displayGuiScreen(new GuiVillagerDialogMenu(this));
		
//		GuiVillager startGUI = null;
//
//		for (VillagerComponent comp : this.components) {
//			comp.getGui().setVillageComponent(comp);
//			if (comp.getClass() == VillagerCompAbout.class)
//				startGUI = comp.getGui();
//		}
//
//		if (startGUI != null)
//			Minecraft.getMinecraft().displayGuiScreen(startGUI);
	}

	public boolean interact(EntityPlayer p_70085_1_) {		
		
		if (this.getDistanceSqToEntity(p_70085_1_) <= ConfigVillager.MaxInteractDistanceSq) {
			if (this.isSleeping()) {
				if (this.worldObj.isRemote)
					PlayerMsg.sendTranslation(p_70085_1_, "villagebento.msg.villagerIsSleeping", this.getName());
			} else {
				if (this.worldObj.isRemote) {
					this.openVillagerGui();
				} else {
					this.InteractTarget = p_70085_1_;
					this.getNavigator().clearPathEntity();
				}
			}
		} else {
			if (this.worldObj.isRemote)
				PlayerMsg.sendTranslation(p_70085_1_, "villagebento.msg.villagerTooFar");
		}

		return true;
	}
	
	
	private void updateInteractTarget(){
		if(this.InteractTarget != null && !this.worldObj.isRemote){
			if(this.getDistanceSqToEntity( this.InteractTarget) > ConfigVillager.MaxInteractDistanceSq){
				this.InteractTarget = null;
			}
		}
	}

	private boolean isFirstTimeLivingUpdate = true;
	private void onFirstTimeLivingUpdate(){
		this.refreshBuildingCaches();
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(isFirstTimeLivingUpdate){
			isFirstTimeLivingUpdate = false;
			this.onFirstTimeLivingUpdate();
		}
		
		this.updateInteractTarget();
		
		this.updateArmSwingProgress();
		if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 80 * 12 == 0) {
			this.heal(1.0F);
		}
		
		if(ConfigDev.VillagerDebugEnabled){
			this.debugUpdate();
		}
	}

	protected void attackEntity(Entity entity, float distance) {
		if (this.attackTime <= 0 && distance < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY
				&& entity.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(entity);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		// deal damage
		float dmg = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), dmg);
		// knock back
		float k = 0.5F;
		entity.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * k * 0.5F), 0.1D,
				(double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) k * 0.5F));
		this.motionX *= 0.6D;
		this.motionZ *= 0.6D;

		return super.attackEntityAsMob(entity);
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
		if (p_70097_1_.getEntity() instanceof EntityLivingBase)
			this.setAttackTarget((EntityLivingBase) p_70097_1_.getEntity());
		return super.attackEntityFrom(p_70097_1_, p_70097_2_);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setInteger(ConfigData.KeyVillagerProfessionID, this.getProfessionID());
		p_70014_1_.setInteger(ConfigData.KeyVillagerBuildingID, this.getBuildingID());
		p_70014_1_.setInteger(ConfigData.KeyVillagerInitX, this.initPosX);
		p_70014_1_.setInteger(ConfigData.KeyVillagerInitY, this.initPosY);
		p_70014_1_.setInteger(ConfigData.KeyVillagerInitZ, this.initPosZ);
		p_70014_1_.setInteger(ConfigData.KeyVillagerLevel, this.getLevel());
		p_70014_1_.setInteger(ConfigData.KeyVillagerSleeping, this.getSleepingValue());
		p_70014_1_.setInteger(ConfigData.KeyVillagerVisitingBuildingID, this.getVisitingBuildingID());
		p_70014_1_.setBoolean(ConfigData.KeyVillagerVisitingSkipSleep, this.isVisitingSkipSleeping());
		p_70014_1_.setBoolean(ConfigData.KeyVillagerIsTraveler, this.isTraveler());
		p_70014_1_.setInteger(ConfigData.KeyVillagerTravelerTimer, this.getTravelTimer());
		
		for(VillagerComponent component : components)
			component.writeToNBT(p_70014_1_);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		super.readEntityFromNBT(p_70037_1_);
		this.setProfessionID(p_70037_1_.getInteger(ConfigData.KeyVillagerProfessionID));
		this.setBuildingID(p_70037_1_.getInteger(ConfigData.KeyVillagerBuildingID));
		this.initPosX = p_70037_1_.getInteger(ConfigData.KeyVillagerInitX);
		this.initPosY = p_70037_1_.getInteger(ConfigData.KeyVillagerInitY);
		this.initPosZ = p_70037_1_.getInteger(ConfigData.KeyVillagerInitZ);
		this.setLevel(p_70037_1_.getInteger(ConfigData.KeyVillagerLevel));
		this.setSleepingValue(p_70037_1_.getInteger(ConfigData.KeyVillagerSleeping));
		this.visitingBuildingID = p_70037_1_.getInteger(ConfigData.KeyVillagerVisitingBuildingID);
		this.visitingSkipSleep = p_70037_1_.getBoolean(ConfigData.KeyVillagerVisitingSkipSleep);
		this.isTraveler = p_70037_1_.getBoolean(ConfigData.KeyVillagerIsTraveler);
		this.travelTimer = p_70037_1_.getInteger(ConfigData.KeyVillagerTravelerTimer);
		
		for(VillagerComponent component : components)
			component.readFromNBT(p_70037_1_);
	}

	@Override
	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);

		// when the villager is dead, we should tell the DataVillager he is
		// dead, and he will be revive on next noon
		if (!this.worldObj.isRemote) {
			//should move the villager to death list
			VBVillagerMgr.get().removeVillager(this);
			if(!this.isTraveler()){ // traveler will not revive after death...
				HelperDataVB.addDeadVillager(DataVillageBento.get(), this);
				DataBuilding db = HelperDataVB.findBuildingByID(DataVillageBento.get(), this.getBuildingID());
				db.returnBed(this.bedIdx);
			}
			
			//death message
			PlayerMsg.sendToAllTranslation("villagebento.msg.villagerDeathMessage",this.getName(),p_70645_1_.getDamageType());
		}
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	@Override
	public boolean allowLeashing() {
		return false;
	}

	@Override
	public double getYOffset() {
		// TODO Auto-generated method stub
		return super.getYOffset() - 0.5D;
	}
	
	
	//-----------------------------
	// Debug
	//-----------------------------
	private void debugUpdate(){
		if(true) return;
		if(!this.worldObj.isRemote){
			if(this.getNavigator().noPath())
				setDebugText("No Path, " + this.getCurrentlyDoing());
			else{
				PathPoint p = this.getNavigator().getPath().getFinalPathPoint();
				
				setDebugText(String.format("Move to %d,%d,%d, %s", p.xCoord, p.yCoord, p.zCoord, this.getCurrentlyDoing()));
			}
		}
	}
	
	private void debugInit(){
		this.dataWatcher.addObject(31, "Debug Text");
	}
	
	public void setDebugText(String text){
		this.dataWatcher.updateObject(31, "[Debug] " + text);
	}
	
	public String getDebugText(){
		return this.dataWatcher.getWatchableObjectString(31);
	}
	
private String currentlyDoing = "";
	
	public String getCurrentlyDoing(){
		
		if(this.isVisiting()){
			DataBuilding db = HelperDataVB.findBuildingByID(DataVillageBento.get(),this.getVisitingBuildingID());
			if(db != null){
				Building b = Building.registry.get(db.type);
				return "Visiting " + b.getName();
			}
		}
		
		Profession pro = this.getProfession();
		if(pro.getTimeSchedule().isSleepTimeNow()){
			return "Going to sleep..";
		}
		
		if(pro.getTimeSchedule().isWorkTimeNow()){
			return "Working...";
		}
		
		if(this instanceof EntityVBGuard){
			return "Patrolling..";
		}
		
		return "Wandering...";
	}
}
