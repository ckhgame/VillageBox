package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerProfessions;

import net.minecraft.init.Blocks;

public class BuildingGroundworkLarge extends Building {

	@Override
	public String getName() {
		return "Ground Work Large";
	}

	@Override
	public String getDescription() {
		return "The large size groundwork";
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
		return ConfigBuilding.SizeType_Large;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		
	}

}
