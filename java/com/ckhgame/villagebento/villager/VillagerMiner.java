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
        workIdx = compWork.createWork("Not Enough Torch", "get some coal...",0 , 7, 15);
        compWork.addWorkOutput(workIdx, Items.coal, 7, 12);
        
        workIdx = compWork.createWork("Iron Finder", "a little bit iron taste..", 1, 10, 50);
        compWork.addWorkOutput(workIdx, Blocks.iron_ore, 5, 8); 
        
        workIdx = compWork.createWork("Need more Gold", "Gold mountains!", 3, 12, 120);
        compWork.addWorkOutput(workIdx, Blocks.gold_ore, 3, 6); 
        
        workIdx = compWork.createWork("Diamond lover", "I think you need get a ring...", 5, 20, 180);
        compWork.addWorkOutput(workIdx, Blocks.diamond_ore, 1, 4); 
        
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
