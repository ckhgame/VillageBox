package ckhbox.villagebento.common.network;

import ckhbox.villagebento.common.network.message.MessageGuiVillagerOpen;
import ckhbox.villagebento.common.network.message.MessageGuiSelectTradeRecipeIndex;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ModNetwork {
	
	//singleton
	private static SimpleNetworkWrapper instance;
	public static SimpleNetworkWrapper getInstance(){
		return instance;
	}
	
	public static void init(){
		instance = NetworkRegistry.INSTANCE.newSimpleChannel("netvlgbto");
		initMessages();
	}
	
	private static void initMessages(){
		int id = 0;
		instance.registerMessage(MessageGuiVillagerOpen.Handler.class, MessageGuiVillagerOpen.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiSelectTradeRecipeIndex.Handler.class, MessageGuiSelectTradeRecipeIndex.class, id++, Side.SERVER);
	}
}
