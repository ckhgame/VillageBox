package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionLibrarian extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.librarian.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.librarian.description");
	}
	
	@Override
	public boolean isMale(){
		return false;
	}
	
	@Override
	public boolean canSpawn() {
		
		return true;
	}
	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));

            VillagerCompBuy compBuy = new VillagerCompBuy(villager);
            compBuy.addItem(Items.paper, 1, 10, 0);
            compBuy.addItem(ModItems.itemCookingBookI, 1, 1, 0);
            compBuy.addItem(ModItems.itemCookingBookII, 1, 1, 0);
            compBuy.addItem(ModItems.itemAnimalBook, 1, 1, 0);
            compBuy.addItem(ModItems.itemPlantBook, 1, 1, 0);
            compBuy.addItem(ModItems.itemBuildingsBook, 1, 1, 0);
            compBuy.addItem(ModItems.itemNPCBook, 1, 1, 0);

            components.add(compBuy);
            

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.librarian.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.librarian.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.librarian.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "librarian";
	}

}
