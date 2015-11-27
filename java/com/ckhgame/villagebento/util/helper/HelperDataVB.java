package com.ckhgame.villagebento.util.helper;

import java.util.ArrayList;

import com.ckhgame.villagebento.building.builder.RestrictionExceptions;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.config.ConfigRendering;
import com.ckhgame.villagebento.config.ConfigVillage;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataDeadVillager;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.VBEntityMgr;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.data.BoxWithColor;
import com.ckhgame.villagebento.util.village.VillagerSpawner;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldServer;

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
		
		//remove village B from the map
		dataVB.mapDataVillage.remove(vb.id);
		dataVB.markDirty();
		
		refreshCacheVillageBoundary(va);
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

	public static boolean removeBuildingData(DataVillageBento dataVB,int buildingID){
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			for(DataBuilding db : dv.mapDataBuilding.values()){
				if(db.id == buildingID){
					//villagers
					ArrayList<EntityVBVillager> villagers = VBEntityMgr.get().findBuildingVillagers(buildingID);
					WorldServer ws = MinecraftServer.getServer().worldServerForDimension(0);
					for(EntityVBVillager villager : villagers){		
						ws.removeEntity(villager);
						//if add to death list
						//HelperDataVB.addDeadVillager(dataVB, villager);
					}
					//remove building
					dv.mapDataBuilding.remove(buildingID);
					
					//if the current village has no building 
					if(dv.mapDataBuilding.size() == 0){
						//remove the villager
						dataVB.mapDataVillage.remove(dv.id);
					}
					else{
						HelperDataVB.refreshCacheVillageBoundary(dv);
					}
					
					dataVB.markDirty();
					
					return true;				
				}
			}
		}
		
		return false;
	}
	
	public static void displayVillageInfo(DataVillage dv){
		System.out.println("============ Village Info =============");
		
		System.out.println("Buildings:" + dv.mapDataBuilding.size());
		
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
	
	public static DataBuilding findBuildingByPos(DataVillageBento dataVB,int x, int y, int z){
		DataVillage dv = findVillageByPos(dataVB,x,z);
		if(dv != null){
			for(DataBuilding db:dv.mapDataBuilding.values()){
				if(x < db.x - db.sizeX||
					x > db.x + db.sizeX||
					z < db.z - db.sizeZ ||
					z > db.z + db.sizeZ ||
					y < db.y - ConfigBuilding.BuildingGroundWorkDepth ||
					y >= db.y + ConfigBuilding.BuildingMaxHeight){
					continue;
				}
				else
					return db;
			}
		}
		return null;
	}
	
	public static int getVillagerIdxInBuilding(DataVillageBento dataVB, EntityVBVillager villager){
		
		int idx = -1;
		
//		DataVillage dv = null;
//		for(DataVillage fdv : dataVB.mapDataVillage.values()){
//			if(fdv.mapDataVillager.containsKey(dvr.id)){
//				dv = fdv;
//				break;
//			}
//		}
//		
//		if(dv != null){
//			for(DataVillager other: dv.mapDataVillager.values()){
//				if(other.buildingID == dvr.buildingID){
//					idx++;
//					if(other.id == dvr.id)
//						break;
//				}
//			}
//		}

		return idx;
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
	
	//buldings
	public static DataBuilding createDataBuilding(int x, int y, int z, int type, int sizeType, String owner){
		
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
		db.owner = owner;
		
		return db;
	}
	
	public static void addDeadVillager(DataVillageBento dataVB, EntityVBVillager villager){
		
		DataDeadVillager ddvr = new DataDeadVillager();
		ddvr.name = villager.getName();
		ddvr.professionID = villager.getProfessionID();
		ddvr.buildingID = villager.getBuildingID();
		ddvr.initX = villager.getInitPosX();
		ddvr.initY = villager.getInitPosY();
		ddvr.initZ = villager.getInitPosZ();
		ddvr.exp = villager.getExp();
		ddvr.timer = 0;	
		dataVB.dataDeath.deadVillagers.add(ddvr);
		dataVB.markDirty();
	}
	
	public static void removeDeadVillagerOfBuilding(DataVillageBento dataVB, int buildingID){
		ArrayList<DataDeadVillager> removes = new ArrayList<DataDeadVillager>();
		for(DataDeadVillager ddvr : dataVB.dataDeath.deadVillagers){
			if(ddvr.buildingID == buildingID){
				removes.add(ddvr);
			}
		}
		
		for(DataDeadVillager ddvr : removes){
			dataVB.dataDeath.deadVillagers.remove(ddvr);
		}
	}
	
	public static void stepDeathAll(DataVillageBento dataVB){
		
		System.out.println("look at those poor dead people...");
		
		ArrayList<DataDeadVillager> removes = new ArrayList<DataDeadVillager>();
		
		for(DataDeadVillager ddvr : dataVB.dataDeath.deadVillagers){
			ddvr.timer += 24; // one day
			if(ddvr.timer >= ConfigVillager.VillagerRevivingDuration){
				removes.add(ddvr);
				VillagerSpawner.spawn(dataVB.world, Profession.registry.get(ddvr.professionID).getClass(), ddvr.buildingID, ddvr.initX, ddvr.initY, ddvr.initZ,ddvr.name);
			}
		}
		
		for(DataDeadVillager ddvr : removes){
			dataVB.dataDeath.deadVillagers.remove(ddvr);
		}

		dataVB.markDirty();
	}
	
	public static void tpEntityVillagersInbuildingToInitPos(DataBuilding db){
		 ArrayList<EntityVBVillager> villagers = VBEntityMgr.get().findBuildingVillagers(db.id);
		 for(EntityVBVillager villager : villagers){
			 villager.moveToInitPos();
		 }
	}
	
	public static ArrayList<BoxWithColor> getVillageOutlines(DataVillageBento dataVB, String playerName){
		
		ArrayList<BoxWithColor> bs = new ArrayList<BoxWithColor>();
		
		BoxWithColor b = null;
		AxisAlignedBB aabb = null;
		
		int[] cb = ConfigRendering.ColorVillageBuildingOutlines;
		int[] cv = ConfigRendering.ColorVillageOutlines;
		int[] co = ConfigRendering.ColorVillageOwnerOutlines;
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			//village
			aabb = dv.cacheVillageBoundary;
			b = new BoxWithColor(	(int)aabb.minX,(int)aabb.minY,(int)aabb.minZ,
									(int)aabb.maxX + 1,(int)aabb.maxY + 1,(int)aabb.maxZ + 1,
									cv[0],cv[1],cv[2],cv[3]);
			bs.add(b);
			
			//buildings
			int[] c;
			for(DataBuilding db : dv.mapDataBuilding.values()){
				c = (db.owner != null && db.owner.equals(playerName))?co:cb;
				b = new BoxWithColor(
						db.x - db.sizeX, db.y - ConfigBuilding.BuildingGroundWorkDepth, db.z - db.sizeZ, 
						db.x + db.sizeX + 1, db.y + ConfigBuilding.BuildingMaxHeight, db.z + db.sizeZ + 1,
						c[0], c[1], c[2], c[3]
						);
				bs.add(b);
			}
		}
		
		return bs;
	}
	

	
	//---------use of guard potral---------

	private static DataVillage getVillagersVillage(DataVillageBento dataVB, EntityVBVillager villager){
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(dv.mapDataBuilding.containsKey(villager.getBuildingID()))
				return dv;
		}
		return null;
	}
	
	public static DataBuilding getRandomBuildingInVillage(DataVillageBento dataVB, EntityVBVillager villager){
		DataVillage dv = getVillagersVillage(dataVB,villager);
		if(dv != null){
			
			ArrayList<DataBuilding> dbArr = new ArrayList<DataBuilding>();
			for(DataBuilding db : dv.mapDataBuilding.values()){
				double dx = db.x - villager.posX;
				double dz = db.z - villager.posZ;
				double dsq = dx * dx + dz * dz;
				if(dsq <= ConfigVillager.AIGuardPotrolSearchDistanceSq){
					dbArr.add(db);
				}
			}
			
			if(dbArr.size() == 0)
				return null;
			
			return dbArr.get(villager.getRNG().nextInt(dbArr.size()));
		}
		return null;
	}
	
	
	
	//---------check position------------------
	
	public static boolean isInVillage(DataVillage dv,int x,int z){
		if(	x < dv.cacheVillageBoundary.minX ||
				x > dv.cacheVillageBoundary.maxX ||
				z < dv.cacheVillageBoundary.minZ ||
				z > dv.cacheVillageBoundary.maxZ){
				return false;
			}
			return true;
	}
	
	public static boolean isNearVillage(DataVillage dv,double x,double z,double d){
		
		if(	x < dv.cacheVillageBoundary.minX - d ||
			x > dv.cacheVillageBoundary.maxX + d ||
			z < dv.cacheVillageBoundary.minZ - d ||
			z > dv.cacheVillageBoundary.maxZ + d){
			return false;
		}
		return true;
	}
	
	public static boolean isInBuilding(DataBuilding db,int x,int y,int z){
		//if this building filed is in restriction exception list, we just ignore it
		if(RestrictionExceptions.hasBuildingException(db.id))
			return false;
		
		if(	x < db.x - db.sizeX || x > db.x + db.sizeX ||
			z < db.z - db.sizeZ || z > db.z + db.sizeZ ||
			y < db.y - ConfigBuilding.BuildingGroundWorkDepth || y >= db.y + ConfigBuilding.BuildingMaxHeight){
			return false;
		}
		
		return true;
	}
	
	public static boolean isNearBuilding(DataBuilding db,double x,double y,double z,double d){
		//if this building filed is in restriction exception list, we just ignore it
		if(RestrictionExceptions.hasBuildingException(db.id))
			return false;
		
		if(	x < db.x - db.sizeX - d || x > db.x + db.sizeX + d + 1 ||
			z < db.z - db.sizeZ - d || z > db.z + db.sizeZ + d + 1||
			y < db.y - ConfigBuilding.BuildingGroundWorkDepth - d || y >= db.y + ConfigBuilding.BuildingMaxHeight + d + 1){
			return false;
		}
		
		return true;
	}
	
	
	public static boolean isEntityInBuilding(DataBuilding db,Entity entity){
		//if this building filed is in restriction exception list, we just ignore it
		if(RestrictionExceptions.hasBuildingException(db.id))
			return false;
		
		AxisAlignedBB aabb = getBuildingAABB(db);
		
		return aabb.isVecInside(Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ));
	}
	
	public static AxisAlignedBB getBuildingAABB(DataBuilding db){
		return AxisAlignedBB.getBoundingBox(db.x - db.sizeX, db.y - ConfigBuilding.BuildingGroundWorkDepth, db.z - db.sizeZ, 
											db.x + db.sizeX+1, db.y + ConfigBuilding.BuildingMaxHeight, db.z + db.sizeZ+1);
	}
	
	
	//player private field
	public static boolean PlayerOwnsBuilding(EntityPlayer player, DataBuilding db){
		if(db.owner == null)
			return false;
		return player.getDisplayName().equals(db.owner);
	}

}
