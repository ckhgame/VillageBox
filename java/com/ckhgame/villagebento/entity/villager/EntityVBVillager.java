package com.ckhgame.villagebento.entity.villager;

import com.ckhgame.villagebento.ai.villager.VillagerAISleep;
import com.ckhgame.villagebento.ai.villager.VillagerAIWander;
import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.gui.GuiVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionInitVillager;
import com.ckhgame.villagebento.network.action.SActionUpdateVillagerSleep;
import com.ckhgame.villagebento.util.BlockFinder;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityVBVillager extends EntityAgeable{

	//resource
	private ResourceLocation skinTexture = null;
	public ResourceLocation getSkinTexture(){
		return skinTexture;
	}
	
	
	//----------------------------------------
	//vb data
	public int dataVillagerID;
	public String name;
	public int profession;
	public int level;
	public int exp;
		
	
	public int buildingX,buildingY,buildingZ;
	public int buildingSizeX,buildingSizeZ;
	public int villagerIdxOfBuilding;
	
	public Vec3 bedPosition = null;
	
	private boolean firstTimeUpdateVBVillager = true;
	
	private boolean vbInited = false;
	public boolean isVBInitialized(){
		return vbInited;
	}
	
	private void findBed(){
		Vec3[] arr = BlockFinder.findBlock(	this.worldObj, 
				this.buildingX, this.buildingY, this.buildingZ,
				this.buildingSizeX, this.buildingSizeZ, 
				Blocks.bed, new int[]{0,1,2,3}, false);
		if(arr != null && this.villagerIdxOfBuilding < arr.length)
			bedPosition = arr[this.villagerIdxOfBuilding];
	}
	
	public void initVillager(int villagerID,String name, int profession){
		this.dataVillagerID = villagerID;
		this.name = name;
		this.profession = profession;
		
		Villager vr = Villager.registry.get(this.profession);
		
		if(this.worldObj.isRemote){
			//client
			this.setCustomNameTag(name + "<" + vr.getProfessionName() + ">");
			this.skinTexture = vr.getSkin();
		}
		else{
			//server
			DataVillageBento dataVB = DataVillageBento.get();
			DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, this.dataVillagerID);
			DataBuilding db =  HelperDataVB.findBuildingByID(dataVB, dvr.buildingID);
			this.buildingX = db.x;
			this.buildingY = db.y;
			this.buildingZ = db.z;
			this.buildingSizeX = db.sizeX;
			this.buildingSizeZ = db.sizeZ;
			this.villagerIdxOfBuilding = HelperDataVB.getVillagerIdxInBuilding(dataVB, dvr);
			findBed();
					
			int d = (int)Math.sqrt(db.sizeX * db.sizeX + db.sizeZ * db.sizeZ);			
			this.setHomeArea(this.buildingX, this.buildingY, this.buildingZ, d * 2);
		}
		
		initAIs();
		
		vbInited = true;
	}
	
	private void updateVBVillager(){
		if(firstTimeUpdateVBVillager){
			Action.send(ActionInitVillager.class, new Object[]{this.getEntityId()});
			firstTimeUpdateVBVillager = false;
		}
	}
	
	//----------------------------------------
	//sleeping
	private boolean isSleeping = false;
	public boolean getSleeping(){
		return isSleeping;
	}
	
	public void setSleeping(boolean sleeping){
		this.isSleeping = sleeping;		
		
		if(this.worldObj.isRemote){
			//client
			if(sleeping == true){
			//	System.out.println("Client: Start Sleeping!");
			}
			else{
				//System.out.println("Client: End Sleeping!");
			}
		}
		else{
			//server
			Action.send(SActionUpdateVillagerSleep.class,new Object[]{this.getEntityId(),this.isSleeping,
																	  (int)bedPosition.xCoord,(int)bedPosition.yCoord,(int)bedPosition.zCoord});
			if(sleeping == true){
				if(this.bedPosition != null)
					this.setPosition(this.bedPosition.xCoord + 0.5D, this.bedPosition.yCoord + 1.0D, this.bedPosition.zCoord + 0.5D);
				//System.out.println("Start Sleeping!");
			}
			else{
				//System.out.println("End Sleeping!");
			}
		}
		
		
	}
	
	public boolean isNearBed(){
		if(this.bedPosition == null){
			return false;
		}
		else{
			double dy = this.posY - this.bedPosition.yCoord;
			double dx = this.bedPosition.xCoord + 0.5 - this.posX;
			double dz = this.bedPosition.zCoord + 0.5 - this.posZ;
			double dxz = Math.sqrt(dx * dx + dz * dz);
			System.out.println("dy:" + dy + ",dxz:" + dxz);
			return (dy >= 0 && dy <= 1.0D && dxz <= 0.8D);
		}
	}
	
	 public float getBedOrientationInDegrees()
	    {
	        if (this.bedPosition != null)
	        {
	            int x = (int)bedPosition.xCoord;
	            int y = (int)bedPosition.yCoord;
	            int z = (int)bedPosition.zCoord;
	            int j = worldObj.getBlock(x, y, z).getBedDirection(worldObj, x, y, z);

	            switch (j)
	            {
	                case 0:
	                    return 90.0F;
	                case 1:
	                    return 0.0F;
	                case 2:
	                    return 270.0F;
	                case 3:
	                    return 180.0F;
	            }
	        }

	        return 0.0F;
	    }
	
	//----------------------------------------
	//ai
	private void initAIs(){
        this.targetTasks.addTask(0, new VillagerAIWander(this,0.35D));
        this.targetTasks.addTask(1, new VillagerAISleep(this));
	}
	
	//----------------------------------------
	public String getDisplayName(){
		return name;
	}
	
	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		super.onUpdate();
		updateVBVillager();
	}

	public EntityVBVillager(World world) {
		super(world);
		
		this.setSize(0.6F, 1.8F);
		this.getNavigator().setBreakDoors(false);
        this.getNavigator().setAvoidsWater(true);
      //  this.tasks.addTask(0, new EntityAISwimming(this));
       // this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
       // this.tasks.addTask(2, new EntityAIMoveIndoors(this));
       // this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
       // this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
       // this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
       // this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
       // this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
        //this.tasks.addTask(5, new VillagerAIWander(this, 2.6,10,7));
        //this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
	}

	@Override
	public EntityVBVillager createChild(EntityAgeable p_90011_1_) {
		EntityVBVillager entityvillager = new EntityVBVillager(this.worldObj);
        entityvillager.onSpawnWithEgg((IEntityLivingData)null);
        return entityvillager;
	}
	
	private EntityPlayer interactTarget;
	
	public void setInteractTarget(EntityPlayer entityPlayer){
		this.interactTarget = entityPlayer;
	}
	
	public EntityPlayer getInteractTarget(){
		return this.interactTarget;
	}
	
	public void openVillagerGui(){
		Villager vr = Villager.registry.get(profession);
		
		GuiVillager startGUI = null;
		
		for(VillagerComponent comp : vr.getVillagerComponents()){
			comp.getGui().setEntityVillager(this);
			if(comp.getClass() == VillagerCompAbout.class)
				startGUI = comp.getGui();
		}
		
		if(startGUI != null)
			Minecraft.getMinecraft().displayGuiScreen(startGUI);
	}
	
	public boolean interact(EntityPlayer p_70085_1_)
    {
    	if(this.worldObj.isRemote){
    		
    		this.setInteractTarget(p_70085_1_);
    		this.openVillagerGui();
    		
    	}
        return true;
    }
    
	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setInteger(ConfigData.KeyVillagerEntityDataVillagerID, dataVillagerID);
		p_70014_1_.setBoolean(ConfigData.KeyVillagerEntityIsSleeping, isSleeping);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub
		super.readEntityFromNBT(p_70037_1_);
		
		dataVillagerID = p_70037_1_.getInteger(ConfigData.KeyVillagerEntityDataVillagerID);
		isSleeping = p_70037_1_.getBoolean(ConfigData.KeyVillagerEntityIsSleeping);
	}

	@Override
	protected boolean canDespawn() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	protected boolean isAIEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);
		
		//when the villager is dead, we should tell the DataVillager he is dead, and he will be revive on next noon
		DataVillageBento dataVB = DataVillageBento.get(this.worldObj);
		HelperDataVB.setVillageDeath(dataVB, this.dataVillagerID);
	}
	


	
    
	
    
	
	
	
}
