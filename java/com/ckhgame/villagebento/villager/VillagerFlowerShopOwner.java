package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerFlowerShopOwner extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Flower Shop Owner";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Flower makes you smiling!";
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
        compBuy.addItemBuy(Items.flower_pot, 1, 5, 0);
        compBuy.addItemBuy(ModBlocks.blockSunflower, 1, 2, 0);
        compBuy.addItemBuy(ModBlocks.blockPeacefulGarden, 1, 2, 0);
        compBuy.addItemBuy(ModBlocks.blockTeaChair, 1, 2, 0);
        compBuy.addItemBuy(ModBlocks.blockAutumnGarden, 1, 2, 0);
        compBuy.addItemBuy(ModBlocks.blockRoseBridge, 1, 2, 0);
        compBuy.addItemBuy(ModBlocks.blockRosePath, 1, 2, 0);
        compBuy.addItemBuy(ModBlocks.blockChristmas, 1, 2, 0);
        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Beautiful!");
		villagerChat.add(0, "Flowers make your life better!");
		villagerChat.add(0, "Flowers are the gifts from the nature.");
		
	}

	@Override
	public String getSkinName() {
		return "flowershopowner";
	}

}
