package com.ckhgame.villagebento.villager.component;

public class ModVillagerComps {
	public static void init(){
		VillagerComponent.registry.register(0, new VillagerCompAbout());
		VillagerComponent.registry.register(2, new VillagerCompSell());
	}
}
