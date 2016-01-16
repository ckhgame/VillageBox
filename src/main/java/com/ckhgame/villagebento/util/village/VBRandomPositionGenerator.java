package com.ckhgame.villagebento.util.village;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.tool.VBRandom;

import net.minecraft.block.Block;
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
		int sy = ConfigVillager.AIWanderDistanceMaxY;

		int x = 0,y = 0,z = 0;
		Block b;
		int t;
        int tryTimes = 5;
        for(t =0;t<tryTimes;t++){
            x = random.nextInt(2 * sx + 1) - sx + bx;
            z = random.nextInt(2 * sz + 1) - sz + bz;
            y = random.nextInt(2 * sy + 1) - sy + by;
            b = evr.worldObj.getBlock(x, y, z);
            if(!b.getMaterial().blocksMovement() && !b.getMaterial().isLiquid())
            	break;
        }
       
    	return t < tryTimes?Vec3.createVectorHelper((double)x, (double)y, (double)z):null;
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
		//int sh = ConfigBuilding.BuildingMaxHeight;
		//int sd = ConfigBuilding.BuildingGroundWorkDepth;
       
		int x = 0,y = 0,z = 0;
		Block b;
		int t;
        int tryTimes = 5;
        for(t =0;t<tryTimes;t++){
            x = random.nextInt(2 * sx + 1) - sx + bx;
            z = random.nextInt(2 * sz + 1) - sz + bz;
            y =  by;
            b = evr.worldObj.getBlock(x, y, z);
            if(!b.getMaterial().blocksMovement() && !b.getMaterial().isLiquid())
            	break;
        }
       
    	return t < tryTimes?Vec3.createVectorHelper((double)x, (double)y, (double)z):null;
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
