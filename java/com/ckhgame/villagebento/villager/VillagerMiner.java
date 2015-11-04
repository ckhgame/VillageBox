package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerMiner extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Miner";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Mining things.......";
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

		villagerChat.add(0, "I saw a big boom yesterday");
		villagerChat.add(0, "Do you need help?");
		villagerChat.add(0, "Hello there!");
		
	}
	
	@Override
	public String getSkinName() {
		return "miner";
	}

}
