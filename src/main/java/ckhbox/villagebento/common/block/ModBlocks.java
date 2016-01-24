package ckhbox.villagebento.common.block;

import ckhbox.villagebento.common.block.building.BlockFoundation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockFoundation foundation;
	
	
	public static void init(){
		GameRegistry.registerBlock(foundation=new BlockFoundation(),"foundation");
	}
}
