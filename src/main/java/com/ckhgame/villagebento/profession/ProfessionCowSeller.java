package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionCowSeller extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.cowProductSeller.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.cowProductSeller.description");
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
        compBuy.addItem(ModBlocks.blockCow, 0);
        compBuy.addItem(ModItems.itemCowFood, 0);
        compBuy.addItem(ModItems.itemCowPotion, 0);
        compBuy.addItem(ModItems.itemMilkBottle, 0);
        compBuy.addItem(ModItems.itemVillageMilk, 0);
        compBuy.addItem(Items.lead, 0);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.cowProductSeller.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.cowProductSeller.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.cowProductSeller.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "cowseller";
	}

	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(9,17));	
		timeSchedule.setWorkTime(1, new RangeInt(9,17));	
		timeSchedule.setWorkTime(2, new RangeInt(9,17));	
		timeSchedule.setWorkTime(3, new RangeInt(9,17));	

		timeSchedule.setWorkTime(5, new RangeInt(9,17));	
		timeSchedule.setWorkTime(6, new RangeInt(9,17));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}
}
