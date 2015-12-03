package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionLargeHotelOwner extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Large Hotel Owner";
	}

	@Override
	public String getProfessionDescription() {
		
		return "The owner of the Large Hotel";
	}
	
	@Override
	public boolean isMale(){
		return false;
	}
	
	@Override
	public boolean canSpawn() {
		
		return true;
	}

	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Glad to see you here!");
		villagerChat.add(0, "How are you doing today?");
		villagerChat.add(0, "This is the price of the room...");
		
	}

	@Override
	public String getSkinName() {
		return "largehotelowner";
	}
	
}
