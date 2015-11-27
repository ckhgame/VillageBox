package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.helper.HelperPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class EventPlayer {
	
	@SubscribeEvent
    public void itemPickupEvent(EntityItemPickupEvent event) {
		//if we pickup the village currency, we have to make sure that the player onlyhave  one current itemstack in the inventory
        if (event.item.getEntityItem().getItem() == ModItems.itemVillageCurrency){
        	HelperPlayer.addCurrency(event.entityPlayer, event.item.getEntityItem().getItemDamage());
        	event.item.getEntityItem().stackSize = 0;
        }
    }
}
