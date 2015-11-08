package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerBlackSmith extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "BlackSmith";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Making good weapons!";
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

		villagerChat.add(0, "Need any help on Armor?!");
		villagerChat.add(0, "Shaper..");
		villagerChat.add(0, "Need more Gold!");
		
	}

	@Override
	public String getSkinName() {
		return "blacksmith";
	}

}
