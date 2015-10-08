package com.ckhgame.villagebento.builders;

import com.ckhgame.villagebento.data.BuildingData;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BuildingBuilder {

	private static BuildingData buildingData;
	private static World world;
	private static int facing;
	
	/**
	 * 
	 * @param w
	 * @param facing 0=East, 1=South, 2=West, 3=North.
	 * @param bd
	 */
	private static void beginBuild(World w, EntityPlayer player, BuildingData bd){
		world = w;
		buildingData = bd;
		
		//calculate facing
		
		int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		facing = (l + 1)%4;
	}
	
	private static void buildOneBlock(int dx,int dy,int dz,Block block){
		
		int fx = dx;
		int fy = dy;
		int fz = dz;
		
		switch(facing){
		case 1://North
			fx = -dz;
			fz = dx;
			break;
		case 2://West
			fx = -dx;
			fz = -dz;
			break;
		case 3://South
			fx = dz;
			fz = -dx;
		case 0://East
			break;
			default://East
				break;
		}
		
		
		world.setBlock(	buildingData.x+fx,
						buildingData.y+fy,
						buildingData.z+fz,
						block);
	}
	
	public static void BuildAHouse(World world,EntityPlayer player,BuildingData bd){
		
		BaseBuilder.buildGroundwork(world, bd);
		beginBuild(world,player,bd);
		
		buildOneBlock(-1,-2,-1,Blocks.water);buildOneBlock(-1,-2,0,Blocks.water);buildOneBlock(-1,-2,1,Blocks.water);
		buildOneBlock(0,-2,-1,Blocks.water);buildOneBlock(0,-2,0,Blocks.water);buildOneBlock(0,-2,1,Blocks.water);
		buildOneBlock(1,-2,-1,Blocks.water);buildOneBlock(1,-2,0,Blocks.water);buildOneBlock(1,-2,1,Blocks.water);
		buildOneBlock(-2,-1,-1,Blocks.planks);buildOneBlock(-2,-1,0,Blocks.planks);buildOneBlock(-2,-1,1,Blocks.planks);
		buildOneBlock(-1,-1,-2,Blocks.planks);buildOneBlock(-1,-1,-1,Blocks.water);buildOneBlock(-1,-1,0,Blocks.water);
		buildOneBlock(-1,-1,1,Blocks.water);buildOneBlock(-1,-1,2,Blocks.planks);buildOneBlock(0,-1,-2,Blocks.planks);
		buildOneBlock(0,-1,-1,Blocks.water);buildOneBlock(0,-1,0,Blocks.water);buildOneBlock(0,-1,1,Blocks.water);
		buildOneBlock(0,-1,2,Blocks.planks);buildOneBlock(1,-1,-2,Blocks.planks);buildOneBlock(1,-1,-1,Blocks.water);
		buildOneBlock(1,-1,0,Blocks.water);buildOneBlock(1,-1,1,Blocks.water);buildOneBlock(1,-1,2,Blocks.planks);
		buildOneBlock(2,-1,-1,Blocks.planks);buildOneBlock(2,-1,0,Blocks.planks);buildOneBlock(2,-1,1,Blocks.planks);
		buildOneBlock(-1,0,-2,Blocks.air);buildOneBlock(-1,0,-1,Blocks.air);buildOneBlock(-1,0,0,Blocks.air);
		buildOneBlock(-1,0,1,Blocks.air);buildOneBlock(-1,0,2,Blocks.air);buildOneBlock(0,0,-2,Blocks.air);
		buildOneBlock(0,0,-1,Blocks.air);buildOneBlock(0,0,0,Blocks.air);buildOneBlock(0,0,1,Blocks.air);
		buildOneBlock(0,0,2,Blocks.air);buildOneBlock(1,0,-2,Blocks.air);buildOneBlock(1,0,-1,Blocks.air);
		buildOneBlock(1,0,0,Blocks.air);buildOneBlock(1,0,1,Blocks.air);buildOneBlock(1,0,2,Blocks.air);
		buildOneBlock(-5,1,-5,Blocks.glass);buildOneBlock(-5,1,-4,Blocks.glass);buildOneBlock(-5,1,-3,Blocks.glass);
		buildOneBlock(-5,1,-2,Blocks.glass);buildOneBlock(-5,1,-1,Blocks.glass);buildOneBlock(-5,1,0,Blocks.glass);
		buildOneBlock(-5,1,1,Blocks.glass);buildOneBlock(-5,1,2,Blocks.glass);buildOneBlock(-5,1,3,Blocks.glass);
		buildOneBlock(-5,1,4,Blocks.glass);buildOneBlock(-5,1,5,Blocks.glass);buildOneBlock(-4,1,-5,Blocks.glass);
		buildOneBlock(-4,1,-4,Blocks.planks);buildOneBlock(-4,1,-3,Blocks.planks);buildOneBlock(-4,1,-2,Blocks.planks);
		buildOneBlock(-4,1,-1,Blocks.planks);buildOneBlock(-4,1,0,Blocks.planks);buildOneBlock(-4,1,1,Blocks.planks);
		buildOneBlock(-4,1,2,Blocks.planks);buildOneBlock(-4,1,3,Blocks.planks);buildOneBlock(-4,1,4,Blocks.planks);
		buildOneBlock(-4,1,5,Blocks.glass);buildOneBlock(-3,1,-5,Blocks.glass);buildOneBlock(-3,1,5,Blocks.glass);
		buildOneBlock(-2,1,-5,Blocks.glass);buildOneBlock(-2,1,5,Blocks.glass);buildOneBlock(-1,1,-5,Blocks.glass);
		buildOneBlock(-1,1,5,Blocks.glass);buildOneBlock(0,1,-5,Blocks.glass);buildOneBlock(0,1,5,Blocks.glass);
		buildOneBlock(1,1,-5,Blocks.glass);buildOneBlock(1,1,5,Blocks.glass);buildOneBlock(2,1,-5,Blocks.glass);
		buildOneBlock(2,1,5,Blocks.glass);buildOneBlock(3,1,-5,Blocks.glass);buildOneBlock(3,1,5,Blocks.glass);
		buildOneBlock(4,1,-5,Blocks.glass);buildOneBlock(4,1,-3,Blocks.glass);buildOneBlock(4,1,0,Blocks.glass);
		buildOneBlock(4,1,1,Blocks.glass);buildOneBlock(4,1,2,Blocks.glass);buildOneBlock(4,1,3,Blocks.glass);
		buildOneBlock(4,1,5,Blocks.glass);buildOneBlock(5,1,-5,Blocks.glass);buildOneBlock(5,1,-4,Blocks.glass);
		buildOneBlock(5,1,-3,Blocks.glass);buildOneBlock(5,1,0,Blocks.glass);buildOneBlock(5,1,1,Blocks.glass);
		buildOneBlock(5,1,2,Blocks.glass);buildOneBlock(5,1,3,Blocks.glass);buildOneBlock(5,1,4,Blocks.glass);
		buildOneBlock(5,1,5,Blocks.glass);buildOneBlock(-4,2,-1,Blocks.planks);buildOneBlock(-4,2,1,Blocks.planks);
		
		/*buildOneBlock(-2,-4,-2,Blocks.torch);buildOneBlock(-2,-4,-1,Blocks.air);buildOneBlock(-2,-4,0,Blocks.air);
		buildOneBlock(-2,-4,1,Blocks.air);buildOneBlock(-2,-4,2,Blocks.air);buildOneBlock(-1,-4,-2,Blocks.trapped_chest);
		buildOneBlock(-1,-4,-1,Blocks.air);buildOneBlock(-1,-4,0,Blocks.air);buildOneBlock(-1,-4,1,Blocks.air);
		buildOneBlock(-1,-4,2,Blocks.air);buildOneBlock(-2,-3,-2,Blocks.air);buildOneBlock(-2,-3,-1,Blocks.air);
		buildOneBlock(-2,-3,0,Blocks.air);buildOneBlock(-2,-3,1,Blocks.air);buildOneBlock(-2,-3,2,Blocks.air);
		buildOneBlock(-1,-3,-2,Blocks.air);buildOneBlock(-1,-3,-1,Blocks.air);buildOneBlock(-1,-3,0,Blocks.air);
		buildOneBlock(-1,-3,1,Blocks.air);buildOneBlock(-1,-3,2,Blocks.air);buildOneBlock(0,-3,0,Blocks.air);
		buildOneBlock(0,-3,1,Blocks.air);buildOneBlock(0,-3,2,Blocks.air);buildOneBlock(1,-3,2,Blocks.air);
		buildOneBlock(-2,-2,-2,Blocks.glass);buildOneBlock(-2,-2,-1,Blocks.air);buildOneBlock(-2,-2,0,Blocks.air);
		buildOneBlock(-2,-2,1,Blocks.air);buildOneBlock(-2,-2,2,Blocks.air);buildOneBlock(-1,-2,-2,Blocks.glass);
		buildOneBlock(-1,-2,-1,Blocks.air);buildOneBlock(-1,-2,0,Blocks.air);buildOneBlock(-1,-2,1,Blocks.air);
		buildOneBlock(-1,-2,2,Blocks.air);buildOneBlock(0,-2,0,Blocks.air);buildOneBlock(0,-2,1,Blocks.air);
		buildOneBlock(0,-2,2,Blocks.air);buildOneBlock(1,-2,1,Blocks.air);buildOneBlock(1,-2,2,Blocks.air);
		buildOneBlock(-2,-1,0,Blocks.torch);buildOneBlock(-2,-1,1,Blocks.air);buildOneBlock(-2,-1,2,Blocks.torch);
		buildOneBlock(-1,-1,0,Blocks.air);buildOneBlock(-1,-1,1,Blocks.air);buildOneBlock(-1,-1,2,Blocks.air);
		buildOneBlock(0,-1,1,Blocks.air);buildOneBlock(0,-1,2,Blocks.air);buildOneBlock(1,-1,0,Blocks.air);
		buildOneBlock(1,-1,1,Blocks.air);buildOneBlock(1,-1,2,Blocks.torch);buildOneBlock(1,0,-1,Blocks.air);
		buildOneBlock(1,0,0,Blocks.air);buildOneBlock(1,0,1,Blocks.torch);buildOneBlock(-3,1,-3,Blocks.planks);
		buildOneBlock(-3,1,-2,Blocks.planks);buildOneBlock(-3,1,-1,Blocks.planks);buildOneBlock(-3,1,0,Blocks.planks);
		buildOneBlock(-3,1,1,Blocks.planks);buildOneBlock(-3,1,2,Blocks.planks);buildOneBlock(-3,1,3,Blocks.planks);
		buildOneBlock(-2,1,-3,Blocks.planks);buildOneBlock(-2,1,3,Blocks.planks);buildOneBlock(-1,1,-3,Blocks.planks);
		buildOneBlock(-1,1,3,Blocks.planks);buildOneBlock(0,1,-3,Blocks.planks);buildOneBlock(0,1,3,Blocks.planks);
		buildOneBlock(1,1,-3,Blocks.planks);buildOneBlock(1,1,3,Blocks.planks);buildOneBlock(2,1,-3,Blocks.planks);
		buildOneBlock(2,1,3,Blocks.planks);buildOneBlock(3,1,-3,Blocks.planks);buildOneBlock(3,1,-2,Blocks.planks);
		buildOneBlock(3,1,-1,Blocks.planks);buildOneBlock(3,1,1,Blocks.planks);buildOneBlock(3,1,2,Blocks.planks);
		buildOneBlock(3,1,3,Blocks.planks);buildOneBlock(-3,2,-3,Blocks.stone);buildOneBlock(-3,2,-2,Blocks.stone);
		buildOneBlock(-3,2,-1,Blocks.stone);buildOneBlock(-3,2,0,Blocks.stone);buildOneBlock(-3,2,1,Blocks.stone);
		buildOneBlock(-3,2,2,Blocks.stone);buildOneBlock(-3,2,3,Blocks.stone);buildOneBlock(-2,2,-3,Blocks.stone);
		buildOneBlock(-2,2,3,Blocks.stone);buildOneBlock(-1,2,-3,Blocks.stone);buildOneBlock(-1,2,3,Blocks.stone);
		buildOneBlock(0,2,-3,Blocks.stone);buildOneBlock(0,2,3,Blocks.stone);buildOneBlock(1,2,-3,Blocks.stone);
		buildOneBlock(1,2,3,Blocks.stone);buildOneBlock(2,2,-3,Blocks.stone);buildOneBlock(2,2,3,Blocks.stone);
		buildOneBlock(3,2,-3,Blocks.stone);buildOneBlock(3,2,-2,Blocks.stone);buildOneBlock(3,2,-1,Blocks.stone);
		buildOneBlock(3,2,1,Blocks.stone);buildOneBlock(3,2,2,Blocks.stone);buildOneBlock(3,2,3,Blocks.stone);
		buildOneBlock(-3,3,-3,Blocks.planks);buildOneBlock(-3,3,-2,Blocks.planks);buildOneBlock(-3,3,-1,Blocks.planks);
		buildOneBlock(-3,3,0,Blocks.planks);buildOneBlock(-3,3,1,Blocks.glass);buildOneBlock(-3,3,2,Blocks.planks);
		buildOneBlock(-3,3,3,Blocks.glass);buildOneBlock(-2,3,-3,Blocks.glass);buildOneBlock(-2,3,3,Blocks.glass);
		buildOneBlock(-1,3,-3,Blocks.planks);buildOneBlock(-1,3,3,Blocks.planks);buildOneBlock(0,3,-3,Blocks.glass);
		buildOneBlock(0,3,3,Blocks.glass);buildOneBlock(1,3,-3,Blocks.planks);buildOneBlock(1,3,3,Blocks.planks);
		buildOneBlock(2,3,-3,Blocks.glass);buildOneBlock(2,3,3,Blocks.glass);buildOneBlock(3,3,-3,Blocks.planks);
		buildOneBlock(3,3,-2,Blocks.glass);buildOneBlock(3,3,-1,Blocks.planks);buildOneBlock(3,3,1,Blocks.planks);
		buildOneBlock(3,3,2,Blocks.glass);buildOneBlock(3,3,3,Blocks.planks);buildOneBlock(-3,4,-3,Blocks.planks);
		buildOneBlock(-3,4,-2,Blocks.planks);buildOneBlock(-3,4,-1,Blocks.planks);buildOneBlock(-3,4,0,Blocks.planks);
		buildOneBlock(-3,4,1,Blocks.planks);buildOneBlock(-3,4,2,Blocks.planks);buildOneBlock(-3,4,3,Blocks.planks);
		buildOneBlock(-2,4,-3,Blocks.planks);buildOneBlock(-2,4,3,Blocks.planks);buildOneBlock(-1,4,-3,Blocks.planks);
		buildOneBlock(-1,4,3,Blocks.planks);buildOneBlock(0,4,-3,Blocks.planks);buildOneBlock(0,4,3,Blocks.planks);
		buildOneBlock(1,4,-3,Blocks.planks);buildOneBlock(1,4,3,Blocks.planks);buildOneBlock(2,4,-3,Blocks.planks);
		buildOneBlock(2,4,3,Blocks.planks);buildOneBlock(3,4,-3,Blocks.planks);buildOneBlock(3,4,-2,Blocks.planks);
		buildOneBlock(3,4,-1,Blocks.planks);buildOneBlock(3,4,0,Blocks.planks);buildOneBlock(3,4,1,Blocks.planks);
		buildOneBlock(3,4,2,Blocks.planks);buildOneBlock(3,4,3,Blocks.planks);buildOneBlock(-2,5,-2,Blocks.planks);
		buildOneBlock(-2,5,-1,Blocks.planks);buildOneBlock(-2,5,0,Blocks.planks);buildOneBlock(-2,5,1,Blocks.planks);
		buildOneBlock(-2,5,2,Blocks.planks);buildOneBlock(-1,5,-2,Blocks.stone);buildOneBlock(-1,5,-1,Blocks.stone);
		buildOneBlock(-1,5,0,Blocks.stone);buildOneBlock(-1,5,1,Blocks.stone);buildOneBlock(-1,5,2,Blocks.stone);
		buildOneBlock(0,5,-2,Blocks.stone);buildOneBlock(0,5,-1,Blocks.stone);buildOneBlock(0,5,0,Blocks.stone);
		buildOneBlock(0,5,1,Blocks.stone);buildOneBlock(0,5,2,Blocks.stone);buildOneBlock(1,5,-2,Blocks.stone);
		buildOneBlock(1,5,-1,Blocks.stone);buildOneBlock(1,5,0,Blocks.stone);buildOneBlock(1,5,1,Blocks.stone);
		buildOneBlock(1,5,2,Blocks.stone);buildOneBlock(2,5,-2,Blocks.planks);buildOneBlock(2,5,-1,Blocks.planks);
		buildOneBlock(2,5,0,Blocks.planks);buildOneBlock(2,5,1,Blocks.planks);buildOneBlock(2,5,2,Blocks.planks);
		buildOneBlock(3,5,-2,Blocks.planks);buildOneBlock(3,5,-1,Blocks.planks);buildOneBlock(3,5,0,Blocks.planks);
		buildOneBlock(3,5,1,Blocks.planks);buildOneBlock(3,5,2,Blocks.planks);buildOneBlock(0,6,-2,Blocks.stone);
		buildOneBlock(0,6,0,Blocks.stone);buildOneBlock(0,6,2,Blocks.stone);*/
		
	}
	
}
