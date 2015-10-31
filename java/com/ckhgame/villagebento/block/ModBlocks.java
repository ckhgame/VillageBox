package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.building.BuildingBlacksmithsShop;
import com.ckhgame.villagebento.building.BuildingGroundworkLarge;
import com.ckhgame.villagebento.building.BuildingGroundworkMedium;
import com.ckhgame.villagebento.building.BuildingGroundworkSmall;
import com.ckhgame.villagebento.building.BuildingVillageCenter;

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
        GameRegistry.registerBlock(blockGroundworkOnlySmall = new BlockVillageBuilding(BuildingGroundworkSmall.class,"BlockGroundworkOnlySmall"),"BlockGroundworkOnlySmall");
        GameRegistry.registerBlock(blockGroundworkOnlyMedium = new BlockVillageBuilding(BuildingGroundworkMedium.class,"BlockGroundworkOnlyMedium"),"BlockGroundworkOnlyMedium");
        GameRegistry.registerBlock(blockGroundworkOnlyLarge = new BlockVillageBuilding(BuildingGroundworkLarge.class,"BlockGroundworkOnlyLarge"),"BlockGroundworkOnlyLarge");
        
        GameRegistry.registerBlock(blockVillageCenter = new BlockVillageBuilding(BuildingVillageCenter.class,"BlockVillageCenter"),"BlockVillageCenter");
       // GameRegistry.registerBlock(blockMiningHouse = new BlockVillageBuilding(BuildingTypes.MiningHouse,"BlockMiningHouse"),"BlockMiningHouse");
        GameRegistry.registerBlock(blockBlackSmithsShop = new BlockVillageBuilding(BuildingBlacksmithsShop.class,"BlockBlackSmithsShop"),"BlockBlackSmithsShop");
       // GameRegistry.registerBlock(blockBakery = new BlockVillageBuilding(BuildingTypes.Bakery,"BlockBakery"),"BlockBakery");
    }
}
