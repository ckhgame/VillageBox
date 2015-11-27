package com.ckhgame.villagebento.data;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.util.IData;

import net.minecraft.nbt.NBTTagCompound;

public class DataID implements IData {

	public int idLastVillage;
	public int idLastBuilding;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		compound.setInteger(ConfigData.KeyDataIDLastVillage, this.idLastVillage);
		compound.setInteger(ConfigData.KeyDataIDLastBuilding, this.idLastBuilding);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		this.idLastVillage = compound.getInteger(ConfigData.KeyDataIDLastVillage);
		this.idLastBuilding = compound.getInteger(ConfigData.KeyDataIDLastBuilding);
	}
	
}
