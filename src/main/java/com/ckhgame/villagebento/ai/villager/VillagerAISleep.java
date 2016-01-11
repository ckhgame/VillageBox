package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.VBDateTime;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.entity.ai.EntityAIBase;
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
    	//sleep only at late night
    	if(!this.entity.getProfession().getTimeSchedule().isSleepTimeNow())
    		return false;
    	
    	if(this.entity.isVisiting() && this.entity.isVisitingSkipSleeping()){
    		this.entity.cancelVisiting();
    		return false;
    	}
    		
    	//if the one has already been sleeping, just let it keep sleeping... 
    	if(this.entity.isSleeping())
    		return true;
    	else{
    		//if now it's not sleeping, we need to move it to the bed 
    		if(entity.bedPosition==null)
    			return false;
    		else
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
    		 return (this.entity.getProfession().getTimeSchedule().isSleepTimeNow() && this.entity.isNearBed());
    	 }
        
    }

	public void updateTask() {
		if(!this.entity.isSleeping() && this.entity.isNearBed()){
			this.entity.startSleeping();
		}
	}
    
    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    	if(!this.entity.isSleeping()){		
    		VillagerNavigator.tryMoveToXYZ(entity, 	this.entity.bedPosition.x + 0.5D,
					    							this.entity.bedPosition.y + 1.0D,
					    							this.entity.bedPosition.z + 0.5D);   
    	}
    }

	@Override
	public void resetTask() {
		this.entity.endSleeping();
	}
    
    
}