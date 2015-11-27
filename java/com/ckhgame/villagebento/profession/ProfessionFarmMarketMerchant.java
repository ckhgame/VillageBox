package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class ProfessionFarmMarketMerchant extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Farm Product Merchant";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Sell me your farming goods!";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.reeds, 12, 22, 0);
        compSell.addItem(Items.wheat, 12, 22, 0);
        compSell.addItem(Items.apple, 5, 9, 0);
        compSell.addItem(Items.carrot, 7, 12, 0, 2);
        compSell.addItem(Items.potato, 7, 12, 0, 2);
        compSell.addItem(Blocks.pumpkin, 5, 7, 0, 3);
        compSell.addItem(Blocks.melon_block, 5, 7, 0, 3);
        compSell.addItem(Items.golden_apple, 1, 3, 0, 5);
        compSell.addItem(Items.golden_carrot, 1, 3, 0, 5);
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
