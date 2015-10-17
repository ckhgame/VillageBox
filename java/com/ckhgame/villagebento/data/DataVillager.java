package com.ckhgame.villagebento.data;

import com.ckhgame.villagebento.config.ConfigData;

import net.minecraft.nbt.NBTTagCompound;

public class DataVillager extends Data{

	public int id;
	public String name;
	public int profession;
	public int buildingID;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger(ConfigData.KeyDataVillagerID, this.id);
		compound.setString(ConfigData.KeyDataVillagerName, this.name);
		compound.setInteger(ConfigData.KeyDataVillagerProfession, this.profession);
		compound.setInteger(ConfigData.KeyDataVillagerBuildingID, this.buildingID);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.id = compound.getInteger(ConfigData.KeyDataVillagerID);
		this.name = compound.getString(ConfigData.KeyDataVillagerName);
		this.profession = compound.getInteger(ConfigData.KeyDataVillagerProfession);
		this.buildingID = compound.getInteger(ConfigData.KeyDataVillagerBuildingID);	
	}
	
}
