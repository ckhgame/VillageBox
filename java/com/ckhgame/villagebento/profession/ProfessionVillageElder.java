package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompQuest;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;
import com.ckhgame.villagebento.villagercomponent.villagerquest.VillagerQuestDesign;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class ProfessionVillageElder extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Village Elder";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Living in Village Center";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        //buy & sell
        //params:
        //1.Block or Item 2. min 3.max 4.minlevel  5.meta
        
        //buy list
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(ModBlocks.blockFishingStore, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockSmallBakery, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockMiningHouse, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockPlayerFieldSmall, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockArchitectsHome, 1, 1, 0);
        components.add(compBuy);
        
        //sell list
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Blocks.cobblestone, 50, 60, 0);
        compSell.addItem(Items.rotten_flesh, 7, 13, 0);
        compSell.addItem(Blocks.log, 20, 30, 0, 0);
        compSell.addItem(Blocks.log, 20, 30, 0, 1);
        compSell.addItem(Blocks.log, 20, 30, 0, 2);
        compSell.addItem(Blocks.log, 20, 30, 0, 3);
        compSell.addItem(Blocks.log2, 20, 30, 0, 0);
        compSell.addItem(Blocks.log2, 20, 30, 0, 1);
        components.add(compSell);
        
        //work
        /*
         
        VillagerCompWork compWork = new VillagerCompWork(villager);
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
        
        //quest
        VillagerCompQuest compQuest = new VillagerCompQuest(villager);
        VillagerQuestDesign design = new VillagerQuestDesign("The Quest for Beginner","Hi, thank you so much for building the house for me. If you don't mind, could you keep helping with me?",0);
        design.addNeeds(Items.apple, 2, 0);
        design.addNeeds(Blocks.log, 5, 0);
        design.addNeeds(Blocks.log, 5, 1);
        design.addRewards(ModItems.itemVillageCurrency, 1, 100);
        design.addRewards(ModItems.itemVillageCurrency, 1, 150);
        compQuest.addQuestDesign(design);
        
        components.add(compQuest);
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
