package com.ckhgame.villagebento.config;

public class ConfigVillager {

	public static final int VillagerRevivingDuration = 48; //how long the village will be revived after death (on hours)
	public static final int TradingExp = 3;	//how much exp the villager will get for each trading action
	public static final int WorkExpPerHour = 1;	//how much exp the villager will get for working one hour
	public static final int WorkOutputExpirationHours = 48;	//if the work out hasn't been took more than 2 days, it will automatically disappear!
	
	public static final int BetExp = 3;	//how much exp the villager will get for each bet action

	public static final int AIWanderDistanceMaxNearBuilding = 5;
	public static final int AIWanderDistanceMaxY = 3; 
	public static final int ALWanderInBuildingWallOffset = 2;
	
	public static final int ALGuardPatrolNearMaxBuilding = 1;
	public static final int AIGuardPatrolDistanceMaxY = 1;
	public static final double AIGuardPotrolSearchDistanceX = 200.0D;
	public static final double AIGuardPotrolSearchDistanceY = 20.0D;
	public static final double AIGuardPotrolSearchDistanceZ = 200.0D;
	
	public static final double AIVillagerVisitingSearchDistanceX = 200.0D;
	public static final double AIVillagerVisitingSearchDistanceY = 20.0D;
	public static final double AIVillagerVisitingSearchDistanceZ = 200.0D;
	
	public static final double AIVillagerSearchDistance = 16.0D;
	
	public static final double VillagerMoveSpeed = 0.35D;
	
	public static final double VillagerMoveTowardsDistance = 5;
	public static final int VillagerMoveTowardsRange = 2;
	
	public static final int MaxInteractDistance = 3;
	public static final int MaxInteractDistanceSq = 9;
	
	public static final int MaxRenderGuiDrawDistanceSq = 64 * 64;
	
	public static final int VisitingChance = 4; // means it has 1/VisitingChance to init a visiting...
	public static final int VisitingMaxSearchHeight = 1;
	
	public static final int QuestChance = 2;
}
