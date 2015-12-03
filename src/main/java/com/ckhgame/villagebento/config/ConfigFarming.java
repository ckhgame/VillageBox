package com.ckhgame.villagebento.config;

public class ConfigFarming {
	public static final int GrowingTimePerStage = 25000; // how long should a seed take to enter next stage...
	public static final int CropsStageMax = 2;	//largest stage idx the crops have (0 - n)
	public static final int GrowingTimeTotal = GrowingTimePerStage * CropsStageMax;	//largest stage idx the crops have
}
