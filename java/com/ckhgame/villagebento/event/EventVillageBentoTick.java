package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;

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
	
	private long lastTick = -1;
	private long currentTick = -1;
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if(event.side == Side.SERVER && event.world.provider.dimensionId == 0){ // only server			
			currentTick = event.world.getWorldTime();			
			if(currentTick > lastTick){
				if(currentTick % 1000 == 0){
					updateByHour(event.world,((int)(currentTick / 1000) + 6)%24);
				}
			}			
			lastTick = currentTick;
		}		 
	}
	
	/**
	 * be careful!! the hour in the param is NOT the game world time
	 * it has been +6 hours in order to fit the feeling in the real world 
	 * etc:
	 * 0:00 in the game world is the moment of sun raising, which is usually 6:00 in the real world
	 */
	private void updateByHour(World world,int hour){
		//System.out.println("DUANG! " + hour + ":00 !");
		updateDeadVillagers(world,hour);
		updateVillagerBuyAndSellList(world,hour);
	}
	
	//--------------------------------------
	//update dead villagers
	
	private void updateDeadVillagers(World world,int hour){
		if(hour == 6){
			DataVillageBento dataVB = DataVillageBento.get(world);
			HelperDataVB.stepDeadVillages(dataVB);
		}
	}
	
	//--------------------------------------
	//update villagers' buy list
	private void updateVillagerBuyAndSellList(World world,int hour){	
		if(hour == 6){
			DataVillageBento dataVB = DataVillageBento.get();		
			for(DataVillage dv : dataVB.mapDataVillage.values()){
				for(DataVillager dvr : dv.mapDataVillager.values()){
					HelperDataVrComp.refreshBuyList(dvr);
					HelperDataVrComp.refreshSellList(dvr);
				}
			}
		}	
	}
	
	//--------------------------------------
	//update villagers' sell list
}
