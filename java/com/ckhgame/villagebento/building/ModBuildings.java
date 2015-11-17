package com.ckhgame.villagebento.building;

public class ModBuildings {
	public static void init(){
		//groundworks
		Building.registry.register(0,new BuildingGroundworkSmall());
		Building.registry.register(1,new BuildingGroundworkMedium());
		Building.registry.register(2,new BuildingGroundworkLarge());
		//village center
		Building.registry.register(10,new BuildingVillageCenter());
		
		Building.registry.register(11,new BuildingBlacksmithsShop());
		Building.registry.register(12,new BuildingArchitectsHome());
		Building.registry.register(13,new BuildingFishingStore());
		Building.registry.register(14,new BuildingMiningHouse());
		Building.registry.register(15,new BuildingSmallBakery());
		Building.registry.register(16,new BuildingSmallHotel());
		Building.registry.register(17,new BuildingSmallTavern());
		
		Building.registry.register(19,new BuildingCowShop());
		Building.registry.register(20,new BuildingSheepShop());
		Building.registry.register(21,new BuildingChickenShop());
		Building.registry.register(22,new BuildingFlowerShop());
		Building.registry.register(23,new BuildingHunterHouse());
		Building.registry.register(24,new BuildingSmallCasino());
		Building.registry.register(27,new BuildingFarmland());
		Building.registry.register(28,new BuildingPotionStore());
		Building.registry.register(29,new BuildingDefenceTower());
		Building.registry.register(30,new BuildingSmallMilitaryCamp());
		Building.registry.register(25,new BuildingLargeCasino());
		Building.registry.register(31,new BuildingLargeMilitaryCamp());
		Building.registry.register(18,new BuildingLargeTavern());
		Building.registry.register(32,new BuildingProArchitectsHouse());
		Building.registry.register(33,new BuildingLargeBakery());
		Building.registry.register(34,new BuildingLargeHotel());
		Building.registry.register(35,new BuildingMarket());
		Building.registry.register(36,new BuildingFarmlandSmall());
		
		
		
		
		Building.registry.register(37,new BuildingAutumnGarden());
		Building.registry.register(38,new BuildingTeaChair());
		Building.registry.register(39,new BuildingRoseBridge());
		Building.registry.register(40,new BuildingRosePath());
		Building.registry.register(41,new BuildingPeacefulGarden());
		Building.registry.register(42,new BuildingSunflower());
		Building.registry.register(43,new BuildingChristmas());
		Building.registry.register(44,new BuildingLibrary());
		Building.registry.register(45,new BuildingTailorStore());


		Building.registry.register(1000,new BuildingPlayerFieldSmall());
		Building.registry.register(1001,new BuildingPlayerFieldMedium());
		Building.registry.register(1002,new BuildingPlayerFieldLarge());
		
	}
}
