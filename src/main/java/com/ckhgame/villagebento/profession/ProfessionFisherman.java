package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionFisherman extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Fisherman";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Fishing is fun...";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.cooked_fished, 4, 6, 0, 0);
        compBuy.addItem(Items.cooked_fished, 4, 6, 0, 1);
        compBuy.addItem(ModItems.itemSeaweed,7, 10, 0);
        compBuy.addItem(Items.fishing_rod, 1, 1, 0);
        compBuy.addItem(ModItems.itemIronFishingPole, 1, 1, 0);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.fish, 4, 6, 0, 0);
        compSell.addItem(Items.fish, 4, 6, 0, 1);
        compSell.addItem(Items.fish, 4, 6, 0, 2);
        compSell.addItem(Items.fish, 4, 6, 0, 3);
        components.add(compSell);

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Everybody needs a rod!");
		villagerChat.add(0, "Hi!");
		villagerChat.add(0, "Wish you luck");
		
	}

	@Override
	public String getSkinName() {
		return "fisherman";
	}
	
}
