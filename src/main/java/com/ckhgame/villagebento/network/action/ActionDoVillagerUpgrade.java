package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author ckhgame
 * params & return
 * see ActionSyncVillagerComp
 * 
 * sync params
 */
public class ActionDoVillagerUpgrade extends ActionSyncVillagerComp {

	@Override
	protected VBCompResult onResolveSync(EntityVBVillager villager, VillagerComponent component, EntityPlayer player,Object[] params) {
		return ((VillagerCompAbout)component).upgradeLevel(player);
	}
	
}
