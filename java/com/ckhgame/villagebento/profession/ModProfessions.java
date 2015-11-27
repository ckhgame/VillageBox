package com.ckhgame.villagebento.profession;

public class ModProfessions {
	public static void init(){
		Profession.registry.register(0, new ProfessionVillageElder());
		
		Profession.registry.register(10, new ProfessionMiner());
		Profession.registry.register(11, new ProfessionMinerAssistant());
		Profession.registry.register(12, new ProfessionNoviceBaker());
		Profession.registry.register(13, new ProfessionArchitect());
		Profession.registry.register(14, new ProfessionFisherman());
		Profession.registry.register(15, new ProfessionHotelOwner());
		Profession.registry.register(16, new ProfessionTavernOwner());
		
		Profession.registry.register(17, new ProfessionBakerAssistant());
		Profession.registry.register(18, new ProfessionBlackSmith());

		Profession.registry.register(19, new ProfessionCasinoDealer());
		Profession.registry.register(20, new ProfessionCasinoManager());
		Profession.registry.register(21, new ProfessionChickenSeller());
		Profession.registry.register(22, new ProfessionCowSeller());
		Profession.registry.register(23, new ProfessionSheepSeller());
		Profession.registry.register(24, new ProfessionFarmer());
		Profession.registry.register(25, new ProfessionFlowerShopOwner());
		Profession.registry.register(26, new ProfessionLargeHotelOwner());
		Profession.registry.register(27, new ProfessionHunter());
		Profession.registry.register(28, new ProfessionKnight());
		Profession.registry.register(29, new ProfessionTailor());
		Profession.registry.register(30, new ProfessionMarksman());
		Profession.registry.register(31, new ProfessionMerchant());
		Profession.registry.register(32, new ProfessionProBaker());
		Profession.registry.register(33, new ProfessionProArchitect());
		Profession.registry.register(34, new ProfessionLargeTavernOwner());
		Profession.registry.register(35, new ProfessionSoldier());
		Profession.registry.register(36, new ProfessionCaptainSoldier());
		Profession.registry.register(37, new ProfessionLargeCasinoManager());
		Profession.registry.register(38, new ProfessionFarmMarketMerchant());
		Profession.registry.register(39, new ProfessionPastureMarketMerchant());
		Profession.registry.register(40, new ProfessionFarmerSmall());
		Profession.registry.register(41, new ProfessionLibrarian());



	}
}
