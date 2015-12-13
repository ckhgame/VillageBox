package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionFisherman;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class BuildingFishingStore extends Building {

	@Override
	public String getName() {
		return "Fishing Store";
	}

	@Override
	public String getDescription() {
		return "Welcome to the Fishing Store!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionFisherman.class,-1,-1 );
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,-3,Blocks.sandstone,0);bb.buildBlock(-3,-1,3,Blocks.sandstone,0);bb.buildBlock(-2,-1,-2,Blocks.planks,2);
		bb.buildBlock(-2,-1,-1,Blocks.planks,2);bb.buildBlock(-2,-1,0,Blocks.planks,2);bb.buildBlock(-2,-1,1,Blocks.planks,2);
		bb.buildBlock(-2,-1,2,Blocks.planks,2);bb.buildBlock(-1,-1,-2,Blocks.planks,2);bb.buildBlock(-1,-1,-1,Blocks.planks,0);
		bb.buildBlock(-1,-1,0,Blocks.planks,2);bb.buildBlock(-1,-1,1,Blocks.planks,0);bb.buildBlock(-1,-1,2,Blocks.planks,2);
		bb.buildBlock(0,-1,-2,Blocks.planks,2);bb.buildBlock(0,-1,-1,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);
		bb.buildBlock(0,-1,2,Blocks.planks,2);bb.buildBlock(1,-1,-2,Blocks.planks,2);bb.buildBlock(1,-1,-1,Blocks.planks,0);
		bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.planks,2);bb.buildBlock(2,-1,-2,Blocks.planks,2);
		bb.buildBlock(2,-1,-1,Blocks.planks,2);bb.buildBlock(2,-1,0,Blocks.planks,2);bb.buildBlock(2,-1,1,Blocks.planks,2);
		bb.buildBlock(2,-1,2,Blocks.planks,2);bb.buildBlock(3,-1,-3,Blocks.sandstone,0);bb.buildBlock(3,-1,-1,Blocks.planks,2);
		bb.buildBlock(3,-1,3,Blocks.sandstone,0);bb.buildBlock(-3,0,-3,Blocks.fence,0);bb.buildBlock(-3,0,-2,Blocks.sandstone,0);
		bb.buildBlock(-3,0,-1,Blocks.sandstone,0);bb.buildBlock(-3,0,0,Blocks.sandstone,0);bb.buildBlock(-3,0,1,Blocks.sandstone,0);
		bb.buildBlock(-3,0,2,Blocks.sandstone,0);bb.buildBlock(-3,0,3,Blocks.fence,0);bb.buildBlock(-2,0,-3,Blocks.sandstone,0);
		bb.buildBlock(-2,0,-2,Blocks.planks,2);bb.buildBlock(-2,0,0,Blocks.wooden_door,3);bb.buildBlock(-2,0,3,Blocks.sandstone,0);
		bb.buildBlock(-1,0,-3,Blocks.sandstone,0);bb.buildBlock(-1,0,0,Blocks.planks,0);bb.buildBlock(-1,0,3,Blocks.sandstone,0);
		bb.buildBlock(0,0,-3,Blocks.sandstone,0);bb.buildBlock(0,0,-1,Blocks.planks,0);bb.buildBlock(0,0,0,Blocks.planks,0);
		bb.buildBlock(0,0,1,Blocks.bed,3);bb.buildBlock(0,0,3,Blocks.sandstone,0);bb.buildBlock(1,0,-3,Blocks.sandstone,0);
		bb.buildBlock(1,0,0,Blocks.planks,0);bb.buildBlock(1,0,1,Blocks.bed,11);bb.buildBlock(1,0,3,Blocks.sandstone,0);
		bb.buildBlock(2,0,-3,Blocks.sandstone,0);bb.buildBlock(2,0,0,Blocks.planks,0);bb.buildBlock(2,0,1,Blocks.bookshelf,0);
		bb.buildBlock(2,0,2,Blocks.chest,4);bb.buildBlock(2,0,3,Blocks.sandstone,0);bb.buildBlock(3,0,-3,Blocks.fence,0);bb.buildBlock(3,0,-2,Blocks.sandstone,0);
		bb.buildBlock(3,0,-1,Blocks.wooden_door,0);bb.buildBlock(3,0,0,Blocks.sandstone,0);bb.buildBlock(3,0,1,Blocks.sandstone,0);
		bb.buildBlock(3,0,2,Blocks.sandstone,0);bb.buildBlock(3,0,3,Blocks.fence,0);bb.buildBlock(-3,1,-3,Blocks.fence,0);
		bb.buildBlock(-3,1,-2,Blocks.planks,2);bb.buildBlock(-3,1,-1,Blocks.planks,2);bb.buildBlock(-3,1,0,Blocks.planks,2);
		bb.buildBlock(-3,1,1,Blocks.planks,2);bb.buildBlock(-3,1,2,Blocks.planks,2);bb.buildBlock(-3,1,3,Blocks.fence,0);
		bb.buildBlock(-2,1,-3,Blocks.planks,2);bb.buildBlock(-2,1,-2,Blocks.bookshelf,0);bb.buildBlock(-2,1,0,Blocks.wooden_door,8);
		bb.buildBlock(-2,1,3,Blocks.planks,2);bb.buildBlock(-1,1,-3,Blocks.planks,2);bb.buildBlock(-1,1,0,Blocks.planks,0);
		bb.buildBlock(-1,1,3,Blocks.planks,2);bb.buildBlock(0,1,-3,Blocks.planks,2);bb.buildBlock(0,1,0,Blocks.planks,0);
		bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.planks,2);bb.buildBlock(1,1,0,Blocks.planks,0);
		bb.buildBlock(1,1,3,Blocks.planks,2);bb.buildBlock(2,1,-3,Blocks.planks,2);bb.buildBlock(2,1,0,Blocks.planks,0);
		bb.buildBlock(2,1,1,Blocks.flower_pot,4);bb.addTileEntityPot(2,1,1,38,4);
		bb.buildBlock(2,1,3,Blocks.planks,2);bb.buildBlock(3,1,-3,Blocks.fence,0);bb.buildBlock(3,1,-2,Blocks.planks,2);
		bb.buildBlock(3,1,-1,Blocks.wooden_door,8);bb.buildBlock(3,1,0,Blocks.planks,2);bb.buildBlock(3,1,1,Blocks.planks,2);
		bb.buildBlock(3,1,2,Blocks.planks,2);bb.buildBlock(3,1,3,Blocks.fence,0);bb.buildBlock(-3,2,-3,Blocks.fence,0);
		bb.buildBlock(-3,2,-2,Blocks.planks,2);bb.buildBlock(-3,2,-1,Blocks.planks,2);bb.buildBlock(-3,2,0,Blocks.planks,2);
		bb.buildBlock(-3,2,1,Blocks.planks,2);bb.buildBlock(-3,2,2,Blocks.planks,2);bb.buildBlock(-3,2,3,Blocks.fence,0);
		bb.buildBlock(-2,2,-3,Blocks.planks,2);bb.buildBlock(-2,2,0,Blocks.planks,0);bb.buildBlock(-2,2,3,Blocks.planks,2);
		bb.buildBlock(-1,2,-3,Blocks.planks,2);bb.buildBlock(-1,2,0,Blocks.planks,0);bb.buildBlock(-1,2,3,Blocks.planks,2);
		bb.buildBlock(0,2,-3,Blocks.planks,2);bb.buildBlock(0,2,0,Blocks.planks,0);bb.buildBlock(0,2,3,Blocks.glass_pane,0);
		bb.buildBlock(1,2,-3,Blocks.planks,2);bb.buildBlock(1,2,0,Blocks.planks,0);bb.buildBlock(1,2,3,Blocks.planks,2);
		bb.buildBlock(2,2,-3,Blocks.planks,2);bb.buildBlock(2,2,0,Blocks.planks,0);bb.buildBlock(2,2,3,Blocks.planks,2);
		bb.buildBlock(3,2,-3,Blocks.fence,0);bb.buildBlock(3,2,-2,Blocks.planks,2);bb.buildBlock(3,2,-1,Blocks.planks,2);
		bb.buildBlock(3,2,0,Blocks.planks,2);bb.buildBlock(3,2,1,Blocks.planks,2);bb.buildBlock(3,2,2,Blocks.planks,2);
		bb.buildBlock(3,2,3,Blocks.fence,0);bb.buildBlock(-3,3,-3,Blocks.wooden_slab,8);bb.buildBlock(-3,3,-2,Blocks.wooden_slab,0);
		bb.buildBlock(-3,3,-1,Blocks.wooden_slab,8);bb.buildBlock(-3,3,0,Blocks.wooden_slab,0);bb.buildBlock(-3,3,1,Blocks.wooden_slab,8);
		bb.buildBlock(-3,3,2,Blocks.wooden_slab,0);bb.buildBlock(-3,3,3,Blocks.wooden_slab,8);bb.buildBlock(-2,3,-3,Blocks.wooden_slab,0);
		bb.buildBlock(-2,3,-2,Blocks.planks,2);bb.buildBlock(-2,3,-1,Blocks.planks,2);bb.buildBlock(-2,3,0,Blocks.planks,2);
		bb.buildBlock(-2,3,1,Blocks.planks,2);bb.buildBlock(-2,3,2,Blocks.planks,2);bb.buildBlock(-2,3,3,Blocks.wooden_slab,0);
		bb.buildBlock(-1,3,-3,Blocks.wooden_slab,8);bb.buildBlock(-1,3,-2,Blocks.planks,2);bb.buildBlock(-1,3,0,Blocks.planks,2);
		bb.buildBlock(-1,3,2,Blocks.planks,2);bb.buildBlock(-1,3,3,Blocks.wooden_slab,8);bb.buildBlock(0,3,-3,Blocks.wooden_slab,0);
		bb.buildBlock(0,3,-2,Blocks.planks,2);bb.buildBlock(0,3,0,Blocks.planks,2);bb.buildBlock(0,3,2,Blocks.planks,2);
		bb.buildBlock(0,3,3,Blocks.wooden_slab,0);bb.buildBlock(1,3,-3,Blocks.wooden_slab,8);bb.buildBlock(1,3,-2,Blocks.planks,2);
		bb.buildBlock(1,3,0,Blocks.planks,2);bb.buildBlock(1,3,2,Blocks.planks,2);bb.buildBlock(1,3,3,Blocks.wooden_slab,8);
		bb.buildBlock(2,3,-3,Blocks.wooden_slab,0);bb.buildBlock(2,3,-2,Blocks.planks,2);bb.buildBlock(2,3,-1,Blocks.planks,2);
		bb.buildBlock(2,3,0,Blocks.planks,2);bb.buildBlock(2,3,1,Blocks.planks,2);bb.buildBlock(2,3,2,Blocks.planks,2);
		bb.buildBlock(2,3,3,Blocks.wooden_slab,0);bb.buildBlock(3,3,-3,Blocks.wooden_slab,8);bb.buildBlock(3,3,-2,Blocks.wooden_slab,0);
		bb.buildBlock(3,3,-1,Blocks.wooden_slab,8);bb.buildBlock(3,3,0,Blocks.wooden_slab,0);bb.buildBlock(3,3,1,Blocks.wooden_slab,8);
		bb.buildBlock(3,3,2,Blocks.wooden_slab,0);bb.buildBlock(3,3,3,Blocks.wooden_slab,8);bb.buildBlock(-2,4,-2,Blocks.hay_block,0);
		bb.buildBlock(-2,4,-1,Blocks.hay_block,0);bb.buildBlock(-2,4,0,Blocks.hay_block,0);bb.buildBlock(-2,4,1,Blocks.hay_block,0);
		bb.buildBlock(-2,4,2,Blocks.hay_block,0);bb.buildBlock(-1,4,-2,Blocks.hay_block,0);bb.buildBlock(-1,4,-1,Blocks.hay_block,4);
		bb.buildBlock(-1,4,0,Blocks.hay_block,4);bb.buildBlock(-1,4,1,Blocks.hay_block,4);bb.buildBlock(-1,4,2,Blocks.hay_block,0);
		bb.buildBlock(0,4,-1,Blocks.hay_block,4);bb.buildBlock(0,4,1,Blocks.hay_block,4);bb.buildBlock(0,4,2,Blocks.hay_block,0);
		bb.buildBlock(1,4,-2,Blocks.hay_block,0);bb.buildBlock(1,4,-1,Blocks.hay_block,4);bb.buildBlock(1,4,0,Blocks.hay_block,4);
		bb.buildBlock(1,4,1,Blocks.hay_block,4);bb.buildBlock(1,4,2,Blocks.hay_block,0);bb.buildBlock(2,4,-2,Blocks.hay_block,0);
		bb.buildBlock(2,4,-1,Blocks.hay_block,0);bb.buildBlock(2,4,0,Blocks.hay_block,0);bb.buildBlock(2,4,1,Blocks.hay_block,0);
		bb.buildBlock(2,4,2,Blocks.hay_block,0);bb.buildBlock(-1,5,-1,Blocks.fence,0);bb.buildBlock(-1,5,0,Blocks.fence,0);
		bb.buildBlock(-1,5,1,Blocks.fence,0);bb.buildBlock(0,5,-1,Blocks.fence,0);bb.buildBlock(0,5,1,Blocks.fence,0);
		bb.buildBlock(1,5,-1,Blocks.fence,0);bb.buildBlock(1,5,0,Blocks.fence,0);bb.buildBlock(1,5,1,Blocks.fence,0);
		bb.buildBlock(-1,6,-1,Blocks.hay_block,0);bb.buildBlock(-1,6,0,Blocks.hay_block,8);bb.buildBlock(-1,6,1,Blocks.hay_block,0);
		bb.buildBlock(0,6,-1,Blocks.hay_block,4);bb.buildBlock(0,6,0,Blocks.hay_block,8);bb.buildBlock(0,6,1,Blocks.hay_block,4);
		bb.buildBlock(1,6,-1,Blocks.hay_block,0);bb.buildBlock(1,6,0,Blocks.hay_block,8);bb.buildBlock(1,6,1,Blocks.hay_block,0);
		bb.buildBlock(-1,2,-2,Blocks.torch,3);bb.buildBlock(-1,2,2,Blocks.torch,4);bb.buildBlock(1,2,2,Blocks.torch,4);
		bb.buildBlock(2,2,-2,Blocks.torch,3);bb.addEntityItemFrame(0,2,-3,0,Items.fish);
		bb.addEntityItemFrame(0,1,-3,0,Items.fish);
		bb.addEntityItemFrame(1,2,-3,0,Items.fish);
		bb.addEntityItemFrame(1,1,-3,0,Items.fish);
	}

}
