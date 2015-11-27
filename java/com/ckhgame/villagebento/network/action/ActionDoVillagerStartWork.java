package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * 
 * @author ckhgame
 * params & return
 * see ActionSyncVillagerComp
 * 
 * sync params
 * workIdx
 */
public class ActionDoVillagerStartWork extends ActionSyncVillagerComp {

	@Override
	protected void onSyncParamsSend(ByteBuf buf, Object[] params) {
		int workIdx = (Integer)params[0];
		buf.writeInt(workIdx);
	}

	@Override
	protected Object[] onSyncParamsReceived(ByteBuf buf) {
		int workIdx = buf.readInt();
		return new Object[]{workIdx};
	}

	@Override
	protected VBCompResult onResolveSync(EntityVBVillager villager, VillagerComponent component, EntityPlayer player,Object[] params) {
		int workIdx = (Integer)params[0];
		return ((VillagerCompWork)component).startWork(workIdx, player);
	}
	
}
