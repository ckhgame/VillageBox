package com.ckhgame.villagebento.event;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.builder.RestrictionExceptions;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;
public class EventBlockChanged {
	
	private DataVillageBento dataVB = null;
	
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
		 
		dataVB = DataVillageBento.get();
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(isInVillage(dv,event.x,event.z)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(inInBuilding(db,event.x,event.y,event.z)){
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
		
		dataVB = DataVillageBento.get();
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(isInVillage(dv,event.x,event.z)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(inInBuilding(db,event.x,event.y,event.z)){
						event.setCanceled(true);
						return;
					}
				}
			}
		}
    }
	
	@SubscribeEvent
	public void onExplosionStart(ExplosionEvent.Start event) {		

		dataVB = DataVillageBento.get();
		double x = event.explosion.explosionX;
		double y = event.explosion.explosionY;
		double z = event.explosion.explosionZ;
		double s = event.explosion.explosionSize + 1;
		Vec3 vpos = Vec3.createVectorHelper(x,y,z);
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(isNearVillage(dv,x,z,s)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(isNearBuilding(db,x,y,z,s)){
						event.setCanceled(true);
						return;
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
	
	private boolean isNearVillage(DataVillage dv,double x,double z,double d){
		
		if(	x < dv.cacheVillageBoundary.minX - d ||
			x > dv.cacheVillageBoundary.maxX + d ||
			z < dv.cacheVillageBoundary.minZ - d ||
			z > dv.cacheVillageBoundary.maxZ + d){
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
	
	private boolean isNearBuilding(DataBuilding db,double x,double y,double z,double d){
		//if this building filed is in restriction exception list, we just ignore it
		if(RestrictionExceptions.hasBuildingException(db.id))
			return false;
		
		if(	x < db.x - db.sizeX - d || x > db.x + db.sizeX + d + 1 ||
			z < db.z - db.sizeZ - d || z > db.z + db.sizeZ + d + 1||
			y < db.y - ConfigBuilding.BuildingGroundWorkDepth - d || y >= db.y + ConfigBuilding.BuildingMaxHeight + d + 1){
			return false;
		}
		
		return true;
	}
}
