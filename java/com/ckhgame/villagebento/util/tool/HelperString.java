package com.ckhgame.villagebento.util.tool;

public class HelperString {
	public static boolean isNumeric(String str){
	  return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static boolean isInteger(String str){
		return str.matches("^-?\\d+$");
	}
}
