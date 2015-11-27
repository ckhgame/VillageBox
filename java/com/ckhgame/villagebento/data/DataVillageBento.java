package com.ckhgame.villagebento.data;

import java.util.HashMap;

import com.ckhgame.villagebento.config.ConfigData;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class DataVillageBento extends WorldSavedData{
	
	public HashMap<Integer,DataVillage> mapDataVillage = new HashMap<Integer,DataVillage>();
	public DataDeath dataDeath = new DataDeath();
	public DataID dataID = new DataID();
	public World world;
	
	public DataVillageBento(String tagName) {
		super(tagName);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		//village list
		mapDataVillage.clear();
		int size = compound.getInteger(ConfigData.KeyDataVillageBentoVillageMapSize);
		for(int i =0;i<size;i++){
			DataVillage dv = new DataVillage();
			dv.readFromNBT((NBTTagCompound)compound.getTag(ConfigData.KeyDataVillageBentoVillageMapPrefix + i));
			mapDataVillage.put(dv.id,dv);
		}
		
		//id
		dataID.readFromNBT((NBTTagCompound)compound.getTag(ConfigData.KeyDataVillageBentoIDs));
		
		//death
		dataDeath.readFromNBT(compound);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		//village list
		int idx = 0;
		compound.setInteger(ConfigData.KeyDataVillageBentoVillageMapSize, this.mapDataVillage.size());
		for(DataVillage dv:this.mapDataVillage.values()){
			NBTTagCompound c = new NBTTagCompound();
			dv.writeToNBT(c);
			compound.setTag(ConfigData.KeyDataVillageBentoVillageMapPrefix + (idx++), c);
		}
		
		//id
		NBTTagCompound c = new NBTTagCompound();
		dataID.writeToNBT(c);
		compound.setTag(ConfigData.KeyDataVillageBentoIDs, c);
		
		//death
		dataDeath.writeToNBT(compound);
	}
	
	private static DataVillageBento instanceCache = null;
	
	public static DataVillageBento get(){
		return instanceCache;
	}
	
	public static DataVillageBento init(World world){

		if(world.provider.dimensionId != 0) // only overworld
			return null;
		
		if(world.mapStorage == null)
			return null;
		
		DataVillageBento data = (DataVillageBento)world.mapStorage.loadData(DataVillageBento.class, ConfigData.KeyDataVillageBentoMapStorage);
		
		if(data == null){
			data = new DataVillageBento(ConfigData.KeyDataVillageBentoMapStorage);
			data.markDirty();
			world.mapStorage.setData(ConfigData.KeyDataVillageBentoMapStorage, data);
		}
		
		data.world = world;
		
		instanceCache = data;
		
		return data;
	}
	
	public static void resetInstance(){
		instanceCache = null;
		System.out.println("=============================== reset data vb instance===================================");
	}

}
