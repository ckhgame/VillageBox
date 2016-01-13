package com.ckhgame.villagebento.entity;

import java.util.ArrayList;

import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.building.BuildingLargeHotel;
import com.ckhgame.villagebento.building.BuildingSmallHotel;
import com.ckhgame.villagebento.config.ConfigVillage;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.profession.ProfessionBuilder;
import com.ckhgame.villagebento.profession.ProfessionBlackSmith;
import com.ckhgame.villagebento.profession.ProfessionFlowerShopOwner;
import com.ckhgame.villagebento.profession.ProfessionHunter;
import com.ckhgame.villagebento.profession.ProfessionLargeCasinoManager;
import com.ckhgame.villagebento.util.data.Vec3Int;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.tool.NameGenerator;
import com.ckhgame.villagebento.util.tool.VBRandom;
import com.ckhgame.villagebento.util.village.HelperVillager;
import com.ckhgame.villagebento.util.village.PlayerMsg;
import com.ckhgame.villagebento.util.village.VillagerSpawner;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class VBVillagerMgr {
	
	//----------- singleton
	private static VBVillagerMgr instance = null;
	public static VBVillagerMgr get(){
		if(instance == null)
			instance = new VBVillagerMgr();
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
	
	//================================================
	//====================Traveller======================
	//================================================
	
	private Class<? extends Profession>[][] travelerClassSets;
	
	public void updateTravelers(){
		ArrayList<EntityVBVillager> removes = new ArrayList<EntityVBVillager>();
		for(EntityVBVillager villager : villagers){
			if(villager.isTraveler()){
				villager.stepTravelTimer();
				if(villager.getTravelTimer() <= 0 && villager.InteractTarget == null){
					//traveler depart
					removes.add(villager);
				}
			}
		}
		
		for(EntityVBVillager villager : removes){
			villager.worldObj.removeEntity(villager);
			VBVillagerMgr.get().removeVillager(villager);
			DataBuilding db = HelperDataVB.findBuildingByID(DataVillageBento.get(), villager.getBuildingID());
			db.returnBed(villager.bedIdx);
			PlayerMsg.sendToAllTranslation("villagebento.msg.TravelerDeparted");
		}
		
	}
	
	private void initTravelerSets(){
		if(travelerClassSets != null){
			return;
		}
		
		travelerClassSets = new Class[2][];
		
		//traveler will appear in small tavern
		travelerClassSets[0] = new Class[]{
				ProfessionBuilder.class,
				ProfessionBlackSmith.class,
				ProfessionHunter.class
		};
		
		//traveler will appear in both small and large tavern
		travelerClassSets[1] = new Class[]{
				ProfessionLargeCasinoManager.class,
				ProfessionFlowerShopOwner.class
		};
	}

	public void spawnRandomTravelers(){
		
		initTravelerSets();
		
		int typeSmallHotel = Building.registry.get(BuildingSmallHotel.class).getType();
		int typeLargeHotel = Building.registry.get(BuildingLargeHotel.class).getType();
		int chance = ConfigVillage.TravelerSpawnChance;
		
		DataVillageBento dataVB = DataVillageBento.get();
	    for(DataVillage dv : dataVB.mapDataVillage.values()){
	    	for(DataBuilding db : dv.mapDataBuilding.values()){
	    		//if the building is hotel
	    		if(db.type == typeSmallHotel || db.type == typeLargeHotel){
	    			//if in the chance of spawning
	    			if(VBRandom.getRand().nextInt(chance) == 0){
	    				//is there still at least one bed available?
	    				if(db.hasEmptyBed()){
	    					//get random traveler type
	    					int setIdx = (db.type == typeSmallHotel?0:VBRandom.getRand().nextInt(2));
	    					Class<? extends Profession>[] set = travelerClassSets[setIdx];
	    					Class<? extends Profession> pc = set[VBRandom.getRand().nextInt(set.length)];
	    					//spawn new villager into world
	    					Profession profession = Profession.registry.get(pc);
	    					String name = profession.isMale()?NameGenerator.getRandomMaleName():NameGenerator.getRandomFemaleName();
	    					
	    					int bedIdx = db.applyForBed(name);
	    					if(bedIdx >=0){
	    						Vec3Int bedPosition = db.getBedPosition(bedIdx);
	    						Vec3 p = HelperVillager.findWalkableBlockNearPos(dataVB.world, bedPosition.x,bedPosition.y, bedPosition.z);
	    						EntityVBVillager villager = VillagerSpawner.spawn(dataVB.world, pc, db.id, 
	    																												MathHelper.floor_double(p.xCoord), MathHelper.floor_double(p.yCoord), MathHelper.floor_double(p.zCoord),
	    																												name);
	    						if(villager != null){
	    							villager.bedIdx = bedIdx;
	    							villager.setTraveler(ConfigVillage.TravelerStayTime);
	    							PlayerMsg.sendToAllTranslation("villagebento.msg.TravelerArrived");
	    						}
	    						else{
	    							db.returnBed(bedIdx);
	    						}
	    					}
	    				}	
	    			}	
	    		}
	    	}
	    }
	}
}
