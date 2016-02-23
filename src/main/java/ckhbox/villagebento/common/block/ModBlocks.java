package ckhbox.villagebento.common.block;

import ckhbox.villagebento.common.block.buildbox.BlockBuildBox;
import ckhbox.villagebento.common.block.mailbox.BlockMailBox;
import ckhbox.villagebento.common.block.tool.BlockAlchemyPot;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockMailBox mailbox;
	public static BlockAlchemyPot alchemyPot;
	
	public static BlockBuildBox buildboxSmall;
	public static BlockBuildBox buildboxMedium;
	public static BlockBuildBox buildboxLarge;
	public static BlockBuildBox buildboxExLarge;
	
	public static void init(){
		GameRegistry.registerBlock(mailbox=new BlockMailBox(),"mailbox");
		GameRegistry.registerBlock(alchemyPot=new BlockAlchemyPot(),"alchemypot");
		
		GameRegistry.registerBlock(buildboxSmall=new BlockBuildBox(BlockBuildBox.BuildSize.Small),"buildbox_small");
		GameRegistry.registerBlock(buildboxMedium=new BlockBuildBox(BlockBuildBox.BuildSize.Medium),"buildbox_medium");
		GameRegistry.registerBlock(buildboxLarge=new BlockBuildBox(BlockBuildBox.BuildSize.Large),"buildbox_large");
		GameRegistry.registerBlock(buildboxExLarge=new BlockBuildBox(BlockBuildBox.BuildSize.ExLarge),"buildbox_exlarge");
		
	}
}
