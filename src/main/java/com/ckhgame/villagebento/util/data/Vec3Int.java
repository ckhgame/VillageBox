package com.ckhgame.villagebento.util.data;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Vec3Int {
	public int x,y,z;
	
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
		v.x = MathHelper.floor_double(x);
		v.y = MathHelper.floor_double(y);
		v.z = MathHelper.floor_double(z);
		return v;
	}
	
	public static Vec3Int create(Vec3 v3){
		Vec3Int v = new Vec3Int();
		v.x = MathHelper.floor_double(v3.xCoord);
		v.y = MathHelper.floor_double(v3.yCoord);
		v.z = MathHelper.floor_double(v3.zCoord);
		return v;
	}
}
