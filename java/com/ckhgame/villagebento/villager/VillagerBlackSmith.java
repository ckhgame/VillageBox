package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerBlackSmith extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "BlackSmith";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Making good weapons!";
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
        compBuy.addItemBuy(Items.iron_sword, 1, 3, 0);
        compBuy.addItemBuy(Items.iron_axe, 1, 3, 0);
        compBuy.addItemBuy(Items.golden_sword, 1, 3, 3);
        compBuy.addItemBuy(Items.golden_axe, 1, 3, 3);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Items.iron_ingot, 8, 12, 0);
        compSell.addItemSell(Items.gold_ingot, 5, 8, 5);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need any help on Armor?!");
		villagerChat.add(0, "Shaper..");
		villagerChat.add(0, "Need more Gold!");
		
	}

	@Override
	public String getSkinName() {
		return "blacksmith";
	}

}
