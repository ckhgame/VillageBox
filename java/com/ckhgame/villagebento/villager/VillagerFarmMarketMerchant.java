package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerFarmMarketMerchant extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Farm Product Merchant";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Sell me your farming goods!";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Items.reeds, 12, 22, 0);
        compSell.addItemSell(Items.wheat, 12, 22, 0);
        compSell.addItemSell(Items.apple, 5, 9, 0);
        compSell.addItemSell(Items.carrot, 7, 12, 0, 2);
        compSell.addItemSell(Items.potato, 7, 12, 0, 2);
        compSell.addItemSell(Blocks.pumpkin, 5, 7, 0, 3);
        compSell.addItemSell(Blocks.melon_block, 5, 7, 0, 3);
        compSell.addItemSell(Items.golden_apple, 1, 3, 0, 5);
        compSell.addItemSell(Items.golden_carrot, 1, 3, 0, 5);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Selling somehing new?");
		villagerChat.add(0, "Harvest time!");
		villagerChat.add(0, "Um..let me see your crops..");
		
	}

	@Override
	public String getSkinName() {
		return "farmmarketmerchant";
	}

}
