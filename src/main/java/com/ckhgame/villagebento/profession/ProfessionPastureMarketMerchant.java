package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.util.StatCollector;

public class ProfessionPastureMarketMerchant extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.pmMerchant.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.pmMerchant.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(ModItems.itemVillageEgg, 10, 20, 0);
        compSell.addItem(ModItems.itemVillageHeartEgg, 10, 20, 0);
        compSell.addItem(ModItems.itemVillageSilverEgg, 4, 8, 0);
        compSell.addItem(ModItems.itemVillageGoldenEgg, 2, 5, 0);
        compSell.addItem(ModItems.itemVillageEasterEgg, 2, 5, 0);
        compSell.addItem(ModItems.itemVillageWool, 10, 20, 0);
        compSell.addItem(ModItems.itemVillageMilk, 10, 20, 0);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.pmMerchant.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.pmMerchant.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.pmMerchant.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "pasturemarketmerchant";
	}

}
