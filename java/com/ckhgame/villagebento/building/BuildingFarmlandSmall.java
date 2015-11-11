package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerFarmerSmall;

import net.minecraft.init.Blocks;

public class BuildingFarmlandSmall extends Building {

	@Override
	public String getName() {
		return "Small Farm";
	}

	@Override
	public String getDescription() {
		return "Grow the Crops";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerFarmerSmall.class,"Jimmy",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-5,-1,-5,Blocks.grass,0);bb.buildBlock(-5,-1,5,Blocks.grass,0);bb.buildBlock(-4,-1,-5,Blocks.grass,0);
		bb.buildBlock(-4,-1,5,Blocks.grass,0);bb.buildBlock(-3,-1,-5,Blocks.grass,0);bb.buildBlock(-3,-1,5,Blocks.grass,0);
		bb.buildBlock(-2,-1,-5,Blocks.grass,0);bb.buildBlock(-2,-1,5,Blocks.grass,0);bb.buildBlock(-1,-1,-5,Blocks.grass,0);
		bb.buildBlock(-1,-1,5,Blocks.grass,0);bb.buildBlock(0,-1,-5,Blocks.grass,0);bb.buildBlock(0,-1,-4,Blocks.grass,0);
		bb.buildBlock(0,-1,-3,Blocks.grass,0);bb.buildBlock(0,-1,-2,Blocks.grass,0);bb.buildBlock(0,-1,-1,Blocks.grass,0);
		bb.buildBlock(0,-1,0,Blocks.grass,0);bb.buildBlock(0,-1,1,Blocks.grass,0);bb.buildBlock(0,-1,2,Blocks.grass,0);
		bb.buildBlock(0,-1,3,Blocks.grass,0);bb.buildBlock(0,-1,4,Blocks.grass,0);bb.buildBlock(0,-1,5,Blocks.grass,0);
		bb.buildBlock(1,-1,-5,Blocks.grass,0);bb.buildBlock(1,-1,-4,Blocks.grass,0);bb.buildBlock(1,-1,-3,Blocks.water,0);
		bb.buildBlock(1,-1,-2,Blocks.farmland,7);bb.buildBlock(1,-1,-1,Blocks.farmland,7);bb.buildBlock(1,-1,0,Blocks.water,0);
		bb.buildBlock(1,-1,1,Blocks.grass,0);bb.buildBlock(1,-1,2,Blocks.grass,0);bb.buildBlock(1,-1,3,Blocks.grass,0);
		bb.buildBlock(1,-1,4,Blocks.grass,0);bb.buildBlock(1,-1,5,Blocks.grass,0);bb.buildBlock(2,-1,-5,Blocks.grass,0);
		bb.buildBlock(2,-1,-4,Blocks.grass,0);bb.buildBlock(2,-1,-3,Blocks.water,0);bb.buildBlock(2,-1,-2,Blocks.farmland,7);
		bb.buildBlock(2,-1,-1,Blocks.farmland,7);bb.buildBlock(2,-1,0,Blocks.water,0);bb.buildBlock(2,-1,1,Blocks.grass,0);
		bb.buildBlock(2,-1,2,Blocks.grass,0);bb.buildBlock(2,-1,3,Blocks.grass,0);bb.buildBlock(2,-1,4,Blocks.grass,0);
		bb.buildBlock(2,-1,5,Blocks.grass,0);bb.buildBlock(3,-1,-5,Blocks.grass,0);bb.buildBlock(3,-1,-4,Blocks.grass,0);
		bb.buildBlock(3,-1,-3,Blocks.water,0);bb.buildBlock(3,-1,-2,Blocks.farmland,7);bb.buildBlock(3,-1,-1,Blocks.farmland,7);
		bb.buildBlock(3,-1,0,Blocks.water,0);bb.buildBlock(3,-1,1,Blocks.grass,0);bb.buildBlock(3,-1,2,Blocks.grass,0);
		bb.buildBlock(3,-1,3,Blocks.grass,0);bb.buildBlock(3,-1,4,Blocks.grass,0);bb.buildBlock(3,-1,5,Blocks.grass,0);
		bb.buildBlock(4,-1,-5,Blocks.grass,0);bb.buildBlock(4,-1,-4,Blocks.grass,0);bb.buildBlock(4,-1,-3,Blocks.grass,0);
		bb.buildBlock(4,-1,-2,Blocks.grass,0);bb.buildBlock(4,-1,-1,Blocks.grass,0);bb.buildBlock(4,-1,0,Blocks.grass,0);
		bb.buildBlock(4,-1,1,Blocks.grass,0);bb.buildBlock(4,-1,2,Blocks.grass,0);bb.buildBlock(4,-1,3,Blocks.grass,0);
		bb.buildBlock(4,-1,4,Blocks.grass,0);bb.buildBlock(4,-1,5,Blocks.grass,0);bb.buildBlock(5,-1,-5,Blocks.grass,0);
		bb.buildBlock(5,-1,-4,Blocks.grass,0);bb.buildBlock(5,-1,-3,Blocks.grass,0);bb.buildBlock(5,-1,-2,Blocks.grass,0);
		bb.buildBlock(5,-1,-1,Blocks.grass,0);bb.buildBlock(5,-1,0,Blocks.grass,0);bb.buildBlock(5,-1,1,Blocks.dirt,0);
		bb.buildBlock(5,-1,2,Blocks.grass,0);bb.buildBlock(5,-1,3,Blocks.dirt,0);bb.buildBlock(5,-1,4,Blocks.grass,0);
		bb.buildBlock(5,-1,5,Blocks.grass,0);bb.buildBlock(-5,0,-5,Blocks.fence,0);bb.buildBlock(-5,0,-4,Blocks.planks,2);
		bb.buildBlock(-5,0,-3,Blocks.planks,2);bb.buildBlock(-5,0,-2,Blocks.planks,2);bb.buildBlock(-5,0,-1,Blocks.planks,2);
		bb.buildBlock(-5,0,0,Blocks.planks,2);bb.buildBlock(-5,0,1,Blocks.planks,2);bb.buildBlock(-5,0,2,Blocks.planks,2);
		bb.buildBlock(-5,0,3,Blocks.planks,2);bb.buildBlock(-5,0,4,Blocks.planks,2);bb.buildBlock(-5,0,5,Blocks.fence,0);
		bb.buildBlock(-4,0,-5,Blocks.fence,0);bb.buildBlock(-4,0,-3,Blocks.hay_block,0);bb.buildBlock(-4,0,-2,Blocks.hay_block,0);
		bb.buildBlock(-4,0,-1,Blocks.planks,2);bb.buildBlock(-4,0,0,Blocks.bed,10);bb.buildBlock(-4,0,1,Blocks.bed,2);
		bb.buildBlock(-4,0,3,Blocks.hay_block,8);bb.buildBlock(-4,0,4,Blocks.planks,2);bb.buildBlock(-4,0,5,Blocks.fence,0);
		bb.buildBlock(-3,0,-5,Blocks.fence,0);bb.buildBlock(-3,0,-2,Blocks.hay_block,4);bb.buildBlock(-3,0,-1,Blocks.planks,2);
		bb.buildBlock(-3,0,0,Blocks.chest,3);bb.buildBlock(-3,0,3,Blocks.hay_block,8);bb.buildBlock(-3,0,4,Blocks.planks,2);bb.buildBlock(-3,0,5,Blocks.fence,0);
		bb.buildBlock(-2,0,-5,Blocks.fence,0);bb.buildBlock(-2,0,-2,Blocks.hay_block,0);bb.buildBlock(-2,0,-1,Blocks.planks,2);
		bb.buildBlock(-2,0,0,Blocks.planks,2);bb.buildBlock(-2,0,3,Blocks.hay_block,0);bb.buildBlock(-2,0,4,Blocks.planks,2);
		bb.buildBlock(-2,0,5,Blocks.fence,0);bb.buildBlock(-1,0,-5,Blocks.fence,0);bb.buildBlock(-1,0,-1,Blocks.planks,2);
		bb.buildBlock(-1,0,0,Blocks.planks,2);bb.buildBlock(-1,0,1,Blocks.planks,2);bb.buildBlock(-1,0,2,Blocks.wooden_door,0);
		bb.buildBlock(-1,0,3,Blocks.planks,2);bb.buildBlock(-1,0,4,Blocks.planks,2);bb.buildBlock(-1,0,5,Blocks.fence,0);
		bb.buildBlock(0,0,-5,Blocks.fence,0);bb.buildBlock(0,0,5,Blocks.fence,0);bb.buildBlock(1,0,-5,Blocks.fence,0);
		bb.buildBlock(1,0,-3,Blocks.fence,0);bb.buildBlock(1,0,-2,Blocks.wheat,7);bb.buildBlock(1,0,-1,Blocks.wheat,7);
		bb.buildBlock(1,0,0,Blocks.fence,0);bb.buildBlock(1,0,5,Blocks.fence,0);bb.buildBlock(2,0,-5,Blocks.fence,0);
		bb.buildBlock(2,0,-2,Blocks.wheat,7);bb.buildBlock(2,0,-1,Blocks.wheat,6);bb.buildBlock(2,0,5,Blocks.fence,0);
		bb.buildBlock(3,0,-5,Blocks.fence,0);bb.buildBlock(3,0,-3,Blocks.fence,0);bb.buildBlock(3,0,-2,Blocks.wheat,7);
		bb.buildBlock(3,0,-1,Blocks.wheat,7);bb.buildBlock(3,0,0,Blocks.fence,0);bb.buildBlock(3,0,5,Blocks.fence,0);
		bb.buildBlock(4,0,-5,Blocks.fence,0);bb.buildBlock(4,0,5,Blocks.fence,0);bb.buildBlock(5,0,-5,Blocks.fence,0);
		bb.buildBlock(5,0,-4,Blocks.fence,0);bb.buildBlock(5,0,-3,Blocks.fence,0);bb.buildBlock(5,0,-2,Blocks.fence,0);
		bb.buildBlock(5,0,-1,Blocks.fence,0);bb.buildBlock(5,0,0,Blocks.fence,0);bb.buildBlock(5,0,1,Blocks.planks,1);
		bb.buildBlock(5,0,2,Blocks.wooden_door,0);bb.buildBlock(5,0,3,Blocks.planks,1);bb.buildBlock(5,0,4,Blocks.fence,0);
		bb.buildBlock(5,0,5,Blocks.fence,0);bb.buildBlock(-5,1,-4,Blocks.planks,2);bb.buildBlock(-5,1,-3,Blocks.planks,2);
		bb.buildBlock(-5,1,-2,Blocks.planks,2);bb.buildBlock(-5,1,-1,Blocks.planks,2);bb.buildBlock(-5,1,0,Blocks.planks,2);
		bb.buildBlock(-5,1,1,Blocks.planks,2);bb.buildBlock(-5,1,2,Blocks.planks,2);bb.buildBlock(-5,1,3,Blocks.planks,2);
		bb.buildBlock(-5,1,4,Blocks.planks,2);bb.buildBlock(-4,1,-2,Blocks.hay_block,4);bb.buildBlock(-4,1,-1,Blocks.planks,2);
		bb.buildBlock(-4,1,4,Blocks.planks,2);bb.buildBlock(-3,1,-2,Blocks.hay_block,0);bb.buildBlock(-3,1,-1,Blocks.planks,2);
		bb.buildBlock(-3,1,4,Blocks.glass_pane,0);bb.buildBlock(-2,1,-1,Blocks.planks,2);bb.buildBlock(-2,1,0,Blocks.flower_pot,8);
		bb.addTileEntityPot(-2,1,0,38,8);
		bb.buildBlock(-2,1,4,Blocks.planks,2);bb.buildBlock(-1,1,-1,Blocks.planks,2);bb.buildBlock(-1,1,0,Blocks.glass_pane,0);
		bb.buildBlock(-1,1,1,Blocks.planks,2);bb.buildBlock(-1,1,2,Blocks.wooden_door,8);bb.buildBlock(-1,1,3,Blocks.planks,2);
		bb.buildBlock(-1,1,4,Blocks.planks,2);bb.buildBlock(1,1,-3,Blocks.wooden_slab,1);bb.buildBlock(1,1,-2,Blocks.wooden_slab,1);
		bb.buildBlock(1,1,-1,Blocks.wooden_slab,1);bb.buildBlock(1,1,0,Blocks.wooden_slab,1);bb.buildBlock(2,1,-3,Blocks.wooden_slab,1);
		bb.buildBlock(2,1,0,Blocks.wooden_slab,1);bb.buildBlock(3,1,-3,Blocks.wooden_slab,1);bb.buildBlock(3,1,-2,Blocks.wooden_slab,1);
		bb.buildBlock(3,1,-1,Blocks.wooden_slab,1);bb.buildBlock(3,1,0,Blocks.wooden_slab,1);bb.buildBlock(5,1,1,Blocks.planks,1);
		bb.buildBlock(5,1,2,Blocks.wooden_door,8);bb.buildBlock(5,1,3,Blocks.planks,1);bb.buildBlock(-5,2,-4,Blocks.wooden_slab,9);
		bb.buildBlock(-5,2,-3,Blocks.wooden_slab,9);bb.buildBlock(-5,2,-2,Blocks.wooden_slab,9);bb.buildBlock(-5,2,-1,Blocks.planks,2);
		bb.buildBlock(-5,2,0,Blocks.planks,2);bb.buildBlock(-5,2,1,Blocks.planks,2);bb.buildBlock(-5,2,2,Blocks.planks,2);
		bb.buildBlock(-5,2,3,Blocks.planks,2);bb.buildBlock(-5,2,4,Blocks.planks,2);bb.buildBlock(-4,2,-4,Blocks.wooden_slab,9);
		bb.buildBlock(-4,2,-3,Blocks.wooden_slab,9);bb.buildBlock(-4,2,-2,Blocks.wooden_slab,9);bb.buildBlock(-4,2,-1,Blocks.planks,2);
		bb.buildBlock(-4,2,4,Blocks.planks,2);bb.buildBlock(-3,2,-4,Blocks.wooden_slab,9);bb.buildBlock(-3,2,-3,Blocks.wooden_slab,9);
		bb.buildBlock(-3,2,-2,Blocks.wooden_slab,9);bb.buildBlock(-3,2,-1,Blocks.planks,2);bb.buildBlock(-3,2,4,Blocks.planks,2);
		bb.buildBlock(-2,2,-4,Blocks.wooden_slab,9);bb.buildBlock(-2,2,-3,Blocks.wooden_slab,9);bb.buildBlock(-2,2,-2,Blocks.wooden_slab,9);
		bb.buildBlock(-2,2,-1,Blocks.planks,2);bb.buildBlock(-2,2,4,Blocks.planks,2);bb.buildBlock(-1,2,-3,Blocks.wooden_slab,9);
		bb.buildBlock(-1,2,-2,Blocks.wooden_slab,9);bb.buildBlock(-1,2,-1,Blocks.planks,2);bb.buildBlock(-1,2,0,Blocks.planks,2);
		bb.buildBlock(-1,2,1,Blocks.planks,2);bb.buildBlock(-1,2,2,Blocks.planks,2);bb.buildBlock(-1,2,3,Blocks.planks,2);
		bb.buildBlock(-1,2,4,Blocks.planks,2);bb.buildBlock(5,2,1,Blocks.wooden_slab,2);bb.buildBlock(5,2,2,Blocks.wooden_slab,2);
		bb.buildBlock(5,2,3,Blocks.wooden_slab,2);bb.buildBlock(-5,3,-1,Blocks.spruce_stairs,2);bb.buildBlock(-5,3,0,Blocks.spruce_stairs,0);
		bb.buildBlock(-5,3,1,Blocks.spruce_stairs,0);bb.buildBlock(-5,3,2,Blocks.spruce_stairs,0);bb.buildBlock(-5,3,3,Blocks.spruce_stairs,0);
		bb.buildBlock(-5,3,4,Blocks.spruce_stairs,0);bb.buildBlock(-4,3,-1,Blocks.spruce_stairs,2);bb.buildBlock(-4,3,0,Blocks.wooden_slab,9);
		bb.buildBlock(-4,3,1,Blocks.wooden_slab,9);bb.buildBlock(-4,3,2,Blocks.wooden_slab,9);bb.buildBlock(-4,3,3,Blocks.wooden_slab,9);
		bb.buildBlock(-4,3,4,Blocks.spruce_stairs,3);bb.buildBlock(-3,3,-1,Blocks.spruce_stairs,2);bb.buildBlock(-3,3,0,Blocks.wooden_slab,9);
		bb.buildBlock(-3,3,1,Blocks.wooden_slab,9);bb.buildBlock(-3,3,2,Blocks.wooden_slab,9);bb.buildBlock(-3,3,3,Blocks.wooden_slab,9);
		bb.buildBlock(-3,3,4,Blocks.spruce_stairs,3);bb.buildBlock(-2,3,-1,Blocks.spruce_stairs,2);bb.buildBlock(-2,3,0,Blocks.wooden_slab,9);
		bb.buildBlock(-2,3,1,Blocks.wooden_slab,9);bb.buildBlock(-2,3,2,Blocks.wooden_slab,9);bb.buildBlock(-2,3,3,Blocks.wooden_slab,9);
		bb.buildBlock(-2,3,4,Blocks.spruce_stairs,3);bb.buildBlock(-1,3,-1,Blocks.spruce_stairs,2);bb.buildBlock(-1,3,0,Blocks.spruce_stairs,1);
		bb.buildBlock(-1,3,1,Blocks.spruce_stairs,1);bb.buildBlock(-1,3,2,Blocks.spruce_stairs,1);bb.buildBlock(-1,3,3,Blocks.spruce_stairs,1);
		bb.buildBlock(-1,3,4,Blocks.spruce_stairs,3);bb.buildBlock(-5,1,-5,Blocks.torch,5);bb.buildBlock(-5,1,5,Blocks.torch,5);
		bb.buildBlock(-4,1,-3,Blocks.torch,1);bb.buildBlock(-2,1,-5,Blocks.torch,5);bb.buildBlock(-2,1,-2,Blocks.torch,4);
		bb.buildBlock(-1,1,5,Blocks.torch,5);bb.buildBlock(0,1,1,Blocks.torch,1);bb.buildBlock(0,1,3,Blocks.torch,1);
		bb.buildBlock(1,1,-5,Blocks.torch,5);bb.buildBlock(2,1,5,Blocks.torch,5);bb.buildBlock(5,1,-5,Blocks.torch,5);
		bb.buildBlock(5,1,-3,Blocks.torch,5);bb.buildBlock(5,1,0,Blocks.torch,5);bb.buildBlock(5,1,5,Blocks.torch,5);
		bb.buildBlock(-4,2,0,Blocks.torch,1);bb.buildBlock(-4,2,3,Blocks.torch,1);bb.buildBlock(-2,2,0,Blocks.torch,2);
		bb.buildBlock(-2,2,3,Blocks.torch,2);bb.addEntityPainting(-5,2,2,3,"Sea");
	}

}
