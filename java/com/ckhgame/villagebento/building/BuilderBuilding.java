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
		case BuildingTypes.GroundWorkOnlySmall:buildGroundworkOnlySmall();break;
		case BuildingTypes.GroundWorkOnlyMedium:buildGroundworkOnlyMedium();break;
		case BuildingTypes.GroundWorkOnlyLarge:buildGroundworkOnlyLarge();break;
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
			
			buildOneBlock(0,-3,0,Blocks.air);buildOneBlock(1,-3,0,Blocks.air);buildOneBlock(0,-2,-1,Blocks.planks);
			buildOneBlock(0,-2,0,Blocks.air);buildOneBlock(0,-2,1,Blocks.planks);buildOneBlock(1,-2,-1,Blocks.planks);
			buildOneBlock(1,-2,0,Blocks.air);buildOneBlock(1,-2,1,Blocks.planks);buildOneBlock(0,-1,-1,Blocks.planks);
			buildOneBlock(0,-1,0,Blocks.planks);buildOneBlock(0,-1,1,Blocks.planks);buildOneBlock(1,-1,-1,Blocks.planks);
			buildOneBlock(1,-1,0,Blocks.planks);buildOneBlock(1,-1,1,Blocks.planks);buildOneBlock(-3,0,-3,Blocks.log);
			buildOneBlock(-3,0,-2,Blocks.planks);buildOneBlock(-3,0,-1,Blocks.planks);buildOneBlock(-3,0,0,Blocks.planks);
			buildOneBlock(-3,0,1,Blocks.planks);buildOneBlock(-3,0,2,Blocks.planks);buildOneBlock(-3,0,3,Blocks.log);
			buildOneBlock(-2,0,-3,Blocks.planks);buildOneBlock(-2,0,-2,Blocks.planks);buildOneBlock(-2,0,2,Blocks.planks);
			buildOneBlock(-2,0,3,Blocks.planks);buildOneBlock(-1,0,-3,Blocks.planks);buildOneBlock(-1,0,3,Blocks.planks);
			buildOneBlock(0,0,-3,Blocks.planks);buildOneBlock(0,0,3,Blocks.planks);buildOneBlock(1,0,-3,Blocks.planks);
			buildOneBlock(1,0,3,Blocks.planks);buildOneBlock(2,0,-3,Blocks.log);buildOneBlock(2,0,-2,Blocks.planks);
			buildOneBlock(2,0,2,Blocks.planks);buildOneBlock(2,0,3,Blocks.log);buildOneBlock(-3,1,-3,Blocks.log);
			buildOneBlock(-3,1,-2,Blocks.planks);buildOneBlock(-3,1,2,Blocks.planks);buildOneBlock(-3,1,3,Blocks.log);
			buildOneBlock(-2,1,-3,Blocks.planks);buildOneBlock(-2,1,-2,Blocks.planks);buildOneBlock(-2,1,2,Blocks.planks);
			buildOneBlock(-2,1,3,Blocks.planks);buildOneBlock(1,1,-3,Blocks.planks);buildOneBlock(1,1,3,Blocks.planks);
			buildOneBlock(2,1,-3,Blocks.log);buildOneBlock(2,1,-2,Blocks.planks);buildOneBlock(2,1,2,Blocks.planks);
			buildOneBlock(2,1,3,Blocks.log);buildOneBlock(-3,2,-3,Blocks.log);buildOneBlock(-3,2,-2,Blocks.planks);
			buildOneBlock(-3,2,2,Blocks.planks);buildOneBlock(-3,2,3,Blocks.log);buildOneBlock(-2,2,-3,Blocks.planks);
			buildOneBlock(-2,2,3,Blocks.planks);buildOneBlock(1,2,-3,Blocks.planks);buildOneBlock(1,2,3,Blocks.planks);
			buildOneBlock(2,2,-3,Blocks.log);buildOneBlock(2,2,-2,Blocks.planks);buildOneBlock(2,2,2,Blocks.planks);
			buildOneBlock(2,2,3,Blocks.log);buildOneBlock(-3,3,-3,Blocks.log);buildOneBlock(-3,3,-2,Blocks.planks);
			buildOneBlock(-3,3,-1,Blocks.planks);buildOneBlock(-3,3,0,Blocks.planks);buildOneBlock(-3,3,1,Blocks.planks);
			buildOneBlock(-3,3,2,Blocks.planks);buildOneBlock(-3,3,3,Blocks.log);buildOneBlock(-2,3,-3,Blocks.planks);
			buildOneBlock(-2,3,-2,Blocks.glass);buildOneBlock(-2,3,-1,Blocks.glass);buildOneBlock(-2,3,0,Blocks.glass);
			buildOneBlock(-2,3,1,Blocks.glass);buildOneBlock(-2,3,2,Blocks.glass);buildOneBlock(-2,3,3,Blocks.planks);
			buildOneBlock(-1,3,-3,Blocks.planks);buildOneBlock(-1,3,-2,Blocks.glass);buildOneBlock(-1,3,-1,Blocks.glass);
			buildOneBlock(-1,3,0,Blocks.planks);buildOneBlock(-1,3,1,Blocks.glass);buildOneBlock(-1,3,2,Blocks.glass);
			buildOneBlock(-1,3,3,Blocks.planks);buildOneBlock(0,3,-3,Blocks.planks);buildOneBlock(0,3,-2,Blocks.glass);
			buildOneBlock(0,3,-1,Blocks.glass);buildOneBlock(0,3,0,Blocks.planks);buildOneBlock(0,3,1,Blocks.glass);
			buildOneBlock(0,3,2,Blocks.glass);buildOneBlock(0,3,3,Blocks.planks);buildOneBlock(1,3,-3,Blocks.planks);
			buildOneBlock(1,3,-2,Blocks.glass);buildOneBlock(1,3,-1,Blocks.glass);buildOneBlock(1,3,0,Blocks.glass);
			buildOneBlock(1,3,1,Blocks.glass);buildOneBlock(1,3,2,Blocks.glass);buildOneBlock(1,3,3,Blocks.planks);
			buildOneBlock(2,3,-3,Blocks.log);buildOneBlock(2,3,-2,Blocks.planks);buildOneBlock(2,3,-1,Blocks.log);
			buildOneBlock(2,3,0,Blocks.log);buildOneBlock(2,3,1,Blocks.log);buildOneBlock(2,3,2,Blocks.planks);
			buildOneBlock(2,3,3,Blocks.log);buildOneBlock(-3,4,-2,Blocks.log);buildOneBlock(-3,4,-1,Blocks.log);
			buildOneBlock(-3,4,0,Blocks.log);buildOneBlock(-3,4,1,Blocks.log);buildOneBlock(-3,4,2,Blocks.log);
			buildOneBlock(-2,4,-3,Blocks.log);buildOneBlock(-2,4,3,Blocks.log);buildOneBlock(-1,4,-3,Blocks.log);
			buildOneBlock(-1,4,3,Blocks.log);buildOneBlock(0,4,-3,Blocks.log);buildOneBlock(0,4,3,Blocks.log);
			buildOneBlock(1,4,-3,Blocks.log);buildOneBlock(1,4,3,Blocks.log);buildOneBlock(2,4,-2,Blocks.log);
			buildOneBlock(2,4,-1,Blocks.log);buildOneBlock(2,4,0,Blocks.log);buildOneBlock(2,4,1,Blocks.log);
			buildOneBlock(2,4,2,Blocks.log);
			
			//add villager
			addBuildingVillager(VillagerProfessions.VillageAssistant,"VillagerAssistant","VillagerAssistant",0,0);
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
			
			//add villager
			addBuildingVillager(VillagerProfessions.Miner,"Miner1","Miner",1,0);
			addBuildingVillager(VillagerProfessions.Miner,"Miner2","Miner",-1,0);
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
			
			//add villager
			addBuildingVillager(VillagerProfessions.Blacksmith,"Blacksmith","Blacksmith",1,0);
			addBuildingVillager(VillagerProfessions.BlacksmithAssistant,"BlacksmithAssistant","BlacksmithAssistant",-1,0);
		}
	}
	
	private static void buildBakery(){
		if(preBuild(BuildingTypes.Bakery,ConfigBuilding.SizeType_Medium)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
			
			buildOneBlock(-5,0,-5,Blocks.wool);buildOneBlock(-5,0,-4,Blocks.planks);buildOneBlock(-5,0,-3,Blocks.planks);
			buildOneBlock(-5,0,-2,Blocks.planks);buildOneBlock(-5,0,-1,Blocks.planks);buildOneBlock(-5,0,0,Blocks.planks);
			buildOneBlock(-5,0,1,Blocks.planks);buildOneBlock(-5,0,2,Blocks.wool);buildOneBlock(-4,0,-5,Blocks.planks);
			buildOneBlock(-4,0,-1,Blocks.planks);buildOneBlock(-4,0,2,Blocks.planks);buildOneBlock(-4,0,3,Blocks.hay_block);
			buildOneBlock(-4,0,4,Blocks.hay_block);buildOneBlock(-3,0,-5,Blocks.planks);buildOneBlock(-3,0,-1,Blocks.planks);
			buildOneBlock(-3,0,2,Blocks.planks);buildOneBlock(-3,0,3,Blocks.hay_block);buildOneBlock(-2,0,-5,Blocks.planks);
			buildOneBlock(-2,0,-1,Blocks.planks);buildOneBlock(-1,0,-5,Blocks.planks);buildOneBlock(-1,0,-1,Blocks.planks);
			buildOneBlock(0,0,-5,Blocks.planks);buildOneBlock(0,0,-1,Blocks.planks);buildOneBlock(1,0,-5,Blocks.planks);
			buildOneBlock(2,0,-5,Blocks.planks);buildOneBlock(3,0,-5,Blocks.planks);buildOneBlock(3,0,2,Blocks.planks);
			buildOneBlock(4,0,-5,Blocks.planks);buildOneBlock(4,0,2,Blocks.planks);buildOneBlock(5,0,-5,Blocks.wool);
			buildOneBlock(5,0,-4,Blocks.planks);buildOneBlock(5,0,-3,Blocks.planks);buildOneBlock(5,0,-2,Blocks.planks);
			buildOneBlock(5,0,-1,Blocks.planks);buildOneBlock(5,0,0,Blocks.planks);buildOneBlock(5,0,1,Blocks.planks);
			buildOneBlock(5,0,2,Blocks.wool);buildOneBlock(-5,1,-5,Blocks.wool);buildOneBlock(-5,1,2,Blocks.wool);
			buildOneBlock(-4,1,-1,Blocks.glass);buildOneBlock(-4,1,2,Blocks.planks);buildOneBlock(-4,1,3,Blocks.hay_block);
			buildOneBlock(-3,1,-1,Blocks.glass);buildOneBlock(-3,1,2,Blocks.planks);buildOneBlock(-2,1,-1,Blocks.glass);
			buildOneBlock(-1,1,-1,Blocks.glass);buildOneBlock(0,1,-1,Blocks.glass);buildOneBlock(3,1,2,Blocks.planks);
			buildOneBlock(4,1,2,Blocks.planks);buildOneBlock(5,1,-5,Blocks.wool);buildOneBlock(5,1,2,Blocks.wool);
			buildOneBlock(-5,2,-5,Blocks.wool);buildOneBlock(-5,2,-4,Blocks.planks);buildOneBlock(-5,2,-3,Blocks.planks);
			buildOneBlock(-5,2,-2,Blocks.planks);buildOneBlock(-5,2,-1,Blocks.planks);buildOneBlock(-5,2,0,Blocks.planks);
			buildOneBlock(-5,2,1,Blocks.planks);buildOneBlock(-5,2,2,Blocks.wool);buildOneBlock(-4,2,-5,Blocks.planks);
			buildOneBlock(-4,2,2,Blocks.planks);buildOneBlock(-3,2,-5,Blocks.planks);buildOneBlock(-3,2,2,Blocks.planks);
			buildOneBlock(-2,2,-5,Blocks.planks);buildOneBlock(-2,2,2,Blocks.planks);buildOneBlock(-1,2,-5,Blocks.planks);
			buildOneBlock(0,2,-5,Blocks.planks);buildOneBlock(1,2,-5,Blocks.planks);buildOneBlock(2,2,-5,Blocks.planks);
			buildOneBlock(2,2,2,Blocks.planks);buildOneBlock(3,2,-5,Blocks.planks);buildOneBlock(3,2,2,Blocks.planks);
			buildOneBlock(4,2,-5,Blocks.planks);buildOneBlock(4,2,2,Blocks.planks);buildOneBlock(5,2,-5,Blocks.wool);
			buildOneBlock(5,2,-4,Blocks.planks);buildOneBlock(5,2,-3,Blocks.planks);buildOneBlock(5,2,-2,Blocks.planks);
			buildOneBlock(5,2,-1,Blocks.planks);buildOneBlock(5,2,0,Blocks.planks);buildOneBlock(5,2,1,Blocks.planks);
			buildOneBlock(5,2,2,Blocks.wool);buildOneBlock(-4,3,-5,Blocks.planks);buildOneBlock(-4,3,-4,Blocks.planks);
			buildOneBlock(-4,3,-3,Blocks.planks);buildOneBlock(-4,3,-2,Blocks.planks);buildOneBlock(-4,3,-1,Blocks.planks);
			buildOneBlock(-4,3,0,Blocks.planks);buildOneBlock(-4,3,1,Blocks.planks);buildOneBlock(-4,3,2,Blocks.planks);
			buildOneBlock(-3,3,-4,Blocks.planks);buildOneBlock(-3,3,1,Blocks.planks);buildOneBlock(-2,3,-4,Blocks.planks);
			buildOneBlock(-2,3,1,Blocks.planks);buildOneBlock(-2,3,2,Blocks.planks);buildOneBlock(-1,3,-4,Blocks.planks);
			buildOneBlock(-1,3,1,Blocks.planks);buildOneBlock(-1,3,2,Blocks.planks);buildOneBlock(0,3,-4,Blocks.planks);
			buildOneBlock(0,3,1,Blocks.planks);buildOneBlock(0,3,2,Blocks.planks);buildOneBlock(1,3,-4,Blocks.planks);
			buildOneBlock(1,3,1,Blocks.planks);buildOneBlock(1,3,2,Blocks.planks);buildOneBlock(2,3,-4,Blocks.planks);
			buildOneBlock(2,3,1,Blocks.planks);buildOneBlock(2,3,2,Blocks.planks);buildOneBlock(3,3,-4,Blocks.planks);
			buildOneBlock(3,3,1,Blocks.planks);buildOneBlock(4,3,-5,Blocks.planks);buildOneBlock(4,3,-4,Blocks.planks);
			buildOneBlock(4,3,-3,Blocks.planks);buildOneBlock(4,3,-2,Blocks.planks);buildOneBlock(4,3,-1,Blocks.planks);
			buildOneBlock(4,3,0,Blocks.planks);buildOneBlock(4,3,1,Blocks.planks);buildOneBlock(4,3,2,Blocks.planks);
			buildOneBlock(-3,4,-4,Blocks.planks);buildOneBlock(-3,4,-3,Blocks.planks);buildOneBlock(-3,4,-2,Blocks.planks);
			buildOneBlock(-3,4,-1,Blocks.planks);buildOneBlock(-3,4,0,Blocks.planks);buildOneBlock(-3,4,1,Blocks.planks);
			buildOneBlock(-2,4,-3,Blocks.wool);buildOneBlock(-2,4,-2,Blocks.wool);buildOneBlock(-2,4,-1,Blocks.wool);
			buildOneBlock(-2,4,0,Blocks.wool);buildOneBlock(-1,4,-3,Blocks.wool);buildOneBlock(-1,4,-2,Blocks.wool);
			buildOneBlock(-1,4,-1,Blocks.wool);buildOneBlock(-1,4,0,Blocks.wool);buildOneBlock(0,4,-3,Blocks.wool);
			buildOneBlock(0,4,-2,Blocks.wool);buildOneBlock(0,4,-1,Blocks.wool);buildOneBlock(0,4,0,Blocks.wool);
			buildOneBlock(1,4,-3,Blocks.wool);buildOneBlock(1,4,-2,Blocks.wool);buildOneBlock(1,4,-1,Blocks.wool);
			buildOneBlock(1,4,0,Blocks.wool);buildOneBlock(2,4,-3,Blocks.wool);buildOneBlock(2,4,-2,Blocks.wool);
			buildOneBlock(2,4,-1,Blocks.wool);buildOneBlock(2,4,0,Blocks.wool);buildOneBlock(3,4,-4,Blocks.planks);
			buildOneBlock(3,4,-3,Blocks.planks);buildOneBlock(3,4,-2,Blocks.planks);buildOneBlock(3,4,-1,Blocks.planks);
			buildOneBlock(3,4,0,Blocks.planks);buildOneBlock(3,4,1,Blocks.planks);
			
			//add villager
			addBuildingVillager(VillagerProfessions.Baker,"Baker","Baker",1,0);
			addBuildingVillager(VillagerProfessions.BakerApprentice,"BakerApprentice","BakerApprentice",-1,0);
		}
	}
	
	private static void buildGroundworkOnlySmall(){
		if(preBuild(BuildingTypes.GroundWorkOnlySmall,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
		}
	}
	
	private static void buildGroundworkOnlyMedium(){
		if(preBuild(BuildingTypes.GroundWorkOnlyMedium,ConfigBuilding.SizeType_Medium)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
		}
	}
	
	private static void buildGroundworkOnlyLarge(){
		if(preBuild(BuildingTypes.GroundWorkOnlyLarge,ConfigBuilding.SizeType_Large)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
		}
	}
	
	private static void buildXXXXXX(){
		if(preBuild(BuildingTypes.VillageCenter,ConfigBuilding.SizeType_Small)){
			BuilderGroundWrok.buildGroundwork(world,dataBuilding);
		}
	}
	
}
