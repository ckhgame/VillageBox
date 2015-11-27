package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class ProfessionFarmerSmall extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Small Farm Owner";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Farming!";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompWork compWork = new VillagerCompWork(villager);
        int workIdx;
        workIdx = compWork.createWork("Basic of farming", "want to make bread?",0 , 10, 30);
        compWork.addWorkOutput(workIdx, Items.wheat, 5, 10);
        
        workIdx = compWork.createWork("Get more carrots!", "Vegitables are healthy", 2, 15, 50);
        compWork.addWorkOutput(workIdx, Items.carrot, 5, 8); 
        
        workIdx = compWork.createWork("Wanna baking potatos?", "Vegitables are healthy", 3, 15, 50);
        compWork.addWorkOutput(workIdx, Items.potato, 5, 8); 
        
        workIdx = compWork.createWork("Pick some apples", "An apple a day keeps teh doctor away!", 5, 15, 50);
        compWork.addWorkOutput(workIdx, Items.apple, 5, 8); 
        
        workIdx = compWork.createWork("Harvest Time!", "Ready for Autumn's festivals!", 7, 20, 90);
        compWork.addWorkOutput(workIdx, Blocks.pumpkin, 8, 12); 
        
        workIdx = compWork.createWork("Summer fest!", "Melons!", 7, 20, 102);
        compWork.addWorkOutput(workIdx, Blocks.melon_block, 8, 12); 
        
        components.add(compWork);
        
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(Items.iron_hoe, 1, 1, 0);
        compBuy.addItem(Items.golden_hoe, 1, 1, 3);
        compBuy.addItem(Items.wheat_seeds, 1, 5, 0);
        compBuy.addItem(Items.pumpkin_seeds, 1, 2, 2);
        compBuy.addItem(Items.melon_seeds, 1, 2, 3);
        compBuy.addItem(Items.carrot, 1, 2, 5);
        compBuy.addItem(Items.potato, 1, 2, 5);
        compBuy.addItem(Items.apple, 1, 1, 8);

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need help on farming?");
		villagerChat.add(0, "Get something to eat?");
		villagerChat.add(0, "Look at this big pumpkin!");
		
	}

	@Override
	public String getSkinName() {
		return "farmersmall";
	}

}
