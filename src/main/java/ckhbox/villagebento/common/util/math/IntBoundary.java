package ckhbox.villagebento.common.util.math;

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

	public IntVec3 center(){
		IntVec3 center = new IntVec3((this.minx + this.maxx)/2, (this.miny + this.maxy)/2, (this.minz + this.maxz)/2);
		return center;
	}
	
	public IntVec3 size(){
		IntVec3 size = new IntVec3(this.maxx - this.minx + 1, this.maxy - this.miny + 1, this.maxz - this.minz + 1);
		return size;
	}
	
	@Override
	public String toString() {
		return String.format("from:[%d,%d,%d] to:[%d,%d,%d] size:[%d,%d,%d]", 
				this.minx,this.miny,this.minz,this.maxx,this.maxy,this.maxz,this.maxx - this.minx + 1, this.maxy - this.miny + 1, this.maxz - this.minz + 1);
	}
	
	
}
