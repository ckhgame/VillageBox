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
 * 1.villageEntityID (int)
 */
public class ActionInitVillager extends Action {
	
	@Override
	public void onClientSend(ByteBuf buf, Object[] info) {
		int villagerEntityID = (int)info[0];
		buf.writeInt(villagerEntityID);
	}

	@Override
	public Object[] onServerReceived(ByteBuf buf) {
		int villagerEntityID = buf.readInt();
		return new Object[]{villagerEntityID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerEntityID = (int)info[0];
		
		//(EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).entity
		int villagerID = ((EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(villagerEntityID)).dataVillagerID;
		
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);
		
		dvr.cacheEntityVillagerID = villagerEntityID;
		
		int villagerProfession = dvr.profession;
		String villagerName = dvr.name;
		
		//init on server side as well
		EntityVBVillager evr = (EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(villagerEntityID);
		evr.initVillager(villagerID,villagerName, villagerProfession);
		
		return new Object[]{villagerID,villagerProfession,villagerName,villagerEntityID};
	}

	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		int villagerID = (int)info[0];
		int villagerProfession = (int)info[1];
		String villagerName = (String)info[2];
		int villagerEntityID = (int)info[3];
		
		buf.writeInt(villagerID);
		buf.writeInt(villagerProfession);
		ByteBufUtils.writeUTF8String(buf,villagerName);
		buf.writeInt(villagerEntityID);

	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

		int villagerID = buf.readInt();
		int villagerProfession = buf.readInt();
		String villagerName = ByteBufUtils.readUTF8String(buf);
		int villagerEntityID = buf.readInt();
		
		return new Object[]{villagerID,villagerProfession,villagerName,villagerEntityID};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int villagerID = (int)result[0];
		int villagerProfession = (int)result[1];
		String villagerName = (String)result[2];
		int villagerEntityID = (int)result[3];
		
		EntityVBVillager evr = (EntityVBVillager)Minecraft.getMinecraft().theWorld.getEntityByID(villagerEntityID);
		
		evr.initVillager(villagerID,villagerName, villagerProfession);
	}

}
