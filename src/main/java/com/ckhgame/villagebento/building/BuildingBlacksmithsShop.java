package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionBlackSmith;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class BuildingBlacksmithsShop extends Building {

	@Override
	public String getName() {
		return "Blacksmith's Shop";
	}

	@Override
	public String getDescription() {
		return "Good weapons and armors!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {

		bb.addVillager(ProfessionBlackSmith.class,-1,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-2,-1,2,Blocks.monster_egg,2);bb.buildBlock(-4,0,-4,Blocks.planks,1);bb.buildBlock(-4,0,-3,Blocks.planks,1);
		bb.buildBlock(-4,0,-2,Blocks.planks,1);bb.buildBlock(-4,0,-1,Blocks.planks,1);bb.buildBlock(-4,0,0,Blocks.planks,1);
		bb.buildBlock(-4,0,1,Blocks.planks,1);bb.buildBlock(-4,0,2,Blocks.planks,1);bb.buildBlock(-4,0,3,Blocks.planks,1);
		bb.buildBlock(-4,0,4,Blocks.planks,1);bb.buildBlock(-3,0,-4,Blocks.planks,1);bb.buildBlock(-3,0,-1,Blocks.wooden_door,3);
		bb.buildBlock(-3,0,1,Blocks.anvil,0);bb.buildBlock(-3,0,2,Blocks.stonebrick,0);bb.buildBlock(-3,0,3,Blocks.stonebrick,0);
		bb.buildBlock(-3,0,4,Blocks.planks,1);bb.buildBlock(-2,0,-4,Blocks.planks,1);bb.buildBlock(-2,0,-3,Blocks.bed,3);
		bb.buildBlock(-2,0,-1,Blocks.planks,1);bb.buildBlock(-2,0,4,Blocks.planks,1);bb.buildBlock(-1,0,-4,Blocks.planks,1);
		bb.buildBlock(-1,0,-3,Blocks.bed,11);bb.buildBlock(-1,0,-2,Blocks.bookshelf,0);bb.buildBlock(-1,0,-1,Blocks.planks,1);
		bb.buildBlock(-1,0,4,Blocks.planks,1);bb.buildBlock(0,0,-4,Blocks.planks,1);bb.buildBlock(0,0,-3,Blocks.planks,1);
		bb.buildBlock(0,0,-2,Blocks.planks,1);bb.buildBlock(0,0,-1,Blocks.planks,1);bb.buildBlock(0,0,0,Blocks.planks,1);
		bb.buildBlock(0,0,1,Blocks.planks,1);bb.buildBlock(0,0,2,Blocks.planks,1);bb.buildBlock(0,0,4,Blocks.planks,1);
		bb.buildBlock(1,0,-4,Blocks.planks,1);bb.buildBlock(1,0,-3,Blocks.monster_egg,2);bb.buildBlock(1,0,4,Blocks.planks,1);
		bb.buildBlock(2,0,-4,Blocks.planks,1);bb.buildBlock(2,0,-3,Blocks.monster_egg,2);bb.buildBlock(2,0,4,Blocks.planks,1);
		bb.buildBlock(3,0,-4,Blocks.planks,1);bb.buildBlock(3,0,-3,Blocks.monster_egg,2);bb.buildBlock(3,0,1,ModBlocks.blockWoodenChair,0);
		bb.buildBlock(3,0,3,ModBlocks.blockWoodenChair,0);bb.buildBlock(3,0,4,Blocks.planks,1);bb.buildBlock(4,0,-4,Blocks.planks,1);bb.buildBlock(4,0,-3,Blocks.planks,1);
		bb.buildBlock(4,0,-2,Blocks.planks,1);bb.buildBlock(4,0,-1,Blocks.planks,1);bb.buildBlock(4,0,0,Blocks.wooden_door,2);
		bb.buildBlock(4,0,1,Blocks.planks,1);bb.buildBlock(4,0,2,Blocks.planks,1);bb.buildBlock(4,0,3,Blocks.planks,1);
		bb.buildBlock(4,0,4,Blocks.planks,1);bb.buildBlock(-4,1,-4,Blocks.planks,1);bb.buildBlock(-4,1,-3,Blocks.planks,1);
		bb.buildBlock(-4,1,-2,Blocks.planks,1);bb.buildBlock(-4,1,-1,Blocks.planks,1);bb.buildBlock(-4,1,0,Blocks.planks,1);
		bb.buildBlock(-4,1,1,Blocks.planks,1);bb.buildBlock(-4,1,2,Blocks.planks,1);bb.buildBlock(-4,1,3,Blocks.planks,1);
		bb.buildBlock(-4,1,4,Blocks.planks,1);bb.buildBlock(-3,1,-4,Blocks.planks,1);bb.buildBlock(-3,1,-1,Blocks.wooden_door,8);
		bb.buildBlock(-3,1,2,Blocks.furnace,5);bb.buildBlock(-3,1,3,Blocks.furnace,5);bb.buildBlock(-3,1,4,Blocks.planks,1);bb.buildBlock(-2,1,-4,Blocks.glass_pane,0);bb.buildBlock(-2,1,-1,Blocks.planks,1);
		bb.buildBlock(-2,1,4,Blocks.planks,1);bb.buildBlock(-1,1,-4,Blocks.glass_pane,0);bb.buildBlock(-1,1,-2,Blocks.chest,4);
		bb.buildBlock(-1,1,-1,Blocks.planks,1);bb.buildBlock(-1,1,4,Blocks.planks,1);bb.buildBlock(0,1,-4,Blocks.planks,1);
		bb.buildBlock(0,1,-3,Blocks.planks,1);bb.buildBlock(0,1,-2,Blocks.planks,1);bb.buildBlock(0,1,-1,Blocks.planks,1);
		bb.buildBlock(0,1,4,Blocks.glass_pane,0);bb.buildBlock(1,1,-4,Blocks.planks,1);bb.buildBlock(1,1,4,Blocks.glass_pane,0);
		bb.buildBlock(2,1,-4,Blocks.planks,1);bb.buildBlock(2,1,4,Blocks.glass_pane,0);bb.buildBlock(3,1,-4,Blocks.planks,1);
		bb.buildBlock(3,1,4,Blocks.planks,1);bb.buildBlock(4,1,-4,Blocks.planks,1);bb.buildBlock(4,1,-3,Blocks.planks,1);
		bb.buildBlock(4,1,-2,Blocks.glass_pane,0);bb.buildBlock(4,1,-1,Blocks.planks,1);bb.buildBlock(4,1,0,Blocks.wooden_door,8);
		bb.buildBlock(4,1,1,Blocks.planks,1);bb.buildBlock(4,1,2,Blocks.glass_pane,0);bb.buildBlock(4,1,3,Blocks.glass_pane,0);
		bb.buildBlock(4,1,4,Blocks.planks,1);bb.buildBlock(-5,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(-5,2,-4,Blocks.acacia_stairs,7);
		bb.buildBlock(-5,2,-3,Blocks.fence,0);bb.buildBlock(-5,2,-2,Blocks.fence,0);bb.buildBlock(-5,2,-1,Blocks.fence,0);
		bb.buildBlock(-5,2,0,Blocks.fence,0);bb.buildBlock(-5,2,1,Blocks.fence,0);bb.buildBlock(-5,2,2,Blocks.fence,0);
		bb.buildBlock(-5,2,3,Blocks.fence,0);bb.buildBlock(-5,2,4,Blocks.acacia_stairs,6);bb.buildBlock(-5,2,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-4,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(-4,2,-4,Blocks.planks,1);bb.buildBlock(-4,2,-3,Blocks.planks,1);
		bb.buildBlock(-4,2,-2,Blocks.planks,1);bb.buildBlock(-4,2,-1,Blocks.planks,1);bb.buildBlock(-4,2,0,Blocks.planks,1);
		bb.buildBlock(-4,2,1,Blocks.planks,1);bb.buildBlock(-4,2,2,Blocks.planks,1);bb.buildBlock(-4,2,3,Blocks.planks,1);
		bb.buildBlock(-4,2,4,Blocks.planks,1);bb.buildBlock(-4,2,5,Blocks.acacia_stairs,3);bb.buildBlock(-3,2,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-3,2,-4,Blocks.planks,1);bb.buildBlock(-3,2,-1,Blocks.planks,1);bb.buildBlock(-3,2,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,2,3,Blocks.stonebrick,0);bb.buildBlock(-3,2,4,Blocks.planks,1);bb.buildBlock(-3,2,5,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(-2,2,-4,Blocks.planks,1);bb.buildBlock(-2,2,-1,Blocks.planks,1);
		bb.buildBlock(-2,2,4,Blocks.planks,1);bb.buildBlock(-2,2,5,Blocks.acacia_stairs,3);bb.buildBlock(-1,2,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,2,-4,Blocks.planks,1);bb.buildBlock(-1,2,-1,Blocks.planks,1);bb.buildBlock(-1,2,4,Blocks.planks,1);
		bb.buildBlock(-1,2,5,Blocks.acacia_stairs,3);bb.buildBlock(0,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(0,2,-4,Blocks.planks,1);
		bb.buildBlock(0,2,-3,Blocks.planks,1);bb.buildBlock(0,2,-2,Blocks.planks,1);bb.buildBlock(0,2,-1,Blocks.planks,1);
		bb.buildBlock(0,2,4,Blocks.planks,1);bb.buildBlock(0,2,5,Blocks.acacia_stairs,3);bb.buildBlock(1,2,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(1,2,-4,Blocks.planks,1);bb.buildBlock(1,2,4,Blocks.planks,1);bb.buildBlock(1,2,5,Blocks.acacia_stairs,3);
		bb.buildBlock(2,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(2,2,-4,Blocks.planks,1);bb.buildBlock(2,2,4,Blocks.planks,1);
		bb.buildBlock(2,2,5,Blocks.acacia_stairs,3);bb.buildBlock(3,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(3,2,-4,Blocks.planks,1);
		bb.buildBlock(3,2,4,Blocks.planks,1);bb.buildBlock(3,2,5,Blocks.acacia_stairs,3);bb.buildBlock(4,2,-5,Blocks.acacia_stairs,2);
		bb.buildBlock(4,2,-4,Blocks.planks,1);bb.buildBlock(4,2,-3,Blocks.planks,1);bb.buildBlock(4,2,-2,Blocks.planks,1);
		bb.buildBlock(4,2,-1,Blocks.planks,1);bb.buildBlock(4,2,0,Blocks.planks,1);bb.buildBlock(4,2,1,Blocks.planks,1);
		bb.buildBlock(4,2,2,Blocks.planks,1);bb.buildBlock(4,2,3,Blocks.planks,1);bb.buildBlock(4,2,4,Blocks.planks,1);
		bb.buildBlock(4,2,5,Blocks.acacia_stairs,3);bb.buildBlock(5,2,-5,Blocks.acacia_stairs,2);bb.buildBlock(5,2,-4,Blocks.acacia_stairs,7);
		bb.buildBlock(5,2,4,Blocks.acacia_stairs,6);bb.buildBlock(5,2,5,Blocks.acacia_stairs,3);bb.buildBlock(-5,3,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,3,-3,Blocks.acacia_stairs,7);bb.buildBlock(-5,3,0,Blocks.wooden_slab,12);bb.buildBlock(-5,3,3,Blocks.acacia_stairs,6);
		bb.buildBlock(-5,3,4,Blocks.acacia_stairs,3);bb.buildBlock(-4,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(-4,3,-3,Blocks.planks,1);
		bb.buildBlock(-4,3,-2,Blocks.planks,1);bb.buildBlock(-4,3,-1,Blocks.planks,1);bb.buildBlock(-4,3,0,Blocks.planks,1);
		bb.buildBlock(-4,3,1,Blocks.planks,1);bb.buildBlock(-4,3,2,Blocks.planks,1);bb.buildBlock(-4,3,3,Blocks.planks,1);
		bb.buildBlock(-4,3,4,Blocks.acacia_stairs,3);bb.buildBlock(-3,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(-3,3,-3,Blocks.planks,1);
		bb.buildBlock(-3,3,-1,Blocks.planks,1);bb.buildBlock(-3,3,0,Blocks.planks,1);bb.buildBlock(-3,3,1,Blocks.planks,1);
		bb.buildBlock(-3,3,2,Blocks.stonebrick,0);bb.buildBlock(-3,3,3,Blocks.stonebrick,0);bb.buildBlock(-3,3,4,Blocks.acacia_stairs,3);
		bb.buildBlock(-2,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(-2,3,-3,Blocks.planks,1);bb.buildBlock(-2,3,-1,Blocks.planks,1);
		bb.buildBlock(-2,3,0,Blocks.planks,1);bb.buildBlock(-2,3,1,Blocks.planks,1);bb.buildBlock(-2,3,2,Blocks.stonebrick,0);
		bb.buildBlock(-2,3,3,Blocks.stonebrick,0);bb.buildBlock(-2,3,4,Blocks.acacia_stairs,3);bb.buildBlock(-1,3,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,3,-3,Blocks.planks,1);bb.buildBlock(-1,3,-1,Blocks.planks,1);bb.buildBlock(-1,3,0,Blocks.planks,1);
		bb.buildBlock(-1,3,3,Blocks.planks,1);bb.buildBlock(-1,3,4,Blocks.acacia_stairs,3);bb.buildBlock(0,3,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(0,3,-3,Blocks.planks,1);bb.buildBlock(0,3,-2,Blocks.planks,1);bb.buildBlock(0,3,-1,Blocks.planks,1);
		bb.buildBlock(0,3,0,Blocks.planks,1);bb.buildBlock(0,3,3,Blocks.planks,1);bb.buildBlock(0,3,4,Blocks.acacia_stairs,3);
		bb.buildBlock(1,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(1,3,-3,Blocks.planks,1);bb.buildBlock(1,3,0,Blocks.planks,1);
		bb.buildBlock(1,3,3,Blocks.planks,1);bb.buildBlock(1,3,4,Blocks.acacia_stairs,3);bb.buildBlock(2,3,-4,Blocks.acacia_stairs,2);
		bb.buildBlock(2,3,-3,Blocks.planks,1);bb.buildBlock(2,3,0,Blocks.planks,1);bb.buildBlock(2,3,3,Blocks.planks,1);
		bb.buildBlock(2,3,4,Blocks.acacia_stairs,3);bb.buildBlock(3,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(3,3,-3,Blocks.planks,1);
		bb.buildBlock(3,3,0,Blocks.planks,1);bb.buildBlock(3,3,3,Blocks.planks,1);bb.buildBlock(3,3,4,Blocks.acacia_stairs,3);
		bb.buildBlock(4,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(4,3,-3,Blocks.planks,1);bb.buildBlock(4,3,-2,Blocks.planks,1);
		bb.buildBlock(4,3,-1,Blocks.planks,1);bb.buildBlock(4,3,0,Blocks.planks,1);bb.buildBlock(4,3,1,Blocks.planks,1);
		bb.buildBlock(4,3,2,Blocks.planks,1);bb.buildBlock(4,3,3,Blocks.planks,1);bb.buildBlock(4,3,4,Blocks.acacia_stairs,3);
		bb.buildBlock(5,3,-4,Blocks.acacia_stairs,2);bb.buildBlock(5,3,-3,Blocks.acacia_stairs,7);bb.buildBlock(5,3,0,Blocks.wooden_slab,12);
		bb.buildBlock(5,3,3,Blocks.acacia_stairs,6);bb.buildBlock(5,3,4,Blocks.acacia_stairs,3);bb.buildBlock(-5,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,4,-2,Blocks.wooden_slab,12);bb.buildBlock(-5,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(-5,4,1,Blocks.acacia_stairs,2);
		bb.buildBlock(-5,4,2,Blocks.wooden_slab,12);bb.buildBlock(-5,4,3,Blocks.acacia_stairs,3);bb.buildBlock(-4,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-4,4,-2,Blocks.planks,1);bb.buildBlock(-4,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(-4,4,0,Blocks.wooden_slab,4);
		bb.buildBlock(-4,4,1,Blocks.acacia_stairs,2);bb.buildBlock(-4,4,2,Blocks.planks,1);bb.buildBlock(-4,4,3,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(-3,4,-2,Blocks.planks,1);bb.buildBlock(-3,4,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(-3,4,0,Blocks.wooden_slab,4);bb.buildBlock(-3,4,1,Blocks.acacia_stairs,2);bb.buildBlock(-3,4,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,4,3,Blocks.stonebrick,0);bb.buildBlock(-2,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(-2,4,-2,Blocks.planks,1);
		bb.buildBlock(-2,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(-2,4,0,Blocks.wooden_slab,4);bb.buildBlock(-2,4,1,Blocks.acacia_stairs,2);
		bb.buildBlock(-2,4,2,Blocks.stonebrick,0);bb.buildBlock(-2,4,3,Blocks.stonebrick,0);bb.buildBlock(-1,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(-1,4,-2,Blocks.planks,1);bb.buildBlock(-1,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(-1,4,0,Blocks.wooden_slab,4);
		bb.buildBlock(-1,4,1,Blocks.acacia_stairs,2);bb.buildBlock(-1,4,2,Blocks.planks,1);bb.buildBlock(-1,4,3,Blocks.acacia_stairs,3);
		bb.buildBlock(0,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(0,4,-2,Blocks.planks,1);bb.buildBlock(0,4,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(0,4,0,Blocks.wooden_slab,4);bb.buildBlock(0,4,1,Blocks.acacia_stairs,2);bb.buildBlock(0,4,2,Blocks.planks,1);
		bb.buildBlock(0,4,3,Blocks.acacia_stairs,3);bb.buildBlock(1,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(1,4,-2,Blocks.planks,1);
		bb.buildBlock(1,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(1,4,0,Blocks.wooden_slab,4);bb.buildBlock(1,4,1,Blocks.acacia_stairs,2);
		bb.buildBlock(1,4,2,Blocks.planks,1);bb.buildBlock(1,4,3,Blocks.acacia_stairs,3);bb.buildBlock(2,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(2,4,-2,Blocks.planks,1);bb.buildBlock(2,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(2,4,0,Blocks.wooden_slab,4);
		bb.buildBlock(2,4,1,Blocks.acacia_stairs,2);bb.buildBlock(2,4,2,Blocks.planks,1);bb.buildBlock(2,4,3,Blocks.acacia_stairs,3);
		bb.buildBlock(3,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(3,4,-2,Blocks.planks,1);bb.buildBlock(3,4,-1,Blocks.acacia_stairs,3);
		bb.buildBlock(3,4,0,Blocks.wooden_slab,4);bb.buildBlock(3,4,1,Blocks.acacia_stairs,2);bb.buildBlock(3,4,2,Blocks.planks,1);
		bb.buildBlock(3,4,3,Blocks.acacia_stairs,3);bb.buildBlock(4,4,-3,Blocks.acacia_stairs,2);bb.buildBlock(4,4,-2,Blocks.planks,1);
		bb.buildBlock(4,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(4,4,0,Blocks.wooden_slab,4);bb.buildBlock(4,4,1,Blocks.acacia_stairs,2);
		bb.buildBlock(4,4,2,Blocks.planks,1);bb.buildBlock(4,4,3,Blocks.acacia_stairs,3);bb.buildBlock(5,4,-3,Blocks.acacia_stairs,2);
		bb.buildBlock(5,4,-2,Blocks.wooden_slab,12);bb.buildBlock(5,4,-1,Blocks.acacia_stairs,3);bb.buildBlock(5,4,1,Blocks.acacia_stairs,2);
		bb.buildBlock(5,4,2,Blocks.wooden_slab,12);bb.buildBlock(5,4,3,Blocks.acacia_stairs,3);bb.buildBlock(-5,5,-2,Blocks.wooden_slab,4);
		bb.buildBlock(-5,5,2,Blocks.wooden_slab,4);bb.buildBlock(-4,5,-2,Blocks.wooden_slab,4);bb.buildBlock(-4,5,2,Blocks.wooden_slab,4);
		bb.buildBlock(-3,5,-2,Blocks.wooden_slab,4);bb.buildBlock(-3,5,2,Blocks.stonebrick,0);bb.buildBlock(-3,5,3,Blocks.stonebrick,0);
		bb.buildBlock(-2,5,-2,Blocks.wooden_slab,4);bb.buildBlock(-2,5,2,Blocks.stonebrick,0);bb.buildBlock(-2,5,3,Blocks.stonebrick,0);
		bb.buildBlock(-1,5,-2,Blocks.wooden_slab,4);bb.buildBlock(-1,5,2,Blocks.wooden_slab,4);bb.buildBlock(0,5,-2,Blocks.wooden_slab,4);
		bb.buildBlock(0,5,2,Blocks.wooden_slab,4);bb.buildBlock(1,5,-2,Blocks.wooden_slab,4);bb.buildBlock(1,5,2,Blocks.wooden_slab,4);
		bb.buildBlock(2,5,-2,Blocks.wooden_slab,4);bb.buildBlock(2,5,2,Blocks.wooden_slab,4);bb.buildBlock(3,5,-2,Blocks.wooden_slab,4);
		bb.buildBlock(3,5,2,Blocks.wooden_slab,4);bb.buildBlock(4,5,-2,Blocks.wooden_slab,4);bb.buildBlock(4,5,2,Blocks.wooden_slab,4);
		bb.buildBlock(5,5,-2,Blocks.wooden_slab,4);bb.buildBlock(5,5,2,Blocks.wooden_slab,4);bb.buildBlock(-3,6,2,Blocks.stonebrick,0);
		bb.buildBlock(-3,6,3,Blocks.stonebrick,0);bb.buildBlock(-2,6,2,Blocks.stonebrick,0);bb.buildBlock(-2,6,3,Blocks.stonebrick,0);
		bb.buildBlock(-3,7,2,Blocks.stonebrick,0);bb.buildBlock(-3,7,3,Blocks.stonebrick,0);bb.buildBlock(-2,7,2,Blocks.stonebrick,0);
		bb.buildBlock(-2,7,3,Blocks.stonebrick,0);bb.buildBlock(-3,2,1,Blocks.torch,1);bb.buildBlock(-2,2,-3,Blocks.torch,3);
		bb.buildBlock(1,2,-3,Blocks.torch,3);bb.buildBlock(3,2,-3,Blocks.torch,3);bb.buildBlock(3,2,3,Blocks.torch,4);
		bb.addEntityPainting(-1,1,4,2,"Plant");
		bb.addEntityItemFrame(2,2,-4,0,Items.iron_ingot);
		bb.addEntityItemFrame(0,2,-1,3,Items.iron_helmet);
		bb.addEntityItemFrame(0,2,-2,3,Items.iron_sword);
		bb.addEntityItemFrame(2,1,-4,0,Items.gold_ingot);
		bb.addEntityItemFrame(0,1,-1,3,Items.golden_helmet);
		bb.addEntityItemFrame(0,1,-2,3,Items.golden_sword);
		bb.addEntityItemFrame(4,1,1,3,ModBlocks.blockBlackSmithsShop);
	}

}
