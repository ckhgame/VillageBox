package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.VBDateTime;
import com.ckhgame.villagebento.util.village.VillagerEmoji;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

public class VillagerAISleeping extends VillagerAIMoving
{
    public VillagerAISleeping(EntityVBVillager entity)
    {
    	super(entity);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	//if the one has already been sleeping, just let it keep sleeping... 
    	if(this.entity.isSleeping())
    		return true;
    	
    	if(this.entity.getRNG().nextInt(30) == 0){
	    	//sleep only at late night
	    	if(!this.entity.getProfession().getTimeSchedule().isSleepTimeNow())
	    		return false;
	    	
	    	if(this.entity.isVisiting()){
	    		if(this.entity.isVisitingSkipSleeping()){
	    			return false;
	    		}
	    		else{
	    			this.entity.cancelVisiting();
	    		}
	    	}
	    		
    		//need to move it to the bed 
    		if(entity.bedPosition==null)
    			return false;
    		else{
    			this.targetPos = this.entity.bedPosition.toVec3();
    			this.entity.playEmoji(VillagerEmoji.EmojiSleepy, 9999);
    			return true;
    		}
    	}
    	else{
    		return false;
    	}
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	if(this.entity.isSleeping()){
    		if (this.entity.getRNG().nextInt(60) != 0){
                return true;
            }
	       	else{    		 
	       		return (this.entity.getProfession().getTimeSchedule().isSleepTimeNow() && this.entity.isNearBed());
	       	}
    	}
    	else{
    		return super.continueExecuting();
    	}
    	 
        
    }

	public void updateTask() {
		if(!this.entity.isSleeping() && this.entity.isNearBed()){
			this.entity.startSleeping();
		}
	}

	@Override
	public void resetTask() {
		if(this.entity.isSleeping())
			this.entity.endSleeping();
		super.resetTask();
	}
    
	@Override
	public void startExecuting() {
		this.entity.setDebugText("Sleeping...");
	}
}