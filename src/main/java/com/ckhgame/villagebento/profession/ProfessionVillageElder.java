package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompQuest;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;
import com.ckhgame.villagebento.villagercomponent.villagerquest.VillagerQuestDesign;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionVillageElder extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.villageElder.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.villageElder.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {
		
        components.add(new VillagerCompAbout(villager));
        
        //quest
        VillagerCompQuest compQuest = new VillagerCompQuest(villager);

        VillagerQuestDesign design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villageElder.questZombie"),0,3);
        design.addNeeds(Items.rotten_flesh, 3, 0);
        design.addRewards(ModItems.itemVillageCurrency, 1, 15);
        design.addRewards(ModItems.itemVillageCurrency, 1, 20);
        compQuest.addQuestDesign(design);
        
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villageElder.questWantWoods"),0,1);
        design.addNeeds(Blocks.log, 30, 0);
        design.addNeeds(Blocks.log, 30, 1);
        design.addNeeds(Blocks.log, 30, 2);
        design.addNeeds(Blocks.log, 30, 3);
        design.addNeeds(Blocks.log2, 30, 0);
        design.addNeeds(Blocks.log2, 30, 1);
        design.addRewards(ModItems.itemVillageCurrency, 1, 75);
        design.addRewards(ModBlocks.blockFolkHouse,1,0);
        compQuest.addQuestDesign(design);
        
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villageElder.questWantStones"),0,1);
        design.addNeeds(Blocks.stonebrick, 40, 0);
        design.addRewards(ModItems.itemVillageCurrency, 1, 75);
        design.addRewards(ModBlocks.blockFolkHouse,1,0);
        compQuest.addQuestDesign(design);
        
        components.add(compQuest);
        
        
        //buy & sell
        //params:
        //1.Block or Item 2. min 3.max 4.minlevel  5.meta
        
        //buy list
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(ModBlocks.blockSmallBakery, 0);
        compBuy.addItem(ModBlocks.blockFishingStore, 0);
        compBuy.addItem(ModBlocks.blockBlackSmithsShop, 0);
        compBuy.addItem(ModBlocks.blockMarket, 0);
        compBuy.addItem(ModBlocks.blockArchitectsHome, 0);
        compBuy.addItem(ModBlocks.blockHunterHouse, 0);
        compBuy.addItem(ModBlocks.blockMiningHouse, 0);
        compBuy.addItem(ModBlocks.blockChurch, 0);
        
        compBuy.addItem(ModBlocks.blockVillagerHomeTP, 1);
        compBuy.addItem(ModBlocks.blockFarmland, 1);
        compBuy.addItem(ModBlocks.blockChickenShop, 1);
        compBuy.addItem(ModBlocks.blockSheepShop, 1);
        compBuy.addItem(ModBlocks.blockCowShop, 1);
        compBuy.addItem(ModBlocks.blockLibrary, 1);
        compBuy.addItem(ModBlocks.blockSmallMilitaryCamp, 1);
        compBuy.addItem(ModBlocks.blockSmallHotel, 1);
        compBuy.addItem(ModBlocks.blockSmallTavern, 1);
        compBuy.addItem(ModBlocks.blockPotionStore, 1);
               
        compBuy.addItem(ModBlocks.blockLargeBakery, 2);
        compBuy.addItem(ModBlocks.blockFlowerShop, 2); 
        compBuy.addItem(ModBlocks.blockProArchitectsHouse, 2);
        compBuy.addItem(ModBlocks.blockSmallCasino, 2); 
        compBuy.addItem(ModBlocks.blockTailorStore, 2);

        components.add(compBuy);
        
        //sell list
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Blocks.cobblestone, 0);
        compSell.addItem(Blocks.log, 0, 0);
        compSell.addItem(Blocks.log, 0, 1);
        compSell.addItem(Blocks.log, 0, 2);
        compSell.addItem(Blocks.log, 0, 3);
        compSell.addItem(Blocks.log2, 0, 0);
        compSell.addItem(Blocks.log2, 0, 1);
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
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.villageElder.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.villageElder.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.villageElder.chat2"));
		
	}
	
	@Override
	public String getSkinName() {
		return "villageelder";
	}

	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[2][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(Blocks.torch,32),
																				new ItemStack(Blocks.crafting_table,1)};
		
		this.levelRequirements[1] = new ItemStack[]{	new ItemStack(Items.apple,10),
																				new ItemStack(Items.boat,1),
																				new ItemStack(Items.beef,10)};
		
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(8,17));	
		timeSchedule.setWorkTime(1, new RangeInt(8,17));	
		timeSchedule.setWorkTime(2, new RangeInt(8,17));	
		timeSchedule.setWorkTime(3, new RangeInt(8,17));	
		timeSchedule.setWorkTime(4, new RangeInt(8,17));	
		timeSchedule.setWorkTime(5, new RangeInt(9,12));	
		timeSchedule.setWorkTime(6, new RangeInt(9,12));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}
	

}
