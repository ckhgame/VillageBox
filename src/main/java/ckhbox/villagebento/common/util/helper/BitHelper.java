package ckhbox.villagebento.common.util.helper;

public class BitHelper {
	public static boolean readBit(int data, int offset){
		return ((data>>offset) & 1) == 0?false:true;
	}
	
	public static int writeBit(int data, int offset, boolean flag){
		if(readBit(data,offset) != flag){
			data ^= (1<<offset);
		}
		return data;
	}
}
