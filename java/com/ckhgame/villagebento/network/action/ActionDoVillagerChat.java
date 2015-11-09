package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (Integer)
 */
public class ActionDoVillagerChat extends Action {
	
	public ActionDoVillagerChat() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int villagerID = (Integer)info[0];
		buf.writeInt(villagerID);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		return new Object[]{villagerID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (Integer)info[0];
		
		DataVillageBento dataVB = DataVillageBento.get();	
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);
				
		dvr.exp += 1;
		if(dvr.exp > 10){
			dvr.exp = 0;
			dvr.level++;
		}
		
		dataVB.markDirty();
		
		return null;
	}

	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {	
		return null;
	}


	@Override
	public void onActionCompleted(Object[] result) {

	}

}
