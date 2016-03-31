package ckhbox.villagebox.common.tileentity;

import ckhbox.villagebox.common.tileentity.totem.TileEntityFireTotem;
import ckhbox.villagebox.common.tileentity.totem.TileEntityNatureTotem;
import ckhbox.villagebox.common.tileentity.totem.TileEntityWaterTotem;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static void init(){
		GameRegistry.registerTileEntity(TileEntityFireTotem.class,"fire_totem");
		GameRegistry.registerTileEntity(TileEntityWaterTotem.class,"water_totem");
		GameRegistry.registerTileEntity(TileEntityNatureTotem.class,"nature_totem");
	}
}
