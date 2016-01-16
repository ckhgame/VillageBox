package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;

import net.minecraft.init.Blocks;

public class BuildingTownSquareLarge extends Building {

	@Override
	public String getName() {
		return "Town Square";
	}

	@Override
	public String getDescription() {
		return "Town Square";
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
		return ConfigBuilding.SizeType_Large;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-7,-1,-7,Blocks.grass,0);bb.buildBlock(-7,-1,-6,Blocks.grass,0);bb.buildBlock(-7,-1,-5,Blocks.grass,0);
		bb.buildBlock(-7,-1,-4,Blocks.grass,0);bb.buildBlock(-7,-1,-3,Blocks.grass,0);bb.buildBlock(-7,-1,-2,Blocks.grass,0);
		bb.buildBlock(-7,-1,-1,Blocks.grass,0);bb.buildBlock(-7,-1,0,Blocks.grass,0);bb.buildBlock(-7,-1,1,Blocks.grass,0);
		bb.buildBlock(-7,-1,2,Blocks.grass,0);bb.buildBlock(-7,-1,3,Blocks.grass,0);bb.buildBlock(-7,-1,4,Blocks.grass,0);
		bb.buildBlock(-7,-1,5,Blocks.grass,0);bb.buildBlock(-7,-1,6,Blocks.grass,0);bb.buildBlock(-7,-1,7,Blocks.grass,0);
		bb.buildBlock(-6,-1,-7,Blocks.grass,0);bb.buildBlock(-6,-1,-6,Blocks.planks,2);bb.buildBlock(-6,-1,-5,Blocks.planks,2);
		bb.buildBlock(-6,-1,-4,Blocks.planks,2);bb.buildBlock(-6,-1,-3,Blocks.planks,2);bb.buildBlock(-6,-1,-2,Blocks.planks,2);
		bb.buildBlock(-6,-1,-1,Blocks.planks,2);bb.buildBlock(-6,-1,0,Blocks.planks,2);bb.buildBlock(-6,-1,1,Blocks.planks,2);
		bb.buildBlock(-6,-1,2,Blocks.planks,2);bb.buildBlock(-6,-1,3,Blocks.planks,2);bb.buildBlock(-6,-1,4,Blocks.planks,2);
		bb.buildBlock(-6,-1,5,Blocks.planks,2);bb.buildBlock(-6,-1,6,Blocks.planks,2);bb.buildBlock(-6,-1,7,Blocks.grass,0);
		bb.buildBlock(-5,-1,-7,Blocks.grass,0);bb.buildBlock(-5,-1,-6,Blocks.planks,2);bb.buildBlock(-5,-1,-5,Blocks.planks,2);
		bb.buildBlock(-5,-1,-4,Blocks.planks,2);bb.buildBlock(-5,-1,-3,Blocks.grass,0);bb.buildBlock(-5,-1,-2,Blocks.grass,0);
		bb.buildBlock(-5,-1,-1,Blocks.grass,0);bb.buildBlock(-5,-1,0,Blocks.grass,0);bb.buildBlock(-5,-1,1,Blocks.grass,0);
		bb.buildBlock(-5,-1,2,Blocks.grass,0);bb.buildBlock(-5,-1,3,Blocks.grass,0);bb.buildBlock(-5,-1,4,Blocks.planks,2);
		bb.buildBlock(-5,-1,5,Blocks.planks,2);bb.buildBlock(-5,-1,6,Blocks.planks,2);bb.buildBlock(-5,-1,7,Blocks.grass,0);
		bb.buildBlock(-4,-1,-7,Blocks.grass,0);bb.buildBlock(-4,-1,-6,Blocks.planks,2);bb.buildBlock(-4,-1,-5,Blocks.planks,2);
		bb.buildBlock(-4,-1,-4,Blocks.planks,2);bb.buildBlock(-4,-1,-3,Blocks.grass,0);bb.buildBlock(-4,-1,-2,Blocks.grass,0);
		bb.buildBlock(-4,-1,-1,Blocks.grass,0);bb.buildBlock(-4,-1,0,Blocks.grass,0);bb.buildBlock(-4,-1,1,Blocks.grass,0);
		bb.buildBlock(-4,-1,2,Blocks.grass,0);bb.buildBlock(-4,-1,3,Blocks.grass,0);bb.buildBlock(-4,-1,4,Blocks.planks,2);
		bb.buildBlock(-4,-1,5,Blocks.planks,2);bb.buildBlock(-4,-1,6,Blocks.planks,2);bb.buildBlock(-4,-1,7,Blocks.grass,0);
		bb.buildBlock(-3,-1,-7,Blocks.grass,0);bb.buildBlock(-3,-1,-6,Blocks.planks,2);bb.buildBlock(-3,-1,-5,Blocks.grass,0);
		bb.buildBlock(-3,-1,-4,Blocks.grass,0);bb.buildBlock(-3,-1,-3,Blocks.planks,2);bb.buildBlock(-3,-1,-2,Blocks.planks,2);
		bb.buildBlock(-3,-1,-1,Blocks.planks,2);bb.buildBlock(-3,-1,0,Blocks.planks,2);bb.buildBlock(-3,-1,1,Blocks.planks,2);
		bb.buildBlock(-3,-1,2,Blocks.planks,2);bb.buildBlock(-3,-1,3,Blocks.planks,2);bb.buildBlock(-3,-1,4,Blocks.grass,0);
		bb.buildBlock(-3,-1,5,Blocks.grass,0);bb.buildBlock(-3,-1,6,Blocks.planks,2);bb.buildBlock(-3,-1,7,Blocks.grass,0);
		bb.buildBlock(-2,-1,-7,Blocks.grass,0);bb.buildBlock(-2,-1,-6,Blocks.planks,2);bb.buildBlock(-2,-1,-5,Blocks.grass,0);
		bb.buildBlock(-2,-1,-4,Blocks.grass,0);bb.buildBlock(-2,-1,-3,Blocks.planks,2);bb.buildBlock(-2,-1,3,Blocks.planks,2);
		bb.buildBlock(-2,-1,4,Blocks.grass,0);bb.buildBlock(-2,-1,5,Blocks.grass,0);bb.buildBlock(-2,-1,6,Blocks.planks,2);
		bb.buildBlock(-2,-1,7,Blocks.grass,0);bb.buildBlock(-1,-1,-7,Blocks.grass,0);bb.buildBlock(-1,-1,-6,Blocks.planks,2);
		bb.buildBlock(-1,-1,-5,Blocks.grass,0);bb.buildBlock(-1,-1,-4,Blocks.grass,0);bb.buildBlock(-1,-1,-3,Blocks.planks,2);
		bb.buildBlock(-1,-1,-1,Blocks.planks,2);bb.buildBlock(-1,-1,0,Blocks.planks,2);bb.buildBlock(-1,-1,1,Blocks.planks,2);
		bb.buildBlock(-1,-1,3,Blocks.planks,2);bb.buildBlock(-1,-1,4,Blocks.grass,0);bb.buildBlock(-1,-1,5,Blocks.grass,0);
		bb.buildBlock(-1,-1,6,Blocks.planks,2);bb.buildBlock(-1,-1,7,Blocks.grass,0);bb.buildBlock(0,-1,-7,Blocks.grass,0);
		bb.buildBlock(0,-1,-6,Blocks.planks,2);bb.buildBlock(0,-1,-5,Blocks.grass,0);bb.buildBlock(0,-1,-4,Blocks.grass,0);
		bb.buildBlock(0,-1,-3,Blocks.planks,2);bb.buildBlock(0,-1,-1,Blocks.planks,2);bb.buildBlock(0,-1,0,Blocks.planks,4);
		bb.buildBlock(0,-1,1,Blocks.planks,2);bb.buildBlock(0,-1,3,Blocks.planks,2);bb.buildBlock(0,-1,4,Blocks.grass,0);
		bb.buildBlock(0,-1,5,Blocks.grass,0);bb.buildBlock(0,-1,6,Blocks.planks,2);bb.buildBlock(0,-1,7,Blocks.grass,0);
		bb.buildBlock(1,-1,-7,Blocks.grass,0);bb.buildBlock(1,-1,-6,Blocks.planks,2);bb.buildBlock(1,-1,-5,Blocks.grass,0);
		bb.buildBlock(1,-1,-4,Blocks.grass,0);bb.buildBlock(1,-1,-3,Blocks.planks,2);bb.buildBlock(1,-1,-1,Blocks.planks,2);
		bb.buildBlock(1,-1,0,Blocks.planks,2);bb.buildBlock(1,-1,1,Blocks.planks,2);bb.buildBlock(1,-1,3,Blocks.planks,2);
		bb.buildBlock(1,-1,4,Blocks.grass,0);bb.buildBlock(1,-1,5,Blocks.grass,0);bb.buildBlock(1,-1,6,Blocks.planks,2);
		bb.buildBlock(1,-1,7,Blocks.grass,0);bb.buildBlock(2,-1,-7,Blocks.grass,0);bb.buildBlock(2,-1,-6,Blocks.planks,2);
		bb.buildBlock(2,-1,-5,Blocks.grass,0);bb.buildBlock(2,-1,-4,Blocks.grass,0);bb.buildBlock(2,-1,-3,Blocks.planks,2);
		bb.buildBlock(2,-1,0,Blocks.planks,2);bb.buildBlock(2,-1,3,Blocks.planks,2);bb.buildBlock(2,-1,4,Blocks.grass,0);
		bb.buildBlock(2,-1,5,Blocks.grass,0);bb.buildBlock(2,-1,6,Blocks.planks,2);bb.buildBlock(2,-1,7,Blocks.grass,0);
		bb.buildBlock(3,-1,-7,Blocks.grass,0);bb.buildBlock(3,-1,-6,Blocks.planks,2);bb.buildBlock(3,-1,-5,Blocks.grass,0);
		bb.buildBlock(3,-1,-4,Blocks.grass,0);bb.buildBlock(3,-1,-3,Blocks.planks,2);bb.buildBlock(3,-1,-2,Blocks.planks,2);
		bb.buildBlock(3,-1,-1,Blocks.planks,4);bb.buildBlock(3,-1,0,Blocks.planks,2);bb.buildBlock(3,-1,1,Blocks.planks,4);
		bb.buildBlock(3,-1,2,Blocks.planks,2);bb.buildBlock(3,-1,3,Blocks.planks,2);bb.buildBlock(3,-1,4,Blocks.grass,0);
		bb.buildBlock(3,-1,5,Blocks.grass,0);bb.buildBlock(3,-1,6,Blocks.planks,2);bb.buildBlock(3,-1,7,Blocks.grass,0);
		bb.buildBlock(4,-1,-7,Blocks.grass,0);bb.buildBlock(4,-1,-6,Blocks.planks,2);bb.buildBlock(4,-1,-5,Blocks.planks,2);
		bb.buildBlock(4,-1,-4,Blocks.planks,2);bb.buildBlock(4,-1,-3,Blocks.grass,0);bb.buildBlock(4,-1,-2,Blocks.grass,0);
		bb.buildBlock(4,-1,-1,Blocks.planks,4);bb.buildBlock(4,-1,0,Blocks.planks,2);bb.buildBlock(4,-1,1,Blocks.planks,4);
		bb.buildBlock(4,-1,2,Blocks.grass,0);bb.buildBlock(4,-1,3,Blocks.grass,0);bb.buildBlock(4,-1,4,Blocks.planks,2);
		bb.buildBlock(4,-1,5,Blocks.planks,2);bb.buildBlock(4,-1,6,Blocks.planks,2);bb.buildBlock(4,-1,7,Blocks.grass,0);
		bb.buildBlock(5,-1,-7,Blocks.grass,0);bb.buildBlock(5,-1,-6,Blocks.planks,2);bb.buildBlock(5,-1,-5,Blocks.planks,2);
		bb.buildBlock(5,-1,-4,Blocks.planks,2);bb.buildBlock(5,-1,-3,Blocks.grass,0);bb.buildBlock(5,-1,-2,Blocks.grass,0);
		bb.buildBlock(5,-1,-1,Blocks.planks,4);bb.buildBlock(5,-1,0,Blocks.planks,2);bb.buildBlock(5,-1,1,Blocks.planks,4);
		bb.buildBlock(5,-1,2,Blocks.grass,0);bb.buildBlock(5,-1,3,Blocks.grass,0);bb.buildBlock(5,-1,4,Blocks.planks,2);
		bb.buildBlock(5,-1,5,Blocks.planks,2);bb.buildBlock(5,-1,6,Blocks.planks,2);bb.buildBlock(5,-1,7,Blocks.grass,0);
		bb.buildBlock(6,-1,-7,Blocks.grass,0);bb.buildBlock(6,-1,-6,Blocks.planks,2);bb.buildBlock(6,-1,-5,Blocks.planks,2);
		bb.buildBlock(6,-1,-4,Blocks.planks,2);bb.buildBlock(6,-1,-3,Blocks.planks,2);bb.buildBlock(6,-1,-2,Blocks.planks,2);
		bb.buildBlock(6,-1,-1,Blocks.planks,4);bb.buildBlock(6,-1,0,Blocks.planks,2);bb.buildBlock(6,-1,1,Blocks.planks,4);
		bb.buildBlock(6,-1,2,Blocks.planks,2);bb.buildBlock(6,-1,3,Blocks.planks,2);bb.buildBlock(6,-1,4,Blocks.planks,2);
		bb.buildBlock(6,-1,5,Blocks.planks,2);bb.buildBlock(6,-1,6,Blocks.planks,2);bb.buildBlock(6,-1,7,Blocks.grass,0);
		bb.buildBlock(7,-1,-7,Blocks.grass,0);bb.buildBlock(7,-1,-6,Blocks.grass,0);bb.buildBlock(7,-1,-5,Blocks.grass,0);
		bb.buildBlock(7,-1,-4,Blocks.grass,0);bb.buildBlock(7,-1,-3,Blocks.grass,0);bb.buildBlock(7,-1,-2,Blocks.grass,0);
		bb.buildBlock(7,-1,-1,Blocks.grass,0);bb.buildBlock(7,-1,0,Blocks.grass,0);bb.buildBlock(7,-1,1,Blocks.grass,0);
		bb.buildBlock(7,-1,2,Blocks.grass,0);bb.buildBlock(7,-1,3,Blocks.grass,0);bb.buildBlock(7,-1,4,Blocks.grass,0);
		bb.buildBlock(7,-1,5,Blocks.grass,0);bb.buildBlock(7,-1,6,Blocks.grass,0);bb.buildBlock(7,-1,7,Blocks.grass,0);
		bb.buildBlock(-7,0,-7,Blocks.double_plant,4);bb.buildBlock(-7,0,-6,Blocks.double_plant,4);bb.buildBlock(-7,0,-5,Blocks.double_plant,4);
		bb.buildBlock(-7,0,-4,Blocks.double_plant,4);bb.buildBlock(-7,0,-3,Blocks.double_plant,5);bb.buildBlock(-7,0,-2,Blocks.double_plant,5);
		bb.buildBlock(-7,0,-1,Blocks.double_plant,5);bb.buildBlock(-7,0,0,Blocks.double_plant,5);bb.buildBlock(-7,0,1,Blocks.double_plant,5);
		bb.buildBlock(-7,0,2,Blocks.double_plant,5);bb.buildBlock(-7,0,3,Blocks.double_plant,5);bb.buildBlock(-7,0,4,Blocks.double_plant,4);
		bb.buildBlock(-7,0,5,Blocks.double_plant,4);bb.buildBlock(-7,0,6,Blocks.double_plant,4);bb.buildBlock(-7,0,7,Blocks.double_plant,4);
		bb.buildBlock(-6,0,-7,Blocks.double_plant,4);bb.buildBlock(-6,0,-1,Blocks.jungle_stairs,1);bb.buildBlock(-6,0,0,Blocks.jungle_stairs,1);
		bb.buildBlock(-6,0,1,Blocks.jungle_stairs,1);bb.buildBlock(-6,0,7,Blocks.double_plant,4);bb.buildBlock(-5,0,-7,Blocks.double_plant,4);
		bb.buildBlock(-5,0,-6,ModBlocks.blockOakChair,0);bb.buildBlock(-5,0,-5,Blocks.planks,3);bb.buildBlock(-5,0,-4,ModBlocks.blockOakChair,0);bb.buildBlock(-5,0,4,ModBlocks.blockOakChair,0);bb.buildBlock(-5,0,5,Blocks.planks,3);bb.buildBlock(-5,0,6,ModBlocks.blockOakChair,0);bb.buildBlock(-5,0,7,Blocks.double_plant,4);bb.buildBlock(-4,0,-7,Blocks.double_plant,4);bb.buildBlock(-4,0,-3,Blocks.red_flower,3);
		bb.buildBlock(-4,0,-2,Blocks.yellow_flower,0);bb.buildBlock(-4,0,-1,Blocks.red_flower,3);bb.buildBlock(-4,0,0,Blocks.yellow_flower,0);
		bb.buildBlock(-4,0,1,Blocks.red_flower,3);bb.buildBlock(-4,0,2,Blocks.yellow_flower,0);bb.buildBlock(-4,0,7,Blocks.double_plant,4);
		bb.buildBlock(-3,0,-7,Blocks.double_plant,5);bb.buildBlock(-3,0,-4,Blocks.red_flower,3);bb.buildBlock(-3,0,4,Blocks.yellow_flower,0);
		bb.buildBlock(-3,0,7,Blocks.double_plant,5);bb.buildBlock(-2,0,-7,Blocks.double_plant,5);bb.buildBlock(-2,0,-4,Blocks.yellow_flower,0);
		bb.buildBlock(-2,0,-2,Blocks.quartz_block,2);bb.buildBlock(-2,0,-1,Blocks.sandstone,2);bb.buildBlock(-2,0,0,Blocks.sandstone,2);
		bb.buildBlock(-2,0,1,Blocks.sandstone,2);bb.buildBlock(-2,0,2,Blocks.quartz_block,2);bb.buildBlock(-2,0,4,Blocks.red_flower,3);
		bb.buildBlock(-2,0,7,Blocks.double_plant,5);bb.buildBlock(-1,0,-7,Blocks.double_plant,5);bb.buildBlock(-1,0,-6,Blocks.jungle_stairs,3);
		bb.buildBlock(-1,0,-4,Blocks.red_flower,3);bb.buildBlock(-1,0,-2,Blocks.sandstone,2);bb.buildBlock(-1,0,1,Blocks.birch_stairs,2);
		bb.buildBlock(-1,0,2,Blocks.sandstone,2);bb.buildBlock(-1,0,4,Blocks.yellow_flower,0);bb.buildBlock(-1,0,6,Blocks.jungle_stairs,2);
		bb.buildBlock(-1,0,7,Blocks.double_plant,5);bb.buildBlock(0,0,-7,Blocks.double_plant,5);bb.buildBlock(0,0,-6,Blocks.jungle_stairs,3);
		bb.buildBlock(0,0,-4,Blocks.yellow_flower,0);bb.buildBlock(0,0,-2,Blocks.sandstone,2);bb.buildBlock(0,0,1,Blocks.flower_pot,0);
		bb.addTileEntityPot(0,0,1,37,0);
		bb.buildBlock(0,0,2,Blocks.sandstone,2);bb.buildBlock(0,0,4,Blocks.red_flower,3);bb.buildBlock(0,0,6,Blocks.jungle_stairs,2);
		bb.buildBlock(0,0,7,Blocks.double_plant,5);bb.buildBlock(1,0,-7,Blocks.double_plant,5);bb.buildBlock(1,0,-6,Blocks.jungle_stairs,3);
		bb.buildBlock(1,0,-4,Blocks.red_flower,3);bb.buildBlock(1,0,-2,Blocks.sandstone,2);bb.buildBlock(1,0,1,Blocks.flower_pot,2);
		bb.addTileEntityPot(1,0,1,38,2);
		bb.buildBlock(1,0,2,Blocks.sandstone,2);bb.buildBlock(1,0,4,Blocks.yellow_flower,0);bb.buildBlock(1,0,6,Blocks.jungle_stairs,2);
		bb.buildBlock(1,0,7,Blocks.double_plant,5);bb.buildBlock(2,0,-7,Blocks.double_plant,5);bb.buildBlock(2,0,-4,Blocks.yellow_flower,0);
		bb.buildBlock(2,0,-2,Blocks.quartz_block,2);bb.buildBlock(2,0,-1,Blocks.sandstone,2);bb.buildBlock(2,0,0,Blocks.wooden_door,0);
		bb.buildBlock(2,0,1,Blocks.sandstone,2);bb.buildBlock(2,0,2,Blocks.quartz_block,2);bb.buildBlock(2,0,4,Blocks.red_flower,3);
		bb.buildBlock(2,0,7,Blocks.double_plant,5);bb.buildBlock(3,0,-7,Blocks.double_plant,5);bb.buildBlock(3,0,-4,Blocks.red_flower,3);
		bb.buildBlock(3,0,4,Blocks.yellow_flower,0);bb.buildBlock(3,0,7,Blocks.double_plant,5);bb.buildBlock(4,0,-7,Blocks.double_plant,4);
		bb.buildBlock(4,0,7,Blocks.double_plant,4);bb.buildBlock(5,0,-7,Blocks.double_plant,4);bb.buildBlock(5,0,-6,ModBlocks.blockOakChair,0);
		bb.buildBlock(5,0,-5,Blocks.planks,3);bb.buildBlock(5,0,-4,ModBlocks.blockOakChair,0);bb.buildBlock(5,0,4,ModBlocks.blockOakChair,0);bb.buildBlock(5,0,5,Blocks.planks,3);bb.buildBlock(5,0,6,ModBlocks.blockOakChair,0);bb.buildBlock(5,0,7,Blocks.double_plant,4);bb.buildBlock(6,0,-7,Blocks.double_plant,4);bb.buildBlock(6,0,7,Blocks.double_plant,4);
		bb.buildBlock(7,0,-7,Blocks.double_plant,4);bb.buildBlock(7,0,-6,Blocks.double_plant,4);bb.buildBlock(7,0,-5,Blocks.double_plant,4);
		bb.buildBlock(7,0,-4,Blocks.double_plant,4);bb.buildBlock(7,0,-3,Blocks.double_plant,5);bb.buildBlock(7,0,-2,Blocks.double_plant,5);
		bb.buildBlock(7,0,2,Blocks.double_plant,5);bb.buildBlock(7,0,3,Blocks.double_plant,5);bb.buildBlock(7,0,4,Blocks.double_plant,4);
		bb.buildBlock(7,0,5,Blocks.double_plant,4);bb.buildBlock(7,0,6,Blocks.double_plant,4);bb.buildBlock(7,0,7,Blocks.double_plant,4);
		bb.buildBlock(-7,1,-7,Blocks.double_plant,9);bb.buildBlock(-7,1,-6,Blocks.double_plant,9);bb.buildBlock(-7,1,-5,Blocks.double_plant,9);
		bb.buildBlock(-7,1,-4,Blocks.double_plant,8);bb.buildBlock(-7,1,-3,Blocks.double_plant,11);bb.buildBlock(-7,1,-2,Blocks.double_plant,11);
		bb.buildBlock(-7,1,-1,Blocks.double_plant,11);bb.buildBlock(-7,1,0,Blocks.double_plant,11);bb.buildBlock(-7,1,1,Blocks.double_plant,11);
		bb.buildBlock(-7,1,2,Blocks.double_plant,11);bb.buildBlock(-7,1,3,Blocks.double_plant,11);bb.buildBlock(-7,1,4,Blocks.double_plant,10);
		bb.buildBlock(-7,1,5,Blocks.double_plant,10);bb.buildBlock(-7,1,6,Blocks.double_plant,10);bb.buildBlock(-7,1,7,Blocks.double_plant,10);
		bb.buildBlock(-6,1,-7,Blocks.double_plant,9);bb.buildBlock(-6,1,7,Blocks.double_plant,10);bb.buildBlock(-5,1,-7,Blocks.double_plant,9);
		bb.buildBlock(-5,1,7,Blocks.double_plant,9);bb.buildBlock(-4,1,-7,Blocks.double_plant,11);bb.buildBlock(-4,1,7,Blocks.double_plant,9);
		bb.buildBlock(-3,1,-7,Blocks.double_plant,8);bb.buildBlock(-3,1,7,Blocks.double_plant,10);bb.buildBlock(-2,1,-7,Blocks.double_plant,8);
		bb.buildBlock(-2,1,-2,Blocks.quartz_block,2);bb.buildBlock(-2,1,-1,Blocks.sandstone,2);bb.buildBlock(-2,1,0,Blocks.glass_pane,0);
		bb.buildBlock(-2,1,1,Blocks.sandstone,2);bb.buildBlock(-2,1,2,Blocks.quartz_block,2);bb.buildBlock(-2,1,7,Blocks.double_plant,10);
		bb.buildBlock(-1,1,-7,Blocks.double_plant,8);bb.buildBlock(-1,1,-2,Blocks.sandstone,2);bb.buildBlock(-1,1,2,Blocks.sandstone,2);
		bb.buildBlock(-1,1,7,Blocks.double_plant,10);bb.buildBlock(0,1,-7,Blocks.double_plant,8);bb.buildBlock(0,1,-2,Blocks.glass_pane,0);
		bb.buildBlock(0,1,1,Blocks.birch_stairs,0);bb.buildBlock(0,1,2,Blocks.glass_pane,0);bb.buildBlock(0,1,7,Blocks.double_plant,10);
		bb.buildBlock(1,1,-7,Blocks.double_plant,10);bb.buildBlock(1,1,-2,Blocks.sandstone,2);bb.buildBlock(1,1,2,Blocks.sandstone,2);
		bb.buildBlock(1,1,7,Blocks.double_plant,10);bb.buildBlock(2,1,-7,Blocks.double_plant,8);bb.buildBlock(2,1,-2,Blocks.quartz_block,2);
		bb.buildBlock(2,1,-1,Blocks.sandstone,2);bb.buildBlock(2,1,0,Blocks.wooden_door,8);bb.buildBlock(2,1,1,Blocks.sandstone,2);
		bb.buildBlock(2,1,2,Blocks.quartz_block,2);bb.buildBlock(2,1,7,Blocks.double_plant,10);bb.buildBlock(3,1,-7,Blocks.double_plant,8);
		bb.buildBlock(3,1,7,Blocks.double_plant,10);bb.buildBlock(4,1,-7,Blocks.double_plant,11);bb.buildBlock(4,1,7,Blocks.double_plant,9);
		bb.buildBlock(5,1,-7,Blocks.double_plant,11);bb.buildBlock(5,1,7,Blocks.double_plant,11);bb.buildBlock(6,1,-7,Blocks.double_plant,11);
		bb.buildBlock(6,1,7,Blocks.double_plant,9);bb.buildBlock(7,1,-7,Blocks.double_plant,8);bb.buildBlock(7,1,-6,Blocks.double_plant,8);
		bb.buildBlock(7,1,-5,Blocks.double_plant,8);bb.buildBlock(7,1,-4,Blocks.double_plant,8);bb.buildBlock(7,1,-3,Blocks.double_plant,9);
		bb.buildBlock(7,1,-2,Blocks.double_plant,8);bb.buildBlock(7,1,2,Blocks.double_plant,9);bb.buildBlock(7,1,3,Blocks.double_plant,9);
		bb.buildBlock(7,1,4,Blocks.double_plant,8);bb.buildBlock(7,1,5,Blocks.double_plant,8);bb.buildBlock(7,1,6,Blocks.double_plant,8);
		bb.buildBlock(7,1,7,Blocks.double_plant,9);bb.buildBlock(-2,2,-2,Blocks.quartz_block,2);bb.buildBlock(-2,2,-1,Blocks.sandstone,2);
		bb.buildBlock(-2,2,0,Blocks.glass_pane,0);bb.buildBlock(-2,2,1,Blocks.sandstone,2);bb.buildBlock(-2,2,2,Blocks.quartz_block,2);
		bb.buildBlock(-1,2,-2,Blocks.sandstone,2);bb.buildBlock(-1,2,2,Blocks.sandstone,2);bb.buildBlock(0,2,-2,Blocks.glass_pane,0);
		bb.buildBlock(0,2,2,Blocks.glass_pane,0);bb.buildBlock(1,2,-2,Blocks.sandstone,2);bb.buildBlock(1,2,1,Blocks.birch_stairs,0);
		bb.buildBlock(1,2,2,Blocks.sandstone,2);bb.buildBlock(2,2,-2,Blocks.quartz_block,2);bb.buildBlock(2,2,-1,Blocks.sandstone,2);
		bb.buildBlock(2,2,0,Blocks.sandstone,2);bb.buildBlock(2,2,1,Blocks.sandstone,2);bb.buildBlock(2,2,2,Blocks.quartz_block,2);
		bb.buildBlock(-2,3,-2,Blocks.quartz_block,2);bb.buildBlock(-2,3,-1,Blocks.sandstone,2);bb.buildBlock(-2,3,0,Blocks.sandstone,2);
		bb.buildBlock(-2,3,1,Blocks.sandstone,2);bb.buildBlock(-2,3,2,Blocks.quartz_block,2);bb.buildBlock(-1,3,-2,Blocks.sandstone,2);
		bb.buildBlock(-1,3,2,Blocks.sandstone,2);bb.buildBlock(0,3,-2,Blocks.sandstone,2);bb.buildBlock(0,3,2,Blocks.sandstone,2);
		bb.buildBlock(1,3,-2,Blocks.sandstone,2);bb.buildBlock(1,3,0,Blocks.birch_stairs,3);bb.buildBlock(1,3,2,Blocks.sandstone,2);
		bb.buildBlock(2,3,-2,Blocks.quartz_block,2);bb.buildBlock(2,3,-1,Blocks.sandstone,2);bb.buildBlock(2,3,0,Blocks.sandstone,2);
		bb.buildBlock(2,3,1,Blocks.sandstone,2);bb.buildBlock(2,3,2,Blocks.quartz_block,2);bb.buildBlock(-2,4,-2,Blocks.quartz_block,2);
		bb.buildBlock(-2,4,-1,Blocks.sandstone,2);bb.buildBlock(-2,4,0,Blocks.sandstone,2);bb.buildBlock(-2,4,1,Blocks.sandstone,2);
		bb.buildBlock(-2,4,2,Blocks.quartz_block,2);bb.buildBlock(-1,4,-2,Blocks.sandstone,2);bb.buildBlock(-1,4,2,Blocks.sandstone,2);
		bb.buildBlock(0,4,-2,Blocks.sandstone,2);bb.buildBlock(0,4,2,Blocks.sandstone,2);bb.buildBlock(1,4,-2,Blocks.sandstone,2);
		bb.buildBlock(1,4,-1,Blocks.birch_stairs,3);bb.buildBlock(1,4,2,Blocks.sandstone,2);bb.buildBlock(2,4,-2,Blocks.quartz_block,2);
		bb.buildBlock(2,4,-1,Blocks.sandstone,2);bb.buildBlock(2,4,0,Blocks.glass_pane,0);bb.buildBlock(2,4,1,Blocks.sandstone,2);
		bb.buildBlock(2,4,2,Blocks.quartz_block,2);bb.buildBlock(-2,5,-2,Blocks.quartz_block,2);bb.buildBlock(-2,5,-1,Blocks.sandstone,2);
		bb.buildBlock(-2,5,0,Blocks.sandstone,2);bb.buildBlock(-2,5,1,Blocks.sandstone,2);bb.buildBlock(-2,5,2,Blocks.quartz_block,2);
		bb.buildBlock(-1,5,-2,Blocks.sandstone,2);bb.buildBlock(-1,5,2,Blocks.sandstone,2);bb.buildBlock(0,5,-2,Blocks.sandstone,2);
		bb.buildBlock(0,5,-1,Blocks.birch_stairs,1);bb.buildBlock(0,5,2,Blocks.sandstone,2);bb.buildBlock(1,5,-2,Blocks.sandstone,2);
		bb.buildBlock(1,5,2,Blocks.sandstone,2);bb.buildBlock(2,5,-2,Blocks.quartz_block,2);bb.buildBlock(2,5,-1,Blocks.sandstone,2);
		bb.buildBlock(2,5,0,Blocks.glass_pane,0);bb.buildBlock(2,5,1,Blocks.sandstone,2);bb.buildBlock(2,5,2,Blocks.quartz_block,2);
		bb.buildBlock(-2,6,-2,Blocks.quartz_block,2);bb.buildBlock(-2,6,-1,Blocks.sandstone,2);bb.buildBlock(-2,6,0,Blocks.sandstone,2);
		bb.buildBlock(-2,6,1,Blocks.sandstone,2);bb.buildBlock(-2,6,2,Blocks.quartz_block,2);bb.buildBlock(-1,6,-2,Blocks.sandstone,2);
		bb.buildBlock(-1,6,-1,Blocks.birch_stairs,1);bb.buildBlock(-1,6,2,Blocks.sandstone,2);bb.buildBlock(0,6,-2,Blocks.sandstone,2);
		bb.buildBlock(0,6,2,Blocks.sandstone,2);bb.buildBlock(1,6,-2,Blocks.sandstone,2);bb.buildBlock(1,6,2,Blocks.sandstone,2);
		bb.buildBlock(2,6,-2,Blocks.quartz_block,2);bb.buildBlock(2,6,-1,Blocks.sandstone,2);bb.buildBlock(2,6,0,Blocks.glass_pane,0);
		bb.buildBlock(2,6,1,Blocks.sandstone,2);bb.buildBlock(2,6,2,Blocks.quartz_block,2);bb.buildBlock(-2,7,-2,Blocks.quartz_block,2);
		bb.buildBlock(-2,7,-1,Blocks.sandstone,2);bb.buildBlock(-2,7,0,Blocks.sandstone,2);bb.buildBlock(-2,7,1,Blocks.sandstone,2);
		bb.buildBlock(-2,7,2,Blocks.quartz_block,2);bb.buildBlock(-1,7,-2,Blocks.sandstone,2);bb.buildBlock(-1,7,0,Blocks.birch_stairs,2);
		bb.buildBlock(-1,7,1,Blocks.wooden_slab,8);bb.buildBlock(-1,7,2,Blocks.sandstone,2);bb.buildBlock(0,7,-2,Blocks.sandstone,2);
		bb.buildBlock(0,7,2,Blocks.sandstone,2);bb.buildBlock(1,7,-2,Blocks.sandstone,2);bb.buildBlock(1,7,2,Blocks.sandstone,2);
		bb.buildBlock(2,7,-2,Blocks.quartz_block,2);bb.buildBlock(2,7,-1,Blocks.sandstone,2);bb.buildBlock(2,7,0,Blocks.sandstone,2);
		bb.buildBlock(2,7,1,Blocks.sandstone,2);bb.buildBlock(2,7,2,Blocks.quartz_block,2);bb.buildBlock(-3,8,-2,Blocks.quartz_stairs,4);
		bb.buildBlock(-3,8,-1,Blocks.quartz_stairs,4);bb.buildBlock(-3,8,0,Blocks.quartz_stairs,4);bb.buildBlock(-3,8,1,Blocks.quartz_stairs,4);
		bb.buildBlock(-3,8,2,Blocks.quartz_stairs,4);bb.buildBlock(-2,8,-3,Blocks.quartz_stairs,6);bb.buildBlock(-2,8,-2,Blocks.quartz_block,0);
		bb.buildBlock(-2,8,-1,Blocks.quartz_stairs,1);bb.buildBlock(-2,8,0,Blocks.quartz_stairs,1);bb.buildBlock(-2,8,1,Blocks.quartz_stairs,1);
		bb.buildBlock(-2,8,2,Blocks.quartz_block,0);bb.buildBlock(-2,8,3,Blocks.quartz_stairs,7);bb.buildBlock(-1,8,-3,Blocks.quartz_stairs,6);
		bb.buildBlock(-1,8,-2,Blocks.quartz_block,0);bb.buildBlock(-1,8,2,Blocks.quartz_block,0);bb.buildBlock(-1,8,3,Blocks.quartz_stairs,7);
		bb.buildBlock(0,8,-3,Blocks.quartz_stairs,6);bb.buildBlock(0,8,-2,Blocks.quartz_block,0);bb.buildBlock(0,8,0,Blocks.wooden_slab,0);
		bb.buildBlock(0,8,1,Blocks.wooden_slab,2);bb.buildBlock(0,8,2,Blocks.quartz_block,0);bb.buildBlock(0,8,3,Blocks.quartz_stairs,7);
		bb.buildBlock(1,8,-3,Blocks.quartz_stairs,6);bb.buildBlock(1,8,-2,Blocks.quartz_block,0);bb.buildBlock(1,8,-1,Blocks.wooden_slab,0);
		bb.buildBlock(1,8,0,Blocks.wooden_slab,2);bb.buildBlock(1,8,1,Blocks.wooden_slab,0);bb.buildBlock(1,8,2,Blocks.quartz_block,0);
		bb.buildBlock(1,8,3,Blocks.quartz_stairs,7);bb.buildBlock(2,8,-3,Blocks.quartz_stairs,6);bb.buildBlock(2,8,-2,Blocks.quartz_block,0);
		bb.buildBlock(2,8,-1,Blocks.quartz_stairs,0);bb.buildBlock(2,8,0,Blocks.quartz_stairs,0);bb.buildBlock(2,8,1,Blocks.quartz_stairs,0);
		bb.buildBlock(2,8,2,Blocks.quartz_block,0);bb.buildBlock(2,8,3,Blocks.quartz_stairs,7);bb.buildBlock(3,8,-2,Blocks.quartz_stairs,5);
		bb.buildBlock(3,8,-1,Blocks.quartz_stairs,5);bb.buildBlock(3,8,0,Blocks.quartz_stairs,5);bb.buildBlock(3,8,1,Blocks.quartz_stairs,5);
		bb.buildBlock(3,8,2,Blocks.quartz_stairs,5);bb.buildBlock(-3,9,-2,Blocks.gold_block,0);bb.buildBlock(-3,9,-1,Blocks.gold_block,0);
		bb.buildBlock(-3,9,0,Blocks.gold_block,0);bb.buildBlock(-3,9,1,Blocks.gold_block,0);bb.buildBlock(-3,9,2,Blocks.gold_block,0);
		bb.buildBlock(-2,9,-3,Blocks.gold_block,0);bb.buildBlock(-2,9,-2,Blocks.flower_pot,3);bb.addTileEntityPot(-2,9,-2,38,3);
		bb.buildBlock(-2,9,2,Blocks.flower_pot,3);bb.addTileEntityPot(-2,9,2,38,3);
		bb.buildBlock(-2,9,3,Blocks.gold_block,0);bb.buildBlock(-1,9,-3,Blocks.gold_block,0);bb.buildBlock(-1,9,3,Blocks.gold_block,0);
		bb.buildBlock(0,9,-3,Blocks.gold_block,0);bb.buildBlock(0,9,-2,ModBlocks.blockOakChair,0);bb.buildBlock(0,9,2,ModBlocks.blockOakChair,0);bb.buildBlock(0,9,3,Blocks.gold_block,0);bb.buildBlock(1,9,-3,Blocks.gold_block,0);bb.buildBlock(1,9,3,Blocks.gold_block,0);
		bb.buildBlock(2,9,-3,Blocks.gold_block,0);bb.buildBlock(2,9,-2,Blocks.flower_pot,3);bb.addTileEntityPot(2,9,-2,38,3);
		bb.buildBlock(2,9,2,Blocks.flower_pot,3);bb.addTileEntityPot(2,9,2,38,3);
		bb.buildBlock(2,9,3,Blocks.gold_block,0);bb.buildBlock(3,9,-2,Blocks.gold_block,0);bb.buildBlock(3,9,-1,Blocks.gold_block,0);
		bb.buildBlock(3,9,0,Blocks.gold_block,0);bb.buildBlock(3,9,1,Blocks.gold_block,0);bb.buildBlock(3,9,2,Blocks.gold_block,0);
		bb.buildBlock(-3,10,-3,Blocks.gold_block,0);bb.buildBlock(-3,10,-2,Blocks.gold_block,0);bb.buildBlock(-3,10,-1,Blocks.glass_pane,0);
		bb.buildBlock(-3,10,0,Blocks.glass_pane,0);bb.buildBlock(-3,10,1,Blocks.glass_pane,0);bb.buildBlock(-3,10,2,Blocks.gold_block,0);
		bb.buildBlock(-3,10,3,Blocks.gold_block,0);bb.buildBlock(-2,10,-3,Blocks.gold_block,0);bb.buildBlock(-2,10,3,Blocks.gold_block,0);
		bb.buildBlock(-1,10,-3,Blocks.glass_pane,0);bb.buildBlock(-1,10,3,Blocks.glass_pane,0);bb.buildBlock(0,10,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,10,3,Blocks.glass_pane,0);bb.buildBlock(1,10,-3,Blocks.glass_pane,0);bb.buildBlock(1,10,3,Blocks.glass_pane,0);
		bb.buildBlock(2,10,-3,Blocks.gold_block,0);bb.buildBlock(2,10,3,Blocks.gold_block,0);bb.buildBlock(3,10,-3,Blocks.gold_block,0);
		bb.buildBlock(3,10,-2,Blocks.gold_block,0);bb.buildBlock(3,10,-1,Blocks.quartz_block,1);bb.buildBlock(3,10,0,Blocks.quartz_block,1);
		bb.buildBlock(3,10,1,Blocks.quartz_block,1);bb.buildBlock(3,10,2,Blocks.gold_block,0);bb.buildBlock(3,10,3,Blocks.gold_block,0);
		bb.buildBlock(-3,11,-3,Blocks.gold_block,0);bb.buildBlock(-3,11,-2,Blocks.gold_block,0);bb.buildBlock(-3,11,-1,Blocks.glass_pane,0);
		bb.buildBlock(-3,11,0,Blocks.glass_pane,0);bb.buildBlock(-3,11,1,Blocks.glass_pane,0);bb.buildBlock(-3,11,2,Blocks.gold_block,0);
		bb.buildBlock(-3,11,3,Blocks.gold_block,0);bb.buildBlock(-2,11,-3,Blocks.gold_block,0);bb.buildBlock(-2,11,3,Blocks.gold_block,0);
		bb.buildBlock(-1,11,-3,Blocks.glass_pane,0);bb.buildBlock(-1,11,3,Blocks.glass_pane,0);bb.buildBlock(0,11,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,11,3,Blocks.glass_pane,0);bb.buildBlock(1,11,-3,Blocks.glass_pane,0);bb.buildBlock(1,11,3,Blocks.glass_pane,0);
		bb.buildBlock(2,11,-3,Blocks.gold_block,0);bb.buildBlock(2,11,3,Blocks.gold_block,0);bb.buildBlock(3,11,-3,Blocks.gold_block,0);
		bb.buildBlock(3,11,-2,Blocks.gold_block,0);bb.buildBlock(3,11,-1,Blocks.quartz_block,1);bb.buildBlock(3,11,0,Blocks.quartz_block,1);
		bb.buildBlock(3,11,1,Blocks.quartz_block,1);bb.buildBlock(3,11,2,Blocks.gold_block,0);bb.buildBlock(3,11,3,Blocks.gold_block,0);
		bb.buildBlock(-3,12,-3,Blocks.gold_block,0);bb.buildBlock(-3,12,-2,Blocks.gold_block,0);bb.buildBlock(-3,12,-1,Blocks.glass_pane,0);
		bb.buildBlock(-3,12,0,Blocks.glass_pane,0);bb.buildBlock(-3,12,1,Blocks.glass_pane,0);bb.buildBlock(-3,12,2,Blocks.gold_block,0);
		bb.buildBlock(-3,12,3,Blocks.gold_block,0);bb.buildBlock(-2,12,-3,Blocks.gold_block,0);bb.buildBlock(-2,12,3,Blocks.gold_block,0);
		bb.buildBlock(-1,12,-3,Blocks.glass_pane,0);bb.buildBlock(-1,12,3,Blocks.glass_pane,0);bb.buildBlock(0,12,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,12,3,Blocks.glass_pane,0);bb.buildBlock(1,12,-3,Blocks.glass_pane,0);bb.buildBlock(1,12,3,Blocks.glass_pane,0);
		bb.buildBlock(2,12,-3,Blocks.gold_block,0);bb.buildBlock(2,12,3,Blocks.gold_block,0);bb.buildBlock(3,12,-3,Blocks.gold_block,0);
		bb.buildBlock(3,12,-2,Blocks.gold_block,0);bb.buildBlock(3,12,-1,Blocks.quartz_block,1);bb.buildBlock(3,12,0,Blocks.quartz_block,1);
		bb.buildBlock(3,12,1,Blocks.quartz_block,1);bb.buildBlock(3,12,2,Blocks.gold_block,0);bb.buildBlock(3,12,3,Blocks.gold_block,0);
		bb.buildBlock(-3,13,-2,Blocks.gold_block,0);bb.buildBlock(-3,13,-1,Blocks.gold_block,0);bb.buildBlock(-3,13,0,Blocks.gold_block,0);
		bb.buildBlock(-3,13,1,Blocks.gold_block,0);bb.buildBlock(-3,13,2,Blocks.gold_block,0);bb.buildBlock(-2,13,-3,Blocks.gold_block,0);
		bb.buildBlock(-2,13,3,Blocks.gold_block,0);bb.buildBlock(-1,13,-3,Blocks.gold_block,0);bb.buildBlock(-1,13,3,Blocks.gold_block,0);
		bb.buildBlock(0,13,-3,Blocks.gold_block,0);bb.buildBlock(0,13,3,Blocks.gold_block,0);bb.buildBlock(1,13,-3,Blocks.gold_block,0);
		bb.buildBlock(1,13,3,Blocks.gold_block,0);bb.buildBlock(2,13,-3,Blocks.gold_block,0);bb.buildBlock(2,13,3,Blocks.gold_block,0);
		bb.buildBlock(3,13,-2,Blocks.gold_block,0);bb.buildBlock(3,13,-1,Blocks.gold_block,0);bb.buildBlock(3,13,0,Blocks.gold_block,0);
		bb.buildBlock(3,13,1,Blocks.gold_block,0);bb.buildBlock(3,13,2,Blocks.gold_block,0);bb.buildBlock(-2,14,-2,Blocks.gold_block,0);
		bb.buildBlock(-2,14,-1,Blocks.gold_block,0);bb.buildBlock(-2,14,0,Blocks.gold_block,0);bb.buildBlock(-2,14,1,Blocks.gold_block,0);
		bb.buildBlock(-2,14,2,Blocks.gold_block,0);bb.buildBlock(-1,14,-2,Blocks.gold_block,0);bb.buildBlock(-1,14,-1,Blocks.gold_block,0);
		bb.buildBlock(-1,14,0,Blocks.gold_block,0);bb.buildBlock(-1,14,1,Blocks.gold_block,0);bb.buildBlock(-1,14,2,Blocks.gold_block,0);
		bb.buildBlock(0,14,-2,Blocks.gold_block,0);bb.buildBlock(0,14,-1,Blocks.gold_block,0);bb.buildBlock(0,14,0,Blocks.gold_block,0);
		bb.buildBlock(0,14,1,Blocks.gold_block,0);bb.buildBlock(0,14,2,Blocks.gold_block,0);bb.buildBlock(1,14,-2,Blocks.gold_block,0);
		bb.buildBlock(1,14,-1,Blocks.gold_block,0);bb.buildBlock(1,14,0,Blocks.gold_block,0);bb.buildBlock(1,14,1,Blocks.gold_block,0);
		bb.buildBlock(1,14,2,Blocks.gold_block,0);bb.buildBlock(2,14,-2,Blocks.gold_block,0);bb.buildBlock(2,14,-1,Blocks.gold_block,0);
		bb.buildBlock(2,14,0,Blocks.gold_block,0);bb.buildBlock(2,14,1,Blocks.gold_block,0);bb.buildBlock(2,14,2,Blocks.gold_block,0);
		bb.buildBlock(1,2,-1,Blocks.torch,2);bb.buildBlock(-3,3,-1,Blocks.torch,2);bb.buildBlock(-3,3,1,Blocks.torch,2);
		bb.buildBlock(-1,3,-3,Blocks.torch,4);bb.buildBlock(1,3,-3,Blocks.torch,4);bb.buildBlock(3,3,-1,Blocks.torch,1);
		bb.buildBlock(3,3,1,Blocks.torch,1);bb.buildBlock(-1,5,0,Blocks.torch,1);bb.buildBlock(-2,12,-2,Blocks.torch,3);
		bb.buildBlock(-2,12,2,Blocks.torch,4);bb.buildBlock(2,12,-2,Blocks.torch,3);bb.buildBlock(2,12,2,Blocks.torch,4);
	}

}
