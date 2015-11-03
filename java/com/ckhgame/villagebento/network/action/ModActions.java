package com.ckhgame.villagebento.network.action;

public class ModActions {
	public static void init(){
		int id = 0;
		Action.registry.register(id++, new ActionGetVillagerName());
		Action.registry.register(id++, new ActionGetVillagerLevel());
		Action.registry.register(id++, new ActionDoVillagerChat());
		Action.registry.register(id++, new ActionInitVillager());
		Action.registry.register(id++, new ActionGetVillagerBuy());
		Action.registry.register(id++, new ActionDoVillagerBuy());
		Action.registry.register(id++, new ActionGetVillagerSell());
		Action.registry.register(id++, new ActionDoVillagerSell());
	}
}
