package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMiner;
import com.ckhgame.villagebento.villager.VillagerNoviceBaker;
import com.ckhgame.villagebento.villager.VillagerVillageElder;

import net.minecraft.init.Blocks;

public class BuildingSmallBakery extends Building {

	@Override
	public String getName() {
		return "Small Bakery";
	}

	@Override
	public String getDescription() {
		return "Welcome to the Small Bakery!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerNoviceBaker.class,"Haili","Haili",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		bb.buildBlock(-2,0,-2,Blocks.planks,0);bb.buildBlock(-2,0,-1,Blocks.planks,0);bb.buildBlock(-2,0,0,Blocks.planks,0);
		bb.buildBlock(-2,0,1,Blocks.planks,0);bb.buildBlock(-2,0,2,Blocks.planks,0);bb.buildBlock(-1,0,-2,Blocks.planks,0);
		bb.buildBlock(-1,0,-1,Blocks.planks,0);bb.buildBlock(-1,0,0,Blocks.chest,5);bb.buildBlock(-1,0,1,Blocks.bed,9);
		bb.buildBlock(-1,0,2,Blocks.planks,0);bb.buildBlock(0,0,-2,Blocks.planks,0);bb.buildBlock(0,0,1,Blocks.bed,1);
		bb.buildBlock(0,0,2,Blocks.planks,0);bb.buildBlock(1,0,-2,Blocks.planks,0);bb.buildBlock(1,0,-1,Blocks.oak_stairs,3);
		bb.buildBlock(1,0,2,Blocks.planks,0);bb.buildBlock(2,0,-2,Blocks.planks,0);bb.buildBlock(2,0,-1,Blocks.oak_stairs,3);
		bb.buildBlock(2,0,2,Blocks.planks,0);bb.buildBlock(3,0,-2,Blocks.planks,0);bb.buildBlock(3,0,-1,Blocks.planks,0);
		bb.buildBlock(3,0,0,Blocks.wooden_door,6);bb.buildBlock(3,0,1,Blocks.planks,0);bb.buildBlock(3,0,2,Blocks.planks,0);
		bb.buildBlock(-2,1,-2,Blocks.planks,0);bb.buildBlock(-2,1,-1,Blocks.planks,0);bb.buildBlock(-2,1,0,Blocks.planks,0);
		bb.buildBlock(-2,1,1,Blocks.planks,0);bb.buildBlock(-2,1,2,Blocks.planks,0);bb.buildBlock(-1,1,-2,Blocks.planks,0);
		bb.buildBlock(-1,1,-1,Blocks.furnace,5);bb.buildBlock(-1,1,2,Blocks.planks,0);bb.buildBlock(0,1,-2,Blocks.glass_pane,0);
		bb.buildBlock(0,1,2,Blocks.glass_pane,0);bb.buildBlock(1,1,-2,Blocks.glass_pane,0);bb.buildBlock(1,1,2,Blocks.glass_pane,0);
		bb.buildBlock(2,1,-2,Blocks.planks,0);bb.buildBlock(2,1,2,Blocks.planks,0);bb.buildBlock(3,1,-2,Blocks.planks,0);
		bb.buildBlock(3,1,-1,Blocks.planks,0);bb.buildBlock(3,1,0,Blocks.wooden_door,8);bb.buildBlock(3,1,1,Blocks.planks,0);
		bb.buildBlock(3,1,2,Blocks.planks,0);bb.buildBlock(-2,2,-2,Blocks.planks,0);bb.buildBlock(-2,2,-1,Blocks.planks,0);
		bb.buildBlock(-2,2,0,Blocks.planks,0);bb.buildBlock(-2,2,1,Blocks.planks,0);bb.buildBlock(-2,2,2,Blocks.planks,0);
		bb.buildBlock(-1,2,-2,Blocks.planks,0);bb.buildBlock(-1,2,2,Blocks.planks,0);bb.buildBlock(0,2,-2,Blocks.planks,0);
		bb.buildBlock(0,2,2,Blocks.planks,0);bb.buildBlock(1,2,-2,Blocks.planks,0);bb.buildBlock(1,2,2,Blocks.planks,0);
		bb.buildBlock(2,2,-2,Blocks.planks,0);bb.buildBlock(2,2,2,Blocks.planks,0);bb.buildBlock(3,2,-2,Blocks.planks,0);
		bb.buildBlock(3,2,-1,Blocks.planks,0);bb.buildBlock(3,2,0,Blocks.planks,0);bb.buildBlock(3,2,1,Blocks.planks,0);
		bb.buildBlock(3,2,2,Blocks.planks,0);bb.buildBlock(-1,3,-2,Blocks.planks,0);bb.buildBlock(-1,3,-1,Blocks.planks,0);
		bb.buildBlock(-1,3,0,Blocks.planks,0);bb.buildBlock(-1,3,1,Blocks.planks,0);bb.buildBlock(-1,3,2,Blocks.planks,0);
		bb.buildBlock(0,3,-2,Blocks.planks,0);bb.buildBlock(0,3,-1,Blocks.planks,0);bb.buildBlock(0,3,0,Blocks.planks,0);
		bb.buildBlock(0,3,1,Blocks.planks,0);bb.buildBlock(0,3,2,Blocks.planks,0);bb.buildBlock(1,3,-2,Blocks.planks,0);
		bb.buildBlock(1,3,-1,Blocks.planks,0);bb.buildBlock(1,3,0,Blocks.planks,0);bb.buildBlock(1,3,1,Blocks.planks,0);
		bb.buildBlock(1,3,2,Blocks.planks,0);bb.buildBlock(2,3,-2,Blocks.planks,0);bb.buildBlock(2,3,-1,Blocks.planks,0);
		bb.buildBlock(2,3,0,Blocks.planks,0);bb.buildBlock(2,3,1,Blocks.planks,0);bb.buildBlock(2,3,2,Blocks.planks,0);
		bb.buildBlock(-1,2,1,Blocks.torch,1);bb.buildBlock(2,2,-1,Blocks.torch,3);bb.buildBlock(2,2,1,Blocks.torch,4);
	}

}
