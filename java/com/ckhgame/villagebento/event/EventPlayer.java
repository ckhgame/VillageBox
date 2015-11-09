package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.config.ConfigVillage;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.PlayerMsg;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class EventPlayer {
	
	@SubscribeEvent
    public void itemPickupEvent(EntityItemPickupEvent event) {
		//if we pickup the village currency, we have to make sure that the player onlyhave  one current itemstack in the inventory
        if (event.item.getEntityItem().getItem() == ModItems.itemVillageCurrency){
        	HelperDataVrComp.addCurrency(event.entityPlayer, event.item.getEntityItem().getItemDamage());
        	event.item.getEntityItem().stackSize = 0;
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
    }
	
	@SubscribeEvent
    public void fillBucketEvent(FillBucketEvent event) {
		
		DataVillageBento dataVB = DataVillageBento.get();
		
		for(DataVillage dv : dataVB.mapDataVillage.values()){
			if(HelperDataVB.isInVillage(dv,event.target.blockX,event.target.blockZ)){
				for(DataBuilding db : dv.mapDataBuilding.values()){
					if(HelperDataVB.inInBuilding(db,event.target.blockX,event.target.blockY,event.target.blockZ)){
						PlayerMsg.send(event.entityPlayer, "Bukkets are not allowed here....");
						event.setCanceled(true);
						return;
					}
				}
			}
		}
    }
}
