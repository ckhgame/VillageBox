package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionFurnitureSeller;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class BuildingFurnitureStore extends Building {

	@Override
	public String getName() {
		return "Furniture Store";
	}

	@Override
	public String getDescription() {
		return "This is a place to sell Furnitures.";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionFurnitureSeller.class,-1,-1 );
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,-3,Blocks.planks,0);bb.buildBlock(-3,-1,-2,Blocks.planks,0);bb.buildBlock(-3,-1,-1,Blocks.planks,0);
		bb.buildBlock(-3,-1,0,Blocks.planks,0);bb.buildBlock(-3,-1,1,Blocks.planks,0);bb.buildBlock(-3,-1,2,Blocks.planks,0);
		bb.buildBlock(-3,-1,3,Blocks.planks,0);bb.buildBlock(-2,-1,-3,Blocks.planks,0);bb.buildBlock(-2,-1,-2,Blocks.planks,0);
		bb.buildBlock(-2,-1,-1,Blocks.planks,0);bb.buildBlock(-2,-1,0,Blocks.planks,0);bb.buildBlock(-2,-1,1,Blocks.planks,0);
		bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-2,-1,3,Blocks.planks,0);bb.buildBlock(-1,-1,-3,Blocks.planks,0);
		bb.buildBlock(-1,-1,-2,Blocks.planks,0);bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,0,Blocks.planks,0);
		bb.buildBlock(-1,-1,1,Blocks.planks,0);bb.buildBlock(-1,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,3,Blocks.planks,0);
		bb.buildBlock(0,-1,-3,Blocks.planks,0);bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.planks,0);
		bb.buildBlock(0,-1,3,Blocks.planks,0);bb.buildBlock(1,-1,-3,Blocks.planks,0);bb.buildBlock(1,-1,-2,Blocks.planks,0);
		bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);bb.buildBlock(1,-1,1,Blocks.planks,0);
		bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(1,-1,3,Blocks.planks,0);bb.buildBlock(2,-1,-3,Blocks.planks,0);
		bb.buildBlock(2,-1,-2,Blocks.planks,0);bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(2,-1,0,Blocks.planks,0);
		bb.buildBlock(2,-1,1,Blocks.planks,0);bb.buildBlock(2,-1,2,Blocks.planks,0);bb.buildBlock(2,-1,3,Blocks.planks,0);
		bb.buildBlock(3,-1,-3,Blocks.planks,0);bb.buildBlock(3,-1,-2,Blocks.planks,0);bb.buildBlock(3,-1,-1,Blocks.planks,0);
		bb.buildBlock(3,-1,0,Blocks.planks,0);bb.buildBlock(3,-1,1,Blocks.planks,0);bb.buildBlock(3,-1,2,Blocks.planks,0);
		bb.buildBlock(3,-1,3,Blocks.planks,0);bb.buildBlock(-4,0,-4,Blocks.planks,1);bb.buildBlock(-4,0,-3,Blocks.planks,1);
		bb.buildBlock(-4,0,-2,Blocks.planks,1);bb.buildBlock(-4,0,-1,Blocks.planks,1);bb.buildBlock(-4,0,0,Blocks.planks,1);
		bb.buildBlock(-4,0,1,Blocks.planks,1);bb.buildBlock(-4,0,2,Blocks.planks,1);bb.buildBlock(-4,0,3,Blocks.planks,1);
		bb.buildBlock(-4,0,4,Blocks.planks,1);bb.buildBlock(-3,0,-4,Blocks.planks,1);bb.buildBlock(-3,0,-3,Blocks.flower_pot,6);
		bb.addTileEntityPot(-3,0,-3,38,6);
		bb.buildBlock(-3,0,0,Blocks.planks,1);bb.buildBlock(-3,0,1,Blocks.carpet,12);bb.buildBlock(-3,0,2,Blocks.carpet,1);
		bb.buildBlock(-3,0,3,Blocks.chest,2);bb.buildBlock(-3,0,4,Blocks.planks,1);bb.buildBlock(-2,0,-4,Blocks.planks,1);bb.buildBlock(-2,0,0,Blocks.wooden_door,1);
		bb.buildBlock(-2,0,1,Blocks.carpet,1);bb.buildBlock(-2,0,2,Blocks.carpet,12);bb.buildBlock(-2,0,3,Blocks.bed,3);
		bb.buildBlock(-2,0,4,Blocks.planks,1);bb.buildBlock(-1,0,-4,Blocks.planks,1);bb.buildBlock(-1,0,0,Blocks.planks,1);
		bb.buildBlock(-1,0,1,Blocks.carpet,12);bb.buildBlock(-1,0,2,Blocks.carpet,1);bb.buildBlock(-1,0,3,Blocks.bed,11);
		bb.buildBlock(-1,0,4,Blocks.planks,1);bb.buildBlock(0,0,-4,Blocks.planks,1);bb.buildBlock(0,0,-2,Blocks.planks,1);
		bb.buildBlock(0,0,-1,Blocks.planks,1);bb.buildBlock(0,0,0,Blocks.planks,1);bb.buildBlock(0,0,1,Blocks.planks,1);
		bb.buildBlock(0,0,2,Blocks.planks,1);bb.buildBlock(0,0,3,Blocks.planks,1);bb.buildBlock(0,0,4,Blocks.planks,1);
		bb.buildBlock(1,0,-4,Blocks.planks,1);bb.buildBlock(1,0,3,Blocks.birch_stairs,2);bb.buildBlock(1,0,4,Blocks.planks,1);
		bb.buildBlock(2,0,-4,Blocks.planks,1);bb.buildBlock(2,0,4,Blocks.planks,1);bb.buildBlock(3,0,-4,Blocks.planks,1);
		bb.buildBlock(3,0,-2,ModBlocks.blockWoodenChair,0);bb.buildBlock(3,0,3,ModBlocks.blockWoodenChair,0);bb.buildBlock(3,0,4,Blocks.planks,1);bb.buildBlock(4,0,-4,Blocks.planks,1);bb.buildBlock(4,0,-3,Blocks.planks,1);
		bb.buildBlock(4,0,-2,Blocks.planks,1);bb.buildBlock(4,0,-1,Blocks.planks,1);bb.buildBlock(4,0,0,Blocks.wooden_door,2);
		bb.buildBlock(4,0,1,Blocks.planks,1);bb.buildBlock(4,0,2,Blocks.planks,1);bb.buildBlock(4,0,3,Blocks.planks,1);
		bb.buildBlock(4,0,4,Blocks.planks,1);bb.buildBlock(-4,1,-4,Blocks.planks,1);bb.buildBlock(-4,1,-3,Blocks.planks,1);
		bb.buildBlock(-4,1,-2,Blocks.planks,1);bb.buildBlock(-4,1,-1,Blocks.planks,1);bb.buildBlock(-4,1,0,Blocks.planks,1);
		bb.buildBlock(-4,1,1,Blocks.planks,1);bb.buildBlock(-4,1,2,Blocks.planks,1);bb.buildBlock(-4,1,3,Blocks.planks,1);
		bb.buildBlock(-4,1,4,Blocks.planks,1);bb.buildBlock(-3,1,-4,Blocks.planks,1);bb.buildBlock(-3,1,0,Blocks.planks,1);
		bb.buildBlock(-3,1,4,Blocks.planks,1);bb.buildBlock(-2,1,-4,Blocks.glass_pane,0);bb.buildBlock(-2,1,0,Blocks.wooden_door,8);
		bb.buildBlock(-2,1,4,Blocks.planks,1);bb.buildBlock(-1,1,-4,Blocks.glass_pane,0);bb.buildBlock(-1,1,0,Blocks.planks,1);
		bb.buildBlock(-1,1,4,Blocks.planks,1);bb.buildBlock(0,1,-4,Blocks.planks,1);bb.buildBlock(0,1,0,Blocks.planks,1);
		bb.buildBlock(0,1,1,Blocks.planks,1);bb.buildBlock(0,1,2,Blocks.planks,1);bb.buildBlock(0,1,3,Blocks.planks,1);
		bb.buildBlock(0,1,4,Blocks.planks,1);bb.buildBlock(1,1,-4,Blocks.planks,1);bb.buildBlock(1,1,4,Blocks.planks,1);
		bb.buildBlock(2,1,-4,Blocks.planks,1);bb.buildBlock(2,1,4,Blocks.glass_pane,0);bb.buildBlock(3,1,-4,Blocks.planks,1);
		bb.buildBlock(3,1,4,Blocks.planks,1);bb.buildBlock(4,1,-4,Blocks.planks,1);bb.buildBlock(4,1,-3,Blocks.planks,1);
		bb.buildBlock(4,1,-2,Blocks.glass_pane,0);bb.buildBlock(4,1,-1,Blocks.planks,1);bb.buildBlock(4,1,0,Blocks.wooden_door,8);
		bb.buildBlock(4,1,1,Blocks.planks,1);bb.buildBlock(4,1,2,Blocks.glass_pane,0);bb.buildBlock(4,1,3,Blocks.glass_pane,0);
		bb.buildBlock(4,1,4,Blocks.planks,1);bb.buildBlock(-4,2,-4,Blocks.planks,1);bb.buildBlock(-4,2,-3,Blocks.planks,1);
		bb.buildBlock(-4,2,-2,Blocks.planks,1);bb.buildBlock(-4,2,-1,Blocks.planks,1);bb.buildBlock(-4,2,0,Blocks.planks,1);
		bb.buildBlock(-4,2,1,Blocks.planks,1);bb.buildBlock(-4,2,2,Blocks.planks,1);bb.buildBlock(-4,2,3,Blocks.planks,1);
		bb.buildBlock(-4,2,4,Blocks.planks,1);bb.buildBlock(-3,2,-4,Blocks.planks,1);bb.buildBlock(-3,2,0,Blocks.planks,1);
		bb.buildBlock(-3,2,4,Blocks.planks,1);bb.buildBlock(-2,2,-4,Blocks.glass_pane,0);bb.buildBlock(-2,2,0,Blocks.planks,1);
		bb.buildBlock(-2,2,4,Blocks.planks,1);bb.buildBlock(-1,2,-4,Blocks.glass_pane,0);bb.buildBlock(-1,2,0,Blocks.planks,1);
		bb.buildBlock(-1,2,4,Blocks.planks,1);bb.buildBlock(0,2,-4,Blocks.planks,1);bb.buildBlock(0,2,0,Blocks.planks,1);
		bb.buildBlock(0,2,1,Blocks.planks,1);bb.buildBlock(0,2,2,Blocks.planks,1);bb.buildBlock(0,2,3,Blocks.planks,1);
		bb.buildBlock(0,2,4,Blocks.planks,1);bb.buildBlock(1,2,-4,Blocks.planks,1);bb.buildBlock(1,2,4,Blocks.planks,1);
		bb.buildBlock(2,2,-4,Blocks.planks,1);bb.buildBlock(2,2,4,Blocks.glass_pane,0);bb.buildBlock(3,2,-4,Blocks.planks,1);
		bb.buildBlock(3,2,4,Blocks.planks,1);bb.buildBlock(4,2,-4,Blocks.planks,1);bb.buildBlock(4,2,-3,Blocks.planks,1);
		bb.buildBlock(4,2,-2,Blocks.glass_pane,0);bb.buildBlock(4,2,-1,Blocks.planks,1);bb.buildBlock(4,2,0,Blocks.planks,1);
		bb.buildBlock(4,2,1,Blocks.planks,1);bb.buildBlock(4,2,2,Blocks.glass_pane,0);bb.buildBlock(4,2,3,Blocks.glass_pane,0);
		bb.buildBlock(4,2,4,Blocks.planks,1);bb.buildBlock(-5,3,-5,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,-4,Blocks.acacia_stairs,0);
		bb.buildBlock(-5,3,-3,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,-2,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,-1,Blocks.acacia_stairs,0);
		bb.buildBlock(-5,3,0,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,1,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,2,Blocks.acacia_stairs,0);
		bb.buildBlock(-5,3,3,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,4,Blocks.acacia_stairs,0);bb.buildBlock(-5,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-4,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-4,3,-4,Blocks.planks,1);bb.buildBlock(-4,3,-3,Blocks.planks,1);
		bb.buildBlock(-4,3,-2,Blocks.planks,1);bb.buildBlock(-4,3,-1,Blocks.planks,1);bb.buildBlock(-4,3,0,Blocks.planks,1);
		bb.buildBlock(-4,3,1,Blocks.planks,1);bb.buildBlock(-4,3,2,Blocks.planks,1);bb.buildBlock(-4,3,3,Blocks.planks,1);
		bb.buildBlock(-4,3,4,Blocks.planks,1);bb.buildBlock(-4,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-3,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,3,-4,Blocks.planks,1);bb.buildBlock(-3,3,0,Blocks.planks,1);bb.buildBlock(-3,3,3,Blocks.bookshelf,0);
		bb.buildBlock(-3,3,4,Blocks.planks,1);bb.buildBlock(-3,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-2,3,-5,Blocks.acacia_stairs,6);
		bb.buildBlock(-2,3,-4,Blocks.planks,1);bb.buildBlock(-2,3,0,Blocks.planks,1);bb.buildBlock(-2,3,3,Blocks.bookshelf,0);
		bb.buildBlock(-2,3,4,Blocks.planks,1);bb.buildBlock(-2,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-1,3,-5,Blocks.acacia_stairs,6);
		bb.buildBlock(-1,3,-4,Blocks.planks,1);bb.buildBlock(-1,3,0,Blocks.planks,1);bb.buildBlock(-1,3,3,Blocks.bookshelf,0);
		bb.buildBlock(-1,3,4,Blocks.planks,1);bb.buildBlock(-1,3,5,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(0,3,-4,Blocks.planks,1);bb.buildBlock(0,3,0,Blocks.planks,1);bb.buildBlock(0,3,1,Blocks.planks,1);
		bb.buildBlock(0,3,2,Blocks.planks,1);bb.buildBlock(0,3,3,Blocks.planks,1);bb.buildBlock(0,3,4,Blocks.planks,1);
		bb.buildBlock(0,3,5,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(1,3,-4,Blocks.planks,1);
		bb.buildBlock(1,3,4,Blocks.planks,1);bb.buildBlock(1,3,5,Blocks.acacia_stairs,3);bb.buildBlock(2,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(2,3,-4,Blocks.planks,1);bb.buildBlock(2,3,4,Blocks.planks,1);bb.buildBlock(2,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(3,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(3,3,-4,Blocks.planks,1);bb.buildBlock(3,3,4,Blocks.planks,1);
		bb.buildBlock(3,3,5,Blocks.acacia_stairs,3);bb.buildBlock(4,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(4,3,-4,Blocks.planks,1);
		bb.buildBlock(4,3,-3,Blocks.planks,1);bb.buildBlock(4,3,-2,Blocks.planks,1);bb.buildBlock(4,3,-1,Blocks.planks,1);
		bb.buildBlock(4,3,0,Blocks.planks,1);bb.buildBlock(4,3,1,Blocks.planks,1);bb.buildBlock(4,3,2,Blocks.planks,1);
		bb.buildBlock(4,3,3,Blocks.planks,1);bb.buildBlock(4,3,4,Blocks.planks,1);bb.buildBlock(4,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(5,3,-5,Blocks.acacia_stairs,1);bb.buildBlock(5,3,-4,Blocks.acacia_stairs,1);bb.buildBlock(5,3,-3,Blocks.acacia_stairs,1);
		bb.buildBlock(5,3,-2,Blocks.acacia_stairs,5);bb.buildBlock(5,3,-1,Blocks.acacia_stairs,1);bb.buildBlock(5,3,0,Blocks.acacia_stairs,1);
		bb.buildBlock(5,3,1,Blocks.acacia_stairs,1);bb.buildBlock(5,3,2,Blocks.acacia_stairs,5);bb.buildBlock(5,3,3,Blocks.acacia_stairs,5);
		bb.buildBlock(5,3,4,Blocks.acacia_stairs,1);bb.buildBlock(5,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-4,4,-4,Blocks.acacia_stairs,0);
		bb.buildBlock(-4,4,-3,Blocks.acacia_stairs,0);bb.buildBlock(-4,4,-2,Blocks.acacia_stairs,0);bb.buildBlock(-4,4,-1,Blocks.acacia_stairs,0);
		bb.buildBlock(-4,4,0,Blocks.acacia_stairs,0);bb.buildBlock(-4,4,1,Blocks.acacia_stairs,0);bb.buildBlock(-4,4,2,Blocks.acacia_stairs,0);
		bb.buildBlock(-4,4,3,Blocks.acacia_stairs,0);bb.buildBlock(-4,4,4,Blocks.acacia_stairs,0);bb.buildBlock(-3,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,4,-3,Blocks.planks,0);bb.buildBlock(-3,4,-2,Blocks.planks,0);bb.buildBlock(-3,4,-1,Blocks.planks,0);
		bb.buildBlock(-3,4,0,Blocks.planks,0);bb.buildBlock(-3,4,1,Blocks.planks,0);bb.buildBlock(-3,4,2,Blocks.planks,0);
		bb.buildBlock(-3,4,3,Blocks.planks,0);bb.buildBlock(-3,4,4,Blocks.acacia_stairs,3);bb.buildBlock(-2,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,4,-3,Blocks.planks,0);bb.buildBlock(-2,4,-2,Blocks.planks,4);bb.buildBlock(-2,4,-1,Blocks.planks,4);
		bb.buildBlock(-2,4,0,Blocks.planks,4);bb.buildBlock(-2,4,1,Blocks.planks,4);bb.buildBlock(-2,4,2,Blocks.planks,4);
		bb.buildBlock(-2,4,3,Blocks.planks,0);bb.buildBlock(-2,4,4,Blocks.acacia_stairs,3);bb.buildBlock(-1,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,4,-3,Blocks.planks,0);bb.buildBlock(-1,4,-2,Blocks.planks,0);bb.buildBlock(-1,4,-1,Blocks.planks,0);
		bb.buildBlock(-1,4,0,Blocks.planks,0);bb.buildBlock(-1,4,1,Blocks.planks,0);bb.buildBlock(-1,4,2,Blocks.planks,0);
		bb.buildBlock(-1,4,3,Blocks.planks,0);bb.buildBlock(-1,4,4,Blocks.acacia_stairs,3);bb.buildBlock(0,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(0,4,-3,Blocks.planks,0);bb.buildBlock(0,4,-2,Blocks.planks,4);bb.buildBlock(0,4,-1,Blocks.planks,4);
		bb.buildBlock(0,4,0,Blocks.planks,4);bb.buildBlock(0,4,1,Blocks.planks,4);bb.buildBlock(0,4,2,Blocks.planks,4);
		bb.buildBlock(0,4,3,Blocks.planks,0);bb.buildBlock(0,4,4,Blocks.acacia_stairs,3);bb.buildBlock(1,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(1,4,-3,Blocks.planks,0);bb.buildBlock(1,4,-2,Blocks.planks,0);bb.buildBlock(1,4,-1,Blocks.planks,0);
		bb.buildBlock(1,4,0,Blocks.planks,0);bb.buildBlock(1,4,1,Blocks.planks,0);bb.buildBlock(1,4,2,Blocks.planks,0);
		bb.buildBlock(1,4,3,Blocks.planks,0);bb.buildBlock(1,4,4,Blocks.acacia_stairs,3);bb.buildBlock(2,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(2,4,-3,Blocks.planks,0);bb.buildBlock(2,4,-2,Blocks.planks,4);bb.buildBlock(2,4,-1,Blocks.planks,4);
		bb.buildBlock(2,4,0,Blocks.planks,4);bb.buildBlock(2,4,1,Blocks.planks,4);bb.buildBlock(2,4,2,Blocks.planks,4);
		bb.buildBlock(2,4,3,Blocks.planks,0);bb.buildBlock(2,4,4,Blocks.acacia_stairs,3);bb.buildBlock(3,4,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(3,4,-3,Blocks.planks,0);bb.buildBlock(3,4,-2,Blocks.planks,0);bb.buildBlock(3,4,-1,Blocks.planks,0);
		bb.buildBlock(3,4,0,Blocks.planks,0);bb.buildBlock(3,4,1,Blocks.planks,0);bb.buildBlock(3,4,2,Blocks.planks,0);
		bb.buildBlock(3,4,3,Blocks.planks,0);bb.buildBlock(3,4,4,Blocks.acacia_stairs,3);bb.buildBlock(4,4,-4,Blocks.acacia_stairs,1);
		bb.buildBlock(4,4,-3,Blocks.acacia_stairs,1);bb.buildBlock(4,4,-2,Blocks.acacia_stairs,1);bb.buildBlock(4,4,-1,Blocks.acacia_stairs,1);
		bb.buildBlock(4,4,0,Blocks.acacia_stairs,1);bb.buildBlock(4,4,1,Blocks.acacia_stairs,1);bb.buildBlock(4,4,2,Blocks.acacia_stairs,1);
		bb.buildBlock(4,4,3,Blocks.acacia_stairs,1);bb.buildBlock(4,4,4,Blocks.acacia_stairs,1);bb.buildBlock(-3,3,-3,Blocks.torch,3);
		bb.buildBlock(-3,3,-1,Blocks.torch,4);bb.buildBlock(-3,3,1,Blocks.torch,3);bb.buildBlock(-2,3,1,Blocks.torch,3);
		bb.buildBlock(-1,3,1,Blocks.torch,3);bb.buildBlock(0,3,-3,Blocks.torch,3);bb.buildBlock(1,3,3,Blocks.torch,4);
		bb.buildBlock(3,3,-3,Blocks.torch,3);bb.buildBlock(3,3,3,Blocks.torch,4);bb.addEntityItemFrame(0,2,2,3,ModBlocks.blockWoodenChair,0);
		bb.addEntityItemFrame(0,2,1,3,ModBlocks.blockWineShelf,0);
		bb.addEntityItemFrame(0,1,2,3,ModBlocks.blockWineBucket,0);
		bb.addEntityItemFrame(0,1,1,3,Items.painting,0);
		bb.addEntityItemFrame(0,2,0,3,Items.bed,0);
		bb.addEntityItemFrame(0,1,0,3,Blocks.bookshelf,0);
		bb.addEntityItemFrame(4,1,1,3,ModBlocks.blockFurnitureStore,0);
	}

}
