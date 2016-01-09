package com.ckhgame.villagebento.entity.misc;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.tileentity.TileEntityBlockCustom;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBuildingIndicatorSmall extends EntityBuildingIndicator {

	public EntityBuildingIndicatorSmall(World p_i1582_1_) {
		super(p_i1582_1_);
		this.buildingSizeX = ConfigBuilding.GroundWorkLargeSizeX;
		this.buildingSizeZ = ConfigBuilding.GroundWorkLargeSizeZ;
	}
	
	
}
