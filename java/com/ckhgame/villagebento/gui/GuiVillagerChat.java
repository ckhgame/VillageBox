package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerChat;
import com.ckhgame.villagebento.network.action.ActionGetVillagerName;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

public class GuiVillagerChat extends GuiVillager {
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Chat";
	}

	@Override
	public void onDrawScreen() {

		drawRect(this.width / 2 - 83, this.height / 2 - 53, this.width / 2 + 123, this.height / 2 + 53, 0xFF333333);
		drawRect(this.width / 2 - 81, this.height / 2 - 51, this.width / 2 + 121, this.height / 2 + 51, 0xFF111111);
		drawRect(this.width / 2 - 80, this.height / 2 - 50, this.width / 2 + 120, this.height / 2 + 50, 0xFF555555);
		this.drawWrappedString(this.fontRendererObj,"Nice to meet you! ",this.width / 2 - 74,this.height /2 - 45,0xFFFFFFFF,188);
	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		Action.send(ActionDoVillagerChat.class, new Object[]{this.entityVillager.dataVillagerID});
	}

	@Override
	public void onActionPerformed() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
