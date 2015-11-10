package com.ckhgame.villagebento.building;

import java.util.HashMap;

import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.util.registry.IRegistrable;
import com.ckhgame.villagebento.util.registry.Registry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class Building implements IRegistrable {	
	
	private int type;
	
	public int getType(){
		return type;
	}
	
	public void setRegID(int regID){
		this.type = regID;
	}
	
	public int getRegID(){
		return this.type;
	}
	
	public abstract String getName(); 
	public abstract String getDescription(); 
	public abstract int getSizeType();
	protected abstract boolean canBuild();
	protected abstract void buildBlocks(BuildingBuilder bb);
	protected abstract void generateVillagers(BuildingBuilder bb); 

	//---------------------------------
	public static Registry<Building> registry = new Registry<Building>();
	
	public static boolean build(World w,EntityPlayer p,int x, int y,int z, Class<? extends Building> c){
		
		BuildingBuilder bb = BuildingBuilder.getInstance();
		Building b = registry.get(c);

		bb.reset(w, p, x, y, z);
		
		//generate bulding data
		if( b!=null && b.canBuild() && bb.generateData(b.getType(),b.getSizeType())){
			//if both meet the requirements of building and building data, we will start building blocks
			bb.calculateFacing();
			bb.buildGroundwork();
			b.buildBlocks(bb);
			b.generateVillagers(bb);
			return true;
		}
		return false;
	}
	
	public static boolean destroy(World w,int x,int y,int z){
		DataVillageBento dataVB = DataVillageBento.get();
		DataBuilding db = HelperDataVB.findBuildingByPos(dataVB, x,y, z);
		if(db != null){
			BuildingBuilder bb = BuildingBuilder.getInstance();
			bb.reset(w, null, x, y, z);
			bb.setData(db);	
			if(HelperDataVB.removeBuildingData(dataVB, db.id)){
				bb.buildGroundwork();
				bb.removeBuildingEntities();
				return true;
			}
		}
		return false;
	}
}
