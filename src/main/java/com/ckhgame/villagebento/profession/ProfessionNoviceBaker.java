package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionNoviceBaker extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Novice Baker";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Novice Level Baker";
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
        compBuy.addItem(Items.bread, 2, 3, 0);
        compBuy.addItem(Items.cookie, 1, 2, 0);
        compBuy.addItem(Items.baked_potato, 2, 3, 0);

        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.wheat_seeds, 10, 20, 0);
        components.add(compSell);
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Fresh bread!");
		villagerChat.add(0, "Are you hungury!");
		villagerChat.add(0, "Hello!!!");
		
	}

	@Override
	public String getSkinName() {
		return "novicebaker";
	}
	
}
