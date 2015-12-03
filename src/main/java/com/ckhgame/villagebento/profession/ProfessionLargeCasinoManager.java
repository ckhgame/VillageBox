package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBNightbird;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerActionBet;

public class ProfessionLargeCasinoManager extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Large Casino Manager";
	}

	@Override
	public String getProfessionDescription() {
		
		return "It is a big win!";
	}
	
	@Override
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBNightbird.class;
	}
	
	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));

        //action
        VillagerCompAction compAction = new VillagerCompAction(villager);
        compAction.addAction(new VillagerActionBet("I'm..CRAZY!!!(bet:1000)", 0, new Object[]{1000}));
        compAction.addAction(new VillagerActionBet("I'm..SUPER CRAZY!!!(bet:2000)", 1, new Object[]{2000}));
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
