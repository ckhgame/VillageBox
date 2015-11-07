package com.ckhgame.villagebento.util;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.entity.EntityCreature;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class VBRandomPositionGenerator{
	
	public static Vec3 findRandomTargetNearBuildingFast(EntityVBVillager evr){
		if(!evr.isVBInitialized())
			return null;
		
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
		if(!evr.isVBInitialized())
			return null;
		
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
	
	public static Vec3 findRandomTargetInBuildingFast(EntityVBVillager evr)
    {
		if(!evr.isVBInitialized())
			return null;
		
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
		if(!evr.isVBInitialized())
			return null;
		
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

	
}
