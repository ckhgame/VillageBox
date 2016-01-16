package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;

import net.minecraft.init.Blocks;

public class BuildingTownSquareSmall extends Building {

	@Override
	public String getName() {
		return "Village Square";
	}

	@Override
	public String getDescription() {
		return "Village Square";
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
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-5,-1,-5,Blocks.planks,2);bb.buildBlock(-5,-1,-4,Blocks.planks,2);bb.buildBlock(-5,-1,-3,Blocks.planks,2);
		bb.buildBlock(-5,-1,-2,Blocks.planks,2);bb.buildBlock(-5,-1,-1,Blocks.planks,2);bb.buildBlock(-5,-1,0,Blocks.planks,2);
		bb.buildBlock(-5,-1,1,Blocks.planks,2);bb.buildBlock(-5,-1,2,Blocks.planks,2);bb.buildBlock(-5,-1,3,Blocks.planks,2);
		bb.buildBlock(-5,-1,4,Blocks.planks,2);bb.buildBlock(-5,-1,5,Blocks.planks,2);bb.buildBlock(-4,-1,-5,Blocks.planks,2);
		bb.buildBlock(-4,-1,-4,Blocks.grass,0);bb.buildBlock(-4,-1,-3,Blocks.grass,0);bb.buildBlock(-4,-1,-2,Blocks.grass,0);
		bb.buildBlock(-4,-1,-1,Blocks.grass,0);bb.buildBlock(-4,-1,0,Blocks.grass,0);bb.buildBlock(-4,-1,1,Blocks.grass,0);
		bb.buildBlock(-4,-1,2,Blocks.grass,0);bb.buildBlock(-4,-1,3,Blocks.grass,0);bb.buildBlock(-4,-1,4,Blocks.grass,0);
		bb.buildBlock(-4,-1,5,Blocks.planks,2);bb.buildBlock(-3,-1,-5,Blocks.planks,2);bb.buildBlock(-3,-1,-4,Blocks.grass,0);
		bb.buildBlock(-3,-1,-3,Blocks.planks,3);bb.buildBlock(-3,-1,-2,Blocks.planks,3);bb.buildBlock(-3,-1,-1,Blocks.planks,3);
		bb.buildBlock(-3,-1,0,Blocks.planks,3);bb.buildBlock(-3,-1,1,Blocks.planks,3);bb.buildBlock(-3,-1,2,Blocks.planks,3);
		bb.buildBlock(-3,-1,3,Blocks.planks,3);bb.buildBlock(-3,-1,4,Blocks.grass,0);bb.buildBlock(-3,-1,5,Blocks.planks,2);
		bb.buildBlock(-2,-1,-5,Blocks.planks,2);bb.buildBlock(-2,-1,-4,Blocks.grass,0);bb.buildBlock(-2,-1,-3,Blocks.planks,3);
		bb.buildBlock(-2,-1,-2,Blocks.grass,0);bb.buildBlock(-2,-1,-1,Blocks.grass,0);bb.buildBlock(-2,-1,0,Blocks.grass,0);
		bb.buildBlock(-2,-1,1,Blocks.grass,0);bb.buildBlock(-2,-1,2,Blocks.grass,0);bb.buildBlock(-2,-1,3,Blocks.planks,3);
		bb.buildBlock(-2,-1,4,Blocks.grass,0);bb.buildBlock(-2,-1,5,Blocks.planks,2);bb.buildBlock(-1,-1,-5,Blocks.planks,2);
		bb.buildBlock(-1,-1,-4,Blocks.grass,0);bb.buildBlock(-1,-1,-3,Blocks.planks,3);bb.buildBlock(-1,-1,-2,Blocks.grass,0);
		bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,0,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);
		bb.buildBlock(-1,-1,2,Blocks.grass,0);bb.buildBlock(-1,-1,3,Blocks.planks,3);bb.buildBlock(-1,-1,4,Blocks.grass,0);
		bb.buildBlock(-1,-1,5,Blocks.planks,2);bb.buildBlock(0,-1,-5,Blocks.planks,2);bb.buildBlock(0,-1,-4,Blocks.grass,0);
		bb.buildBlock(0,-1,-3,Blocks.planks,3);bb.buildBlock(0,-1,-2,Blocks.grass,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.grass,0);
		bb.buildBlock(0,-1,3,Blocks.planks,3);bb.buildBlock(0,-1,4,Blocks.grass,0);bb.buildBlock(0,-1,5,Blocks.planks,2);
		bb.buildBlock(1,-1,-5,Blocks.planks,2);bb.buildBlock(1,-1,-4,Blocks.grass,0);bb.buildBlock(1,-1,-3,Blocks.planks,3);
		bb.buildBlock(1,-1,-2,Blocks.grass,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);
		bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.grass,0);bb.buildBlock(1,-1,3,Blocks.planks,3);
		bb.buildBlock(1,-1,4,Blocks.grass,0);bb.buildBlock(1,-1,5,Blocks.planks,2);bb.buildBlock(2,-1,-5,Blocks.planks,2);
		bb.buildBlock(2,-1,-4,Blocks.grass,0);bb.buildBlock(2,-1,-3,Blocks.planks,3);bb.buildBlock(2,-1,-2,Blocks.grass,0);
		bb.buildBlock(2,-1,-1,Blocks.grass,0);bb.buildBlock(2,-1,0,Blocks.planks,3);bb.buildBlock(2,-1,1,Blocks.grass,0);
		bb.buildBlock(2,-1,2,Blocks.grass,0);bb.buildBlock(2,-1,3,Blocks.planks,3);bb.buildBlock(2,-1,4,Blocks.grass,0);
		bb.buildBlock(2,-1,5,Blocks.planks,2);bb.buildBlock(3,-1,-5,Blocks.planks,2);bb.buildBlock(3,-1,-4,Blocks.grass,0);
		bb.buildBlock(3,-1,-3,Blocks.planks,3);bb.buildBlock(3,-1,-2,Blocks.planks,3);bb.buildBlock(3,-1,-1,Blocks.planks,3);
		bb.buildBlock(3,-1,0,Blocks.planks,3);bb.buildBlock(3,-1,1,Blocks.planks,3);bb.buildBlock(3,-1,2,Blocks.planks,3);
		bb.buildBlock(3,-1,3,Blocks.planks,3);bb.buildBlock(3,-1,4,Blocks.grass,0);bb.buildBlock(3,-1,5,Blocks.planks,2);
		bb.buildBlock(4,-1,-5,Blocks.planks,2);bb.buildBlock(4,-1,-4,Blocks.grass,0);bb.buildBlock(4,-1,-3,Blocks.grass,0);
		bb.buildBlock(4,-1,-2,Blocks.grass,0);bb.buildBlock(4,-1,-1,Blocks.grass,0);bb.buildBlock(4,-1,0,Blocks.planks,3);
		bb.buildBlock(4,-1,1,Blocks.grass,0);bb.buildBlock(4,-1,2,Blocks.grass,0);bb.buildBlock(4,-1,3,Blocks.grass,0);
		bb.buildBlock(4,-1,4,Blocks.grass,0);bb.buildBlock(4,-1,5,Blocks.planks,2);bb.buildBlock(5,-1,-5,Blocks.planks,2);
		bb.buildBlock(5,-1,-4,Blocks.planks,2);bb.buildBlock(5,-1,-3,Blocks.planks,2);bb.buildBlock(5,-1,-2,Blocks.planks,2);
		bb.buildBlock(5,-1,-1,Blocks.planks,2);bb.buildBlock(5,-1,0,Blocks.planks,3);bb.buildBlock(5,-1,1,Blocks.planks,2);
		bb.buildBlock(5,-1,2,Blocks.planks,2);bb.buildBlock(5,-1,3,Blocks.planks,2);bb.buildBlock(5,-1,4,Blocks.planks,2);
		bb.buildBlock(5,-1,5,Blocks.planks,2);bb.buildBlock(-5,0,-5,Blocks.fence,0);bb.buildBlock(-5,0,5,Blocks.fence,0);
		bb.buildBlock(-4,0,-4,Blocks.red_flower,4);bb.buildBlock(-4,0,-3,Blocks.red_flower,6);bb.buildBlock(-4,0,-2,Blocks.red_flower,7);
		bb.buildBlock(-4,0,-1,Blocks.red_flower,6);bb.buildBlock(-4,0,0,Blocks.red_flower,5);bb.buildBlock(-4,0,1,Blocks.red_flower,6);
		bb.buildBlock(-4,0,2,Blocks.red_flower,7);bb.buildBlock(-4,0,3,Blocks.red_flower,6);bb.buildBlock(-4,0,4,Blocks.red_flower,4);
		bb.buildBlock(-3,0,-4,Blocks.red_flower,6);bb.buildBlock(-3,0,-3,ModBlocks.blockOakChair,0);bb.buildBlock(-3,0,0,ModBlocks.blockOakChair,0);bb.buildBlock(-3,0,3,ModBlocks.blockOakChair,0);bb.buildBlock(-3,0,4,Blocks.red_flower,6);bb.buildBlock(-2,0,-4,Blocks.red_flower,7);bb.buildBlock(-2,0,4,Blocks.red_flower,7);
		bb.buildBlock(-1,0,-4,Blocks.red_flower,6);bb.buildBlock(-1,0,4,Blocks.red_flower,6);bb.buildBlock(0,0,-4,Blocks.red_flower,5);
		bb.buildBlock(0,0,-3,ModBlocks.blockOakChair,0);bb.buildBlock(0,0,0,Blocks.fence,0);bb.buildBlock(0,0,3,ModBlocks.blockOakChair,0);bb.buildBlock(0,0,4,Blocks.red_flower,5);bb.buildBlock(1,0,-4,Blocks.red_flower,6);bb.buildBlock(1,0,-3,ModBlocks.blockOakChair,0);
		bb.buildBlock(1,0,3,ModBlocks.blockOakChair,0);bb.buildBlock(1,0,4,Blocks.red_flower,6);bb.buildBlock(2,0,-4,Blocks.red_flower,4);bb.buildBlock(2,0,4,Blocks.red_flower,4);
		bb.buildBlock(3,0,-4,Blocks.red_flower,6);bb.buildBlock(3,0,-3,ModBlocks.blockOakChair,0);bb.buildBlock(3,0,3,ModBlocks.blockOakChair,0);bb.buildBlock(3,0,4,Blocks.red_flower,6);bb.buildBlock(4,0,-4,Blocks.red_flower,7);bb.buildBlock(4,0,-3,Blocks.red_flower,6);
		bb.buildBlock(4,0,-2,Blocks.red_flower,5);bb.buildBlock(4,0,-1,Blocks.red_flower,6);bb.buildBlock(4,0,1,Blocks.red_flower,6);
		bb.buildBlock(4,0,2,Blocks.red_flower,5);bb.buildBlock(4,0,3,Blocks.red_flower,6);bb.buildBlock(4,0,4,Blocks.red_flower,7);
		bb.buildBlock(5,0,-5,Blocks.fence,0);bb.buildBlock(5,0,5,Blocks.fence,0);bb.buildBlock(-5,1,-5,Blocks.fence,0);
		bb.buildBlock(-5,1,5,Blocks.fence,0);bb.buildBlock(0,1,0,Blocks.fence,0);bb.buildBlock(5,1,-5,Blocks.fence,0);
		bb.buildBlock(5,1,5,Blocks.fence,0);bb.buildBlock(-5,2,-5,Blocks.fence,0);bb.buildBlock(-5,2,5,Blocks.fence,0);
		bb.buildBlock(0,2,0,Blocks.fence,0);bb.buildBlock(5,2,-5,Blocks.fence,0);bb.buildBlock(5,2,5,Blocks.fence,0);
		bb.buildBlock(-5,3,-5,Blocks.fence,0);bb.buildBlock(-5,3,5,Blocks.fence,0);bb.buildBlock(0,3,0,Blocks.fence,0);
		bb.buildBlock(5,3,-5,Blocks.fence,0);bb.buildBlock(5,3,5,Blocks.fence,0);bb.buildBlock(-5,4,-5,Blocks.planks,0);
		bb.buildBlock(-5,4,5,Blocks.planks,0);bb.buildBlock(0,4,0,Blocks.planks,0);bb.buildBlock(5,4,-5,Blocks.planks,0);
		bb.buildBlock(5,4,5,Blocks.planks,0);bb.buildBlock(-5,5,-5,Blocks.acacia_stairs,2);bb.buildBlock(-5,5,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,5,-1,Blocks.acacia_stairs,2);bb.buildBlock(-1,5,0,Blocks.acacia_stairs,0);bb.buildBlock(-1,5,1,Blocks.acacia_stairs,0);
		bb.buildBlock(0,5,-1,Blocks.acacia_stairs,2);bb.buildBlock(0,5,0,Blocks.planks,4);bb.buildBlock(0,5,1,Blocks.acacia_stairs,3);
		bb.buildBlock(1,5,-1,Blocks.acacia_stairs,1);bb.buildBlock(1,5,0,Blocks.acacia_stairs,1);bb.buildBlock(1,5,1,Blocks.acacia_stairs,1);
		bb.buildBlock(5,5,-5,Blocks.acacia_stairs,2);bb.buildBlock(5,5,5,Blocks.acacia_stairs,3);bb.buildBlock(-5,4,-4,Blocks.torch,3);
		bb.buildBlock(-5,4,4,Blocks.torch,4);bb.buildBlock(-4,4,-5,Blocks.torch,1);bb.buildBlock(-4,4,5,Blocks.torch,1);
		bb.buildBlock(-1,4,0,Blocks.torch,2);bb.buildBlock(0,4,-1,Blocks.torch,4);bb.buildBlock(0,4,1,Blocks.torch,3);
		bb.buildBlock(1,4,0,Blocks.torch,1);bb.buildBlock(4,4,-5,Blocks.torch,2);bb.buildBlock(4,4,5,Blocks.torch,2);
		bb.buildBlock(5,4,-4,Blocks.torch,3);bb.buildBlock(5,4,4,Blocks.torch,4);
	}

}
