package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (int)
 * 2.villageEntityID (int)
 */
public class ActionGetVillagerLevel extends Action {
	
	@Override
	public void onClientSend(ByteBuf buf, Object[] info) {
		int villagerID = (int)info[0];
		int villagerEntityID = (int)info[1];
		buf.writeInt(villagerID);
		buf.writeInt(villagerEntityID);
	}

	@Override
	public Object[] onServerReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		int villagerEntityID = buf.readInt();
		return new Object[]{villagerID,villagerEntityID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (int)info[0];
		int villagerEntityID = (int)info[1];
		
		DataVillager dvr = HelperDataVB.findVillagerByID(DataVillageBento.get(), villagerID);
		int villagerLevel = dvr.level;
		int villageExp = dvr.exp;
		
		return new Object[]{villagerLevel,villageExp,villagerEntityID};
	}

	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		int villagerLevel = (int)info[0];
		int villageExp = (int)info[1];
		int villagerEntityID = (int)info[2];
		
		buf.writeInt(villagerLevel);
		buf.writeInt(villageExp);
		buf.writeInt(villagerEntityID);

	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

		int villagerLevel = buf.readInt();
		int villageExp = buf.readInt();
		int villagerEntityID = buf.readInt();
		
		return new Object[]{villagerLevel,villageExp,villagerEntityID};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int villagerLevel = (int)result[0];
		int villageExp = (int)result[1];
		int villagerEntityID = (int)result[2];
		
		EntityVBVillager evr = (EntityVBVillager)Minecraft.getMinecraft().theWorld.getEntityByID(villagerEntityID);
		evr.level = villagerLevel;
		evr.exp = villageExp;
	}

}
