package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerSoldier extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Soldier";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "In your order!";
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

		villagerChat.add(0, "Let me tell you a ture story...");
		villagerChat.add(0, "Protect our homeland!");
		
	}

	@Override
	public String getSkinName() {
		return "soldier";
	}

}
