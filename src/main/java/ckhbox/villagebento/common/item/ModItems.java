package ckhbox.villagebento.common.item;

import ckhbox.villagebento.common.item.armor.ItemArmor;
import ckhbox.villagebento.common.item.book.ItemTreasureBook;
import ckhbox.villagebento.common.item.common.ItemCoin;
import ckhbox.villagebento.common.item.common.ItemDrink;
import ckhbox.villagebento.common.item.common.ItemInvitation;
import ckhbox.villagebento.common.item.common.ItemMail;
import ckhbox.villagebento.common.item.material.ItemSteelIngot;
import ckhbox.villagebento.common.item.painting.ItemPainting;
import ckhbox.villagebento.common.item.tool.ItemAxe;
import ckhbox.villagebento.common.item.tool.ItemPickaxe;
import ckhbox.villagebento.common.item.tool.ItemShovel;
import ckhbox.villagebento.common.item.tool.ItemWeatherStone;
import ckhbox.villagebento.common.item.weapon.ItemEfficientBow;
import ckhbox.villagebento.common.item.weapon.ItemFlameStaff;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static class ToolMaterials{
		public static ToolMaterial STEEL = EnumHelper.addToolMaterial("VB:STEEL", 2, 500, 7.0F, 3.0F, 15);
		public static ToolMaterial RUNESTEEL = EnumHelper.addToolMaterial("VB:RUNESTEEL", 3, 1000, 8.0F, 3.0F, 18);
	}
	
	public static class ArmorMaterials{
		public static ArmorMaterial WOOD = EnumHelper.addArmorMaterial("VB:WOOD", PathHelper.full("wood"), 7, new int[]{2, 4, 3, 2}, 10);
		public static ArmorMaterial STEEL = EnumHelper.addArmorMaterial("VB:STEEL", PathHelper.full("steel"), 15, new int[]{3, 7, 6, 3}, 12);
		public static ArmorMaterial RUNESTEEL = EnumHelper.addArmorMaterial("VB:RUNESTEEL", PathHelper.full("steel"), 30, new int[]{3, 8, 7, 3}, 15);
	}
	
	public static ItemTreasureBook treasureHuntBookI;
	public static ItemTreasureBook treasureHuntBookII;
	public static ItemTreasureBook treasureHuntBookIII;
	public static ItemCoin bronzeCoin;
	public static ItemCoin silverCoin;
	public static ItemCoin goldCoin;
	public static ItemMail mail;
	public static Item invitation;
	public static ItemFlameStaff flameStaff;

	public static ItemSteelIngot steelIngot;
	
	public static Item steelHoe;
	public static Item steelAxe;
	public static Item steelPickaxe;
	public static Item steelShovel;
	public static Item steelSword;
	
	public static Item steelHelmet;
	public static Item steelChestplate;
	public static Item steelLeggings;
	public static Item steelBoots;
	
	public static Item woodenHelmet;
	public static Item woodenChestplate;
	public static Item woodenLeggings;
	public static Item woodenBoots;
	
	public static ItemWeatherStone sunStone;
	public static ItemWeatherStone rainStone;
	
	public static Item painting; 
	
	public static Item efficientBow;
	
	//materials
	public static Item cabbage;
	public static Item chili;
	public static Item corn;
	public static Item soybean;
	public static Item riceplant;
	
	public static Item mayonnaise;
	public static Item cheese;
	public static Item ballOfWool;
	
	public static Item rice;
	public static Item riceFlour;
	public static Item wheatFlour;
	public static Item soySauce;
	public static Item cookingOil;
	public static Item boiledEgg;
	public static Item tofu;
	
	public static Item shrimp;
	public static Item crab;
	public static Item seaweed;
	public static Item salt;
	
	//fruits
	public static Item grape;
	public static Item lemon;
	public static Item orange;
	public static Item pineapple;
	public static Item strawberry;
	public static Item melon;
	public static Item banana;
	
	public static Item grapeWine;
	public static Item cookingWine;
	public static Item cocktail;
	public static Item beer;
	public static Item whisky;
	public static Item vodka;
	
	//food
	public static Item porkRamen;
	public static Item beefNoodleSoup;
	public static Item noodleSoup;
	public static Item carrotCake;
	public static Item hambuger;
	public static Item congee;
	public static Item boiledFish;
	public static Item appleCandy;
	public static Item creamyCorn;
	public static Item chocolateBanana;
	public static Item fries;
	public static Item mapoTofu;
	public static Item cannedOranges;
	public static Item strawberryIcecream;
	public static Item honeyTea;
	public static Item pineappleCanday;
	public static Item cornChips;
	public static Item melonIcecream;
	public static Item melonIcebar;
	public static Item roastedLamb;
	public static Item nigiri;
	public static Item udon;

	public static void init(){
		//books
		GameRegistry.registerItem(treasureHuntBookI=new ItemTreasureBook(1),"treasure_hunt_book_0");
		GameRegistry.registerItem(treasureHuntBookII=new ItemTreasureBook(2),"treasure_hunt_book_1");
		GameRegistry.registerItem(treasureHuntBookIII=new ItemTreasureBook(3),"treasure_hunt_book_2");
		
		//gems
		GameRegistry.registerItem(bronzeCoin=new ItemCoin("bronze"),"bronze_coin");
		GameRegistry.registerItem(silverCoin=new ItemCoin("silver"),"silver_coin");
		GameRegistry.registerItem(goldCoin=new ItemCoin("gold"),"gold_coin");
		
		//mail
		GameRegistry.registerItem(mail=new ItemMail(),"mail");
		GameRegistry.registerItem(invitation=new ItemInvitation(),"invitation");
		
		//painting
		GameRegistry.registerItem(painting=new ItemPainting(),"painting");
		
		//weapon
		GameRegistry.registerItem(flameStaff=new ItemFlameStaff(),"flame_staff");
		GameRegistry.registerItem(efficientBow=new ItemEfficientBow(),"bow");
		GameRegistry.registerItem(steelSword=(new ItemSword(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelSword"))),"steel_sword");
		
		//armor
		GameRegistry.registerItem(steelHelmet=new ItemArmor("steelHelmet", ModItems.ArmorMaterials.STEEL, 1, 0),"steel_helmet");
		GameRegistry.registerItem(steelChestplate=new ItemArmor("steelChestplate", ModItems.ArmorMaterials.STEEL, 1, 1),"steel_chestplate");
		GameRegistry.registerItem(steelLeggings=new ItemArmor("steelLeggings", ModItems.ArmorMaterials.STEEL, 2, 2),"steel_leggings");
		GameRegistry.registerItem(steelBoots=new ItemArmor("steelBoots", ModItems.ArmorMaterials.STEEL, 1, 3),"steel_boots");
		
		GameRegistry.registerItem(woodenHelmet=new ItemArmor("woodenHelmet", ModItems.ArmorMaterials.WOOD, 1, 0),"wooden_helmet");
		GameRegistry.registerItem(woodenChestplate=new ItemArmor("woodenChestplate", ModItems.ArmorMaterials.WOOD, 1, 1),"wooden_chestplate");
		GameRegistry.registerItem(woodenLeggings=new ItemArmor("woodenLeggings", ModItems.ArmorMaterials.WOOD, 2, 2),"wooden_leggings");
		GameRegistry.registerItem(woodenBoots=new ItemArmor("woodenBoots", ModItems.ArmorMaterials.WOOD, 1, 3),"wooden_boots");
		
		//tools
		GameRegistry.registerItem(sunStone=(new ItemWeatherStone(true)),"sun_stone");
		GameRegistry.registerItem(rainStone=(new ItemWeatherStone(false)),"rain_stone");
		
		GameRegistry.registerItem(steelHoe=(new ItemHoe(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelHoe"))),"steel_hoe");
		GameRegistry.registerItem(steelAxe=(new ItemAxe(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelAxe"))),"steel_axe");
		GameRegistry.registerItem(steelPickaxe=(new ItemPickaxe(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelPickaxe"))),"steel_pickaxe");
		GameRegistry.registerItem(steelShovel=(new ItemShovel(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelShovel"))),"steel_shovel");	
		
		GameRegistry.registerItem(steelIngot=new ItemSteelIngot(),"steel_ingot");
		
		//materials
		GameRegistry.registerItem(cabbage=(new Item()).setUnlocalizedName(PathHelper.full("cabbage")).setCreativeTab(CreativeTabs.tabMaterials),"cabbage");
		GameRegistry.registerItem(chili=(new Item()).setUnlocalizedName(PathHelper.full("chili")).setCreativeTab(CreativeTabs.tabMaterials),"chili");
		GameRegistry.registerItem(corn=(new Item()).setUnlocalizedName(PathHelper.full("corn")).setCreativeTab(CreativeTabs.tabMaterials),"corn");
		GameRegistry.registerItem(soybean=(new Item()).setUnlocalizedName(PathHelper.full("soybean")).setCreativeTab(CreativeTabs.tabMaterials),"soybean");
		GameRegistry.registerItem(riceplant=(new Item()).setUnlocalizedName(PathHelper.full("riceplant")).setCreativeTab(CreativeTabs.tabMaterials),"riceplant");
		
		GameRegistry.registerItem(mayonnaise=(new Item()).setUnlocalizedName(PathHelper.full("mayonnaise")).setCreativeTab(CreativeTabs.tabMaterials),"mayonnaise");
		GameRegistry.registerItem(cheese=(new Item()).setUnlocalizedName(PathHelper.full("cheese")).setCreativeTab(CreativeTabs.tabMaterials),"cheese");
		GameRegistry.registerItem(ballOfWool=(new Item()).setUnlocalizedName(PathHelper.full("ballOfWool")).setCreativeTab(CreativeTabs.tabMaterials),"ball_of_wool");
		
		GameRegistry.registerItem(rice=(new Item()).setUnlocalizedName(PathHelper.full("rice")).setCreativeTab(CreativeTabs.tabMaterials),"rice");
		GameRegistry.registerItem(riceFlour=(new Item()).setUnlocalizedName(PathHelper.full("riceFlour")).setCreativeTab(CreativeTabs.tabMaterials),"rice_flour");
		GameRegistry.registerItem(wheatFlour=(new Item()).setUnlocalizedName(PathHelper.full("wheatFlour")).setCreativeTab(CreativeTabs.tabMaterials),"wheat_flour");
		GameRegistry.registerItem(soySauce=(new Item()).setUnlocalizedName(PathHelper.full("soySauce")).setCreativeTab(CreativeTabs.tabMaterials),"soy_sauce");
		GameRegistry.registerItem(cookingOil=(new Item()).setUnlocalizedName(PathHelper.full("cookingOil")).setCreativeTab(CreativeTabs.tabMaterials),"cooking_oil");
		
		GameRegistry.registerItem(seaweed=(new Item()).setUnlocalizedName(PathHelper.full("seaweed")).setCreativeTab(CreativeTabs.tabMaterials),"seaweed");
		GameRegistry.registerItem(salt=(new Item()).setUnlocalizedName(PathHelper.full("salt")).setCreativeTab(CreativeTabs.tabMaterials),"salt");
		
		//wines
		GameRegistry.registerItem(grapeWine=(new ItemDrink(0, 0.0F, false)).setUnlocalizedName(PathHelper.full("grapeWine")),"grape_wine");
		GameRegistry.registerItem(cookingWine=(new ItemDrink(0, 0.0F, false)).setUnlocalizedName(PathHelper.full("cookingWine")),"cooking_wine");
		GameRegistry.registerItem(cocktail=(new ItemDrink(0, 0.0F, false)).setUnlocalizedName(PathHelper.full("cocktail")),"cocktail");		
		GameRegistry.registerItem(beer=(new ItemDrink(0, 0.0F, false)).setUnlocalizedName(PathHelper.full("beer")),"beer");
		GameRegistry.registerItem(whisky=(new ItemDrink(0, 0.0F, false)).setUnlocalizedName(PathHelper.full("whisky")),"whisky");
		GameRegistry.registerItem(vodka=(new ItemDrink(0, 0.0F, false)).setUnlocalizedName(PathHelper.full("vodka")),"vodka");
		
		//food
		GameRegistry.registerItem(grape=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("grape")),"grape");
		GameRegistry.registerItem(lemon=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("lemon")),"lemon");
		GameRegistry.registerItem(orange=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("orange")),"orange");		
		GameRegistry.registerItem(pineapple=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("pineapple")),"pineapple");
		GameRegistry.registerItem(strawberry=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("strawberry")),"strawberry");
		GameRegistry.registerItem(melon=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("melon")),"melon");
		GameRegistry.registerItem(banana=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("banana")),"banana");
		
		GameRegistry.registerItem(tofu=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("tofu")),"tofu");
		GameRegistry.registerItem(boiledEgg=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("boiledEgg")),"boiled_egg");
		
		GameRegistry.registerItem(shrimp=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("shrimp")),"shrimp");
		GameRegistry.registerItem(crab=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("crab")),"crab");
		
		GameRegistry.registerItem(porkRamen=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("porkRamen")),"pork_ramen");
		GameRegistry.registerItem(beefNoodleSoup=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("beefNoodleSoup")),"beef_noodle_soup");
		GameRegistry.registerItem(noodleSoup=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("noodleSoup")),"noodle_soup");
		GameRegistry.registerItem(carrotCake=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("carrotCake")),"carrot_cake");
		GameRegistry.registerItem(hambuger=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("hambuger")),"hambuger");
		GameRegistry.registerItem(congee=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("congee")),"congee");
		GameRegistry.registerItem(boiledFish=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("boiledFish")),"boiled_fish");
		GameRegistry.registerItem(appleCandy=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("appleCandy")),"apple_candy");
		GameRegistry.registerItem(creamyCorn=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("creamyCorn")),"creamy_corn");
		GameRegistry.registerItem(chocolateBanana=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("chocolateBanana")),"chocolate_banana");
		GameRegistry.registerItem(fries=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("fries")),"fries");
		GameRegistry.registerItem(mapoTofu=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("mapoTofu")),"mapo_tofu");
		GameRegistry.registerItem(cannedOranges=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("cannedOranges")),"canned_oranges");
		GameRegistry.registerItem(strawberryIcecream=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("strawberryIcecream")),"strawberry_icecream");
		GameRegistry.registerItem(honeyTea=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("honeyTea")),"honey_tea");
		GameRegistry.registerItem(pineappleCanday=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("pineappleCanday")),"pineapple_canday");
		GameRegistry.registerItem(cornChips=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("cornChips")),"corn_chips");
		GameRegistry.registerItem(melonIcecream=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("melonIcecream")),"melon_icecream");
		GameRegistry.registerItem(melonIcebar=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("melonIcebar")),"melon_icebar");
		GameRegistry.registerItem(roastedLamb=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("roastedLamb")),"roasted_lamb");
		GameRegistry.registerItem(nigiri=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("nigiri")),"nigiri");
		GameRegistry.registerItem(udon=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("udon")),"udon");
	}
	
	
}
