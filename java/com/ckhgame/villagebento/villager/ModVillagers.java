package com.ckhgame.villagebento.villager;

public class ModVillagers {
	public static void init(){
		Villager.registry.register(0, new VillagerVillageElder());
		
		Villager.registry.register(11, new VillagerMiner());
		Villager.registry.register(12, new VillagerNoviceBaker());
		Villager.registry.register(13, new VillagerArchitect());
		Villager.registry.register(14, new VillagerFisherman());
	}
}
