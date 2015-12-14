package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.VBVillagerMgr;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.tool.VBRandom;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.world.World;

public class EventVillageBentoTick {
	
	private static EventVillageBentoTick instance = null;
	public static EventVillageBentoTick getInstance(){
		if(instance == null)
			instance = new EventVillageBentoTick();
		return instance;
	}
	
	private int lastHours = -1;
	private int currentHours = -1;
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if(!event.world.isRemote && event.world.provider.dimensionId == 0){ // only server and the overworld dimension					
			
			currentHours = (int)(event.world.getWorldTime() / 1000);
			if(lastHours != -1 && currentHours > lastHours){ 			
				for(int h = lastHours + 1;h<= currentHours;h++){
					updateByTime(h%24);
				}
			}
			lastHours = currentHours;
		}		 
	}
	
	
	/**
	 * !! time == 0 is the time of sun raising....
	 */
	private void updateByTime(int time){
		updateVillagerByTime(time);
		updateDeadVillagers(time);
		updateTraveler(time);
	}
	
	//--------------------------------------
	//update dead villagers
	
	private void updateDeadVillagers(int time){
		if(time == 0){
			DataVillageBento dataVB = DataVillageBento.get();
			HelperDataVB.stepDeathAll(dataVB);
		}
	}
	
	//--------------------------------------
	//update villagers' buy and sell list
	private void updateVillagerByTime(int time){
		for(EntityVBVillager villager : VBVillagerMgr.get().getVillagers()){
			villager.updateVillagerComponentsByTime(time);
		}
	}
	
	//update travellers
	private void updateTraveler(int time){
		
		VBVillagerMgr.get().updateTravelers();
		
		if(VBRandom.getRand().nextInt(24) == 0){
			VBVillagerMgr.get().spawnRandomTravelers();
		}
	}
}
