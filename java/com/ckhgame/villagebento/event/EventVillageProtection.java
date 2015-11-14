package com.ckhgame.villagebento.event;

import java.util.ArrayList;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.config.ConfigVillage;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.util.PlayerMsg;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;

public class EventVillageProtection {
	
	private ArrayList<Block> blockWhiteList = null;
	private void initBlockWhiteList(){
		if(blockWhiteList != null)
			return;
		blockWhiteList = new ArrayList<Block>();
		blockWhiteList.add(ModBlocks.blockBuildingScanner);
		blockWhiteList.add(ModBlocks.blockBuildingDestroyer);
		blockWhiteList.add(ModBlocks.blockVillagerHomeTP);
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
					if(HelperDataVB.isInBuilding(db,event.x,event.y,event.z)){
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
					if(HelperDataVB.isInBuilding(db,event.x,event.y,event.z)){
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
	
	
	@SubscribeEvent
    public void entityInteractEvent(EntityInteractEvent event) {	
		Class c = event.target.getClass();
		if(c == EntityPainting.class || c == EntityItemFrame.class){
			DataVillageBento dataVB = DataVillageBento.get();
			for(DataVillage dv : dataVB.mapDataVillage.values()){
				if(HelperDataVB.isInVillage(dv,(int)event.target.posX,(int)event.target.posZ)){
					for(DataBuilding db : dv.mapDataBuilding.values()){
						if(HelperDataVB.isEntityInBuilding(db,event.target)){
							event.setCanceled(true);
							return;
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
    public void entityAttackEvent(AttackEntityEvent event) {	
		System.out.println("hhh");
		Class c = event.target.getClass();
		if(c == EntityPainting.class || c == EntityItemFrame.class){
			DataVillageBento dataVB = DataVillageBento.get();
			for(DataVillage dv : dataVB.mapDataVillage.values()){
				if(HelperDataVB.isInVillage(dv,(int)event.target.posX,(int)event.target.posZ)){
					for(DataBuilding db : dv.mapDataBuilding.values()){
						if(HelperDataVB.isEntityInBuilding(db,event.target)){
							event.setCanceled(true);
							return;
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
    public void blockInteractEvent(PlayerInteractEvent event) {	
		//can not use 
		ItemStack hold = event.entityPlayer.getHeldItem();
		if(hold!= null && (hold.getItem() == Items.flint_and_steel | hold.getItem() == Items.fire_charge)){
			
			System.out.println(event.world.getBlock( event.x,  event.y,  event.z).getUnlocalizedName());
			
			DataVillageBento dataVB = DataVillageBento.get();
			double x = event.x;
			double y = event.y;
			double z = event.z;
			double s = ConfigVillage.FireProhibitDistance;
			Vec3 vpos = Vec3.createVectorHelper(x,y,z);
			for(DataVillage dv : dataVB.mapDataVillage.values()){
				if(HelperDataVB.isNearVillage(dv,x,z,s)){
					for(DataBuilding db : dv.mapDataBuilding.values()){
						if(HelperDataVB.isNearBuilding(db,x,y,z,s)){
							PlayerMsg.send(event.entityPlayer, "Can not set fire near any village building...");
							event.setCanceled(true);
							return;
						}
					}
				}
			}
		}
		
		else if(hold!= null && (hold.getItem() == Items.painting || hold.getItem() == Items.item_frame)){
			DataVillageBento dataVB = DataVillageBento.get();
			
			for(DataVillage dv : dataVB.mapDataVillage.values()){
				if(HelperDataVB.isInVillage(dv,event.x,event.z)){
					for(DataBuilding db : dv.mapDataBuilding.values()){
						if(HelperDataVB.isInBuilding(db,event.x,event.y,event.z)){
							PlayerMsg.send(event.entityPlayer, "You can't hang it here!");
							event.setCanceled(true);
							return;
						}
					}
				}
			}
		}
    }
	
	@SubscribeEvent
    public void fillBucketEvent(FillBucketEvent event) {
		
		DataVillageBento dataVB = DataVillageBento.get();
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(HelperDataVB.isInVillage(dv,event.target.blockX,event.target.blockZ)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(HelperDataVB.isInBuilding(db,event.target.blockX,event.target.blockY,event.target.blockZ)){
						PlayerMsg.send(event.entityPlayer, "Bukkets are not allowed here....");
						event.setCanceled(true);
						return;
					}
				}
			}
		}
    }
	
	
	
	
}
