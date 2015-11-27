package com.ckhgame.villagebento.data;

import java.util.HashMap;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.util.IData;
import com.ckhgame.villagebento.util.helper.HelperDataVB;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class DataVillage implements IData{
	
	public int id;
	public HashMap<Integer,DataBuilding> mapDataBuilding = new HashMap<Integer,DataBuilding>();
	
	//caches
	public AxisAlignedBB cacheVillageBoundary = null;
	 
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		
		compound.setInteger(ConfigData.KeyDataVillageID,this.id);
		
		//building Map
		int idx = 0;
		compound.setInteger(ConfigData.KeyDataVillageBuildingMapSize, this.mapDataBuilding.size());
		for(DataBuilding bd:this.mapDataBuilding.values()){
			NBTTagCompound c = new NBTTagCompound();
			bd.writeToNBT(c);
			compound.setTag(ConfigData.KeyDataVillageBuildingMapPrefix + (idx++), c);
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {

		this.id = compound.getInteger(ConfigData.KeyDataVillageID);
		
		//building Map
		mapDataBuilding.clear();
		int size = compound.getInteger(ConfigData.KeyDataVillageBuildingMapSize);
		for(int i =0;i<size;i++){
			DataBuilding db = new DataBuilding();
			db.readFromNBT((NBTTagCompound)compound.getTag(ConfigData.KeyDataVillageBuildingMapPrefix + i));
			mapDataBuilding.put(db.id, db);
		}
		
		//refresh cache
		HelperDataVB.refreshCacheVillageBoundary(this);
	}
	
}
