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
		
		register(Blocks.log,24);
		register(Blocks.log2,24);
		register(Blocks.cobblestone,10);
		
		register(ModItems.itemVillageStick,100);
		
		register(Items.bread,80);
		
		//Fishing
		register(Items.cooked_fished,80);
		register(Items.fishing_rod,240);
		register(ModItems.itemFishingRodIron,2500);
		register(ModItems.itemFishingRodGold,5000);
		register(ModItems.itemFishingRodDiamond,12000);
		register(Items.fish,200);		
		
		register(Items.iron_pickaxe,960);
		register(Items.golden_pickaxe,1500);
		register(Items.diamond_pickaxe,15000);
		register(Blocks.ladder,50);
		register(Blocks.rail,100);
		register(Items.compass,600);
		register(Blocks.torch,50);
		register(Items.minecart,600);
		register(Items.iron_sword,640);
		register(Items.iron_axe,960);
		register(Items.golden_sword,1000);
		register(Items.golden_axe,1500);
		register(Items.iron_hoe,640);
		register(Items.golden_hoe,960);
		register(Items.bow,240);
		register(Items.arrow,80);
		register(Items.leather,300);
		register(Items.porkchop,250);
		register(Items.beef,300);
		register(Items.stick,25);
		
		register(Items.flint,12);
		register(Items.coal,120);
		register(Items.iron_ingot,260);
		register(Items.gold_ingot,420);
		
		register(Items.paper,150);
		
		register(Items.reeds,30);
		register(Items.wheat,30);
		register(Items.apple,180);
		register(Items.golden_apple,1000);
		register(Blocks.melon_block,60);
		register(Blocks.pumpkin,60);
		register(Items.carrot,30);
		register(Items.golden_carrot,500);
		register(Items.potato,30);
		register(Items.cake,600);
		register(Items.pumpkin_pie,200);
		register(Items.baked_potato,80);
		register(Items.cookie,70);
		
		register(Blocks.wool,30);
		register(Items.egg,30);
		register(ModItems.itemBottleOfMilk,30);
		register(Items.feather,260);
		register(Items.string,100);
		register(Items.lead,500);
		
		
		register(Items.glass_bottle,10);
		register(Items.flower_pot,200);
		register(Items.potionitem,900);
		register(Items.experience_bottle,2400);
		
		//Village Building Blocks
		register(ModBlocks.blockSmallBakery,150);
		register(ModBlocks.blockFishingStore,300);
		register(ModBlocks.blockBlackSmithsShop,750);
		register(ModBlocks.blockBuildersHome,750);
		register(ModBlocks.blockMarket,750);
		register(ModBlocks.blockHunterHouse,1000);
		register(ModBlocks.blockMiningHouse,1000);	
		
		register(ModBlocks.blockFolkHouse,5000);		
		register(ModBlocks.blockFarmland,4500);
		register(ModBlocks.blockChickenShop,4500);
		register(ModBlocks.blockSheepShop,4500);
		register(ModBlocks.blockCowShop,4500);
		register(ModBlocks.blockLibrary,10000);
		register(ModBlocks.blockSmallMilitaryCamp,10000);
		register(ModBlocks.blockSmallHotel,24000);
		register(ModBlocks.blockSmallTavern,24000);
		register(ModBlocks.blockPotionStore,25000);
		register(ModBlocks.blockChurch,30000);
		
		register(ModBlocks.blockLargeBakery,60000);
		register(ModBlocks.blockFlowerShop,70000);
		register(ModBlocks.blockFurnitureStore,80000);
		register(ModBlocks.blockSmallCasino,60000);
		register(ModBlocks.blockTailorStore,80000);

		// Builder's House
		register(ModBlocks.blockPlayerFieldSmall,1000);
		register(ModBlocks.blockDefenceTower,3000);
		register(ModBlocks.blockTownSquareSmall,5000);
		register(ModBlocks.blockPlayerFieldMedium,20000);
		register(ModBlocks.blockTownSquareLarge,30000);
		
		//misc
		register(ModBlocks.blockVillagerHomeTP,5000);
		register(ModBlocks.blockBuildingDestroyer,30000);
		
		//Furniture Store
		register(Blocks.bookshelf,2500);
		register(Items.bed,1000);
		register(Blocks.chest,500);
		register(ModBlocks.blockWineBucket,5000);
		register(ModBlocks.blockWineShelf,5000);
		register(ModBlocks.blockOakChair,3000);
		register(ModBlocks.blockOakTable,4000);
		register(ModBlocks.blockBirchChair,3000);
		register(ModBlocks.blockBirchTable,4000);

			
		//Large Buildings
		//register(ModBlocks.blockLargeMilitaryCamp,880);
		//register(ModBlocks.blockLargeHotel,890);
		//register(ModBlocks.blockLargeTavern,890);
		//register(ModBlocks.blockLargeCasino,1200);
		
		
		//Decorations
		register(ModBlocks.blockSunflower,12000);
		register(ModBlocks.blockTeaChair,15000);
		register(ModBlocks.blockAutumnGarden,17500);
		register(ModBlocks.blockPeacefulGarden,22000);
		register(ModBlocks.blockRoseBridge,26000);
		register(ModBlocks.blockRosePath,30000);
		register(ModBlocks.blockChristmas,42000);
		
		
		//Animals
		register(ModBlocks.blockChicken,2000);
		register(ModBlocks.blockCow,3000);
		register(ModBlocks.blockSheep,3000);
		register(ModItems.itemChickenFood,30);
		register(ModItems.itemSheepFood,40);
		register(ModItems.itemCowFood,40);
		register(ModItems.itemChickenPotion,1500);
		register(ModItems.itemSheepPotion,1500);
		register(ModItems.itemCowPotion,1500);
		register(ModItems.itemChickenGloves,200);
		register(ModItems.itemWoolShears,200);
		register(ModItems.itemMilkBottle,5);
		register(ModItems.itemVillageEgg,560);
		register(ModItems.itemVillageHeartEgg,800);
		register(ModItems.itemVillageSilverEgg,1500);
		register(ModItems.itemVillageGoldenEgg,2000);
		register(ModItems.itemVillageEasterEgg,1000);
		register(ModItems.itemVillageMilk,1200);
		register(ModItems.itemVillageWool,1200);
				
		register(ModItems.itemGauze,500);
		register(ModItems.itemSeaweed,600);

		//Seeds
		register(Items.wheat_seeds,20);
		register(Items.pumpkin_seeds,100);
		register(Items.melon_seeds,100);
		register(ModItems.itemCabbageSeed,200);
		register(ModItems.itemRiceSeed,200);
		register(ModItems.itemCornSeed,200);
		register(ModItems.itemChiliSeed,300);
		register(ModItems.itemGrapeSeed,300);
		register(ModItems.itemSoybeanSeed,300);

		//Crops
		register(ModItems.itemRiceplant,600);
		register(ModItems.itemCorn,600);
		register(ModItems.itemCabbage,600);
		register(ModItems.itemSoybeans,900);
		register(ModItems.itemChili,900);
		register(ModItems.itemGrapes,900);
		
		//Food
		register(ModItems.itemAppleCandy,300);
		register(ModItems.itemBoiledEgg,500);
		register(ModItems.itemCarrotCake,400);
		register(ModItems.itemCheese,300);
		register(ModItems.itemFries,400);
		register(ModItems.itemHambuger,300);
		register(ModItems.itemMayonaise,300);
		register(ModItems.itemMelonIce,500);
		register(ModItems.itemPorkRamen,800);
		register(ModItems.itemRice,300);
		register(ModItems.itemRiceFlour,400);
		register(ModItems.itemSalt,300);
		register(ModItems.itemUdon,400);
		register(ModItems.itemWheatFlour,300);				
		register(ModItems.itemNoodleSoup,600);
		register(ModItems.itemBeefNoodleSoup,500);
		register(ModItems.itemBoiledFish,800);
		register(ModItems.itemBouquetLamb,760);
		register(ModItems.itemCongee,500);
		register(ModItems.itemCornChips,300);
		register(ModItems.itemCreamyCorn,300);
		register(ModItems.itemMapoTofu,520);
		register(ModItems.itemNigiri,520);
		register(ModItems.itemOil,300);
		register(ModItems.itemSoySauce,400);
		register(ModItems.itemTofu,300);
				
		//Wine
		register(ModItems.itemCockTail,840);
		register(ModItems.itemBeer,800);
		register(ModItems.itemGrapeVine,920);
		register(ModItems.itemWhisky,1080);
		register(ModItems.itemVodka,1360);
		register(ModItems.itemCookVine,600);
		
		//Books
		register(ModItems.itemCookingBookI,900);
		register(ModItems.itemCookingBookII,1520);
		register(ModItems.itemAnimalBook,1560);
		register(ModItems.itemPlantBook,1600);
		register(ModItems.itemBuildingsBook,2200);
		register(ModItems.itemNPCBook,1800);
		
		//carpets
		register(ModBlocks.blockVillageCarpet,2000);
		register(ModBlocks.blockVillageCarpet1,5000);
		register(ModBlocks.blockVillageCarpet2,5000);
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
