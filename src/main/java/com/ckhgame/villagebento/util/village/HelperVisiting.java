package com.ckhgame.villagebento.util.village;

import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.building.BuildingLargeTavern;
import com.ckhgame.villagebento.building.BuildingSmallTavern;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.profession.ProfessionLargeTavernOwner;
import com.ckhgame.villagebento.profession.ProfessionTavernOwner;
import com.ckhgame.villagebento.util.data.Vec3Int;
import com.ckhgame.villagebento.util.helper.HelperDataVB;

import net.minecraft.util.Vec3;

public class HelperVisiting {
	public static Vec3 findNextMovingTargetInBuilding(int buildingID){
		
		Vec3 p = null;
		
		//find a random mountable 
		DataBuilding db = HelperDataVB.findBuildingByID(DataVillageBento.get(), buildingID);
		if(db != null){
			Vec3Int v  = db.getRandomAvailableMoutable();
			if(v != null)
				p = Vec3.createVectorHelper((double)v.x + 0.5D, (double)v.y + 0.1D, (double)v.z + 0.5D);
		}
		
		//find a random position
		if(p == null) {
			p = VBRandomPositionGenerator.findRandomTargetInBuildingFast(buildingID,true);
		}
		return p;
	}
	
	public static void startRandomVisiting(EntityVBVillager villager){
		int r = villager.getRNG().nextInt(10);
		if(r < 10) //%30 chances go to taverns... 
		{
			if(villager.getProfession().getClass() == ProfessionTavernOwner.class || villager.getProfession().getClass() == ProfessionLargeTavernOwner.class)
				return;
			
			int[] types = new int[2];
			types[0] = Building.registry.get(BuildingSmallTavern.class).getType();
			types[1] = Building.registry.get(BuildingLargeTavern.class).getType();
			
			DataBuilding db = HelperDataVB.getRandomBuildingInVillage(villager, 
					ConfigVillager.AIVillagerVisitingSearchDistanceX,
					ConfigVillager.AIVillagerVisitingSearchDistanceY,
					ConfigVillager.AIVillagerVisitingSearchDistanceZ,
					types);
			villager.setVisitingBuidlingID(db == null?-1:db.id);
			villager.setVisitingSkipSleeping(villager.getRNG().nextBoolean());
			
			System.out.println(villager.getName() + ": START VISITING!");
		}
//		else{
//		DataBuilding db = HelperDataVB.getRandomBuildingInVillage(this, 
//				ConfigVillager.AIVillagerVisitingSearchDistanceX,
//				ConfigVillager.AIVillagerVisitingSearchDistanceY,
//				ConfigVillager.AIVillagerVisitingSearchDistanceZ);
//		this.visitingBuildingID = (db == null?-1:db.id);
//		this.visitingSkipSleep = false;
//	}
	}
}
