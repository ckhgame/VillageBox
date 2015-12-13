package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionCasinoManager;

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
		bb.addVillager(ProfessionCasinoManager.class,-1,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-2,-6,-2,Blocks.planks,3);bb.buildBlock(-2,-6,-1,Blocks.planks,3);bb.buildBlock(-2,-6,0,Blocks.planks,3);
		bb.buildBlock(-2,-6,1,Blocks.planks,3);bb.buildBlock(-2,-6,2,Blocks.planks,3);bb.buildBlock(-1,-6,-2,Blocks.planks,3);
		bb.buildBlock(-1,-6,-1,Blocks.planks,3);bb.buildBlock(-1,-6,0,Blocks.planks,3);bb.buildBlock(-1,-6,1,Blocks.planks,3);
		bb.buildBlock(-1,-6,2,Blocks.planks,3);bb.buildBlock(0,-6,-2,Blocks.planks,3);bb.buildBlock(0,-6,-1,Blocks.planks,3);
		bb.buildBlock(0,-6,0,Blocks.planks,3);bb.buildBlock(0,-6,1,Blocks.planks,3);bb.buildBlock(0,-6,2,Blocks.planks,3);
		bb.buildBlock(1,-6,-2,Blocks.planks,3);bb.buildBlock(1,-6,-1,Blocks.planks,3);bb.buildBlock(1,-6,0,Blocks.planks,3);
		bb.buildBlock(1,-6,1,Blocks.planks,3);bb.buildBlock(1,-6,2,Blocks.planks,3);bb.buildBlock(2,-6,-2,Blocks.planks,3);
		bb.buildBlock(2,-6,-1,Blocks.planks,3);bb.buildBlock(2,-6,0,Blocks.planks,3);bb.buildBlock(2,-6,1,Blocks.planks,3);
		bb.buildBlock(2,-6,2,Blocks.planks,3);bb.buildBlock(-2,-5,-2,Blocks.jungle_stairs,1);bb.buildBlock(-2,-5,-1,Blocks.planks,3);
		bb.buildBlock(-2,-5,0,Blocks.planks,3);bb.buildBlock(-2,-5,1,Blocks.planks,3);bb.buildBlock(-2,-5,2,Blocks.planks,3);
		bb.buildBlock(-1,-5,-2,Blocks.air,0);bb.buildBlock(-1,-5,-1,Blocks.planks,3);bb.buildBlock(-1,-5,0,Blocks.bookshelf,0);
		bb.buildBlock(-1,-5,1,Blocks.chest,5);bb.buildBlock(-1,-5,2,Blocks.planks,3);bb.buildBlock(0,-5,-2,Blocks.air,0);bb.buildBlock(0,-5,-1,Blocks.wooden_door,3);
		bb.buildBlock(0,-5,0,Blocks.air,0);bb.buildBlock(0,-5,1,Blocks.air,0);bb.buildBlock(0,-5,2,Blocks.planks,3);
		bb.buildBlock(1,-5,-2,Blocks.planks,3);bb.buildBlock(1,-5,-1,Blocks.planks,3);bb.buildBlock(1,-5,0,Blocks.bed,0);
		bb.buildBlock(1,-5,1,Blocks.bed,8);bb.buildBlock(1,-5,2,Blocks.planks,3);bb.buildBlock(2,-5,-2,Blocks.planks,3);
		bb.buildBlock(2,-5,-1,Blocks.planks,3);bb.buildBlock(2,-5,0,Blocks.planks,3);bb.buildBlock(2,-5,1,Blocks.planks,3);
		bb.buildBlock(2,-5,2,Blocks.planks,3);bb.buildBlock(-2,-4,-2,Blocks.air,0);bb.buildBlock(-2,-4,-1,Blocks.jungle_stairs,2);
		bb.buildBlock(-2,-4,0,Blocks.planks,3);bb.buildBlock(-2,-4,1,Blocks.planks,3);bb.buildBlock(-2,-4,2,Blocks.planks,3);
		bb.buildBlock(-1,-4,-2,Blocks.air,0);bb.buildBlock(-1,-4,-1,Blocks.planks,3);bb.buildBlock(-1,-4,0,Blocks.air,0);
		bb.buildBlock(-1,-4,1,Blocks.air,0);bb.buildBlock(-1,-4,2,Blocks.planks,3);bb.buildBlock(0,-4,-2,Blocks.air,0);
		bb.buildBlock(0,-4,-1,Blocks.wooden_door,8);bb.buildBlock(0,-4,0,Blocks.air,0);bb.buildBlock(0,-4,1,Blocks.air,0);
		bb.buildBlock(0,-4,2,Blocks.planks,3);bb.buildBlock(1,-4,-2,Blocks.flower_pot,5);bb.addTileEntityPot(1,-4,-2,38,5);
		bb.buildBlock(1,-4,-1,Blocks.planks,3);bb.buildBlock(1,-4,0,Blocks.air,0);bb.buildBlock(1,-4,1,Blocks.air,0);
		bb.buildBlock(1,-4,2,Blocks.planks,3);bb.buildBlock(2,-4,-2,Blocks.planks,3);bb.buildBlock(2,-4,-1,Blocks.planks,3);
		bb.buildBlock(2,-4,0,Blocks.planks,3);bb.buildBlock(2,-4,1,Blocks.planks,3);bb.buildBlock(2,-4,2,Blocks.planks,3);
		bb.buildBlock(-2,-3,-2,Blocks.air,0);bb.buildBlock(-2,-3,-1,Blocks.air,0);bb.buildBlock(-2,-3,0,Blocks.jungle_stairs,2);
		bb.buildBlock(-2,-3,1,Blocks.planks,3);bb.buildBlock(-2,-3,2,Blocks.planks,3);bb.buildBlock(-1,-3,-2,Blocks.air,0);
		bb.buildBlock(-1,-3,-1,Blocks.planks,3);bb.buildBlock(-1,-3,0,Blocks.wooden_slab,11);bb.buildBlock(-1,-3,2,Blocks.planks,3);
		bb.buildBlock(0,-3,-2,Blocks.air,0);bb.buildBlock(0,-3,-1,Blocks.planks,3);bb.buildBlock(0,-3,0,Blocks.air,0);
		bb.buildBlock(0,-3,1,Blocks.air,0);bb.buildBlock(0,-3,2,Blocks.planks,3);bb.buildBlock(1,-3,-2,Blocks.air,0);
		bb.buildBlock(1,-3,-1,Blocks.planks,3);bb.buildBlock(1,-3,0,Blocks.air,0);bb.buildBlock(1,-3,1,Blocks.air,0);
		bb.buildBlock(1,-3,2,Blocks.planks,3);bb.buildBlock(2,-3,-2,Blocks.planks,3);bb.buildBlock(2,-3,-1,Blocks.planks,3);
		bb.buildBlock(2,-3,0,Blocks.planks,3);bb.buildBlock(2,-3,1,Blocks.planks,3);bb.buildBlock(2,-3,2,Blocks.planks,3);
		bb.buildBlock(-2,-2,-2,Blocks.air,0);bb.buildBlock(-2,-2,-1,Blocks.air,0);bb.buildBlock(-2,-2,0,Blocks.air,0);
		bb.buildBlock(-2,-2,1,Blocks.jungle_stairs,2);bb.buildBlock(-1,-2,-2,Blocks.air,0);bb.buildBlock(-1,-2,-1,Blocks.planks,3);
		bb.buildBlock(-1,-2,0,Blocks.planks,3);bb.buildBlock(-1,-2,1,Blocks.wooden_slab,11);bb.buildBlock(-1,-2,2,Blocks.planks,3);
		bb.buildBlock(0,-2,-2,Blocks.air,0);bb.buildBlock(0,-2,-1,Blocks.planks,3);bb.buildBlock(0,-2,0,Blocks.air,0);
		bb.buildBlock(0,-2,1,Blocks.air,0);bb.buildBlock(0,-2,2,Blocks.planks,3);bb.buildBlock(1,-2,-1,Blocks.planks,3);
		bb.buildBlock(1,-2,0,Blocks.air,0);bb.buildBlock(1,-2,2,Blocks.planks,3);bb.buildBlock(2,-2,-2,Blocks.planks,3);
		bb.buildBlock(2,-2,-1,Blocks.planks,3);bb.buildBlock(2,-2,0,Blocks.planks,3);bb.buildBlock(2,-2,1,Blocks.planks,3);
		bb.buildBlock(2,-2,2,Blocks.planks,3);bb.buildBlock(-2,-1,-2,Blocks.planks,3);bb.buildBlock(-2,-1,-1,Blocks.air,0);
		bb.buildBlock(-2,-1,0,Blocks.air,0);bb.buildBlock(-2,-1,1,Blocks.air,0);bb.buildBlock(-2,-1,2,Blocks.jungle_stairs,2);
		bb.buildBlock(-1,-1,-2,Blocks.planks,3);bb.buildBlock(-1,-1,-1,Blocks.planks,3);bb.buildBlock(-1,-1,0,Blocks.planks,3);
		bb.buildBlock(-1,-1,1,Blocks.planks,3);bb.buildBlock(-1,-1,2,Blocks.planks,3);bb.buildBlock(0,-1,-2,Blocks.planks,3);
		bb.buildBlock(0,-1,-1,Blocks.planks,3);bb.buildBlock(0,-1,0,Blocks.planks,3);bb.buildBlock(0,-1,1,Blocks.planks,3);
		bb.buildBlock(0,-1,2,Blocks.planks,3);bb.buildBlock(1,-1,-2,Blocks.planks,3);bb.buildBlock(1,-1,-1,Blocks.planks,3);
		bb.buildBlock(1,-1,0,Blocks.planks,3);bb.buildBlock(1,-1,1,Blocks.planks,3);bb.buildBlock(1,-1,2,Blocks.planks,3);
		bb.buildBlock(2,-1,-2,Blocks.planks,3);bb.buildBlock(2,-1,-1,Blocks.planks,3);bb.buildBlock(2,-1,0,Blocks.planks,3);
		bb.buildBlock(2,-1,1,Blocks.planks,3);bb.buildBlock(2,-1,2,Blocks.planks,3);bb.buildBlock(3,-1,0,Blocks.planks,3);
		bb.buildBlock(-3,0,-3,Blocks.sandstone,2);bb.buildBlock(-3,0,-2,Blocks.sandstone,2);bb.buildBlock(-3,0,-1,Blocks.sandstone,2);
		bb.buildBlock(-3,0,0,Blocks.sandstone,2);bb.buildBlock(-3,0,1,Blocks.sandstone,2);bb.buildBlock(-3,0,2,Blocks.sandstone,2);
		bb.buildBlock(-3,0,3,Blocks.sandstone,2);bb.buildBlock(-2,0,-3,Blocks.sandstone,2);bb.buildBlock(-2,0,-2,Blocks.glass,0);
		bb.buildBlock(-2,0,3,Blocks.sandstone,2);bb.buildBlock(-1,0,-3,Blocks.sandstone,2);bb.buildBlock(-1,0,-2,Blocks.carpet,15);
		bb.buildBlock(-1,0,-1,Blocks.carpet,14);bb.buildBlock(-1,0,0,Blocks.carpet,15);bb.buildBlock(-1,0,1,Blocks.carpet,14);
		bb.buildBlock(-1,0,2,Blocks.carpet,15);bb.buildBlock(-1,0,3,Blocks.sandstone,2);bb.buildBlock(0,0,-3,Blocks.sandstone,2);
		bb.buildBlock(0,0,-2,Blocks.carpet,14);bb.buildBlock(0,0,-1,Blocks.planks,3);bb.buildBlock(0,0,0,Blocks.planks,3);
		bb.buildBlock(0,0,1,Blocks.planks,3);bb.buildBlock(0,0,2,Blocks.planks,3);bb.buildBlock(0,0,3,Blocks.sandstone,2);
		bb.buildBlock(1,0,-3,Blocks.sandstone,2);bb.buildBlock(1,0,-2,Blocks.carpet,15);bb.buildBlock(1,0,-1,Blocks.carpet,14);
		bb.buildBlock(1,0,0,Blocks.carpet,15);bb.buildBlock(1,0,1,Blocks.carpet,14);bb.buildBlock(1,0,2,Blocks.planks,3);
		bb.buildBlock(1,0,3,Blocks.sandstone,2);bb.buildBlock(2,0,-3,Blocks.sandstone,2);bb.buildBlock(2,0,-2,Blocks.carpet,14);
		bb.buildBlock(2,0,-1,Blocks.carpet,15);bb.buildBlock(2,0,0,Blocks.carpet,14);bb.buildBlock(2,0,1,Blocks.carpet,15);
		bb.buildBlock(2,0,2,Blocks.planks,3);bb.buildBlock(2,0,3,Blocks.sandstone,2);bb.buildBlock(3,0,-3,Blocks.sandstone,2);
		bb.buildBlock(3,0,-2,Blocks.sandstone,2);bb.buildBlock(3,0,-1,Blocks.sandstone,2);bb.buildBlock(3,0,0,Blocks.wooden_door,0);
		bb.buildBlock(3,0,1,Blocks.sandstone,2);bb.buildBlock(3,0,2,Blocks.sandstone,2);bb.buildBlock(3,0,3,Blocks.sandstone,2);
		bb.buildBlock(-3,1,-3,Blocks.sandstone,2);bb.buildBlock(-3,1,-2,Blocks.glass_pane,0);bb.buildBlock(-3,1,-1,Blocks.sandstone,2);
		bb.buildBlock(-3,1,0,Blocks.glass_pane,0);bb.buildBlock(-3,1,1,Blocks.sandstone,2);bb.buildBlock(-3,1,2,Blocks.glass_pane,0);
		bb.buildBlock(-3,1,3,Blocks.sandstone,2);bb.buildBlock(-2,1,-3,Blocks.glass_pane,0);bb.buildBlock(-2,1,-2,Blocks.chest,5);
		bb.buildBlock(-2,1,3,Blocks.glass_pane,0);bb.buildBlock(-1,1,-3,Blocks.sandstone,2);bb.buildBlock(-1,1,3,Blocks.sandstone,2);
		bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,2,Blocks.flower_pot,6);bb.addTileEntityPot(0,1,2,38,6);
		bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.sandstone,2);bb.buildBlock(1,1,3,Blocks.sandstone,2);
		bb.buildBlock(2,1,-3,Blocks.glass_pane,0);bb.buildBlock(2,1,3,Blocks.glass_pane,0);bb.buildBlock(3,1,-3,Blocks.sandstone,2);
		bb.buildBlock(3,1,-2,Blocks.glass_pane,0);bb.buildBlock(3,1,-1,Blocks.sandstone,2);bb.buildBlock(3,1,0,Blocks.wooden_door,8);
		bb.buildBlock(3,1,1,Blocks.sandstone,2);bb.buildBlock(3,1,2,Blocks.glass_pane,0);bb.buildBlock(3,1,3,Blocks.sandstone,2);
		bb.buildBlock(-3,2,-3,Blocks.sandstone,2);bb.buildBlock(-3,2,-2,Blocks.glass_pane,0);bb.buildBlock(-3,2,-1,Blocks.sandstone,2);
		bb.buildBlock(-3,2,0,Blocks.glass_pane,0);bb.buildBlock(-3,2,1,Blocks.sandstone,2);bb.buildBlock(-3,2,2,Blocks.glass_pane,0);
		bb.buildBlock(-3,2,3,Blocks.sandstone,2);bb.buildBlock(-2,2,-3,Blocks.glass_pane,0);bb.buildBlock(-2,2,3,Blocks.glass_pane,0);
		bb.buildBlock(-1,2,-3,Blocks.sandstone,2);bb.buildBlock(-1,2,3,Blocks.sandstone,2);bb.buildBlock(0,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,2,3,Blocks.glass_pane,0);bb.buildBlock(1,2,-3,Blocks.sandstone,2);bb.buildBlock(1,2,3,Blocks.sandstone,2);
		bb.buildBlock(2,2,-3,Blocks.glass_pane,0);bb.buildBlock(2,2,3,Blocks.glass_pane,0);bb.buildBlock(3,2,-3,Blocks.sandstone,2);
		bb.buildBlock(3,2,-2,Blocks.glass_pane,0);bb.buildBlock(3,2,-1,Blocks.sandstone,2);bb.buildBlock(3,2,0,Blocks.sandstone,2);
		bb.buildBlock(3,2,1,Blocks.sandstone,2);bb.buildBlock(3,2,2,Blocks.glass_pane,0);bb.buildBlock(3,2,3,Blocks.sandstone,2);
		bb.buildBlock(-3,3,-3,Blocks.sandstone,2);bb.buildBlock(-3,3,-2,Blocks.sandstone,2);bb.buildBlock(-3,3,-1,Blocks.sandstone,2);
		bb.buildBlock(-3,3,0,Blocks.sandstone,2);bb.buildBlock(-3,3,1,Blocks.sandstone,2);bb.buildBlock(-3,3,2,Blocks.sandstone,2);
		bb.buildBlock(-3,3,3,Blocks.sandstone,2);bb.buildBlock(-2,3,-3,Blocks.sandstone,2);bb.buildBlock(-2,3,3,Blocks.sandstone,2);
		bb.buildBlock(-1,3,-3,Blocks.sandstone,2);bb.buildBlock(-1,3,3,Blocks.sandstone,2);bb.buildBlock(0,3,-3,Blocks.sandstone,2);
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
		bb.buildBlock(-1,-3,1,Blocks.torch,1);bb.buildBlock(1,-2,-2,Blocks.torch,2);bb.buildBlock(1,-2,1,Blocks.torch,4);
		bb.buildBlock(-2,2,-1,Blocks.torch,1);bb.buildBlock(-2,2,1,Blocks.torch,1);bb.buildBlock(2,2,-1,Blocks.torch,2);
		bb.buildBlock(2,2,1,Blocks.torch,2);bb.buildBlock(-2,3,-2,Blocks.torch,3);bb.buildBlock(0,3,-2,Blocks.torch,3);
		bb.buildBlock(0,3,2,Blocks.torch,4);bb.buildBlock(2,3,-2,Blocks.torch,3);bb.addEntityPainting(2,-3,-2,1,"Aztec2");
		bb.addEntityPainting(0,-4,2,2,"Wanderer");
	}

}
