package ckhbox.villagebox.common.entity.ai;

import java.util.List;

import ckhbox.villagebox.common.entity.villager.EntityVillager;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;

public class VillagerAIFollowing extends EntityAIBase
{
    /** The child that is following its parent. */
    private EntityVillager villager;
    private float moveSpeed;
    private int delayCounter;
    
    private static final double maxDisSq = 256.0F;
    private static final double minDisSq = 9.0F;

    public VillagerAIFollowing(EntityVillager villager,float speed)
    {
        this.villager = villager;
        this.moveSpeed = speed;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(!this.villager.isFollowing()){
    		return false;
    	}
    	
    	return this.inFollowingDistance();
    }

    private boolean inFollowingDistance(){
    	double d = this.villager.getDistanceSqToEntity(this.villager.getFollowing());
    	return d >= minDisSq && d <= maxDisSq;
    }
    
    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        if (!this.villager.isAirBorne)
        {
            return false;
        }
        else
        {
        	return this.villager.getFollowing().isEntityAlive() && this.inFollowingDistance();
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.delayCounter = 0;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
    	this.villager.setFollowing(null);
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (--this.delayCounter <= 0)
        {
            this.delayCounter = 10;
            this.villager.getNavigator().tryMoveToEntityLiving(this.villager.getFollowing(), this.moveSpeed);
        }
    }
}