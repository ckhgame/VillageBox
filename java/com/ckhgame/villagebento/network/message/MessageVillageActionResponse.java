package com.ckhgame.villagebento.network.message;

import com.ckhgame.villagebento.network.action.Action;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class MessageVillageActionResponse implements IMessage {

	public Action action;
	public Object[] info;
	
	public void toBytes(ByteBuf buf) {
		buf.writeInt(action.getActionID());
		action.onServerSend(buf, info);
	}
	
	public void fromBytes(ByteBuf buf) {
		int aid = buf.readInt();
		action = Action.registry.get(aid);
		info = action.onClientReceived(buf);
	}

}
