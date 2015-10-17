package com.ckhgame.villagebento.data;

import net.minecraft.nbt.NBTTagCompound;

public abstract class Data {
	
	public abstract void writeToNBT(NBTTagCompound compound);	
	public abstract void readFromNBT(NBTTagCompound compound);
	
}
