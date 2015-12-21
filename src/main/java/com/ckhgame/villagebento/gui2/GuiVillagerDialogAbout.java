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
	private static final int ButtonID_Back = 2;
	
	private static final int ContentID_Story = 0;
	private static final int ContentID_Upgrade = 1;
	
	public GuiVillagerDialogAbout(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	private void createDialogFirst(){
		this.clearAllDialogOptions();
		this.setDialogString("My name is " + this.entityVBVillager.getName());
		this.addDialogOptions(ButtonID_Story, 0, "Your story");
		this.addDialogOptions(ButtonID_Upgrade, 1, "I want to upgrade you");
		this.addDialogOptions(ButtonID_Back, 2, "Back");
	}
	
	@Override
	protected void initCenterContent() {
		super.initCenterContent();
		this.hideCenterContent();
	}
	
	@Override
	protected void initDialogAndOptions() {
		super.initDialogAndOptions();
		this.createDialogFirst();
	}

	
	
	@Override
	protected void drawCenterContent(int centerContentID) {
		super.drawCenterContent(centerContentID);
		if(centerContentID == ContentID_Story){
			String text = "My dear owner, Thank you so much for summoning me from the void world, I was a village elder and I will help you to create a nice village!";
			this.drawWrappedString(this.fontRendererObj, text, 
														this.boundCenterContent.getIntX(), this.boundCenterContent.getIntY(), 
														0xFFFFFFFF, this.boundCenterContent.getIntW());
		}
		else if(centerContentID == ContentID_Upgrade){
			this.drawCenteredString(this.fontRendererObj, "Villager Upgrading", this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntCenterY(), 0xFFFFFF00);
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
		case ButtonID_Back:
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
			break;
		}
	}
	
	
}
