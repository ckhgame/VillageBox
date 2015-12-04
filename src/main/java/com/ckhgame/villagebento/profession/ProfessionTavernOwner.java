package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionTavernOwner extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Tavern Owner";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Wanna have a drink?";
	}
	
	@Override
	public boolean isMale(){
		return false;
	}
	
	@Override
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBVillager.class;
	}
	
	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(ModItems.itemCockTail, 1, 5, 0);
        compBuy.addItem(ModItems.itemCookVine, 1, 10, 0);
        compBuy.addItem(ModItems.itemBeer, 1, 3, 0);

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
