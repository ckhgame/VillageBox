package com.ckhgame.villagebento.misc;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class VBParticles {
	public static final int Fx_VillagerLevelingUp = 0;
	
	public static void spawnParticle(World world, Entity entity, int fxid, double x, double y, double z){
		if(!world.isRemote || world.provider.dimensionId != 0){
			return;
		}
		
		Random rand = world.rand;
		
		switch(fxid){
		case Fx_VillagerLevelingUp:
		    double width = 1.0f;
		    double height = 1.0f;

		    for(int i = 0;i<16;i++){
		    	world.spawnParticle("happyVillager", x + rand.nextFloat() * width * 2.0F - width, y + 0.8D + rand.nextFloat() * height, z + rand.nextFloat() * width * 2.0F - width, 
		    			rand.nextGaussian() * 0.02D, rand.nextGaussian() * 0.02D, rand.nextGaussian() * 0.02D);
		    }
		}
	}
}
