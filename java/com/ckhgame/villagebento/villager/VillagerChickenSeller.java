package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerChickenSeller extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Chicken Products Seller";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Chicken Run,Chicken Run!";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());

        VillagerCompBuy compBuy = new VillagerCompBuy();
        compBuy.addItemBuy(ModBlocks.blockChicken, 1, 1, 0);
        compBuy.addItemBuy(ModItems.itemChickenFood, 30, 50, 0);
        compBuy.addItemBuy(ModItems.itemChickenPotion, 3, 5, 0);
        compBuy.addItemBuy(ModItems.itemChickenGloves, 1, 1, 0);
        compBuy.addItemBuy(ModItems.itemVillageEgg, 5, 10, 0);
        compBuy.addItemBuy(ModItems.itemVillageHeartEgg, 2, 5, 0);
        compBuy.addItemBuy(Items.lead, 1, 2, 0);

        components.add(compBuy);
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need more eggs?");
		villagerChat.add(0, "Chickens are cute!");
		villagerChat.add(0, "Let's sing a chicken song!");
		
	}

	@Override
	public String getSkinName() {
		return "chickenseller";
	}

}
