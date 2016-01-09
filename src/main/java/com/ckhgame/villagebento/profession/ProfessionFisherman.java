package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionFisherman extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.fisherman.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.fisherman.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.cooked_fished, 0, 0);
        compBuy.addItem(Items.cooked_fished, 0, 1);
        compBuy.addItem(ModItems.itemSeaweed, 0);
        compBuy.addItem(Items.fishing_rod, 0);
        compBuy.addItem(ModItems.itemFishingRodIron, 1);
        compBuy.addItem(ModItems.itemFishingRodGold, 1);
        compBuy.addItem(ModItems.itemFishingRodDiamond, 2);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.fish, 0, 0);
        compSell.addItem(Items.fish, 0, 1);
        compSell.addItem(Items.fish, 0, 2);
        compSell.addItem(Items.fish, 0, 3);
        components.add(compSell);

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.fisherman.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.fisherman.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.fisherman.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "fisherman";
	}
	
	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[2][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(Items.stick,32),
																				new ItemStack(Items.string,8)};
		
		this.levelRequirements[1] = new ItemStack[]{	new ItemStack(Items.stick,64),
																				new ItemStack(Items.iron_ingot,16),
																				new ItemStack(Items.gold_ingot,16)};
		
	}
	
}
