package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionFurnitureSeller extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.furnitureseller.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.furnitureseller.description");
	}

	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompBuy compBuy = new VillagerCompBuy(villager);

        compBuy.addItem(Blocks.bookshelf, 0);
        compBuy.addItem(Items.bed, 0);
        compBuy.addItem(Blocks.chest, 0);
        compBuy.addItem(ModBlocks.blockWineBucket, 0);
        compBuy.addItem(ModBlocks.blockWineShelf, 0);
        compBuy.addItem(ModBlocks.blockOakChair, 0);
        compBuy.addItem(ModBlocks.blockBirchChair, 0);
        compBuy.addItem(ModBlocks.blockOakTable, 0);
        compBuy.addItem(ModBlocks.blockBirchTable, 0);
        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.furnitureseller.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.furnitureseller.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.furnitureseller.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "furnitureseller";
	}

}
