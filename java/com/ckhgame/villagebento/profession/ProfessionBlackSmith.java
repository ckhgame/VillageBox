package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionBlackSmith extends Profession {

	@Override
	public String getProfessionName() {
		
		return "BlackSmith";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Making good weapons!";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.iron_sword, 1, 3, 0);
        compBuy.addItem(Items.iron_axe, 1, 3, 0);
        compBuy.addItem(Items.golden_sword, 1, 3, 3);
        compBuy.addItem(Items.golden_axe, 1, 3, 3);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.iron_ingot, 8, 12, 0);
        compSell.addItem(Items.gold_ingot, 5, 8, 5);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need any help on Armor?!");
		villagerChat.add(0, "Shaper..");
		villagerChat.add(0, "Need more Gold!");
		
	}

	@Override
	public String getSkinName() {
		return "blacksmith";
	}

}
