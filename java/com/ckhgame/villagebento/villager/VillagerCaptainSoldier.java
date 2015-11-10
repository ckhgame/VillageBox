package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerCaptainSoldier extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Captain Soldier";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "It is my horner!";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());

        components.add(new VillagerCompAbout());
        
        VillagerCompWork compWork = new VillagerCompWork();
        int workIdx;
        workIdx = compWork.createWork("Protect our homeland!", "Get somthing to prove..",0 , 18, 28);
        compWork.addWorkOutput(workIdx, Items.rotten_flesh, 7, 12);
        
       
        components.add(compWork);
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "In your order!");
		villagerChat.add(0, "Glad to help you!");
		
	}

	@Override
	public String getSkinName() {
		return "soldiercaptain";
	}

}
