package com.ckhgame.villagebento.util.village;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class PlayerMsg {
	public static void send(EntityPlayer player,String text){
		player.addChatMessage(new ChatComponentText("[to " + player.getDisplayName() + "]: " + text));
	}
}
