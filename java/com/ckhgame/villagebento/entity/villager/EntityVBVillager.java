package com.ckhgame.villagebento.entity.villager;

import com.ckhgame.villagebento.ai.HelperVillagerAI;
import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.gui.GuiVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionInitVillager;
import com.ckhgame.villagebento.network.action.SActionUpdateVillagerSleep;
import com.ckhgame.villagebento.util.BlockFinder;
import com.ckhgame.villagebento.util.PlayerMsg;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityVBVillager extends EntityAgeable {

	// resource
	private ResourceLocation skinTexture = null;

	public ResourceLocation getSkinTexture() {
		return skinTexture;
	}

	// ----------------------------------------
	// vb data
	public int dataVillagerID;
	public String name;
	public int profession;
	public int level;
	public int exp;

	public int buildingX, buildingY, buildingZ;
	public int buildingSizeX, buildingSizeZ;
	public int villagerIdxOfBuilding;

	public Vec3 bedPosition = null;

	private boolean firstTimeUpdateVBVillager = true;

	private boolean vbInited = false;

	public boolean isVBInitialized() {
		return vbInited;
	}

	private void findBed() {
		Vec3[] arr = BlockFinder.findBlock(this.worldObj, this.buildingX, this.buildingY, this.buildingZ,
				this.buildingSizeX, this.buildingSizeZ, Blocks.bed, new int[] { 0, 1, 2, 3 }, false);
		if (arr != null && this.villagerIdxOfBuilding < arr.length)
			bedPosition = arr[this.villagerIdxOfBuilding];
	}

	public void initVillager(int villagerID, String name, int profession) {
		this.dataVillagerID = villagerID;
		this.name = name;
		this.profession = profession;

		Villager vr = Villager.registry.get(this.profession);

		this.setCustomNameTag(name + "<" + vr.getProfessionName() + ">");
		
		if (this.worldObj.isRemote) {
			// client
			this.setAlwaysRenderNameTag(true);
			this.skinTexture = vr.getSkin();
		} else {
			// server
			DataVillageBento dataVB = DataVillageBento.get();
			DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, this.dataVillagerID);
			DataBuilding db = HelperDataVB.findBuildingByID(dataVB, dvr.buildingID);
			this.buildingX = db.x;
			this.buildingY = db.y;
			this.buildingZ = db.z;
			this.buildingSizeX = db.sizeX;
			this.buildingSizeZ = db.sizeZ;
			this.villagerIdxOfBuilding = HelperDataVB.getVillagerIdxInBuilding(dataVB, dvr);
			findBed();

			int d = (int) Math.sqrt(db.sizeX * db.sizeX + db.sizeZ * db.sizeZ);
			this.setHomeArea(this.buildingX, this.buildingY, this.buildingZ, d * 2);
		}

		initAIs();

		vbInited = true;
	}

	private void updateVBVillager() {
		if (firstTimeUpdateVBVillager) {
			Action.send(ActionInitVillager.class, new Object[] { this.getEntityId() });
			firstTimeUpdateVBVillager = false;
		}
	}

	// ----------------------------------------
	// sleeping
	private boolean isSleeping = false;

	public boolean getSleeping() {
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
				if(this.bedPosition != null){
					this.getNavigator().clearPathEntity();
					this.setPosition(this.bedPosition.xCoord + 0.5D, this.bedPosition.yCoord + 1.0D, this.bedPosition.zCoord + 0.5D);
				}
					
				//System.out.println("Start Sleeping!");
			}
			else{
				if(this.isNearBed()){
					//find a passable block near the bed
					int[] dxz = new int[]{1,1, 1,0, 1,-1, 
										  0,1,	0,-1,
										  -1,1, -1,0, -1,-1};
					for(int i =0;i<16;i+=2){
						Block b = this.worldObj.getBlock(	(int)this.bedPosition.xCoord + dxz[i], 
															(int)this.bedPosition.yCoord,
															(int)this.bedPosition.zCoord + dxz[i +1]);
						if(b == Blocks.air || b == Blocks.carpet){
							this.setPosition((int)this.bedPosition.xCoord + dxz[i]  + 0.5D, 
											 this.bedPosition.yCoord + 1.0D, 
											 (int)this.bedPosition.zCoord + dxz[i +1] + 0.5D);
							break;
						}
					}
				}
			}
		}
		
		
	}

	public boolean isNearBed() {
		if (this.bedPosition == null) {
			return false;
		} else {
			double dy = Math.abs(this.posY - this.bedPosition.yCoord);
			double dx = this.bedPosition.xCoord + 0.5 - this.posX;
			double dz = this.bedPosition.zCoord + 0.5 - this.posZ;
			double dxz = Math.sqrt(dx * dx + dz * dz);
			//System.out.println("dy:" + dy + ",dxz:" + dxz);
			return (dy <= 1.0D && dxz <= 1.6D);
		}
	}

	public float getBedOrientationInDegrees() {
		if (this.bedPosition != null) {
			int x = (int) bedPosition.xCoord;
			int y = (int) bedPosition.yCoord;
			int z = (int) bedPosition.zCoord;
			int j = worldObj.getBlock(x, y, z).getBedDirection(worldObj, x, y, z);

			switch (j) {
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

	// ----------------------------------------
	// ai
	private void initAIs() {
		HelperVillagerAI.SetVBVillagerAI(this);
	}

	// ----------------------------------------
	public String getDisplayName() {
		return name;
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		super.onUpdate();
		updateVBVillager();
		
	//	System.out.println(this.worldObj.isRemote + "," + this.posY);
	}

	public EntityVBVillager(World world) {
		super(world);

		this.setSize(0.6F, 1.8F);
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setEnterDoors(true);
	}

	@Override
	public EntityVBVillager createChild(EntityAgeable p_90011_1_) {
		EntityVBVillager entityvillager = new EntityVBVillager(this.worldObj);
		entityvillager.onSpawnWithEgg((IEntityLivingData) null);
		return entityvillager;
	}

	private EntityPlayer interactTarget;

	public void setInteractTarget(EntityPlayer entityPlayer) {
		this.interactTarget = entityPlayer;
	}

	public EntityPlayer getInteractTarget() {
		return this.interactTarget;
	}

	public void openVillagerGui() {
		Villager vr = Villager.registry.get(profession);

		GuiVillager startGUI = null;

		for (VillagerComponent comp : vr.getVillagerComponents()) {
			comp.getGui().setEntityVillager(this);
			if (comp.getClass() == VillagerCompAbout.class)
				startGUI = comp.getGui();
		}

		if (startGUI != null)
			Minecraft.getMinecraft().displayGuiScreen(startGUI);
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		
		if(this.getDistanceSqToEntity(p_70085_1_) <= ConfigVillager.MaxInteractDistanceSq){
			if(this.isSleeping){
				if(this.worldObj.isRemote)
					PlayerMsg.send(p_70085_1_, "This villager is sleeping now...");
			}
			else{
				if(this.worldObj.isRemote){
					this.openVillagerGui();
				}
				else{
					this.setInteractTarget(p_70085_1_);
					this.getNavigator().clearPathEntity();
				}
			}
		}
		else{
			if(this.worldObj.isRemote)
				PlayerMsg.send(p_70085_1_, "too far from the villager..");
		}
		
		return true;
	}

	
	
	
	@Override
	protected void applyEntityAttributes() {
		// TODO Auto-generated method stub
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(12.0D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}

	@Override
	public void onLivingUpdate() {
		// TODO Auto-generated method stub
		super.onLivingUpdate();
		this.updateArmSwingProgress();
		if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 40 * 12 == 0)
        {
            this.heal(1.0F);
        }
	}

	protected void attackEntity(Entity entity, float distance){
        if (this.attackTime <= 0 && distance < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;            
            this.attackEntityAsMob(entity);
        }
    }

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		
		//deal damage
		float dmg = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        entity.attackEntityFrom(DamageSource.causeMobDamage(this), dmg);
        
        //knock back
        float k = 0.5F;
        entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * k * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)k * 0.5F));
        this.motionX *= 0.6D;
        this.motionZ *= 0.6D;
		
		return super.attackEntityAsMob(entity);
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
		if(p_70097_1_.getEntity() instanceof EntityLivingBase)
			this.setAttackTarget((EntityLivingBase)p_70097_1_.getEntity());
		return super.attackEntityFrom(p_70097_1_, p_70097_2_);
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
	public String getCommandSenderName() {
		// TODO Auto-generated method stub
		return super.getCommandSenderName();
	}

	@Override
	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);

		// when the villager is dead, we should tell the DataVillager he is
		// dead, and he will be revive on next noon
		if(!this.worldObj.isRemote){
			DataVillageBento dataVB = DataVillageBento.get();
			HelperDataVB.setVillageDeath(dataVB, this.dataVillagerID);
			
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(this.func_110142_aN().func_151521_b());
		}
	}
	
	public boolean allowLeashing()
    {
        return false;
    }

}
