package com.ckhgame.villagebento.rendering;

public class ColoredCube{
	
	public ColoredCube(float x,float y,float z,float w,float h,float d,float[] c){
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = w;
		this.height = h;
		this.depth = d;
		this.color = c;
	}
	
	public float x,y,z;
	public float width,height,depth;
	public float[] color;
}
