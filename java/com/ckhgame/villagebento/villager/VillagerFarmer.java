package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerFarmer extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Farmer";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Farming!";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setExpBase(){
		expBase = 20;
		expE = 3;
	}
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompWork compWork = new VillagerCompWork();
        int workIdx;
        workIdx = compWork.createWork("Basic of farming", "want to make bread?",0 , 10, 30);
        compWork.addWorkOutput(workIdx, Items.wheat, 5, 10);
        
        workIdx = compWork.createWork("Get more carrots!", "Vegitables are healthy", 5, 15, 50);
        compWork.addWorkOutput(workIdx, Items.carrot, 5, 8); 
        
        workIdx = compWork.createWork("Wanna baking potatos?", "Vegitables are healthy", 5, 15, 50);
        compWork.addWorkOutput(workIdx, Items.potato, 5, 8); 
        
        workIdx = compWork.createWork("Pick some apples", "An apple a day keeps teh doctor away!", 5, 15, 50);
        compWork.addWorkOutput(workIdx, Items.apple, 5, 8); 
        
        workIdx = compWork.createWork("Harvest Time!", "Ready for Autumn's festivals!", 10, 20, 90);
        compWork.addWorkOutput(workIdx, Blocks.pumpkin, 8, 12); 
        
        workIdx = compWork.createWork("Summer fest!", "Melons!", 10, 20, 102);
        compWork.addWorkOutput(workIdx, Blocks.melon_block, 8, 12); 
        
        components.add(compWork);
        
        
        VillagerCompBuy compBuy = new VillagerCompBuy();
        compBuy.addItemBuy(Items.iron_hoe, 1, 1, 0);
        compBuy.addItemBuy(Items.golden_hoe, 1, 1, 15);
        compBuy.addItemBuy(Items.wheat_seeds, 1, 5, 0);
        compBuy.addItemBuy(Items.pumpkin_seeds, 1, 2, 15);
        compBuy.addItemBuy(Items.melon_seeds, 1, 2, 18);
        compBuy.addItemBuy(Items.carrot, 1, 2, 18);
        compBuy.addItemBuy(Items.potato, 1, 2, 18);
        compBuy.addItemBuy(Items.apple, 1, 1, 20);

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
		return "farmer";
	}

}
