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
	@Override
	public void onDrawScreen() {		

		String infoProfession = "Profession: " + this.villager.getProfessionName();
		String infoLevel = "Level: " + this.entityVillager.level;
		String infoExp = "Exp: " + this.entityVillager.exp + " / " + this.villager.getNextLevelExp(this.entityVillager.level);
		String infoProDesction = this.villager.getProfessionDescription();
		
		this.fontRendererObj.drawString(infoProfession, fieldCompLeft + 4,fieldCompTop + 2, 0xFFFFFFFF);
		this.fontRendererObj.drawString(infoLevel, fieldCompLeft + 4,fieldCompTop + 17, 0xFFFFFFFF);
		this.fontRendererObj.drawString(infoExp, fieldCompLeft + 4,fieldCompTop + 32, 0xFFFFFFFF);
		
		this.fontRendererObj.drawString("-------", fieldCompLeft + 4,fieldCompTop + 47, 0xFFAAAAAA);		
		this.drawWrappedString(	this.fontRendererObj,infoProDesction,
								fieldCompLeft+4,fieldCompTop+62,0xFFFFFF66,196);
		
	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		Action.send(ActionGetVillagerLevel.class, new Object[]{this.entityVillager.dataVillagerID,this.entityVillager.getEntityId()});
		setChatContent(this.villager.getVillagerChat().getRandom(this.entityVillager.level));
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateWithData(int data) {
		
	}
	
	
	
}
