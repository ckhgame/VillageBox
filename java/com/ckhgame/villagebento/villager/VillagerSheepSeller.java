package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerSheepSeller extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Sheep Products Seller";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "White as snow is sheep.";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompBuy compBuy = new VillagerCompBuy();
        compBuy.addItemBuy(Items.lead, 1, 1, 0);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "shearing?");
		villagerChat.add(0, "Wanna warm clothes?");
		
	}

	@Override
	public String getSkinName() {
		return "sheepseller";
	}

}
