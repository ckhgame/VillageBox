package com.ckhgame.villagebento.profession;

public class ModProfessions {
	public static void init(){
		Profession.registry.register(0, new ProfessionVillageElder());
		
		int id = 10;
		
		Profession.registry.register(id++, new ProfessionMiner());
		Profession.registry.register(id++, new ProfessionMinerAssistant());
		Profession.registry.register(id++, new ProfessionNoviceBaker());
		Profession.registry.register(id++, new ProfessionArchitect());
		Profession.registry.register(id++, new ProfessionFisherman());
		Profession.registry.register(id++, new ProfessionHotelOwner());
		Profession.registry.register(id++, new ProfessionTavernOwner());
		
		Profession.registry.register(id++, new ProfessionBakerAssistant());
		Profession.registry.register(id++, new ProfessionBlackSmith());

		Profession.registry.register(id++, new ProfessionCasinoDealer());
		Profession.registry.register(id++, new ProfessionCasinoManager());
		Profession.registry.register(id++, new ProfessionChickenSeller());
		Profession.registry.register(id++, new ProfessionCowSeller());
		Profession.registry.register(id++, new ProfessionSheepSeller());
		Profession.registry.register(id++, new ProfessionFarmer());
		Profession.registry.register(id++, new ProfessionFlowerShopOwner());
		Profession.registry.register(id++, new ProfessionLargeHotelOwner());
		Profession.registry.register(id++, new ProfessionHunter());
		Profession.registry.register(id++, new ProfessionKnight());
		Profession.registry.register(id++, new ProfessionTailor());
		Profession.registry.register(id++, new ProfessionMarksman());
		Profession.registry.register(id++, new ProfessionMerchant());
		Profession.registry.register(id++, new ProfessionProBaker());
		Profession.registry.register(id++, new ProfessionProArchitect());
		Profession.registry.register(id++, new ProfessionLargeTavernOwner());
		Profession.registry.register(id++, new ProfessionSoldier());
		Profession.registry.register(id++, new ProfessionCaptainSoldier());
		Profession.registry.register(id++, new ProfessionLargeCasinoManager());
		Profession.registry.register(id++, new ProfessionFarmMarketMerchant());
		Profession.registry.register(id++, new ProfessionPastureMarketMerchant());
		Profession.registry.register(id++, new ProfessionFarmerSmall());
		Profession.registry.register(id++, new ProfessionLibrarian());
		Profession.registry.register(id++, new ProfessionPriest());
		
		Profession.registry.register(id++, new ProfessionVillagerFolk0());
		Profession.registry.register(id++, new ProfessionVillagerFolk1());
		Profession.registry.register(id++, new ProfessionVillagerFolk2());
		Profession.registry.register(id++, new ProfessionVillagerFolk3());
		Profession.registry.register(id++, new ProfessionVillagerFolk4());
	}
}
