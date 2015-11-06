package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.building.BuildingArchitectsHome;
import com.ckhgame.villagebento.building.BuildingBlacksmithsShop;
import com.ckhgame.villagebento.building.BuildingFishingStore;
import com.ckhgame.villagebento.building.BuildingGroundworkLarge;
import com.ckhgame.villagebento.building.BuildingGroundworkMedium;
import com.ckhgame.villagebento.building.BuildingGroundworkSmall;
import com.ckhgame.villagebento.building.BuildingMiningHouse;
import com.ckhgame.villagebento.building.BuildingSmallBakery;
import com.ckhgame.villagebento.building.BuildingVillageCenter;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {
    
    public static BlockBuildingScanner blockBuildingScanner;
    
    public static BlockBuildingDestroyer blockBuildingDestroyer;
    
    //buildings
    public static BlockVillageBuilding blockGroundworkOnlySmall;
    public static BlockVillageBuilding blockGroundworkOnlyMedium;
    public static BlockVillageBuilding blockGroundworkOnlyLarge;
    
    public static BlockVillageBuilding blockVillageCenter;
    public static BlockVillageBuilding blockMiningHouse;
    public static BlockVillageBuilding blockBlackSmithsShop;
    public static BlockVillageBuilding blockSmallBakery;
    public static BlockVillageBuilding blockArchitectsHome;
    public static BlockVillageBuilding blockFishingStore;

    public static final void init() {
        
        GameRegistry.registerBlock(blockBuildingScanner = new BlockBuildingScanner(), "BlockBuildingScanner");
         
        GameRegistry.registerBlock(blockBuildingDestroyer = new BlockBuildingDestroyer(), "BlockBuildingDestroyer");
             
        //buildings
        GameRegistry.registerBlock(blockGroundworkOnlySmall = new BlockVillageBuilding(BuildingGroundworkSmall.class,"BlockGroundworkOnlySmall"),"BlockGroundworkOnlySmall");
        GameRegistry.registerBlock(blockGroundworkOnlyMedium = new BlockVillageBuilding(BuildingGroundworkMedium.class,"BlockGroundworkOnlyMedium"),"BlockGroundworkOnlyMedium");
        GameRegistry.registerBlock(blockGroundworkOnlyLarge = new BlockVillageBuilding(BuildingGroundworkLarge.class,"BlockGroundworkOnlyLarge"),"BlockGroundworkOnlyLarge");
        
        GameRegistry.registerBlock(blockVillageCenter = new BlockVillageBuilding(BuildingVillageCenter.class,"BlockVillageCenter"),"BlockVillageCenter");
        GameRegistry.registerBlock(blockBlackSmithsShop = new BlockVillageBuilding(BuildingBlacksmithsShop.class,"BlockBlackSmithsShop"),"BlockBlackSmithsShop");
        GameRegistry.registerBlock(blockArchitectsHome = new BlockVillageBuilding(BuildingArchitectsHome.class,"BlockArchitectsHome"),"BlockArchitectsHome");
        GameRegistry.registerBlock(blockFishingStore = new BlockVillageBuilding(BuildingFishingStore.class,"BlockFishingStore"),"BlockFishingStore");
        GameRegistry.registerBlock(blockMiningHouse = new BlockVillageBuilding(BuildingMiningHouse.class,"BlockMiningHouse"),"BlockMiningHouse");
        GameRegistry.registerBlock(blockSmallBakery = new BlockVillageBuilding(BuildingSmallBakery.class,"BlockSmallBakery"),"BlockSmallBakery");
    }
}
