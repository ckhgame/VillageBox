package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionLibrarian extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Librarian";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Every book gives a new journey.";
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

		villagerChat.add(0, "Book is the most wonderful creature in the world. ");
		villagerChat.add(0, "....");
		villagerChat.add(0, "I love books!");
		
	}

	@Override
	public String getSkinName() {
		return "librarian";
	}

}
