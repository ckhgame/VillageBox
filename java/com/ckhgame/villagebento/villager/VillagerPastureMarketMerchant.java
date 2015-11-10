package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class VillagerPastureMarketMerchant extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Pasture Product Merchant";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Sell me your pasture products!";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setExpBase(){
		expBase = 20;
		expE = 3;
	}
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompSell compSell = new VillagerCompSell();
        compSell.addItemSell(Items.feather, 12, 23, 0);
        compSell.addItemSell(Items.string, 12, 23, 0);
        compSell.addItemSell(Items.egg, 8, 12, 0);
        compSell.addItemSell(Blocks.wool, 5, 8, 3);
        compSell.addItemSell(Items.milk_bucket, 5, 8, 5);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Selling somehing new?");
		villagerChat.add(0, "Do you remember feeding your animals?");
		villagerChat.add(0, "What you want to sell to me today?");
		
	}

	@Override
	public String getSkinName() {
		return "pasturemarketmerchant";
	}

}
