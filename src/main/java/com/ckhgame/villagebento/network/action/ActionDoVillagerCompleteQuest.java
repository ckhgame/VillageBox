package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompQuest;
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
 * quest ID
 */
public class ActionDoVillagerCompleteQuest extends ActionSyncVillagerComp {

	@Override
	protected void onSyncParamsSend(ByteBuf buf, Object[] params) {
		int questID = (Integer)params[0];
		buf.writeInt(questID);
	}

	@Override
	protected Object[] onSyncParamsReceived(ByteBuf buf) {
		int questID = buf.readInt();
		return new Object[]{questID};
	}

	@Override
	protected VBCompResult onResolveSync(EntityVBVillager villager, VillagerComponent component, EntityPlayer player,Object[] params) {
		int questID = (Integer)params[0];
		return ((VillagerCompQuest)component).completeQuest(questID, player);
	}
	
}
