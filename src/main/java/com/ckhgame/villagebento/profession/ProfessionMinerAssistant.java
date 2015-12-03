package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class ProfessionMinerAssistant extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Miner Assistant";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Sell Mining tools.......";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
  
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.iron_pickaxe, 1, 3, 0);
        compBuy.addItem(Items.golden_pickaxe, 1, 2, 3);
        compBuy.addItem(Items.diamond_pickaxe, 1, 1, 5);
        compBuy.addItem(Blocks.ladder, 1, 32, 0);
        compBuy.addItem(Blocks.torch, 1, 32, 0);
        compBuy.addItem(Blocks.rail, 1, 32, 0);
        compBuy.addItem(Items.minecart, 1, 2, 0);
        compBuy.addItem(Items.compass, 1, 2, 0);
        components.add(compBuy);
        
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "I saw a big boom yesterday");
		villagerChat.add(0, "Do you need help?");
		villagerChat.add(0, "Hello there!");
		
	}
	
	@Override
	public String getSkinName() {
		return "minerassistant";
	}

}
