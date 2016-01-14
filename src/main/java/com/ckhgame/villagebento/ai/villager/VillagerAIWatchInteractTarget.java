package com.ckhgame.villagebento.ai.villager;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.entity.EntityLiving;

public class VillagerAIWatchInteractTarget extends VillagerAIWatchClosest
{

    public VillagerAIWatchInteractTarget(EntityVBVillager p_i1629_1_, float p_i1629_3_)
    {
        super(p_i1629_1_, null, p_i1629_3_, 0);
    }

	@Override
	public boolean shouldExecute() {
		
		if(this.theWatcher.InteractTarget == null)
			return false;
		else
			return super.shouldExecute();
	}

	@Override
	public boolean continueExecuting() {
		return super.continueExecuting() & (this.theWatcher.InteractTarget!=null && this.closestEntity == this.theWatcher.InteractTarget);
	}
    
}