package com.ckhgame.villagebento.data.villagercomp;

import com.ckhgame.villagebento.config.ConfigData;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class DataVillagerCompSell extends DataVillagerComp{

	public ItemStack[] sellList;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
				
		NBTTagList tagList = new NBTTagList();
		NBTTagCompound tag;
		int idx = 0;
		if(sellList != null){
			for(ItemStack itemStack : sellList){
				tag = new NBTTagCompound();
				itemStack.writeToNBT(tag);
				tagList.appendTag(tag);
			}
		}
		
		compound.setTag(ConfigData.KeyVillagerCompSellItemStackList, tagList);	
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		NBTTagCompound tag;
		NBTTagList tagList = compound.getTagList(ConfigData.KeyVillagerCompSellItemStackList, Constants.NBT.TAG_COMPOUND);
		
		sellList = new ItemStack[tagList.tagCount()];
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			tag = tagList.getCompoundTagAt(i);
			sellList[i] = ItemStack.loadItemStackFromNBT(tag);
		}
	}
	
}
