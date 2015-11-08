package com.ckhgame.villagebento.ai.villager;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.BlockFinder;
import com.ckhgame.villagebento.util.VBRandomPositionGenerator;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;

public class VillagerAIWander extends EntityAIBase
{
    private EntityVBVillager entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private int sizeXZ;
    private int sizeY;
    private double speed;
    private static final String __OBFID = "CL_00001608";

    public VillagerAIWander(EntityVBVillager entity, double speed, int sizeXZ, int sizeY)
    {
        this.entity = entity;
        this.speed = speed;
        this.sizeXZ = sizeXZ;
        this.sizeY = sizeY;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entity.getRNG().nextInt(60) != 0)
        {
            return false;
        }
        else
        {
        	
            Vec3 vec3 = null;
            if(this.entity.worldObj.isDaytime())
            	vec3 = VBRandomPositionGenerator.findRandomTargetNearBuildingFast(this.entity);
            else{
            	
            	if(entity.bedPosition!=null)
            		vec3 = Vec3.createVectorHelper(entity.bedPosition.xCoord, entity.bedPosition.yCoord + 1, entity.bedPosition.zCoord);
            }
            	//vec3 = VBRandomPositionGenerator.findRandomTargetInBuildingFast(this.entity);

            if (vec3 == null)
            {
                return false;
            }
            else
            {
                this.xPosition = vec3.xCoord;
                this.yPosition = vec3.yCoord;
                this.zPosition = vec3.zCoord;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entity.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
}