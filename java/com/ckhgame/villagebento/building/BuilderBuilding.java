package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helpers.HelperBuildingData;
import com.ckhgame.villagebento.data.helpers.HelperVillageData;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BuilderBuilding {

	private static DataBuilding dataBuilding;
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
	private static boolean preBuild(int type, int sizeType){

		DataVillageBento villageBentoData = DataVillageBento.get(world);		

		dataBuilding = null;
		
		//check if there is a building exists on the current location
		DataBuilding db = HelperBuildingData.createDataBuilding(x,y,z,type,sizeType);
		if(HelperVillageData.addBuildingData(villageBentoData, db)){
			
			dataBuilding = db;
			villageBentoData.markDirty();
			
			//calculate facing
			int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			facing = (l + 1)%4;
			
			return true;
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
		
		
		world.setBlock(	dataBuilding.x+fx,
						dataBuilding.y+fy,
						dataBuilding.z+fz,
						block);
	}
	
	public static void build(World w,EntityPlayer p,int x, int y, int z,int type){
		
		BuilderBuilding.world = w;
		BuilderBuilding.player = p;
		BuilderBuilding.x = x;
		BuilderBuilding.y = y;
		BuilderBuilding.z = z;
		
		switch(type){
		case BuildingTypes.VillageCenter:buildVillageCenter();break;
		case BuildingTypes.MiningHouse:buildMiningHouse();break;
		case BuildingTypes.BlackSmithsShop:buildBlackSmithsShop();break;
		case BuildingTypes.Bakery:buildBakery();break;
		default:break;
		}
	}
	
	private static void buildVillageCenter(){	
		if(preBuild(BuildingTypes.VillageCenter,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			
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
		if(preBuild(BuildingTypes.MiningHouse,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
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
		if(preBuild(BuildingTypes.BlackSmithsShop,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
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
		if(preBuild(BuildingTypes.Bakery,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
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
		if(preBuild(BuildingTypes.VillageCenter,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
		}
	}
	
}
