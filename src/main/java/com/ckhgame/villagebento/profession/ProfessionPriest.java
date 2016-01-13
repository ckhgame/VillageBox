package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompQuest;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerActionBet;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerActionPriestDonation;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerActionPriestStory;
import com.ckhgame.villagebento.villagercomponent.villagerquest.VillagerQuestDesign;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionPriest extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.priest.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.priest.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {
		
        components.add(new VillagerCompAbout(villager));
        
        //action
        VillagerCompAction compAction = new VillagerCompAction(villager);
        compAction.setDialogOptionText("villager.priest.actionDialog");
        compAction.addAction(new VillagerActionPriestStory("villager.priest.action0.text","villager.priest.action0.info", 0, null));
        compAction.addAction(new VillagerActionPriestDonation("villager.priest.action1.text","villager.priest.action1.info", 0, new Object[]{20}));
        compAction.addAction(new VillagerActionPriestDonation("villager.priest.action2.text","villager.priest.action2.info", 0, new Object[]{50}));
        components.add(compAction);
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "villager.priest.chat0");
		villagerChat.add(0, "villager.priest.chat1");
		villagerChat.add(0, "villager.priest.chat2");
		
	}
	
	@Override
	public String getSkinName() {
		return "priest";
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(6,18));	
		timeSchedule.setWorkTime(1, new RangeInt(6,18));	
		timeSchedule.setWorkTime(2, new RangeInt(6,12));	
		timeSchedule.setWorkTime(3, new RangeInt(6,18));	
		timeSchedule.setWorkTime(4, new RangeInt(6,18));	
		timeSchedule.setWorkTime(5, new RangeInt(6,12));	
		timeSchedule.setWorkTime(6, new RangeInt(6,18));	
		
		timeSchedule.setSleeptime(new RangeInt(22,29));
	}
	

}
