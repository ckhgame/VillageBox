package ckhbox.villagebento.common.util.math;

import java.util.Random;

public class Rand {
	public static Random random;
	public static Random get(){
		if(random == null)
			random = new Random();
		return random;
	}
}
