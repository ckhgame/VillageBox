package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.BlockFinder;
import com.ckhgame.villagebento.util.VBRandomPositionGenerator;
import com.ckhgame.villagebento.util.VillageTime;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

public class VillagerAIGuardPatrol extends EntityAIBase
{
    private EntityVBVillager entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public VillagerAIGuardPatrol(EntityVBVillager entity)
    {
        this.entity = entity;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        Vec3 vec3 = null;
        
        if (this.entity.getRNG().nextInt(20) != 0) {return false;}
        
        vec3 = VBRandomPositionGenerator.findRandomTargetGuardPatrol(this.entity);
        
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

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	if(this.entity.getAttackTarget()!=null)
    		return false;
    	
    	if(VillageTime.isMorning(this.entity.worldObj))
    	{
    		if (this.entity.getRNG().nextInt(60) != 0)
    			return false;
    	}
    	
        return !this.entity.getNavigator().noPath();
    }

    
    
    @Override
	public void updateTask() {
		
		super.updateTask();
		
	}
    
	/**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    	equipWeaponAndArmors(true);
        boolean nav = this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, ConfigVillager.VillagerMoveSpeed);
        if(nav == false){
			Vec3 dir = Vec3.createVectorHelper(	this.entity.bedPosition.xCoord - this.entity.posX,
							    				this.entity.bedPosition.yCoord - this.entity.posY, 
							    				this.entity.bedPosition.zCoord - this.entity.posZ);
			dir = dir.normalize();
			double d = 10;
			Random rand = this.entity.getRNG();
			this.entity.getNavigator().tryMoveToXYZ(this.entity.posX + dir.xCoord * d + rand.nextInt(3) - 1,
													this.entity.posY + dir.yCoord * d + rand.nextInt(3) - 1,
													this.entity.posZ + dir.zCoord * d + rand.nextInt(3) - 1,
    												ConfigVillager.VillagerMoveSpeed);
		}
        
    }
    
    private void equipWeaponAndArmors(boolean equip){
    	if(equip){
    		if(this.entity.getEquipmentInSlot(0) == null){
        		this.entity.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
            	this.entity.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
            	this.entity.setCurrentItemOrArmor(2, new ItemStack(Items.iron_chestplate));
            	this.entity.setCurrentItemOrArmor(3, new ItemStack(Items.iron_helmet));
            	this.entity.setCurrentItemOrArmor(4, new ItemStack(Items.iron_leggings));
    		}
    	}
    	else{
    		if(this.entity.getEquipmentInSlot(0) != null){
    			this.entity.setCurrentItemOrArmor(0, null);
        		this.entity.setCurrentItemOrArmor(1, null);
        		this.entity.setCurrentItemOrArmor(2, null);
        		this.entity.setCurrentItemOrArmor(3, null);
        		this.entity.setCurrentItemOrArmor(4, null);
    		}
    	}
    }
    
}