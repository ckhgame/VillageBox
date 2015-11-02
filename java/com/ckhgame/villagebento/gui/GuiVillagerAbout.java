package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionGetVillagerLevel;
import com.ckhgame.villagebento.network.action.ActionGetVillagerName;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

public class GuiVillagerAbout extends GuiVillager {
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "General";
	}
	float pos;
	@Override
	public void onDrawScreen() {

		drawRect(this.width / 2 - 83, this.height / 2 - 53, this.width / 2 + 123, this.height / 2 + 53, 0xFF333333);
		drawRect(this.width / 2 - 81, this.height / 2 - 51, this.width / 2 + 121, this.height / 2 + 51, 0xFF111111);
		drawRect(this.width / 2 - 80, this.height / 2 - 50, this.width / 2 + 120, this.height / 2 + 50, 0xFF555555);
		
		if(pos > 0) pos -= pos * 0.1f;
		
		//if(!isWaitingForActionResult)
			this.drawWrappedString(	this.fontRendererObj,
									"this is a villager, level:" + this.entityVillager.level + ", exp:" + this.entityVillager.exp,
									this.width / 2 - 74,this.height /2 - 45 + (int)pos,0xFFFFFF66,188);
		
	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		pos = 20;
		GuiVillager.ActionStart();
		Action.send(ActionGetVillagerLevel.class, new Object[]{this.entityVillager.dataVillagerID,this.entityVillager.getEntityId()});
	}

	@Override
	public void onActionPerformed() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
