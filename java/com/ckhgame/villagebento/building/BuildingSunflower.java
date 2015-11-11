package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMerchant;

import net.minecraft.init.Blocks;

public class BuildingSunflower extends Building {

	@Override
	public String getName() {
		return "Summer Garden";
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
		bb.buildBlock(-3,-1,-3,Blocks.grass,0);bb.buildBlock(-3,-1,-2,Blocks.sand,0);bb.buildBlock(-3,-1,-1,Blocks.sand,0);
		bb.buildBlock(-3,-1,0,Blocks.grass,0);bb.buildBlock(-3,-1,1,Blocks.sand,0);bb.buildBlock(-3,-1,2,Blocks.sand,0);
		bb.buildBlock(-3,-1,3,Blocks.grass,0);bb.buildBlock(-2,-1,-3,Blocks.sand,0);bb.buildBlock(-2,-1,-2,Blocks.water,0);
		bb.buildBlock(-2,-1,-1,Blocks.water,0);bb.buildBlock(-2,-1,0,Blocks.sand,0);bb.buildBlock(-2,-1,1,Blocks.water,0);
		bb.buildBlock(-2,-1,2,Blocks.water,0);bb.buildBlock(-2,-1,3,Blocks.sand,0);bb.buildBlock(-1,-1,-3,Blocks.sand,0);
		bb.buildBlock(-1,-1,-2,Blocks.water,0);bb.buildBlock(-1,-1,-1,Blocks.water,0);bb.buildBlock(-1,-1,0,Blocks.grass,0);
		bb.buildBlock(-1,-1,1,Blocks.water,0);bb.buildBlock(-1,-1,2,Blocks.water,0);bb.buildBlock(-1,-1,3,Blocks.sand,0);
		bb.buildBlock(0,-1,-3,Blocks.grass,0);bb.buildBlock(0,-1,-2,Blocks.sand,0);bb.buildBlock(0,-1,-1,Blocks.grass,0);
		bb.buildBlock(0,-1,0,Blocks.grass,0);bb.buildBlock(0,-1,1,Blocks.grass,0);bb.buildBlock(0,-1,2,Blocks.sand,0);
		bb.buildBlock(0,-1,3,Blocks.grass,0);bb.buildBlock(1,-1,-3,Blocks.sand,0);bb.buildBlock(1,-1,-2,Blocks.water,0);
		bb.buildBlock(1,-1,-1,Blocks.water,0);bb.buildBlock(1,-1,0,Blocks.grass,0);bb.buildBlock(1,-1,1,Blocks.water,0);
		bb.buildBlock(1,-1,2,Blocks.water,0);bb.buildBlock(1,-1,3,Blocks.sand,0);bb.buildBlock(2,-1,-3,Blocks.sand,0);
		bb.buildBlock(2,-1,-2,Blocks.water,0);bb.buildBlock(2,-1,-1,Blocks.water,0);bb.buildBlock(2,-1,0,Blocks.sand,0);
		bb.buildBlock(2,-1,1,Blocks.water,0);bb.buildBlock(2,-1,2,Blocks.water,0);bb.buildBlock(2,-1,3,Blocks.sand,0);
		bb.buildBlock(3,-1,-3,Blocks.grass,0);bb.buildBlock(3,-1,-2,Blocks.sand,0);bb.buildBlock(3,-1,-1,Blocks.sand,0);
		bb.buildBlock(3,-1,0,Blocks.grass,0);bb.buildBlock(3,-1,1,Blocks.sand,0);bb.buildBlock(3,-1,2,Blocks.sand,0);
		bb.buildBlock(3,-1,3,Blocks.grass,0);bb.buildBlock(-3,0,-3,Blocks.red_flower,3);bb.buildBlock(-3,0,0,Blocks.red_flower,3);
		bb.buildBlock(-3,0,3,Blocks.red_flower,3);bb.buildBlock(-1,0,0,Blocks.yellow_flower,0);bb.buildBlock(0,0,-3,Blocks.red_flower,3);
		bb.buildBlock(0,0,-1,Blocks.yellow_flower,0);bb.buildBlock(0,0,0,Blocks.double_plant,0);bb.buildBlock(0,0,1,Blocks.yellow_flower,0);
		bb.buildBlock(0,0,3,Blocks.red_flower,3);bb.buildBlock(1,0,0,Blocks.yellow_flower,0);bb.buildBlock(3,0,-3,Blocks.red_flower,3);
		bb.buildBlock(3,0,0,Blocks.red_flower,3);
	}

}
