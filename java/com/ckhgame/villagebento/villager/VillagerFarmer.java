package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.item.ModItems;
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
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompWork compWork = new VillagerCompWork();
        int workIdx;
        workIdx = compWork.createWork("Basic of farming", "want to make rice?",0 , 10, 30);
        compWork.addWorkOutput(workIdx, ModItems.itemRiceplant, 5, 10);
        
        workIdx = compWork.createWork("Get more Vegi!", "Vegitables are healthy", 2, 15, 50);
        compWork.addWorkOutput(workIdx, ModItems.itemCabbage, 5, 8); 
        
        workIdx = compWork.createWork("Wanna make cornchips?", "Cornchips are delicious!", 3, 15, 50);
        compWork.addWorkOutput(workIdx, ModItems.itemCorn, 5, 8); 
        
        workIdx = compWork.createWork("Some Asia testy", "Hand make Tofu.", 5, 15, 50);
        compWork.addWorkOutput(workIdx, ModItems.itemSoybeans, 5, 8); 
        
        workIdx = compWork.createWork("Pick Grapes!", "Ready for Vines festivals!", 7, 20, 90);
        compWork.addWorkOutput(workIdx, ModItems.itemGrapes, 8, 12); 
        
        workIdx = compWork.createWork("Mexcio fest!", "Hot Chilis!", 7, 20, 102);
        compWork.addWorkOutput(workIdx, ModItems.itemChili, 8, 12); 
        
        components.add(compWork);
        
        
        VillagerCompBuy compBuy = new VillagerCompBuy();
        compBuy.addItemBuy(Items.iron_hoe, 1, 1, 0);
        compBuy.addItemBuy(Items.golden_hoe, 1, 1, 3);
        compBuy.addItemBuy(ModItems.itemRiceSeed, 1, 5, 0);
        compBuy.addItemBuy(ModItems.itemCornSeed, 1, 2, 2);
        compBuy.addItemBuy(ModItems.itemCabbageSeed, 1, 2,3);
        compBuy.addItemBuy(ModItems.itemSoybeanSeed, 1, 2, 5);
        compBuy.addItemBuy(ModItems.itemGrapeSeed, 1, 2, 5);
        compBuy.addItemBuy(ModItems.itemChiliSeed, 1, 1, 5);

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
