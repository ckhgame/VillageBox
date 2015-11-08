package com.ckhgame.villagebento.network.action;

public class ModActions {
	public static void init(){
		
		//client ->server
		int id = 0;
		Action.registry.register(id++, new ActionGetVillagerName());
		Action.registry.register(id++, new ActionGetVillagerLevel());
		Action.registry.register(id++, new ActionDoVillagerChat());
		Action.registry.register(id++, new ActionInitVillager());
		Action.registry.register(id++, new ActionGetVillagerBuy());
		Action.registry.register(id++, new ActionDoVillagerBuy());
		Action.registry.register(id++, new ActionGetVillagerSell());
		Action.registry.register(id++, new ActionDoVillagerSell());
		Action.registry.register(id++, new ActionGetVillagerWork());
		Action.registry.register(id++, new ActionDoVillagerStartWork());
		Action.registry.register(id++, new ActionDoVillagerTakeWorkOutput());
		Action.registry.register(id++, new ActionGetVillagerWorkList());
		Action.registry.register(id++, new ActionDoDropCoins());
		
		
		//server -> clinet
		id = 100;
		Action.registry.register(id++, new SActionUpdateVillagerSleep());
		
	}
}
