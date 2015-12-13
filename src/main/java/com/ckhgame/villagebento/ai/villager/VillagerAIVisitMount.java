package com.ckhgame.villagebento.ai.villager;

import com.ckhgame.villagebento.block.BlockMountable;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class VillagerAIVisitMount extends EntityAIBase
{
    private EntityVBVillager entity;

    public VillagerAIVisitMount(EntityVBVillager entity)
    {
        this.entity = entity;
        this.setMutexBits(0);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(this.entity.isRiding()){
    		return true;
    	}
    	
    	if(this.entity.getRNG().nextInt(5) != 0)
    		return false;
    	
    	//sleep only at late night
    	if(!this.entity.isVisiting())
    		return false;
    	
    	double d = entity.getDistance(this.entity.aiMovingTargetX, this.entity.aiMovingTargetY, this.entity.aiMovingTargetZ);
    	if(d > 1.5D)
    		return false;
    	
    	int x = MathHelper.floor_double(this.entity.aiMovingTargetX);
    	int y = MathHelper.floor_double(this.entity.aiMovingTargetY);
    	int z = MathHelper.floor_double(this.entity.aiMovingTargetZ);
    	
    	Block b = this.entity.worldObj.getBlock(x, y, z); 
    	if(!(b instanceof BlockMountable))
    		return false;
    	
    	if(!((BlockMountable)b).activedByEntityVBVillager(this.entity, x, y, z)){
    		return false;
    	}
    		
    	
    	return true;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    { 		 
    		 return (this.entity.isVisiting());       
    }

	public void updateTask() {

	}
    
    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    }

	@Override
	public void resetTask() {
		this.entity.mountEntity(null);
	}
    
    
}