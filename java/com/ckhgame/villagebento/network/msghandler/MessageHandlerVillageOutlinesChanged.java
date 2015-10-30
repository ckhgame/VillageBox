package com.ckhgame.villagebento.network.msghandler;

import com.ckhgame.villagebento.event.EventRenderVillageOutlines;
import com.ckhgame.villagebento.network.message.MessageVillageOutlinesChanged;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHandlerVillageOutlinesChanged implements IMessageHandler<MessageVillageOutlinesChanged,IMessage> {

	@Override
	public IMessage onMessage(MessageVillageOutlinesChanged message, MessageContext ctx) {
		
		EventRenderVillageOutlines.getInstance().setVillageOutlines(message.listOutlines);
		
		return null;
	}
	
}
