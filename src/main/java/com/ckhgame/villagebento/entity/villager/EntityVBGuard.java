package com.ckhgame.villagebento.entity.villager;

import com.ckhgame.villagebento.ai.villager.VillageAINearestAttackableTarget;
import com.ckhgame.villagebento.ai.villager.VillagerAIAttackOnCollide;
import com.ckhgame.villagebento.ai.villager.VillagerAIGuardPatrol;
import com.ckhgame.villagebento.ai.villager.VillagerAISleepGuard;
import com.ckhgame.villagebento.ai.villager.VillagerAISleepNightbird;
import com.ckhgame.villagebento.ai.villager.VillagerAIWander;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest2;
import com.ckhgame.villagebento.config.ConfigVillager;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityVBGuard extends EntityVBVillager {

	public EntityVBGuard(World p_i1578_1_) {
		super(p_i1578_1_);
	}

	@Override
	public void initAITasks() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new VillagerAIAttackOnCollide(this, EntityMob.class, 0.5D, false));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new VillagerAISleepGuard(this));
		
		this.tasks.addTask(6, new VillagerAIGuardPatrol(this));
		this.tasks.addTask(7, new VillagerAIWatchClosest(this, EntityLiving.class, 6.0F));
		
		this.targetTasks.addTask(0, new VillageAINearestAttackableTarget(this, EntityMob.class, 0, false));
	}
	
	
}
