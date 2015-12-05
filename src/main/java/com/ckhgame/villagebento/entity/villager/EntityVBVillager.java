package com.ckhgame.villagebento.entity.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.ai.villager.VillagerAISleep;
import com.ckhgame.villagebento.ai.villager.VillagerAIMovement;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest2;
import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.VBEntityMgr;
import com.ckhgame.villagebento.gui.GuiVillager;
import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.data.Vec3Int;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.village.PlayerMsg;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.block.Block;
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
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityVBVillager extends EntityAgeable {

	private Profession profession; 	// professtion of the villager
	private int buidlingID = -1; // village building ID (used to find the related
	
	private int visitingBuildingID = -1; 		//ID of the building the villager is visiting...
	private boolean visitingSkipSleep = false; 	//if the visiting should ignore sleeping schedule, e.g. the villager is staying in tavern over night
	
	//components of the villager (is created by profession)
	private ArrayList<VillagerComponent> components = new ArrayList<VillagerComponent>();
	
	//initialized position relates to the building
	private int initPosX, initPosY, initPosZ;
	
	public EntityVBVillager(World w) {
		super(w);
		this.setSize(0.6F, 1.8F);
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setEnterDoors(true);
		this.initAITasks();	
		this.setAlwaysRenderNameTag(true);
		if(!w.isRemote){
			VBEntityMgr.get().addVillager(this);
		}
	}
	
	public void initAITasks(){
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMob.class, 6.0F, 0.4D, 0.4D));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new VillagerAISleep(this));
		
		this.tasks.addTask(5, new VillagerAIWatchClosest2(this, EntityPlayer.class, ConfigVillager.MaxInteractDistance, 1.0F));
		this.tasks.addTask(5, new VillagerAIWatchClosest2(this, EntityVBVillager.class, 5.0F, 0.02F));
		this.tasks.addTask(6, new VillagerAIMovement(this));
		this.tasks.addTask(7, new VillagerAIWatchClosest(this, EntityLiving.class, 6.0F));
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(17, new Integer(-1));	//profession
        this.dataWatcher.addObject(18, new Integer(-1));	//sleeping <0: false, others: true ( >= 0indicates the sleep orientation as well:0 90 180 270)
        this.dataWatcher.addObject(19, new Integer(0));		//exp
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

	public void setExp(int exp) {
		this.dataWatcher.updateObject(19, exp);
	}
	
	public void addExp(int add){
		int exp = this.getExp();
		int lvl = this.getLevel();
		//add exp
		exp += Math.max(0, add);
		this.setExp(exp);
		//check leveling up
		int lvlAfter = this.getLevel();
		if(lvlAfter != lvl)
			this.levelChanged(lvlAfter > lvl);
	}

	public int getExp() {
		return this.dataWatcher.getWatchableObjectInt(19);
	}
	
	public int getLevel(){
		return this.profession.expToLevel(this.getExp());
	}
	
	public void levelChanged(boolean isLevelup){
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
				int[] dxz = new int[]{1,1, 1,0, 1,-1, 
						  0,1,	0,-1,
						  -1,1, -1,0, -1,-1,0,0};
				for(int i =0;i<dxz.length;i+=2){
					Block b = this.worldObj.getBlock(	(int)this.bedPosition.x + dxz[i], 
														(int)this.bedPosition.y,
														(int)this.bedPosition.z + dxz[i +1]);
					if(b == Blocks.air || b == Blocks.carpet){
						this.setPosition((int)this.bedPosition.x + dxz[i]  + 0.5D, 
										 this.bedPosition.y + 1.0D, 
										 (int)this.bedPosition.z + dxz[i +1] + 0.5D);
						break;
					}
				}
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
		
	}
	
	public void cancelVisiting(){
		
	}
	
	// temp caches
	public int buildingX, buildingY, buildingZ;
	public int buildingSizeX, buildingSizeZ;
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
			bedPosition =  db.applyForBed(this.getName());
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

			System.out.println("BED J:" +j);
			
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
		
		GuiVillager startGUI = null;

		for (VillagerComponent comp : this.components) {
			comp.getGui().setVillageComponent(comp);
			if (comp.getClass() == VillagerCompAbout.class)
				startGUI = comp.getGui();
		}

		if (startGUI != null)
			Minecraft.getMinecraft().displayGuiScreen(startGUI);
	}

	public boolean interact(EntityPlayer p_70085_1_) {

		if (this.getDistanceSqToEntity(p_70085_1_) <= ConfigVillager.MaxInteractDistanceSq) {
			if (this.isSleeping()) {
				if (this.worldObj.isRemote)
					PlayerMsg.send(p_70085_1_, "This villager is sleeping now...");
			} else {
				if (this.worldObj.isRemote) {
					this.openVillagerGui();
				} else {
					this.getNavigator().clearPathEntity();
				}
			}
		} else {
			if (this.worldObj.isRemote)
				PlayerMsg.send(p_70085_1_, "too far from the villager..");
		}

		return true;
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
		
		this.updateArmSwingProgress();
		if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 80 * 12 == 0) {
			this.heal(1.0F);
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
		p_70014_1_.setInteger(ConfigData.KeyVillagerExp, this.getExp());
		p_70014_1_.setInteger(ConfigData.KeyVillagerInitX, this.initPosX);
		p_70014_1_.setInteger(ConfigData.KeyVillagerInitY, this.initPosY);
		p_70014_1_.setInteger(ConfigData.KeyVillagerInitZ, this.initPosZ);
		p_70014_1_.setInteger(ConfigData.KeyVillagerSleeping, this.getSleepingValue());
		
		for(VillagerComponent component : components)
			component.writeToNBT(p_70014_1_);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		super.readEntityFromNBT(p_70037_1_);
		this.setProfessionID(p_70037_1_.getInteger(ConfigData.KeyVillagerProfessionID));
		this.setBuildingID(p_70037_1_.getInteger(ConfigData.KeyVillagerBuildingID));
		this.setExp(p_70037_1_.getInteger(ConfigData.KeyVillagerExp));
		this.initPosX = p_70037_1_.getInteger(ConfigData.KeyVillagerInitX);
		this.initPosY = p_70037_1_.getInteger(ConfigData.KeyVillagerInitY);
		this.initPosZ = p_70037_1_.getInteger(ConfigData.KeyVillagerInitZ);
		this.setSleepingValue(p_70037_1_.getInteger(ConfigData.KeyVillagerSleeping));
		
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
			VBEntityMgr.get().removeVillager(this);
			HelperDataVB.addDeadVillager(DataVillageBento.get(), this);
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
		return true;
	}

}
