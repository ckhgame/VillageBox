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
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionBlackSmith extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.blackSmith.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.blackSmith.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.iron_sword, 0);
        compBuy.addItem(Items.iron_axe, 0);
        compBuy.addItem(Items.golden_sword, 1);
        compBuy.addItem(Items.golden_axe, 1);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.coal, 0);
        compSell.addItem(Items.iron_ingot, 0);
        compSell.addItem(Items.gold_ingot, 1);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "villager.blackSmith.chat0");
		villagerChat.add(0, "villager.blackSmith.chat1");
		villagerChat.add(0, "villager.blackSmith.chat2");
		
	}
	
	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[1][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(Items.iron_ingot,16)};
		
	}

	@Override
	public String getSkinName() {
		return "blacksmith";
	}
	
	@Override
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(10,16));	

		timeSchedule.setWorkTime(2, new RangeInt(10,16));	
		timeSchedule.setWorkTime(3, new RangeInt(10,16));	
		timeSchedule.setWorkTime(4, new RangeInt(10,16));	
		timeSchedule.setWorkTime(5, new RangeInt(10,16));	
		timeSchedule.setWorkTime(6, new RangeInt(10,16));	
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}

}
