package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.entity.villager.EntityVBGuard;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;

public class ProfessionSoldier extends Profession {

	@Override
	public String getProfessionName() {
		
		return StatCollector.translateToLocal("villager.soldier.name");
	}

	@Override
	public String getProfessionDescription() {
		
		return StatCollector.translateToLocal("villager.soldier.description");
	}
	
	@Override
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBGuard.class;
	}
	
	@Override
	public boolean canSpawn() {
		
		return true;
	}

	
	
	@Override
	public void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager) {

        components.add(new VillagerCompAbout(villager));
        
        VillagerCompWork compWork = new VillagerCompWork(villager);
        int workIdx;
        workIdx = compWork.createWork("Protect our homeland!", "Get somthing to prove..",0 , 18, 28);
        compWork.addWorkOutput(workIdx, Items.rotten_flesh, 7, 12);
        
       
        components.add(compWork);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, StatCollector.translateToLocal("villager.soldier.chat0"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.soldier.chat1"));
		villagerChat.add(0, StatCollector.translateToLocal("villager.soldier.chat2"));
		
	}

	@Override
	public String getSkinName() {
		return "soldier";
	}
	
	@Override
	protected void setTimeSchedule(){	
		timeSchedule.setSleeptime(new  RangeInt(6,14));
	}

}
