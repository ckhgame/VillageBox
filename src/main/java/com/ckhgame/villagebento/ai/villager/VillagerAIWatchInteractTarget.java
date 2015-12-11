package com.ckhgame.villagebento.ai.villager;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.entity.EntityLiving;

public class VillagerAIWatchInteractTarget extends VillagerAIWatchClosest
{

    public VillagerAIWatchInteractTarget(EntityVBVillager p_i1629_1_, Class p_i1629_2_, float p_i1629_3_, float p_i1629_4_)
    {
        super(p_i1629_1_, p_i1629_2_, p_i1629_3_, p_i1629_4_);
        this.setMutexBits(3);
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
		return super.continueExecuting() & (this.theWatcher.InteractTarget!=null);
	}
    
}