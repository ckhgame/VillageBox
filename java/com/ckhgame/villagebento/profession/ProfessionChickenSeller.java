package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionChickenSeller extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Chicken Products Seller";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Chicken Run,Chicken Run!";
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
        compBuy.addItem(ModBlocks.blockChicken, 1, 1, 0);
        compBuy.addItem(ModItems.itemChickenFood, 30, 50, 0);
        compBuy.addItem(ModItems.itemChickenPotion, 3, 5, 0);
        compBuy.addItem(ModItems.itemChickenGloves, 1, 1, 0);
        compBuy.addItem(ModItems.itemVillageEgg, 5, 10, 0);
        compBuy.addItem(ModItems.itemVillageHeartEgg, 2, 5, 0);
        compBuy.addItem(Items.lead, 1, 2, 0);

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
