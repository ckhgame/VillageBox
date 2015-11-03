package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (int)
 */
public class ActionDoVillagerChat extends Action {
	
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
	public void onServerSend(ByteBuf buf, Object[] info) {
	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {	
		return null;
	}


	@Override
	public void onActionCompleted(Object[] result) {

	}

}
