package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.building.BuildingArchitectsHome;
import com.ckhgame.villagebento.building.BuildingBlacksmithsShop;
import com.ckhgame.villagebento.building.BuildingChickenShop;
import com.ckhgame.villagebento.building.BuildingCowShop;
import com.ckhgame.villagebento.building.BuildingDefenceTower;
import com.ckhgame.villagebento.building.BuildingFarmland;
import com.ckhgame.villagebento.building.BuildingFishingStore;
import com.ckhgame.villagebento.building.BuildingFlowerShop;
import com.ckhgame.villagebento.building.BuildingGeneralStore;
import com.ckhgame.villagebento.building.BuildingGroundworkLarge;
import com.ckhgame.villagebento.building.BuildingGroundworkMedium;
import com.ckhgame.villagebento.building.BuildingGroundworkSmall;
import com.ckhgame.villagebento.building.BuildingHunterHouse;
import com.ckhgame.villagebento.building.BuildingLargeBakery;
import com.ckhgame.villagebento.building.BuildingLargeCasino;
import com.ckhgame.villagebento.building.BuildingLargeHotel;
import com.ckhgame.villagebento.building.BuildingLargeMilitaryCamp;
import com.ckhgame.villagebento.building.BuildingLargeTavern;
import com.ckhgame.villagebento.building.BuildingMiningHouse;
import com.ckhgame.villagebento.building.BuildingProArchitectsHouse;
import com.ckhgame.villagebento.building.BuildingSheepShop;
import com.ckhgame.villagebento.building.BuildingSmallBakery;
import com.ckhgame.villagebento.building.BuildingSmallCasino;
import com.ckhgame.villagebento.building.BuildingSmallHotel;
import com.ckhgame.villagebento.building.BuildingSmallMilitaryCamp;
import com.ckhgame.villagebento.building.BuildingSmallTavern;
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
    public static BlockVillageBuilding blockSmallHotel;
    public static BlockVillageBuilding blockSmallTavern;

    public static BlockVillageBuilding blockCowShop;
    public static BlockVillageBuilding blockSheepShop;
    public static BlockVillageBuilding blockChickenShop;
    public static BlockVillageBuilding blockSmallCasino;
    public static BlockVillageBuilding blockFarmland;
    public static BlockVillageBuilding blockFlowerShop;
    public static BlockVillageBuilding blockGeneralStore;
    public static BlockVillageBuilding blockDefenceTower;
    public static BlockVillageBuilding blockHunterHouse;
    public static BlockVillageBuilding blockSmallMilitaryCamp;
    public static BlockVillageBuilding blockLargeTavern;
    public static BlockVillageBuilding blockLargeMilitaryCamp;
    public static BlockVillageBuilding blockLargeCasino;
    public static BlockVillageBuilding blockLargeBakery;
    public static BlockVillageBuilding blockProArchitectsHouse;
    public static BlockVillageBuilding blockLargeHotel;


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
        GameRegistry.registerBlock(blockSmallHotel = new BlockVillageBuilding(BuildingSmallHotel.class,"BlockSmallHotel"),"BlockSmallHotel");
        GameRegistry.registerBlock(blockSmallTavern = new BlockVillageBuilding(BuildingSmallTavern.class,"BlockSmallTavern"),"BlockSmallTavern");
        
        GameRegistry.registerBlock(blockCowShop = new BlockVillageBuilding(BuildingCowShop.class,"BlockCowShop"),"BlockCowShop");
        GameRegistry.registerBlock(blockSheepShop = new BlockVillageBuilding(BuildingSheepShop.class,"BlockSheepShop"),"BlockSheepShop");
        GameRegistry.registerBlock(blockChickenShop = new BlockVillageBuilding(BuildingChickenShop.class,"BlockChickenShop"),"BlockChickenShop");
        GameRegistry.registerBlock(blockSmallCasino = new BlockVillageBuilding(BuildingSmallCasino.class,"BlockSmallCasino"),"BlockSmallCasino");
        GameRegistry.registerBlock(blockFarmland = new BlockVillageBuilding(BuildingFarmland.class,"BlockFarmland"),"BlockFarmland");
        GameRegistry.registerBlock(blockFlowerShop = new BlockVillageBuilding(BuildingFlowerShop.class,"BlockFlowerShop"),"BlockFlowerShop");
        GameRegistry.registerBlock(blockGeneralStore = new BlockVillageBuilding(BuildingGeneralStore.class,"BlockGeneralStore"),"BlockGeneralStore");
        GameRegistry.registerBlock(blockDefenceTower = new BlockVillageBuilding(BuildingDefenceTower.class,"BlockDefenceTower"),"BlockDefenceTower");
        GameRegistry.registerBlock(blockHunterHouse = new BlockVillageBuilding(BuildingHunterHouse.class,"BlockHunterHouse"),"BlockHunterHouse");
        GameRegistry.registerBlock(blockSmallMilitaryCamp = new BlockVillageBuilding(BuildingSmallMilitaryCamp.class,"BlockSmallMilitaryCamp"),"BlockSmallMilitaryCamp");
        GameRegistry.registerBlock(blockLargeMilitaryCamp = new BlockVillageBuilding(BuildingLargeMilitaryCamp.class,"BlockLargeMilitaryCamp"),"BlockLargeMilitaryCamp");
        GameRegistry.registerBlock(blockLargeTavern = new BlockVillageBuilding(BuildingLargeTavern.class,"BlockLargeTavern"),"BlockLargeTavern");
        GameRegistry.registerBlock(blockLargeCasino = new BlockVillageBuilding(BuildingLargeCasino.class,"BlockLargeCasino"),"BlockLargeCasino");
        GameRegistry.registerBlock(blockLargeBakery = new BlockVillageBuilding(BuildingLargeBakery.class,"BlockLargeBakery"),"BlockLargeBakery");
        GameRegistry.registerBlock(blockProArchitectsHouse = new BlockVillageBuilding(BuildingProArchitectsHouse.class,"BlockProArchitectsHouse"),"BlockProArchitectsHouse");
        GameRegistry.registerBlock(blockLargeHotel = new BlockVillageBuilding(BuildingLargeHotel.class,"BlockLargeHotel"),"BlockLargeHotel");

        
        
    }
}
