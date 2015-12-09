package com.ckhgame.villagebento.util.village;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.tool.VBRandom;

import net.minecraft.util.Vec3;

public class VBRandomPositionGenerator{
	
	public static Vec3 findRandomTargetNearBuildingFast(EntityVBVillager evr){
		
		Random random = evr.getRNG();
		
		int bx = evr.buildingX;
		int by = evr.buildingY;
		int bz = evr.buildingZ;
		int d = ConfigVillager.AIWanderDistanceMaxNearBuilding;
		int sx = evr.buildingSizeX + d;
		int sz = evr.buildingSizeZ + d;
		int sy = ConfigVillager.AIWanderDistanceMaxY;;

        int x = random.nextInt(2 * sx + 1) - sx + bx;
        int z = random.nextInt(2 * sz + 1) - sz + bz;
        int y = random.nextInt(2 * sy + 1) - sy + by;

        return Vec3.createVectorHelper((double)x, (double)y, (double)z);
	}
	
	public static Vec3 findRandomTargetNearBuilding(EntityVBVillager evr){
		
		Random random = evr.getRNG();
		
		int bx = evr.buildingX;
		int by = evr.buildingY;
		int bz = evr.buildingZ;
		int d = ConfigVillager.AIWanderDistanceMaxNearBuilding;
		int sx = evr.buildingSizeX + d;
		int sz = evr.buildingSizeZ + d;
		int sy = ConfigVillager.AIWanderDistanceMaxY;;
        
		float maxWeight = -99999;
		int fx = bz;
		int fy = by;
		int fz = bz;
		boolean found = false;
		
        for (int i = 0; i < 10; i++)
        {
            int x = random.nextInt(2 * sx + 1) - sx + bx;
            int z = random.nextInt(2 * sz + 1) - sz + bz;
            int y = random.nextInt(2 * sy + 1) - sy + by;

            float weight = evr.getBlockPathWeight(x, y, z);

            if (weight > maxWeight)
            {
            	maxWeight = weight;
                fx = x;
                fy = y;
                fz = z;
                found = true;
            }
        }

        return found?Vec3.createVectorHelper((double)fx, (double)fy, (double)fz):null;
	}
	
	public static Vec3 findRandomTargetInBuildingFast(int BuildingID, boolean aboveGroundwork)
    {
		DataBuilding db = HelperDataVB.findBuildingByID(DataVillageBento.get(), BuildingID);
		if(db == null) return null;
		
		int bx = db.x;
		int by = db.y;
		int bz = db.z;
		int d = ConfigVillager.ALWanderInBuildingWallOffset;
		int sx = Math.max(0,db.sizeX - d);
		int sz = Math.max(0,db.sizeZ - d);
		int sh = ConfigBuilding.BuildingMaxHeight;
		int sd = aboveGroundwork?0:ConfigBuilding.BuildingGroundWorkDepth;

		Random rand = VBRandom.getRand();
        int x = rand.nextInt(2 * sx + 1) - sx + bx;
        int z = rand.nextInt(2 * sz + 1) - sz + bz;
        int y = rand.nextInt(sd + sh) - sd + by;

        return Vec3.createVectorHelper((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D);
    }
	
	public static Vec3 findRandomTargetInBuildingFast(EntityVBVillager evr)
    {
		
		Random random = evr.getRNG();
		
		int bx = evr.buildingX;
		int by = evr.buildingY;
		int bz = evr.buildingZ;
		int d = ConfigVillager.ALWanderInBuildingWallOffset;
		int sx = Math.max(0,evr.buildingSizeX - d);
		int sz = Math.max(0,evr.buildingSizeZ - d);
		int sh = ConfigBuilding.BuildingMaxHeight;
		int sd = ConfigBuilding.BuildingGroundWorkDepth;

        int x = random.nextInt(2 * sx + 1) - sx + bx;
        int z = random.nextInt(2 * sz + 1) - sz + bz;
        int y = random.nextInt(sd + sh) - sd + by;

        return Vec3.createVectorHelper((double)x, (double)y, (double)z);
    }
	
	public static Vec3 findRandomTargetInBuilding(EntityVBVillager evr)
    {
		
		Random random = evr.getRNG();
		
		int bx = evr.buildingX;
		int by = evr.buildingY;
		int bz = evr.buildingZ;
		int sx = evr.buildingSizeX;
		int sz = evr.buildingSizeZ;
		int sh = ConfigBuilding.BuildingMaxHeight;
		int sd = ConfigBuilding.BuildingGroundWorkDepth;
        
		float maxWeight = -99999;
		int fx = bx;
		int fy = by;
		int fz = bz;
		boolean found = false;
		
        for (int i = 0; i < 10; i++)
        {
            int x = random.nextInt(2 * sx + 1) - sx + bx;
            int z = random.nextInt(2 * sz + 1) - sz + bz;
            int y = random.nextInt(sd + sh) - sd + by;

            float weight = evr.getBlockPathWeight(x, y, z);

            if (weight > maxWeight)
            {
            	maxWeight = weight;
                fx = x;
                fy = y;
                fz = z;
                found = true;
            }
        }

        return found?Vec3.createVectorHelper((double)fx, (double)fy, (double)fz):null;
    }

	public static Vec3 findRandomTargetGuardPatrol(EntityVBVillager evr){
		DataBuilding db = HelperDataVB.getRandomBuildingInVillage(evr,
																										ConfigVillager.AIGuardPotrolSearchDistanceX,
																										ConfigVillager.AIGuardPotrolSearchDistanceY,
																										ConfigVillager.AIGuardPotrolSearchDistanceZ);
		if(db != null){
			
			Random random = evr.getRNG();
			
			int d = ConfigVillager.ALGuardPatrolNearMaxBuilding;
			int sy = ConfigVillager.AIGuardPatrolDistanceMaxY;
			int sx = db.sizeX;
			int sz = db.sizeZ;

			boolean onX = random.nextBoolean();
			int x = db.x;
			int z = db.z;
			if(onX){
				x += random.nextInt(1 + sx * 2) - sx;
				z += (random.nextBoolean()?1:-1) * (random.nextInt(d) + 1 + sz);
			}
			else{
				z += random.nextInt(1 + sz * 2) - sz;
				x += (random.nextBoolean()?1:-1) * (random.nextInt(d) + 1 + sx);
			}

			int y = random.nextInt(2 * sy + 1) - sy + db.y;

	        return Vec3.createVectorHelper((double)x, (double)y, (double)z);
		}
		
		return null;
	}
	
	
	
	
}
