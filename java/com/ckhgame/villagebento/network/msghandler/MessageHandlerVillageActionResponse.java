package com.ckhgame.villagebento.network.msghandler;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponse;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHandlerVillageActionResponse implements IMessageHandler<MessageVillageActionResponse,IMessage> {

	@Override
	public IMessage onMessage(MessageVillageActionResponse message, MessageContext ctx) {
		
		Object[] result = message.info;
		Action action = message.action;
		
		action.onActionCompleted(result);
		
		return null;
	}
	
}
