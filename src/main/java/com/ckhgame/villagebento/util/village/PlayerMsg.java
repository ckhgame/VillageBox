package com.ckhgame.villagebento.util.village;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;

public class PlayerMsg {	
	public static void sendTranslation(EntityPlayer player, String unlocalized,Object... params){
		player.addChatMessage(new ChatComponentTranslation(unlocalized, params));
	}
	
	public static void sendToAllTranslation(String unlocalized, Object... params){
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentTranslation(unlocalized, params));
	}
}
