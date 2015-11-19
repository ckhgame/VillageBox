package com.ckhgame.villagebento.item;


import com.ckhgame.villagebento.Main;

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
	public static Item itemGuaze;
	
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
        
        GameRegistry.registerItem(itemGuaze = new ItemVB("itemGuaze",null,CreativeTabs.tabMaterials),"ItemGuaze");
        
        

        
        //Seeds
        GameRegistry.registerItem(itemCabbageSeed = new ItemVB("ItemCabbageSeed",null,CreativeTabs.tabMisc),"ItemCabbageSeed");
        GameRegistry.registerItem(itemGrapeSeed = new ItemVB("ItemGrapeSeed",null,CreativeTabs.tabMisc),"ItemGrapeSeed");
        GameRegistry.registerItem(itemCornSeed = new ItemVB("ItemCornSeed",null,CreativeTabs.tabMisc),"ItemCornSeed");
        GameRegistry.registerItem(itemChiliSeed = new ItemVB("ItemChiliSeed",null,CreativeTabs.tabMisc),"ItemChiliSeed");
        GameRegistry.registerItem(itemRiceSeed = new ItemVB("ItemRiceSeed",null,CreativeTabs.tabMisc),"ItemRiceSeed");
        GameRegistry.registerItem(itemSoybeanSeed = new ItemVB("ItemSoybeanSeed",null,CreativeTabs.tabMisc),"ItemSoybeanSeed");
        
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
        GameRegistry.registerItem(itemRiceFlour = new ItemVB("ItemRiceFlour",null,CreativeTabs.tabFood),"ItemRiceFlour");
        GameRegistry.registerItem(itemSalt = new ItemVB("ItemSalt",null,CreativeTabs.tabFood),"ItemSalt");
        GameRegistry.registerItem(itemUdon = new ItemVB("ItemUdon",null,CreativeTabs.tabFood),"ItemUdon");
        GameRegistry.registerItem(itemWheatFlour = new ItemVB("ItemWheatFlour",null,CreativeTabs.tabFood),"ItemWheatFlour");


        
        
    }
}
