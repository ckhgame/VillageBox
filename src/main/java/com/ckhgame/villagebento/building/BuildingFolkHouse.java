package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionVillagerFolk0;
import com.ckhgame.villagebento.profession.ProfessionVillagerFolk1;
import com.ckhgame.villagebento.profession.ProfessionVillagerFolk2;
import com.ckhgame.villagebento.profession.ProfessionVillagerFolk3;
import com.ckhgame.villagebento.profession.ProfessionVillagerFolk4;
import com.ckhgame.villagebento.util.tool.VBRandom;

import net.minecraft.init.Blocks;

public class BuildingFolkHouse extends Building {

	@Override
	public String getName() {
		return "Folk House";
	}

	@Override
	public String getDescription() {
		return "Home of villagers";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		int r = VBRandom.getRand().nextInt(5);
		if(r == 0) bb.addVillager(ProfessionVillagerFolk0.class,0,-1 );
		else if(r == 1) bb.addVillager(ProfessionVillagerFolk1.class,0,-1 );
		else if(r == 2) bb.addVillager(ProfessionVillagerFolk2.class,0,-1 );
		else if(r == 3) bb.addVillager(ProfessionVillagerFolk3.class,0,-1 );
		else if(r == 4) bb.addVillager(ProfessionVillagerFolk4.class,0,-1 );
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		int r = VBRandom.getRand().nextInt(5);
		if(r == 0) this.buildBlocks_style0(bb);
		else if(r == 1) this.buildBlocks_style1(bb);
		else if(r == 2) this.buildBlocks_style2(bb);
		else if(r == 3) this.buildBlocks_style3(bb);
		else if(r == 4) this.buildBlocks_style4(bb);
	}
	
