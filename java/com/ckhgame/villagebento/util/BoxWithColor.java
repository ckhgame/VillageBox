package com.ckhgame.villagebento.util;

public class BoxWithColor{
	public int minX,minY,minZ,maxX,maxY,maxZ;
	public int R,G,B,A;
	public BoxWithColor(int minX,int minY,int minZ,int maxX,int maxY,int maxZ, int R,int G,int B,int A){
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
		this.R = R;
		this.G = G;
		this.B = B;
		this.A = A;
	}
}
