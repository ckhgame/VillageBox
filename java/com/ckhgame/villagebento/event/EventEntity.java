package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class EventEntity {
	
	@SubscribeEvent
    public void livingSpawnEvent(LivingSpawnEvent event) {
		
		Class ec = event.entityLiving.getClass();
		
		if(ec == EntityZombie.class){
			EntityZombie entity = (EntityZombie)event.entityLiving;
			entity.tasks.addTask(4, new EntityAIAttackOnCollide(entity, EntityVBVillager.class, 1.0D, true));
			entity.targetTasks.addTask(2, new EntityAINearestAttackableTarget(entity, EntityVBVillager.class, 0, false));
		}
		else if(ec == EntitySkeleton.class){
			EntitySkeleton entity = (EntitySkeleton)event.entityLiving;
			entity.targetTasks.addTask(2, new EntityAINearestAttackableTarget(entity, EntityVBVillager.class, 0, false));
		}
		
    }
}
