package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerPastureMarketMerchant extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Pasture Product Merchant";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Sell me your pasture products!";
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
        compSell.addItemSell(ModItems.itemVillageEgg, 10, 20, 0);
        compSell.addItemSell(ModItems.itemVillageHeartEgg, 10, 20, 0);
        compSell.addItemSell(ModItems.itemVillageSilverEgg, 4, 8, 0);
        compSell.addItemSell(ModItems.itemVillageGoldenEgg, 2, 5, 0);
        compSell.addItemSell(ModItems.itemVillageEasterEgg, 2, 5, 0);
        compSell.addItemSell(ModItems.itemVillageWool, 10, 20, 0);
        compSell.addItemSell(ModItems.itemVillageMilk, 10, 20, 0);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Selling somehing new?");
		villagerChat.add(0, "Do you remember feeding your animals?");
		villagerChat.add(0, "What you want to sell to me today?");
		
	}

	@Override
	public String getSkinName() {
		return "pasturemarketmerchant";
	}

}
