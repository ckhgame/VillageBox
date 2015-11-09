package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerLargeTavernOwner extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Large Tavern Owner";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Liquid is the best medicine for pain.";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Got something to drink?");
		villagerChat.add(0, "Vodka? or just want a cocktail?");
		villagerChat.add(0, "liquid sloves everything.");
		
	}

	@Override
	public String getSkinName() {
		return "largetavernowner";
	}

}
