package com.ckhgame.villagebento.builders;

public final class VillageConfig {
	public final int Width;
	public final int Height;
	public final int X;	//left top corner
	public final int Z;	//left top corner
	public final int Y;
	public final int Deep;
	public String name; 
	
	public VillageConfig(String n,int w,int h,int cx,int y,int cz,int d){

		int x = cx - w / 2;
		int z = cz - h / 2;
		
		this.Width = w;
		this.Height = h;
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.Deep = d;
		this.name = n;
	}
}
