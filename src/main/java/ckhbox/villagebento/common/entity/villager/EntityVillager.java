package ckhbox.villagebento.common.entity.villager;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.entity.ai.VillagerAIFollowing;
import ckhbox.villagebento.common.entity.ai.VillagerAIWander;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.util.helper.BitHelper;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.util.math.IntBoundary;
import ckhbox.villagebento.common.util.math.IntVec3;
import ckhbox.villagebento.common.util.tool.HouseDetector;
import ckhbox.villagebento.common.util.tool.NameGenerator;
import ckhbox.villagebento.common.village.attribute.AttributeList;
import ckhbox.villagebento.common.village.attribute.VillagerAttribute;
import ckhbox.villagebento.common.village.home.DataHomeList;
import ckhbox.villagebento.common.village.profession.Profession;
import ckhbox.villagebento.common.village.trading.ITrading;
import ckhbox.villagebento.common.village.trading.TradingRecipeList;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityVillager extends EntityCreature implements ITrading{

	private Profession profession;
	private AttributeList attributeList;
	//the player this villager is currently interacting with
	private EntityPlayer interacting;
	private EntityPlayer following;
	
	private IntBoundary home;
	
	//the canter of wandering when no home has been set to this villager
	private Vec3 wanderCenter;
	
	public EntityVillager(World worldIn) {
		super(worldIn);		
		
		this.setSize(0.6F, 1.8F);
		
		this.attributeList = new AttributeList();
		this.attributeList.add(new VillagerAttribute(PathHelper.full("villager.attribute.energy"),0,this,17,0));
		this.attributeList.add(new VillagerAttribute(PathHelper.full("villager.attribute.happiness"),1,this,18,1));
		this.attributeList.add(new VillagerAttribute(PathHelper.full("villager.attribute.proficiency"),2,this,19,2));
		
		//set max happiness to 100 
		this.attributeList.get(1).setMaxValue(100);
		
		//set attribute growing
		this.attributeList.get(0).setValueGrowing(10);
		this.attributeList.get(1).setValueGrowing(3);
		this.attributeList.get(2).setValueGrowing(1);
		
		this.refreshProfession();
		
		//temp
		if(!this.hasCustomName()){
			this.setCustomNameTag(NameGenerator.getRandomMaleName());
		}
		
		this.initAI();
	}
	
	
	
	@Override
	public EntityJumpHelper getJumpHelper() {
		// TODO Auto-generated method stub
		return super.getJumpHelper();
	}



	@Override
	protected float getJumpUpwardsMotion() {
		// TODO Auto-generated method stub
		return super.getJumpUpwardsMotion();
	}

	protected void initAI(){
		((PathNavigateGround)this.getNavigator()).setBreakDoors(true);
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        //this.tasks.addTask(1, new EntityAITradePlayer(this));
        //this.tasks.addTask(1, new EntityAILookAtTradePlayer(this));
        //this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        //this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new VillagerAIFollowing(this,0.6F));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.3D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        //this.tasks.addTask(9, new EntityAIVillagerInteract(this));
        this.tasks.addTask(9, new VillagerAIWander(this, 0.4D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
    }
	
	@Override
	protected void entityInit() {
		super.entityInit();
		//profession id
		this.getDataWatcher().addObject(16, 0);
		//attributes
		this.getDataWatcher().addObject(17, 0);
		this.getDataWatcher().addObject(18, 0);
		this.getDataWatcher().addObject(19, 0);
		//data flags(interacting.following,etc.)
		this.getDataWatcher().addObject(20, 0);
	}

	@Override
	protected boolean interact(EntityPlayer player) {
		
		if(!player.worldObj.isRemote){
			if(	(this.isInteracting() && this.interacting != player) ||
				(this.isFollowing() && this.following != player)){
				player.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.villager.isbusy")));
			}
			else{
				player.openGui(VillageBentoMod.instance, GuiIDs.VillagerMain, player.worldObj, player.dimension, this.getEntityId(), 0);
			}
		}
		
		return super.interact(player);
	}

	@Override
	public TradingRecipeList getTradingRecipeList() {
		return this.profession.getTradingRecipeList();
	}
	
	public Vec3 getWanderCenter(){
		if(this.wanderCenter == null){
			this.wanderCenter = new Vec3(this.posX, this.posY, this.posZ);
		}
		return this.wanderCenter;
	}
	
	//data flags
	
	/**
	 * POS: 0=Interacting, 1=Following
	 */
	protected void setDataFlag(int pos, boolean flag){
		int data = this.getDataWatcher().getWatchableObjectInt(20);
		data = BitHelper.writeBit(data, pos, flag);
		this.getDataWatcher().updateObject(20, data);
	}
	
	/**
	 * POS: 0=Interacting, 1=Following
	 */
	protected boolean getDataFlag(int pos){
		int data = this.getDataWatcher().getWatchableObjectInt(20);
		return BitHelper.readBit(data, pos);
	}
	
	//interacting and following	
	public void setInteracting(EntityPlayer player){
		if(!this.worldObj.isRemote){
			this.interacting = player;
			this.setDataFlag(0, (this.interacting != null));
		}
	}
	
	public boolean isInteracting(){
		return this.getDataFlag(0);
	}
	
	public void setFollowing(EntityPlayer player){
		if(!this.worldObj.isRemote){
			this.following = player;
			this.setDataFlag(1, (this.following != null));
			this.wanderCenter = null;
		}
	}
	
	public boolean isFollowing(){
		return this.getDataFlag(1);
	}	
	
	public EntityPlayer getFollowing(){
		return this.following;
	}
	
	//set home
	public void setCurrentPosAsHome(EntityPlayer player){
		//server side only
		if(this.worldObj.isRemote)
			return;
		
		//scan home boundary
		IntBoundary bound = HouseDetector.getClosedField(this.worldObj, new IntVec3(this.posX,this.posY,this.posZ));
		if(bound == null){
			player.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.villager.home.openspace")));
		}
		else{
			bound = bound.extend(-1);//remove outlines
			//add home bounday
			if(!DataHomeList.get(this.worldObj).add(bound)){
				player.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.villager.home.existed")));
			}
			else{
				//remove old home
				if(this.home != null){
					DataHomeList.get(this.worldObj).remove(home);
				}
				this.home = bound;
				//stop following
				this.setFollowing(null);
			}
		}
	}
	
	public IntBoundary getHome(){
		return this.home;
	}
	
	//profession
	public Profession getProfession(){
		if(this.worldObj.isRemote && (this.profession == null || this.getDataWatcher().getWatchableObjectInt(16) != this.profession.getRegID())){
			this.profession = Profession.registry.get(this.getDataWatcher().getWatchableObjectInt(16));
			this.refreshProfession();
		}
		return this.profession;
	}
	
	public void setProfession(int proid){
		this.getDataWatcher().updateObject(16, proid);
		this.refreshProfession();
	}
	
	public AttributeList getAttributes(){
		return this.attributeList;
	}
	
	public String getName(){
		return this.getCustomNameTag();
	}
	
	public boolean isProficiencyFull(){
		VillagerAttribute attribute = (VillagerAttribute)this.attributeList.get(2);
		return (attribute.getValue() >= attribute.getMaxValue());
	}
	
	public void clearProficiency(){
		this.attributeList.get(2).setValue(0);
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}



	@Override
	public void onUpdate() {
		super.onUpdate();
		//update profession
		if(this.worldObj.isRemote && (this.profession == null || this.getDataWatcher().getWatchableObjectInt(16) != this.profession.getRegID())){
			this.setProfession(this.getDataWatcher().getWatchableObjectInt(16));
		}
		//update attributes
		this.attributeList.update();
	}

	public void refreshProfession(){
		int proid = this.getDataWatcher().getWatchableObjectInt(16);
		this.profession = Profession.registry.get(proid);
		this.attributeList.get(0).setMaxValue(this.profession.getMaxEnegy());
		this.attributeList.get(2).setMaxValue(this.profession.getMaxProficiency());
	}
	
	@Override
	public boolean allowLeashing() {
		return false;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("proid", this.getDataWatcher().getWatchableObjectInt(16));
		tagCompound.setInteger("attr_eng", (Integer)this.attributeList.get(0).getValue());
		tagCompound.setInteger("attr_hap", (Integer)this.attributeList.get(1).getValue());
		tagCompound.setInteger("attr_pro", (Integer)this.attributeList.get(2).getValue());
		//home
		if(this.home != null){
			tagCompound.setIntArray("homebd", new int[]{
					this.home.minx,
					this.home.miny,
					this.home.minz,
					this.home.maxx,
					this.home.maxy,
					this.home.maxz
					});
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		int proid = tagCompund.getInteger("proid");
		this.setProfession(proid);
		this.attributeList.get(0).setValue(tagCompund.getInteger("attr_eng"));
		this.attributeList.get(1).setValue(tagCompund.getInteger("attr_hap"));
		this.attributeList.get(2).setValue(tagCompund.getInteger("attr_pro"));
		//home
		int[] arr = tagCompund.getIntArray("homebd");
		if(arr == null || arr.length == 0){
			this.home = null;
		}
		else{
			this.home = new IntBoundary(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
		}
	}
	
	

	
	//----------------------------------
	//upgrading preview
	@SideOnly(Side.CLIENT)
	public Profession previewProfession;

	
}
