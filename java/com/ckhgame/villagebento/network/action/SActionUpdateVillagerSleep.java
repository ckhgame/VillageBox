package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.Vec3;

/**
 * 
 * @author ckhgame
 * params:
 * 1.enttiyVillagerID (Integer)
 * 2.isSleeping
 */
public class SActionUpdateVillagerSleep extends Action {
	
	public SActionUpdateVillagerSleep() {
		super(false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int enttiyVillagerID = (Integer)info[0];
		boolean isSleeping = (Boolean)info[1];
		int bedX = (Integer)info[2];
		int bedY = (Integer)info[3];
		int bedZ = (Integer)info[4];
		buf.writeInt(enttiyVillagerID);
		buf.writeBoolean(isSleeping);
		buf.writeInt(bedX);
		buf.writeInt(bedY);
		buf.writeInt(bedZ);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int enttiyVillagerID = buf.readInt();
		boolean isSleeping = buf.readBoolean();
		int bedX = buf.readInt();
		int bedY = buf.readInt();
		int bedZ = buf.readInt();
		return new Object[]{enttiyVillagerID,isSleeping,bedX,bedY,bedZ};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int enttiyVillagerID = (Integer)info[0];
		boolean isSleeping = (Boolean)info[1];
		int bedX = (Integer)info[2];
		int bedY = (Integer)info[3];
		int bedZ = (Integer)info[4];
		
		WorldClient wc = Minecraft.getMinecraft().theWorld;
		if(wc.provider.dimensionId == 0){
			EntityVBVillager evr = (EntityVBVillager)wc.getEntityByID(enttiyVillagerID);
			if(evr != null){
				evr.setSleeping(isSleeping);
				evr.bedPosition = Vec3.createVectorHelper(bedX, bedY, bedZ);
			}
		}
		
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
