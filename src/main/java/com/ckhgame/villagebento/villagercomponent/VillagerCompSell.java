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

public class VillagerCompSell extends VillagerCompItemList {
	
	public VillagerCompSell(EntityVBVillager entityVillager) {
		super(entityVillager);
	}
	
	//-------------------------------------------------------
	//--------------------Methods----------------------------
	//-------------------------------------------------------
	
	public VBCompResult sellItem(EntityPlayer player,ItemStack itemSell){
		if(this.itemRecords == null || itemSell.stackSize <= 0)
			return VBCompResult.getDefaultFailed();
		
		//sell process			
		for(ItemRecord itemRecord : this.itemRecords ){
			if(this.isItemRecoardAvailable(itemRecord) && itemRecord.itemStack.isItemEqual(itemSell)){
				if(HelperPlayer.playerHasItemStack(player, itemSell)){
					int num = HelperPlayer.getItemTotalInInventory(player, itemSell);
					if(itemSell.stackSize > num) itemSell.stackSize = num;
					HelperPlayer.playerRemoveItemStack(player, itemSell);
					HelperPlayer.addCurrency(player,ItemPrice.getSellPrice(itemSell.getItem()) * itemSell.stackSize);
					return VBCompResult.getDefaultSuccess();
				}
				else
					return new VBCompResult(VBResult.FAILED_NOITEM,"vcomp.sell.noitem");
			}							
		}
		
		return VBCompResult.getDefaultFailed();
	}
	
	@Override
	public String getNBTTagPostfix() {
		return "_s";
	}
}
