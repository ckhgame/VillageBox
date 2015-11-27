package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.util.helper.HelperPlayer;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

/**
 * 
 * @author ckhgame
 * params:
 * 1.entityPlayerID (Integer)
 * 2.dropAmount (Integer)
 */
public class ActionDoDropCoins extends Action {
	
	public ActionDoDropCoins() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int entityPlayerID = (Integer)info[0];
		int dropAmount = (Integer)info[1];
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

		int entityPlayerID = (Integer)info[0];
		int dropAmount = (Integer)info[1];
		
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		
	    HelperPlayer.dropCurrency(entityPlayer, dropAmount);
		
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
