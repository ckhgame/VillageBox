package com.ckhgame.villagebento.entity.villager;

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

public class EntityVBNightbird extends EntityVBVillager {

	public EntityVBNightbird(World world) {
		super(world);
	}

	@Override
	public void initAITasks() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMob.class, 6.0F, 0.4D, 0.4D));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new VillagerAISleepNightbird(this));
		
		this.tasks.addTask(5, new VillagerAIWatchClosest2(this, EntityPlayer.class, ConfigVillager.MaxInteractDistance, 1.0F));
		this.tasks.addTask(5, new VillagerAIWatchClosest2(this, EntityVBVillager.class, 5.0F, 0.02F));
		this.tasks.addTask(6, new VillagerAIWander(this));
		this.tasks.addTask(7, new VillagerAIWatchClosest(this, EntityLiving.class, 6.0F));
	}
	
	
}
