package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.factory.Factory;

public abstract class BuildingFactory extends Factory {

	public BuildingFactory(int productType) {
		super(productType);
		// TODO Auto-generated constructor stub
	}
	
	public abstract String getBuildingName();
	
	public abstract String getBuildingDescription();
	
}
