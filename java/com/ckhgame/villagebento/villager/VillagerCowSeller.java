package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerCowSeller extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Cow Products Seller";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Selling Milk";
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
        compBuy.addItemBuy(Items.lead, 1, 1, 0);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "What you need?");
		villagerChat.add(0, "Freash Milk!");
		
	}

	@Override
	public String getSkinName() {
		return "cowseller";
	}

}
