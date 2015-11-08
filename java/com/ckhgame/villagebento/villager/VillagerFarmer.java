package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerFarmer extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Farmer";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Farming!";
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

		villagerChat.add(0, "Need help on farming?");
		villagerChat.add(0, "Get something to eat?");
		villagerChat.add(0, "Look at this big pumpkin!");
		
	}

	@Override
	public String getSkinName() {
		return "farmer";
	}

}
