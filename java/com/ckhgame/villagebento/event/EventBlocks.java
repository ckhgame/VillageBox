package com.ckhgame.villagebento.event;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;

public class EventBlocks {
	
	private ArrayList<Block> blockWhiteList = null;
	private void initBlockWhiteList(){
		if(blockWhiteList != null)
			return;
		blockWhiteList = new ArrayList<Block>();
		blockWhiteList.add(ModBlocks.blockBuildingScanner);
		blockWhiteList.add(ModBlocks.blockBuildingDestroyer);
	}
	private boolean isInWhiteList(Block block){
		initBlockWhiteList();
		return blockWhiteList.contains(block);
	}
	
	 @SubscribeEvent
    public void blockPlaceEvent(BlockEvent.PlaceEvent event)
    {	 
		if(isInWhiteList(event.block))
			return;
		 
		DataVillageBento dataVB = DataVillageBento.get();
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(HelperDataVB.isInVillage(dv,event.x,event.z)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(HelperDataVB.inInBuilding(db,event.x,event.y,event.z)){
						event.setCanceled(true);
						return;
					}
				}
			}
		}
    }
	
	@SubscribeEvent
    public void blockBreakEvent(BlockEvent.BreakEvent event)
    {
		if(isInWhiteList(event.block))
			return;
		
		DataVillageBento dataVB = DataVillageBento.get();
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(HelperDataVB.isInVillage(dv,event.x,event.z)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(HelperDataVB.inInBuilding(db,event.x,event.y,event.z)){
						event.setCanceled(true);
						return;
					}
				}
			}
		}
    }
	
	@SubscribeEvent
	public void onExplosionStart(ExplosionEvent.Start event) {		

		DataVillageBento dataVB = DataVillageBento.get();
		double x = event.explosion.explosionX;
		double y = event.explosion.explosionY;
		double z = event.explosion.explosionZ;
		double s = event.explosion.explosionSize + 1;
		Vec3 vpos = Vec3.createVectorHelper(x,y,z);
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(HelperDataVB.isNearVillage(dv,x,z,s)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(HelperDataVB.isNearBuilding(db,x,y,z,s)){
						event.setCanceled(true);
						return;
					}
				}
			}
		}
	}
	
	
	
	
	
	
}
