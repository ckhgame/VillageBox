package com.ckhgame.villagebento.network.action;

public class ModActions {
	public static void init(){
		
		//client ->server
		int id = 0;
		Action.registry.register(id++, new ActionSyncVillagerComp());
		Action.registry.register(id++, new ActionDoVillagerBuy());
		Action.registry.register(id++, new ActionDoVillagerSell());
		Action.registry.register(id++, new ActionDoVillagerAction());
		Action.registry.register(id++, new ActionDoVillagerStartWork());
		Action.registry.register(id++, new ActionDoVillagerTakeWorkOutput());
		Action.registry.register(id++, new ActionDoDropCoins());
		Action.registry.register(id++, new ActionDoCreateAnimal());
		Action.registry.register(id++, new ActionDoVillagerCompleteQuest());
		Action.registry.register(id++, new ActionDoVillagerAcceptQuest());
		
		
		//server -> clinet
		id = 1000;
		Action.registry.register(id++, new SActionDoSpawnParticles());
	}
}
