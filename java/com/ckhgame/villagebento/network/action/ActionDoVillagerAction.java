package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerAction;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * 
 * @author ckhgame
 * params & return
 * see ActionSyncVillagerComp
 * 
 * sync params
 * see villager actions
 */
public class ActionDoVillagerAction extends ActionSyncVillagerComp {

	@Override
	protected void onSyncParamsSend(ByteBuf buf, Object[] params) {
		int actionIdx = (Integer)params[0];
		buf.writeInt(actionIdx);
	}

	@Override
	protected Object[] onSyncParamsReceived(ByteBuf buf) {
		int actionIdx = buf.readInt();
		return new Object[]{actionIdx};
	}

	@Override
	protected VBCompResult onResolveSync(EntityVBVillager villager, VillagerComponent component, EntityPlayer player, Object[] params) {
		int actionIdx = (Integer) params[0];
		VillagerAction va = ((VillagerCompAction) component).getAction(actionIdx);
		if (va != null) {
			return va.doAction(player, villager, (VillagerCompAction) component, va.vaParams);
		} else {
			return VBCompResult.getDefaultFailed();
		}
	}
	
}
