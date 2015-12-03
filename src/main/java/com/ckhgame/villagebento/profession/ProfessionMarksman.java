package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionMarksman extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Marksman";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Protect the village!";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need more focus...");
		villagerChat.add(0, "Get farther.");
		
	}

	@Override
	public String getSkinName() {
		return "marksman";
	}

}
