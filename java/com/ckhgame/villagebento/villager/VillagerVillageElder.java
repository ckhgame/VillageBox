package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.network.action.ActionDoVillagerBet;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompAction;
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
        
        //buy & sell
        //params:
        //1.Block or Item 2. min 3.max 4.minlevel  5.meta
        
        //buy list
        VillagerCompBuy compBuy = new VillagerCompBuy();
        compBuy.addItemBuy(ModBlocks.blockFishingStore, 1, 1, 0);
        compBuy.addItemBuy(ModBlocks.blockSmallBakery, 1, 1, 0);
        compBuy.addItemBuy(ModBlocks.blockMiningHouse, 1, 1, 0);
        compBuy.addItemBuy(ModBlocks.blockGroundworkOnlySmall, 1, 1, 0);
        compBuy.addItemBuy(ModBlocks.blockArchitectsHome, 1, 1, 0);
        components.add(compBuy);
        
        //sell list
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Blocks.cobblestone, 50, 60, 0);
        compSell.addItemSell(Items.rotten_flesh, 7, 13, 0);
        compSell.addItemSell(Blocks.log, 20, 30, 0, 0);
        compSell.addItemSell(Blocks.log, 20, 30, 0, 1);
        compSell.addItemSell(Blocks.log, 20, 30, 0, 2);
        compSell.addItemSell(Blocks.log, 20, 30, 0, 3);
        compSell.addItemSell(Blocks.log2, 20, 30, 0, 0);
        compSell.addItemSell(Blocks.log2, 20, 30, 0, 1);
        components.add(compSell);
        
        //work
        /*
         
        VillagerCompWork compWork = new VillagerCompWork();
        int workIdx;
        
        //work1
        workIdx = compWork.createWork("Not Enough Torch", "get some coal...",0 , 10, 15); //params: 1. title 2.remark, 3.minlevel 4.hours(mc world) 5.price
        compWork.addWorkOutput(workIdx, Items.coal, 7, 15);
        compWork.addWorkOutput(workIdx, Items.wood, 3, 16);//param: 1. workIdx 2.ITem/Block 3.min 4.max
        
        //work2
        workIdx = compWork.createWork("Iron Finder", "a little bit iron taste..", 1, 10, 50);
        compWork.addWorkOutput(workIdx, Blocks.iron_ore, 3, 5); 
        
        components.add(compWork);
        
         */

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
