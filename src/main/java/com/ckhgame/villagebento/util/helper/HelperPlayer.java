package com.ckhgame.villagebento.util.helper;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.SActionDoSpawnParticles;
import com.ckhgame.villagebento.util.data.VBParticles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;

public class HelperPlayer {
	
	public static EntityPlayer getPlayer(String name){
		return MinecraftServer.getServer().worldServerForDimension(0).getPlayerEntityByName(name);
	}
	
	public static boolean playerHasItemStack(EntityPlayer entityPlayer, ItemStack itemStack) {

		int i;
		InventoryPlayer ip = entityPlayer.inventory;

		for (i = 0; i < ip.mainInventory.length; ++i) {
			if (ip.mainInventory[i] != null && ip.mainInventory[i].isItemEqual(itemStack)
					&& ip.mainInventory[i].stackSize >= itemStack.stackSize) {
				return true;
			}
		}

		return false;
	}

	public static boolean playerRemoveItemStack(EntityPlayer entityPlayer, ItemStack itemStack) {

		int i;
		InventoryPlayer ip = entityPlayer.inventory;

		for (i = 0; i < ip.mainInventory.length; ++i) {
			if (ip.mainInventory[i] != null && ip.mainInventory[i].isItemEqual(itemStack)
					&& ip.mainInventory[i].stackSize >= itemStack.stackSize) {
				ip.mainInventory[i].stackSize -= itemStack.stackSize;
				if (ip.mainInventory[i].stackSize == 0)
					ip.mainInventory[i] = null;

				return true;
			}
		}

		return false;
	}

	public static boolean dropCurrency(EntityPlayer entityPlayer, int currency) {
		if (addCurrency(entityPlayer, -currency)) {

			ForgeHooks.onPlayerTossEvent(entityPlayer, new ItemStack(ModItems.itemVillageCurrency, 1, currency), true);

			return true;
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
			int newCurrency = itemStackCurrency.getItemDamage() + currency;
			if (newCurrency > 0) {
				itemStackCurrency.setItemDamage(newCurrency);
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
				ip.addItemStackToInventory(new ItemStack(ModItems.itemVillageCurrency, 1, currency));
				return true;
			}

		}
	}
}
