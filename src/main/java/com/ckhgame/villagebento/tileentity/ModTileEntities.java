package com.ckhgame.villagebento.tileentity;


import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static final void init() {
		GameRegistry.registerTileEntity(TileEntityVBCrops.class, "TileEntityVBCrops");
		GameRegistry.registerTileEntity(TileEntityBlockCustom.class, "TileEntityBlockCustom");
    }
}
