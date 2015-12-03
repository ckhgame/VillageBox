package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBNightbird;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionLargeTavernOwner extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Large Tavern Owner";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Liquid is the best medicine for pain.";
	}
	
	@Override
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBNightbird.class;
	}
	
	@Override
	public boolean isMale(){
		return false;
	}
	
	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(ModItems.itemCockTail, 3, 8, 0);
        compBuy.addItem(ModItems.itemBeer, 2, 5, 0);
        compBuy.addItem(ModItems.itemGrapeVine, 5, 10, 0);
        compBuy.addItem(ModItems.itemWhisky, 1, 5, 0);
        compBuy.addItem(ModItems.itemVodka, 1, 3, 0);
        compBuy.addItem(ModItems.itemCookVine, 1, 15, 0);
        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Got something to drink?");
		villagerChat.add(0, "Vodka? or just want a cocktail?");
		villagerChat.add(0, "liquid sloves everything.");
		
	}

	@Override
	public String getSkinName() {
		return "largetavernowner";
	}

}
