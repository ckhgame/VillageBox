package ckhbox.villagebox.common.util.math;

import java.util.Random;

public class Rand {
	private static Random random;
	public static Random get(){
		if(random == null)
			random = new Random();
		return random;
	}
}
