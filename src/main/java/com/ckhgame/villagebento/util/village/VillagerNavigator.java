package com.ckhgame.villagebento.util.village;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class VillagerNavigator {
	public static boolean tryMoveToXYZ(EntityVBVillager entity, double x,double y,double z){
		
		boolean removeTarget = entity.getNavigator().tryMoveToXYZ(x,y,z,ConfigVillager.VillagerMoveSpeed);
		if(!removeTarget){
			System.out.println("Cant find the path!!!!!!!!");
			removeTarget = !tryMoveTowardsTheTarget(entity,x,y,z);
		}
		return removeTarget;
	}
	
	public static boolean tryMoveTowardsTheTarget(EntityVBVillager entity, double x, double y, double z){		
		double tx= x;
		double ty = y;
		double tz = z;
		double d = ConfigVillager.AIVillagerSearchDistance - 1.0D;
		
		if(tx - entity.posX > d) tx = entity.posX + d;
		else if(tx - entity.posX < -d) tx = entity.posX - d;
		
		if(ty - entity.posY > d) ty = entity.posY + d;
		else if(ty - entity.posY < -d) ty = entity.posY - d;
		
		if(tz - entity.posZ > d) tz = entity.posZ + d;
		else if(tz - entity.posZ < -d) tz = entity.posZ - d;
		
		int dy = 0;
		System.out.println(entity.worldObj.getBlock((int)tx, (int)ty, (int)tz));
		while(!entity.getNavigator().tryMoveToXYZ(tx,ty + dy,tz,ConfigVillager.VillagerMoveSpeed)){
			if(++dy >= 12)
				break;
		}
		
		if(dy < 12){
			return true;
		}
		else
		{
			System.out.println("22222 Cant find the path!!!!!!!!");
			return false;
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
