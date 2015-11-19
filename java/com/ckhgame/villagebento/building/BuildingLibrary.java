package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.misc.NameGenerator;
import com.ckhgame.villagebento.villager.VillagerLibrarian;

import net.minecraft.init.Blocks;

public class BuildingLibrary extends Building {

	@Override
	public String getName() {
		return "Library";
	}

	@Override
	public String getDescription() {
		return "Please keep slience..";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerLibrarian.class,NameGenerator.getRandomFemaleName(),2,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-5,0,-4,Blocks.stonebrick,0);bb.buildBlock(-5,0,-3,Blocks.stonebrick,0);bb.buildBlock(-5,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(-5,0,-1,Blocks.stonebrick,0);bb.buildBlock(-5,0,0,Blocks.stonebrick,0);bb.buildBlock(-5,0,1,Blocks.stonebrick,0);
		bb.buildBlock(-5,0,2,Blocks.stonebrick,0);bb.buildBlock(-5,0,3,Blocks.stonebrick,0);bb.buildBlock(-5,0,4,Blocks.stonebrick,0);
		bb.buildBlock(-4,0,-5,Blocks.stonebrick,0);bb.buildBlock(-4,0,-3,Blocks.oak_stairs,2);bb.buildBlock(-4,0,-2,Blocks.bookshelf,0);
		bb.buildBlock(-4,0,-1,Blocks.bookshelf,0);bb.buildBlock(-4,0,0,Blocks.bookshelf,0);bb.buildBlock(-4,0,1,Blocks.bookshelf,0);
		bb.buildBlock(-4,0,2,Blocks.bookshelf,0);bb.buildBlock(-4,0,3,Blocks.bookshelf,0);bb.buildBlock(-4,0,4,Blocks.bookshelf,0);
		bb.buildBlock(-4,0,5,Blocks.stonebrick,0);bb.buildBlock(-3,0,-5,Blocks.stonebrick,0);bb.buildBlock(-3,0,5,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,-5,Blocks.stonebrick,0);bb.buildBlock(-2,0,-4,Blocks.dark_oak_stairs,3);bb.buildBlock(-2,0,5,Blocks.stonebrick,0);
		bb.buildBlock(-1,0,-5,Blocks.stonebrick,0);bb.buildBlock(-1,0,-4,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,0,-2,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-1,0,2,Blocks.dark_oak_stairs,0);bb.buildBlock(-1,0,4,Blocks.dark_oak_stairs,2);bb.buildBlock(-1,0,5,Blocks.stonebrick,0);
		bb.buildBlock(0,0,-5,Blocks.stonebrick,0);bb.buildBlock(0,0,-4,Blocks.dark_oak_stairs,3);bb.buildBlock(0,0,-2,Blocks.planks,5);
		bb.buildBlock(0,0,-1,Blocks.bookshelf,0);bb.buildBlock(0,0,0,Blocks.bookshelf,0);bb.buildBlock(0,0,1,Blocks.bookshelf,0);
		bb.buildBlock(0,0,2,Blocks.planks,5);bb.buildBlock(0,0,4,Blocks.dark_oak_stairs,2);bb.buildBlock(0,0,5,Blocks.stonebrick,0);
		bb.buildBlock(1,0,-5,Blocks.stonebrick,0);bb.buildBlock(1,0,-4,Blocks.dark_oak_stairs,3);bb.buildBlock(1,0,-2,Blocks.ladder,5);
		bb.buildBlock(1,0,2,Blocks.ladder,5);bb.buildBlock(1,0,4,Blocks.dark_oak_stairs,2);bb.buildBlock(1,0,5,Blocks.stonebrick,0);
		bb.buildBlock(2,0,-5,Blocks.stonebrick,0);bb.buildBlock(2,0,5,Blocks.stonebrick,0);bb.buildBlock(3,0,-5,Blocks.stonebrick,0);
		bb.buildBlock(3,0,5,Blocks.stonebrick,0);bb.buildBlock(4,0,-5,Blocks.stonebrick,0);bb.buildBlock(4,0,-4,Blocks.bookshelf,0);
		bb.buildBlock(4,0,-3,Blocks.bookshelf,0);bb.buildBlock(4,0,-2,Blocks.stonebrick,0);bb.buildBlock(4,0,-1,Blocks.stonebrick,0);
		bb.buildBlock(4,0,0,Blocks.wooden_door,0);bb.buildBlock(4,0,1,Blocks.stonebrick,0);bb.buildBlock(4,0,2,Blocks.stonebrick,0);
		bb.buildBlock(4,0,3,Blocks.bookshelf,0);bb.buildBlock(4,0,4,Blocks.bookshelf,0);bb.buildBlock(4,0,5,Blocks.stonebrick,0);
		bb.buildBlock(5,0,-4,Blocks.stonebrick,0);bb.buildBlock(5,0,-3,Blocks.stonebrick,0);bb.buildBlock(5,0,3,Blocks.stonebrick,0);
		bb.buildBlock(5,0,4,Blocks.stonebrick,0);bb.buildBlock(-5,1,-4,Blocks.planks,1);bb.buildBlock(-5,1,-3,Blocks.planks,1);
		bb.buildBlock(-5,1,-2,Blocks.planks,1);bb.buildBlock(-5,1,-1,Blocks.planks,1);bb.buildBlock(-5,1,0,Blocks.planks,1);
		bb.buildBlock(-5,1,1,Blocks.planks,1);bb.buildBlock(-5,1,2,Blocks.planks,1);bb.buildBlock(-5,1,3,Blocks.planks,1);
		bb.buildBlock(-5,1,4,Blocks.planks,1);bb.buildBlock(-4,1,-5,Blocks.planks,1);bb.buildBlock(-4,1,-2,Blocks.oak_stairs,2);
		bb.buildBlock(-4,1,-1,Blocks.bookshelf,0);bb.buildBlock(-4,1,0,Blocks.bookshelf,0);bb.buildBlock(-4,1,1,Blocks.bookshelf,0);
		bb.buildBlock(-4,1,2,Blocks.bookshelf,0);bb.buildBlock(-4,1,3,Blocks.bookshelf,0);bb.buildBlock(-4,1,4,Blocks.bookshelf,0);
		bb.buildBlock(-4,1,5,Blocks.planks,1);bb.buildBlock(-3,1,-5,Blocks.planks,1);bb.buildBlock(-3,1,5,Blocks.planks,1);
		bb.buildBlock(-2,1,-5,Blocks.planks,1);bb.buildBlock(-2,1,5,Blocks.planks,1);bb.buildBlock(-1,1,-5,Blocks.planks,1);
		bb.buildBlock(-1,1,5,Blocks.planks,1);bb.buildBlock(0,1,-5,Blocks.planks,1);bb.buildBlock(0,1,-2,Blocks.planks,5);
		bb.buildBlock(0,1,-1,Blocks.bookshelf,0);bb.buildBlock(0,1,0,Blocks.flower_pot,3);bb.addTileEntityPot(0,1,0,38,3);
		bb.buildBlock(0,1,1,Blocks.bookshelf,0);bb.buildBlock(0,1,2,Blocks.planks,5);bb.buildBlock(0,1,5,Blocks.planks,1);
		bb.buildBlock(1,1,-5,Blocks.planks,1);bb.buildBlock(1,1,-2,Blocks.ladder,5);bb.buildBlock(1,1,2,Blocks.ladder,5);
		bb.buildBlock(1,1,5,Blocks.planks,1);bb.buildBlock(2,1,-5,Blocks.planks,1);bb.buildBlock(2,1,5,Blocks.planks,1);
		bb.buildBlock(3,1,-5,Blocks.planks,1);bb.buildBlock(3,1,5,Blocks.planks,1);bb.buildBlock(4,1,-5,Blocks.planks,1);
		bb.buildBlock(4,1,-4,Blocks.flower_pot,3);bb.addTileEntityPot(4,1,-4,38,3);
		bb.buildBlock(4,1,-3,Blocks.flower_pot,2);bb.addTileEntityPot(4,1,-3,38,2);
		bb.buildBlock(4,1,-2,Blocks.planks,1);bb.buildBlock(4,1,-1,Blocks.planks,1);bb.buildBlock(4,1,0,Blocks.wooden_door,8);
		bb.buildBlock(4,1,1,Blocks.planks,1);bb.buildBlock(4,1,2,Blocks.planks,1);bb.buildBlock(4,1,3,Blocks.flower_pot,2);
		bb.addTileEntityPot(4,1,3,38,2);
		bb.buildBlock(4,1,4,Blocks.flower_pot,3);bb.addTileEntityPot(4,1,4,38,3);
		bb.buildBlock(4,1,5,Blocks.planks,1);bb.buildBlock(5,1,-4,Blocks.planks,1);bb.buildBlock(5,1,-3,Blocks.planks,1);
		bb.buildBlock(5,1,3,Blocks.planks,1);bb.buildBlock(5,1,4,Blocks.planks,1);bb.buildBlock(-5,2,-4,Blocks.planks,1);
		bb.buildBlock(-5,2,-3,Blocks.glass_pane,0);bb.buildBlock(-5,2,-2,Blocks.glass_pane,0);bb.buildBlock(-5,2,-1,Blocks.planks,1);
		bb.buildBlock(-5,2,0,Blocks.glass_pane,0);bb.buildBlock(-5,2,1,Blocks.planks,1);bb.buildBlock(-5,2,2,Blocks.glass_pane,0);
		bb.buildBlock(-5,2,3,Blocks.glass_pane,0);bb.buildBlock(-5,2,4,Blocks.planks,1);bb.buildBlock(-4,2,-5,Blocks.planks,1);
		bb.buildBlock(-4,2,-1,Blocks.oak_stairs,2);bb.buildBlock(-4,2,0,Blocks.bookshelf,0);bb.buildBlock(-4,2,1,Blocks.bookshelf,0);
		bb.buildBlock(-4,2,2,Blocks.bookshelf,0);bb.buildBlock(-4,2,3,Blocks.bookshelf,0);bb.buildBlock(-4,2,4,Blocks.bookshelf,0);
		bb.buildBlock(-4,2,5,Blocks.planks,1);bb.buildBlock(-3,2,-5,Blocks.glass_pane,0);bb.buildBlock(-3,2,5,Blocks.glass_pane,0);
		bb.buildBlock(-2,2,-5,Blocks.glass_pane,0);bb.buildBlock(-2,2,5,Blocks.glass_pane,0);bb.buildBlock(-1,2,-5,Blocks.planks,1);
		bb.buildBlock(-1,2,5,Blocks.planks,1);bb.buildBlock(0,2,-5,Blocks.glass_pane,0);bb.buildBlock(0,2,-2,Blocks.planks,5);
		bb.buildBlock(0,2,-1,Blocks.bookshelf,0);bb.buildBlock(0,2,0,Blocks.bookshelf,0);bb.buildBlock(0,2,1,Blocks.bookshelf,0);
		bb.buildBlock(0,2,2,Blocks.planks,5);bb.buildBlock(0,2,5,Blocks.glass_pane,0);bb.buildBlock(1,2,-5,Blocks.glass_pane,0);
		bb.buildBlock(1,2,-2,Blocks.ladder,5);bb.buildBlock(1,2,2,Blocks.ladder,5);bb.buildBlock(1,2,5,Blocks.glass_pane,0);
		bb.buildBlock(2,2,-5,Blocks.planks,1);bb.buildBlock(2,2,5,Blocks.planks,1);bb.buildBlock(3,2,-5,Blocks.planks,1);
		bb.buildBlock(3,2,5,Blocks.planks,1);bb.buildBlock(4,2,-5,Blocks.planks,1);bb.buildBlock(4,2,-2,Blocks.planks,1);
		bb.buildBlock(4,2,-1,Blocks.planks,1);bb.buildBlock(4,2,0,Blocks.planks,1);bb.buildBlock(4,2,1,Blocks.planks,1);
		bb.buildBlock(4,2,2,Blocks.planks,1);bb.buildBlock(4,2,5,Blocks.planks,1);bb.buildBlock(5,2,-4,Blocks.glass,0);
		bb.buildBlock(5,2,-3,Blocks.glass,0);bb.buildBlock(5,2,3,Blocks.glass,0);bb.buildBlock(5,2,4,Blocks.glass,0);
		bb.buildBlock(-5,3,-4,Blocks.planks,1);bb.buildBlock(-5,3,-3,Blocks.glass_pane,0);bb.buildBlock(-5,3,-2,Blocks.glass_pane,0);
		bb.buildBlock(-5,3,-1,Blocks.planks,1);bb.buildBlock(-5,3,0,Blocks.glass_pane,0);bb.buildBlock(-5,3,1,Blocks.planks,1);
		bb.buildBlock(-5,3,2,Blocks.glass_pane,0);bb.buildBlock(-5,3,3,Blocks.glass_pane,0);bb.buildBlock(-5,3,4,Blocks.planks,1);
		bb.buildBlock(-4,3,-5,Blocks.planks,1);bb.buildBlock(-4,3,0,Blocks.oak_stairs,2);bb.buildBlock(-4,3,1,Blocks.bookshelf,0);
		bb.buildBlock(-4,3,2,Blocks.bookshelf,0);bb.buildBlock(-4,3,3,Blocks.bookshelf,0);bb.buildBlock(-4,3,4,Blocks.bookshelf,0);
		bb.buildBlock(-4,3,5,Blocks.planks,1);bb.buildBlock(-3,3,-5,Blocks.glass_pane,0);bb.buildBlock(-3,3,5,Blocks.glass_pane,0);
		bb.buildBlock(-2,3,-5,Blocks.glass_pane,0);bb.buildBlock(-2,3,5,Blocks.glass_pane,0);bb.buildBlock(-1,3,-5,Blocks.planks,1);
		bb.buildBlock(-1,3,5,Blocks.planks,1);bb.buildBlock(0,3,-5,Blocks.glass_pane,0);bb.buildBlock(0,3,-2,Blocks.planks,5);
		bb.buildBlock(0,3,2,Blocks.planks,5);bb.buildBlock(0,3,5,Blocks.glass_pane,0);bb.buildBlock(1,3,-5,Blocks.glass_pane,0);
		bb.buildBlock(1,3,-2,Blocks.ladder,5);bb.buildBlock(1,3,2,Blocks.ladder,5);bb.buildBlock(1,3,5,Blocks.glass_pane,0);
		bb.buildBlock(2,3,-5,Blocks.planks,1);bb.buildBlock(2,3,5,Blocks.planks,1);bb.buildBlock(3,3,-5,Blocks.planks,1);
		bb.buildBlock(3,3,5,Blocks.planks,1);bb.buildBlock(4,3,-5,Blocks.planks,1);bb.buildBlock(4,3,-2,Blocks.planks,1);
		bb.buildBlock(4,3,-1,Blocks.glass_pane,0);bb.buildBlock(4,3,0,Blocks.glass_pane,0);bb.buildBlock(4,3,1,Blocks.glass_pane,0);
		bb.buildBlock(4,3,2,Blocks.planks,1);bb.buildBlock(4,3,5,Blocks.planks,1);bb.buildBlock(5,3,-4,Blocks.glass,0);
		bb.buildBlock(5,3,-3,Blocks.glass,0);bb.buildBlock(5,3,3,Blocks.glass,0);bb.buildBlock(5,3,4,Blocks.glass,0);
		bb.buildBlock(-5,4,-4,Blocks.planks,1);bb.buildBlock(-5,4,-3,Blocks.planks,1);bb.buildBlock(-5,4,-2,Blocks.planks,1);
		bb.buildBlock(-5,4,-1,Blocks.planks,1);bb.buildBlock(-5,4,0,Blocks.planks,1);bb.buildBlock(-5,4,1,Blocks.planks,1);
		bb.buildBlock(-5,4,2,Blocks.planks,1);bb.buildBlock(-5,4,3,Blocks.planks,1);bb.buildBlock(-5,4,4,Blocks.planks,1);
		bb.buildBlock(-4,4,-5,Blocks.planks,1);bb.buildBlock(-4,4,-4,Blocks.planks,1);bb.buildBlock(-4,4,-3,Blocks.planks,1);
		bb.buildBlock(-4,4,1,Blocks.oak_stairs,2);bb.buildBlock(-4,4,2,Blocks.planks,1);bb.buildBlock(-4,4,3,Blocks.planks,1);
		bb.buildBlock(-4,4,4,Blocks.planks,1);bb.buildBlock(-4,4,5,Blocks.planks,1);bb.buildBlock(-3,4,-5,Blocks.planks,1);
		bb.buildBlock(-3,4,-4,Blocks.planks,1);bb.buildBlock(-3,4,-3,Blocks.planks,1);bb.buildBlock(-3,4,-2,Blocks.planks,1);
		bb.buildBlock(-3,4,-1,Blocks.planks,1);bb.buildBlock(-3,4,0,Blocks.planks,1);bb.buildBlock(-3,4,1,Blocks.planks,1);
		bb.buildBlock(-3,4,2,Blocks.planks,1);bb.buildBlock(-3,4,3,Blocks.planks,1);bb.buildBlock(-3,4,4,Blocks.planks,1);
		bb.buildBlock(-3,4,5,Blocks.planks,1);bb.buildBlock(-2,4,-5,Blocks.planks,1);bb.buildBlock(-2,4,-4,Blocks.planks,1);
		bb.buildBlock(-2,4,-3,Blocks.planks,1);bb.buildBlock(-2,4,-2,Blocks.planks,1);bb.buildBlock(-2,4,-1,Blocks.planks,1);
		bb.buildBlock(-2,4,0,Blocks.planks,1);bb.buildBlock(-2,4,1,Blocks.planks,1);bb.buildBlock(-2,4,2,Blocks.planks,1);
		bb.buildBlock(-2,4,3,Blocks.planks,1);bb.buildBlock(-2,4,4,Blocks.planks,1);bb.buildBlock(-2,4,5,Blocks.planks,1);
		bb.buildBlock(-1,4,-5,Blocks.planks,1);bb.buildBlock(-1,4,-4,Blocks.planks,1);bb.buildBlock(-1,4,-3,Blocks.planks,1);
		bb.buildBlock(-1,4,-2,Blocks.planks,1);bb.buildBlock(-1,4,-1,Blocks.planks,1);bb.buildBlock(-1,4,0,Blocks.planks,1);
		bb.buildBlock(-1,4,1,Blocks.planks,1);bb.buildBlock(-1,4,2,Blocks.planks,1);bb.buildBlock(-1,4,3,Blocks.planks,1);
		bb.buildBlock(-1,4,4,Blocks.planks,1);bb.buildBlock(-1,4,5,Blocks.planks,1);bb.buildBlock(0,4,-5,Blocks.planks,1);
		bb.buildBlock(0,4,-4,Blocks.planks,1);bb.buildBlock(0,4,-3,Blocks.planks,1);bb.buildBlock(0,4,-2,Blocks.planks,5);
		bb.buildBlock(0,4,-1,Blocks.planks,5);bb.buildBlock(0,4,0,Blocks.planks,5);bb.buildBlock(0,4,1,Blocks.planks,5);
		bb.buildBlock(0,4,2,Blocks.planks,5);bb.buildBlock(0,4,3,Blocks.planks,1);bb.buildBlock(0,4,4,Blocks.planks,1);
		bb.buildBlock(0,4,5,Blocks.planks,1);bb.buildBlock(1,4,-5,Blocks.planks,1);bb.buildBlock(1,4,-4,Blocks.planks,1);
		bb.buildBlock(1,4,-3,Blocks.planks,1);bb.buildBlock(1,4,-2,Blocks.planks,1);bb.buildBlock(1,4,-1,Blocks.planks,1);
		bb.buildBlock(1,4,0,Blocks.planks,1);bb.buildBlock(1,4,1,Blocks.planks,1);bb.buildBlock(1,4,2,Blocks.planks,1);
		bb.buildBlock(1,4,3,Blocks.planks,1);bb.buildBlock(1,4,4,Blocks.planks,1);bb.buildBlock(1,4,5,Blocks.planks,1);
		bb.buildBlock(2,4,-5,Blocks.planks,1);bb.buildBlock(2,4,-4,Blocks.planks,1);bb.buildBlock(2,4,-3,Blocks.planks,1);
		bb.buildBlock(2,4,-2,Blocks.planks,1);bb.buildBlock(2,4,-1,Blocks.planks,1);bb.buildBlock(2,4,0,Blocks.planks,1);
		bb.buildBlock(2,4,1,Blocks.planks,1);bb.buildBlock(2,4,2,Blocks.planks,1);bb.buildBlock(2,4,3,Blocks.planks,1);
		bb.buildBlock(2,4,4,Blocks.planks,1);bb.buildBlock(2,4,5,Blocks.planks,1);bb.buildBlock(3,4,-5,Blocks.planks,1);
		bb.buildBlock(3,4,-4,Blocks.planks,1);bb.buildBlock(3,4,-3,Blocks.planks,1);bb.buildBlock(3,4,-2,Blocks.planks,1);
		bb.buildBlock(3,4,-1,Blocks.planks,1);bb.buildBlock(3,4,0,Blocks.planks,1);bb.buildBlock(3,4,1,Blocks.planks,1);
		bb.buildBlock(3,4,2,Blocks.planks,1);bb.buildBlock(3,4,3,Blocks.planks,1);bb.buildBlock(3,4,4,Blocks.planks,1);
		bb.buildBlock(3,4,5,Blocks.planks,1);bb.buildBlock(4,4,-5,Blocks.planks,1);bb.buildBlock(4,4,-4,Blocks.planks,1);
		bb.buildBlock(4,4,-3,Blocks.planks,1);bb.buildBlock(4,4,-2,Blocks.planks,1);bb.buildBlock(4,4,-1,Blocks.planks,1);
		bb.buildBlock(4,4,0,Blocks.planks,1);bb.buildBlock(4,4,1,Blocks.planks,1);bb.buildBlock(4,4,2,Blocks.planks,1);
		bb.buildBlock(4,4,3,Blocks.planks,1);bb.buildBlock(4,4,4,Blocks.planks,1);bb.buildBlock(4,4,5,Blocks.planks,1);
		bb.buildBlock(5,4,-4,Blocks.planks,1);bb.buildBlock(5,4,-3,Blocks.planks,1);bb.buildBlock(5,4,3,Blocks.planks,1);
		bb.buildBlock(5,4,4,Blocks.planks,1);bb.buildBlock(-5,5,-5,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,5,-4,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-5,5,-3,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,5,-2,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,5,-1,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-5,5,0,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,5,1,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,5,2,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-5,5,3,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,5,4,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,5,5,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-4,5,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(-4,5,5,Blocks.stone_brick_stairs,3);bb.buildBlock(-3,5,-5,Blocks.stone_brick_stairs,2);
		bb.buildBlock(-3,5,5,Blocks.stone_brick_stairs,3);bb.buildBlock(-2,5,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(-2,5,-4,Blocks.planks,1);
		bb.buildBlock(-2,5,-3,Blocks.planks,1);bb.buildBlock(-2,5,-2,Blocks.planks,1);bb.buildBlock(-2,5,-1,Blocks.planks,1);
		bb.buildBlock(-2,5,0,Blocks.planks,1);bb.buildBlock(-2,5,1,Blocks.planks,1);bb.buildBlock(-2,5,2,Blocks.planks,1);
		bb.buildBlock(-2,5,3,Blocks.wooden_door,2);bb.buildBlock(-2,5,4,Blocks.planks,1);bb.buildBlock(-2,5,5,Blocks.stone_brick_stairs,3);
		bb.buildBlock(-1,5,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(-1,5,-4,Blocks.planks,1);bb.buildBlock(-1,5,-3,Blocks.bed,9);
		bb.buildBlock(-1,5,4,Blocks.planks,1);bb.buildBlock(-1,5,5,Blocks.stone_brick_stairs,3);bb.buildBlock(0,5,-5,Blocks.stone_brick_stairs,2);
		bb.buildBlock(0,5,-4,Blocks.planks,1);bb.buildBlock(0,5,-3,Blocks.bed,1);bb.buildBlock(0,5,4,Blocks.planks,1);
		bb.buildBlock(0,5,5,Blocks.stone_brick_stairs,3);bb.buildBlock(1,5,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(1,5,-4,Blocks.planks,1);
		bb.buildBlock(1,5,-3,Blocks.bookshelf,0);bb.buildBlock(1,5,-2,Blocks.bookshelf,0);bb.buildBlock(1,5,2,Blocks.bookshelf,0);
		bb.buildBlock(1,5,3,Blocks.bookshelf,0);bb.buildBlock(1,5,4,Blocks.planks,1);bb.buildBlock(1,5,5,Blocks.stone_brick_stairs,3);
		bb.buildBlock(2,5,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(2,5,-4,Blocks.planks,1);bb.buildBlock(2,5,-3,Blocks.planks,1);
		bb.buildBlock(2,5,-2,Blocks.planks,1);bb.buildBlock(2,5,-1,Blocks.planks,1);bb.buildBlock(2,5,0,Blocks.wooden_door,0);
		bb.buildBlock(2,5,1,Blocks.planks,1);bb.buildBlock(2,5,2,Blocks.planks,1);bb.buildBlock(2,5,3,Blocks.planks,1);
		bb.buildBlock(2,5,4,Blocks.planks,1);bb.buildBlock(2,5,5,Blocks.stone_brick_stairs,3);bb.buildBlock(3,5,-5,Blocks.stone_brick_stairs,2);
		bb.buildBlock(3,5,5,Blocks.stone_brick_stairs,3);bb.buildBlock(4,5,-5,Blocks.stone_brick_stairs,2);bb.buildBlock(4,5,-3,Blocks.stone_brick_stairs,3);
		bb.buildBlock(4,5,-2,Blocks.stone_brick_stairs,1);bb.buildBlock(4,5,-1,Blocks.stone_brick_stairs,1);bb.buildBlock(4,5,0,Blocks.stone_brick_stairs,1);
		bb.buildBlock(4,5,1,Blocks.stone_brick_stairs,1);bb.buildBlock(4,5,2,Blocks.stone_brick_stairs,1);bb.buildBlock(4,5,3,Blocks.stone_brick_stairs,2);
		bb.buildBlock(4,5,5,Blocks.stone_brick_stairs,3);bb.buildBlock(5,5,-5,Blocks.stone_brick_stairs,1);bb.buildBlock(5,5,-4,Blocks.stone_brick_stairs,1);
		bb.buildBlock(5,5,-3,Blocks.stone_brick_stairs,1);bb.buildBlock(5,5,3,Blocks.stone_brick_stairs,1);bb.buildBlock(5,5,4,Blocks.stone_brick_stairs,1);
		bb.buildBlock(5,5,5,Blocks.stone_brick_stairs,1);bb.buildBlock(-5,6,-5,Blocks.fence,0);bb.buildBlock(-5,6,-4,Blocks.fence,0);
		bb.buildBlock(-5,6,-3,Blocks.fence,0);bb.buildBlock(-5,6,-2,Blocks.fence,0);bb.buildBlock(-5,6,-1,Blocks.fence,0);
		bb.buildBlock(-5,6,0,Blocks.fence,0);bb.buildBlock(-5,6,1,Blocks.fence,0);bb.buildBlock(-5,6,2,Blocks.fence,0);
		bb.buildBlock(-5,6,3,Blocks.fence,0);bb.buildBlock(-5,6,4,Blocks.fence,0);bb.buildBlock(-5,6,5,Blocks.fence,0);
		bb.buildBlock(-4,6,-5,Blocks.fence,0);bb.buildBlock(-4,6,5,Blocks.fence,0);bb.buildBlock(-3,6,-5,Blocks.fence,0);
		bb.buildBlock(-3,6,5,Blocks.fence,0);bb.buildBlock(-2,6,-5,Blocks.fence,0);bb.buildBlock(-2,6,-4,Blocks.planks,1);
		bb.buildBlock(-2,6,-3,Blocks.planks,1);bb.buildBlock(-2,6,-2,Blocks.planks,1);bb.buildBlock(-2,6,-1,Blocks.planks,1);
		bb.buildBlock(-2,6,0,Blocks.planks,1);bb.buildBlock(-2,6,1,Blocks.planks,1);bb.buildBlock(-2,6,2,Blocks.planks,1);
		bb.buildBlock(-2,6,3,Blocks.wooden_door,8);bb.buildBlock(-2,6,4,Blocks.planks,1);bb.buildBlock(-2,6,5,Blocks.fence,0);
		bb.buildBlock(-1,6,-4,Blocks.planks,1);bb.buildBlock(-1,6,4,Blocks.planks,1);bb.buildBlock(0,6,-4,Blocks.glass_pane,0);
		bb.buildBlock(0,6,4,Blocks.glass_pane,0);bb.buildBlock(1,6,-4,Blocks.planks,1);bb.buildBlock(1,6,-2,Blocks.flower_pot,6);
		bb.addTileEntityPot(1,6,-2,38,6);
		bb.buildBlock(1,6,2,Blocks.flower_pot,6);bb.addTileEntityPot(1,6,2,38,6);
		bb.buildBlock(1,6,4,Blocks.planks,1);bb.buildBlock(2,6,-5,Blocks.fence,0);bb.buildBlock(2,6,-4,Blocks.planks,1);
		bb.buildBlock(2,6,-3,Blocks.planks,1);bb.buildBlock(2,6,-2,Blocks.glass_pane,0);bb.buildBlock(2,6,-1,Blocks.planks,1);
		bb.buildBlock(2,6,0,Blocks.wooden_door,8);bb.buildBlock(2,6,1,Blocks.planks,1);bb.buildBlock(2,6,2,Blocks.glass_pane,0);
		bb.buildBlock(2,6,3,Blocks.planks,1);bb.buildBlock(2,6,4,Blocks.planks,1);bb.buildBlock(2,6,5,Blocks.fence,0);
		bb.buildBlock(3,6,-5,Blocks.fence,0);bb.buildBlock(3,6,5,Blocks.fence,0);bb.buildBlock(4,6,-5,Blocks.fence,0);
		bb.buildBlock(4,6,-3,Blocks.fence,0);bb.buildBlock(4,6,-2,Blocks.fence,0);bb.buildBlock(4,6,-1,Blocks.fence,0);
		bb.buildBlock(4,6,0,Blocks.fence,0);bb.buildBlock(4,6,1,Blocks.fence,0);bb.buildBlock(4,6,2,Blocks.fence,0);
		bb.buildBlock(4,6,3,Blocks.fence,0);bb.buildBlock(4,6,5,Blocks.fence,0);bb.buildBlock(5,6,-5,Blocks.fence,0);
		bb.buildBlock(5,6,-4,Blocks.fence,0);bb.buildBlock(5,6,-3,Blocks.fence,0);bb.buildBlock(5,6,3,Blocks.fence,0);
		bb.buildBlock(5,6,4,Blocks.fence,0);bb.buildBlock(5,6,5,Blocks.fence,0);bb.buildBlock(-2,7,-4,Blocks.planks,1);
		bb.buildBlock(-2,7,-3,Blocks.planks,1);bb.buildBlock(-2,7,-2,Blocks.planks,1);bb.buildBlock(-2,7,-1,Blocks.planks,1);
		bb.buildBlock(-2,7,0,Blocks.planks,1);bb.buildBlock(-2,7,1,Blocks.planks,1);bb.buildBlock(-2,7,2,Blocks.planks,1);
		bb.buildBlock(-2,7,3,Blocks.planks,1);bb.buildBlock(-2,7,4,Blocks.planks,1);bb.buildBlock(-1,7,-4,Blocks.planks,1);
		bb.buildBlock(-1,7,4,Blocks.planks,1);bb.buildBlock(0,7,-4,Blocks.planks,1);bb.buildBlock(0,7,4,Blocks.planks,1);
		bb.buildBlock(1,7,-4,Blocks.planks,1);bb.buildBlock(1,7,4,Blocks.planks,1);bb.buildBlock(2,7,-4,Blocks.planks,1);
		bb.buildBlock(2,7,-3,Blocks.planks,1);bb.buildBlock(2,7,-2,Blocks.planks,1);bb.buildBlock(2,7,-1,Blocks.planks,1);
		bb.buildBlock(2,7,0,Blocks.planks,1);bb.buildBlock(2,7,1,Blocks.planks,1);bb.buildBlock(2,7,2,Blocks.planks,1);
		bb.buildBlock(2,7,3,Blocks.planks,1);bb.buildBlock(2,7,4,Blocks.planks,1);bb.buildBlock(-2,8,-4,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-2,8,-3,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,8,-2,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,8,-1,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-2,8,0,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,8,1,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,8,2,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-2,8,3,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,8,4,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,8,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-1,8,4,Blocks.dark_oak_stairs,3);bb.buildBlock(0,8,-4,Blocks.dark_oak_stairs,2);bb.buildBlock(0,8,4,Blocks.dark_oak_stairs,3);
		bb.buildBlock(1,8,-4,Blocks.dark_oak_stairs,2);bb.buildBlock(1,8,4,Blocks.dark_oak_stairs,3);bb.buildBlock(2,8,-4,Blocks.dark_oak_stairs,2);
		bb.buildBlock(2,8,-3,Blocks.dark_oak_stairs,1);bb.buildBlock(2,8,-2,Blocks.dark_oak_stairs,1);bb.buildBlock(2,8,-1,Blocks.dark_oak_stairs,1);
		bb.buildBlock(2,8,0,Blocks.dark_oak_stairs,1);bb.buildBlock(2,8,1,Blocks.dark_oak_stairs,1);bb.buildBlock(2,8,2,Blocks.dark_oak_stairs,1);
		bb.buildBlock(2,8,3,Blocks.dark_oak_stairs,1);bb.buildBlock(2,8,4,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,9,-3,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-1,9,-2,Blocks.dark_oak_stairs,0);bb.buildBlock(-1,9,-1,Blocks.dark_oak_stairs,0);bb.buildBlock(-1,9,0,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-1,9,1,Blocks.dark_oak_stairs,0);bb.buildBlock(-1,9,2,Blocks.dark_oak_stairs,0);bb.buildBlock(-1,9,3,Blocks.dark_oak_stairs,3);
		bb.buildBlock(0,9,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(0,9,-2,Blocks.planks,1);bb.buildBlock(0,9,-1,Blocks.planks,1);
		bb.buildBlock(0,9,0,Blocks.planks,1);bb.buildBlock(0,9,1,Blocks.planks,1);bb.buildBlock(0,9,2,Blocks.planks,1);
		bb.buildBlock(0,9,3,Blocks.dark_oak_stairs,3);bb.buildBlock(1,9,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(1,9,-2,Blocks.dark_oak_stairs,1);
		bb.buildBlock(1,9,-1,Blocks.dark_oak_stairs,1);bb.buildBlock(1,9,0,Blocks.dark_oak_stairs,1);bb.buildBlock(1,9,1,Blocks.dark_oak_stairs,1);
		bb.buildBlock(1,9,2,Blocks.dark_oak_stairs,1);bb.buildBlock(1,9,3,Blocks.dark_oak_stairs,1);bb.buildBlock(-1,2,-2,Blocks.torch,2);
		bb.buildBlock(-1,2,2,Blocks.torch,2);bb.buildBlock(-4,3,-4,Blocks.torch,3);bb.buildBlock(-1,3,-4,Blocks.torch,3);
		bb.buildBlock(-1,3,4,Blocks.torch,4);bb.buildBlock(0,3,-1,Blocks.torch,3);bb.buildBlock(0,3,1,Blocks.torch,4);
		bb.buildBlock(2,3,-4,Blocks.torch,3);bb.buildBlock(2,3,4,Blocks.torch,4);bb.buildBlock(4,3,-4,Blocks.torch,3);
		bb.buildBlock(4,3,-3,Blocks.torch,4);bb.buildBlock(4,3,3,Blocks.torch,3);bb.buildBlock(4,3,4,Blocks.torch,4);
		bb.buildBlock(-5,7,-5,Blocks.torch,5);bb.buildBlock(-5,7,-2,Blocks.torch,5);bb.buildBlock(-5,7,0,Blocks.torch,5);
		bb.buildBlock(-5,7,2,Blocks.torch,5);bb.buildBlock(-5,7,5,Blocks.torch,5);bb.buildBlock(-2,7,-5,Blocks.torch,5);
		bb.buildBlock(-2,7,5,Blocks.torch,5);bb.buildBlock(2,7,-5,Blocks.torch,5);bb.buildBlock(2,7,5,Blocks.torch,5);
		bb.buildBlock(5,7,-5,Blocks.torch,5);bb.buildBlock(5,7,-3,Blocks.torch,5);bb.buildBlock(5,7,3,Blocks.torch,5);
		bb.buildBlock(5,7,5,Blocks.torch,5);bb.buildBlock(-1,8,-3,Blocks.torch,1);bb.buildBlock(-1,8,0,Blocks.torch,1);
		bb.buildBlock(-1,8,3,Blocks.torch,1);bb.buildBlock(1,8,-3,Blocks.torch,2);bb.buildBlock(1,8,0,Blocks.torch,2);
		bb.buildBlock(1,8,3,Blocks.torch,2);bb.addEntityPainting(-2,6,1,3,"Aztec2");
		bb.addEntityPainting(-2,6,0,3,"Alban");
		bb.addEntityPainting(-2,6,-1,3,"Plant");
		bb.addEntityItemFrame(4,1,1,3,ModBlocks.blockLibrary);
	}

}
