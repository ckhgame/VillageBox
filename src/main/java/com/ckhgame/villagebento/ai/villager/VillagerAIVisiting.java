package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.block.BlockMountable;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.HelperVisiting;
import com.ckhgame.villagebento.util.village.VBDateTime;
import com.ckhgame.villagebento.util.village.VBRandomPositionGenerator;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class VillagerAIVisiting extends VillagerAIMoving
{
    public VillagerAIVisiting(EntityVBVillager entity)
    {
    	super(entity);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
		if(this.entity.isVisiting()){
			if(this.entity.getProfession().getTimeSchedule().isSleepTimeNow() && !this.entity.isVisitingSkipSleeping()){
				this.entity.cancelVisiting();
				return false;
			}
			else{
				this.targetPos = HelperVisiting.findNextMovingTargetInBuilding(this.entity.getVisitingBuildingID());
				return true;
			}
		}
    	
    	if(this.entity.getRNG().nextInt(30) == 0){
    		
    		if(this.entity.getProfession().getTimeSchedule().isWorkTimeNow())
    			return false;
    		
    		if(!VBDateTime.isDayTime())
    			return false;
    		
    		if(this.entity.getProfession().getTimeSchedule().isSleepTimeNow())
    			return false;
    		
    		if(this.entity.worldObj.isRaining())
    			return false;
    		
    		if(this.entity.getRNG().nextInt(ConfigVillager.VisitingChance) == 0){
    			this.entity.startRandomVisiting();
        		this.targetPos = HelperVisiting.findNextMovingTargetInBuilding(this.entity.getVisitingBuildingID());
        		return true; 		
    		}
    		else{
    			return false;
    		}
    	}
    	return false;
    }
    
    
    
    @Override
	public void updateTask() {
    	if(!this.entity.isRiding() && this.targetPos != null){
    		double d = entity.getDistance(this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord);
    		if(d <= 1.5D){
    			int x = MathHelper.floor_double(this.targetPos.xCoord);
    	    	int y = MathHelper.floor_double(this.targetPos.yCoord);
    	    	int z = MathHelper.floor_double(this.targetPos.zCoord);
    	    	Block b = this.entity.worldObj.getBlock(x, y, z); 
    	    	if(b instanceof BlockMountable){
    	    		if(!((BlockMountable)b).activedByEntityVBVillager(this.entity, x, y, z)){
    	    			this.targetPos = HelperVisiting.findNextMovingTargetInBuilding(this.entity.getVisitingBuildingID());
    	    		}
    	    	}
    		}
    	}
    }

    public boolean continueExecuting()
    {
    	if(this.entity.isVisiting() && this.entity.worldObj.isRaining()){
    		return false;
    	}
    	else if(this.entity.isVisiting() && this.entity.isRiding()){
    		return true;
    	}
    	else{
    		return super.continueExecuting();
    	}
    }
    	
	@Override
	public void resetTask() {
		this.entity.cancelVisiting();
		super.resetTask();
	}

	@Override
	public void startExecuting() {
		this.entity.setDebugText("Visiting...");
	}
}