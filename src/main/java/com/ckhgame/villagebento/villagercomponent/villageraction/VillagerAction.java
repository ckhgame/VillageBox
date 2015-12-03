package com.ckhgame.villagebento.villagercomponent.villageraction;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;

import net.minecraft.entity.player.EntityPlayer;

/**
 * only a int argument and a string argument are provided
 */
public abstract class VillagerAction {
	
	public VillagerAction(String text, int minLevel, Object[] vaParams){
		this.text = text;
		this.minLevel = minLevel;
		this.vaParams = vaParams;
	}
	
	public String text;
	public Object[] vaParams;
	public int minLevel;
	
	public abstract VBCompResult doAction(EntityPlayer player, EntityVBVillager villager, VillagerCompAction component, Object[] vaParams);
}
