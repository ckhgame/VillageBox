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

public class VillagerBakerAssistant extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Baker Assistant";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Entry level Baker";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Items.wheat_seeds, 10, 20, 0);
        components.add(compSell);
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Need help with bakery?");
		villagerChat.add(0, "Wanna get some baking powder?");
		villagerChat.add(0, "Bakery is fun!");
		
	}

	@Override
	public String getSkinName() {
		return "bakerassistant";
	}
	
}
