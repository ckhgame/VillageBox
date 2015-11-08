package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerChickenSeller extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Chicken Products Seller";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Chicken Run,Chicken Run!";
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

		villagerChat.add(0, "Need more eggs?");
		villagerChat.add(0, "Chickens are cute!");
		villagerChat.add(0, "Let's sing a chicken song!");
		
	}

	@Override
	public String getSkinName() {
		return "chickenseller";
	}

}
