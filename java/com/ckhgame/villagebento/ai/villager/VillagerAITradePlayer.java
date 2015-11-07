package com.ckhgame.villagebento.ai.villager;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class VillagerAITradePlayer extends EntityAIBase
{
    private EntityVBVillager villager;

    public VillagerAITradePlayer(EntityVBVillager villager)
    {
        this.villager = villager;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.villager.isEntityAlive())
        {
            return false;
        }
        else if (this.villager.isInWater())
        {
            return false;
        }
        else if (!this.villager.onGround)
        {
            return false;
        }
        else if (this.villager.velocityChanged)
        {
            return false;
        }
        else
        {
            EntityPlayer entityplayer = this.villager.getInteractTarget();
            if(entityplayer == null)
            	return false;
            else if(this.villager.getDistanceSqToEntity(entityplayer) > 9D)
            	return false;
        	else
            	return true;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.villager.getNavigator().clearPathEntity();
        this.villager.openVillagerGui();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.villager.setInteractTarget((EntityPlayer)null);
    }
}