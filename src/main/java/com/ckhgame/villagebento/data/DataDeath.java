package com.ckhgame.villagebento.data;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.util.IData;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class DataDeath implements IData {

	public ArrayList<DataDeadVillager> deadVillagers = new ArrayList<DataDeadVillager>();

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList tagList = new NBTTagList();
		NBTTagCompound tag;
		for (DataDeadVillager deadVillager : deadVillagers) {
			tag = new NBTTagCompound();
			deadVillager.writeToNBT(tag);
			tagList.appendTag(tag);
		}
		compound.setTag(ConfigData.KeyDataDeadVillagerList, tagList);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagCompound tag;
		DataDeadVillager deadVillager;
		NBTTagList tagList = compound.getTagList(ConfigData.KeyDataDeadVillagerList, Constants.NBT.TAG_COMPOUND);
		deadVillagers.clear();
		for (int i = 0; i < tagList.tagCount(); i++) {
			tag = tagList.getCompoundTagAt(i);
			deadVillager = new DataDeadVillager();
			deadVillager.readFromNBT(tag);
			deadVillagers.add(deadVillager);
		}
	}

}
