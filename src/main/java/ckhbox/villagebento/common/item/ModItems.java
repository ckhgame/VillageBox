package ckhbox.villagebento.common.item;

import ckhbox.villagebento.common.item.book.ItemTreasureBook;
import ckhbox.villagebento.common.item.coin.ItemCoin;
import ckhbox.villagebento.common.item.mail.ItemMail;
import ckhbox.villagebento.common.item.material.ItemProcessedWoodPlank;
import ckhbox.villagebento.common.item.material.ItemReinforcedIronIngot;
import ckhbox.villagebento.common.item.weapon.ItemFlameStaff;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
	
	//food materials
	public static Item cabbage;
	public static Item chili;
	public static Item corn;
	public static Item soybean;
	public static Item riceplant;
	
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
		
		//food materials
		GameRegistry.registerItem(cabbage=(new Item()).setUnlocalizedName(PathHelper.full("cabbage")).setCreativeTab(CreativeTabs.tabMaterials),"cabbage");
		GameRegistry.registerItem(chili=(new Item()).setUnlocalizedName(PathHelper.full("chili")).setCreativeTab(CreativeTabs.tabMaterials),"chili");
		GameRegistry.registerItem(corn=(new Item()).setUnlocalizedName(PathHelper.full("corn")).setCreativeTab(CreativeTabs.tabMaterials),"corn");
		GameRegistry.registerItem(soybean=(new Item()).setUnlocalizedName(PathHelper.full("soybean")).setCreativeTab(CreativeTabs.tabMaterials),"soybean");
		GameRegistry.registerItem(riceplant=(new Item()).setUnlocalizedName(PathHelper.full("riceplant")).setCreativeTab(CreativeTabs.tabMaterials),"riceplant");
	}
	
	
}
