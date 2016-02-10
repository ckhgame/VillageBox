package ckhbox.villagebento.common.item;

import ckhbox.villagebento.common.item.book.ItemVillageBook;
import ckhbox.villagebento.common.item.gem.ItemGem;
import ckhbox.villagebento.common.item.mail.ItemMail;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemVillageBook villageBook;
	public static ItemGem blueGem;
	public static ItemGem violetGem;
	public static ItemGem orangeGem;
	public static ItemMail mail;
	
	
	public static void init(){
		//books
		GameRegistry.registerItem(villageBook=new ItemVillageBook(),"village_book");
		
		//gems
		GameRegistry.registerItem(blueGem=new ItemGem("blue"),"blue_gem");
		GameRegistry.registerItem(violetGem=new ItemGem("violet"),"violet_gem");
		GameRegistry.registerItem(orangeGem=new ItemGem("orange"),"orange_gem");
		
		//mail
		GameRegistry.registerItem(mail=new ItemMail(),"mail");
	}
	
	
}
