package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionHotelOwner extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Hotel Owner";
	}

	@Override
	public String getProfessionDescription() {
		
		return "The owner of the Hotel";
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

		villagerChat.add(0, "Welcome!");
		villagerChat.add(0, "Have a sweet dream!");
		villagerChat.add(0, "Finding place to sleep?");
		
	}

	@Override
	public String getSkinName() {
		return "hotelowner";
	}
	
}
