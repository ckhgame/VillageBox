package com.ckhgame.villagebento.ai.villager;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.VBRandomPositionGenerator;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class VillagerAISleep extends EntityAIBase
{
    private EntityVBVillager entity;

    public VillagerAISleep(EntityVBVillager entity)
    {
        this.entity = entity;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entity.getRNG().nextInt(60) != 0){
            return false;
        }
        else if(this.entity.worldObj.isDaytime()){
        	return false;
        }
        else if(!this.entity.isNearBed()){
        	return false;
        }
        else{
        	return true;
        }
    	
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	 if (this.entity.getRNG().nextInt(60) != 0){
             return true;
         }
    	 else{
    		 return !this.entity.worldObj.isDaytime();
    	 }
        
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.entity.setSleeping(true);
    }

	@Override
	public void resetTask() {
		this.entity.setSleeping(false);
	}
    
    
}