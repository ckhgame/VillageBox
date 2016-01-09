package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionProBaker extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Professional Baker";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Advance level Baker";
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
        compBuy.addItem(ModItems.itemAppleCandy, 0);
        compBuy.addItem(ModItems.itemCornChips, 0);
        compBuy.addItem(ModItems.itemMayonaise, 0);
        compBuy.addItem(Items.cake, 0);
        compBuy.addItem(ModItems.itemCarrotCake, 0);
        compBuy.addItem(Items.pumpkin_pie, 0);
        compBuy.addItem(ModItems.itemHambuger, 0);
        compBuy.addItem(ModItems.itemUdon, 0);
        compBuy.addItem(ModItems.itemPorkRamen, 0);
        compBuy.addItem(ModItems.itemCongee, 0);
        compBuy.addItem(ModItems.itemNoodleSoup, 0);



        components.add(compBuy);

	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Wanna some warm food?");
		villagerChat.add(0, "Are you hungury?");
		villagerChat.add(0, "Got somthing delicious!");
		
	}

	@Override
	public String getSkinName() {
		return "probaker";
	}
	
}
