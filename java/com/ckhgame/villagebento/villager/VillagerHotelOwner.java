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

public class VillagerHotelOwner extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Hotel Owner";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "The owner of the Hotel";
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

		villagerChat.add(0, "Welcome!");
		villagerChat.add(0, "Have a sweet dream!");
		villagerChat.add(0, "Finding place to sleep?");
		
	}

	@Override
	public String getSkinName() {
		return "hotelowner";
	}
	
}
