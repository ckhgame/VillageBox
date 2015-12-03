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

public class ProfessionCowSeller extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Cow Products Seller";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Selling Milk";
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
        compBuy.addItem(ModBlocks.blockCow, 1, 1, 0);
        compBuy.addItem(ModItems.itemCowFood, 30, 50, 0);
        compBuy.addItem(ModItems.itemCowPotion, 3, 5, 0);
        compBuy.addItem(ModItems.itemMilkBottle, 20, 30, 0);
        compBuy.addItem(ModItems.itemVillageMilk, 5, 10, 0);
        compBuy.addItem(Items.lead, 1, 2, 0);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "What you need?");
		villagerChat.add(0, "Freash Milk!");
		
	}

	@Override
	public String getSkinName() {
		return "cowseller";
	}

}
