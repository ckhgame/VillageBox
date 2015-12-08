package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionVillageElder;

import net.minecraft.init.Blocks;

public class BuildingVillageCenter extends Building {

	@Override
	public String getName() {
		return "Village Center";
	}

	@Override
	public String getDescription() {
		return "Welcome to the Village Center! Starting your cute village from here....";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionVillageElder.class,-1,-1);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {

		bb.buildBlock(-2,-1,-2,Blocks.planks,0);bb.buildBlock(-2,-1,-1,Blocks.planks,0);bb.buildBlock(-2,-1,0,Blocks.planks,0);
		bb.buildBlock(-2,-1,1,Blocks.planks,0);bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,-2,Blocks.planks,0);
		bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,0,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);
		bb.buildBlock(-1,-1,2,Blocks.planks,0);bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.planks,0);
		bb.buildBlock(1,-1,-2,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);
		bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(2,-1,-2,Blocks.planks,0);
		bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(2,-1,0,Blocks.planks,0);bb.buildBlock(2,-1,1,Blocks.planks,0);
		bb.buildBlock(2,-1,2,Blocks.planks,0);bb.buildBlock(-3,0,-3,Blocks.stonebrick,0);bb.buildBlock(-3,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,-1,Blocks.stonebrick,0);bb.buildBlock(-3,0,0,Blocks.stonebrick,0);bb.buildBlock(-3,0,1,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,2,Blocks.stonebrick,0);bb.buildBlock(-3,0,3,Blocks.stonebrick,0);bb.buildBlock(-2,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,-2,Blocks.stonebrick,0);bb.buildBlock(-2,0,-1,Blocks.stonebrick,0);bb.buildBlock(-2,0,0,Blocks.planks,0);
		bb.buildBlock(-2,0,1,Blocks.planks,0);bb.buildBlock(-2,0,2,Blocks.planks,0);bb.buildBlock(-2,0,3,Blocks.stonebrick,0);
		bb.buildBlock(-1,0,-3,Blocks.stonebrick,0);bb.buildBlock(-1,0,2,Blocks.oak_stairs,1);bb.buildBlock(-1,0,3,Blocks.stonebrick,0);
		bb.buildBlock(0,0,-3,Blocks.stonebrick,0);bb.buildBlock(0,0,-2,Blocks.planks,1);bb.buildBlock(0,0,-1,Blocks.planks,1);
		bb.buildBlock(0,0,0,Blocks.planks,1);bb.buildBlock(0,0,3,Blocks.stonebrick,0);bb.buildBlock(1,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(1,0,-2,Blocks.oak_stairs,3);bb.buildBlock(1,0,3,Blocks.stonebrick,0);bb.buildBlock(2,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(2,0,-2,Blocks.oak_stairs,3);bb.buildBlock(2,0,2,Blocks.bookshelf,0);bb.buildBlock(2,0,3,Blocks.stonebrick,0);
		bb.buildBlock(3,0,-3,Blocks.stonebrick,0);bb.buildBlock(3,0,-2,Blocks.stonebrick,0);bb.buildBlock(3,0,-1,Blocks.wooden_door,0);
		bb.buildBlock(3,0,0,Blocks.wooden_door,0);bb.buildBlock(3,0,1,Blocks.stonebrick,0);bb.buildBlock(3,0,2,Blocks.stonebrick,0);
		bb.buildBlock(3,0,3,Blocks.stonebrick,0);bb.buildBlock(-3,1,-3,Blocks.log,0);bb.buildBlock(-3,1,-2,Blocks.planks,2);
		bb.buildBlock(-3,1,-1,Blocks.planks,2);bb.buildBlock(-3,1,0,Blocks.planks,2);bb.buildBlock(-3,1,1,Blocks.planks,2);
		bb.buildBlock(-3,1,2,Blocks.planks,2);bb.buildBlock(-3,1,3,Blocks.log,0);bb.buildBlock(-2,1,-3,Blocks.planks,2);
		bb.buildBlock(-2,1,-2,Blocks.bookshelf,0);bb.buildBlock(-2,1,-1,Blocks.bookshelf,0);bb.buildBlock(-2,1,0,Blocks.planks,0);
		bb.buildBlock(-2,1,1,Blocks.oak_stairs,3);bb.buildBlock(-2,1,3,Blocks.planks,2);bb.buildBlock(-1,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(-1,1,3,Blocks.glass_pane,0);bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,-2,Blocks.flower_pot,0);
		bb.addTileEntityPot(0,1,-2,37,0);
		bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.glass_pane,0);bb.buildBlock(1,1,3,Blocks.glass_pane,0);
		bb.buildBlock(2,1,-3,Blocks.planks,2);bb.buildBlock(2,1,2,Blocks.bookshelf,0);bb.buildBlock(2,1,3,Blocks.planks,2);
		bb.buildBlock(3,1,-3,Blocks.log,0);bb.buildBlock(3,1,-2,Blocks.planks,2);bb.buildBlock(3,1,-1,Blocks.wooden_door,8);
		bb.buildBlock(3,1,0,Blocks.wooden_door,9);bb.buildBlock(3,1,1,Blocks.planks,2);bb.buildBlock(3,1,2,Blocks.planks,2);
		bb.buildBlock(3,1,3,Blocks.log,0);bb.buildBlock(-3,2,-3,Blocks.log,0);bb.buildBlock(-3,2,-2,Blocks.planks,2);
		bb.buildBlock(-3,2,-1,Blocks.planks,2);bb.buildBlock(-3,2,0,Blocks.planks,2);bb.buildBlock(-3,2,1,Blocks.planks,2);
		bb.buildBlock(-3,2,2,Blocks.planks,2);bb.buildBlock(-3,2,3,Blocks.log,0);bb.buildBlock(-2,2,-3,Blocks.planks,2);
		bb.buildBlock(-2,2,-1,Blocks.oak_stairs,6);bb.buildBlock(-2,2,0,Blocks.oak_stairs,3);bb.buildBlock(-2,2,3,Blocks.planks,2);
		bb.buildBlock(-1,2,-3,Blocks.planks,2);bb.buildBlock(-1,2,3,Blocks.planks,2);bb.buildBlock(0,2,-3,Blocks.planks,2);
		bb.buildBlock(0,2,3,Blocks.planks,2);bb.buildBlock(1,2,-3,Blocks.planks,2);bb.buildBlock(1,2,3,Blocks.planks,2);
		bb.buildBlock(2,2,-3,Blocks.planks,2);bb.buildBlock(2,2,3,Blocks.planks,2);bb.buildBlock(3,2,-3,Blocks.log,0);
		bb.buildBlock(3,2,-2,Blocks.planks,2);bb.buildBlock(3,2,-1,Blocks.planks,2);bb.buildBlock(3,2,0,Blocks.planks,2);
		bb.buildBlock(3,2,1,Blocks.planks,2);bb.buildBlock(3,2,2,Blocks.planks,2);bb.buildBlock(3,2,3,Blocks.log,0);
		bb.buildBlock(-3,3,-3,Blocks.log,0);bb.buildBlock(-3,3,-2,Blocks.planks,0);bb.buildBlock(-3,3,-1,Blocks.planks,0);
		bb.buildBlock(-3,3,0,Blocks.planks,0);bb.buildBlock(-3,3,1,Blocks.planks,0);bb.buildBlock(-3,3,2,Blocks.planks,0);
		bb.buildBlock(-3,3,3,Blocks.log,0);bb.buildBlock(-2,3,-3,Blocks.planks,0);bb.buildBlock(-2,3,-2,Blocks.planks,0);
		bb.buildBlock(-2,3,-1,Blocks.oak_stairs,3);bb.buildBlock(-2,3,3,Blocks.planks,0);bb.buildBlock(-1,3,-3,Blocks.planks,0);
		bb.buildBlock(-1,3,-2,Blocks.planks,0);bb.buildBlock(-1,3,-1,Blocks.planks,0);bb.buildBlock(-1,3,0,Blocks.planks,0);
		bb.buildBlock(-1,3,1,Blocks.planks,0);bb.buildBlock(-1,3,2,Blocks.planks,0);bb.buildBlock(-1,3,3,Blocks.planks,0);
		bb.buildBlock(0,3,-3,Blocks.planks,0);bb.buildBlock(0,3,-2,Blocks.planks,0);bb.buildBlock(0,3,-1,Blocks.planks,0);
		bb.buildBlock(0,3,0,Blocks.planks,0);bb.buildBlock(0,3,1,Blocks.planks,0);bb.buildBlock(0,3,2,Blocks.planks,0);
		bb.buildBlock(0,3,3,Blocks.planks,0);bb.buildBlock(1,3,-3,Blocks.planks,0);bb.buildBlock(1,3,-2,Blocks.planks,0);
		bb.buildBlock(1,3,-1,Blocks.planks,0);bb.buildBlock(1,3,0,Blocks.planks,0);bb.buildBlock(1,3,1,Blocks.planks,0);
		bb.buildBlock(1,3,2,Blocks.planks,0);bb.buildBlock(1,3,3,Blocks.planks,0);bb.buildBlock(2,3,-3,Blocks.planks,0);
		bb.buildBlock(2,3,-2,Blocks.planks,0);bb.buildBlock(2,3,-1,Blocks.planks,0);bb.buildBlock(2,3,0,Blocks.planks,0);
		bb.buildBlock(2,3,1,Blocks.planks,0);bb.buildBlock(2,3,2,Blocks.planks,0);bb.buildBlock(2,3,3,Blocks.planks,0);
		bb.buildBlock(3,3,-3,Blocks.log,0);bb.buildBlock(3,3,-2,Blocks.planks,0);bb.buildBlock(3,3,-1,Blocks.planks,0);
		bb.buildBlock(3,3,0,Blocks.planks,0);bb.buildBlock(3,3,1,Blocks.planks,0);bb.buildBlock(3,3,2,Blocks.planks,0);
		bb.buildBlock(3,3,3,Blocks.log,0);bb.buildBlock(-3,4,-3,Blocks.log,0);bb.buildBlock(-3,4,-2,Blocks.planks,2);
		bb.buildBlock(-3,4,-1,Blocks.planks,2);bb.buildBlock(-3,4,0,Blocks.planks,2);bb.buildBlock(-3,4,1,Blocks.planks,2);
		bb.buildBlock(-3,4,2,Blocks.planks,2);bb.buildBlock(-3,4,3,Blocks.log,0);bb.buildBlock(-2,4,-3,Blocks.planks,2);
		bb.buildBlock(-2,4,3,Blocks.planks,2);bb.buildBlock(-1,4,-3,Blocks.planks,2);bb.buildBlock(-1,4,-2,Blocks.wooden_door,2);
		bb.buildBlock(-1,4,-1,Blocks.planks,0);bb.buildBlock(-1,4,0,Blocks.planks,0);bb.buildBlock(-1,4,1,Blocks.planks,0);
		bb.buildBlock(-1,4,2,Blocks.planks,0);bb.buildBlock(-1,4,3,Blocks.planks,2);bb.buildBlock(0,4,-3,Blocks.planks,2);
		bb.buildBlock(0,4,-2,Blocks.carpet,14);bb.buildBlock(0,4,-1,Blocks.carpet,14);bb.buildBlock(0,4,0,Blocks.carpet,14);
		bb.buildBlock(0,4,1,Blocks.carpet,14);bb.buildBlock(0,4,2,Blocks.crafting_table,0);bb.buildBlock(0,4,3,Blocks.planks,2);
		bb.buildBlock(1,4,-3,Blocks.planks,2);bb.buildBlock(1,4,-2,Blocks.carpet,14);bb.buildBlock(1,4,-1,Blocks.carpet,14);
		bb.buildBlock(1,4,0,Blocks.carpet,14);bb.buildBlock(1,4,1,Blocks.carpet,14);bb.buildBlock(1,4,2,Blocks.chest,2);
		bb.buildBlock(1,4,3,Blocks.planks,2);bb.buildBlock(2,4,-3,Blocks.planks,2);bb.buildBlock(2,4,-2,Blocks.bookshelf,0);
		bb.buildBlock(2,4,-1,Blocks.bookshelf,0);bb.buildBlock(2,4,1,Blocks.bed,0);bb.buildBlock(2,4,2,Blocks.bed,8);
		bb.buildBlock(2,4,3,Blocks.planks,2);bb.buildBlock(3,4,-3,Blocks.log,0);bb.buildBlock(3,4,-2,Blocks.planks,2);
		bb.buildBlock(3,4,-1,Blocks.planks,2);bb.buildBlock(3,4,0,Blocks.planks,2);bb.buildBlock(3,4,1,Blocks.planks,2);
		bb.buildBlock(3,4,2,Blocks.planks,2);bb.buildBlock(3,4,3,Blocks.log,0);bb.buildBlock(-3,5,-3,Blocks.log,0);
		bb.buildBlock(-3,5,-2,Blocks.planks,2);bb.buildBlock(-3,5,-1,Blocks.glass_pane,0);bb.buildBlock(-3,5,0,Blocks.glass_pane,0);
		bb.buildBlock(-3,5,1,Blocks.glass_pane,0);bb.buildBlock(-3,5,2,Blocks.planks,2);bb.buildBlock(-3,5,3,Blocks.log,0);
		bb.buildBlock(-2,5,-3,Blocks.planks,2);bb.buildBlock(-2,5,3,Blocks.planks,2);bb.buildBlock(-1,5,-3,Blocks.planks,2);
		bb.buildBlock(-1,5,-2,Blocks.wooden_door,8);bb.buildBlock(-1,5,-1,Blocks.planks,0);bb.buildBlock(-1,5,0,Blocks.planks,0);
		bb.buildBlock(-1,5,1,Blocks.planks,0);bb.buildBlock(-1,5,2,Blocks.planks,0);bb.buildBlock(-1,5,3,Blocks.planks,2);
		bb.buildBlock(0,5,-3,Blocks.planks,2);bb.buildBlock(0,5,3,Blocks.planks,2);bb.buildBlock(1,5,-3,Blocks.planks,2);
		bb.buildBlock(1,5,3,Blocks.glass_pane,0);bb.buildBlock(2,5,-3,Blocks.planks,2);bb.buildBlock(2,5,-2,Blocks.flower_pot,8);
		bb.addTileEntityPot(2,5,-2,38,8);
		bb.buildBlock(2,5,3,Blocks.planks,2);bb.buildBlock(3,5,-3,Blocks.log,0);bb.buildBlock(3,5,-2,Blocks.planks,2);
		bb.buildBlock(3,5,-1,Blocks.glass_pane,0);bb.buildBlock(3,5,0,Blocks.glass_pane,0);bb.buildBlock(3,5,1,Blocks.glass_pane,0);
		bb.buildBlock(3,5,2,Blocks.planks,2);bb.buildBlock(3,5,3,Blocks.log,0);bb.buildBlock(-3,6,-3,Blocks.log,0);
		bb.buildBlock(-3,6,-2,Blocks.planks,2);bb.buildBlock(-3,6,-1,Blocks.planks,2);bb.buildBlock(-3,6,0,Blocks.planks,2);
		bb.buildBlock(-3,6,1,Blocks.planks,2);bb.buildBlock(-3,6,2,Blocks.planks,2);bb.buildBlock(-3,6,3,Blocks.log,0);
		bb.buildBlock(-2,6,-3,Blocks.planks,2);bb.buildBlock(-2,6,3,Blocks.planks,2);bb.buildBlock(-1,6,-3,Blocks.planks,2);
		bb.buildBlock(-1,6,-2,Blocks.planks,0);bb.buildBlock(-1,6,-1,Blocks.planks,0);bb.buildBlock(-1,6,0,Blocks.planks,0);
		bb.buildBlock(-1,6,1,Blocks.planks,0);bb.buildBlock(-1,6,2,Blocks.planks,0);bb.buildBlock(-1,6,3,Blocks.planks,2);
		bb.buildBlock(0,6,-3,Blocks.planks,2);bb.buildBlock(0,6,3,Blocks.planks,2);bb.buildBlock(1,6,-3,Blocks.planks,2);
		bb.buildBlock(1,6,3,Blocks.glass_pane,0);bb.buildBlock(2,6,-3,Blocks.planks,2);bb.buildBlock(2,6,3,Blocks.planks,2);
		bb.buildBlock(3,6,-3,Blocks.log,0);bb.buildBlock(3,6,-2,Blocks.planks,2);bb.buildBlock(3,6,-1,Blocks.planks,2);
		bb.buildBlock(3,6,0,Blocks.planks,2);bb.buildBlock(3,6,1,Blocks.planks,2);bb.buildBlock(3,6,2,Blocks.planks,2);
		bb.buildBlock(3,6,3,Blocks.log,0);bb.buildBlock(-3,7,-3,Blocks.log,0);bb.buildBlock(-3,7,-2,Blocks.log,8);
		bb.buildBlock(-3,7,-1,Blocks.log,8);bb.buildBlock(-3,7,0,Blocks.log,8);bb.buildBlock(-3,7,1,Blocks.log,8);
		bb.buildBlock(-3,7,2,Blocks.log,8);bb.buildBlock(-3,7,3,Blocks.log,0);bb.buildBlock(-2,7,-3,Blocks.log,4);
		bb.buildBlock(-2,7,3,Blocks.log,4);bb.buildBlock(-1,7,-3,Blocks.log,4);bb.buildBlock(-1,7,-2,Blocks.planks,0);
		bb.buildBlock(-1,7,-1,Blocks.planks,0);bb.buildBlock(-1,7,0,Blocks.planks,0);bb.buildBlock(-1,7,1,Blocks.planks,0);
		bb.buildBlock(-1,7,2,Blocks.planks,0);bb.buildBlock(-1,7,3,Blocks.log,4);bb.buildBlock(0,7,-3,Blocks.log,4);
		bb.buildBlock(0,7,3,Blocks.log,4);bb.buildBlock(1,7,-3,Blocks.log,4);bb.buildBlock(1,7,3,Blocks.log,4);
		bb.buildBlock(2,7,-3,Blocks.log,4);bb.buildBlock(2,7,3,Blocks.log,4);bb.buildBlock(3,7,-3,Blocks.log,0);
		bb.buildBlock(3,7,-2,Blocks.log,8);bb.buildBlock(3,7,-1,Blocks.log,8);bb.buildBlock(3,7,0,Blocks.log,8);
		bb.buildBlock(3,7,1,Blocks.log,8);bb.buildBlock(3,7,2,Blocks.log,8);bb.buildBlock(3,7,3,Blocks.log,0);
		bb.buildBlock(-3,8,-3,Blocks.oak_stairs,0);bb.buildBlock(-3,8,-2,Blocks.oak_stairs,0);bb.buildBlock(-3,8,-1,Blocks.oak_stairs,0);
		bb.buildBlock(-3,8,0,Blocks.oak_stairs,0);bb.buildBlock(-3,8,1,Blocks.oak_stairs,0);bb.buildBlock(-3,8,2,Blocks.oak_stairs,0);
		bb.buildBlock(-3,8,3,Blocks.oak_stairs,0);bb.buildBlock(-2,8,-3,Blocks.oak_stairs,2);bb.buildBlock(-2,8,3,Blocks.oak_stairs,3);
		bb.buildBlock(-1,8,-3,Blocks.oak_stairs,2);bb.buildBlock(-1,8,-2,Blocks.planks,0);bb.buildBlock(-1,8,-1,Blocks.planks,0);
		bb.buildBlock(-1,8,0,Blocks.planks,0);bb.buildBlock(-1,8,1,Blocks.planks,0);bb.buildBlock(-1,8,2,Blocks.planks,0);
		bb.buildBlock(-1,8,3,Blocks.oak_stairs,3);bb.buildBlock(0,8,-3,Blocks.oak_stairs,2);bb.buildBlock(0,8,3,Blocks.oak_stairs,3);
		bb.buildBlock(1,8,-3,Blocks.oak_stairs,2);bb.buildBlock(1,8,3,Blocks.oak_stairs,3);bb.buildBlock(2,8,-3,Blocks.oak_stairs,2);
		bb.buildBlock(2,8,3,Blocks.oak_stairs,3);bb.buildBlock(3,8,-3,Blocks.oak_stairs,1);bb.buildBlock(3,8,-2,Blocks.oak_stairs,1);
		bb.buildBlock(3,8,-1,Blocks.oak_stairs,1);bb.buildBlock(3,8,0,Blocks.oak_stairs,1);bb.buildBlock(3,8,1,Blocks.oak_stairs,1);
		bb.buildBlock(3,8,2,Blocks.oak_stairs,1);bb.buildBlock(3,8,3,Blocks.oak_stairs,3);bb.buildBlock(-2,9,-2,Blocks.oak_stairs,2);
		bb.buildBlock(-2,9,-1,Blocks.oak_stairs,0);bb.buildBlock(-2,9,0,Blocks.oak_stairs,0);bb.buildBlock(-2,9,1,Blocks.oak_stairs,0);
		bb.buildBlock(-2,9,2,Blocks.oak_stairs,3);bb.buildBlock(-1,9,-2,Blocks.oak_stairs,2);bb.buildBlock(-1,9,-1,Blocks.log,4);
		bb.buildBlock(-1,9,0,Blocks.log,8);bb.buildBlock(-1,9,1,Blocks.log,8);bb.buildBlock(-1,9,2,Blocks.oak_stairs,3);
		bb.buildBlock(0,9,-2,Blocks.oak_stairs,2);bb.buildBlock(0,9,-1,Blocks.log,4);bb.buildBlock(0,9,0,Blocks.glass,0);
		bb.buildBlock(0,9,1,Blocks.log,4);bb.buildBlock(0,9,2,Blocks.oak_stairs,3);bb.buildBlock(1,9,-2,Blocks.oak_stairs,2);
		bb.buildBlock(1,9,-1,Blocks.log,8);bb.buildBlock(1,9,0,Blocks.log,8);bb.buildBlock(1,9,1,Blocks.log,4);
		bb.buildBlock(1,9,2,Blocks.oak_stairs,3);bb.buildBlock(2,9,-2,Blocks.oak_stairs,1);bb.buildBlock(2,9,-1,Blocks.oak_stairs,1);
		bb.buildBlock(2,9,0,Blocks.oak_stairs,1);bb.buildBlock(2,9,1,Blocks.oak_stairs,1);bb.buildBlock(2,9,2,Blocks.oak_stairs,3);
		bb.buildBlock(-2,2,-2,Blocks.torch,3);bb.buildBlock(-2,2,2,Blocks.torch,4);bb.buildBlock(2,2,-2,Blocks.torch,3);
		bb.buildBlock(2,2,2,Blocks.torch,4);bb.buildBlock(-2,7,-2,Blocks.torch,3);bb.buildBlock(2,7,-2,Blocks.torch,3);
		bb.buildBlock(2,7,2,Blocks.torch,4);bb.addEntityPainting(-2,1,0,3,"Kebab");
		bb.addEntityPainting(-1,6,1,3,"Sea");
	}

}
