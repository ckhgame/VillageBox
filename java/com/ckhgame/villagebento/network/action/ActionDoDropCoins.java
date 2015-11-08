package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

/**
 * 
 * @author ckhgame
 * params:
 * 1.entityPlayerID (int)
 * 2.dropAmount (int)
 */
public class ActionDoDropCoins extends Action {
	
	public ActionDoDropCoins() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int entityPlayerID = (int)info[0];
		int dropAmount = (int)info[1];
		buf.writeInt(entityPlayerID);
		buf.writeInt(dropAmount);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int entityPlayerID = buf.readInt();
		int dropAmount = buf.readInt();
		return new Object[]{entityPlayerID,dropAmount};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int entityPlayerID = (int)info[0];
		int dropAmount = (int)info[1];
		
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		
	    HelperDataVrComp.dropCurrency(entityPlayer, dropAmount);
		
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
