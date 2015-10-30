package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helpers.HelperDataVB;
import com.ckhgame.villagebento.villager.VillagerGenerator;
import com.ckhgame.villagebento.villager.VillagerProfessions;

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
		DataBuilding db = HelperDataVB.createDataBuilding(x,y,z,type,sizeType);
		if(HelperDataVB.addBuildingData(villageBentoData, db)){
			
			dataBuilding = db;
			villageBentoData.markDirty();
			
			//calculate facing
			int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			facing = (l + 1)%4;
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * add villagers after completing building
	 */
	private static void addBuildingVillager(int profession, String name, String skin, int dx, int dz){
		VillagerGenerator.generate(	world, 
									dataBuilding.x + dx, dataBuilding.y, dataBuilding.z + dz,
									profession, name, skin, 
									dataBuilding.id);
	}
	
	private static void buildOneBlock(int dx,int dy,int dz,Block block,int metadata){
		
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
						block,
						metadata,
						3);
	}
	
	public static boolean build(World w,EntityPlayer p,int x, int y, int z,int type){
		
		BuilderBuilding.world = w;
		BuilderBuilding.player = p;
		BuilderBuilding.x = x;
		BuilderBuilding.y = y;
		BuilderBuilding.z = z;
		
		boolean success = false;
		
		switch(type){
		case BuildingTypes.GroundWorkOnlySmall:success = buildGroundworkOnlySmall();break;
		case BuildingTypes.GroundWorkOnlyMedium:success = buildGroundworkOnlyMedium();break;
		case BuildingTypes.GroundWorkOnlyLarge:success = buildGroundworkOnlyLarge();break;
		case BuildingTypes.VillageCenter:success = buildVillageCenter();break;
		case BuildingTypes.MiningHouse:success = buildMiningHouse();break;
		case BuildingTypes.BlackSmithsShop:success = buildBlackSmithsShop();break;
		case BuildingTypes.Bakery:success = buildBakery();break;
		default:break;
		}
		
		return success;
	}
	
	private static boolean buildVillageCenter(){	
		if(preBuild(BuildingTypes.VillageCenter,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			
			
			
			//add villager
			addBuildingVillager(VillagerProfessions.VillageAssistant,"VillagerAssistant","VillagerAssistant",0,0);
			
			return true;
		}
		return false;
	}

	private static boolean buildMiningHouse(){
		if(preBuild(BuildingTypes.MiningHouse,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			
			buildOneBlock(-3,0,-3,Blocks.planks,2);buildOneBlock(-3,0,-2,Blocks.planks,2);buildOneBlock(-3,0,2,Blocks.planks,2);
			buildOneBlock(-3,0,3,Blocks.planks,2);buildOneBlock(-2,0,-3,Blocks.planks,2);buildOneBlock(-2,0,3,Blocks.planks,2);
			buildOneBlock(-1,0,-3,Blocks.planks,2);buildOneBlock(-1,0,-2,Blocks.trapped_chest,3);buildOneBlock(-1,0,3,Blocks.planks,2);
			buildOneBlock(0,0,-3,Blocks.planks,2);buildOneBlock(0,0,2,Blocks.trapped_chest,2);buildOneBlock(0,0,3,Blocks.planks,2);
			buildOneBlock(1,0,-3,Blocks.planks,2);buildOneBlock(1,0,-2,Blocks.bed,3);buildOneBlock(1,0,2,Blocks.bed,3);
			buildOneBlock(1,0,3,Blocks.planks,2);buildOneBlock(2,0,-3,Blocks.planks,2);buildOneBlock(2,0,-2,Blocks.bed,11);
			buildOneBlock(2,0,0,Blocks.trapped_chest,4);buildOneBlock(2,0,2,Blocks.bed,11);buildOneBlock(2,0,3,Blocks.planks,2);
			buildOneBlock(3,0,-3,Blocks.planks,2);buildOneBlock(3,0,-2,Blocks.planks,2);buildOneBlock(3,0,-1,Blocks.planks,2);
			buildOneBlock(3,0,0,Blocks.planks,2);buildOneBlock(3,0,1,Blocks.planks,2);buildOneBlock(3,0,2,Blocks.planks,2);
			buildOneBlock(3,0,3,Blocks.planks,2);buildOneBlock(-3,1,-3,Blocks.log,0);buildOneBlock(-3,1,-2,Blocks.log,0);
			buildOneBlock(-3,1,2,Blocks.log,0);buildOneBlock(-3,1,3,Blocks.log,0);buildOneBlock(-2,1,-3,Blocks.wool,14);
			buildOneBlock(-2,1,3,Blocks.wool,14);buildOneBlock(-1,1,-3,Blocks.wool,14);buildOneBlock(-1,1,3,Blocks.wool,14);
			buildOneBlock(0,1,-3,Blocks.wool,14);buildOneBlock(0,1,3,Blocks.wool,14);buildOneBlock(1,1,-3,Blocks.wool,14);
			buildOneBlock(1,1,3,Blocks.wool,14);buildOneBlock(2,1,-3,Blocks.wool,14);buildOneBlock(2,1,3,Blocks.wool,14);
			buildOneBlock(3,1,-3,Blocks.wool,14);buildOneBlock(3,1,-2,Blocks.wool,14);buildOneBlock(3,1,-1,Blocks.wool,14);
			buildOneBlock(3,1,0,Blocks.wool,14);buildOneBlock(3,1,1,Blocks.wool,14);buildOneBlock(3,1,2,Blocks.wool,14);
			buildOneBlock(3,1,3,Blocks.wool,14);buildOneBlock(-1,2,-3,Blocks.wool,4);buildOneBlock(-1,2,3,Blocks.wool,4);
			buildOneBlock(0,2,-3,Blocks.wool,4);buildOneBlock(0,2,-2,Blocks.torch,3);buildOneBlock(0,2,3,Blocks.wool,4);
			buildOneBlock(1,2,-3,Blocks.wool,4);buildOneBlock(1,2,2,Blocks.torch,4);buildOneBlock(1,2,3,Blocks.wool,4);
			buildOneBlock(2,2,-3,Blocks.wool,4);buildOneBlock(2,2,-1,Blocks.torch,2);buildOneBlock(2,2,3,Blocks.wool,4);
			buildOneBlock(3,2,-3,Blocks.wool,4);buildOneBlock(3,2,-2,Blocks.wool,4);buildOneBlock(3,2,-1,Blocks.wool,4);
			buildOneBlock(3,2,0,Blocks.wool,4);buildOneBlock(3,2,1,Blocks.wool,4);buildOneBlock(3,2,2,Blocks.wool,4);
			buildOneBlock(3,2,3,Blocks.wool,4);buildOneBlock(0,3,-3,Blocks.wool,5);buildOneBlock(0,3,3,Blocks.wool,5);
			buildOneBlock(1,3,-3,Blocks.wool,5);buildOneBlock(1,3,3,Blocks.wool,5);buildOneBlock(2,3,-3,Blocks.wool,5);
			buildOneBlock(2,3,-1,Blocks.log,4);buildOneBlock(2,3,0,Blocks.log,4);buildOneBlock(2,3,1,Blocks.log,4);
			buildOneBlock(2,3,3,Blocks.wool,5);buildOneBlock(3,3,-3,Blocks.wool,5);buildOneBlock(3,3,-2,Blocks.wool,5);
			buildOneBlock(3,3,-1,Blocks.wool,5);buildOneBlock(3,3,0,Blocks.wool,5);buildOneBlock(3,3,1,Blocks.wool,5);
			buildOneBlock(3,3,2,Blocks.wool,5);buildOneBlock(3,3,3,Blocks.wool,5);
			
			//add villager
			addBuildingVillager(VillagerProfessions.Miner,"Miner1","Miner",1,0);
			addBuildingVillager(VillagerProfessions.Miner,"Miner2","Miner",-1,0);
			
			return true;
		}
		return false;
	}
	
	private static boolean buildBlackSmithsShop(){
		if(preBuild(BuildingTypes.BlackSmithsShop,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);


			
			//add villager
			addBuildingVillager(VillagerProfessions.Blacksmith,"Blacksmith","Blacksmith",1,0);
			addBuildingVillager(VillagerProfessions.BlacksmithAssistant,"BlacksmithAssistant","BlacksmithAssistant",-1,0);
			
			return true;
		}
		return false;
	}
	
	private static boolean buildBakery(){
		if(preBuild(BuildingTypes.Bakery,ConfigBuilding.SizeType_Medium)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			


			
			//add villager
			addBuildingVillager(VillagerProfessions.Baker,"Baker","Baker",1,0);
			addBuildingVillager(VillagerProfessions.BakerApprentice,"BakerApprentice","BakerApprentice",-1,0);
			
			return true;
		}
		return false;
	}
	
	private static boolean buildGroundworkOnlySmall(){
		if(preBuild(BuildingTypes.GroundWorkOnlySmall,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			return true;
		}
		return false;
	}
	
	private static boolean buildGroundworkOnlyMedium(){
		if(preBuild(BuildingTypes.GroundWorkOnlyMedium,ConfigBuilding.SizeType_Medium)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			return true;
		}
		return false;
	}
	
	private static boolean buildGroundworkOnlyLarge(){
		if(preBuild(BuildingTypes.GroundWorkOnlyLarge,ConfigBuilding.SizeType_Large)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			return true;
		}
		return false;
	}
	
	private static boolean buildXXXXXX(){
		if(preBuild(BuildingTypes.VillageCenter,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			return true;
		}
		return false;
	}
	
}
