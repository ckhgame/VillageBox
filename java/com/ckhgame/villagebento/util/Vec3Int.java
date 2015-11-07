package com.ckhgame.villagebento.util;

import net.minecraft.util.Vec3;

public class Vec3Int {
	int x,y,z;
	
	public Vec3 toVec3(){
		return Vec3.createVectorHelper(x, y, z);
	}
	
	public static Vec3Int create(int x, int y, int z){
		Vec3Int v = new Vec3Int();
		v.x = x;
		v.y = y;
		v.z = z;
		return v;
	}
	
	public static Vec3Int create(double x, double y, double z){
		Vec3Int v = new Vec3Int();
		v.x = (int)x;
		v.y = (int)y;
		v.z = (int)z;
		return v;
	}
	
	public static Vec3Int create(Vec3 v3){
		Vec3Int v = new Vec3Int();
		v.x = (int)v3.xCoord;
		v.y = (int)v3.yCoord;
		v.z = (int)v3.zCoord;
		return v;
	}
}
