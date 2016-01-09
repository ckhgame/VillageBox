package com.ckhgame.villagebento.entity.misc;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.tileentity.TileEntityBlockCustom;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntityBuildingIndicator extends Entity {
	
	protected int buildingSizeX;
	protected int buildingSizeZ;
	
	public EntityBuildingIndicator(World p_i1582_1_) {
		super(p_i1582_1_);
		this.setSize(0.1F, 0.1F);
		noClip = true;
	}
	
	public int getBuildingSizeX(){
		return this.buildingSizeX;
	}
	
	public int getBuildingSizeZ(){
		return this.buildingSizeZ;
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		this.setSize(0, 0);
	}

	@Override
	public void onEntityUpdate() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub
		
	}


}
