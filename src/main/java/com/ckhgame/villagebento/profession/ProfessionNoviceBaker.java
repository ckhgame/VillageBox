package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ProfessionNoviceBaker extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.noviceBaker.name");

	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.noviceBaker.description");
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
        compBuy.addItem(Items.bread, 2, 3, 0);
        compBuy.addItem(Items.cookie, 1, 2, 1);
        compBuy.addItem(Items.baked_potato, 2, 3, 1);

        components.add(compBuy);
        
        VillagerCompSell compSell = new VillagerCompSell(villager);
        compSell.addItem(Items.wheat_seeds, 10, 20, 1);
        components.add(compSell);
	}
	
	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.noviceBaker.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.noviceBaker.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.noviceBaker.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "novicebaker";
	}
	
	@Override
	protected void setILevelRequirements() {
		
		this.levelRequirements = new ItemStack[1][];
		
		this.levelRequirements[0] = new ItemStack[]{	new ItemStack(Items.wheat_seeds,16),
																				new ItemStack(Items.milk_bucket,1)};
		
	}
	
}
