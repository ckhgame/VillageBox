package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.misc.EntityBlockMountable;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.BlockFinder;
import com.ckhgame.villagebento.util.village.HelperVisiting;
import com.ckhgame.villagebento.util.village.VBRandomPositionGenerator;
import com.ckhgame.villagebento.util.village.VBDateTime;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public abstract class VillagerAIMoving extends EntityAIBase
{
	protected EntityVBVillager entity;
    protected Vec3 targetPos = null;
    protected int stayTimer = 0;
    
    public VillagerAIMoving(EntityVBVillager entity)
    {
        this.entity = entity;
        this.setMutexBits(1);
    }
    
    @Override
	public void resetTask() {
		this.targetPos = null;
		this.entity.getNavigator().clearPathEntity();
	}

	/**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	if(this.entity.InteractTarget != null){
    		this.entity.getNavigator().clearPathEntity();
    		return true;
    	}
    	
    	if(this.entity.getNavigator().noPath()){
    		if(this.targetPos == null){
    			return false;
    		}
    			
    		Vec3 pos = Vec3.createVectorHelper(this.entity.posX - this.targetPos.xCoord,this.entity.posY - this.targetPos.yCoord,this.entity.posZ - this.targetPos.zCoord);
    		if(pos.lengthVector() < 1.0D){
    			return false; // reached the target
    		}	
    		else{
    			return VillagerNavigator.tryMoveToXYZ(entity, this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord);	
    		}	
    	}
    	else{
    		if(MathHelper.floor_double(this.entity.posX) == MathHelper.floor_double(this.entity.lastTickPosX) &&
    			MathHelper.floor_double(this.entity.posZ) == MathHelper.floor_double(this.entity.lastTickPosZ) ){
    			if(++stayTimer > 100){
    				System.out.println("This villager is stuck...reset task");
    				return false;
    			}
    		}
    		
    		stayTimer = 0;
    		return true;
    	}
    }
}