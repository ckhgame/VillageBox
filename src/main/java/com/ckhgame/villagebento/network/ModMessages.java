package com.ckhgame.villagebento.network;

import com.ckhgame.villagebento.config.ConfigNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequestC2S;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequestS2C;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponseC2S;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponseS2C;
import com.ckhgame.villagebento.network.message.MessageVillageOutlinesChanged;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageActionRequestC2S;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageActionRequestS2C;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageActionResponseC2S;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageActionResponseS2C;
import com.ckhgame.villagebento.network.msghandler.MessageHandlerVillageOutlinesChanged;

import cpw.mods.fml.relauncher.Side;

public class ModMessages {
	
	public static void init(){
		//create network
		VBNetwork.create();
		
		//register messages
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageOutlinesChanged.class, MessageVillageOutlinesChanged.class, ConfigNetwork.MessageIDVillageOutlinesChanged, Side.CLIENT);
		
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageActionRequestC2S.class, MessageVillageActionRequestC2S.class, ConfigNetwork.MessageIDVillageActionRequestC2S, Side.SERVER);
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageActionResponseC2S.class, MessageVillageActionResponseC2S.class, ConfigNetwork.MessageIDVillageActionResponseC2S, Side.CLIENT);
		
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageActionRequestS2C.class, MessageVillageActionRequestS2C.class, ConfigNetwork.MessageIDVillageActionRequestS2C, Side.CLIENT);
		VBNetwork.networkWrapper.registerMessage(MessageHandlerVillageActionResponseS2C.class, MessageVillageActionResponseS2C.class, ConfigNetwork.MessageIDVillageActionResponseS2C, Side.SERVER);
	}
}
