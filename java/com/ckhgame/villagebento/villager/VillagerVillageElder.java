package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerVillageElder extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Village Elder";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Living in Village Center";
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
        compBuy.addItemBuy(ModBlocks.blockFishingStore, 1, 1, 0);
        compBuy.addItemBuy(ModBlocks.blockSmallBakery, 1, 1, 0);
        compBuy.addItemBuy(ModBlocks.blockMiningHouse, 1, 1, 0);
        compBuy.addItemBuy(ModBlocks.blockArchitectsHome, 1, 1, 0);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Blocks.log, 20, 30, 0, 0);
        compSell.addItemSell(Blocks.log, 20, 30, 0, 1);
        compSell.addItemSell(Blocks.log, 20, 30, 0, 2);
        compSell.addItemSell(Blocks.log, 20, 30, 0, 3);
        compSell.addItemSell(Blocks.cobblestone, 50, 60, 0);
        components.add(compSell);

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "I'm an old man!");
		villagerChat.add(0, "Glad to see you!");
		villagerChat.add(0, "zzz...zzz...!");
		
	}
	
	@Override
	public String getSkinName() {
		return "villageelder";
	}

}
