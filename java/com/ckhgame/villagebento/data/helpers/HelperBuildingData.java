package com.ckhgame.villagebento.data.helpers;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;

public class HelperBuildingData {
	
	public static int generateNextID(DataVillageBento dataVB){
		dataVB.dataID.idLastBuilding += 1;
		dataVB.markDirty();
		return dataVB.dataID.idLastBuilding;
	}
	
	public static DataBuilding createDataBuilding(int x, int y, int z, int type, int sizeType){
		
		int sx = ConfigBuilding.GroundWorkSmallSizeX;
		int sz = ConfigBuilding.GroundWorkSmallSizeZ;
		if(sizeType == ConfigBuilding.SizeType_Medium){
			sx = ConfigBuilding.GroundWorkMediumSizeX;
			sz = ConfigBuilding.GroundWorkMediumSizeZ;
		}
		else if(sizeType == ConfigBuilding.SizeType_Large){
			sx = ConfigBuilding.GroundWorkLargeSizeX;
			sz = ConfigBuilding.GroundWorkLargeSizeZ;
		}
		
		DataBuilding db = new DataBuilding();
		db.id = -1; //the id will be automatially generated when adding to the village data
		db.x = x;
		db.y = y;
		db.z = z;
		db.sizeX =sx;
		db.sizeZ = sz;
		db.type = type;
		
		return db;
	}
}
