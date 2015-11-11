package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.building.builder.RestrictionExceptions;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.util.PlayerMsg;

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
				if(isInVillage(dv,event.x,event.z)){
					for(DataBuilding db : dv.mapDataBuilding.values()){
						if(inInBuilding(db,event.x,event.y,event.z)){
							event.result = EnumStatus.OTHER_PROBLEM;
							PlayerMsg.send(event.entityPlayer, "It's not your bed!");
							return;
						}
					}
				}
			}
		}
    }
	
	private boolean isInVillage(DataVillage dv,int x,int z){
		if(	x < dv.cacheVillageBoundary.minX ||
				x > dv.cacheVillageBoundary.maxX ||
				z < dv.cacheVillageBoundary.minZ ||
				z > dv.cacheVillageBoundary.maxZ){
				return false;
			}
			return true;
	}
	
	private boolean inInBuilding(DataBuilding db,int x,int y,int z){
		//if this building filed is in restriction exception list, we just ignore it
		if(RestrictionExceptions.hasBuildingException(db.id))
			return false;
		
		if(	x < db.x - db.sizeX || x > db.x + db.sizeX ||
			z < db.z - db.sizeZ || z > db.z + db.sizeZ ||
			y < db.y - ConfigBuilding.BuildingGroundWorkDepth || y >= db.y + ConfigBuilding.BuildingMaxHeight){
			return false;
		}
		
		return true;
	}
}
