package com.ckhgame.villagebento.network.msghandler;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponseS2C;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHandlerVillageActionResponseS2C implements IMessageHandler<MessageVillageActionResponseS2C,IMessage> {

	@Override
	public IMessage onMessage(MessageVillageActionResponseS2C message, MessageContext ctx) {
		
		Object[] result = message.info;
		Action action = message.action;
		
		action.onActionCompleted(result);
		
		return null;
	}
	
}
