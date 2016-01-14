package com.ckhgame.villagebento.ai.villager;

import com.ckhgame.villagebento.ai.villager2.VillagerAIWatchClosest;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.entity.EntityLiving;

public class VillagerAIWatchClosest2 extends VillagerAIWatchClosest
{

    public VillagerAIWatchClosest2(EntityVBVillager p_i1629_1_, Class p_i1629_2_, float p_i1629_3_, float p_i1629_4_)
    {
        super(p_i1629_1_, p_i1629_2_, p_i1629_3_, p_i1629_4_);
        this.setMutexBits(3);
    }
}