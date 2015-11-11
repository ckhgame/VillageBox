package com.ckhgame.villagebento.misc;

import java.util.HashMap;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ItemPrice {
	
	
	public static void init(){
		register(Blocks.log,2);
		register(Blocks.log2,2);
		register(Blocks.cobblestone,2);
		
		register(Items.rotten_flesh,4);
		register(ModBlocks.blockArchitectsHome,250);
		register(ModBlocks.blockMiningHouse,100);
		register(ModBlocks.blockSmallBakery,70);
		register(ModBlocks.blockFishingStore,150);
		
		register(Items.bread,10);
		register(Items.wheat_seeds,4);
		
		register(Items.cooked_fished,10);
		register(Items.fishing_rod,50);
		register(Items.fish,6);
		
		//examples:
		//register(Items.book,10);
		//register(Blocks.bedrock,10);
		//register(ModItems.itemVillageStick,999);
		//register(ModBlocks.blockGroundworkOnlySmall,100);
		
		
		register(Items.iron_pickaxe,64);
		register(Items.golden_pickaxe,98);
		register(Items.diamond_pickaxe,126);
		register(Blocks.ladder,3);
		register(Blocks.rail,6);
		register(Items.compass,122);
		register(Blocks.torch,3);
		register(Items.minecart,76);
		register(Items.iron_sword,58);
		register(Items.iron_axe,62);
		register(Items.golden_sword,86);
		register(Items.golden_axe,92);
		register(Items.iron_ingot,18);
		register(Items.gold_ingot,30);
		register(Items.iron_hoe,64);
		register(Items.golden_hoe,98);
		register(Items.bow,45);
		register(Items.arrow,15);
		register(Items.leather,30);
		register(Items.porkchop,20);
		register(Items.beef,25);
		register(Items.stick,2);
		
		register(Items.reeds,10);
		register(Items.wheat,12);
		register(Items.apple,18);
		register(Items.golden_apple,48);
		register(Blocks.melon_block,26);
		register(Blocks.pumpkin,22);
		register(Items.carrot,18);
		register(Items.golden_carrot,38);
		register(Items.potato,18);
		register(Items.cake,36);
		register(Items.pumpkin_pie,32);
		register(Items.baked_potato,20);
		register(Items.cookie,18);
		
		register(Blocks.wool,24);
		register(Items.egg,24);
		register(Items.milk_bucket,28);
		register(Items.feather,16);
		register(Items.string,16);
		register(Items.lead,26);
		
		register(Items.pumpkin_seeds,12);
		register(Items.melon_seeds,12);
		
		register(Items.glass_bottle,10);
		register(Items.flower_pot,15);
		register(Items.potionitem,180);
		register(Items.experience_bottle,240);
		
		
		register(ModBlocks.blockGroundworkOnlySmall,200);
		register(ModBlocks.blockBuildingDestroyer,400);
		register(ModBlocks.blockBlackSmithsShop,360);
		register(ModBlocks.blockSmallHotel,420);
		register(ModBlocks.blockHunterHouse,420);
		register(ModBlocks.blockSmallTavern,480);
		register(ModBlocks.blockSmallMilitaryCamp,420);
		register(ModBlocks.blockSmallCasino,520);
		register(ModBlocks.blockDefenceTower,320);
		register(ModBlocks.blockFarmland,520);
		register(ModBlocks.blockMarket,440);
		register(ModBlocks.blockChickenShop,420);
		register(ModBlocks.blockSheepShop,460);
		register(ModBlocks.blockCowShop,480);
		register(ModBlocks.blockProArchitectsHouse,648);
		register(ModBlocks.blockGroundworkOnlyMedium,500);
		
		register(ModBlocks.blockLargeBakery,780);
		register(ModBlocks.blockFlowerShop,780);
		register(ModBlocks.blockPotionStore,860);
		register(ModBlocks.blockLargeMilitaryCamp,880);
		register(ModBlocks.blockLargeHotel,890);
		register(ModBlocks.blockLargeTavern,890);
		register(ModBlocks.blockLargeCasino,1200);
		
		
		//Decorations
		register(ModBlocks.blockSunflower,280);
		register(ModBlocks.blockTeaChair,320);
		register(ModBlocks.blockAutumnGarden,340);
		register(ModBlocks.blockPeacefulGarden,280);
		register(ModBlocks.blockRoseBridge,340);
		register(ModBlocks.blockRosePath,380);
		register(ModBlocks.blockChristmas,380);
		

	}
	
	
	
	
	
	
	
	
	
	private static HashMap<Item,Integer> mapItemPrice = new HashMap<Item,Integer>();
	
	private static void register(Item item, int price){
		mapItemPrice.put(item, Math.max(0, price));
	}
	
	private static void register(Block block, int price){
		register(Item.getItemFromBlock(block),price);
	}
	
	public static int getPrice(Item item){
		if(mapItemPrice.containsKey(item))
			return mapItemPrice.get(item);
		else
			return 0;
	}
	
	public static int getPrice(Block block){
		return getPrice(Item.getItemFromBlock(block));
	}
	
	public static int getSellPrice(Item item){
		return (int)Math.ceil(getPrice(item) * 0.5);
	}
	
	public static int getSellPrice(Block block){
		return getSellPrice(Item.getItemFromBlock(block));
	}
	
	public static int getBuyPrice(Item item){
		return getPrice(item);
	}
	
	public static int getBuyPrice(Block block){
		return getBuyPrice(Item.getItemFromBlock(block));
	}
}
