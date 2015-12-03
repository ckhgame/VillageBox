package com.ckhgame.villagebento.tileentity;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.config.ConfigFarming;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVBCrops extends TileEntity {

	private static final int UpdateCropsTime = 100;
	private int updateCropsTimer = 0;
	private long lastWorldTime = -1;

	private int growingTimer = 0;

	@Override
	public void updateEntity() {

		if (lastWorldTime < 0)
			lastWorldTime = this.worldObj.getWorldTime();

		if (++updateCropsTimer >= UpdateCropsTime) {
			updateCropsTimer = updateCropsTimer % UpdateCropsTime;
			updateCrops();
		}
	}

	protected int getCropsStage() {
		int s = this.growingTimer / ConfigFarming.GrowingTimePerStage;
		if (s > ConfigFarming.CropsStageMax) {
			s = ConfigFarming.CropsStageMax;
		} else if (s < 0) {
			s = 0;
		}
		return s;
	}

	protected void updateCrops(){
		if(!this.worldObj.isRemote){
        	long currentTime = this.worldObj.getWorldTime();
        	long deltaTime = Math.max(0, currentTime - this.lastWorldTime);
        	this.lastWorldTime = currentTime;
        	
        	//this.markDirty();
        	
        	if(this.growingTimer < ConfigFarming.GrowingTimeTotal){
            	this.growingTimer += deltaTime;
            	
            	int s = this.getCropsStage();
            	int d = this.getBlockMetadata();
            	if(s != d){
            		if(this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, s, 2)){
            			this.blockMetadata = s;
            		}
            	}
        	}        	
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_) {
		super.readFromNBT(p_145839_1_);
		growingTimer = p_145839_1_.getInteger(ConfigData.KeyCropsGrowingTimer);
		updateCropsTimer = p_145839_1_.getInteger(ConfigData.KeyCropsUpdateTimer);

	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_) {
		super.writeToNBT(p_145841_1_);
		p_145841_1_.setInteger(ConfigData.KeyCropsGrowingTimer, growingTimer);
		p_145841_1_.setInteger(ConfigData.KeyCropsUpdateTimer, updateCropsTimer);
	}

}
