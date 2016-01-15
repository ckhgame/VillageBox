package com.ckhgame.villagebento.util.village;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class HelperVillageCurrency {
	public static void setAmount(ItemStack itemStack, int amount){
		if(amount >= 0 && itemStack.getItem() == ModItems.itemVillageCurrency){
			if(!itemStack.hasTagCompound())
				itemStack.setTagCompound(new NBTTagCompound());

			itemStack.getTagCompound().setInteger(ConfigData.KeyVillageCurrency, amount);
		}
	}
	
	public static int getAmount(ItemStack itemStack){
		if(	itemStack.getItem() == ModItems.itemVillageCurrency &&
			itemStack.hasTagCompound() && 
			itemStack.getTagCompound().hasKey(ConfigData.KeyVillageCurrency)){

				return itemStack.getTagCompound().getInteger(ConfigData.KeyVillageCurrency);
			
		}
		
		return 0;
	}
	
	public static ItemStack create(int amount){
		ItemStack itemStack = new ItemStack(ModItems.itemVillageCurrency);
		setAmount(itemStack,amount);
		return itemStack;
	}
}
