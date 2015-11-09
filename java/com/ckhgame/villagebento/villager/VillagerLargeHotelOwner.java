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

public class VillagerLargeHotelOwner extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Large Hotel Owner";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "The owner of the Large Hotel";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Glad to see you here!");
		villagerChat.add(0, "How are you doing today?");
		villagerChat.add(0, "This is the price of the room...");
		
	}

	@Override
	public String getSkinName() {
		return "largehotelowner";
	}
	
}
