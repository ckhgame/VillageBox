package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionMerchant extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Potion Merchant";
	}

	@Override
	public String getProfessionDescription() {
		
		return "It is a Deal!";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.glass_bottle, 0);
        compBuy.addItem(Items.potionitem, 3);
        compBuy.addItem(Items.experience_bottle, 8);
        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Trying to buy somthing?");
		villagerChat.add(0, "You find everthing Ok?");
		villagerChat.add(0, "This is today's speacial!");
		
	}

	@Override
	public String getSkinName() {
		return "merchant";
	}

}
