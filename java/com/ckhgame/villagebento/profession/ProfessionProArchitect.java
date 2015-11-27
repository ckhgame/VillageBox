package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

public class ProfessionProArchitect extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Professional Architect";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Get some buidlings.";
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);
        compBuy.addItem(ModBlocks.blockLargeMilitaryCamp, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockLargeTavern, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockLargeHotel, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockLargeCasino, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockLargeBakery, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockFlowerShop, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockPotionStore, 1, 1, 0);
        compBuy.addItem(ModBlocks.blockPlayerFieldLarge, 1, 1, 0);
        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Which place you want to build?");
		villagerChat.add(0, "Let's make some art works on the ground!");
		villagerChat.add(0, "The beauty of engineering!");
		
	}

	@Override
	public String getSkinName() {
		return "proarchitect";
	}

}
