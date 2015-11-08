package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerCasinoManager extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Casino Manager";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Gambling is drug.";
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

		villagerChat.add(0, "Wanna have fun?");
		villagerChat.add(0, "Lost money does not means you lost everthing...");
		villagerChat.add(0, "It is a Win-Win!");
		
	}

	@Override
	public String getSkinName() {
		return "casinomanager";
	}

}
