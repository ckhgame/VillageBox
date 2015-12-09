package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionSoldier;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class BuildingSmallMilitaryCamp extends Building {

	@Override
	public String getName() {
		return "Small Military Camp";
	}

	@Override
	public String getDescription() {
		return "A place for Armies.";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionSoldier.class,1,-2);
		bb.addVillager(ProfessionSoldier.class,1,2);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-2,-4,-1,Blocks.stone_brick_stairs,3);bb.buildBlock(-2,-4,0,Blocks.air,0);bb.buildBlock(-2,-4,1,Blocks.stone_brick_stairs,2);
		bb.buildBlock(-1,-4,-1,Blocks.air,0);bb.buildBlock(-1,-4,0,Blocks.air,0);bb.buildBlock(-1,-4,1,Blocks.air,0);
		bb.buildBlock(0,-4,-1,Blocks.wooden_door,0);bb.buildBlock(0,-4,1,Blocks.wooden_door,0);bb.buildBlock(1,-4,-2,Blocks.bed,3);
		bb.buildBlock(1,-4,-1,Blocks.air,0);bb.buildBlock(1,-4,1,Blocks.air,0);bb.buildBlock(1,-4,2,Blocks.bed,3);
		bb.buildBlock(2,-4,-2,Blocks.bed,11);bb.buildBlock(2,-4,-1,Blocks.bookshelf,0);bb.buildBlock(2,-4,1,Blocks.bookshelf,0);
		bb.buildBlock(2,-4,2,Blocks.bed,11);bb.buildBlock(-2,-3,-2,Blocks.stone_brick_stairs,3);bb.buildBlock(-2,-3,-1,Blocks.air,0);
		bb.buildBlock(-2,-3,0,Blocks.air,0);bb.buildBlock(-2,-3,1,Blocks.air,0);bb.buildBlock(-2,-3,2,Blocks.stone_brick_stairs,2);
		bb.buildBlock(-1,-3,-1,Blocks.air,0);bb.buildBlock(-1,-3,0,Blocks.air,0);bb.buildBlock(-1,-3,1,Blocks.air,0);
		bb.buildBlock(0,-3,-2,Blocks.chest,3);bb.buildBlock(0,-3,-1,Blocks.wooden_door,9);bb.buildBlock(0,-3,1,Blocks.wooden_door,8);bb.buildBlock(0,-3,2,Blocks.chest,2);
		bb.buildBlock(1,-3,-2,Blocks.air,0);bb.buildBlock(1,-3,-1,Blocks.air,0);bb.buildBlock(1,-3,1,Blocks.air,0);
		bb.buildBlock(1,-3,2,Blocks.air,0);bb.buildBlock(2,-3,-2,Blocks.air,0);bb.buildBlock(2,-3,-1,Blocks.flower_pot,8);
		bb.addTileEntityPot(2,-3,-1,38,8);
		bb.buildBlock(2,-3,1,Blocks.flower_pot,8);bb.addTileEntityPot(2,-3,1,38,8);
		bb.buildBlock(2,-3,2,Blocks.air,0);bb.buildBlock(-2,-2,-2,Blocks.air,0);bb.buildBlock(-2,-2,-1,Blocks.air,0);
		bb.buildBlock(-2,-2,0,Blocks.air,0);bb.buildBlock(-2,-2,1,Blocks.air,0);bb.buildBlock(-2,-2,2,Blocks.air,0);
		bb.buildBlock(-1,-2,-2,Blocks.stone_brick_stairs,0);bb.buildBlock(-1,-2,-1,Blocks.air,0);bb.buildBlock(-1,-2,1,Blocks.air,0);
		bb.buildBlock(-1,-2,2,Blocks.stone_brick_stairs,0);bb.buildBlock(1,-2,-2,Blocks.air,0);bb.buildBlock(1,-2,-1,Blocks.air,0);
		bb.buildBlock(1,-2,1,Blocks.air,0);bb.buildBlock(1,-2,2,Blocks.air,0);bb.buildBlock(2,-2,-1,Blocks.air,0);
		bb.buildBlock(2,-2,1,Blocks.air,0);bb.buildBlock(-2,-1,-2,Blocks.air,0);bb.buildBlock(-2,-1,-1,Blocks.air,0);
		bb.buildBlock(-2,-1,1,Blocks.air,0);bb.buildBlock(-2,-1,2,Blocks.air,0);bb.buildBlock(-1,-1,-2,Blocks.air,0);
		bb.buildBlock(-1,-1,-1,Blocks.oak_stairs,4);bb.buildBlock(-1,-1,1,Blocks.oak_stairs,4);bb.buildBlock(-1,-1,2,Blocks.air,0);
		bb.buildBlock(0,-1,-2,Blocks.stone_brick_stairs,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);bb.buildBlock(0,-1,0,Blocks.planks,0);
		bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.stone_brick_stairs,0);bb.buildBlock(1,-1,-2,Blocks.planks,0);
		bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);bb.buildBlock(1,-1,1,Blocks.planks,0);
		bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(2,-1,-2,Blocks.planks,0);bb.buildBlock(2,-1,-1,Blocks.planks,0);
		bb.buildBlock(2,-1,0,Blocks.planks,0);bb.buildBlock(2,-1,1,Blocks.planks,0);bb.buildBlock(2,-1,2,Blocks.planks,0);
		bb.buildBlock(-3,0,-3,Blocks.stonebrick,0);bb.buildBlock(-3,0,-2,Blocks.stonebrick,0);bb.buildBlock(-3,0,-1,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,0,Blocks.stonebrick,0);bb.buildBlock(-3,0,1,Blocks.stonebrick,0);bb.buildBlock(-3,0,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,3,Blocks.stonebrick,0);bb.buildBlock(-2,0,-3,Blocks.stonebrick,0);bb.buildBlock(-2,0,-1,Blocks.planks,0);
		bb.buildBlock(-2,0,0,Blocks.planks,0);bb.buildBlock(-2,0,1,Blocks.planks,0);bb.buildBlock(-2,0,3,Blocks.stonebrick,0);
		bb.buildBlock(-1,0,-3,Blocks.stonebrick,0);bb.buildBlock(-1,0,-1,Blocks.oak_stairs,1);bb.buildBlock(-1,0,0,Blocks.oak_stairs,1);
		bb.buildBlock(-1,0,1,Blocks.oak_stairs,1);bb.buildBlock(-1,0,3,Blocks.stonebrick,0);bb.buildBlock(0,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(0,0,3,Blocks.stonebrick,0);bb.buildBlock(1,0,-3,Blocks.stonebrick,0);bb.buildBlock(1,0,3,Blocks.stonebrick,0);
		bb.buildBlock(2,0,-3,Blocks.stonebrick,0);bb.buildBlock(2,0,-2,Blocks.wooden_door,0);bb.buildBlock(2,0,-1,Blocks.stonebrick,0);
		bb.buildBlock(2,0,0,Blocks.stonebrick,0);bb.buildBlock(2,0,1,Blocks.stonebrick,0);bb.buildBlock(2,0,2,Blocks.wooden_door,0);
		bb.buildBlock(2,0,3,Blocks.stonebrick,0);bb.buildBlock(3,0,-3,Blocks.stonebrick,0);bb.buildBlock(3,0,3,Blocks.stonebrick,0);
		bb.buildBlock(-3,1,-3,Blocks.stonebrick,0);bb.buildBlock(-3,1,-2,Blocks.stonebrick,0);bb.buildBlock(-3,1,-1,Blocks.stonebrick,0);
		bb.buildBlock(-3,1,0,Blocks.stonebrick,0);bb.buildBlock(-3,1,1,Blocks.stonebrick,0);bb.buildBlock(-3,1,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,1,3,Blocks.stonebrick,0);bb.buildBlock(-2,1,-3,Blocks.stonebrick,0);bb.buildBlock(-2,1,3,Blocks.stonebrick,0);
		bb.buildBlock(-1,1,-3,Blocks.stonebrick,0);bb.buildBlock(-1,1,3,Blocks.stonebrick,0);bb.buildBlock(0,1,-3,Blocks.stonebrick,0);
		bb.buildBlock(0,1,3,Blocks.stonebrick,0);bb.buildBlock(1,1,-3,Blocks.stonebrick,0);bb.buildBlock(1,1,3,Blocks.stonebrick,0);
		bb.buildBlock(2,1,-3,Blocks.stonebrick,0);bb.buildBlock(2,1,-2,Blocks.wooden_door,8);bb.buildBlock(2,1,-1,Blocks.stonebrick,0);
		bb.buildBlock(2,1,0,Blocks.stonebrick,0);bb.buildBlock(2,1,1,Blocks.stonebrick,0);bb.buildBlock(2,1,2,Blocks.wooden_door,8);
		bb.buildBlock(2,1,3,Blocks.stonebrick,0);bb.buildBlock(3,1,-3,Blocks.stonebrick,0);bb.buildBlock(3,1,3,Blocks.stonebrick,0);
		bb.buildBlock(-3,2,-3,Blocks.stonebrick,0);bb.buildBlock(-3,2,-2,Blocks.stonebrick,0);bb.buildBlock(-3,2,-1,Blocks.stonebrick,0);
		bb.buildBlock(-3,2,0,Blocks.stonebrick,0);bb.buildBlock(-3,2,1,Blocks.stonebrick,0);bb.buildBlock(-3,2,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,2,3,Blocks.stonebrick,0);bb.buildBlock(-2,2,-3,Blocks.stonebrick,0);bb.buildBlock(-2,2,-2,Blocks.stonebrick,0);
		bb.buildBlock(-2,2,2,Blocks.stonebrick,0);bb.buildBlock(-2,2,3,Blocks.stonebrick,0);bb.buildBlock(-1,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(-1,2,3,Blocks.glass_pane,0);bb.buildBlock(0,2,-3,Blocks.glass_pane,0);bb.buildBlock(0,2,3,Blocks.glass_pane,0);
		bb.buildBlock(1,2,-3,Blocks.glass_pane,0);bb.buildBlock(1,2,3,Blocks.glass_pane,0);bb.buildBlock(2,2,-3,Blocks.stonebrick,0);
		bb.buildBlock(2,2,-2,Blocks.stonebrick,0);bb.buildBlock(2,2,-1,Blocks.stonebrick,0);bb.buildBlock(2,2,0,Blocks.stonebrick,0);
		bb.buildBlock(2,2,1,Blocks.stonebrick,0);bb.buildBlock(2,2,2,Blocks.stonebrick,0);bb.buildBlock(2,2,3,Blocks.stonebrick,0);
		bb.buildBlock(3,2,-3,Blocks.stonebrick,0);bb.buildBlock(3,2,-2,Blocks.stone_brick_stairs,5);bb.buildBlock(3,2,-1,Blocks.stone_brick_stairs,5);
		bb.buildBlock(3,2,0,Blocks.stone_brick_stairs,5);bb.buildBlock(3,2,1,Blocks.stone_brick_stairs,5);bb.buildBlock(3,2,2,Blocks.stone_brick_stairs,5);
		bb.buildBlock(3,2,3,Blocks.stonebrick,0);bb.buildBlock(-3,3,-3,Blocks.stonebrick,0);bb.buildBlock(-3,3,-2,Blocks.stonebrick,0);
		bb.buildBlock(-3,3,-1,Blocks.stonebrick,0);bb.buildBlock(-3,3,0,Blocks.stonebrick,0);bb.buildBlock(-3,3,1,Blocks.stonebrick,0);
		bb.buildBlock(-3,3,2,Blocks.stonebrick,0);bb.buildBlock(-3,3,3,Blocks.stonebrick,0);bb.buildBlock(-2,3,-3,Blocks.stonebrick,0);
		bb.buildBlock(-2,3,-2,Blocks.stonebrick,0);bb.buildBlock(-2,3,0,Blocks.stonebrick,0);bb.buildBlock(-2,3,2,Blocks.stonebrick,0);
		bb.buildBlock(-2,3,3,Blocks.stonebrick,0);bb.buildBlock(-1,3,-3,Blocks.stonebrick,0);bb.buildBlock(-1,3,3,Blocks.stonebrick,0);
		bb.buildBlock(0,3,-3,Blocks.stonebrick,0);bb.buildBlock(0,3,3,Blocks.stonebrick,0);bb.buildBlock(1,3,-3,Blocks.stonebrick,0);
		bb.buildBlock(1,3,3,Blocks.stonebrick,0);bb.buildBlock(2,3,-3,Blocks.stonebrick,0);bb.buildBlock(2,3,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,3,2,Blocks.stonebrick,0);bb.buildBlock(2,3,3,Blocks.stonebrick,0);bb.buildBlock(3,3,-3,Blocks.stonebrick,0);
		bb.buildBlock(3,3,-2,Blocks.fence,0);bb.buildBlock(3,3,-1,Blocks.glass,0);bb.buildBlock(3,3,0,Blocks.glass,0);
		bb.buildBlock(3,3,1,Blocks.glass,0);bb.buildBlock(3,3,2,Blocks.fence,0);bb.buildBlock(3,3,3,Blocks.stonebrick,0);
		bb.buildBlock(-3,4,-3,Blocks.stonebrick,0);bb.buildBlock(-3,4,-2,Blocks.stonebrick,0);bb.buildBlock(-3,4,-1,Blocks.stonebrick,0);
		bb.buildBlock(-3,4,0,Blocks.stonebrick,0);bb.buildBlock(-3,4,1,Blocks.stonebrick,0);bb.buildBlock(-3,4,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,4,3,Blocks.stonebrick,0);bb.buildBlock(-2,4,-3,Blocks.stonebrick,0);bb.buildBlock(-2,4,-2,Blocks.stonebrick,0);
		bb.buildBlock(-2,4,-1,Blocks.stonebrick,0);bb.buildBlock(-2,4,1,Blocks.stonebrick,0);bb.buildBlock(-2,4,2,Blocks.stonebrick,0);
		bb.buildBlock(-2,4,3,Blocks.stonebrick,0);bb.buildBlock(-1,4,-3,Blocks.stonebrick,0);bb.buildBlock(-1,4,3,Blocks.stonebrick,0);
		bb.buildBlock(0,4,-3,Blocks.stonebrick,0);bb.buildBlock(0,4,3,Blocks.stonebrick,0);bb.buildBlock(1,4,-3,Blocks.stonebrick,0);
		bb.buildBlock(1,4,3,Blocks.stonebrick,0);bb.buildBlock(2,4,-3,Blocks.stonebrick,0);bb.buildBlock(2,4,3,Blocks.stonebrick,0);
		bb.buildBlock(3,4,-3,Blocks.stonebrick,0);bb.buildBlock(3,4,-2,Blocks.stonebrick,0);bb.buildBlock(3,4,-1,Blocks.stonebrick,0);
		bb.buildBlock(3,4,0,Blocks.stonebrick,0);bb.buildBlock(3,4,1,Blocks.stonebrick,0);bb.buildBlock(3,4,2,Blocks.stonebrick,0);
		bb.buildBlock(3,4,3,Blocks.stonebrick,0);bb.buildBlock(-3,5,-3,Blocks.stone_brick_stairs,2);bb.buildBlock(-3,5,-2,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-3,5,-1,Blocks.stone_brick_stairs,0);bb.buildBlock(-3,5,0,Blocks.stone_brick_stairs,0);bb.buildBlock(-3,5,1,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-3,5,2,Blocks.stone_brick_stairs,0);bb.buildBlock(-3,5,3,Blocks.stone_brick_stairs,3);bb.buildBlock(-2,5,-3,Blocks.stone_brick_stairs,2);
		bb.buildBlock(-2,5,-2,Blocks.stone_slab,5);bb.buildBlock(-2,5,-1,Blocks.stone_slab,5);bb.buildBlock(-2,5,0,Blocks.stone_slab,5);
		bb.buildBlock(-2,5,1,Blocks.stone_slab,5);bb.buildBlock(-2,5,2,Blocks.stone_slab,5);bb.buildBlock(-2,5,3,Blocks.stone_brick_stairs,3);
		bb.buildBlock(-1,5,-3,Blocks.stone_brick_stairs,2);bb.buildBlock(-1,5,-2,Blocks.stone_slab,5);bb.buildBlock(-1,5,-1,Blocks.planks,0);
		bb.buildBlock(-1,5,0,Blocks.planks,0);bb.buildBlock(-1,5,1,Blocks.planks,0);bb.buildBlock(-1,5,2,Blocks.stone_slab,5);
		bb.buildBlock(-1,5,3,Blocks.stone_brick_stairs,3);bb.buildBlock(0,5,-3,Blocks.stone_brick_stairs,2);bb.buildBlock(0,5,-2,Blocks.stone_slab,5);
		bb.buildBlock(0,5,-1,Blocks.planks,0);bb.buildBlock(0,5,0,Blocks.planks,0);bb.buildBlock(0,5,1,Blocks.planks,0);
		bb.buildBlock(0,5,2,Blocks.stone_slab,5);bb.buildBlock(0,5,3,Blocks.stone_brick_stairs,3);bb.buildBlock(1,5,-3,Blocks.stone_brick_stairs,2);
		bb.buildBlock(1,5,-2,Blocks.stone_slab,5);bb.buildBlock(1,5,-1,Blocks.planks,0);bb.buildBlock(1,5,0,Blocks.planks,0);
		bb.buildBlock(1,5,1,Blocks.planks,0);bb.buildBlock(1,5,2,Blocks.stone_slab,5);bb.buildBlock(1,5,3,Blocks.stone_brick_stairs,3);
		bb.buildBlock(2,5,-3,Blocks.stone_brick_stairs,2);bb.buildBlock(2,5,-2,Blocks.stone_slab,5);bb.buildBlock(2,5,-1,Blocks.stone_slab,5);
		bb.buildBlock(2,5,0,Blocks.stone_slab,5);bb.buildBlock(2,5,1,Blocks.stone_slab,5);bb.buildBlock(2,5,2,Blocks.stone_slab,5);
		bb.buildBlock(2,5,3,Blocks.stone_brick_stairs,3);bb.buildBlock(3,5,-3,Blocks.stone_brick_stairs,1);bb.buildBlock(3,5,-2,Blocks.stone_brick_stairs,1);
		bb.buildBlock(3,5,-1,Blocks.stone_brick_stairs,1);bb.buildBlock(3,5,0,Blocks.stone_brick_stairs,1);bb.buildBlock(3,5,1,Blocks.stone_brick_stairs,1);
		bb.buildBlock(3,5,2,Blocks.stone_brick_stairs,1);bb.buildBlock(3,5,3,Blocks.stone_brick_stairs,3);bb.buildBlock(-1,-2,0,Blocks.torch,2);
		bb.buildBlock(2,-2,-2,Blocks.torch,3);bb.buildBlock(2,-2,2,Blocks.torch,4);bb.buildBlock(1,1,0,Blocks.torch,2);
		bb.buildBlock(0,4,-2,Blocks.torch,3);bb.buildBlock(0,4,2,Blocks.torch,4);bb.buildBlock(2,4,-2,Blocks.torch,2);
		bb.buildBlock(2,4,0,Blocks.torch,2);bb.buildBlock(2,4,2,Blocks.torch,2);bb.addEntityItemFrame(-3,2,1,3,Items.iron_chestplate);
		bb.addEntityItemFrame(-3,2,0,3,Items.iron_sword);
		bb.addEntityItemFrame(-3,2,-1,3,Items.iron_helmet);
	}

}
