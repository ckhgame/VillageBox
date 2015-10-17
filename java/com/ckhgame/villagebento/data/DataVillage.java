package com.ckhgame.villagebento.data;

import java.util.HashMap;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.helpers.HelperVillageData;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class DataVillage extends Data{
	
	public int id;
	public String name;
	public HashMap<Integer,DataBuilding> mapDataBuilding = new HashMap<Integer,DataBuilding>();
	public HashMap<Integer,DataVillager> mapDataVillager = new HashMap<Integer,DataVillager>();
	
	//caches
	public AxisAlignedBB cacheVillageBoundary = null;
	 
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		
		compound.setInteger(ConfigData.KeyDataVillageID,this.id);
		compound.setString(ConfigData.KeyDataVillageName,this.name);
		
		//building Map
		int idx = 0;
		compound.setInteger(ConfigData.KeyDataVillageBuildingMapSize, this.mapDataBuilding.size());
		for(DataBuilding bd:this.mapDataBuilding.values()){
			NBTTagCompound c = new NBTTagCompound();
			bd.writeToNBT(c);
			compound.setTag(ConfigData.KeyDataVillageBuildingMapPrefix + (idx++), c);
		}
		
		//villager Map
		idx = 0;
		compound.setInteger(ConfigData.KeyDataVillageVillagerMapSize, this.mapDataVillager.size());
		for(DataVillager bvr:this.mapDataVillager.values()){
			NBTTagCompound c = new NBTTagCompound();
			bvr.writeToNBT(c);
			compound.setTag(ConfigData.KeyDataVillageVillagerMapPrefix + (idx++), c);
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {

		this.id = compound.getInteger(ConfigData.KeyDataVillageID);
		this.name = compound.getString(ConfigData.KeyDataVillageName);
		
		//building Map
		mapDataBuilding.clear();
		int size = compound.getInteger(ConfigData.KeyDataVillageBuildingMapSize);
		for(int i =0;i<size;i++){
			DataBuilding db = new DataBuilding();
			db.readFromNBT((NBTTagCompound)compound.getTag(ConfigData.KeyDataVillageBuildingMapPrefix + i));
			mapDataBuilding.put(db.id, db);
		}
		
		//villager Map
		mapDataVillager.clear();
		size = compound.getInteger(ConfigData.KeyDataVillageVillagerMapSize);
		for(int i =0;i<size;i++){
			DataVillager dvr = new DataVillager();
			dvr.readFromNBT((NBTTagCompound)compound.getTag(ConfigData.KeyDataVillageVillagerMapPrefix + i));
			mapDataVillager.put(dvr.id, dvr);
		}
		
		//refresh cache
		HelperVillageData.refreshCacheVillageBoundary(this);
	}
	
}
