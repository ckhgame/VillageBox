package ckhbox.villagebento.common.util.math;

import net.minecraft.util.Vec3;

public class IntBoundary {
	public int minx,miny,minz,maxx,maxy,maxz;
	public IntBoundary(int minx,int miny, int minz, int maxx, int maxy, int maxz){
		this.minx = minx;
		this.miny = miny;
		this.minz = minz;
		this.maxx = maxx;
		this.maxy = maxy;
		this.maxz = maxz;
	}
	
	public IntBoundary(int[] array){
		this.minx = array[0];
		this.miny = array[1];
		this.minz = array[2];
		this.maxx = array[3];
		this.maxy = array[4];
		this.maxz = array[5];
	}

	public boolean equalTo(IntBoundary other){
		if(this.maxx != other.maxx ||
		   this.minx != other.minx ||
		   this.maxy != other.maxy ||
		   this.miny != other.miny ||
		   this.maxz != other.maxz ||
		   this.minz != other.minz ){
			return false;
		}
		return true;
	}

	public boolean contact(IntBoundary other){
		if(this.maxx < other.minx ||
		   this.minx > other.maxx ||
		   this.maxy < other.miny ||
		   this.miny > other.maxy ||
		   this.maxz < other.minz ||
		   this.minz > other.maxz ){
			return false;
		}
		return true;
	}
	
	public boolean contact(IntVec3 vec){
		if(this.maxx < vec.x ||
		   this.minx > vec.x ||
		   this.maxy < vec.y ||
		   this.miny > vec.y ||
		   this.maxz < vec.z ||
		   this.minz > vec.z ){
			return false;
		}
		return true;
	}
	
	public IntBoundary extend(int ds){
		return this.extend(ds,ds,ds);
	}
	
	public IntBoundary extend(int dx, int dy, int dz){
		return new IntBoundary(this.minx - dx, this.miny - dy, this.minz - dz, this.maxx + dx, this.maxy + dy, this .maxz + dz);
	}
	
	public IntVec3 center(){
		IntVec3 center = new IntVec3((this.minx + this.maxx)/2, (this.miny + this.maxy)/2, (this.minz + this.maxz)/2);
		return center;
	}
	
	public IntVec3 size(){
		IntVec3 size = new IntVec3(this.maxx - this.minx + 1, this.maxy - this.miny + 1, this.maxz - this.minz + 1);
		return size;
	}
	
	public Vec3 getRandomPosInsideBoundary(){
		double x = Rand.get().nextInt(this.maxx + 1 - this.minx) + this.minx;
		double y = Rand.get().nextInt(this.maxy + 1 - this.miny) + this.miny;
		double z = Rand.get().nextInt(this.maxz + 1 - this.minz) + this.minz;
		return new Vec3(x,y,z);
	}
	
	public int[] toArray(){
		return new int[]{minx,miny,minz,maxx,maxy,maxz};
	}
	
	@Override
	public String toString() {
		return String.format("from:[%d,%d,%d] to:[%d,%d,%d] size:[%d,%d,%d]", 
				this.minx,this.miny,this.minz,this.maxx,this.maxy,this.maxz,this.maxx - this.minx + 1, this.maxy - this.miny + 1, this.maxz - this.minz + 1);
	}
	
	
}
