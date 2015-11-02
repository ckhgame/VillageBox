package com.ckhgame.villagebento.data.villagercomp;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.Data;

import net.minecraft.nbt.NBTTagCompound;

public class DataVillagerComp extends Data{
	public int type;

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger(ConfigData.KeyVillagerCompType, this.type);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.type = compound.getInteger(ConfigData.KeyVillagerCompType);
	}
	
}
