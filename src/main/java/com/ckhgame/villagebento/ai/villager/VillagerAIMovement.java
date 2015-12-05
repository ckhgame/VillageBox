package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.BlockFinder;
import com.ckhgame.villagebento.util.village.VBRandomPositionGenerator;
import com.ckhgame.villagebento.util.village.VBDataTime;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;

public class VillagerAIMovement extends EntityAIBase
{
    private EntityVBVillager entity;
    private boolean hasTarget;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public VillagerAIMovement(EntityVBVillager entity)
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
    	if (this.entity.getRNG().nextInt(60) == 0){
    		 if(this.entity.getProfession().getTimeSchedule().isWorkTimeNow()){ // in working time        	
    	        	vec3 = Vec3.createVectorHelper( this.entity.getInitPosX() + 0.5D,this.entity.getInitPosY(),this.entity.getInitPosZ() + 0.5D);
    	        }
    	        else if(VBDataTime.isDayTime()){ //day time & out of working time
    	        	if(this.entity.worldObj.isRaining()){ // rainning : stay in side of the building
    	        		vec3 = VBRandomPositionGenerator.findRandomTargetInBuildingFast(this.entity);
    	        	}
    	        	else{
    	        		
    	        		//if it's not raining and it's day time, there are two options
    	        		//if(this.entity.getRNG().nextInt(10) != 0)
    	        		
    	        		//not raining: walking near the building
    	        		vec3 = VBRandomPositionGenerator.findRandomTargetNearBuildingFast(this.entity);
    	        	}
    	        }
    	        else{ // when it's night
    	        	vec3 = VBRandomPositionGenerator.findRandomTargetInBuildingFast(this.entity);
    	        }
    	}
    	else{
    		if(hasTarget){
    			return true;
    		}
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
            this.hasTarget = true;
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
    	if(VillagerNavigator.tryMoveToXYZ(entity, this.xPosition, this.yPosition, this.zPosition)){
    		this.hasTarget = false;
    	}
    	
    }
}