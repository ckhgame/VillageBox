package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerLibrarian extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Librarian";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Every book gives a new journey.";
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
            compBuy.addItemBuy(Items.paper, 1, 10, 0);
            compBuy.addItemBuy(ModItems.itemCookingBookI, 1, 1, 0);
            compBuy.addItemBuy(ModItems.itemCookingBookII, 1, 1, 0);
            compBuy.addItemBuy(ModItems.itemAnimalBook, 1, 1, 0);
            compBuy.addItemBuy(ModItems.itemPlantBook, 1, 1, 0);
            compBuy.addItemBuy(ModItems.itemBuildingsBook, 1, 1, 0);
            compBuy.addItemBuy(ModItems.itemNPCBook, 1, 1, 0);



            components.add(compBuy);
            

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Book is the most wonderful creature in the world. ");
		villagerChat.add(0, "....");
		villagerChat.add(0, "I love books!");
		
	}

	@Override
	public String getSkinName() {
		return "librarian";
	}

}
