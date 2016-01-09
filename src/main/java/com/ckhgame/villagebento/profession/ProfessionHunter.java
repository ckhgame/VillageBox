package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionHunter extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.hunter.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.hunter.description");
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
        compBuy.addItem(Items.bow, 0);
        compBuy.addItem(Items.arrow, 0);
        compBuy.addItem(Items.leather, 0);
        compBuy.addItem(Items.porkchop, 0);
        compBuy.addItem(Items.beef, 0);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.stick, 0);
        compSell.addItem(Items.feather, 0);
        compSell.addItem(Items.bread, 0);

        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.hunter.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.hunter.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.hunter.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "hunter";
	}

}
