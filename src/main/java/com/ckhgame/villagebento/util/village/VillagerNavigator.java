package com.ckhgame.villagebento.util.village;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class VillagerNavigator {
	public static boolean tryMoveToXYZ(EntityVBVillager entity, double x,double y,double z){
		
		if(!entity.getNavigator().tryMoveToXYZ(x,y,z,ConfigVillager.VillagerMoveSpeed))
			return tryMoveTowardsTheTarget(entity,x,y,z);
		return true;
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
		
		while(d > 1.0D){
			double r = d / l;
			tx = entity.posX + dx * r;
			ty = entity.posY + dy * r;
			tz = entity.posZ + dz * r;
			if(!entity.getNavigator().tryMoveToXYZ(tx,ty,tz,ConfigVillager.VillagerMoveSpeed)){
				d *= 0.5D;
			}
			else{
				break;
			}
		}
			
		if(d > 1.0D){
			return true; 
		}
		else{
			return false;
		}
	}
}
