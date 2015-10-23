package com.ckhgame.villagebento.entity;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helpers.HelperDataVB;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityVBVillager extends EntityAgeable{

	private int dataVillagerID;
	private String name;
	private String skin;
	private int profession;
	
	public void setVillagerData(DataVillager dv){
		this.dataVillagerID = dv.id;
		this.name = dv.name;
		this.skin = dv.skin;
		this.profession = dv.profession;
	}
	
	public EntityVBVillager(World p_i1578_1_) {
		super(p_i1578_1_);

		this.setSize(0.6F, 1.8F);
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
    		System.out.println("Hi! My name is " + name);
    	}
        return true;
    }

    
    
	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setInteger(ConfigData.KeyVillagerEntityDataVillagerID, dataVillagerID);
		p_70014_1_.setString(ConfigData.KeyVillagerEntityName, name);
		p_70014_1_.setString(ConfigData.KeyVillagerEntitySkin, skin);
		p_70014_1_.setInteger(ConfigData.KeyVillagerEntityProfession, profession);
		System.out.println("Writing......");
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub
		super.readEntityFromNBT(p_70037_1_);
		
		dataVillagerID = p_70037_1_.getInteger(ConfigData.KeyVillagerEntityDataVillagerID);
		name = p_70037_1_.getString(ConfigData.KeyVillagerEntityName);
		skin = p_70037_1_.getString(ConfigData.KeyVillagerEntitySkin);
		profession = p_70037_1_.getInteger(ConfigData.KeyVillagerEntityProfession);
		System.out.println("Reading......");
	}

	@Override
	protected boolean canDespawn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);
		
		//when the villager is dead, we should tell the DataVillager he is dead, and he will be revive on next noon
		DataVillageBento dataVB = DataVillageBento.get(this.worldObj);
		HelperDataVB.setVillageDeath(dataVB, this.dataVillagerID);
	}
	
	
    
	
    
	
	
	
}
