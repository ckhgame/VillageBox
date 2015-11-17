package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;

import net.minecraft.init.Blocks;

public class BuildingPlayerFieldMedium extends Building {

	@Override
	public String getName() {
		return "Player Field Medium";
	}

	@Override
	public String getDescription() {
		return "The medium size player field";
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
		bb.addPlayerFieldSign(0,0,0);
	}

}
