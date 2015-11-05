package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

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
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompWork compWork = new VillagerCompWork();
        int workIdx;
        workIdx = compWork.createWork("mine1", "mine mine", 0, 10, 0);
        compWork.addWorkOutput(workIdx, Items.coal, 10, 20);
        compWork.addWorkOutput(workIdx, Blocks.cobblestone, 5, 20);
        
        workIdx = compWork.createWork("mine2", "mine2 mine2", 1, 10, 10);
        compWork.addWorkOutput(workIdx, Blocks.iron_ore, 1, 5);
        compWork.addWorkOutput(workIdx, Blocks.gold_ore, 1, 5);
        
        workIdx = compWork.createWork("mine3", "mine3 mine3", 0, 10, 1);
        compWork.addWorkOutput(workIdx, Items.arrow, 10, 20);
        compWork.addWorkOutput(workIdx, Items.boat, 1, 2);
        
        components.add(compWork);
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "I saw a big boom yesterday");
		villagerChat.add(0, "Do you need help?");
		villagerChat.add(0, "Hello there!");
		
	}
	
	@Override
	public String getSkinName() {
		return "miner";
	}

}
