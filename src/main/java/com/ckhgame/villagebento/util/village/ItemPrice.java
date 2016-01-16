package com.ckhgame.villagebento.util.village;

import java.util.HashMap;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ItemPrice {
	
	
	public static void init(){
		
		//examples:
		//register(Items.book,10);
		//register(Blocks.bedrock,10);
		//register(ModItems.itemVillageStick,999);
		//register(ModBlocks.blockGroundworkOnlySmall,100);
		
		register(Blocks.log,4);
		register(Blocks.log2,4);
		register(Blocks.cobblestone,2);
		
		register(Items.rotten_flesh,4);
		
		register(Items.bread,20);
		
		//Fishing
		register(Items.cooked_fished,20);
		register(Items.fishing_rod,50);
		register(ModItems.itemFishingRodIron,200);
		register(ModItems.itemFishingRodGold,400);
		register(ModItems.itemFishingRodDiamond,800);
		register(Items.fish,20);		
		
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
		register(Items.iron_hoe,64);
		register(Items.golden_hoe,98);
		register(Items.bow,45);
		register(Items.arrow,15);
		register(Items.leather,30);
		register(Items.porkchop,20);
		register(Items.beef,25);
		register(Items.stick,2);
		
		register(Items.flint,8);
		register(Items.coal,12);
		register(Items.iron_ingot,24);
		register(Items.gold_ingot,48);
		
		register(Items.paper,4);
		
		register(Items.reeds,6);
		register(Items.wheat,6);
		register(Items.apple,18);
		register(Items.golden_apple,100);
		register(Blocks.melon_block,6);
		register(Blocks.pumpkin,6);
		register(Items.carrot,4);
		register(Items.golden_carrot,100);
		register(Items.potato,4);
		register(Items.cake,36);
		register(Items.pumpkin_pie,32);
		register(Items.baked_potato,20);
		register(Items.cookie,18);
		
		register(Blocks.wool,4);
		register(Items.egg,4);
		register(ModItems.itemBottleOfMilk,4);
		register(Items.feather,16);
		register(Items.string,16);
		register(Items.lead,26);
		
		
		register(Items.glass_bottle,10);
		register(Items.flower_pot,15);
		register(Items.potionitem,180);
		register(Items.experience_bottle,240);
		
		//Village Building Blocks
		register(ModBlocks.blockSmallBakery,50);
		register(ModBlocks.blockFishingStore,100);
		register(ModBlocks.blockBlackSmithsShop,150);
		register(ModBlocks.blockBuildersHome,150);
		register(ModBlocks.blockMarket,150);
		register(ModBlocks.blockHunterHouse,200);
		register(ModBlocks.blockMiningHouse,200);	
		
		register(ModBlocks.blockFolkHouse,300);		
		register(ModBlocks.blockFarmland,350);
		register(ModBlocks.blockChickenShop,350);
		register(ModBlocks.blockSheepShop,350);
		register(ModBlocks.blockCowShop,350);
		register(ModBlocks.blockLibrary,500);
		register(ModBlocks.blockSmallMilitaryCamp,500);
		register(ModBlocks.blockSmallHotel,700);
		register(ModBlocks.blockSmallTavern,700);
		register(ModBlocks.blockPotionStore,700);
		register(ModBlocks.blockChurch,800);
		
		register(ModBlocks.blockLargeBakery,1000);
		register(ModBlocks.blockFlowerShop,1000);
		register(ModBlocks.blockFurnitureStore,1000);
		register(ModBlocks.blockSmallCasino,1000);
		register(ModBlocks.blockTailorStore,1000);

		// Builder's House
		register(ModBlocks.blockPlayerFieldSmall,150);
		register(ModBlocks.blockDefenceTower,250);
		register(ModBlocks.blockTownSquareSmall,300);
		register(ModBlocks.blockPlayerFieldMedium,500);
		register(ModBlocks.blockTownSquareLarge,800);
		register(ModBlocks.blockBuildingDestroyer,400);
		
		//misc
		register(ModBlocks.blockVillagerHomeTP,500);
		register(ModBlocks.blockBuildingDestroyer,1000);
		
		//Furniture Store
		register(Blocks.bookshelf,100);
		register(Items.bed,100);
		register(Blocks.chest,100);
		register(ModBlocks.blockWineBucket,200);
		register(ModBlocks.blockWineShelf,250);
		register(ModBlocks.blockOakChair,300);
		register(ModBlocks.blockOakTable,500);
		register(ModBlocks.blockBirchChair,300);
		register(ModBlocks.blockBirchTable,500);

			
		//Large Buildings
		register(ModBlocks.blockLargeMilitaryCamp,880);
		register(ModBlocks.blockLargeHotel,890);
		register(ModBlocks.blockLargeTavern,890);
		register(ModBlocks.blockLargeCasino,1200);
		
		
		//Decorations
		register(ModBlocks.blockSunflower,180);
		register(ModBlocks.blockTeaChair,220);
		register(ModBlocks.blockAutumnGarden,280);
		register(ModBlocks.blockPeacefulGarden,180);
		register(ModBlocks.blockRoseBridge,220);
		register(ModBlocks.blockRosePath,280);
		register(ModBlocks.blockChristmas,280);
		
		
		//Animals
		register(ModBlocks.blockChicken,200);
		register(ModBlocks.blockCow,300);
		register(ModBlocks.blockSheep,300);
		register(ModItems.itemChickenFood,2);
		register(ModItems.itemSheepFood,3);
		register(ModItems.itemCowFood,3);
		register(ModItems.itemChickenPotion,150);
		register(ModItems.itemSheepPotion,150);
		register(ModItems.itemCowPotion,150);
		register(ModItems.itemChickenGloves,200);
		register(ModItems.itemWoolShears,200);
		register(ModItems.itemMilkBottle,5);
		register(ModItems.itemVillageEgg,20);
		register(ModItems.itemVillageHeartEgg,30);
		register(ModItems.itemVillageSilverEgg,25);
		register(ModItems.itemVillageGoldenEgg,100);
		register(ModItems.itemVillageEasterEgg,50);
		register(ModItems.itemVillageMilk,40);
		register(ModItems.itemVillageWool,36);
				
		register(ModItems.itemGauze,4);
		register(ModItems.itemSeaweed,8);

		//Seeds
		register(Items.wheat_seeds,4);
		register(Items.pumpkin_seeds,20);
		register(Items.melon_seeds,20);
		register(ModItems.itemCabbageSeed,14);
		register(ModItems.itemGrapeSeed,28);
		register(ModItems.itemCornSeed,14);
		register(ModItems.itemChiliSeed,24);
		register(ModItems.itemRiceSeed,16);
		register(ModItems.itemSoybeanSeed,20);

		//Crops
		register(ModItems.itemCabbage,30);
		register(ModItems.itemChili,50);
		register(ModItems.itemGrapes,80);
		register(ModItems.itemRiceplant,30);
		register(ModItems.itemSoybeans,40);
		register(ModItems.itemCorn,30);
		
		//Food
		register(ModItems.itemAppleCandy,30);
		register(ModItems.itemBoiledEgg,50);
		register(ModItems.itemCarrotCake,40);
		register(ModItems.itemCheese,30);
		register(ModItems.itemFries,40);
		register(ModItems.itemHambuger,30);
		register(ModItems.itemMayonaise,30);
		register(ModItems.itemMelonIce,50);
		register(ModItems.itemPorkRamen,80);
		register(ModItems.itemRice,30);
		register(ModItems.itemRiceFlour,40);
		register(ModItems.itemSalt,30);
		register(ModItems.itemUdon,40);
		register(ModItems.itemWheatFlour,30);				
		register(ModItems.itemNoodleSoup,60);
		register(ModItems.itemBeefNoodleSoup,50);
		register(ModItems.itemBoiledFish,80);
		register(ModItems.itemBouquetLamb,76);
		register(ModItems.itemCongee,50);
		register(ModItems.itemCornChips,30);
		register(ModItems.itemCreamyCorn,30);
		register(ModItems.itemMapoTofu,52);
		register(ModItems.itemNigiri,52);
		register(ModItems.itemOil,30);
		register(ModItems.itemSoySauce,40);
		register(ModItems.itemTofu,30);
				
		//Wine
		register(ModItems.itemCockTail,42);
		register(ModItems.itemBeer,40);
		register(ModItems.itemGrapeVine,46);
		register(ModItems.itemWhisky,54);
		register(ModItems.itemVodka,68);
		register(ModItems.itemCookVine,30);
		
		//Books
		register(ModItems.itemCookingBookI,30);
		register(ModItems.itemCookingBookII,52);
		register(ModItems.itemAnimalBook,52);
		register(ModItems.itemPlantBook,52);
		register(ModItems.itemBuildingsBook,68);
		register(ModItems.itemNPCBook,64);
		
		
		
		
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
