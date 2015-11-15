package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerArchitect extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Architect";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Let's building";
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
            compBuy.addItemBuy(ModBlocks.blockDefenceTower, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockChickenShop, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockBlackSmithsShop, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockMarket, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockSmallHotel, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockHunterHouse, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockSmallMilitaryCamp, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockSheepShop, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockCowShop, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockTailorStore, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockSmallTavern, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockFarmland, 1, 1, 0);          
            compBuy.addItemBuy(ModBlocks.blockBuildingDestroyer, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockGroundworkOnlyMedium, 1, 1, 0);
            compBuy.addItemBuy(ModBlocks.blockSmallCasino, 1, 1, 0);            
            compBuy.addItemBuy(ModBlocks.blockProArchitectsHouse, 1, 1, 0);
            components.add(compBuy);
            

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need any help on building?!");
		villagerChat.add(0, "Glad to see you!");
		villagerChat.add(0, "I'm nature artist!");
		
	}

	@Override
	public String getSkinName() {
		return "architect";
	}

}
