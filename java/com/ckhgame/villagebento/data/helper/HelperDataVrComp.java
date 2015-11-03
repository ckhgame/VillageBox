package com.ckhgame.villagebento.data.helper;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompBuy;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompSell;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.misc.ItemPrice;
import com.ckhgame.villagebento.misc.VBResult;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class HelperDataVrComp {
	
	public static DataVillagerComp findDataVillagerComp(DataVillager dvr,Class<? extends DataVillagerComp> c){
		for(DataVillagerComp vrc : dvr.dataComponents){
			if(vrc.getClass() == c)
				return vrc;
		}
		return null;
	}
	
	public static void refreshBuyList(DataVillager dvr){
		
		DataVillagerCompBuy dataCompBuy = (DataVillagerCompBuy)findDataVillagerComp(dvr,DataVillagerCompBuy.class);
		if(dataCompBuy == null)
			return;
		
		Villager vr = Villager.registry.get(dvr.profession);
		if(vr == null)
			return;
		
		VillagerCompBuy compBuy = (VillagerCompBuy)vr.findVillagerComponentByClass(VillagerCompBuy.class);
		if(compBuy == null)
			return;

		dataCompBuy.buyList = compBuy.generateBuyList(dvr.level);
		
	}
	
	public static void refreshSellList(DataVillager dvr){
			
		DataVillagerCompSell dataCompSell = (DataVillagerCompSell)findDataVillagerComp(dvr,DataVillagerCompSell.class);
		if(dataCompSell == null)
			return;
		
		Villager vr = Villager.registry.get(dvr.profession);
		if(vr == null)
			return;
		
		VillagerCompSell compSell = (VillagerCompSell)vr.findVillagerComponentByClass(VillagerCompSell.class);
		if(compSell == null)
			return;

		dataCompSell.sellList = compSell.generateSellList(dvr.level);
		
	}

	public static void refreshWork(DataVillager dvr){	
	}
	
	public static boolean buyItem(ItemStack from,ItemStack item,EntityPlayer p){
		if(from.stackSize >= item.stackSize){
			from.stackSize -= item.stackSize;
			p.inventory.addItemStackToInventory(item);
			return true;
		}
		return false;
	}
	
	public static ItemStack[] getBuyList(DataVillager dvr){
		ItemStack[] itemStacks = null;
		DataVillagerCompBuy dataCompBuy = (DataVillagerCompBuy)HelperDataVrComp.findDataVillagerComp(dvr, DataVillagerCompBuy.class);
		if(dataCompBuy != null){
			itemStacks = dataCompBuy.buyList;
		}
		
		if(itemStacks == null)
			itemStacks = new ItemStack[0];
		
		return itemStacks;
	}
	
	public static ItemStack[] getSellList(DataVillager dvr){
		ItemStack[] itemStacks = null;
		DataVillagerCompSell dataCompSell = (DataVillagerCompSell)HelperDataVrComp.findDataVillagerComp(dvr, DataVillagerCompSell.class);
		if(dataCompSell != null){
			itemStacks = dataCompSell.sellList;
		}
		
		if(itemStacks == null)
			itemStacks = new ItemStack[0];
		
		return itemStacks;
	}
	
	public static int buyItem(DataVillager dvr,EntityPlayer entityPlayer,ItemStack itemBuy){
		DataVillagerCompBuy dataCompBuy = (DataVillagerCompBuy)HelperDataVrComp.findDataVillagerComp(dvr, DataVillagerCompBuy.class);
		if(dataCompBuy == null)
			return VBResult.FAILED;
		
		ItemStack[] itemStacks = dataCompBuy.buyList;
		if(itemStacks == null)
			return VBResult.FAILED;

		if(entityPlayer == null)
			return VBResult.FAILED;
		
		//buy process			
		for(ItemStack itemStack : itemStacks ){
			if(itemStack.isItemEqual(itemBuy)){
				if(itemStack.stackSize >= itemBuy.stackSize){
					if(HelperDataVrComp.addCurrency(entityPlayer,-ItemPrice.getBuyPrice(itemBuy.getItem()))){
						itemStack.stackSize -= itemBuy.stackSize;
						entityPlayer.inventory.addItemStackToInventory(itemBuy);
						HelperDataVrComp.addExp(dvr, ConfigVillager.TradingExp);						
						return VBResult.SUCCESS;
					}
					else
						return VBResult.FAILED_UNAFFORDABLE;
				}
				else
					return VBResult.FALLED_RUNOUT;
			}							
		}
		
		return VBResult.FAILED;
	}
	
	public static int sellItem(DataVillager dvr, EntityPlayer entityPlayer,ItemStack itemSell){
		DataVillagerCompSell dataCompSell = (DataVillagerCompSell)HelperDataVrComp.findDataVillagerComp(dvr, DataVillagerCompSell.class);
		if(dataCompSell == null)
			return VBResult.FAILED;
		
		ItemStack[] itemStacks = dataCompSell.sellList;
		if(itemStacks == null)
			return VBResult.FAILED;

		if(entityPlayer == null)
			return VBResult.FAILED;
		
		//sell process			
		for(ItemStack itemStack : itemStacks ){
			if(itemStack.isItemEqual(itemSell)){
				if(itemStack.stackSize >= itemSell.stackSize){
					if(HelperDataVrComp.playerHasItemStack(entityPlayer, itemSell)){
						itemStack.stackSize -= itemSell.stackSize;
						playerRemoveItemStack(entityPlayer, itemSell);
						HelperDataVrComp.addCurrency(entityPlayer,ItemPrice.getSellPrice(itemSell.getItem()));
						HelperDataVrComp.addExp(dvr, ConfigVillager.TradingExp);
					
						return VBResult.SUCCESS;
					}
					else
						return VBResult.FAILED_NOITEM;
				}
				else
					return VBResult.FALLED_RUNOUT;
			}							
		}
		
		return VBResult.FAILED;
	}
	
	private static boolean playerHasItemStack(EntityPlayer entityPlayer,ItemStack itemStack){
		
		int i;
		InventoryPlayer ip = entityPlayer.inventory;

        for (i = 0; i < ip.mainInventory.length; ++i)
        {
            if (ip.mainInventory[i] != null && ip.mainInventory[i].isItemEqual(itemStack)
            		&&ip.mainInventory[i].stackSize >= itemStack.stackSize)
            {
                return true;
            }
        }

        return false;
	}
	
private static boolean playerRemoveItemStack(EntityPlayer entityPlayer,ItemStack itemStack){
		
		int i;
		InventoryPlayer ip = entityPlayer.inventory;

        for (i = 0; i < ip.mainInventory.length; ++i)
        {
            if (ip.mainInventory[i] != null && ip.mainInventory[i].isItemEqual(itemStack)
            		&&ip.mainInventory[i].stackSize >= itemStack.stackSize)
            {
            	ip.mainInventory[i].stackSize -= itemStack.stackSize;
            	if(ip.mainInventory[i].stackSize == 0)
            		ip.mainInventory[i] = null;
            	
                return true;
            }
        }

        return false;
	}
	
	
	public static boolean addExp(DataVillager dvr,int exp){
		
		Villager vr = Villager.registry.get(dvr.profession);
		if(vr != null){
			int nextExp = vr.getNextLevelExp(dvr.level);
			dvr.exp += exp;
			if(dvr.exp >= nextExp){
				dvr.level++;
				dvr.exp -= nextExp;
			}
			return true;
		}		
		return false;
	}

	public static boolean addCurrency(EntityPlayer entityPlayer, int currency){
		
		InventoryPlayer ip = entityPlayer.inventory;
		ItemStack itemStackCurrency = null;
		for (int i = 0; i < ip.mainInventory.length; ++i){
            if (ip.mainInventory[i] != null && ip.mainInventory[i].getItem() == ModItems.itemVillageCurrency){
            	itemStackCurrency = ip.mainInventory[i];
            	break;
            }
        }

		if(itemStackCurrency != null){
			//the player already have the curreny item
			int newCurrency = itemStackCurrency.getItemDamage() + currency;
			if(newCurrency >= 0){
				itemStackCurrency.setItemDamage(newCurrency);
				return true;
			}
			else{
				return false;
			}				
		}
		else{
			//the player dont have the curreny item
			if(currency < 0){
				return false;
			}
			else{
				ip.addItemStackToInventory(new ItemStack(ModItems.itemVillageCurrency,1,currency));
				return true;
			}
			
		}
	}
}
