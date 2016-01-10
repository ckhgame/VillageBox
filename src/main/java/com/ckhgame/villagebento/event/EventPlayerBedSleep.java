package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
public class EventPlayerBedSleep {
	
	private DataVillageBento dataVB = null;
	
	@SubscribeEvent
    public void onPlayerSleepInBedEvent (PlayerSleepInBedEvent event)
    {
		if(!event.entityPlayer.worldObj.isRemote){
			dataVB = DataVillageBento.get();
			
			for(DataVillage dv : dataVB.mapDataVillage.values()){
				if(HelperDataVB.isInVillage(dv,event.x,event.z)){
					for(DataBuilding db : dv.mapDataBuilding.values()){
						if(HelperDataVB.isInBuilding(db,event.x,event.y,event.z)&&!HelperDataVB.PlayerOwnsBuilding(event.entityPlayer, db)){
							event.result = EnumStatus.OTHER_PROBLEM;
							PlayerMsg.sendTranslation(event.entityPlayer, "villagebento.msg.notMyBed");
							return;
						}
					}
				}
			}
		}
    }
}
