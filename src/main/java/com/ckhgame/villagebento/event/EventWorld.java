package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.util.village.VBDateTime;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

public class EventWorld {
	
	@SubscribeEvent
    public void worldLoadEvent(WorldEvent.Load event) {
		if(!event.world.isRemote && event.world.provider.dimensionId == 0){
			DataVillageBento.init(event.world);
		}
		
		if(event.world.provider.dimensionId == 0){
			VBDateTime.init(event.world);
		}
    }
}
