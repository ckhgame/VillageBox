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
		
		ArrayList<ItemStack> itemStacks = this.itemListCurrent;
		if(itemStacks == null)
			return VBCompResult.getDefaultFailed();
		
		//buy process			
		for(ItemStack itemStack : itemStacks ){
			if(itemStack.isItemEqual(itemBuy)){
				if(itemStack.stackSize >= itemBuy.stackSize){
					if(HelperPlayer.addCurrency(player,-ItemPrice.getBuyPrice(itemBuy.getItem()))){
						itemStack.stackSize -= itemBuy.stackSize;
						player.inventory.addItemStackToInventory(itemBuy);
						//this.getVillager().addExp(ConfigVillager.TradingExp);						
						return VBCompResult.getDefaultSuccess();
					}
					else
						return new VBCompResult(VBResult.FAILED_UNAFFORDABLE,StatCollector.translateToLocal("vcomp.buy.unaffordable"));
				}
				else
					return new VBCompResult(VBResult.FALLED_RUNOUT,StatCollector.translateToLocal("vcomp.buy.runout"));
			}							
		}
		
		return VBCompResult.getDefaultFailed();
	}


	@Override
	public String getNBTTagPostfix() {
		return "_b";
	}
}
