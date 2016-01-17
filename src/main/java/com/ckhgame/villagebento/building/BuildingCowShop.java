package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.profession.ProfessionCowSeller;

import net.minecraft.init.Blocks;

public class BuildingCowShop extends Building {

	@Override
	public String getName() {
		return "Cow Products Shop";
	}

	@Override
	public String getDescription() {
		return "A sweet home for cows!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionCowSeller.class,-1,1);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,-3,Blocks.planks,2);bb.buildBlock(-3,-1,-2,Blocks.planks,2);bb.buildBlock(-3,-1,-1,Blocks.planks,2);
		bb.buildBlock(-2,-1,-3,Blocks.planks,2);bb.buildBlock(-2,-1,-2,Blocks.planks,2);bb.buildBlock(-2,-1,-1,Blocks.planks,2);
		bb.buildBlock(-2,-1,0,Blocks.planks,2);bb.buildBlock(-2,-1,1,Blocks.planks,2);bb.buildBlock(-2,-1,2,Blocks.planks,2);
		bb.buildBlock(-2,-1,3,Blocks.planks,2);bb.buildBlock(-1,-1,-3,Blocks.planks,2);bb.buildBlock(-1,-1,-2,Blocks.planks,2);
		bb.buildBlock(-1,-1,-1,Blocks.planks,2);bb.buildBlock(-1,-1,1,Blocks.planks,2);bb.buildBlock(-1,-1,2,Blocks.planks,2);
		bb.buildBlock(-1,-1,3,Blocks.planks,2);bb.buildBlock(0,-1,-3,Blocks.planks,2);bb.buildBlock(0,-1,-2,Blocks.planks,2);
		bb.buildBlock(0,-1,-1,Blocks.planks,2);bb.buildBlock(0,-1,3,Blocks.planks,2);bb.buildBlock(1,-1,-3,Blocks.planks,2);
		bb.buildBlock(1,-1,-2,Blocks.planks,2);bb.buildBlock(1,-1,-1,Blocks.planks,2);bb.buildBlock(1,-1,1,Blocks.planks,2);
		bb.buildBlock(1,-1,2,Blocks.planks,2);bb.buildBlock(1,-1,3,Blocks.planks,2);bb.buildBlock(2,-1,-3,Blocks.planks,2);
		bb.buildBlock(2,-1,-2,Blocks.planks,2);bb.buildBlock(2,-1,-1,Blocks.planks,2);bb.buildBlock(2,-1,1,Blocks.planks,2);
		bb.buildBlock(2,-1,2,Blocks.planks,2);bb.buildBlock(2,-1,3,Blocks.planks,2);bb.buildBlock(3,-1,-3,Blocks.planks,2);
		bb.buildBlock(3,-1,-2,Blocks.planks,2);bb.buildBlock(3,-1,-1,Blocks.planks,2);bb.buildBlock(3,-1,1,Blocks.planks,2);
		bb.buildBlock(3,-1,2,Blocks.planks,2);bb.buildBlock(3,-1,3,Blocks.planks,2);bb.buildBlock(4,-1,2,Blocks.planks,2);
		bb.buildBlock(-4,0,-4,Blocks.planks,1);bb.buildBlock(-4,0,-3,Blocks.planks,1);bb.buildBlock(-4,0,-2,Blocks.planks,1);
		bb.buildBlock(-4,0,-1,Blocks.planks,1);bb.buildBlock(-4,0,0,Blocks.planks,1);bb.buildBlock(-4,0,1,Blocks.planks,1);
		bb.buildBlock(-4,0,2,Blocks.planks,1);bb.buildBlock(-4,0,3,Blocks.planks,1);bb.buildBlock(-4,0,4,Blocks.planks,1);
		bb.buildBlock(-3,0,-4,Blocks.planks,1);bb.buildBlock(-3,0,-3,Blocks.spruce_stairs,1);bb.buildBlock(-3,0,-2,Blocks.spruce_stairs,1);
		bb.buildBlock(-3,0,-1,Blocks.bookshelf,0);bb.buildBlock(-3,0,0,Blocks.planks,1);bb.buildBlock(-3,0,1,Blocks.planks,1);
		bb.buildBlock(-3,0,2,Blocks.planks,1);bb.buildBlock(-3,0,3,Blocks.bookshelf,0);bb.buildBlock(-3,0,4,Blocks.planks,1);
		bb.buildBlock(-2,0,-4,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.spruce_stairs,3);bb.buildBlock(-2,0,0,Blocks.wooden_door,3);
		bb.buildBlock(-2,0,4,Blocks.planks,1);bb.buildBlock(-1,0,-4,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.spruce_stairs,3);
		bb.buildBlock(-1,0,0,Blocks.planks,1);bb.buildBlock(-1,0,4,Blocks.planks,1);bb.buildBlock(0,0,-4,Blocks.planks,1);
		bb.buildBlock(0,0,0,Blocks.planks,1);bb.buildBlock(0,0,1,Blocks.planks,1);bb.buildBlock(0,0,2,Blocks.planks,1);
		bb.buildBlock(0,0,4,Blocks.planks,1);bb.buildBlock(1,0,-4,Blocks.planks,1);bb.buildBlock(1,0,0,Blocks.planks,1);
		bb.buildBlock(1,0,4,Blocks.planks,1);bb.buildBlock(2,0,-4,Blocks.planks,1);bb.buildBlock(2,0,-1,Blocks.bed,3);
		bb.buildBlock(2,0,0,Blocks.planks,1);bb.buildBlock(2,0,4,Blocks.planks,1);bb.buildBlock(3,0,-4,Blocks.planks,1);
		bb.buildBlock(3,0,-3,Blocks.bookshelf,0);bb.buildBlock(3,0,-2,Blocks.bookshelf,0);bb.buildBlock(3,0,-1,Blocks.bed,11);
		bb.buildBlock(3,0,0,Blocks.planks,1);bb.buildBlock(3,0,4,Blocks.planks,1);bb.buildBlock(4,0,-4,Blocks.planks,1);
		bb.buildBlock(4,0,-3,Blocks.planks,1);bb.buildBlock(4,0,-2,Blocks.planks,1);bb.buildBlock(4,0,-1,Blocks.planks,1);
		bb.buildBlock(4,0,0,Blocks.planks,1);bb.buildBlock(4,0,1,Blocks.planks,1);bb.buildBlock(4,0,2,Blocks.wooden_door,2);
		bb.buildBlock(4,0,3,Blocks.planks,1);bb.buildBlock(4,0,4,Blocks.planks,1);bb.buildBlock(5,0,-1,Blocks.birch_stairs,1);
		bb.buildBlock(5,0,0,Blocks.birch_stairs,1);bb.buildBlock(-5,1,-5,Blocks.acacia_stairs,2);bb.buildBlock(-5,1,-4,Blocks.acacia_stairs,7);
		bb.buildBlock(-5,1,4,Blocks.wooden_slab,12);bb.buildBlock(-5,1,5,Blocks.wooden_slab,12);bb.buildBlock(-4,1,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,1,-4,Blocks.planks,1);bb.buildBlock(-4,1,-3,Blocks.planks,1);bb.buildBlock(-4,1,-2,Blocks.glass_pane,0);
		bb.buildBlock(-4,1,-1,Blocks.planks,1);bb.buildBlock(-4,1,0,Blocks.planks,1);bb.buildBlock(-4,1,1,Blocks.planks,1);
		bb.buildBlock(-4,1,2,Blocks.glass_pane,0);bb.buildBlock(-4,1,3,Blocks.glass_pane,0);bb.buildBlock(-4,1,4,Blocks.planks,1);
		bb.buildBlock(-4,1,5,Blocks.wooden_slab,12);bb.buildBlock(-3,1,-5,Blocks.acacia_stairs,2);bb.buildBlock(-3,1,-4,Blocks.planks,1);
		bb.buildBlock(-3,1,-1,Blocks.bookshelf,0);bb.buildBlock(-3,1,0,Blocks.planks,1);bb.buildBlock(-3,1,1,Blocks.chest,5);
		bb.buildBlock(-3,1,3,Blocks.flower_pot,8);bb.addTileEntityPot(-3,1,3,38,8);
		bb.buildBlock(-3,1,4,Blocks.planks,1);bb.buildBlock(-3,1,5,Blocks.wooden_slab,12);bb.buildBlock(-2,1,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,1,-4,Blocks.planks,1);bb.buildBlock(-2,1,0,Blocks.wooden_door,8);bb.buildBlock(-2,1,4,Blocks.planks,1);
		bb.buildBlock(-2,1,5,Blocks.wooden_slab,12);bb.buildBlock(-1,1,-5,Blocks.acacia_stairs,2);bb.buildBlock(-1,1,-4,Blocks.planks,1);
		bb.buildBlock(-1,1,0,Blocks.planks,1);bb.buildBlock(-1,1,4,Blocks.glass_pane,0);bb.buildBlock(-1,1,5,Blocks.wooden_slab,12);
		bb.buildBlock(0,1,-5,Blocks.acacia_stairs,2);bb.buildBlock(0,1,-4,Blocks.planks,1);bb.buildBlock(0,1,0,Blocks.planks,1);
		bb.buildBlock(0,1,4,Blocks.glass_pane,0);bb.buildBlock(0,1,5,Blocks.wooden_slab,12);bb.buildBlock(1,1,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(1,1,-4,Blocks.planks,1);bb.buildBlock(1,1,0,Blocks.planks,1);bb.buildBlock(1,1,4,Blocks.glass_pane,0);
		bb.buildBlock(1,1,5,Blocks.wooden_slab,12);bb.buildBlock(2,1,-5,Blocks.acacia_stairs,2);bb.buildBlock(2,1,-4,Blocks.planks,1);
		bb.buildBlock(2,1,0,Blocks.planks,1);bb.buildBlock(2,1,4,Blocks.planks,1);bb.buildBlock(2,1,5,Blocks.wooden_slab,12);
		bb.buildBlock(3,1,-5,Blocks.acacia_stairs,2);bb.buildBlock(3,1,-4,Blocks.planks,1);bb.buildBlock(3,1,0,Blocks.planks,1);
		bb.buildBlock(3,1,4,Blocks.planks,1);bb.buildBlock(3,1,5,Blocks.wooden_slab,12);bb.buildBlock(4,1,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(4,1,-4,Blocks.planks,1);bb.buildBlock(4,1,-3,Blocks.glass_pane,0);bb.buildBlock(4,1,-2,Blocks.glass_pane,0);
		bb.buildBlock(4,1,-1,Blocks.planks,1);bb.buildBlock(4,1,0,Blocks.planks,1);bb.buildBlock(4,1,1,Blocks.planks,1);
		bb.buildBlock(4,1,2,Blocks.wooden_door,8);bb.buildBlock(4,1,3,Blocks.planks,1);bb.buildBlock(4,1,4,Blocks.planks,1);
		bb.buildBlock(4,1,5,Blocks.wooden_slab,12);bb.buildBlock(5,1,-5,Blocks.acacia_stairs,2);bb.buildBlock(5,1,-4,Blocks.acacia_stairs,7);
		bb.buildBlock(5,1,4,Blocks.wooden_slab,12);bb.buildBlock(5,1,5,Blocks.wooden_slab,12);bb.buildBlock(-5,2,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,2,-3,Blocks.acacia_stairs,7);bb.buildBlock(-5,2,2,Blocks.wooden_slab,12);bb.buildBlock(-5,2,3,Blocks.double_wooden_slab,4);
		bb.buildBlock(-5,2,4,Blocks.wooden_slab,4);bb.buildBlock(-4,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(-4,2,-3,Blocks.planks,1);
		bb.buildBlock(-4,2,-2,Blocks.planks,1);bb.buildBlock(-4,2,-1,Blocks.planks,1);bb.buildBlock(-4,2,0,Blocks.planks,1);
		bb.buildBlock(-4,2,1,Blocks.planks,1);bb.buildBlock(-4,2,2,Blocks.planks,1);bb.buildBlock(-4,2,3,Blocks.planks,4);
		bb.buildBlock(-4,2,4,Blocks.wooden_slab,4);bb.buildBlock(-3,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(-3,2,-3,Blocks.planks,1);
		bb.buildBlock(-3,2,0,Blocks.planks,1);bb.buildBlock(-3,2,3,Blocks.planks,4);bb.buildBlock(-3,2,4,Blocks.wooden_slab,4);
		bb.buildBlock(-2,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(-2,2,-3,Blocks.planks,1);bb.buildBlock(-2,2,0,Blocks.planks,1);
		bb.buildBlock(-2,2,3,Blocks.planks,4);bb.buildBlock(-2,2,4,Blocks.wooden_slab,4);bb.buildBlock(-1,2,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,2,-3,Blocks.planks,1);bb.buildBlock(-1,2,0,Blocks.planks,1);bb.buildBlock(-1,2,3,Blocks.planks,4);
		bb.buildBlock(-1,2,4,Blocks.wooden_slab,4);bb.buildBlock(0,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(0,2,-3,Blocks.planks,1);
		bb.buildBlock(0,2,0,Blocks.planks,1);bb.buildBlock(0,2,3,Blocks.planks,4);bb.buildBlock(0,2,4,Blocks.wooden_slab,4);
		bb.buildBlock(1,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(1,2,-3,Blocks.planks,1);bb.buildBlock(1,2,0,Blocks.planks,1);
		bb.buildBlock(1,2,3,Blocks.planks,4);bb.buildBlock(1,2,4,Blocks.wooden_slab,4);bb.buildBlock(2,2,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(2,2,-3,Blocks.planks,1);bb.buildBlock(2,2,0,Blocks.planks,1);bb.buildBlock(2,2,3,Blocks.planks,4);
		bb.buildBlock(2,2,4,Blocks.wooden_slab,4);bb.buildBlock(3,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(3,2,-3,Blocks.planks,1);
		bb.buildBlock(3,2,0,Blocks.planks,1);bb.buildBlock(3,2,3,Blocks.planks,4);bb.buildBlock(3,2,4,Blocks.wooden_slab,4);
		bb.buildBlock(4,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(4,2,-3,Blocks.planks,1);bb.buildBlock(4,2,-2,Blocks.planks,1);
		bb.buildBlock(4,2,-1,Blocks.planks,1);bb.buildBlock(4,2,0,Blocks.planks,1);bb.buildBlock(4,2,1,Blocks.planks,1);
		bb.buildBlock(4,2,2,Blocks.planks,1);bb.buildBlock(4,2,3,Blocks.double_wooden_slab,4);bb.buildBlock(4,2,4,Blocks.wooden_slab,4);
		bb.buildBlock(5,2,-4,Blocks.acacia_stairs,2);bb.buildBlock(5,2,-3,Blocks.acacia_stairs,7);bb.buildBlock(5,2,2,Blocks.wooden_slab,12);
		bb.buildBlock(5,2,3,Blocks.double_wooden_slab,4);bb.buildBlock(5,2,4,Blocks.wooden_slab,4);bb.buildBlock(-5,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,3,-2,Blocks.acacia_stairs,7);bb.buildBlock(-5,3,-1,Blocks.planks,4);bb.buildBlock(-5,3,0,Blocks.wooden_slab,12);
		bb.buildBlock(-5,3,1,Blocks.double_wooden_slab,4);bb.buildBlock(-5,3,2,Blocks.wooden_slab,4);bb.buildBlock(-4,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,3,-2,Blocks.planks,1);bb.buildBlock(-4,3,-1,Blocks.planks,1);bb.buildBlock(-4,3,0,Blocks.planks,1);
		bb.buildBlock(-4,3,1,Blocks.planks,4);bb.buildBlock(-4,3,2,Blocks.wooden_slab,4);bb.buildBlock(-3,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,3,-2,Blocks.planks,1);bb.buildBlock(-3,3,-1,Blocks.planks,1);bb.buildBlock(-3,3,0,Blocks.planks,1);
		bb.buildBlock(-3,3,1,Blocks.planks,4);bb.buildBlock(-3,3,2,Blocks.wooden_slab,4);bb.buildBlock(-2,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,3,-2,Blocks.planks,1);bb.buildBlock(-2,3,-1,Blocks.planks,1);bb.buildBlock(-2,3,0,Blocks.planks,1);
		bb.buildBlock(-2,3,1,Blocks.planks,4);bb.buildBlock(-2,3,2,Blocks.wooden_slab,4);bb.buildBlock(-1,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,3,-2,Blocks.planks,1);bb.buildBlock(-1,3,-1,Blocks.planks,1);bb.buildBlock(-1,3,0,Blocks.planks,1);
		bb.buildBlock(-1,3,1,Blocks.planks,4);bb.buildBlock(-1,3,2,Blocks.wooden_slab,4);bb.buildBlock(0,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(0,3,-2,Blocks.planks,1);bb.buildBlock(0,3,-1,Blocks.planks,1);bb.buildBlock(0,3,0,Blocks.planks,1);
		bb.buildBlock(0,3,1,Blocks.planks,4);bb.buildBlock(0,3,2,Blocks.wooden_slab,4);bb.buildBlock(1,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(1,3,-2,Blocks.planks,1);bb.buildBlock(1,3,-1,Blocks.planks,1);bb.buildBlock(1,3,0,Blocks.planks,1);
		bb.buildBlock(1,3,1,Blocks.planks,4);bb.buildBlock(1,3,2,Blocks.wooden_slab,4);bb.buildBlock(2,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(2,3,-2,Blocks.planks,1);bb.buildBlock(2,3,-1,Blocks.planks,1);bb.buildBlock(2,3,0,Blocks.planks,1);
		bb.buildBlock(2,3,1,Blocks.planks,4);bb.buildBlock(2,3,2,Blocks.wooden_slab,4);bb.buildBlock(3,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(3,3,-2,Blocks.planks,1);bb.buildBlock(3,3,-1,Blocks.planks,1);bb.buildBlock(3,3,0,Blocks.planks,1);
		bb.buildBlock(3,3,1,Blocks.planks,4);bb.buildBlock(3,3,2,Blocks.wooden_slab,4);bb.buildBlock(4,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(4,3,-2,Blocks.planks,1);bb.buildBlock(4,3,-1,Blocks.planks,1);bb.buildBlock(4,3,0,Blocks.planks,1);
		bb.buildBlock(4,3,1,Blocks.double_wooden_slab,4);bb.buildBlock(4,3,2,Blocks.wooden_slab,4);bb.buildBlock(5,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(5,3,-2,Blocks.acacia_stairs,7);bb.buildBlock(5,3,-1,Blocks.planks,4);bb.buildBlock(5,3,0,Blocks.wooden_slab,12);
		bb.buildBlock(5,3,1,Blocks.double_wooden_slab,4);bb.buildBlock(5,3,2,Blocks.wooden_slab,4);bb.buildBlock(-5,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,4,-1,Blocks.acacia_stairs,0);bb.buildBlock(-5,4,0,Blocks.wooden_slab,4);bb.buildBlock(-4,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,4,-1,Blocks.planks,4);bb.buildBlock(-4,4,0,Blocks.wooden_slab,4);bb.buildBlock(-3,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,4,-1,Blocks.planks,4);bb.buildBlock(-3,4,0,Blocks.wooden_slab,4);bb.buildBlock(-2,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,4,-1,Blocks.planks,4);bb.buildBlock(-2,4,0,Blocks.wooden_slab,4);bb.buildBlock(-1,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,4,-1,Blocks.planks,4);bb.buildBlock(-1,4,0,Blocks.wooden_slab,4);bb.buildBlock(0,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(0,4,-1,Blocks.planks,4);bb.buildBlock(0,4,0,Blocks.wooden_slab,4);bb.buildBlock(1,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(1,4,-1,Blocks.planks,4);bb.buildBlock(1,4,0,Blocks.wooden_slab,4);bb.buildBlock(2,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(2,4,-1,Blocks.planks,4);bb.buildBlock(2,4,0,Blocks.wooden_slab,4);bb.buildBlock(3,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(3,4,-1,Blocks.planks,4);bb.buildBlock(3,4,0,Blocks.wooden_slab,4);bb.buildBlock(4,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(4,4,-1,Blocks.planks,4);bb.buildBlock(4,4,0,Blocks.wooden_slab,4);bb.buildBlock(5,4,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(5,4,-1,Blocks.acacia_stairs,1);bb.buildBlock(5,4,0,Blocks.wooden_slab,4);bb.buildBlock(-2,1,-3,Blocks.torch,3);
		bb.buildBlock(1,1,-3,Blocks.torch,3);bb.buildBlock(-3,2,2,Blocks.torch,1);bb.buildBlock(-1,2,1,Blocks.torch,3);
		bb.buildBlock(3,2,1,Blocks.torch,3);bb.addEntityPainting(-1,1,-4,0,"Sunset");
		bb.addEntityItemFrame(4,1,0,3,ModBlocks.blockCowShop,0);
		bb.addEntityItemFrame(0,1,0,0,ModItems.itemVillageMilk,0);
		bb.addEntityItemFrame(0,2,0,0,ModItems.itemMilkBottle,0);
	}

}
