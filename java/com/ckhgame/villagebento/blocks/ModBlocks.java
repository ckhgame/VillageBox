package com.ckhgame.villagebento.blocks;

import com.ckhgame.villagebento.data.BuildingData;

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
    
    //buildings
    public static BlockVillageBuilding blockVillageCenter;
    public static BlockVillageBuilding blockMiningHouse;
    public static BlockVillageBuilding blockBlackSmithsShop;
    public static BlockVillageBuilding blockBakery;

    public static final void init() {
        GameRegistry.registerBlock(blockVillageBoxSmall = new BlockVillageBoxSmall(), "BlockVillageBoxSmall");
        GameRegistry.registerBlock(blockVillageBoxMedium = new BlockVillageBoxMedium(), "BlockVillageBoxMedium");
        GameRegistry.registerBlock(blockVillageBoxLarge = new BlockVillageBoxLarge(), "BlockVillageBoxLarge");
        
        GameRegistry.registerBlock(blockVillageViewer = new BlockVillageViewer(), "BlockVillageViewer");
        GameRegistry.registerBlock(blockBuildingScanner = new BlockBuildingScanner(), "BlockBuildingScanner");
              
        GameRegistry.registerBlock(blockBuildingSmallHouse = new BlockBuildingSmallHouse(), "BlockBuildingSmallHouse");
        
        //buildings
        GameRegistry.registerBlock(blockVillageCenter = new BlockVillageBuilding(BuildingData.Type_VillageCenter,"BlockVillageCenter"),"BlockVillageCenter");
        GameRegistry.registerBlock(blockMiningHouse = new BlockVillageBuilding(BuildingData.Type_MiningHouse,"BlockMiningHouse"),"BlockMiningHouse");
        GameRegistry.registerBlock(blockBlackSmithsShop = new BlockVillageBuilding(BuildingData.Type_BlackSmithsShop,"BlockBlackSmithsShop"),"BlockBlackSmithsShop");
        GameRegistry.registerBlock(blockBakery = new BlockVillageBuilding(BuildingData.Type_Bakery,"BlockBakery"),"BlockBakery");
    }
}
