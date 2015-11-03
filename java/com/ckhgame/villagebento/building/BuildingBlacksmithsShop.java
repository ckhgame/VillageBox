package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;

import net.minecraft.init.Blocks;

public class BuildingBlacksmithsShop extends Building {

	@Override
	public String getName() {
		return "Blacksmith's Shop";
	}

	@Override
	public String getDescription() {
		return "Good weapons and armors!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
	//	bb.addBuildingVillager(VillagerProfessions.Miner,"Miner1","Miner",1,0);
		//bb.addBuildingVillager(VillagerProfessions.Miner,"Miner2","Miner",-1,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		bb.buildBlock(-3,0,-3,Blocks.planks,0);bb.buildBlock(-3,0,-2,Blocks.planks,0);bb.buildBlock(-3,0,-1,Blocks.planks,0);
		bb.buildBlock(-3,0,0,Blocks.planks,0);bb.buildBlock(-3,0,1,Blocks.planks,0);bb.buildBlock(-3,0,2,Blocks.planks,0);
		bb.buildBlock(-3,0,3,Blocks.planks,0);bb.buildBlock(-2,0,-3,Blocks.planks,0);bb.buildBlock(-2,0,-1,Blocks.oak_stairs,1);
		bb.buildBlock(-2,0,0,Blocks.pumpkin,3);bb.buildBlock(-2,0,1,Blocks.trapped_chest,5);bb.buildBlock(-2,0,3,Blocks.planks,0);
		bb.buildBlock(-1,0,-3,Blocks.planks,0);bb.buildBlock(-1,0,-2,Blocks.trapped_chest,3);bb.buildBlock(-1,0,2,Blocks.trapped_chest,2);
		bb.buildBlock(-1,0,3,Blocks.planks,0);bb.buildBlock(0,0,-3,Blocks.planks,0);bb.buildBlock(0,0,-2,Blocks.log,4);
		bb.buildBlock(0,0,-1,Blocks.bed,9);bb.buildBlock(0,0,2,Blocks.log,1);bb.buildBlock(0,0,3,Blocks.planks,0);
		bb.buildBlock(1,0,-3,Blocks.planks,0);bb.buildBlock(1,0,-2,Blocks.log,8);bb.buildBlock(1,0,-1,Blocks.bed,1);
		bb.buildBlock(1,0,2,Blocks.log,3);bb.buildBlock(1,0,3,Blocks.planks,0);bb.buildBlock(2,0,-3,Blocks.planks,0);
		bb.buildBlock(2,0,-2,Blocks.log,0);bb.buildBlock(2,0,2,Blocks.log,2);bb.buildBlock(2,0,3,Blocks.planks,0);
		bb.buildBlock(3,0,-3,Blocks.planks,0);bb.buildBlock(3,0,-2,Blocks.planks,0);bb.buildBlock(3,0,-1,Blocks.planks,0);
		bb.buildBlock(3,0,1,Blocks.planks,0);bb.buildBlock(3,0,2,Blocks.planks,0);bb.buildBlock(3,0,3,Blocks.planks,0);
		bb.buildBlock(-3,1,-3,Blocks.planks,0);bb.buildBlock(-3,1,-2,Blocks.planks,0);bb.buildBlock(-3,1,-1,Blocks.planks,0);
		bb.buildBlock(-3,1,0,Blocks.planks,0);bb.buildBlock(-3,1,1,Blocks.planks,0);bb.buildBlock(-3,1,2,Blocks.planks,0);
		bb.buildBlock(-3,1,3,Blocks.planks,0);bb.buildBlock(-2,1,-3,Blocks.planks,0);bb.buildBlock(-2,1,-1,Blocks.oak_stairs,5);
		bb.buildBlock(-2,1,1,Blocks.torch,1);bb.buildBlock(-2,1,3,Blocks.planks,0);bb.buildBlock(-1,1,-3,Blocks.planks,0);
		bb.buildBlock(-1,1,3,Blocks.planks,0);bb.buildBlock(0,1,-3,Blocks.planks,0);bb.buildBlock(0,1,-2,Blocks.torch,3);
		bb.buildBlock(0,1,2,Blocks.torch,4);bb.buildBlock(0,1,3,Blocks.planks,0);bb.buildBlock(1,1,-3,Blocks.planks,0);
		bb.buildBlock(1,1,3,Blocks.planks,0);bb.buildBlock(2,1,-3,Blocks.planks,0);bb.buildBlock(2,1,3,Blocks.planks,0);
		bb.buildBlock(3,1,-3,Blocks.planks,0);bb.buildBlock(3,1,-2,Blocks.planks,0);bb.buildBlock(3,1,-1,Blocks.planks,0);
		bb.buildBlock(3,1,1,Blocks.planks,0);bb.buildBlock(3,1,2,Blocks.planks,0);bb.buildBlock(3,1,3,Blocks.planks,0);
		bb.buildBlock(-1,2,3,Blocks.wool,14);bb.buildBlock(0,2,3,Blocks.wool,5);bb.buildBlock(1,2,3,Blocks.wool,3);
	}

}
