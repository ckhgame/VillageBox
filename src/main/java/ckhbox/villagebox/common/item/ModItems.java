package ckhbox.villagebox.common.item;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.armor.ItemArmor;
import ckhbox.villagebox.common.item.book.ItemDismissalScroll;
import ckhbox.villagebox.common.item.book.ItemResetScroll;
import ckhbox.villagebox.common.item.book.ItemTreasureBook;
import ckhbox.villagebox.common.item.book.ItemVillageBook;
import ckhbox.villagebox.common.item.common.ItemCoin;
import ckhbox.villagebox.common.item.common.ItemDrink;
import ckhbox.villagebox.common.item.common.ItemElementShard;
import ckhbox.villagebox.common.item.common.ItemInvitation;
import ckhbox.villagebox.common.item.common.ItemMail;
import ckhbox.villagebox.common.item.material.ItemSteelIngot;
import ckhbox.villagebox.common.item.painting.ItemPainting;
import ckhbox.villagebox.common.item.tool.ItemAxe;
import ckhbox.villagebox.common.item.tool.ItemPickaxe;
import ckhbox.villagebox.common.item.tool.ItemShovel;
import ckhbox.villagebox.common.item.tool.ItemWeatherStone;
import ckhbox.villagebox.common.item.totem.ItemBlockWithInfo;
import ckhbox.villagebox.common.item.weapon.ItemDarkStaff;
import ckhbox.villagebox.common.item.weapon.ItemDarkSword;
import ckhbox.villagebox.common.item.weapon.ItemEfficientBow;
import ckhbox.villagebox.common.item.weapon.ItemFireStaff;
import ckhbox.villagebox.common.item.weapon.ItemFireSword;
import ckhbox.villagebox.common.item.weapon.ItemLightStaff;
import ckhbox.villagebox.common.item.weapon.ItemLightSword;
import ckhbox.villagebox.common.item.weapon.ItemNatureStaff;
import ckhbox.villagebox.common.item.weapon.ItemNatureSword;
import ckhbox.villagebox.common.item.weapon.ItemStaff;
import ckhbox.villagebox.common.item.weapon.ItemWaterStaff;
import ckhbox.villagebox.common.item.weapon.ItemWaterSword;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static final CreativeTabs tabVB = new CreativeTabs("tabVillageBox") {
		@SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(ModBlocks.mailbox);
        }
        @SideOnly(Side.CLIENT)
        public int getIconItemDamage()
        {
            return 0;
        }
	};
	
	public static class ToolMaterials{
		public static ToolMaterial STEEL = EnumHelper.addToolMaterial("VB:STEEL", 2, 500, 7.0F, 3.0F, 15);
		public static ToolMaterial RUNESTEEL = EnumHelper.addToolMaterial("VB:RUNESTEEL", 3, 1000, 8.0F, 3.0F, 18);
	}
	
	public static class ArmorMaterials{
		public static ArmorMaterial WOOD = EnumHelper.addArmorMaterial("VB:WOOD", PathHelper.full("wooden"), 7, new int[]{2, 4, 3, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0.0F);
		public static ArmorMaterial STEEL = EnumHelper.addArmorMaterial("VB:STEEL", PathHelper.full("steel"), 15, new int[]{3, 7, 6, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON,2.0F);
		public static ArmorMaterial RUNESTEEL = EnumHelper.addArmorMaterial("VB:RUNESTEEL", PathHelper.full("steel"), 30, new int[]{3, 8, 7, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,2.0F);
	}
	
	public static ItemTreasureBook treasureHuntBookI;
	public static ItemTreasureBook treasureHuntBookII;
	public static ItemTreasureBook treasureHuntBookIII;
	public static ItemCoin bronzeCoin;
	public static ItemCoin silverCoin;
	public static ItemCoin goldCoin;
	public static ItemMail mail;
	public static ItemResetScroll resetScroll;
	public static ItemDismissalScroll dismissalScroll;
	public static Item invitation;
	public static ItemVillageBook villageBook;
	
	//staff
	public static ItemStaff staff;
	public static ItemFireStaff fireStaff;
	public static ItemWaterStaff waterStaff;
	public static ItemNatureStaff natureStaff;
	public static ItemLightStaff lightStaff;
	public static ItemDarkStaff darkStaff;

	public static ItemSteelIngot steelIngot;
	
	public static Item steelHoe;
	public static Item steelAxe;
	public static Item steelPickaxe;
	public static Item steelShovel;
	public static Item steelSword;
	
	public static ItemFireSword fireSword;
	public static ItemWaterSword waterSword;
	public static ItemNatureSword natureSword;
	public static ItemDarkSword darkSword;
	public static ItemLightSword lightSword;
	
	public static Item steelHelmet;
	public static Item steelChestplate;
	public static Item steelLeggings;
	public static Item steelBoots;
	
	public static Item woodenHelmet;
	public static Item woodenChestplate;
	public static Item woodenLeggings;
	public static Item woodenBoots;
	
	public static Item woodenClub;
	
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
	public static Item hamburger;
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
	
	//element shards
	public static ItemElementShard fireShard;
	public static ItemElementShard waterShard;
	public static ItemElementShard natureShard;
	public static ItemElementShard darkShard;
	public static ItemElementShard lightShard;

	public static void init(){
		//books
		register(treasureHuntBookI=new ItemTreasureBook(1),"treasure_hunt_book_0");
		register(treasureHuntBookII=new ItemTreasureBook(2),"treasure_hunt_book_1");
		register(treasureHuntBookIII=new ItemTreasureBook(3),"treasure_hunt_book_2");
		register(villageBook=new ItemVillageBook(),"village_book");
		
		register(resetScroll=new ItemResetScroll(),"reset_scroll");
		register(dismissalScroll=new ItemDismissalScroll(),"dismissal_scroll");
		
		//shards
		register(fireShard=new ItemElementShard("fire"),"fire_shard");
		register(waterShard=new ItemElementShard("water"),"water_shard");
		register(natureShard=new ItemElementShard("nature"),"nature_shard");
		register(darkShard=new ItemElementShard("dark"),"dark_shard");
		register(lightShard=new ItemElementShard("light"),"light_shard");
		
		//coins
		register(bronzeCoin=new ItemCoin("bronze"),"bronze_coin");
		register(silverCoin=new ItemCoin("silver"),"silver_coin");
		register(goldCoin=new ItemCoin("gold"),"gold_coin");
		
		//mail
		register(mail=new ItemMail(),"mail");
		register(invitation=new ItemInvitation(),"invitation");
		
		//painting
		register(painting=new ItemPainting(),"painting");
		
		//weapon
		register(staff=new ItemStaff(),"staff");
		register(fireStaff=new ItemFireStaff(),"fire_staff");
		register(waterStaff=new ItemWaterStaff(),"water_staff");
		register(natureStaff=new ItemNatureStaff(),"nature_staff");
		register(lightStaff=new ItemLightStaff(),"light_staff");
		register(darkStaff=new ItemDarkStaff(),"dark_staff");
		
		register(efficientBow=new ItemEfficientBow(),"bow");
		
		register(steelSword=(new ItemSword(ModItems.ToolMaterials.STEEL).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("steelSword"))),"steel_sword");
		register(fireSword=new ItemFireSword(),"fire_sword");
		register(waterSword=new ItemWaterSword(),"water_sword");
		register(natureSword=new ItemNatureSword(),"nature_sword");
		register(darkSword=new ItemDarkSword(),"dark_sword");
		register(lightSword=new ItemLightSword(),"light_sword");	
		
		register(woodenClub=(new ItemSword(ToolMaterial.WOOD).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("woodenClub"))),"wooden_club");
		
		//armor
		register(steelHelmet=new ItemArmor("steelHelmet", ModItems.ArmorMaterials.STEEL, 1, EntityEquipmentSlot.HEAD),"steel_helmet");
		register(steelChestplate=new ItemArmor("steelChestplate", ModItems.ArmorMaterials.STEEL, 1, EntityEquipmentSlot.CHEST),"steel_chestplate");
		register(steelLeggings=new ItemArmor("steelLeggings", ModItems.ArmorMaterials.STEEL, 2, EntityEquipmentSlot.LEGS),"steel_leggings");
		register(steelBoots=new ItemArmor("steelBoots", ModItems.ArmorMaterials.STEEL, 1, EntityEquipmentSlot.FEET),"steel_boots");
		
		register(woodenHelmet=new ItemArmor("woodenHelmet", ModItems.ArmorMaterials.WOOD, 1, EntityEquipmentSlot.HEAD),"wooden_helmet");
		register(woodenChestplate=new ItemArmor("woodenChestplate", ModItems.ArmorMaterials.WOOD, 1, EntityEquipmentSlot.CHEST),"wooden_chestplate");
		register(woodenLeggings=new ItemArmor("woodenLeggings", ModItems.ArmorMaterials.WOOD, 2, EntityEquipmentSlot.LEGS),"wooden_leggings");
		register(woodenBoots=new ItemArmor("woodenBoots", ModItems.ArmorMaterials.WOOD, 1, EntityEquipmentSlot.FEET),"wooden_boots");
		
		//tools
		register(sunStone=(new ItemWeatherStone(true)),"sun_stone");
		register(rainStone=(new ItemWeatherStone(false)),"rain_stone");
		
		register(steelHoe=(new ItemHoe(ModItems.ToolMaterials.STEEL).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("steelHoe"))),"steel_hoe");
		register(steelAxe=(new ItemAxe(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelAxe"))),"steel_axe");
		register(steelPickaxe=(new ItemPickaxe(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelPickaxe"))),"steel_pickaxe");
		register(steelShovel=(new ItemShovel(ModItems.ToolMaterials.STEEL).setUnlocalizedName(PathHelper.full("steelShovel"))),"steel_shovel");	
		
		register(steelIngot=new ItemSteelIngot(),"steel_ingot");
		
		//materials
		register(cabbage=(new Item()).setUnlocalizedName(PathHelper.full("cabbage")).setCreativeTab(ModItems.tabVB),"cabbage");
		register(chili=(new Item()).setUnlocalizedName(PathHelper.full("chili")).setCreativeTab(ModItems.tabVB),"chili");
		register(corn=(new Item()).setUnlocalizedName(PathHelper.full("corn")).setCreativeTab(ModItems.tabVB),"corn");
		register(soybean=(new Item()).setUnlocalizedName(PathHelper.full("soybean")).setCreativeTab(ModItems.tabVB),"soybean");
		register(riceplant=(new Item()).setUnlocalizedName(PathHelper.full("riceplant")).setCreativeTab(ModItems.tabVB),"riceplant");
		
		register(mayonnaise=(new Item()).setUnlocalizedName(PathHelper.full("mayonnaise")).setCreativeTab(ModItems.tabVB),"mayonnaise");
		register(cheese=(new Item()).setUnlocalizedName(PathHelper.full("cheese")).setCreativeTab(ModItems.tabVB),"cheese");
		register(ballOfWool=(new Item()).setUnlocalizedName(PathHelper.full("ballOfWool")).setCreativeTab(ModItems.tabVB),"ball_of_wool");
		
		register(rice=(new Item()).setUnlocalizedName(PathHelper.full("rice")).setCreativeTab(ModItems.tabVB),"rice");
		register(riceFlour=(new Item()).setUnlocalizedName(PathHelper.full("riceFlour")).setCreativeTab(ModItems.tabVB),"rice_flour");
		register(wheatFlour=(new Item()).setUnlocalizedName(PathHelper.full("wheatFlour")).setCreativeTab(ModItems.tabVB),"wheat_flour");
		register(soySauce=(new Item()).setUnlocalizedName(PathHelper.full("soySauce")).setCreativeTab(ModItems.tabVB),"soy_sauce");
		register(cookingOil=(new Item()).setUnlocalizedName(PathHelper.full("cookingOil")).setCreativeTab(ModItems.tabVB),"cooking_oil");
		
		register(seaweed=(new Item()).setUnlocalizedName(PathHelper.full("seaweed")).setCreativeTab(ModItems.tabVB),"seaweed");
		register(salt=(new Item()).setUnlocalizedName(PathHelper.full("salt")).setCreativeTab(ModItems.tabVB),"salt");
		
		//wines
		register(grapeWine=(new ItemDrink(1, 0.0F, 15)).setUnlocalizedName(PathHelper.full("grapeWine")),"grape_wine");
		register(cookingWine=(new ItemDrink(1, 0.0F, 10)).setUnlocalizedName(PathHelper.full("cookingWine")),"cooking_wine");
		register(cocktail=(new ItemDrink(1, 0.0F, 20)).setUnlocalizedName(PathHelper.full("cocktail")),"cocktail");		
		register(beer=(new ItemDrink(2, 0.0F, 10)).setUnlocalizedName(PathHelper.full("beer")),"beer");
		register(whisky=(new ItemDrink(1, 0.0F, 25)).setUnlocalizedName(PathHelper.full("whisky")),"whisky");
		register(vodka=(new ItemDrink(1, 0.0F, 25)).setUnlocalizedName(PathHelper.full("vodka")),"vodka");
		
		//food
		register(grape=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("grape")),"grape");
		register(lemon=(new ItemFood(2, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("lemon")),"lemon");
		register(orange=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("orange")),"orange");		
		register(pineapple=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("pineapple")),"pineapple");
		register(strawberry=(new ItemFood(2, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("strawberry")),"strawberry");
		register(melon=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("melon")),"melon");
		register(banana=(new ItemFood(2, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("banana")),"banana");
		
		register(tofu=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("tofu")),"tofu");
		register(boiledEgg=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("boiledEgg")),"boiled_egg");
		
		register(shrimp=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("shrimp")),"shrimp");
		register(crab=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("crab")),"crab");
		
		register(porkRamen=(new ItemFood(8, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("porkRamen")),"pork_ramen");
		register(beefNoodleSoup=(new ItemFood(8, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("beefNoodleSoup")),"beef_noodle_soup");
		register(noodleSoup=(new ItemFood(6, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("noodleSoup")),"noodle_soup");
		register(carrotCake=(new ItemFood(6, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("carrotCake")),"carrot_cake");
		register(hamburger=(new ItemFood(8, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("hamburger")),"hamburger");
		register(congee=(new ItemFood(4, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("congee")),"congee");
		register(boiledFish=(new ItemFood(6, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("boiledFish")),"boiled_fish");
		register(appleCandy=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("appleCandy")),"apple_candy");
		register(creamyCorn=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("creamyCorn")),"creamy_corn");
		register(chocolateBanana=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("chocolateBanana")),"chocolate_banana");
		register(fries=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("fries")),"fries");
		register(mapoTofu=(new ItemFood(8, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("mapoTofu")),"mapo_tofu");
		register(cannedOranges=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("cannedOranges")),"canned_oranges");
		register(strawberryIcecream=(new ItemFood(2, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("strawberryIcecream")),"strawberry_icecream");
		register(honeyTea=(new ItemFood(2, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("honeyTea")),"honey_tea");
		register(pineappleCanday=(new ItemFood(2, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("pineappleCanday")),"pineapple_canday");
		register(cornChips=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("cornChips")),"corn_chips");
		register(melonIcecream=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("melonIcecream")),"melon_icecream");
		register(melonIcebar=(new ItemFood(4, 0.3F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("melonIcebar")),"melon_icebar");
		register(roastedLamb=(new ItemFood(6, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("roastedLamb")),"roasted_lamb");
		register(nigiri=(new ItemFood(4, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("nigiri")),"nigiri");
		register(udon=(new ItemFood(6, 0.8F, false)).setCreativeTab(ModItems.tabVB).setUnlocalizedName(PathHelper.full("udon")),"udon");
	}
	
	public static void register(Item item, String name){
		GameRegistry.register(item,new ResourceLocation(VillageBoxMod.MODID,name));
	}
	
	
}
