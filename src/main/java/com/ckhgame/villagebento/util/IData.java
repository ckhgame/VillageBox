package com.ckhgame.villagebento.util;

import net.minecraft.nbt.NBTTagCompound;

public interface IData {
	
    void writeToNBT(NBTTagCompound compound);	
	void readFromNBT(NBTTagCompound compound);
	
}
