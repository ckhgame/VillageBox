package com.ckhgame.villagebento.data;

public class BuildingData {
	public final int x;
	public final int z;
	public final int sizeX; // if the total width is 7, sizeX will be 3 (3 + 1 + 3)
	public final int sizeZ; // similar as sizeX
	public final int y;
	public final int type;
	
	public BuildingData(int x,int z,int sx, int sz ,int y,int t){
		this.x = x;
		this.z = z;
		this.sizeX = sx;
		this.sizeZ = sz;
		this.y = y;
		this.type = t;
	}
	
	
	//building types
	public static final int Type_GroundworkSmall = 0;
	public static final int Type_GroundworkMedium = 1;
	public static final int Type_GroundworkLarge = 2;
}