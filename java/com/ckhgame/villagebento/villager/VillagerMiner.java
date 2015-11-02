package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.component.VillagerCompChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompTrade;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

public class VillagerMiner extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Miner";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Mining things.......";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<VillagerComponent> createComponents() {
		// TODO Auto-generated method stub
		 //test
        ArrayList<VillagerComponent> components = new ArrayList<VillagerComponent>();
        components.add(new VillagerCompAbout());
        components.add(new VillagerCompChat());
        
        return components;
	}

}
