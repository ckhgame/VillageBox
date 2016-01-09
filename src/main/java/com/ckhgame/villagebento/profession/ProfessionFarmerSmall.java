package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionFarmerSmall extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.farmerSmall.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.farmerSmall.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.iron_hoe, 0);

        compBuy.addItem(Items.wheat_seeds, 0);
        compBuy.addItem(Items.carrot, 0);
        compBuy.addItem(Items.potato, 0);
        compBuy.addItem(Items.apple, 0);
        
        compBuy.addItem(Items.pumpkin_seeds, 1);
        compBuy.addItem(Items.melon_seeds, 1);
        compBuy.addItem(Items.golden_hoe, 1);
        
        compBuy.addItem(ModItems.itemCornSeed, 1);
        compBuy.addItem(ModItems.itemRiceSeed, 1);
        compBuy.addItem(ModItems.itemCabbageSeed, 1);
        
        compBuy.addItem(ModItems.itemSoybeanSeed, 2);
        compBuy.addItem(ModItems.itemChiliSeed, 2);
        compBuy.addItem(ModItems.itemGrapeSeed, 2);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.farmerSmall.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.farmerSmall.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.farmerSmall.chat2"));
		
	}
	
	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[2][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(Items.apple,12),
																						new ItemStack(Items.carrot,12),
																						new ItemStack(Items.potato,12)};
		
		this.levelRequirements[1] = new ItemStack[]{	new ItemStack(ModItems.itemCorn,24),
																						new ItemStack(ModItems.itemCabbage,24),
																						new ItemStack(ModItems.itemRice,24)};
		
	}

	@Override
	public String getSkinName() {
		return "farmersmall";
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(6,14));	
		timeSchedule.setWorkTime(1, new RangeInt(6,14));	
		timeSchedule.setWorkTime(2, new RangeInt(6,14));	
		timeSchedule.setWorkTime(3, new RangeInt(6,14));	
		timeSchedule.setWorkTime(4, new RangeInt(6,14));	

		timeSchedule.setWorkTime(6, new RangeInt(6,14));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}

}
