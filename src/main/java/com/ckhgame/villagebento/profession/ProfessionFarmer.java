package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionFarmer extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.farmer.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.farmer.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompWork compWork = new VillagerCompWork(villager);
        compWork.setDialogOptionText(StatCollector.translateToLocal("villager.farmer.workDialog"));
        int workIdx;
        
        workIdx = compWork.createWork(StatCollector.translateToLocal("villager.farmer.work0.title"), StatCollector.translateToLocal("villager.farmer.work0.description"),0 , 10, 45);
        compWork.addWorkOutput(workIdx, Items.wheat, 5, 10);
        compWork.addWorkOutput(workIdx, Items.carrot, 5, 8); 
        compWork.addWorkOutput(workIdx, Items.potato, 5, 8); 
        
        workIdx = compWork.createWork(StatCollector.translateToLocal("villager.farmer.work1.title"), StatCollector.translateToLocal("villager.farmer.work1.description"), 0, 15, 50);
        compWork.addWorkOutput(workIdx, Items.apple, 5, 8); 
        compWork.addWorkOutput(workIdx, Blocks.pumpkin, 8, 12);
        compWork.addWorkOutput(workIdx, Blocks.melon_block, 8, 12); 
        
        workIdx = compWork.createWork(StatCollector.translateToLocal("villager.farmer.work2.title"), StatCollector.translateToLocal("villager.farmer.work2.description"),1 , 10, 70);
        compWork.addWorkOutput(workIdx, ModItems.itemRiceplant, 5, 10);
        compWork.addWorkOutput(workIdx, ModItems.itemCabbage, 5, 8); 
        compWork.addWorkOutput(workIdx, ModItems.itemCorn, 5, 8); 
        
        workIdx = compWork.createWork(StatCollector.translateToLocal("villager.farmer.work3.title"), StatCollector.translateToLocal("villager.farmer.work3.description"), 2, 15, 100);
        compWork.addWorkOutput(workIdx, ModItems.itemSoybeans, 3, 8); 
        compWork.addWorkOutput(workIdx, ModItems.itemGrapes, 3, 8); 
        compWork.addWorkOutput(workIdx, ModItems.itemChili, 3, 8); 
        
        components.add(compWork);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.farmer.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.farmer.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.farmer.chat2"));
		
	}
	
	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[2][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(Items.iron_hoe,4)};
		
		this.levelRequirements[1] = new ItemStack[]{	new ItemStack(Items.golden_hoe,4)};
		
	}

	@Override
	public String getSkinName() {
		return "farmer";
	}

}
