package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerFlowerShopOwner;

import net.minecraft.init.Blocks;

public class BuildingFlowerShop extends Building {

	@Override
	public String getName() {
		return "Flower Shop";
	}

	@Override
	public String getDescription() {
		return "Flowers is always a best gift!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerFlowerShopOwner.class,"Tina",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,-1,-3,Blocks.grass,0);bb.buildBlock(-3,-1,-2,Blocks.grass,0);bb.buildBlock(-3,-1,-1,Blocks.grass,0);
		bb.buildBlock(-3,-1,0,Blocks.grass,0);bb.buildBlock(-3,-1,1,Blocks.grass,0);bb.buildBlock(-3,-1,2,Blocks.grass,0);
		bb.buildBlock(-3,-1,3,Blocks.grass,0);bb.buildBlock(-2,-1,-3,Blocks.grass,0);bb.buildBlock(-2,-1,3,Blocks.grass,0);
		bb.buildBlock(-1,-1,-3,Blocks.grass,0);bb.buildBlock(-1,-1,3,Blocks.grass,0);bb.buildBlock(0,-1,-3,Blocks.grass,0);
		bb.buildBlock(0,-1,3,Blocks.grass,0);bb.buildBlock(1,-1,-3,Blocks.grass,0);bb.buildBlock(1,-1,3,Blocks.grass,0);
		bb.buildBlock(2,-1,-3,Blocks.grass,0);bb.buildBlock(2,-1,3,Blocks.grass,0);bb.buildBlock(3,-1,-3,Blocks.grass,0);
		bb.buildBlock(3,-1,-2,Blocks.grass,0);bb.buildBlock(3,-1,2,Blocks.grass,0);bb.buildBlock(3,-1,3,Blocks.grass,0);
		bb.buildBlock(-3,0,-3,Blocks.double_plant,4);bb.buildBlock(-3,0,-2,Blocks.double_plant,4);bb.buildBlock(-3,0,-1,Blocks.double_plant,4);
		bb.buildBlock(-3,0,0,Blocks.double_plant,4);bb.buildBlock(-3,0,1,Blocks.double_plant,4);bb.buildBlock(-3,0,2,Blocks.double_plant,4);
		bb.buildBlock(-3,0,3,Blocks.double_plant,4);bb.buildBlock(-2,0,-3,Blocks.double_plant,4);bb.buildBlock(-2,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,-1,Blocks.stonebrick,0);bb.buildBlock(-2,0,0,Blocks.stonebrick,0);bb.buildBlock(-2,0,1,Blocks.stonebrick,0);
		bb.buildBlock(-2,0,2,Blocks.stonebrick,0);bb.buildBlock(-2,0,3,Blocks.double_plant,4);bb.buildBlock(-1,0,-3,Blocks.double_plant,4);
		bb.buildBlock(-1,0,-2,Blocks.stonebrick,0);bb.buildBlock(-1,0,-1,Blocks.planks,3);bb.buildBlock(-1,0,0,Blocks.planks,3);
		bb.buildBlock(-1,0,1,Blocks.planks,3);bb.buildBlock(-1,0,2,Blocks.stonebrick,0);bb.buildBlock(-1,0,3,Blocks.double_plant,4);
		bb.buildBlock(0,0,-3,Blocks.double_plant,4);bb.buildBlock(0,0,-2,Blocks.stonebrick,0);bb.buildBlock(0,0,-1,Blocks.bookshelf,0);
		bb.buildBlock(0,0,0,Blocks.flower_pot,3);bb.addTileEntityPot(0,0,0,38,3);
		bb.buildBlock(0,0,1,Blocks.jungle_stairs,1);bb.buildBlock(0,0,2,Blocks.stonebrick,0);bb.buildBlock(0,0,3,Blocks.double_plant,4);
		bb.buildBlock(1,0,-3,Blocks.double_plant,4);bb.buildBlock(1,0,-2,Blocks.stonebrick,0);bb.buildBlock(1,0,2,Blocks.stonebrick,0);
		bb.buildBlock(1,0,3,Blocks.double_plant,4);bb.buildBlock(2,0,-3,Blocks.double_plant,4);bb.buildBlock(2,0,-2,Blocks.stonebrick,0);
		bb.buildBlock(2,0,-1,Blocks.stonebrick,0);bb.buildBlock(2,0,0,Blocks.wooden_door,0);bb.buildBlock(2,0,1,Blocks.stonebrick,0);
		bb.buildBlock(2,0,2,Blocks.stonebrick,0);bb.buildBlock(2,0,3,Blocks.double_plant,4);bb.buildBlock(3,0,-3,Blocks.double_plant,4);
		bb.buildBlock(3,0,-2,Blocks.double_plant,4);bb.buildBlock(3,0,-1,Blocks.fence,0);bb.buildBlock(3,0,1,Blocks.fence,0);
		bb.buildBlock(3,0,2,Blocks.double_plant,4);bb.buildBlock(3,0,3,Blocks.double_plant,4);bb.buildBlock(-3,1,-3,Blocks.double_plant,8);
		bb.buildBlock(-3,1,-2,Blocks.double_plant,11);bb.buildBlock(-3,1,-1,Blocks.double_plant,10);bb.buildBlock(-3,1,0,Blocks.double_plant,11);
		bb.buildBlock(-3,1,1,Blocks.double_plant,11);bb.buildBlock(-3,1,2,Blocks.double_plant,10);bb.buildBlock(-3,1,3,Blocks.double_plant,10);
		bb.buildBlock(-2,1,-3,Blocks.double_plant,8);bb.buildBlock(-2,1,-2,Blocks.planks,3);bb.buildBlock(-2,1,-1,Blocks.glass_pane,0);
		bb.buildBlock(-2,1,0,Blocks.glass_pane,0);bb.buildBlock(-2,1,1,Blocks.glass_pane,0);bb.buildBlock(-2,1,2,Blocks.planks,3);
		bb.buildBlock(-2,1,3,Blocks.double_plant,10);bb.buildBlock(-1,1,-3,Blocks.double_plant,10);bb.buildBlock(-1,1,-2,Blocks.glass_pane,0);
		bb.buildBlock(-1,1,-1,Blocks.planks,3);bb.buildBlock(-1,1,0,Blocks.planks,3);bb.buildBlock(-1,1,1,Blocks.jungle_stairs,3);
		bb.buildBlock(-1,1,2,Blocks.glass_pane,0);bb.buildBlock(-1,1,3,Blocks.double_plant,10);bb.buildBlock(0,1,-3,Blocks.double_plant,10);
		bb.buildBlock(0,1,-2,Blocks.glass_pane,0);bb.buildBlock(0,1,2,Blocks.glass_pane,0);bb.buildBlock(0,1,3,Blocks.double_plant,10);
		bb.buildBlock(1,1,-3,Blocks.double_plant,10);bb.buildBlock(1,1,-2,Blocks.glass_pane,0);bb.buildBlock(1,1,2,Blocks.glass_pane,0);
		bb.buildBlock(1,1,3,Blocks.double_plant,10);bb.buildBlock(2,1,-3,Blocks.double_plant,10);bb.buildBlock(2,1,-2,Blocks.planks,3);
		bb.buildBlock(2,1,-1,Blocks.fence,0);bb.buildBlock(2,1,0,Blocks.wooden_door,8);bb.buildBlock(2,1,1,Blocks.fence,0);
		bb.buildBlock(2,1,2,Blocks.planks,3);bb.buildBlock(2,1,3,Blocks.double_plant,9);bb.buildBlock(3,1,-3,Blocks.double_plant,10);
		bb.buildBlock(3,1,-2,Blocks.double_plant,8);bb.buildBlock(3,1,2,Blocks.double_plant,11);bb.buildBlock(3,1,3,Blocks.double_plant,9);
		bb.buildBlock(-3,2,-2,Blocks.vine,8);bb.buildBlock(-3,2,2,Blocks.vine,8);bb.buildBlock(-2,2,-3,Blocks.vine,1);
		bb.buildBlock(-2,2,-2,Blocks.planks,3);bb.buildBlock(-2,2,-1,Blocks.glass_pane,0);bb.buildBlock(-2,2,0,Blocks.glass_pane,0);
		bb.buildBlock(-2,2,1,Blocks.glass_pane,0);bb.buildBlock(-2,2,2,Blocks.planks,3);bb.buildBlock(-2,2,3,Blocks.vine,4);
		bb.buildBlock(-1,2,-2,Blocks.glass_pane,0);bb.buildBlock(-1,2,-1,Blocks.planks,3);bb.buildBlock(-1,2,0,Blocks.jungle_stairs,3);
		bb.buildBlock(-1,2,2,Blocks.glass_pane,0);bb.buildBlock(0,2,-2,Blocks.glass_pane,0);bb.buildBlock(0,2,2,Blocks.glass_pane,0);
		bb.buildBlock(1,2,-2,Blocks.glass_pane,0);bb.buildBlock(1,2,2,Blocks.glass_pane,0);bb.buildBlock(2,2,-3,Blocks.vine,1);
		bb.buildBlock(2,2,-2,Blocks.planks,3);bb.buildBlock(2,2,-1,Blocks.planks,3);bb.buildBlock(2,2,0,Blocks.planks,3);
		bb.buildBlock(2,2,1,Blocks.planks,3);bb.buildBlock(2,2,2,Blocks.planks,3);bb.buildBlock(2,2,3,Blocks.vine,4);
		bb.buildBlock(3,2,-2,Blocks.vine,2);bb.buildBlock(3,2,2,Blocks.vine,2);bb.buildBlock(-3,3,-2,Blocks.vine,8);
		bb.buildBlock(-3,3,2,Blocks.vine,8);bb.buildBlock(-2,3,-3,Blocks.vine,1);bb.buildBlock(-2,3,-2,Blocks.planks,3);
		bb.buildBlock(-2,3,-1,Blocks.glass_pane,0);bb.buildBlock(-2,3,0,Blocks.glass_pane,0);bb.buildBlock(-2,3,1,Blocks.glass_pane,0);
		bb.buildBlock(-2,3,2,Blocks.planks,3);bb.buildBlock(-1,3,-2,Blocks.glass_pane,0);bb.buildBlock(-1,3,-1,Blocks.jungle_stairs,3);
		bb.buildBlock(-1,3,2,Blocks.glass_pane,0);bb.buildBlock(0,3,-2,Blocks.glass_pane,0);bb.buildBlock(0,3,2,Blocks.glass_pane,0);
		bb.buildBlock(1,3,-2,Blocks.glass_pane,0);bb.buildBlock(1,3,2,Blocks.glass_pane,0);bb.buildBlock(2,3,-3,Blocks.vine,1);
		bb.buildBlock(2,3,-2,Blocks.planks,3);bb.buildBlock(2,3,-1,Blocks.glass_pane,0);bb.buildBlock(2,3,0,Blocks.glass_pane,0);
		bb.buildBlock(2,3,1,Blocks.glass_pane,0);bb.buildBlock(2,3,2,Blocks.planks,3);bb.buildBlock(2,3,3,Blocks.vine,4);
		bb.buildBlock(3,3,-2,Blocks.vine,2);bb.buildBlock(3,3,2,Blocks.vine,2);bb.buildBlock(-2,4,-2,Blocks.double_wooden_slab,3);
		bb.buildBlock(-2,4,-1,Blocks.double_wooden_slab,3);bb.buildBlock(-2,4,0,Blocks.double_wooden_slab,3);bb.buildBlock(-2,4,1,Blocks.double_wooden_slab,3);
		bb.buildBlock(-2,4,2,Blocks.double_wooden_slab,3);bb.buildBlock(-1,4,-2,Blocks.double_wooden_slab,3);bb.buildBlock(-1,4,2,Blocks.double_wooden_slab,3);
		bb.buildBlock(0,4,-2,Blocks.double_wooden_slab,3);bb.buildBlock(0,4,-1,Blocks.wooden_slab,3);bb.buildBlock(0,4,0,Blocks.wooden_slab,3);
		bb.buildBlock(0,4,1,Blocks.wooden_slab,3);bb.buildBlock(0,4,2,Blocks.double_wooden_slab,3);bb.buildBlock(1,4,-2,Blocks.double_wooden_slab,3);
		bb.buildBlock(1,4,-1,Blocks.double_wooden_slab,3);bb.buildBlock(1,4,0,Blocks.double_wooden_slab,3);bb.buildBlock(1,4,1,Blocks.planks,3);
		bb.buildBlock(1,4,2,Blocks.double_wooden_slab,3);bb.buildBlock(2,4,-2,Blocks.double_wooden_slab,3);bb.buildBlock(2,4,-1,Blocks.double_wooden_slab,3);
		bb.buildBlock(2,4,0,Blocks.double_wooden_slab,3);bb.buildBlock(2,4,1,Blocks.double_wooden_slab,3);bb.buildBlock(2,4,2,Blocks.double_wooden_slab,3);
		bb.buildBlock(-2,5,-2,Blocks.planks,3);bb.buildBlock(-2,5,-1,Blocks.glass_pane,0);bb.buildBlock(-2,5,0,Blocks.glass_pane,0);
		bb.buildBlock(-2,5,1,Blocks.glass_pane,0);bb.buildBlock(-2,5,2,Blocks.planks,3);bb.buildBlock(-1,5,-2,Blocks.glass_pane,0);
		bb.buildBlock(-1,5,2,Blocks.glass_pane,0);bb.buildBlock(0,5,-2,Blocks.glass_pane,0);bb.buildBlock(0,5,2,Blocks.glass_pane,0);
		bb.buildBlock(1,5,-2,Blocks.glass_pane,0);bb.buildBlock(1,5,-1,Blocks.bed,10);bb.buildBlock(1,5,0,Blocks.bed,2);
		bb.buildBlock(1,5,1,Blocks.flower_pot,2);bb.addTileEntityPot(1,5,1,38,2);
		bb.buildBlock(1,5,2,Blocks.glass_pane,0);bb.buildBlock(2,5,-2,Blocks.planks,3);bb.buildBlock(2,5,-1,Blocks.glass_pane,0);
		bb.buildBlock(2,5,0,Blocks.glass_pane,0);bb.buildBlock(2,5,1,Blocks.glass_pane,0);bb.buildBlock(2,5,2,Blocks.planks,3);
		bb.buildBlock(-2,6,-2,Blocks.planks,3);bb.buildBlock(-2,6,-1,Blocks.glass_pane,0);bb.buildBlock(-2,6,0,Blocks.glass_pane,0);
		bb.buildBlock(-2,6,1,Blocks.glass_pane,0);bb.buildBlock(-2,6,2,Blocks.planks,3);bb.buildBlock(-1,6,-2,Blocks.glass_pane,0);
		bb.buildBlock(-1,6,2,Blocks.glass_pane,0);bb.buildBlock(0,6,-2,Blocks.glass_pane,0);bb.buildBlock(0,6,2,Blocks.glass_pane,0);
		bb.buildBlock(1,6,-2,Blocks.glass_pane,0);bb.buildBlock(1,6,2,Blocks.glass_pane,0);bb.buildBlock(2,6,-2,Blocks.planks,3);
		bb.buildBlock(2,6,-1,Blocks.glass_pane,0);bb.buildBlock(2,6,0,Blocks.glass_pane,0);bb.buildBlock(2,6,1,Blocks.glass_pane,0);
		bb.buildBlock(2,6,2,Blocks.planks,3);bb.buildBlock(-3,7,-2,Blocks.wooden_slab,3);bb.buildBlock(-3,7,-1,Blocks.wooden_slab,3);
		bb.buildBlock(-3,7,0,Blocks.wooden_slab,3);bb.buildBlock(-3,7,1,Blocks.wooden_slab,3);bb.buildBlock(-3,7,2,Blocks.wooden_slab,3);
		bb.buildBlock(-2,7,-3,Blocks.wooden_slab,3);bb.buildBlock(-2,7,-2,Blocks.jungle_stairs,2);bb.buildBlock(-2,7,-1,Blocks.jungle_stairs,0);
		bb.buildBlock(-2,7,0,Blocks.jungle_stairs,0);bb.buildBlock(-2,7,1,Blocks.jungle_stairs,0);bb.buildBlock(-2,7,2,Blocks.jungle_stairs,0);
		bb.buildBlock(-2,7,3,Blocks.wooden_slab,3);bb.buildBlock(-1,7,-3,Blocks.wooden_slab,3);bb.buildBlock(-1,7,-2,Blocks.jungle_stairs,2);
		bb.buildBlock(-1,7,-1,Blocks.glass,0);bb.buildBlock(-1,7,0,Blocks.glass,0);bb.buildBlock(-1,7,1,Blocks.glass,0);
		bb.buildBlock(-1,7,2,Blocks.jungle_stairs,3);bb.buildBlock(-1,7,3,Blocks.wooden_slab,3);bb.buildBlock(0,7,-3,Blocks.wooden_slab,3);
		bb.buildBlock(0,7,-2,Blocks.jungle_stairs,2);bb.buildBlock(0,7,-1,Blocks.glass,0);bb.buildBlock(0,7,0,Blocks.glass,0);
		bb.buildBlock(0,7,1,Blocks.glass,0);bb.buildBlock(0,7,2,Blocks.jungle_stairs,3);bb.buildBlock(0,7,3,Blocks.wooden_slab,3);
		bb.buildBlock(1,7,-3,Blocks.wooden_slab,3);bb.buildBlock(1,7,-2,Blocks.jungle_stairs,2);bb.buildBlock(1,7,-1,Blocks.glass,0);
		bb.buildBlock(1,7,0,Blocks.glass,0);bb.buildBlock(1,7,1,Blocks.glass,0);bb.buildBlock(1,7,2,Blocks.jungle_stairs,3);
		bb.buildBlock(1,7,3,Blocks.wooden_slab,3);bb.buildBlock(2,7,-3,Blocks.wooden_slab,3);bb.buildBlock(2,7,-2,Blocks.jungle_stairs,2);
		bb.buildBlock(2,7,-1,Blocks.jungle_stairs,1);bb.buildBlock(2,7,0,Blocks.jungle_stairs,1);bb.buildBlock(2,7,1,Blocks.jungle_stairs,1);
		bb.buildBlock(2,7,2,Blocks.jungle_stairs,3);bb.buildBlock(2,7,3,Blocks.wooden_slab,3);bb.buildBlock(3,7,-2,Blocks.wooden_slab,3);
		bb.buildBlock(3,7,-1,Blocks.wooden_slab,3);bb.buildBlock(3,7,0,Blocks.wooden_slab,3);bb.buildBlock(3,7,1,Blocks.wooden_slab,3);
		bb.buildBlock(3,7,2,Blocks.wooden_slab,3);bb.buildBlock(-2,8,-2,Blocks.fence,0);bb.buildBlock(-2,8,2,Blocks.fence,0);
		bb.buildBlock(2,8,-2,Blocks.fence,0);bb.buildBlock(2,8,2,Blocks.fence,0);bb.buildBlock(3,1,-1,Blocks.torch,5);
		bb.buildBlock(3,1,1,Blocks.torch,5);bb.buildBlock(0,2,-1,Blocks.torch,1);bb.buildBlock(-3,4,-2,Blocks.torch,2);
		bb.buildBlock(-3,4,2,Blocks.torch,2);bb.buildBlock(-2,4,-3,Blocks.torch,4);bb.buildBlock(-2,4,3,Blocks.torch,3);
		bb.buildBlock(2,4,-3,Blocks.torch,4);bb.buildBlock(2,4,3,Blocks.torch,3);bb.buildBlock(3,4,-2,Blocks.torch,1);
		bb.buildBlock(3,4,2,Blocks.torch,1);bb.buildBlock(-2,9,-2,Blocks.torch,5);bb.buildBlock(-2,9,2,Blocks.torch,5);
		bb.buildBlock(2,9,-2,Blocks.torch,5);bb.buildBlock(2,9,2,Blocks.torch,5);bb.addEntityItemFrame(2,2,0,3,175);
		bb.addEntityItemFrame(-1,1,0,3,175);
		bb.addEntityItemFrame(-1,1,-1,3,175);

	}

}
