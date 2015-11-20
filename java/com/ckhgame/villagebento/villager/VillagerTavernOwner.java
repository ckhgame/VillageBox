package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerTavernOwner extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Tavern Owner";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Wanna have a drink?";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        VillagerCompBuy compBuy = new VillagerCompBuy();
        compBuy.addItemBuy(ModItems.itemCockTail, 1, 5, 0);
        compBuy.addItemBuy(ModItems.itemCookVine, 1, 10, 0);
        compBuy.addItemBuy(ModItems.itemBeer, 1, 3, 0);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Got something to drink?");
		villagerChat.add(0, "Sometime is better to get dunk...");
		villagerChat.add(0, "Alcohol sloves everything.");
		
	}

	@Override
	public String getSkinName() {
		return "tavernowner";
	}

}
