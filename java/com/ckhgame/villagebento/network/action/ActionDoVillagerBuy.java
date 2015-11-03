package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (int)
 */
public class ActionDoVillagerBuy extends Action {
	
	@Override
	public void onClientSend(ByteBuf buf, Object[] info) {
		int villagerID = (int)info[0];
		buf.writeInt(villagerID);
	}

	@Override
	public Object[] onServerReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		return new Object[]{villagerID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (int)info[0];
		
		String villagerName = HelperDataVB.findVillagerByID(DataVillageBento.get(), villagerID).name;
		
		
		return new Object[]{villagerName};
	}

	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		String villagerName = (String)info[0];	
		ByteBufUtils.writeUTF8String(buf, villagerName);

	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

		String villagerName;
		villagerName = ByteBufUtils.readUTF8String(buf);
		
		return new Object[]{villagerName};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		String villagerName = (String)result[0];	
		
		System.out.println("Villager Name is :" + villagerName);
	}

}