	private void buildBlocks_style0(BuildingBuilder bb){
		bb.buildBlock(-1,-1,-2,Blocks.planks,0);bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,0,Blocks.planks,0);
		bb.buildBlock(-1,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);
		bb.buildBlock(1,-1,0,Blocks.planks,0);bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(2,-1,0,Blocks.planks,0);
		bb.buildBlock(-2,0,-3,Blocks.planks,1);bb.buildBlock(-2,0,-2,Blocks.planks,1);bb.buildBlock(-2,0,-1,Blocks.planks,1);
		bb.buildBlock(-2,0,0,Blocks.planks,1);bb.buildBlock(-2,0,1,Blocks.planks,1);bb.buildBlock(-2,0,2,Blocks.planks,1);
		bb.buildBlock(-2,0,3,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);bb.buildBlock(-1,0,-2,Blocks.bed,9);
		bb.buildBlock(-1,0,2,Blocks.bookshelf,0);bb.buildBlock(-1,0,3,Blocks.planks,1);bb.buildBlock(0,0,-3,Blocks.planks,1);
		bb.buildBlock(0,0,-2,Blocks.bed,1);bb.buildBlock(0,0,1,ModBlocks.blockOakChair,0);bb.buildBlock(0,0,2,Blocks.planks,1);bb.buildBlock(0,0,3,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.planks,1);
		bb.buildBlock(1,0,-2,Blocks.planks,0);bb.buildBlock(1,0,2,Blocks.planks,1);bb.buildBlock(1,0,3,Blocks.planks,1);
		bb.buildBlock(2,0,-3,Blocks.planks,1);bb.buildBlock(2,0,-2,Blocks.planks,1);bb.buildBlock(2,0,-1,Blocks.planks,1);
		bb.buildBlock(2,0,0,Blocks.wooden_door,2);bb.buildBlock(2,0,1,Blocks.planks,1);bb.buildBlock(2,0,2,Blocks.planks,1);
		bb.buildBlock(2,0,3,Blocks.planks,1);bb.buildBlock(3,0,-1,Blocks.flower_pot,8);bb.addTileEntityPot(3,0,-1,38,8);
		bb.buildBlock(3,0,1,Blocks.oak_stairs,1);bb.buildBlock(3,0,2,Blocks.oak_stairs,1);bb.buildBlock(-2,1,-3,Blocks.planks,1);
		bb.buildBlock(-2,1,-2,Blocks.planks,1);bb.buildBlock(-2,1,-1,Blocks.glass_pane,0);bb.buildBlock(-2,1,0,Blocks.glass_pane,0);
		bb.buildBlock(-2,1,1,Blocks.glass_pane,0);bb.buildBlock(-2,1,2,Blocks.planks,1);bb.buildBlock(-2,1,3,Blocks.planks,1);
		bb.buildBlock(-1,1,-3,Blocks.planks,1);bb.buildBlock(-1,1,2,Blocks.bookshelf,0);bb.buildBlock(-1,1,3,Blocks.planks,1);
		bb.buildBlock(0,1,-3,Blocks.planks,1);bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.planks,1);
		bb.buildBlock(1,1,-2,Blocks.chest,3);bb.buildBlock(1,1,3,Blocks.planks,1);bb.buildBlock(2,1,-3,Blocks.planks,1);bb.buildBlock(2,1,-2,Blocks.planks,1);
		bb.buildBlock(2,1,-1,Blocks.planks,1);bb.buildBlock(2,1,0,Blocks.wooden_door,8);bb.buildBlock(2,1,1,Blocks.planks,1);
		bb.buildBlock(2,1,2,Blocks.planks,1);bb.buildBlock(2,1,3,Blocks.planks,1);bb.buildBlock(-3,2,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,2,-2,Blocks.acacia_stairs,7);bb.buildBlock(-3,2,-1,Blocks.fence,0);bb.buildBlock(-3,2,0,Blocks.fence,0);
		bb.buildBlock(-3,2,1,Blocks.fence,0);bb.buildBlock(-3,2,2,Blocks.acacia_stairs,6);bb.buildBlock(-3,2,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,2,-3,Blocks.acacia_stairs,2);bb.buildBlock(-2,2,-2,Blocks.planks,1);bb.buildBlock(-2,2,-1,Blocks.planks,1);
		bb.buildBlock(-2,2,0,Blocks.planks,1);bb.buildBlock(-2,2,1,Blocks.planks,1);bb.buildBlock(-2,2,2,Blocks.planks,1);
		bb.buildBlock(-2,2,3,Blocks.acacia_stairs,3);bb.buildBlock(-1,2,-3,Blocks.acacia_stairs,2);bb.buildBlock(-1,2,3,Blocks.acacia_stairs,3);
		bb.buildBlock(0,2,-3,Blocks.acacia_stairs,2);bb.buildBlock(0,2,3,Blocks.acacia_stairs,3);bb.buildBlock(1,2,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(1,2,3,Blocks.acacia_stairs,3);bb.buildBlock(2,2,-3,Blocks.acacia_stairs,2);bb.buildBlock(2,2,-2,Blocks.planks,1);
		bb.buildBlock(2,2,-1,Blocks.planks,1);bb.buildBlock(2,2,0,Blocks.planks,1);bb.buildBlock(2,2,1,Blocks.planks,1);
		bb.buildBlock(2,2,2,Blocks.planks,1);bb.buildBlock(2,2,3,Blocks.acacia_stairs,3);bb.buildBlock(3,2,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(3,2,-2,Blocks.acacia_stairs,7);bb.buildBlock(3,2,2,Blocks.acacia_stairs,6);bb.buildBlock(3,2,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-1,Blocks.acacia_stairs,7);bb.buildBlock(-3,3,1,Blocks.acacia_stairs,6);
		bb.buildBlock(-3,3,2,Blocks.acacia_stairs,3);bb.buildBlock(-2,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(-2,3,-1,Blocks.planks,1);
		bb.buildBlock(-2,3,0,Blocks.planks,1);bb.buildBlock(-2,3,1,Blocks.planks,1);bb.buildBlock(-2,3,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(-1,3,2,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(0,3,2,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(1,3,2,Blocks.acacia_stairs,3);
		bb.buildBlock(2,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(2,3,-1,Blocks.planks,1);bb.buildBlock(2,3,0,Blocks.glass_pane,0);
		bb.buildBlock(2,3,1,Blocks.planks,1);bb.buildBlock(2,3,2,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(3,3,-1,Blocks.acacia_stairs,7);bb.buildBlock(3,3,1,Blocks.acacia_stairs,6);bb.buildBlock(3,3,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(-3,4,0,Blocks.planks,4);bb.buildBlock(-3,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(-2,4,0,Blocks.planks,4);bb.buildBlock(-2,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(-1,4,0,Blocks.planks,4);bb.buildBlock(-1,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(0,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(0,4,0,Blocks.planks,4);bb.buildBlock(0,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(1,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(1,4,0,Blocks.planks,4);bb.buildBlock(1,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(2,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(2,4,0,Blocks.planks,4);bb.buildBlock(2,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(3,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(3,4,0,Blocks.planks,4);bb.buildBlock(3,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(0,2,-2,Blocks.torch,3);bb.buildBlock(0,2,2,Blocks.torch,4);bb.addEntityPainting(-2,2,0,3,"Wasteland");
	}

	private void buildBlocks_style1(BuildingBuilder bb){
		bb.buildBlock(-2,-1,1,Blocks.planks,0);bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,-2,Blocks.planks,0);
		bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);bb.buildBlock(-1,-1,2,Blocks.planks,0);
		bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);
		bb.buildBlock(0,-1,2,Blocks.planks,0);bb.buildBlock(1,-1,-2,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);
		bb.buildBlock(1,-1,0,Blocks.planks,0);bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.planks,0);
		bb.buildBlock(2,-1,-2,Blocks.planks,0);bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(3,-1,-1,Blocks.planks,0);
		bb.buildBlock(-3,0,-3,Blocks.planks,1);bb.buildBlock(-3,0,-2,Blocks.planks,1);bb.buildBlock(-3,0,-1,Blocks.planks,1);
		bb.buildBlock(-3,0,0,Blocks.planks,1);bb.buildBlock(-3,0,1,Blocks.planks,1);bb.buildBlock(-3,0,2,Blocks.planks,1);
		bb.buildBlock(-3,0,3,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.planks,1);bb.buildBlock(-2,0,-2,Blocks.planks,1);
		bb.buildBlock(-2,0,-1,Blocks.planks,1);bb.buildBlock(-2,0,0,Blocks.planks,1);bb.buildBlock(-2,0,1,Blocks.planks,1);
		bb.buildBlock(-2,0,2,Blocks.bed,9);bb.buildBlock(-2,0,3,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);
		bb.buildBlock(-1,0,-2,ModBlocks.blockOakChair,0);bb.buildBlock(-1,0,0,Blocks.planks,1);bb.buildBlock(-1,0,2,Blocks.bed,1);bb.buildBlock(-1,0,3,Blocks.planks,1);
		bb.buildBlock(0,0,-3,Blocks.planks,1);bb.buildBlock(0,0,0,Blocks.planks,1);bb.buildBlock(0,0,3,Blocks.planks,1);
		bb.buildBlock(1,0,-3,Blocks.planks,1);bb.buildBlock(1,0,0,Blocks.wooden_door,1);bb.buildBlock(1,0,3,Blocks.planks,1);
		bb.buildBlock(2,0,-3,Blocks.planks,1);bb.buildBlock(2,0,0,Blocks.planks,1);bb.buildBlock(2,0,1,Blocks.bookshelf,0);
		bb.buildBlock(2,0,2,Blocks.bookshelf,0);bb.buildBlock(2,0,3,Blocks.planks,1);bb.buildBlock(3,0,-3,Blocks.planks,1);
		bb.buildBlock(3,0,-2,Blocks.planks,1);bb.buildBlock(3,0,-1,Blocks.wooden_door,2);bb.buildBlock(3,0,0,Blocks.planks,1);
		bb.buildBlock(3,0,1,Blocks.planks,1);bb.buildBlock(3,0,2,Blocks.planks,1);bb.buildBlock(3,0,3,Blocks.planks,1);
		bb.buildBlock(-3,1,-3,Blocks.planks,1);bb.buildBlock(-3,1,-2,Blocks.glass_pane,0);bb.buildBlock(-3,1,-1,Blocks.glass_pane,0);
		bb.buildBlock(-3,1,0,Blocks.planks,1);bb.buildBlock(-3,1,1,Blocks.planks,1);bb.buildBlock(-3,1,2,Blocks.planks,1);
		bb.buildBlock(-3,1,3,Blocks.planks,1);bb.buildBlock(-2,1,-3,Blocks.planks,1);bb.buildBlock(-2,1,0,Blocks.planks,1);
		bb.buildBlock(-2,1,1,Blocks.chest,5);bb.buildBlock(-2,1,3,Blocks.planks,1);bb.buildBlock(-1,1,-3,Blocks.planks,1);bb.buildBlock(-1,1,0,Blocks.planks,1);
		bb.buildBlock(-1,1,3,Blocks.planks,1);bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,0,Blocks.planks,1);
		bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.glass_pane,0);bb.buildBlock(1,1,0,Blocks.wooden_door,8);
		bb.buildBlock(1,1,3,Blocks.planks,1);bb.buildBlock(2,1,-3,Blocks.planks,1);bb.buildBlock(2,1,0,Blocks.planks,1);
		bb.buildBlock(2,1,3,Blocks.planks,1);bb.buildBlock(3,1,-3,Blocks.planks,1);bb.buildBlock(3,1,-2,Blocks.planks,1);
		bb.buildBlock(3,1,-1,Blocks.wooden_door,8);bb.buildBlock(3,1,0,Blocks.planks,1);bb.buildBlock(3,1,1,Blocks.glass_pane,0);
		bb.buildBlock(3,1,2,Blocks.glass_pane,0);bb.buildBlock(3,1,3,Blocks.planks,1);bb.buildBlock(-3,2,-3,Blocks.planks,1);
		bb.buildBlock(-3,2,-2,Blocks.planks,1);bb.buildBlock(-3,2,-1,Blocks.planks,1);bb.buildBlock(-3,2,0,Blocks.planks,1);
		bb.buildBlock(-3,2,1,Blocks.planks,4);bb.buildBlock(-3,2,2,Blocks.planks,4);bb.buildBlock(-3,2,3,Blocks.planks,1);
		bb.buildBlock(-2,2,-3,Blocks.planks,1);bb.buildBlock(-2,2,0,Blocks.planks,1);bb.buildBlock(-2,2,3,Blocks.planks,1);
		bb.buildBlock(-1,2,-3,Blocks.planks,1);bb.buildBlock(-1,2,0,Blocks.planks,1);bb.buildBlock(-1,2,3,Blocks.planks,1);
		bb.buildBlock(0,2,-3,Blocks.planks,1);bb.buildBlock(0,2,0,Blocks.planks,1);bb.buildBlock(0,2,3,Blocks.planks,1);
		bb.buildBlock(1,2,-3,Blocks.planks,1);bb.buildBlock(1,2,0,Blocks.planks,1);bb.buildBlock(1,2,3,Blocks.planks,1);
		bb.buildBlock(2,2,-3,Blocks.planks,1);bb.buildBlock(2,2,0,Blocks.planks,1);bb.buildBlock(2,2,3,Blocks.planks,1);
		bb.buildBlock(3,2,-3,Blocks.planks,1);bb.buildBlock(3,2,-2,Blocks.planks,4);bb.buildBlock(3,2,-1,Blocks.planks,4);
		bb.buildBlock(3,2,0,Blocks.planks,4);bb.buildBlock(3,2,1,Blocks.planks,4);bb.buildBlock(3,2,2,Blocks.planks,4);
		bb.buildBlock(3,2,3,Blocks.planks,1);bb.buildBlock(-3,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-2,Blocks.acacia_stairs,0);
		bb.buildBlock(-3,3,-1,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,0,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,1,Blocks.acacia_stairs,0);
		bb.buildBlock(-3,3,2,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,3,Blocks.acacia_stairs,0);bb.buildBlock(-2,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,3,-2,Blocks.planks,4);bb.buildBlock(-2,3,-1,Blocks.planks,4);bb.buildBlock(-2,3,0,Blocks.planks,4);
		bb.buildBlock(-2,3,1,Blocks.planks,4);bb.buildBlock(-2,3,2,Blocks.planks,4);bb.buildBlock(-2,3,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(-1,3,-2,Blocks.planks,4);bb.buildBlock(-1,3,-1,Blocks.planks,1);
		bb.buildBlock(-1,3,0,Blocks.planks,1);bb.buildBlock(-1,3,1,Blocks.planks,1);bb.buildBlock(-1,3,2,Blocks.planks,4);
		bb.buildBlock(-1,3,3,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(0,3,-2,Blocks.planks,4);
		bb.buildBlock(0,3,-1,Blocks.planks,1);bb.buildBlock(0,3,0,Blocks.planks,1);bb.buildBlock(0,3,1,Blocks.planks,1);
		bb.buildBlock(0,3,2,Blocks.planks,4);bb.buildBlock(0,3,3,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(1,3,-2,Blocks.planks,4);bb.buildBlock(1,3,-1,Blocks.planks,1);bb.buildBlock(1,3,0,Blocks.planks,1);
		bb.buildBlock(1,3,1,Blocks.planks,1);bb.buildBlock(1,3,2,Blocks.planks,4);bb.buildBlock(1,3,3,Blocks.acacia_stairs,3);
		bb.buildBlock(2,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(2,3,-2,Blocks.planks,4);bb.buildBlock(2,3,-1,Blocks.planks,4);
		bb.buildBlock(2,3,0,Blocks.planks,4);bb.buildBlock(2,3,1,Blocks.planks,4);bb.buildBlock(2,3,2,Blocks.planks,4);
		bb.buildBlock(2,3,3,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(3,3,-2,Blocks.acacia_stairs,1);
		bb.buildBlock(3,3,-1,Blocks.acacia_stairs,1);bb.buildBlock(3,3,0,Blocks.acacia_stairs,1);bb.buildBlock(3,3,1,Blocks.acacia_stairs,1);
		bb.buildBlock(3,3,2,Blocks.acacia_stairs,1);bb.buildBlock(3,3,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,2,-1,Blocks.torch,4);
		bb.buildBlock(-2,2,2,Blocks.torch,1);bb.buildBlock(2,2,-1,Blocks.torch,4);bb.buildBlock(2,2,2,Blocks.torch,2);
		bb.addEntityPainting(0,2,0,2,"Sunset");
	}
	
	private void buildBlocks_style2(BuildingBuilder bb){
		bb.buildBlock(-2,-1,-2,Blocks.planks,0);bb.buildBlock(-2,-1,-1,Blocks.planks,0);bb.buildBlock(-2,-1,0,Blocks.planks,0);
		bb.buildBlock(-2,-1,1,Blocks.planks,0);bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,-2,Blocks.planks,0);
		bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,0,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);
		bb.buildBlock(-1,-1,2,Blocks.planks,0);bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.planks,0);
		bb.buildBlock(1,-1,-2,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);
		bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(2,-1,-2,Blocks.planks,0);
		bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(2,-1,0,Blocks.planks,0);bb.buildBlock(2,-1,1,Blocks.planks,0);
		bb.buildBlock(2,-1,2,Blocks.planks,0);bb.buildBlock(3,-1,-1,Blocks.planks,0);bb.buildBlock(3,-1,1,Blocks.planks,0);
		bb.buildBlock(-3,0,-2,Blocks.planks,1);bb.buildBlock(-3,0,-1,Blocks.planks,1);bb.buildBlock(-3,0,0,Blocks.planks,1);
		bb.buildBlock(-3,0,1,Blocks.planks,1);bb.buildBlock(-3,0,2,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.planks,1);
		bb.buildBlock(-2,0,-2,Blocks.bed,10);bb.buildBlock(-2,0,-1,Blocks.bed,2);bb.buildBlock(-2,0,2,Blocks.planks,1);
		bb.buildBlock(-2,0,3,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);bb.buildBlock(-1,0,-2,Blocks.bookshelf,0);
		bb.buildBlock(-1,0,3,Blocks.planks,1);bb.buildBlock(0,0,-3,Blocks.planks,1);bb.buildBlock(0,0,-2,Blocks.planks,1);
		bb.buildBlock(0,0,-1,ModBlocks.blockOakChair,0);bb.buildBlock(0,0,3,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.planks,1);bb.buildBlock(1,0,-2,Blocks.planks,1);
		bb.buildBlock(1,0,2,Blocks.planks,1);bb.buildBlock(1,0,3,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.planks,1);
		bb.buildBlock(2,0,-2,Blocks.bookshelf,0);bb.buildBlock(2,0,2,Blocks.planks,1);bb.buildBlock(2,0,3,Blocks.planks,1);
		bb.buildBlock(3,0,-2,Blocks.planks,1);bb.buildBlock(3,0,-1,Blocks.planks,1);bb.buildBlock(3,0,0,Blocks.planks,1);
		bb.buildBlock(3,0,1,Blocks.wooden_door,2);bb.buildBlock(3,0,2,Blocks.planks,1);bb.buildBlock(-3,1,-2,Blocks.planks,1);
		bb.buildBlock(-3,1,-1,Blocks.planks,1);bb.buildBlock(-3,1,0,Blocks.planks,1);bb.buildBlock(-3,1,1,Blocks.planks,1);
		bb.buildBlock(-3,1,2,Blocks.planks,1);bb.buildBlock(-2,1,-3,Blocks.planks,1);bb.buildBlock(-2,1,2,Blocks.chest,2);
		bb.buildBlock(-2,1,3,Blocks.planks,1);bb.buildBlock(-1,1,-3,Blocks.glass_pane,0);bb.buildBlock(-1,1,3,Blocks.planks,1);
		bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(1,1,3,Blocks.planks,1);bb.buildBlock(2,1,-3,Blocks.planks,1);bb.buildBlock(2,1,-2,Blocks.bookshelf,0);
		bb.buildBlock(2,1,2,Blocks.flower_pot,4);bb.addTileEntityPot(2,1,2,38,4);
		bb.buildBlock(2,1,3,Blocks.planks,1);bb.buildBlock(3,1,-2,Blocks.planks,1);bb.buildBlock(3,1,-1,Blocks.planks,1);
		bb.buildBlock(3,1,0,Blocks.planks,1);bb.buildBlock(3,1,1,Blocks.wooden_door,8);bb.buildBlock(3,1,2,Blocks.planks,1);
		bb.buildBlock(-3,2,-3,Blocks.acacia_stairs,2);bb.buildBlock(-3,2,-2,Blocks.planks,4);bb.buildBlock(-3,2,-1,Blocks.planks,4);
		bb.buildBlock(-3,2,0,Blocks.planks,4);bb.buildBlock(-3,2,1,Blocks.planks,4);bb.buildBlock(-3,2,2,Blocks.planks,4);
		bb.buildBlock(-3,2,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,2,-3,Blocks.acacia_stairs,2);bb.buildBlock(-2,2,-2,Blocks.planks,4);
		bb.buildBlock(-2,2,2,Blocks.planks,4);bb.buildBlock(-2,2,3,Blocks.acacia_stairs,3);bb.buildBlock(-1,2,-3,Blocks.acacia_stairs,6);
		bb.buildBlock(-1,2,-2,Blocks.planks,4);bb.buildBlock(-1,2,2,Blocks.planks,4);bb.buildBlock(-1,2,3,Blocks.acacia_stairs,3);
		bb.buildBlock(0,2,-3,Blocks.acacia_stairs,6);bb.buildBlock(0,2,-2,Blocks.planks,4);bb.buildBlock(0,2,2,Blocks.planks,4);
		bb.buildBlock(0,2,3,Blocks.acacia_stairs,7);bb.buildBlock(1,2,-3,Blocks.acacia_stairs,6);bb.buildBlock(1,2,-2,Blocks.planks,4);
		bb.buildBlock(1,2,2,Blocks.planks,4);bb.buildBlock(1,2,3,Blocks.acacia_stairs,3);bb.buildBlock(2,2,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(2,2,-2,Blocks.planks,4);bb.buildBlock(2,2,2,Blocks.planks,4);bb.buildBlock(2,2,3,Blocks.acacia_stairs,3);
		bb.buildBlock(3,2,-3,Blocks.acacia_stairs,2);bb.buildBlock(3,2,-2,Blocks.planks,4);bb.buildBlock(3,2,-1,Blocks.planks,4);
		bb.buildBlock(3,2,0,Blocks.planks,4);bb.buildBlock(3,2,1,Blocks.planks,4);bb.buildBlock(3,2,2,Blocks.planks,4);
		bb.buildBlock(3,2,3,Blocks.acacia_stairs,3);bb.buildBlock(-3,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-1,Blocks.acacia_stairs,0);
		bb.buildBlock(-3,3,0,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,1,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,2,Blocks.acacia_stairs,0);
		bb.buildBlock(-2,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(-2,3,-1,Blocks.planks,4);bb.buildBlock(-2,3,0,Blocks.planks,4);
		bb.buildBlock(-2,3,1,Blocks.planks,4);bb.buildBlock(-2,3,2,Blocks.planks,4);bb.buildBlock(-1,3,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,3,-1,Blocks.planks,1);bb.buildBlock(-1,3,0,Blocks.planks,1);bb.buildBlock(-1,3,1,Blocks.planks,1);
		bb.buildBlock(-1,3,2,Blocks.planks,4);bb.buildBlock(0,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(0,3,-1,Blocks.planks,1);
		bb.buildBlock(0,3,0,Blocks.planks,1);bb.buildBlock(0,3,1,Blocks.planks,1);bb.buildBlock(0,3,2,Blocks.planks,4);
		bb.buildBlock(1,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(1,3,-1,Blocks.planks,1);bb.buildBlock(1,3,0,Blocks.planks,1);
		bb.buildBlock(1,3,1,Blocks.planks,1);bb.buildBlock(1,3,2,Blocks.planks,4);bb.buildBlock(2,3,-2,Blocks.acacia_stairs,2);
		bb.buildBlock(2,3,-1,Blocks.planks,4);bb.buildBlock(2,3,0,Blocks.planks,4);bb.buildBlock(2,3,1,Blocks.planks,4);
		bb.buildBlock(2,3,2,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-2,Blocks.acacia_stairs,2);bb.buildBlock(3,3,-1,Blocks.acacia_stairs,1);
		bb.buildBlock(3,3,0,Blocks.acacia_stairs,1);bb.buildBlock(3,3,1,Blocks.acacia_stairs,1);bb.buildBlock(3,3,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(-2,4,0,Blocks.planks,4);bb.buildBlock(-2,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(-1,4,0,Blocks.planks,4);bb.buildBlock(-1,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(0,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(0,4,0,Blocks.planks,4);bb.buildBlock(0,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(1,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(1,4,0,Blocks.planks,4);bb.buildBlock(1,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(2,4,-1,Blocks.acacia_stairs,2);bb.buildBlock(2,4,0,Blocks.planks,4);bb.buildBlock(2,4,1,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,2,-1,Blocks.torch,3);bb.buildBlock(-1,2,1,Blocks.torch,4);bb.buildBlock(1,2,-1,Blocks.torch,3);
		bb.buildBlock(1,2,1,Blocks.torch,4);
	}
	
	private void buildBlocks_style3(BuildingBuilder bb){
		bb.buildBlock(-2,-1,-2,Blocks.planks,0);bb.buildBlock(-2,-1,-1,Blocks.planks,0);bb.buildBlock(-2,-1,0,Blocks.planks,0);
		bb.buildBlock(-2,-1,1,Blocks.planks,0);bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,-2,Blocks.planks,0);
		bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,0,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);
		bb.buildBlock(-1,-1,2,Blocks.planks,0);bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.planks,0);
		bb.buildBlock(1,-1,-2,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);
		bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(2,-1,-2,Blocks.planks,0);
		bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(2,-1,0,Blocks.planks,0);bb.buildBlock(2,-1,1,Blocks.planks,0);
		bb.buildBlock(2,-1,2,Blocks.planks,0);bb.buildBlock(-3,0,3,Blocks.fence,0);bb.buildBlock(-2,0,-3,Blocks.planks,1);
		bb.buildBlock(-2,0,-2,Blocks.planks,1);bb.buildBlock(-2,0,-1,Blocks.planks,1);bb.buildBlock(-2,0,0,Blocks.planks,1);
		bb.buildBlock(-2,0,1,Blocks.planks,1);bb.buildBlock(-2,0,2,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);
		bb.buildBlock(-1,0,-2,Blocks.bookshelf,0);bb.buildBlock(-1,0,1,Blocks.planks,1);bb.buildBlock(-1,0,2,Blocks.planks,1);
		bb.buildBlock(0,0,-3,Blocks.planks,1);bb.buildBlock(0,0,-2,Blocks.planks,1);bb.buildBlock(0,0,-1,ModBlocks.blockOakChair,0);
		bb.buildBlock(0,0,1,Blocks.bed,3);bb.buildBlock(0,0,2,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.planks,1);
		bb.buildBlock(1,0,-2,Blocks.planks,1);bb.buildBlock(1,0,1,Blocks.bed,11);bb.buildBlock(1,0,2,Blocks.planks,1);
		bb.buildBlock(2,0,-3,Blocks.planks,1);bb.buildBlock(2,0,-2,Blocks.planks,1);bb.buildBlock(2,0,-1,Blocks.wooden_door,2);
		bb.buildBlock(2,0,0,Blocks.planks,1);bb.buildBlock(2,0,1,Blocks.planks,1);bb.buildBlock(2,0,2,Blocks.planks,1);
		bb.buildBlock(3,0,-3,Blocks.jungle_stairs,1);bb.buildBlock(3,0,-2,Blocks.jungle_stairs,1);bb.buildBlock(3,0,3,Blocks.fence,0);
		bb.buildBlock(-3,1,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,1,-3,Blocks.planks,1);bb.buildBlock(-2,1,-2,Blocks.planks,1);
		bb.buildBlock(-2,1,-1,Blocks.glass_pane,0);bb.buildBlock(-2,1,0,Blocks.glass_pane,0);bb.buildBlock(-2,1,1,Blocks.glass_pane,0);
		bb.buildBlock(-2,1,2,Blocks.planks,1);bb.buildBlock(-2,1,3,Blocks.acacia_stairs,3);bb.buildBlock(-1,1,-3,Blocks.planks,1);
		bb.buildBlock(-1,1,-2,Blocks.flower_pot,7);bb.addTileEntityPot(-1,1,-2,38,7);
		bb.buildBlock(-1,1,1,Blocks.chest,2);bb.buildBlock(-1,1,2,Blocks.planks,1);bb.buildBlock(-1,1,3,Blocks.acacia_stairs,3);bb.buildBlock(0,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,1,2,Blocks.planks,1);bb.buildBlock(0,1,3,Blocks.acacia_stairs,3);bb.buildBlock(1,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(1,1,2,Blocks.planks,1);bb.buildBlock(1,1,3,Blocks.acacia_stairs,3);bb.buildBlock(2,1,-3,Blocks.planks,1);
		bb.buildBlock(2,1,-2,Blocks.planks,1);bb.buildBlock(2,1,-1,Blocks.wooden_door,8);bb.buildBlock(2,1,0,Blocks.planks,1);
		bb.buildBlock(2,1,1,Blocks.glass_pane,0);bb.buildBlock(2,1,2,Blocks.planks,1);bb.buildBlock(2,1,3,Blocks.acacia_stairs,3);
		bb.buildBlock(3,1,2,Blocks.acacia_stairs,6);bb.buildBlock(3,1,3,Blocks.acacia_stairs,3);bb.buildBlock(-3,2,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-3,2,-2,Blocks.double_wooden_slab,4);bb.buildBlock(-3,2,-1,Blocks.wooden_slab,12);bb.buildBlock(-3,2,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,2,-3,Blocks.wooden_slab,4);bb.buildBlock(-2,2,-2,Blocks.planks,4);bb.buildBlock(-2,2,-1,Blocks.double_wooden_slab,4);
		bb.buildBlock(-2,2,0,Blocks.planks,1);bb.buildBlock(-2,2,1,Blocks.planks,1);bb.buildBlock(-2,2,2,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,2,-3,Blocks.wooden_slab,4);bb.buildBlock(-1,2,-2,Blocks.planks,4);bb.buildBlock(-1,2,-1,Blocks.double_wooden_slab,4);
		bb.buildBlock(-1,2,2,Blocks.acacia_stairs,3);bb.buildBlock(0,2,-3,Blocks.wooden_slab,4);bb.buildBlock(0,2,-2,Blocks.planks,4);
		bb.buildBlock(0,2,-1,Blocks.double_wooden_slab,4);bb.buildBlock(0,2,2,Blocks.acacia_stairs,3);bb.buildBlock(1,2,-3,Blocks.wooden_slab,4);
		bb.buildBlock(1,2,-2,Blocks.planks,4);bb.buildBlock(1,2,-1,Blocks.double_wooden_slab,4);bb.buildBlock(1,2,2,Blocks.acacia_stairs,3);
		bb.buildBlock(2,2,-3,Blocks.wooden_slab,4);bb.buildBlock(2,2,-2,Blocks.planks,4);bb.buildBlock(2,2,-1,Blocks.double_wooden_slab,4);
		bb.buildBlock(2,2,0,Blocks.planks,4);bb.buildBlock(2,2,1,Blocks.planks,4);bb.buildBlock(2,2,2,Blocks.acacia_stairs,3);
		bb.buildBlock(3,2,-3,Blocks.wooden_slab,4);bb.buildBlock(3,2,-2,Blocks.double_wooden_slab,4);bb.buildBlock(3,2,-1,Blocks.wooden_slab,12);
		bb.buildBlock(3,2,1,Blocks.acacia_stairs,6);bb.buildBlock(3,2,2,Blocks.acacia_stairs,3);bb.buildBlock(-3,3,-1,Blocks.wooden_slab,4);
		bb.buildBlock(-3,3,0,Blocks.planks,4);bb.buildBlock(-3,3,1,Blocks.acacia_stairs,3);bb.buildBlock(-2,3,-1,Blocks.wooden_slab,4);
		bb.buildBlock(-2,3,0,Blocks.planks,4);bb.buildBlock(-2,3,1,Blocks.acacia_stairs,3);bb.buildBlock(-1,3,-1,Blocks.wooden_slab,4);
		bb.buildBlock(-1,3,0,Blocks.planks,4);bb.buildBlock(-1,3,1,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-1,Blocks.wooden_slab,4);
		bb.buildBlock(0,3,0,Blocks.planks,4);bb.buildBlock(0,3,1,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-1,Blocks.wooden_slab,4);
		bb.buildBlock(1,3,0,Blocks.planks,4);bb.buildBlock(1,3,1,Blocks.acacia_stairs,3);bb.buildBlock(2,3,-1,Blocks.wooden_slab,4);
		bb.buildBlock(2,3,0,Blocks.planks,4);bb.buildBlock(2,3,1,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-1,Blocks.wooden_slab,4);
		bb.buildBlock(3,3,0,Blocks.planks,4);bb.buildBlock(3,3,1,Blocks.acacia_stairs,3);bb.buildBlock(-1,2,0,Blocks.torch,1);
		bb.buildBlock(-1,2,1,Blocks.torch,1);bb.buildBlock(1,2,1,Blocks.torch,2);bb.addEntityPainting(0,2,2,2,"Pool");
	}
	
	private void buildBlocks_style4(BuildingBuilder bb){
		bb.buildBlock(-2,-1,-2,Blocks.planks,0);bb.buildBlock(-2,-1,-1,Blocks.planks,0);bb.buildBlock(-2,-1,0,Blocks.planks,0);
		bb.buildBlock(-2,-1,1,Blocks.planks,0);bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,-2,Blocks.planks,0);
		bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,0,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);
		bb.buildBlock(-1,-1,2,Blocks.planks,0);bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);
		bb.buildBlock(0,-1,0,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);bb.buildBlock(0,-1,2,Blocks.planks,0);
		bb.buildBlock(1,-1,-2,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);bb.buildBlock(1,-1,0,Blocks.planks,0);
		bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.planks,0);bb.buildBlock(2,-1,-2,Blocks.planks,0);
		bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(2,-1,0,Blocks.planks,0);bb.buildBlock(2,-1,1,Blocks.planks,0);
		bb.buildBlock(2,-1,2,Blocks.planks,0);bb.buildBlock(-3,0,-3,Blocks.planks,1);bb.buildBlock(-3,0,-2,Blocks.planks,1);
		bb.buildBlock(-3,0,-1,Blocks.planks,1);bb.buildBlock(-3,0,0,Blocks.planks,1);bb.buildBlock(-3,0,1,Blocks.planks,1);
		bb.buildBlock(-3,0,2,Blocks.planks,1);bb.buildBlock(-3,0,3,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.planks,1);
		bb.buildBlock(-2,0,-2,Blocks.bed,9);bb.buildBlock(-2,0,0,Blocks.planks,1);bb.buildBlock(-2,0,1,Blocks.bookshelf,0);
		bb.buildBlock(-2,0,2,Blocks.planks,1);bb.buildBlock(-2,0,3,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);
		bb.buildBlock(-1,0,-2,Blocks.bed,1);bb.buildBlock(-1,0,2,Blocks.planks,1);bb.buildBlock(-1,0,3,Blocks.planks,1);
		bb.buildBlock(0,0,-3,Blocks.planks,1);bb.buildBlock(0,0,-2,Blocks.planks,1);bb.buildBlock(0,0,-1,ModBlocks.blockOakChair,0);
		bb.buildBlock(0,0,3,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.planks,1);bb.buildBlock(1,0,-2,Blocks.planks,1);
		bb.buildBlock(1,0,3,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.planks,1);bb.buildBlock(2,0,-2,Blocks.planks,1);
		bb.buildBlock(2,0,-1,Blocks.planks,1);bb.buildBlock(2,0,0,Blocks.planks,1);bb.buildBlock(2,0,1,Blocks.wooden_door,2);
		bb.buildBlock(2,0,2,Blocks.planks,1);bb.buildBlock(2,0,3,Blocks.planks,1);bb.buildBlock(3,0,-3,Blocks.oak_stairs,1);
		bb.buildBlock(3,0,-2,Blocks.oak_stairs,1);bb.buildBlock(3,0,3,Blocks.oak_stairs,1);bb.buildBlock(-3,1,-3,Blocks.planks,1);
		bb.buildBlock(-3,1,-2,Blocks.planks,1);bb.buildBlock(-3,1,-1,Blocks.planks,1);bb.buildBlock(-3,1,0,Blocks.glass_pane,0);
		bb.buildBlock(-3,1,1,Blocks.planks,1);bb.buildBlock(-3,1,2,Blocks.planks,1);bb.buildBlock(-3,1,3,Blocks.planks,1);
		bb.buildBlock(-2,1,-3,Blocks.planks,1);
		bb.buildBlock(-2,1,2,Blocks.bookshelf,0);bb.buildBlock(-2,1,3,Blocks.planks,1);bb.buildBlock(-1,1,-3,Blocks.planks,1);
		bb.buildBlock(-1,1,2,Blocks.chest,2);bb.buildBlock(-1,1,3,Blocks.planks,1);bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,3,Blocks.planks,1);
		bb.buildBlock(1,1,-3,Blocks.glass_pane,0);bb.buildBlock(1,1,3,Blocks.planks,1);bb.buildBlock(2,1,-3,Blocks.planks,1);
		bb.buildBlock(2,1,-2,Blocks.planks,1);bb.buildBlock(2,1,-1,Blocks.glass_pane,0);bb.buildBlock(2,1,0,Blocks.planks,1);
		bb.buildBlock(2,1,1,Blocks.wooden_door,8);bb.buildBlock(2,1,2,Blocks.planks,1);bb.buildBlock(2,1,3,Blocks.planks,1);
		bb.buildBlock(-3,2,-3,Blocks.planks,1);bb.buildBlock(-3,2,-2,Blocks.planks,1);bb.buildBlock(-3,2,-1,Blocks.planks,1);
		bb.buildBlock(-3,2,0,Blocks.planks,1);bb.buildBlock(-3,2,1,Blocks.planks,1);bb.buildBlock(-3,2,2,Blocks.planks,1);
		bb.buildBlock(-3,2,3,Blocks.planks,1);bb.buildBlock(-2,2,-3,Blocks.planks,1);bb.buildBlock(-2,2,3,Blocks.planks,1);
		bb.buildBlock(-1,2,-3,Blocks.planks,1);bb.buildBlock(-1,2,3,Blocks.planks,1);bb.buildBlock(0,2,-3,Blocks.planks,1);
		bb.buildBlock(0,2,3,Blocks.planks,1);bb.buildBlock(1,2,-3,Blocks.planks,1);bb.buildBlock(1,2,3,Blocks.planks,1);
		bb.buildBlock(2,2,-3,Blocks.planks,1);bb.buildBlock(2,2,-2,Blocks.planks,1);bb.buildBlock(2,2,-1,Blocks.planks,1);
		bb.buildBlock(2,2,0,Blocks.planks,1);bb.buildBlock(2,2,1,Blocks.planks,1);bb.buildBlock(2,2,2,Blocks.planks,1);
		bb.buildBlock(2,2,3,Blocks.planks,1);bb.buildBlock(3,2,-2,Blocks.acacia_stairs,1);bb.buildBlock(3,2,-1,Blocks.acacia_stairs,1);
		bb.buildBlock(3,2,0,Blocks.acacia_stairs,1);bb.buildBlock(3,2,1,Blocks.acacia_stairs,1);bb.buildBlock(3,2,2,Blocks.acacia_stairs,1);
		bb.buildBlock(-3,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-2,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,-1,Blocks.acacia_stairs,0);
		bb.buildBlock(-3,3,0,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,1,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,2,Blocks.acacia_stairs,0);
		bb.buildBlock(-3,3,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(-2,3,-2,Blocks.planks,4);
		bb.buildBlock(-2,3,-1,Blocks.planks,4);bb.buildBlock(-2,3,0,Blocks.planks,4);bb.buildBlock(-2,3,1,Blocks.planks,4);
		bb.buildBlock(-2,3,2,Blocks.planks,4);bb.buildBlock(-2,3,3,Blocks.acacia_stairs,3);bb.buildBlock(-1,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,3,-2,Blocks.planks,4);bb.buildBlock(-1,3,-1,Blocks.planks,4);bb.buildBlock(-1,3,0,Blocks.glass,0);
		bb.buildBlock(-1,3,1,Blocks.glass,0);bb.buildBlock(-1,3,2,Blocks.planks,4);bb.buildBlock(-1,3,3,Blocks.acacia_stairs,3);
		bb.buildBlock(0,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(0,3,-2,Blocks.planks,4);bb.buildBlock(0,3,-1,Blocks.planks,4);
		bb.buildBlock(0,3,0,Blocks.glass,0);bb.buildBlock(0,3,1,Blocks.glass,0);bb.buildBlock(0,3,2,Blocks.planks,4);
		bb.buildBlock(0,3,3,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(1,3,-2,Blocks.planks,4);
		bb.buildBlock(1,3,-1,Blocks.planks,4);bb.buildBlock(1,3,0,Blocks.planks,4);bb.buildBlock(1,3,1,Blocks.planks,4);
		bb.buildBlock(1,3,2,Blocks.planks,4);bb.buildBlock(1,3,3,Blocks.acacia_stairs,3);bb.buildBlock(2,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(2,3,-2,Blocks.acacia_stairs,1);bb.buildBlock(2,3,-1,Blocks.acacia_stairs,1);bb.buildBlock(2,3,0,Blocks.acacia_stairs,1);
		bb.buildBlock(2,3,1,Blocks.acacia_stairs,1);bb.buildBlock(2,3,2,Blocks.acacia_stairs,1);bb.buildBlock(2,3,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,4,-2,Blocks.fence,0);bb.buildBlock(-2,4,-1,Blocks.fence,0);bb.buildBlock(-2,4,0,Blocks.fence,0);
		bb.buildBlock(-2,4,1,Blocks.fence,0);bb.buildBlock(-2,4,2,Blocks.fence,0);bb.buildBlock(-1,4,-2,Blocks.fence,0);
		bb.buildBlock(-1,4,2,Blocks.fence,0);bb.buildBlock(0,4,-2,Blocks.fence,0);bb.buildBlock(0,4,2,Blocks.fence,0);
		bb.buildBlock(1,4,-2,Blocks.fence,0);bb.buildBlock(1,4,-1,Blocks.fence,0);bb.buildBlock(1,4,0,Blocks.fence,0);
		bb.buildBlock(1,4,1,Blocks.fence,0);bb.buildBlock(1,4,2,Blocks.fence,0);bb.buildBlock(-2,2,-2,Blocks.torch,3);
		bb.buildBlock(-2,2,2,Blocks.torch,4);bb.buildBlock(1,2,-2,Blocks.torch,3);bb.buildBlock(1,2,2,Blocks.torch,4);
	}
	
	private void coolhouse(BuildingBuilder bb){
		bb.buildBlock(-2,-1,1,Blocks.planks,0);bb.buildBlock(-2,-1,2,Blocks.planks,0);bb.buildBlock(-1,-1,-2,Blocks.planks,0);
		bb.buildBlock(-1,-1,-1,Blocks.planks,0);bb.buildBlock(-1,-1,1,Blocks.planks,0);bb.buildBlock(-1,-1,2,Blocks.planks,0);
		bb.buildBlock(0,-1,-2,Blocks.planks,0);bb.buildBlock(0,-1,-1,Blocks.planks,0);bb.buildBlock(0,-1,1,Blocks.planks,0);
		bb.buildBlock(0,-1,2,Blocks.planks,0);bb.buildBlock(1,-1,-2,Blocks.planks,0);bb.buildBlock(1,-1,-1,Blocks.planks,0);
		bb.buildBlock(1,-1,0,Blocks.planks,0);bb.buildBlock(1,-1,1,Blocks.planks,0);bb.buildBlock(1,-1,2,Blocks.planks,0);
		bb.buildBlock(2,-1,-2,Blocks.planks,0);bb.buildBlock(2,-1,-1,Blocks.planks,0);bb.buildBlock(3,-1,-1,Blocks.planks,0);
		bb.buildBlock(-3,0,-3,Blocks.planks,1);bb.buildBlock(-3,0,-2,Blocks.planks,1);bb.buildBlock(-3,0,-1,Blocks.planks,1);
		bb.buildBlock(-3,0,0,Blocks.planks,1);bb.buildBlock(-3,0,1,Blocks.planks,1);bb.buildBlock(-3,0,2,Blocks.planks,1);
		bb.buildBlock(-3,0,3,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.planks,1);bb.buildBlock(-2,0,-2,Blocks.planks,1);
		bb.buildBlock(-2,0,-1,Blocks.planks,1);bb.buildBlock(-2,0,0,Blocks.planks,1);bb.buildBlock(-2,0,1,Blocks.planks,1);
		bb.buildBlock(-2,0,2,Blocks.bed,9);bb.buildBlock(-2,0,3,Blocks.planks,1);bb.buildBlock(-1,0,-3,Blocks.planks,1);
		bb.buildBlock(-1,0,-2,ModBlocks.blockOakChair,0);bb.buildBlock(-1,0,0,Blocks.planks,1);bb.buildBlock(-1,0,1,Blocks.carpet,1);bb.buildBlock(-1,0,2,Blocks.bed,1);
		bb.buildBlock(-1,0,3,Blocks.planks,1);bb.buildBlock(0,0,-3,Blocks.planks,1);bb.buildBlock(0,0,0,Blocks.planks,1);
		bb.buildBlock(0,0,1,Blocks.carpet,8);bb.buildBlock(0,0,2,Blocks.carpet,1);bb.buildBlock(0,0,3,Blocks.planks,1);
		bb.buildBlock(1,0,-3,Blocks.planks,1);bb.buildBlock(1,0,0,Blocks.wooden_door,1);bb.buildBlock(1,0,1,Blocks.carpet,1);
		bb.buildBlock(1,0,2,Blocks.carpet,8);bb.buildBlock(1,0,3,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.planks,1);
		bb.buildBlock(2,0,0,Blocks.planks,1);bb.buildBlock(2,0,1,Blocks.bookshelf,0);bb.buildBlock(2,0,2,Blocks.bookshelf,0);
		bb.buildBlock(2,0,3,Blocks.planks,1);bb.buildBlock(3,0,-3,Blocks.planks,1);bb.buildBlock(3,0,-2,Blocks.planks,1);
		bb.buildBlock(3,0,-1,Blocks.wooden_door,2);bb.buildBlock(3,0,0,Blocks.planks,1);bb.buildBlock(3,0,1,Blocks.planks,1);
		bb.buildBlock(3,0,2,Blocks.planks,1);bb.buildBlock(3,0,3,Blocks.planks,1);bb.buildBlock(-3,1,-3,Blocks.glass_pane,0);
		bb.buildBlock(-3,1,-2,Blocks.glass_pane,0);bb.buildBlock(-3,1,-1,Blocks.glass_pane,0);bb.buildBlock(-3,1,0,Blocks.planks,1);
		bb.buildBlock(-3,1,1,Blocks.planks,1);bb.buildBlock(-3,1,2,Blocks.planks,1);bb.buildBlock(-3,1,3,Blocks.planks,1);
		bb.buildBlock(-2,1,-3,Blocks.glass_pane,0);bb.buildBlock(-2,1,0,Blocks.planks,1);bb.buildBlock(-2,1,1,Blocks.chest,5);
		bb.buildBlock(-2,1,3,Blocks.planks,1);bb.buildBlock(-1,1,-3,Blocks.glass_pane,0);bb.buildBlock(-1,1,0,Blocks.planks,1);
		bb.buildBlock(-1,1,3,Blocks.planks,1);bb.buildBlock(0,1,-3,Blocks.glass_pane,0);bb.buildBlock(0,1,0,Blocks.planks,1);
		bb.buildBlock(0,1,3,Blocks.glass_pane,0);bb.buildBlock(1,1,-3,Blocks.glass_pane,0);bb.buildBlock(1,1,0,Blocks.wooden_door,8);
		bb.buildBlock(1,1,3,Blocks.planks,1);bb.buildBlock(2,1,-3,Blocks.glass_pane,0);bb.buildBlock(2,1,0,Blocks.planks,1);
		bb.buildBlock(2,1,3,Blocks.planks,1);bb.buildBlock(3,1,-3,Blocks.planks,1);bb.buildBlock(3,1,-2,Blocks.planks,1);
		bb.buildBlock(3,1,-1,Blocks.wooden_door,8);bb.buildBlock(3,1,0,Blocks.planks,1);bb.buildBlock(3,1,1,Blocks.glass_pane,0);
		bb.buildBlock(3,1,2,Blocks.glass_pane,0);bb.buildBlock(3,1,3,Blocks.planks,1);bb.buildBlock(-3,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(-3,2,-2,Blocks.glass_pane,0);bb.buildBlock(-3,2,-1,Blocks.glass_pane,0);bb.buildBlock(-3,2,0,Blocks.planks,4);
		bb.buildBlock(-3,2,1,Blocks.planks,4);bb.buildBlock(-3,2,2,Blocks.planks,4);bb.buildBlock(-3,2,3,Blocks.planks,1);
		bb.buildBlock(-2,2,-3,Blocks.glass_pane,0);bb.buildBlock(-2,2,0,Blocks.planks,1);bb.buildBlock(-2,2,3,Blocks.planks,1);
		bb.buildBlock(-1,2,-3,Blocks.glass_pane,0);bb.buildBlock(-1,2,0,Blocks.planks,1);bb.buildBlock(-1,2,3,Blocks.planks,1);
		bb.buildBlock(0,2,-3,Blocks.glass_pane,0);bb.buildBlock(0,2,0,Blocks.planks,1);bb.buildBlock(0,2,3,Blocks.planks,1);
		bb.buildBlock(1,2,-3,Blocks.glass_pane,0);bb.buildBlock(1,2,0,Blocks.planks,1);bb.buildBlock(1,2,3,Blocks.planks,1);
		bb.buildBlock(2,2,-3,Blocks.glass_pane,0);bb.buildBlock(2,2,0,Blocks.planks,1);bb.buildBlock(2,2,3,Blocks.planks,1);
		bb.buildBlock(3,2,-3,Blocks.planks,1);bb.buildBlock(3,2,-2,Blocks.planks,4);bb.buildBlock(3,2,-1,Blocks.planks,4);
		bb.buildBlock(3,2,0,Blocks.planks,4);bb.buildBlock(3,2,1,Blocks.planks,4);bb.buildBlock(3,2,2,Blocks.planks,4);
		bb.buildBlock(3,2,3,Blocks.planks,1);bb.buildBlock(-3,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-2,Blocks.acacia_stairs,0);
		bb.buildBlock(-3,3,-1,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,0,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,1,Blocks.acacia_stairs,0);
		bb.buildBlock(-3,3,2,Blocks.acacia_stairs,0);bb.buildBlock(-3,3,3,Blocks.acacia_stairs,0);bb.buildBlock(-2,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,3,-2,Blocks.planks,4);bb.buildBlock(-2,3,-1,Blocks.planks,4);bb.buildBlock(-2,3,0,Blocks.planks,4);
		bb.buildBlock(-2,3,1,Blocks.planks,4);bb.buildBlock(-2,3,2,Blocks.planks,4);bb.buildBlock(-2,3,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(-1,3,-2,Blocks.planks,4);bb.buildBlock(-1,3,-1,Blocks.planks,1);
		bb.buildBlock(-1,3,0,Blocks.planks,1);bb.buildBlock(-1,3,1,Blocks.planks,1);bb.buildBlock(-1,3,2,Blocks.planks,4);
		bb.buildBlock(-1,3,3,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(0,3,-2,Blocks.planks,4);
		bb.buildBlock(0,3,-1,Blocks.planks,1);bb.buildBlock(0,3,0,Blocks.planks,1);bb.buildBlock(0,3,1,Blocks.planks,1);
		bb.buildBlock(0,3,2,Blocks.planks,4);bb.buildBlock(0,3,3,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(1,3,-2,Blocks.planks,4);bb.buildBlock(1,3,-1,Blocks.planks,1);bb.buildBlock(1,3,0,Blocks.planks,1);
		bb.buildBlock(1,3,1,Blocks.planks,1);bb.buildBlock(1,3,2,Blocks.planks,4);bb.buildBlock(1,3,3,Blocks.acacia_stairs,3);
		bb.buildBlock(2,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(2,3,-2,Blocks.planks,4);bb.buildBlock(2,3,-1,Blocks.planks,4);
		bb.buildBlock(2,3,0,Blocks.planks,4);bb.buildBlock(2,3,1,Blocks.planks,4);bb.buildBlock(2,3,2,Blocks.planks,4);
		bb.buildBlock(2,3,3,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-3,Blocks.acacia_stairs,2);bb.buildBlock(3,3,-2,Blocks.acacia_stairs,1);
		bb.buildBlock(3,3,-1,Blocks.acacia_stairs,1);bb.buildBlock(3,3,0,Blocks.acacia_stairs,1);bb.buildBlock(3,3,1,Blocks.acacia_stairs,1);
		bb.buildBlock(3,3,2,Blocks.acacia_stairs,1);bb.buildBlock(3,3,3,Blocks.acacia_stairs,3);bb.buildBlock(-2,2,-1,Blocks.torch,4);
		bb.buildBlock(-2,2,2,Blocks.torch,1);bb.buildBlock(2,2,-1,Blocks.torch,4);bb.buildBlock(2,2,2,Blocks.torch,2);
		bb.addEntityPainting(0,2,0,2,"Sunset");
	}




}
