package com.ckhgame.villagebento.building;

public class ModBuildings {
	public static void init(){
		//groundworks
		Building.register(0,new BuildingGroundworkSmall());
		Building.register(1,new BuildingGroundworkMedium());
		Building.register(2,new BuildingGroundworkLarge());
		//village center
		Building.register(10,new BuildingVillageCenter());
		
		Building.register(11,new BuildingBlacksmithsShop());
	}
}
