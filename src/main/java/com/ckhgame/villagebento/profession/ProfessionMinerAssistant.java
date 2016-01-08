package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionMinerAssistant extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.minerAssistant.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.minerAssistant.description");
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
        compBuy.addItem(Blocks.ladder, 1, 32, 0);
        compBuy.addItem(Blocks.torch, 1, 32, 0);
        compBuy.addItem(Blocks.rail, 1, 32, 0);
        compBuy.addItem(Items.minecart, 1, 2, 0);
        compBuy.addItem(Items.compass, 1, 2, 0);
        components.add(compBuy);
        
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.minerAssistant.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.minerAssistant.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.minerAssistant.chat2"));
		
	}
	
	@Override
	public String getSkinName() {
		return "minerassistant";
	}

}
