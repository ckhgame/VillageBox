package com.ckhgame.villagebento.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityBlockCustom extends TileEntity {
	
	private ModelBase model;
	private ResourceLocation texture;
	private Entity target;
	
	public void setModel(ModelBase model){
		this.model = model;
	}
	
	public void setTexture(ResourceLocation texture){
		this.texture = texture;
	}
	
	public ModelBase getModel(){
		return this.model;
	}
	
	public ResourceLocation getTexture(){
		return this.texture;
	}
	
	public void setTarget(Entity target){
		this.target = target;
	}
	
	public Entity getTarget(){
		return this.target;
	}
}
