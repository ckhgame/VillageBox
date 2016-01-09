package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionLibrarian extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.librarian.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.librarian.description");
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

            VillagerCompBuy compBuy = new VillagerCompBuy(villager);
            compBuy.addItem(Items.paper, 0);
            compBuy.addItem(ModItems.itemCookingBookI, 0);
            compBuy.addItem(ModItems.itemCookingBookII, 0);
            compBuy.addItem(ModItems.itemAnimalBook, 0);
            compBuy.addItem(ModItems.itemPlantBook, 0);
            compBuy.addItem(ModItems.itemBuildingsBook, 0);
            compBuy.addItem(ModItems.itemNPCBook, 0);

            components.add(compBuy);
            

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.librarian.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.librarian.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.librarian.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "librarian";
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(11,16));	
		timeSchedule.setWorkTime(1, new RangeInt(11,16));	
		timeSchedule.setWorkTime(2, new RangeInt(11,16));	
		timeSchedule.setWorkTime(3, new RangeInt(11,17));	
		timeSchedule.setWorkTime(4, new RangeInt(11,17));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}

}
