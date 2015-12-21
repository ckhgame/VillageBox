package com.ckhgame.villagebento.gui2;

import net.minecraft.util.MathHelper;

public class GuiBoundary {
	private float x;
	private float y;
	private float w;
	private float h;
	public GuiBoundary(float x, float y, float w, float h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void setX(float x){this.x = x;}
	public void setY(float y){this.y = y;}
	public void setW(float w){this.w = w;}
	public void setH(float h){this.h = h;}
	
	public float getX(){return this.x;}
	public float getY(){return this.y;}
	public float getW(){return this.w;}
	public float getH(){return this.h;}
	
	public int getIntX(){return MathHelper.floor_float(this.x);}
	public int getIntY(){return MathHelper.floor_float(this.y);}
	public int getIntW(){return MathHelper.floor_float(this.w);}
	public int getIntH(){return MathHelper.floor_float(this.h);}
	
	public int getIntCenterX(){return MathHelper.floor_float(this.x + this.w * 0.5F);}
	public int getIntCenterY(){return MathHelper.floor_float(this.y + this.h * 0.5F);}
}
