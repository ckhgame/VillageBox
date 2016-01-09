package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
        compSell.addItem(Items.egg, 0);
        compSell.addItem(Blocks.wool, 0);
        compSell.addItem(ModItems.itemBottleOfMilk,0);
        compSell.addItem(ModItems.itemVillageEgg, 0);
        compSell.addItem(ModItems.itemVillageHeartEgg, 0);
        compSell.addItem(ModItems.itemVillageSilverEgg, 0);
        compSell.addItem(ModItems.itemVillageGoldenEgg, 0);
        compSell.addItem(ModItems.itemVillageEasterEgg, 0);
        compSell.addItem(ModItems.itemVillageWool, 0);
        compSell.addItem(ModItems.itemVillageMilk, 0);
        compSell.addItem(Items.fish, 0, 0);
        compSell.addItem(Items.fish, 0, 1);
        compSell.addItem(Items.fish, 0, 2);
        compSell.addItem(Items.fish, 0, 3);
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
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(10,16));	
		timeSchedule.setWorkTime(1, new RangeInt(10,16));	
		timeSchedule.setWorkTime(2, new RangeInt(10,16));	
		timeSchedule.setWorkTime(3, new RangeInt(10,16));	
		timeSchedule.setWorkTime(4, new RangeInt(10,16));	
		timeSchedule.setWorkTime(5, new RangeInt(10,16));	

		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}

}
