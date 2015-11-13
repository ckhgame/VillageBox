package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerHunter;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class BuildingHunterHouse extends Building {

	@Override
	public String getName() {
		return "Hunter's House";
	}

	@Override
	public String getDescription() {
		return "All back to the nature!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerHunter.class,"Jennifer",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,0,-3,Blocks.fence,0);bb.buildBlock(-3,0,-2,Blocks.log,3);bb.buildBlock(-3,0,-1,Blocks.planks,5);
		bb.buildBlock(-3,0,0,Blocks.planks,5);bb.buildBlock(-3,0,1,Blocks.planks,5);bb.buildBlock(-3,0,2,Blocks.planks,5);
		bb.buildBlock(-3,0,3,Blocks.log,3);bb.buildBlock(-2,0,-3,Blocks.fence,0);bb.buildBlock(-2,0,-2,Blocks.planks,5);
		bb.buildBlock(-2,0,-1,Blocks.flower_pot,3);bb.addTileEntityPot(-2,0,-1,38,3);
		bb.buildBlock(-2,0,1,Blocks.ladder,2);bb.buildBlock(-2,0,2,Blocks.planks,0);bb.buildBlock(-2,0,3,Blocks.planks,5);
		bb.buildBlock(-1,0,-3,Blocks.fence,0);bb.buildBlock(-1,0,-2,Blocks.planks,5);bb.buildBlock(-1,0,0,Blocks.carpet,14);
		bb.buildBlock(-1,0,1,Blocks.carpet,14);bb.buildBlock(-1,0,2,Blocks.bed,3);bb.buildBlock(-1,0,3,Blocks.planks,5);
		bb.buildBlock(0,0,-2,Blocks.wooden_door,3);bb.buildBlock(0,0,0,Blocks.carpet,14);bb.buildBlock(0,0,1,Blocks.carpet,14);
		bb.buildBlock(0,0,2,Blocks.bed,11);bb.buildBlock(0,0,3,Blocks.planks,5);bb.buildBlock(1,0,-3,Blocks.fence,0);
		bb.buildBlock(1,0,-2,Blocks.planks,5);bb.buildBlock(1,0,0,Blocks.carpet,14);bb.buildBlock(1,0,1,Blocks.carpet,14);
		bb.buildBlock(1,0,2,Blocks.chest,2);bb.buildBlock(1,0,3,Blocks.planks,5);bb.buildBlock(2,0,-3,Blocks.fence,0);bb.buildBlock(2,0,-2,Blocks.planks,5);
		bb.buildBlock(2,0,-1,Blocks.flower_pot,3);bb.addTileEntityPot(2,0,-1,38,3);
		bb.buildBlock(2,0,1,Blocks.ladder,2);bb.buildBlock(2,0,2,Blocks.planks,0);bb.buildBlock(2,0,3,Blocks.planks,5);
		bb.buildBlock(3,0,-3,Blocks.fence,0);bb.buildBlock(3,0,-2,Blocks.log,3);bb.buildBlock(3,0,-1,Blocks.planks,5);
		bb.buildBlock(3,0,0,Blocks.planks,5);bb.buildBlock(3,0,1,Blocks.planks,5);bb.buildBlock(3,0,2,Blocks.planks,5);
		bb.buildBlock(3,0,3,Blocks.log,3);bb.buildBlock(-3,1,-2,Blocks.log,3);bb.buildBlock(-3,1,-1,Blocks.planks,5);
		bb.buildBlock(-3,1,0,Blocks.glass_pane,0);bb.buildBlock(-3,1,1,Blocks.glass_pane,0);bb.buildBlock(-3,1,2,Blocks.planks,5);
		bb.buildBlock(-3,1,3,Blocks.log,3);bb.buildBlock(-2,1,-2,Blocks.planks,5);bb.buildBlock(-2,1,1,Blocks.ladder,2);
		bb.buildBlock(-2,1,2,Blocks.planks,0);bb.buildBlock(-2,1,3,Blocks.planks,5);bb.buildBlock(-1,1,-2,Blocks.planks,5);
		bb.buildBlock(-1,1,3,Blocks.glass_pane,0);bb.buildBlock(0,1,-2,Blocks.wooden_door,8);bb.buildBlock(0,1,3,Blocks.glass_pane,0);
		bb.buildBlock(1,1,-2,Blocks.planks,5);bb.buildBlock(1,1,3,Blocks.glass_pane,0);bb.buildBlock(2,1,-2,Blocks.planks,5);
		bb.buildBlock(2,1,1,Blocks.ladder,2);bb.buildBlock(2,1,2,Blocks.planks,0);bb.buildBlock(2,1,3,Blocks.planks,5);
		bb.buildBlock(3,1,-2,Blocks.log,3);bb.buildBlock(3,1,-1,Blocks.planks,5);bb.buildBlock(3,1,0,Blocks.glass_pane,0);
		bb.buildBlock(3,1,1,Blocks.glass_pane,0);bb.buildBlock(3,1,2,Blocks.planks,5);bb.buildBlock(3,1,3,Blocks.log,3);
		bb.buildBlock(-3,2,-2,Blocks.log,3);bb.buildBlock(-3,2,-1,Blocks.planks,5);bb.buildBlock(-3,2,0,Blocks.glass_pane,0);
		bb.buildBlock(-3,2,1,Blocks.glass_pane,0);bb.buildBlock(-3,2,2,Blocks.planks,5);bb.buildBlock(-3,2,3,Blocks.log,3);
		bb.buildBlock(-2,2,-2,Blocks.planks,5);bb.buildBlock(-2,2,1,Blocks.ladder,2);bb.buildBlock(-2,2,2,Blocks.planks,0);
		bb.buildBlock(-2,2,3,Blocks.planks,5);bb.buildBlock(-1,2,-2,Blocks.planks,5);bb.buildBlock(-1,2,2,Blocks.wooden_slab,8);
		bb.buildBlock(-1,2,3,Blocks.planks,5);bb.buildBlock(0,2,-2,Blocks.planks,5);bb.buildBlock(0,2,2,Blocks.wooden_slab,8);
		bb.buildBlock(0,2,3,Blocks.planks,5);bb.buildBlock(1,2,-2,Blocks.planks,5);bb.buildBlock(1,2,2,Blocks.wooden_slab,8);
		bb.buildBlock(1,2,3,Blocks.planks,5);bb.buildBlock(2,2,-2,Blocks.planks,5);bb.buildBlock(2,2,1,Blocks.ladder,2);
		bb.buildBlock(2,2,2,Blocks.double_wooden_slab,0);bb.buildBlock(2,2,3,Blocks.planks,5);bb.buildBlock(3,2,-2,Blocks.log,3);
		bb.buildBlock(3,2,-1,Blocks.planks,5);bb.buildBlock(3,2,0,Blocks.glass_pane,0);bb.buildBlock(3,2,1,Blocks.glass_pane,0);
		bb.buildBlock(3,2,2,Blocks.planks,5);bb.buildBlock(3,2,3,Blocks.log,3);bb.buildBlock(-3,3,-2,Blocks.log,11);
		bb.buildBlock(-3,3,-1,Blocks.log,11);bb.buildBlock(-3,3,0,Blocks.log,11);bb.buildBlock(-3,3,1,Blocks.log,11);
		bb.buildBlock(-3,3,2,Blocks.log,11);bb.buildBlock(-3,3,3,Blocks.log,3);bb.buildBlock(-2,3,-2,Blocks.log,7);
		bb.buildBlock(-2,3,3,Blocks.log,7);bb.buildBlock(-1,3,-2,Blocks.log,7);bb.buildBlock(-1,3,3,Blocks.log,7);
		bb.buildBlock(0,3,-2,Blocks.log,7);bb.buildBlock(0,3,3,Blocks.log,7);bb.buildBlock(1,3,-2,Blocks.log,7);
		bb.buildBlock(1,3,3,Blocks.log,7);bb.buildBlock(2,3,-2,Blocks.log,7);bb.buildBlock(2,3,3,Blocks.log,7);
		bb.buildBlock(3,3,-2,Blocks.log,11);bb.buildBlock(3,3,-1,Blocks.log,11);bb.buildBlock(3,3,0,Blocks.log,11);
		bb.buildBlock(3,3,1,Blocks.log,11);bb.buildBlock(3,3,2,Blocks.log,11);bb.buildBlock(3,3,3,Blocks.log,3);
		bb.buildBlock(-3,4,-2,Blocks.jungle_stairs,2);bb.buildBlock(-3,4,-1,Blocks.jungle_stairs,0);bb.buildBlock(-3,4,0,Blocks.jungle_stairs,0);
		bb.buildBlock(-3,4,1,Blocks.jungle_stairs,0);bb.buildBlock(-3,4,2,Blocks.jungle_stairs,0);bb.buildBlock(-3,4,3,Blocks.jungle_stairs,0);
		bb.buildBlock(-2,4,-2,Blocks.jungle_stairs,2);bb.buildBlock(-2,4,3,Blocks.jungle_stairs,3);bb.buildBlock(-1,4,-2,Blocks.jungle_stairs,2);
		bb.buildBlock(-1,4,3,Blocks.jungle_stairs,3);bb.buildBlock(0,4,-2,Blocks.jungle_stairs,2);bb.buildBlock(0,4,3,Blocks.jungle_stairs,3);
		bb.buildBlock(1,4,-2,Blocks.jungle_stairs,2);bb.buildBlock(1,4,3,Blocks.jungle_stairs,3);bb.buildBlock(2,4,-2,Blocks.jungle_stairs,2);
		bb.buildBlock(2,4,3,Blocks.jungle_stairs,3);bb.buildBlock(3,4,-2,Blocks.jungle_stairs,1);bb.buildBlock(3,4,-1,Blocks.jungle_stairs,1);
		bb.buildBlock(3,4,0,Blocks.jungle_stairs,1);bb.buildBlock(3,4,1,Blocks.jungle_stairs,1);bb.buildBlock(3,4,2,Blocks.jungle_stairs,1);
		bb.buildBlock(3,4,3,Blocks.jungle_stairs,1);bb.buildBlock(-2,5,-1,Blocks.jungle_stairs,0);bb.buildBlock(-2,5,0,Blocks.jungle_stairs,0);
		bb.buildBlock(-2,5,1,Blocks.jungle_stairs,0);bb.buildBlock(-2,5,2,Blocks.jungle_stairs,3);bb.buildBlock(-1,5,-1,Blocks.jungle_stairs,2);
		bb.buildBlock(-1,5,0,Blocks.wooden_slab,0);bb.buildBlock(-1,5,1,Blocks.wooden_slab,0);bb.buildBlock(-1,5,2,Blocks.jungle_stairs,3);
		bb.buildBlock(0,5,-1,Blocks.jungle_stairs,2);bb.buildBlock(0,5,0,Blocks.wooden_slab,0);bb.buildBlock(0,5,1,Blocks.wooden_slab,0);
		bb.buildBlock(0,5,2,Blocks.jungle_stairs,3);bb.buildBlock(1,5,-1,Blocks.jungle_stairs,2);bb.buildBlock(1,5,0,Blocks.wooden_slab,0);
		bb.buildBlock(1,5,1,Blocks.wooden_slab,0);bb.buildBlock(1,5,2,Blocks.jungle_stairs,3);bb.buildBlock(2,5,-1,Blocks.jungle_stairs,2);
		bb.buildBlock(2,5,0,Blocks.jungle_stairs,1);bb.buildBlock(2,5,1,Blocks.jungle_stairs,1);bb.buildBlock(2,5,2,Blocks.jungle_stairs,1);
		bb.buildBlock(-3,1,-3,Blocks.torch,5);bb.buildBlock(-1,1,-3,Blocks.torch,5);bb.buildBlock(1,1,-3,Blocks.torch,5);
		bb.buildBlock(1,1,2,Blocks.torch,2);bb.buildBlock(3,1,-3,Blocks.torch,5);bb.buildBlock(-2,3,-1,Blocks.torch,3);
		bb.buildBlock(2,3,-1,Blocks.torch,3);bb.buildBlock(-2,4,2,Blocks.torch,4);bb.buildBlock(2,4,2,Blocks.torch,4);
		bb.addEntityItemFrame(0,2,-2,2,ModBlocks.blockHunterHouse);
		bb.addEntityItemFrame(1,4,3,2,Items.arrow);
		bb.addEntityItemFrame(0,4,3,2,Items.leather);
		bb.addEntityItemFrame(-1,4,3,2,Items.bow);

	}

}
