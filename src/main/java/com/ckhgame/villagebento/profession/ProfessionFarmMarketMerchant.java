package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionFarmMarketMerchant extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.fmMerchant.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.fmMerchant.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.reeds, 12, 22, 0);
        compSell.addItem(Items.wheat, 12, 22, 0);
        compSell.addItem(Items.apple, 5, 9, 0);
        compSell.addItem(Items.carrot, 7, 12, 0, 0);
        compSell.addItem(Items.potato, 7, 12, 0, 0);
        compSell.addItem(Blocks.pumpkin, 5, 7, 0, 0);
        compSell.addItem(Blocks.melon_block, 5, 7, 0, 0);
        compSell.addItem(Items.golden_apple, 1, 3, 0, 0);
        compSell.addItem(Items.golden_carrot, 1, 3, 0, 0);
        compSell.addItem(ModItems.itemCorn, 10, 20, 0);
        compSell.addItem(ModItems.itemChili, 10, 20, 0);
        compSell.addItem(ModItems.itemCabbage, 10, 20, 0);
        compSell.addItem(ModItems.itemGrapes, 10, 20, 0);
        compSell.addItem(ModItems.itemRice, 10, 20, 0);
        compSell.addItem(ModItems.itemSoybeans, 10, 20, 0);
        components.add(compSell);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.fmMerchant.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.fmMerchant.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.fmMerchant.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "farmmarketmerchant";
	}

}
