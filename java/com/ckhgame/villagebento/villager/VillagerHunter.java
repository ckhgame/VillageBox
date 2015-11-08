package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerHunter extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Hunter";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Hunting is fun!";
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

		villagerChat.add(0, "Hunting a deer?");
		villagerChat.add(0, "Go wild!");
		villagerChat.add(0, "Need some arrows?");
		
	}

	@Override
	public String getSkinName() {
		return "hunter";
	}

}
