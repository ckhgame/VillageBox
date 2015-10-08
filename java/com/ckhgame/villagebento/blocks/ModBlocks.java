package com.ckhgame.villagebento.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks {

    public static BlockVillageBoxSmall blockVillageBoxSmall;
    public static BlockVillageBoxMedium blockVillageBoxMedium;
    public static BlockVillageBoxLarge blockVillageBoxLarge;
    
    public static BlockVillageViewer blockVillageViewer;
    public static BlockBuildingScanner blockBuildingScanner;
    
    public static BlockBuildingSmallHouse blockBuildingSmallHouse;

    public static final void init() {
        GameRegistry.registerBlock(blockVillageBoxSmall = new BlockVillageBoxSmall(), "BlockVillageBoxSmall");
        GameRegistry.registerBlock(blockVillageBoxMedium = new BlockVillageBoxMedium(), "BlockVillageBoxMedium");
        GameRegistry.registerBlock(blockVillageBoxLarge = new BlockVillageBoxLarge(), "BlockVillageBoxLarge");
        
        GameRegistry.registerBlock(blockVillageViewer = new BlockVillageViewer(), "BlockVillageViewer");
        GameRegistry.registerBlock(blockBuildingScanner = new BlockBuildingScanner(), "BlockBuildingScanner");
        
        GameRegistry.registerBlock(blockBuildingSmallHouse = new BlockBuildingSmallHouse(), "BlockBuildingSmallHouse");
    }
}
