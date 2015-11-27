package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author ckhgame
 * params & return
 * see ActionSyncVillagerComp
 * 
 * sync params
 * ItemStack itemSell
 */
public class ActionDoVillagerSell extends ActionSyncVillagerComp {

	@Override
	protected void onSyncParamsSend(ByteBuf buf, Object[] params) {
		ItemStack itemSell = (ItemStack)params[0];
		ByteBufUtils.writeItemStack(buf, itemSell);
	}

	@Override
	protected Object[] onSyncParamsReceived(ByteBuf buf) {
		ItemStack itemSell = ByteBufUtils.readItemStack(buf);
		return new Object[]{itemSell};
	}

	@Override
	protected VBCompResult onResolveSync(EntityVBVillager villager, VillagerComponent component, EntityPlayer player,Object[] params) {
		ItemStack itemSell = (ItemStack)params[0];
		return ((VillagerCompSell)component).sellItem(player, itemSell);
	}
	
}
