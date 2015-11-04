package com.ckhgame.villagebento.data.helper;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.config.ConfigRendering;
import com.ckhgame.villagebento.config.ConfigVillage;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.util.BoxWithColor;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class HelperDataVB {
	
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

	
	public static void mergeVillageBtoA(DataVillageBento dataVB,DataVillage va,DataVillage vb){
		//copy buldings from village B to village A
		for(DataBuilding db:vb.mapDataBuilding.values()){
			va.mapDataBuilding.put(db.id, db);
		}
		
		//copy villagers from village B to village A
		for(DataVillager dvr:vb.mapDataVillager.values()){
			va.mapDataVillager.put(dvr.id, dvr);
		}
		
		//remove village B from the map
		dataVB.mapDataVillage.remove(vb.id);
		dataVB.markDirty();
		
		refreshCacheVillageBoundary(va);
	}
	
	public static boolean addVillagerData(DataVillageBento dataVB,DataVillager dvr){

		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(dv.mapDataBuilding.containsKey(dvr.buildingID)){
				//if we find the building id, we are in the right village for the new villager
				dvr.id = generateNextVillagerID(dataVB);
				dv.mapDataVillager.put(dvr.id, dvr);
				dataVB.markDirty();
				return true;
			}
		}
		return false;
	}
	
	public static boolean addBuildingData(DataVillageBento dataVB,DataBuilding db){
		
		//try to find a existed village for this new building
		DataVillage dv = null;
		Vec3 pos = Vec3.createVectorHelper(db.x, db.y, db.z);
		for(DataVillage tdv : dataVB.mapDataVillage.values()){
			if(tdv.cacheVillageBoundary.expand(1, 1, 1).isVecInside(pos)){
				//found it
				dv = tdv;
				break;
			}
		}
		
		//if no existed village found and the type of the building is Village Center, then we need to create a new one
		if(dv == null){
			if(db.type == 10){//10 is the type of village center!
			
				//before we create a new village, we have to check if it will be collide with other villages
				for(DataVillage tdv : dataVB.mapDataVillage.values()){
					if(	!(db.x + ConfigVillage.NewVillageSizeRequirment < tdv.cacheVillageBoundary.minX ||
						db.x - ConfigVillage.NewVillageSizeRequirment > tdv.cacheVillageBoundary.maxX ||
						db.z + ConfigVillage.NewVillageSizeRequirment < tdv.cacheVillageBoundary.minZ ||
						db.z - ConfigVillage.NewVillageSizeRequirment > tdv.cacheVillageBoundary.maxZ)){
						return false;
					}
						
				}		
				//if we pass the collision test, we now can create the new village
				dv = new DataVillage();
				dv.id = generateNextVillageID(dataVB);
				dataVB.mapDataVillage.put(dv.id, dv);
			}
			else{
				return false;
			}
		}
		
		//** when we reach this step, a village is guaranteed for us to add the new building **
		
		//make sure the new building will not overlap on the existed buildings.
		//in addition, there must be a certain tile gap between two buildings
		int gap = ConfigBuilding.BuildingGap;
		for(DataBuilding bdexisted:dv.mapDataBuilding.values()){
			if(!(db.x + db.sizeX < bdexisted.x - bdexisted.sizeX - gap||
			   db.x - db.sizeX > bdexisted.x + bdexisted.sizeX + gap||
			   db.z + db.sizeZ < bdexisted.z - bdexisted.sizeZ - gap||
			   db.z - db.sizeZ > bdexisted.z + bdexisted.sizeZ + gap)){
				return false;
			}
		}
		
		//finally we add the new building to the village data and refresh the boundary cache of the village
		db.id = generateNextBuildingID(dataVB);
		dv.mapDataBuilding.put(db.id, db);
		dataVB.markDirty();
		HelperDataVB.refreshCacheVillageBoundary(dv);
		
		//last step, we have to check if two village are overlap
		ArrayList<DataVillage> lv = new ArrayList<DataVillage>();
		for(DataVillage dvt : dataVB.mapDataVillage.values()){
			lv.add(dvt);
		}	
		for(DataVillage dvt: lv){
			if(dv.id != dvt.id){
				if(	!(dv.cacheVillageBoundary.maxX < dvt.cacheVillageBoundary.minX ||
					dv.cacheVillageBoundary.minX > dvt.cacheVillageBoundary.maxX ||
					dv.cacheVillageBoundary.maxZ < dvt.cacheVillageBoundary.minZ ||
					dv.cacheVillageBoundary.minZ > dvt.cacheVillageBoundary.maxZ ))
				{
					//if two village are overlap, we need to merge them
					mergeVillageBtoA(dataVB,dv,dvt);
				}
			}
		}

		return true;
	}

	public static void displayVillageInfo(DataVillage dv){
		System.out.println("============ Village Info =============");
		
		System.out.println("Buildings:" + dv.mapDataBuilding.size());
		System.out.println("villagers:" + dv.mapDataVillager.size());
		
		System.out.println("============ ============ =============");
	}
	
	public static DataVillage findVillageByPos(DataVillageBento dataVB,int x ,int z){
		for(DataVillage dv:dataVB.mapDataVillage.values()){
			if(x < dv.cacheVillageBoundary.minX||
				x > dv.cacheVillageBoundary.maxX||
				z < dv.cacheVillageBoundary.minZ ||
				z > dv.cacheVillageBoundary.maxZ){
				continue;
			}
			else
				return dv;
		}
		return null;
	}
	
	public static DataVillage findVillageByID(DataVillageBento dataVB,int id){		
		if(dataVB.mapDataVillage.containsKey(id))
			return dataVB.mapDataVillage.get(id);
		else
			return null;
	}
	
	public static DataBuilding findBuildingByID(DataVillageBento dataVB, int id){
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(dv.mapDataBuilding.containsKey(id))
				return dv.mapDataBuilding.get(id);
		}
		return null;
	}
	
	public static DataBuilding findBuildingByPos(DataVillageBento dataVB,int x, int z){
		DataVillage dv = findVillageByPos(dataVB,x,z);
		if(dv != null){
			for(DataBuilding db:dv.mapDataBuilding.values()){
				if(x < db.x - db.sizeX||
					x > db.x + db.sizeX||
					z < db.z - db.sizeZ ||
					z > db.z + db.sizeZ){
					continue;
				}
				else
					return db;
			}
		}
		return null;
	}
	
	public static DataVillager findVillagerByID(DataVillageBento dataVB, int id){
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			for(DataVillager dvr : dv.mapDataVillager.values()){
				if(dv.mapDataVillager.containsKey(id))
					return dv.mapDataVillager.get(id);
			}
		}
		return null;
	}
	
	public static int generateNextBuildingID(DataVillageBento dataVB){
		dataVB.dataID.idLastBuilding += 1;
		dataVB.markDirty();
		return dataVB.dataID.idLastBuilding;
	}
	
	public static int generateNextVillageID(DataVillageBento dataVB){
		dataVB.dataID.idLastVillage += 1;
		dataVB.markDirty();
		return dataVB.dataID.idLastVillage;
	}
	
	public static int generateNextVillagerID(DataVillageBento dataVB){
		dataVB.dataID.idLastVillager += 1;
		dataVB.markDirty();
		return dataVB.dataID.idLastVillager;
	}
	
	//buldings
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
	
	public static DataVillager createDataVillager(int profession, String name, String skin, int buildingID){
		
		DataVillager dvr = new DataVillager();
		dvr.id = -1; //the id will be automatially generated when adding to the village data
		dvr.name = name;
		dvr.profession = profession;
		dvr.skin = skin;
		dvr.buildingID = buildingID;
		
		//villager components data
		Villager vr = Villager.registry.get(dvr.profession);
		DataVillagerComp dataComp;
		dvr.dataComponents.clear();
		for(VillagerComponent comp : vr.getVillagerComponents()){
			dataComp = comp.getNewDataInstance();
			if(dataComp != null){//needs data for the current component				
				dvr.dataComponents.add(dataComp);
			}
		}
		
		//refresh if needed
		HelperDataVrComp.refreshBuyList(dvr);
		HelperDataVrComp.refreshSellList(dvr);
		HelperDataVrComp.refreshWork(dvr);
		
		return dvr;
	}
	
	public static void setVillageDeath(DataVillageBento dataVB, int id){
		DataVillager dvr = findVillagerByID(dataVB,id);
		if(dvr != null){
			dvr.death = ConfigVillager.VillagerRevivingDurationByDay;
			dataVB.markDirty();
		}
	}
	
	public static void stepDeadVillages(DataVillageBento dataVB){
		
		System.out.println("look at those poor dead people...");
		
		//step all dead villages' reviving counting (1 day)
		boolean changed = false;
		for(DataVillage dv:dataVB.mapDataVillage.values()){
			for(DataVillager dvr:dv.mapDataVillager.values()){
				if(dvr.death > 0){
					dvr.death-=1;
					changed = true;
					//if the village is available for reviving, respawn the villager
					if(dvr.death == 0){
						DataBuilding db = findBuildingByID(dataVB,dvr.buildingID);
						if(db != null){
							//respawn on the position of the villager's building
							Villager.spawn(dataVB.world,db.x, db.y, db.z, dvr);
						}
					}
				}
			}
		}
		
		if(changed)
			dataVB.markDirty();
	}
	
	public static ArrayList<BoxWithColor> getVillageOutlines(DataVillageBento dataVB){
		
		ArrayList<BoxWithColor> bs = new ArrayList<BoxWithColor>();
		
		BoxWithColor b = null;
		AxisAlignedBB aabb = null;
		
		int[] cb = ConfigRendering.ColorVillageBuildingOutlines;
		int[] cv = ConfigRendering.ColorVillageOutlines;
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			//village
			aabb = dv.cacheVillageBoundary;
			b = new BoxWithColor(	(int)aabb.minX,(int)aabb.minY,(int)aabb.minZ,
									(int)aabb.maxX + 1,(int)aabb.maxY + 1,(int)aabb.maxZ + 1,
									cv[0],cv[1],cv[2],cv[3]);
			bs.add(b);
			
			//buildings
			for(DataBuilding db : dv.mapDataBuilding.values()){
				b = new BoxWithColor(
						db.x - db.sizeX, db.y - ConfigBuilding.BuildingGroundWorkDepth, db.z - db.sizeZ, 
						db.x + db.sizeX + 1, db.y + ConfigBuilding.BuildingMaxHeight, db.z + db.sizeZ + 1,
						cb[0], cb[1], cb[2], cb[3]
						);
				bs.add(b);
			}
		}
		
		return bs;
	}

}
