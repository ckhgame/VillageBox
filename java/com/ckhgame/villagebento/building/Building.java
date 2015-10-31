package com.ckhgame.villagebento.building;

import java.util.HashMap;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class Building {	
	
	private int type;
	
	public int getType(){
		return type;
	}
	
	public abstract String getName(); 
	public abstract String getDescription(); 
	public abstract int getSizeType();
	protected abstract boolean canBuild();
	protected abstract void buildBlocks(BuildingBuilder bb);
	protected abstract void generateVillagers(BuildingBuilder bb); 

	//---------------------------------
	//registry...
	
	private static HashMap<Integer,Building> mapIntCreators = new HashMap<Integer,Building>();
	private static HashMap<Class<? extends Building>,Building> mapClassCreators = new HashMap<Class<? extends Building>,Building>();
	
	public static void register(int type, Building bc ){
		if(mapIntCreators.containsKey(type) || mapClassCreators.containsKey(bc.getClass())){
			System.out.println("Can not register the Building, type/class is existed!");
		}
		else{
			mapIntCreators.put(type, bc);
			mapClassCreators.put(bc.getClass(), bc);
			bc.type = type;
		}
	}
	
	public static Building get(int type){
		if(mapIntCreators.containsKey(type)){
			return mapIntCreators.get(type);
		}
		else{
			System.out.println("Can not fint Building, type=" + type);
			return null;
		}
	}
	
	public static Building get(Class<? extends Building> c){
		if(mapClassCreators.containsKey(c)){
			return mapClassCreators.get(c);
		}
		else{
			System.out.println("Can not fint BuildingCreator, class=" + c.getName());
			return null;
		}
	}
	
	public static boolean build(World w,EntityPlayer p,int x, int y,int z, Class<? extends Building> c){
		
		BuildingBuilder bb = BuildingBuilder.getInstance();
		Building b = get(c);
		//init builder
		bb.reset(w, p, x, y, z);
		//generate bulding data
		if(b.canBuild() && bb.generateData(b.getType(),b.getSizeType())){
			//if both meet the requirements of building and building data, we will start building blocks
			bb.calculateFacing();
			bb.buildGroundwork();
			b.buildBlocks(bb);
			b.generateVillagers(bb);
			return true;
		}
		return false;
	}
}
