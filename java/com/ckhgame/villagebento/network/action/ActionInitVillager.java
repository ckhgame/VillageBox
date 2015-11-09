package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villageEntityID (Integer)
 */
public class ActionInitVillager extends Action {
	
	public ActionInitVillager() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int villagerEntityID = (Integer)info[0];
		buf.writeInt(villagerEntityID);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int villagerEntityID = buf.readInt();
		return new Object[]{villagerEntityID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerEntityID = (Integer)info[0];
		
		//(EntityVBVillager)MinecraftTarget.getTarget().worldTargetForDimension(0).entity
		int villagerID = ((EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(villagerEntityID)).dataVillagerID;
		
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);
		
		dvr.cacheEntityVillagerID = villagerEntityID;
		
		int villagerProfession = dvr.profession;
		String villagerName = dvr.name;
		
		//init on Target side as well
		EntityVBVillager evr = (EntityVBVillager)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(villagerEntityID);
		evr.initVillager(villagerID,villagerName, villagerProfession);
		
		//sleeping info
		boolean isSleeping = evr.getSleeping();
		int bedX = -1;
		int bedY = -1;
		int bedZ = -1;
		if(isSleeping){
			bedX = (int)evr.bedPosition.xCoord;
			bedY = (int)evr.bedPosition.yCoord;
			bedZ = (int)evr.bedPosition.zCoord;
		}
		
		return new Object[]{villagerID,villagerProfession,villagerName,villagerEntityID,isSleeping,bedX,bedY,bedZ};
	}

	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		
		int villagerID = (Integer)info[0];
		int villagerProfession = (Integer)info[1];
		String villagerName = (String)info[2];
		int villagerEntityID = (Integer)info[3];
		
		boolean isSleeping = (Boolean)info[4];
		int bedX = (Integer)info[5];
		int bedY = (Integer)info[6];
		int bedZ = (Integer)info[7];
		
		buf.writeInt(villagerID);
		buf.writeInt(villagerProfession);
		ByteBufUtils.writeUTF8String(buf,villagerName);
		buf.writeInt(villagerEntityID);
		
		buf.writeBoolean(isSleeping);
		buf.writeInt(bedX);
		buf.writeInt(bedY);
		buf.writeInt(bedZ);

	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {

		int villagerID = buf.readInt();
		int villagerProfession = buf.readInt();
		String villagerName = ByteBufUtils.readUTF8String(buf);
		int villagerEntityID = buf.readInt();
		
		boolean isSleeping = buf.readBoolean();
		int bedX = buf.readInt();
		int bedY = buf.readInt();
		int bedZ = buf.readInt();
		
		return new Object[]{villagerID,villagerProfession,villagerName,villagerEntityID,isSleeping,bedX,bedY,bedZ};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int villagerID = (Integer)result[0];
		int villagerProfession = (Integer)result[1];
		String villagerName = (String)result[2];
		int villagerEntityID = (Integer)result[3];
		
		boolean isSleeping = (Boolean)result[4];
		int bedX = (Integer)result[5];
		int bedY = (Integer)result[6];
		int bedZ = (Integer)result[7];
		
		EntityVBVillager evr = (EntityVBVillager)Minecraft.getMinecraft().theWorld.getEntityByID(villagerEntityID);
		
		evr.initVillager(villagerID,villagerName, villagerProfession);
		evr.setSleeping(isSleeping);
		if(isSleeping)
			evr.bedPosition =  Vec3.createVectorHelper(bedX, bedY, bedZ); 
	}

}
