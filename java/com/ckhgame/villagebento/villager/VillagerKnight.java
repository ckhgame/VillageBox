package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerKnight extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Knight";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Portect our homeland...";
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

		villagerChat.add(0, "Glad to see you!");
		villagerChat.add(0, "On your side...");
		
	}

	@Override
	public String getSkinName() {
		return "knight";
	}

}
