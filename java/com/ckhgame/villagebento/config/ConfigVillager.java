package com.ckhgame.villagebento.config;

public class ConfigVillager {
	public static final int VillagerRevivingDurationByDay = 2; //how long the village will be revived after death (on day)
	public static final int TradingExp = 3;	//how much exp the villager will get for each trading action
	public static final int WorkExpPerHour = 1;	//how much exp the villager will get for working one hour
	public static final int WorkOutputExpirationHours = 48;	//if the work out hasn't been took more than 2 days, it will automatically disappear!
	
	public static final int AIWanderDistanceMaxNearBuilding = 5;
	public static final int AIWanderDistanceMaxY = 3; 
	public static final int ALWanderInBuildingWallOffset = 2;
	
	public static final double VillagerMoveSpeed = 0.35D;
}
