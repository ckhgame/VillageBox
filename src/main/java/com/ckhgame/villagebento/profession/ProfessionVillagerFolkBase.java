package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.util.tool.VBRandom;
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

public abstract class ProfessionVillagerFolkBase extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.villagerfolk.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.villagerfolk.description");
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

        VillagerQuestDesign design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerelder.quest0"),0);
        design.addNeeds(Items.apple, 2, 0);
        design.addNeeds(Blocks.log, 5, 0);
        design.addNeeds(Blocks.log, 5, 1);
        design.addRewards(ModItems.itemVillageCurrency, 1, 40);
        design.addRewards(ModItems.itemVillageCurrency, 1, 50);
        compQuest.addQuestDesign(design);
        
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerelder.quest1"),0);
        design.addNeeds(Items.rotten_flesh, 5, 0);
        design.addRewards(ModItems.itemVillageCurrency, 1, 50);
        compQuest.addQuestDesign(design);
        
        components.add(compQuest);
        
        
        //buy & sell
        //params:
        //1.Block or Item 2. min 3.max 4.minlevel  5.meta
        
        //buy list
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        
        //sell list
        VillagerCompSell compSell = new VillagerCompSell(villager);
        
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

		villagerChat.add(0, StatCollector.translateToLocal("villager.villagerfolk.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.villagerfolk.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.villagerfolk.chat2"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.villagerfolk.chat3"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.villagerfolk.chat4"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.villagerfolk.chat5"));
		
	}
	
	@Override
	protected void setTimeSchedule(){			
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}
	

}
