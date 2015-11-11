package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerSheepSeller;

import net.minecraft.init.Blocks;

public class BuildingSheepShop extends Building {

	@Override
	public String getName() {
		return "Sheep Products Shop";
	}

	@Override
	public String getDescription() {
		return "A sweet home for sheep!";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerSheepSeller.class,"Mayo",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {
		bb.buildBlock(-3,0,-3,Blocks.planks,0);bb.buildBlock(-3,0,-2,Blocks.planks,0);bb.buildBlock(-3,0,-1,Blocks.planks,0);
		bb.buildBlock(-3,0,0,Blocks.planks,0);bb.buildBlock(-3,0,1,Blocks.planks,0);bb.buildBlock(-3,0,2,Blocks.planks,0);
		bb.buildBlock(-3,0,3,Blocks.planks,0);bb.buildBlock(-2,0,-3,Blocks.planks,0);bb.buildBlock(-2,0,-2,Blocks.wool,14);
		bb.buildBlock(-2,0,-1,Blocks.wool,14);bb.buildBlock(-2,0,0,Blocks.wool,14);bb.buildBlock(-2,0,1,Blocks.wool,0);
		bb.buildBlock(-2,0,2,Blocks.wool,0);bb.buildBlock(-2,0,3,Blocks.planks,0);bb.buildBlock(-1,0,-3,Blocks.planks,0);
		bb.buildBlock(-1,0,-2,Blocks.wool,14);bb.buildBlock(-1,0,-1,Blocks.wool,14);bb.buildBlock(-1,0,0,Blocks.bed,0);
		bb.buildBlock(-1,0,1,Blocks.bed,8);bb.buildBlock(-1,0,2,Blocks.wool,0);bb.buildBlock(-1,0,3,Blocks.planks,0);
		bb.buildBlock(0,0,-3,Blocks.planks,0);bb.buildBlock(0,0,-2,Blocks.birch_stairs,3);bb.buildBlock(0,0,-1,Blocks.wooden_slab,2);
		bb.buildBlock(0,0,0,Blocks.wooden_slab,2);bb.buildBlock(0,0,1,Blocks.wooden_slab,2);bb.buildBlock(0,0,2,Blocks.birch_stairs,2);
		bb.buildBlock(0,0,3,Blocks.planks,0);bb.buildBlock(1,0,-3,Blocks.planks,0);bb.buildBlock(1,0,-2,Blocks.chest,3);
		bb.buildBlock(1,0,2,Blocks.birch_stairs,2);bb.buildBlock(1,0,3,Blocks.planks,0);bb.buildBlock(2,0,-3,Blocks.planks,0);
		bb.buildBlock(2,0,-2,Blocks.crafting_table,0);bb.buildBlock(2,0,2,Blocks.double_wooden_slab,2);bb.buildBlock(2,0,3,Blocks.planks,0);
		bb.buildBlock(3,0,-3,Blocks.planks,0);bb.buildBlock(3,0,-2,Blocks.planks,0);bb.buildBlock(3,0,-1,Blocks.planks,0);
		bb.buildBlock(3,0,0,Blocks.wooden_door,0);bb.buildBlock(3,0,1,Blocks.planks,0);bb.buildBlock(3,0,2,Blocks.planks,0);
		bb.buildBlock(3,0,3,Blocks.planks,0);bb.buildBlock(-3,1,-3,Blocks.fence,0);bb.buildBlock(-3,1,-2,Blocks.planks,2);
		bb.buildBlock(-3,1,-1,Blocks.planks,2);bb.buildBlock(-3,1,0,Blocks.planks,2);bb.buildBlock(-3,1,1,Blocks.planks,2);
		bb.buildBlock(-3,1,2,Blocks.planks,2);bb.buildBlock(-3,1,3,Blocks.fence,0);bb.buildBlock(-2,1,-3,Blocks.planks,2);
		bb.buildBlock(-2,1,3,Blocks.planks,2);bb.buildBlock(-1,1,-3,Blocks.planks,2);bb.buildBlock(-1,1,3,Blocks.planks,2);
		bb.buildBlock(0,1,-3,Blocks.planks,2);bb.buildBlock(0,1,3,Blocks.planks,2);bb.buildBlock(1,1,-3,Blocks.planks,2);
		bb.buildBlock(1,1,3,Blocks.planks,2);bb.buildBlock(2,1,-3,Blocks.planks,2);bb.buildBlock(2,1,2,Blocks.flower_pot,3);
		bb.addTileEntityPot(2,1,2,38,3);
		bb.buildBlock(2,1,3,Blocks.planks,2);bb.buildBlock(3,1,-3,Blocks.fence,0);bb.buildBlock(3,1,-2,Blocks.planks,2);
		bb.buildBlock(3,1,-1,Blocks.planks,0);bb.buildBlock(3,1,0,Blocks.wooden_door,8);bb.buildBlock(3,1,1,Blocks.planks,0);
		bb.buildBlock(3,1,2,Blocks.planks,2);bb.buildBlock(3,1,3,Blocks.fence,0);bb.buildBlock(-3,2,-2,Blocks.planks,2);
		bb.buildBlock(-3,2,-1,Blocks.planks,2);bb.buildBlock(-3,2,0,Blocks.planks,2);bb.buildBlock(-3,2,1,Blocks.planks,2);
		bb.buildBlock(-3,2,2,Blocks.planks,2);bb.buildBlock(-2,2,-3,Blocks.planks,2);bb.buildBlock(-2,2,3,Blocks.planks,2);
		bb.buildBlock(-1,2,-3,Blocks.planks,2);bb.buildBlock(-1,2,3,Blocks.planks,2);bb.buildBlock(0,2,-3,Blocks.glass_pane,0);
		bb.buildBlock(0,2,3,Blocks.glass_pane,0);bb.buildBlock(1,2,-3,Blocks.planks,2);bb.buildBlock(1,2,3,Blocks.planks,2);
		bb.buildBlock(2,2,-3,Blocks.planks,2);bb.buildBlock(2,2,3,Blocks.planks,2);bb.buildBlock(3,2,-2,Blocks.planks,2);
		bb.buildBlock(3,2,-1,Blocks.planks,0);bb.buildBlock(3,2,0,Blocks.planks,0);bb.buildBlock(3,2,1,Blocks.planks,0);
		bb.buildBlock(3,2,2,Blocks.planks,2);bb.buildBlock(-3,3,-3,Blocks.fence,0);bb.buildBlock(-3,3,-2,Blocks.planks,2);
		bb.buildBlock(-3,3,-1,Blocks.planks,2);bb.buildBlock(-3,3,0,Blocks.planks,2);bb.buildBlock(-3,3,1,Blocks.planks,2);
		bb.buildBlock(-3,3,2,Blocks.planks,2);bb.buildBlock(-3,3,3,Blocks.fence,0);bb.buildBlock(-2,3,-3,Blocks.planks,2);
		bb.buildBlock(-2,3,3,Blocks.planks,2);bb.buildBlock(-1,3,-3,Blocks.planks,2);bb.buildBlock(-1,3,3,Blocks.planks,2);
		bb.buildBlock(0,3,-3,Blocks.planks,2);bb.buildBlock(0,3,3,Blocks.planks,2);bb.buildBlock(1,3,-3,Blocks.planks,2);
		bb.buildBlock(1,3,3,Blocks.planks,2);bb.buildBlock(2,3,-3,Blocks.planks,2);bb.buildBlock(2,3,3,Blocks.planks,2);
		bb.buildBlock(3,3,-3,Blocks.fence,0);bb.buildBlock(3,3,-2,Blocks.planks,2);bb.buildBlock(3,3,-1,Blocks.planks,2);
		bb.buildBlock(3,3,0,Blocks.planks,2);bb.buildBlock(3,3,1,Blocks.planks,2);bb.buildBlock(3,3,2,Blocks.planks,2);
		bb.buildBlock(3,3,3,Blocks.fence,0);bb.buildBlock(-3,4,-3,Blocks.planks,0);bb.buildBlock(-3,4,-2,Blocks.planks,0);
		bb.buildBlock(-3,4,-1,Blocks.planks,0);bb.buildBlock(-3,4,0,Blocks.planks,0);bb.buildBlock(-3,4,1,Blocks.planks,0);
		bb.buildBlock(-3,4,2,Blocks.planks,0);bb.buildBlock(-3,4,3,Blocks.planks,0);bb.buildBlock(-2,4,-3,Blocks.planks,0);
		bb.buildBlock(-2,4,-2,Blocks.planks,1);bb.buildBlock(-2,4,-1,Blocks.planks,1);bb.buildBlock(-2,4,0,Blocks.planks,1);
		bb.buildBlock(-2,4,1,Blocks.planks,1);bb.buildBlock(-2,4,2,Blocks.planks,1);bb.buildBlock(-2,4,3,Blocks.planks,0);
		bb.buildBlock(-1,4,-3,Blocks.planks,0);bb.buildBlock(-1,4,-2,Blocks.planks,1);bb.buildBlock(-1,4,-1,Blocks.glass,0);
		bb.buildBlock(-1,4,0,Blocks.glass,0);bb.buildBlock(-1,4,1,Blocks.glass,0);bb.buildBlock(-1,4,2,Blocks.planks,1);
		bb.buildBlock(-1,4,3,Blocks.planks,0);bb.buildBlock(0,4,-3,Blocks.planks,0);bb.buildBlock(0,4,-2,Blocks.planks,1);
		bb.buildBlock(0,4,-1,Blocks.glass,0);bb.buildBlock(0,4,0,Blocks.glass,0);bb.buildBlock(0,4,1,Blocks.glass,0);
		bb.buildBlock(0,4,2,Blocks.planks,1);bb.buildBlock(0,4,3,Blocks.planks,0);bb.buildBlock(1,4,-3,Blocks.planks,0);
		bb.buildBlock(1,4,-2,Blocks.planks,1);bb.buildBlock(1,4,-1,Blocks.glass,0);bb.buildBlock(1,4,0,Blocks.glass,0);
		bb.buildBlock(1,4,1,Blocks.glass,0);bb.buildBlock(1,4,2,Blocks.planks,1);bb.buildBlock(1,4,3,Blocks.planks,0);
		bb.buildBlock(2,4,-3,Blocks.planks,0);bb.buildBlock(2,4,-2,Blocks.planks,1);bb.buildBlock(2,4,-1,Blocks.planks,1);
		bb.buildBlock(2,4,0,Blocks.planks,1);bb.buildBlock(2,4,1,Blocks.planks,1);bb.buildBlock(2,4,2,Blocks.planks,1);
		bb.buildBlock(2,4,3,Blocks.planks,0);bb.buildBlock(3,4,-3,Blocks.planks,0);bb.buildBlock(3,4,-2,Blocks.planks,0);
		bb.buildBlock(3,4,-1,Blocks.planks,0);bb.buildBlock(3,4,0,Blocks.planks,0);bb.buildBlock(3,4,1,Blocks.planks,0);
		bb.buildBlock(3,4,2,Blocks.planks,0);bb.buildBlock(3,4,3,Blocks.planks,0);bb.buildBlock(-3,2,-3,Blocks.torch,5);
		bb.buildBlock(-3,2,3,Blocks.torch,5);bb.buildBlock(3,2,-3,Blocks.torch,5);bb.buildBlock(3,2,3,Blocks.torch,5);
		bb.buildBlock(-2,3,-2,Blocks.torch,1);bb.buildBlock(-2,3,0,Blocks.torch,1);bb.buildBlock(-2,3,2,Blocks.torch,1);
		bb.buildBlock(0,3,-2,Blocks.torch,3);bb.buildBlock(0,3,2,Blocks.torch,4);bb.buildBlock(2,3,-2,Blocks.torch,2);
		bb.buildBlock(2,3,0,Blocks.torch,2);bb.buildBlock(2,3,2,Blocks.torch,2);bb.addEntityPainting(-3,2,1,3,"Aztec2");
		bb.addEntityPainting(-3,2,0,3,"Bomb");
		bb.addEntityPainting(-3,2,-1,3,"Wasteland");
	}

}
