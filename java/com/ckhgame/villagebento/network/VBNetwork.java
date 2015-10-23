package com.ckhgame.villagebento.network;

import com.ckhgame.villagebento.config.ConfigNetwork;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class VBNetwork {
	public static SimpleNetworkWrapper networkWrapper = null;
	public static void create(){
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ConfigNetwork.VillageBentoNetworkChannelID);
	}
}
