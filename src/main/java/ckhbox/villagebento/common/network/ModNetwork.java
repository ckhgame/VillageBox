package ckhbox.villagebento.common.network;

import ckhbox.villagebento.common.network.message.MessageGuiActionPerformed;
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
		instance.registerMessage(MessageGuiActionPerformed.Handler.class, MessageGuiActionPerformed.class, 0, Side.SERVER);
	}
}
