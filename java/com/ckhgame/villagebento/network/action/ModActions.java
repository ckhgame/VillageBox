package com.ckhgame.villagebento.network.action;

public class ModActions {
	public static void init(){
		Action.registry.register(0, new ActionGetVillagerName());
		Action.registry.register(1, new ActionGetVillagerLevel());
		Action.registry.register(2, new ActionDoVillagerChat());
		Action.registry.register(3, new ActionInitVillager());
		Action.registry.register(4, new ActionGetVillagerBuy());
		Action.registry.register(5, new ActionDoVillagerBuy());
	}
}
