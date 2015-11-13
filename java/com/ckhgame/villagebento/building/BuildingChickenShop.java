package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerChickenSeller;

import net.minecraft.init.Blocks;

public class BuildingChickenShop extends Building {

	@Override
	public String getName() {
		return "Chicken Products Shop";
	}

	@Override
	public String getDescription() {
		return "A sweet home for chickens.";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerChickenSeller.class,"Mina",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,0,-2,Blocks.planks,2);bb.buildBlock(-3,0,-1,Blocks.planks,2);bb.buildBlock(-3,0,0,Blocks.planks,2);
		bb.buildBlock(-3,0,1,Blocks.planks,2);bb.buildBlock(-3,0,2,Blocks.planks,2);bb.buildBlock(-2,0,-3,Blocks.planks,2);
		bb.buildBlock(-2,0,-2,Blocks.birch_stairs,3);bb.buildBlock(-2,0,-1,Blocks.wooden_slab,2);bb.buildBlock(-2,0,0,Blocks.bed,0);
		bb.buildBlock(-2,0,1,Blocks.bed,8);bb.buildBlock(-2,0,2,Blocks.birch_stairs,2);bb.buildBlock(-2,0,3,Blocks.planks,2);
		bb.buildBlock(-1,0,-3,Blocks.planks,2);bb.buildBlock(-1,0,-2,Blocks.birch_stairs,3);bb.buildBlock(-1,0,-1,Blocks.wooden_slab,2);
		bb.buildBlock(-1,0,0,Blocks.wooden_slab,2);bb.buildBlock(-1,0,1,Blocks.wooden_slab,2);bb.buildBlock(-1,0,2,Blocks.birch_stairs,2);
		bb.buildBlock(-1,0,3,Blocks.planks,2);bb.buildBlock(0,0,-3,Blocks.planks,2);bb.buildBlock(0,0,-2,Blocks.chest,3);
		bb.buildBlock(0,0,-1,Blocks.carpet,14);bb.buildBlock(0,0,0,Blocks.carpet,14);bb.buildBlock(0,0,1,Blocks.carpet,14);
		bb.buildBlock(0,0,2,Blocks.planks,2);bb.buildBlock(0,0,3,Blocks.planks,2);bb.buildBlock(1,0,-3,Blocks.planks,2);
		bb.buildBlock(1,0,-2,Blocks.chest,3);bb.buildBlock(1,0,0,Blocks.carpet,14);bb.buildBlock(1,0,2,Blocks.bookshelf,0);bb.buildBlock(1,0,3,Blocks.planks,2);
		bb.buildBlock(2,0,-3,Blocks.planks,2);bb.buildBlock(2,0,-1,Blocks.planks,2);bb.buildBlock(2,0,0,Blocks.wooden_door,0);
		bb.buildBlock(2,0,1,Blocks.planks,2);bb.buildBlock(2,0,2,Blocks.bookshelf,0);bb.buildBlock(2,0,3,Blocks.planks,2);
		bb.buildBlock(3,0,-2,Blocks.planks,2);bb.buildBlock(3,0,2,Blocks.planks,2);bb.buildBlock(-3,1,-2,Blocks.planks,2);
		bb.buildBlock(-3,1,-1,Blocks.planks,2);bb.buildBlock(-3,1,0,Blocks.planks,2);bb.buildBlock(-3,1,1,Blocks.planks,2);
		bb.buildBlock(-3,1,2,Blocks.planks,2);bb.buildBlock(-2,1,-3,Blocks.planks,2);bb.buildBlock(-2,1,3,Blocks.planks,2);
		bb.buildBlock(-1,1,-3,Blocks.planks,2);bb.buildBlock(-1,1,3,Blocks.planks,2);bb.buildBlock(0,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,1,2,Blocks.flower_pot,0);bb.addTileEntityPot(0,1,2,37,0);
		bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.planks,2);bb.buildBlock(1,1,2,Blocks.bookshelf,0);
		bb.buildBlock(1,1,3,Blocks.planks,2);bb.buildBlock(2,1,-3,Blocks.planks,2);bb.buildBlock(2,1,-1,Blocks.planks,2);
		bb.buildBlock(2,1,0,Blocks.wooden_door,8);bb.buildBlock(2,1,1,Blocks.planks,2);bb.buildBlock(2,1,2,Blocks.bookshelf,0);
		bb.buildBlock(2,1,3,Blocks.planks,2);bb.buildBlock(3,1,-2,Blocks.planks,2);bb.buildBlock(3,1,2,Blocks.planks,2);
		bb.buildBlock(-3,2,-2,Blocks.planks,2);bb.buildBlock(-3,2,-1,Blocks.planks,2);bb.buildBlock(-3,2,0,Blocks.planks,2);
		bb.buildBlock(-3,2,1,Blocks.planks,2);bb.buildBlock(-3,2,2,Blocks.planks,2);bb.buildBlock(-2,2,-3,Blocks.planks,2);
		bb.buildBlock(-2,2,3,Blocks.planks,2);bb.buildBlock(-1,2,-3,Blocks.planks,2);bb.buildBlock(-1,2,3,Blocks.planks,2);
		bb.buildBlock(0,2,-3,Blocks.glass_pane,0);bb.buildBlock(0,2,3,Blocks.glass_pane,0);bb.buildBlock(1,2,-3,Blocks.planks,2);
		bb.buildBlock(1,2,2,Blocks.bookshelf,0);bb.buildBlock(1,2,3,Blocks.planks,2);bb.buildBlock(2,2,-3,Blocks.planks,2);
		bb.buildBlock(2,2,0,Blocks.planks,2);bb.buildBlock(2,2,2,Blocks.bookshelf,0);bb.buildBlock(2,2,3,Blocks.planks,2);
		bb.buildBlock(3,2,-2,Blocks.planks,2);bb.buildBlock(3,2,-1,Blocks.glass,0);bb.buildBlock(3,2,0,Blocks.glass,0);
		bb.buildBlock(3,2,1,Blocks.glass,0);bb.buildBlock(3,2,2,Blocks.planks,2);bb.buildBlock(-3,3,-2,Blocks.planks,2);
		bb.buildBlock(-3,3,-1,Blocks.planks,2);bb.buildBlock(-3,3,0,Blocks.planks,2);bb.buildBlock(-3,3,1,Blocks.planks,2);
		bb.buildBlock(-3,3,2,Blocks.planks,2);bb.buildBlock(-2,3,-3,Blocks.planks,2);bb.buildBlock(-2,3,3,Blocks.planks,2);
		bb.buildBlock(-1,3,-3,Blocks.planks,2);bb.buildBlock(-1,3,3,Blocks.planks,2);bb.buildBlock(0,3,-3,Blocks.planks,2);
		bb.buildBlock(0,3,3,Blocks.planks,2);bb.buildBlock(1,3,-3,Blocks.planks,2);bb.buildBlock(1,3,3,Blocks.planks,2);
		bb.buildBlock(2,3,-3,Blocks.planks,2);bb.buildBlock(2,3,3,Blocks.planks,2);bb.buildBlock(3,3,-2,Blocks.planks,2);
		bb.buildBlock(3,3,-1,Blocks.planks,2);bb.buildBlock(3,3,0,Blocks.planks,2);bb.buildBlock(3,3,1,Blocks.planks,2);
		bb.buildBlock(3,3,2,Blocks.planks,2);bb.buildBlock(-2,4,-2,Blocks.acacia_stairs,0);bb.buildBlock(-2,4,-1,Blocks.acacia_stairs,0);
		bb.buildBlock(-2,4,0,Blocks.acacia_stairs,0);bb.buildBlock(-2,4,1,Blocks.acacia_stairs,0);bb.buildBlock(-2,4,2,Blocks.acacia_stairs,0);
		bb.buildBlock(-1,4,-2,Blocks.acacia_stairs,2);bb.buildBlock(-1,4,-1,Blocks.wooden_slab,2);bb.buildBlock(-1,4,0,Blocks.wooden_slab,2);
		bb.buildBlock(-1,4,1,Blocks.wooden_slab,2);bb.buildBlock(-1,4,2,Blocks.acacia_stairs,3);bb.buildBlock(0,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(0,4,-1,Blocks.wooden_slab,2);bb.buildBlock(0,4,0,Blocks.wooden_slab,2);bb.buildBlock(0,4,1,Blocks.wooden_slab,2);
		bb.buildBlock(0,4,2,Blocks.acacia_stairs,3);bb.buildBlock(1,4,-2,Blocks.acacia_stairs,2);bb.buildBlock(1,4,-1,Blocks.wooden_slab,2);
		bb.buildBlock(1,4,0,Blocks.wooden_slab,2);bb.buildBlock(1,4,1,Blocks.wooden_slab,2);bb.buildBlock(1,4,2,Blocks.acacia_stairs,3);
		bb.buildBlock(2,4,-2,Blocks.acacia_stairs,1);bb.buildBlock(2,4,-1,Blocks.acacia_stairs,1);bb.buildBlock(2,4,0,Blocks.acacia_stairs,1);
		bb.buildBlock(2,4,1,Blocks.acacia_stairs,1);bb.buildBlock(2,4,2,Blocks.acacia_stairs,1);bb.buildBlock(-3,0,-3,Blocks.torch,5);
		bb.buildBlock(-3,0,3,Blocks.torch,5);bb.buildBlock(3,0,-3,Blocks.torch,5);bb.buildBlock(3,0,3,Blocks.torch,5);
		bb.buildBlock(-2,3,-2,Blocks.torch,1);bb.buildBlock(-2,3,2,Blocks.torch,1);bb.buildBlock(0,3,-2,Blocks.torch,3);
		bb.buildBlock(0,3,2,Blocks.torch,4);bb.buildBlock(2,3,-2,Blocks.torch,2);bb.buildBlock(2,3,2,Blocks.torch,2);
		bb.addEntityPainting(-3,2,0,3,"Wasteland");
		bb.addEntityItemFrame(2,1,1,3,186);

	}

}
