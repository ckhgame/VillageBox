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
	public static final int Type_GroundworkSmall = 1;
	public static final int Type_GroundworkMedium = 2;
	public static final int Type_GroundworkLarge = 3;
	
	public static final int Type_VillageCenter = 10;
	public static final int Type_MiningHouse = 11;
	public static final int Type_BlackSmithsShop = 12;
	public static final int Type_Bakery = 13;
}