package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionArchitect extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Architect";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Let's building";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));

        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(ModBlocks.blockDefenceTower, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockChickenShop, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockBlackSmithsShop, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockMarket, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockSmallHotel, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockHunterHouse, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockSmallMilitaryCamp, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockSheepShop, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockCowShop, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockTailorStore, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockSmallTavern, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockFarmland, 1, 1, 0);          
        compBuy.addItem(ModBlocks.blockBuildingDestroyer, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockPlayerFieldMedium, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockSmallCasino, 1, 1, 0);            
        compBuy.addItem(ModBlocks.blockProArchitectsHouse, 1, 1, 0);
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
