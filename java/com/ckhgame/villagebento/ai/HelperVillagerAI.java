package com.ckhgame.villagebento.ai;

import com.ckhgame.villagebento.ai.villager.VillagerAIGuardPatrol;
import com.ckhgame.villagebento.ai.villager.VillagerAISleep;
import com.ckhgame.villagebento.ai.villager.VillagerAISleepGuard;
import com.ckhgame.villagebento.ai.villager.VillagerAISleepNightbird;
import com.ckhgame.villagebento.ai.villager.VillagerAIWander;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest2;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.VillagerCaptainSoldier;
import com.ckhgame.villagebento.villager.VillagerCasinoDealer;
import com.ckhgame.villagebento.villager.VillagerCasinoManager;
import com.ckhgame.villagebento.villager.VillagerKnight;
import com.ckhgame.villagebento.villager.VillagerLargeCasinoManager;
import com.ckhgame.villagebento.villager.VillagerLargeTavernOwner;
import com.ckhgame.villagebento.villager.VillagerSoldier;
import com.ckhgame.villagebento.villager.VillagerTavernOwner;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;

public class HelperVillagerAI {
	public static void SetVBVillagerAI(EntityVBVillager entity){
		Class vrc = Villager.registry.get(entity.profession).getClass();
		if(	vrc == VillagerCasinoDealer.class || vrc == VillagerLargeCasinoManager.class || vrc == VillagerCasinoManager.class ||
			vrc == VillagerTavernOwner.class || vrc == VillagerLargeTavernOwner.class){
			setNightbirdAI(entity);
		}
		else if(vrc == VillagerSoldier.class || vrc == VillagerCaptainSoldier.class || vrc == VillagerKnight.class){
			setGuardAI(entity);
		}
		else{
			setNormalAI(entity);
		}
	}
	
	private static void setNightbirdAI(EntityVBVillager entity){
		entity.tasks.addTask(0, new EntityAISwimming(entity));
		entity.tasks.addTask(1, new EntityAIAvoidEntity(entity, EntityZombie.class, 6.0F, 0.4D, 0.4D));
		entity.tasks.addTask(2, new EntityAIOpenDoor(entity, true));
		entity.tasks.addTask(3, new VillagerAISleepNightbird(entity));
		
		entity.tasks.addTask(5, new VillagerAIWatchClosest2(entity, EntityPlayer.class, ConfigVillager.MaxInteractDistance, 1.0F));
		entity.tasks.addTask(5, new VillagerAIWatchClosest2(entity, EntityVillager.class, 5.0F, 0.02F));
		entity.tasks.addTask(6, new VillagerAIWander(entity));
		entity.tasks.addTask(7, new VillagerAIWatchClosest(entity, EntityLiving.class, 6.0F));
	}
	
	private static void setGuardAI(EntityVBVillager entity){
		entity.tasks.addTask(0, new EntityAISwimming(entity));
		entity.tasks.addTask(1, new EntityAIAttackOnCollide(entity, EntityZombie.class, 1.0D, true));
		entity.tasks.addTask(2, new EntityAIOpenDoor(entity, true));
		entity.tasks.addTask(3, new VillagerAISleepGuard(entity));
		
		entity.tasks.addTask(5, new VillagerAIWatchClosest2(entity, EntityPlayer.class, ConfigVillager.MaxInteractDistance, 1.0F));
		entity.tasks.addTask(5, new VillagerAIWatchClosest2(entity, EntityVillager.class, 5.0F, 0.02F));
		entity.tasks.addTask(6, new VillagerAIGuardPatrol(entity));
		entity.tasks.addTask(7, new VillagerAIWatchClosest(entity, EntityLiving.class, 6.0F));
		
		entity.targetTasks.addTask(0, new EntityAINearestAttackableTarget(entity, EntityZombie.class, 0, false));
	}
	
	private static void setNormalAI(EntityVBVillager entity){
		entity.tasks.addTask(0, new EntityAISwimming(entity));
		entity.tasks.addTask(1, new EntityAIAvoidEntity(entity, EntityZombie.class, 6.0F, 0.4D, 0.4D));
		entity.tasks.addTask(2, new EntityAIOpenDoor(entity, true));
		entity.tasks.addTask(3, new VillagerAISleep(entity));
		
		entity.tasks.addTask(5, new VillagerAIWatchClosest2(entity, EntityPlayer.class, ConfigVillager.MaxInteractDistance, 1.0F));
		entity.tasks.addTask(5, new VillagerAIWatchClosest2(entity, EntityVillager.class, 5.0F, 0.02F));
		entity.tasks.addTask(6, new VillagerAIWander(entity));
		entity.tasks.addTask(7, new VillagerAIWatchClosest(entity, EntityLiving.class, 6.0F));
	}
}
