package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.util.StatCollector;

public class ProfessionTavernOwner extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.tavernOwner.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.tavernOwner.description");
	}
	
	@Override
	public boolean isMale(){
		return false;
	}
	
	@Override
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBVillager.class;
	}
	
	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(ModItems.itemCockTail, 0);
        compBuy.addItem(ModItems.itemCookVine, 0);
        compBuy.addItem(ModItems.itemBeer, 0);

        components.add(compBuy);

	}

	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(16,28));		//Monday
		timeSchedule.setWorkTime(1, new RangeInt(16,28));		//Tuesday
		timeSchedule.setWorkTime(2, new RangeInt(16,28));		//Wednesday
		timeSchedule.setWorkTime(3, new RangeInt(16,28));		//Thursday
		timeSchedule.setWorkTime(4, new RangeInt(16,28));		//Friday
		timeSchedule.setWorkTime(5, new RangeInt(16,28));		//Saturday
		timeSchedule.setWorkTime(6, new RangeInt(16,28));		//Sunday
		
		//sleeping
		timeSchedule.setSleeptime(new  RangeInt(6,14));
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "villager.tavernOwner.chat0");
		villagerChat.add(0, "villager.tavernOwner.chat1");
		villagerChat.add(0, "villager.tavernOwner.chat2");
		
	}

	@Override
	public String getSkinName() {
		return "tavernowner";
	}

}
