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
	
	private int lastHours = -1;
	private int currentHours = -1;
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if(!event.world.isRemote && event.world.provider.dimensionId == 0){ // only server and the overworld dimension					
			currentHours = (int)(event.world.getWorldTime() / 1000);
			if(currentHours > lastHours){ 			
				for(int h = lastHours + 1;h<= currentHours;h++){
					updateByHour(event.world,h%24);
				}
			}
			lastHours = currentHours;
		}		 
	}
	
	
	/**
	 * !! hour%24 == 0 is the time of sun raising....
	 */
	private void updateByHour(World world,int hour){
		System.out.println("DUANG! " + hour + ":00 !");
		updateDeadVillagers(world,hour);
		updateVillagerBuyAndSellList(world,hour);
		updateVillageWorks(world,hour);
	}
	
	//--------------------------------------
	//update dead villagers
	
	private void updateDeadVillagers(World world,int hour){
		if(hour == 0){
			DataVillageBento dataVB = DataVillageBento.get(world);
			HelperDataVB.stepDeadVillages(dataVB);
			dataVB.markDirty();
		}
	}
	
	//--------------------------------------
	//update villagers' buy and sell list
	private void updateVillagerBuyAndSellList(World world,int hour){	
		if(hour == 0){
			DataVillageBento dataVB = DataVillageBento.get();		
			for(DataVillage dv : dataVB.mapDataVillage.values()){
				for(DataVillager dvr : dv.mapDataVillager.values()){
					HelperDataVrComp.refreshBuyList(dvr);
					HelperDataVrComp.refreshSellList(dvr);
				}
			}
			dataVB.markDirty();
		}	
	}
	
	//--------------------------------------
	//update villagers' work
	private void updateVillageWorks(World world,int hour){	
		DataVillageBento dataVB = DataVillageBento.get();		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			for(DataVillager dvr : dv.mapDataVillager.values()){
				HelperDataVrComp.refreshWork(dvr);
			}
		}	
		dataVB.markDirty();
	}
}
