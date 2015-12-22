package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.profession.ProfessionChickenSeller;

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
		bb.addVillager(ProfessionChickenSeller.class,0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-2,-1,0,Blocks.planks,2);bb.buildBlock(-2,-1,1,Blocks.planks,2);bb.buildBlock(-3,0,-2,Blocks.planks,2);
		bb.buildBlock(-3,0,-1,Blocks.planks,2);bb.buildBlock(-3,0,0,Blocks.planks,2);bb.buildBlock(-3,0,1,Blocks.planks,2);
		bb.buildBlock(-3,0,2,Blocks.planks,2);bb.buildBlock(-2,0,-3,Blocks.planks,2);bb.buildBlock(-2,0,-2,Blocks.carpet,14);
		bb.buildBlock(-2,0,-1,Blocks.carpet,14);bb.buildBlock(-2,0,0,Blocks.trapped_chest,5);bb.buildBlock(-2,0,1,Blocks.trapped_chest,5);bb.buildBlock(-2,0,2,Blocks.planks,2);bb.buildBlock(-2,0,3,Blocks.planks,2);bb.buildBlock(-1,0,-3,Blocks.planks,2);
		bb.buildBlock(-1,0,-2,Blocks.carpet,14);bb.buildBlock(-1,0,-1,Blocks.carpet,14);bb.buildBlock(-1,0,0,Blocks.carpet,14);
		bb.buildBlock(-1,0,1,Blocks.carpet,14);bb.buildBlock(-1,0,2,Blocks.planks,2);bb.buildBlock(-1,0,3,Blocks.planks,2);
		bb.buildBlock(0,0,-3,Blocks.planks,2);bb.buildBlock(0,0,-2,Blocks.carpet,14);bb.buildBlock(0,0,-1,Blocks.planks,2);
		bb.buildBlock(0,0,0,Blocks.planks,2);bb.buildBlock(0,0,1,Blocks.planks,2);bb.buildBlock(0,0,2,Blocks.planks,2);
		bb.buildBlock(0,0,3,Blocks.planks,2);bb.buildBlock(1,0,-3,Blocks.planks,2);bb.buildBlock(1,0,-2,Blocks.carpet,14);
		bb.buildBlock(1,0,-1,Blocks.carpet,14);bb.buildBlock(1,0,0,Blocks.carpet,14);bb.buildBlock(1,0,1,Blocks.carpet,14);
		bb.buildBlock(1,0,2,Blocks.birch_stairs,1);bb.buildBlock(1,0,3,Blocks.planks,2);bb.buildBlock(2,0,-3,Blocks.planks,2);
		bb.buildBlock(2,0,-2,Blocks.carpet,14);bb.buildBlock(2,0,-1,Blocks.carpet,14);bb.buildBlock(2,0,1,Blocks.carpet,14);
		bb.buildBlock(2,0,2,Blocks.carpet,14);bb.buildBlock(2,0,3,Blocks.planks,2);bb.buildBlock(3,0,-2,Blocks.planks,2);
		bb.buildBlock(3,0,-1,Blocks.planks,2);bb.buildBlock(3,0,0,Blocks.wooden_door,4);bb.buildBlock(3,0,1,Blocks.planks,2);
		bb.buildBlock(3,0,2,Blocks.planks,2);bb.buildBlock(-3,1,-2,Blocks.planks,2);bb.buildBlock(-3,1,-1,Blocks.planks,2);
		bb.buildBlock(-3,1,0,Blocks.planks,2);bb.buildBlock(-3,1,1,Blocks.planks,2);bb.buildBlock(-3,1,2,Blocks.planks,2);
		bb.buildBlock(-2,1,-3,Blocks.planks,2);bb.buildBlock(-2,1,2,Blocks.planks,2);bb.buildBlock(-2,1,3,Blocks.planks,2);
		bb.buildBlock(-1,1,-3,Blocks.planks,2);bb.buildBlock(-1,1,2,Blocks.planks,2);bb.buildBlock(-1,1,3,Blocks.planks,2);
		bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,2,Blocks.birch_stairs,1);bb.buildBlock(0,1,3,Blocks.glass_pane,0);
		bb.buildBlock(1,1,-3,Blocks.planks,2);bb.buildBlock(1,1,3,Blocks.planks,2);bb.buildBlock(2,1,-3,Blocks.planks,2);
		bb.buildBlock(2,1,3,Blocks.planks,2);bb.buildBlock(3,1,-2,Blocks.planks,2);bb.buildBlock(3,1,-1,Blocks.planks,2);
		bb.buildBlock(3,1,0,Blocks.wooden_door,8);bb.buildBlock(3,1,1,Blocks.planks,2);bb.buildBlock(3,1,2,Blocks.planks,2);
		bb.buildBlock(-3,2,-2,Blocks.planks,2);bb.buildBlock(-3,2,-1,Blocks.planks,2);bb.buildBlock(-3,2,0,Blocks.planks,2);
		bb.buildBlock(-3,2,1,Blocks.planks,2);bb.buildBlock(-3,2,2,Blocks.planks,2);bb.buildBlock(-2,2,-3,Blocks.planks,2);
		bb.buildBlock(-2,2,2,Blocks.planks,2);bb.buildBlock(-2,2,3,Blocks.planks,2);bb.buildBlock(-1,2,-3,Blocks.planks,2);
		bb.buildBlock(-1,2,2,Blocks.birch_stairs,1);bb.buildBlock(-1,2,3,Blocks.planks,2);bb.buildBlock(0,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,2,3,Blocks.glass_pane,0);bb.buildBlock(1,2,-3,Blocks.planks,2);bb.buildBlock(1,2,3,Blocks.planks,2);
		bb.buildBlock(2,2,-3,Blocks.planks,2);bb.buildBlock(2,2,3,Blocks.planks,2);bb.buildBlock(3,2,-2,Blocks.planks,2);
		bb.buildBlock(3,2,-1,Blocks.glass,0);bb.buildBlock(3,2,0,Blocks.planks,2);bb.buildBlock(3,2,1,Blocks.glass,0);
		bb.buildBlock(3,2,2,Blocks.planks,2);bb.buildBlock(-3,3,-2,Blocks.planks,2);bb.buildBlock(-3,3,-1,Blocks.planks,2);
		bb.buildBlock(-3,3,0,Blocks.planks,2);bb.buildBlock(-3,3,1,Blocks.planks,2);bb.buildBlock(-3,3,2,Blocks.planks,2);
		bb.buildBlock(-2,3,-3,Blocks.planks,2);bb.buildBlock(-2,3,-2,Blocks.planks,2);bb.buildBlock(-2,3,-1,Blocks.planks,2);
		bb.buildBlock(-2,3,0,Blocks.planks,2);bb.buildBlock(-2,3,1,Blocks.planks,2);bb.buildBlock(-2,3,2,Blocks.birch_stairs,1);
		bb.buildBlock(-2,3,3,Blocks.planks,2);bb.buildBlock(-1,3,-3,Blocks.planks,2);bb.buildBlock(-1,3,-2,Blocks.planks,2);
		bb.buildBlock(-1,3,-1,Blocks.planks,2);bb.buildBlock(-1,3,0,Blocks.planks,2);bb.buildBlock(-1,3,1,Blocks.planks,2);
		bb.buildBlock(-1,3,3,Blocks.planks,2);bb.buildBlock(0,3,-3,Blocks.planks,2);bb.buildBlock(0,3,-2,Blocks.planks,2);
		bb.buildBlock(0,3,-1,Blocks.planks,2);bb.buildBlock(0,3,0,Blocks.planks,2);bb.buildBlock(0,3,1,Blocks.planks,2);
		bb.buildBlock(0,3,3,Blocks.planks,2);bb.buildBlock(1,3,-3,Blocks.planks,2);bb.buildBlock(1,3,-2,Blocks.planks,2);
		bb.buildBlock(1,3,-1,Blocks.planks,2);bb.buildBlock(1,3,0,Blocks.planks,2);bb.buildBlock(1,3,1,Blocks.planks,2);
		bb.buildBlock(1,3,3,Blocks.planks,2);bb.buildBlock(2,3,-3,Blocks.planks,2);bb.buildBlock(2,3,-2,Blocks.planks,2);
		bb.buildBlock(2,3,-1,Blocks.planks,2);bb.buildBlock(2,3,0,Blocks.planks,2);bb.buildBlock(2,3,1,Blocks.planks,2);
		bb.buildBlock(2,3,3,Blocks.planks,2);bb.buildBlock(3,3,-2,Blocks.planks,2);bb.buildBlock(3,3,-1,Blocks.planks,2);
		bb.buildBlock(3,3,0,Blocks.planks,2);bb.buildBlock(3,3,1,Blocks.planks,2);bb.buildBlock(3,3,2,Blocks.planks,2);
		bb.buildBlock(-3,4,-3,Blocks.planks,4);bb.buildBlock(-3,4,-2,Blocks.planks,4);bb.buildBlock(-3,4,-1,Blocks.planks,4);
		bb.buildBlock(-3,4,0,Blocks.planks,4);bb.buildBlock(-3,4,1,Blocks.planks,4);bb.buildBlock(-3,4,2,Blocks.planks,4);
		bb.buildBlock(-3,4,3,Blocks.planks,4);bb.buildBlock(-2,4,-3,Blocks.planks,4);bb.buildBlock(-2,4,-2,Blocks.carpet,14);
		bb.buildBlock(-2,4,-1,Blocks.carpet,14);bb.buildBlock(-2,4,0,Blocks.planks,2);bb.buildBlock(-2,4,3,Blocks.planks,4);
		bb.buildBlock(-1,4,-3,Blocks.planks,4);bb.buildBlock(-1,4,-2,Blocks.carpet,14);bb.buildBlock(-1,4,-1,Blocks.carpet,14);
		bb.buildBlock(-1,4,0,Blocks.wooden_door,1);bb.buildBlock(-1,4,3,Blocks.planks,4);bb.buildBlock(0,4,-3,Blocks.planks,4);
		bb.buildBlock(0,4,-2,Blocks.carpet,14);bb.buildBlock(0,4,-1,Blocks.carpet,14);bb.buildBlock(0,4,0,Blocks.planks,2);
		bb.buildBlock(0,4,3,Blocks.planks,4);bb.buildBlock(1,4,-3,Blocks.planks,4);bb.buildBlock(1,4,-2,Blocks.bed,3);
		bb.buildBlock(1,4,-1,Blocks.carpet,14);bb.buildBlock(1,4,0,Blocks.planks,2);bb.buildBlock(1,4,3,Blocks.planks,4);
		bb.buildBlock(2,4,-3,Blocks.planks,4);bb.buildBlock(2,4,-2,Blocks.bed,11);bb.buildBlock(2,4,-1,Blocks.chest,4);
		bb.buildBlock(2,4,0,Blocks.planks,2);bb.buildBlock(2,4,3,Blocks.planks,4);bb.buildBlock(3,4,-3,Blocks.planks,4);
		bb.buildBlock(3,4,-2,Blocks.planks,4);bb.buildBlock(3,4,-1,Blocks.planks,4);bb.buildBlock(3,4,0,Blocks.planks,4);
		bb.buildBlock(3,4,1,Blocks.planks,4);bb.buildBlock(3,4,2,Blocks.planks,4);bb.buildBlock(3,4,3,Blocks.planks,4);
		bb.buildBlock(-3,5,-3,Blocks.planks,2);bb.buildBlock(-3,5,-2,Blocks.planks,2);bb.buildBlock(-3,5,-1,Blocks.planks,2);
		bb.buildBlock(-3,5,0,Blocks.planks,2);bb.buildBlock(-3,5,1,Blocks.planks,2);bb.buildBlock(-3,5,2,Blocks.planks,2);
		bb.buildBlock(-3,5,3,Blocks.planks,2);bb.buildBlock(-2,5,-3,Blocks.planks,2);bb.buildBlock(-2,5,0,Blocks.planks,2);
		bb.buildBlock(-2,5,3,Blocks.planks,2);bb.buildBlock(-1,5,-3,Blocks.planks,2);bb.buildBlock(-1,5,0,Blocks.wooden_door,8);
		bb.buildBlock(-1,5,3,Blocks.planks,2);bb.buildBlock(0,5,-3,Blocks.planks,2);bb.buildBlock(0,5,0,Blocks.planks,2);
		bb.buildBlock(0,5,3,Blocks.planks,2);bb.buildBlock(1,5,-3,Blocks.planks,2);bb.buildBlock(1,5,0,Blocks.planks,2);
		bb.buildBlock(1,5,3,Blocks.planks,2);bb.buildBlock(2,5,-3,Blocks.planks,2);bb.buildBlock(2,5,0,Blocks.planks,2);
		bb.buildBlock(2,5,3,Blocks.planks,2);bb.buildBlock(3,5,-3,Blocks.planks,2);bb.buildBlock(3,5,-2,Blocks.planks,2);
		bb.buildBlock(3,5,-1,Blocks.planks,2);bb.buildBlock(3,5,0,Blocks.planks,2);bb.buildBlock(3,5,1,Blocks.glass_pane,0);
		bb.buildBlock(3,5,2,Blocks.glass_pane,0);bb.buildBlock(3,5,3,Blocks.planks,2);bb.buildBlock(-3,6,-3,Blocks.planks,2);
		bb.buildBlock(-3,6,-2,Blocks.planks,2);bb.buildBlock(-3,6,-1,Blocks.planks,2);bb.buildBlock(-3,6,0,Blocks.planks,2);
		bb.buildBlock(-3,6,1,Blocks.planks,2);bb.buildBlock(-3,6,2,Blocks.planks,2);bb.buildBlock(-3,6,3,Blocks.planks,2);
		bb.buildBlock(-2,6,-3,Blocks.planks,2);bb.buildBlock(-2,6,0,Blocks.planks,2);bb.buildBlock(-2,6,3,Blocks.planks,2);
		bb.buildBlock(-1,6,-3,Blocks.planks,2);bb.buildBlock(-1,6,0,Blocks.planks,2);bb.buildBlock(-1,6,3,Blocks.planks,2);
		bb.buildBlock(0,6,-3,Blocks.planks,2);bb.buildBlock(0,6,0,Blocks.planks,2);bb.buildBlock(0,6,3,Blocks.planks,2);
		bb.buildBlock(1,6,-3,Blocks.planks,2);bb.buildBlock(1,6,0,Blocks.planks,2);bb.buildBlock(1,6,3,Blocks.planks,2);
		bb.buildBlock(2,6,-3,Blocks.planks,2);bb.buildBlock(2,6,0,Blocks.planks,2);bb.buildBlock(2,6,3,Blocks.planks,2);
		bb.buildBlock(3,6,-3,Blocks.planks,2);bb.buildBlock(3,6,-2,Blocks.planks,2);bb.buildBlock(3,6,-1,Blocks.planks,2);
		bb.buildBlock(3,6,0,Blocks.planks,2);bb.buildBlock(3,6,1,Blocks.glass_pane,0);bb.buildBlock(3,6,2,Blocks.glass_pane,0);
		bb.buildBlock(3,6,3,Blocks.planks,2);bb.buildBlock(-3,7,-3,Blocks.planks,2);bb.buildBlock(-3,7,-2,Blocks.planks,2);
		bb.buildBlock(-3,7,-1,Blocks.planks,2);bb.buildBlock(-3,7,0,Blocks.planks,2);bb.buildBlock(-3,7,1,Blocks.planks,2);
		bb.buildBlock(-3,7,2,Blocks.planks,2);bb.buildBlock(-3,7,3,Blocks.planks,2);bb.buildBlock(-2,7,-3,Blocks.planks,2);
		bb.buildBlock(-2,7,0,Blocks.planks,2);bb.buildBlock(-2,7,3,Blocks.planks,2);bb.buildBlock(-1,7,-3,Blocks.planks,2);
		bb.buildBlock(-1,7,0,Blocks.planks,2);bb.buildBlock(-1,7,3,Blocks.planks,2);bb.buildBlock(0,7,-3,Blocks.planks,2);
		bb.buildBlock(0,7,0,Blocks.planks,2);bb.buildBlock(0,7,3,Blocks.planks,2);bb.buildBlock(1,7,-3,Blocks.planks,2);
		bb.buildBlock(1,7,0,Blocks.planks,2);bb.buildBlock(1,7,3,Blocks.planks,2);bb.buildBlock(2,7,-3,Blocks.planks,2);
		bb.buildBlock(2,7,0,Blocks.planks,2);bb.buildBlock(2,7,3,Blocks.planks,2);bb.buildBlock(3,7,-3,Blocks.planks,2);
		bb.buildBlock(3,7,-2,Blocks.planks,2);bb.buildBlock(3,7,-1,Blocks.planks,2);bb.buildBlock(3,7,0,Blocks.planks,2);
		bb.buildBlock(3,7,1,Blocks.planks,2);bb.buildBlock(3,7,2,Blocks.planks,2);bb.buildBlock(3,7,3,Blocks.planks,2);
		bb.buildBlock(-3,8,-3,Blocks.spruce_stairs,0);bb.buildBlock(-3,8,-2,Blocks.spruce_stairs,0);bb.buildBlock(-3,8,-1,Blocks.spruce_stairs,0);
		bb.buildBlock(-3,8,0,Blocks.spruce_stairs,0);bb.buildBlock(-3,8,1,Blocks.spruce_stairs,0);bb.buildBlock(-3,8,2,Blocks.spruce_stairs,0);
		bb.buildBlock(-3,8,3,Blocks.spruce_stairs,0);bb.buildBlock(-2,8,-3,Blocks.spruce_stairs,2);bb.buildBlock(-2,8,-2,Blocks.wooden_slab,0);
		bb.buildBlock(-2,8,-1,Blocks.wooden_slab,0);bb.buildBlock(-2,8,0,Blocks.wooden_slab,0);bb.buildBlock(-2,8,1,Blocks.wooden_slab,0);
		bb.buildBlock(-2,8,2,Blocks.wooden_slab,0);bb.buildBlock(-2,8,3,Blocks.spruce_stairs,3);bb.buildBlock(-1,8,-3,Blocks.spruce_stairs,2);
		bb.buildBlock(-1,8,-2,Blocks.wooden_slab,0);bb.buildBlock(-1,8,-1,Blocks.wooden_slab,0);bb.buildBlock(-1,8,0,Blocks.wooden_slab,0);
		bb.buildBlock(-1,8,1,Blocks.wooden_slab,0);bb.buildBlock(-1,8,2,Blocks.wooden_slab,0);bb.buildBlock(-1,8,3,Blocks.spruce_stairs,3);
		bb.buildBlock(0,8,-3,Blocks.spruce_stairs,2);bb.buildBlock(0,8,-2,Blocks.wooden_slab,0);bb.buildBlock(0,8,-1,Blocks.wooden_slab,0);
		bb.buildBlock(0,8,0,Blocks.wooden_slab,0);bb.buildBlock(0,8,1,Blocks.wooden_slab,0);bb.buildBlock(0,8,2,Blocks.wooden_slab,0);
		bb.buildBlock(0,8,3,Blocks.spruce_stairs,3);bb.buildBlock(1,8,-3,Blocks.spruce_stairs,2);bb.buildBlock(1,8,-2,Blocks.wooden_slab,0);
		bb.buildBlock(1,8,-1,Blocks.wooden_slab,0);bb.buildBlock(1,8,0,Blocks.wooden_slab,0);bb.buildBlock(1,8,1,Blocks.wooden_slab,0);
		bb.buildBlock(1,8,2,Blocks.wooden_slab,0);bb.buildBlock(1,8,3,Blocks.spruce_stairs,3);bb.buildBlock(2,8,-3,Blocks.spruce_stairs,2);
		bb.buildBlock(2,8,-2,Blocks.wooden_slab,0);bb.buildBlock(2,8,-1,Blocks.wooden_slab,0);bb.buildBlock(2,8,0,Blocks.wooden_slab,0);
		bb.buildBlock(2,8,1,Blocks.wooden_slab,0);bb.buildBlock(2,8,2,Blocks.wooden_slab,0);bb.buildBlock(2,8,3,Blocks.spruce_stairs,3);
		bb.buildBlock(3,8,-3,Blocks.spruce_stairs,1);bb.buildBlock(3,8,-2,Blocks.spruce_stairs,1);bb.buildBlock(3,8,-1,Blocks.spruce_stairs,1);
		bb.buildBlock(3,8,0,Blocks.spruce_stairs,1);bb.buildBlock(3,8,1,Blocks.spruce_stairs,1);bb.buildBlock(3,8,2,Blocks.spruce_stairs,1);
		bb.buildBlock(3,8,3,Blocks.spruce_stairs,3);bb.buildBlock(-3,0,-3,Blocks.torch,5);bb.buildBlock(-3,0,3,Blocks.torch,5);
		bb.buildBlock(3,0,-3,Blocks.torch,5);bb.buildBlock(3,0,3,Blocks.torch,5);bb.buildBlock(-2,2,-2,Blocks.torch,1);
		bb.buildBlock(-2,2,1,Blocks.torch,1);bb.buildBlock(2,3,2,Blocks.torch,2);bb.buildBlock(-2,7,-2,Blocks.torch,3);
		bb.buildBlock(-2,7,-1,Blocks.torch,4);bb.buildBlock(-2,7,2,Blocks.torch,1);bb.buildBlock(2,7,-2,Blocks.torch,3);
		bb.buildBlock(2,7,-1,Blocks.torch,4);bb.buildBlock(2,7,2,Blocks.torch,2);bb.addEntityPainting(0,6,-3,0,"Bomb");
		bb.addEntityItemFrame(-3,2,0,3,ModItems.itemChickenGloves);
		bb.addEntityItemFrame(-3,2,-1,3,ModItems.itemVillageHeartEgg);
		bb.addEntityItemFrame(2,2,3,3,ModBlocks.blockChickenShop);
	}

}
