package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionGetVillagerName;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

public class GuiVillagerSell extends GuiVillager {
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Sell";
	}

	@Override
	public void onDrawScreen() {
		//this.drawWrappedString(this.fontRendererObj,"Nothing to trade with you now :(",this.width / 2 - 74,this.height /2 - 45,0xFFFFFFFF,188);
		
	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		Action.send(ActionGetVillagerName.class, new Object[]{this.entityVillager.dataVillagerID});
		setChatContent("Do you have any of these?");
	}

	@Override
	public void onActionPerformed() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
