package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerMinerAssistant extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Miner Assistant";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Sell Mining tools.......";
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
        compBuy.addItemBuy(Items.iron_pickaxe, 1, 3, 0);
        compBuy.addItemBuy(Items.golden_pickaxe, 1, 2, 3);
        compBuy.addItemBuy(Items.diamond_pickaxe, 1, 1, 5);
        compBuy.addItemBuy(Blocks.ladder, 1, 32, 0);
        compBuy.addItemBuy(Blocks.torch, 1, 32, 0);
        compBuy.addItemBuy(Blocks.rail, 1, 32, 0);
        compBuy.addItemBuy(Items.minecart, 1, 2, 0);
        compBuy.addItemBuy(Items.compass, 1, 2, 0);
        components.add(compBuy);
        
	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "I saw a big boom yesterday");
		villagerChat.add(0, "Do you need help?");
		villagerChat.add(0, "Hello there!");
		
	}
	
	@Override
	public String getSkinName() {
		return "minerassistant";
	}

}
