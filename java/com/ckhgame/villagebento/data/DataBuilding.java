package com.ckhgame.villagebento.data;

import com.ckhgame.villagebento.config.ConfigData;

import net.minecraft.nbt.NBTTagCompound;

public class DataBuilding extends Data{
	public int id;
	public int x;
	public int z;
	public int sizeX; // if the total width is 7, sizeX would be 3 (3 + 1 + 3)
	public int sizeZ; // similar as sizeX
	public int y;
	public int type;
	public int villagerID;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger(ConfigData.KeyDataBuildingID, this.id);
		compound.setInteger(ConfigData.KeyDataBuildingX, this.x);
		compound.setInteger(ConfigData.KeyDataBuildingY, this.y);
		compound.setInteger(ConfigData.KeyDataBuildingZ, this.z);
		compound.setInteger(ConfigData.KeyDataBuildingSizeX, this.sizeX);
		compound.setInteger(ConfigData.KeyDataBuildingSizeZ, this.sizeZ);
		compound.setInteger(ConfigData.KeyDataBuildingType, this.type);
		compound.setInteger(ConfigData.KeyDataBuildingVillagerID, this.villagerID);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.id = compound.getInteger(ConfigData.KeyDataBuildingID); 
		this.x = compound.getInteger(ConfigData.KeyDataBuildingX);
		this.y = compound.getInteger(ConfigData.KeyDataBuildingY);
		this.z = compound.getInteger(ConfigData.KeyDataBuildingZ);
		this.sizeX = compound.getInteger(ConfigData.KeyDataBuildingSizeX);
		this.sizeZ = compound.getInteger(ConfigData.KeyDataBuildingSizeZ);
		this.type = compound.getInteger(ConfigData.KeyDataBuildingType);
		this.villagerID = compound.getInteger(ConfigData.KeyDataBuildingVillagerID);
	}
}