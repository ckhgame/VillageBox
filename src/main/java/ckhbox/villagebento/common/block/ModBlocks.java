package ckhbox.villagebento.common.block;

import ckhbox.villagebento.common.block.mailbox.BlockMailBox;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockMailBox mailbox;
		
	public static void init(){
		GameRegistry.registerBlock(mailbox=new BlockMailBox(),"mailbox");
	}
}
