package com.ckhgame.villagebento.ai.villager2;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.VBDateTime;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

public class VillagerAIWorking extends VillagerAIMoving
{
    public VillagerAIWorking(EntityVBVillager entity)
    {
    	super(entity);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(this.entity.getRNG().nextInt(30) == 0){
    		if(this.entity.getProfession().getTimeSchedule().isWorkTimeNow()){
    			if(this.entity.isVisiting()) this.entity.cancelVisiting();
    			this.targetPos = Vec3.createVectorHelper(this.entity.getInitPosX(), this.entity.getInitPosY(), this.entity.getInitPosZ());
        		return true;
    		}  		
    	}
    	return false;
    }

	@Override
	public void startExecuting() {
		this.entity.setDebugText("Working...");
	}
    
    
    
}