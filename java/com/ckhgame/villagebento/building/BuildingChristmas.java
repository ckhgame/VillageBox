package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMerchant;

import net.minecraft.init.Blocks;

public class BuildingChristmas extends Building {

	@Override
	public String getName() {
		return "Christmas Park";
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
		bb.buildBlock(-3,-1,-3,Blocks.snow,0);bb.buildBlock(-3,-1,-2,Blocks.snow,0);bb.buildBlock(-3,-1,-1,Blocks.snow,0);
		bb.buildBlock(-3,-1,0,Blocks.snow,0);bb.buildBlock(-3,-1,1,Blocks.snow,0);bb.buildBlock(-3,-1,2,Blocks.snow,0);
		bb.buildBlock(-3,-1,3,Blocks.snow,0);bb.buildBlock(-2,-1,-3,Blocks.snow,0);bb.buildBlock(-2,-1,-2,Blocks.snow,0);
		bb.buildBlock(-2,-1,-1,Blocks.snow,0);bb.buildBlock(-2,-1,0,Blocks.snow,0);bb.buildBlock(-2,-1,1,Blocks.snow,0);
		bb.buildBlock(-2,-1,2,Blocks.snow,0);bb.buildBlock(-2,-1,3,Blocks.snow,0);bb.buildBlock(-1,-1,-3,Blocks.snow,0);
		bb.buildBlock(-1,-1,-2,Blocks.snow,0);bb.buildBlock(-1,-1,-1,Blocks.snow,0);bb.buildBlock(-1,-1,0,Blocks.snow,0);
		bb.buildBlock(-1,-1,1,Blocks.snow,0);bb.buildBlock(-1,-1,2,Blocks.snow,0);bb.buildBlock(-1,-1,3,Blocks.snow,0);
		bb.buildBlock(0,-1,-3,Blocks.snow,0);bb.buildBlock(0,-1,-2,Blocks.snow,0);bb.buildBlock(0,-1,-1,Blocks.snow,0);
		bb.buildBlock(0,-1,0,Blocks.dirt,0);bb.buildBlock(0,-1,1,Blocks.snow,0);bb.buildBlock(0,-1,2,Blocks.snow,0);
		bb.buildBlock(0,-1,3,Blocks.snow,0);bb.buildBlock(1,-1,-3,Blocks.snow,0);bb.buildBlock(1,-1,-2,Blocks.snow,0);
		bb.buildBlock(1,-1,-1,Blocks.snow,0);bb.buildBlock(1,-1,0,Blocks.snow,0);bb.buildBlock(1,-1,1,Blocks.snow,0);
		bb.buildBlock(1,-1,2,Blocks.snow,0);bb.buildBlock(1,-1,3,Blocks.snow,0);bb.buildBlock(2,-1,-3,Blocks.snow,0);
		bb.buildBlock(2,-1,-2,Blocks.snow,0);bb.buildBlock(2,-1,-1,Blocks.snow,0);bb.buildBlock(2,-1,0,Blocks.snow,0);
		bb.buildBlock(2,-1,1,Blocks.snow,0);bb.buildBlock(2,-1,2,Blocks.snow,0);bb.buildBlock(2,-1,3,Blocks.snow,0);
		bb.buildBlock(3,-1,-3,Blocks.snow,0);bb.buildBlock(3,-1,-2,Blocks.snow,0);bb.buildBlock(3,-1,-1,Blocks.snow,0);
		bb.buildBlock(3,-1,0,Blocks.snow,0);bb.buildBlock(3,-1,1,Blocks.snow,0);bb.buildBlock(3,-1,2,Blocks.snow,0);
		bb.buildBlock(3,-1,3,Blocks.snow,0);bb.buildBlock(-1,0,0,Blocks.stained_hardened_clay,14);bb.buildBlock(0,0,0,Blocks.log2,1);
		bb.buildBlock(0,0,1,Blocks.stained_hardened_clay,14);bb.buildBlock(1,0,-1,Blocks.stained_hardened_clay,14);bb.buildBlock(-2,1,1,Blocks.glowstone,0);
		bb.buildBlock(0,1,0,Blocks.log2,1);bb.buildBlock(2,1,-2,Blocks.glowstone,0);bb.buildBlock(-2,2,1,Blocks.fence,0);
		bb.buildBlock(-1,2,-2,Blocks.glowstone,0);bb.buildBlock(0,2,0,Blocks.log2,1);bb.buildBlock(2,2,-2,Blocks.fence,0);
		bb.buildBlock(2,2,2,Blocks.glowstone,0);bb.buildBlock(-3,3,-2,Blocks.leaves,13);bb.buildBlock(-3,3,-1,Blocks.leaves,13);
		bb.buildBlock(-3,3,0,Blocks.leaves,13);bb.buildBlock(-3,3,1,Blocks.leaves,13);bb.buildBlock(-3,3,2,Blocks.leaves,13);
		bb.buildBlock(-2,3,-3,Blocks.leaves,13);bb.buildBlock(-2,3,1,Blocks.fence,0);bb.buildBlock(-2,3,3,Blocks.leaves,13);
		bb.buildBlock(-1,3,-3,Blocks.leaves,13);bb.buildBlock(-1,3,-2,Blocks.fence,0);bb.buildBlock(-1,3,-1,Blocks.leaves,13);
		bb.buildBlock(-1,3,0,Blocks.leaves,13);bb.buildBlock(-1,3,1,Blocks.leaves,13);bb.buildBlock(-1,3,3,Blocks.leaves,13);
		bb.buildBlock(0,3,-3,Blocks.leaves,13);bb.buildBlock(0,3,-1,Blocks.leaves,5);bb.buildBlock(0,3,0,Blocks.log2,1);
		bb.buildBlock(0,3,1,Blocks.leaves,13);bb.buildBlock(0,3,3,Blocks.leaves,13);bb.buildBlock(1,3,-3,Blocks.leaves,13);
		bb.buildBlock(1,3,-1,Blocks.leaves,13);bb.buildBlock(1,3,0,Blocks.leaves,13);bb.buildBlock(1,3,1,Blocks.leaves,13);
		bb.buildBlock(1,3,3,Blocks.leaves,13);bb.buildBlock(2,3,-3,Blocks.leaves,13);bb.buildBlock(2,3,-2,Blocks.fence,0);
		bb.buildBlock(2,3,2,Blocks.fence,0);bb.buildBlock(2,3,3,Blocks.leaves,13);bb.buildBlock(3,3,-2,Blocks.leaves,13);
		bb.buildBlock(3,3,-1,Blocks.leaves,13);bb.buildBlock(3,3,0,Blocks.leaves,13);bb.buildBlock(3,3,1,Blocks.leaves,13);
		bb.buildBlock(3,3,2,Blocks.leaves,13);bb.buildBlock(-3,4,-1,Blocks.leaves,13);bb.buildBlock(-3,4,0,Blocks.glowstone,0);
		bb.buildBlock(-3,4,1,Blocks.leaves,13);bb.buildBlock(-2,4,-2,Blocks.stained_hardened_clay,14);bb.buildBlock(-2,4,-1,Blocks.leaves,13);
		bb.buildBlock(-2,4,0,Blocks.leaves,13);bb.buildBlock(-2,4,1,Blocks.leaves,13);bb.buildBlock(-2,4,2,Blocks.leaves,13);
		bb.buildBlock(-1,4,-3,Blocks.leaves,13);bb.buildBlock(-1,4,-2,Blocks.leaves,13);bb.buildBlock(-1,4,-1,Blocks.leaves,13);
		bb.buildBlock(-1,4,0,Blocks.leaves,13);bb.buildBlock(-1,4,1,Blocks.leaves,13);bb.buildBlock(-1,4,2,Blocks.leaves,13);
		bb.buildBlock(-1,4,3,Blocks.leaves,13);bb.buildBlock(0,4,-3,Blocks.glowstone,0);bb.buildBlock(0,4,-2,Blocks.leaves,13);
		bb.buildBlock(0,4,-1,Blocks.leaves,13);bb.buildBlock(0,4,0,Blocks.log2,1);bb.buildBlock(0,4,1,Blocks.leaves,13);
		bb.buildBlock(0,4,2,Blocks.leaves,13);bb.buildBlock(0,4,3,Blocks.glowstone,0);bb.buildBlock(1,4,-3,Blocks.leaves,13);
		bb.buildBlock(1,4,-2,Blocks.leaves,13);bb.buildBlock(1,4,-1,Blocks.leaves,13);bb.buildBlock(1,4,0,Blocks.leaves,13);
		bb.buildBlock(1,4,1,Blocks.leaves,13);bb.buildBlock(1,4,2,Blocks.leaves,13);bb.buildBlock(1,4,3,Blocks.leaves,13);
		bb.buildBlock(2,4,-2,Blocks.leaves,13);bb.buildBlock(2,4,-1,Blocks.leaves,13);bb.buildBlock(2,4,0,Blocks.leaves,13);
		bb.buildBlock(2,4,1,Blocks.leaves,13);bb.buildBlock(2,4,2,Blocks.leaves,13);bb.buildBlock(3,4,-1,Blocks.leaves,13);
		bb.buildBlock(3,4,0,Blocks.glowstone,0);bb.buildBlock(3,4,1,Blocks.leaves,13);bb.buildBlock(-2,5,-1,Blocks.leaves,13);
		bb.buildBlock(-2,5,0,Blocks.leaves,13);bb.buildBlock(-2,5,1,Blocks.leaves,13);bb.buildBlock(-1,5,-2,Blocks.leaves,13);
		bb.buildBlock(-1,5,-1,Blocks.leaves,13);bb.buildBlock(-1,5,0,Blocks.leaves,13);bb.buildBlock(-1,5,1,Blocks.leaves,13);
		bb.buildBlock(-1,5,2,Blocks.leaves,13);bb.buildBlock(0,5,-2,Blocks.leaves,13);bb.buildBlock(0,5,-1,Blocks.leaves,13);
		bb.buildBlock(0,5,0,Blocks.leaves,13);bb.buildBlock(0,5,1,Blocks.leaves,13);bb.buildBlock(0,5,2,Blocks.leaves,13);
		bb.buildBlock(1,5,-2,Blocks.stained_hardened_clay,14);bb.buildBlock(1,5,-1,Blocks.leaves,13);bb.buildBlock(1,5,0,Blocks.leaves,13);
		bb.buildBlock(1,5,1,Blocks.leaves,13);bb.buildBlock(1,5,2,Blocks.stained_hardened_clay,14);bb.buildBlock(2,5,-1,Blocks.leaves,13);
		bb.buildBlock(2,5,0,Blocks.leaves,5);bb.buildBlock(2,5,1,Blocks.leaves,13);bb.buildBlock(-2,6,0,Blocks.leaves,13);
		bb.buildBlock(-1,6,-1,Blocks.leaves,13);bb.buildBlock(-1,6,0,Blocks.leaves,13);bb.buildBlock(-1,6,1,Blocks.stained_hardened_clay,14);
		bb.buildBlock(0,6,-2,Blocks.leaves,13);bb.buildBlock(0,6,-1,Blocks.leaves,13);bb.buildBlock(0,6,0,Blocks.leaves,13);
		bb.buildBlock(0,6,1,Blocks.leaves,13);bb.buildBlock(0,6,2,Blocks.leaves,13);bb.buildBlock(1,6,-1,Blocks.leaves,13);
		bb.buildBlock(1,6,0,Blocks.leaves,13);bb.buildBlock(1,6,1,Blocks.leaves,13);bb.buildBlock(2,6,0,Blocks.leaves,13);
		bb.buildBlock(-1,7,0,Blocks.leaves,13);bb.buildBlock(0,7,-1,Blocks.leaves,13);bb.buildBlock(0,7,0,Blocks.leaves,13);
		bb.buildBlock(0,7,1,Blocks.leaves,13);bb.buildBlock(1,7,0,Blocks.leaves,13);bb.buildBlock(0,8,0,Blocks.glowstone,0);
	}

}
