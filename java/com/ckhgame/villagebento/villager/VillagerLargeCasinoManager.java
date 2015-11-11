package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.network.action.ActionDoVillagerBet;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompAction;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerLargeCasinoManager extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Large Casino Manager";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "It is a big win!";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());

        //action
        VillagerCompAction compAction = new VillagerCompAction();
        compAction.addAction("I'm..CRAZY!!!(bet:1000)", ActionDoVillagerBet.class, new Object[]{1000}, 0);
        compAction.addAction("I'm..SUPER CRAZY!!!(bet:2000)", ActionDoVillagerBet.class, new Object[]{2000}, 1);
        components.add(compAction);
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Playing big?");
		villagerChat.add(0, "You should all in...");
		villagerChat.add(0, "Wish you luck!");
		
	}

	@Override
	public String getSkinName() {
		return "largecasinomanager";
	}

}
