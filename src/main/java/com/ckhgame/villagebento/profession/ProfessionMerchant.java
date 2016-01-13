package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionMerchant extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.Merchant.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.Merchant.description");
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
		villagerChat.add(0, "villager.Merchant.chat0");
		villagerChat.add(0, "villager.Merchant.chat1");
		villagerChat.add(0, "villager.Merchant.chat2");
		
	}

	@Override
	public String getSkinName() {
		return "merchant";
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(9,17));	
		timeSchedule.setWorkTime(1, new RangeInt(9,17));	
		timeSchedule.setWorkTime(2, new RangeInt(9,17));	

		timeSchedule.setWorkTime(4, new RangeInt(9,17));	
		timeSchedule.setWorkTime(5, new RangeInt(9,17));	
		timeSchedule.setWorkTime(6, new RangeInt(9,17));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}

}
