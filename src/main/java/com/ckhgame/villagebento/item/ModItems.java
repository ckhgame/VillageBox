package com.ckhgame.villagebento.item;


import com.ckhgame.villagebento.block.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {
  
	public static Item itemVillageStick;
	public static Item itemVillageCurrency;
	//animals
	public static Item itemChickenPotion;
	public static Item itemChickenFood;
	public static Item itemVillageEgg;
	public static Item itemChickenGloves;
	public static Item itemVillageGoldenEgg;
	public static Item itemVillageSilverEgg;
	public static Item itemVillageHeartEgg;
	public static Item itemVillageEasterEgg;
	public static Item itemSheepPotion;
	public static Item itemSheepFood;
	public static Item itemWoolShears;
	public static Item itemVillageWool;
	public static Item itemCowPotion;
	public static Item itemCowFood;
	public static Item itemMilkBottle;
	public static Item itemVillageMilk;
	public static Item itemGauze;
	public static Item itemSeaweed;
	public static Item itemBottleOfMilk; // buket of milk -> 2 bottle of milk
	
	//seeds
	public static Item itemCabbageSeed;
	public static Item itemGrapeSeed;
	public static Item itemCornSeed;
	public static Item itemChiliSeed;
	public static Item itemRiceSeed;
	public static Item itemSoybeanSeed;
	
	//crops
	public static Item itemCabbage;
	public static Item itemChili;
	public static Item itemGrapes;
	public static Item itemRiceplant;
	public static Item itemSoybeans;
	public static Item itemCorn;
	
	//food
	public static Item itemAppleCandy;
	public static Item itemBoiledEgg;
	public static Item itemCarrotCake;
	public static Item itemCheese;
	public static Item itemFries;
	public static Item itemHambuger;
	public static Item itemMayonaise;
	public static Item itemMelonIce;
	public static Item itemPorkRamen;
	public static Item itemRice;
	public static Item itemRiceFlour;
	public static Item itemSalt;
	public static Item itemUdon;
	public static Item itemWheatFlour;
	
	public static Item itemNoodleSoup;
	public static Item itemBeefNoodleSoup;
	public static Item itemBoiledFish;
	public static Item itemBouquetLamb;
	public static Item itemCongee;
	public static Item itemCornChips;
	public static Item itemCreamyCorn;
	public static Item itemMapoTofu;
	public static Item itemNigiri;
	public static Item itemOil;
	public static Item itemSoySauce;
	public static Item itemTofu;
	
	//Wine
	public static Item itemCockTail;
	public static Item itemBeer;
	public static Item itemGrapeVine;
	public static Item itemWhisky;
	public static Item itemVodka;
	public static Item itemCookVine;
	
	//Fishing
	public static Item itemIronBox;
	public static Item itemGoldenBox;
	public static Item itemDiamondBox;
	public static Item itemFishingRodIron;
	public static Item itemFishingRodGold;
	public static Item itemFishingRodDiamond;
	
	//Books
	public static Item itemPlantBook;
	public static Item itemAnimalBook;
	public static Item itemCookingBookI;
	public static Item itemCookingBookII;
	public static Item itemBuildingsBook;
	public static Item itemNPCBook;
	

	
	
	
	public static final void init() {
        GameRegistry.registerItem(itemVillageStick = new ItemVillageStick(), "ItemVillageStick");
        GameRegistry.registerItem(itemVillageCurrency = new ItemVillageCurrency(), "ItemVillageCurrency");
        
        //animal
        GameRegistry.registerItem(itemChickenPotion = new ItemVB("ItemChickenPotion",null,CreativeTabs.tabMisc),"ItemChickenPotion");
        GameRegistry.registerItem(itemChickenFood = new ItemVB("ItemChickenFood",null,CreativeTabs.tabMisc),"ItemChickenFood");
        GameRegistry.registerItem(itemChickenGloves = new ItemVB("ItemChickenGloves","It's the love",CreativeTabs.tabTools),"ItemChickenGloves");
        GameRegistry.registerItem(itemVillageEgg = new ItemVB("ItemVillageEgg",null,CreativeTabs.tabMaterials),"ItemVillageEgg");
        GameRegistry.registerItem(itemVillageHeartEgg = new ItemVB("ItemVillageHeartEgg",null,CreativeTabs.tabMaterials),"ItemVillageHeartEgg");
        GameRegistry.registerItem(itemVillageSilverEgg = new ItemVB("ItemVillageSilverEgg",null,CreativeTabs.tabMaterials),"ItemVillageSilverEgg");
        GameRegistry.registerItem(itemVillageGoldenEgg = new ItemVB("ItemVillageGoldenEgg",null,CreativeTabs.tabMaterials),"ItemVillageGoldenEgg");
        GameRegistry.registerItem(itemVillageEasterEgg = new ItemVB("ItemVillageEasterEgg",null,CreativeTabs.tabMaterials),"ItemVillageEasterEgg");
        
        GameRegistry.registerItem(itemSheepPotion = new ItemVB("ItemSheepPotion",null,CreativeTabs.tabMisc),"ItemSheepPotion");
        GameRegistry.registerItem(itemSheepFood = new ItemVB("ItemSheepFood",null,CreativeTabs.tabMisc),"ItemSheepFood");
        GameRegistry.registerItem(itemWoolShears = new ItemVB("ItemWoolShears",null,CreativeTabs.tabTools),"ItemWoolShears");
        GameRegistry.registerItem(itemVillageWool = new ItemVB("ItemVillageWool",null,CreativeTabs.tabMaterials),"ItemVillageWool");
        
        GameRegistry.registerItem(itemCowPotion = new ItemVB("ItemCowPotion",null,CreativeTabs.tabMisc),"ItemCowPotion");
        GameRegistry.registerItem(itemCowFood = new ItemVB("ItemCowFood",null,CreativeTabs.tabMisc),"ItemCowFood");
        GameRegistry.registerItem(itemMilkBottle = new ItemVB("ItemMilkBottle",null,CreativeTabs.tabTools),"ItemMilkBottle");
        GameRegistry.registerItem(itemVillageMilk = new ItemVB("ItemVillageMilk",null,CreativeTabs.tabMaterials),"ItemVillageMilk");
        
        GameRegistry.registerItem(itemGauze = new ItemVB("ItemGauze",null,CreativeTabs.tabMaterials),"ItemGauze");
        GameRegistry.registerItem(itemSeaweed = new ItemVB("ItemSeaweed",null,CreativeTabs.tabMaterials),"ItemSeaweed");
        
        GameRegistry.registerItem(itemBottleOfMilk = new ItemVB("ItemBottleOfMilk",null,CreativeTabs.tabMaterials),"ItemBottleOfMilk");// bucket of milk -> 2 bottle of milk
        

        
        //Seeds
        GameRegistry.registerItem(itemCabbageSeed = new ItemVBSeeds("ItemCabbageSeed",null,CreativeTabs.tabMisc,ModBlocks.blockCabbage),"ItemCabbageSeed");
        GameRegistry.registerItem(itemGrapeSeed = new ItemVBSeeds("ItemGrapeSeed",null,CreativeTabs.tabMisc,ModBlocks.blockGrapes),"ItemGrapeSeed");
        GameRegistry.registerItem(itemCornSeed = new ItemVBSeeds("ItemCornSeed",null,CreativeTabs.tabMisc,ModBlocks.blockCorn),"ItemCornSeed");
        GameRegistry.registerItem(itemChiliSeed = new ItemVBSeeds("ItemChiliSeed",null,CreativeTabs.tabMisc,ModBlocks.blockChili),"ItemChiliSeed");
        GameRegistry.registerItem(itemRiceSeed = new ItemVBSeeds("ItemRiceSeed",null,CreativeTabs.tabMisc,ModBlocks.blockRicePlant),"ItemRiceSeed");
        GameRegistry.registerItem(itemSoybeanSeed = new ItemVBSeeds("ItemSoybeanSeed",null,CreativeTabs.tabMisc,ModBlocks.blockSoybeans),"ItemSoybeanSeed");
        
        //Crops
        GameRegistry.registerItem(itemCabbage = new ItemVB("ItemCabbage",null,CreativeTabs.tabMisc),"ItemCabbage");
        GameRegistry.registerItem(itemChili = new ItemVB("ItemChili",null,CreativeTabs.tabMisc),"ItemChili");
        GameRegistry.registerItem(itemGrapes = new ItemVB("ItemGrapes",null,CreativeTabs.tabMisc),"ItemGrapes");
        GameRegistry.registerItem(itemRiceplant = new ItemVB("ItemRiceplant",null,CreativeTabs.tabMisc),"ItemRiceplant");
        GameRegistry.registerItem(itemSoybeans = new ItemVB("ItemSoybeans",null,CreativeTabs.tabMisc),"ItemSoybeans");
        GameRegistry.registerItem(itemCorn = new ItemVB("ItemCorn",null,CreativeTabs.tabMisc),"ItemCorn");
        
        //Food
        GameRegistry.registerItem(itemAppleCandy = new ItemVB("ItemAppleCandy",null,CreativeTabs.tabFood),"ItemAppleCandy");
        GameRegistry.registerItem(itemBoiledEgg = new ItemVB("ItemBoiledEgg",null,CreativeTabs.tabFood),"ItemBoiledEgg");
        GameRegistry.registerItem(itemCarrotCake = new ItemVB("ItemCarrotCake",null,CreativeTabs.tabFood),"ItemCarrotCake");
        GameRegistry.registerItem(itemCheese = new ItemVB("ItemCheese",null,CreativeTabs.tabFood),"ItemCheese");
        GameRegistry.registerItem(itemFries = new ItemVB("ItemFries",null,CreativeTabs.tabFood),"ItemFries");
        GameRegistry.registerItem(itemHambuger = new ItemVB("ItemHambuger",null,CreativeTabs.tabFood),"ItemHambuger");
        GameRegistry.registerItem(itemMayonaise = new ItemVB("ItemMayonaise",null,CreativeTabs.tabFood),"ItemMayonaise");
        GameRegistry.registerItem(itemMelonIce = new ItemVB("ItemMelonIce",null,CreativeTabs.tabFood),"ItemMelonIce");
        GameRegistry.registerItem(itemPorkRamen = new ItemVB("ItemPorkRamen",null,CreativeTabs.tabFood),"ItemPorkRamen");
        GameRegistry.registerItem(itemRice = new ItemVB("ItemRice",null,CreativeTabs.tabFood),"ItemRice");
        GameRegistry.registerItem(itemRiceFlour = new ItemVB("ItemRiceFlour",null,CreativeTabs.tabMaterials),"ItemRiceFlour");
        GameRegistry.registerItem(itemSalt = new ItemVB("ItemSalt",null,CreativeTabs.tabMaterials),"ItemSalt");
        GameRegistry.registerItem(itemUdon = new ItemVB("ItemUdon",null,CreativeTabs.tabFood),"ItemUdon");
        GameRegistry.registerItem(itemWheatFlour = new ItemVB("ItemWheatFlour",null,CreativeTabs.tabMaterials),"ItemWheatFlour");
        
        
        GameRegistry.registerItem(itemNoodleSoup = new ItemVB("ItemNoodleSoup",null,CreativeTabs.tabFood),"ItemNoodleSoup");
        GameRegistry.registerItem(itemBeefNoodleSoup = new ItemVB("ItemBeefNoodleSoup",null,CreativeTabs.tabFood),"ItemBeefNoodleSoup");
        GameRegistry.registerItem(itemBoiledFish = new ItemVB("ItemBoiledFish",null,CreativeTabs.tabFood),"ItemBoiledFish");
        GameRegistry.registerItem(itemBouquetLamb = new ItemVB("ItemBouquetLamb",null,CreativeTabs.tabFood),"ItemBouquetLamb");
        GameRegistry.registerItem(itemCongee = new ItemVB("ItemCongee",null,CreativeTabs.tabFood),"ItemCongee");
        GameRegistry.registerItem(itemCornChips = new ItemVB("ItemCornChips",null,CreativeTabs.tabFood),"ItemCornChips");
        GameRegistry.registerItem(itemCreamyCorn = new ItemVB("ItemCreamyCorn",null,CreativeTabs.tabFood),"ItemCreamyCorn");
        GameRegistry.registerItem(itemMapoTofu = new ItemVB("ItemMapoTofu",null,CreativeTabs.tabFood),"ItemMapoTofu");
        GameRegistry.registerItem(itemNigiri = new ItemVB("ItemNigiri",null,CreativeTabs.tabFood),"ItemNigiri");
        GameRegistry.registerItem(itemOil = new ItemVB("ItemOil",null,CreativeTabs.tabMaterials),"ItemOil");
        GameRegistry.registerItem(itemSoySauce = new ItemVB("ItemSoySauce",null,CreativeTabs.tabMaterials),"ItemSoySauce");
        GameRegistry.registerItem(itemTofu = new ItemVB("ItemTofu",null,CreativeTabs.tabFood),"itemTofu");
        
        //Wine
        GameRegistry.registerItem(itemCockTail = new ItemVB("ItemCockTail",null,CreativeTabs.tabFood),"ItemCockTail");
        GameRegistry.registerItem(itemCookVine = new ItemVB("ItemCookVine",null,CreativeTabs.tabMaterials),"ItemCookVine");
        GameRegistry.registerItem(itemBeer = new ItemVB("ItemBeer",null,CreativeTabs.tabFood),"ItemBeer");
        GameRegistry.registerItem(itemGrapeVine = new ItemVB("ItemGrapeVine",null,CreativeTabs.tabFood),"ItemGrapeVine");
        GameRegistry.registerItem(itemWhisky = new ItemVB("ItemWhisky",null,CreativeTabs.tabFood),"ItemWhisky");
        GameRegistry.registerItem(itemVodka = new ItemVB("ItemVodka",null,CreativeTabs.tabFood),"ItemVodka");
        
        //Fishing
        GameRegistry.registerItem(itemIronBox = new ItemVBChest("ItemIronBox",null,CreativeTabs.tabMisc,ItemVBChest.randChestIron),"ItemIronBox");
        GameRegistry.registerItem(itemGoldenBox = new ItemVBChest("ItemGoldenBox",null,CreativeTabs.tabMisc,ItemVBChest.randChestGolden),"ItemGoldenBox");
        GameRegistry.registerItem(itemDiamondBox = new ItemVBChest("ItemDiamondBox",null,CreativeTabs.tabMisc,ItemVBChest.randChestDiamond),"ItemDiamondBox");
        GameRegistry.registerItem(itemFishingRodIron = new ItemFishingRodVB("ItemFishingRodIron"), "ItemFishingRodIron");
        GameRegistry.registerItem(itemFishingRodGold = new ItemFishingRodVB("ItemFishingRodGold"), "ItemFishingRodGold");
        GameRegistry.registerItem(itemFishingRodDiamond = new ItemFishingRodVB("ItemFishingRodDiamond"), "ItemFishingRodDiamond");

        //Books
        GameRegistry.registerItem(itemPlantBook = new ItemVBBook("ItemPlantBook",null,CreativeTabs.tabMisc,"PlantBook"),"ItemPlantBook");
        GameRegistry.registerItem(itemAnimalBook = new ItemVBBook("ItemAnimalBook",null,CreativeTabs.tabMisc,"AnimalBook"),"ItemAnimalBook");
        GameRegistry.registerItem(itemCookingBookI = new ItemVBBook("ItemCookingBookI",null,CreativeTabs.tabMisc,"CookingBookI"),"ItemCookingBookI");
        GameRegistry.registerItem(itemCookingBookII = new ItemVBBook("ItemCookingBookII",null,CreativeTabs.tabMisc,"CookingBookII"),"ItemCookingBookII");
        GameRegistry.registerItem(itemBuildingsBook = new ItemVBBook("ItemBuildingsBook",null,CreativeTabs.tabMisc,"BuildingsBook"),"ItemBuildingsBook");
        GameRegistry.registerItem(itemNPCBook = new ItemVBBook("ItemNPCBook",null,CreativeTabs.tabMisc,"NPCBook"),"ItemNPCBook");

        
        
    }
}
