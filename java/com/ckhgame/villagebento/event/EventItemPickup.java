package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.item.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class EventItemPickup {
	
	@SubscribeEvent
    public void itemPickupEvent(EntityItemPickupEvent event) {
		//if we pickup the village currency, we have to make sure that the player onlyhave  one current itemstack in the inventory
        if (event.item.getEntityItem().getItem() == ModItems.itemVillageCurrency){
        	HelperDataVrComp.addCurrency(event.entityPlayer, event.item.getEntityItem().getItemDamage());
        	event.item.getEntityItem().stackSize = 0;
        }
    }
}
