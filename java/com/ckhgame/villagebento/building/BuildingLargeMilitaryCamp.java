package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerCaptainSoldier;
import com.ckhgame.villagebento.villager.VillagerKnight;

import net.minecraft.init.Blocks;

public class BuildingLargeMilitaryCamp extends Building {

	@Override
	public String getName() {
		return "Large Military Camp";
	}

	@Override
	public String getDescription() {
		return "A place for Knights.";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerKnight.class,"Andrew",-3,0);
		bb.addBuildingVillager(VillagerKnight.class,"Carn",-3,1);
		bb.addBuildingVillager(VillagerKnight.class,"Mike",-3,-1);
		bb.addBuildingVillager(VillagerCaptainSoldier.class,"Edward",-4,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Large;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-4,-2,4,Blocks.stonebrick,2);bb.buildBlock(-4,-1,-2,Blocks.stonebrick,2);bb.buildBlock(-5,0,-5,Blocks.stonebrick,0);
		bb.buildBlock(-5,0,-4,Blocks.stonebrick,0);bb.buildBlock(-5,0,-3,Blocks.stonebrick,0);bb.buildBlock(-5,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(-5,0,-1,Blocks.stonebrick,0);bb.buildBlock(-5,0,0,Blocks.stonebrick,0);bb.buildBlock(-5,0,1,Blocks.stonebrick,0);
		bb.buildBlock(-5,0,2,Blocks.stonebrick,0);bb.buildBlock(-5,0,3,Blocks.stonebrick,0);bb.buildBlock(-5,0,4,Blocks.stonebrick,0);
		bb.buildBlock(-5,0,5,Blocks.stonebrick,0);bb.buildBlock(-4,0,-5,Blocks.stonebrick,0);bb.buildBlock(-4,0,-4,Blocks.dark_oak_stairs,1);
		bb.buildBlock(-4,0,-3,Blocks.dark_oak_stairs,1);bb.buildBlock(-4,0,-2,Blocks.flower_pot,6);bb.addTileEntityPot(-4,0,-2,38,6);
		bb.buildBlock(-4,0,-1,Blocks.dark_oak_stairs,1);bb.buildBlock(-4,0,0,Blocks.dark_oak_stairs,1);bb.buildBlock(-4,0,1,Blocks.dark_oak_stairs,1);
		bb.buildBlock(-4,0,2,Blocks.flower_pot,6);bb.addTileEntityPot(-4,0,2,38,6);
		bb.buildBlock(-4,0,3,Blocks.dark_oak_stairs,1);bb.buildBlock(-4,0,4,Blocks.dark_oak_stairs,1);bb.buildBlock(-4,0,5,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,-5,Blocks.stonebrick,0);bb.buildBlock(-3,0,5,Blocks.stonebrick,0);bb.buildBlock(-2,0,-5,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,5,Blocks.stonebrick,0);bb.buildBlock(-1,0,-5,Blocks.stonebrick,0);bb.buildBlock(-1,0,0,Blocks.trapped_chest,4);
		bb.buildBlock(-1,0,1,Blocks.trapped_chest,4);bb.buildBlock(-1,0,5,Blocks.stonebrick,0);bb.buildBlock(0,0,-5,Blocks.stonebrick,0);bb.buildBlock(0,0,0,Blocks.stonebrick,0);
		bb.buildBlock(0,0,1,Blocks.stonebrick,0);bb.buildBlock(0,0,5,Blocks.stonebrick,0);bb.buildBlock(1,0,-5,Blocks.stonebrick,0);
		bb.buildBlock(1,0,0,Blocks.stone_brick_stairs,1);bb.buildBlock(1,0,1,Blocks.stone_brick_stairs,1);bb.buildBlock(1,0,5,Blocks.stonebrick,0);
		bb.buildBlock(2,0,-5,Blocks.stonebrick,0);bb.buildBlock(2,0,5,Blocks.stonebrick,0);bb.buildBlock(3,0,-5,Blocks.stonebrick,0);
		bb.buildBlock(3,0,-4,Blocks.dark_oak_stairs,1);bb.buildBlock(3,0,-3,Blocks.dark_oak_stairs,1);bb.buildBlock(3,0,-2,Blocks.dark_oak_stairs,1);
		bb.buildBlock(3,0,3,Blocks.dark_oak_stairs,1);bb.buildBlock(3,0,4,Blocks.dark_oak_stairs,1);bb.buildBlock(3,0,5,Blocks.stonebrick,0);
		bb.buildBlock(4,0,-5,Blocks.stonebrick,0);bb.buildBlock(4,0,5,Blocks.stonebrick,0);bb.buildBlock(5,0,-5,Blocks.stonebrick,0);
		bb.buildBlock(5,0,-4,Blocks.stonebrick,0);bb.buildBlock(5,0,-3,Blocks.stonebrick,0);bb.buildBlock(5,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(5,0,-1,Blocks.stonebrick,0);bb.buildBlock(5,0,0,Blocks.wooden_door,0);bb.buildBlock(5,0,1,Blocks.wooden_door,0);
		bb.buildBlock(5,0,2,Blocks.stonebrick,0);bb.buildBlock(5,0,3,Blocks.stonebrick,0);bb.buildBlock(5,0,4,Blocks.stonebrick,0);
		bb.buildBlock(5,0,5,Blocks.stonebrick,0);bb.buildBlock(-5,1,-5,Blocks.stonebrick,0);bb.buildBlock(-5,1,-4,Blocks.stonebrick,0);
		bb.buildBlock(-5,1,-3,Blocks.stonebrick,0);bb.buildBlock(-5,1,-2,Blocks.stonebrick,0);bb.buildBlock(-5,1,-1,Blocks.stonebrick,0);
		bb.buildBlock(-5,1,0,Blocks.stonebrick,0);bb.buildBlock(-5,1,1,Blocks.stonebrick,0);bb.buildBlock(-5,1,2,Blocks.stonebrick,0);
		bb.buildBlock(-5,1,3,Blocks.stonebrick,0);bb.buildBlock(-5,1,4,Blocks.stonebrick,0);bb.buildBlock(-5,1,5,Blocks.stonebrick,0);
		bb.buildBlock(-4,1,-5,Blocks.stonebrick,0);bb.buildBlock(-4,1,5,Blocks.stonebrick,0);bb.buildBlock(-3,1,-5,Blocks.stonebrick,0);
		bb.buildBlock(-3,1,5,Blocks.stonebrick,0);bb.buildBlock(-2,1,-5,Blocks.stonebrick,0);bb.buildBlock(-2,1,5,Blocks.stonebrick,0);
		bb.buildBlock(-1,1,-5,Blocks.stonebrick,0);bb.buildBlock(-1,1,5,Blocks.stonebrick,0);bb.buildBlock(0,1,-5,Blocks.stonebrick,0);
		bb.buildBlock(0,1,0,Blocks.stone_brick_stairs,1);bb.buildBlock(0,1,1,Blocks.stone_brick_stairs,1);bb.buildBlock(0,1,5,Blocks.stonebrick,0);
		bb.buildBlock(1,1,-5,Blocks.stonebrick,0);bb.buildBlock(1,1,5,Blocks.stonebrick,0);bb.buildBlock(2,1,-5,Blocks.stonebrick,0);
		bb.buildBlock(2,1,-4,Blocks.dark_oak_stairs,1);bb.buildBlock(2,1,-3,Blocks.dark_oak_stairs,1);bb.buildBlock(2,1,-2,Blocks.dark_oak_stairs,1);
		bb.buildBlock(2,1,3,Blocks.dark_oak_stairs,1);bb.buildBlock(2,1,4,Blocks.dark_oak_stairs,1);bb.buildBlock(2,1,5,Blocks.stonebrick,0);
		bb.buildBlock(3,1,-5,Blocks.stonebrick,0);bb.buildBlock(3,1,5,Blocks.stonebrick,0);bb.buildBlock(4,1,-5,Blocks.stonebrick,0);
		bb.buildBlock(4,1,5,Blocks.stonebrick,0);bb.buildBlock(5,1,-5,Blocks.stonebrick,0);bb.buildBlock(5,1,-4,Blocks.stonebrick,0);
		bb.buildBlock(5,1,-3,Blocks.stonebrick,0);bb.buildBlock(5,1,-2,Blocks.stonebrick,0);bb.buildBlock(5,1,-1,Blocks.stonebrick,0);
		bb.buildBlock(5,1,0,Blocks.wooden_door,8);bb.buildBlock(5,1,1,Blocks.wooden_door,9);bb.buildBlock(5,1,2,Blocks.stonebrick,0);
		bb.buildBlock(5,1,3,Blocks.stonebrick,0);bb.buildBlock(5,1,4,Blocks.stonebrick,0);bb.buildBlock(5,1,5,Blocks.stonebrick,0);
		bb.buildBlock(-5,2,-5,Blocks.stonebrick,0);bb.buildBlock(-5,2,-4,Blocks.stonebrick,0);bb.buildBlock(-5,2,-3,Blocks.stonebrick,0);
		bb.buildBlock(-5,2,-2,Blocks.stonebrick,0);bb.buildBlock(-5,2,-1,Blocks.stonebrick,0);bb.buildBlock(-5,2,0,Blocks.stonebrick,0);
		bb.buildBlock(-5,2,1,Blocks.stonebrick,0);bb.buildBlock(-5,2,2,Blocks.stonebrick,0);bb.buildBlock(-5,2,3,Blocks.stonebrick,0);
		bb.buildBlock(-5,2,4,Blocks.stonebrick,0);bb.buildBlock(-5,2,5,Blocks.stonebrick,0);bb.buildBlock(-4,2,-5,Blocks.stonebrick,0);
		bb.buildBlock(-4,2,-4,Blocks.wooden_slab,13);bb.buildBlock(-4,2,-3,Blocks.wooden_slab,13);bb.buildBlock(-4,2,-2,Blocks.wooden_slab,13);
		bb.buildBlock(-4,2,-1,Blocks.wooden_slab,13);bb.buildBlock(-4,2,0,Blocks.wooden_slab,13);bb.buildBlock(-4,2,1,Blocks.wooden_slab,13);
		bb.buildBlock(-4,2,2,Blocks.wooden_slab,13);bb.buildBlock(-4,2,3,Blocks.wooden_slab,13);bb.buildBlock(-4,2,4,Blocks.wooden_slab,13);
		bb.buildBlock(-4,2,5,Blocks.stonebrick,0);bb.buildBlock(-3,2,-5,Blocks.stonebrick,0);bb.buildBlock(-3,2,-4,Blocks.wooden_slab,13);
		bb.buildBlock(-3,2,-3,Blocks.wooden_slab,13);bb.buildBlock(-3,2,-2,Blocks.wooden_slab,13);bb.buildBlock(-3,2,3,Blocks.wooden_slab,13);
		bb.buildBlock(-3,2,4,Blocks.wooden_slab,13);bb.buildBlock(-3,2,5,Blocks.stonebrick,0);bb.buildBlock(-2,2,-5,Blocks.stonebrick,0);
		bb.buildBlock(-2,2,-4,Blocks.wooden_slab,13);bb.buildBlock(-2,2,-3,Blocks.wooden_slab,13);bb.buildBlock(-2,2,-2,Blocks.wooden_slab,13);
		bb.buildBlock(-2,2,3,Blocks.wooden_slab,13);bb.buildBlock(-2,2,4,Blocks.wooden_slab,13);bb.buildBlock(-2,2,5,Blocks.stonebrick,0);
		bb.buildBlock(-1,2,-5,Blocks.stonebrick,0);bb.buildBlock(-1,2,-4,Blocks.wooden_slab,13);bb.buildBlock(-1,2,-3,Blocks.wooden_slab,13);
		bb.buildBlock(-1,2,-2,Blocks.wooden_slab,13);bb.buildBlock(-1,2,0,Blocks.stone_brick_stairs,1);bb.buildBlock(-1,2,1,Blocks.stone_brick_stairs,1);
		bb.buildBlock(-1,2,3,Blocks.wooden_slab,13);bb.buildBlock(-1,2,4,Blocks.wooden_slab,13);bb.buildBlock(-1,2,5,Blocks.stonebrick,0);
		bb.buildBlock(0,2,-5,Blocks.stonebrick,0);bb.buildBlock(0,2,-4,Blocks.wooden_slab,13);bb.buildBlock(0,2,-3,Blocks.wooden_slab,13);
		bb.buildBlock(0,2,-2,Blocks.wooden_slab,13);bb.buildBlock(0,2,3,Blocks.wooden_slab,13);bb.buildBlock(0,2,4,Blocks.wooden_slab,13);
		bb.buildBlock(0,2,5,Blocks.stonebrick,0);bb.buildBlock(1,2,-5,Blocks.stonebrick,0);bb.buildBlock(1,2,-4,Blocks.dark_oak_stairs,1);
		bb.buildBlock(1,2,-3,Blocks.dark_oak_stairs,1);bb.buildBlock(1,2,-2,Blocks.dark_oak_stairs,1);bb.buildBlock(1,2,3,Blocks.double_wooden_slab,5);
		bb.buildBlock(1,2,4,Blocks.double_wooden_slab,5);bb.buildBlock(1,2,5,Blocks.stonebrick,0);bb.buildBlock(2,2,-5,Blocks.stonebrick,0);
		bb.buildBlock(2,2,5,Blocks.stonebrick,0);bb.buildBlock(3,2,-5,Blocks.glass_pane,0);bb.buildBlock(3,2,5,Blocks.glass_pane,0);
		bb.buildBlock(4,2,-5,Blocks.stonebrick,0);bb.buildBlock(4,2,5,Blocks.stonebrick,0);bb.buildBlock(5,2,-5,Blocks.stonebrick,0);
		bb.buildBlock(5,2,-4,Blocks.stonebrick,0);bb.buildBlock(5,2,-3,Blocks.stonebrick,0);bb.buildBlock(5,2,-2,Blocks.stonebrick,0);
		bb.buildBlock(5,2,-1,Blocks.stonebrick,0);bb.buildBlock(5,2,0,Blocks.stonebrick,0);bb.buildBlock(5,2,1,Blocks.stonebrick,0);
		bb.buildBlock(5,2,2,Blocks.stonebrick,0);bb.buildBlock(5,2,3,Blocks.stonebrick,0);bb.buildBlock(5,2,4,Blocks.stonebrick,0);
		bb.buildBlock(5,2,5,Blocks.stonebrick,0);bb.buildBlock(-5,3,-5,Blocks.stonebrick,0);bb.buildBlock(-5,3,-4,Blocks.stonebrick,0);
		bb.buildBlock(-5,3,-3,Blocks.stonebrick,0);bb.buildBlock(-5,3,-2,Blocks.stonebrick,0);bb.buildBlock(-5,3,-1,Blocks.stonebrick,0);
		bb.buildBlock(-5,3,0,Blocks.glass_pane,0);bb.buildBlock(-5,3,1,Blocks.glass_pane,0);bb.buildBlock(-5,3,2,Blocks.glass_pane,0);
		bb.buildBlock(-5,3,3,Blocks.stonebrick,0);bb.buildBlock(-5,3,4,Blocks.stonebrick,0);bb.buildBlock(-5,3,5,Blocks.stonebrick,0);
		bb.buildBlock(-4,3,-5,Blocks.stonebrick,0);bb.buildBlock(-4,3,-4,Blocks.chest,5);bb.buildBlock(-4,3,-3,Blocks.chest,5);bb.buildBlock(-4,3,3,Blocks.chest,5);bb.buildBlock(-4,3,4,Blocks.chest,5);bb.buildBlock(-4,3,5,Blocks.stonebrick,0);bb.buildBlock(-3,3,-5,Blocks.stonebrick,0);bb.buildBlock(-3,3,5,Blocks.stonebrick,0);
		bb.buildBlock(-2,3,-5,Blocks.stonebrick,0);bb.buildBlock(-2,3,0,Blocks.stone_brick_stairs,1);bb.buildBlock(-2,3,1,Blocks.stone_brick_stairs,1);
		bb.buildBlock(-2,3,5,Blocks.stonebrick,0);bb.buildBlock(-1,3,-5,Blocks.stonebrick,0);bb.buildBlock(-1,3,5,Blocks.stonebrick,0);
		bb.buildBlock(0,3,-5,Blocks.stonebrick,0);bb.buildBlock(0,3,5,Blocks.stonebrick,0);bb.buildBlock(1,3,-5,Blocks.stonebrick,0);
		bb.buildBlock(1,3,5,Blocks.stonebrick,0);bb.buildBlock(2,3,-5,Blocks.stonebrick,0);bb.buildBlock(2,3,5,Blocks.stonebrick,0);
		bb.buildBlock(3,3,-5,Blocks.glass_pane,0);bb.buildBlock(3,3,5,Blocks.glass_pane,0);bb.buildBlock(4,3,-5,Blocks.stonebrick,0);
		bb.buildBlock(4,3,5,Blocks.stonebrick,0);bb.buildBlock(5,3,-5,Blocks.stonebrick,0);bb.buildBlock(5,3,-4,Blocks.stonebrick,0);
		bb.buildBlock(5,3,-3,Blocks.glass_pane,0);bb.buildBlock(5,3,-2,Blocks.glass_pane,0);bb.buildBlock(5,3,-1,Blocks.glass_pane,0);
		bb.buildBlock(5,3,0,Blocks.glass_pane,0);bb.buildBlock(5,3,1,Blocks.glass_pane,0);bb.buildBlock(5,3,2,Blocks.glass_pane,0);
		bb.buildBlock(5,3,3,Blocks.glass_pane,0);bb.buildBlock(5,3,4,Blocks.stonebrick,0);bb.buildBlock(5,3,5,Blocks.stonebrick,0);
		bb.buildBlock(-5,4,-5,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,4,-4,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,4,-3,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-5,4,-2,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,4,-1,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,4,0,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-5,4,1,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,4,2,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,4,3,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-5,4,4,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(-4,4,-5,Blocks.stone_brick_stairs,2);
		bb.buildBlock(-4,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(-3,4,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(-3,4,0,Blocks.stone_brick_stairs,1);
		bb.buildBlock(-3,4,1,Blocks.stone_brick_stairs,1);bb.buildBlock(-3,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(-2,4,-5,Blocks.stone_brick_stairs,2);
		bb.buildBlock(-2,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(-1,4,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(-1,4,5,Blocks.stone_brick_stairs,3);
		bb.buildBlock(0,4,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(0,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(1,4,-5,Blocks.stone_brick_stairs,2);
		bb.buildBlock(1,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(2,4,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(2,4,5,Blocks.stone_brick_stairs,3);
		bb.buildBlock(3,4,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(3,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(4,4,-5,Blocks.stone_brick_stairs,2);
		bb.buildBlock(4,4,5,Blocks.stone_brick_stairs,3);bb.buildBlock(5,4,-5,Blocks.stone_brick_stairs,1);bb.buildBlock(5,4,-4,Blocks.stone_brick_stairs,1);
		bb.buildBlock(5,4,-3,Blocks.stone_brick_stairs,1);bb.buildBlock(5,4,-2,Blocks.stone_brick_stairs,1);bb.buildBlock(5,4,-1,Blocks.stone_brick_stairs,1);
		bb.buildBlock(5,4,0,Blocks.stone_brick_stairs,1);bb.buildBlock(5,4,1,Blocks.stone_brick_stairs,1);bb.buildBlock(5,4,2,Blocks.stone_brick_stairs,1);
		bb.buildBlock(5,4,3,Blocks.stone_brick_stairs,1);bb.buildBlock(5,4,4,Blocks.stone_brick_stairs,1);bb.buildBlock(5,4,5,Blocks.stone_brick_stairs,1);
		bb.buildBlock(-4,5,-4,Blocks.stonebrick,0);bb.buildBlock(-4,5,-3,Blocks.stonebrick,0);bb.buildBlock(-4,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(-4,5,-1,Blocks.stonebrick,0);bb.buildBlock(-4,5,0,Blocks.stonebrick,0);bb.buildBlock(-4,5,1,Blocks.stonebrick,0);
		bb.buildBlock(-4,5,2,Blocks.stonebrick,0);bb.buildBlock(-4,5,3,Blocks.stonebrick,0);bb.buildBlock(-4,5,4,Blocks.stonebrick,0);
		bb.buildBlock(-3,5,-4,Blocks.stonebrick,0);bb.buildBlock(-3,5,-3,Blocks.stonebrick,0);bb.buildBlock(-3,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(-3,5,-1,Blocks.stone_slab,5);bb.buildBlock(-3,5,2,Blocks.stone_slab,5);bb.buildBlock(-3,5,3,Blocks.stonebrick,0);
		bb.buildBlock(-3,5,4,Blocks.stonebrick,0);bb.buildBlock(-2,5,-4,Blocks.stonebrick,0);bb.buildBlock(-2,5,-3,Blocks.stonebrick,0);
		bb.buildBlock(-2,5,-2,Blocks.stonebrick,0);bb.buildBlock(-2,5,-1,Blocks.stone_slab,5);bb.buildBlock(-2,5,2,Blocks.stone_slab,5);
		bb.buildBlock(-2,5,3,Blocks.stonebrick,0);bb.buildBlock(-2,5,4,Blocks.stonebrick,0);bb.buildBlock(-1,5,-4,Blocks.stonebrick,0);
		bb.buildBlock(-1,5,-3,Blocks.stonebrick,0);bb.buildBlock(-1,5,-2,Blocks.stonebrick,0);bb.buildBlock(-1,5,-1,Blocks.stone_slab,5);
		bb.buildBlock(-1,5,2,Blocks.stone_slab,5);bb.buildBlock(-1,5,3,Blocks.stonebrick,0);bb.buildBlock(-1,5,4,Blocks.stonebrick,0);
		bb.buildBlock(0,5,-4,Blocks.stonebrick,0);bb.buildBlock(0,5,-3,Blocks.stonebrick,0);bb.buildBlock(0,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(0,5,-1,Blocks.stone_slab,5);bb.buildBlock(0,5,0,Blocks.stone_slab,5);bb.buildBlock(0,5,1,Blocks.stone_slab,5);
		bb.buildBlock(0,5,2,Blocks.stone_slab,5);bb.buildBlock(0,5,3,Blocks.stonebrick,0);bb.buildBlock(0,5,4,Blocks.stonebrick,0);
		bb.buildBlock(1,5,-4,Blocks.stonebrick,0);bb.buildBlock(1,5,-3,Blocks.stonebrick,0);bb.buildBlock(1,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(1,5,-1,Blocks.stonebrick,0);bb.buildBlock(1,5,0,Blocks.stonebrick,0);bb.buildBlock(1,5,1,Blocks.stonebrick,0);
		bb.buildBlock(1,5,2,Blocks.stonebrick,0);bb.buildBlock(1,5,3,Blocks.stonebrick,0);bb.buildBlock(1,5,4,Blocks.stonebrick,0);
		bb.buildBlock(2,5,-4,Blocks.stonebrick,0);bb.buildBlock(2,5,-3,Blocks.stonebrick,0);bb.buildBlock(2,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,5,-1,Blocks.stonebrick,0);bb.buildBlock(2,5,0,Blocks.stonebrick,0);bb.buildBlock(2,5,1,Blocks.stonebrick,0);
		bb.buildBlock(2,5,2,Blocks.stonebrick,0);bb.buildBlock(2,5,3,Blocks.stonebrick,0);bb.buildBlock(2,5,4,Blocks.stonebrick,0);
		bb.buildBlock(3,5,-4,Blocks.stonebrick,0);bb.buildBlock(3,5,-3,Blocks.stonebrick,0);bb.buildBlock(3,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(3,5,-1,Blocks.stonebrick,0);bb.buildBlock(3,5,0,Blocks.stonebrick,0);bb.buildBlock(3,5,1,Blocks.stonebrick,0);
		bb.buildBlock(3,5,2,Blocks.stonebrick,0);bb.buildBlock(3,5,3,Blocks.stonebrick,0);bb.buildBlock(3,5,4,Blocks.stonebrick,0);
		bb.buildBlock(4,5,-4,Blocks.stonebrick,0);bb.buildBlock(4,5,-3,Blocks.stonebrick,0);bb.buildBlock(4,5,-2,Blocks.stonebrick,0);
		bb.buildBlock(4,5,-1,Blocks.stonebrick,0);bb.buildBlock(4,5,0,Blocks.stonebrick,0);bb.buildBlock(4,5,1,Blocks.stonebrick,0);
		bb.buildBlock(4,5,2,Blocks.stonebrick,0);bb.buildBlock(4,5,3,Blocks.stonebrick,0);bb.buildBlock(4,5,4,Blocks.stonebrick,0);
		bb.buildBlock(-4,6,-4,Blocks.stonebrick,0);bb.buildBlock(-4,6,-3,Blocks.stonebrick,0);bb.buildBlock(-4,6,-2,Blocks.stonebrick,0);
		bb.buildBlock(-4,6,-1,Blocks.glass_pane,0);bb.buildBlock(-4,6,0,Blocks.glass_pane,0);bb.buildBlock(-4,6,1,Blocks.glass_pane,0);
		bb.buildBlock(-4,6,2,Blocks.stonebrick,0);bb.buildBlock(-4,6,3,Blocks.stonebrick,0);bb.buildBlock(-4,6,4,Blocks.stonebrick,0);
		bb.buildBlock(-3,6,-4,Blocks.stonebrick,0);bb.buildBlock(-3,6,4,Blocks.stonebrick,0);bb.buildBlock(-2,6,-4,Blocks.stonebrick,0);
		bb.buildBlock(-2,6,4,Blocks.stonebrick,0);bb.buildBlock(-1,6,-4,Blocks.stonebrick,0);bb.buildBlock(-1,6,4,Blocks.stonebrick,0);
		bb.buildBlock(0,6,-4,Blocks.stonebrick,0);bb.buildBlock(0,6,4,Blocks.stonebrick,0);bb.buildBlock(1,6,-4,Blocks.stonebrick,0);
		bb.buildBlock(1,6,4,Blocks.stonebrick,0);bb.buildBlock(2,6,-4,Blocks.stonebrick,0);bb.buildBlock(2,6,-3,Blocks.bed,3);
		bb.buildBlock(2,6,-1,Blocks.bed,3);bb.buildBlock(2,6,1,Blocks.bed,3);bb.buildBlock(2,6,3,Blocks.bed,3);
		bb.buildBlock(2,6,4,Blocks.stonebrick,0);bb.buildBlock(3,6,-4,Blocks.stonebrick,0);bb.buildBlock(3,6,-3,Blocks.bed,11);
		bb.buildBlock(3,6,-1,Blocks.bed,11);bb.buildBlock(3,6,1,Blocks.bed,11);bb.buildBlock(3,6,3,Blocks.bed,11);
		bb.buildBlock(3,6,4,Blocks.stonebrick,0);bb.buildBlock(4,6,-4,Blocks.stonebrick,0);bb.buildBlock(4,6,-3,Blocks.stonebrick,0);
		bb.buildBlock(4,6,-2,Blocks.stonebrick,0);bb.buildBlock(4,6,-1,Blocks.stonebrick,0);bb.buildBlock(4,6,0,Blocks.stonebrick,0);
		bb.buildBlock(4,6,1,Blocks.stonebrick,0);bb.buildBlock(4,6,2,Blocks.stonebrick,0);bb.buildBlock(4,6,3,Blocks.stonebrick,0);
		bb.buildBlock(4,6,4,Blocks.stonebrick,0);bb.buildBlock(-4,7,-4,Blocks.stonebrick,0);bb.buildBlock(-4,7,-3,Blocks.stonebrick,0);
		bb.buildBlock(-4,7,-2,Blocks.stonebrick,0);bb.buildBlock(-4,7,-1,Blocks.glass_pane,0);bb.buildBlock(-4,7,0,Blocks.glass_pane,0);
		bb.buildBlock(-4,7,1,Blocks.glass_pane,0);bb.buildBlock(-4,7,2,Blocks.stonebrick,0);bb.buildBlock(-4,7,3,Blocks.stonebrick,0);
		bb.buildBlock(-4,7,4,Blocks.stonebrick,0);bb.buildBlock(-3,7,-4,Blocks.stonebrick,0);bb.buildBlock(-3,7,4,Blocks.stonebrick,0);
		bb.buildBlock(-2,7,-4,Blocks.stonebrick,0);bb.buildBlock(-2,7,4,Blocks.stonebrick,0);bb.buildBlock(-1,7,-4,Blocks.glass_pane,0);
		bb.buildBlock(-1,7,4,Blocks.glass_pane,0);bb.buildBlock(0,7,-4,Blocks.glass_pane,0);bb.buildBlock(0,7,4,Blocks.glass_pane,0);
		bb.buildBlock(1,7,-4,Blocks.glass_pane,0);bb.buildBlock(1,7,4,Blocks.glass_pane,0);bb.buildBlock(2,7,-4,Blocks.stonebrick,0);
		bb.buildBlock(2,7,4,Blocks.stonebrick,0);bb.buildBlock(3,7,-4,Blocks.stonebrick,0);bb.buildBlock(3,7,4,Blocks.stonebrick,0);
		bb.buildBlock(4,7,-4,Blocks.stonebrick,0);bb.buildBlock(4,7,-3,Blocks.stonebrick,0);bb.buildBlock(4,7,-2,Blocks.glass_pane,0);
		bb.buildBlock(4,7,-1,Blocks.glass_pane,0);bb.buildBlock(4,7,0,Blocks.glass_pane,0);bb.buildBlock(4,7,1,Blocks.glass_pane,0);
		bb.buildBlock(4,7,2,Blocks.glass_pane,0);bb.buildBlock(4,7,3,Blocks.stonebrick,0);bb.buildBlock(4,7,4,Blocks.stonebrick,0);
		bb.buildBlock(-4,8,-4,Blocks.stonebrick,0);bb.buildBlock(-4,8,-3,Blocks.stonebrick,0);bb.buildBlock(-4,8,-2,Blocks.stonebrick,0);
		bb.buildBlock(-4,8,-1,Blocks.stonebrick,0);bb.buildBlock(-4,8,0,Blocks.stonebrick,0);bb.buildBlock(-4,8,1,Blocks.stonebrick,0);
		bb.buildBlock(-4,8,2,Blocks.stonebrick,0);bb.buildBlock(-4,8,3,Blocks.stonebrick,0);bb.buildBlock(-4,8,4,Blocks.stonebrick,0);
		bb.buildBlock(-3,8,-4,Blocks.stonebrick,0);bb.buildBlock(-3,8,4,Blocks.stonebrick,0);bb.buildBlock(-2,8,-4,Blocks.stonebrick,0);
		bb.buildBlock(-2,8,4,Blocks.stonebrick,0);bb.buildBlock(-1,8,-4,Blocks.stonebrick,0);bb.buildBlock(-1,8,4,Blocks.stonebrick,0);
		bb.buildBlock(0,8,-4,Blocks.stonebrick,0);bb.buildBlock(0,8,4,Blocks.stonebrick,0);bb.buildBlock(1,8,-4,Blocks.stonebrick,0);
		bb.buildBlock(1,8,4,Blocks.stonebrick,0);bb.buildBlock(2,8,-4,Blocks.stonebrick,0);bb.buildBlock(2,8,4,Blocks.stonebrick,0);
		bb.buildBlock(3,8,-4,Blocks.stonebrick,0);bb.buildBlock(3,8,4,Blocks.stonebrick,0);bb.buildBlock(4,8,-4,Blocks.stonebrick,0);
		bb.buildBlock(4,8,-3,Blocks.stonebrick,0);bb.buildBlock(4,8,-2,Blocks.stonebrick,0);bb.buildBlock(4,8,-1,Blocks.stonebrick,0);
		bb.buildBlock(4,8,0,Blocks.stonebrick,0);bb.buildBlock(4,8,1,Blocks.stonebrick,0);bb.buildBlock(4,8,2,Blocks.stonebrick,0);
		bb.buildBlock(4,8,3,Blocks.stonebrick,0);bb.buildBlock(4,8,4,Blocks.stonebrick,0);bb.buildBlock(-4,9,-4,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-4,9,-3,Blocks.dark_oak_stairs,0);bb.buildBlock(-4,9,-2,Blocks.dark_oak_stairs,0);bb.buildBlock(-4,9,-1,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-4,9,0,Blocks.dark_oak_stairs,0);bb.buildBlock(-4,9,1,Blocks.dark_oak_stairs,0);bb.buildBlock(-4,9,2,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-4,9,3,Blocks.dark_oak_stairs,0);bb.buildBlock(-4,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(-3,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-3,9,-3,Blocks.wooden_slab,9);bb.buildBlock(-3,9,-2,Blocks.wooden_slab,9);bb.buildBlock(-3,9,-1,Blocks.wooden_slab,9);
		bb.buildBlock(-3,9,0,Blocks.wooden_slab,9);bb.buildBlock(-3,9,1,Blocks.wooden_slab,9);bb.buildBlock(-3,9,2,Blocks.wooden_slab,9);
		bb.buildBlock(-3,9,3,Blocks.wooden_slab,9);bb.buildBlock(-3,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(-2,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-2,9,-3,Blocks.wooden_slab,9);bb.buildBlock(-2,9,-2,Blocks.wooden_slab,9);bb.buildBlock(-2,9,-1,Blocks.wooden_slab,9);
		bb.buildBlock(-2,9,0,Blocks.wooden_slab,9);bb.buildBlock(-2,9,1,Blocks.wooden_slab,9);bb.buildBlock(-2,9,2,Blocks.wooden_slab,9);
		bb.buildBlock(-2,9,3,Blocks.wooden_slab,9);bb.buildBlock(-2,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-1,9,-3,Blocks.wooden_slab,9);bb.buildBlock(-1,9,-2,Blocks.wooden_slab,9);bb.buildBlock(-1,9,-1,Blocks.wooden_slab,9);
		bb.buildBlock(-1,9,0,Blocks.wooden_slab,9);bb.buildBlock(-1,9,1,Blocks.wooden_slab,9);bb.buildBlock(-1,9,2,Blocks.wooden_slab,9);
		bb.buildBlock(-1,9,3,Blocks.wooden_slab,9);bb.buildBlock(-1,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(0,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(0,9,-3,Blocks.wooden_slab,9);bb.buildBlock(0,9,-2,Blocks.wooden_slab,9);bb.buildBlock(0,9,-1,Blocks.wooden_slab,9);
		bb.buildBlock(0,9,0,Blocks.wooden_slab,9);bb.buildBlock(0,9,1,Blocks.wooden_slab,9);bb.buildBlock(0,9,2,Blocks.wooden_slab,9);
		bb.buildBlock(0,9,3,Blocks.wooden_slab,9);bb.buildBlock(0,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(1,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(1,9,-3,Blocks.wooden_slab,9);bb.buildBlock(1,9,-2,Blocks.wooden_slab,9);bb.buildBlock(1,9,-1,Blocks.wooden_slab,9);
		bb.buildBlock(1,9,0,Blocks.wooden_slab,9);bb.buildBlock(1,9,1,Blocks.wooden_slab,9);bb.buildBlock(1,9,2,Blocks.wooden_slab,9);
		bb.buildBlock(1,9,3,Blocks.wooden_slab,9);bb.buildBlock(1,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(2,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(2,9,-3,Blocks.wooden_slab,9);bb.buildBlock(2,9,-2,Blocks.wooden_slab,9);bb.buildBlock(2,9,-1,Blocks.wooden_slab,9);
		bb.buildBlock(2,9,0,Blocks.wooden_slab,9);bb.buildBlock(2,9,1,Blocks.wooden_slab,9);bb.buildBlock(2,9,2,Blocks.wooden_slab,9);
		bb.buildBlock(2,9,3,Blocks.wooden_slab,9);bb.buildBlock(2,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(3,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(3,9,-3,Blocks.wooden_slab,9);bb.buildBlock(3,9,-2,Blocks.wooden_slab,9);bb.buildBlock(3,9,-1,Blocks.wooden_slab,9);
		bb.buildBlock(3,9,0,Blocks.wooden_slab,9);bb.buildBlock(3,9,1,Blocks.wooden_slab,9);bb.buildBlock(3,9,2,Blocks.wooden_slab,9);
		bb.buildBlock(3,9,3,Blocks.wooden_slab,9);bb.buildBlock(3,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(4,9,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(4,9,-3,Blocks.dark_oak_stairs,1);bb.buildBlock(4,9,-2,Blocks.dark_oak_stairs,1);bb.buildBlock(4,9,-1,Blocks.dark_oak_stairs,1);
		bb.buildBlock(4,9,0,Blocks.dark_oak_stairs,1);bb.buildBlock(4,9,1,Blocks.dark_oak_stairs,1);bb.buildBlock(4,9,2,Blocks.dark_oak_stairs,1);
		bb.buildBlock(4,9,3,Blocks.dark_oak_stairs,1);bb.buildBlock(4,9,4,Blocks.dark_oak_stairs,3);bb.buildBlock(-4,1,2,Blocks.torch,1);
		bb.buildBlock(-1,1,0,Blocks.torch,2);bb.buildBlock(-1,1,1,Blocks.torch,2);bb.buildBlock(4,2,-1,Blocks.torch,2);
		bb.buildBlock(4,2,2,Blocks.torch,2);bb.buildBlock(4,4,-4,Blocks.torch,2);bb.buildBlock(4,4,4,Blocks.torch,2);
		bb.buildBlock(-3,8,-3,Blocks.torch,3);bb.buildBlock(-3,8,0,Blocks.torch,1);bb.buildBlock(-3,8,1,Blocks.torch,1);
		bb.buildBlock(-3,8,3,Blocks.torch,4);bb.buildBlock(-1,8,-3,Blocks.torch,3);bb.buildBlock(-1,8,3,Blocks.torch,4);
		bb.buildBlock(1,8,-3,Blocks.torch,3);bb.buildBlock(1,8,3,Blocks.torch,4);bb.addEntityItemFrame(5,1,3,3,306);
	}

}
