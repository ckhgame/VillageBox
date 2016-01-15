package com.ckhgame.villagebento.util.helper;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.SActionDoSpawnParticles;
import com.ckhgame.villagebento.util.data.VBParticles;
import com.ckhgame.villagebento.util.village.HelperVillageCurrency;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;

public class HelperPlayer {
	
	public static EntityPlayer getPlayer(String name){
		return MinecraftServer.getServer().worldServerForDimension(0).getPlayerEntityByName(name);
	}
	
	public static int getItemTotalInInventory(EntityPlayer entityPlayer, ItemStack itemStack){
		int i;
		InventoryPlayer ip = entityPlayer.inventory;

		int num = 0;
		
		for (i = 0; i < ip.mainInventory.length; ++i) {
			if (ip.mainInventory[i] != null && ip.mainInventory[i].isItemEqual(itemStack)) {
				num += ip.mainInventory[i].stackSize;
			}
		}
		
		return num;
	}
	
	public static boolean playerHasItemStack(EntityPlayer entityPlayer, ItemStack itemStack) {

		int i;
		InventoryPlayer ip = entityPlayer.inventory;

		int total = 0;
		
		for (i = 0; i < ip.mainInventory.length; ++i) {
			if (ip.mainInventory[i] != null && ip.mainInventory[i].isItemEqual(itemStack)) {
				total += ip.mainInventory[i].stackSize;
			}
		}

		return (total >= itemStack.stackSize);
	}

	public static boolean playerRemoveItemStack(EntityPlayer entityPlayer, ItemStack itemStack) {
		
		int total = itemStack.stackSize;
		
		InventoryPlayer ip = entityPlayer.inventory;

		for (int i = 0; i < ip.mainInventory.length; ++i) {
			if (ip.mainInventory[i] != null && ip.mainInventory[i].isItemEqual(itemStack)) {
				
				if(total < ip.mainInventory[i].stackSize){
					ip.mainInventory[i].stackSize -= total;
					total = 0;
				}
				else{
					total -= ip.mainInventory[i].stackSize;
					ip.mainInventory[i] = null;
				}
				
				if(total == 0)
					break;
			}
		}
		
		return (total <= 0);
	}

	public static boolean dropCurrency(EntityPlayer entityPlayer, int currency) {
		if (addCurrency(entityPlayer, -currency)) {

			ForgeHooks.onPlayerTossEvent(entityPlayer, HelperVillageCurrency.create(currency), true);

			return true;
		}
		return false;
	}

	public static boolean addCurrency(EntityPlayer entityPlayer, ItemStack itemStackCurrency){
		if(itemStackCurrency.getItem() == ModItems.itemVillageCurrency){
			return addCurrency(entityPlayer, HelperVillageCurrency.getAmount(itemStackCurrency));
		}
		return false;
	}
	
	public static boolean addCurrency(EntityPlayer entityPlayer, int currency) {

		InventoryPlayer ip = entityPlayer.inventory;
		ItemStack itemStackCurrency = null;
		int i;
		for (i = 0; i < ip.mainInventory.length; ++i) {
			if (ip.mainInventory[i] != null && ip.mainInventory[i].getItem() == ModItems.itemVillageCurrency) {
				itemStackCurrency = ip.mainInventory[i];
				break;
			}
		}

		if (itemStackCurrency != null) {
			// the player already have the curreny item
			int newCurrency = HelperVillageCurrency.getAmount(itemStackCurrency) + currency;
			if (newCurrency > 0) {
				HelperVillageCurrency.setAmount(itemStackCurrency, newCurrency);
				return true;
			} else if (newCurrency == 0) {
				ip.mainInventory[i] = null;
				return true;
			} else {
				return false;
			}
		} else {
			// the player dont have the curreny item
			if (currency < 0) {
				return false;
			} else {
				ItemStack itemStackCurreny = HelperVillageCurrency.create(currency);
				if(!ip.addItemStackToInventory(itemStackCurreny)){
					entityPlayer.dropPlayerItemWithRandomChoice(itemStackCurreny, false);
				}
				return true;
			}

		}
	}
}
