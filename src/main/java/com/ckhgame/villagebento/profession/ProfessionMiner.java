package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionMiner extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.miner.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.miner.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompWork compWork = new VillagerCompWork(villager);
        compWork.setDialogOptionText("villager.miner.workDialog");
        int workIdx;
        workIdx = compWork.createWork("villager.miner.work0.title", "villager.miner.work0.description",0 , 7, 15);
        compWork.addWorkOutput(workIdx, Items.coal, 7, 12);
        
        workIdx = compWork.createWork("villager.miner.work1.title", "villager.miner.work1.description", 1, 10, 50);
        compWork.addWorkOutput(workIdx, Blocks.iron_ore, 5, 8); 
        
        workIdx = compWork.createWork("villager.miner.work2.title", "villager.miner.work2.description", 2, 12, 120);
        compWork.addWorkOutput(workIdx, Blocks.gold_ore, 3, 6); 
        
        workIdx = compWork.createWork("villager.miner.work3.title", "villager.miner.work3.description", 3, 20, 180);
        compWork.addWorkOutput(workIdx, Items.diamond, 1, 4); 
        
        components.add(compWork);
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "villager.miner.chat0");
		villagerChat.add(0, "villager.miner.chat1");
		villagerChat.add(0, "villager.miner.chat2");
		
	}
	
	@Override
	public String getSkinName() {
		return "miner";
	}
	
	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[3][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(Items.coal,32),
																				new ItemStack(Blocks.ladder,32)};
		
		this.levelRequirements[1] = new ItemStack[]{	new ItemStack(Items.coal,64),
																				new ItemStack(Blocks.ladder,32),
																				new ItemStack(Items.iron_ingot,32)};
		
		this.levelRequirements[2] = new ItemStack[]{	new ItemStack(Items.coal,64),
																				new ItemStack(Blocks.ladder,64),
																				new ItemStack(Items.gold_ingot,32)};
		
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
