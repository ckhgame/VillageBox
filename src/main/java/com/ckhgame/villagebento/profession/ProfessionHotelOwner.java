package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.util.StatCollector;

public class ProfessionHotelOwner extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.hotelOwner.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.hotelOwner.description");
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

		villagerChat.add(0, StatCollector.translateToLocal("villager.hotelOwner.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.hotelOwner.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.hotelOwner.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "hotelowner";
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(12,17));	
		timeSchedule.setWorkTime(1, new RangeInt(12,17));	

		timeSchedule.setWorkTime(3, new RangeInt(12,17));	
		timeSchedule.setWorkTime(4, new RangeInt(12,17));	
		timeSchedule.setWorkTime(5, new RangeInt(12,17));	
		timeSchedule.setWorkTime(6, new RangeInt(12,17));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}
	
}
