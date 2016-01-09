package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionVillageElder;

import net.minecraft.init.Blocks;

public class BuildingVillageCenter extends Building {

	@Override
	public String getName() {
		return "Village Center";
	}

	@Override
	public String getDescription() {
		return "Welcome to the Village Center! Starting your cute village from here....";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionVillageElder.class,-1,-1);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,2,Blocks.planks,0);bb.buildBlock(-3,-1,3,Blocks.planks,0);bb.buildBlock(-2,-1,-3,Blocks.planks,0);
		bb.buildBlock(-2,-1,-2,Blocks.planks,0);bb.buildBlock(-2,-1,-1,Blocks.planks,0);bb.buildBlock(-2,-1,0,Blocks.planks,0);
		bb.buildBlock(-2,-1,1,Blocks.planks,0);bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-2,-1,3,Blocks.planks,0);
		bb.buildBlock(-1,-1,-3,Blocks.planks,0);bb.buildBlock(-1,-1,-2,Blocks.planks,0);bb.buildBlock(-1,-1,-1,Blocks.planks,0);
		bb.buildBlock(-1,-1,0,Blocks.planks,0);bb.buildBlock(-1,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,3,Blocks.planks,0);
		bb.buildBlock(0,-1,-3,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.planks,0);bb.buildBlock(0,-1,3,Blocks.planks,0);
		bb.buildBlock(1,-1,-3,Blocks.planks,0);bb.buildBlock(1,-1,-2,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);
		bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(1,-1,3,Blocks.planks,0);bb.buildBlock(2,-1,-3,Blocks.planks,0);
		bb.buildBlock(2,-1,-2,Blocks.planks,0);bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(2,-1,2,Blocks.planks,0);
		bb.buildBlock(2,-1,3,Blocks.planks,0);bb.buildBlock(3,-1,-3,Blocks.planks,0);bb.buildBlock(3,-1,-2,Blocks.planks,0);
		bb.buildBlock(3,-1,-1,Blocks.planks,0);bb.buildBlock(-4,0,-4,Blocks.planks,1);bb.buildBlock(-4,0,-3,Blocks.planks,1);
		bb.buildBlock(-4,0,-2,Blocks.planks,1);bb.buildBlock(-4,0,-1,Blocks.planks,1);bb.buildBlock(-4,0,0,Blocks.planks,1);
		bb.buildBlock(-4,0,1,Blocks.planks,1);bb.buildBlock(-4,0,2,Blocks.planks,1);bb.buildBlock(-4,0,3,Blocks.planks,1);
		bb.buildBlock(-4,0,4,Blocks.planks,1);bb.buildBlock(-3,0,-4,Blocks.planks,1);bb.buildBlock(-3,0,-3,Blocks.planks,4);
		bb.buildBlock(-3,0,-2,Blocks.planks,1);bb.buildBlock(-3,0,-1,Blocks.planks,1);bb.buildBlock(-3,0,0,Blocks.planks,1);
		bb.buildBlock(-3,0,1,Blocks.planks,1);bb.buildBlock(-3,0,3,Blocks.planks,1);bb.buildBlock(-3,0,4,Blocks.planks,1);
		bb.buildBlock(-2,0,-4,Blocks.planks,1);bb.buildBlock(-2,0,1,Blocks.wooden_door,1);bb.buildBlock(-2,0,4,Blocks.planks,1);
		bb.buildBlock(-1,0,-4,Blocks.planks,1);bb.buildBlock(-1,0,1,Blocks.planks,1);bb.buildBlock(-1,0,4,Blocks.planks,1);
		bb.buildBlock(0,0,-4,Blocks.planks,1);bb.buildBlock(0,0,-3,Blocks.carpet,14);bb.buildBlock(0,0,-2,Blocks.planks,1);
		bb.buildBlock(0,0,-1,Blocks.planks,1);bb.buildBlock(0,0,0,Blocks.planks,1);bb.buildBlock(0,0,1,Blocks.planks,1);
		bb.buildBlock(0,0,4,Blocks.planks,1);bb.buildBlock(1,0,-4,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.carpet,14);
		bb.buildBlock(1,0,-2,Blocks.carpet,14);bb.buildBlock(1,0,-1,Blocks.carpet,14);bb.buildBlock(1,0,0,Blocks.acacia_stairs,2);
		bb.buildBlock(1,0,1,Blocks.planks,1);bb.buildBlock(1,0,2,Blocks.bed,3);bb.buildBlock(1,0,4,Blocks.planks,1);
		bb.buildBlock(2,0,-4,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.carpet,14);bb.buildBlock(2,0,-2,Blocks.carpet,14);
		bb.buildBlock(2,0,-1,Blocks.carpet,14);bb.buildBlock(2,0,0,Blocks.acacia_stairs,2);bb.buildBlock(2,0,1,Blocks.planks,1);
		bb.buildBlock(2,0,2,Blocks.bed,11);bb.buildBlock(2,0,3,Blocks.chest,4);bb.buildBlock(2,0,4,Blocks.planks,1);bb.buildBlock(3,0,-4,Blocks.planks,1);bb.buildBlock(3,0,-3,Blocks.carpet,14);
		bb.buildBlock(3,0,-2,Blocks.carpet,14);bb.buildBlock(3,0,-1,Blocks.carpet,14);bb.buildBlock(3,0,0,Blocks.acacia_stairs,2);
		bb.buildBlock(3,0,1,Blocks.planks,1);bb.buildBlock(3,0,2,Blocks.planks,1);bb.buildBlock(3,0,3,Blocks.planks,1);
		bb.buildBlock(3,0,4,Blocks.planks,1);bb.buildBlock(4,0,-4,Blocks.planks,1);bb.buildBlock(4,0,-3,Blocks.planks,1);
		bb.buildBlock(4,0,-2,Blocks.wooden_door,2);bb.buildBlock(4,0,-1,Blocks.planks,1);bb.buildBlock(4,0,0,Blocks.planks,1);
		bb.buildBlock(4,0,1,Blocks.planks,1);bb.buildBlock(4,0,2,Blocks.planks,1);bb.buildBlock(4,0,3,Blocks.planks,1);
		bb.buildBlock(4,0,4,Blocks.planks,1);bb.buildBlock(-4,1,-4,Blocks.planks,1);bb.buildBlock(-4,1,-3,Blocks.planks,1);
		bb.buildBlock(-4,1,-2,Blocks.planks,1);bb.buildBlock(-4,1,-1,Blocks.planks,1);bb.buildBlock(-4,1,0,Blocks.planks,1);
		bb.buildBlock(-4,1,1,Blocks.planks,1);bb.buildBlock(-4,1,2,Blocks.planks,1);bb.buildBlock(-4,1,3,Blocks.planks,1);
		bb.buildBlock(-4,1,4,Blocks.planks,1);bb.buildBlock(-3,1,-4,Blocks.planks,1);bb.buildBlock(-3,1,-3,Blocks.planks,4);
		bb.buildBlock(-3,1,-2,Blocks.bookshelf,0);bb.buildBlock(-3,1,-1,Blocks.bookshelf,0);bb.buildBlock(-3,1,0,Blocks.bookshelf,0);
		bb.buildBlock(-3,1,1,Blocks.planks,1);bb.buildBlock(-3,1,3,Blocks.flower_pot,1);bb.addTileEntityPot(-3,1,3,38,1);
		bb.buildBlock(-3,1,4,Blocks.planks,1);bb.buildBlock(-2,1,-4,Blocks.planks,1);bb.buildBlock(-2,1,1,Blocks.wooden_door,8);
		bb.buildBlock(-2,1,4,Blocks.planks,1);bb.buildBlock(-1,1,-4,Blocks.glass_pane,0);bb.buildBlock(-1,1,1,Blocks.planks,1);
		bb.buildBlock(-1,1,4,Blocks.glass_pane,0);bb.buildBlock(0,1,-4,Blocks.glass_pane,0);bb.buildBlock(0,1,1,Blocks.planks,1);
		bb.buildBlock(0,1,4,Blocks.glass_pane,0);bb.buildBlock(1,1,-4,Blocks.glass_pane,0);bb.buildBlock(1,1,1,Blocks.planks,1);
		bb.buildBlock(1,1,4,Blocks.planks,1);bb.buildBlock(2,1,-4,Blocks.planks,1);bb.buildBlock(2,1,1,Blocks.planks,1);
		bb.buildBlock(2,1,4,Blocks.planks,1);bb.buildBlock(3,1,-4,Blocks.planks,1);bb.buildBlock(3,1,1,Blocks.planks,1);
		bb.buildBlock(3,1,2,Blocks.bookshelf,0);bb.buildBlock(3,1,3,Blocks.bookshelf,0);bb.buildBlock(3,1,4,Blocks.planks,1);
		bb.buildBlock(4,1,-4,Blocks.planks,1);bb.buildBlock(4,1,-3,Blocks.planks,1);bb.buildBlock(4,1,-2,Blocks.wooden_door,8);
		bb.buildBlock(4,1,-1,Blocks.planks,1);bb.buildBlock(4,1,0,Blocks.planks,1);bb.buildBlock(4,1,1,Blocks.planks,1);
		bb.buildBlock(4,1,2,Blocks.planks,1);bb.buildBlock(4,1,3,Blocks.planks,1);bb.buildBlock(4,1,4,Blocks.planks,1);
		bb.buildBlock(-4,2,-4,Blocks.planks,1);bb.buildBlock(-4,2,-3,Blocks.planks,1);bb.buildBlock(-4,2,-2,Blocks.planks,1);
		bb.buildBlock(-4,2,-1,Blocks.planks,1);bb.buildBlock(-4,2,0,Blocks.planks,1);bb.buildBlock(-4,2,1,Blocks.planks,1);
		bb.buildBlock(-4,2,2,Blocks.planks,1);bb.buildBlock(-4,2,3,Blocks.planks,1);bb.buildBlock(-4,2,4,Blocks.planks,1);
		bb.buildBlock(-3,2,-4,Blocks.planks,1);bb.buildBlock(-3,2,1,Blocks.planks,1);bb.buildBlock(-3,2,3,Blocks.planks,1);
		bb.buildBlock(-3,2,4,Blocks.planks,1);bb.buildBlock(-2,2,-4,Blocks.planks,1);bb.buildBlock(-2,2,1,Blocks.planks,1);
		bb.buildBlock(-2,2,4,Blocks.planks,1);bb.buildBlock(-1,2,-4,Blocks.planks,1);bb.buildBlock(-1,2,1,Blocks.planks,1);
		bb.buildBlock(-1,2,4,Blocks.planks,1);bb.buildBlock(0,2,-4,Blocks.planks,1);bb.buildBlock(0,2,1,Blocks.planks,1);
		bb.buildBlock(0,2,4,Blocks.planks,1);bb.buildBlock(1,2,-4,Blocks.planks,1);bb.buildBlock(1,2,1,Blocks.planks,1);
		bb.buildBlock(1,2,4,Blocks.planks,1);bb.buildBlock(2,2,-4,Blocks.planks,1);bb.buildBlock(2,2,1,Blocks.planks,1);
		bb.buildBlock(2,2,4,Blocks.planks,1);bb.buildBlock(3,2,-4,Blocks.planks,1);bb.buildBlock(3,2,1,Blocks.planks,1);
		bb.buildBlock(3,2,4,Blocks.planks,1);bb.buildBlock(4,2,-4,Blocks.planks,1);bb.buildBlock(4,2,-3,Blocks.planks,1);
		bb.buildBlock(4,2,-2,Blocks.planks,1);bb.buildBlock(4,2,-1,Blocks.planks,1);bb.buildBlock(4,2,0,Blocks.planks,1);
		bb.buildBlock(4,2,1,Blocks.planks,1);bb.buildBlock(4,2,2,Blocks.planks,1);bb.buildBlock(4,2,3,Blocks.planks,1);
		bb.buildBlock(4,2,4,Blocks.planks,1);bb.buildBlock(-5,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-5,3,-4,Blocks.acacia_stairs,7);
		bb.buildBlock(-5,3,4,Blocks.acacia_stairs,6);bb.buildBlock(-5,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-4,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,3,-4,Blocks.planks,1);bb.buildBlock(-4,3,-3,Blocks.planks,1);bb.buildBlock(-4,3,-2,Blocks.planks,1);
		bb.buildBlock(-4,3,-1,Blocks.glass_pane,0);bb.buildBlock(-4,3,0,Blocks.glass_pane,0);bb.buildBlock(-4,3,1,Blocks.planks,1);
		bb.buildBlock(-4,3,2,Blocks.planks,1);bb.buildBlock(-4,3,3,Blocks.planks,1);bb.buildBlock(-4,3,4,Blocks.planks,1);
		bb.buildBlock(-4,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-3,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-4,Blocks.planks,1);
		bb.buildBlock(-3,3,-3,Blocks.planks,1);bb.buildBlock(-3,3,1,Blocks.planks,1);bb.buildBlock(-3,3,3,Blocks.planks,1);
		bb.buildBlock(-3,3,4,Blocks.planks,1);bb.buildBlock(-3,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-2,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,3,-4,Blocks.planks,1);bb.buildBlock(-2,3,-3,Blocks.planks,1);bb.buildBlock(-2,3,1,Blocks.planks,1);
		bb.buildBlock(-2,3,3,Blocks.planks,1);bb.buildBlock(-2,3,4,Blocks.planks,1);bb.buildBlock(-2,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-1,3,-4,Blocks.planks,1);bb.buildBlock(-1,3,-3,Blocks.planks,1);
		bb.buildBlock(-1,3,1,Blocks.planks,1);bb.buildBlock(-1,3,3,Blocks.planks,1);bb.buildBlock(-1,3,4,Blocks.planks,1);
		bb.buildBlock(-1,3,5,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(0,3,-4,Blocks.planks,1);
		bb.buildBlock(0,3,-3,Blocks.planks,1);bb.buildBlock(0,3,1,Blocks.planks,1);bb.buildBlock(0,3,3,Blocks.planks,1);
		bb.buildBlock(0,3,4,Blocks.planks,1);bb.buildBlock(0,3,5,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(1,3,-4,Blocks.planks,1);bb.buildBlock(1,3,-3,Blocks.planks,1);bb.buildBlock(1,3,1,Blocks.planks,1);
		bb.buildBlock(1,3,3,Blocks.planks,1);bb.buildBlock(1,3,4,Blocks.planks,1);bb.buildBlock(1,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(2,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(2,3,-4,Blocks.planks,1);bb.buildBlock(2,3,-3,Blocks.planks,1);
		bb.buildBlock(2,3,1,Blocks.planks,1);bb.buildBlock(2,3,3,Blocks.planks,1);bb.buildBlock(2,3,4,Blocks.planks,1);
		bb.buildBlock(2,3,5,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(3,3,-4,Blocks.planks,1);
		bb.buildBlock(3,3,-3,Blocks.planks,1);bb.buildBlock(3,3,1,Blocks.planks,1);bb.buildBlock(3,3,3,Blocks.planks,1);
		bb.buildBlock(3,3,4,Blocks.planks,1);bb.buildBlock(3,3,5,Blocks.acacia_stairs,3);bb.buildBlock(4,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(4,3,-4,Blocks.planks,1);bb.buildBlock(4,3,-3,Blocks.planks,1);bb.buildBlock(4,3,-2,Blocks.planks,1);
		bb.buildBlock(4,3,-1,Blocks.planks,1);bb.buildBlock(4,3,0,Blocks.planks,1);bb.buildBlock(4,3,1,Blocks.planks,1);
		bb.buildBlock(4,3,2,Blocks.planks,1);bb.buildBlock(4,3,3,Blocks.planks,1);bb.buildBlock(4,3,4,Blocks.planks,1);
		bb.buildBlock(4,3,5,Blocks.acacia_stairs,3);bb.buildBlock(5,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(5,3,-4,Blocks.acacia_stairs,7);
		bb.buildBlock(5,3,4,Blocks.acacia_stairs,6);bb.buildBlock(5,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-5,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,4,-3,Blocks.acacia_stairs,7);bb.buildBlock(-5,4,3,Blocks.acacia_stairs,6);bb.buildBlock(-5,4,4,Blocks.acacia_stairs,3);
		bb.buildBlock(-4,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(-4,4,-3,Blocks.planks,1);bb.buildBlock(-4,4,-2,Blocks.planks,1);
		bb.buildBlock(-4,4,-1,Blocks.planks,1);bb.buildBlock(-4,4,0,Blocks.planks,1);bb.buildBlock(-4,4,1,Blocks.planks,1);
		bb.buildBlock(-4,4,2,Blocks.planks,1);bb.buildBlock(-4,4,3,Blocks.planks,1);bb.buildBlock(-4,4,4,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(-3,4,-3,Blocks.planks,1);bb.buildBlock(-3,4,-2,Blocks.planks,1);
		bb.buildBlock(-3,4,1,Blocks.planks,1);bb.buildBlock(-3,4,2,Blocks.planks,1);bb.buildBlock(-3,4,3,Blocks.planks,1);
		bb.buildBlock(-3,4,4,Blocks.acacia_stairs,3);bb.buildBlock(-2,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(-2,4,-3,Blocks.planks,1);
		bb.buildBlock(-2,4,-2,Blocks.planks,1);bb.buildBlock(-2,4,1,Blocks.planks,1);bb.buildBlock(-2,4,2,Blocks.planks,1);
		bb.buildBlock(-2,4,3,Blocks.planks,1);bb.buildBlock(-2,4,4,Blocks.acacia_stairs,3);bb.buildBlock(-1,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,4,-3,Blocks.planks,1);bb.buildBlock(-1,4,-2,Blocks.planks,1);bb.buildBlock(-1,4,1,Blocks.planks,1);
		bb.buildBlock(-1,4,2,Blocks.planks,1);bb.buildBlock(-1,4,3,Blocks.planks,1);bb.buildBlock(-1,4,4,Blocks.acacia_stairs,3);
		bb.buildBlock(0,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(0,4,-3,Blocks.planks,1);bb.buildBlock(0,4,-2,Blocks.planks,1);
		bb.buildBlock(0,4,1,Blocks.planks,1);bb.buildBlock(0,4,2,Blocks.planks,1);bb.buildBlock(0,4,3,Blocks.planks,1);
		bb.buildBlock(0,4,4,Blocks.acacia_stairs,3);bb.buildBlock(1,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(1,4,-3,Blocks.planks,1);
		bb.buildBlock(1,4,-2,Blocks.planks,1);bb.buildBlock(1,4,1,Blocks.planks,1);bb.buildBlock(1,4,2,Blocks.planks,1);
		bb.buildBlock(1,4,3,Blocks.planks,1);bb.buildBlock(1,4,4,Blocks.acacia_stairs,3);bb.buildBlock(2,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(2,4,-3,Blocks.planks,1);bb.buildBlock(2,4,-2,Blocks.planks,1);bb.buildBlock(2,4,1,Blocks.planks,1);
		bb.buildBlock(2,4,2,Blocks.planks,1);bb.buildBlock(2,4,3,Blocks.planks,1);bb.buildBlock(2,4,4,Blocks.acacia_stairs,3);
		bb.buildBlock(3,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(3,4,-3,Blocks.planks,1);bb.buildBlock(3,4,-2,Blocks.planks,1);
		bb.buildBlock(3,4,1,Blocks.planks,1);bb.buildBlock(3,4,2,Blocks.planks,1);bb.buildBlock(3,4,3,Blocks.planks,1);
		bb.buildBlock(3,4,4,Blocks.acacia_stairs,3);bb.buildBlock(4,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(4,4,-3,Blocks.planks,1);
		bb.buildBlock(4,4,-2,Blocks.planks,1);bb.buildBlock(4,4,-1,Blocks.planks,1);bb.buildBlock(4,4,0,Blocks.planks,1);
		bb.buildBlock(4,4,1,Blocks.planks,1);bb.buildBlock(4,4,2,Blocks.planks,1);bb.buildBlock(4,4,3,Blocks.planks,1);
		bb.buildBlock(4,4,4,Blocks.acacia_stairs,3);bb.buildBlock(5,4,-4,Blocks.acacia_stairs,2);bb.buildBlock(5,4,-3,Blocks.acacia_stairs,7);
		bb.buildBlock(5,4,3,Blocks.acacia_stairs,6);bb.buildBlock(5,4,4,Blocks.acacia_stairs,3);bb.buildBlock(-5,5,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,5,-2,Blocks.acacia_stairs,7);bb.buildBlock(-5,5,2,Blocks.acacia_stairs,6);bb.buildBlock(-5,5,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-4,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(-4,5,-2,Blocks.planks,1);bb.buildBlock(-4,5,-1,Blocks.planks,1);
		bb.buildBlock(-4,5,0,Blocks.planks,1);bb.buildBlock(-4,5,1,Blocks.planks,1);bb.buildBlock(-4,5,2,Blocks.planks,1);
		bb.buildBlock(-4,5,3,Blocks.acacia_stairs,3);bb.buildBlock(-3,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(-3,5,-2,Blocks.planks,1);
		bb.buildBlock(-3,5,-1,Blocks.planks,1);bb.buildBlock(-3,5,1,Blocks.planks,1);bb.buildBlock(-3,5,2,Blocks.planks,1);
		bb.buildBlock(-3,5,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(-2,5,-2,Blocks.planks,1);
		bb.buildBlock(-2,5,-1,Blocks.planks,1);bb.buildBlock(-2,5,1,Blocks.planks,1);bb.buildBlock(-2,5,2,Blocks.planks,1);
		bb.buildBlock(-2,5,3,Blocks.acacia_stairs,3);bb.buildBlock(-1,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(-1,5,-2,Blocks.planks,1);
		bb.buildBlock(-1,5,-1,Blocks.planks,1);bb.buildBlock(-1,5,1,Blocks.planks,1);bb.buildBlock(-1,5,2,Blocks.planks,1);
		bb.buildBlock(-1,5,3,Blocks.acacia_stairs,3);bb.buildBlock(0,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(0,5,-2,Blocks.planks,1);
		bb.buildBlock(0,5,-1,Blocks.planks,1);bb.buildBlock(0,5,1,Blocks.planks,1);bb.buildBlock(0,5,2,Blocks.planks,1);
		bb.buildBlock(0,5,3,Blocks.acacia_stairs,3);bb.buildBlock(1,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(1,5,-2,Blocks.planks,1);
		bb.buildBlock(1,5,-1,Blocks.planks,1);bb.buildBlock(1,5,1,Blocks.planks,1);bb.buildBlock(1,5,2,Blocks.planks,1);
		bb.buildBlock(1,5,3,Blocks.acacia_stairs,3);bb.buildBlock(2,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(2,5,-2,Blocks.planks,1);
		bb.buildBlock(2,5,-1,Blocks.planks,1);bb.buildBlock(2,5,1,Blocks.planks,1);bb.buildBlock(2,5,2,Blocks.planks,1);
		bb.buildBlock(2,5,3,Blocks.acacia_stairs,3);bb.buildBlock(3,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(3,5,-2,Blocks.planks,1);
		bb.buildBlock(3,5,-1,Blocks.planks,1);bb.buildBlock(3,5,1,Blocks.planks,1);bb.buildBlock(3,5,2,Blocks.planks,1);
		bb.buildBlock(3,5,3,Blocks.acacia_stairs,3);bb.buildBlock(4,5,-3,Blocks.acacia_stairs,2);bb.buildBlock(4,5,-2,Blocks.planks,1);
		bb.buildBlock(4,5,-1,Blocks.planks,1);bb.buildBlock(4,5,0,Blocks.planks,1);bb.buildBlock(4,5,1,Blocks.planks,1);
		bb.buildBlock(4,5,2,Blocks.planks,1);bb.buildBlock(4,5,3,Blocks.acacia_stairs,3);bb.buildBlock(5,5,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(5,5,-2,Blocks.acacia_stairs,7);bb.buildBlock(5,5,2,Blocks.acacia_stairs,6);bb.buildBlock(5,5,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-5,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(-5,6,-1,Blocks.acacia_stairs,7);bb.buildBlock(-5,6,1,Blocks.acacia_stairs,6);
		bb.buildBlock(-5,6,2,Blocks.acacia_stairs,3);bb.buildBlock(-4,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(-4,6,-1,Blocks.planks,1);
		bb.buildBlock(-4,6,0,Blocks.planks,1);bb.buildBlock(-4,6,1,Blocks.planks,1);bb.buildBlock(-4,6,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(-3,6,-1,Blocks.planks,1);bb.buildBlock(-3,6,0,Blocks.planks,1);
		bb.buildBlock(-3,6,1,Blocks.planks,1);bb.buildBlock(-3,6,2,Blocks.acacia_stairs,3);bb.buildBlock(-2,6,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,6,-1,Blocks.planks,1);bb.buildBlock(-2,6,0,Blocks.planks,1);bb.buildBlock(-2,6,1,Blocks.planks,1);
		bb.buildBlock(-2,6,2,Blocks.acacia_stairs,3);bb.buildBlock(-1,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(-1,6,-1,Blocks.planks,1);
		bb.buildBlock(-1,6,0,Blocks.planks,1);bb.buildBlock(-1,6,1,Blocks.planks,1);bb.buildBlock(-1,6,2,Blocks.acacia_stairs,3);
		bb.buildBlock(0,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(0,6,-1,Blocks.planks,1);bb.buildBlock(0,6,0,Blocks.planks,1);
		bb.buildBlock(0,6,1,Blocks.planks,1);bb.buildBlock(0,6,2,Blocks.acacia_stairs,3);bb.buildBlock(1,6,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(1,6,-1,Blocks.planks,1);bb.buildBlock(1,6,0,Blocks.planks,1);bb.buildBlock(1,6,1,Blocks.planks,1);
		bb.buildBlock(1,6,2,Blocks.acacia_stairs,3);bb.buildBlock(2,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(2,6,-1,Blocks.planks,1);
		bb.buildBlock(2,6,0,Blocks.planks,1);bb.buildBlock(2,6,1,Blocks.planks,1);bb.buildBlock(2,6,2,Blocks.acacia_stairs,3);
		bb.buildBlock(3,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(3,6,-1,Blocks.planks,1);bb.buildBlock(3,6,0,Blocks.planks,1);
		bb.buildBlock(3,6,1,Blocks.planks,1);bb.buildBlock(3,6,2,Blocks.acacia_stairs,3);bb.buildBlock(4,6,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(4,6,-1,Blocks.planks,1);bb.buildBlock(4,6,0,Blocks.planks,1);bb.buildBlock(4,6,1,Blocks.planks,1);
		bb.buildBlock(4,6,2,Blocks.acacia_stairs,3);bb.buildBlock(5,6,-2,Blocks.acacia_stairs,2);bb.buildBlock(5,6,-1,Blocks.acacia_stairs,7);
		bb.buildBlock(5,6,1,Blocks.acacia_stairs,6);bb.buildBlock(5,6,2,Blocks.acacia_stairs,3);bb.buildBlock(-5,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,7,0,Blocks.planks,4);bb.buildBlock(-5,7,1,Blocks.acacia_stairs,3);bb.buildBlock(-4,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,7,0,Blocks.planks,4);bb.buildBlock(-4,7,1,Blocks.acacia_stairs,3);bb.buildBlock(-3,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,7,0,Blocks.planks,4);bb.buildBlock(-3,7,1,Blocks.acacia_stairs,3);bb.buildBlock(-2,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,7,0,Blocks.planks,4);bb.buildBlock(-2,7,1,Blocks.acacia_stairs,3);bb.buildBlock(-1,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,7,0,Blocks.planks,4);bb.buildBlock(-1,7,1,Blocks.acacia_stairs,3);bb.buildBlock(0,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(0,7,0,Blocks.planks,4);bb.buildBlock(0,7,1,Blocks.acacia_stairs,3);bb.buildBlock(1,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(1,7,0,Blocks.planks,4);bb.buildBlock(1,7,1,Blocks.acacia_stairs,3);bb.buildBlock(2,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(2,7,0,Blocks.planks,4);bb.buildBlock(2,7,1,Blocks.acacia_stairs,3);bb.buildBlock(3,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(3,7,0,Blocks.planks,4);bb.buildBlock(3,7,1,Blocks.acacia_stairs,3);bb.buildBlock(4,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(4,7,0,Blocks.planks,4);bb.buildBlock(4,7,1,Blocks.acacia_stairs,3);bb.buildBlock(5,7,-1,Blocks.acacia_stairs,2);
		bb.buildBlock(5,7,0,Blocks.planks,4);bb.buildBlock(5,7,1,Blocks.acacia_stairs,3);bb.buildBlock(-5,8,0,Blocks.acacia_stairs,0);
		bb.buildBlock(5,8,0,Blocks.acacia_stairs,1);bb.buildBlock(-3,2,-2,Blocks.torch,1);bb.buildBlock(-3,2,0,Blocks.torch,1);
		bb.buildBlock(-3,2,2,Blocks.torch,1);bb.buildBlock(-2,2,-3,Blocks.torch,3);bb.buildBlock(0,2,3,Blocks.torch,4);
		bb.buildBlock(2,2,-3,Blocks.torch,3);bb.buildBlock(3,2,-1,Blocks.torch,2);bb.buildBlock(3,2,2,Blocks.torch,2);
		bb.buildBlock(-3,5,0,Blocks.torch,4);bb.buildBlock(0,5,0,Blocks.torch,4);bb.buildBlock(3,5,0,Blocks.torch,4);
		bb.addEntityPainting(0,2,1,0,"Plant");
		bb.addEntityPainting(2,2,1,2,"Creebet");
	}

}
