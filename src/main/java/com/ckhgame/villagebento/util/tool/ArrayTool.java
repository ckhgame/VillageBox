package com.ckhgame.villagebento.util.tool;

public class ArrayTool {
	
	/**
	 * return a+b
	 */
	public Object[] combine(Object[] a, Object[]b){
		Object[] rtn = new Object[a.length+a.length];
		System.arraycopy( a, 0, rtn, 0, a.length);
		System.arraycopy( b, 0, rtn, a.length, b.length );
		return rtn;
	}
}
