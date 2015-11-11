package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerCasinoManager;

import net.minecraft.init.Blocks;

public class BuildingSmallCasino extends Building {

	@Override
	public String getName() {
		return "Small Casino";
	}

	@Override
	public String getDescription() {
		return "Gambling";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerCasinoManager.class,"Roger",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-7,-3,Blocks.air,0);bb.buildBlock(-3,-7,-2,Blocks.air,0);bb.buildBlock(-3,-7,-1,Blocks.air,0);
		bb.buildBlock(-3,-7,0,Blocks.air,0);bb.buildBlock(-3,-7,1,Blocks.air,0);bb.buildBlock(-3,-7,2,Blocks.air,0);
		bb.buildBlock(-3,-7,3,Blocks.air,0);bb.buildBlock(-2,-7,-3,Blocks.air,0);bb.buildBlock(-2,-7,-2,Blocks.air,0);
		bb.buildBlock(-2,-7,-1,Blocks.air,0);bb.buildBlock(-2,-7,0,Blocks.air,0);bb.buildBlock(-2,-7,1,Blocks.air,0);
		bb.buildBlock(-2,-7,2,Blocks.air,0);bb.buildBlock(-2,-7,3,Blocks.air,0);bb.buildBlock(-1,-7,-3,Blocks.air,0);
		bb.buildBlock(-1,-7,-2,Blocks.air,0);bb.buildBlock(-1,-7,-1,Blocks.air,0);bb.buildBlock(-1,-7,0,Blocks.air,0);
		bb.buildBlock(-1,-7,1,Blocks.air,0);bb.buildBlock(-1,-7,2,Blocks.air,0);bb.buildBlock(-1,-7,3,Blocks.air,0);
		bb.buildBlock(0,-7,-3,Blocks.air,0);bb.buildBlock(0,-7,-2,Blocks.air,0);bb.buildBlock(0,-7,-1,Blocks.air,0);
		bb.buildBlock(0,-7,0,Blocks.air,0);bb.buildBlock(0,-7,1,Blocks.air,0);bb.buildBlock(0,-7,2,Blocks.air,0);
		bb.buildBlock(0,-7,3,Blocks.air,0);bb.buildBlock(1,-7,-3,Blocks.air,0);bb.buildBlock(1,-7,-2,Blocks.air,0);
		bb.buildBlock(1,-7,-1,Blocks.air,0);bb.buildBlock(1,-7,0,Blocks.air,0);bb.buildBlock(1,-7,1,Blocks.air,0);
		bb.buildBlock(1,-7,2,Blocks.air,0);bb.buildBlock(1,-7,3,Blocks.air,0);bb.buildBlock(2,-7,-3,Blocks.air,0);
		bb.buildBlock(2,-7,-2,Blocks.air,0);bb.buildBlock(2,-7,-1,Blocks.air,0);bb.buildBlock(2,-7,0,Blocks.air,0);
		bb.buildBlock(2,-7,1,Blocks.air,0);bb.buildBlock(2,-7,2,Blocks.air,0);bb.buildBlock(2,-7,3,Blocks.air,0);
		bb.buildBlock(3,-7,-3,Blocks.air,0);bb.buildBlock(3,-7,-2,Blocks.air,0);bb.buildBlock(3,-7,-1,Blocks.air,0);
		bb.buildBlock(3,-7,0,Blocks.air,0);bb.buildBlock(3,-7,1,Blocks.air,0);bb.buildBlock(3,-7,2,Blocks.air,0);
		bb.buildBlock(3,-7,3,Blocks.air,0);bb.buildBlock(-3,-6,-3,Blocks.air,0);bb.buildBlock(-3,-6,-2,Blocks.air,0);
		bb.buildBlock(-3,-6,-1,Blocks.air,0);bb.buildBlock(-3,-6,0,Blocks.air,0);bb.buildBlock(-3,-6,1,Blocks.air,0);
		bb.buildBlock(-3,-6,2,Blocks.air,0);bb.buildBlock(-3,-6,3,Blocks.air,0);bb.buildBlock(-2,-6,-3,Blocks.air,0);
		bb.buildBlock(-2,-6,-2,Blocks.air,0);bb.buildBlock(-2,-6,-1,Blocks.air,0);bb.buildBlock(-2,-6,0,Blocks.air,0);
		bb.buildBlock(-2,-6,1,Blocks.air,0);bb.buildBlock(-2,-6,2,Blocks.air,0);bb.buildBlock(-2,-6,3,Blocks.air,0);
		bb.buildBlock(-1,-6,-3,Blocks.air,0);bb.buildBlock(-1,-6,-2,Blocks.air,0);bb.buildBlock(-1,-6,-1,Blocks.air,0);
		bb.buildBlock(-1,-6,0,Blocks.air,0);bb.buildBlock(-1,-6,1,Blocks.air,0);bb.buildBlock(-1,-6,2,Blocks.air,0);
		bb.buildBlock(-1,-6,3,Blocks.air,0);bb.buildBlock(0,-6,-3,Blocks.air,0);bb.buildBlock(0,-6,-2,Blocks.air,0);
		bb.buildBlock(0,-6,-1,Blocks.air,0);bb.buildBlock(0,-6,0,Blocks.air,0);bb.buildBlock(0,-6,1,Blocks.air,0);
		bb.buildBlock(0,-6,2,Blocks.air,0);bb.buildBlock(0,-6,3,Blocks.air,0);bb.buildBlock(1,-6,-3,Blocks.air,0);
		bb.buildBlock(1,-6,-2,Blocks.air,0);bb.buildBlock(1,-6,-1,Blocks.air,0);bb.buildBlock(1,-6,0,Blocks.air,0);
		bb.buildBlock(1,-6,1,Blocks.air,0);bb.buildBlock(1,-6,2,Blocks.air,0);bb.buildBlock(1,-6,3,Blocks.air,0);
		bb.buildBlock(2,-6,-3,Blocks.air,0);bb.buildBlock(2,-6,-2,Blocks.air,0);bb.buildBlock(2,-6,-1,Blocks.air,0);
		bb.buildBlock(2,-6,0,Blocks.air,0);bb.buildBlock(2,-6,1,Blocks.air,0);bb.buildBlock(2,-6,2,Blocks.air,0);
		bb.buildBlock(2,-6,3,Blocks.air,0);bb.buildBlock(3,-6,-3,Blocks.air,0);bb.buildBlock(3,-6,-2,Blocks.air,0);
		bb.buildBlock(3,-6,-1,Blocks.air,0);bb.buildBlock(3,-6,0,Blocks.air,0);bb.buildBlock(3,-6,1,Blocks.air,0);
		bb.buildBlock(3,-6,2,Blocks.air,0);bb.buildBlock(3,-6,3,Blocks.air,0);bb.buildBlock(-3,-5,-3,Blocks.air,0);
		bb.buildBlock(-3,-5,-2,Blocks.air,0);bb.buildBlock(-3,-5,-1,Blocks.air,0);bb.buildBlock(-3,-5,0,Blocks.air,0);
		bb.buildBlock(-3,-5,1,Blocks.air,0);bb.buildBlock(-3,-5,2,Blocks.air,0);bb.buildBlock(-3,-5,3,Blocks.air,0);
		bb.buildBlock(-2,-5,-3,Blocks.air,0);bb.buildBlock(-2,-5,-2,Blocks.air,0);bb.buildBlock(-2,-5,-1,Blocks.air,0);
		bb.buildBlock(-2,-5,0,Blocks.air,0);bb.buildBlock(-2,-5,1,Blocks.air,0);bb.buildBlock(-2,-5,2,Blocks.air,0);
		bb.buildBlock(-2,-5,3,Blocks.air,0);bb.buildBlock(-1,-5,-3,Blocks.air,0);bb.buildBlock(-1,-5,-2,Blocks.air,0);
		bb.buildBlock(-1,-5,-1,Blocks.air,0);bb.buildBlock(-1,-5,0,Blocks.air,0);bb.buildBlock(-1,-5,1,Blocks.air,0);
		bb.buildBlock(-1,-5,2,Blocks.air,0);bb.buildBlock(-1,-5,3,Blocks.air,0);bb.buildBlock(0,-5,-3,Blocks.air,0);
		bb.buildBlock(0,-5,-2,Blocks.air,0);bb.buildBlock(0,-5,-1,Blocks.air,0);bb.buildBlock(0,-5,0,Blocks.air,0);
		bb.buildBlock(0,-5,1,Blocks.air,0);bb.buildBlock(0,-5,2,Blocks.air,0);bb.buildBlock(0,-5,3,Blocks.air,0);
		bb.buildBlock(1,-5,-3,Blocks.air,0);bb.buildBlock(1,-5,-2,Blocks.air,0);bb.buildBlock(1,-5,-1,Blocks.air,0);
		bb.buildBlock(1,-5,0,Blocks.air,0);bb.buildBlock(1,-5,1,Blocks.air,0);bb.buildBlock(1,-5,2,Blocks.air,0);
		bb.buildBlock(1,-5,3,Blocks.air,0);bb.buildBlock(2,-5,-3,Blocks.air,0);bb.buildBlock(2,-5,-2,Blocks.air,0);
		bb.buildBlock(2,-5,-1,Blocks.air,0);bb.buildBlock(2,-5,0,Blocks.air,0);bb.buildBlock(2,-5,1,Blocks.air,0);
		bb.buildBlock(2,-5,2,Blocks.air,0);bb.buildBlock(2,-5,3,Blocks.air,0);bb.buildBlock(3,-5,-3,Blocks.air,0);
		bb.buildBlock(3,-5,-2,Blocks.air,0);bb.buildBlock(3,-5,-1,Blocks.air,0);bb.buildBlock(3,-5,0,Blocks.air,0);
		bb.buildBlock(3,-5,1,Blocks.air,0);bb.buildBlock(3,-5,2,Blocks.air,0);bb.buildBlock(3,-5,3,Blocks.air,0);
		bb.buildBlock(-3,0,-3,Blocks.sandstone,2);bb.buildBlock(-3,0,-2,Blocks.sandstone,2);bb.buildBlock(-3,0,-1,Blocks.sandstone,2);
		bb.buildBlock(-3,0,0,Blocks.sandstone,2);bb.buildBlock(-3,0,1,Blocks.sandstone,2);bb.buildBlock(-3,0,2,Blocks.sandstone,2);
		bb.buildBlock(-3,0,3,Blocks.sandstone,2);bb.buildBlock(-2,0,-3,Blocks.sandstone,2);bb.buildBlock(-2,0,-2,Blocks.wooden_slab,2);
		bb.buildBlock(-2,0,-1,Blocks.wooden_slab,2);bb.buildBlock(-2,0,0,Blocks.bed,0);bb.buildBlock(-2,0,1,Blocks.bed,8);
		bb.buildBlock(-2,0,2,Blocks.chest,2);bb.buildBlock(-2,0,3,Blocks.sandstone,2);bb.buildBlock(-1,0,-3,Blocks.sandstone,2);bb.buildBlock(-1,0,-1,Blocks.planks,2);
		bb.buildBlock(-1,0,0,Blocks.planks,2);bb.buildBlock(-1,0,1,Blocks.planks,2);bb.buildBlock(-1,0,2,Blocks.planks,2);
		bb.buildBlock(-1,0,3,Blocks.sandstone,2);bb.buildBlock(0,0,-3,Blocks.sandstone,2);bb.buildBlock(0,0,3,Blocks.sandstone,2);
		bb.buildBlock(1,0,-3,Blocks.sandstone,2);bb.buildBlock(1,0,-1,Blocks.dark_oak_stairs,2);bb.buildBlock(1,0,1,Blocks.dark_oak_stairs,3);
		bb.buildBlock(1,0,3,Blocks.sandstone,2);bb.buildBlock(2,0,-3,Blocks.sandstone,2);bb.buildBlock(2,0,-1,Blocks.dark_oak_stairs,2);
		bb.buildBlock(2,0,1,Blocks.dark_oak_stairs,3);bb.buildBlock(2,0,3,Blocks.sandstone,2);bb.buildBlock(3,0,-3,Blocks.sandstone,2);
		bb.buildBlock(3,0,-2,Blocks.sandstone,2);bb.buildBlock(3,0,-1,Blocks.sandstone,2);bb.buildBlock(3,0,0,Blocks.wooden_door,0);
		bb.buildBlock(3,0,1,Blocks.sandstone,2);bb.buildBlock(3,0,2,Blocks.sandstone,2);bb.buildBlock(3,0,3,Blocks.sandstone,2);
		bb.buildBlock(-3,1,-3,Blocks.sandstone,2);bb.buildBlock(-3,1,-2,Blocks.glass_pane,0);bb.buildBlock(-3,1,-1,Blocks.sandstone,2);
		bb.buildBlock(-3,1,0,Blocks.glass_pane,0);bb.buildBlock(-3,1,1,Blocks.sandstone,2);bb.buildBlock(-3,1,2,Blocks.glass_pane,0);
		bb.buildBlock(-3,1,3,Blocks.sandstone,2);bb.buildBlock(-2,1,-3,Blocks.glass_pane,0);bb.buildBlock(-2,1,3,Blocks.glass_pane,0);
		bb.buildBlock(-1,1,-3,Blocks.sandstone,2);bb.buildBlock(-1,1,-1,Blocks.double_wooden_slab,2);bb.buildBlock(-1,1,0,Blocks.wooden_slab,10);
		bb.buildBlock(-1,1,1,Blocks.double_wooden_slab,2);bb.buildBlock(-1,1,2,Blocks.wooden_slab,10);bb.buildBlock(-1,1,3,Blocks.sandstone,2);
		bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.sandstone,2);
		bb.buildBlock(1,1,3,Blocks.sandstone,2);bb.buildBlock(2,1,-3,Blocks.glass_pane,0);bb.buildBlock(2,1,3,Blocks.glass_pane,0);
		bb.buildBlock(3,1,-3,Blocks.sandstone,2);bb.buildBlock(3,1,-2,Blocks.glass_pane,0);bb.buildBlock(3,1,-1,Blocks.sandstone,2);
		bb.buildBlock(3,1,0,Blocks.wooden_door,8);bb.buildBlock(3,1,1,Blocks.sandstone,2);bb.buildBlock(3,1,2,Blocks.glass_pane,0);
		bb.buildBlock(3,1,3,Blocks.sandstone,2);bb.buildBlock(-3,2,-3,Blocks.sandstone,2);bb.buildBlock(-3,2,-2,Blocks.glass_pane,0);
		bb.buildBlock(-3,2,-1,Blocks.sandstone,2);bb.buildBlock(-3,2,0,Blocks.glass_pane,0);bb.buildBlock(-3,2,1,Blocks.sandstone,2);
		bb.buildBlock(-3,2,2,Blocks.glass_pane,0);bb.buildBlock(-3,2,3,Blocks.sandstone,2);bb.buildBlock(-2,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(-2,2,3,Blocks.glass_pane,0);bb.buildBlock(-1,2,-3,Blocks.sandstone,2);bb.buildBlock(-1,2,-1,Blocks.double_wooden_slab,2);
		bb.buildBlock(-1,2,0,Blocks.flower_pot,0);bb.addTileEntityPot(-1,2,0,38,0);
		bb.buildBlock(-1,2,1,Blocks.flower_pot,7);bb.addTileEntityPot(-1,2,1,38,7);
		bb.buildBlock(-1,2,2,Blocks.flower_pot,0);bb.addTileEntityPot(-1,2,2,38,0);
		bb.buildBlock(-1,2,3,Blocks.sandstone,2);bb.buildBlock(0,2,-3,Blocks.glass_pane,0);bb.buildBlock(0,2,3,Blocks.glass_pane,0);
		bb.buildBlock(1,2,-3,Blocks.sandstone,2);bb.buildBlock(1,2,3,Blocks.sandstone,2);bb.buildBlock(2,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(2,2,3,Blocks.glass_pane,0);bb.buildBlock(3,2,-3,Blocks.sandstone,2);bb.buildBlock(3,2,-2,Blocks.glass_pane,0);
		bb.buildBlock(3,2,-1,Blocks.sandstone,2);bb.buildBlock(3,2,0,Blocks.sandstone,2);bb.buildBlock(3,2,1,Blocks.sandstone,2);
		bb.buildBlock(3,2,2,Blocks.glass_pane,0);bb.buildBlock(3,2,3,Blocks.sandstone,2);bb.buildBlock(-3,3,-3,Blocks.sandstone,2);
		bb.buildBlock(-3,3,-2,Blocks.sandstone,2);bb.buildBlock(-3,3,-1,Blocks.sandstone,2);bb.buildBlock(-3,3,0,Blocks.sandstone,2);
		bb.buildBlock(-3,3,1,Blocks.sandstone,2);bb.buildBlock(-3,3,2,Blocks.sandstone,2);bb.buildBlock(-3,3,3,Blocks.sandstone,2);
		bb.buildBlock(-2,3,-3,Blocks.sandstone,2);bb.buildBlock(-2,3,3,Blocks.sandstone,2);bb.buildBlock(-1,3,-3,Blocks.sandstone,2);
		bb.buildBlock(-1,3,-1,Blocks.wooden_slab,2);bb.buildBlock(-1,3,0,Blocks.wooden_slab,2);bb.buildBlock(-1,3,1,Blocks.wooden_slab,2);
		bb.buildBlock(-1,3,2,Blocks.wooden_slab,2);bb.buildBlock(-1,3,3,Blocks.sandstone,2);bb.buildBlock(0,3,-3,Blocks.sandstone,2);
		bb.buildBlock(0,3,3,Blocks.sandstone,2);bb.buildBlock(1,3,-3,Blocks.sandstone,2);bb.buildBlock(1,3,3,Blocks.sandstone,2);
		bb.buildBlock(2,3,-3,Blocks.sandstone,2);bb.buildBlock(2,3,3,Blocks.sandstone,2);bb.buildBlock(3,3,-3,Blocks.sandstone,2);
		bb.buildBlock(3,3,-2,Blocks.sandstone,2);bb.buildBlock(3,3,-1,Blocks.sandstone,2);bb.buildBlock(3,3,0,Blocks.sandstone,2);
		bb.buildBlock(3,3,1,Blocks.sandstone,2);bb.buildBlock(3,3,2,Blocks.sandstone,2);bb.buildBlock(3,3,3,Blocks.sandstone,2);
		bb.buildBlock(-3,4,-3,Blocks.wooden_slab,4);bb.buildBlock(-3,4,-2,Blocks.planks,4);bb.buildBlock(-3,4,-1,Blocks.wooden_slab,4);
		bb.buildBlock(-3,4,0,Blocks.planks,4);bb.buildBlock(-3,4,1,Blocks.wooden_slab,4);bb.buildBlock(-3,4,2,Blocks.planks,4);
		bb.buildBlock(-3,4,3,Blocks.wooden_slab,4);bb.buildBlock(-2,4,-3,Blocks.planks,4);bb.buildBlock(-2,4,-2,Blocks.planks,4);
		bb.buildBlock(-2,4,-1,Blocks.planks,4);bb.buildBlock(-2,4,0,Blocks.planks,4);bb.buildBlock(-2,4,1,Blocks.planks,4);
		bb.buildBlock(-2,4,2,Blocks.planks,4);bb.buildBlock(-2,4,3,Blocks.planks,4);bb.buildBlock(-1,4,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-1,4,-2,Blocks.planks,4);bb.buildBlock(-1,4,-1,Blocks.glass,0);bb.buildBlock(-1,4,0,Blocks.glass,0);
		bb.buildBlock(-1,4,1,Blocks.glass,0);bb.buildBlock(-1,4,2,Blocks.planks,4);bb.buildBlock(-1,4,3,Blocks.wooden_slab,4);
		bb.buildBlock(0,4,-3,Blocks.planks,4);bb.buildBlock(0,4,-2,Blocks.planks,4);bb.buildBlock(0,4,-1,Blocks.glass,0);
		bb.buildBlock(0,4,0,Blocks.planks,4);bb.buildBlock(0,4,1,Blocks.glass,0);bb.buildBlock(0,4,2,Blocks.planks,4);
		bb.buildBlock(0,4,3,Blocks.planks,4);bb.buildBlock(1,4,-3,Blocks.wooden_slab,4);bb.buildBlock(1,4,-2,Blocks.planks,4);
		bb.buildBlock(1,4,-1,Blocks.glass,0);bb.buildBlock(1,4,0,Blocks.glass,0);bb.buildBlock(1,4,1,Blocks.glass,0);
		bb.buildBlock(1,4,2,Blocks.planks,4);bb.buildBlock(1,4,3,Blocks.wooden_slab,4);bb.buildBlock(2,4,-3,Blocks.planks,4);
		bb.buildBlock(2,4,-2,Blocks.planks,4);bb.buildBlock(2,4,-1,Blocks.planks,4);bb.buildBlock(2,4,0,Blocks.planks,4);
		bb.buildBlock(2,4,1,Blocks.planks,4);bb.buildBlock(2,4,2,Blocks.planks,4);bb.buildBlock(2,4,3,Blocks.double_wooden_slab,4);
		bb.buildBlock(3,4,-3,Blocks.wooden_slab,4);bb.buildBlock(3,4,-2,Blocks.planks,4);bb.buildBlock(3,4,-1,Blocks.wooden_slab,4);
		bb.buildBlock(3,4,0,Blocks.planks,4);bb.buildBlock(3,4,1,Blocks.wooden_slab,4);bb.buildBlock(3,4,2,Blocks.planks,4);
		bb.buildBlock(3,4,3,Blocks.wooden_slab,4);bb.buildBlock(-2,5,-1,Blocks.wooden_slab,4);bb.buildBlock(-2,5,1,Blocks.wooden_slab,4);
		bb.buildBlock(-1,5,-2,Blocks.wooden_slab,4);bb.buildBlock(-1,5,2,Blocks.wooden_slab,4);bb.buildBlock(1,5,-2,Blocks.wooden_slab,4);
		bb.buildBlock(1,5,2,Blocks.wooden_slab,4);bb.buildBlock(2,5,-1,Blocks.wooden_slab,4);bb.buildBlock(2,5,1,Blocks.wooden_slab,4);
		bb.buildBlock(-2,2,-1,Blocks.torch,1);bb.buildBlock(-2,2,1,Blocks.torch,1);bb.buildBlock(2,2,-1,Blocks.torch,2);
		bb.buildBlock(2,2,1,Blocks.torch,2);bb.buildBlock(-2,3,-2,Blocks.torch,3);bb.buildBlock(0,3,-2,Blocks.torch,3);
		bb.buildBlock(0,3,2,Blocks.torch,4);bb.buildBlock(2,3,-2,Blocks.torch,3);bb.buildBlock(2,3,2,Blocks.torch,4);
	}

}
