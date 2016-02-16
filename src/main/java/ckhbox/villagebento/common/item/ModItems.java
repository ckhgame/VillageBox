package ckhbox.villagebento.common.item;

import ckhbox.villagebento.common.item.book.ItemTreasureBook;
import ckhbox.villagebento.common.item.common.ItemCoin;
import ckhbox.villagebento.common.item.common.ItemDrink;
import ckhbox.villagebento.common.item.common.ItemMail;
import ckhbox.villagebento.common.item.material.ItemProcessedWoodPlank;
import ckhbox.villagebento.common.item.material.ItemReinforcedIronIngot;
import ckhbox.villagebento.common.item.weapon.ItemFlameStaff;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemTreasureBook treasureHuntBookI;
	public static ItemTreasureBook treasureHuntBookII;
	public static ItemTreasureBook treasureHuntBookIII;
	public static ItemCoin bronzeCoin;
	public static ItemCoin silverCoin;
	public static ItemCoin goldCoin;
	public static ItemMail mail;
	public static ItemFlameStaff flameStaff;
	public static ItemProcessedWoodPlank processedWoodPlank;
	public static ItemReinforcedIronIngot reinforcedIronIngot;
	
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
	public static Item soySauce;
	public static Item cookingOil;
	
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
		
		//weapon
		GameRegistry.registerItem(flameStaff=new ItemFlameStaff(),"flame_staff");
		
		//materials
		GameRegistry.registerItem(processedWoodPlank=new ItemProcessedWoodPlank(),"processed_wood_plank");
		GameRegistry.registerItem(reinforcedIronIngot=new ItemReinforcedIronIngot(),"reinforced_iron_ingot");
		
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
		
		//fruits
		GameRegistry.registerItem(grape=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("grape")),"grape");
		GameRegistry.registerItem(lemon=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("lemon")),"lemon");
		GameRegistry.registerItem(orange=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("orange")),"orange");		
		GameRegistry.registerItem(pineapple=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("pineapple")),"pineapple");
		GameRegistry.registerItem(strawberry=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("strawberry")),"strawberry");
		GameRegistry.registerItem(melon=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("melon")),"melon");
		GameRegistry.registerItem(banana=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("banana")),"banana");
		
		GameRegistry.registerItem(shrimp=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("shrimp")),"shrimp");
		GameRegistry.registerItem(crab=(new ItemFood(4, 0.3F, false)).setUnlocalizedName(PathHelper.full("crab")),"crab");
	}
	
	
}
