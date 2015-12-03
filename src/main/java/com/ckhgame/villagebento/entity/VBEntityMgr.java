package com.ckhgame.villagebento.entity;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

public class VBEntityMgr {
	
	//----------- singleton
	private static VBEntityMgr instance = null;
	public static VBEntityMgr get(){
		if(instance == null)
			instance = new VBEntityMgr();
		return instance;
	}
	//-----------
	
	private ArrayList<EntityVBVillager> villagers = new ArrayList<EntityVBVillager>();
	
	public void init(){
		this.clearAll();
	}
	
	public void clearAll(){
		villagers.clear();
	}
	
	public void addVillager(EntityVBVillager villager){
		if(!this.villagers.contains(villager))
			this.villagers.add(villager);
	}
	
	public void removeVillager(EntityVBVillager villager){
		if(this.villagers.contains(villager))
			this.villagers.remove(villager);
	}
	
	public ArrayList<EntityVBVillager> getVillagers(){
		return this.villagers;
	}
	
	public ArrayList<EntityVBVillager> findBuildingVillagers(int buildingID){
		ArrayList<EntityVBVillager> result = new ArrayList<EntityVBVillager>();
		for(EntityVBVillager villager : villagers){
			if(villager.getBuildingID() == buildingID)
				result.add(villager);
		}
		return result;
	}
}
