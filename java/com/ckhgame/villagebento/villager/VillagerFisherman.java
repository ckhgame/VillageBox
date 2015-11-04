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

public class VillagerFisherman extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Fisherman";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Fishing is fun...";
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
        compBuy.addItemBuy(Items.cooked_fished, 4, 6, 0, 0);
        compBuy.addItemBuy(Items.cooked_fished, 4, 6, 0, 1);
        compBuy.addItemBuy(Items.fishing_rod, 1, 1, 0);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Items.fish, 4, 6, 0, 0);
        compSell.addItemSell(Items.fish, 4, 6, 0, 1);
        compSell.addItemSell(Items.fish, 4, 6, 0, 2);
        compSell.addItemSell(Items.fish, 4, 6, 0, 3);
        components.add(compSell);

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Everybody needs a rod!");
		villagerChat.add(0, "Hi!");
		villagerChat.add(0, "Wish you luck");
		
	}

	@Override
	public String getSkinName() {
		return "fisherman";
	}
	
}
