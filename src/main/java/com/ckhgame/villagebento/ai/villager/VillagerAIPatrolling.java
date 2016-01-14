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

public class VillagerAIPatrolling extends VillagerAIMoving
{
    public VillagerAIPatrolling(EntityVBVillager entity)
    {
    	super(entity);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(this.entity.getRNG().nextInt(30) == 0){
			this.targetPos =  VBRandomPositionGenerator.findRandomTargetGuardPatrol(this.entity);
    		return true;
		}  
    	
    	return false;
    }

	@Override
	public void startExecuting() {
		this.entity.setDebugText("Patroling...");
	}

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {    	
    	if(this.entity.getAttackTarget() != null)
    		return false;
        return super.continueExecuting();
    }
    
}