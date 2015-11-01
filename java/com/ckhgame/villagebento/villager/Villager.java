package com.ckhgame.villagebento.villager;

import java.util.ArrayList;
import java.util.HashMap;

import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.registry.IRegistrable;
import com.ckhgame.villagebento.util.registry.Registry;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class Villager implements IRegistrable {
	
	private int profession;
	public int getProfession(){
		return profession;
	}
	
	public int getRegID() {
		// TODO Auto-generated method stub
		return profession;
	}

	public void setRegID(int regID) {
		profession = regID;
	}
	
	public abstract String getProfessionName();
	public abstract String getProfessionDescription();
	public abstract boolean canSpawn();
	public abstract ArrayList<VillagerComponent> createComponents();
	
	//---------------------------------
	public static Registry<Villager> registry = new Registry<Villager>();
				
	/**
	 * spawn villager and create villager data
	 */
	public static boolean spawn(World w,int x, int y,int z, Class<? extends Villager> c,String name, String skin, int buildingID){
				
		Villager v = registry.get(c);

		if(v != null && v.canSpawn()){
			//generate villager data
			DataVillager dv = HelperDataVB.createDataVillager(v.profession, name, skin, buildingID);
			HelperDataVB.addVillagerData(DataVillageBento.get(w), dv);
			
			return spawn(w,x,y,z,dv,v);
		}
		
		return false;
	}
	
	/**
	 * spawn villager with an existed villager data
	 */
	public static boolean spawn(World w,int x, int y,int z,DataVillager dv){
		
		Villager v = registry.get(dv.profession);

		if(v != null && v.canSpawn()){
			return spawn(w,x,y,z,dv,v);
		}
		
		return false;
	}

	/**
	 * the real spawn function
	 */
	private static boolean spawn(World w,int x, int y,int z,DataVillager dv, Villager v){
		
		//create entity
		EntityVBVillager entityvbvillager = new EntityVBVillager(w);	
		entityvbvillager.setVillagerData(dv);
		entityvbvillager.setLocationAndAngles((double)x + 0.5,(double)y + 0.1,(double)z + 0.5, 0.0F, 0.0F);
		
		//set components
		entityvbvillager.setVillagerComponents(v.createComponents());
		
		//add to world
        return w.spawnEntityInWorld(entityvbvillager);
	}
}


