package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.villager.VillagerMiner;
import com.ckhgame.villagebento.villager.VillagerVillageElder;

import net.minecraft.init.Blocks;

public class BuildingVillageCenter extends Building {

	@Override
	public String getName() {
		return "Village Center";
	}

	@Override
	public String getDescription() {
		return "Welcome to the Village Center! Starting your cute village from here....";
	}

	@Override
	protected boolean canBuild() {
		return true;
	}
	
	@Override
	protected void generateVillagers(BuildingBuilder bb) {
		// TODO Auto-generated method stub
		//add villager
		bb.addBuildingVillager(VillagerVillageElder.class,"Rober",0,0);
	}

	@Override
	public int getSizeType() {
		return ConfigBuilding.SizeType_Small;
	}

	@Override
	protected void buildBlocks(BuildingBuilder bb) {

		bb.buildBlock(-3,0,-3,Blocks.flower_pot,0);bb.addTileEntityPot(-3,0,-3,0,0);
		bb.buildBlock(-3,0,3,Blocks.flower_pot,1);bb.addTileEntityPot(-3,0,3,38,1);
		bb.buildBlock(2,0,-2,Blocks.planks,0);bb.buildBlock(2,0,-1,Blocks.planks,0);bb.buildBlock(2,0,0,Blocks.planks,0);
		bb.buildBlock(2,0,1,Blocks.planks,0);bb.buildBlock(2,0,2,Blocks.planks,0);bb.buildBlock(3,0,-3,Blocks.flower_pot,0);
		bb.addTileEntityPot(3,0,-3,0,0);
		bb.buildBlock(3,0,3,Blocks.flower_pot,0);bb.addTileEntityPot(3,0,3,0,0);
		bb.buildBlock(2,1,-2,Blocks.planks,0);bb.buildBlock(2,1,-1,Blocks.planks,0);bb.buildBlock(2,1,0,Blocks.planks,0);
		bb.buildBlock(2,1,1,Blocks.planks,0);bb.buildBlock(2,1,2,Blocks.planks,0);bb.buildBlock(2,2,-2,Blocks.planks,0);
		bb.buildBlock(2,2,-1,Blocks.planks,0);bb.buildBlock(2,2,0,Blocks.planks,0);bb.buildBlock(2,2,1,Blocks.planks,0);
		bb.buildBlock(2,2,2,Blocks.planks,0);bb.buildBlock(1,3,-2,Blocks.wall_sign,4);bb.addTileEntitySign(1,3,-2,"ggg1","222","3","444");
		bb.buildBlock(1,3,-1,Blocks.wall_sign,4);bb.addTileEntitySign(1,3,-1,"asdas","bbbb","ccc","ddddddaa");
		bb.buildBlock(2,3,-2,Blocks.planks,0);bb.buildBlock(2,3,-1,Blocks.planks,0);bb.buildBlock(2,3,0,Blocks.planks,0);
		bb.buildBlock(2,3,1,Blocks.planks,0);bb.buildBlock(2,3,2,Blocks.planks,0);bb.addEntityPainting(2,3,0,1,"Aztec2");
		bb.addEntityPainting(2,2,1,1,"Graham");
		bb.addEntityPainting(2,0,1,1,"SkullAndRoses");
		bb.addEntityItemFrame(2,2,-2,1,4096);
		bb.addEntityItemFrame(2,2,-1,1,392);
		bb.addEntityItemFrame(2,1,-2,1,176);
		bb.addEntityItemFrame(2,1,-1,1,390);
	}

}
