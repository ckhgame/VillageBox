package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerActionBet;

public class ProfessionCasinoDealer extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Casino Dealer";
	}

	@Override
	public String getProfessionDescription() {
		
		return "See what we got...";
	}
	
	@Override
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBVillager.class;
	}
	
	@Override
	public boolean isMale(){
		return false;
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
        compAction.addAction(new VillagerActionBet("I'm so lucky!(bet:200)", 0, new Object[]{200}));
        compAction.addAction(new VillagerActionBet("I want W-I-N!(bet:500)", 1, new Object[]{500}));
        components.add(compAction);
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Double or not?");
		villagerChat.add(0, "Split? may be not?");
		villagerChat.add(0, "Good luck!");
		
	}

	@Override
	public String getSkinName() {
		return "casinodealer";
	}

}
