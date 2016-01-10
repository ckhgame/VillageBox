package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionSoldier;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class BuildingSmallMilitaryCamp extends Building {

	@Override
	public String getName() {
		return "Small Military Camp";
	}

	@Override
	public String getDescription() {
		return "A place for Armies.";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionSoldier.class,1,-2);
		bb.addVillager(ProfessionSoldier.class,1,2);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-5,0,-5,Blocks.planks,1);bb.buildBlock(-5,0,5,Blocks.planks,1);bb.buildBlock(-4,0,-4,Blocks.planks,1);
		bb.buildBlock(-4,0,-3,Blocks.planks,1);bb.buildBlock(-4,0,-2,Blocks.planks,1);bb.buildBlock(-4,0,-1,Blocks.planks,1);
		bb.buildBlock(-4,0,0,Blocks.planks,1);bb.buildBlock(-4,0,1,Blocks.planks,1);bb.buildBlock(-4,0,2,Blocks.planks,1);
		bb.buildBlock(-4,0,3,Blocks.planks,1);bb.buildBlock(-4,0,4,Blocks.planks,1);bb.buildBlock(-3,0,-4,Blocks.planks,1);
		bb.buildBlock(-3,0,-3,Blocks.bed,9);bb.buildBlock(-3,0,-1,Blocks.bookshelf,0);bb.buildBlock(-3,0,0,Blocks.planks,1);
		bb.buildBlock(-3,0,1,Blocks.bookshelf,0);bb.buildBlock(-3,0,3,Blocks.bed,9);bb.buildBlock(-3,0,4,Blocks.planks,1);
		bb.buildBlock(-2,0,-4,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.bed,1);bb.buildBlock(-2,0,0,Blocks.planks,1);
		bb.buildBlock(-2,0,3,Blocks.bed,1);bb.buildBlock(-2,0,4,Blocks.planks,1);bb.buildBlock(-1,0,-4,Blocks.planks,1);
		bb.buildBlock(-1,0,0,Blocks.planks,1);bb.buildBlock(-1,0,4,Blocks.planks,1);bb.buildBlock(0,0,-4,Blocks.planks,1);
		bb.buildBlock(0,0,-3,Blocks.planks,1);bb.buildBlock(0,0,-2,Blocks.wooden_door,2);bb.buildBlock(0,0,-1,Blocks.planks,1);
		bb.buildBlock(0,0,0,Blocks.planks,1);bb.buildBlock(0,0,1,Blocks.planks,1);bb.buildBlock(0,0,2,Blocks.wooden_door,2);
		bb.buildBlock(0,0,3,Blocks.planks,1);bb.buildBlock(0,0,4,Blocks.planks,1);bb.buildBlock(1,0,-4,Blocks.planks,1);
		bb.buildBlock(1,0,-3,Blocks.planks,1);bb.buildBlock(1,0,3,Blocks.planks,1);bb.buildBlock(1,0,4,Blocks.planks,1);
		bb.buildBlock(2,0,-4,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.planks,1);bb.buildBlock(2,0,3,Blocks.planks,1);
		bb.buildBlock(2,0,4,Blocks.planks,1);bb.buildBlock(3,0,-4,Blocks.planks,1);bb.buildBlock(3,0,-3,Blocks.planks,1);
		bb.buildBlock(3,0,0,Blocks.planks,1);bb.buildBlock(3,0,3,Blocks.planks,1);bb.buildBlock(3,0,4,Blocks.planks,1);
		bb.buildBlock(4,0,-4,Blocks.planks,1);bb.buildBlock(4,0,-3,Blocks.planks,1);bb.buildBlock(4,0,-2,Blocks.wooden_door,2);
		bb.buildBlock(4,0,-1,Blocks.planks,1);bb.buildBlock(4,0,0,Blocks.planks,1);bb.buildBlock(4,0,1,Blocks.planks,1);
		bb.buildBlock(4,0,2,Blocks.wooden_door,2);bb.buildBlock(4,0,3,Blocks.planks,1);bb.buildBlock(4,0,4,Blocks.planks,1);
		bb.buildBlock(5,0,-5,Blocks.planks,1);bb.buildBlock(5,0,5,Blocks.planks,1);bb.buildBlock(-5,1,-5,Blocks.planks,1);
		bb.buildBlock(-5,1,5,Blocks.planks,1);bb.buildBlock(-4,1,-4,Blocks.planks,1);bb.buildBlock(-4,1,-3,Blocks.planks,1);
		bb.buildBlock(-4,1,-2,Blocks.glass_pane,0);bb.buildBlock(-4,1,-1,Blocks.planks,1);bb.buildBlock(-4,1,0,Blocks.planks,1);
		bb.buildBlock(-4,1,1,Blocks.planks,1);bb.buildBlock(-4,1,2,Blocks.glass_pane,0);bb.buildBlock(-4,1,3,Blocks.planks,1);
		bb.buildBlock(-4,1,4,Blocks.planks,1);bb.buildBlock(-3,1,-4,Blocks.planks,1);bb.buildBlock(-3,1,-1,Blocks.chest,5);
		bb.buildBlock(-3,1,0,Blocks.planks,1);bb.buildBlock(-3,1,1,Blocks.chest,5);bb.buildBlock(-3,1,4,Blocks.planks,1);bb.buildBlock(-2,1,-4,Blocks.planks,1);bb.buildBlock(-2,1,0,Blocks.planks,1);
		bb.buildBlock(-2,1,4,Blocks.planks,1);bb.buildBlock(-1,1,-4,Blocks.planks,1);bb.buildBlock(-1,1,0,Blocks.planks,1);
		bb.buildBlock(-1,1,4,Blocks.planks,1);bb.buildBlock(0,1,-4,Blocks.planks,1);bb.buildBlock(0,1,-3,Blocks.planks,1);
		bb.buildBlock(0,1,-2,Blocks.wooden_door,8);bb.buildBlock(0,1,-1,Blocks.planks,1);bb.buildBlock(0,1,0,Blocks.planks,1);
		bb.buildBlock(0,1,1,Blocks.planks,1);bb.buildBlock(0,1,2,Blocks.wooden_door,8);bb.buildBlock(0,1,3,Blocks.planks,1);
		bb.buildBlock(0,1,4,Blocks.planks,1);bb.buildBlock(1,1,-4,Blocks.glass_pane,0);bb.buildBlock(1,1,4,Blocks.glass_pane,0);
		bb.buildBlock(2,1,-4,Blocks.planks,1);bb.buildBlock(2,1,4,Blocks.planks,1);bb.buildBlock(3,1,-4,Blocks.planks,1);
		bb.buildBlock(3,1,0,Blocks.chest,4);bb.buildBlock(3,1,4,Blocks.planks,1);bb.buildBlock(4,1,-4,Blocks.planks,1);bb.buildBlock(4,1,-3,Blocks.planks,1);
		bb.buildBlock(4,1,-2,Blocks.wooden_door,8);bb.buildBlock(4,1,-1,Blocks.planks,1);bb.buildBlock(4,1,0,Blocks.planks,1);
		bb.buildBlock(4,1,1,Blocks.planks,1);bb.buildBlock(4,1,2,Blocks.wooden_door,8);bb.buildBlock(4,1,3,Blocks.planks,1);
		bb.buildBlock(4,1,4,Blocks.planks,1);bb.buildBlock(5,1,-5,Blocks.planks,1);bb.buildBlock(5,1,5,Blocks.planks,1);
		bb.buildBlock(-5,2,-5,Blocks.planks,1);bb.buildBlock(-5,2,5,Blocks.planks,1);bb.buildBlock(-4,2,-4,Blocks.planks,1);
		bb.buildBlock(-4,2,-3,Blocks.planks,1);bb.buildBlock(-4,2,-2,Blocks.glass_pane,0);bb.buildBlock(-4,2,-1,Blocks.planks,1);
		bb.buildBlock(-4,2,0,Blocks.planks,1);bb.buildBlock(-4,2,1,Blocks.planks,1);bb.buildBlock(-4,2,2,Blocks.glass_pane,0);
		bb.buildBlock(-4,2,3,Blocks.planks,1);bb.buildBlock(-4,2,4,Blocks.planks,1);bb.buildBlock(-3,2,-4,Blocks.planks,1);
		bb.buildBlock(-3,2,0,Blocks.planks,1);bb.buildBlock(-3,2,4,Blocks.planks,1);bb.buildBlock(-2,2,-4,Blocks.planks,1);
		bb.buildBlock(-2,2,0,Blocks.planks,1);bb.buildBlock(-2,2,4,Blocks.planks,1);bb.buildBlock(-1,2,-4,Blocks.planks,1);
		bb.buildBlock(-1,2,0,Blocks.planks,1);bb.buildBlock(-1,2,4,Blocks.planks,1);bb.buildBlock(0,2,-4,Blocks.planks,1);
		bb.buildBlock(0,2,-3,Blocks.planks,1);bb.buildBlock(0,2,-2,Blocks.planks,1);bb.buildBlock(0,2,-1,Blocks.planks,1);
		bb.buildBlock(0,2,0,Blocks.planks,1);bb.buildBlock(0,2,1,Blocks.planks,1);bb.buildBlock(0,2,2,Blocks.planks,1);
		bb.buildBlock(0,2,3,Blocks.planks,1);bb.buildBlock(0,2,4,Blocks.planks,1);bb.buildBlock(1,2,-4,Blocks.glass_pane,0);
		bb.buildBlock(1,2,4,Blocks.glass_pane,0);bb.buildBlock(2,2,-4,Blocks.planks,1);bb.buildBlock(2,2,4,Blocks.planks,1);
		bb.buildBlock(3,2,-4,Blocks.planks,1);bb.buildBlock(3,2,4,Blocks.planks,1);bb.buildBlock(4,2,-4,Blocks.planks,1);
		bb.buildBlock(4,2,-3,Blocks.planks,1);bb.buildBlock(4,2,-2,Blocks.planks,1);bb.buildBlock(4,2,-1,Blocks.planks,1);
		bb.buildBlock(4,2,0,Blocks.planks,1);bb.buildBlock(4,2,1,Blocks.planks,1);bb.buildBlock(4,2,2,Blocks.planks,1);
		bb.buildBlock(4,2,3,Blocks.planks,1);bb.buildBlock(4,2,4,Blocks.planks,1);bb.buildBlock(5,2,-5,Blocks.planks,1);
		bb.buildBlock(5,2,5,Blocks.planks,1);bb.buildBlock(-5,3,-5,Blocks.planks,4);bb.buildBlock(-5,3,5,Blocks.planks,4);
		bb.buildBlock(-4,3,-4,Blocks.planks,4);bb.buildBlock(-4,3,-3,Blocks.planks,4);bb.buildBlock(-4,3,-2,Blocks.planks,4);
		bb.buildBlock(-4,3,-1,Blocks.planks,4);bb.buildBlock(-4,3,0,Blocks.planks,4);bb.buildBlock(-4,3,1,Blocks.planks,4);
		bb.buildBlock(-4,3,2,Blocks.planks,4);bb.buildBlock(-4,3,3,Blocks.planks,4);bb.buildBlock(-4,3,4,Blocks.planks,4);
		bb.buildBlock(-3,3,-4,Blocks.planks,4);bb.buildBlock(-3,3,-3,Blocks.planks,4);bb.buildBlock(-3,3,-2,Blocks.planks,4);
		bb.buildBlock(-3,3,-1,Blocks.planks,4);bb.buildBlock(-3,3,0,Blocks.planks,4);bb.buildBlock(-3,3,1,Blocks.planks,4);
		bb.buildBlock(-3,3,2,Blocks.planks,4);bb.buildBlock(-3,3,3,Blocks.planks,4);bb.buildBlock(-3,3,4,Blocks.planks,4);
		bb.buildBlock(-2,3,-4,Blocks.planks,4);bb.buildBlock(-2,3,-3,Blocks.planks,4);bb.buildBlock(-2,3,-2,Blocks.planks,1);
		bb.buildBlock(-2,3,-1,Blocks.planks,4);bb.buildBlock(-2,3,0,Blocks.planks,1);bb.buildBlock(-2,3,1,Blocks.planks,4);
		bb.buildBlock(-2,3,2,Blocks.planks,1);bb.buildBlock(-2,3,3,Blocks.planks,4);bb.buildBlock(-2,3,4,Blocks.planks,4);
		bb.buildBlock(-1,3,-4,Blocks.planks,4);bb.buildBlock(-1,3,-3,Blocks.planks,4);bb.buildBlock(-1,3,-2,Blocks.planks,4);
		bb.buildBlock(-1,3,-1,Blocks.planks,1);bb.buildBlock(-1,3,0,Blocks.planks,1);bb.buildBlock(-1,3,1,Blocks.planks,1);
		bb.buildBlock(-1,3,2,Blocks.planks,4);bb.buildBlock(-1,3,3,Blocks.planks,4);bb.buildBlock(-1,3,4,Blocks.planks,4);
		bb.buildBlock(0,3,-4,Blocks.planks,4);bb.buildBlock(0,3,-3,Blocks.planks,4);bb.buildBlock(0,3,-2,Blocks.planks,1);
		bb.buildBlock(0,3,-1,Blocks.planks,1);bb.buildBlock(0,3,0,Blocks.planks,1);bb.buildBlock(0,3,1,Blocks.planks,1);
		bb.buildBlock(0,3,2,Blocks.planks,1);bb.buildBlock(0,3,3,Blocks.planks,4);bb.buildBlock(0,3,4,Blocks.planks,4);
		bb.buildBlock(1,3,-4,Blocks.planks,4);bb.buildBlock(1,3,-3,Blocks.planks,4);bb.buildBlock(1,3,-2,Blocks.planks,4);
		bb.buildBlock(1,3,-1,Blocks.planks,1);bb.buildBlock(1,3,0,Blocks.planks,1);bb.buildBlock(1,3,1,Blocks.planks,1);
		bb.buildBlock(1,3,2,Blocks.planks,4);bb.buildBlock(1,3,3,Blocks.planks,4);bb.buildBlock(1,3,4,Blocks.planks,4);
		bb.buildBlock(2,3,-4,Blocks.planks,4);bb.buildBlock(2,3,-3,Blocks.planks,4);bb.buildBlock(2,3,-2,Blocks.planks,1);
		bb.buildBlock(2,3,-1,Blocks.planks,4);bb.buildBlock(2,3,0,Blocks.planks,1);bb.buildBlock(2,3,1,Blocks.planks,4);
		bb.buildBlock(2,3,2,Blocks.planks,1);bb.buildBlock(2,3,3,Blocks.planks,4);bb.buildBlock(2,3,4,Blocks.planks,4);
		bb.buildBlock(3,3,-4,Blocks.planks,4);bb.buildBlock(3,3,-3,Blocks.planks,4);bb.buildBlock(3,3,-2,Blocks.planks,4);
		bb.buildBlock(3,3,-1,Blocks.planks,4);bb.buildBlock(3,3,0,Blocks.planks,4);bb.buildBlock(3,3,1,Blocks.planks,4);
		bb.buildBlock(3,3,2,Blocks.planks,4);bb.buildBlock(3,3,3,Blocks.planks,4);bb.buildBlock(3,3,4,Blocks.planks,4);
		bb.buildBlock(4,3,-4,Blocks.planks,4);bb.buildBlock(4,3,-3,Blocks.planks,4);bb.buildBlock(4,3,-2,Blocks.planks,4);
		bb.buildBlock(4,3,-1,Blocks.planks,4);bb.buildBlock(4,3,0,Blocks.planks,4);bb.buildBlock(4,3,1,Blocks.planks,4);
		bb.buildBlock(4,3,2,Blocks.planks,4);bb.buildBlock(4,3,3,Blocks.planks,4);bb.buildBlock(4,3,4,Blocks.planks,4);
		bb.buildBlock(5,3,-5,Blocks.planks,4);bb.buildBlock(5,3,5,Blocks.planks,4);bb.buildBlock(-2,2,-1,Blocks.torch,4);
		bb.buildBlock(-2,2,1,Blocks.torch,3);bb.buildBlock(2,2,-3,Blocks.torch,3);bb.buildBlock(2,2,3,Blocks.torch,4);
		bb.addEntityPainting(0,1,0,3,"Aztec2");
		bb.addEntityItemFrame(2,1,-4,0,Items.iron_chestplate);
		bb.addEntityItemFrame(2,1,4,2,Items.iron_sword);
		bb.addEntityItemFrame(4,1,0,3,ModBlocks.blockSmallMilitaryCamp);
	}

}
