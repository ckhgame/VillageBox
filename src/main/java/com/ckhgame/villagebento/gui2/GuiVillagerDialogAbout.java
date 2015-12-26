package com.ckhgame.villagebento.gui2;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;

public class GuiVillagerDialogAbout extends GuiVillagerDialog{

	private static final int ButtonID_Story = 0;
	private static final int ButtonID_Upgrade = 1;
	private static final int ButtonID_OpenHours = 2;
	private static final int ButtonID_Back = 3;
	
	private static final int ContentID_Story = 0;
	private static final int ContentID_Upgrade = 1;
	private static final int ContentID_OpenHours = 2;
	
	public GuiVillagerDialogAbout(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.hideCenterContent();
		this.createDialogAbout();
	}
	
	private void createDialogAbout(){
		this.clearAllDialogOptions();
		this.setDialogString("My name is " + this.entityVBVillager.getName());
		this.addDialogOptions(ButtonID_Story, 0, "Your story");
		this.addDialogOptions(ButtonID_Upgrade, 1, "I want to upgrade you");
		this.addDialogOptions(ButtonID_OpenHours, 3, "Your open hours");
		this.addDialogOptions(ButtonID_Back, 2, "Back");
	}
	
	@Override
	protected void drawCenterContent(int centerContentID, int mx, int my, float f) {
		super.drawCenterContent(centerContentID, mx, my, f);
		if(centerContentID == ContentID_Story){
			String text = "My dear owner, Thank you so much for summoning me from the void world, I was a village elder and I will help you to create a nice village!";
			this.drawWrappedString(this.fontRendererObj, text, 
														this.boundCenterContent.getIntX() + 8, this.boundCenterContent.getIntY() + 8, 
														0xFFFFFFFF, this.boundCenterContent.getIntW() - 16);
		}
		else if(centerContentID == ContentID_Upgrade){
			this.drawCenteredString(this.fontRendererObj, "Villager Upgrading", this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntCenterY(), 0xFFFFFF00);
		}
		else if(centerContentID == ContentID_OpenHours){
			this.drawCenteredString(this.fontRendererObj, "Open Hours", this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntCenterY(), 0xFFFFFF00);
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		switch(guiButton.id){
		case ButtonID_Story:
			this.showCenterContent(ContentID_Story);
			break;
		case ButtonID_Upgrade:
			this.showCenterContent(ContentID_Upgrade);
			break;
		case ButtonID_OpenHours:
			this.showCenterContent(ContentID_OpenHours);
			break;
		case ButtonID_Back:
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
			break;
		}
	}
	
}
