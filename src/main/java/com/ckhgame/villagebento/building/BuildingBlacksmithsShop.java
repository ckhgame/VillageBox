package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.profession.ProfessionBlackSmith;

import net.minecraft.init.Blocks;

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

		bb.addVillager(ProfessionBlackSmith.class,-3,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Medium;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		bb.buildBlock(-3,-7,-3,Blocks.monster_egg,2);bb.buildBlock(-3,-7,-2,Blocks.monster_egg,2);bb.buildBlock(-2,-7,-3,Blocks.monster_egg,2);
		bb.buildBlock(-2,-7,-2,Blocks.monster_egg,2);bb.buildBlock(-2,-7,-1,Blocks.monster_egg,2);bb.buildBlock(-2,-7,0,Blocks.monster_egg,2);
		bb.buildBlock(-1,-7,-2,Blocks.monster_egg,2);bb.buildBlock(-1,-7,-1,Blocks.monster_egg,2);bb.buildBlock(-3,-6,-4,Blocks.planks,0);
		bb.buildBlock(-3,-6,-3,Blocks.planks,0);bb.buildBlock(-3,-6,-2,Blocks.planks,0);bb.buildBlock(-3,-6,-1,Blocks.planks,0);
		bb.buildBlock(-3,-6,0,Blocks.planks,0);bb.buildBlock(-2,-6,-4,Blocks.planks,0);bb.buildBlock(-2,-6,-3,Blocks.planks,0);
		bb.buildBlock(-2,-6,-2,Blocks.planks,0);bb.buildBlock(-2,-6,-1,Blocks.planks,0);bb.buildBlock(-2,-6,0,Blocks.planks,0);
		bb.buildBlock(-2,-6,1,Blocks.planks,0);bb.buildBlock(-1,-6,-4,Blocks.planks,0);bb.buildBlock(-1,-6,-3,Blocks.planks,0);
		bb.buildBlock(-1,-6,-2,Blocks.planks,0);bb.buildBlock(-1,-6,-1,Blocks.planks,0);bb.buildBlock(-1,-6,0,Blocks.planks,0);
		bb.buildBlock(-1,-6,1,Blocks.planks,0);bb.buildBlock(-1,-6,3,Blocks.stone_brick_stairs,1);bb.buildBlock(0,-6,-4,Blocks.planks,0);
		bb.buildBlock(0,-6,-3,Blocks.carpet,15);bb.buildBlock(0,-6,-2,Blocks.carpet,12);bb.buildBlock(0,-6,-1,Blocks.oak_stairs,1);
		bb.buildBlock(0,-6,0,Blocks.oak_stairs,1);bb.buildBlock(0,-6,1,Blocks.planks,0);bb.buildBlock(0,-6,3,Blocks.air,0);
		bb.buildBlock(1,-6,-4,Blocks.planks,0);bb.buildBlock(1,-6,-3,Blocks.spruce_stairs,3);bb.buildBlock(1,-6,-2,Blocks.carpet,15);
		bb.buildBlock(1,-6,-1,Blocks.carpet,12);bb.buildBlock(1,-6,0,Blocks.carpet,15);bb.buildBlock(1,-6,1,Blocks.carpet,12);
		bb.buildBlock(1,-6,2,Blocks.planks,0);bb.buildBlock(1,-6,3,Blocks.wooden_door,2);bb.buildBlock(2,-6,-4,Blocks.planks,0);
		bb.buildBlock(2,-6,-3,Blocks.carpet,15);bb.buildBlock(2,-6,-2,Blocks.carpet,12);bb.buildBlock(2,-6,-1,Blocks.carpet,15);
		bb.buildBlock(2,-6,0,Blocks.carpet,12);bb.buildBlock(2,-6,1,Blocks.carpet,15);bb.buildBlock(2,-6,2,Blocks.carpet,12);
		bb.buildBlock(2,-6,3,Blocks.carpet,15);bb.buildBlock(3,-6,-4,Blocks.planks,0);bb.buildBlock(3,-6,-3,Blocks.planks,5);
		bb.buildBlock(3,-6,-2,Blocks.carpet,15);bb.buildBlock(3,-6,-1,Blocks.carpet,12);bb.buildBlock(3,-6,0,Blocks.carpet,15);
		bb.buildBlock(3,-6,1,Blocks.carpet,12);bb.buildBlock(3,-6,2,Blocks.carpet,15);bb.buildBlock(3,-6,3,Blocks.flower_pot,3);
		bb.addTileEntityPot(3,-6,3,38,3);
		bb.buildBlock(4,-6,-4,Blocks.planks,0);bb.buildBlock(4,-6,-3,Blocks.planks,0);bb.buildBlock(4,-6,-2,Blocks.planks,0);
		bb.buildBlock(4,-6,-1,Blocks.planks,0);bb.buildBlock(4,-6,0,Blocks.planks,0);bb.buildBlock(4,-6,1,Blocks.planks,0);
		bb.buildBlock(4,-6,2,Blocks.planks,0);bb.buildBlock(4,-6,3,Blocks.planks,0);bb.buildBlock(-3,-5,-4,Blocks.planks,0);
		bb.buildBlock(-3,-5,-3,Blocks.planks,0);bb.buildBlock(-3,-5,-2,Blocks.planks,0);bb.buildBlock(-3,-5,-1,Blocks.planks,0);
		bb.buildBlock(-3,-5,0,Blocks.planks,0);bb.buildBlock(-2,-5,-4,Blocks.planks,0);bb.buildBlock(-2,-5,-3,Blocks.bookshelf,0);
		bb.buildBlock(-2,-5,-2,Blocks.air,0);bb.buildBlock(-2,-5,-1,Blocks.chest,5);bb.buildBlock(-2,-5,0,Blocks.bed,9);bb.buildBlock(-2,-5,1,Blocks.planks,0);bb.buildBlock(-2,-5,3,Blocks.stone_brick_stairs,1);
		bb.buildBlock(-1,-5,-4,Blocks.planks,0);bb.buildBlock(-1,-5,-3,Blocks.bookshelf,0);bb.buildBlock(-1,-5,-2,Blocks.air,0);
		bb.buildBlock(-1,-5,-1,Blocks.air,0);bb.buildBlock(-1,-5,0,Blocks.bed,1);bb.buildBlock(-1,-5,1,Blocks.planks,0);
		bb.buildBlock(-1,-5,3,Blocks.air,0);bb.buildBlock(0,-5,-4,Blocks.planks,0);bb.buildBlock(0,-5,-3,Blocks.air,0);
		bb.buildBlock(0,-5,-2,Blocks.air,0);bb.buildBlock(0,-5,-1,Blocks.air,0);bb.buildBlock(0,-5,0,Blocks.air,0);
		bb.buildBlock(0,-5,1,Blocks.planks,0);bb.buildBlock(0,-5,3,Blocks.air,0);bb.buildBlock(1,-5,-4,Blocks.planks,0);
		bb.buildBlock(1,-5,-3,Blocks.air,0);bb.buildBlock(1,-5,-2,Blocks.air,0);bb.buildBlock(1,-5,-1,Blocks.air,0);
		bb.buildBlock(1,-5,0,Blocks.air,0);bb.buildBlock(1,-5,1,Blocks.air,0);bb.buildBlock(1,-5,2,Blocks.planks,0);
		bb.buildBlock(1,-5,3,Blocks.wooden_door,8);bb.buildBlock(2,-5,-4,Blocks.planks,0);bb.buildBlock(2,-5,-3,Blocks.air,0);
		bb.buildBlock(2,-5,-2,Blocks.air,0);bb.buildBlock(2,-5,-1,Blocks.air,0);bb.buildBlock(2,-5,0,Blocks.air,0);
		bb.buildBlock(2,-5,1,Blocks.air,0);bb.buildBlock(2,-5,2,Blocks.air,0);bb.buildBlock(2,-5,3,Blocks.air,0);
		bb.buildBlock(3,-5,-4,Blocks.planks,0);bb.buildBlock(3,-5,-3,Blocks.flower_pot,3);bb.addTileEntityPot(3,-5,-3,38,3);
		bb.buildBlock(3,-5,-2,Blocks.air,0);bb.buildBlock(3,-5,-1,Blocks.air,0);bb.buildBlock(3,-5,0,Blocks.air,0);
		bb.buildBlock(3,-5,1,Blocks.air,0);bb.buildBlock(3,-5,2,Blocks.air,0);bb.buildBlock(3,-5,3,Blocks.air,0);
		bb.buildBlock(4,-5,-4,Blocks.planks,0);bb.buildBlock(4,-5,-3,Blocks.planks,0);bb.buildBlock(4,-5,-2,Blocks.planks,0);
		bb.buildBlock(4,-5,-1,Blocks.planks,0);bb.buildBlock(4,-5,0,Blocks.planks,0);bb.buildBlock(4,-5,1,Blocks.planks,0);
		bb.buildBlock(4,-5,2,Blocks.planks,0);bb.buildBlock(4,-5,3,Blocks.planks,0);bb.buildBlock(-3,-4,-4,Blocks.planks,0);
		bb.buildBlock(-3,-4,-3,Blocks.planks,0);bb.buildBlock(-3,-4,-2,Blocks.planks,0);bb.buildBlock(-3,-4,-1,Blocks.planks,0);
		bb.buildBlock(-3,-4,0,Blocks.planks,0);bb.buildBlock(-3,-4,3,Blocks.stone_brick_stairs,1);bb.buildBlock(-2,-4,-4,Blocks.planks,0);
		bb.buildBlock(-2,-4,-2,Blocks.air,0);bb.buildBlock(-2,-4,-1,Blocks.air,0);bb.buildBlock(-2,-4,1,Blocks.planks,0);
		bb.buildBlock(-2,-4,3,Blocks.air,0);bb.buildBlock(-1,-4,-4,Blocks.planks,0);bb.buildBlock(-1,-4,-3,Blocks.air,0);
		bb.buildBlock(-1,-4,-2,Blocks.air,0);bb.buildBlock(-1,-4,-1,Blocks.air,0);bb.buildBlock(-1,-4,0,Blocks.air,0);
		bb.buildBlock(-1,-4,1,Blocks.planks,0);bb.buildBlock(-1,-4,3,Blocks.air,0);bb.buildBlock(0,-4,-4,Blocks.planks,0);
		bb.buildBlock(0,-4,-3,Blocks.air,0);bb.buildBlock(0,-4,-2,Blocks.air,0);bb.buildBlock(0,-4,-1,Blocks.air,0);
		bb.buildBlock(0,-4,0,Blocks.air,0);bb.buildBlock(0,-4,1,Blocks.planks,0);bb.buildBlock(0,-4,3,Blocks.air,0);
		bb.buildBlock(1,-4,-4,Blocks.planks,0);bb.buildBlock(1,-4,-3,Blocks.air,0);bb.buildBlock(1,-4,-2,Blocks.air,0);
		bb.buildBlock(1,-4,-1,Blocks.air,0);bb.buildBlock(1,-4,0,Blocks.air,0);bb.buildBlock(1,-4,1,Blocks.air,0);
		bb.buildBlock(1,-4,2,Blocks.planks,0);bb.buildBlock(1,-4,3,Blocks.planks,0);bb.buildBlock(2,-4,-4,Blocks.planks,0);
		bb.buildBlock(2,-4,-3,Blocks.air,0);bb.buildBlock(2,-4,-2,Blocks.air,0);bb.buildBlock(2,-4,-1,Blocks.air,0);
		bb.buildBlock(2,-4,0,Blocks.air,0);bb.buildBlock(2,-4,1,Blocks.air,0);bb.buildBlock(2,-4,2,Blocks.air,0);
		bb.buildBlock(2,-4,3,Blocks.air,0);bb.buildBlock(3,-4,-4,Blocks.planks,0);bb.buildBlock(3,-4,-2,Blocks.air,0);
		bb.buildBlock(3,-4,-1,Blocks.air,0);bb.buildBlock(3,-4,1,Blocks.air,0);bb.buildBlock(3,-4,2,Blocks.air,0);
		bb.buildBlock(4,-4,-4,Blocks.planks,0);bb.buildBlock(4,-4,-3,Blocks.planks,0);bb.buildBlock(4,-4,-2,Blocks.planks,0);
		bb.buildBlock(4,-4,-1,Blocks.planks,0);bb.buildBlock(4,-4,0,Blocks.planks,0);bb.buildBlock(4,-4,1,Blocks.planks,0);
		bb.buildBlock(4,-4,2,Blocks.planks,0);bb.buildBlock(4,-4,3,Blocks.planks,0);bb.buildBlock(-4,-3,3,Blocks.stone_brick_stairs,1);
		bb.buildBlock(-3,-3,3,Blocks.air,0);bb.buildBlock(-2,-3,-3,Blocks.planks,1);bb.buildBlock(-2,-3,-2,Blocks.planks,1);
		bb.buildBlock(-2,-3,-1,Blocks.planks,1);bb.buildBlock(-2,-3,0,Blocks.planks,1);bb.buildBlock(-2,-3,3,Blocks.air,0);
		bb.buildBlock(-1,-3,-3,Blocks.planks,1);bb.buildBlock(-1,-3,-2,Blocks.planks,1);bb.buildBlock(-1,-3,-1,Blocks.planks,1);
		bb.buildBlock(-1,-3,0,Blocks.planks,1);bb.buildBlock(-1,-3,3,Blocks.air,0);bb.buildBlock(0,-3,-3,Blocks.planks,1);
		bb.buildBlock(0,-3,-2,Blocks.planks,1);bb.buildBlock(0,-3,-1,Blocks.planks,1);bb.buildBlock(0,-3,0,Blocks.planks,1);
		bb.buildBlock(0,-3,3,Blocks.air,0);bb.buildBlock(1,-3,-3,Blocks.planks,1);bb.buildBlock(1,-3,-2,Blocks.planks,1);
		bb.buildBlock(1,-3,-1,Blocks.planks,1);bb.buildBlock(1,-3,0,Blocks.planks,1);bb.buildBlock(1,-3,1,Blocks.planks,1);
		bb.buildBlock(2,-3,-3,Blocks.planks,1);bb.buildBlock(2,-3,-2,Blocks.planks,1);bb.buildBlock(2,-3,-1,Blocks.planks,1);
		bb.buildBlock(2,-3,0,Blocks.planks,1);bb.buildBlock(2,-3,1,Blocks.planks,1);bb.buildBlock(2,-3,2,Blocks.planks,1);
		bb.buildBlock(2,-3,3,Blocks.planks,1);bb.buildBlock(3,-3,-3,Blocks.planks,1);bb.buildBlock(3,-3,-2,Blocks.planks,1);
		bb.buildBlock(3,-3,-1,Blocks.planks,1);bb.buildBlock(3,-3,0,Blocks.planks,1);bb.buildBlock(3,-3,1,Blocks.planks,1);
		bb.buildBlock(3,-3,2,Blocks.planks,1);bb.buildBlock(3,-3,3,Blocks.planks,1);bb.buildBlock(-4,-2,2,Blocks.air,0);
		bb.buildBlock(-4,-2,3,Blocks.air,0);bb.buildBlock(-3,-2,2,Blocks.stone_brick_stairs,0);bb.buildBlock(-3,-2,3,Blocks.air,0);
		bb.buildBlock(-2,-2,3,Blocks.air,0);bb.buildBlock(-5,-1,0,Blocks.monster_egg,2);bb.buildBlock(-4,-1,-3,Blocks.monster_egg,2);
		bb.buildBlock(-4,-1,2,Blocks.air,0);bb.buildBlock(-4,-1,3,Blocks.air,0);bb.buildBlock(-3,-1,-2,Blocks.monster_egg,2);
		bb.buildBlock(-3,-1,2,Blocks.air,0);bb.buildBlock(-3,-1,3,Blocks.air,0);bb.buildBlock(-2,-1,2,Blocks.stone_brick_stairs,0);
		bb.buildBlock(-2,-1,3,Blocks.air,0);bb.buildBlock(-1,-1,3,Blocks.monster_egg,2);bb.buildBlock(1,-1,-4,Blocks.monster_egg,2);
		bb.buildBlock(1,-1,3,Blocks.monster_egg,2);bb.buildBlock(3,-1,-2,Blocks.monster_egg,2);bb.buildBlock(4,-1,0,Blocks.monster_egg,2);
		bb.buildBlock(-5,0,-5,Blocks.planks,0);bb.buildBlock(-5,0,-4,Blocks.fence,0);bb.buildBlock(-5,0,-3,Blocks.fence,0);
		bb.buildBlock(-5,0,-2,Blocks.fence,0);bb.buildBlock(-5,0,-1,Blocks.fence,0);bb.buildBlock(-5,0,0,Blocks.fence,0);
		bb.buildBlock(-5,0,1,Blocks.fence,0);bb.buildBlock(-5,0,2,Blocks.fence,0);bb.buildBlock(-5,0,3,Blocks.fence,0);
		bb.buildBlock(-5,0,4,Blocks.fence,0);bb.buildBlock(-5,0,5,Blocks.planks,0);bb.buildBlock(-4,0,-5,Blocks.fence,0);
		bb.buildBlock(-4,0,-1,Blocks.stonebrick,0);bb.buildBlock(-4,0,5,Blocks.fence,0);bb.buildBlock(-3,0,-5,Blocks.planks,0);
		bb.buildBlock(-3,0,-1,Blocks.stonebrick,0);bb.buildBlock(-3,0,5,Blocks.fence,0);bb.buildBlock(-2,0,-5,Blocks.wooden_door,3);
		bb.buildBlock(-2,0,-1,Blocks.stonebrick,0);bb.buildBlock(-2,0,5,Blocks.fence,0);bb.buildBlock(-1,0,-5,Blocks.wooden_door,3);
		bb.buildBlock(-1,0,-1,Blocks.stonebrick,0);bb.buildBlock(-1,0,5,Blocks.fence,0);bb.buildBlock(0,0,-5,Blocks.planks,0);
		bb.buildBlock(0,0,-2,Blocks.anvil,2);bb.buildBlock(0,0,-1,Blocks.stonebrick,0);bb.buildBlock(0,0,0,Blocks.stonebrick,0);
		bb.buildBlock(0,0,1,Blocks.stonebrick,0);bb.buildBlock(0,0,2,Blocks.stonebrick,0);bb.buildBlock(0,0,5,Blocks.fence,0);
		bb.buildBlock(1,0,-5,Blocks.fence,0);bb.buildBlock(1,0,-3,Blocks.monster_egg,2);bb.buildBlock(1,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(1,0,-1,Blocks.stonebrick,0);bb.buildBlock(1,0,0,Blocks.stonebrick,0);bb.buildBlock(1,0,1,Blocks.lava,0);
		bb.buildBlock(1,0,2,Blocks.stonebrick,0);bb.buildBlock(1,0,5,Blocks.fence,0);bb.buildBlock(2,0,-5,Blocks.fence,0);
		bb.buildBlock(2,0,-3,Blocks.stonebrick,0);bb.buildBlock(2,0,-2,Blocks.netherrack,0);bb.buildBlock(2,0,-1,Blocks.monster_egg,2);
		bb.buildBlock(2,0,0,Blocks.monster_egg,2);bb.buildBlock(2,0,1,Blocks.lava,0);bb.buildBlock(2,0,2,Blocks.monster_egg,2);
		bb.buildBlock(2,0,5,Blocks.fence,0);bb.buildBlock(3,0,-5,Blocks.fence,0);bb.buildBlock(3,0,-3,Blocks.stonebrick,0);
		bb.buildBlock(3,0,-2,Blocks.monster_egg,2);bb.buildBlock(3,0,-1,Blocks.monster_egg,2);bb.buildBlock(3,0,0,Blocks.monster_egg,2);
		bb.buildBlock(3,0,1,Blocks.monster_egg,2);bb.buildBlock(3,0,2,Blocks.stonebrick,0);bb.buildBlock(3,0,5,Blocks.fence,0);
		bb.buildBlock(4,0,-5,Blocks.fence,0);bb.buildBlock(4,0,5,Blocks.fence,0);bb.buildBlock(5,0,-5,Blocks.planks,0);
		bb.buildBlock(5,0,-4,Blocks.fence,0);bb.buildBlock(5,0,-3,Blocks.fence,0);bb.buildBlock(5,0,-2,Blocks.fence,0);
		bb.buildBlock(5,0,-1,Blocks.fence,0);bb.buildBlock(5,0,0,Blocks.fence,0);bb.buildBlock(5,0,1,Blocks.fence,0);
		bb.buildBlock(5,0,2,Blocks.fence,0);bb.buildBlock(5,0,3,Blocks.fence,0);bb.buildBlock(5,0,4,Blocks.fence,0);
		bb.buildBlock(5,0,5,Blocks.planks,0);bb.buildBlock(-5,1,-5,Blocks.planks,0);bb.buildBlock(-5,1,5,Blocks.planks,0);
		bb.buildBlock(-4,1,-5,Blocks.fence,0);bb.buildBlock(-3,1,-5,Blocks.planks,0);bb.buildBlock(-2,1,-5,Blocks.wooden_door,8);
		bb.buildBlock(-1,1,-5,Blocks.wooden_door,9);bb.buildBlock(0,1,-5,Blocks.planks,0);bb.buildBlock(0,1,-1,Blocks.stone_brick_stairs,0);
		bb.buildBlock(0,1,0,Blocks.iron_bars,0);bb.buildBlock(0,1,2,Blocks.iron_bars,0);bb.buildBlock(1,1,-3,Blocks.stonebrick,0);
		bb.buildBlock(1,1,-2,Blocks.iron_bars,0);bb.buildBlock(1,1,-1,Blocks.monster_egg,2);bb.buildBlock(1,1,0,Blocks.iron_bars,0);
		bb.buildBlock(1,1,2,Blocks.iron_bars,0);bb.buildBlock(2,1,-3,Blocks.stonebrick,0);bb.buildBlock(2,1,-2,Blocks.fire,15);
		bb.buildBlock(2,1,-1,Blocks.stonebrick,0);bb.buildBlock(2,1,0,Blocks.iron_bars,0);bb.buildBlock(2,1,2,Blocks.iron_bars,0);
		bb.buildBlock(3,1,-3,Blocks.stonebrick,0);bb.buildBlock(3,1,-2,Blocks.iron_bars,0);bb.buildBlock(3,1,-1,Blocks.stonebrick,0);
		bb.buildBlock(3,1,0,Blocks.iron_bars,0);bb.buildBlock(3,1,1,Blocks.iron_bars,0);bb.buildBlock(3,1,2,Blocks.iron_bars,0);
		bb.buildBlock(5,1,-5,Blocks.planks,0);bb.buildBlock(5,1,5,Blocks.planks,0);bb.buildBlock(-5,2,-5,Blocks.planks,0);
		bb.buildBlock(-5,2,5,Blocks.planks,0);bb.buildBlock(-4,2,-5,Blocks.fence,0);bb.buildBlock(-3,2,-5,Blocks.planks,0);
		bb.buildBlock(0,2,-5,Blocks.planks,0);bb.buildBlock(0,2,0,Blocks.stone_slab,5);bb.buildBlock(0,2,1,Blocks.stone_slab,5);
		bb.buildBlock(0,2,2,Blocks.stone_slab,5);bb.buildBlock(1,2,-2,Blocks.stonebrick,0);bb.buildBlock(1,2,0,Blocks.stone_slab,5);
		bb.buildBlock(1,2,1,Blocks.stone_slab,5);bb.buildBlock(1,2,2,Blocks.stone_slab,5);bb.buildBlock(2,2,-3,Blocks.stonebrick,0);
		bb.buildBlock(2,2,-2,Blocks.stonebrick,0);bb.buildBlock(2,2,-1,Blocks.stonebrick,0);bb.buildBlock(2,2,0,Blocks.stone_slab,5);
		bb.buildBlock(2,2,1,Blocks.stone_slab,5);bb.buildBlock(2,2,2,Blocks.stone_slab,5);bb.buildBlock(3,2,-2,Blocks.stonebrick,0);
		bb.buildBlock(3,2,0,Blocks.stone_slab,5);bb.buildBlock(3,2,1,Blocks.stone_slab,5);bb.buildBlock(3,2,2,Blocks.stone_slab,5);
		bb.buildBlock(5,2,-5,Blocks.planks,0);bb.buildBlock(5,2,5,Blocks.planks,0);bb.buildBlock(-5,3,-5,Blocks.planks,0);
		bb.buildBlock(-5,3,5,Blocks.planks,0);bb.buildBlock(-4,3,-5,Blocks.fence,0);bb.buildBlock(-3,3,-5,Blocks.planks,0);
		bb.buildBlock(0,3,-5,Blocks.planks,0);bb.buildBlock(2,3,-2,Blocks.stonebrick,0);bb.buildBlock(5,3,-5,Blocks.planks,0);
		bb.buildBlock(5,3,5,Blocks.planks,0);bb.buildBlock(-5,4,-5,Blocks.planks,0);bb.buildBlock(-5,4,5,Blocks.planks,0);
		bb.buildBlock(-4,4,-5,Blocks.fence,0);bb.buildBlock(-3,4,-5,Blocks.planks,0);bb.buildBlock(0,4,-5,Blocks.planks,0);
		bb.buildBlock(2,4,-2,Blocks.stonebrick,0);bb.buildBlock(5,4,-5,Blocks.planks,0);bb.buildBlock(5,4,5,Blocks.planks,0);
		bb.buildBlock(-5,5,-5,Blocks.planks,0);bb.buildBlock(-5,5,-4,Blocks.planks,0);bb.buildBlock(-5,5,-3,Blocks.planks,0);
		bb.buildBlock(-5,5,-2,Blocks.planks,0);bb.buildBlock(-5,5,-1,Blocks.planks,0);bb.buildBlock(-5,5,0,Blocks.planks,0);
		bb.buildBlock(-5,5,1,Blocks.planks,0);bb.buildBlock(-5,5,2,Blocks.planks,0);bb.buildBlock(-5,5,3,Blocks.planks,0);
		bb.buildBlock(-5,5,4,Blocks.planks,0);bb.buildBlock(-5,5,5,Blocks.planks,0);bb.buildBlock(-4,5,-5,Blocks.planks,0);
		bb.buildBlock(-4,5,-4,Blocks.planks,0);bb.buildBlock(-4,5,-3,Blocks.planks,0);bb.buildBlock(-4,5,-2,Blocks.planks,0);
		bb.buildBlock(-4,5,-1,Blocks.planks,0);bb.buildBlock(-4,5,0,Blocks.planks,0);bb.buildBlock(-4,5,1,Blocks.planks,0);
		bb.buildBlock(-4,5,2,Blocks.planks,0);bb.buildBlock(-4,5,3,Blocks.planks,0);bb.buildBlock(-4,5,4,Blocks.planks,0);
		bb.buildBlock(-4,5,5,Blocks.planks,0);bb.buildBlock(-3,5,-5,Blocks.planks,0);bb.buildBlock(-3,5,-4,Blocks.planks,0);
		bb.buildBlock(-3,5,-3,Blocks.planks,0);bb.buildBlock(-3,5,-2,Blocks.planks,0);bb.buildBlock(-3,5,-1,Blocks.planks,0);
		bb.buildBlock(-3,5,0,Blocks.planks,0);bb.buildBlock(-3,5,1,Blocks.planks,0);bb.buildBlock(-3,5,2,Blocks.planks,0);
		bb.buildBlock(-3,5,3,Blocks.planks,0);bb.buildBlock(-3,5,4,Blocks.planks,0);bb.buildBlock(-3,5,5,Blocks.planks,0);
		bb.buildBlock(-2,5,-5,Blocks.planks,0);bb.buildBlock(-2,5,-4,Blocks.planks,0);bb.buildBlock(-2,5,-3,Blocks.planks,0);
		bb.buildBlock(-2,5,-2,Blocks.planks,0);bb.buildBlock(-2,5,-1,Blocks.planks,0);bb.buildBlock(-2,5,0,Blocks.planks,0);
		bb.buildBlock(-2,5,1,Blocks.planks,0);bb.buildBlock(-2,5,2,Blocks.planks,0);bb.buildBlock(-2,5,3,Blocks.planks,0);
		bb.buildBlock(-2,5,4,Blocks.planks,0);bb.buildBlock(-2,5,5,Blocks.planks,0);bb.buildBlock(-1,5,-5,Blocks.planks,0);
		bb.buildBlock(-1,5,-4,Blocks.planks,0);bb.buildBlock(-1,5,-3,Blocks.planks,0);bb.buildBlock(-1,5,-2,Blocks.planks,0);
		bb.buildBlock(-1,5,-1,Blocks.planks,0);bb.buildBlock(-1,5,0,Blocks.planks,0);bb.buildBlock(-1,5,1,Blocks.planks,0);
		bb.buildBlock(-1,5,2,Blocks.planks,0);bb.buildBlock(-1,5,3,Blocks.planks,0);bb.buildBlock(-1,5,4,Blocks.planks,0);
		bb.buildBlock(-1,5,5,Blocks.planks,0);bb.buildBlock(0,5,-5,Blocks.stone_slab,5);bb.buildBlock(0,5,-4,Blocks.stone_slab,5);
		bb.buildBlock(0,5,-3,Blocks.stone_slab,5);bb.buildBlock(0,5,-2,Blocks.stone_slab,5);bb.buildBlock(0,5,-1,Blocks.stone_slab,5);
		bb.buildBlock(0,5,0,Blocks.stone_slab,5);bb.buildBlock(0,5,1,Blocks.stone_slab,5);bb.buildBlock(0,5,2,Blocks.stone_slab,5);
		bb.buildBlock(0,5,3,Blocks.stone_slab,5);bb.buildBlock(0,5,4,Blocks.stone_slab,5);bb.buildBlock(0,5,5,Blocks.stone_slab,5);
		bb.buildBlock(1,5,-5,Blocks.stone_slab,5);bb.buildBlock(1,5,-4,Blocks.stone_slab,5);bb.buildBlock(1,5,0,Blocks.stone_slab,5);
		bb.buildBlock(1,5,1,Blocks.stone_slab,5);bb.buildBlock(1,5,2,Blocks.stone_slab,5);bb.buildBlock(1,5,3,Blocks.stone_slab,5);
		bb.buildBlock(1,5,4,Blocks.stone_slab,5);bb.buildBlock(1,5,5,Blocks.stone_slab,5);bb.buildBlock(2,5,-5,Blocks.stone_slab,5);
		bb.buildBlock(2,5,-4,Blocks.stone_slab,5);bb.buildBlock(2,5,-2,Blocks.stonebrick,0);bb.buildBlock(2,5,0,Blocks.stone_slab,5);
		bb.buildBlock(2,5,1,Blocks.stone_slab,5);bb.buildBlock(2,5,2,Blocks.stone_slab,5);bb.buildBlock(2,5,3,Blocks.stone_slab,5);
		bb.buildBlock(2,5,4,Blocks.stone_slab,5);bb.buildBlock(2,5,5,Blocks.stone_slab,5);bb.buildBlock(3,5,-5,Blocks.stone_slab,5);
		bb.buildBlock(3,5,-4,Blocks.stone_slab,5);bb.buildBlock(3,5,0,Blocks.stone_slab,5);bb.buildBlock(3,5,1,Blocks.stone_slab,5);
		bb.buildBlock(3,5,2,Blocks.stone_slab,5);bb.buildBlock(3,5,3,Blocks.stone_slab,5);bb.buildBlock(3,5,4,Blocks.stone_slab,5);
		bb.buildBlock(3,5,5,Blocks.stone_slab,5);bb.buildBlock(4,5,-5,Blocks.stone_slab,5);bb.buildBlock(4,5,-4,Blocks.stone_slab,5);
		bb.buildBlock(4,5,-3,Blocks.stone_slab,5);bb.buildBlock(4,5,-2,Blocks.stone_slab,5);bb.buildBlock(4,5,-1,Blocks.stone_slab,5);
		bb.buildBlock(4,5,0,Blocks.stone_slab,5);bb.buildBlock(4,5,1,Blocks.stone_slab,5);bb.buildBlock(4,5,2,Blocks.stone_slab,5);
		bb.buildBlock(4,5,3,Blocks.stone_slab,5);bb.buildBlock(4,5,4,Blocks.stone_slab,5);bb.buildBlock(4,5,5,Blocks.stone_slab,5);
		bb.buildBlock(5,5,-5,Blocks.stone_slab,5);bb.buildBlock(5,5,-4,Blocks.stone_slab,5);bb.buildBlock(5,5,-3,Blocks.stone_slab,5);
		bb.buildBlock(5,5,-2,Blocks.stone_slab,5);bb.buildBlock(5,5,-1,Blocks.stone_slab,5);bb.buildBlock(5,5,0,Blocks.stone_slab,5);
		bb.buildBlock(5,5,1,Blocks.stone_slab,5);bb.buildBlock(5,5,2,Blocks.stone_slab,5);bb.buildBlock(5,5,3,Blocks.stone_slab,5);
		bb.buildBlock(5,5,4,Blocks.stone_slab,5);bb.buildBlock(5,5,5,Blocks.stone_slab,5);bb.buildBlock(-2,-4,-3,Blocks.torch,1);
		bb.buildBlock(-2,-4,0,Blocks.torch,1);bb.buildBlock(3,-4,-3,Blocks.torch,2);bb.buildBlock(3,-4,0,Blocks.torch,2);
		bb.buildBlock(3,-4,3,Blocks.torch,2);bb.buildBlock(-1,-2,3,Blocks.torch,2);bb.buildBlock(-5,1,-3,Blocks.torch,5);
		bb.buildBlock(-5,1,0,Blocks.torch,5);bb.buildBlock(-3,1,5,Blocks.torch,5);bb.buildBlock(0,1,5,Blocks.torch,5);
		bb.buildBlock(1,1,-5,Blocks.torch,5);bb.buildBlock(3,1,5,Blocks.torch,5);bb.buildBlock(4,1,-5,Blocks.torch,5);
		bb.buildBlock(5,1,-3,Blocks.torch,5);bb.buildBlock(5,1,0,Blocks.torch,5);bb.buildBlock(5,1,3,Blocks.torch,5);
		bb.addEntityPainting(4,-5,-1,1,"Wasteland");
		bb.addEntityPainting(4,-5,1,1,"Plant");
	}

}
