package com.ckhgame.villagebento.network.msghandler;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequestS2C;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponseS2C;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHandlerVillageActionRequestS2C implements IMessageHandler<MessageVillageActionRequestS2C,IMessage> {

	@Override
	public IMessage onMessage(MessageVillageActionRequestS2C message, MessageContext ctx) {
		
		//received info from the client
		Object[] info = message.info;
		Action action = message.action;
		
		//resolve request
		info = action.resolveRequest(info);
		
		//send result back to the client in a new message
		MessageVillageActionResponseS2C msgback = new MessageVillageActionResponseS2C();
		msgback.info = info;
		msgback.action = action;
		
		return msgback;
	}
	
}
