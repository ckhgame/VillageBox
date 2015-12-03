package com.ckhgame.villagebento.network.msghandler;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponseC2S;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHandlerVillageActionResponseC2S implements IMessageHandler<MessageVillageActionResponseC2S,IMessage> {

	@Override
	public IMessage onMessage(MessageVillageActionResponseC2S message, MessageContext ctx) {
		
		Object[] result = message.info;
		Action action = message.action;
		
		action.onActionCompleted(result);
		
		return null;
	}
	
}
