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
		
		EntityVBVillager v = (EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(villagerEntityID);
		
		//(EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).entity
		int villagerID = ((EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(villagerEntityID)).dataVillagerID;
		
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);
		int villagerProfession = dvr.profession;
		String villagerName = dvr.name;
		String villagerSkin = dvr.skin;
		
		return new Object[]{villagerID,villagerProfession,villagerName,villagerSkin,villagerEntityID};
	}

	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		int villagerID = (int)info[0];
		int villagerProfession = (int)info[1];
		String villagerName = (String)info[2];
		String villagerSkin = (String)info[3];
		int villagerEntityID = (int)info[4];
		
		buf.writeInt(villagerID);
		buf.writeInt(villagerProfession);
		ByteBufUtils.writeUTF8String(buf,villagerName);
		ByteBufUtils.writeUTF8String(buf,villagerSkin);
		buf.writeInt(villagerEntityID);

	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

		int villagerID = buf.readInt();
		int villagerProfession = buf.readInt();
		String villagerName = ByteBufUtils.readUTF8String(buf);
		String villagerSkin = ByteBufUtils.readUTF8String(buf);
		int villagerEntityID = buf.readInt();
		
		return new Object[]{villagerID,villagerProfession,villagerName,villagerSkin,villagerEntityID};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int villagerID = (int)result[0];
		int villagerProfession = (int)result[1];
		String villagerName = (String)result[2];
		String villagerSkin = (String)result[3];
		int villagerEntityID = (int)result[4];
		
		EntityVBVillager evr = (EntityVBVillager)Minecraft.getMinecraft().theWorld.getEntityByID(villagerEntityID);
		
		evr.initVillager(villagerID,villagerName, villagerSkin, villagerProfession);
	}

}
