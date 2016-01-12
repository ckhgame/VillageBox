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
        compBuy.addItem(ModBlocks.blockPlayerFieldSmall, 0);
        compBuy.addItem(ModBlocks.blockDefenceTower, 0);
        compBuy.addItem(ModBlocks.blockTownSquareSmall, 0);
        compBuy.addItem(ModBlocks.blockPlayerFieldMedium, 1);
        compBuy.addItem(ModBlocks.blockTownSquareLarge, 1);
        compBuy.addItem(ModBlocks.blockBuildingDestroyer, 1);
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
