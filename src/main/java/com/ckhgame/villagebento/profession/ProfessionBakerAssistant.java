package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionBakerAssistant extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Baker Assistant";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Entry level Baker";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(ModItems.itemWheatFlour, 0);
        compSell.addItem(ModItems.itemRiceFlour, 0);
        compSell.addItem(ModItems.itemSalt, 0);
        compSell.addItem(ModItems.itemOil, 0);
        components.add(compSell);
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need help with bakery?");
		villagerChat.add(0, "Wanna get some baking powder?");
		villagerChat.add(0, "Bakery is fun!");
		
	}

	@Override
	public String getSkinName() {
		return "bakerassistant";
	}
	
}
