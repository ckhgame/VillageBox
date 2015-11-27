package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
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
 * ItemStack itemBuy
 */
public class ActionDoVillagerBuy extends ActionSyncVillagerComp {

	@Override
	protected void onSyncParamsSend(ByteBuf buf, Object[] params) {
		ItemStack itemBuy = (ItemStack)params[0];
		ByteBufUtils.writeItemStack(buf, itemBuy);
	}

	@Override
	protected Object[] onSyncParamsReceived(ByteBuf buf) {
		ItemStack itemBuy = ByteBufUtils.readItemStack(buf);
		return new Object[]{itemBuy};
	}

	@Override
	protected VBCompResult onResolveSync(EntityVBVillager villager, VillagerComponent component, EntityPlayer player,Object[] params) {
		ItemStack itemBuy = (ItemStack)params[0];
		return ((VillagerCompBuy)component).buyItem(player, itemBuy);
	}
	
}
