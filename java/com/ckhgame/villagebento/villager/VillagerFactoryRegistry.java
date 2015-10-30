package com.ckhgame.villagebento.villager;

import com.ckhgame.villagebento.building.BuildingFactory;
import com.ckhgame.villagebento.factory.FactoryRegistry;

public class VillagerFactoryRegistry {
	private static FactoryRegistry<BuildingFactory> instance = null;
	public static FactoryRegistry<BuildingFactory> get(){
		if(instance == null)
			instance = new FactoryRegistry<BuildingFactory>();
		return instance;
	}
}
