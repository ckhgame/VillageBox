package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionTailor extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Tailor";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Tailoring.";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Look at this new design...");
		villagerChat.add(0, "Wanna warm clothes?");
		villagerChat.add(0, "How about this one?");
		
	}

	@Override
	public String getSkinName() {
		return "tailor";
	}

}
