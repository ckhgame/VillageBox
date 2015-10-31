package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.world.World;

public class EventVillageBentoTick {
	
	private static EventVillageBentoTick instance = null;
	public static EventVillageBentoTick getInstance(){
		if(instance == null)
			instance = new EventVillageBentoTick();
		return instance;
	}
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if(event.side == Side.SERVER){ // only server
			if(event.world.provider.dimensionId == 0) {// only overworld
				updateDeadVillagers(event.world);
			}
		}		 
	}
	
	
	
	//update dead villagers
	
	private boolean deadVillagersUpdated = false;
	
	private void updateDeadVillagers(World world){
		if(!deadVillagersUpdated && world.getWorldTime()%24000 == 0){	
			deadVillagersUpdated = true;
			DataVillageBento dataVB = DataVillageBento.get(world);
			HelperDataVB.stepDeadVillages(dataVB);
		}
		else if(deadVillagersUpdated){
			deadVillagersUpdated = false;
		}

	}
}
