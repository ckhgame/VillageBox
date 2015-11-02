package com.ckhgame.villagebento.network;

import com.ckhgame.villagebento.config.ConfigNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequest;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponse;
import com.ckhgame.villagebento.network.message.MessageVillageOutlinesChanged;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageActionRequest;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageActionResponse;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageOutlinesChanged;

import cpw.mods.fml.relauncher.Side;

public class ModMessages {
	
	public static void init(){
		//create network
		VBNetwork.create();
		
		//register messages
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageOutlinesChanged.class, MessageVillageOutlinesChanged.class, ConfigNetwork.MessageIDVillageOutlinesChanged, Side.CLIENT);
	
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageActionRequest.class, MessageVillageActionRequest.class, ConfigNetwork.MessageIDVillageActionRequest, Side.SERVER);
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageActionResponse.class, MessageVillageActionResponse.class, ConfigNetwork.MessageIDVillageActionResponse, Side.CLIENT);
	}
}
