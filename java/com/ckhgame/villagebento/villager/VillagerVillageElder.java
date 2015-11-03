package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerVillageElder extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Village Elder";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Living in Village Center";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompBuy compBuy = new VillagerCompBuy();
        compBuy.addItemBuy(Items.apple, 1, 5, 0);
        compBuy.addItemBuy(Items.beef, 2, 10, 0);
        compBuy.addItemBuy(Items.blaze_rod, 1, 2, 0);
        compBuy.addItemBuy(Items.bone, 10, 20, 0);
        compBuy.addItemBuy(Blocks.stonebrick, 1, 3, 0);
        compBuy.addItemBuy(Blocks.stone, 20, 50, 0);
        compBuy.addItemBuy(Blocks.log, 20, 50, 0);
        compBuy.addItemBuy(Blocks.log, 20, 50, 0,1);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Items.bed, 1, 5, 0);
        compSell.addItemSell(Items.beef, 2, 10, 0);
        components.add(compSell);

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Nice to meet you!");
		villagerChat.add(0, "Glad to see you!");
		villagerChat.add(0, "Hi there!");
		
	}

}
