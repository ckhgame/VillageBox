package com.ckhgame.villagebento.util;

import net.minecraft.world.World;

public class VillageTime {
	public static boolean isDayTime(World world){
		int h = get24h(world);
		return (h <= 12);
	}
	
	public static boolean isEarlyNight(World world){
		int h = get24h(world);
		return (h > 12 && h <= 16);
	}
	public static boolean isLateNight(World world){
		int h = get24h(world);
		return (h > 16);
	}
	
	private static int get24h(World world){
		return (int)((world.getWorldTime() % 24000) / 1000);
	}
}
