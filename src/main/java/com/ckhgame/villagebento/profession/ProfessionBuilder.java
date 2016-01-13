package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.util.StatCollector;

public class ProfessionBuilder extends Profession {

	@Override
	public String getProfessionName() {
				
		return StatCollector.translateToLocal("villager.builder.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.builder.description");
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

		villagerChat.add(0, StatCollector.translateToLocal("villager.builder.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.builder.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.builder.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "builder";
	}

}
