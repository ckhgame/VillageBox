package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMerchant;

import net.minecraft.init.Blocks;

public class BuildingPotionStore extends Building {

	@Override
	public String getName() {
		return "Potion Store";
	}

	@Override
	public String getDescription() {
		return "Trading Goods";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerMerchant.class,"Ryan",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-5,-2,5,Blocks.stonebrick,2);bb.buildBlock(-4,-1,-5,Blocks.stonebrick,2);bb.buildBlock(-1,-1,-5,Blocks.stonebrick,2);
		bb.buildBlock(0,-1,-4,Blocks.stonebrick,2);bb.buildBlock(0,-1,5,Blocks.stonebrick,2);bb.buildBlock(2,-1,-2,Blocks.stonebrick,2);
		bb.buildBlock(3,-1,-4,Blocks.stonebrick,2);bb.buildBlock(3,-1,-1,Blocks.stonebrick,2);bb.buildBlock(4,-1,-5,Blocks.stonebrick,2);
		bb.buildBlock(4,-1,0,Blocks.stonebrick,2);bb.buildBlock(5,-1,5,Blocks.stonebrick,2);bb.buildBlock(-4,0,-4,Blocks.stonebrick,0);
		bb.buildBlock(-4,0,-3,Blocks.stonebrick,2);bb.buildBlock(-4,0,-2,Blocks.stonebrick,0);bb.buildBlock(-4,0,-1,Blocks.stonebrick,0);
		bb.buildBlock(-4,0,0,Blocks.stonebrick,0);bb.buildBlock(-4,0,1,Blocks.stonebrick,2);bb.buildBlock(-4,0,2,Blocks.stonebrick,2);
		bb.buildBlock(-4,0,3,Blocks.stonebrick,0);bb.buildBlock(-4,0,4,Blocks.stonebrick,2);bb.buildBlock(-3,0,-4,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,-3,Blocks.bookshelf,0);bb.buildBlock(-3,0,-2,Blocks.bookshelf,0);bb.buildBlock(-3,0,-1,Blocks.lit_pumpkin,3);
		bb.buildBlock(-3,0,0,Blocks.bookshelf,0);bb.buildBlock(-3,0,1,Blocks.bookshelf,0);bb.buildBlock(-3,0,2,Blocks.crafting_table,0);
		bb.buildBlock(-3,0,3,Blocks.acacia_stairs,3);bb.buildBlock(-3,0,4,Blocks.stonebrick,0);bb.buildBlock(-2,0,-4,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,1,Blocks.fence_gate,2);bb.buildBlock(-2,0,3,Blocks.acacia_stairs,1);bb.buildBlock(-2,0,4,Blocks.stonebrick,0);
		bb.buildBlock(-1,0,-4,Blocks.stonebrick,0);bb.buildBlock(-1,0,-3,Blocks.planks,5);bb.buildBlock(-1,0,-2,Blocks.planks,5);
		bb.buildBlock(-1,0,-1,Blocks.planks,5);bb.buildBlock(-1,0,0,Blocks.planks,5);bb.buildBlock(-1,0,1,Blocks.planks,5);
		bb.buildBlock(-1,0,2,Blocks.flower_pot,1);bb.addTileEntityPot(-1,0,2,38,1);
		bb.buildBlock(-1,0,4,Blocks.stonebrick,0);bb.buildBlock(0,0,-4,Blocks.stonebrick,0);bb.buildBlock(0,0,-1,Blocks.carpet,14);
		bb.buildBlock(0,0,0,Blocks.carpet,14);bb.buildBlock(0,0,1,Blocks.carpet,14);bb.buildBlock(0,0,4,Blocks.stonebrick,0);
		bb.buildBlock(1,0,-4,Blocks.stonebrick,0);bb.buildBlock(1,0,-3,Blocks.dark_oak_stairs,1);bb.buildBlock(1,0,-1,Blocks.carpet,14);
		bb.buildBlock(1,0,0,Blocks.carpet,1);bb.buildBlock(1,0,1,Blocks.carpet,14);bb.buildBlock(1,0,3,Blocks.dark_oak_stairs,1);
		bb.buildBlock(1,0,4,Blocks.stonebrick,0);bb.buildBlock(2,0,-4,Blocks.stonebrick,2);bb.buildBlock(2,0,-3,Blocks.dark_oak_stairs,3);
		bb.buildBlock(2,0,-1,Blocks.carpet,14);bb.buildBlock(2,0,0,Blocks.carpet,1);bb.buildBlock(2,0,1,Blocks.carpet,14);
		bb.buildBlock(2,0,3,Blocks.dark_oak_stairs,2);bb.buildBlock(2,0,4,Blocks.stonebrick,2);bb.buildBlock(3,0,-4,Blocks.stonebrick,0);
		bb.buildBlock(3,0,-3,Blocks.dark_oak_stairs,0);bb.buildBlock(3,0,-1,Blocks.carpet,14);bb.buildBlock(3,0,0,Blocks.carpet,14);
		bb.buildBlock(3,0,1,Blocks.carpet,14);bb.buildBlock(3,0,3,Blocks.dark_oak_stairs,0);bb.buildBlock(3,0,4,Blocks.stonebrick,0);
		bb.buildBlock(4,0,-4,Blocks.stonebrick,0);bb.buildBlock(4,0,-3,Blocks.stonebrick,0);bb.buildBlock(4,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(4,0,-1,Blocks.stonebrick,0);bb.buildBlock(4,0,0,Blocks.wooden_door,0);bb.buildBlock(4,0,1,Blocks.stonebrick,0);
		bb.buildBlock(4,0,2,Blocks.stonebrick,2);bb.buildBlock(4,0,3,Blocks.stonebrick,0);bb.buildBlock(4,0,4,Blocks.stonebrick,0);
		bb.buildBlock(-4,1,-4,Blocks.stonebrick,0);bb.buildBlock(-4,1,-3,Blocks.planks,2);bb.buildBlock(-4,1,-2,Blocks.planks,2);
		bb.buildBlock(-4,1,-1,Blocks.planks,2);bb.buildBlock(-4,1,0,Blocks.planks,2);bb.buildBlock(-4,1,1,Blocks.planks,2);
		bb.buildBlock(-4,1,2,Blocks.planks,2);bb.buildBlock(-4,1,3,Blocks.planks,2);bb.buildBlock(-4,1,4,Blocks.stonebrick,0);
		bb.buildBlock(-3,1,-4,Blocks.planks,2);bb.buildBlock(-3,1,-3,Blocks.chest,5);bb.buildBlock(-3,1,-2,Blocks.bookshelf,0);bb.buildBlock(-3,1,-1,Blocks.bookshelf,0);bb.buildBlock(-3,1,0,Blocks.flower_pot,3);
		bb.addTileEntityPot(-3,1,0,38,3);
		bb.buildBlock(-3,1,1,Blocks.bookshelf,0);bb.buildBlock(-3,1,2,Blocks.acacia_stairs,3);bb.buildBlock(-3,1,4,Blocks.planks,2);
		bb.buildBlock(-2,1,-4,Blocks.planks,2);bb.buildBlock(-2,1,4,Blocks.planks,2);bb.buildBlock(-1,1,-4,Blocks.planks,2);
		bb.buildBlock(-1,1,4,Blocks.planks,2);bb.buildBlock(0,1,-4,Blocks.planks,2);bb.buildBlock(0,1,4,Blocks.planks,2);
		bb.buildBlock(1,1,-4,Blocks.planks,2);bb.buildBlock(1,1,4,Blocks.planks,2);bb.buildBlock(2,1,-4,Blocks.planks,2);
		bb.buildBlock(2,1,4,Blocks.planks,2);bb.buildBlock(3,1,-4,Blocks.planks,2);bb.buildBlock(3,1,4,Blocks.planks,2);
		bb.buildBlock(4,1,-4,Blocks.stonebrick,0);bb.buildBlock(4,1,-3,Blocks.planks,2);bb.buildBlock(4,1,-2,Blocks.planks,2);
		bb.buildBlock(4,1,-1,Blocks.planks,2);bb.buildBlock(4,1,0,Blocks.wooden_door,8);bb.buildBlock(4,1,1,Blocks.planks,2);
		bb.buildBlock(4,1,2,Blocks.planks,2);bb.buildBlock(4,1,3,Blocks.planks,2);bb.buildBlock(4,1,4,Blocks.stonebrick,0);
		bb.buildBlock(-4,2,-4,Blocks.stonebrick,0);bb.buildBlock(-4,2,-3,Blocks.planks,2);bb.buildBlock(-4,2,-2,Blocks.planks,2);
		bb.buildBlock(-4,2,-1,Blocks.planks,2);bb.buildBlock(-4,2,0,Blocks.planks,2);bb.buildBlock(-4,2,1,Blocks.planks,2);
		bb.buildBlock(-4,2,2,Blocks.planks,2);bb.buildBlock(-4,2,3,Blocks.planks,2);bb.buildBlock(-4,2,4,Blocks.stonebrick,0);
		bb.buildBlock(-3,2,-4,Blocks.planks,2);bb.buildBlock(-3,2,-2,Blocks.bookshelf,0);bb.buildBlock(-3,2,0,Blocks.bookshelf,0);
		bb.buildBlock(-3,2,1,Blocks.acacia_stairs,3);bb.buildBlock(-3,2,4,Blocks.planks,2);bb.buildBlock(-2,2,-4,Blocks.planks,2);
		bb.buildBlock(-2,2,4,Blocks.planks,2);bb.buildBlock(-1,2,-4,Blocks.glass_pane,0);bb.buildBlock(-1,2,4,Blocks.glass_pane,0);
		bb.buildBlock(0,2,-4,Blocks.planks,2);bb.buildBlock(0,2,4,Blocks.planks,2);bb.buildBlock(1,2,-4,Blocks.glass_pane,0);
		bb.buildBlock(1,2,4,Blocks.glass_pane,0);bb.buildBlock(2,2,-4,Blocks.planks,2);bb.buildBlock(2,2,4,Blocks.planks,2);
		bb.buildBlock(3,2,-4,Blocks.planks,2);bb.buildBlock(3,2,4,Blocks.planks,2);bb.buildBlock(4,2,-4,Blocks.stonebrick,0);
		bb.buildBlock(4,2,-3,Blocks.planks,2);bb.buildBlock(4,2,-2,Blocks.glass_pane,0);bb.buildBlock(4,2,-1,Blocks.glass_pane,0);
		bb.buildBlock(4,2,0,Blocks.glass_pane,0);bb.buildBlock(4,2,1,Blocks.glass_pane,0);bb.buildBlock(4,2,2,Blocks.glass_pane,0);
		bb.buildBlock(4,2,3,Blocks.planks,2);bb.buildBlock(4,2,4,Blocks.stonebrick,0);bb.buildBlock(-4,3,-4,Blocks.stonebrick,0);
		bb.buildBlock(-4,3,-3,Blocks.planks,2);bb.buildBlock(-4,3,-2,Blocks.planks,2);bb.buildBlock(-4,3,-1,Blocks.planks,2);
		bb.buildBlock(-4,3,0,Blocks.planks,2);bb.buildBlock(-4,3,1,Blocks.planks,2);bb.buildBlock(-4,3,2,Blocks.planks,2);
		bb.buildBlock(-4,3,3,Blocks.planks,2);bb.buildBlock(-4,3,4,Blocks.stonebrick,0);bb.buildBlock(-3,3,-4,Blocks.planks,2);
		bb.buildBlock(-3,3,-3,Blocks.bookshelf,0);bb.buildBlock(-3,3,-2,Blocks.bookshelf,0);bb.buildBlock(-3,3,-1,Blocks.bookshelf,0);
		bb.buildBlock(-3,3,0,Blocks.acacia_stairs,3);bb.buildBlock(-3,3,4,Blocks.planks,2);bb.buildBlock(-2,3,-4,Blocks.planks,2);
		bb.buildBlock(-2,3,4,Blocks.planks,2);bb.buildBlock(-1,3,-4,Blocks.glass_pane,0);bb.buildBlock(-1,3,4,Blocks.glass_pane,0);
		bb.buildBlock(0,3,-4,Blocks.planks,2);bb.buildBlock(0,3,4,Blocks.planks,2);bb.buildBlock(1,3,-4,Blocks.glass_pane,0);
		bb.buildBlock(1,3,4,Blocks.glass_pane,0);bb.buildBlock(2,3,-4,Blocks.planks,2);bb.buildBlock(2,3,4,Blocks.planks,2);
		bb.buildBlock(3,3,-4,Blocks.planks,2);bb.buildBlock(3,3,4,Blocks.planks,2);bb.buildBlock(4,3,-4,Blocks.stonebrick,0);
		bb.buildBlock(4,3,-3,Blocks.planks,2);bb.buildBlock(4,3,-2,Blocks.glass_pane,0);bb.buildBlock(4,3,-1,Blocks.glass_pane,0);
		bb.buildBlock(4,3,0,Blocks.glass_pane,0);bb.buildBlock(4,3,1,Blocks.glass_pane,0);bb.buildBlock(4,3,2,Blocks.glass_pane,0);
		bb.buildBlock(4,3,3,Blocks.planks,2);bb.buildBlock(4,3,4,Blocks.stonebrick,0);bb.buildBlock(-4,4,-4,Blocks.stonebrick,0);
		bb.buildBlock(-4,4,-3,Blocks.planks,2);bb.buildBlock(-4,4,-2,Blocks.planks,2);bb.buildBlock(-4,4,-1,Blocks.planks,2);
		bb.buildBlock(-4,4,0,Blocks.planks,2);bb.buildBlock(-4,4,1,Blocks.planks,2);bb.buildBlock(-4,4,2,Blocks.planks,2);
		bb.buildBlock(-4,4,3,Blocks.planks,2);bb.buildBlock(-4,4,4,Blocks.stonebrick,0);bb.buildBlock(-3,4,-4,Blocks.planks,2);
		bb.buildBlock(-3,4,-3,Blocks.planks,4);bb.buildBlock(-3,4,-2,Blocks.double_wooden_slab,4);bb.buildBlock(-3,4,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,4,3,Blocks.planks,4);bb.buildBlock(-3,4,4,Blocks.planks,2);bb.buildBlock(-2,4,-4,Blocks.planks,2);
		bb.buildBlock(-2,4,-3,Blocks.planks,4);bb.buildBlock(-2,4,-2,Blocks.planks,4);bb.buildBlock(-2,4,-1,Blocks.planks,4);
		bb.buildBlock(-2,4,0,Blocks.planks,4);bb.buildBlock(-2,4,1,Blocks.planks,4);bb.buildBlock(-2,4,2,Blocks.planks,4);
		bb.buildBlock(-2,4,3,Blocks.planks,4);bb.buildBlock(-2,4,4,Blocks.planks,2);bb.buildBlock(-1,4,-4,Blocks.planks,2);
		bb.buildBlock(-1,4,-3,Blocks.planks,4);bb.buildBlock(-1,4,-2,Blocks.planks,4);bb.buildBlock(-1,4,-1,Blocks.planks,4);
		bb.buildBlock(-1,4,0,Blocks.planks,4);bb.buildBlock(-1,4,1,Blocks.planks,4);bb.buildBlock(-1,4,2,Blocks.planks,4);
		bb.buildBlock(-1,4,3,Blocks.planks,4);bb.buildBlock(-1,4,4,Blocks.planks,2);bb.buildBlock(0,4,-4,Blocks.planks,2);
		bb.buildBlock(0,4,-3,Blocks.planks,4);bb.buildBlock(0,4,-2,Blocks.planks,4);bb.buildBlock(0,4,-1,Blocks.planks,4);
		bb.buildBlock(0,4,0,Blocks.planks,4);bb.buildBlock(0,4,1,Blocks.planks,4);bb.buildBlock(0,4,2,Blocks.planks,4);
		bb.buildBlock(0,4,3,Blocks.planks,4);bb.buildBlock(0,4,4,Blocks.planks,2);bb.buildBlock(1,4,-4,Blocks.planks,2);
		bb.buildBlock(1,4,-3,Blocks.planks,4);bb.buildBlock(1,4,-2,Blocks.planks,4);bb.buildBlock(1,4,-1,Blocks.planks,4);
		bb.buildBlock(1,4,0,Blocks.planks,4);bb.buildBlock(1,4,1,Blocks.planks,4);bb.buildBlock(1,4,2,Blocks.planks,4);
		bb.buildBlock(1,4,3,Blocks.planks,4);bb.buildBlock(1,4,4,Blocks.planks,2);bb.buildBlock(2,4,-4,Blocks.planks,2);
		bb.buildBlock(2,4,-3,Blocks.planks,4);bb.buildBlock(2,4,-2,Blocks.planks,4);bb.buildBlock(2,4,-1,Blocks.planks,4);
		bb.buildBlock(2,4,0,Blocks.planks,4);bb.buildBlock(2,4,1,Blocks.planks,4);bb.buildBlock(2,4,2,Blocks.planks,4);
		bb.buildBlock(2,4,3,Blocks.planks,4);bb.buildBlock(2,4,4,Blocks.planks,2);bb.buildBlock(3,4,-4,Blocks.planks,2);
		bb.buildBlock(3,4,-3,Blocks.planks,4);bb.buildBlock(3,4,-2,Blocks.planks,4);bb.buildBlock(3,4,-1,Blocks.planks,4);
		bb.buildBlock(3,4,0,Blocks.planks,4);bb.buildBlock(3,4,1,Blocks.planks,4);bb.buildBlock(3,4,2,Blocks.planks,4);
		bb.buildBlock(3,4,3,Blocks.planks,4);bb.buildBlock(3,4,4,Blocks.planks,2);bb.buildBlock(4,4,-4,Blocks.stonebrick,0);
		bb.buildBlock(4,4,-3,Blocks.planks,2);bb.buildBlock(4,4,-2,Blocks.planks,2);bb.buildBlock(4,4,-1,Blocks.planks,2);
		bb.buildBlock(4,4,0,Blocks.planks,2);bb.buildBlock(4,4,1,Blocks.planks,2);bb.buildBlock(4,4,2,Blocks.planks,2);
		bb.buildBlock(4,4,3,Blocks.planks,2);bb.buildBlock(4,4,4,Blocks.stonebrick,0);bb.buildBlock(-4,5,-4,Blocks.stonebrick,0);
		bb.buildBlock(-4,5,-3,Blocks.planks,2);bb.buildBlock(-4,5,-2,Blocks.planks,2);bb.buildBlock(-4,5,-1,Blocks.planks,2);
		bb.buildBlock(-4,5,0,Blocks.planks,2);bb.buildBlock(-4,5,1,Blocks.planks,2);bb.buildBlock(-4,5,2,Blocks.planks,2);
		bb.buildBlock(-4,5,3,Blocks.planks,2);bb.buildBlock(-4,5,4,Blocks.stonebrick,0);bb.buildBlock(-3,5,-4,Blocks.planks,2);
		bb.buildBlock(-3,5,3,Blocks.bookshelf,0);bb.buildBlock(-3,5,4,Blocks.planks,2);bb.buildBlock(-2,5,-4,Blocks.planks,2);
		bb.buildBlock(-2,5,3,Blocks.bookshelf,0);bb.buildBlock(-2,5,4,Blocks.planks,2);bb.buildBlock(-1,5,-4,Blocks.planks,2);
		bb.buildBlock(-1,5,-3,Blocks.jukebox,0);bb.buildBlock(-1,5,-2,Blocks.carpet,14);bb.buildBlock(-1,5,-1,Blocks.carpet,14);bb.buildBlock(-1,5,0,Blocks.carpet,14);
		bb.buildBlock(-1,5,1,Blocks.carpet,14);bb.buildBlock(-1,5,2,Blocks.carpet,14);bb.buildBlock(-1,5,3,Blocks.bookshelf,0);
		bb.buildBlock(-1,5,4,Blocks.planks,2);bb.buildBlock(0,5,-4,Blocks.planks,2);bb.buildBlock(0,5,-3,Blocks.chest,3);
		bb.buildBlock(0,5,-2,Blocks.carpet,14);bb.buildBlock(0,5,-1,Blocks.carpet,1);bb.buildBlock(0,5,0,Blocks.carpet,1);
		bb.buildBlock(0,5,1,Blocks.carpet,1);bb.buildBlock(0,5,2,Blocks.carpet,14);bb.buildBlock(0,5,3,Blocks.bookshelf,0);
		bb.buildBlock(0,5,4,Blocks.planks,2);bb.buildBlock(1,5,-4,Blocks.planks,2);bb.buildBlock(1,5,-3,Blocks.chest,3);
		bb.buildBlock(1,5,-2,Blocks.carpet,14);bb.buildBlock(1,5,-1,Blocks.carpet,1);bb.buildBlock(1,5,0,Blocks.carpet,1);
		bb.buildBlock(1,5,1,Blocks.carpet,1);bb.buildBlock(1,5,2,Blocks.carpet,14);bb.buildBlock(1,5,3,Blocks.bookshelf,0);
		bb.buildBlock(1,5,4,Blocks.planks,2);bb.buildBlock(2,5,-4,Blocks.planks,2);bb.buildBlock(2,5,-3,Blocks.bookshelf,0);
		bb.buildBlock(2,5,-2,Blocks.carpet,14);bb.buildBlock(2,5,-1,Blocks.carpet,14);bb.buildBlock(2,5,0,Blocks.carpet,14);
		bb.buildBlock(2,5,1,Blocks.carpet,14);bb.buildBlock(2,5,2,Blocks.carpet,14);bb.buildBlock(2,5,3,Blocks.bookshelf,0);
		bb.buildBlock(2,5,4,Blocks.planks,2);bb.buildBlock(3,5,-4,Blocks.planks,2);bb.buildBlock(3,5,-3,Blocks.bookshelf,0);
		bb.buildBlock(3,5,-2,Blocks.carpet,14);bb.buildBlock(3,5,-1,Blocks.bed,10);bb.buildBlock(3,5,0,Blocks.bed,2);
		bb.buildBlock(3,5,1,Blocks.carpet,14);bb.buildBlock(3,5,2,Blocks.carpet,14);bb.buildBlock(3,5,3,Blocks.crafting_table,0);
		bb.buildBlock(3,5,4,Blocks.planks,2);bb.buildBlock(4,5,-4,Blocks.stonebrick,0);bb.buildBlock(4,5,-3,Blocks.planks,2);
		bb.buildBlock(4,5,-2,Blocks.planks,2);bb.buildBlock(4,5,-1,Blocks.planks,2);bb.buildBlock(4,5,0,Blocks.planks,2);
		bb.buildBlock(4,5,1,Blocks.planks,2);bb.buildBlock(4,5,2,Blocks.planks,2);bb.buildBlock(4,5,3,Blocks.planks,2);
		bb.buildBlock(4,5,4,Blocks.stonebrick,0);bb.buildBlock(-5,6,-4,Blocks.wooden_slab,4);bb.buildBlock(-5,6,-3,Blocks.wooden_slab,4);
		bb.buildBlock(-5,6,-2,Blocks.wooden_slab,12);bb.buildBlock(-5,6,2,Blocks.wooden_slab,12);bb.buildBlock(-5,6,3,Blocks.wooden_slab,4);
		bb.buildBlock(-5,6,4,Blocks.wooden_slab,4);bb.buildBlock(-4,6,-5,Blocks.wooden_slab,4);bb.buildBlock(-4,6,-4,Blocks.acacia_stairs,0);
		bb.buildBlock(-4,6,-3,Blocks.acacia_stairs,0);bb.buildBlock(-4,6,-2,Blocks.planks,4);bb.buildBlock(-4,6,-1,Blocks.glass_pane,0);
		bb.buildBlock(-4,6,0,Blocks.glass_pane,0);bb.buildBlock(-4,6,1,Blocks.glass_pane,0);bb.buildBlock(-4,6,2,Blocks.planks,4);
		bb.buildBlock(-4,6,3,Blocks.acacia_stairs,0);bb.buildBlock(-4,6,4,Blocks.acacia_stairs,3);bb.buildBlock(-4,6,5,Blocks.wooden_slab,4);
		bb.buildBlock(-3,6,-5,Blocks.wooden_slab,4);bb.buildBlock(-3,6,-4,Blocks.acacia_stairs,2);bb.buildBlock(-3,6,4,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,6,5,Blocks.wooden_slab,4);bb.buildBlock(-2,6,-5,Blocks.wooden_slab,12);bb.buildBlock(-2,6,-4,Blocks.planks,4);
		bb.buildBlock(-2,6,4,Blocks.planks,4);bb.buildBlock(-2,6,5,Blocks.wooden_slab,12);bb.buildBlock(-1,6,-4,Blocks.glass_pane,0);
		bb.buildBlock(-1,6,3,Blocks.flower_pot,2);bb.addTileEntityPot(-1,6,3,38,2);
		bb.buildBlock(-1,6,4,Blocks.glass_pane,0);bb.buildBlock(0,6,-4,Blocks.glass_pane,0);bb.buildBlock(0,6,3,Blocks.flower_pot,3);
		bb.addTileEntityPot(0,6,3,38,3);
		bb.buildBlock(0,6,4,Blocks.glass_pane,0);bb.buildBlock(1,6,-4,Blocks.glass_pane,0);bb.buildBlock(1,6,3,Blocks.flower_pot,1);
		bb.addTileEntityPot(1,6,3,38,1);
		bb.buildBlock(1,6,4,Blocks.glass_pane,0);bb.buildBlock(2,6,-5,Blocks.wooden_slab,12);bb.buildBlock(2,6,-4,Blocks.planks,4);
		bb.buildBlock(2,6,4,Blocks.planks,4);bb.buildBlock(2,6,5,Blocks.wooden_slab,12);bb.buildBlock(3,6,-5,Blocks.wooden_slab,4);
		bb.buildBlock(3,6,-4,Blocks.acacia_stairs,2);bb.buildBlock(3,6,-3,Blocks.flower_pot,7);bb.addTileEntityPot(3,6,-3,38,7);
		bb.buildBlock(3,6,4,Blocks.acacia_stairs,3);bb.buildBlock(3,6,5,Blocks.wooden_slab,4);bb.buildBlock(4,6,-5,Blocks.wooden_slab,4);
		bb.buildBlock(4,6,-4,Blocks.acacia_stairs,2);bb.buildBlock(4,6,-3,Blocks.acacia_stairs,1);bb.buildBlock(4,6,-2,Blocks.planks,4);
		bb.buildBlock(4,6,-1,Blocks.glass_pane,0);bb.buildBlock(4,6,0,Blocks.glass_pane,0);bb.buildBlock(4,6,1,Blocks.glass_pane,0);
		bb.buildBlock(4,6,2,Blocks.planks,4);bb.buildBlock(4,6,3,Blocks.acacia_stairs,1);bb.buildBlock(4,6,4,Blocks.acacia_stairs,1);
		bb.buildBlock(4,6,5,Blocks.wooden_slab,4);bb.buildBlock(5,6,-4,Blocks.wooden_slab,4);bb.buildBlock(5,6,-3,Blocks.wooden_slab,4);
		bb.buildBlock(5,6,-2,Blocks.wooden_slab,12);bb.buildBlock(5,6,2,Blocks.wooden_slab,12);bb.buildBlock(5,6,3,Blocks.wooden_slab,4);
		bb.buildBlock(5,6,4,Blocks.wooden_slab,4);bb.buildBlock(-5,7,-1,Blocks.wooden_slab,4);bb.buildBlock(-5,7,0,Blocks.wooden_slab,4);
		bb.buildBlock(-5,7,1,Blocks.wooden_slab,4);bb.buildBlock(-4,7,-1,Blocks.wooden_slab,4);bb.buildBlock(-4,7,0,Blocks.wooden_slab,4);
		bb.buildBlock(-4,7,1,Blocks.wooden_slab,4);bb.buildBlock(-3,7,-3,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,-2,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-3,7,-1,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,0,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,1,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-3,7,2,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,3,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,7,-3,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-2,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,7,-5,Blocks.wooden_slab,4);bb.buildBlock(-1,7,-4,Blocks.wooden_slab,4);
		bb.buildBlock(-1,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(-1,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,7,4,Blocks.wooden_slab,4);
		bb.buildBlock(-1,7,5,Blocks.wooden_slab,4);bb.buildBlock(0,7,-5,Blocks.wooden_slab,4);bb.buildBlock(0,7,-4,Blocks.wooden_slab,4);
		bb.buildBlock(0,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(0,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(0,7,4,Blocks.wooden_slab,4);
		bb.buildBlock(0,7,5,Blocks.wooden_slab,4);bb.buildBlock(1,7,-5,Blocks.wooden_slab,4);bb.buildBlock(1,7,-4,Blocks.wooden_slab,4);
		bb.buildBlock(1,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(1,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(1,7,4,Blocks.wooden_slab,4);
		bb.buildBlock(1,7,5,Blocks.wooden_slab,4);bb.buildBlock(2,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(2,7,3,Blocks.dark_oak_stairs,3);
		bb.buildBlock(3,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(3,7,-2,Blocks.dark_oak_stairs,1);bb.buildBlock(3,7,-1,Blocks.dark_oak_stairs,1);
		bb.buildBlock(3,7,0,Blocks.dark_oak_stairs,1);bb.buildBlock(3,7,1,Blocks.dark_oak_stairs,1);bb.buildBlock(3,7,2,Blocks.dark_oak_stairs,1);
		bb.buildBlock(3,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(4,7,-1,Blocks.wooden_slab,4);bb.buildBlock(4,7,0,Blocks.wooden_slab,4);
		bb.buildBlock(4,7,1,Blocks.wooden_slab,4);bb.buildBlock(5,7,-1,Blocks.wooden_slab,4);bb.buildBlock(5,7,0,Blocks.wooden_slab,4);
		bb.buildBlock(5,7,1,Blocks.wooden_slab,4);bb.buildBlock(-2,8,-2,Blocks.dark_oak_stairs,2);bb.buildBlock(-2,8,-1,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-2,8,0,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,8,1,Blocks.dark_oak_stairs,0);bb.buildBlock(-2,8,2,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-1,8,-2,Blocks.dark_oak_stairs,2);bb.buildBlock(-1,8,2,Blocks.dark_oak_stairs,3);bb.buildBlock(0,8,-2,Blocks.dark_oak_stairs,2);
		bb.buildBlock(0,8,2,Blocks.dark_oak_stairs,3);bb.buildBlock(1,8,-2,Blocks.dark_oak_stairs,2);bb.buildBlock(1,8,2,Blocks.dark_oak_stairs,3);
		bb.buildBlock(2,8,-2,Blocks.dark_oak_stairs,2);bb.buildBlock(2,8,-1,Blocks.dark_oak_stairs,1);bb.buildBlock(2,8,0,Blocks.dark_oak_stairs,1);
		bb.buildBlock(2,8,1,Blocks.dark_oak_stairs,1);bb.buildBlock(2,8,2,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,9,-1,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-1,9,0,Blocks.dark_oak_stairs,0);bb.buildBlock(-1,9,1,Blocks.dark_oak_stairs,0);bb.buildBlock(0,9,-1,Blocks.dark_oak_stairs,2);
		bb.buildBlock(0,9,0,Blocks.glass,0);bb.buildBlock(0,9,1,Blocks.dark_oak_stairs,3);bb.buildBlock(1,9,-1,Blocks.dark_oak_stairs,2);
		bb.buildBlock(1,9,0,Blocks.dark_oak_stairs,1);bb.buildBlock(1,9,1,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,1,-3,Blocks.torch,5);
		bb.buildBlock(-1,1,1,Blocks.torch,5);bb.buildBlock(3,1,-1,Blocks.torch,2);bb.buildBlock(3,1,1,Blocks.torch,2);
		bb.buildBlock(-3,3,3,Blocks.torch,4);bb.buildBlock(-2,3,-3,Blocks.torch,3);bb.buildBlock(0,3,-3,Blocks.torch,3);
		bb.buildBlock(0,3,3,Blocks.torch,4);bb.buildBlock(3,3,-3,Blocks.torch,3);bb.buildBlock(3,3,3,Blocks.torch,4);
		bb.buildBlock(-2,7,-2,Blocks.torch,1);bb.buildBlock(-2,7,2,Blocks.torch,1);bb.buildBlock(2,7,-2,Blocks.torch,2);
		bb.buildBlock(2,7,2,Blocks.torch,2);bb.buildBlock(-1,8,-1,Blocks.torch,3);bb.buildBlock(-1,8,1,Blocks.torch,4);
		bb.buildBlock(1,8,-1,Blocks.torch,3);bb.buildBlock(1,8,1,Blocks.torch,4);bb.addEntityPainting(-3,7,0,3,"Bomb");
		bb.addEntityPainting(-4,2,-1,3,"Bomb");
		bb.addEntityItemFrame(4,1,1,3,373);
	}

}
