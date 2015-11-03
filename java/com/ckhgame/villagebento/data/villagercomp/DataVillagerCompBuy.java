package com.ckhgame.villagebento.data.villagercomp;

import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.Data;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class DataVillagerCompBuy extends DataVillagerComp{

	public ItemStack[] buyList;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
				
		NBTTagList tagList = new NBTTagList();
		NBTTagCompound tag;
		int idx = 0;
		if(buyList != null){
			for(ItemStack itemStack : buyList){
				tag = new NBTTagCompound();
				itemStack.writeToNBT(tag);
				tagList.appendTag(tag);
			}
		}
		
		compound.setTag(ConfigData.KeyVillagerCompBuyItemStackList, tagList);	
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		NBTTagCompound tag;
		NBTTagList tagList = compound.getTagList(ConfigData.KeyVillagerCompBuyItemStackList, Constants.NBT.TAG_COMPOUND);
		
		buyList = new ItemStack[tagList.tagCount()];
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			tag = tagList.getCompoundTagAt(i);
			buyList[i] = ItemStack.loadItemStackFromNBT(tag);
		}
	}
	
}
