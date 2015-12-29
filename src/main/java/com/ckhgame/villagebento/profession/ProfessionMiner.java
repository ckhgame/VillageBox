package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class ProfessionMiner extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Miner";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Mining things.......";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompWork compWork = new VillagerCompWork(villager);
        compWork.setDialogOptionText("Please mining for me!");
        int workIdx;
        workIdx = compWork.createWork("Coals mining", "coal...",0 , 7, 15);
        compWork.addWorkOutput(workIdx, Items.coal, 7, 12);
        
        workIdx = compWork.createWork("Iron mining", "iron ....", 1, 10, 50);
        compWork.addWorkOutput(workIdx, Blocks.iron_ore, 5, 8); 
        
        workIdx = compWork.createWork("Gold mining", "gold!", 1, 12, 120);
        compWork.addWorkOutput(workIdx, Blocks.gold_ore, 3, 6); 
        
        workIdx = compWork.createWork("Diamond mining", "diamond!", 2, 20, 180);
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
