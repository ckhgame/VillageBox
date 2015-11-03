package com.ckhgame.villagebento.event;

import com.ckhgame.villagebento.config.ConfigPlayerVBProperty;
import com.ckhgame.villagebento.player.PlayerVBProperty;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class EventEntityPlayerConstructing {
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			player.registerExtendedProperties(ConfigPlayerVBProperty.KeyPlayerVBProperty, new PlayerVBProperty());
		}
	}
}
