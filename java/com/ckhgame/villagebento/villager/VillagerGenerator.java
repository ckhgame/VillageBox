package com.ckhgame.villagebento.villager;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helpers.HelperDataVB;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.world.World;

public class VillagerGenerator {
	
	/**
	 * this function will generate villager data as well as villager entity, mostly used for first adding (in most case with the creation of a new building)
	 * use genenrateEntity() when just want to create an entity based on an existed DataVillager (useful when revive an dead villager)
	 */
	public static void generate(World w,int x,int y,int z, int profession, String name, String skin, int buildingID){	
		
		DataVillager dv = HelperDataVB.createDataVillager(profession, name, skin, buildingID);
		HelperDataVB.addVillagerData(DataVillageBento.get(w), dv);
		
		generateEntity(w,x,y,z,dv);
		
	}
	
	public static void generateEntity(World w, int x ,int y, int z , DataVillager dv){
		EntityVBVillager entityvbvillager = new EntityVBVillager(w);	
		entityvbvillager.setVillagerData(dv);
		entityvbvillager.setLocationAndAngles((double)x,(double)y,(double)z, 0.0F, 0.0F);
        w.spawnEntityInWorld(entityvbvillager);
	}
}
