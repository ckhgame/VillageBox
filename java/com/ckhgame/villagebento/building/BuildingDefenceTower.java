package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMarksman;

import net.minecraft.init.Blocks;

public class BuildingDefenceTower extends Building {

	@Override
	public String getName() {
		return "Defense Tower";
	}

	@Override
	public String getDescription() {
		return "See farther...";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerMarksman.class,"Mark",-1,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,0,-3,Blocks.fence,0);bb.buildBlock(-3,0,-2,Blocks.fence,0);bb.buildBlock(-3,0,-1,Blocks.fence,0);
		bb.buildBlock(-3,0,0,Blocks.fence,0);bb.buildBlock(-3,0,1,Blocks.fence,0);bb.buildBlock(-3,0,2,Blocks.fence,0);
		bb.buildBlock(-3,0,3,Blocks.fence,0);bb.buildBlock(-2,0,-3,Blocks.fence,0);bb.buildBlock(-2,0,-2,Blocks.stonebrick,1);
		bb.buildBlock(-2,0,-1,Blocks.stonebrick,1);bb.buildBlock(-2,0,0,Blocks.stonebrick,1);bb.buildBlock(-2,0,1,Blocks.stonebrick,1);
		bb.buildBlock(-2,0,2,Blocks.stonebrick,1);bb.buildBlock(-2,0,3,Blocks.fence,0);bb.buildBlock(-1,0,-3,Blocks.fence,0);
		bb.buildBlock(-1,0,-2,Blocks.stonebrick,1);bb.buildBlock(-1,0,0,Blocks.stone_brick_stairs,2);bb.buildBlock(-1,0,1,Blocks.stonebrick,0);
		bb.buildBlock(-1,0,2,Blocks.stonebrick,1);bb.buildBlock(-1,0,3,Blocks.fence,0);bb.buildBlock(0,0,-3,Blocks.fence,0);
		bb.buildBlock(0,0,-2,Blocks.stonebrick,1);bb.buildBlock(0,0,0,Blocks.stonebrick,0);bb.buildBlock(0,0,1,Blocks.chest,5);
		bb.buildBlock(0,0,2,Blocks.stonebrick,1);bb.buildBlock(0,0,3,Blocks.fence,0);bb.buildBlock(1,0,-3,Blocks.fence,0);
		bb.buildBlock(1,0,-2,Blocks.stonebrick,1);bb.buildBlock(1,0,2,Blocks.stonebrick,1);bb.buildBlock(1,0,3,Blocks.fence,0);
		bb.buildBlock(2,0,-3,Blocks.fence,0);bb.buildBlock(2,0,-2,Blocks.stonebrick,1);bb.buildBlock(2,0,-1,Blocks.stonebrick,1);
		bb.buildBlock(2,0,0,Blocks.wooden_door,0);bb.buildBlock(2,0,1,Blocks.stonebrick,1);bb.buildBlock(2,0,2,Blocks.stonebrick,1);
		bb.buildBlock(2,0,3,Blocks.fence,0);bb.buildBlock(3,0,-3,Blocks.fence,0);bb.buildBlock(3,0,-2,Blocks.fence,0);
		bb.buildBlock(3,0,-1,Blocks.fence,0);bb.buildBlock(3,0,1,Blocks.fence,0);bb.buildBlock(3,0,2,Blocks.fence,0);
		bb.buildBlock(3,0,3,Blocks.fence,0);bb.buildBlock(-2,1,-2,Blocks.stonebrick,1);bb.buildBlock(-2,1,-1,Blocks.stonebrick,1);
		bb.buildBlock(-2,1,0,Blocks.stonebrick,1);bb.buildBlock(-2,1,1,Blocks.stonebrick,1);bb.buildBlock(-2,1,2,Blocks.stonebrick,1);
		bb.buildBlock(-1,1,-2,Blocks.stonebrick,1);bb.buildBlock(-1,1,1,Blocks.stone_brick_stairs,2);bb.buildBlock(-1,1,2,Blocks.stonebrick,1);
		bb.buildBlock(0,1,-2,Blocks.stonebrick,1);bb.buildBlock(0,1,0,Blocks.stonebrick,0);bb.buildBlock(0,1,2,Blocks.stonebrick,1);
		bb.buildBlock(1,1,-2,Blocks.stonebrick,1);bb.buildBlock(1,1,2,Blocks.stonebrick,1);bb.buildBlock(2,1,-2,Blocks.stonebrick,1);
		bb.buildBlock(2,1,-1,Blocks.stonebrick,1);bb.buildBlock(2,1,0,Blocks.wooden_door,8);bb.buildBlock(2,1,1,Blocks.stonebrick,1);
		bb.buildBlock(2,1,2,Blocks.stonebrick,1);bb.buildBlock(-2,2,-2,Blocks.stonebrick,1);bb.buildBlock(-2,2,-1,Blocks.stonebrick,1);
		bb.buildBlock(-2,2,0,Blocks.stonebrick,1);bb.buildBlock(-2,2,1,Blocks.stonebrick,1);bb.buildBlock(-2,2,2,Blocks.stonebrick,1);
		bb.buildBlock(-1,2,-2,Blocks.stonebrick,1);bb.buildBlock(-1,2,2,Blocks.stonebrick,1);bb.buildBlock(0,2,-2,Blocks.stonebrick,1);
		bb.buildBlock(0,2,0,Blocks.stonebrick,0);bb.buildBlock(0,2,1,Blocks.stone_brick_stairs,0);bb.buildBlock(0,2,2,Blocks.stonebrick,1);
		bb.buildBlock(1,2,-2,Blocks.stonebrick,1);bb.buildBlock(1,2,2,Blocks.stonebrick,1);bb.buildBlock(2,2,-2,Blocks.stonebrick,1);
		bb.buildBlock(2,2,-1,Blocks.stonebrick,1);bb.buildBlock(2,2,0,Blocks.stonebrick,1);bb.buildBlock(2,2,1,Blocks.stonebrick,1);
		bb.buildBlock(2,2,2,Blocks.stonebrick,1);bb.buildBlock(-2,3,-2,Blocks.stonebrick,0);bb.buildBlock(-2,3,-1,Blocks.stonebrick,0);
		bb.buildBlock(-2,3,0,Blocks.glass_pane,0);bb.buildBlock(-2,3,1,Blocks.stonebrick,0);bb.buildBlock(-2,3,2,Blocks.stonebrick,0);
		bb.buildBlock(-1,3,-2,Blocks.stonebrick,0);bb.buildBlock(-1,3,2,Blocks.stonebrick,0);bb.buildBlock(0,3,-2,Blocks.glass_pane,0);
		bb.buildBlock(0,3,0,Blocks.stonebrick,0);bb.buildBlock(0,3,2,Blocks.glass_pane,0);bb.buildBlock(1,3,-2,Blocks.stonebrick,0);
		bb.buildBlock(1,3,1,Blocks.stone_brick_stairs,0);bb.buildBlock(1,3,2,Blocks.stonebrick,0);bb.buildBlock(2,3,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,3,-1,Blocks.stonebrick,0);bb.buildBlock(2,3,0,Blocks.glass_pane,0);bb.buildBlock(2,3,1,Blocks.stonebrick,0);
		bb.buildBlock(2,3,2,Blocks.stonebrick,0);bb.buildBlock(-2,4,-2,Blocks.stonebrick,0);bb.buildBlock(-2,4,-1,Blocks.stonebrick,0);
		bb.buildBlock(-2,4,0,Blocks.stonebrick,0);bb.buildBlock(-2,4,1,Blocks.stonebrick,0);bb.buildBlock(-2,4,2,Blocks.stonebrick,0);
		bb.buildBlock(-1,4,-2,Blocks.stonebrick,0);bb.buildBlock(-1,4,2,Blocks.stonebrick,0);bb.buildBlock(0,4,-2,Blocks.stonebrick,0);
		bb.buildBlock(0,4,0,Blocks.stonebrick,0);bb.buildBlock(0,4,2,Blocks.stonebrick,0);bb.buildBlock(1,4,-2,Blocks.stonebrick,0);
		bb.buildBlock(1,4,0,Blocks.stone_brick_stairs,3);bb.buildBlock(1,4,2,Blocks.stonebrick,0);bb.buildBlock(2,4,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,4,-1,Blocks.stonebrick,0);bb.buildBlock(2,4,0,Blocks.stonebrick,0);bb.buildBlock(2,4,1,Blocks.stonebrick,0);
		bb.buildBlock(2,4,2,Blocks.stonebrick,0);bb.buildBlock(-2,5,-2,Blocks.stonebrick,0);bb.buildBlock(-2,5,-1,Blocks.stonebrick,0);
		bb.buildBlock(-2,5,0,Blocks.glass_pane,0);bb.buildBlock(-2,5,1,Blocks.stonebrick,0);bb.buildBlock(-2,5,2,Blocks.stonebrick,0);
		bb.buildBlock(-1,5,-2,Blocks.stonebrick,0);bb.buildBlock(-1,5,2,Blocks.stonebrick,0);bb.buildBlock(0,5,-2,Blocks.glass_pane,0);
		bb.buildBlock(0,5,0,Blocks.stonebrick,0);bb.buildBlock(0,5,2,Blocks.glass_pane,0);bb.buildBlock(1,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(1,5,-1,Blocks.stone_brick_stairs,3);bb.buildBlock(1,5,2,Blocks.stonebrick,0);bb.buildBlock(2,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,5,-1,Blocks.stonebrick,0);bb.buildBlock(2,5,0,Blocks.glass_pane,0);bb.buildBlock(2,5,1,Blocks.stonebrick,0);
		bb.buildBlock(2,5,2,Blocks.stonebrick,0);bb.buildBlock(-2,6,-2,Blocks.stonebrick,0);bb.buildBlock(-2,6,-1,Blocks.stonebrick,0);
		bb.buildBlock(-2,6,0,Blocks.stonebrick,0);bb.buildBlock(-2,6,1,Blocks.stonebrick,0);bb.buildBlock(-2,6,2,Blocks.stonebrick,0);
		bb.buildBlock(-1,6,-2,Blocks.stonebrick,0);bb.buildBlock(-1,6,2,Blocks.stonebrick,0);bb.buildBlock(0,6,-2,Blocks.stonebrick,0);
		bb.buildBlock(0,6,-1,Blocks.stone_brick_stairs,1);bb.buildBlock(0,6,0,Blocks.stonebrick,0);bb.buildBlock(0,6,2,Blocks.stonebrick,0);
		bb.buildBlock(1,6,-2,Blocks.stonebrick,0);bb.buildBlock(1,6,2,Blocks.stonebrick,0);bb.buildBlock(2,6,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,6,-1,Blocks.stonebrick,0);bb.buildBlock(2,6,0,Blocks.stonebrick,0);bb.buildBlock(2,6,1,Blocks.stonebrick,0);
		bb.buildBlock(2,6,2,Blocks.stonebrick,0);bb.buildBlock(-2,7,-2,Blocks.stonebrick,0);bb.buildBlock(-2,7,-1,Blocks.stonebrick,0);
		bb.buildBlock(-2,7,0,Blocks.glass_pane,0);bb.buildBlock(-2,7,1,Blocks.stonebrick,0);bb.buildBlock(-2,7,2,Blocks.stonebrick,0);
		bb.buildBlock(-1,7,-2,Blocks.stonebrick,0);bb.buildBlock(-1,7,-1,Blocks.stone_brick_stairs,1);bb.buildBlock(-1,7,2,Blocks.stonebrick,0);
		bb.buildBlock(0,7,-2,Blocks.glass_pane,0);bb.buildBlock(0,7,0,Blocks.stonebrick,0);bb.buildBlock(0,7,2,Blocks.glass_pane,0);
		bb.buildBlock(1,7,-2,Blocks.stonebrick,0);bb.buildBlock(1,7,2,Blocks.stonebrick,0);bb.buildBlock(2,7,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,7,-1,Blocks.stonebrick,0);bb.buildBlock(2,7,0,Blocks.glass_pane,0);bb.buildBlock(2,7,1,Blocks.stonebrick,0);
		bb.buildBlock(2,7,2,Blocks.stonebrick,0);bb.buildBlock(-3,8,-3,Blocks.stonebrick,0);bb.buildBlock(-3,8,-2,Blocks.fence,0);
		bb.buildBlock(-3,8,-1,Blocks.fence,0);bb.buildBlock(-3,8,0,Blocks.fence,0);bb.buildBlock(-3,8,1,Blocks.fence,0);
		bb.buildBlock(-3,8,2,Blocks.fence,0);bb.buildBlock(-3,8,3,Blocks.stonebrick,0);bb.buildBlock(-2,8,-3,Blocks.fence,0);
		bb.buildBlock(-2,8,-2,Blocks.stonebrick,0);bb.buildBlock(-2,8,-1,Blocks.stonebrick,0);bb.buildBlock(-2,8,0,Blocks.stonebrick,0);
		bb.buildBlock(-2,8,1,Blocks.stonebrick,0);bb.buildBlock(-2,8,2,Blocks.stonebrick,0);bb.buildBlock(-2,8,3,Blocks.fence,0);
		bb.buildBlock(-1,8,-3,Blocks.fence,0);bb.buildBlock(-1,8,-2,Blocks.stonebrick,0);bb.buildBlock(-1,8,0,Blocks.stone_brick_stairs,2);
		bb.buildBlock(-1,8,1,Blocks.stone_slab,13);bb.buildBlock(-1,8,2,Blocks.stonebrick,0);bb.buildBlock(-1,8,3,Blocks.fence,0);
		bb.buildBlock(0,8,-3,Blocks.fence,0);bb.buildBlock(0,8,-2,Blocks.stonebrick,0);bb.buildBlock(0,8,0,Blocks.stonebrick,0);
		bb.buildBlock(0,8,1,Blocks.stone_slab,13);bb.buildBlock(0,8,2,Blocks.stonebrick,0);bb.buildBlock(0,8,3,Blocks.fence,0);
		bb.buildBlock(1,8,-3,Blocks.fence,0);bb.buildBlock(1,8,-2,Blocks.stonebrick,0);bb.buildBlock(1,8,1,Blocks.stone_slab,13);
		bb.buildBlock(1,8,2,Blocks.stonebrick,0);bb.buildBlock(1,8,3,Blocks.fence,0);bb.buildBlock(2,8,-3,Blocks.fence,0);
		bb.buildBlock(2,8,-2,Blocks.stonebrick,0);bb.buildBlock(2,8,-1,Blocks.stonebrick,0);bb.buildBlock(2,8,0,Blocks.stonebrick,0);
		bb.buildBlock(2,8,1,Blocks.stonebrick,0);bb.buildBlock(2,8,2,Blocks.stonebrick,0);bb.buildBlock(2,8,3,Blocks.fence,0);
		bb.buildBlock(3,8,-3,Blocks.stonebrick,0);bb.buildBlock(3,8,-2,Blocks.fence,0);bb.buildBlock(3,8,-1,Blocks.fence,0);
		bb.buildBlock(3,8,0,Blocks.fence,0);bb.buildBlock(3,8,1,Blocks.fence,0);bb.buildBlock(3,8,2,Blocks.fence,0);
		bb.buildBlock(3,8,3,Blocks.stonebrick,0);bb.buildBlock(-3,9,-3,Blocks.stonebrick,0);bb.buildBlock(-3,9,3,Blocks.stonebrick,0);
		bb.buildBlock(0,9,1,Blocks.bed,9);bb.buildBlock(1,9,1,Blocks.bed,1);bb.buildBlock(3,9,-3,Blocks.stonebrick,0);
		bb.buildBlock(3,9,3,Blocks.stonebrick,0);bb.buildBlock(-3,10,-3,Blocks.stonebrick,0);bb.buildBlock(-3,10,3,Blocks.stonebrick,0);
		bb.buildBlock(3,10,-3,Blocks.stonebrick,0);bb.buildBlock(3,10,3,Blocks.stonebrick,0);bb.buildBlock(-3,11,-3,Blocks.stonebrick,0);
		bb.buildBlock(-3,11,-2,Blocks.fence,0);bb.buildBlock(-3,11,-1,Blocks.fence,0);bb.buildBlock(-3,11,0,Blocks.fence,0);
		bb.buildBlock(-3,11,1,Blocks.fence,0);bb.buildBlock(-3,11,2,Blocks.fence,0);bb.buildBlock(-3,11,3,Blocks.stonebrick,0);
		bb.buildBlock(-2,11,-3,Blocks.fence,0);bb.buildBlock(-2,11,3,Blocks.fence,0);bb.buildBlock(-1,11,-3,Blocks.fence,0);
		bb.buildBlock(-1,11,3,Blocks.fence,0);bb.buildBlock(0,11,-3,Blocks.fence,0);bb.buildBlock(0,11,3,Blocks.fence,0);
		bb.buildBlock(1,11,-3,Blocks.fence,0);bb.buildBlock(1,11,3,Blocks.fence,0);bb.buildBlock(2,11,-3,Blocks.fence,0);
		bb.buildBlock(2,11,3,Blocks.fence,0);bb.buildBlock(3,11,-3,Blocks.stonebrick,0);bb.buildBlock(3,11,-2,Blocks.fence,0);
		bb.buildBlock(3,11,-1,Blocks.fence,0);bb.buildBlock(3,11,0,Blocks.fence,0);bb.buildBlock(3,11,1,Blocks.fence,0);
		bb.buildBlock(3,11,2,Blocks.fence,0);bb.buildBlock(3,11,3,Blocks.stonebrick,0);bb.buildBlock(-3,12,-3,Blocks.spruce_stairs,2);
		bb.buildBlock(-3,12,-2,Blocks.spruce_stairs,0);bb.buildBlock(-3,12,-1,Blocks.spruce_stairs,0);bb.buildBlock(-3,12,0,Blocks.spruce_stairs,0);
		bb.buildBlock(-3,12,1,Blocks.spruce_stairs,0);bb.buildBlock(-3,12,2,Blocks.spruce_stairs,0);bb.buildBlock(-3,12,3,Blocks.spruce_stairs,0);
		bb.buildBlock(-2,12,-3,Blocks.spruce_stairs,2);bb.buildBlock(-2,12,3,Blocks.spruce_stairs,3);bb.buildBlock(-1,12,-3,Blocks.spruce_stairs,2);
		bb.buildBlock(-1,12,3,Blocks.spruce_stairs,3);bb.buildBlock(0,12,-3,Blocks.spruce_stairs,2);bb.buildBlock(0,12,3,Blocks.spruce_stairs,3);
		bb.buildBlock(1,12,-3,Blocks.spruce_stairs,2);bb.buildBlock(1,12,3,Blocks.spruce_stairs,3);bb.buildBlock(2,12,-3,Blocks.spruce_stairs,2);
		bb.buildBlock(2,12,3,Blocks.spruce_stairs,3);bb.buildBlock(3,12,-3,Blocks.spruce_stairs,2);bb.buildBlock(3,12,-2,Blocks.spruce_stairs,1);
		bb.buildBlock(3,12,-1,Blocks.spruce_stairs,1);bb.buildBlock(3,12,0,Blocks.spruce_stairs,1);bb.buildBlock(3,12,1,Blocks.spruce_stairs,1);
		bb.buildBlock(3,12,2,Blocks.spruce_stairs,1);bb.buildBlock(3,12,3,Blocks.spruce_stairs,3);bb.buildBlock(-2,13,-2,Blocks.spruce_stairs,0);
		bb.buildBlock(-2,13,-1,Blocks.spruce_stairs,0);bb.buildBlock(-2,13,0,Blocks.spruce_stairs,0);bb.buildBlock(-2,13,1,Blocks.spruce_stairs,0);
		bb.buildBlock(-2,13,2,Blocks.spruce_stairs,3);bb.buildBlock(-1,13,-2,Blocks.spruce_stairs,2);bb.buildBlock(-1,13,-1,Blocks.wooden_slab,9);
		bb.buildBlock(-1,13,0,Blocks.wooden_slab,9);bb.buildBlock(-1,13,1,Blocks.wooden_slab,9);bb.buildBlock(-1,13,2,Blocks.spruce_stairs,3);
		bb.buildBlock(0,13,-2,Blocks.spruce_stairs,2);bb.buildBlock(0,13,-1,Blocks.wooden_slab,9);bb.buildBlock(0,13,0,Blocks.wooden_slab,9);
		bb.buildBlock(0,13,1,Blocks.wooden_slab,9);bb.buildBlock(0,13,2,Blocks.spruce_stairs,3);bb.buildBlock(1,13,-2,Blocks.spruce_stairs,2);
		bb.buildBlock(1,13,-1,Blocks.wooden_slab,9);bb.buildBlock(1,13,0,Blocks.wooden_slab,9);bb.buildBlock(1,13,1,Blocks.wooden_slab,9);
		bb.buildBlock(1,13,2,Blocks.spruce_stairs,3);bb.buildBlock(2,13,-2,Blocks.spruce_stairs,2);bb.buildBlock(2,13,-1,Blocks.spruce_stairs,1);
		bb.buildBlock(2,13,0,Blocks.spruce_stairs,1);bb.buildBlock(2,13,1,Blocks.spruce_stairs,1);bb.buildBlock(2,13,2,Blocks.spruce_stairs,1);
		bb.buildBlock(-3,1,-3,Blocks.torch,5);bb.buildBlock(-3,1,3,Blocks.torch,5);bb.buildBlock(1,1,-1,Blocks.torch,2);
		bb.buildBlock(1,1,1,Blocks.torch,2);bb.buildBlock(3,1,-3,Blocks.torch,5);bb.buildBlock(3,1,-1,Blocks.torch,1);
		bb.buildBlock(3,1,1,Blocks.torch,1);bb.buildBlock(3,1,3,Blocks.torch,5);bb.buildBlock(-1,5,-1,Blocks.torch,3);
		bb.buildBlock(-1,5,1,Blocks.torch,4);bb.buildBlock(-3,10,-2,Blocks.torch,3);bb.buildBlock(-3,10,2,Blocks.torch,4);
		bb.buildBlock(-2,10,-3,Blocks.torch,1);bb.buildBlock(-2,10,3,Blocks.torch,1);bb.buildBlock(2,10,-3,Blocks.torch,2);
		bb.buildBlock(2,10,3,Blocks.torch,2);bb.buildBlock(3,10,-2,Blocks.torch,3);bb.buildBlock(3,10,2,Blocks.torch,4);
		bb.buildBlock(-2,12,-2,Blocks.torch,1);bb.buildBlock(-2,12,2,Blocks.torch,1);bb.buildBlock(0,12,-2,Blocks.torch,3);
		bb.buildBlock(0,12,2,Blocks.torch,4);bb.buildBlock(2,12,-2,Blocks.torch,2);bb.buildBlock(2,12,2,Blocks.torch,2);


	}

}
