package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMerchant;

import net.minecraft.init.Blocks;

public class BuildingTeaChair extends Building {

	@Override
	public String getName() {
		return "Tea Party Garden";
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
		bb.buildBlock(-3,-1,-3,Blocks.grass,0);bb.buildBlock(-3,-1,-2,Blocks.grass,0);bb.buildBlock(-3,-1,-1,Blocks.grass,0);
		bb.buildBlock(-3,-1,0,Blocks.grass,0);bb.buildBlock(-3,-1,1,Blocks.grass,0);bb.buildBlock(-3,-1,2,Blocks.grass,0);
		bb.buildBlock(-3,-1,3,Blocks.grass,0);bb.buildBlock(-2,-1,-3,Blocks.grass,0);bb.buildBlock(-2,-1,-2,Blocks.grass,0);
		bb.buildBlock(-2,-1,2,Blocks.grass,0);bb.buildBlock(-2,-1,3,Blocks.grass,0);bb.buildBlock(-1,-1,-3,Blocks.grass,0);
		bb.buildBlock(-1,-1,3,Blocks.grass,0);bb.buildBlock(0,-1,-3,Blocks.grass,0);bb.buildBlock(0,-1,-1,Blocks.planks,2);
		bb.buildBlock(0,-1,0,Blocks.planks,2);bb.buildBlock(0,-1,1,Blocks.planks,2);bb.buildBlock(0,-1,3,Blocks.grass,0);
		bb.buildBlock(1,-1,-3,Blocks.grass,0);bb.buildBlock(1,-1,3,Blocks.grass,0);bb.buildBlock(2,-1,-3,Blocks.grass,0);
		bb.buildBlock(2,-1,-2,Blocks.grass,0);bb.buildBlock(2,-1,2,Blocks.grass,0);bb.buildBlock(2,-1,3,Blocks.grass,0);
		bb.buildBlock(3,-1,-3,Blocks.grass,0);bb.buildBlock(3,-1,-2,Blocks.grass,0);bb.buildBlock(3,-1,-1,Blocks.grass,0);
		bb.buildBlock(3,-1,0,Blocks.grass,0);bb.buildBlock(3,-1,1,Blocks.grass,0);bb.buildBlock(3,-1,2,Blocks.grass,0);
		bb.buildBlock(3,-1,3,Blocks.grass,0);bb.buildBlock(-3,0,-3,Blocks.double_plant,5);bb.buildBlock(-3,0,-2,Blocks.double_plant,5);
		bb.buildBlock(-3,0,-1,Blocks.double_plant,5);bb.buildBlock(-3,0,0,Blocks.double_plant,5);bb.buildBlock(-3,0,1,Blocks.double_plant,5);
		bb.buildBlock(-3,0,2,Blocks.double_plant,5);bb.buildBlock(-3,0,3,Blocks.double_plant,5);bb.buildBlock(-2,0,-3,Blocks.double_plant,5);
		bb.buildBlock(-2,0,-2,Blocks.double_plant,4);bb.buildBlock(-2,0,-1,Blocks.birch_stairs,3);bb.buildBlock(-2,0,0,Blocks.birch_stairs,1);
		bb.buildBlock(-2,0,1,Blocks.birch_stairs,2);bb.buildBlock(-2,0,2,Blocks.double_plant,4);bb.buildBlock(-2,0,3,Blocks.double_plant,5);
		bb.buildBlock(-1,0,-3,Blocks.double_plant,5);bb.buildBlock(-1,0,3,Blocks.double_plant,5);bb.buildBlock(1,0,-3,Blocks.double_plant,5);
		bb.buildBlock(1,0,3,Blocks.double_plant,5);bb.buildBlock(2,0,-3,Blocks.double_plant,5);bb.buildBlock(2,0,-2,Blocks.double_plant,4);
		bb.buildBlock(2,0,-1,Blocks.birch_stairs,3);bb.buildBlock(2,0,0,Blocks.birch_stairs,0);bb.buildBlock(2,0,1,Blocks.birch_stairs,2);
		bb.buildBlock(2,0,2,Blocks.double_plant,4);bb.buildBlock(2,0,3,Blocks.double_plant,5);bb.buildBlock(3,0,-3,Blocks.double_plant,5);
		bb.buildBlock(3,0,-2,Blocks.double_plant,5);bb.buildBlock(3,0,-1,Blocks.double_plant,5);bb.buildBlock(3,0,0,Blocks.double_plant,5);
		bb.buildBlock(3,0,1,Blocks.double_plant,5);bb.buildBlock(3,0,2,Blocks.double_plant,5);bb.buildBlock(3,0,3,Blocks.double_plant,5);
		bb.buildBlock(-3,1,-3,Blocks.double_plant,11);bb.buildBlock(-3,1,-2,Blocks.double_plant,10);bb.buildBlock(-3,1,-1,Blocks.double_plant,10);
		bb.buildBlock(-3,1,0,Blocks.double_plant,10);bb.buildBlock(-3,1,1,Blocks.double_plant,10);bb.buildBlock(-3,1,2,Blocks.double_plant,10);
		bb.buildBlock(-3,1,3,Blocks.double_plant,10);bb.buildBlock(-2,1,-3,Blocks.double_plant,11);bb.buildBlock(-2,1,-2,Blocks.double_plant,11);
		bb.buildBlock(-2,1,2,Blocks.double_plant,11);bb.buildBlock(-2,1,3,Blocks.double_plant,11);bb.buildBlock(-1,1,-3,Blocks.double_plant,11);
		bb.buildBlock(-1,1,3,Blocks.double_plant,11);bb.buildBlock(1,1,-3,Blocks.double_plant,11);bb.buildBlock(1,1,3,Blocks.double_plant,9);
		bb.buildBlock(2,1,-3,Blocks.double_plant,11);bb.buildBlock(2,1,-2,Blocks.double_plant,10);bb.buildBlock(2,1,2,Blocks.double_plant,11);
		bb.buildBlock(2,1,3,Blocks.double_plant,8);bb.buildBlock(3,1,-3,Blocks.double_plant,8);bb.buildBlock(3,1,-2,Blocks.double_plant,8);
		bb.buildBlock(3,1,-1,Blocks.double_plant,8);bb.buildBlock(3,1,0,Blocks.double_plant,8);bb.buildBlock(3,1,1,Blocks.double_plant,8);
		bb.buildBlock(3,1,2,Blocks.double_plant,8);bb.buildBlock(3,1,3,Blocks.double_plant,11);
	}

}
