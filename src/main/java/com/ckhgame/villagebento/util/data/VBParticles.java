package com.ckhgame.villagebento.util.data;

import java.util.Random;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.SActionDoSpawnParticles;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class VBParticles {
	public static final int Fx_VillagerLevelingUp = 0;
	public static final int Fx_Heart = 1;
	public static final int Fx_Happy = 2;
	
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
		    break;
		case Fx_Heart:
			generateRandomParticles(rand,"heart",world,entity);
			break;
		case Fx_Happy:
			generateRandomParticles(rand,"happyVillager",world,entity);
			break;
		}
	}
	
	public static void spawnParticleFromServer(Entity entity, int fxid, double x, double y, double z){
		if(entity.worldObj.isRemote || entity.worldObj.provider.dimensionId != 0){
			return;
		}
		
		Action.send(SActionDoSpawnParticles.class, new Object[]{fxid,x,y,z,entity.getEntityId()});
	}
	
	//helpers
	private static void generateRandomParticles(Random rand, String effect, World world, Entity entity)
    {
        for (int i = 0; i < 5; ++i)
        {
            double d0 = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;
            world.spawnParticle(effect, entity.posX + (double)(rand.nextFloat() * entity.width * 2.0F) - (double)entity.width, entity.posY + 1.0D + (double)(rand.nextFloat() * entity.height), entity.posZ + (double)(rand.nextFloat() * entity.width * 2.0F) - (double)entity.width, d0, d1, d2);
        }
    }
}
