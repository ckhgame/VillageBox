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

	@Override
	public String toString() {
		return String.format("from:[%d,%d,%d] to:[%d,%d,%d] size:[%d,%d,%d]", 
				this.minx,this.miny,this.minz,this.maxx,this.maxy,this.maxz,this.maxx - this.minx + 1, this.maxy - this.miny + 1, this.maxz - this.minz + 1);
	}
	
	
}
