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
	}
}
