package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionFarmMarketMerchant;
import com.ckhgame.villagebento.profession.ProfessionPastureMarketMerchant;

import net.minecraft.init.Blocks;

public class BuildingMarket extends Building {

	@Override
	public String getName() {
		return "Market";
	}

	@Override
	public String getDescription() {
		return "Selling products.";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addVillager(ProfessionFarmMarketMerchant.class,2,0);
		bb.addVillager(ProfessionPastureMarketMerchant.class,2,1);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,0,-3,Blocks.stonebrick,0);bb.buildBlock(-3,0,-2,Blocks.stonebrick,0);bb.buildBlock(-3,0,-1,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,0,Blocks.stonebrick,0);bb.buildBlock(-3,0,1,Blocks.stonebrick,0);bb.buildBlock(-3,0,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,3,Blocks.stonebrick,0);bb.buildBlock(-2,0,-5,Blocks.fence,0);bb.buildBlock(-2,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,-2,Blocks.flower_pot,8);bb.addTileEntityPot(-2,0,-2,38,8);
		bb.buildBlock(-2,0,-1,Blocks.flower_pot,1);bb.addTileEntityPot(-2,0,-1,38,1);
		bb.buildBlock(-2,0,0,Blocks.planks,0);bb.buildBlock(-2,0,1,Blocks.flower_pot,1);bb.addTileEntityPot(-2,0,1,38,1);
		bb.buildBlock(-2,0,2,Blocks.flower_pot,8);bb.addTileEntityPot(-2,0,2,38,8);
		bb.buildBlock(-2,0,3,Blocks.stonebrick,0);bb.buildBlock(-2,0,5,Blocks.fence,0);bb.buildBlock(-1,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(-1,0,-1,Blocks.jungle_stairs,2);bb.buildBlock(-1,0,0,Blocks.planks,0);bb.buildBlock(-1,0,1,Blocks.jungle_stairs,3);
		bb.buildBlock(-1,0,3,Blocks.stonebrick,0);bb.buildBlock(0,0,-3,Blocks.stonebrick,0);bb.buildBlock(0,0,0,Blocks.planks,0);
		bb.buildBlock(0,0,3,Blocks.stonebrick,0);bb.buildBlock(1,0,-3,Blocks.stonebrick,0);bb.buildBlock(1,0,0,Blocks.jungle_stairs,1);
		bb.buildBlock(1,0,3,Blocks.stonebrick,0);bb.buildBlock(2,0,-5,Blocks.fence,0);bb.buildBlock(2,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(2,0,3,Blocks.stonebrick,0);bb.buildBlock(2,0,5,Blocks.fence,0);bb.buildBlock(3,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(3,0,-2,Blocks.stonebrick,0);bb.buildBlock(3,0,-1,Blocks.stonebrick,0);bb.buildBlock(3,0,0,Blocks.wooden_door,0);
		bb.buildBlock(3,0,1,Blocks.stonebrick,0);bb.buildBlock(3,0,2,Blocks.stonebrick,0);bb.buildBlock(3,0,3,Blocks.stonebrick,0);
		bb.buildBlock(4,0,-3,Blocks.jungle_stairs,1);bb.buildBlock(4,0,-2,Blocks.jungle_stairs,1);bb.buildBlock(4,0,2,Blocks.jungle_stairs,1);
		bb.buildBlock(4,0,3,Blocks.jungle_stairs,1);bb.buildBlock(-3,1,-3,Blocks.planks,4);bb.buildBlock(-3,1,-2,Blocks.planks,4);
		bb.buildBlock(-3,1,-1,Blocks.planks,4);bb.buildBlock(-3,1,0,Blocks.planks,4);bb.buildBlock(-3,1,1,Blocks.planks,4);
		bb.buildBlock(-3,1,2,Blocks.planks,4);bb.buildBlock(-3,1,3,Blocks.planks,4);bb.buildBlock(-2,1,-5,Blocks.fence,0);
		bb.buildBlock(-2,1,-3,Blocks.fence,0);bb.buildBlock(-2,1,0,Blocks.planks,0);bb.buildBlock(-2,1,3,Blocks.fence,0);
		bb.buildBlock(-2,1,5,Blocks.fence,0);bb.buildBlock(-1,1,-3,Blocks.fence,0);bb.buildBlock(-1,1,0,Blocks.planks,0);
		bb.buildBlock(-1,1,3,Blocks.fence,0);bb.buildBlock(0,1,0,Blocks.jungle_stairs,1);bb.buildBlock(1,1,-3,Blocks.fence,0);
		bb.buildBlock(1,1,3,Blocks.fence,0);bb.buildBlock(2,1,-5,Blocks.fence,0);bb.buildBlock(2,1,-3,Blocks.fence,0);
		bb.buildBlock(2,1,3,Blocks.fence,0);bb.buildBlock(2,1,5,Blocks.fence,0);bb.buildBlock(3,1,-3,Blocks.planks,4);
		bb.buildBlock(3,1,-2,Blocks.glass_pane,0);bb.buildBlock(3,1,-1,Blocks.planks,0);bb.buildBlock(3,1,0,Blocks.wooden_door,8);
		bb.buildBlock(3,1,1,Blocks.planks,0);bb.buildBlock(3,1,2,Blocks.glass_pane,0);bb.buildBlock(3,1,3,Blocks.planks,4);
		bb.buildBlock(-3,2,-3,Blocks.planks,4);bb.buildBlock(-3,2,-2,Blocks.glass_pane,0);bb.buildBlock(-3,2,-1,Blocks.glass_pane,0);
		bb.buildBlock(-3,2,0,Blocks.planks,4);bb.buildBlock(-3,2,1,Blocks.glass_pane,0);bb.buildBlock(-3,2,2,Blocks.glass_pane,0);
		bb.buildBlock(-3,2,3,Blocks.planks,4);bb.buildBlock(-2,2,-5,Blocks.fence,0);bb.buildBlock(-2,2,-3,Blocks.fence,0);
		bb.buildBlock(-2,2,0,Blocks.planks,0);bb.buildBlock(-2,2,3,Blocks.fence,0);bb.buildBlock(-2,2,5,Blocks.fence,0);
		bb.buildBlock(-1,2,-3,Blocks.fence,0);bb.buildBlock(-1,2,0,Blocks.jungle_stairs,1);bb.buildBlock(-1,2,3,Blocks.fence,0);
		bb.buildBlock(0,2,-3,Blocks.fence,0);bb.buildBlock(0,2,3,Blocks.fence,0);bb.buildBlock(1,2,-3,Blocks.fence,0);
		bb.buildBlock(1,2,3,Blocks.fence,0);bb.buildBlock(2,2,-5,Blocks.fence,0);bb.buildBlock(2,2,-3,Blocks.fence,0);
		bb.buildBlock(2,2,3,Blocks.fence,0);bb.buildBlock(2,2,5,Blocks.fence,0);bb.buildBlock(3,2,-3,Blocks.planks,4);
		bb.buildBlock(3,2,-2,Blocks.glass_pane,0);bb.buildBlock(3,2,-1,Blocks.planks,0);bb.buildBlock(3,2,0,Blocks.planks,0);
		bb.buildBlock(3,2,1,Blocks.planks,0);bb.buildBlock(3,2,2,Blocks.glass_pane,0);bb.buildBlock(3,2,3,Blocks.planks,4);
		bb.buildBlock(-3,3,-3,Blocks.planks,4);bb.buildBlock(-3,3,-2,Blocks.planks,4);bb.buildBlock(-3,3,-1,Blocks.planks,4);
		bb.buildBlock(-3,3,0,Blocks.planks,4);bb.buildBlock(-3,3,1,Blocks.planks,4);bb.buildBlock(-3,3,2,Blocks.planks,4);
		bb.buildBlock(-3,3,3,Blocks.planks,4);bb.buildBlock(-2,3,-5,Blocks.wooden_slab,3);bb.buildBlock(-2,3,-4,Blocks.jungle_stairs,2);
		bb.buildBlock(-2,3,-3,Blocks.planks,4);bb.buildBlock(-2,3,-2,Blocks.wooden_slab,8);bb.buildBlock(-2,3,-1,Blocks.wooden_slab,8);
		bb.buildBlock(-2,3,0,Blocks.jungle_stairs,1);bb.buildBlock(-2,3,1,Blocks.wooden_slab,8);bb.buildBlock(-2,3,2,Blocks.wooden_slab,8);
		bb.buildBlock(-2,3,3,Blocks.planks,4);bb.buildBlock(-2,3,4,Blocks.jungle_stairs,3);bb.buildBlock(-2,3,5,Blocks.wooden_slab,3);
		bb.buildBlock(-1,3,-5,Blocks.wooden_slab,3);bb.buildBlock(-1,3,-4,Blocks.jungle_stairs,2);bb.buildBlock(-1,3,-3,Blocks.planks,4);
		bb.buildBlock(-1,3,-2,Blocks.wooden_slab,8);bb.buildBlock(-1,3,-1,Blocks.wooden_slab,8);bb.buildBlock(-1,3,1,Blocks.wooden_slab,8);
		bb.buildBlock(-1,3,2,Blocks.wooden_slab,8);bb.buildBlock(-1,3,3,Blocks.planks,4);bb.buildBlock(-1,3,4,Blocks.jungle_stairs,3);
		bb.buildBlock(-1,3,5,Blocks.wooden_slab,3);bb.buildBlock(0,3,-5,Blocks.wooden_slab,3);bb.buildBlock(0,3,-4,Blocks.jungle_stairs,2);
		bb.buildBlock(0,3,-3,Blocks.planks,4);bb.buildBlock(0,3,-2,Blocks.wooden_slab,8);bb.buildBlock(0,3,-1,Blocks.wooden_slab,8);
		bb.buildBlock(0,3,1,Blocks.wooden_slab,8);bb.buildBlock(0,3,2,Blocks.wooden_slab,8);bb.buildBlock(0,3,3,Blocks.planks,4);
		bb.buildBlock(0,3,4,Blocks.jungle_stairs,3);bb.buildBlock(0,3,5,Blocks.wooden_slab,3);bb.buildBlock(1,3,-5,Blocks.wooden_slab,3);
		bb.buildBlock(1,3,-4,Blocks.jungle_stairs,2);bb.buildBlock(1,3,-3,Blocks.planks,4);bb.buildBlock(1,3,-2,Blocks.wooden_slab,8);
		bb.buildBlock(1,3,-1,Blocks.wooden_slab,8);bb.buildBlock(1,3,1,Blocks.wooden_slab,8);bb.buildBlock(1,3,2,Blocks.wooden_slab,8);
		bb.buildBlock(1,3,3,Blocks.planks,4);bb.buildBlock(1,3,4,Blocks.jungle_stairs,3);bb.buildBlock(1,3,5,Blocks.wooden_slab,3);
		bb.buildBlock(2,3,-5,Blocks.wooden_slab,3);bb.buildBlock(2,3,-4,Blocks.jungle_stairs,2);bb.buildBlock(2,3,-3,Blocks.planks,4);
		bb.buildBlock(2,3,-2,Blocks.wooden_slab,8);bb.buildBlock(2,3,-1,Blocks.wooden_slab,8);bb.buildBlock(2,3,0,Blocks.wooden_slab,8);
		bb.buildBlock(2,3,1,Blocks.wooden_slab,8);bb.buildBlock(2,3,2,Blocks.wooden_slab,8);bb.buildBlock(2,3,3,Blocks.planks,4);
		bb.buildBlock(2,3,4,Blocks.jungle_stairs,3);bb.buildBlock(2,3,5,Blocks.wooden_slab,3);bb.buildBlock(3,3,-3,Blocks.planks,4);
		bb.buildBlock(3,3,-2,Blocks.planks,4);bb.buildBlock(3,3,-1,Blocks.planks,4);bb.buildBlock(3,3,0,Blocks.planks,4);
		bb.buildBlock(3,3,1,Blocks.planks,4);bb.buildBlock(3,3,2,Blocks.planks,4);bb.buildBlock(3,3,3,Blocks.planks,4);
		bb.buildBlock(-3,4,-2,Blocks.planks,0);bb.buildBlock(-3,4,-1,Blocks.planks,0);bb.buildBlock(-3,4,0,Blocks.planks,0);
		bb.buildBlock(-3,4,1,Blocks.planks,0);bb.buildBlock(-3,4,2,Blocks.planks,0);bb.buildBlock(-2,4,-3,Blocks.planks,0);
		bb.buildBlock(-2,4,3,Blocks.planks,0);bb.buildBlock(-1,4,-3,Blocks.planks,0);bb.buildBlock(-1,4,3,Blocks.planks,0);
		bb.buildBlock(0,4,-3,Blocks.planks,0);bb.buildBlock(0,4,-2,Blocks.bed,3);bb.buildBlock(0,4,2,Blocks.bed,3);
		bb.buildBlock(0,4,3,Blocks.planks,0);bb.buildBlock(1,4,-3,Blocks.planks,0);bb.buildBlock(1,4,-2,Blocks.bed,11);
		bb.buildBlock(1,4,2,Blocks.bed,11);bb.buildBlock(1,4,3,Blocks.planks,0);bb.buildBlock(2,4,-3,Blocks.planks,0);
		bb.buildBlock(2,4,-2,Blocks.chest,4);bb.buildBlock(2,4,-1,Blocks.chest,4);bb.buildBlock(2,4,1,Blocks.chest,4);bb.buildBlock(2,4,2,Blocks.chest,4);bb.buildBlock(2,4,3,Blocks.planks,0);bb.buildBlock(3,4,-2,Blocks.planks,0);bb.buildBlock(3,4,-1,Blocks.planks,0);
		bb.buildBlock(3,4,0,Blocks.planks,0);bb.buildBlock(3,4,1,Blocks.planks,0);bb.buildBlock(3,4,2,Blocks.planks,0);
		bb.buildBlock(-3,5,-2,Blocks.planks,0);bb.buildBlock(-3,5,-1,Blocks.glass_pane,0);bb.buildBlock(-3,5,0,Blocks.glass_pane,0);
		bb.buildBlock(-3,5,1,Blocks.glass_pane,0);bb.buildBlock(-3,5,2,Blocks.planks,0);bb.buildBlock(-2,5,-3,Blocks.planks,0);
		bb.buildBlock(-2,5,3,Blocks.planks,0);bb.buildBlock(-1,5,-3,Blocks.glass_pane,0);bb.buildBlock(-1,5,3,Blocks.glass_pane,0);
		bb.buildBlock(0,5,-3,Blocks.glass_pane,0);bb.buildBlock(0,5,3,Blocks.glass_pane,0);bb.buildBlock(1,5,-3,Blocks.glass_pane,0);
		bb.buildBlock(1,5,3,Blocks.glass_pane,0);bb.buildBlock(2,5,-3,Blocks.planks,0);bb.buildBlock(2,5,3,Blocks.planks,0);
		bb.buildBlock(3,5,-2,Blocks.planks,0);bb.buildBlock(3,5,-1,Blocks.glass_pane,0);bb.buildBlock(3,5,0,Blocks.glass_pane,0);
		bb.buildBlock(3,5,1,Blocks.glass_pane,0);bb.buildBlock(3,5,2,Blocks.planks,0);bb.buildBlock(-3,6,-2,Blocks.planks,0);
		bb.buildBlock(-3,6,-1,Blocks.glass_pane,0);bb.buildBlock(-3,6,0,Blocks.glass_pane,0);bb.buildBlock(-3,6,1,Blocks.glass_pane,0);
		bb.buildBlock(-3,6,2,Blocks.planks,0);bb.buildBlock(-2,6,-3,Blocks.planks,0);bb.buildBlock(-2,6,3,Blocks.planks,0);
		bb.buildBlock(-1,6,-3,Blocks.glass_pane,0);bb.buildBlock(-1,6,3,Blocks.glass_pane,0);bb.buildBlock(0,6,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,6,3,Blocks.glass_pane,0);bb.buildBlock(1,6,-3,Blocks.glass_pane,0);bb.buildBlock(1,6,3,Blocks.glass_pane,0);
		bb.buildBlock(2,6,-3,Blocks.planks,0);bb.buildBlock(2,6,3,Blocks.planks,0);bb.buildBlock(3,6,-2,Blocks.planks,0);
		bb.buildBlock(3,6,-1,Blocks.glass_pane,0);bb.buildBlock(3,6,0,Blocks.glass_pane,0);bb.buildBlock(3,6,1,Blocks.glass_pane,0);
		bb.buildBlock(3,6,2,Blocks.planks,0);bb.buildBlock(-4,7,-2,Blocks.wooden_slab,11);bb.buildBlock(-4,7,0,Blocks.wooden_slab,11);
		bb.buildBlock(-4,7,2,Blocks.wooden_slab,11);bb.buildBlock(-3,7,-2,Blocks.planks,0);bb.buildBlock(-3,7,-1,Blocks.planks,0);
		bb.buildBlock(-3,7,0,Blocks.planks,0);bb.buildBlock(-3,7,1,Blocks.planks,0);bb.buildBlock(-3,7,2,Blocks.planks,0);
		bb.buildBlock(-2,7,-4,Blocks.wooden_slab,11);bb.buildBlock(-2,7,-3,Blocks.planks,0);bb.buildBlock(-2,7,3,Blocks.planks,0);
		bb.buildBlock(-2,7,4,Blocks.wooden_slab,11);bb.buildBlock(-1,7,-3,Blocks.planks,0);bb.buildBlock(-1,7,3,Blocks.planks,0);
		bb.buildBlock(0,7,-4,Blocks.wooden_slab,11);bb.buildBlock(0,7,-3,Blocks.planks,0);bb.buildBlock(0,7,3,Blocks.planks,0);
		bb.buildBlock(0,7,4,Blocks.wooden_slab,11);bb.buildBlock(1,7,-3,Blocks.planks,0);bb.buildBlock(1,7,3,Blocks.planks,0);
		bb.buildBlock(2,7,-4,Blocks.wooden_slab,11);bb.buildBlock(2,7,-3,Blocks.planks,0);bb.buildBlock(2,7,3,Blocks.planks,0);
		bb.buildBlock(2,7,4,Blocks.wooden_slab,11);bb.buildBlock(3,7,-2,Blocks.planks,0);bb.buildBlock(3,7,-1,Blocks.planks,0);
		bb.buildBlock(3,7,0,Blocks.planks,0);bb.buildBlock(3,7,1,Blocks.planks,0);bb.buildBlock(3,7,2,Blocks.planks,0);
		bb.buildBlock(4,7,-2,Blocks.wooden_slab,11);bb.buildBlock(4,7,0,Blocks.wooden_slab,11);bb.buildBlock(4,7,2,Blocks.wooden_slab,11);
		bb.buildBlock(-4,8,-3,Blocks.wooden_slab,3);bb.buildBlock(-4,8,-1,Blocks.wooden_slab,3);bb.buildBlock(-4,8,1,Blocks.wooden_slab,3);
		bb.buildBlock(-4,8,3,Blocks.wooden_slab,3);bb.buildBlock(-3,8,-4,Blocks.wooden_slab,3);bb.buildBlock(-3,8,-3,Blocks.jungle_stairs,2);
		bb.buildBlock(-3,8,-2,Blocks.jungle_stairs,0);bb.buildBlock(-3,8,-1,Blocks.jungle_stairs,0);bb.buildBlock(-3,8,0,Blocks.jungle_stairs,0);
		bb.buildBlock(-3,8,1,Blocks.jungle_stairs,0);bb.buildBlock(-3,8,2,Blocks.jungle_stairs,0);bb.buildBlock(-3,8,3,Blocks.jungle_stairs,0);
		bb.buildBlock(-3,8,4,Blocks.wooden_slab,3);bb.buildBlock(-2,8,-3,Blocks.jungle_stairs,2);bb.buildBlock(-2,8,-2,Blocks.wooden_slab,0);
		bb.buildBlock(-2,8,-1,Blocks.wooden_slab,0);bb.buildBlock(-2,8,0,Blocks.wooden_slab,0);bb.buildBlock(-2,8,1,Blocks.wooden_slab,0);
		bb.buildBlock(-2,8,2,Blocks.wooden_slab,0);bb.buildBlock(-2,8,3,Blocks.jungle_stairs,3);bb.buildBlock(-1,8,-4,Blocks.wooden_slab,3);
		bb.buildBlock(-1,8,-3,Blocks.jungle_stairs,2);bb.buildBlock(-1,8,-2,Blocks.wooden_slab,0);bb.buildBlock(-1,8,-1,Blocks.wooden_slab,0);
		bb.buildBlock(-1,8,0,Blocks.wooden_slab,0);bb.buildBlock(-1,8,1,Blocks.wooden_slab,0);bb.buildBlock(-1,8,2,Blocks.wooden_slab,0);
		bb.buildBlock(-1,8,3,Blocks.jungle_stairs,3);bb.buildBlock(-1,8,4,Blocks.wooden_slab,3);bb.buildBlock(0,8,-3,Blocks.jungle_stairs,2);
		bb.buildBlock(0,8,-2,Blocks.wooden_slab,0);bb.buildBlock(0,8,-1,Blocks.wooden_slab,0);bb.buildBlock(0,8,0,Blocks.wooden_slab,0);
		bb.buildBlock(0,8,1,Blocks.wooden_slab,0);bb.buildBlock(0,8,2,Blocks.wooden_slab,0);bb.buildBlock(0,8,3,Blocks.jungle_stairs,3);
		bb.buildBlock(1,8,-4,Blocks.wooden_slab,3);bb.buildBlock(1,8,-3,Blocks.jungle_stairs,2);bb.buildBlock(1,8,-2,Blocks.wooden_slab,0);
		bb.buildBlock(1,8,-1,Blocks.wooden_slab,0);bb.buildBlock(1,8,0,Blocks.wooden_slab,0);bb.buildBlock(1,8,1,Blocks.wooden_slab,0);
		bb.buildBlock(1,8,2,Blocks.wooden_slab,0);bb.buildBlock(1,8,3,Blocks.jungle_stairs,3);bb.buildBlock(1,8,4,Blocks.wooden_slab,3);
		bb.buildBlock(2,8,-3,Blocks.jungle_stairs,2);bb.buildBlock(2,8,-2,Blocks.wooden_slab,0);bb.buildBlock(2,8,-1,Blocks.wooden_slab,0);
		bb.buildBlock(2,8,0,Blocks.wooden_slab,0);bb.buildBlock(2,8,1,Blocks.wooden_slab,0);bb.buildBlock(2,8,2,Blocks.wooden_slab,0);
		bb.buildBlock(2,8,3,Blocks.jungle_stairs,3);bb.buildBlock(3,8,-4,Blocks.wooden_slab,3);bb.buildBlock(3,8,-3,Blocks.jungle_stairs,2);
		bb.buildBlock(3,8,-2,Blocks.jungle_stairs,1);bb.buildBlock(3,8,-1,Blocks.jungle_stairs,1);bb.buildBlock(3,8,0,Blocks.jungle_stairs,1);
		bb.buildBlock(3,8,1,Blocks.jungle_stairs,1);bb.buildBlock(3,8,2,Blocks.jungle_stairs,1);bb.buildBlock(3,8,3,Blocks.jungle_stairs,1);
		bb.buildBlock(3,8,4,Blocks.wooden_slab,3);bb.buildBlock(4,8,-3,Blocks.wooden_slab,3);bb.buildBlock(4,8,-1,Blocks.wooden_slab,3);
		bb.buildBlock(4,8,1,Blocks.wooden_slab,3);bb.buildBlock(4,8,3,Blocks.wooden_slab,3);bb.buildBlock(-2,1,-2,Blocks.torch,1);
		bb.buildBlock(-2,1,-1,Blocks.torch,1);bb.buildBlock(-2,1,1,Blocks.torch,1);bb.buildBlock(-2,1,2,Blocks.torch,1);
		bb.buildBlock(2,1,-1,Blocks.torch,2);bb.buildBlock(2,1,1,Blocks.torch,2);bb.buildBlock(-3,2,-4,Blocks.torch,4);
		bb.buildBlock(-3,2,4,Blocks.torch,3);bb.buildBlock(3,2,-4,Blocks.torch,4);bb.buildBlock(3,2,4,Blocks.torch,3);
		bb.buildBlock(4,2,-1,Blocks.torch,1);bb.buildBlock(4,2,1,Blocks.torch,1);bb.buildBlock(-2,7,-2,Blocks.torch,1);
		bb.buildBlock(-2,7,0,Blocks.torch,1);bb.buildBlock(-2,7,2,Blocks.torch,1);bb.buildBlock(2,7,-2,Blocks.torch,2);
		bb.buildBlock(2,7,0,Blocks.torch,2);bb.buildBlock(2,7,2,Blocks.torch,2);bb.addEntityPainting(-1,1,0,2,"Kebab");
		bb.addEntityPainting(-1,1,0,0,"Plant");
		bb.addEntityItemFrame(3,2,0,3,ModBlocks.blockMarket);
	}

}
