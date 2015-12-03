package com.ckhgame.villagebento.util.village;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.util.Vec3;

public class VillagerNavigator {
	public static void tryMoveToXYZ(EntityVBVillager entity, double x,double y,double z){
		if(!entity.getNavigator().tryMoveToXYZ(x,y,z,ConfigVillager.VillagerMoveSpeed)){
			tryMoveTowardsSelfBuilding(entity);
		}
	}
	
	public static void tryMoveTowardsSelfBuilding(EntityVBVillager entity){
		Vec3 dir = Vec3.createVectorHelper(	entity.buildingX - entity.posX,
											entity.buildingY - entity.posY,
											entity.buildingZ - entity.posZ)
						.normalize();
		double d = ConfigVillager.VillagerMoveTowardsDistance;
		int r = ConfigVillager.VillagerMoveTowardsRange;
		Random rand = entity.getRNG();
		entity.getNavigator().tryMoveToXYZ(	entity.posX + dir.xCoord * d + rand.nextInt(r *2+ 1) - r,
											entity.posY + dir.yCoord * d + rand.nextInt(r *2+ 1) - r,
											entity.posZ + dir.zCoord * d + rand.nextInt(r *2+ 1) - r,
											ConfigVillager.VillagerMoveSpeed);
	}
}
