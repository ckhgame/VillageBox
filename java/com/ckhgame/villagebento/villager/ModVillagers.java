package com.ckhgame.villagebento.villager;

public class ModVillagers {
	public static void init(){
		Villager.registry.register(0, new VillagerVillageElder());
		
		Villager.registry.register(10, new VillagerMiner());
	}
}
