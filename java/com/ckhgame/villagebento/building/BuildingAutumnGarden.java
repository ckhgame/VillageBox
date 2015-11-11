package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMerchant;

import net.minecraft.init.Blocks;

public class BuildingAutumnGarden extends Building {

	@Override
	public String getName() {
		return "Autumn Garden";
	}

	@Override
	public String getDescription() {
		return "Park";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,-3,Blocks.dirt,2);bb.buildBlock(-3,-1,-2,Blocks.dirt,2);bb.buildBlock(-3,-1,-1,Blocks.dirt,2);
		bb.buildBlock(-3,-1,0,Blocks.dirt,2);bb.buildBlock(-3,-1,1,Blocks.dirt,2);bb.buildBlock(-3,-1,2,Blocks.dirt,2);
		bb.buildBlock(-3,-1,3,Blocks.dirt,2);bb.buildBlock(-2,-1,-3,Blocks.dirt,2);bb.buildBlock(-2,-1,-2,Blocks.dirt,2);
		bb.buildBlock(-2,-1,-1,Blocks.dirt,2);bb.buildBlock(-2,-1,0,Blocks.dirt,2);bb.buildBlock(-2,-1,1,Blocks.dirt,2);
		bb.buildBlock(-2,-1,2,Blocks.dirt,2);bb.buildBlock(-2,-1,3,Blocks.dirt,2);bb.buildBlock(-1,-1,-3,Blocks.dirt,2);
		bb.buildBlock(-1,-1,-2,Blocks.dirt,2);bb.buildBlock(-1,-1,-1,Blocks.grass,0);bb.buildBlock(-1,-1,0,Blocks.grass,0);
		bb.buildBlock(-1,-1,1,Blocks.grass,0);bb.buildBlock(-1,-1,2,Blocks.dirt,2);bb.buildBlock(-1,-1,3,Blocks.dirt,2);
		bb.buildBlock(0,-1,-3,Blocks.dirt,2);bb.buildBlock(0,-1,-2,Blocks.dirt,2);bb.buildBlock(0,-1,-1,Blocks.grass,0);
		bb.buildBlock(0,-1,0,Blocks.dirt,2);bb.buildBlock(0,-1,1,Blocks.grass,0);bb.buildBlock(0,-1,2,Blocks.dirt,2);
		bb.buildBlock(0,-1,3,Blocks.dirt,2);bb.buildBlock(1,-1,-3,Blocks.dirt,2);bb.buildBlock(1,-1,-2,Blocks.dirt,2);
		bb.buildBlock(1,-1,-1,Blocks.grass,0);bb.buildBlock(1,-1,0,Blocks.grass,0);bb.buildBlock(1,-1,1,Blocks.grass,0);
		bb.buildBlock(1,-1,2,Blocks.dirt,2);bb.buildBlock(1,-1,3,Blocks.dirt,2);bb.buildBlock(2,-1,-3,Blocks.dirt,2);
		bb.buildBlock(2,-1,-2,Blocks.dirt,2);bb.buildBlock(2,-1,-1,Blocks.dirt,2);bb.buildBlock(2,-1,0,Blocks.dirt,2);
		bb.buildBlock(2,-1,1,Blocks.dirt,2);bb.buildBlock(2,-1,2,Blocks.dirt,2);bb.buildBlock(2,-1,3,Blocks.dirt,2);
		bb.buildBlock(3,-1,-3,Blocks.dirt,2);bb.buildBlock(3,-1,-2,Blocks.dirt,2);bb.buildBlock(3,-1,-1,Blocks.dirt,2);
		bb.buildBlock(3,-1,0,Blocks.dirt,2);bb.buildBlock(3,-1,1,Blocks.dirt,2);bb.buildBlock(3,-1,2,Blocks.dirt,2);
		bb.buildBlock(3,-1,3,Blocks.dirt,2);bb.buildBlock(-2,0,-2,Blocks.tallgrass,1);bb.buildBlock(-2,0,-1,Blocks.tallgrass,1);
		bb.buildBlock(-2,0,0,Blocks.tallgrass,1);bb.buildBlock(-2,0,1,Blocks.tallgrass,1);bb.buildBlock(-2,0,2,Blocks.tallgrass,1);
		bb.buildBlock(-1,0,-2,Blocks.tallgrass,1);bb.buildBlock(-1,0,-1,Blocks.lit_pumpkin,2);bb.buildBlock(-1,0,0,Blocks.lit_pumpkin,1);
		bb.buildBlock(-1,0,1,Blocks.lit_pumpkin,0);bb.buildBlock(-1,0,2,Blocks.tallgrass,1);bb.buildBlock(0,0,-2,Blocks.tallgrass,1);
		bb.buildBlock(0,0,-1,Blocks.lit_pumpkin,2);bb.buildBlock(0,0,0,Blocks.fence,0);bb.buildBlock(0,0,1,Blocks.lit_pumpkin,0);
		bb.buildBlock(0,0,2,Blocks.tallgrass,1);bb.buildBlock(1,0,-2,Blocks.tallgrass,1);bb.buildBlock(1,0,-1,Blocks.lit_pumpkin,2);
		bb.buildBlock(1,0,0,Blocks.lit_pumpkin,3);bb.buildBlock(1,0,1,Blocks.lit_pumpkin,0);bb.buildBlock(1,0,2,Blocks.tallgrass,1);
		bb.buildBlock(2,0,-2,Blocks.tallgrass,1);bb.buildBlock(2,0,-1,Blocks.tallgrass,1);bb.buildBlock(2,0,0,Blocks.tallgrass,1);
		bb.buildBlock(2,0,1,Blocks.tallgrass,1);bb.buildBlock(2,0,2,Blocks.tallgrass,1);bb.buildBlock(0,1,0,Blocks.fence,0);
		bb.buildBlock(-1,2,0,Blocks.wooden_slab,4);bb.buildBlock(0,2,-1,Blocks.wooden_slab,4);bb.buildBlock(0,2,0,Blocks.double_wooden_slab,4);
	}

}
