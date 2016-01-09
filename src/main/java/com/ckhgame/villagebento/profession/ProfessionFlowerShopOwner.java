package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;

public class ProfessionFlowerShopOwner extends Profession {

	@Override
	public String getProfessionName() {
		
		return "Flower Shop Owner";
	}

	@Override
	public String getProfessionDescription() {
		
		return "Flower makes you smiling!";
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
        compBuy.addItem(Items.flower_pot, 0);
        compBuy.addItem(ModBlocks.blockSunflower, 0);
        compBuy.addItem(ModBlocks.blockPeacefulGarden, 0);
        compBuy.addItem(ModBlocks.blockTeaChair, 0);
        compBuy.addItem(ModBlocks.blockAutumnGarden, 0);
        compBuy.addItem(ModBlocks.blockRoseBridge, 0);
        compBuy.addItem(ModBlocks.blockRosePath, 0);
        compBuy.addItem(ModBlocks.blockChristmas, 0);
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
