package com.ckhgame.villagebento.util.data;

public class Hour24 {
	public int from;
	public int to;
	
	public Hour24(int from, int to){
		
		if(from <=  to){
			this.from = from;
			this.to = to;
		}
		else{
			this.from = this.to;
			this.to = this.from;
		}
		
		if(this.from > 23) this.from = 23;
		if(this.to < 0) this.to = 0;
		
		
	}
	
	/**
	 * 
	 * in range: d >= from && d < 0
	 */
	public boolean inRange(int d){
		return (d >= this.from && d < this.to);
	}
}
