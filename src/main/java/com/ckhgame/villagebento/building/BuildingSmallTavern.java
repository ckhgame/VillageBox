package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.profession.ProfessionTavernOwner;

import net.minecraft.init.Blocks;

public class BuildingSmallTavern extends Building {

	@Override
	public String getName() {
		return "Small Tavern";
	}

	@Override
	public String getDescription() {
		return "A place to get liquid!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionTavernOwner.class,0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-6,-3,Blocks.planks,1);bb.buildBlock(-3,-6,-2,Blocks.planks,1);bb.buildBlock(-3,-6,-1,Blocks.planks,1);
		bb.buildBlock(-3,-6,0,Blocks.planks,1);bb.buildBlock(-3,-6,1,Blocks.planks,1);bb.buildBlock(-2,-6,-3,Blocks.planks,1);
		bb.buildBlock(-2,-6,-2,Blocks.planks,1);bb.buildBlock(-2,-6,-1,Blocks.planks,1);bb.buildBlock(-2,-6,0,Blocks.planks,1);
		bb.buildBlock(-2,-6,1,Blocks.planks,1);bb.buildBlock(0,-6,0,Blocks.planks,1);bb.buildBlock(1,-6,-3,Blocks.planks,1);
		bb.buildBlock(1,-6,-2,Blocks.planks,1);bb.buildBlock(1,-6,-1,Blocks.planks,1);bb.buildBlock(1,-6,0,Blocks.planks,1);
		bb.buildBlock(1,-6,1,Blocks.planks,1);bb.buildBlock(2,-6,-3,Blocks.planks,1);bb.buildBlock(2,-6,-2,Blocks.planks,1);
		bb.buildBlock(2,-6,-1,Blocks.planks,1);bb.buildBlock(2,-6,0,Blocks.planks,1);bb.buildBlock(2,-6,1,Blocks.planks,1);
		bb.buildBlock(3,-6,-3,Blocks.planks,1);bb.buildBlock(3,-6,-2,Blocks.planks,1);bb.buildBlock(3,-6,-1,Blocks.planks,1);
		bb.buildBlock(3,-6,0,Blocks.planks,1);bb.buildBlock(3,-6,1,Blocks.planks,1);bb.buildBlock(-4,-5,-3,ModBlocks.blockWineBucket,0);
		bb.buildBlock(-4,-5,-2,ModBlocks.blockWineShelf,0);bb.buildBlock(-4,-5,-1,ModBlocks.blockWineShelf,0);bb.buildBlock(-4,-5,0,Blocks.air,0);
		bb.buildBlock(-4,-5,1,Blocks.air,0);bb.buildBlock(-4,-5,2,Blocks.stone_brick_stairs,2);bb.buildBlock(-3,-5,-3,ModBlocks.blockWineBucket,0);
		bb.buildBlock(-3,-5,-2,Blocks.air,0);bb.buildBlock(-3,-5,-1,Blocks.air,0);bb.buildBlock(-3,-5,0,Blocks.air,0);
		bb.buildBlock(-3,-5,1,Blocks.air,0);bb.buildBlock(-3,-5,2,Blocks.stone_brick_stairs,2);bb.buildBlock(-2,-5,-3,ModBlocks.blockWineBucket,0);
		bb.buildBlock(-2,-5,-2,Blocks.air,0);bb.buildBlock(-2,-5,-1,Blocks.air,0);bb.buildBlock(-2,-5,0,Blocks.air,0);
		bb.buildBlock(-2,-5,1,Blocks.air,0);bb.buildBlock(-1,-5,-3,ModBlocks.blockWineBucket,0);bb.buildBlock(-1,-5,-2,Blocks.chest,4);
		bb.buildBlock(-1,-5,-1,Blocks.chest,4);bb.buildBlock(-1,-5,0,Blocks.air,0);bb.buildBlock(-1,-5,1,Blocks.air,0);bb.buildBlock(0,-5,-3,Blocks.planks,1);
		bb.buildBlock(0,-5,-2,Blocks.planks,1);bb.buildBlock(0,-5,-1,Blocks.planks,1);bb.buildBlock(0,-5,0,Blocks.wooden_door,0);
		bb.buildBlock(0,-5,1,Blocks.planks,1);bb.buildBlock(1,-5,-4,Blocks.planks,1);bb.buildBlock(1,-5,-3,Blocks.air,0);
		bb.buildBlock(1,-5,-2,Blocks.air,0);bb.buildBlock(1,-5,-1,Blocks.air,0);bb.buildBlock(1,-5,0,Blocks.air,0);
		bb.buildBlock(1,-5,1,Blocks.air,0);bb.buildBlock(1,-5,2,Blocks.planks,1);bb.buildBlock(2,-5,-4,Blocks.planks,1);
		bb.buildBlock(2,-5,-3,Blocks.bed,3);bb.buildBlock(2,-5,-2,Blocks.air,0);bb.buildBlock(2,-5,-1,Blocks.air,0);
		bb.buildBlock(2,-5,0,Blocks.air,0);bb.buildBlock(2,-5,1,Blocks.bed,3);bb.buildBlock(2,-5,2,Blocks.planks,1);
		bb.buildBlock(3,-5,-4,Blocks.planks,1);bb.buildBlock(3,-5,-3,Blocks.bed,11);bb.buildBlock(3,-5,-2,Blocks.bookshelf,0);
		bb.buildBlock(3,-5,-1,Blocks.planks,1);bb.buildBlock(3,-5,0,Blocks.bookshelf,0);bb.buildBlock(3,-5,1,Blocks.bed,11);
		bb.buildBlock(3,-5,2,Blocks.planks,1);bb.buildBlock(4,-5,-3,Blocks.planks,1);bb.buildBlock(4,-5,-2,Blocks.planks,1);
		bb.buildBlock(4,-5,-1,Blocks.planks,1);bb.buildBlock(4,-5,0,Blocks.planks,1);bb.buildBlock(4,-5,1,Blocks.planks,1);
		bb.buildBlock(-4,-4,-3,ModBlocks.blockWineBucket,0);bb.buildBlock(-4,-4,-2,ModBlocks.blockWineShelf,0);bb.buildBlock(-4,-4,-1,ModBlocks.blockWineShelf,0);
		bb.buildBlock(-4,-4,0,Blocks.air,0);bb.buildBlock(-4,-4,1,Blocks.air,0);bb.buildBlock(-4,-4,2,Blocks.air,0);
		bb.buildBlock(-4,-4,3,Blocks.air,0);bb.buildBlock(-3,-4,-3,ModBlocks.blockWineBucket,0);bb.buildBlock(-3,-4,-2,Blocks.air,0);
		bb.buildBlock(-3,-4,-1,Blocks.air,0);bb.buildBlock(-3,-4,0,Blocks.air,0);bb.buildBlock(-3,-4,1,Blocks.air,0);
		bb.buildBlock(-3,-4,2,Blocks.air,0);bb.buildBlock(-3,-4,3,Blocks.stone_brick_stairs,0);bb.buildBlock(-2,-4,-3,ModBlocks.blockWineBucket,0);
		bb.buildBlock(-2,-4,-2,Blocks.air,0);bb.buildBlock(-2,-4,-1,Blocks.air,0);bb.buildBlock(-2,-4,0,Blocks.air,0);
		bb.buildBlock(-2,-4,1,Blocks.air,0);bb.buildBlock(-1,-4,-3,ModBlocks.blockWineBucket,0);bb.buildBlock(-1,-4,-2,Blocks.air,0);
		bb.buildBlock(-1,-4,-1,Blocks.air,0);bb.buildBlock(-1,-4,0,Blocks.air,0);bb.buildBlock(-1,-4,1,Blocks.air,0);
		bb.buildBlock(0,-4,-3,Blocks.planks,1);bb.buildBlock(0,-4,-2,Blocks.planks,1);bb.buildBlock(0,-4,-1,Blocks.planks,1);
		bb.buildBlock(0,-4,0,Blocks.wooden_door,8);bb.buildBlock(0,-4,1,Blocks.planks,1);bb.buildBlock(1,-4,-4,Blocks.planks,1);
		bb.buildBlock(1,-4,-3,Blocks.air,0);bb.buildBlock(1,-4,-2,Blocks.air,0);bb.buildBlock(1,-4,-1,Blocks.air,0);
		bb.buildBlock(1,-4,0,Blocks.air,0);bb.buildBlock(1,-4,1,Blocks.air,0);bb.buildBlock(1,-4,2,Blocks.planks,1);
		bb.buildBlock(2,-4,-4,Blocks.planks,1);bb.buildBlock(2,-4,-3,Blocks.air,0);bb.buildBlock(2,-4,-2,Blocks.air,0);
		bb.buildBlock(2,-4,-1,Blocks.air,0);bb.buildBlock(2,-4,0,Blocks.air,0);bb.buildBlock(2,-4,1,Blocks.air,0);
		bb.buildBlock(2,-4,2,Blocks.planks,1);bb.buildBlock(3,-4,-4,Blocks.planks,1);bb.buildBlock(3,-4,-3,Blocks.air,0);
		bb.buildBlock(3,-4,-2,Blocks.air,0);bb.buildBlock(3,-4,-1,Blocks.air,0);bb.buildBlock(3,-4,0,Blocks.air,0);
		bb.buildBlock(3,-4,1,Blocks.air,0);bb.buildBlock(3,-4,2,Blocks.planks,1);bb.buildBlock(4,-4,-3,Blocks.planks,1);
		bb.buildBlock(4,-4,-2,Blocks.planks,1);bb.buildBlock(4,-4,-1,Blocks.planks,1);bb.buildBlock(4,-4,0,Blocks.planks,1);
		bb.buildBlock(4,-4,1,Blocks.planks,1);bb.buildBlock(-4,-3,-3,ModBlocks.blockWineShelf,0);bb.buildBlock(-4,-3,-2,Blocks.air,0);
		bb.buildBlock(-4,-3,-1,Blocks.air,0);bb.buildBlock(-4,-3,0,Blocks.air,0);bb.buildBlock(-4,-3,1,Blocks.air,0);
		bb.buildBlock(-4,-3,2,Blocks.air,0);bb.buildBlock(-4,-3,3,Blocks.air,0);bb.buildBlock(-3,-3,-3,ModBlocks.blockWineShelf,0);
		bb.buildBlock(-3,-3,-2,Blocks.air,0);bb.buildBlock(-3,-3,-1,Blocks.air,0);bb.buildBlock(-3,-3,0,Blocks.air,0);
		bb.buildBlock(-3,-3,1,Blocks.air,0);bb.buildBlock(-3,-3,2,Blocks.air,0);bb.buildBlock(-3,-3,3,Blocks.air,0);
		bb.buildBlock(-2,-3,-3,ModBlocks.blockWineShelf,0);bb.buildBlock(-2,-3,-2,Blocks.air,0);bb.buildBlock(-2,-3,-1,Blocks.air,0);
		bb.buildBlock(-2,-3,0,Blocks.air,0);bb.buildBlock(-2,-3,1,Blocks.air,0);bb.buildBlock(-2,-3,3,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-1,-3,-3,ModBlocks.blockWineShelf,0);bb.buildBlock(-1,-3,-2,Blocks.air,0);bb.buildBlock(-1,-3,-1,Blocks.air,0);
		bb.buildBlock(-1,-3,0,Blocks.air,0);bb.buildBlock(-1,-3,1,Blocks.air,0);bb.buildBlock(0,-3,-3,Blocks.planks,1);
		bb.buildBlock(0,-3,-2,Blocks.planks,1);bb.buildBlock(0,-3,-1,Blocks.planks,1);bb.buildBlock(0,-3,0,Blocks.planks,1);
		bb.buildBlock(0,-3,1,Blocks.planks,1);bb.buildBlock(1,-3,-4,Blocks.planks,1);bb.buildBlock(1,-3,-3,Blocks.air,0);
		bb.buildBlock(1,-3,-2,Blocks.air,0);bb.buildBlock(1,-3,-1,Blocks.air,0);bb.buildBlock(1,-3,0,Blocks.air,0);
		bb.buildBlock(1,-3,1,Blocks.air,0);bb.buildBlock(1,-3,2,Blocks.planks,1);bb.buildBlock(2,-3,-4,Blocks.planks,1);
		bb.buildBlock(2,-3,-3,Blocks.air,0);bb.buildBlock(2,-3,-2,Blocks.air,0);bb.buildBlock(2,-3,-1,Blocks.air,0);
		bb.buildBlock(2,-3,0,Blocks.air,0);bb.buildBlock(2,-3,1,Blocks.air,0);bb.buildBlock(2,-3,2,Blocks.planks,1);
		bb.buildBlock(3,-3,-4,Blocks.planks,1);bb.buildBlock(3,-3,-2,Blocks.air,0);bb.buildBlock(3,-3,-1,Blocks.air,0);
		bb.buildBlock(3,-3,0,Blocks.air,0);bb.buildBlock(3,-3,2,Blocks.planks,1);bb.buildBlock(4,-3,-3,Blocks.planks,1);
		bb.buildBlock(4,-3,-2,Blocks.planks,1);bb.buildBlock(4,-3,-1,Blocks.planks,1);bb.buildBlock(4,-3,0,Blocks.planks,1);
		bb.buildBlock(4,-3,1,Blocks.planks,1);bb.buildBlock(-4,-2,-3,Blocks.air,0);bb.buildBlock(-4,-2,-2,Blocks.air,0);
		bb.buildBlock(-4,-2,0,Blocks.air,0);bb.buildBlock(-4,-2,1,Blocks.air,0);bb.buildBlock(-4,-2,3,Blocks.air,0);
		bb.buildBlock(-3,-2,-3,Blocks.air,0);bb.buildBlock(-3,-2,-2,Blocks.air,0);bb.buildBlock(-3,-2,-1,Blocks.air,0);
		bb.buildBlock(-3,-2,0,Blocks.air,0);bb.buildBlock(-3,-2,1,Blocks.air,0);bb.buildBlock(-3,-2,3,Blocks.air,0);
		bb.buildBlock(-2,-2,-2,Blocks.air,0);bb.buildBlock(-2,-2,-1,Blocks.air,0);bb.buildBlock(-2,-2,0,Blocks.air,0);
		bb.buildBlock(-2,-2,3,Blocks.air,0);bb.buildBlock(-1,-2,-3,Blocks.air,0);bb.buildBlock(-1,-2,-2,Blocks.air,0);
		bb.buildBlock(-1,-2,-1,Blocks.air,0);bb.buildBlock(-1,-2,0,Blocks.air,0);bb.buildBlock(-1,-2,1,Blocks.air,0);
		bb.buildBlock(-1,-2,3,Blocks.stone_brick_stairs,0);bb.buildBlock(0,-2,-3,Blocks.planks,1);bb.buildBlock(0,-2,-2,Blocks.planks,1);
		bb.buildBlock(0,-2,-1,Blocks.planks,1);bb.buildBlock(0,-2,0,Blocks.planks,1);bb.buildBlock(0,-2,1,Blocks.planks,1);
		bb.buildBlock(1,-2,-3,Blocks.planks,1);bb.buildBlock(1,-2,-2,Blocks.planks,1);bb.buildBlock(1,-2,-1,Blocks.planks,1);
		bb.buildBlock(1,-2,0,Blocks.planks,1);bb.buildBlock(1,-2,1,Blocks.planks,1);bb.buildBlock(2,-2,-3,Blocks.planks,1);
		bb.buildBlock(2,-2,-2,Blocks.planks,1);bb.buildBlock(2,-2,-1,Blocks.planks,1);bb.buildBlock(2,-2,0,Blocks.planks,1);
		bb.buildBlock(2,-2,1,Blocks.planks,1);bb.buildBlock(3,-2,-3,Blocks.planks,1);bb.buildBlock(3,-2,-2,Blocks.planks,1);
		bb.buildBlock(3,-2,-1,Blocks.planks,1);bb.buildBlock(3,-2,0,Blocks.planks,1);bb.buildBlock(3,-2,1,Blocks.planks,1);
		bb.buildBlock(-3,-1,3,Blocks.air,0);bb.buildBlock(-2,-1,3,Blocks.air,0);bb.buildBlock(-1,-1,3,Blocks.air,0);
		bb.buildBlock(0,-1,3,Blocks.stone_brick_stairs,0);bb.buildBlock(-5,0,-5,Blocks.fence,0);bb.buildBlock(-5,0,5,Blocks.fence,0);
		bb.buildBlock(-4,0,-4,Blocks.planks,1);bb.buildBlock(-4,0,-3,Blocks.planks,1);bb.buildBlock(-4,0,-2,Blocks.planks,1);
		bb.buildBlock(-4,0,-1,Blocks.planks,1);bb.buildBlock(-4,0,0,Blocks.planks,1);bb.buildBlock(-4,0,1,Blocks.planks,1);
		bb.buildBlock(-4,0,2,Blocks.planks,1);bb.buildBlock(-4,0,3,Blocks.planks,1);bb.buildBlock(-4,0,4,Blocks.planks,1);
		bb.buildBlock(-3,0,-4,Blocks.planks,1);bb.buildBlock(-3,0,-3,ModBlocks.blockWineBucket,0);bb.buildBlock(-3,0,1,Blocks.planks,1);
		bb.buildBlock(-3,0,2,Blocks.planks,1);bb.buildBlock(-3,0,4,Blocks.planks,1);bb.buildBlock(-2,0,-4,Blocks.planks,1);
		bb.buildBlock(-2,0,4,Blocks.planks,1);bb.buildBlock(-1,0,-4,Blocks.planks,1);bb.buildBlock(-1,0,-2,ModBlocks.blockWoodenChair,0);
		bb.buildBlock(-1,0,-1,Blocks.planks,1);bb.buildBlock(-1,0,4,Blocks.planks,1);bb.buildBlock(0,0,-4,Blocks.planks,1);
		bb.buildBlock(0,0,-1,Blocks.planks,1);bb.buildBlock(0,0,4,Blocks.planks,1);bb.buildBlock(1,0,-4,Blocks.planks,1);
		bb.buildBlock(1,0,-2,ModBlocks.blockWoodenChair,0);bb.buildBlock(1,0,-1,Blocks.planks,1);bb.buildBlock(1,0,0,Blocks.planks,1);bb.buildBlock(1,0,1,Blocks.planks,1);
		bb.buildBlock(1,0,2,Blocks.planks,1);bb.buildBlock(1,0,3,Blocks.planks,1);bb.buildBlock(1,0,4,Blocks.planks,1);
		bb.buildBlock(2,0,-4,Blocks.planks,1);bb.buildBlock(2,0,-1,ModBlocks.blockWoodenChair,0);bb.buildBlock(2,0,1,ModBlocks.blockWoodenChair,0);bb.buildBlock(2,0,3,ModBlocks.blockWoodenChair,0);bb.buildBlock(2,0,4,Blocks.planks,1);bb.buildBlock(3,0,-4,Blocks.planks,1);bb.buildBlock(3,0,4,Blocks.planks,1);
		bb.buildBlock(4,0,-4,Blocks.planks,1);bb.buildBlock(4,0,-3,Blocks.planks,1);bb.buildBlock(4,0,-2,Blocks.planks,1);
		bb.buildBlock(4,0,-1,Blocks.planks,1);bb.buildBlock(4,0,0,Blocks.wooden_door,2);bb.buildBlock(4,0,1,Blocks.wooden_door,2);
		bb.buildBlock(4,0,2,Blocks.planks,1);bb.buildBlock(4,0,3,Blocks.planks,1);bb.buildBlock(4,0,4,Blocks.planks,1);
		bb.buildBlock(5,0,-5,Blocks.fence,0);bb.buildBlock(5,0,5,Blocks.fence,0);bb.buildBlock(-5,1,-5,Blocks.fence,0);
		bb.buildBlock(-5,1,5,Blocks.fence,0);bb.buildBlock(-4,1,-4,Blocks.planks,1);bb.buildBlock(-4,1,-3,Blocks.planks,1);
		bb.buildBlock(-4,1,-2,Blocks.planks,1);bb.buildBlock(-4,1,-1,Blocks.planks,1);bb.buildBlock(-4,1,0,Blocks.planks,1);
		bb.buildBlock(-4,1,1,Blocks.planks,1);bb.buildBlock(-4,1,2,Blocks.planks,1);bb.buildBlock(-4,1,3,Blocks.planks,1);
		bb.buildBlock(-4,1,4,Blocks.planks,1);bb.buildBlock(-3,1,-4,Blocks.planks,1);bb.buildBlock(-3,1,-3,ModBlocks.blockWineBucket,0);
		bb.buildBlock(-3,1,1,ModBlocks.blockWineShelf,0);bb.buildBlock(-3,1,2,ModBlocks.blockWineShelf,0);bb.buildBlock(-3,1,4,Blocks.planks,1);
		bb.buildBlock(-2,1,-4,Blocks.planks,1);bb.buildBlock(-2,1,4,Blocks.planks,1);bb.buildBlock(-1,1,-4,Blocks.glass_pane,0);
		bb.buildBlock(-1,1,4,Blocks.glass_pane,0);bb.buildBlock(0,1,-4,Blocks.glass_pane,0);bb.buildBlock(0,1,4,Blocks.glass_pane,0);
		bb.buildBlock(1,1,-4,Blocks.glass_pane,0);bb.buildBlock(1,1,4,Blocks.glass_pane,0);bb.buildBlock(2,1,-4,Blocks.planks,1);
		bb.buildBlock(2,1,4,Blocks.planks,1);bb.buildBlock(3,1,-4,Blocks.planks,1);bb.buildBlock(3,1,4,Blocks.planks,1);
		bb.buildBlock(4,1,-4,Blocks.planks,1);bb.buildBlock(4,1,-3,Blocks.glass_pane,0);bb.buildBlock(4,1,-2,Blocks.glass_pane,0);
		bb.buildBlock(4,1,-1,Blocks.planks,1);bb.buildBlock(4,1,0,Blocks.wooden_door,9);bb.buildBlock(4,1,1,Blocks.wooden_door,8);
		bb.buildBlock(4,1,2,Blocks.planks,1);bb.buildBlock(4,1,3,Blocks.planks,1);bb.buildBlock(4,1,4,Blocks.planks,1);
		bb.buildBlock(5,1,-5,Blocks.fence,0);bb.buildBlock(5,1,5,Blocks.fence,0);bb.buildBlock(-5,2,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,2,-4,Blocks.acacia_stairs,7);bb.buildBlock(-5,2,4,Blocks.acacia_stairs,6);bb.buildBlock(-5,2,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-4,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(-4,2,-4,Blocks.planks,1);bb.buildBlock(-4,2,-3,Blocks.planks,1);
		bb.buildBlock(-4,2,-2,Blocks.planks,1);bb.buildBlock(-4,2,-1,Blocks.planks,1);bb.buildBlock(-4,2,0,Blocks.planks,1);
		bb.buildBlock(-4,2,1,Blocks.planks,1);bb.buildBlock(-4,2,2,Blocks.planks,1);bb.buildBlock(-4,2,3,Blocks.planks,1);
		bb.buildBlock(-4,2,4,Blocks.planks,1);bb.buildBlock(-4,2,5,Blocks.acacia_stairs,3);bb.buildBlock(-3,2,-4,Blocks.planks,1);
		bb.buildBlock(-3,2,4,Blocks.planks,1);bb.buildBlock(-2,2,-4,Blocks.planks,1);bb.buildBlock(-2,2,4,Blocks.planks,1);
		bb.buildBlock(-1,2,-4,Blocks.planks,1);bb.buildBlock(-1,2,4,Blocks.planks,1);bb.buildBlock(0,2,-4,Blocks.planks,1);
		bb.buildBlock(0,2,4,Blocks.planks,1);bb.buildBlock(1,2,-4,Blocks.planks,1);bb.buildBlock(1,2,4,Blocks.planks,1);
		bb.buildBlock(2,2,-4,Blocks.planks,1);bb.buildBlock(2,2,4,Blocks.planks,1);bb.buildBlock(3,2,-4,Blocks.planks,1);
		bb.buildBlock(3,2,4,Blocks.planks,1);bb.buildBlock(4,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(4,2,-4,Blocks.planks,1);
		bb.buildBlock(4,2,-3,Blocks.planks,1);bb.buildBlock(4,2,-2,Blocks.planks,1);bb.buildBlock(4,2,-1,Blocks.planks,1);
		bb.buildBlock(4,2,0,Blocks.planks,1);bb.buildBlock(4,2,1,Blocks.planks,1);bb.buildBlock(4,2,2,Blocks.planks,1);
		bb.buildBlock(4,2,3,Blocks.planks,1);bb.buildBlock(4,2,4,Blocks.planks,1);bb.buildBlock(4,2,5,Blocks.acacia_stairs,3);
		bb.buildBlock(5,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(5,2,-4,Blocks.acacia_stairs,7);bb.buildBlock(5,2,4,Blocks.acacia_stairs,6);
		bb.buildBlock(5,2,5,Blocks.acacia_stairs,3);bb.buildBlock(-5,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(-5,3,-3,Blocks.acacia_stairs,7);
		bb.buildBlock(-5,3,3,Blocks.acacia_stairs,6);bb.buildBlock(-5,3,4,Blocks.acacia_stairs,3);bb.buildBlock(-4,3,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,3,-3,Blocks.planks,1);bb.buildBlock(-4,3,-2,Blocks.planks,1);bb.buildBlock(-4,3,-1,Blocks.planks,1);
		bb.buildBlock(-4,3,0,Blocks.planks,1);bb.buildBlock(-4,3,1,Blocks.planks,1);bb.buildBlock(-4,3,2,Blocks.planks,1);
		bb.buildBlock(-4,3,3,Blocks.planks,1);bb.buildBlock(-4,3,4,Blocks.acacia_stairs,3);bb.buildBlock(-3,3,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,3,-4,Blocks.planks,4);bb.buildBlock(-3,3,-3,Blocks.planks,1);bb.buildBlock(-3,3,-2,Blocks.planks,1);
		bb.buildBlock(-3,3,-1,Blocks.planks,1);bb.buildBlock(-3,3,0,Blocks.planks,1);bb.buildBlock(-3,3,1,Blocks.planks,1);
		bb.buildBlock(-3,3,2,Blocks.planks,1);bb.buildBlock(-3,3,3,Blocks.planks,1);bb.buildBlock(-3,3,4,Blocks.planks,4);
		bb.buildBlock(-3,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-2,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-2,3,-4,Blocks.planks,4);
		bb.buildBlock(-2,3,-3,Blocks.planks,1);bb.buildBlock(-2,3,3,Blocks.planks,1);bb.buildBlock(-2,3,4,Blocks.planks,4);
		bb.buildBlock(-2,3,5,Blocks.acacia_stairs,3);bb.buildBlock(-1,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(-1,3,-4,Blocks.planks,4);
		bb.buildBlock(-1,3,-3,Blocks.planks,1);bb.buildBlock(-1,3,3,Blocks.planks,1);bb.buildBlock(-1,3,4,Blocks.planks,4);
		bb.buildBlock(-1,3,5,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(0,3,-4,Blocks.planks,4);
		bb.buildBlock(0,3,-3,Blocks.planks,1);bb.buildBlock(0,3,3,Blocks.planks,1);bb.buildBlock(0,3,4,Blocks.planks,4);
		bb.buildBlock(0,3,5,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(1,3,-4,Blocks.planks,4);
		bb.buildBlock(1,3,-3,Blocks.planks,1);bb.buildBlock(1,3,3,Blocks.planks,1);bb.buildBlock(1,3,4,Blocks.planks,4);
		bb.buildBlock(1,3,5,Blocks.acacia_stairs,3);bb.buildBlock(2,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(2,3,-4,Blocks.planks,4);
		bb.buildBlock(2,3,-3,Blocks.planks,1);bb.buildBlock(2,3,3,Blocks.planks,1);bb.buildBlock(2,3,4,Blocks.planks,4);
		bb.buildBlock(2,3,5,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-5,Blocks.acacia_stairs,2);bb.buildBlock(3,3,-4,Blocks.planks,4);
		bb.buildBlock(3,3,-3,Blocks.planks,1);bb.buildBlock(3,3,-2,Blocks.planks,1);bb.buildBlock(3,3,-1,Blocks.planks,1);
		bb.buildBlock(3,3,0,Blocks.planks,1);bb.buildBlock(3,3,1,Blocks.planks,1);bb.buildBlock(3,3,2,Blocks.planks,1);
		bb.buildBlock(3,3,3,Blocks.planks,1);bb.buildBlock(3,3,4,Blocks.planks,4);bb.buildBlock(3,3,5,Blocks.acacia_stairs,3);
		bb.buildBlock(4,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(4,3,-3,Blocks.planks,1);bb.buildBlock(4,3,-2,Blocks.planks,1);
		bb.buildBlock(4,3,-1,Blocks.planks,1);bb.buildBlock(4,3,0,Blocks.planks,1);bb.buildBlock(4,3,1,Blocks.planks,1);
		bb.buildBlock(4,3,2,Blocks.planks,1);bb.buildBlock(4,3,3,Blocks.planks,1);bb.buildBlock(4,3,4,Blocks.acacia_stairs,3);
		bb.buildBlock(5,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(5,3,-3,Blocks.acacia_stairs,7);bb.buildBlock(5,3,3,Blocks.acacia_stairs,6);
		bb.buildBlock(5,3,4,Blocks.acacia_stairs,3);bb.buildBlock(-5,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(-5,4,-2,Blocks.planks,4);
		bb.buildBlock(-5,4,-1,Blocks.planks,4);bb.buildBlock(-5,4,0,Blocks.planks,4);bb.buildBlock(-5,4,1,Blocks.planks,4);
		bb.buildBlock(-5,4,2,Blocks.planks,4);bb.buildBlock(-5,4,3,Blocks.acacia_stairs,3);bb.buildBlock(-4,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,4,-2,Blocks.planks,4);bb.buildBlock(-4,4,-1,Blocks.planks,4);bb.buildBlock(-4,4,0,Blocks.planks,4);
		bb.buildBlock(-4,4,1,Blocks.planks,4);bb.buildBlock(-4,4,2,Blocks.planks,4);bb.buildBlock(-4,4,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(-3,4,-2,Blocks.planks,4);bb.buildBlock(-3,4,-1,Blocks.planks,4);
		bb.buildBlock(-3,4,0,Blocks.planks,4);bb.buildBlock(-3,4,1,Blocks.planks,4);bb.buildBlock(-3,4,2,Blocks.planks,4);
		bb.buildBlock(-3,4,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(-2,4,-2,Blocks.planks,4);
		bb.buildBlock(-2,4,-1,Blocks.planks,4);bb.buildBlock(-2,4,0,Blocks.planks,4);bb.buildBlock(-2,4,1,Blocks.planks,4);
		bb.buildBlock(-2,4,2,Blocks.planks,4);bb.buildBlock(-2,4,3,Blocks.acacia_stairs,3);bb.buildBlock(-1,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,4,-2,Blocks.planks,4);bb.buildBlock(-1,4,-1,Blocks.planks,4);bb.buildBlock(-1,4,0,Blocks.planks,4);
		bb.buildBlock(-1,4,1,Blocks.planks,4);bb.buildBlock(-1,4,2,Blocks.planks,4);bb.buildBlock(-1,4,3,Blocks.acacia_stairs,3);
		bb.buildBlock(0,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(0,4,-2,Blocks.planks,4);bb.buildBlock(0,4,-1,Blocks.planks,4);
		bb.buildBlock(0,4,0,Blocks.planks,4);bb.buildBlock(0,4,1,Blocks.planks,4);bb.buildBlock(0,4,2,Blocks.planks,4);
		bb.buildBlock(0,4,3,Blocks.acacia_stairs,3);bb.buildBlock(1,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(1,4,-2,Blocks.planks,4);
		bb.buildBlock(1,4,-1,Blocks.planks,4);bb.buildBlock(1,4,0,Blocks.planks,4);bb.buildBlock(1,4,1,Blocks.planks,4);
		bb.buildBlock(1,4,2,Blocks.planks,4);bb.buildBlock(1,4,3,Blocks.acacia_stairs,3);bb.buildBlock(2,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(2,4,-2,Blocks.planks,4);bb.buildBlock(2,4,-1,Blocks.planks,4);bb.buildBlock(2,4,0,Blocks.planks,4);
		bb.buildBlock(2,4,1,Blocks.planks,4);bb.buildBlock(2,4,2,Blocks.planks,4);bb.buildBlock(2,4,3,Blocks.acacia_stairs,3);
		bb.buildBlock(3,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(3,4,-2,Blocks.planks,4);bb.buildBlock(3,4,-1,Blocks.planks,4);
		bb.buildBlock(3,4,0,Blocks.planks,4);bb.buildBlock(3,4,1,Blocks.planks,4);bb.buildBlock(3,4,2,Blocks.planks,4);
		bb.buildBlock(3,4,3,Blocks.acacia_stairs,3);bb.buildBlock(4,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(4,4,-2,Blocks.planks,4);
		bb.buildBlock(4,4,-1,Blocks.planks,4);bb.buildBlock(4,4,0,Blocks.planks,4);bb.buildBlock(4,4,1,Blocks.planks,4);
		bb.buildBlock(4,4,2,Blocks.planks,4);bb.buildBlock(4,4,3,Blocks.acacia_stairs,3);bb.buildBlock(5,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(5,4,-2,Blocks.planks,4);bb.buildBlock(5,4,-1,Blocks.planks,4);bb.buildBlock(5,4,0,Blocks.planks,4);
		bb.buildBlock(5,4,1,Blocks.planks,4);bb.buildBlock(5,4,2,Blocks.planks,4);bb.buildBlock(5,4,3,Blocks.acacia_stairs,3);
		bb.buildBlock(3,-3,-3,Blocks.torch,2);bb.buildBlock(3,-3,1,Blocks.torch,2);bb.buildBlock(-4,-2,-1,Blocks.torch,1);
		bb.buildBlock(-2,-2,-3,Blocks.torch,3);bb.buildBlock(-2,-2,1,Blocks.torch,4);bb.buildBlock(-3,2,-3,Blocks.torch,3);
		bb.buildBlock(-3,2,3,Blocks.torch,4);bb.buildBlock(3,2,-3,Blocks.torch,3);bb.buildBlock(3,2,3,Blocks.torch,4);
		bb.buildBlock(-2,3,-2,Blocks.torch,3);bb.buildBlock(-2,3,2,Blocks.torch,4);bb.buildBlock(2,3,-2,Blocks.torch,3);
		bb.buildBlock(2,3,2,Blocks.torch,4);bb.addEntityPainting(4,-3,-1,1,"Alban");
		bb.addEntityItemFrame(-4,1,0,3,ModItems.itemGrapeVine);
		bb.addEntityItemFrame(-4,2,0,3,ModItems.itemBeer);
		bb.addEntityItemFrame(-2,1,4,2,ModItems.itemCockTail);
		bb.addEntityItemFrame(4,1,2,3,ModBlocks.blockSmallTavern);
	}

}
