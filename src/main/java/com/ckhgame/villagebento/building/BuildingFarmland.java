package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionFarmer;
import com.ckhgame.villagebento.profession.ProfessionFarmerSmall;

import net.minecraft.init.Blocks;

public class BuildingFarmland extends Building {

	@Override
	public String getName() {
		return "Farm Land";
	}

	@Override
	public String getDescription() {
		return "Grow the Crops";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionFarmer.class,0,0 );
		bb.addVillager(ProfessionFarmerSmall.class,0,1 );
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Large;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-7,-1,-7,Blocks.grass,0);bb.buildBlock(-7,-1,-6,Blocks.grass,0);bb.buildBlock(-7,-1,-5,Blocks.grass,0);
		bb.buildBlock(-7,-1,-4,Blocks.grass,0);bb.buildBlock(-7,-1,-3,Blocks.grass,0);bb.buildBlock(-7,-1,-2,Blocks.grass,0);
		bb.buildBlock(-7,-1,-1,Blocks.grass,0);bb.buildBlock(-7,-1,0,Blocks.grass,0);bb.buildBlock(-7,-1,1,Blocks.grass,0);
		bb.buildBlock(-7,-1,2,Blocks.grass,0);bb.buildBlock(-7,-1,3,Blocks.grass,0);bb.buildBlock(-7,-1,4,Blocks.grass,0);
		bb.buildBlock(-7,-1,5,Blocks.grass,0);bb.buildBlock(-7,-1,6,Blocks.grass,0);bb.buildBlock(-7,-1,7,Blocks.grass,0);
		bb.buildBlock(-6,-1,-7,Blocks.grass,0);bb.buildBlock(-6,-1,-6,Blocks.planks,2);bb.buildBlock(-6,-1,-5,Blocks.planks,2);
		bb.buildBlock(-6,-1,-4,Blocks.planks,2);bb.buildBlock(-6,-1,-3,Blocks.planks,2);bb.buildBlock(-6,-1,-2,Blocks.dirt,0);
		bb.buildBlock(-6,-1,-1,Blocks.grass,0);bb.buildBlock(-6,-1,0,Blocks.grass,0);bb.buildBlock(-6,-1,1,Blocks.grass,0);
		bb.buildBlock(-6,-1,2,Blocks.grass,0);bb.buildBlock(-6,-1,3,Blocks.grass,0);bb.buildBlock(-6,-1,4,Blocks.grass,0);
		bb.buildBlock(-6,-1,5,Blocks.grass,0);bb.buildBlock(-6,-1,6,Blocks.grass,0);bb.buildBlock(-6,-1,7,Blocks.grass,0);
		bb.buildBlock(-5,-1,-7,Blocks.grass,0);bb.buildBlock(-5,-1,-6,Blocks.planks,2);bb.buildBlock(-5,-1,-5,Blocks.planks,2);
		bb.buildBlock(-5,-1,-4,Blocks.planks,2);bb.buildBlock(-5,-1,-3,Blocks.planks,2);bb.buildBlock(-5,-1,-2,Blocks.dirt,0);
		bb.buildBlock(-5,-1,-1,Blocks.grass,0);bb.buildBlock(-5,-1,0,Blocks.grass,0);bb.buildBlock(-5,-1,1,Blocks.grass,0);
		bb.buildBlock(-5,-1,2,Blocks.farmland,7);bb.buildBlock(-5,-1,3,Blocks.farmland,7);bb.buildBlock(-5,-1,4,Blocks.farmland,7);
		bb.buildBlock(-5,-1,5,Blocks.farmland,7);bb.buildBlock(-5,-1,6,Blocks.grass,0);bb.buildBlock(-5,-1,7,Blocks.grass,0);
		bb.buildBlock(-4,-1,-7,Blocks.grass,0);bb.buildBlock(-4,-1,-6,Blocks.planks,2);bb.buildBlock(-4,-1,-5,Blocks.planks,2);
		bb.buildBlock(-4,-1,-4,Blocks.planks,2);bb.buildBlock(-4,-1,-3,Blocks.planks,2);bb.buildBlock(-4,-1,-2,Blocks.planks,2);
		bb.buildBlock(-4,-1,-1,Blocks.grass,0);bb.buildBlock(-4,-1,0,Blocks.grass,0);bb.buildBlock(-4,-1,1,Blocks.grass,0);
		bb.buildBlock(-4,-1,2,Blocks.water,0);bb.buildBlock(-4,-1,3,Blocks.water,0);bb.buildBlock(-4,-1,4,Blocks.lit_pumpkin,2);
		bb.buildBlock(-4,-1,5,Blocks.water,0);bb.buildBlock(-4,-1,6,Blocks.grass,0);bb.buildBlock(-4,-1,7,Blocks.grass,0);
		bb.buildBlock(-3,-1,-7,Blocks.grass,0);bb.buildBlock(-3,-1,-6,Blocks.planks,2);bb.buildBlock(-3,-1,-5,Blocks.planks,2);
		bb.buildBlock(-3,-1,-4,Blocks.planks,2);bb.buildBlock(-3,-1,-3,Blocks.planks,2);bb.buildBlock(-3,-1,-2,Blocks.planks,2);
		bb.buildBlock(-3,-1,-1,Blocks.grass,0);bb.buildBlock(-3,-1,0,Blocks.grass,0);bb.buildBlock(-3,-1,1,Blocks.grass,0);
		bb.buildBlock(-3,-1,2,Blocks.farmland,7);bb.buildBlock(-3,-1,3,Blocks.farmland,7);bb.buildBlock(-3,-1,4,Blocks.farmland,7);
		bb.buildBlock(-3,-1,5,Blocks.farmland,7);bb.buildBlock(-3,-1,6,Blocks.grass,0);bb.buildBlock(-3,-1,7,Blocks.grass,0);
		bb.buildBlock(-2,-1,-7,Blocks.grass,0);bb.buildBlock(-2,-1,-6,Blocks.planks,2);bb.buildBlock(-2,-1,-5,Blocks.planks,2);
		bb.buildBlock(-2,-1,-4,Blocks.planks,2);bb.buildBlock(-2,-1,-3,Blocks.planks,2);bb.buildBlock(-2,-1,-2,Blocks.dirt,0);
		bb.buildBlock(-2,-1,-1,Blocks.grass,0);bb.buildBlock(-2,-1,0,Blocks.grass,0);bb.buildBlock(-2,-1,1,Blocks.grass,0);
		bb.buildBlock(-2,-1,2,Blocks.water,0);bb.buildBlock(-2,-1,3,Blocks.lit_pumpkin,2);bb.buildBlock(-2,-1,4,Blocks.water,0);
		bb.buildBlock(-2,-1,5,Blocks.water,0);bb.buildBlock(-2,-1,6,Blocks.grass,0);bb.buildBlock(-2,-1,7,Blocks.grass,0);
		bb.buildBlock(-1,-1,-7,Blocks.grass,0);bb.buildBlock(-1,-1,-6,Blocks.planks,2);bb.buildBlock(-1,-1,-5,Blocks.planks,2);
		bb.buildBlock(-1,-1,-4,Blocks.planks,2);bb.buildBlock(-1,-1,-3,Blocks.planks,2);bb.buildBlock(-1,-1,-2,Blocks.planks,2);
		bb.buildBlock(-1,-1,-1,Blocks.grass,0);bb.buildBlock(-1,-1,0,Blocks.grass,0);bb.buildBlock(-1,-1,1,Blocks.grass,0);
		bb.buildBlock(-1,-1,2,Blocks.farmland,7);bb.buildBlock(-1,-1,3,Blocks.farmland,7);bb.buildBlock(-1,-1,4,Blocks.farmland,7);
		bb.buildBlock(-1,-1,5,Blocks.farmland,7);bb.buildBlock(-1,-1,6,Blocks.grass,0);bb.buildBlock(-1,-1,7,Blocks.grass,0);
		bb.buildBlock(0,-1,-7,Blocks.planks,2);bb.buildBlock(0,-1,-6,Blocks.planks,2);bb.buildBlock(0,-1,-5,Blocks.planks,2);
		bb.buildBlock(0,-1,-4,Blocks.planks,2);bb.buildBlock(0,-1,-3,Blocks.planks,2);bb.buildBlock(0,-1,-2,Blocks.dirt,0);
		bb.buildBlock(0,-1,-1,Blocks.grass,0);bb.buildBlock(0,-1,0,Blocks.grass,0);bb.buildBlock(0,-1,1,Blocks.grass,0);
		bb.buildBlock(0,-1,2,Blocks.water,0);bb.buildBlock(0,-1,3,Blocks.water,0);bb.buildBlock(0,-1,4,Blocks.lit_pumpkin,2);
		bb.buildBlock(0,-1,5,Blocks.water,0);bb.buildBlock(0,-1,6,Blocks.grass,0);bb.buildBlock(0,-1,7,Blocks.grass,0);
		bb.buildBlock(1,-1,-7,Blocks.planks,2);bb.buildBlock(1,-1,-6,Blocks.planks,2);bb.buildBlock(1,-1,-5,Blocks.planks,2);
		bb.buildBlock(1,-1,-4,Blocks.planks,2);bb.buildBlock(1,-1,-3,Blocks.planks,2);bb.buildBlock(1,-1,-2,Blocks.planks,2);
		bb.buildBlock(1,-1,-1,Blocks.grass,0);bb.buildBlock(1,-1,0,Blocks.grass,0);bb.buildBlock(1,-1,1,Blocks.grass,0);
		bb.buildBlock(1,-1,2,Blocks.farmland,7);bb.buildBlock(1,-1,3,Blocks.farmland,7);bb.buildBlock(1,-1,4,Blocks.farmland,7);
		bb.buildBlock(1,-1,5,Blocks.farmland,7);bb.buildBlock(1,-1,6,Blocks.grass,0);bb.buildBlock(1,-1,7,Blocks.grass,0);
		bb.buildBlock(2,-1,-7,Blocks.planks,2);bb.buildBlock(2,-1,-6,Blocks.planks,2);bb.buildBlock(2,-1,-5,Blocks.planks,2);
		bb.buildBlock(2,-1,-4,Blocks.planks,2);bb.buildBlock(2,-1,-3,Blocks.planks,2);bb.buildBlock(2,-1,-2,Blocks.planks,2);
		bb.buildBlock(2,-1,-1,Blocks.grass,0);bb.buildBlock(2,-1,0,Blocks.grass,0);bb.buildBlock(2,-1,1,Blocks.grass,0);
		bb.buildBlock(2,-1,2,Blocks.water,0);bb.buildBlock(2,-1,3,Blocks.lit_pumpkin,2);bb.buildBlock(2,-1,4,Blocks.water,0);
		bb.buildBlock(2,-1,5,Blocks.water,0);bb.buildBlock(2,-1,6,Blocks.grass,0);bb.buildBlock(2,-1,7,Blocks.grass,0);
		bb.buildBlock(3,-1,-7,Blocks.planks,2);bb.buildBlock(3,-1,-6,Blocks.planks,2);bb.buildBlock(3,-1,-5,Blocks.planks,2);
		bb.buildBlock(3,-1,-4,Blocks.planks,2);bb.buildBlock(3,-1,-3,Blocks.planks,2);bb.buildBlock(3,-1,-2,Blocks.planks,2);
		bb.buildBlock(3,-1,-1,Blocks.grass,0);bb.buildBlock(3,-1,0,Blocks.grass,0);bb.buildBlock(3,-1,1,Blocks.grass,0);
		bb.buildBlock(3,-1,2,Blocks.farmland,7);bb.buildBlock(3,-1,3,Blocks.farmland,7);bb.buildBlock(3,-1,4,Blocks.farmland,7);
		bb.buildBlock(3,-1,5,Blocks.farmland,7);bb.buildBlock(3,-1,6,Blocks.grass,0);bb.buildBlock(3,-1,7,Blocks.grass,0);
		bb.buildBlock(4,-1,-7,Blocks.planks,2);bb.buildBlock(4,-1,-6,Blocks.planks,2);bb.buildBlock(4,-1,-5,Blocks.planks,2);
		bb.buildBlock(4,-1,-4,Blocks.planks,2);bb.buildBlock(4,-1,-3,Blocks.planks,2);bb.buildBlock(4,-1,-2,Blocks.planks,2);
		bb.buildBlock(4,-1,-1,Blocks.grass,0);bb.buildBlock(4,-1,0,Blocks.grass,0);bb.buildBlock(4,-1,1,Blocks.grass,0);
		bb.buildBlock(4,-1,2,Blocks.water,0);bb.buildBlock(4,-1,3,Blocks.water,0);bb.buildBlock(4,-1,4,Blocks.lit_pumpkin,2);
		bb.buildBlock(4,-1,5,Blocks.water,0);bb.buildBlock(4,-1,6,Blocks.grass,0);bb.buildBlock(4,-1,7,Blocks.grass,0);
		bb.buildBlock(5,-1,-7,Blocks.planks,2);bb.buildBlock(5,-1,-6,Blocks.planks,2);bb.buildBlock(5,-1,-5,Blocks.planks,2);
		bb.buildBlock(5,-1,-4,Blocks.planks,2);bb.buildBlock(5,-1,-3,Blocks.planks,2);bb.buildBlock(5,-1,-2,Blocks.planks,2);
		bb.buildBlock(5,-1,-1,Blocks.grass,0);bb.buildBlock(5,-1,0,Blocks.grass,0);bb.buildBlock(5,-1,1,Blocks.grass,0);
		bb.buildBlock(5,-1,2,Blocks.farmland,7);bb.buildBlock(5,-1,3,Blocks.farmland,7);bb.buildBlock(5,-1,4,Blocks.farmland,7);
		bb.buildBlock(5,-1,5,Blocks.farmland,7);bb.buildBlock(5,-1,6,Blocks.grass,0);bb.buildBlock(5,-1,7,Blocks.grass,0);
		bb.buildBlock(6,-1,-7,Blocks.planks,2);bb.buildBlock(6,-1,-6,Blocks.planks,2);bb.buildBlock(6,-1,-5,Blocks.planks,2);
		bb.buildBlock(6,-1,-4,Blocks.planks,2);bb.buildBlock(6,-1,-3,Blocks.planks,2);bb.buildBlock(6,-1,-2,Blocks.planks,2);
		bb.buildBlock(6,-1,-1,Blocks.planks,2);bb.buildBlock(6,-1,0,Blocks.grass,0);bb.buildBlock(6,-1,1,Blocks.grass,0);
		bb.buildBlock(6,-1,2,Blocks.grass,0);bb.buildBlock(6,-1,3,Blocks.grass,0);bb.buildBlock(6,-1,4,Blocks.grass,0);
		bb.buildBlock(6,-1,5,Blocks.grass,0);bb.buildBlock(6,-1,6,Blocks.grass,0);bb.buildBlock(6,-1,7,Blocks.grass,0);
		bb.buildBlock(7,-1,-7,Blocks.planks,2);bb.buildBlock(7,-1,-6,Blocks.planks,2);bb.buildBlock(7,-1,-5,Blocks.planks,2);
		bb.buildBlock(7,-1,-4,Blocks.planks,2);bb.buildBlock(7,-1,-3,Blocks.planks,2);bb.buildBlock(7,-1,-2,Blocks.planks,2);
		bb.buildBlock(7,-1,-1,Blocks.planks,2);bb.buildBlock(7,-1,0,Blocks.grass,0);bb.buildBlock(7,-1,1,Blocks.grass,0);
		bb.buildBlock(7,-1,2,Blocks.grass,0);bb.buildBlock(7,-1,3,Blocks.grass,0);bb.buildBlock(7,-1,4,Blocks.grass,0);
		bb.buildBlock(7,-1,5,Blocks.grass,0);bb.buildBlock(7,-1,6,Blocks.grass,0);bb.buildBlock(7,-1,7,Blocks.grass,0);
		bb.buildBlock(-7,0,-2,Blocks.fence,0);bb.buildBlock(-7,0,-1,Blocks.fence,0);bb.buildBlock(-7,0,0,Blocks.fence,0);
		bb.buildBlock(-7,0,1,Blocks.fence,0);bb.buildBlock(-7,0,2,Blocks.fence,0);bb.buildBlock(-7,0,3,Blocks.fence,0);
		bb.buildBlock(-7,0,4,Blocks.fence,0);bb.buildBlock(-7,0,5,Blocks.fence,0);bb.buildBlock(-7,0,6,Blocks.fence,0);
		bb.buildBlock(-7,0,7,Blocks.fence,0);bb.buildBlock(-6,0,-6,Blocks.planks,1);bb.buildBlock(-6,0,-5,Blocks.planks,1);
		bb.buildBlock(-6,0,-4,Blocks.planks,1);bb.buildBlock(-6,0,-3,Blocks.planks,1);bb.buildBlock(-6,0,-2,Blocks.planks,1);
		bb.buildBlock(-6,0,1,Blocks.fence,0);bb.buildBlock(-6,0,2,Blocks.fence,0);bb.buildBlock(-6,0,3,Blocks.fence,0);
		bb.buildBlock(-6,0,4,Blocks.fence,0);bb.buildBlock(-6,0,5,Blocks.fence,0);bb.buildBlock(-6,0,6,Blocks.fence,0);
		bb.buildBlock(-6,0,7,Blocks.fence,0);bb.buildBlock(-5,0,-6,Blocks.planks,1);bb.buildBlock(-5,0,-5,Blocks.bed,9);
		bb.buildBlock(-5,0,-4,Blocks.chest,5);bb.buildBlock(-5,0,-3,Blocks.bed,9);bb.buildBlock(-5,0,-2,Blocks.planks,1);bb.buildBlock(-5,0,1,Blocks.fence,0);
		bb.buildBlock(-5,0,2,Blocks.wheat,7);bb.buildBlock(-5,0,3,Blocks.wheat,7);bb.buildBlock(-5,0,4,Blocks.wheat,7);
		bb.buildBlock(-5,0,5,Blocks.wheat,7);bb.buildBlock(-5,0,6,Blocks.fence,0);bb.buildBlock(-5,0,7,Blocks.fence,0);
		bb.buildBlock(-4,0,-6,Blocks.planks,1);bb.buildBlock(-4,0,-5,Blocks.bed,1);bb.buildBlock(-4,0,-4,Blocks.carpet,14);
		bb.buildBlock(-4,0,-3,Blocks.bed,1);bb.buildBlock(-4,0,-2,Blocks.planks,1);bb.buildBlock(-4,0,1,Blocks.fence,0);
		bb.buildBlock(-4,0,6,Blocks.fence,0);bb.buildBlock(-4,0,7,Blocks.fence,0);bb.buildBlock(-3,0,-6,Blocks.planks,1);
		bb.buildBlock(-3,0,-5,Blocks.carpet,14);bb.buildBlock(-3,0,-4,Blocks.carpet,14);bb.buildBlock(-3,0,-3,Blocks.carpet,14);
		bb.buildBlock(-3,0,-2,Blocks.wooden_door,3);bb.buildBlock(-3,0,1,Blocks.fence,0);bb.buildBlock(-3,0,2,Blocks.wheat,7);
		bb.buildBlock(-3,0,3,Blocks.wheat,7);bb.buildBlock(-3,0,4,Blocks.wheat,7);bb.buildBlock(-3,0,5,Blocks.wheat,7);
		bb.buildBlock(-3,0,6,Blocks.fence,0);bb.buildBlock(-3,0,7,Blocks.fence,0);bb.buildBlock(-2,0,-6,Blocks.planks,1);
		bb.buildBlock(-2,0,-5,Blocks.carpet,14);bb.buildBlock(-2,0,-4,Blocks.carpet,14);bb.buildBlock(-2,0,-3,Blocks.carpet,14);
		bb.buildBlock(-2,0,-2,Blocks.planks,1);bb.buildBlock(-2,0,1,Blocks.fence,0);bb.buildBlock(-2,0,6,Blocks.fence,0);
		bb.buildBlock(-2,0,7,Blocks.fence,0);bb.buildBlock(-1,0,-6,Blocks.planks,1);bb.buildBlock(-1,0,-5,Blocks.carpet,14);
		bb.buildBlock(-1,0,-4,Blocks.planks,2);bb.buildBlock(-1,0,-3,Blocks.carpet,14);bb.buildBlock(-1,0,-2,Blocks.planks,1);
		bb.buildBlock(-1,0,1,Blocks.fence,0);bb.buildBlock(-1,0,2,Blocks.wheat,7);bb.buildBlock(-1,0,3,Blocks.wheat,7);
		bb.buildBlock(-1,0,4,Blocks.wheat,7);bb.buildBlock(-1,0,5,Blocks.wheat,7);bb.buildBlock(-1,0,6,Blocks.fence,0);
		bb.buildBlock(-1,0,7,Blocks.fence,0);bb.buildBlock(0,0,-6,Blocks.planks,1);bb.buildBlock(0,0,-5,Blocks.planks,2);
		bb.buildBlock(0,0,-4,Blocks.planks,2);bb.buildBlock(0,0,-3,Blocks.planks,2);bb.buildBlock(0,0,-2,Blocks.planks,1);
		bb.buildBlock(0,0,1,Blocks.fence,0);bb.buildBlock(0,0,6,Blocks.fence,0);bb.buildBlock(0,0,7,Blocks.fence,0);
		bb.buildBlock(1,0,-6,Blocks.planks,1);bb.buildBlock(1,0,-5,Blocks.pumpkin,3);bb.buildBlock(1,0,-4,Blocks.hay_block,4);
		bb.buildBlock(1,0,-3,Blocks.melon_block,0);bb.buildBlock(1,0,-2,Blocks.planks,1);bb.buildBlock(1,0,1,Blocks.fence,0);
		bb.buildBlock(1,0,2,Blocks.wheat,7);bb.buildBlock(1,0,3,Blocks.wheat,7);bb.buildBlock(1,0,4,Blocks.wheat,7);
		bb.buildBlock(1,0,5,Blocks.wheat,7);bb.buildBlock(1,0,6,Blocks.fence,0);bb.buildBlock(1,0,7,Blocks.fence,0);
		bb.buildBlock(2,0,-6,Blocks.planks,1);bb.buildBlock(2,0,-2,Blocks.planks,1);bb.buildBlock(2,0,1,Blocks.fence,0);
		bb.buildBlock(2,0,6,Blocks.fence,0);bb.buildBlock(2,0,7,Blocks.fence,0);bb.buildBlock(3,0,-6,Blocks.planks,1);
		bb.buildBlock(3,0,-5,Blocks.planks,0);bb.buildBlock(3,0,-4,Blocks.planks,0);bb.buildBlock(3,0,-2,Blocks.planks,1);
		bb.buildBlock(3,0,1,Blocks.fence,0);bb.buildBlock(3,0,2,Blocks.wheat,7);bb.buildBlock(3,0,3,Blocks.wheat,7);
		bb.buildBlock(3,0,4,Blocks.wheat,7);bb.buildBlock(3,0,5,Blocks.wheat,7);bb.buildBlock(3,0,6,Blocks.fence,0);
		bb.buildBlock(3,0,7,Blocks.fence,0);bb.buildBlock(4,0,-6,Blocks.planks,1);bb.buildBlock(4,0,-2,Blocks.wooden_door,3);
		bb.buildBlock(4,0,6,Blocks.fence,0);bb.buildBlock(4,0,7,Blocks.fence,0);bb.buildBlock(5,0,-6,Blocks.planks,1);
		bb.buildBlock(5,0,-2,Blocks.planks,1);bb.buildBlock(5,0,1,Blocks.fence,0);bb.buildBlock(5,0,2,Blocks.wheat,7);
		bb.buildBlock(5,0,3,Blocks.wheat,7);bb.buildBlock(5,0,4,Blocks.wheat,7);bb.buildBlock(5,0,5,Blocks.wheat,7);
		bb.buildBlock(5,0,6,Blocks.fence,0);bb.buildBlock(5,0,7,Blocks.fence,0);bb.buildBlock(6,0,-6,Blocks.planks,1);
		bb.buildBlock(6,0,-5,Blocks.wooden_door,6);bb.buildBlock(6,0,-4,Blocks.wooden_door,2);bb.buildBlock(6,0,-3,Blocks.planks,1);
		bb.buildBlock(6,0,-2,Blocks.planks,1);bb.buildBlock(6,0,1,Blocks.fence,0);bb.buildBlock(6,0,2,Blocks.fence,0);
		bb.buildBlock(6,0,3,Blocks.fence,0);bb.buildBlock(6,0,4,Blocks.fence,0);bb.buildBlock(6,0,5,Blocks.fence,0);
		bb.buildBlock(6,0,6,Blocks.fence,0);bb.buildBlock(6,0,7,Blocks.fence,0);bb.buildBlock(7,0,-2,Blocks.fence,0);
		bb.buildBlock(7,0,-1,Blocks.fence,0);bb.buildBlock(7,0,0,Blocks.fence,0);bb.buildBlock(7,0,1,Blocks.fence,0);
		bb.buildBlock(7,0,2,Blocks.fence,0);bb.buildBlock(7,0,3,Blocks.fence,0);bb.buildBlock(7,0,4,Blocks.fence,0);
		bb.buildBlock(7,0,5,Blocks.fence,0);bb.buildBlock(7,0,6,Blocks.fence,0);bb.buildBlock(7,0,7,Blocks.fence,0);
		bb.buildBlock(-6,1,-6,Blocks.planks,1);bb.buildBlock(-6,1,-5,Blocks.planks,1);bb.buildBlock(-6,1,-4,Blocks.planks,1);
		bb.buildBlock(-6,1,-3,Blocks.planks,1);bb.buildBlock(-6,1,-2,Blocks.planks,1);bb.buildBlock(-6,1,1,Blocks.fence,0);
		bb.buildBlock(-6,1,2,Blocks.fence,0);bb.buildBlock(-6,1,3,Blocks.fence,0);bb.buildBlock(-6,1,4,Blocks.fence,0);
		bb.buildBlock(-6,1,5,Blocks.fence,0);bb.buildBlock(-6,1,6,Blocks.fence,0);bb.buildBlock(-5,1,-6,Blocks.planks,1);
		bb.buildBlock(-5,1,-2,Blocks.planks,1);bb.buildBlock(-5,1,1,Blocks.fence,0);bb.buildBlock(-5,1,6,Blocks.fence,0);
		bb.buildBlock(-4,1,-6,Blocks.planks,1);bb.buildBlock(-4,1,-2,Blocks.planks,1);bb.buildBlock(-4,1,1,Blocks.fence,0);
		bb.buildBlock(-4,1,6,Blocks.fence,0);bb.buildBlock(-3,1,-6,Blocks.planks,1);bb.buildBlock(-3,1,-2,Blocks.wooden_door,9);
		bb.buildBlock(-3,1,1,Blocks.fence,0);bb.buildBlock(-3,1,6,Blocks.fence,0);bb.buildBlock(-2,1,-6,Blocks.planks,1);
		bb.buildBlock(-2,1,-2,Blocks.planks,1);bb.buildBlock(-2,1,1,Blocks.fence,0);bb.buildBlock(-2,1,6,Blocks.fence,0);
		bb.buildBlock(-1,1,-6,Blocks.planks,1);bb.buildBlock(-1,1,-4,Blocks.flower_pot,3);bb.addTileEntityPot(-1,1,-4,38,3);
		bb.buildBlock(-1,1,-2,Blocks.planks,1);bb.buildBlock(-1,1,1,Blocks.fence,0);bb.buildBlock(-1,1,6,Blocks.fence,0);
		bb.buildBlock(0,1,-6,Blocks.planks,1);bb.buildBlock(0,1,-5,Blocks.planks,2);bb.buildBlock(0,1,-4,Blocks.planks,2);
		bb.buildBlock(0,1,-3,Blocks.planks,2);bb.buildBlock(0,1,-2,Blocks.planks,1);bb.buildBlock(0,1,1,Blocks.fence,0);
		bb.buildBlock(0,1,6,Blocks.fence,0);bb.buildBlock(1,1,-6,Blocks.planks,1);bb.buildBlock(1,1,-2,Blocks.planks,1);
		bb.buildBlock(1,1,1,Blocks.fence,0);bb.buildBlock(1,1,6,Blocks.fence,0);bb.buildBlock(2,1,-6,Blocks.glass_pane,0);
		bb.buildBlock(2,1,-2,Blocks.planks,1);bb.buildBlock(2,1,1,Blocks.fence,0);bb.buildBlock(2,1,6,Blocks.fence,0);
		bb.buildBlock(3,1,-6,Blocks.glass_pane,0);bb.buildBlock(3,1,-2,Blocks.planks,1);bb.buildBlock(3,1,1,Blocks.fence,0);
		bb.buildBlock(3,1,6,Blocks.fence,0);bb.buildBlock(4,1,-6,Blocks.glass_pane,0);bb.buildBlock(4,1,-2,Blocks.wooden_door,8);
		bb.buildBlock(4,1,6,Blocks.fence,0);bb.buildBlock(5,1,-6,Blocks.planks,1);bb.buildBlock(5,1,-2,Blocks.planks,1);
		bb.buildBlock(5,1,1,Blocks.fence,0);bb.buildBlock(5,1,6,Blocks.fence,0);bb.buildBlock(6,1,-6,Blocks.planks,1);
		bb.buildBlock(6,1,-5,Blocks.wooden_door,9);bb.buildBlock(6,1,-4,Blocks.wooden_door,8);bb.buildBlock(6,1,-3,Blocks.planks,1);
		bb.buildBlock(6,1,-2,Blocks.planks,1);bb.buildBlock(6,1,1,Blocks.fence,0);bb.buildBlock(6,1,2,Blocks.fence,0);
		bb.buildBlock(6,1,3,Blocks.fence,0);bb.buildBlock(6,1,4,Blocks.fence,0);bb.buildBlock(6,1,5,Blocks.fence,0);
		bb.buildBlock(6,1,6,Blocks.fence,0);bb.buildBlock(-7,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(-7,2,-6,Blocks.acacia_stairs,7);
		bb.buildBlock(-7,2,-2,Blocks.acacia_stairs,6);bb.buildBlock(-7,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(-6,2,-7,Blocks.acacia_stairs,2);
		bb.buildBlock(-6,2,-6,Blocks.planks,1);bb.buildBlock(-6,2,-5,Blocks.planks,1);bb.buildBlock(-6,2,-4,Blocks.planks,1);
		bb.buildBlock(-6,2,-3,Blocks.planks,1);bb.buildBlock(-6,2,-2,Blocks.planks,1);bb.buildBlock(-6,2,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(-6,2,1,Blocks.fence,0);bb.buildBlock(-6,2,2,Blocks.fence,0);bb.buildBlock(-6,2,3,Blocks.fence,0);
		bb.buildBlock(-6,2,4,Blocks.fence,0);bb.buildBlock(-6,2,5,Blocks.fence,0);bb.buildBlock(-6,2,6,Blocks.fence,0);
		bb.buildBlock(-5,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(-5,2,-6,Blocks.planks,1);bb.buildBlock(-5,2,-2,Blocks.planks,1);
		bb.buildBlock(-5,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(-5,2,1,Blocks.fence,0);bb.buildBlock(-5,2,2,Blocks.fence,0);
		bb.buildBlock(-5,2,3,Blocks.fence,0);bb.buildBlock(-5,2,4,Blocks.fence,0);bb.buildBlock(-5,2,5,Blocks.fence,0);
		bb.buildBlock(-5,2,6,Blocks.fence,0);bb.buildBlock(-4,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(-4,2,-6,Blocks.planks,1);
		bb.buildBlock(-4,2,-2,Blocks.planks,1);bb.buildBlock(-4,2,1,Blocks.fence,0);bb.buildBlock(-4,2,2,Blocks.fence,0);
		bb.buildBlock(-4,2,3,Blocks.fence,0);bb.buildBlock(-4,2,4,Blocks.fence,0);bb.buildBlock(-4,2,5,Blocks.fence,0);
		bb.buildBlock(-4,2,6,Blocks.fence,0);bb.buildBlock(-3,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(-3,2,-6,Blocks.planks,1);
		bb.buildBlock(-3,2,-2,Blocks.planks,1);bb.buildBlock(-3,2,1,Blocks.fence,0);bb.buildBlock(-3,2,2,Blocks.fence,0);
		bb.buildBlock(-3,2,3,Blocks.fence,0);bb.buildBlock(-3,2,4,Blocks.fence,0);bb.buildBlock(-3,2,5,Blocks.fence,0);
		bb.buildBlock(-3,2,6,Blocks.fence,0);bb.buildBlock(-2,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(-2,2,-6,Blocks.planks,1);
		bb.buildBlock(-2,2,-2,Blocks.planks,1);bb.buildBlock(-2,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(-2,2,1,Blocks.fence,0);
		bb.buildBlock(-2,2,2,Blocks.fence,0);bb.buildBlock(-2,2,3,Blocks.fence,0);bb.buildBlock(-2,2,4,Blocks.fence,0);
		bb.buildBlock(-2,2,5,Blocks.fence,0);bb.buildBlock(-2,2,6,Blocks.fence,0);bb.buildBlock(-1,2,-7,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,2,-6,Blocks.planks,1);bb.buildBlock(-1,2,-2,Blocks.planks,1);bb.buildBlock(-1,2,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,2,1,Blocks.fence,0);bb.buildBlock(-1,2,2,Blocks.fence,0);bb.buildBlock(-1,2,3,Blocks.fence,0);
		bb.buildBlock(-1,2,4,Blocks.fence,0);bb.buildBlock(-1,2,5,Blocks.fence,0);bb.buildBlock(-1,2,6,Blocks.fence,0);
		bb.buildBlock(0,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(0,2,-6,Blocks.planks,1);bb.buildBlock(0,2,-5,Blocks.planks,2);
		bb.buildBlock(0,2,-4,Blocks.glass_pane,0);bb.buildBlock(0,2,-3,Blocks.planks,2);bb.buildBlock(0,2,-2,Blocks.planks,1);
		bb.buildBlock(0,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(0,2,1,Blocks.fence,0);bb.buildBlock(0,2,2,Blocks.fence,0);
		bb.buildBlock(0,2,3,Blocks.fence,0);bb.buildBlock(0,2,4,Blocks.fence,0);bb.buildBlock(0,2,5,Blocks.fence,0);
		bb.buildBlock(0,2,6,Blocks.fence,0);bb.buildBlock(1,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(1,2,-6,Blocks.planks,1);
		bb.buildBlock(1,2,-2,Blocks.planks,1);bb.buildBlock(1,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(1,2,1,Blocks.fence,0);
		bb.buildBlock(1,2,2,Blocks.fence,0);bb.buildBlock(1,2,3,Blocks.fence,0);bb.buildBlock(1,2,4,Blocks.fence,0);
		bb.buildBlock(1,2,5,Blocks.fence,0);bb.buildBlock(1,2,6,Blocks.fence,0);bb.buildBlock(2,2,-7,Blocks.acacia_stairs,2);
		bb.buildBlock(2,2,-6,Blocks.planks,1);bb.buildBlock(2,2,-2,Blocks.planks,1);bb.buildBlock(2,2,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(2,2,1,Blocks.fence,0);bb.buildBlock(2,2,2,Blocks.fence,0);bb.buildBlock(2,2,3,Blocks.fence,0);
		bb.buildBlock(2,2,4,Blocks.fence,0);bb.buildBlock(2,2,5,Blocks.fence,0);bb.buildBlock(2,2,6,Blocks.fence,0);
		bb.buildBlock(3,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(3,2,-6,Blocks.planks,1);bb.buildBlock(3,2,-2,Blocks.planks,1);
		bb.buildBlock(3,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(3,2,1,Blocks.fence,0);bb.buildBlock(3,2,2,Blocks.fence,0);
		bb.buildBlock(3,2,3,Blocks.fence,0);bb.buildBlock(3,2,4,Blocks.fence,0);bb.buildBlock(3,2,5,Blocks.fence,0);
		bb.buildBlock(3,2,6,Blocks.fence,0);bb.buildBlock(4,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(4,2,-6,Blocks.planks,1);
		bb.buildBlock(4,2,-2,Blocks.planks,1);bb.buildBlock(4,2,-1,Blocks.wooden_slab,12);bb.buildBlock(4,2,1,Blocks.fence,0);
		bb.buildBlock(4,2,2,Blocks.fence,0);bb.buildBlock(4,2,3,Blocks.fence,0);bb.buildBlock(4,2,4,Blocks.fence,0);
		bb.buildBlock(4,2,5,Blocks.fence,0);bb.buildBlock(4,2,6,Blocks.fence,0);bb.buildBlock(5,2,-7,Blocks.acacia_stairs,2);
		bb.buildBlock(5,2,-6,Blocks.planks,1);bb.buildBlock(5,2,-2,Blocks.planks,1);bb.buildBlock(5,2,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(5,2,1,Blocks.fence,0);bb.buildBlock(5,2,2,Blocks.fence,0);bb.buildBlock(5,2,3,Blocks.fence,0);
		bb.buildBlock(5,2,4,Blocks.fence,0);bb.buildBlock(5,2,5,Blocks.fence,0);bb.buildBlock(5,2,6,Blocks.fence,0);
		bb.buildBlock(6,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(6,2,-6,Blocks.planks,1);bb.buildBlock(6,2,-5,Blocks.planks,1);
		bb.buildBlock(6,2,-4,Blocks.planks,1);bb.buildBlock(6,2,-3,Blocks.planks,1);bb.buildBlock(6,2,-2,Blocks.planks,1);
		bb.buildBlock(6,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(6,2,1,Blocks.fence,0);bb.buildBlock(6,2,2,Blocks.fence,0);
		bb.buildBlock(6,2,3,Blocks.fence,0);bb.buildBlock(6,2,4,Blocks.fence,0);bb.buildBlock(6,2,5,Blocks.fence,0);
		bb.buildBlock(6,2,6,Blocks.fence,0);bb.buildBlock(7,2,-7,Blocks.acacia_stairs,2);bb.buildBlock(7,2,-6,Blocks.acacia_stairs,7);
		bb.buildBlock(7,2,-2,Blocks.acacia_stairs,6);bb.buildBlock(7,2,-1,Blocks.acacia_stairs,3);bb.buildBlock(-7,3,-6,Blocks.acacia_stairs,2);
		bb.buildBlock(-7,3,-5,Blocks.acacia_stairs,7);bb.buildBlock(-7,3,-3,Blocks.acacia_stairs,6);bb.buildBlock(-7,3,-2,Blocks.acacia_stairs,3);
		bb.buildBlock(-6,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(-6,3,-5,Blocks.planks,1);bb.buildBlock(-6,3,-4,Blocks.planks,1);
		bb.buildBlock(-6,3,-3,Blocks.planks,1);bb.buildBlock(-6,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(-5,3,-6,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(-4,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(-4,3,-2,Blocks.acacia_stairs,3);
		bb.buildBlock(-4,3,-1,Blocks.wooden_slab,4);bb.buildBlock(-3,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-2,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,3,-1,Blocks.wooden_slab,4);bb.buildBlock(-2,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(-2,3,-2,Blocks.acacia_stairs,3);
		bb.buildBlock(-1,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(-1,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-6,Blocks.acacia_stairs,2);
		bb.buildBlock(0,3,-5,Blocks.planks,2);bb.buildBlock(0,3,-4,Blocks.planks,2);bb.buildBlock(0,3,-3,Blocks.planks,2);
		bb.buildBlock(0,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(1,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(1,3,-2,Blocks.acacia_stairs,3);
		bb.buildBlock(2,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(2,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-6,Blocks.acacia_stairs,2);
		bb.buildBlock(3,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(4,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(4,3,-2,Blocks.acacia_stairs,3);
		bb.buildBlock(5,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(5,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(6,3,-6,Blocks.acacia_stairs,2);
		bb.buildBlock(6,3,-5,Blocks.planks,1);bb.buildBlock(6,3,-4,Blocks.planks,1);bb.buildBlock(6,3,-3,Blocks.planks,1);
		bb.buildBlock(6,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(7,3,-6,Blocks.acacia_stairs,2);bb.buildBlock(7,3,-5,Blocks.acacia_stairs,7);
		bb.buildBlock(7,3,-3,Blocks.acacia_stairs,6);bb.buildBlock(7,3,-2,Blocks.acacia_stairs,3);bb.buildBlock(-7,4,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-7,4,-4,Blocks.double_wooden_slab,4);bb.buildBlock(-7,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(-6,4,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-6,4,-4,Blocks.planks,1);bb.buildBlock(-6,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(-5,4,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(-4,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(-4,4,-3,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(-3,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(-2,4,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(-1,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(-1,4,-3,Blocks.acacia_stairs,3);
		bb.buildBlock(0,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(0,4,-4,Blocks.planks,2);bb.buildBlock(0,4,-3,Blocks.acacia_stairs,3);
		bb.buildBlock(1,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(1,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(2,4,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(2,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(3,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(3,4,-3,Blocks.acacia_stairs,3);
		bb.buildBlock(4,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(4,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(5,4,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(5,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(6,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(6,4,-4,Blocks.planks,1);
		bb.buildBlock(6,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(7,4,-5,Blocks.acacia_stairs,2);bb.buildBlock(7,4,-4,Blocks.double_wooden_slab,4);
		bb.buildBlock(7,4,-3,Blocks.acacia_stairs,3);bb.buildBlock(-7,5,-4,Blocks.wooden_slab,4);bb.buildBlock(-6,5,-4,Blocks.wooden_slab,4);
		bb.buildBlock(-5,5,-4,Blocks.wooden_slab,4);bb.buildBlock(-4,5,-4,Blocks.wooden_slab,4);bb.buildBlock(-3,5,-4,Blocks.wooden_slab,4);
		bb.buildBlock(-2,5,-4,Blocks.wooden_slab,4);bb.buildBlock(-1,5,-4,Blocks.wooden_slab,4);bb.buildBlock(0,5,-4,Blocks.wooden_slab,4);
		bb.buildBlock(1,5,-4,Blocks.wooden_slab,4);bb.buildBlock(2,5,-4,Blocks.wooden_slab,4);bb.buildBlock(3,5,-4,Blocks.wooden_slab,4);
		bb.buildBlock(4,5,-4,Blocks.wooden_slab,4);bb.buildBlock(5,5,-4,Blocks.wooden_slab,4);bb.buildBlock(6,5,-4,Blocks.wooden_slab,4);
		bb.buildBlock(7,5,-4,Blocks.wooden_slab,4);bb.buildBlock(-7,1,2,Blocks.torch,5);bb.buildBlock(-7,1,7,Blocks.torch,5);
		bb.buildBlock(-2,1,7,Blocks.torch,5);bb.buildBlock(1,1,-1,Blocks.torch,3);bb.buildBlock(1,1,7,Blocks.torch,5);
		bb.buildBlock(4,1,7,Blocks.torch,5);bb.buildBlock(7,1,-2,Blocks.torch,5);bb.buildBlock(7,1,0,Blocks.torch,5);
		bb.buildBlock(7,1,2,Blocks.torch,5);bb.buildBlock(7,1,4,Blocks.torch,5);bb.buildBlock(7,1,7,Blocks.torch,5);
		bb.buildBlock(-5,3,-5,Blocks.torch,3);bb.buildBlock(-5,3,-3,Blocks.torch,4);bb.buildBlock(-1,3,-3,Blocks.torch,4);
		bb.buildBlock(1,3,-5,Blocks.torch,1);bb.buildBlock(1,3,-3,Blocks.torch,1);bb.buildBlock(5,3,-5,Blocks.torch,2);
		bb.buildBlock(5,3,-3,Blocks.torch,2);bb.addEntityPainting(-6,2,-4,3,"Plant");
		bb.addEntityItemFrame(6,1,-3,3,ModBlocks.blockFarmland);
	}

}
