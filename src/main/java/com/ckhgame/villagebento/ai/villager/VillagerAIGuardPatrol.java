package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.BlockFinder;
import com.ckhgame.villagebento.util.village.VBRandomPositionGenerator;
import com.ckhgame.villagebento.util.village.VBDateTime;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

public class VillagerAIGuardPatrol extends EntityAIBase
{
    private EntityVBVillager entity;
    private boolean hasTarget;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public VillagerAIGuardPatrol(EntityVBVillager entity)
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
        
        if (this.entity.getRNG().nextInt(40) != 0){
        	if(this.hasTarget)
        		return true;
        }
        else{
        	vec3 = VBRandomPositionGenerator.findRandomTargetGuardPatrol(this.entity);
            
            if(vec3 == null){
            	//if the guard can not find any building near self, he is considered lost his way and will be moved towards his building 
            	vec3 = Vec3.createVectorHelper(entity.getInitPosX() + 0.5D,entity.getInitPosY(), entity.getInitPosZ() + 0.5D);
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
    	if(this.entity.getAttackTarget()!=null)
    		return false;
    	
    	if(VBDateTime.isMorning())
    	{
    		if (this.entity.getRNG().nextInt(60) != 0)
    			return false;
    	}
    	
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
    		hasTarget = false;
    	}
    		
    }
    
}