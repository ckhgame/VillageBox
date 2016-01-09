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

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionChickenSeller extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.chikProductSeller.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.chikProductSeller.description");
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
        compBuy.addItem(ModBlocks.blockChicken, 0);
        compBuy.addItem(ModItems.itemChickenFood, 0);
        compBuy.addItem(ModItems.itemChickenPotion, 0);
        compBuy.addItem(ModItems.itemVillageEgg, 0);
        compBuy.addItem(ModItems.itemVillageHeartEgg, 0);
        compBuy.addItem(Items.lead, 0);
        compBuy.addItem(ModItems.itemChickenGloves, 1);

        components.add(compBuy);
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.chikProductSeller.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.chikProductSeller.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.chikProductSeller.chat2"));
		
	}

	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[1][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(ModItems.itemVillageEgg,8)};
		
	}
	
	@Override
	public String getSkinName() {
		return "chickenseller";
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(9,17));	
		timeSchedule.setWorkTime(1, new RangeInt(9,17));	
		timeSchedule.setWorkTime(2, new RangeInt(9,17));	
	
		timeSchedule.setWorkTime(4, new RangeInt(9,17));	
		timeSchedule.setWorkTime(5, new RangeInt(9,17));	
		timeSchedule.setWorkTime(6, new RangeInt(9,17));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}

}
