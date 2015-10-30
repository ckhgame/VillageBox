package com.ckhgame.villagebento.building;

public class BFVillageCenter extends BuildingFactory{

	public BFVillageCenter(int productType) {
		super(productType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getBuildingName() {

		return "VillageCenter";
	}

	@Override
	public String getBuildingDescription() {
		// TODO Auto-generated method stub
		return "Helps you to build early level buildings";
	}

	@Override
	public int build() {
		// TODO Auto-generated method stub
		return 0;
	}

}
