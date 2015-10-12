package com.ckhgame.villagebento.builders;

import com.ckhgame.villagebento.data.BuildingData;
import com.ckhgame.villagebento.data.VillageBentoData;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BuildingBuilder {

	private static BuildingData buildingData;
	private static World world;
	private static EntityPlayer player;
	private static int x;
	private static int y;
	private static int z;
	private static int facing;
	
	/**
	 * 
	 * @param w
	 * @param facing 0=East, 1=South, 2=West, 3=North.
	 * @param bd
	 */
	private static boolean preBuild(int type, int sizetype){

		VillageBentoData villageBentoData = VillageBentoData.get(world);		

		buildingData = null;
		
		//check if there is a building exists on the current location
		BuildingData bd = villageBentoData.findBuildingData(x, y, z);
		if(bd == null){
			//if nothing existed on the current location, we should create a new one
			int sx = BuildingConfig.GroundWorkSmallSizeX;
			int sz = BuildingConfig.GroundWorkSmallSizeZ;
			if(sizetype == BuildingConfig.SizeType_Medium){
				sx = BuildingConfig.GroundWorkMediumSizeX;
				sz = BuildingConfig.GroundWorkMediumSizeZ;
			}
			else if(sizetype == BuildingConfig.SizeType_Large){
				sx = BuildingConfig.GroundWorkLargeSizeX;
				sz = BuildingConfig.GroundWorkLargeSizeZ;
			}
			
			bd = new BuildingData(x,z,sx,sz,y,type);
			buildingData = bd;
			boolean success = villageBentoData.addBuildingData(bd);
		
			if(success){
				//update data
				villageBentoData.markDirty();
				
				//calculate facing
				int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				facing = (l + 1)%4;
			}
			
			return success;
		}

		
		return false;
	}
	
	private static void buildOneBlock(int dx,int dy,int dz,Block block){
		
		int fx = -dx;
		int fy = dy;
		int fz = -dz;
		
		switch(facing){
		case 1://North
			fx = dz;
			fz = -dx;
			break;
		case 2://West
			fx = dx;
			fz = dz;
			break;
		case 3://South
			fx = -dz;
			fz = dx;
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
	
	public static void build(World w,EntityPlayer p,int x, int y, int z,int type){
		
		BuildingBuilder.world = w;
		BuildingBuilder.player = p;
		BuildingBuilder.x = x;
		BuildingBuilder.y = y;
		BuildingBuilder.z = z;
		
		switch(type){
		case BuildingData.Type_VillageCenter:buildVillageCenter();break;
		case BuildingData.Type_MiningHouse:buildMiningHouse();break;
		case BuildingData.Type_BlackSmithsShop:buildBlackSmithsShop();break;
		case BuildingData.Type_Bakery:buildBakery();break;
		default:break;
		}
	}
	
	private static void buildVillageCenter(){	
		if(preBuild(BuildingData.Type_VillageCenter,BuildingConfig.SizeType_Small)){
			BaseBuilder.buildGroundwork(world,buildingData);
			
			buildOneBlock(-2,0,-1,Blocks.planks);buildOneBlock(-2,0,0,Blocks.planks);buildOneBlock(-1,0,-1,Blocks.planks);
			buildOneBlock(-1,0,0,Blocks.planks);buildOneBlock(-1,0,1,Blocks.planks);buildOneBlock(0,0,-2,Blocks.planks);
			buildOneBlock(0,0,-1,Blocks.planks);buildOneBlock(0,0,0,Blocks.planks);buildOneBlock(0,0,1,Blocks.planks);
			buildOneBlock(0,0,2,Blocks.planks);buildOneBlock(1,0,-2,Blocks.planks);buildOneBlock(1,0,-1,Blocks.planks);
			buildOneBlock(1,0,0,Blocks.planks);buildOneBlock(1,0,1,Blocks.planks);buildOneBlock(1,0,2,Blocks.planks);
			buildOneBlock(2,0,0,Blocks.planks);buildOneBlock(2,0,1,Blocks.planks);buildOneBlock(-3,1,-3,Blocks.stonebrick);
			buildOneBlock(-3,1,-2,Blocks.stonebrick);buildOneBlock(-3,1,-1,Blocks.stonebrick);buildOneBlock(-3,1,0,Blocks.stonebrick);
			buildOneBlock(-3,1,1,Blocks.stonebrick);buildOneBlock(-3,1,2,Blocks.stonebrick);buildOneBlock(-3,1,3,Blocks.stonebrick);
			buildOneBlock(-2,1,-3,Blocks.stonebrick);buildOneBlock(-2,1,-2,Blocks.oak_stairs);buildOneBlock(-2,1,1,Blocks.oak_stairs);
			buildOneBlock(-2,1,2,Blocks.oak_stairs);buildOneBlock(-2,1,3,Blocks.stonebrick);buildOneBlock(-1,1,-3,Blocks.stonebrick);
			buildOneBlock(-1,1,-2,Blocks.oak_stairs);buildOneBlock(-1,1,2,Blocks.oak_stairs);buildOneBlock(-1,1,3,Blocks.stonebrick);
			buildOneBlock(0,1,-3,Blocks.stonebrick);buildOneBlock(0,1,3,Blocks.stonebrick);buildOneBlock(1,1,-3,Blocks.stonebrick);
			buildOneBlock(1,1,3,Blocks.stonebrick);buildOneBlock(2,1,-3,Blocks.stonebrick);buildOneBlock(2,1,-2,Blocks.stonebrick);
			buildOneBlock(2,1,-1,Blocks.stonebrick);buildOneBlock(2,1,0,Blocks.wooden_door);buildOneBlock(2,1,1,Blocks.wooden_door);
			buildOneBlock(2,1,2,Blocks.stonebrick);buildOneBlock(2,1,3,Blocks.stonebrick);buildOneBlock(3,1,-3,Blocks.fence);
			buildOneBlock(3,1,-2,Blocks.fence);buildOneBlock(3,1,-1,Blocks.fence);buildOneBlock(3,1,2,Blocks.fence);
			buildOneBlock(3,1,3,Blocks.fence);buildOneBlock(-3,2,-3,Blocks.planks);buildOneBlock(-3,2,-2,Blocks.glass_pane);
			buildOneBlock(-3,2,-1,Blocks.glass_pane);buildOneBlock(-3,2,0,Blocks.planks);buildOneBlock(-3,2,1,Blocks.planks);
			buildOneBlock(-3,2,2,Blocks.planks);buildOneBlock(-3,2,3,Blocks.planks);buildOneBlock(-2,2,-3,Blocks.planks);
			buildOneBlock(-2,2,3,Blocks.glass_pane);buildOneBlock(-1,2,-3,Blocks.planks);buildOneBlock(-1,2,3,Blocks.glass_pane);
			buildOneBlock(0,2,-3,Blocks.glass_pane);buildOneBlock(0,2,3,Blocks.planks);buildOneBlock(1,2,-3,Blocks.glass_pane);
			buildOneBlock(1,2,3,Blocks.planks);buildOneBlock(2,2,-3,Blocks.planks);buildOneBlock(2,2,-2,Blocks.planks);
			buildOneBlock(2,2,-1,Blocks.planks);buildOneBlock(2,2,0,Blocks.wooden_door);buildOneBlock(2,2,1,Blocks.wooden_door);
			buildOneBlock(2,2,2,Blocks.planks);buildOneBlock(2,2,3,Blocks.planks);buildOneBlock(-3,3,-3,Blocks.planks);
			buildOneBlock(-3,3,-2,Blocks.planks);buildOneBlock(-3,3,-1,Blocks.planks);buildOneBlock(-3,3,0,Blocks.planks);
			buildOneBlock(-3,3,1,Blocks.planks);buildOneBlock(-3,3,2,Blocks.planks);buildOneBlock(-3,3,3,Blocks.planks);
			buildOneBlock(-2,3,-3,Blocks.planks);buildOneBlock(-2,3,1,Blocks.torch);buildOneBlock(-2,3,3,Blocks.planks);
			buildOneBlock(-1,3,-3,Blocks.planks);buildOneBlock(-1,3,3,Blocks.planks);buildOneBlock(0,3,-3,Blocks.planks);
			buildOneBlock(0,3,3,Blocks.planks);buildOneBlock(1,3,-3,Blocks.planks);buildOneBlock(1,3,3,Blocks.planks);
			buildOneBlock(2,3,-3,Blocks.planks);buildOneBlock(2,3,-2,Blocks.planks);buildOneBlock(2,3,-1,Blocks.planks);
			buildOneBlock(2,3,0,Blocks.planks);buildOneBlock(2,3,1,Blocks.planks);buildOneBlock(2,3,2,Blocks.planks);
			buildOneBlock(2,3,3,Blocks.planks);buildOneBlock(-3,4,-2,Blocks.planks);buildOneBlock(-3,4,0,Blocks.planks);
			buildOneBlock(-3,4,2,Blocks.planks);buildOneBlock(-2,4,-2,Blocks.planks);buildOneBlock(-2,4,-1,Blocks.planks);
			buildOneBlock(-2,4,0,Blocks.planks);buildOneBlock(-2,4,1,Blocks.planks);buildOneBlock(-2,4,2,Blocks.planks);
			buildOneBlock(-1,4,-2,Blocks.planks);buildOneBlock(-1,4,2,Blocks.planks);buildOneBlock(0,4,-2,Blocks.planks);
			buildOneBlock(0,4,2,Blocks.planks);buildOneBlock(1,4,-2,Blocks.planks);buildOneBlock(1,4,-1,Blocks.planks);
			buildOneBlock(1,4,0,Blocks.planks);buildOneBlock(1,4,1,Blocks.planks);buildOneBlock(1,4,2,Blocks.planks);
			buildOneBlock(2,4,-2,Blocks.planks);buildOneBlock(2,4,0,Blocks.planks);buildOneBlock(2,4,2,Blocks.planks);
			buildOneBlock(-2,5,-1,Blocks.planks);buildOneBlock(-2,5,0,Blocks.planks);buildOneBlock(-2,5,1,Blocks.planks);
			buildOneBlock(-1,5,-1,Blocks.planks);buildOneBlock(-1,5,0,Blocks.planks);buildOneBlock(-1,5,1,Blocks.planks);
			buildOneBlock(0,5,-1,Blocks.planks);buildOneBlock(0,5,0,Blocks.planks);buildOneBlock(0,5,1,Blocks.planks);
			buildOneBlock(1,5,-1,Blocks.planks);buildOneBlock(1,5,0,Blocks.planks);buildOneBlock(1,5,1,Blocks.planks);
			buildOneBlock(-2,6,0,Blocks.planks);buildOneBlock(1,6,0,Blocks.planks);
		}
	}

	private static void buildMiningHouse(){
		if(preBuild(BuildingData.Type_MiningHouse,BuildingConfig.SizeType_Small)){
			BaseBuilder.buildGroundwork(world,buildingData);
			buildOneBlock(-2,1,-2,Blocks.stonebrick);buildOneBlock(-2,1,-1,Blocks.planks);buildOneBlock(-2,1,0,Blocks.planks);
			buildOneBlock(-2,1,1,Blocks.planks);buildOneBlock(-2,1,2,Blocks.stonebrick);buildOneBlock(-1,1,-2,Blocks.planks);
			buildOneBlock(-1,1,-1,Blocks.bed);buildOneBlock(-1,1,1,Blocks.trapped_chest);buildOneBlock(-1,1,2,Blocks.planks);
			buildOneBlock(0,1,-2,Blocks.planks);buildOneBlock(0,1,-1,Blocks.bed);buildOneBlock(0,1,2,Blocks.planks);
			buildOneBlock(1,1,-2,Blocks.planks);buildOneBlock(1,1,2,Blocks.planks);buildOneBlock(2,1,-2,Blocks.stonebrick);
			buildOneBlock(2,1,-1,Blocks.stonebrick);buildOneBlock(2,1,0,Blocks.wooden_door);buildOneBlock(2,1,1,Blocks.stonebrick);
			buildOneBlock(2,1,2,Blocks.stonebrick);buildOneBlock(-2,2,-2,Blocks.stonebrick);buildOneBlock(-2,2,-1,Blocks.planks);
			buildOneBlock(-2,2,0,Blocks.planks);buildOneBlock(-2,2,1,Blocks.planks);buildOneBlock(-2,2,2,Blocks.stonebrick);
			buildOneBlock(-1,2,-2,Blocks.glass);buildOneBlock(-1,2,2,Blocks.glass);buildOneBlock(0,2,-2,Blocks.glass);
			buildOneBlock(0,2,2,Blocks.glass);buildOneBlock(1,2,-2,Blocks.glass);buildOneBlock(1,2,2,Blocks.glass);
			buildOneBlock(2,2,-2,Blocks.stonebrick);buildOneBlock(2,2,-1,Blocks.stonebrick);buildOneBlock(2,2,0,Blocks.wooden_door);
			buildOneBlock(2,2,1,Blocks.stonebrick);buildOneBlock(2,2,2,Blocks.stonebrick);buildOneBlock(-2,3,-2,Blocks.stonebrick);
			buildOneBlock(-2,3,-1,Blocks.planks);buildOneBlock(-2,3,0,Blocks.planks);buildOneBlock(-2,3,1,Blocks.planks);
			buildOneBlock(-2,3,2,Blocks.stonebrick);buildOneBlock(-1,3,-2,Blocks.planks);buildOneBlock(-1,3,0,Blocks.torch);
			buildOneBlock(-1,3,2,Blocks.planks);buildOneBlock(0,3,-2,Blocks.planks);buildOneBlock(0,3,2,Blocks.planks);
			buildOneBlock(1,3,-2,Blocks.planks);buildOneBlock(1,3,2,Blocks.planks);buildOneBlock(2,3,-2,Blocks.stonebrick);
			buildOneBlock(2,3,-1,Blocks.stonebrick);buildOneBlock(2,3,0,Blocks.planks);buildOneBlock(2,3,1,Blocks.stonebrick);
			buildOneBlock(2,3,2,Blocks.stonebrick);buildOneBlock(-3,4,-3,Blocks.stonebrick);buildOneBlock(-3,4,-2,Blocks.stonebrick);
			buildOneBlock(-3,4,-1,Blocks.stonebrick);buildOneBlock(-3,4,0,Blocks.stonebrick);buildOneBlock(-3,4,1,Blocks.stonebrick);
			buildOneBlock(-3,4,2,Blocks.stonebrick);buildOneBlock(-3,4,3,Blocks.stonebrick);buildOneBlock(-2,4,-3,Blocks.stonebrick);
			buildOneBlock(-2,4,-2,Blocks.stonebrick);buildOneBlock(-2,4,-1,Blocks.stonebrick);buildOneBlock(-2,4,0,Blocks.stonebrick);
			buildOneBlock(-2,4,1,Blocks.stonebrick);buildOneBlock(-2,4,2,Blocks.stonebrick);buildOneBlock(-2,4,3,Blocks.stonebrick);
			buildOneBlock(-1,4,-3,Blocks.stonebrick);buildOneBlock(-1,4,-2,Blocks.stonebrick);buildOneBlock(-1,4,-1,Blocks.stonebrick);
			buildOneBlock(-1,4,0,Blocks.stonebrick);buildOneBlock(-1,4,1,Blocks.stonebrick);buildOneBlock(-1,4,2,Blocks.stonebrick);
			buildOneBlock(-1,4,3,Blocks.stonebrick);buildOneBlock(0,4,-3,Blocks.stonebrick);buildOneBlock(0,4,-2,Blocks.stonebrick);
			buildOneBlock(0,4,-1,Blocks.stonebrick);buildOneBlock(0,4,0,Blocks.stonebrick);buildOneBlock(0,4,1,Blocks.stonebrick);
			buildOneBlock(0,4,2,Blocks.stonebrick);buildOneBlock(0,4,3,Blocks.stonebrick);buildOneBlock(1,4,-3,Blocks.stonebrick);
			buildOneBlock(1,4,-2,Blocks.stonebrick);buildOneBlock(1,4,-1,Blocks.stonebrick);buildOneBlock(1,4,0,Blocks.stonebrick);
			buildOneBlock(1,4,1,Blocks.stonebrick);buildOneBlock(1,4,2,Blocks.stonebrick);buildOneBlock(1,4,3,Blocks.stonebrick);
			buildOneBlock(2,4,-3,Blocks.stonebrick);buildOneBlock(2,4,-2,Blocks.stonebrick);buildOneBlock(2,4,-1,Blocks.stonebrick);
			buildOneBlock(2,4,0,Blocks.stonebrick);buildOneBlock(2,4,1,Blocks.stonebrick);buildOneBlock(2,4,2,Blocks.stonebrick);
			buildOneBlock(2,4,3,Blocks.stonebrick);buildOneBlock(3,4,-3,Blocks.stonebrick);buildOneBlock(3,4,-2,Blocks.stonebrick);
			buildOneBlock(3,4,-1,Blocks.stonebrick);buildOneBlock(3,4,0,Blocks.stonebrick);buildOneBlock(3,4,1,Blocks.stonebrick);
			buildOneBlock(3,4,2,Blocks.stonebrick);buildOneBlock(3,4,3,Blocks.stonebrick);buildOneBlock(-2,5,-2,Blocks.stonebrick);
			buildOneBlock(-2,5,-1,Blocks.stonebrick);buildOneBlock(-2,5,0,Blocks.stonebrick);buildOneBlock(-2,5,1,Blocks.stonebrick);
			buildOneBlock(-2,5,2,Blocks.stonebrick);buildOneBlock(-1,5,-2,Blocks.stonebrick);buildOneBlock(-1,5,2,Blocks.stonebrick);
			buildOneBlock(0,5,-2,Blocks.stonebrick);buildOneBlock(0,5,2,Blocks.stonebrick);buildOneBlock(1,5,-2,Blocks.stonebrick);
			buildOneBlock(1,5,2,Blocks.stonebrick);buildOneBlock(2,5,-2,Blocks.stonebrick);buildOneBlock(2,5,-1,Blocks.stonebrick);
			buildOneBlock(2,5,0,Blocks.stonebrick);buildOneBlock(2,5,1,Blocks.stonebrick);buildOneBlock(2,5,2,Blocks.stonebrick);
		}
	}
	
	private static void buildBlackSmithsShop(){
		if(preBuild(BuildingData.Type_BlackSmithsShop,BuildingConfig.SizeType_Small)){
			BaseBuilder.buildGroundwork(world,buildingData);
			buildOneBlock(-3,1,-3,Blocks.stonebrick);buildOneBlock(-3,1,-2,Blocks.stonebrick);buildOneBlock(-3,1,-1,Blocks.stonebrick);
			buildOneBlock(-3,1,0,Blocks.stonebrick);buildOneBlock(-3,1,1,Blocks.stonebrick);buildOneBlock(-3,1,2,Blocks.stonebrick);
			buildOneBlock(-3,1,3,Blocks.stonebrick);buildOneBlock(-2,1,-3,Blocks.stonebrick);buildOneBlock(-2,1,-2,Blocks.stonebrick);
			buildOneBlock(-2,1,-1,Blocks.stonebrick);buildOneBlock(-2,1,0,Blocks.stonebrick);buildOneBlock(-2,1,1,Blocks.stonebrick);
			buildOneBlock(-2,1,2,Blocks.lava);buildOneBlock(-2,1,3,Blocks.stonebrick);buildOneBlock(-1,1,-3,Blocks.stonebrick);
			buildOneBlock(-1,1,1,Blocks.stonebrick);buildOneBlock(-1,1,2,Blocks.lava);buildOneBlock(-1,1,3,Blocks.stonebrick);
			buildOneBlock(0,1,-3,Blocks.stonebrick);buildOneBlock(0,1,1,Blocks.stonebrick);buildOneBlock(0,1,2,Blocks.lava);
			buildOneBlock(0,1,3,Blocks.stonebrick);buildOneBlock(1,1,-3,Blocks.stonebrick);buildOneBlock(1,1,-2,Blocks.anvil);
			buildOneBlock(1,1,1,Blocks.stonebrick);buildOneBlock(1,1,2,Blocks.stonebrick);buildOneBlock(1,1,3,Blocks.stonebrick);
			buildOneBlock(2,1,-3,Blocks.stonebrick);buildOneBlock(2,1,3,Blocks.stonebrick);buildOneBlock(3,1,-3,Blocks.stonebrick);
			buildOneBlock(3,1,1,Blocks.stonebrick);buildOneBlock(3,1,2,Blocks.stonebrick);buildOneBlock(3,1,3,Blocks.stonebrick);
			buildOneBlock(-3,2,-3,Blocks.stonebrick);buildOneBlock(-3,2,-2,Blocks.stonebrick);buildOneBlock(-3,2,-1,Blocks.stonebrick);
			buildOneBlock(-3,2,0,Blocks.stonebrick);buildOneBlock(-3,2,1,Blocks.stonebrick);buildOneBlock(-3,2,2,Blocks.stonebrick);
			buildOneBlock(-3,2,3,Blocks.stonebrick);buildOneBlock(-2,2,-2,Blocks.stonebrick);buildOneBlock(-2,2,-1,Blocks.furnace);
			buildOneBlock(-2,2,0,Blocks.stonebrick);buildOneBlock(-2,2,3,Blocks.stonebrick);buildOneBlock(-1,2,3,Blocks.stonebrick);
			buildOneBlock(0,2,3,Blocks.stonebrick);buildOneBlock(1,2,3,Blocks.stonebrick);buildOneBlock(2,2,3,Blocks.stonebrick);
			buildOneBlock(-3,3,-3,Blocks.stonebrick);buildOneBlock(-3,3,-2,Blocks.stonebrick);buildOneBlock(-3,3,0,Blocks.stonebrick);
			buildOneBlock(-3,3,2,Blocks.stonebrick);buildOneBlock(-3,3,3,Blocks.stonebrick);buildOneBlock(-2,3,3,Blocks.stonebrick);
			buildOneBlock(-1,3,3,Blocks.stonebrick);buildOneBlock(0,3,3,Blocks.stonebrick);buildOneBlock(1,3,3,Blocks.stonebrick);
			buildOneBlock(2,3,3,Blocks.stonebrick);buildOneBlock(-3,4,-3,Blocks.stonebrick);buildOneBlock(-3,4,-2,Blocks.stonebrick);
			buildOneBlock(-3,4,-1,Blocks.stonebrick);buildOneBlock(-3,4,0,Blocks.stonebrick);buildOneBlock(-3,4,1,Blocks.stonebrick);
			buildOneBlock(-3,4,2,Blocks.stonebrick);buildOneBlock(-3,4,3,Blocks.stonebrick);buildOneBlock(-2,4,-3,Blocks.stonebrick);
			buildOneBlock(-2,4,-2,Blocks.stonebrick);buildOneBlock(-2,4,-1,Blocks.stonebrick);buildOneBlock(-2,4,0,Blocks.stonebrick);
			buildOneBlock(-2,4,1,Blocks.stonebrick);buildOneBlock(-2,4,2,Blocks.stonebrick);buildOneBlock(-2,4,3,Blocks.stonebrick);
			buildOneBlock(-1,4,-3,Blocks.stonebrick);buildOneBlock(-1,4,-2,Blocks.stonebrick);buildOneBlock(-1,4,-1,Blocks.stonebrick);
			buildOneBlock(-1,4,0,Blocks.stonebrick);buildOneBlock(-1,4,1,Blocks.stonebrick);buildOneBlock(-1,4,2,Blocks.stonebrick);
			buildOneBlock(-1,4,3,Blocks.stonebrick);buildOneBlock(0,4,1,Blocks.stonebrick);buildOneBlock(0,4,2,Blocks.stonebrick);
			buildOneBlock(0,4,3,Blocks.stonebrick);buildOneBlock(1,4,1,Blocks.stonebrick);buildOneBlock(1,4,2,Blocks.stonebrick);
			buildOneBlock(1,4,3,Blocks.stonebrick);buildOneBlock(2,4,1,Blocks.stonebrick);buildOneBlock(2,4,2,Blocks.stonebrick);
			buildOneBlock(2,4,3,Blocks.stonebrick);
		}
	}
	
	private static void buildBakery(){
		if(preBuild(BuildingData.Type_Bakery,BuildingConfig.SizeType_Small)){
			BaseBuilder.buildGroundwork(world,buildingData);
			buildOneBlock(-2,0,-1,Blocks.planks);buildOneBlock(-2,0,0,Blocks.planks);buildOneBlock(-2,0,1,Blocks.planks);
			buildOneBlock(-2,0,2,Blocks.planks);buildOneBlock(-1,0,-2,Blocks.planks);buildOneBlock(-1,0,-1,Blocks.planks);
			buildOneBlock(-1,0,0,Blocks.planks);buildOneBlock(-1,0,1,Blocks.planks);buildOneBlock(-1,0,2,Blocks.planks);
			buildOneBlock(0,0,-2,Blocks.planks);buildOneBlock(0,0,-1,Blocks.wool);buildOneBlock(1,0,-2,Blocks.planks);
			buildOneBlock(1,0,-1,Blocks.wool);buildOneBlock(1,0,0,Blocks.wool);buildOneBlock(1,0,1,Blocks.wool);
			buildOneBlock(1,0,2,Blocks.planks);buildOneBlock(2,0,-2,Blocks.planks);buildOneBlock(2,0,-1,Blocks.wool);
			buildOneBlock(2,0,0,Blocks.wool);buildOneBlock(2,0,1,Blocks.wool);buildOneBlock(2,0,2,Blocks.planks);
			buildOneBlock(3,0,-1,Blocks.wool);buildOneBlock(3,0,0,Blocks.wool);buildOneBlock(3,0,1,Blocks.wool);
			buildOneBlock(-3,1,-3,Blocks.stonebrick);buildOneBlock(-3,1,-2,Blocks.stonebrick);buildOneBlock(-3,1,-1,Blocks.stonebrick);
			buildOneBlock(-3,1,0,Blocks.stonebrick);buildOneBlock(-3,1,1,Blocks.stonebrick);buildOneBlock(-3,1,2,Blocks.stonebrick);
			buildOneBlock(-3,1,3,Blocks.stonebrick);buildOneBlock(-2,1,-3,Blocks.stonebrick);buildOneBlock(-2,1,-2,Blocks.stonebrick);
			buildOneBlock(-2,1,3,Blocks.stonebrick);buildOneBlock(-1,1,-3,Blocks.stonebrick);buildOneBlock(-1,1,3,Blocks.stonebrick);
			buildOneBlock(0,1,-3,Blocks.stonebrick);buildOneBlock(0,1,0,Blocks.planks);buildOneBlock(0,1,1,Blocks.planks);
			buildOneBlock(0,1,2,Blocks.planks);buildOneBlock(0,1,3,Blocks.stonebrick);buildOneBlock(1,1,-3,Blocks.stonebrick);
			buildOneBlock(1,1,3,Blocks.stonebrick);buildOneBlock(2,1,-3,Blocks.fence);buildOneBlock(2,1,3,Blocks.fence);
			buildOneBlock(3,1,-3,Blocks.fence);buildOneBlock(3,1,-2,Blocks.fence);buildOneBlock(3,1,2,Blocks.fence);
			buildOneBlock(3,1,3,Blocks.fence);buildOneBlock(-3,2,-3,Blocks.planks);buildOneBlock(-3,2,-2,Blocks.planks);
			buildOneBlock(-3,2,-1,Blocks.planks);buildOneBlock(-3,2,0,Blocks.planks);buildOneBlock(-3,2,1,Blocks.planks);
			buildOneBlock(-3,2,2,Blocks.planks);buildOneBlock(-3,2,3,Blocks.planks);buildOneBlock(-2,2,-3,Blocks.planks);
			buildOneBlock(-2,2,-2,Blocks.furnace);buildOneBlock(-2,2,3,Blocks.planks);buildOneBlock(-1,2,-3,Blocks.planks);
			buildOneBlock(-1,2,3,Blocks.planks);buildOneBlock(0,2,-3,Blocks.planks);buildOneBlock(0,2,0,Blocks.glass);
			buildOneBlock(0,2,1,Blocks.glass);buildOneBlock(0,2,2,Blocks.glass);buildOneBlock(0,2,3,Blocks.planks);
			buildOneBlock(1,2,-3,Blocks.planks);buildOneBlock(1,2,3,Blocks.planks);buildOneBlock(-3,3,-3,Blocks.planks);
			buildOneBlock(-3,3,-2,Blocks.planks);buildOneBlock(-3,3,-1,Blocks.planks);buildOneBlock(-3,3,0,Blocks.planks);
			buildOneBlock(-3,3,1,Blocks.planks);buildOneBlock(-3,3,2,Blocks.planks);buildOneBlock(-3,3,3,Blocks.planks);
			buildOneBlock(-2,3,-3,Blocks.planks);buildOneBlock(-2,3,3,Blocks.planks);buildOneBlock(-1,3,-3,Blocks.planks);
			buildOneBlock(-1,3,3,Blocks.planks);buildOneBlock(0,3,-3,Blocks.planks);buildOneBlock(0,3,3,Blocks.planks);
			buildOneBlock(1,3,-3,Blocks.planks);buildOneBlock(1,3,3,Blocks.planks);buildOneBlock(-3,4,-3,Blocks.planks);
			buildOneBlock(-3,4,-2,Blocks.planks);buildOneBlock(-3,4,-1,Blocks.planks);buildOneBlock(-3,4,0,Blocks.planks);
			buildOneBlock(-3,4,1,Blocks.planks);buildOneBlock(-3,4,2,Blocks.planks);buildOneBlock(-3,4,3,Blocks.planks);
			buildOneBlock(-2,4,-3,Blocks.planks);buildOneBlock(-2,4,3,Blocks.planks);buildOneBlock(-1,4,-3,Blocks.planks);
			buildOneBlock(-1,4,3,Blocks.planks);buildOneBlock(0,4,-3,Blocks.planks);buildOneBlock(0,4,3,Blocks.planks);
			buildOneBlock(1,4,3,Blocks.planks);buildOneBlock(-2,5,-2,Blocks.planks);buildOneBlock(-2,5,-1,Blocks.planks);
			buildOneBlock(-2,5,0,Blocks.planks);buildOneBlock(-2,5,1,Blocks.planks);buildOneBlock(-2,5,2,Blocks.planks);
			buildOneBlock(-1,5,-2,Blocks.planks);buildOneBlock(-1,5,-1,Blocks.planks);buildOneBlock(-1,5,0,Blocks.planks);
			buildOneBlock(-1,5,1,Blocks.planks);buildOneBlock(-1,5,2,Blocks.planks);buildOneBlock(0,5,-2,Blocks.planks);
			buildOneBlock(0,5,-1,Blocks.planks);buildOneBlock(0,5,0,Blocks.planks);buildOneBlock(0,5,1,Blocks.planks);
			buildOneBlock(0,5,2,Blocks.planks);buildOneBlock(1,5,-1,Blocks.planks);buildOneBlock(1,5,0,Blocks.planks);
			buildOneBlock(1,5,1,Blocks.planks);buildOneBlock(1,5,2,Blocks.planks);
		}
	}
	
	private static void buildXXXXXX(){
		if(preBuild(BuildingData.Type_VillageCenter,BuildingConfig.SizeType_Small)){
			BaseBuilder.buildGroundwork(world,buildingData);
		}
	}
	
}
