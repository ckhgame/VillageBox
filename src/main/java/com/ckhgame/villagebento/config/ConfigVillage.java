package com.ckhgame.villagebento.config;

public class ConfigVillage {
	public static final int VillageBoundaryExtensionHorizontal = 8;
	public static final int VillageBoundaryExtensionVertical = 2;
	public static final int NewVillageSizeRequirment = 15;
	
	public static final int FireProhibitDistance = 3;	//a distance near the village building. The player can not use flint_and_stone or fire_charger near the filed
	
	public static final int TravelerSpawnChance = 3; //means every time the traveler spawning function be called, 1/N chance the traveler will be spawned...  
	public static final int TravelerStayTime = 48; // how long travelers will stay in the village
}
