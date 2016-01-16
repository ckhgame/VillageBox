package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.building.BuidlingBuildersHome;
import com.ckhgame.villagebento.building.BuildingAutumnGarden;
import com.ckhgame.villagebento.building.BuildingBlacksmithsShop;
import com.ckhgame.villagebento.building.BuildingChickenShop;
import com.ckhgame.villagebento.building.BuildingChristmas;
import com.ckhgame.villagebento.building.BuildingChurch;
import com.ckhgame.villagebento.building.BuildingCowShop;
import com.ckhgame.villagebento.building.BuildingDefenceTower;
import com.ckhgame.villagebento.building.BuildingFarmland;
import com.ckhgame.villagebento.building.BuildingFarmlandSmall;
import com.ckhgame.villagebento.building.BuildingFishingStore;
import com.ckhgame.villagebento.building.BuildingFlowerShop;
import com.ckhgame.villagebento.building.BuildingFolkHouse;
import com.ckhgame.villagebento.building.BuildingFurnitureStore;
import com.ckhgame.villagebento.building.BuildingGroundworkLarge;
import com.ckhgame.villagebento.building.BuildingGroundworkMedium;
import com.ckhgame.villagebento.building.BuildingGroundworkSmall;
import com.ckhgame.villagebento.building.BuildingHunterHouse;
import com.ckhgame.villagebento.building.BuildingLargeBakery;
import com.ckhgame.villagebento.building.BuildingLargeCasino;
import com.ckhgame.villagebento.building.BuildingLargeHotel;
import com.ckhgame.villagebento.building.BuildingLargeMilitaryCamp;
import com.ckhgame.villagebento.building.BuildingLargeTavern;
import com.ckhgame.villagebento.building.BuildingLibrary;
import com.ckhgame.villagebento.building.BuildingMarket;
import com.ckhgame.villagebento.building.BuildingMiningHouse;
import com.ckhgame.villagebento.building.BuildingPeacefulGarden;
import com.ckhgame.villagebento.building.BuildingPlayerFieldLarge;
import com.ckhgame.villagebento.building.BuildingPlayerFieldMedium;
import com.ckhgame.villagebento.building.BuildingPlayerFieldSmall;
import com.ckhgame.villagebento.building.BuildingPotionStore;
import com.ckhgame.villagebento.building.BuildingRoseBridge;
import com.ckhgame.villagebento.building.BuildingRosePath;
import com.ckhgame.villagebento.building.BuildingSheepShop;
import com.ckhgame.villagebento.building.BuildingSmallBakery;
import com.ckhgame.villagebento.building.BuildingSmallCasino;
import com.ckhgame.villagebento.building.BuildingSmallHotel;
import com.ckhgame.villagebento.building.BuildingSmallMilitaryCamp;
import com.ckhgame.villagebento.building.BuildingSmallTavern;
import com.ckhgame.villagebento.building.BuildingSunflower;
import com.ckhgame.villagebento.building.BuildingTailorStore;
import com.ckhgame.villagebento.building.BuildingTeaChair;
import com.ckhgame.villagebento.building.BuildingTownSquareLarge;
import com.ckhgame.villagebento.building.BuildingTownSquareSmall;
import com.ckhgame.villagebento.building.BuildingVillageCenter;
import com.ckhgame.villagebento.entity.animal.EntityVBChicken;
import com.ckhgame.villagebento.entity.animal.EntityVBCow;
import com.ckhgame.villagebento.entity.animal.EntityVBSheep;
import com.ckhgame.villagebento.item.ItemBlockMeta;
import com.ckhgame.villagebento.item.ItemBlockVillageBuilding;
import com.ckhgame.villagebento.model.ModelChair;
import com.ckhgame.villagebento.model.ModelTable;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks {
    
    public static BlockBuildingScanner blockBuildingScanner;
    
    public static BlockBuildingDestroyer blockBuildingDestroyer;
    
    public static BlockVillagerHomeTP blockVillagerHomeTP;
    
    //buildings
    public static BlockVillageBuilding blockGroundworkOnlySmall;
    public static BlockVillageBuilding blockGroundworkOnlyMedium;
    public static BlockVillageBuilding blockGroundworkOnlyLarge;
    
    public static BlockVillageBuilding blockVillageCenter;
    public static BlockVillageBuilding blockMiningHouse;
    public static BlockVillageBuilding blockBlackSmithsShop;
    public static BlockVillageBuilding blockSmallBakery;
    public static BlockVillageBuilding blockBuildersHome;
    public static BlockVillageBuilding blockFishingStore;
    public static BlockVillageBuilding blockSmallHotel;
    public static BlockVillageBuilding blockSmallTavern;
    public static BlockVillageBuilding blockCowShop;
    public static BlockVillageBuilding blockSheepShop;
    public static BlockVillageBuilding blockChickenShop;
    public static BlockVillageBuilding blockSmallCasino;
    public static BlockVillageBuilding blockFarmland;
    public static BlockVillageBuilding blockFlowerShop;
    public static BlockVillageBuilding blockPotionStore;
    public static BlockVillageBuilding blockDefenceTower;
    public static BlockVillageBuilding blockHunterHouse;
    public static BlockVillageBuilding blockSmallMilitaryCamp;
    public static BlockVillageBuilding blockLargeTavern;
    public static BlockVillageBuilding blockLargeMilitaryCamp;
    public static BlockVillageBuilding blockLargeCasino;
    public static BlockVillageBuilding blockLargeBakery;
    public static BlockVillageBuilding blockFurnitureStore;
    public static BlockVillageBuilding blockLargeHotel;
    public static BlockVillageBuilding blockMarket;
    public static BlockVillageBuilding blockFarmlandSmall;
    public static BlockVillageBuilding blockLibrary;
    public static BlockVillageBuilding blockTailorStore;
    public static BlockVillageBuilding blockTownSquareSmall;
    public static BlockVillageBuilding blockTownSquareLarge;
    public static BlockVillageBuilding blockChurch;
    
    public static BlockVillageBuilding blockFolkHouse;;
    
//  Decoration Blocks
    public static BlockVillageBuilding blockAutumnGarden;
    public static BlockVillageBuilding blockChristmas;
    public static BlockVillageBuilding blockPeacefulGarden;
    public static BlockVillageBuilding blockRoseBridge;
    public static BlockVillageBuilding blockRosePath;
    public static BlockVillageBuilding blockSunflower;
    public static BlockVillageBuilding blockTeaChair;
    
    //player field
    public static BlockVillageBuilding blockPlayerFieldSmall;
    public static BlockVillageBuilding blockPlayerFieldMedium;
    public static BlockVillageBuilding blockPlayerFieldLarge;
    
    //Animal boxes
    public static BlockVillageAnimal blockChicken;
    public static BlockVillageAnimal blockSheep;
    public static BlockVillageAnimal blockCow;
    
    //crops
    public static BlockVBCrops blockRicePlant;
    public static BlockVBCrops blockCabbage;
    public static BlockVBCrops blockChili;
    public static BlockVBCrops blockSoybeans;
    public static BlockVBCrops blockCorn;
    public static BlockVBCrops blockGrapes;
    
    //decorations
    public static BlockTopSides blockWineShelf;
    public static BlockTopSides blockWineBucket;
    
    //furnitures
    public static BlockMountable blockOakChair;
    public static BlockCustom blockOakTable;
    public static BlockMountable blockBirchChair;
    public static BlockCustom blockBirchTable;
    
    public static BlockVillageWool blockVillageWool;
    public static BlockVillageCarpet blockVillageCarpet;
    
    public static final void init() {
        
    	GameRegistry.registerBlock(blockBuildingScanner = new BlockBuildingScanner(), "BlockBuildingScanner");
    	GameRegistry.registerBlock(blockVillagerHomeTP = new BlockVillagerHomeTP(), "BlockVillagerHomeTP");
         
    	GameRegistry.registerBlock(blockBuildingDestroyer = new BlockBuildingDestroyer(), "BlockBuildingDestroyer");
             
        //buildings
        registerVillageBlock(blockGroundworkOnlySmall = new BlockVillageBuilding(BuildingGroundworkSmall.class,"BlockGroundworkOnlySmall"),"BlockGroundworkOnlySmall");
        registerVillageBlock(blockGroundworkOnlyMedium = new BlockVillageBuilding(BuildingGroundworkMedium.class,"BlockGroundworkOnlyMedium"),"BlockGroundworkOnlyMedium");
        registerVillageBlock(blockGroundworkOnlyLarge = new BlockVillageBuilding(BuildingGroundworkLarge.class,"BlockGroundworkOnlyLarge"),"BlockGroundworkOnlyLarge");
        
        registerVillageBlock(blockVillageCenter = new BlockVillageBuilding(BuildingVillageCenter.class,"BlockVillageCenter"),"BlockVillageCenter");
        registerVillageBlock(blockBlackSmithsShop = new BlockVillageBuilding(BuildingBlacksmithsShop.class,"BlockBlackSmithsShop"),"BlockBlackSmithsShop");
        registerVillageBlock(blockBuildersHome = new BlockVillageBuilding(BuidlingBuildersHome.class,"BlockBuildersHome"),"BlockBuildersHome");
        registerVillageBlock(blockFishingStore = new BlockVillageBuilding(BuildingFishingStore.class,"BlockFishingStore"),"BlockFishingStore");
        registerVillageBlock(blockMiningHouse = new BlockVillageBuilding(BuildingMiningHouse.class,"BlockMiningHouse"),"BlockMiningHouse");
        registerVillageBlock(blockSmallBakery = new BlockVillageBuilding(BuildingSmallBakery.class,"BlockSmallBakery"),"BlockSmallBakery");
        registerVillageBlock(blockSmallHotel = new BlockVillageBuilding(BuildingSmallHotel.class,"BlockSmallHotel"),"BlockSmallHotel");
        registerVillageBlock(blockSmallTavern = new BlockVillageBuilding(BuildingSmallTavern.class,"BlockSmallTavern"),"BlockSmallTavern");
        
        registerVillageBlock(blockCowShop = new BlockVillageBuilding(BuildingCowShop.class,"BlockCowShop"),"BlockCowShop");
        registerVillageBlock(blockSheepShop = new BlockVillageBuilding(BuildingSheepShop.class,"BlockSheepShop"),"BlockSheepShop");
        registerVillageBlock(blockChickenShop = new BlockVillageBuilding(BuildingChickenShop.class,"BlockChickenShop"),"BlockChickenShop");
        registerVillageBlock(blockSmallCasino = new BlockVillageBuilding(BuildingSmallCasino.class,"BlockSmallCasino"),"BlockSmallCasino");
        registerVillageBlock(blockFarmland = new BlockVillageBuilding(BuildingFarmland.class,"BlockFarmland"),"BlockFarmland");
        registerVillageBlock(blockFarmlandSmall = new BlockVillageBuilding(BuildingFarmlandSmall.class,"BlockFarmlandSmall"),"BlockFarmlandSmall");
        registerVillageBlock(blockFlowerShop = new BlockVillageBuilding(BuildingFlowerShop.class,"BlockFlowerShop"),"BlockFlowerShop");
        registerVillageBlock(blockPotionStore = new BlockVillageBuilding(BuildingPotionStore.class,"BlockPotionStore"),"BlockPotionStore");
        registerVillageBlock(blockDefenceTower = new BlockVillageBuilding(BuildingDefenceTower.class,"BlockDefenceTower"),"BlockDefenceTower");
        registerVillageBlock(blockHunterHouse = new BlockVillageBuilding(BuildingHunterHouse.class,"BlockHunterHouse"),"BlockHunterHouse");
        registerVillageBlock(blockSmallMilitaryCamp = new BlockVillageBuilding(BuildingSmallMilitaryCamp.class,"BlockSmallMilitaryCamp"),"BlockSmallMilitaryCamp");
        registerVillageBlock(blockLargeMilitaryCamp = new BlockVillageBuilding(BuildingLargeMilitaryCamp.class,"BlockLargeMilitaryCamp"),"BlockLargeMilitaryCamp");
        registerVillageBlock(blockLargeTavern = new BlockVillageBuilding(BuildingLargeTavern.class,"BlockLargeTavern"),"BlockLargeTavern");
        registerVillageBlock(blockLargeCasino = new BlockVillageBuilding(BuildingLargeCasino.class,"BlockLargeCasino"),"BlockLargeCasino");
        registerVillageBlock(blockLargeBakery = new BlockVillageBuilding(BuildingLargeBakery.class,"BlockLargeBakery"),"BlockLargeBakery");
        registerVillageBlock(blockFurnitureStore = new BlockVillageBuilding(BuildingFurnitureStore.class,"BlockFurnitureStore"),"BlockFurnitureStore");
        registerVillageBlock(blockLargeHotel = new BlockVillageBuilding(BuildingLargeHotel.class,"BlockLargeHotel"),"BlockLargeHotel");
        registerVillageBlock(blockMarket = new BlockVillageBuilding(BuildingMarket.class,"BlockMarket"),"BlockMarket");
       	registerVillageBlock(blockLibrary = new BlockVillageBuilding(BuildingLibrary.class,"BlockLibrary"),"BlockLibrary");
       	registerVillageBlock(blockTailorStore = new BlockVillageBuilding(BuildingTailorStore.class,"BlockTailorStore"),"BlockTailorStore");
       	registerVillageBlock(blockTownSquareSmall = new BlockVillageBuilding(BuildingTownSquareSmall.class,"BlockTownSquareSmall"),"BlockTownSquareSmall");
       	registerVillageBlock(blockTownSquareLarge = new BlockVillageBuilding(BuildingTownSquareLarge.class,"BlockTownSquareLarge"),"BlockTownSquareLarge");
       	registerVillageBlock(blockChurch = new BlockVillageBuilding(BuildingChurch.class,"BlockChurch"),"BlockChurch");
       	
       	registerVillageBlock(blockFolkHouse = new BlockVillageBuilding(BuildingFolkHouse.class,"BlockFolkHouse"),"BlockFolkHouse");
       	
        //	Decoration Blocks
        registerVillageBlock(blockAutumnGarden = new BlockVillageBuilding(BuildingAutumnGarden.class,"BlockAutumnGarden"),"BlockAutumnGarden");
        registerVillageBlock(blockChristmas = new BlockVillageBuilding(BuildingChristmas.class,"BlockChristmas"),"BlockChristmas");
        registerVillageBlock(blockSunflower = new BlockVillageBuilding(BuildingSunflower.class,"BlockSunflower"),"BlockSunflower");
        registerVillageBlock(blockRosePath = new BlockVillageBuilding(BuildingRosePath.class,"BlockRosePath"),"BlockRosePath");
        registerVillageBlock(blockRoseBridge = new BlockVillageBuilding(BuildingRoseBridge.class,"BlockRoseBridge"),"BlockRoseBridge");
       	registerVillageBlock(blockTeaChair = new BlockVillageBuilding(BuildingTeaChair.class,"BlockTeaChair"),"BlockTeaChair");
       	registerVillageBlock(blockPeacefulGarden = new BlockVillageBuilding(BuildingPeacefulGarden.class,"BlockPeacefulGarden"),"BlockPeacefulGarden");
      
       	
       	//player field
       	registerVillageBlock(blockPlayerFieldSmall = new BlockVillageBuilding(BuildingPlayerFieldSmall.class,"BlockPlayerFieldSmall",true),"BlockPlayerFieldSmall");
       	registerVillageBlock(blockPlayerFieldMedium = new BlockVillageBuilding(BuildingPlayerFieldMedium.class,"BlockPlayerFieldMedium",true),"BlockPlayerFieldMedium");
       	registerVillageBlock(blockPlayerFieldLarge = new BlockVillageBuilding(BuildingPlayerFieldLarge.class,"BlockPlayerFieldLarge",true),"BlockPlayerFieldLarge");
       	
       	//Animal boxes
       	GameRegistry.registerBlock(blockChicken = new BlockVillageAnimal(EntityVBChicken.class,"BlockChicken"),"BlockChicken");
       	GameRegistry.registerBlock(blockSheep = new BlockVillageAnimal(EntityVBSheep.class,"BlockSheep"),"BlockSheep");
       	GameRegistry.registerBlock(blockCow = new BlockVillageAnimal(EntityVBCow.class,"BlockCow"),"BlockCow");
       	
       	//crops
       	GameRegistry.registerBlock(blockRicePlant = new BlockVBCrops("BlockRiceplant","ItemRiceSeed","ItemRiceplant"),"BlockRiceplant");
       	GameRegistry.registerBlock(blockCabbage = new BlockVBCrops("BlockCabbage","ItemCabbageSeed","ItemCabbage"),"BlockCabbage");
       	GameRegistry.registerBlock(blockChili = new BlockVBCrops("BlockChili","ItemChiliSeed","ItemChili"),"BlockChili");
       	GameRegistry.registerBlock(blockSoybeans = new BlockVBCrops("BlockSoybeans","ItemSoybeanSeed","ItemSoybeans"),"BlockSoybeans");
       	GameRegistry.registerBlock(blockCorn = new BlockVBCrops("BlockCorn","ItemCornSeed","ItemCorn"),"BlockCorn");
       	GameRegistry.registerBlock(blockGrapes = new BlockVBCrops("BlockGrapes","ItemGrapeSeed","ItemGrapes"),"BlockGrapes");
       	
       	//decoration
       	GameRegistry.registerBlock(blockWineShelf = new BlockTopSides("BlockWineShelf"),"BlockWineShelf");
       	GameRegistry.registerBlock(blockWineBucket = new BlockTopSides("BlockWineBucket"),"BlockWineBucket");
       	
       	GameRegistry.registerBlock(blockVillageWool = new BlockVillageWool(),ItemBlockMeta.class,"BlockVillageWool");
       	GameRegistry.registerBlock(blockVillageCarpet = new BlockVillageCarpet(),ItemBlockMeta.class,"BlockVillageCarpet");
       	
       	//furniture
       	// ** mountable
       	GameRegistry.registerBlock(blockOakChair = new BlockMountable("BlockOakChair",new ModelChair(),"planks_oak"),"BlockOakChair");
       	GameRegistry.registerBlock(blockOakTable = new BlockCustom("BlockOakTable",new ModelTable(),"planks_oak",Material.wood),"BlockOakTable");
    	GameRegistry.registerBlock(blockBirchChair = new BlockMountable("BlockBirchChair",new ModelChair(),"planks_birch"),"BlockBirchChair");
       	GameRegistry.registerBlock(blockBirchTable = new BlockCustom("BlockBirchTable",new ModelTable(),"planks_birch",Material.wood),"BlockBirchTable");
    }
    
    private static void registerVillageBlock(Block block,String name){
    	GameRegistry.registerBlock(block,ItemBlockVillageBuilding.class,name);
    }
}
