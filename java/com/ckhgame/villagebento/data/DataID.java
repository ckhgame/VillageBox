package com.ckhgame.villagebento.data;

import com.ckhgame.villagebento.config.ConfigData;

import net.minecraft.nbt.NBTTagCompound;

public class DataID extends Data {

	public int idLastVillage;
	public int idLastVillager;
	public int idLastBuilding;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		compound.setInteger(ConfigData.KeyDataIDLastVillage, this.idLastVillage);
		compound.setInteger(ConfigData.KeyDataIDLastVillager, this.idLastVillager);
		compound.setInteger(ConfigData.KeyDataIDLastBuilding, this.idLastBuilding);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		this.idLastVillage = compound.getInteger(ConfigData.KeyDataIDLastVillage);
		this.idLastVillager = compound.getInteger(ConfigData.KeyDataIDLastVillager);
		this.idLastBuilding = compound.getInteger(ConfigData.KeyDataIDLastBuilding);
	}
	
}
