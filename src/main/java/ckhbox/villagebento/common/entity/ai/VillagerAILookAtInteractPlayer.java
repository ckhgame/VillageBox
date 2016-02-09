package ckhbox.villagebento.common.entity.ai;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;

public class VillagerAILookAtInteractPlayer extends EntityAIWatchClosest
{
    private final EntityVillager villager;

    public VillagerAILookAtInteractPlayer(EntityVillager villager)
    {
        super(villager, EntityPlayer.class, 8.0F);
        this.villager = villager;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.villager.isInteracting())
        {
            this.closestEntity = this.villager.getInteracting();
            return true;
        }
        else
        {
            return false;
        }
    }
}