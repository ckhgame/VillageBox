package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
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
		bb.addVillager(ProfessionTavernOwner.class,-1,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-2,-5,-2,Blocks.planks,0);bb.buildBlock(-1,-5,-2,Blocks.planks,0);bb.buildBlock(-1,-5,-1,Blocks.planks,0);
		bb.buildBlock(-1,-5,0,Blocks.planks,0);bb.buildBlock(-1,-5,1,Blocks.planks,0);bb.buildBlock(0,-5,-2,Blocks.planks,0);
		bb.buildBlock(0,-5,-1,Blocks.planks,0);bb.buildBlock(0,-5,0,Blocks.planks,0);bb.buildBlock(0,-5,1,Blocks.planks,0);
		bb.buildBlock(1,-5,-2,Blocks.planks,0);bb.buildBlock(1,-5,-1,Blocks.planks,0);bb.buildBlock(1,-5,0,Blocks.planks,0);
		bb.buildBlock(1,-5,1,Blocks.planks,0);bb.buildBlock(-2,-4,-2,Blocks.air,0);bb.buildBlock(-2,-4,-1,Blocks.oak_stairs,2);
		bb.buildBlock(-2,-4,0,Blocks.planks,0);bb.buildBlock(-2,-4,1,Blocks.planks,0);bb.buildBlock(-2,-4,2,Blocks.planks,0);
		bb.buildBlock(-1,-4,-2,Blocks.wooden_door,2);bb.buildBlock(-1,-4,-1,Blocks.planks,2);bb.buildBlock(-1,-4,0,Blocks.bookshelf,0);
		bb.buildBlock(-1,-4,1,Blocks.chest,5);bb.buildBlock(-1,-4,2,Blocks.planks,2);bb.buildBlock(0,-4,-2,Blocks.carpet,3);bb.buildBlock(0,-4,-1,Blocks.carpet,3);
		bb.buildBlock(0,-4,0,Blocks.carpet,3);bb.buildBlock(0,-4,1,Blocks.bed,3);bb.buildBlock(0,-4,2,Blocks.planks,3);
		bb.buildBlock(1,-4,-2,Blocks.bookshelf,0);bb.buildBlock(1,-4,-1,Blocks.carpet,3);bb.buildBlock(1,-4,0,Blocks.carpet,3);
		bb.buildBlock(1,-4,1,Blocks.bed,11);bb.buildBlock(1,-4,2,Blocks.planks,2);bb.buildBlock(2,-4,-2,Blocks.planks,2);
		bb.buildBlock(2,-4,-1,Blocks.planks,3);bb.buildBlock(2,-4,0,Blocks.planks,2);bb.buildBlock(2,-4,1,Blocks.planks,3);
		bb.buildBlock(2,-4,2,Blocks.planks,3);bb.buildBlock(-2,-3,-2,Blocks.air,0);bb.buildBlock(-2,-3,-1,Blocks.air,0);
		bb.buildBlock(-2,-3,0,Blocks.oak_stairs,2);bb.buildBlock(-2,-3,1,Blocks.planks,0);bb.buildBlock(-2,-3,2,Blocks.planks,0);
		bb.buildBlock(-1,-3,-2,Blocks.wooden_door,8);bb.buildBlock(-1,-3,-1,Blocks.planks,2);bb.buildBlock(-1,-3,0,Blocks.planks,3);
		bb.buildBlock(-1,-3,2,Blocks.planks,2);bb.buildBlock(0,-3,-2,Blocks.air,0);bb.buildBlock(0,-3,-1,Blocks.air,0);
		bb.buildBlock(0,-3,0,Blocks.air,0);bb.buildBlock(0,-3,1,Blocks.air,0);bb.buildBlock(0,-3,2,Blocks.planks,3);
		bb.buildBlock(1,-3,-2,Blocks.flower_pot,5);bb.addTileEntityPot(1,-3,-2,38,5);
		bb.buildBlock(1,-3,-1,Blocks.air,0);bb.buildBlock(1,-3,0,Blocks.air,0);bb.buildBlock(1,-3,1,Blocks.air,0);
		bb.buildBlock(1,-3,2,Blocks.planks,2);bb.buildBlock(2,-3,-2,Blocks.planks,2);bb.buildBlock(2,-3,-1,Blocks.planks,3);
		bb.buildBlock(2,-3,0,Blocks.planks,2);bb.buildBlock(2,-3,1,Blocks.planks,3);bb.buildBlock(2,-3,2,Blocks.planks,3);
		bb.buildBlock(-2,-2,-1,Blocks.air,0);bb.buildBlock(-2,-2,0,Blocks.air,0);bb.buildBlock(-2,-2,1,Blocks.oak_stairs,2);
		bb.buildBlock(-2,-2,2,Blocks.planks,0);bb.buildBlock(-1,-2,-2,Blocks.planks,3);bb.buildBlock(-1,-2,-1,Blocks.planks,2);
		bb.buildBlock(-1,-2,0,Blocks.planks,3);bb.buildBlock(-1,-2,1,Blocks.planks,2);bb.buildBlock(-1,-2,2,Blocks.planks,2);
		bb.buildBlock(0,-2,-2,Blocks.air,0);bb.buildBlock(0,-2,-1,Blocks.air,0);bb.buildBlock(0,-2,0,Blocks.air,0);
		bb.buildBlock(0,-2,1,Blocks.air,0);bb.buildBlock(0,-2,2,Blocks.planks,3);bb.buildBlock(1,-2,-1,Blocks.air,0);
		bb.buildBlock(1,-2,0,Blocks.air,0);bb.buildBlock(1,-2,1,Blocks.air,0);bb.buildBlock(1,-2,2,Blocks.planks,2);
		bb.buildBlock(2,-2,-2,Blocks.planks,2);bb.buildBlock(2,-2,-1,Blocks.planks,3);bb.buildBlock(2,-2,0,Blocks.planks,2);
		bb.buildBlock(2,-2,1,Blocks.planks,3);bb.buildBlock(2,-2,2,Blocks.planks,3);bb.buildBlock(-2,-1,-2,Blocks.planks,0);
		bb.buildBlock(-2,-1,-1,Blocks.air,0);bb.buildBlock(-2,-1,0,Blocks.air,0);bb.buildBlock(-2,-1,1,Blocks.air,0);
		bb.buildBlock(-2,-1,2,Blocks.oak_stairs,2);bb.buildBlock(-1,-1,-2,Blocks.planks,0);bb.buildBlock(-1,-1,-1,Blocks.planks,0);
		bb.buildBlock(-1,-1,0,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);bb.buildBlock(-1,-1,2,Blocks.planks,0);
		bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);bb.buildBlock(0,-1,0,Blocks.planks,0);
		bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.planks,0);bb.buildBlock(1,-1,-2,Blocks.planks,0);
		bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);bb.buildBlock(1,-1,1,Blocks.planks,0);
		bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(2,-1,-2,Blocks.planks,0);bb.buildBlock(2,-1,-1,Blocks.planks,0);
		bb.buildBlock(2,-1,0,Blocks.planks,0);bb.buildBlock(2,-1,1,Blocks.planks,0);bb.buildBlock(2,-1,2,Blocks.planks,0);
		bb.buildBlock(-3,0,-3,Blocks.planks,1);bb.buildBlock(-3,0,-2,Blocks.planks,1);bb.buildBlock(-3,0,-1,Blocks.planks,1);
		bb.buildBlock(-3,0,0,Blocks.planks,1);bb.buildBlock(-3,0,1,Blocks.planks,1);bb.buildBlock(-3,0,2,Blocks.planks,1);
		bb.buildBlock(-3,0,3,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.planks,1);bb.buildBlock(-2,0,-2,Blocks.planks,1);
		bb.buildBlock(-2,0,-1,Blocks.spruce_stairs,7);bb.buildBlock(-2,0,3,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);
		bb.buildBlock(-1,0,3,Blocks.planks,1);bb.buildBlock(0,0,-3,Blocks.planks,1);bb.buildBlock(0,0,-1,Blocks.planks,1);
		bb.buildBlock(0,0,0,Blocks.planks,1);bb.buildBlock(0,0,1,Blocks.planks,1);bb.buildBlock(0,0,2,Blocks.planks,1);
		bb.buildBlock(0,0,3,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.planks,1);bb.buildBlock(1,0,-1,ModBlocks.blockWoodenChair,0);
		bb.buildBlock(1,0,0,ModBlocks.blockWoodenChair,0);bb.buildBlock(1,0,1,ModBlocks.blockWoodenChair,0);bb.buildBlock(1,0,2,Blocks.planks,1);bb.buildBlock(1,0,3,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.planks,1);
		bb.buildBlock(2,0,2,Blocks.planks,1);bb.buildBlock(2,0,3,Blocks.planks,1);bb.buildBlock(3,0,-3,Blocks.planks,1);
		bb.buildBlock(3,0,-2,Blocks.planks,1);bb.buildBlock(3,0,-1,Blocks.planks,1);bb.buildBlock(3,0,0,Blocks.wooden_door,0);
		bb.buildBlock(3,0,1,Blocks.planks,1);bb.buildBlock(3,0,2,Blocks.fence,0);bb.buildBlock(3,0,3,Blocks.planks,1);
		bb.buildBlock(-3,1,-3,Blocks.planks,1);bb.buildBlock(-3,1,-2,Blocks.planks,1);bb.buildBlock(-3,1,-1,Blocks.glass_pane,0);
		bb.buildBlock(-3,1,0,Blocks.planks,1);bb.buildBlock(-3,1,1,Blocks.glass_pane,0);bb.buildBlock(-3,1,2,Blocks.planks,1);
		bb.buildBlock(-3,1,3,Blocks.planks,1);bb.buildBlock(-2,1,-3,Blocks.planks,1);bb.buildBlock(-2,1,-2,Blocks.flower_pot,0);
		bb.addTileEntityPot(-2,1,-2,38,0);
		bb.buildBlock(-2,1,3,Blocks.planks,1);bb.buildBlock(-1,1,-3,Blocks.glass_pane,0);bb.buildBlock(-1,1,3,Blocks.glass_pane,0);
		bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(1,1,2,Blocks.flower_pot,3);bb.addTileEntityPot(1,1,2,38,3);
		bb.buildBlock(1,1,3,Blocks.glass_pane,0);bb.buildBlock(2,1,-3,Blocks.planks,1);bb.buildBlock(2,1,2,Blocks.planks,1);
		bb.buildBlock(2,1,3,Blocks.planks,1);bb.buildBlock(3,1,-3,Blocks.planks,1);bb.buildBlock(3,1,-2,Blocks.glass_pane,0);
		bb.buildBlock(3,1,-1,Blocks.planks,1);bb.buildBlock(3,1,0,Blocks.wooden_door,8);bb.buildBlock(3,1,1,Blocks.planks,1);
		bb.buildBlock(3,1,3,Blocks.planks,1);bb.buildBlock(-3,2,-3,Blocks.planks,1);bb.buildBlock(-3,2,-2,Blocks.planks,1);
		bb.buildBlock(-3,2,-1,Blocks.glass_pane,0);bb.buildBlock(-3,2,0,Blocks.planks,1);bb.buildBlock(-3,2,1,Blocks.glass_pane,0);
		bb.buildBlock(-3,2,2,Blocks.planks,1);bb.buildBlock(-3,2,3,Blocks.planks,1);bb.buildBlock(-2,2,-3,Blocks.planks,1);
		bb.buildBlock(-2,2,3,Blocks.planks,1);bb.buildBlock(-1,2,-3,Blocks.glass_pane,0);bb.buildBlock(-1,2,3,Blocks.glass_pane,0);
		bb.buildBlock(0,2,-3,Blocks.glass_pane,0);bb.buildBlock(0,2,3,Blocks.glass_pane,0);bb.buildBlock(1,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(1,2,3,Blocks.glass_pane,0);bb.buildBlock(2,2,-3,Blocks.planks,1);bb.buildBlock(2,2,2,Blocks.planks,1);
		bb.buildBlock(2,2,3,Blocks.planks,1);bb.buildBlock(3,2,-3,Blocks.planks,1);bb.buildBlock(3,2,-2,Blocks.glass_pane,0);
		bb.buildBlock(3,2,-1,Blocks.planks,1);bb.buildBlock(3,2,0,Blocks.planks,1);bb.buildBlock(3,2,1,Blocks.planks,1);
		bb.buildBlock(3,2,3,Blocks.planks,1);bb.buildBlock(-3,3,-3,Blocks.planks,1);bb.buildBlock(-3,3,-2,Blocks.planks,1);
		bb.buildBlock(-3,3,-1,Blocks.planks,1);bb.buildBlock(-3,3,0,Blocks.planks,1);bb.buildBlock(-3,3,1,Blocks.planks,1);
		bb.buildBlock(-3,3,2,Blocks.planks,1);bb.buildBlock(-3,3,3,Blocks.planks,1);bb.buildBlock(-2,3,-3,Blocks.planks,1);
		bb.buildBlock(-2,3,3,Blocks.planks,1);bb.buildBlock(-1,3,-3,Blocks.planks,1);bb.buildBlock(-1,3,3,Blocks.planks,1);
		bb.buildBlock(0,3,-3,Blocks.planks,1);bb.buildBlock(0,3,3,Blocks.planks,1);bb.buildBlock(1,3,-3,Blocks.planks,1);
		bb.buildBlock(1,3,3,Blocks.planks,1);bb.buildBlock(2,3,-3,Blocks.planks,1);bb.buildBlock(2,3,2,Blocks.planks,1);
		bb.buildBlock(2,3,3,Blocks.planks,1);bb.buildBlock(3,3,-3,Blocks.planks,1);bb.buildBlock(3,3,-2,Blocks.planks,1);
		bb.buildBlock(3,3,-1,Blocks.planks,1);bb.buildBlock(3,3,0,Blocks.planks,1);bb.buildBlock(3,3,1,Blocks.planks,1);
		bb.buildBlock(3,3,3,Blocks.planks,1);bb.buildBlock(-3,4,-3,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,4,-2,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-3,4,-1,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,4,0,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,4,1,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-3,4,2,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,4,3,Blocks.dark_oak_stairs,3);bb.buildBlock(-2,4,-3,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-2,4,3,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,4,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(-1,4,3,Blocks.dark_oak_stairs,3);
		bb.buildBlock(0,4,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(0,4,3,Blocks.dark_oak_stairs,3);bb.buildBlock(1,4,-3,Blocks.dark_oak_stairs,2);
		bb.buildBlock(1,4,3,Blocks.dark_oak_stairs,3);bb.buildBlock(2,4,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(2,4,3,Blocks.dark_oak_stairs,3);
		bb.buildBlock(3,4,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(3,4,-2,Blocks.dark_oak_stairs,1);bb.buildBlock(3,4,-1,Blocks.dark_oak_stairs,1);
		bb.buildBlock(3,4,0,Blocks.dark_oak_stairs,1);bb.buildBlock(3,4,1,Blocks.dark_oak_stairs,1);bb.buildBlock(3,4,2,Blocks.dark_oak_stairs,1);
		bb.buildBlock(3,4,3,Blocks.dark_oak_stairs,1);bb.buildBlock(-2,5,-2,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,5,-1,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-2,5,0,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,5,1,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,5,2,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-1,5,-2,Blocks.dark_oak_stairs,2);bb.buildBlock(-1,5,-1,Blocks.wooden_slab,9);bb.buildBlock(-1,5,0,Blocks.wooden_slab,9);
		bb.buildBlock(-1,5,1,Blocks.wooden_slab,9);bb.buildBlock(-1,5,2,Blocks.dark_oak_stairs,3);bb.buildBlock(0,5,-2,Blocks.dark_oak_stairs,2);
		bb.buildBlock(0,5,-1,Blocks.wooden_slab,9);bb.buildBlock(0,5,0,Blocks.wooden_slab,9);bb.buildBlock(0,5,1,Blocks.wooden_slab,9);
		bb.buildBlock(0,5,2,Blocks.dark_oak_stairs,3);bb.buildBlock(1,5,-2,Blocks.dark_oak_stairs,2);bb.buildBlock(1,5,-1,Blocks.wooden_slab,9);
		bb.buildBlock(1,5,0,Blocks.wooden_slab,9);bb.buildBlock(1,5,1,Blocks.wooden_slab,9);bb.buildBlock(1,5,2,Blocks.dark_oak_stairs,3);
		bb.buildBlock(2,5,-2,Blocks.dark_oak_stairs,1);bb.buildBlock(2,5,-1,Blocks.dark_oak_stairs,1);bb.buildBlock(2,5,0,Blocks.dark_oak_stairs,1);
		bb.buildBlock(2,5,1,Blocks.dark_oak_stairs,1);bb.buildBlock(2,5,2,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,-3,1,Blocks.torch,1);
		bb.buildBlock(-2,-2,-2,Blocks.torch,3);bb.buildBlock(1,-2,-2,Blocks.torch,3);bb.buildBlock(-2,3,-2,Blocks.torch,1);
		bb.buildBlock(-2,3,0,Blocks.torch,1);bb.buildBlock(-2,3,2,Blocks.torch,1);bb.buildBlock(0,3,-2,Blocks.torch,3);
		bb.buildBlock(0,3,2,Blocks.torch,4);bb.buildBlock(2,3,-2,Blocks.torch,2);bb.buildBlock(2,3,0,Blocks.torch,2);
		bb.buildBlock(3,3,2,Blocks.torch,1);bb.addEntityPainting(2,-3,-1,1,"Pool");
		bb.addEntityPainting(-3,2,-2,3,"Wasteland");
		bb.addEntityPainting(-3,2,0,3,"Plant"); 
		bb.addEntityPainting(-3,2,2,3,"Aztec2");
		bb.addEntityItemFrame(2,2,2,3,ModBlocks.blockSmallTavern);
	}

}
