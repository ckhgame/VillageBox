package com.ckhgame.villagebento.util.data;

public class RangeInt {
	public int from;
	public int to;
	
	public RangeInt(int from, int to){
		if(from <=  to){
			this.from = from;
			this.to = to;
		}
		else{
			this.from = this.to;
			this.to = this.from;
		}
	}
	
	/**
	 * 
	 * in range: d >= from && d < 0
	 */
	public boolean inRange(int d){
		return (d >= this.from && d < this.to);
	}
}
