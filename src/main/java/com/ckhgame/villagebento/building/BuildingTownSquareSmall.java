package com.ckhgame.villagebento.building;

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
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.grass,0);bb.buildBlock(0,-1,3,Blocks.planks,3);
		bb.buildBlock(0,-1,4,Blocks.grass,0);bb.buildBlock(0,-1,5,Blocks.planks,2);bb.buildBlock(1,-1,-5,Blocks.planks,2);
		bb.buildBlock(1,-1,-4,Blocks.grass,0);bb.buildBlock(1,-1,-3,Blocks.planks,3);bb.buildBlock(1,-1,-2,Blocks.grass,0);
		bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.grass,0);
		bb.buildBlock(1,-1,3,Blocks.planks,3);bb.buildBlock(1,-1,4,Blocks.grass,0);bb.buildBlock(1,-1,5,Blocks.planks,2);
		bb.buildBlock(2,-1,-5,Blocks.planks,2);bb.buildBlock(2,-1,-4,Blocks.grass,0);bb.buildBlock(2,-1,-3,Blocks.planks,3);
		bb.buildBlock(2,-1,-2,Blocks.grass,0);bb.buildBlock(2,-1,-1,Blocks.grass,0);bb.buildBlock(2,-1,0,Blocks.planks,3);
		bb.buildBlock(2,-1,1,Blocks.grass,0);bb.buildBlock(2,-1,2,Blocks.grass,0);bb.buildBlock(2,-1,3,Blocks.planks,3);
		bb.buildBlock(2,-1,4,Blocks.grass,0);bb.buildBlock(2,-1,5,Blocks.planks,2);bb.buildBlock(3,-1,-5,Blocks.planks,2);
		bb.buildBlock(3,-1,-4,Blocks.grass,0);bb.buildBlock(3,-1,-3,Blocks.planks,3);bb.buildBlock(3,-1,-2,Blocks.planks,3);
		bb.buildBlock(3,-1,-1,Blocks.planks,3);bb.buildBlock(3,-1,0,Blocks.planks,3);bb.buildBlock(3,-1,1,Blocks.planks,3);
		bb.buildBlock(3,-1,2,Blocks.planks,3);bb.buildBlock(3,-1,3,Blocks.planks,3);bb.buildBlock(3,-1,4,Blocks.grass,0);
		bb.buildBlock(3,-1,5,Blocks.planks,2);bb.buildBlock(4,-1,-5,Blocks.planks,2);bb.buildBlock(4,-1,-4,Blocks.grass,0);
		bb.buildBlock(4,-1,-3,Blocks.grass,0);bb.buildBlock(4,-1,-2,Blocks.grass,0);bb.buildBlock(4,-1,-1,Blocks.grass,0);
		bb.buildBlock(4,-1,0,Blocks.planks,3);bb.buildBlock(4,-1,1,Blocks.grass,0);bb.buildBlock(4,-1,2,Blocks.grass,0);
		bb.buildBlock(4,-1,3,Blocks.grass,0);bb.buildBlock(4,-1,4,Blocks.grass,0);bb.buildBlock(4,-1,5,Blocks.planks,2);
		bb.buildBlock(5,-1,-5,Blocks.planks,2);bb.buildBlock(5,-1,-4,Blocks.planks,2);bb.buildBlock(5,-1,-3,Blocks.planks,2);
		bb.buildBlock(5,-1,-2,Blocks.planks,2);bb.buildBlock(5,-1,-1,Blocks.planks,2);bb.buildBlock(5,-1,0,Blocks.planks,3);
		bb.buildBlock(5,-1,1,Blocks.planks,2);bb.buildBlock(5,-1,2,Blocks.planks,2);bb.buildBlock(5,-1,3,Blocks.planks,2);
		bb.buildBlock(5,-1,4,Blocks.planks,2);bb.buildBlock(5,-1,5,Blocks.planks,2);bb.buildBlock(-4,0,-4,Blocks.red_flower,4);
		bb.buildBlock(-4,0,-3,Blocks.red_flower,6);bb.buildBlock(-4,0,-2,Blocks.red_flower,7);bb.buildBlock(-4,0,-1,Blocks.red_flower,6);
		bb.buildBlock(-4,0,0,Blocks.red_flower,5);bb.buildBlock(-4,0,1,Blocks.red_flower,6);bb.buildBlock(-4,0,2,Blocks.red_flower,7);
		bb.buildBlock(-4,0,3,Blocks.red_flower,6);bb.buildBlock(-4,0,4,Blocks.red_flower,4);bb.buildBlock(-3,0,-4,Blocks.red_flower,6);
		bb.buildBlock(-3,0,4,Blocks.red_flower,6);bb.buildBlock(-2,0,-4,Blocks.red_flower,7);bb.buildBlock(-2,0,-2,Blocks.double_plant,1);
		bb.buildBlock(-2,0,-1,Blocks.double_plant,4);bb.buildBlock(-2,0,0,Blocks.double_plant,1);bb.buildBlock(-2,0,1,Blocks.double_plant,4);
		bb.buildBlock(-2,0,2,Blocks.double_plant,1);bb.buildBlock(-2,0,4,Blocks.red_flower,7);bb.buildBlock(-1,0,-4,Blocks.red_flower,6);
		bb.buildBlock(-1,0,-2,Blocks.double_plant,4);bb.buildBlock(-1,0,-1,Blocks.planks,0);bb.buildBlock(-1,0,0,Blocks.planks,0);
		bb.buildBlock(-1,0,1,Blocks.planks,0);bb.buildBlock(-1,0,2,Blocks.double_plant,4);bb.buildBlock(-1,0,4,Blocks.red_flower,6);
		bb.buildBlock(0,0,-4,Blocks.red_flower,5);bb.buildBlock(0,0,-2,Blocks.double_plant,1);bb.buildBlock(0,0,-1,Blocks.planks,0);
		bb.buildBlock(0,0,0,Blocks.ladder,5);bb.buildBlock(0,0,1,Blocks.planks,0);bb.buildBlock(0,0,2,Blocks.double_plant,1);
		bb.buildBlock(0,0,4,Blocks.red_flower,5);bb.buildBlock(1,0,-4,Blocks.red_flower,6);bb.buildBlock(1,0,-2,Blocks.double_plant,4);
		bb.buildBlock(1,0,-1,Blocks.planks,0);bb.buildBlock(1,0,0,Blocks.wooden_door,0);bb.buildBlock(1,0,1,Blocks.planks,0);
		bb.buildBlock(1,0,2,Blocks.double_plant,4);bb.buildBlock(1,0,4,Blocks.red_flower,6);bb.buildBlock(2,0,-4,Blocks.red_flower,4);
		bb.buildBlock(2,0,-2,Blocks.double_plant,1);bb.buildBlock(2,0,-1,Blocks.double_plant,4);bb.buildBlock(2,0,1,Blocks.double_plant,4);
		bb.buildBlock(2,0,2,Blocks.double_plant,1);bb.buildBlock(2,0,4,Blocks.red_flower,4);bb.buildBlock(3,0,-4,Blocks.red_flower,6);
		bb.buildBlock(3,0,4,Blocks.red_flower,6);bb.buildBlock(4,0,-4,Blocks.red_flower,7);bb.buildBlock(4,0,-3,Blocks.red_flower,6);
		bb.buildBlock(4,0,-2,Blocks.red_flower,5);bb.buildBlock(4,0,-1,Blocks.red_flower,6);bb.buildBlock(4,0,1,Blocks.red_flower,6);
		bb.buildBlock(4,0,2,Blocks.red_flower,5);bb.buildBlock(4,0,3,Blocks.red_flower,6);bb.buildBlock(4,0,4,Blocks.red_flower,7);
		bb.buildBlock(-2,1,-2,Blocks.double_plant,10);bb.buildBlock(-2,1,-1,Blocks.double_plant,9);bb.buildBlock(-2,1,0,Blocks.double_plant,9);
		bb.buildBlock(-2,1,1,Blocks.double_plant,9);bb.buildBlock(-2,1,2,Blocks.double_plant,9);bb.buildBlock(-1,1,-2,Blocks.double_plant,10);
		bb.buildBlock(-1,1,-1,Blocks.planks,0);bb.buildBlock(-1,1,0,Blocks.planks,0);bb.buildBlock(-1,1,1,Blocks.planks,0);
		bb.buildBlock(-1,1,2,Blocks.double_plant,8);bb.buildBlock(0,1,-2,Blocks.double_plant,10);bb.buildBlock(0,1,-1,Blocks.planks,0);
		bb.buildBlock(0,1,0,Blocks.ladder,5);bb.buildBlock(0,1,1,Blocks.planks,0);bb.buildBlock(0,1,2,Blocks.double_plant,8);
		bb.buildBlock(1,1,-2,Blocks.double_plant,10);bb.buildBlock(1,1,-1,Blocks.planks,0);bb.buildBlock(1,1,0,Blocks.wooden_door,8);
		bb.buildBlock(1,1,1,Blocks.planks,0);bb.buildBlock(1,1,2,Blocks.double_plant,8);bb.buildBlock(2,1,-2,Blocks.double_plant,11);
		bb.buildBlock(2,1,-1,Blocks.double_plant,11);bb.buildBlock(2,1,1,Blocks.double_plant,8);bb.buildBlock(2,1,2,Blocks.double_plant,11);
		bb.buildBlock(-1,2,-1,Blocks.planks,0);bb.buildBlock(-1,2,0,Blocks.planks,0);bb.buildBlock(-1,2,1,Blocks.planks,0);
		bb.buildBlock(0,2,-1,Blocks.planks,0);bb.buildBlock(0,2,0,Blocks.ladder,5);bb.buildBlock(0,2,1,Blocks.planks,0);
		bb.buildBlock(1,2,-1,Blocks.planks,0);bb.buildBlock(1,2,0,Blocks.planks,0);bb.buildBlock(1,2,1,Blocks.planks,0);
		bb.buildBlock(-1,3,-1,Blocks.planks,0);bb.buildBlock(-1,3,0,Blocks.planks,0);bb.buildBlock(-1,3,1,Blocks.planks,0);
		bb.buildBlock(0,3,-1,Blocks.planks,0);bb.buildBlock(0,3,0,Blocks.ladder,5);bb.buildBlock(0,3,1,Blocks.planks,0);
		bb.buildBlock(1,3,-1,Blocks.planks,0);bb.buildBlock(1,3,0,Blocks.planks,0);bb.buildBlock(1,3,1,Blocks.planks,0);
		bb.buildBlock(-1,4,-1,Blocks.planks,0);bb.buildBlock(-1,4,0,Blocks.planks,0);bb.buildBlock(-1,4,1,Blocks.planks,0);
		bb.buildBlock(0,4,-1,Blocks.planks,0);bb.buildBlock(0,4,0,Blocks.ladder,5);bb.buildBlock(0,4,1,Blocks.planks,0);
		bb.buildBlock(1,4,-1,Blocks.planks,0);bb.buildBlock(1,4,0,Blocks.planks,0);bb.buildBlock(1,4,1,Blocks.planks,0);
		bb.buildBlock(-1,5,-1,Blocks.planks,0);bb.buildBlock(-1,5,0,Blocks.planks,0);bb.buildBlock(-1,5,1,Blocks.planks,0);
		bb.buildBlock(0,5,-1,Blocks.glass_pane,0);bb.buildBlock(0,5,0,Blocks.ladder,5);bb.buildBlock(0,5,1,Blocks.planks,0);
		bb.buildBlock(1,5,-1,Blocks.planks,0);bb.buildBlock(1,5,0,Blocks.planks,0);bb.buildBlock(1,5,1,Blocks.planks,0);
		bb.buildBlock(-1,6,-1,Blocks.planks,0);bb.buildBlock(-1,6,0,Blocks.planks,0);bb.buildBlock(-1,6,1,Blocks.planks,0);
		bb.buildBlock(0,6,-1,Blocks.planks,0);bb.buildBlock(0,6,0,Blocks.ladder,5);bb.buildBlock(0,6,1,Blocks.planks,0);
		bb.buildBlock(1,6,-1,Blocks.planks,0);bb.buildBlock(1,6,0,Blocks.planks,0);bb.buildBlock(1,6,1,Blocks.planks,0);
		bb.buildBlock(-1,7,-1,Blocks.planks,0);bb.buildBlock(-1,7,0,Blocks.planks,0);bb.buildBlock(-1,7,1,Blocks.planks,0);
		bb.buildBlock(0,7,-1,Blocks.planks,0);bb.buildBlock(0,7,0,Blocks.ladder,5);bb.buildBlock(0,7,1,Blocks.planks,0);
		bb.buildBlock(1,7,-1,Blocks.planks,0);bb.buildBlock(1,7,0,Blocks.planks,0);bb.buildBlock(1,7,1,Blocks.planks,0);
		bb.buildBlock(-1,8,-1,Blocks.planks,0);bb.buildBlock(-1,8,0,Blocks.planks,0);bb.buildBlock(-1,8,1,Blocks.planks,0);
		bb.buildBlock(0,8,-1,Blocks.planks,0);bb.buildBlock(0,8,0,Blocks.ladder,5);bb.buildBlock(0,8,1,Blocks.planks,0);
		bb.buildBlock(1,8,-1,Blocks.planks,0);bb.buildBlock(1,8,0,Blocks.planks,0);bb.buildBlock(1,8,1,Blocks.planks,0);
		bb.buildBlock(-1,9,-1,Blocks.planks,0);bb.buildBlock(-1,9,0,Blocks.planks,0);bb.buildBlock(-1,9,1,Blocks.planks,0);
		bb.buildBlock(0,9,-1,Blocks.planks,0);bb.buildBlock(0,9,0,Blocks.ladder,5);bb.buildBlock(0,9,1,Blocks.planks,0);
		bb.buildBlock(1,9,-1,Blocks.planks,0);bb.buildBlock(1,9,0,Blocks.planks,0);bb.buildBlock(1,9,1,Blocks.planks,0);
		bb.buildBlock(-2,10,-2,Blocks.log,0);bb.buildBlock(-2,10,-1,Blocks.planks,2);bb.buildBlock(-2,10,0,Blocks.planks,2);
		bb.buildBlock(-2,10,1,Blocks.planks,2);bb.buildBlock(-2,10,2,Blocks.log,0);bb.buildBlock(-1,10,-2,Blocks.planks,2);
		bb.buildBlock(-1,10,-1,Blocks.carpet,14);bb.buildBlock(-1,10,0,Blocks.carpet,14);bb.buildBlock(-1,10,1,Blocks.carpet,14);
		bb.buildBlock(-1,10,2,Blocks.planks,2);bb.buildBlock(0,10,-2,Blocks.planks,2);bb.buildBlock(0,10,-1,Blocks.carpet,14);
		bb.buildBlock(0,10,1,Blocks.carpet,14);bb.buildBlock(0,10,2,Blocks.planks,2);bb.buildBlock(1,10,-2,Blocks.planks,2);
		bb.buildBlock(1,10,-1,Blocks.carpet,14);bb.buildBlock(1,10,0,Blocks.carpet,14);bb.buildBlock(1,10,1,Blocks.carpet,14);
		bb.buildBlock(1,10,2,Blocks.planks,2);bb.buildBlock(2,10,-2,Blocks.log,0);bb.buildBlock(2,10,-1,Blocks.planks,2);
		bb.buildBlock(2,10,0,Blocks.planks,2);bb.buildBlock(2,10,1,Blocks.planks,2);bb.buildBlock(2,10,2,Blocks.log,0);
		bb.buildBlock(-2,11,-2,Blocks.log,0);bb.buildBlock(-2,11,-1,Blocks.planks,2);bb.buildBlock(-2,11,0,Blocks.glass_pane,0);
		bb.buildBlock(-2,11,1,Blocks.planks,2);bb.buildBlock(-2,11,2,Blocks.log,0);bb.buildBlock(-1,11,-2,Blocks.planks,2);
		bb.buildBlock(-1,11,2,Blocks.planks,2);bb.buildBlock(0,11,-2,Blocks.glass_pane,0);bb.buildBlock(0,11,2,Blocks.glass_pane,0);
		bb.buildBlock(1,11,-2,Blocks.planks,2);bb.buildBlock(1,11,2,Blocks.planks,2);bb.buildBlock(2,11,-2,Blocks.log,0);
		bb.buildBlock(2,11,-1,Blocks.planks,2);bb.buildBlock(2,11,0,Blocks.planks,2);bb.buildBlock(2,11,1,Blocks.planks,2);
		bb.buildBlock(2,11,2,Blocks.log,0);bb.buildBlock(-2,12,-2,Blocks.log,0);bb.buildBlock(-2,12,-1,Blocks.planks,2);
		bb.buildBlock(-2,12,0,Blocks.glass_pane,0);bb.buildBlock(-2,12,1,Blocks.planks,2);bb.buildBlock(-2,12,2,Blocks.log,0);
		bb.buildBlock(-1,12,-2,Blocks.planks,2);bb.buildBlock(-1,12,2,Blocks.planks,2);bb.buildBlock(0,12,-2,Blocks.glass_pane,0);
		bb.buildBlock(0,12,2,Blocks.glass_pane,0);bb.buildBlock(1,12,-2,Blocks.planks,2);bb.buildBlock(1,12,2,Blocks.planks,2);
		bb.buildBlock(2,12,-2,Blocks.log,0);bb.buildBlock(2,12,-1,Blocks.planks,2);bb.buildBlock(2,12,0,Blocks.planks,2);
		bb.buildBlock(2,12,1,Blocks.planks,2);bb.buildBlock(2,12,2,Blocks.log,0);bb.buildBlock(-2,13,-2,Blocks.log,0);
		bb.buildBlock(-2,13,-1,Blocks.planks,2);bb.buildBlock(-2,13,0,Blocks.planks,2);bb.buildBlock(-2,13,1,Blocks.planks,2);
		bb.buildBlock(-2,13,2,Blocks.log,0);bb.buildBlock(-1,13,-2,Blocks.planks,2);bb.buildBlock(-1,13,2,Blocks.planks,2);
		bb.buildBlock(0,13,-2,Blocks.planks,2);bb.buildBlock(0,13,2,Blocks.planks,2);bb.buildBlock(1,13,-2,Blocks.planks,2);
		bb.buildBlock(1,13,2,Blocks.planks,2);bb.buildBlock(2,13,-2,Blocks.log,0);bb.buildBlock(2,13,-1,Blocks.planks,2);
		bb.buildBlock(2,13,0,Blocks.planks,2);bb.buildBlock(2,13,1,Blocks.planks,2);bb.buildBlock(2,13,2,Blocks.log,0);
		bb.buildBlock(-3,14,-3,Blocks.wooden_slab,4);bb.buildBlock(-3,14,-2,Blocks.wooden_slab,4);bb.buildBlock(-3,14,-1,Blocks.wooden_slab,4);
		bb.buildBlock(-3,14,0,Blocks.wooden_slab,4);bb.buildBlock(-3,14,1,Blocks.wooden_slab,4);bb.buildBlock(-3,14,2,Blocks.wooden_slab,4);
		bb.buildBlock(-3,14,3,Blocks.wooden_slab,4);bb.buildBlock(-2,14,-3,Blocks.wooden_slab,4);bb.buildBlock(-2,14,-2,Blocks.acacia_stairs,0);
		bb.buildBlock(-2,14,-1,Blocks.acacia_stairs,0);bb.buildBlock(-2,14,0,Blocks.acacia_stairs,0);bb.buildBlock(-2,14,1,Blocks.acacia_stairs,0);
		bb.buildBlock(-2,14,2,Blocks.acacia_stairs,0);bb.buildBlock(-2,14,3,Blocks.wooden_slab,4);bb.buildBlock(-1,14,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-1,14,-2,Blocks.acacia_stairs,2);bb.buildBlock(-1,14,-1,Blocks.planks,4);bb.buildBlock(-1,14,0,Blocks.planks,4);
		bb.buildBlock(-1,14,1,Blocks.planks,4);bb.buildBlock(-1,14,2,Blocks.acacia_stairs,3);bb.buildBlock(-1,14,3,Blocks.wooden_slab,4);
		bb.buildBlock(0,14,-3,Blocks.wooden_slab,4);bb.buildBlock(0,14,-2,Blocks.acacia_stairs,2);bb.buildBlock(0,14,-1,Blocks.planks,4);
		bb.buildBlock(0,14,0,Blocks.planks,4);bb.buildBlock(0,14,1,Blocks.planks,4);bb.buildBlock(0,14,2,Blocks.acacia_stairs,3);
		bb.buildBlock(0,14,3,Blocks.wooden_slab,4);bb.buildBlock(1,14,-3,Blocks.wooden_slab,4);bb.buildBlock(1,14,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(1,14,-1,Blocks.planks,4);bb.buildBlock(1,14,0,Blocks.planks,4);bb.buildBlock(1,14,1,Blocks.planks,4);
		bb.buildBlock(1,14,2,Blocks.acacia_stairs,3);bb.buildBlock(1,14,3,Blocks.wooden_slab,4);bb.buildBlock(2,14,-3,Blocks.wooden_slab,4);
		bb.buildBlock(2,14,-2,Blocks.acacia_stairs,2);bb.buildBlock(2,14,-1,Blocks.acacia_stairs,1);bb.buildBlock(2,14,0,Blocks.acacia_stairs,1);
		bb.buildBlock(2,14,1,Blocks.acacia_stairs,1);bb.buildBlock(2,14,2,Blocks.acacia_stairs,1);bb.buildBlock(2,14,3,Blocks.wooden_slab,4);
		bb.buildBlock(3,14,-3,Blocks.wooden_slab,4);bb.buildBlock(3,14,-2,Blocks.wooden_slab,4);bb.buildBlock(3,14,-1,Blocks.wooden_slab,4);
		bb.buildBlock(3,14,0,Blocks.wooden_slab,4);bb.buildBlock(3,14,1,Blocks.wooden_slab,4);bb.buildBlock(3,14,2,Blocks.wooden_slab,4);
		bb.buildBlock(3,14,3,Blocks.wooden_slab,4);bb.buildBlock(-2,3,0,Blocks.torch,2);bb.buildBlock(0,3,-2,Blocks.torch,4);
		bb.buildBlock(0,3,2,Blocks.torch,3);bb.buildBlock(2,3,0,Blocks.torch,1);bb.buildBlock(-3,12,-2,Blocks.torch,2);
		bb.buildBlock(-3,12,2,Blocks.torch,2);bb.buildBlock(-2,12,-3,Blocks.torch,4);bb.buildBlock(-2,12,3,Blocks.torch,3);
		bb.buildBlock(2,12,-3,Blocks.torch,4);bb.buildBlock(2,12,3,Blocks.torch,3);bb.buildBlock(3,12,-2,Blocks.torch,1);
		bb.buildBlock(3,12,2,Blocks.torch,1);bb.buildBlock(-1,13,-1,Blocks.torch,3);bb.buildBlock(-1,13,1,Blocks.torch,4);
		bb.buildBlock(1,13,-1,Blocks.torch,3);bb.buildBlock(1,13,1,Blocks.torch,4);
	}

}
