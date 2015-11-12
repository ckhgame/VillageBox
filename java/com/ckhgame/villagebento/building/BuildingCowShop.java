package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerCowSeller;

import net.minecraft.init.Blocks;

public class BuildingCowShop extends Building {

	@Override
	public String getName() {
		return "Cow Products Shop";
	}

	@Override
	public String getDescription() {
		return "A sweet home for cows!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerCowSeller.class,"Miki",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-2,-1,-2,Blocks.grass,0);bb.buildBlock(-2,-1,-1,Blocks.grass,0);bb.buildBlock(-2,-1,0,Blocks.dirt,0);
		bb.buildBlock(-2,-1,1,Blocks.grass,0);bb.buildBlock(-2,-1,2,Blocks.grass,0);bb.buildBlock(-1,-1,-2,Blocks.grass,0);
		bb.buildBlock(-1,-1,-1,Blocks.grass,0);bb.buildBlock(-1,-1,0,Blocks.grass,0);bb.buildBlock(-1,-1,1,Blocks.grass,0);
		bb.buildBlock(-1,-1,2,Blocks.grass,0);bb.buildBlock(0,-1,-2,Blocks.grass,0);bb.buildBlock(0,-1,-1,Blocks.grass,0);
		bb.buildBlock(0,-1,0,Blocks.grass,0);bb.buildBlock(0,-1,1,Blocks.grass,0);bb.buildBlock(1,-1,-2,Blocks.grass,0);
		bb.buildBlock(1,-1,-1,Blocks.grass,0);bb.buildBlock(1,-1,0,Blocks.grass,0);bb.buildBlock(1,-1,1,Blocks.grass,0);
		bb.buildBlock(2,-1,-2,Blocks.grass,0);bb.buildBlock(2,-1,-1,Blocks.grass,0);bb.buildBlock(2,-1,0,Blocks.grass,0);
		bb.buildBlock(2,-1,1,Blocks.grass,0);bb.buildBlock(-3,0,-3,Blocks.fence,0);bb.buildBlock(-3,0,-2,Blocks.planks,0);
		bb.buildBlock(-3,0,-1,Blocks.planks,0);bb.buildBlock(-3,0,0,Blocks.planks,0);bb.buildBlock(-3,0,1,Blocks.planks,0);
		bb.buildBlock(-3,0,2,Blocks.planks,0);bb.buildBlock(-3,0,3,Blocks.fence,0);bb.buildBlock(-2,0,-3,Blocks.planks,0);
		bb.buildBlock(-2,0,-2,Blocks.double_plant,1);bb.buildBlock(-2,0,-1,Blocks.chest,5);bb.buildBlock(-2,0,0,Blocks.crafting_table,0);bb.buildBlock(-2,0,1,Blocks.birch_stairs,3);bb.buildBlock(-2,0,2,Blocks.wooden_slab,2);
		bb.buildBlock(-2,0,3,Blocks.planks,0);bb.buildBlock(-1,0,-3,Blocks.planks,0);bb.buildBlock(-1,0,-2,Blocks.double_plant,1);
		bb.buildBlock(-1,0,3,Blocks.planks,0);bb.buildBlock(0,0,-3,Blocks.planks,0);bb.buildBlock(0,0,-2,Blocks.double_plant,1);
		bb.buildBlock(0,0,2,Blocks.birch_stairs,1);bb.buildBlock(0,0,3,Blocks.planks,0);bb.buildBlock(1,0,-3,Blocks.planks,0);
		bb.buildBlock(1,0,-2,Blocks.double_plant,1);bb.buildBlock(1,0,2,Blocks.birch_stairs,2);bb.buildBlock(1,0,3,Blocks.planks,0);
		bb.buildBlock(2,0,-3,Blocks.planks,0);bb.buildBlock(2,0,-2,Blocks.double_plant,1);bb.buildBlock(2,0,2,Blocks.birch_stairs,0);
		bb.buildBlock(2,0,3,Blocks.planks,0);bb.buildBlock(3,0,-3,Blocks.fence,0);bb.buildBlock(3,0,-2,Blocks.planks,0);
		bb.buildBlock(3,0,-1,Blocks.planks,0);bb.buildBlock(3,0,0,Blocks.wooden_door,0);bb.buildBlock(3,0,1,Blocks.planks,0);
		bb.buildBlock(3,0,2,Blocks.planks,0);bb.buildBlock(3,0,3,Blocks.fence,0);bb.buildBlock(-3,1,-3,Blocks.fence,0);
		bb.buildBlock(-3,1,-2,Blocks.fence,0);bb.buildBlock(-3,1,-1,Blocks.fence,0);bb.buildBlock(-3,1,0,Blocks.fence,0);
		bb.buildBlock(-3,1,1,Blocks.fence,0);bb.buildBlock(-3,1,2,Blocks.fence,0);bb.buildBlock(-3,1,3,Blocks.fence,0);
		bb.buildBlock(-2,1,-3,Blocks.fence,0);bb.buildBlock(-2,1,-2,Blocks.double_plant,11);bb.buildBlock(-2,1,0,Blocks.birch_stairs,3);
		bb.buildBlock(-2,1,3,Blocks.fence,0);bb.buildBlock(-1,1,-3,Blocks.fence,0);bb.buildBlock(-1,1,-2,Blocks.double_plant,8);
		bb.buildBlock(-1,1,3,Blocks.fence,0);bb.buildBlock(0,1,-3,Blocks.fence,0);bb.buildBlock(0,1,-2,Blocks.double_plant,8);
		bb.buildBlock(0,1,3,Blocks.fence,0);bb.buildBlock(1,1,-3,Blocks.fence,0);bb.buildBlock(1,1,-2,Blocks.double_plant,8);
		bb.buildBlock(1,1,3,Blocks.fence,0);bb.buildBlock(2,1,-3,Blocks.fence,0);bb.buildBlock(2,1,-2,Blocks.double_plant,8);
		bb.buildBlock(2,1,3,Blocks.fence,0);bb.buildBlock(3,1,-3,Blocks.fence,0);bb.buildBlock(3,1,-2,Blocks.fence,0);
		bb.buildBlock(3,1,-1,Blocks.planks,0);bb.buildBlock(3,1,0,Blocks.wooden_door,8);bb.buildBlock(3,1,1,Blocks.planks,0);
		bb.buildBlock(3,1,2,Blocks.fence,0);bb.buildBlock(3,1,3,Blocks.fence,0);bb.buildBlock(-3,2,-3,Blocks.fence,0);
		bb.buildBlock(-3,2,3,Blocks.fence,0);bb.buildBlock(-2,2,-1,Blocks.birch_stairs,3);bb.buildBlock(3,2,-3,Blocks.fence,0);
		bb.buildBlock(3,2,-1,Blocks.planks,0);bb.buildBlock(3,2,0,Blocks.planks,0);bb.buildBlock(3,2,1,Blocks.planks,0);
		bb.buildBlock(3,2,3,Blocks.fence,0);bb.buildBlock(-3,3,-3,Blocks.planks,1);bb.buildBlock(-3,3,-2,Blocks.planks,1);
		bb.buildBlock(-3,3,-1,Blocks.planks,1);bb.buildBlock(-3,3,0,Blocks.planks,1);bb.buildBlock(-3,3,1,Blocks.planks,1);
		bb.buildBlock(-3,3,2,Blocks.planks,1);bb.buildBlock(-3,3,3,Blocks.planks,1);bb.buildBlock(-2,3,-3,Blocks.planks,1);
		bb.buildBlock(-2,3,-2,Blocks.birch_stairs,3);bb.buildBlock(-2,3,2,Blocks.planks,2);bb.buildBlock(-2,3,3,Blocks.planks,1);
		bb.buildBlock(-1,3,-3,Blocks.planks,1);bb.buildBlock(-1,3,-2,Blocks.planks,2);bb.buildBlock(-1,3,-1,Blocks.planks,2);
		bb.buildBlock(-1,3,0,Blocks.planks,2);bb.buildBlock(-1,3,1,Blocks.planks,2);bb.buildBlock(-1,3,2,Blocks.planks,2);
		bb.buildBlock(-1,3,3,Blocks.planks,1);bb.buildBlock(0,3,-3,Blocks.planks,1);bb.buildBlock(0,3,-2,Blocks.planks,2);
		bb.buildBlock(0,3,-1,Blocks.planks,2);bb.buildBlock(0,3,0,Blocks.planks,2);bb.buildBlock(0,3,1,Blocks.planks,2);
		bb.buildBlock(0,3,2,Blocks.planks,2);bb.buildBlock(0,3,3,Blocks.planks,1);bb.buildBlock(1,3,-3,Blocks.planks,1);
		bb.buildBlock(1,3,-2,Blocks.planks,2);bb.buildBlock(1,3,-1,Blocks.planks,2);bb.buildBlock(1,3,0,Blocks.planks,2);
		bb.buildBlock(1,3,1,Blocks.planks,2);bb.buildBlock(1,3,2,Blocks.planks,2);bb.buildBlock(1,3,3,Blocks.planks,1);
		bb.buildBlock(2,3,-3,Blocks.planks,1);bb.buildBlock(2,3,-2,Blocks.planks,2);bb.buildBlock(2,3,-1,Blocks.planks,2);
		bb.buildBlock(2,3,0,Blocks.planks,2);bb.buildBlock(2,3,1,Blocks.planks,2);bb.buildBlock(2,3,2,Blocks.planks,2);
		bb.buildBlock(2,3,3,Blocks.planks,1);bb.buildBlock(3,3,-3,Blocks.planks,1);bb.buildBlock(3,3,-2,Blocks.planks,1);
		bb.buildBlock(3,3,-1,Blocks.planks,1);bb.buildBlock(3,3,0,Blocks.planks,1);bb.buildBlock(3,3,1,Blocks.planks,1);
		bb.buildBlock(3,3,2,Blocks.planks,1);bb.buildBlock(3,3,3,Blocks.planks,1);bb.buildBlock(-3,4,-3,Blocks.planks,0);
		bb.buildBlock(-3,4,-2,Blocks.planks,0);bb.buildBlock(-3,4,-1,Blocks.planks,0);bb.buildBlock(-3,4,0,Blocks.planks,0);
		bb.buildBlock(-3,4,1,Blocks.planks,0);bb.buildBlock(-3,4,2,Blocks.planks,0);bb.buildBlock(-3,4,3,Blocks.planks,0);
		bb.buildBlock(-2,4,-3,Blocks.planks,0);bb.buildBlock(-2,4,3,Blocks.planks,0);bb.buildBlock(-1,4,-3,Blocks.planks,0);
		bb.buildBlock(-1,4,3,Blocks.planks,0);bb.buildBlock(0,4,-3,Blocks.planks,0);bb.buildBlock(0,4,-2,Blocks.carpet,14);
		bb.buildBlock(0,4,-1,Blocks.carpet,14);bb.buildBlock(0,4,0,Blocks.carpet,14);bb.buildBlock(0,4,1,Blocks.carpet,14);
		bb.buildBlock(0,4,2,Blocks.carpet,14);bb.buildBlock(0,4,3,Blocks.planks,0);bb.buildBlock(1,4,-3,Blocks.planks,0);
		bb.buildBlock(1,4,-2,Blocks.carpet,14);bb.buildBlock(1,4,-1,Blocks.carpet,14);bb.buildBlock(1,4,0,Blocks.carpet,14);
		bb.buildBlock(1,4,1,Blocks.carpet,14);bb.buildBlock(1,4,2,Blocks.carpet,14);bb.buildBlock(1,4,3,Blocks.planks,0);
		bb.buildBlock(2,4,-3,Blocks.planks,0);bb.buildBlock(2,4,-2,Blocks.carpet,14);bb.buildBlock(2,4,-1,Blocks.bed,10);
		bb.buildBlock(2,4,0,Blocks.bed,2);bb.buildBlock(2,4,1,Blocks.carpet,14);bb.buildBlock(2,4,2,Blocks.carpet,14);
		bb.buildBlock(2,4,3,Blocks.planks,0);bb.buildBlock(3,4,-3,Blocks.planks,0);bb.buildBlock(3,4,-2,Blocks.planks,0);
		bb.buildBlock(3,4,-1,Blocks.planks,0);bb.buildBlock(3,4,0,Blocks.planks,0);bb.buildBlock(3,4,1,Blocks.planks,0);
		bb.buildBlock(3,4,2,Blocks.planks,0);bb.buildBlock(3,4,3,Blocks.planks,0);bb.buildBlock(-3,5,-3,Blocks.planks,0);
		bb.buildBlock(-3,5,-2,Blocks.planks,0);bb.buildBlock(-3,5,-1,Blocks.planks,0);bb.buildBlock(-3,5,0,Blocks.planks,0);
		bb.buildBlock(-3,5,1,Blocks.planks,0);bb.buildBlock(-3,5,2,Blocks.planks,0);bb.buildBlock(-3,5,3,Blocks.planks,0);
		bb.buildBlock(-2,5,-3,Blocks.planks,0);bb.buildBlock(-2,5,3,Blocks.planks,0);bb.buildBlock(-1,5,-3,Blocks.planks,0);
		bb.buildBlock(-1,5,3,Blocks.planks,0);bb.buildBlock(0,5,-3,Blocks.planks,0);bb.buildBlock(0,5,3,Blocks.planks,0);
		bb.buildBlock(1,5,-3,Blocks.planks,0);bb.buildBlock(1,5,3,Blocks.planks,0);bb.buildBlock(2,5,-3,Blocks.planks,0);
		bb.buildBlock(2,5,3,Blocks.planks,0);bb.buildBlock(3,5,-3,Blocks.planks,0);bb.buildBlock(3,5,-2,Blocks.glass_pane,0);
		bb.buildBlock(3,5,-1,Blocks.glass_pane,0);bb.buildBlock(3,5,0,Blocks.glass_pane,0);bb.buildBlock(3,5,1,Blocks.glass_pane,0);
		bb.buildBlock(3,5,2,Blocks.glass_pane,0);bb.buildBlock(3,5,3,Blocks.planks,0);bb.buildBlock(-3,6,-3,Blocks.planks,0);
		bb.buildBlock(-3,6,-2,Blocks.planks,0);bb.buildBlock(-3,6,-1,Blocks.planks,0);bb.buildBlock(-3,6,0,Blocks.planks,0);
		bb.buildBlock(-3,6,1,Blocks.planks,0);bb.buildBlock(-3,6,2,Blocks.planks,0);bb.buildBlock(-3,6,3,Blocks.planks,0);
		bb.buildBlock(-2,6,-3,Blocks.planks,0);bb.buildBlock(-2,6,3,Blocks.planks,0);bb.buildBlock(-1,6,-3,Blocks.planks,0);
		bb.buildBlock(-1,6,3,Blocks.planks,0);bb.buildBlock(0,6,-3,Blocks.planks,0);bb.buildBlock(0,6,3,Blocks.planks,0);
		bb.buildBlock(1,6,-3,Blocks.planks,0);bb.buildBlock(1,6,3,Blocks.planks,0);bb.buildBlock(2,6,-3,Blocks.planks,0);
		bb.buildBlock(2,6,3,Blocks.planks,0);bb.buildBlock(3,6,-3,Blocks.planks,0);bb.buildBlock(3,6,-2,Blocks.planks,0);
		bb.buildBlock(3,6,-1,Blocks.planks,0);bb.buildBlock(3,6,0,Blocks.planks,0);bb.buildBlock(3,6,1,Blocks.planks,0);
		bb.buildBlock(3,6,2,Blocks.planks,0);bb.buildBlock(3,6,3,Blocks.planks,0);bb.buildBlock(-3,7,-3,Blocks.dark_oak_stairs,2);
		bb.buildBlock(-3,7,-2,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,-1,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,0,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-3,7,1,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,2,Blocks.dark_oak_stairs,0);bb.buildBlock(-3,7,3,Blocks.dark_oak_stairs,0);
		bb.buildBlock(-2,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(-2,7,-2,Blocks.wooden_slab,2);bb.buildBlock(-2,7,-1,Blocks.wooden_slab,2);
		bb.buildBlock(-2,7,0,Blocks.wooden_slab,2);bb.buildBlock(-2,7,1,Blocks.wooden_slab,2);bb.buildBlock(-2,7,2,Blocks.wooden_slab,2);
		bb.buildBlock(-2,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(-1,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(-1,7,-2,Blocks.wooden_slab,2);
		bb.buildBlock(-1,7,-1,Blocks.wooden_slab,2);bb.buildBlock(-1,7,0,Blocks.wooden_slab,2);bb.buildBlock(-1,7,1,Blocks.wooden_slab,2);
		bb.buildBlock(-1,7,2,Blocks.wooden_slab,2);bb.buildBlock(-1,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(0,7,-3,Blocks.dark_oak_stairs,2);
		bb.buildBlock(0,7,-2,Blocks.wooden_slab,2);bb.buildBlock(0,7,-1,Blocks.wooden_slab,2);bb.buildBlock(0,7,0,Blocks.wooden_slab,2);
		bb.buildBlock(0,7,1,Blocks.wooden_slab,2);bb.buildBlock(0,7,2,Blocks.wooden_slab,2);bb.buildBlock(0,7,3,Blocks.dark_oak_stairs,3);
		bb.buildBlock(1,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(1,7,-2,Blocks.wooden_slab,2);bb.buildBlock(1,7,-1,Blocks.wooden_slab,2);
		bb.buildBlock(1,7,0,Blocks.wooden_slab,2);bb.buildBlock(1,7,1,Blocks.wooden_slab,2);bb.buildBlock(1,7,2,Blocks.wooden_slab,2);
		bb.buildBlock(1,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(2,7,-3,Blocks.dark_oak_stairs,2);bb.buildBlock(2,7,-2,Blocks.wooden_slab,2);
		bb.buildBlock(2,7,-1,Blocks.wooden_slab,2);bb.buildBlock(2,7,0,Blocks.wooden_slab,2);bb.buildBlock(2,7,1,Blocks.wooden_slab,2);
		bb.buildBlock(2,7,2,Blocks.wooden_slab,2);bb.buildBlock(2,7,3,Blocks.dark_oak_stairs,3);bb.buildBlock(3,7,-3,Blocks.dark_oak_stairs,1);
		bb.buildBlock(3,7,-2,Blocks.dark_oak_stairs,1);bb.buildBlock(3,7,-1,Blocks.dark_oak_stairs,1);bb.buildBlock(3,7,0,Blocks.dark_oak_stairs,1);
		bb.buildBlock(3,7,1,Blocks.dark_oak_stairs,1);bb.buildBlock(3,7,2,Blocks.dark_oak_stairs,1);bb.buildBlock(3,7,3,Blocks.dark_oak_stairs,1);
		bb.buildBlock(-3,2,-2,Blocks.torch,5);bb.buildBlock(-3,2,0,Blocks.torch,5);bb.buildBlock(-3,2,2,Blocks.torch,5);
		bb.buildBlock(-2,2,-3,Blocks.torch,5);bb.buildBlock(-2,2,3,Blocks.torch,5);bb.buildBlock(0,2,-3,Blocks.torch,5);
		bb.buildBlock(0,2,3,Blocks.torch,5);bb.buildBlock(2,2,-3,Blocks.torch,5);bb.buildBlock(2,2,3,Blocks.torch,5);
		bb.buildBlock(3,2,2,Blocks.torch,5);bb.buildBlock(-2,6,-2,Blocks.torch,1);bb.buildBlock(-2,6,2,Blocks.torch,1);
		bb.buildBlock(0,6,-2,Blocks.torch,3);bb.buildBlock(0,6,2,Blocks.torch,4);bb.buildBlock(2,6,-2,Blocks.torch,2);
		bb.buildBlock(2,6,2,Blocks.torch,2);bb.addEntityPainting(-3,5,1,3,"Kebab");
		bb.addEntityPainting(-3,5,0,3,"Sea");
	}

}
