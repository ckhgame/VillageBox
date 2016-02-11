package ckhbox.villagebento.common.item;

import ckhbox.villagebento.common.item.book.ItemTreasureBook;
import ckhbox.villagebento.common.item.gem.ItemGem;
import ckhbox.villagebento.common.item.mail.ItemMail;
import ckhbox.villagebento.common.item.weapon.ItemFlameStaff;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemTreasureBook treasureHuntBookI;
	public static ItemTreasureBook treasureHuntBookII;
	public static ItemTreasureBook treasureHuntBookIII;
	public static ItemGem blueGem;
	public static ItemGem violetGem;
	public static ItemGem orangeGem;
	public static ItemMail mail;
	public static ItemFlameStaff flameStaff;
	
	
	public static void init(){
		//books
		GameRegistry.registerItem(treasureHuntBookI=new ItemTreasureBook(1),"treasure_hunt_book_0");
		GameRegistry.registerItem(treasureHuntBookII=new ItemTreasureBook(2),"treasure_hunt_book_1");
		GameRegistry.registerItem(treasureHuntBookIII=new ItemTreasureBook(3),"treasure_hunt_book_2");
		
		//gems
		GameRegistry.registerItem(blueGem=new ItemGem("blue"),"blue_gem");
		GameRegistry.registerItem(violetGem=new ItemGem("violet"),"violet_gem");
		GameRegistry.registerItem(orangeGem=new ItemGem("orange"),"orange_gem");
		
		//mail
		GameRegistry.registerItem(mail=new ItemMail(),"mail");
		
		//weapon
		GameRegistry.registerItem(flameStaff=new ItemFlameStaff(),"flame_staff");
	}
	
	
}
