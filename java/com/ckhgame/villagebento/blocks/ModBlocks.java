package com.ckhgame.villagebento.blocks;

import com.ckhgame.villagebento.building.BuildingTypes;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {
    
    public static BlockBuildingScanner blockBuildingScanner;
    
    
    //buildings
    public static BlockVillageBuilding blockGroundworkOnlySmall;
    public static BlockVillageBuilding blockGroundworkOnlyMedium;
    public static BlockVillageBuilding blockGroundworkOnlyLarge;
    
    public static BlockVillageBuilding blockVillageCenter;
    public static BlockVillageBuilding blockMiningHouse;
    public static BlockVillageBuilding blockBlackSmithsShop;
    public static BlockVillageBuilding blockBakery;

    public static final void init() {
        
        GameRegistry.registerBlock(blockBuildingScanner = new BlockBuildingScanner(), "BlockBuildingScanner");
              
        
        //buildings
        GameRegistry.registerBlock(blockGroundworkOnlySmall = new BlockVillageBuilding(BuildingTypes.GroundWorkOnlySmall,"BlockGroundworkOnlySmall"),"BlockGroundworkOnlySmall");
        GameRegistry.registerBlock(blockGroundworkOnlyMedium = new BlockVillageBuilding(BuildingTypes.GroundWorkOnlyMedium,"BlockGroundworkOnlyMedium"),"BlockGroundworkOnlyMedium");
        GameRegistry.registerBlock(blockGroundworkOnlyLarge = new BlockVillageBuilding(BuildingTypes.GroundWorkOnlyLarge,"BlockGroundworkOnlyLarge"),"BlockGroundworkOnlyLarge");
        
        GameRegistry.registerBlock(blockVillageCenter = new BlockVillageBuilding(BuildingTypes.VillageCenter,"BlockVillageCenter"),"BlockVillageCenter");
        GameRegistry.registerBlock(blockMiningHouse = new BlockVillageBuilding(BuildingTypes.MiningHouse,"BlockMiningHouse"),"BlockMiningHouse");
        GameRegistry.registerBlock(blockBlackSmithsShop = new BlockVillageBuilding(BuildingTypes.BlackSmithsShop,"BlockBlackSmithsShop"),"BlockBlackSmithsShop");
        GameRegistry.registerBlock(blockBakery = new BlockVillageBuilding(BuildingTypes.Bakery,"BlockBakery"),"BlockBakery");
    }
}
