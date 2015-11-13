package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.misc.VillagerNavigator;
import com.ckhgame.villagebento.util.VillageTime;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

public class VillagerAISleepNightbird extends EntityAIBase
{
    protected EntityVBVillager entity;

    public VillagerAISleepNightbird(EntityVBVillager entity)
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
    	if(!VillageTime.isMorning(this.entity.worldObj))
    		return false;
    	
    	//if the one has already been sleeping, just let it keep sleeping... 
    	if(this.entity.getSleeping())
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
    		 return (VillageTime.isMorning(this.entity.worldObj) && this.entity.isNearBed());
    	 }
        
    }

	public void updateTask() {
		if(!this.entity.getSleeping() && this.entity.isNearBed()){
			onSleep();
			this.entity.setSleeping(true);
		}
	}
	
	protected void onSleep(){
		
	}
    
    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    	if(!this.entity.getSleeping()){
    		VillagerNavigator.tryMoveToXYZ(entity, 	this.entity.bedPosition.xCoord + 0.5D,
					this.entity.bedPosition.yCoord + 1.0D,
					this.entity.bedPosition.zCoord + 0.5D); 
    	}
    }

	@Override
	public void resetTask() {
		this.entity.setSleeping(false);
	}
    
    
}