package com.ckhgame.villagebento.util.data;

public class VBResult {
	public static final int SUCCESS = 0;
	public static final int FAILED_UNAFFORDABLE = 100;
	public static final int FALLED_RUNOUT = 101;
	public static final int FAILED_NOITEM = 102;
	public static final int FAILED_WRONGNAME = 103;
	public static final int FAILED = 120;
	
	public static boolean isSuccess(int vbResult){
		return (vbResult < 100);
	}
}
