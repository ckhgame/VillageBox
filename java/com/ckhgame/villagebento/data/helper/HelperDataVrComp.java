package com.ckhgame.villagebento.data.helper;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompBuy;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompSell;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompWork;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.misc.ItemPrice;
import com.ckhgame.villagebento.misc.VBParticles;
import com.ckhgame.villagebento.misc.VBResult;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.SActionDoSpawnParticles;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompAction;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;

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
		
		DataVillagerCompWork dataCompWork = (DataVillagerCompWork)findDataVillagerComp(dvr,DataVillagerCompWork.class);
		if(dataCompWork == null)
			return;
		
		if(dataCompWork.workIdx >= 0){
			dataCompWork.hoursLeft -= 1;
			if(dataCompWork.hoursLeft < -ConfigVillager.WorkOutputExpirationHours)
				HelperDataVrComp.removeWorkOutput(dvr);
		}
	}
	
	public static int startWork(DataVillager dvr,EntityPlayer player , int workIdx){
		if(player == null)
			return VBResult.FAILED;
		
		DataVillagerCompWork dataCompWork = (DataVillagerCompWork)findDataVillagerComp(dvr,DataVillagerCompWork.class);
		if(dataCompWork == null)
			return VBResult.FAILED;
		
		//if is working or is waiting for taking the output...
		if(dataCompWork.workIdx >= 0)
			return VBResult.FAILED;
		
		Villager vr = Villager.registry.get(dvr.profession);
		if(vr == null)
			return VBResult.FAILED;
		
		VillagerCompWork compWork = (VillagerCompWork)vr.findVillagerComponentByClass(VillagerCompWork.class);
		if(compWork == null)
			return VBResult.FAILED;
		
		if(workIdx >= compWork.getWorksSize())
			return VBResult.FAILED;
		
		if(!addCurrency(player,-compWork.getWorkPrice(workIdx)))
			return VBResult.FAILED_UNAFFORDABLE;
		
		dataCompWork.workIdx = workIdx;
		dataCompWork.playerName = player.getDisplayName();
		dataCompWork.hoursLeft = compWork.getWorkHours(workIdx);
		dataCompWork.output = compWork.generateOutput(workIdx);
		
		HelperDataVrComp.addExp(dvr, ConfigVillager.WorkExpPerHour * compWork.getWorkHours(workIdx));//
		
		return VBResult.SUCCESS;
		
	}
	
	public static int takeWorkOutput(DataVillager dvr,EntityPlayer player){
		if(player == null)
			return VBResult.FAILED;
		
		DataVillagerCompWork dataCompWork = (DataVillagerCompWork)findDataVillagerComp(dvr,DataVillagerCompWork.class);
		if(dataCompWork == null)
			return VBResult.FAILED;
		
		//if it's waiting for taking the output
		if(dataCompWork.workIdx >=0 && dataCompWork.hoursLeft <= 0){
			if(dataCompWork.output != null){
				
				String name1 = dataCompWork.playerName;
				String name2 = player.getDisplayName();
				
				if(!name1.equals(name2)){
					
					return VBResult.FAILED_WRONGNAME;
				}
					
				
				player.inventory.addItemStackToInventory(dataCompWork.output);
				dataCompWork.output = null;
				dataCompWork.workIdx = -1;
				
				return VBResult.SUCCESS;
			}
		}
		
		return VBResult.FAILED;
	}
	
	public static void removeWorkOutput(DataVillager dvr){
		DataVillagerCompWork dataCompWork = (DataVillagerCompWork)findDataVillagerComp(dvr,DataVillagerCompWork.class);
		if(dataCompWork == null)
			return;
		
		//if it's waiting for taking the output
		if(dataCompWork.workIdx >=0 && dataCompWork.hoursLeft <= 0){
			if(dataCompWork.output != null){
				dataCompWork.output = null;
				dataCompWork.workIdx = -1;
			}
		}
	}
	
	/**
	 * return:
	 * new Object[]{playerName(String),workIdx(int),hoursLeft(int),output(ItemStack)}
	 */
	public static Object[] getWork(DataVillager dvr){
		DataVillagerCompWork dataCompWork = (DataVillagerCompWork)findDataVillagerComp(dvr,DataVillagerCompWork.class);
		if(dataCompWork == null)
			return null;
		
		return new Object[]{dataCompWork.playerName,dataCompWork.workIdx,dataCompWork.hoursLeft,dataCompWork.output};
	}
	
	public static int[] getWorkList(DataVillager dvr){		
		Villager vr = Villager.registry.get(dvr.profession);
		if(vr == null)
			return new int[0];
		
		VillagerCompWork compWork = (VillagerCompWork)vr.findVillagerComponentByClass(VillagerCompWork.class);
		if(compWork == null)
			return new int[0];
		
		ArrayList<Integer> workIdxList = new ArrayList<Integer>();
		int s = compWork.getWorksSize();
		for(int i =0;i<s;i++){
			if(compWork.getWorkMinLevel(i) <= dvr.level)
				workIdxList.add(i);
		}
		
		int[] arr = new int[workIdxList.size()];
		for(int i =0;i<arr.length;i++)
			arr[i] = workIdxList.get(i);
		return arr;
	}
	
	public static int[] getActionList(DataVillager dvr){		
		Villager vr = Villager.registry.get(dvr.profession);
		if(vr == null)
			return new int[0];
		
		VillagerCompAction compAction = (VillagerCompAction)vr.findVillagerComponentByClass(VillagerCompAction.class);
		if(compAction == null)
			return new int[0];
		
		ArrayList<Integer> actionIdxList = new ArrayList<Integer>();
		int s = compAction.getActionSize();
		for(int i =0;i<s;i++){
			if(compAction.getActionMinLevel(i) <= dvr.level)
				actionIdxList.add(i);
		}
		
		int[] arr = new int[actionIdxList.size()];
		for(int i =0;i<arr.length;i++)
			arr[i] = actionIdxList.get(i);
		return arr;
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
			if(vr.isMaxLevel(dvr.level))
				return false;
			
			int nextExp = vr.getNextLevelExp(dvr.level);
			dvr.exp += exp;
			if(dvr.exp >= nextExp){
				//level up
				dvr.level++;
				dvr.exp -= nextExp;


				EntityVBVillager entity = (EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(dvr.cacheEntityVillagerID);
				if(entity != null){
					//spawn fx
					Action.send(SActionDoSpawnParticles.class, new Object[]{VBParticles.Fx_VillagerLevelingUp,entity.posX,entity.posY,entity.posZ,entity.getEntityId()});
				    //play sound
					entity.playSound("random.levelup", 1.0F, 1.0F);
				}
			}
			return true;
		}		
		return false;
	}

	public static boolean dropCurrency(EntityPlayer entityPlayer, int currency){
		if(addCurrency(entityPlayer,-currency)){
			
			ForgeHooks.onPlayerTossEvent(entityPlayer, new ItemStack(ModItems.itemVillageCurrency,1,currency), true);
			
			return true;
		}
		return false;
	}
	
	public static boolean addCurrency(EntityPlayer entityPlayer, int currency){
		
		InventoryPlayer ip = entityPlayer.inventory;
		ItemStack itemStackCurrency = null;
		int i;
		for (i = 0; i < ip.mainInventory.length; ++i){
            if (ip.mainInventory[i] != null && ip.mainInventory[i].getItem() == ModItems.itemVillageCurrency){
            	itemStackCurrency = ip.mainInventory[i];
            	break;
            }
        }

		if(itemStackCurrency != null){
			//the player already have the curreny item
			int newCurrency = itemStackCurrency.getItemDamage() + currency;
			if(newCurrency > 0){
				itemStackCurrency.setItemDamage(newCurrency);
				return true;
			}
			else if(newCurrency == 0){
				ip.mainInventory[i] = null;
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

	/**
	 * return times, <0 means not enough money, =0 means lose money, >0 means the final times
	 */
	public static int bet(EntityPlayer entityPlayer,DataVillager dvr, int bet){
		
		if(addCurrency(entityPlayer,-bet)){

			HelperDataVrComp.addExp(dvr, ConfigVillager.BetExp);
			
			Random rand = new Random();
			int r = rand.nextInt(100);
			int times = 0;
			if(r < 50){
				times = 0;//50%
			}
			else if(r >= 50 && r < 84)
				times = 1;//34%
			else if(r >= 84 && r < 94){
				times = 2;//10%
			}
			else if(r >= 94 && r < 99){
				times = 4;//5%
			}
			else{
				times = 8;//1%
			}
			
			addCurrency(entityPlayer,bet * times);
			
			return times;
		}
		return -1;
	}

}
