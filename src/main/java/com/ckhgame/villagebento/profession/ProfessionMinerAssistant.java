package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
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
        compBuy.addItem(Items.iron_pickaxe, 0);
        compBuy.addItem(Blocks.ladder, 0);
        compBuy.addItem(Blocks.torch, 0);
        compBuy.addItem(Blocks.rail, 0);
        compBuy.addItem(Items.minecart, 0);
        compBuy.addItem(Items.compass, 0);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.flint, 0);
        components.add(compSell);
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
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(11,17));	
		timeSchedule.setWorkTime(1, new RangeInt(11,17));	
		timeSchedule.setWorkTime(2, new RangeInt(11,17));	
		timeSchedule.setWorkTime(3, new RangeInt(11,17));	
		timeSchedule.setWorkTime(4, new RangeInt(11,17));	

		timeSchedule.setWorkTime(6, new RangeInt(11,17));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}

}
