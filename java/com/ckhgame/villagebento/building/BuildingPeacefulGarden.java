package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;

import net.minecraft.init.Blocks;

public class BuildingPeacefulGarden extends Building {

	@Override
	public String getName() {
		return "Small Flower Garden";
	}

	@Override
	public String getDescription() {
		return "Park";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,-3,Blocks.planks,2);bb.buildBlock(-3,-1,-2,Blocks.planks,2);bb.buildBlock(-3,-1,-1,Blocks.planks,2);
		bb.buildBlock(-3,-1,0,Blocks.planks,2);bb.buildBlock(-3,-1,1,Blocks.planks,2);bb.buildBlock(-3,-1,2,Blocks.planks,2);
		bb.buildBlock(-3,-1,3,Blocks.planks,2);bb.buildBlock(-2,-1,-3,Blocks.planks,2);bb.buildBlock(-2,-1,-2,Blocks.grass,0);
		bb.buildBlock(-2,-1,-1,Blocks.grass,0);bb.buildBlock(-2,-1,0,Blocks.grass,0);bb.buildBlock(-2,-1,1,Blocks.grass,0);
		bb.buildBlock(-2,-1,2,Blocks.grass,0);bb.buildBlock(-2,-1,3,Blocks.planks,2);bb.buildBlock(-1,-1,-3,Blocks.planks,2);
		bb.buildBlock(-1,-1,-2,Blocks.grass,0);bb.buildBlock(-1,-1,-1,Blocks.grass,0);bb.buildBlock(-1,-1,0,Blocks.water,0);
		bb.buildBlock(-1,-1,1,Blocks.grass,0);bb.buildBlock(-1,-1,2,Blocks.grass,0);bb.buildBlock(-1,-1,3,Blocks.planks,2);
		bb.buildBlock(0,-1,-3,Blocks.planks,2);bb.buildBlock(0,-1,-2,Blocks.grass,0);bb.buildBlock(0,-1,-1,Blocks.water,0);
		bb.buildBlock(0,-1,0,Blocks.water,0);bb.buildBlock(0,-1,1,Blocks.water,0);bb.buildBlock(0,-1,2,Blocks.grass,0);
		bb.buildBlock(0,-1,3,Blocks.planks,2);bb.buildBlock(1,-1,-3,Blocks.planks,2);bb.buildBlock(1,-1,-2,Blocks.grass,0);
		bb.buildBlock(1,-1,-1,Blocks.grass,0);bb.buildBlock(1,-1,0,Blocks.water,0);bb.buildBlock(1,-1,1,Blocks.grass,0);
		bb.buildBlock(1,-1,2,Blocks.grass,0);bb.buildBlock(1,-1,3,Blocks.planks,2);bb.buildBlock(2,-1,-3,Blocks.planks,2);
		bb.buildBlock(2,-1,-2,Blocks.grass,0);bb.buildBlock(2,-1,-1,Blocks.grass,0);bb.buildBlock(2,-1,0,Blocks.grass,0);
		bb.buildBlock(2,-1,1,Blocks.grass,0);bb.buildBlock(2,-1,2,Blocks.grass,0);bb.buildBlock(2,-1,3,Blocks.planks,2);
		bb.buildBlock(3,-1,-3,Blocks.planks,2);bb.buildBlock(3,-1,-2,Blocks.planks,2);bb.buildBlock(3,-1,-1,Blocks.planks,2);
		bb.buildBlock(3,-1,0,Blocks.planks,2);bb.buildBlock(3,-1,1,Blocks.planks,2);bb.buildBlock(3,-1,2,Blocks.planks,2);
		bb.buildBlock(3,-1,3,Blocks.planks,2);bb.buildBlock(-2,0,-2,Blocks.red_flower,2);bb.buildBlock(-2,0,-1,Blocks.red_flower,1);
		bb.buildBlock(-2,0,0,Blocks.red_flower,2);bb.buildBlock(-2,0,1,Blocks.red_flower,1);bb.buildBlock(-2,0,2,Blocks.red_flower,2);
		bb.buildBlock(-1,0,-2,Blocks.red_flower,1);bb.buildBlock(-1,0,-1,Blocks.double_plant,1);bb.buildBlock(-1,0,1,Blocks.double_plant,1);
		bb.buildBlock(-1,0,2,Blocks.red_flower,1);bb.buildBlock(0,0,-2,Blocks.red_flower,2);bb.buildBlock(0,0,2,Blocks.red_flower,2);
		bb.buildBlock(1,0,-2,Blocks.red_flower,1);bb.buildBlock(1,0,-1,Blocks.double_plant,1);bb.buildBlock(1,0,1,Blocks.double_plant,1);
		bb.buildBlock(1,0,2,Blocks.red_flower,1);bb.buildBlock(2,0,-2,Blocks.red_flower,2);bb.buildBlock(2,0,-1,Blocks.red_flower,1);
		bb.buildBlock(2,0,0,Blocks.red_flower,2);bb.buildBlock(2,0,1,Blocks.red_flower,1);bb.buildBlock(2,0,2,Blocks.red_flower,2);
		bb.buildBlock(-1,1,-1,Blocks.double_plant,10);bb.buildBlock(-1,1,1,Blocks.double_plant,9);bb.buildBlock(1,1,-1,Blocks.double_plant,10);
		bb.buildBlock(1,1,1,Blocks.double_plant,8);
	}

}
