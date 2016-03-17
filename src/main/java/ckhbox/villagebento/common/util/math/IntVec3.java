package ckhbox.villagebento.common.util.math;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class IntVec3 {
	public int x,y,z;
	
	public IntVec3(double x, double y, double z){
		set(MathHelper.floor_double(x),MathHelper.floor_double(y),MathHelper.floor_double(z));
	}
	
	public IntVec3(Vec3 vec){
		this(vec.xCoord,vec.yCoord,vec.zCoord);
	}
	
	public IntVec3(int[] array){
		set(array[0],array[1],array[2]);
	}
	
	public IntVec3(int x, int y, int z){
		set(x,y,z);
	}
	
	public void set(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int[] toArray(){
		return new int[]{x,y,z};
	}
	
}
