package ckhbox.villagebento.common.block;

import ckhbox.villagebento.common.block.mailbox.BlockMailBox;
import ckhbox.villagebento.common.block.tool.BlockAlchemyPot;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockMailBox mailbox;
	public static BlockAlchemyPot alchemyPot;
	
	public static void init(){
		GameRegistry.registerBlock(mailbox=new BlockMailBox(),"mailbox");
		GameRegistry.registerBlock(alchemyPot=new BlockAlchemyPot(),"alchemypot");
	}
}
