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

    }
}
