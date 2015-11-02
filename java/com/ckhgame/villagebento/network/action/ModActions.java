package com.ckhgame.villagebento.network.action;

public class ModActions {
	public static void init(){
		Action.registry.register(0, new ActionGetVillagerName());
	}
}
