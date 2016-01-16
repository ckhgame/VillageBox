package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionHotelOwner;

import net.minecraft.init.Blocks;

public class BuildingSmallHotel extends Building {

	@Override
	public String getName() {
		return "Small Hotel";
	}

	@Override
	public String getDescription() {
		return "Bon voyage!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionHotelOwner.class,0,-1);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,-3,Blocks.planks,2);bb.buildBlock(-3,-1,-2,Blocks.planks,2);bb.buildBlock(-3,-1,-1,Blocks.planks,2);
		bb.buildBlock(-3,-1,0,Blocks.planks,2);bb.buildBlock(-3,-1,1,Blocks.planks,2);bb.buildBlock(-3,-1,2,Blocks.planks,2);
		bb.buildBlock(-3,-1,3,Blocks.planks,2);bb.buildBlock(-2,-1,-3,Blocks.planks,2);bb.buildBlock(-2,-1,-2,Blocks.planks,2);
		bb.buildBlock(-2,-1,-1,Blocks.planks,2);bb.buildBlock(-2,-1,0,Blocks.planks,2);bb.buildBlock(-2,-1,1,Blocks.planks,2);
		bb.buildBlock(-2,-1,2,Blocks.planks,2);bb.buildBlock(-2,-1,3,Blocks.planks,2);bb.buildBlock(-1,-1,-3,Blocks.planks,2);
		bb.buildBlock(-1,-1,-2,Blocks.planks,2);bb.buildBlock(-1,-1,-1,Blocks.planks,2);bb.buildBlock(-1,-1,0,Blocks.planks,2);
		bb.buildBlock(-1,-1,1,Blocks.planks,2);bb.buildBlock(-1,-1,2,Blocks.planks,2);bb.buildBlock(-1,-1,3,Blocks.planks,2);
		bb.buildBlock(0,-1,-3,Blocks.planks,2);bb.buildBlock(0,-1,-2,Blocks.planks,2);bb.buildBlock(0,-1,-1,Blocks.planks,2);
		bb.buildBlock(0,-1,0,Blocks.planks,2);bb.buildBlock(0,-1,1,Blocks.planks,2);bb.buildBlock(0,-1,2,Blocks.planks,2);
		bb.buildBlock(0,-1,3,Blocks.planks,2);bb.buildBlock(1,-1,-3,Blocks.planks,2);bb.buildBlock(1,-1,-2,Blocks.planks,2);
		bb.buildBlock(1,-1,-1,Blocks.planks,2);bb.buildBlock(1,-1,0,Blocks.planks,2);bb.buildBlock(1,-1,1,Blocks.planks,2);
		bb.buildBlock(1,-1,2,Blocks.planks,2);bb.buildBlock(1,-1,3,Blocks.planks,2);bb.buildBlock(2,-1,-3,Blocks.planks,2);
		bb.buildBlock(2,-1,-2,Blocks.planks,2);bb.buildBlock(2,-1,-1,Blocks.planks,2);bb.buildBlock(2,-1,0,Blocks.planks,2);
		bb.buildBlock(2,-1,1,Blocks.planks,2);bb.buildBlock(2,-1,2,Blocks.planks,2);bb.buildBlock(2,-1,3,Blocks.planks,2);
		bb.buildBlock(3,-1,-3,Blocks.planks,2);bb.buildBlock(3,-1,-2,Blocks.planks,2);bb.buildBlock(3,-1,-1,Blocks.planks,2);
		bb.buildBlock(3,-1,0,Blocks.planks,2);bb.buildBlock(3,-1,1,Blocks.planks,2);bb.buildBlock(3,-1,2,Blocks.planks,2);
		bb.buildBlock(3,-1,3,Blocks.planks,2);bb.buildBlock(-5,0,-5,Blocks.fence,0);bb.buildBlock(-5,0,5,Blocks.fence,0);
		bb.buildBlock(-4,0,-4,Blocks.planks,1);bb.buildBlock(-4,0,-3,Blocks.planks,1);bb.buildBlock(-4,0,-2,Blocks.planks,1);
		bb.buildBlock(-4,0,-1,Blocks.planks,1);bb.buildBlock(-4,0,0,Blocks.planks,1);bb.buildBlock(-4,0,1,Blocks.planks,1);
		bb.buildBlock(-4,0,2,Blocks.planks,1);bb.buildBlock(-4,0,3,Blocks.planks,1);bb.buildBlock(-4,0,4,Blocks.planks,1);
		bb.buildBlock(-3,0,-4,Blocks.planks,1);bb.buildBlock(-3,0,-3,Blocks.bookshelf,0);bb.buildBlock(-3,0,-2,Blocks.carpet,14);
		bb.buildBlock(-3,0,-1,Blocks.bed,0);bb.buildBlock(-3,0,0,Blocks.bed,8);bb.buildBlock(-3,0,1,Blocks.planks,1);
		bb.buildBlock(-3,0,2,Blocks.planks,0);bb.buildBlock(-3,0,3,Blocks.oak_stairs,1);bb.buildBlock(-3,0,4,Blocks.planks,1);
		bb.buildBlock(-2,0,-4,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.bookshelf,0);bb.buildBlock(-2,0,-2,Blocks.carpet,14);
		bb.buildBlock(-2,0,-1,Blocks.carpet,14);bb.buildBlock(-2,0,0,Blocks.chest,2);bb.buildBlock(-2,0,1,Blocks.planks,1);bb.buildBlock(-2,0,2,Blocks.bookshelf,0);bb.buildBlock(-2,0,3,Blocks.carpet,14);
		bb.buildBlock(-2,0,4,Blocks.planks,1);bb.buildBlock(-1,0,-4,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);
		bb.buildBlock(-1,0,-2,Blocks.wooden_door,2);bb.buildBlock(-1,0,-1,Blocks.planks,1);bb.buildBlock(-1,0,0,Blocks.planks,1);
		bb.buildBlock(-1,0,1,Blocks.planks,1);bb.buildBlock(-1,0,2,Blocks.carpet,14);bb.buildBlock(-1,0,3,Blocks.carpet,14);
		bb.buildBlock(-1,0,4,Blocks.planks,1);bb.buildBlock(0,0,-4,Blocks.planks,1);bb.buildBlock(0,0,4,Blocks.planks,1);
		bb.buildBlock(1,0,-4,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.planks,1);bb.buildBlock(1,0,-2,Blocks.planks,1);
		bb.buildBlock(1,0,-1,Blocks.planks,1);bb.buildBlock(1,0,0,Blocks.planks,1);bb.buildBlock(1,0,1,Blocks.flower_pot,0);
		bb.addTileEntityPot(1,0,1,38,0);
		bb.buildBlock(1,0,3,ModBlocks.blockOakChair,0);bb.buildBlock(1,0,4,Blocks.planks,1);bb.buildBlock(2,0,-4,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.carpet,14);
		bb.buildBlock(2,0,-2,Blocks.carpet,14);bb.buildBlock(2,0,-1,Blocks.carpet,14);bb.buildBlock(2,0,0,Blocks.carpet,14);
		bb.buildBlock(2,0,4,Blocks.planks,1);bb.buildBlock(3,0,-4,Blocks.planks,1);bb.buildBlock(3,0,3,ModBlocks.blockOakChair,0);
		bb.buildBlock(3,0,4,Blocks.planks,1);bb.buildBlock(4,0,-4,Blocks.planks,1);bb.buildBlock(4,0,-3,Blocks.planks,1);
		bb.buildBlock(4,0,-2,Blocks.planks,1);bb.buildBlock(4,0,-1,Blocks.wooden_door,2);bb.buildBlock(4,0,0,Blocks.wooden_door,2);
		bb.buildBlock(4,0,1,Blocks.planks,1);bb.buildBlock(4,0,2,Blocks.planks,1);bb.buildBlock(4,0,3,Blocks.planks,1);
		bb.buildBlock(4,0,4,Blocks.planks,1);bb.buildBlock(5,0,-5,Blocks.fence,0);bb.buildBlock(5,0,5,Blocks.fence,0);
		bb.buildBlock(-5,1,-5,Blocks.fence,0);bb.buildBlock(-5,1,5,Blocks.fence,0);bb.buildBlock(-4,1,-4,Blocks.planks,1);
		bb.buildBlock(-4,1,-3,Blocks.planks,1);bb.buildBlock(-4,1,-2,Blocks.planks,1);bb.buildBlock(-4,1,-1,Blocks.planks,1);
		bb.buildBlock(-4,1,0,Blocks.planks,1);bb.buildBlock(-4,1,1,Blocks.planks,1);bb.buildBlock(-4,1,2,Blocks.planks,1);
		bb.buildBlock(-4,1,3,Blocks.planks,1);bb.buildBlock(-4,1,4,Blocks.planks,1);bb.buildBlock(-3,1,-4,Blocks.planks,1);
		bb.buildBlock(-3,1,1,Blocks.planks,1);bb.buildBlock(-3,1,2,Blocks.oak_stairs,3);bb.buildBlock(-3,1,4,Blocks.planks,1);
		bb.buildBlock(-2,1,-4,Blocks.planks,1);bb.buildBlock(-2,1,1,Blocks.planks,1);bb.buildBlock(-2,1,2,Blocks.planks,0);
		bb.buildBlock(-2,1,4,Blocks.planks,1);bb.buildBlock(-1,1,-4,Blocks.planks,1);bb.buildBlock(-1,1,-3,Blocks.planks,1);
		bb.buildBlock(-1,1,-2,Blocks.wooden_door,8);bb.buildBlock(-1,1,-1,Blocks.planks,1);bb.buildBlock(-1,1,0,Blocks.planks,1);
		bb.buildBlock(-1,1,1,Blocks.planks,1);bb.buildBlock(-1,1,4,Blocks.planks,1);bb.buildBlock(0,1,-4,Blocks.planks,1);
		bb.buildBlock(0,1,-3,Blocks.wall_sign,5);bb.addTileEntitySign(0,1,-3,"Private Room","","","");
		bb.buildBlock(0,1,4,Blocks.planks,1);bb.buildBlock(1,1,-4,Blocks.planks,1);bb.buildBlock(1,1,4,Blocks.glass_pane,0);
		bb.buildBlock(2,1,-4,Blocks.planks,1);bb.buildBlock(2,1,4,Blocks.glass_pane,0);bb.buildBlock(3,1,-4,Blocks.planks,1);
		bb.buildBlock(3,1,4,Blocks.planks,1);bb.buildBlock(4,1,-4,Blocks.planks,1);bb.buildBlock(4,1,-3,Blocks.planks,1);
		bb.buildBlock(4,1,-2,Blocks.planks,1);bb.buildBlock(4,1,-1,Blocks.wooden_door,9);bb.buildBlock(4,1,0,Blocks.wooden_door,8);
		bb.buildBlock(4,1,1,Blocks.planks,1);bb.buildBlock(4,1,2,Blocks.glass_pane,0);bb.buildBlock(4,1,3,Blocks.planks,1);
		bb.buildBlock(4,1,4,Blocks.planks,1);bb.buildBlock(5,1,-5,Blocks.fence,0);bb.buildBlock(5,1,5,Blocks.fence,0);
		bb.buildBlock(-5,2,-5,Blocks.fence,0);bb.buildBlock(-5,2,2,Blocks.wooden_slab,12);bb.buildBlock(-5,2,5,Blocks.fence,0);
		bb.buildBlock(-4,2,-4,Blocks.planks,1);bb.buildBlock(-4,2,-3,Blocks.planks,1);bb.buildBlock(-4,2,-2,Blocks.planks,1);
		bb.buildBlock(-4,2,-1,Blocks.planks,1);bb.buildBlock(-4,2,0,Blocks.planks,1);bb.buildBlock(-4,2,1,Blocks.planks,1);
		bb.buildBlock(-4,2,2,Blocks.planks,1);bb.buildBlock(-4,2,3,Blocks.planks,1);bb.buildBlock(-4,2,4,Blocks.planks,1);
		bb.buildBlock(-3,2,-4,Blocks.planks,1);bb.buildBlock(-3,2,1,Blocks.planks,1);bb.buildBlock(-3,2,4,Blocks.planks,1);
		bb.buildBlock(-2,2,-4,Blocks.planks,1);bb.buildBlock(-2,2,1,Blocks.planks,1);bb.buildBlock(-2,2,2,Blocks.oak_stairs,0);
		bb.buildBlock(-2,2,4,Blocks.planks,1);bb.buildBlock(-1,2,-4,Blocks.planks,1);bb.buildBlock(-1,2,-3,Blocks.planks,1);
		bb.buildBlock(-1,2,-2,Blocks.planks,1);bb.buildBlock(-1,2,-1,Blocks.planks,1);bb.buildBlock(-1,2,0,Blocks.planks,1);
		bb.buildBlock(-1,2,1,Blocks.planks,1);bb.buildBlock(-1,2,4,Blocks.planks,1);bb.buildBlock(0,2,-4,Blocks.planks,1);
		bb.buildBlock(0,2,4,Blocks.planks,1);bb.buildBlock(1,2,-4,Blocks.planks,1);bb.buildBlock(1,2,4,Blocks.glass_pane,0);
		bb.buildBlock(2,2,-4,Blocks.planks,1);bb.buildBlock(2,2,4,Blocks.glass_pane,0);bb.buildBlock(3,2,-4,Blocks.planks,1);
		bb.buildBlock(3,2,4,Blocks.planks,1);bb.buildBlock(4,2,-4,Blocks.planks,1);bb.buildBlock(4,2,-3,Blocks.planks,1);
		bb.buildBlock(4,2,-2,Blocks.planks,1);bb.buildBlock(4,2,-1,Blocks.planks,1);bb.buildBlock(4,2,0,Blocks.planks,1);
		bb.buildBlock(4,2,1,Blocks.planks,1);bb.buildBlock(4,2,2,Blocks.glass_pane,0);bb.buildBlock(4,2,3,Blocks.planks,1);
		bb.buildBlock(4,2,4,Blocks.planks,1);bb.buildBlock(5,2,-5,Blocks.fence,0);bb.buildBlock(5,2,5,Blocks.fence,0);
		bb.buildBlock(-5,3,-5,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,-4,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,-3,Blocks.acacia_stairs,0);
		bb.buildBlock(-5,3,-2,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,-1,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,0,Blocks.acacia_stairs,0);
		bb.buildBlock(-5,3,1,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,3,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,4,Blocks.acacia_stairs,0);
		bb.buildBlock(-5,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-4,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-4,3,-4,Blocks.planks,1);
		bb.buildBlock(-4,3,-3,Blocks.planks,1);bb.buildBlock(-4,3,-2,Blocks.planks,1);bb.buildBlock(-4,3,-1,Blocks.planks,1);
		bb.buildBlock(-4,3,0,Blocks.planks,1);bb.buildBlock(-4,3,1,Blocks.planks,1);bb.buildBlock(-4,3,2,Blocks.glass_pane,0);
		bb.buildBlock(-4,3,3,Blocks.planks,1);bb.buildBlock(-4,3,4,Blocks.planks,1);bb.buildBlock(-4,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-4,Blocks.planks,1);bb.buildBlock(-3,3,-3,Blocks.planks,1);
		bb.buildBlock(-3,3,-2,Blocks.planks,1);bb.buildBlock(-3,3,-1,Blocks.planks,1);bb.buildBlock(-3,3,0,Blocks.planks,1);
		bb.buildBlock(-3,3,1,Blocks.planks,1);bb.buildBlock(-3,3,4,Blocks.planks,1);bb.buildBlock(-3,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-2,3,-4,Blocks.planks,1);bb.buildBlock(-2,3,-3,Blocks.planks,1);
		bb.buildBlock(-2,3,-2,Blocks.planks,1);bb.buildBlock(-2,3,-1,Blocks.planks,1);bb.buildBlock(-2,3,0,Blocks.planks,1);
		bb.buildBlock(-2,3,1,Blocks.planks,1);bb.buildBlock(-2,3,4,Blocks.planks,1);bb.buildBlock(-2,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-1,3,-4,Blocks.planks,1);bb.buildBlock(-1,3,-3,Blocks.planks,0);
		bb.buildBlock(-1,3,-2,Blocks.planks,0);bb.buildBlock(-1,3,-1,Blocks.planks,0);bb.buildBlock(-1,3,0,Blocks.planks,0);
		bb.buildBlock(-1,3,1,Blocks.planks,0);bb.buildBlock(-1,3,2,Blocks.oak_stairs,0);bb.buildBlock(-1,3,3,Blocks.planks,0);
		bb.buildBlock(-1,3,4,Blocks.planks,1);bb.buildBlock(-1,3,5,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(0,3,-4,Blocks.planks,1);bb.buildBlock(0,3,-3,Blocks.planks,0);bb.buildBlock(0,3,-2,Blocks.planks,0);
		bb.buildBlock(0,3,-1,Blocks.planks,0);bb.buildBlock(0,3,0,Blocks.planks,0);bb.buildBlock(0,3,1,Blocks.planks,0);
		bb.buildBlock(0,3,2,Blocks.planks,0);bb.buildBlock(0,3,3,Blocks.planks,0);bb.buildBlock(0,3,4,Blocks.planks,1);
		bb.buildBlock(0,3,5,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(1,3,-4,Blocks.planks,1);
		bb.buildBlock(1,3,-3,Blocks.planks,0);bb.buildBlock(1,3,-2,Blocks.planks,0);bb.buildBlock(1,3,-1,Blocks.planks,0);
		bb.buildBlock(1,3,0,Blocks.planks,0);bb.buildBlock(1,3,1,Blocks.planks,0);bb.buildBlock(1,3,2,Blocks.planks,0);
		bb.buildBlock(1,3,3,Blocks.planks,0);bb.buildBlock(1,3,4,Blocks.planks,1);bb.buildBlock(1,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(2,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(2,3,-4,Blocks.planks,1);bb.buildBlock(2,3,-3,Blocks.planks,0);
		bb.buildBlock(2,3,-2,Blocks.planks,0);bb.buildBlock(2,3,-1,Blocks.planks,0);bb.buildBlock(2,3,0,Blocks.planks,0);
		bb.buildBlock(2,3,1,Blocks.planks,0);bb.buildBlock(2,3,2,Blocks.planks,0);bb.buildBlock(2,3,3,Blocks.planks,0);
		bb.buildBlock(2,3,4,Blocks.planks,1);bb.buildBlock(2,3,5,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(3,3,-4,Blocks.planks,1);bb.buildBlock(3,3,-3,Blocks.planks,0);bb.buildBlock(3,3,-2,Blocks.planks,0);
		bb.buildBlock(3,3,-1,Blocks.planks,0);bb.buildBlock(3,3,0,Blocks.planks,0);bb.buildBlock(3,3,1,Blocks.planks,0);
		bb.buildBlock(3,3,2,Blocks.planks,0);bb.buildBlock(3,3,3,Blocks.planks,0);bb.buildBlock(3,3,4,Blocks.planks,1);
		bb.buildBlock(3,3,5,Blocks.acacia_stairs,3);bb.buildBlock(4,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(4,3,-4,Blocks.planks,1);
		bb.buildBlock(4,3,-3,Blocks.planks,1);bb.buildBlock(4,3,-2,Blocks.planks,1);bb.buildBlock(4,3,-1,Blocks.planks,1);
		bb.buildBlock(4,3,0,Blocks.planks,1);bb.buildBlock(4,3,1,Blocks.planks,1);bb.buildBlock(4,3,2,Blocks.planks,1);
		bb.buildBlock(4,3,3,Blocks.planks,1);bb.buildBlock(4,3,4,Blocks.planks,1);bb.buildBlock(4,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(5,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(5,3,-4,Blocks.acacia_stairs,1);bb.buildBlock(5,3,-3,Blocks.acacia_stairs,1);
		bb.buildBlock(5,3,-2,Blocks.acacia_stairs,1);bb.buildBlock(5,3,-1,Blocks.acacia_stairs,1);bb.buildBlock(5,3,0,Blocks.acacia_stairs,1);
		bb.buildBlock(5,3,1,Blocks.acacia_stairs,1);bb.buildBlock(5,3,2,Blocks.acacia_stairs,1);bb.buildBlock(5,3,3,Blocks.acacia_stairs,1);
		bb.buildBlock(5,3,4,Blocks.acacia_stairs,1);bb.buildBlock(5,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-4,4,-4,Blocks.planks,1);
		bb.buildBlock(-4,4,-3,Blocks.planks,1);bb.buildBlock(-4,4,-2,Blocks.planks,1);bb.buildBlock(-4,4,-1,Blocks.planks,1);
		bb.buildBlock(-4,4,0,Blocks.planks,1);bb.buildBlock(-4,4,1,Blocks.planks,1);bb.buildBlock(-4,4,2,Blocks.glass_pane,0);
		bb.buildBlock(-4,4,3,Blocks.planks,1);bb.buildBlock(-4,4,4,Blocks.planks,1);bb.buildBlock(-3,4,-4,Blocks.planks,1);
		bb.buildBlock(-3,4,-3,Blocks.bed,9);bb.buildBlock(-3,4,-2,Blocks.carpet,1);bb.buildBlock(-3,4,-1,Blocks.carpet,1);
		bb.buildBlock(-3,4,0,Blocks.planks,1);bb.buildBlock(-3,4,1,Blocks.flower_pot,3);bb.addTileEntityPot(-3,4,1,38,3);
		bb.buildBlock(-3,4,4,Blocks.planks,1);bb.buildBlock(-2,4,-4,Blocks.planks,1);bb.buildBlock(-2,4,-3,Blocks.bed,1);
		bb.buildBlock(-2,4,-2,Blocks.carpet,1);bb.buildBlock(-2,4,-1,Blocks.carpet,1);bb.buildBlock(-2,4,0,Blocks.planks,1);
		bb.buildBlock(-2,4,4,Blocks.planks,1);bb.buildBlock(-1,4,-4,Blocks.planks,1);bb.buildBlock(-1,4,-3,Blocks.chest,3);
		bb.buildBlock(-1,4,-2,Blocks.carpet,1);bb.buildBlock(-1,4,-1,Blocks.carpet,1);bb.buildBlock(-1,4,0,Blocks.wooden_door,3);
		bb.buildBlock(-1,4,4,Blocks.planks,1);bb.buildBlock(0,4,-4,Blocks.planks,1);bb.buildBlock(0,4,-3,Blocks.planks,1);
		bb.buildBlock(0,4,-2,Blocks.planks,1);bb.buildBlock(0,4,-1,Blocks.planks,1);bb.buildBlock(0,4,0,Blocks.planks,1);
		bb.buildBlock(0,4,4,Blocks.planks,1);bb.buildBlock(1,4,-4,Blocks.planks,1);bb.buildBlock(1,4,-3,Blocks.chest,3);
		bb.buildBlock(1,4,-2,Blocks.carpet,1);bb.buildBlock(1,4,-1,Blocks.carpet,1);bb.buildBlock(1,4,0,Blocks.wooden_door,3);
		bb.buildBlock(1,4,4,Blocks.planks,1);bb.buildBlock(2,4,-4,Blocks.planks,1);bb.buildBlock(2,4,-3,Blocks.bed,3);
		bb.buildBlock(2,4,-2,Blocks.carpet,1);bb.buildBlock(2,4,-1,Blocks.carpet,1);bb.buildBlock(2,4,0,Blocks.planks,1);
		bb.buildBlock(2,4,4,Blocks.planks,1);bb.buildBlock(3,4,-4,Blocks.planks,1);bb.buildBlock(3,4,-3,Blocks.bed,11);
		bb.buildBlock(3,4,-2,Blocks.carpet,1);bb.buildBlock(3,4,-1,Blocks.carpet,1);bb.buildBlock(3,4,0,Blocks.planks,1);
		bb.buildBlock(3,4,1,Blocks.oak_stairs,0);bb.buildBlock(3,4,2,Blocks.flower_pot,3);bb.addTileEntityPot(3,4,2,38,3);
		bb.buildBlock(3,4,3,Blocks.oak_stairs,0);bb.buildBlock(3,4,4,Blocks.planks,1);bb.buildBlock(4,4,-4,Blocks.planks,1);
		bb.buildBlock(4,4,-3,Blocks.planks,1);bb.buildBlock(4,4,-2,Blocks.planks,1);bb.buildBlock(4,4,-1,Blocks.planks,1);
		bb.buildBlock(4,4,0,Blocks.planks,1);bb.buildBlock(4,4,1,Blocks.planks,1);bb.buildBlock(4,4,2,Blocks.planks,1);
		bb.buildBlock(4,4,3,Blocks.planks,1);bb.buildBlock(4,4,4,Blocks.planks,1);bb.buildBlock(-4,5,-4,Blocks.planks,1);
		bb.buildBlock(-4,5,-3,Blocks.planks,1);bb.buildBlock(-4,5,-2,Blocks.glass_pane,0);bb.buildBlock(-4,5,-1,Blocks.planks,1);
		bb.buildBlock(-4,5,0,Blocks.planks,1);bb.buildBlock(-4,5,1,Blocks.planks,1);bb.buildBlock(-4,5,2,Blocks.glass_pane,0);
		bb.buildBlock(-4,5,3,Blocks.planks,1);bb.buildBlock(-4,5,4,Blocks.planks,1);bb.buildBlock(-3,5,-4,Blocks.planks,1);
		bb.buildBlock(-3,5,0,Blocks.planks,1);bb.buildBlock(-3,5,4,Blocks.planks,1);bb.buildBlock(-2,5,-4,Blocks.planks,1);
		bb.buildBlock(-2,5,0,Blocks.planks,1);bb.buildBlock(-2,5,4,Blocks.planks,1);bb.buildBlock(-1,5,-4,Blocks.planks,1);
		bb.buildBlock(-1,5,0,Blocks.wooden_door,8);bb.buildBlock(-1,5,4,Blocks.planks,1);bb.buildBlock(0,5,-4,Blocks.planks,1);
		bb.buildBlock(0,5,-3,Blocks.planks,1);bb.buildBlock(0,5,-2,Blocks.planks,1);bb.buildBlock(0,5,-1,Blocks.planks,1);
		bb.buildBlock(0,5,0,Blocks.planks,1);bb.buildBlock(0,5,4,Blocks.planks,1);bb.buildBlock(1,5,-4,Blocks.planks,1);
		bb.buildBlock(1,5,0,Blocks.wooden_door,8);bb.buildBlock(1,5,4,Blocks.planks,1);bb.buildBlock(2,5,-4,Blocks.planks,1);
		bb.buildBlock(2,5,0,Blocks.planks,1);bb.buildBlock(2,5,4,Blocks.planks,1);bb.buildBlock(3,5,-4,Blocks.planks,1);
		bb.buildBlock(3,5,0,Blocks.planks,1);bb.buildBlock(3,5,4,Blocks.planks,1);bb.buildBlock(4,5,-4,Blocks.planks,1);
		bb.buildBlock(4,5,-3,Blocks.planks,1);bb.buildBlock(4,5,-2,Blocks.glass_pane,0);bb.buildBlock(4,5,-1,Blocks.planks,1);
		bb.buildBlock(4,5,0,Blocks.planks,1);bb.buildBlock(4,5,1,Blocks.planks,1);bb.buildBlock(4,5,2,Blocks.glass_pane,0);
		bb.buildBlock(4,5,3,Blocks.planks,1);bb.buildBlock(4,5,4,Blocks.planks,1);bb.buildBlock(-5,6,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,6,-4,Blocks.acacia_stairs,7);bb.buildBlock(-5,6,2,Blocks.acacia_stairs,0);bb.buildBlock(-5,6,4,Blocks.acacia_stairs,6);
		bb.buildBlock(-5,6,5,Blocks.acacia_stairs,3);bb.buildBlock(-4,6,-5,Blocks.acacia_stairs,2);bb.buildBlock(-4,6,-4,Blocks.planks,1);
		bb.buildBlock(-4,6,-3,Blocks.planks,1);bb.buildBlock(-4,6,-2,Blocks.glass_pane,0);bb.buildBlock(-4,6,-1,Blocks.planks,1);
		bb.buildBlock(-4,6,0,Blocks.planks,1);bb.buildBlock(-4,6,1,Blocks.planks,1);bb.buildBlock(-4,6,2,Blocks.planks,1);
		bb.buildBlock(-4,6,3,Blocks.planks,1);bb.buildBlock(-4,6,4,Blocks.planks,1);bb.buildBlock(-4,6,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,6,-5,Blocks.acacia_stairs,2);bb.buildBlock(-3,6,-4,Blocks.planks,1);bb.buildBlock(-3,6,0,Blocks.planks,1);
		bb.buildBlock(-3,6,4,Blocks.planks,1);bb.buildBlock(-3,6,5,Blocks.acacia_stairs,3);bb.buildBlock(-2,6,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,6,-4,Blocks.planks,1);bb.buildBlock(-2,6,0,Blocks.planks,1);bb.buildBlock(-2,6,4,Blocks.planks,1);
		bb.buildBlock(-2,6,5,Blocks.acacia_stairs,3);bb.buildBlock(-1,6,-5,Blocks.acacia_stairs,2);bb.buildBlock(-1,6,-4,Blocks.planks,1);
		bb.buildBlock(-1,6,0,Blocks.planks,1);bb.buildBlock(-1,6,1,Blocks.wall_sign,3);bb.addTileEntitySign(-1,6,1,"Room One","","","");
		bb.buildBlock(-1,6,4,Blocks.planks,1);bb.buildBlock(-1,6,5,Blocks.acacia_stairs,3);bb.buildBlock(0,6,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(0,6,-4,Blocks.planks,1);bb.buildBlock(0,6,-3,Blocks.planks,1);bb.buildBlock(0,6,-2,Blocks.planks,1);
		bb.buildBlock(0,6,-1,Blocks.planks,1);bb.buildBlock(0,6,0,Blocks.planks,1);bb.buildBlock(0,6,4,Blocks.planks,1);
		bb.buildBlock(0,6,5,Blocks.acacia_stairs,3);bb.buildBlock(1,6,-5,Blocks.acacia_stairs,2);bb.buildBlock(1,6,-4,Blocks.planks,1);
		bb.buildBlock(1,6,0,Blocks.planks,1);bb.buildBlock(1,6,1,Blocks.wall_sign,3);bb.addTileEntitySign(1,6,1,"Room Two","","","");
		bb.buildBlock(1,6,4,Blocks.planks,1);bb.buildBlock(1,6,5,Blocks.acacia_stairs,3);bb.buildBlock(2,6,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(2,6,-4,Blocks.planks,1);bb.buildBlock(2,6,0,Blocks.planks,1);bb.buildBlock(2,6,4,Blocks.planks,1);
		bb.buildBlock(2,6,5,Blocks.acacia_stairs,3);bb.buildBlock(3,6,-5,Blocks.acacia_stairs,2);bb.buildBlock(3,6,-4,Blocks.planks,1);
		bb.buildBlock(3,6,0,Blocks.planks,1);bb.buildBlock(3,6,4,Blocks.planks,1);bb.buildBlock(3,6,5,Blocks.acacia_stairs,3);
		bb.buildBlock(4,6,-5,Blocks.acacia_stairs,2);bb.buildBlock(4,6,-4,Blocks.planks,1);bb.buildBlock(4,6,-3,Blocks.planks,1);
		bb.buildBlock(4,6,-2,Blocks.glass_pane,0);bb.buildBlock(4,6,-1,Blocks.planks,1);bb.buildBlock(4,6,0,Blocks.planks,1);
		bb.buildBlock(4,6,1,Blocks.planks,1);bb.buildBlock(4,6,2,Blocks.glass_pane,0);bb.buildBlock(4,6,3,Blocks.planks,1);
		bb.buildBlock(4,6,4,Blocks.planks,1);bb.buildBlock(4,6,5,Blocks.acacia_stairs,3);bb.buildBlock(5,6,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(5,6,-4,Blocks.acacia_stairs,7);bb.buildBlock(5,6,4,Blocks.acacia_stairs,6);bb.buildBlock(5,6,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-5,7,-4,Blocks.acacia_stairs,2);bb.buildBlock(-5,7,-3,Blocks.acacia_stairs,7);bb.buildBlock(-5,7,3,Blocks.acacia_stairs,6);
		bb.buildBlock(-5,7,4,Blocks.acacia_stairs,3);bb.buildBlock(-4,7,-4,Blocks.acacia_stairs,2);bb.buildBlock(-4,7,-3,Blocks.planks,1);
		bb.buildBlock(-4,7,-2,Blocks.planks,1);bb.buildBlock(-4,7,-1,Blocks.planks,1);bb.buildBlock(-4,7,0,Blocks.planks,1);
		bb.buildBlock(-4,7,1,Blocks.planks,1);bb.buildBlock(-4,7,2,Blocks.planks,1);bb.buildBlock(-4,7,3,Blocks.planks,1);
		bb.buildBlock(-4,7,4,Blocks.acacia_stairs,3);bb.buildBlock(-3,7,-4,Blocks.acacia_stairs,2);bb.buildBlock(-3,7,-3,Blocks.acacia_stairs,7);
		bb.buildBlock(-3,7,0,Blocks.planks,1);bb.buildBlock(-3,7,3,Blocks.acacia_stairs,6);bb.buildBlock(-3,7,4,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,7,-4,Blocks.acacia_stairs,2);bb.buildBlock(-2,7,-3,Blocks.acacia_stairs,7);bb.buildBlock(-2,7,0,Blocks.planks,1);
		bb.buildBlock(-2,7,3,Blocks.acacia_stairs,6);bb.buildBlock(-2,7,4,Blocks.acacia_stairs,3);bb.buildBlock(-1,7,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,7,-3,Blocks.acacia_stairs,7);bb.buildBlock(-1,7,0,Blocks.planks,1);bb.buildBlock(-1,7,3,Blocks.acacia_stairs,6);
		bb.buildBlock(-1,7,4,Blocks.acacia_stairs,3);bb.buildBlock(0,7,-4,Blocks.acacia_stairs,2);bb.buildBlock(0,7,-3,Blocks.planks,1);
		bb.buildBlock(0,7,-2,Blocks.planks,1);bb.buildBlock(0,7,-1,Blocks.planks,1);bb.buildBlock(0,7,0,Blocks.planks,1);
		bb.buildBlock(0,7,3,Blocks.acacia_stairs,6);bb.buildBlock(0,7,4,Blocks.acacia_stairs,3);bb.buildBlock(1,7,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(1,7,-3,Blocks.acacia_stairs,7);bb.buildBlock(1,7,0,Blocks.planks,1);bb.buildBlock(1,7,3,Blocks.acacia_stairs,6);
		bb.buildBlock(1,7,4,Blocks.acacia_stairs,3);bb.buildBlock(2,7,-4,Blocks.acacia_stairs,2);bb.buildBlock(2,7,-3,Blocks.acacia_stairs,7);
		bb.buildBlock(2,7,0,Blocks.planks,1);bb.buildBlock(2,7,3,Blocks.acacia_stairs,6);bb.buildBlock(2,7,4,Blocks.acacia_stairs,3);
		bb.buildBlock(3,7,-4,Blocks.acacia_stairs,2);bb.buildBlock(3,7,-3,Blocks.acacia_stairs,7);bb.buildBlock(3,7,0,Blocks.planks,1);
		bb.buildBlock(3,7,3,Blocks.acacia_stairs,6);bb.buildBlock(3,7,4,Blocks.acacia_stairs,3);bb.buildBlock(4,7,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(4,7,-3,Blocks.planks,1);bb.buildBlock(4,7,-2,Blocks.planks,1);bb.buildBlock(4,7,-1,Blocks.planks,1);
		bb.buildBlock(4,7,0,Blocks.planks,1);bb.buildBlock(4,7,1,Blocks.planks,1);bb.buildBlock(4,7,2,Blocks.planks,1);
		bb.buildBlock(4,7,3,Blocks.planks,1);bb.buildBlock(4,7,4,Blocks.acacia_stairs,3);bb.buildBlock(5,7,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(5,7,-3,Blocks.acacia_stairs,7);bb.buildBlock(5,7,3,Blocks.acacia_stairs,6);bb.buildBlock(5,7,4,Blocks.acacia_stairs,3);
		bb.buildBlock(-5,8,-3,Blocks.acacia_stairs,2);bb.buildBlock(-5,8,-2,Blocks.acacia_stairs,7);bb.buildBlock(-5,8,2,Blocks.acacia_stairs,6);
		bb.buildBlock(-5,8,3,Blocks.acacia_stairs,3);bb.buildBlock(-4,8,-3,Blocks.acacia_stairs,2);bb.buildBlock(-4,8,-2,Blocks.planks,1);
		bb.buildBlock(-4,8,-1,Blocks.planks,1);bb.buildBlock(-4,8,0,Blocks.planks,1);bb.buildBlock(-4,8,1,Blocks.planks,1);
		bb.buildBlock(-4,8,2,Blocks.planks,1);bb.buildBlock(-4,8,3,Blocks.acacia_stairs,3);bb.buildBlock(-3,8,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,8,-2,Blocks.acacia_stairs,7);bb.buildBlock(-3,8,0,Blocks.planks,1);bb.buildBlock(-3,8,2,Blocks.acacia_stairs,6);
		bb.buildBlock(-3,8,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,8,-3,Blocks.acacia_stairs,2);bb.buildBlock(-2,8,-2,Blocks.acacia_stairs,7);
		bb.buildBlock(-2,8,0,Blocks.planks,1);bb.buildBlock(-2,8,2,Blocks.acacia_stairs,6);bb.buildBlock(-2,8,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,8,-3,Blocks.acacia_stairs,2);bb.buildBlock(-1,8,-2,Blocks.acacia_stairs,7);bb.buildBlock(-1,8,0,Blocks.planks,1);
		bb.buildBlock(-1,8,2,Blocks.acacia_stairs,6);bb.buildBlock(-1,8,3,Blocks.acacia_stairs,3);bb.buildBlock(0,8,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(0,8,-2,Blocks.planks,1);bb.buildBlock(0,8,-1,Blocks.planks,1);bb.buildBlock(0,8,0,Blocks.planks,1);
		bb.buildBlock(0,8,2,Blocks.acacia_stairs,6);bb.buildBlock(0,8,3,Blocks.acacia_stairs,3);bb.buildBlock(1,8,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(1,8,-2,Blocks.acacia_stairs,7);bb.buildBlock(1,8,0,Blocks.planks,1);bb.buildBlock(1,8,2,Blocks.acacia_stairs,6);
		bb.buildBlock(1,8,3,Blocks.acacia_stairs,3);bb.buildBlock(2,8,-3,Blocks.acacia_stairs,2);bb.buildBlock(2,8,-2,Blocks.acacia_stairs,7);
		bb.buildBlock(2,8,0,Blocks.planks,1);bb.buildBlock(2,8,2,Blocks.acacia_stairs,6);bb.buildBlock(2,8,3,Blocks.acacia_stairs,3);
		bb.buildBlock(3,8,-3,Blocks.acacia_stairs,2);bb.buildBlock(3,8,-2,Blocks.acacia_stairs,7);bb.buildBlock(3,8,0,Blocks.planks,1);
		bb.buildBlock(3,8,2,Blocks.acacia_stairs,6);bb.buildBlock(3,8,3,Blocks.acacia_stairs,3);bb.buildBlock(4,8,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(4,8,-2,Blocks.planks,1);bb.buildBlock(4,8,-1,Blocks.planks,1);bb.buildBlock(4,8,0,Blocks.planks,1);
		bb.buildBlock(4,8,1,Blocks.planks,1);bb.buildBlock(4,8,2,Blocks.planks,1);bb.buildBlock(4,8,3,Blocks.acacia_stairs,3);
		bb.buildBlock(5,8,-3,Blocks.acacia_stairs,2);bb.buildBlock(5,8,-2,Blocks.acacia_stairs,7);bb.buildBlock(5,8,2,Blocks.acacia_stairs,6);
		bb.buildBlock(5,8,3,Blocks.acacia_stairs,3);bb.buildBlock(-5,9,-2,Blocks.acacia_stairs,2);bb.buildBlock(-5,9,-1,Blocks.acacia_stairs,7);
		bb.buildBlock(-5,9,1,Blocks.acacia_stairs,6);bb.buildBlock(-5,9,2,Blocks.acacia_stairs,3);bb.buildBlock(-4,9,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,9,-1,Blocks.planks,1);bb.buildBlock(-4,9,0,Blocks.planks,1);bb.buildBlock(-4,9,1,Blocks.planks,1);
		bb.buildBlock(-4,9,2,Blocks.acacia_stairs,3);bb.buildBlock(-3,9,-2,Blocks.acacia_stairs,2);bb.buildBlock(-3,9,-1,Blocks.acacia_stairs,7);
		bb.buildBlock(-3,9,0,Blocks.planks,1);bb.buildBlock(-3,9,1,Blocks.acacia_stairs,6);bb.buildBlock(-3,9,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,9,-2,Blocks.acacia_stairs,2);bb.buildBlock(-2,9,-1,Blocks.acacia_stairs,7);bb.buildBlock(-2,9,0,Blocks.planks,1);
		bb.buildBlock(-2,9,1,Blocks.acacia_stairs,6);bb.buildBlock(-2,9,2,Blocks.acacia_stairs,3);bb.buildBlock(-1,9,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,9,-1,Blocks.acacia_stairs,7);bb.buildBlock(-1,9,0,Blocks.planks,1);bb.buildBlock(-1,9,1,Blocks.acacia_stairs,6);
		bb.buildBlock(-1,9,2,Blocks.acacia_stairs,3);bb.buildBlock(0,9,-2,Blocks.acacia_stairs,2);bb.buildBlock(0,9,-1,Blocks.planks,1);
		bb.buildBlock(0,9,0,Blocks.planks,1);bb.buildBlock(0,9,1,Blocks.acacia_stairs,6);bb.buildBlock(0,9,2,Blocks.acacia_stairs,3);
		bb.buildBlock(1,9,-2,Blocks.acacia_stairs,2);bb.buildBlock(1,9,-1,Blocks.acacia_stairs,7);bb.buildBlock(1,9,0,Blocks.planks,1);
		bb.buildBlock(1,9,1,Blocks.acacia_stairs,6);bb.buildBlock(1,9,2,Blocks.acacia_stairs,3);bb.buildBlock(2,9,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(2,9,-1,Blocks.acacia_stairs,7);bb.buildBlock(2,9,0,Blocks.planks,1);bb.buildBlock(2,9,1,Blocks.acacia_stairs,6);
		bb.buildBlock(2,9,2,Blocks.acacia_stairs,3);bb.buildBlock(3,9,-2,Blocks.acacia_stairs,2);bb.buildBlock(3,9,-1,Blocks.acacia_stairs,7);
		bb.buildBlock(3,9,0,Blocks.planks,1);bb.buildBlock(3,9,1,Blocks.acacia_stairs,6);bb.buildBlock(3,9,2,Blocks.acacia_stairs,3);
		bb.buildBlock(4,9,-2,Blocks.acacia_stairs,2);bb.buildBlock(4,9,-1,Blocks.planks,1);bb.buildBlock(4,9,0,Blocks.planks,1);
		bb.buildBlock(4,9,1,Blocks.planks,1);bb.buildBlock(4,9,2,Blocks.acacia_stairs,3);bb.buildBlock(5,9,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(5,9,-1,Blocks.acacia_stairs,7);bb.buildBlock(5,9,1,Blocks.acacia_stairs,6);bb.buildBlock(5,9,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-5,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(-5,10,0,Blocks.double_wooden_slab,4);bb.buildBlock(-5,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-4,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(-4,10,0,Blocks.planks,1);bb.buildBlock(-4,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(-3,10,0,Blocks.planks,1);bb.buildBlock(-3,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(-2,10,0,Blocks.planks,1);bb.buildBlock(-2,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(-1,10,0,Blocks.planks,1);bb.buildBlock(-1,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(0,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(0,10,0,Blocks.planks,1);bb.buildBlock(0,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(1,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(1,10,0,Blocks.planks,1);bb.buildBlock(1,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(2,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(2,10,0,Blocks.planks,1);bb.buildBlock(2,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(3,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(3,10,0,Blocks.planks,1);bb.buildBlock(3,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(4,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(4,10,0,Blocks.planks,1);bb.buildBlock(4,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(5,10,-1,Blocks.acacia_stairs,2);bb.buildBlock(5,10,0,Blocks.double_wooden_slab,4);bb.buildBlock(5,10,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-5,11,0,Blocks.acacia_stairs,0);bb.buildBlock(-4,11,0,Blocks.wooden_slab,4);bb.buildBlock(-3,11,0,Blocks.wooden_slab,4);
		bb.buildBlock(-2,11,0,Blocks.wooden_slab,4);bb.buildBlock(-1,11,0,Blocks.wooden_slab,4);bb.buildBlock(0,11,0,Blocks.wooden_slab,4);
		bb.buildBlock(1,11,0,Blocks.wooden_slab,4);bb.buildBlock(2,11,0,Blocks.wooden_slab,4);bb.buildBlock(3,11,0,Blocks.wooden_slab,4);
		bb.buildBlock(4,11,0,Blocks.wooden_slab,4);bb.buildBlock(5,11,0,Blocks.acacia_stairs,1);bb.buildBlock(-3,2,0,Blocks.torch,1);
		bb.buildBlock(-2,2,-3,Blocks.torch,2);bb.buildBlock(-2,2,0,Blocks.torch,2);bb.buildBlock(-1,2,2,Blocks.torch,1);
		bb.buildBlock(0,2,-3,Blocks.torch,1);bb.buildBlock(0,2,1,Blocks.torch,1);bb.buildBlock(3,2,-3,Blocks.torch,2);
		bb.buildBlock(3,2,0,Blocks.torch,2);bb.buildBlock(-3,6,3,Blocks.torch,4);bb.buildBlock(3,6,3,Blocks.torch,4);
		bb.buildBlock(-3,8,-1,Blocks.torch,1);bb.buildBlock(-3,8,1,Blocks.torch,1);bb.buildBlock(-1,8,-1,Blocks.torch,2);
		bb.buildBlock(0,8,1,Blocks.torch,3);bb.buildBlock(1,8,-1,Blocks.torch,1);bb.buildBlock(3,8,-1,Blocks.torch,2);
		bb.buildBlock(3,8,1,Blocks.torch,2);bb.addEntityPainting(0,6,-2,3,"Kebab");
		bb.addEntityPainting(0,6,-2,1,"Wasteland");
		bb.addEntityPainting(-2,1,2,3,"Alban");
		bb.addEntityPainting(-1,1,0,3,"Sea");
		bb.addEntityItemFrame(4,1,1,3,ModBlocks.blockSmallHotel);
	}

}
