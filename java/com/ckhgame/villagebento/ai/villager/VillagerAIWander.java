package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.misc.VillagerNavigator;
import com.ckhgame.villagebento.util.BlockFinder;
import com.ckhgame.villagebento.util.VBRandomPositionGenerator;
import com.ckhgame.villagebento.util.VillageTime;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;

public class VillagerAIWander extends EntityAIBase
{
    private EntityVBVillager entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public VillagerAIWander(EntityVBVillager entity)
    {
        this.entity = entity;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        Vec3 vec3 = null;
        if(VillageTime.isDayTime(this.entity.worldObj)){
        	if (this.entity.getRNG().nextInt(60) != 0) {return false;}
        	if(this.entity.worldObj.isRaining()){
        		vec3 = VBRandomPositionGenerator.findRandomTargetInBuildingFast(this.entity);
        	}
        	else{
        		vec3 = VBRandomPositionGenerator.findRandomTargetNearBuildingFast(this.entity);
        	}
        }
        else{
        	if (this.entity.getRNG().nextInt(60) != 0) {return false;}
        	vec3 = VBRandomPositionGenerator.findRandomTargetInBuildingFast(this.entity);
        }

        if (vec3 == null)
        {
            return false;
        }
        else
        {
            this.xPosition = vec3.xCoord;
            this.yPosition = vec3.yCoord;
            this.zPosition = vec3.zCoord;
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entity.getNavigator().noPath();
    }

    
    
    @Override
	public void updateTask() {
		
		super.updateTask();
		
	}

	/**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    	VillagerNavigator.tryMoveToXYZ(entity, this.xPosition, this.yPosition, this.zPosition);   
    }
}