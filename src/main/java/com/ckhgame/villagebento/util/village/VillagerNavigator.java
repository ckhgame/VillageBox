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
			System.out.println(entity.worldObj.getBlock((int)x, (int)y, (int)z) + ":" + x + "," + y + "," + z);
			System.out.println("Cant find the path!!!!!!!!");
			removeTarget = !tryMoveTowardsTheTarget(entity,x,y,z);
		}
		return removeTarget;
	}
	
	public static boolean tryMoveTowardsTheTarget(EntityVBVillager entity, double x, double y, double z){		
		double tx= x;
		double ty = y;
		double tz = z;
		double d = ConfigVillager.AIVillagerSearchDistance  - 0.5D;
		
		double dx = tx - entity.posX;
		double dy = ty - entity.posY;
		double dz = tz - entity.posZ;
		double l = Math.sqrt(dx * dx + dy * dy + dz * dz);
		
		if(l > d){
			
			while(d > 1.0D){
				double r = d / l;
				tx = entity.posX + dx * r;
				ty = entity.posY + dy * r;
				tz = entity.posZ + dz * r;
				if(!entity.getNavigator().tryMoveToXYZ(tx,ty,tz,ConfigVillager.VillagerMoveSpeed)){
					System.out.println("d:"+d + ", l:" + l + ",r:" + r);
					System.out.println(entity.worldObj.getBlock((int)tx, (int)ty, (int)tz) + ":" + tx + "," + ty + "," + tz);
					d *= 0.5D;
				}
				else{
					break;
				}
			}
			
			if(d > 1.0D){
				return true; // do not remove the moving target
			}
			else{
				System.out.println("22222 Cant find the path!!!!!!!!");
				return false;// remove the moving target
			}
		}
		else{
			return true;// do not remove the moving target
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
