package com.ckhgame.villagebento.gui2;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;

public class GuiVillagerDialogMenu extends GuiVillagerDialog{

	private static final int ButtonID_About = 0;
	private static final int ButtonID_Trade = 1;
	private static final int ButtonID_Quest = 2;
	private static final int ButtonID_Action = 3;
	private static final int ButtonID_Work = 4;
	private static final int ButtonID_Leave = 5;
	private static final int ButtonID_Back = 6;
	private static final int ButtonID_Buy = 7;
	private static final int ButtonID_Sell = 8;
	
	public GuiVillagerDialogMenu(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.hideCenterContent();
		this.createDialogMain();
	}

	private void createDialogMain(){
		this.clearAllDialogOptions();
		this.setDialogString("Hi, How is going");
		this.addDialogOptions(ButtonID_About, 0, "Tell me about you");
		this.addDialogOptions(ButtonID_Trade, 1, "I want to trade with you");
		this.addDialogOptions(ButtonID_Quest, 2, "Can I help you?");
		this.addDialogOptions(ButtonID_Action, 3, "Actions...");
		this.addDialogOptions(ButtonID_Work, 4, "please work for me");
		this.addDialogOptions(ButtonID_Leave, 5, "Bye bye!");
	}
	
	private void createDialogTrade(){
		this.clearAllDialogOptions();
		this.setDialogString("Glad to trade with you");
		this.addDialogOptions(ButtonID_Buy, 0, "I want to buy");
		this.addDialogOptions(ButtonID_Sell, 1, "I want to sell");
		this.addDialogOptions(ButtonID_Back, 2, "Back");
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		switch(guiButton.id){
		case ButtonID_About:
			this.mc.displayGuiScreen(new GuiVillagerDialogAbout(this.entityVBVillager));
			break;
		case ButtonID_Trade:
			this.createDialogTrade();
			break;
		case ButtonID_Buy:
			this.mc.displayGuiScreen(new GuiVillagerDialogBuy(this.entityVBVillager));
			break;
		case ButtonID_Sell:
			this.mc.displayGuiScreen(new GuiVillagerDialogSell(this.entityVBVillager));
			break;
		case ButtonID_Quest:
			this.mc.displayGuiScreen(new GuiVillagerDialogQuest(this.entityVBVillager));
			break;
		case ButtonID_Action:
			this.mc.displayGuiScreen(new GuiVillagerDialogAction(this.entityVBVillager));
			break;
		case ButtonID_Leave:
			this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
			break;
		case ButtonID_Back:
			this.createDialogMain();
			break;
		}
	}
	
}
