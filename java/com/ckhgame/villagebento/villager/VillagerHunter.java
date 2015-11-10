package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerHunter extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Hunter";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Hunting is fun!";
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
        compBuy.addItemBuy(Items.bow, 1, 1, 0);
        compBuy.addItemBuy(Items.arrow, 1, 99, 0);
        compBuy.addItemBuy(Items.leather, 1, 3, 0);
        compBuy.addItemBuy(Items.porkchop, 1, 2, 0);
        compBuy.addItemBuy(Items.beef, 1, 2, 0);
        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Items.stick, 8, 12, 0);
        compSell.addItemSell(Items.feather, 5, 8, 0);
        compSell.addItemSell(Items.bread, 1, 3, 0);

        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Hunting a deer?");
		villagerChat.add(0, "Go wild!");
		villagerChat.add(0, "Need some arrows?");
		
	}

	@Override
	public String getSkinName() {
		return "hunter";
	}

}
