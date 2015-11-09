package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerBakerAssistant;
import com.ckhgame.villagebento.villager.VillagerProBaker;

import net.minecraft.init.Blocks;

public class BuildingLargeBakery extends Building {

	@Override
	public String getName() {
		return "Large Bakery";
	}

	@Override
	public String getDescription() {
		return "Welcome to the Large Bakery!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerProBaker.class,"Amy",-2,0);
		bb.addBuildingVillager(VillagerBakerAssistant.class,"Henry",-3,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-4,0,-4,Blocks.stonebrick,0);bb.buildBlock(-4,0,-3,Blocks.stonebrick,0);bb.buildBlock(-4,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(-4,0,-1,Blocks.stonebrick,0);bb.buildBlock(-4,0,0,Blocks.stonebrick,0);bb.buildBlock(-4,0,1,Blocks.stonebrick,0);
		bb.buildBlock(-4,0,2,Blocks.stonebrick,0);bb.buildBlock(-4,0,3,Blocks.stonebrick,0);bb.buildBlock(-4,0,4,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,-4,Blocks.stonebrick,0);bb.buildBlock(-3,0,-3,Blocks.planks,0);bb.buildBlock(-3,0,-2,Blocks.planks,0);
		bb.buildBlock(-3,0,-1,Blocks.planks,0);bb.buildBlock(-3,0,0,Blocks.oak_stairs,3);bb.buildBlock(-3,0,4,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,-4,Blocks.stonebrick,0);bb.buildBlock(-2,0,-3,Blocks.acacia_stairs,1);bb.buildBlock(-2,0,-2,Blocks.acacia_stairs,1);
		bb.buildBlock(-2,0,-1,Blocks.carpet,14);bb.buildBlock(-2,0,0,Blocks.carpet,14);bb.buildBlock(-2,0,1,Blocks.carpet,14);
		bb.buildBlock(-2,0,2,Blocks.planks,0);bb.buildBlock(-2,0,3,Blocks.planks,0);bb.buildBlock(-2,0,4,Blocks.stonebrick,0);
		bb.buildBlock(-1,0,-4,Blocks.stonebrick,0);bb.buildBlock(-1,0,-3,Blocks.carpet,14);bb.buildBlock(-1,0,-2,Blocks.carpet,14);
		bb.buildBlock(-1,0,-1,Blocks.carpet,14);bb.buildBlock(-1,0,0,Blocks.carpet,14);bb.buildBlock(-1,0,1,Blocks.carpet,14);
		bb.buildBlock(-1,0,2,Blocks.carpet,14);bb.buildBlock(-1,0,3,Blocks.carpet,14);bb.buildBlock(-1,0,4,Blocks.stonebrick,0);
		bb.buildBlock(0,0,-4,Blocks.stonebrick,0);bb.buildBlock(0,0,-3,Blocks.wooden_slab,4);bb.buildBlock(0,0,-2,Blocks.wooden_slab,4);
		bb.buildBlock(0,0,-1,Blocks.carpet,14);bb.buildBlock(0,0,0,Blocks.carpet,14);bb.buildBlock(0,0,1,Blocks.carpet,14);
		bb.buildBlock(0,0,2,Blocks.oak_stairs,0);bb.buildBlock(0,0,3,Blocks.oak_stairs,0);bb.buildBlock(0,0,4,Blocks.stonebrick,0);
		bb.buildBlock(1,0,-5,Blocks.fence,0);bb.buildBlock(1,0,-4,Blocks.stonebrick,0);bb.buildBlock(1,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(1,0,-2,Blocks.stonebrick,0);bb.buildBlock(1,0,-1,Blocks.stonebrick,0);bb.buildBlock(1,0,0,Blocks.carpet,14);
		bb.buildBlock(1,0,1,Blocks.carpet,14);bb.buildBlock(1,0,2,Blocks.stonebrick,0);bb.buildBlock(1,0,3,Blocks.stonebrick,0);
		bb.buildBlock(1,0,4,Blocks.stonebrick,0);bb.buildBlock(1,0,5,Blocks.fence,0);bb.buildBlock(2,0,-5,Blocks.fence,0);
		bb.buildBlock(2,0,-3,Blocks.acacia_stairs,1);bb.buildBlock(2,0,-2,Blocks.acacia_stairs,1);bb.buildBlock(2,0,-1,Blocks.flower_pot,7);
		bb.buildBlock(2,0,2,Blocks.flower_pot,7);bb.buildBlock(2,0,3,Blocks.acacia_stairs,1);bb.buildBlock(2,0,5,Blocks.fence,0);
		bb.buildBlock(3,0,-5,Blocks.fence,0);bb.buildBlock(3,0,5,Blocks.fence,0);bb.buildBlock(4,0,-5,Blocks.fence,0);
		bb.buildBlock(4,0,-3,Blocks.wooden_slab,4);bb.buildBlock(4,0,-2,Blocks.wooden_slab,4);bb.buildBlock(4,0,3,Blocks.wooden_slab,4);
		bb.buildBlock(4,0,5,Blocks.fence,0);bb.buildBlock(5,0,-5,Blocks.fence,0);bb.buildBlock(5,0,-4,Blocks.fence,0);
		bb.buildBlock(5,0,-3,Blocks.fence,0);bb.buildBlock(5,0,-2,Blocks.fence,0);bb.buildBlock(5,0,-1,Blocks.fence,0);
		bb.buildBlock(5,0,0,Blocks.fence_gate,1);bb.buildBlock(5,0,1,Blocks.fence,0);bb.buildBlock(5,0,2,Blocks.fence,0);
		bb.buildBlock(5,0,3,Blocks.fence,0);bb.buildBlock(5,0,4,Blocks.fence,0);bb.buildBlock(5,0,5,Blocks.fence,0);
		bb.buildBlock(-4,1,-4,Blocks.planks,0);bb.buildBlock(-4,1,-3,Blocks.planks,0);bb.buildBlock(-4,1,-2,Blocks.planks,0);
		bb.buildBlock(-4,1,-1,Blocks.planks,0);bb.buildBlock(-4,1,0,Blocks.planks,0);bb.buildBlock(-4,1,1,Blocks.planks,0);
		bb.buildBlock(-4,1,2,Blocks.planks,0);bb.buildBlock(-4,1,3,Blocks.planks,0);bb.buildBlock(-4,1,4,Blocks.planks,0);
		bb.buildBlock(-3,1,-4,Blocks.planks,0);bb.buildBlock(-3,1,-3,Blocks.planks,0);bb.buildBlock(-3,1,-2,Blocks.planks,0);
		bb.buildBlock(-3,1,-1,Blocks.oak_stairs,3);bb.buildBlock(-3,1,4,Blocks.planks,0);bb.buildBlock(-2,1,-4,Blocks.glass_pane,0);
		bb.buildBlock(-2,1,2,Blocks.glass,0);bb.buildBlock(-2,1,3,Blocks.glass,0);bb.buildBlock(-2,1,4,Blocks.glass_pane,0);
		bb.buildBlock(-1,1,-4,Blocks.glass_pane,0);bb.buildBlock(-1,1,4,Blocks.glass_pane,0);bb.buildBlock(0,1,-4,Blocks.planks,0);
		bb.buildBlock(0,1,4,Blocks.planks,0);bb.buildBlock(1,1,-4,Blocks.planks,0);bb.buildBlock(1,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(1,1,-2,Blocks.glass_pane,0);bb.buildBlock(1,1,-1,Blocks.planks,0);bb.buildBlock(1,1,2,Blocks.planks,0);
		bb.buildBlock(1,1,3,Blocks.planks,0);bb.buildBlock(1,1,4,Blocks.planks,0);bb.buildBlock(5,1,-1,Blocks.fence,0);
		bb.buildBlock(5,1,1,Blocks.fence,0);bb.buildBlock(-4,2,-4,Blocks.planks,0);bb.buildBlock(-4,2,-3,Blocks.planks,0);
		bb.buildBlock(-4,2,-2,Blocks.planks,0);bb.buildBlock(-4,2,-1,Blocks.planks,0);bb.buildBlock(-4,2,0,Blocks.planks,0);
		bb.buildBlock(-4,2,1,Blocks.planks,0);bb.buildBlock(-4,2,2,Blocks.planks,0);bb.buildBlock(-4,2,3,Blocks.planks,0);
		bb.buildBlock(-4,2,4,Blocks.planks,0);bb.buildBlock(-3,2,-4,Blocks.planks,0);bb.buildBlock(-3,2,-3,Blocks.planks,0);
		bb.buildBlock(-3,2,-2,Blocks.oak_stairs,3);bb.buildBlock(-3,2,4,Blocks.planks,0);bb.buildBlock(-2,2,-4,Blocks.glass_pane,0);
		bb.buildBlock(-2,2,4,Blocks.glass_pane,0);bb.buildBlock(-1,2,-4,Blocks.glass_pane,0);bb.buildBlock(-1,2,4,Blocks.glass_pane,0);
		bb.buildBlock(0,2,-4,Blocks.planks,0);bb.buildBlock(0,2,4,Blocks.planks,0);bb.buildBlock(1,2,-4,Blocks.planks,0);
		bb.buildBlock(1,2,-3,Blocks.glass_pane,0);bb.buildBlock(1,2,-2,Blocks.glass_pane,0);bb.buildBlock(1,2,-1,Blocks.planks,0);
		bb.buildBlock(1,2,0,Blocks.planks,0);bb.buildBlock(1,2,1,Blocks.planks,0);bb.buildBlock(1,2,2,Blocks.planks,0);
		bb.buildBlock(1,2,3,Blocks.planks,0);bb.buildBlock(1,2,4,Blocks.planks,0);bb.buildBlock(-4,3,-4,Blocks.planks,0);
		bb.buildBlock(-4,3,-3,Blocks.planks,0);bb.buildBlock(-4,3,-2,Blocks.planks,0);bb.buildBlock(-4,3,-1,Blocks.planks,0);
		bb.buildBlock(-4,3,0,Blocks.planks,0);bb.buildBlock(-4,3,1,Blocks.planks,0);bb.buildBlock(-4,3,2,Blocks.planks,0);
		bb.buildBlock(-4,3,3,Blocks.planks,0);bb.buildBlock(-4,3,4,Blocks.planks,0);bb.buildBlock(-3,3,-4,Blocks.planks,0);
		bb.buildBlock(-3,3,-3,Blocks.oak_stairs,3);bb.buildBlock(-3,3,1,Blocks.wooden_slab,8);bb.buildBlock(-3,3,2,Blocks.planks,0);
		bb.buildBlock(-3,3,3,Blocks.planks,0);bb.buildBlock(-3,3,4,Blocks.planks,0);bb.buildBlock(-2,3,-4,Blocks.planks,0);
		bb.buildBlock(-2,3,-3,Blocks.wooden_slab,8);bb.buildBlock(-2,3,-2,Blocks.wooden_slab,8);bb.buildBlock(-2,3,-1,Blocks.wooden_slab,8);
		bb.buildBlock(-2,3,0,Blocks.wooden_slab,8);bb.buildBlock(-2,3,1,Blocks.wooden_slab,8);bb.buildBlock(-2,3,2,Blocks.planks,0);
		bb.buildBlock(-2,3,3,Blocks.planks,0);bb.buildBlock(-2,3,4,Blocks.planks,0);bb.buildBlock(-1,3,-4,Blocks.planks,0);
		bb.buildBlock(-1,3,-3,Blocks.wooden_slab,8);bb.buildBlock(-1,3,-2,Blocks.wooden_slab,8);bb.buildBlock(-1,3,-1,Blocks.wooden_slab,8);
		bb.buildBlock(-1,3,0,Blocks.wooden_slab,8);bb.buildBlock(-1,3,1,Blocks.wooden_slab,8);bb.buildBlock(-1,3,2,Blocks.planks,0);
		bb.buildBlock(-1,3,3,Blocks.planks,0);bb.buildBlock(-1,3,4,Blocks.planks,0);bb.buildBlock(0,3,-4,Blocks.planks,0);
		bb.buildBlock(0,3,-3,Blocks.wooden_slab,8);bb.buildBlock(0,3,-2,Blocks.wooden_slab,8);bb.buildBlock(0,3,-1,Blocks.wooden_slab,8);
		bb.buildBlock(0,3,0,Blocks.wooden_slab,8);bb.buildBlock(0,3,1,Blocks.wooden_slab,8);bb.buildBlock(0,3,2,Blocks.wooden_slab,8);
		bb.buildBlock(0,3,3,Blocks.wooden_slab,8);bb.buildBlock(0,3,4,Blocks.planks,0);bb.buildBlock(1,3,-4,Blocks.planks,0);
		bb.buildBlock(1,3,-3,Blocks.planks,0);bb.buildBlock(1,3,-2,Blocks.planks,0);bb.buildBlock(1,3,-1,Blocks.planks,0);
		bb.buildBlock(1,3,0,Blocks.planks,0);bb.buildBlock(1,3,1,Blocks.planks,0);bb.buildBlock(1,3,2,Blocks.planks,0);
		bb.buildBlock(1,3,3,Blocks.planks,0);bb.buildBlock(1,3,4,Blocks.planks,0);bb.buildBlock(2,3,-4,Blocks.wooden_slab,12);
		bb.buildBlock(2,3,-3,Blocks.wooden_slab,12);bb.buildBlock(2,3,-2,Blocks.wooden_slab,12);bb.buildBlock(2,3,-1,Blocks.wooden_slab,12);
		bb.buildBlock(2,3,0,Blocks.wooden_slab,12);bb.buildBlock(2,3,1,Blocks.wooden_slab,12);bb.buildBlock(2,3,2,Blocks.wooden_slab,12);
		bb.buildBlock(2,3,3,Blocks.wooden_slab,12);bb.buildBlock(2,3,4,Blocks.wooden_slab,12);bb.buildBlock(-4,4,-4,Blocks.planks,0);
		bb.buildBlock(-4,4,-3,Blocks.planks,0);bb.buildBlock(-4,4,-2,Blocks.planks,0);bb.buildBlock(-4,4,-1,Blocks.planks,0);
		bb.buildBlock(-4,4,0,Blocks.planks,0);bb.buildBlock(-4,4,1,Blocks.planks,0);bb.buildBlock(-4,4,2,Blocks.planks,0);
		bb.buildBlock(-4,4,3,Blocks.planks,0);bb.buildBlock(-4,4,4,Blocks.planks,0);bb.buildBlock(-3,4,-4,Blocks.planks,0);
		bb.buildBlock(-3,4,3,Blocks.planks,2);bb.buildBlock(-3,4,4,Blocks.planks,0);bb.buildBlock(-2,4,-4,Blocks.planks,0);
		bb.buildBlock(-2,4,2,Blocks.bed,0);bb.buildBlock(-2,4,3,Blocks.bed,8);bb.buildBlock(-2,4,4,Blocks.planks,0);
		bb.buildBlock(-1,4,-4,Blocks.planks,0);bb.buildBlock(-1,4,2,Blocks.bed,0);bb.buildBlock(-1,4,3,Blocks.bed,8);
		bb.buildBlock(-1,4,4,Blocks.planks,0);bb.buildBlock(0,4,-4,Blocks.planks,0);bb.buildBlock(0,4,-3,Blocks.planks,0);
		bb.buildBlock(0,4,-2,Blocks.planks,0);bb.buildBlock(0,4,-1,Blocks.wooden_door,0);bb.buildBlock(0,4,0,Blocks.wooden_door,0);
		bb.buildBlock(0,4,1,Blocks.planks,0);bb.buildBlock(0,4,2,Blocks.planks,0);bb.buildBlock(0,4,3,Blocks.planks,0);
		bb.buildBlock(0,4,4,Blocks.planks,0);bb.buildBlock(1,4,-4,Blocks.fence,0);bb.buildBlock(1,4,4,Blocks.fence,0);
		bb.buildBlock(2,4,-4,Blocks.fence,0);bb.buildBlock(2,4,-3,Blocks.fence,0);bb.buildBlock(2,4,-2,Blocks.fence,0);
		bb.buildBlock(2,4,-1,Blocks.fence,0);bb.buildBlock(2,4,0,Blocks.fence,0);bb.buildBlock(2,4,1,Blocks.fence,0);
		bb.buildBlock(2,4,2,Blocks.fence,0);bb.buildBlock(2,4,3,Blocks.fence,0);bb.buildBlock(2,4,4,Blocks.fence,0);
		bb.buildBlock(-4,5,-4,Blocks.planks,0);bb.buildBlock(-4,5,-3,Blocks.planks,0);bb.buildBlock(-4,5,-2,Blocks.planks,0);
		bb.buildBlock(-4,5,-1,Blocks.glass_pane,0);bb.buildBlock(-4,5,0,Blocks.glass_pane,0);bb.buildBlock(-4,5,1,Blocks.planks,0);
		bb.buildBlock(-4,5,2,Blocks.planks,0);bb.buildBlock(-4,5,3,Blocks.planks,0);bb.buildBlock(-4,5,4,Blocks.planks,0);
		bb.buildBlock(-3,5,-4,Blocks.planks,0);bb.buildBlock(-3,5,3,Blocks.flower_pot,2);bb.buildBlock(-3,5,4,Blocks.planks,0);
		bb.buildBlock(-2,5,-4,Blocks.glass_pane,0);bb.buildBlock(-2,5,4,Blocks.glass_pane,0);bb.buildBlock(-1,5,-4,Blocks.planks,0);
		bb.buildBlock(-1,5,4,Blocks.planks,0);bb.buildBlock(0,5,-4,Blocks.planks,0);bb.buildBlock(0,5,-3,Blocks.planks,0);
		bb.buildBlock(0,5,-2,Blocks.planks,0);bb.buildBlock(0,5,-1,Blocks.wooden_door,8);bb.buildBlock(0,5,0,Blocks.wooden_door,9);
		bb.buildBlock(0,5,1,Blocks.planks,0);bb.buildBlock(0,5,2,Blocks.glass_pane,0);bb.buildBlock(0,5,3,Blocks.glass_pane,0);
		bb.buildBlock(0,5,4,Blocks.planks,0);bb.buildBlock(-4,6,-4,Blocks.planks,0);bb.buildBlock(-4,6,-3,Blocks.planks,0);
		bb.buildBlock(-4,6,-2,Blocks.planks,0);bb.buildBlock(-4,6,-1,Blocks.glass_pane,0);bb.buildBlock(-4,6,0,Blocks.glass_pane,0);
		bb.buildBlock(-4,6,1,Blocks.planks,0);bb.buildBlock(-4,6,2,Blocks.planks,0);bb.buildBlock(-4,6,3,Blocks.planks,0);
		bb.buildBlock(-4,6,4,Blocks.planks,0);bb.buildBlock(-3,6,-4,Blocks.planks,0);bb.buildBlock(-3,6,4,Blocks.planks,0);
		bb.buildBlock(-2,6,-4,Blocks.glass_pane,0);bb.buildBlock(-2,6,4,Blocks.glass_pane,0);bb.buildBlock(-1,6,-4,Blocks.planks,0);
		bb.buildBlock(-1,6,4,Blocks.planks,0);bb.buildBlock(0,6,-4,Blocks.planks,0);bb.buildBlock(0,6,-3,Blocks.planks,0);
		bb.buildBlock(0,6,-2,Blocks.planks,0);bb.buildBlock(0,6,-1,Blocks.planks,0);bb.buildBlock(0,6,0,Blocks.planks,0);
		bb.buildBlock(0,6,1,Blocks.planks,0);bb.buildBlock(0,6,2,Blocks.glass_pane,0);bb.buildBlock(0,6,3,Blocks.glass_pane,0);
		bb.buildBlock(0,6,4,Blocks.planks,0);bb.buildBlock(-4,7,-4,Blocks.planks,0);bb.buildBlock(-4,7,-3,Blocks.planks,0);
		bb.buildBlock(-4,7,-2,Blocks.planks,0);bb.buildBlock(-4,7,-1,Blocks.planks,0);bb.buildBlock(-4,7,0,Blocks.planks,0);
		bb.buildBlock(-4,7,1,Blocks.planks,0);bb.buildBlock(-4,7,2,Blocks.planks,0);bb.buildBlock(-4,7,3,Blocks.planks,0);
		bb.buildBlock(-4,7,4,Blocks.planks,0);bb.buildBlock(-3,7,-4,Blocks.planks,0);bb.buildBlock(-3,7,4,Blocks.planks,0);
		bb.buildBlock(-2,7,-4,Blocks.planks,0);bb.buildBlock(-2,7,4,Blocks.planks,0);bb.buildBlock(-1,7,-4,Blocks.planks,0);
		bb.buildBlock(-1,7,4,Blocks.planks,0);bb.buildBlock(0,7,-4,Blocks.planks,0);bb.buildBlock(0,7,-3,Blocks.planks,0);
		bb.buildBlock(0,7,-2,Blocks.planks,0);bb.buildBlock(0,7,-1,Blocks.planks,0);bb.buildBlock(0,7,0,Blocks.planks,0);
		bb.buildBlock(0,7,1,Blocks.planks,0);bb.buildBlock(0,7,2,Blocks.planks,0);bb.buildBlock(0,7,3,Blocks.planks,0);
		bb.buildBlock(0,7,4,Blocks.planks,0);bb.buildBlock(-4,8,-4,Blocks.double_wooden_slab,4);bb.buildBlock(-4,8,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-4,8,-2,Blocks.wooden_slab,4);bb.buildBlock(-4,8,-1,Blocks.wooden_slab,4);bb.buildBlock(-4,8,0,Blocks.wooden_slab,4);
		bb.buildBlock(-4,8,1,Blocks.wooden_slab,4);bb.buildBlock(-4,8,2,Blocks.wooden_slab,4);bb.buildBlock(-4,8,3,Blocks.wooden_slab,4);
		bb.buildBlock(-4,8,4,Blocks.double_wooden_slab,4);bb.buildBlock(-3,8,-4,Blocks.wooden_slab,4);bb.buildBlock(-3,8,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-3,8,-2,Blocks.wooden_slab,4);bb.buildBlock(-3,8,-1,Blocks.wooden_slab,4);bb.buildBlock(-3,8,0,Blocks.wooden_slab,4);
		bb.buildBlock(-3,8,1,Blocks.wooden_slab,4);bb.buildBlock(-3,8,2,Blocks.wooden_slab,4);bb.buildBlock(-3,8,3,Blocks.wooden_slab,4);
		bb.buildBlock(-3,8,4,Blocks.wooden_slab,4);bb.buildBlock(-2,8,-4,Blocks.wooden_slab,4);bb.buildBlock(-2,8,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-2,8,-2,Blocks.wooden_slab,4);bb.buildBlock(-2,8,-1,Blocks.wooden_slab,4);bb.buildBlock(-2,8,0,Blocks.wooden_slab,4);
		bb.buildBlock(-2,8,1,Blocks.wooden_slab,4);bb.buildBlock(-2,8,2,Blocks.wooden_slab,4);bb.buildBlock(-2,8,3,Blocks.wooden_slab,4);
		bb.buildBlock(-2,8,4,Blocks.wooden_slab,4);bb.buildBlock(-1,8,-4,Blocks.wooden_slab,4);bb.buildBlock(-1,8,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-1,8,-2,Blocks.wooden_slab,4);bb.buildBlock(-1,8,-1,Blocks.wooden_slab,4);bb.buildBlock(-1,8,0,Blocks.wooden_slab,4);
		bb.buildBlock(-1,8,1,Blocks.wooden_slab,4);bb.buildBlock(-1,8,2,Blocks.wooden_slab,4);bb.buildBlock(-1,8,3,Blocks.wooden_slab,4);
		bb.buildBlock(-1,8,4,Blocks.wooden_slab,4);bb.buildBlock(0,8,-4,Blocks.double_wooden_slab,4);bb.buildBlock(0,8,-3,Blocks.wooden_slab,4);
		bb.buildBlock(0,8,-2,Blocks.wooden_slab,4);bb.buildBlock(0,8,-1,Blocks.wooden_slab,4);bb.buildBlock(0,8,0,Blocks.wooden_slab,4);
		bb.buildBlock(0,8,1,Blocks.wooden_slab,4);bb.buildBlock(0,8,2,Blocks.wooden_slab,4);bb.buildBlock(0,8,3,Blocks.wooden_slab,4);
		bb.buildBlock(0,8,4,Blocks.double_wooden_slab,4);bb.buildBlock(-5,9,-5,Blocks.wooden_slab,4);bb.buildBlock(-5,9,-4,Blocks.wooden_slab,4);
		bb.buildBlock(-5,9,-3,Blocks.wooden_slab,4);bb.buildBlock(-5,9,-2,Blocks.wooden_slab,4);bb.buildBlock(-5,9,-1,Blocks.wooden_slab,4);
		bb.buildBlock(-5,9,0,Blocks.wooden_slab,4);bb.buildBlock(-5,9,1,Blocks.wooden_slab,4);bb.buildBlock(-5,9,2,Blocks.wooden_slab,4);
		bb.buildBlock(-5,9,3,Blocks.wooden_slab,4);bb.buildBlock(-5,9,4,Blocks.wooden_slab,4);bb.buildBlock(-5,9,5,Blocks.wooden_slab,4);
		bb.buildBlock(-4,9,-5,Blocks.wooden_slab,4);bb.buildBlock(-4,9,-4,Blocks.wooden_slab,4);bb.buildBlock(-4,9,4,Blocks.wooden_slab,4);
		bb.buildBlock(-4,9,5,Blocks.wooden_slab,4);bb.buildBlock(-3,9,-5,Blocks.wooden_slab,4);bb.buildBlock(-3,9,5,Blocks.wooden_slab,4);
		bb.buildBlock(-2,9,-5,Blocks.wooden_slab,4);bb.buildBlock(-2,9,5,Blocks.wooden_slab,4);bb.buildBlock(-1,9,-5,Blocks.wooden_slab,4);
		bb.buildBlock(-1,9,5,Blocks.wooden_slab,4);bb.buildBlock(0,9,-5,Blocks.wooden_slab,4);bb.buildBlock(0,9,-4,Blocks.wooden_slab,4);
		bb.buildBlock(0,9,4,Blocks.wooden_slab,4);bb.buildBlock(0,9,5,Blocks.wooden_slab,4);bb.buildBlock(1,9,-5,Blocks.wooden_slab,4);
		bb.buildBlock(1,9,-4,Blocks.wooden_slab,4);bb.buildBlock(1,9,-3,Blocks.wooden_slab,4);bb.buildBlock(1,9,-2,Blocks.wooden_slab,4);
		bb.buildBlock(1,9,-1,Blocks.wooden_slab,4);bb.buildBlock(1,9,0,Blocks.wooden_slab,4);bb.buildBlock(1,9,1,Blocks.wooden_slab,4);
		bb.buildBlock(1,9,2,Blocks.wooden_slab,4);bb.buildBlock(1,9,3,Blocks.wooden_slab,4);bb.buildBlock(1,9,4,Blocks.wooden_slab,4);
		bb.buildBlock(1,9,5,Blocks.wooden_slab,4);bb.buildBlock(1,1,-5,Blocks.torch,5);bb.buildBlock(1,1,5,Blocks.torch,5);
		bb.buildBlock(2,1,-1,Blocks.torch,1);bb.buildBlock(2,1,2,Blocks.torch,1);bb.buildBlock(5,1,-5,Blocks.torch,5);
		bb.buildBlock(5,1,-2,Blocks.torch,5);bb.buildBlock(5,1,2,Blocks.torch,5);bb.buildBlock(5,1,5,Blocks.torch,5);
		bb.buildBlock(-3,2,3,Blocks.torch,4);bb.buildBlock(0,2,-3,Blocks.torch,3);bb.buildBlock(0,2,3,Blocks.torch,4);
		bb.buildBlock(1,5,-2,Blocks.torch,1);bb.buildBlock(1,5,1,Blocks.torch,1);bb.buildBlock(-3,7,-3,Blocks.torch,3);
		bb.buildBlock(-3,7,3,Blocks.torch,4);bb.buildBlock(-1,7,-3,Blocks.torch,3);bb.buildBlock(-1,7,3,Blocks.torch,4);



	}

}
