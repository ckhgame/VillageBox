package com.ckhgame.villagebento.util.tool;

import java.util.Random;

public class VBRandom {
	private static Random rand = null;
	public static Random getRand(){
		if(rand == null)
			rand = new Random();
		return rand;
	}
}
