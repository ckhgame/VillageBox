package com.ckhgame.villagebento.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityVBVillager extends EntityAgeable{

	private String name;
	private int testCount;
	
	public void setName(String name){
		this.name = name;
	}
	
	public EntityVBVillager(World p_i1578_1_) {
		super(p_i1578_1_);

		this.setSize(0.6F, 1.8F);
		
		testCount = 0;

	}

	@Override
	public EntityVBVillager createChild(EntityAgeable p_90011_1_) {
		EntityVBVillager entityvillager = new EntityVBVillager(this.worldObj);
        entityvillager.onSpawnWithEgg((IEntityLivingData)null);
        return entityvillager;
	}
	
    public boolean interact(EntityPlayer p_70085_1_)
    {
    	if(!this.worldObj.isRemote){
    		System.out.println("Hi! My name is " + name + ", this is the " + (testCount++) +" time you right click on me :D");
    	}
        return true;
    }

    
    
	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setString("vb_name", name);
		p_70014_1_.setInteger("vb_testCount", testCount);
		System.out.println("Writing......");
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub
		super.readEntityFromNBT(p_70037_1_);
		
		name = p_70037_1_.getString("vb_name");
		testCount = p_70037_1_.getInteger("vb_testCount");
		System.out.println("Reading......");
	}

	@Override
	protected boolean canDespawn() {
		// TODO Auto-generated method stub
		return false;
	}
    
	
    
	
	
	
}
