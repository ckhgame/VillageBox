package com.ckhgame.villagebento.network.msghandler;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequest;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponse;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHandlerVillageActionRequest implements IMessageHandler<MessageVillageActionRequest,IMessage> {

	@Override
	public IMessage onMessage(MessageVillageActionRequest message, MessageContext ctx) {
		
		//received info from the client
		Object[] info = message.info;
		Action action = message.action;
		
		//resolve request
		info = action.resolveRequest(info);
		
		//send result back to the client in a new message
		MessageVillageActionResponse msgback = new MessageVillageActionResponse();
		msgback.info = info;
		msgback.action = action;
		
		return msgback;
	}
	
}
