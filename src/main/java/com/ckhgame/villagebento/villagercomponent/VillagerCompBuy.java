package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperPlayer;
import com.ckhgame.villagebento.util.village.ItemPrice;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class VillagerCompBuy extends VillagerCompItemList {
	
	public VillagerCompBuy(EntityVBVillager entityVillager) {
		super(entityVillager);
	}
	
	
	//-------------------------------------------------------
	//--------------------Methods----------------------------
	//-------------------------------------------------------
	
	
	public VBCompResult buyItem(EntityPlayer player,ItemStack itemBuy){	
		this.refreshItemListCurrent();
		ArrayList<ItemStack> itemStacks = this.itemListCurrent;
		if(itemStacks == null || itemBuy.stackSize <= 0)
			return VBCompResult.getDefaultFailed();
		
		//buy process			
		for(ItemStack itemStack : itemStacks ){
			if(itemStack.isItemEqual(itemBuy)){
				if(HelperPlayer.addCurrency(player,-ItemPrice.getBuyPrice(itemBuy.getItem()) * itemBuy.stackSize)){
					if(!player.inventory.addItemStackToInventory(itemBuy)){
						player.dropPlayerItemWithRandomChoice(itemBuy, false);
					}
					return VBCompResult.getDefaultSuccess();
				}
				else
					return new VBCompResult(VBResult.FAILED_UNAFFORDABLE,"vcomp.buy.unaffordable");
			}							
		}
		
		return VBCompResult.getDefaultFailed();
	}


	@Override
	public String getNBTTagPostfix() {
		return "_b";
	}
}
