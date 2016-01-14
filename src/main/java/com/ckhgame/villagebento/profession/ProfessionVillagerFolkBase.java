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
import net.minecraft.item.Item;
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
        VillagerQuestDesign design = null;
        
        //easy - food
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasyFood"),0,3);
        design.addNeeds(Items.cake,1,0);	design.addNeeds(Items.bread,5,0);	design.addNeeds(Items.cookie,5,0);
        design.addNeeds(Items.pumpkin_pie,2,0);	design.addNeeds(Items.cooked_fished,5,0);	design.addNeeds(Items.cooked_fished,5,1);
        design.addNeeds(Items.baked_potato,5,0); design.addNeeds(Items.cooked_chicken,3,0); design.addNeeds(Items.cooked_beef,3,0); 
        design.addNeeds(Items.cooked_porkchop,3,0); design.addNeeds(Items.mushroom_stew, 2, 0);
        design.addNeeds(Items.apple,3,0);
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //easy - hunting
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasyHunting"),0,3);
        design.addNeeds(Items.beef,3,0);	design.addNeeds(Items.porkchop,3,0);	design.addNeeds(Items.chicken,3,0);
        design.addNeeds(Items.leather,2,0);
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //easy - slaying
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasySlaying"),0,3);
        design.addNeeds(Items.rotten_flesh,8,0);	design.addNeeds(Items.bone,5,0);	design.addNeeds(Items.spider_eye,3,0);
        design.addNeeds(Items.gunpowder,3,0);
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //easy - fishing
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasyFishing"),0,3);
        design.addNeeds(Items.fish,3,0);	design.addNeeds(Items.fish,3,1);	design.addNeeds(Items.fish,3,2);
        design.addNeeds(Items.fish,3,3);
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //easy - gathering
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasyGathering"),0,3);
        design.addNeeds(Blocks.red_flower,5,0);	 design.addNeeds(Blocks.red_flower,5,1); design.addNeeds(Blocks.red_flower,5,2);
        design.addNeeds(Blocks.red_flower,5,3);	 design.addNeeds(Blocks.red_flower,5,4); design.addNeeds(Blocks.red_flower,5,5);
        design.addNeeds(Blocks.red_flower,5,6);	 design.addNeeds(Blocks.red_flower,5,7); design.addNeeds(Blocks.red_flower,5,8);
        design.addNeeds(Blocks.yellow_flower,5,0); 
        design.addNeeds(Blocks.double_plant,2,0); design.addNeeds(Blocks.double_plant,2,1); design.addNeeds(Blocks.double_plant,2,4);
        design.addNeeds(Blocks.double_plant,2,5);
        design.addNeeds(Blocks.brown_mushroom,3,0);design.addNeeds(Blocks.red_mushroom,3,0);
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //easy - mining
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasyMining"),0,3);
        design.addNeeds(Items.coal,15,0);	 design.addNeeds(Items.iron_ingot,5,0); 
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //easy - farming
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasyFarming"),0,3);
        design.addNeeds(Items.wheat,5,0);	 design.addNeeds(Items.potato,5,0); design.addNeeds(Items.carrot,5,0); 
        design.addNeeds(Blocks.pumpkin,2,0); design.addNeeds(Items.reeds,6,0); design.addNeeds(Blocks.melon_block,1,0); 
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //easy - feeding
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questEasyFeeding"),0,3);
        design.addNeeds(Items.egg,5,0);	 design.addNeeds(ModItems.itemBottleOfMilk,5,0); design.addNeeds(Blocks.wool,5,0); 
        addEasyQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //-------------------------------------------
        
        //advanced - food
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questAdvFood"),0,1);
        design.addNeeds(ModItems.itemCarrotCake,2,0);	 design.addNeeds(ModItems.itemUdon,2,0);design.addNeeds(ModItems.itemBoiledEgg,5,0);	 
        design.addNeeds(ModItems.itemCreamyCorn,3,0);	 design.addNeeds(ModItems.itemFries,3,0);	 design.addNeeds(ModItems.itemCongee,2,0);	 
        design.addNeeds(ModItems.itemCockTail,2,0);	 design.addNeeds(ModItems.itemAppleCandy,5,0);	 
        addAdvancedQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //advanced - potion
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questAdvPotion"),0,1);
        design.addNeeds(Items.potionitem,1,8197);	
        addAdvancedQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //advanced - mining
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questAdvMining"),0,1);
        design.addNeeds(Items.gold_ingot,5,0);	 design.addNeeds(Items.redstone,30,0);
        addAdvancedQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //advanced - farming
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questAdvFarming"),0,1);
        design.addNeeds(ModItems.itemChili,3,0);design.addNeeds(ModItems.itemSoybeans,3,0);design.addNeeds(ModItems.itemGrapes,3,0);
        design.addNeeds(ModItems.itemRiceplant,5,0);design.addNeeds(ModItems.itemCorn,5,0);design.addNeeds(ModItems.itemCabbage,5,0);
        addAdvancedQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        //advanced - feeding
        design = new VillagerQuestDesign(StatCollector.translateToLocal("villager.villagerfolk.questAdvFeeding"),0,1);
        design.addNeeds(ModItems.itemVillageWool,3,0);design.addNeeds(ModItems.itemVillageEgg,3,0);design.addNeeds(ModItems.itemVillageHeartEgg,3,0);
        design.addNeeds(ModItems.itemVillageMilk,3,0);
        addAdvancedQuestRewards(design);
        compQuest.addQuestDesign(design);
        
        components.add(compQuest);
	}
	
	private void addEasyQuestRewards(VillagerQuestDesign design){
		design.addRewards(ModItems.itemVillageCurrency, 1, 40);
		design.addRewards(ModItems.itemVillageCurrency, 1, 40);
		design.addRewards(ModItems.itemVillageCurrency, 1, 40);
		design.addRewards(ModItems.itemVillageCurrency, 1, 50);
		design.addRewards(ModItems.itemVillageCurrency, 1, 50);
		design.addRewards(ModItems.itemVillageCurrency, 1, 50);
		design.addRewards(ModItems.itemVillageCurrency, 1, 60);
		design.addRewards(ModItems.itemVillageCurrency, 1, 60);
		design.addRewards(ModItems.itemVillageCurrency, 1, 60);
		design.addRewards(ModBlocks.blockFolkHouse, 1, 0);//10%
	}
	
	private void addAdvancedQuestRewards(VillagerQuestDesign design){
		design.addRewards(ModItems.itemVillageCurrency, 1, 100);
		design.addRewards(ModItems.itemVillageCurrency, 1, 110);
		design.addRewards(ModItems.itemVillageCurrency, 1, 120);
		design.addRewards(ModItems.itemVillageCurrency, 1, 90);
		design.addRewards(ModBlocks.blockFolkHouse, 1, 0);//20%
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "villager.villagerfolk.chat0");
		villagerChat.add(0, "villager.villagerfolk.chat1");
		villagerChat.add(0, "villager.villagerfolk.chat2");
		villagerChat.add(0, "villager.villagerfolk.chat3");
		villagerChat.add(0, "villager.villagerfolk.chat4");
		villagerChat.add(0, "villager.villagerfolk.chat5");
		villagerChat.add(0, "villager.villagerfolk.chat6");
		villagerChat.add(0, "villager.villagerfolk.chat7");
		villagerChat.add(0, "villager.villagerfolk.chat8");
		villagerChat.add(0, "villager.villagerfolk.chat9");
	}
	
	@Override
	protected void setTimeSchedule(){			
		
		//a trick way to avoid that the folks stay on tavern forever
		timeSchedule.setWorkTime(0, new RangeInt(7,8));		//Monday
		timeSchedule.setWorkTime(1, new RangeInt(7,8));		//Tuesday
		timeSchedule.setWorkTime(2, new RangeInt(7,8));		//Wednesday
		timeSchedule.setWorkTime(3, new RangeInt(7,8));		//Thursday
		timeSchedule.setWorkTime(4, new RangeInt(7,8));		//Friday
		timeSchedule.setWorkTime(5, new RangeInt(7,8));		//Saturday
		timeSchedule.setWorkTime(6, new RangeInt(7,8));		//Sunday
		
		timeSchedule.setSleeptime(new RangeInt(22,31));
	}
	

}
