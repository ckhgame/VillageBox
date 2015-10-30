package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.factory.FactoryRegistry;

public class BuildingFactoryRegistry {
	private static FactoryRegistry<BuildingFactory> instance = null;
	public static FactoryRegistry<BuildingFactory> get(){
		if(instance == null)
			instance = new FactoryRegistry<BuildingFactory>();
		return instance;
	}
}
