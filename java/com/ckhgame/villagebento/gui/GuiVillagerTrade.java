package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionGetVillagerName;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

public class GuiVillagerTrade extends GuiVillager {
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Trade";
	}

	@Override
	public void onDrawScreen() {

		this.drawGradientRect(this.width / 2 - 103, this.height / 2 - 53, this.width / 2 + 103, this.height / 2 + 53, 0xFF333333,0xFF111111);
		
		//drawRect(this.width / 2 - 103, this.height / 2 - 53, this.width / 2 + 103, this.height / 2 + 53, 0xFF333333);
		//drawRect(this.width / 2 - 101, this.height / 2 - 51, this.width / 2 + 101, this.height / 2 + 51, 0xFF111111);
		//drawRect(this.width / 2 - 100, this.height / 2 - 50, this.width / 2 + 100, this.height / 2 + 50, 0xFF555555);
		this.drawWrappedString(this.fontRendererObj,"Nothing to trade with you now :(",this.width / 2 - 94,this.height /2 - 45,0xFFFFFFFF,188);
		
	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		Action.send(ActionGetVillagerName.class, new Object[]{this.entityVillager.getDataVillagerID()});
		
	}

	@Override
	public void onActionPerformed() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
