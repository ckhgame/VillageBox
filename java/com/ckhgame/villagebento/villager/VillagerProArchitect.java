package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerProArchitect extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Professional Architect";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Get some buidlings.";
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

		villagerChat.add(0, "Which place you want to build?");
		villagerChat.add(0, "Let's make some art works on the ground!");
		villagerChat.add(0, "The beauty of engineering!");
		
	}

	@Override
	public String getSkinName() {
		return "proarchitect";
	}

}
