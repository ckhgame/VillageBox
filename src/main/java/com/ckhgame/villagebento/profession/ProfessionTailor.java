package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;

public class ProfessionTailor extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.Tailor.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.Tailor.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        for(int i =0;i<16;i++)
        	compBuy.addItem(ModBlocks.blockVillageCarpet1, 0, i);
        for(int i =0;i<16;i++)
        	compBuy.addItem(ModBlocks.blockVillageCarpet2, 0, i);
        
        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "villager.Tailor.chat0");
		villagerChat.add(0, "villager.Tailor.chat1");
		villagerChat.add(0, "villager.Tailor.chat2");
		
	}

	@Override
	public String getSkinName() {
		return "tailor";
	}

	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(11,16));	
		timeSchedule.setWorkTime(1, new RangeInt(11,16));	
		timeSchedule.setWorkTime(2, new RangeInt(11,16));	
		timeSchedule.setWorkTime(3, new RangeInt(11,16));	

		timeSchedule.setWorkTime(5, new RangeInt(11,16));	
		timeSchedule.setWorkTime(6, new RangeInt(11,16));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}
}
