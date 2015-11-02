package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompTrade;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerVillageElder extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Village Elder";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Living in Village Center";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<VillagerComponent> createComponents() {
		// TODO Auto-generated method stub
		 //test
        ArrayList<VillagerComponent> components = new ArrayList<VillagerComponent>();
        components.add(new VillagerCompAbout());
        components.add(new VillagerCompTrade());
        
        return components;
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Nice to meet you!");
		villagerChat.add(0, "Glad to see you!");
		villagerChat.add(0, "Hi there!");
		
	}

}
