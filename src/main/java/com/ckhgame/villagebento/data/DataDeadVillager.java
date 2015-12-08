package com.ckhgame.villagebento.data;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.util.IData;

import net.minecraft.nbt.NBTTagCompound;

public class DataDeadVillager implements IData{
	public String name;
	public int professionID;
	public int buildingID;
	public int initX;
	public int initY;
	public int initZ;
	public int level;
	public int timer;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setString(ConfigData.KeyDataDeadVillagerName, this.name);
		compound.setInteger(ConfigData.KeyDataDeadVillagerProfessionID, this.professionID);
		compound.setInteger(ConfigData.KeyDataDeadVillagerBuildingID, this.buildingID);
		compound.setInteger(ConfigData.KeyDataDeadVillagerInitX, this.initX);
		compound.setInteger(ConfigData.KeyDataDeadVillagerInitY, this.initY);
		compound.setInteger(ConfigData.KeyDataDeadVillagerInitZ, this.initZ);
		compound.setInteger(ConfigData.KeyDataDeadVillagerLevel, this.level);
		compound.setInteger(ConfigData.KeyDataDeadVillagerTimer, this.timer);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.name = compound.getString(ConfigData.KeyDataDeadVillagerName);
		this.professionID = compound.getInteger(ConfigData.KeyDataDeadVillagerProfessionID);
		this.buildingID = compound.getInteger(ConfigData.KeyDataDeadVillagerBuildingID);
		this.initX = compound.getInteger(ConfigData.KeyDataDeadVillagerInitX);
		this.initY = compound.getInteger(ConfigData.KeyDataDeadVillagerInitY);
		this.initZ = compound.getInteger(ConfigData.KeyDataDeadVillagerInitZ);
		this.level = compound.getInteger(ConfigData.KeyDataDeadVillagerLevel);
		this.timer = compound.getInteger(ConfigData.KeyDataDeadVillagerTimer);
	}
}
