package com.ckhgame.villagebento.villager;

public class ModVillagers {
	public static void init(){
		Villager.registry.register(0, new VillagerVillageElder());
		
		Villager.registry.register(10, new VillagerMiner());
		Villager.registry.register(11, new VillagerMinerAssistant());
		Villager.registry.register(12, new VillagerNoviceBaker());
		Villager.registry.register(13, new VillagerArchitect());
		Villager.registry.register(14, new VillagerFisherman());
		Villager.registry.register(15, new VillagerHotelOwner());
		Villager.registry.register(16, new VillagerTavernOwner());
		
		Villager.registry.register(17, new VillagerBakerAssistant());
		Villager.registry.register(18, new VillagerBlackSmith());

		Villager.registry.register(19, new VillagerCasinoDealer());
		Villager.registry.register(20, new VillagerCasinoManager());
		Villager.registry.register(21, new VillagerChickenSeller());
		Villager.registry.register(22, new VillagerCowSeller());
		Villager.registry.register(23, new VillagerSheepSeller());
		Villager.registry.register(24, new VillagerFarmer());
		Villager.registry.register(25, new VillagerFlowerShopOwner());
		Villager.registry.register(26, new VillagerLargeHotelOwner());
		Villager.registry.register(27, new VillagerHunter());
		Villager.registry.register(28, new VillagerKnight());
//		Villager.registry.register(29, new VillagerTailor());
		Villager.registry.register(30, new VillagerMarksman());
		Villager.registry.register(31, new VillagerMerchant());
		Villager.registry.register(32, new VillagerProBaker());
		Villager.registry.register(33, new VillagerProArchitect());
		Villager.registry.register(34, new VillagerLargeTavernOwner());
		Villager.registry.register(35, new VillagerSoldier());
		Villager.registry.register(36, new VillagerCaptainSoldier());
		Villager.registry.register(37, new VillagerLargeCasinoManager());
		Villager.registry.register(38, new VillagerFarmMarketMerchant());
		Villager.registry.register(39, new VillagerPastureMarketMerchant());
		Villager.registry.register(40, new VillagerFarmerSmall());



	}
}
