package com.ckhgame.villagebento.network.msghandler;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequestC2S;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponseC2S;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHandlerVillageActionRequestC2S implements IMessageHandler<MessageVillageActionRequestC2S,IMessage> {

	@Override
	public IMessage onMessage(MessageVillageActionRequestC2S message, MessageContext ctx) {
		
		//received info from the client
		Object[] info = message.info;
		Action action = message.action;
		
		//resolve request
		info = action.resolveRequest(info);
		
		//send result back to the client in a new message
		MessageVillageActionResponseC2S msgback = new MessageVillageActionResponseC2S();
		msgback.info = info;
		msgback.action = action;
		
		return msgback;
	}
	
}
