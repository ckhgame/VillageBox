package com.ckhgame.villagebento.data.helpers;

import com.ckhgame.villagebento.building.BuildingTypes;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.config.ConfigVillage;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data_old.BuildingData;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class HelperVillageData {
	
	public static int generateNextID(DataVillageBento dataVB){
		dataVB.dataID.idLastVillage += 1;
		dataVB.markDirty();
		return dataVB.dataID.idLastVillage;
	}
	
	public static void refreshCacheVillageBoundary(DataVillage dv){
		
		dv.cacheVillageBoundary = null;
		
		if(dv.mapDataBuilding.size() > 0){
			int minx,miny,minz,maxx,maxy,maxz;
			minx = miny = minz = Integer.MAX_VALUE;
			maxx = maxy = maxz = Integer.MIN_VALUE;
			int d;
			for(DataBuilding bd:dv.mapDataBuilding.values()){
				d = bd.x - bd.sizeX;		if(d < minx) minx = d;
				d = bd.x + bd.sizeX;		if(d > maxx) maxx = d;
				d = bd.z - bd.sizeZ;		if(d < minz) minz = d;
				d = bd.z + bd.sizeZ;		if(d > maxz) maxz = d;
				d = bd.y;					if(d < miny) miny = d;
				d = bd.y;					if(d > maxy) maxy = d;
			}
			dv.cacheVillageBoundary = AxisAlignedBB.getBoundingBox(minx, miny, minz, maxx, maxy, maxz);
			
			//expand boundary to have space for new buildings
			dv.cacheVillageBoundary = dv.cacheVillageBoundary.expand(	ConfigVillage.VillageBoundaryExtensionHorizontal, 
																		ConfigVillage.VillageBoundaryExtensionVertical,
																		ConfigVillage.VillageBoundaryExtensionHorizontal);
		}
	}

	
	public static boolean addBuildingData(DataVillageBento dataVB,DataBuilding db){
		
		//try to find a existed village for this new building
		DataVillage dv = null;
		Vec3 pos = Vec3.createVectorHelper(db.x, db.y, db.z);
		for(DataVillage tdv : dataVB.mapDataVillage.values()){
			if(tdv.cacheVillageBoundary.isVecInside(pos)){
				//found it
				dv = tdv;
				break;
			}
		}
		
		//if no existed village found and the type of the building is Village Center, then we need to create a new one
		if(dv == null && db.type == BuildingTypes.VillageCenter){
			//before we create a new village, we have to check if it will be collide with other villages
			for(DataVillage tdv : dataVB.mapDataVillage.values()){
				if(	db.x + ConfigVillage.NewVillageSizeRequirment >= tdv.cacheVillageBoundary.minX ||
					db.x - ConfigVillage.NewVillageSizeRequirment <= tdv.cacheVillageBoundary.maxX ||
					db.z + ConfigVillage.NewVillageSizeRequirment >= tdv.cacheVillageBoundary.minZ ||
					db.z - ConfigVillage.NewVillageSizeRequirment <= tdv.cacheVillageBoundary.maxZ)
					return false;
			}
			
			//if we pass the collision test, we now can create the new village
			dv = new DataVillage();
			dv.id = HelperVillageData.generateNextID(dataVB);
			dv.name = "TestName";
			dataVB.mapDataVillage.put(dv.id, dv);
		}
		else{
		//else we just return failed
			return false;
		}
		
		//** when we reach this step, a village is guaranteed for us to add the new building **
		
		//make sure the new building will not overlap on the existed buildings.
		//in addition, there must be a certain tile gap between two buildings
		int gap = ConfigBuilding.BuildingGap;
		for(DataBuilding bdexisted:dv.mapDataBuilding.values()){
			if(db.x + db.sizeX < bdexisted.x - bdexisted.sizeX - gap||
			   db.x - db.sizeX > bdexisted.x + bdexisted.sizeX + gap||
			   db.z + db.sizeZ < bdexisted.z - bdexisted.sizeZ - gap||
			   db.z - db.sizeZ > bdexisted.z + bdexisted.sizeZ + gap){
				continue;
			}
			else{
				return false;
			}
		}
		
		//finally we add the new building to the village data and refresh the boundary cache of the village
		db.id = HelperBuildingData.generateNextID(dataVB);
		dv.mapDataBuilding.put(db.id, db);
		HelperVillageData.refreshCacheVillageBoundary(dv);

		return true;
	}
}
