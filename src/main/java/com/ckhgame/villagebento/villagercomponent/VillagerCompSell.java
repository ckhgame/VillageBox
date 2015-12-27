package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.guiold.GuiVillagerSell;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperPlayer;
import com.ckhgame.villagebento.util.village.ItemPrice;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class VillagerCompSell extends VillagerCompItemList {
	
	public VillagerCompSell(EntityVBVillager entityVillager) {
		super(entityVillager,new GuiVillagerSell());
	}
	
	//-------------------------------------------------------
	//--------------------Methods----------------------------
	//-------------------------------------------------------
	
	public VBCompResult sellItem(EntityPlayer player,ItemStack itemSell){
		
		ArrayList<ItemStack> itemStacks = this.itemListCurrent;
		if(itemStacks == null)
			return VBCompResult.getDefaultFailed();
		
		//sell process			
		for(ItemStack itemStack : itemStacks ){
			if(itemStack.isItemEqual(itemSell)){
				if(itemStack.stackSize >= itemSell.stackSize){
					if(HelperPlayer.playerHasItemStack(player, itemSell)){
						itemStack.stackSize -= itemSell.stackSize;
						HelperPlayer.playerRemoveItemStack(player, itemSell);
						HelperPlayer.addCurrency(player,ItemPrice.getSellPrice(itemSell.getItem()));
						//this.getVillager().addExp(ConfigVillager.TradingExp);
					
						return VBCompResult.getDefaultSuccess();
					}
					else
						return new VBCompResult(VBResult.FAILED_NOITEM,"You don't have that...");
				}
				else
					return new VBCompResult(VBResult.FALLED_RUNOUT,"I don't need more of that..");
			}							
		}
		
		return VBCompResult.getDefaultFailed();
	}
	
	@Override
	public String getNBTTagPostfix() {
		return "_s";
	}
}
