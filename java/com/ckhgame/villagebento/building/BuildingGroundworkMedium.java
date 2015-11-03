	package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;

public class BuildingGroundworkMedium extends Building {

	@Override
	public String getName() {
		return "Ground Work Medium";
	}

	@Override
	public String getDescription() {
		return "The medium size groundwork";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		
	}

}
