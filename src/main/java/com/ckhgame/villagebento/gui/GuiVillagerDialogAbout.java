package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerUpgrade;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.data.VillagerSchedule;
import com.ckhgame.villagebento.util.village.VBDataTime;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;

public class GuiVillagerDialogAbout extends GuiVillagerDialog{

	private static final int ButtonID_Story = 0;
	private static final int ButtonID_CheckUpgrade = 1;
	private static final int ButtonID_Upgrade = 2;
	private static final int ButtonID_OpenHours = 3;
	private static final int ButtonID_Back = 4;
	private static final int ButtonID_BackUpgrade = 5;
	
	private static final int ContentID_Story = 0;
	private static final int ContentID_Upgrade = 1;
	private static final int ContentID_OpenHours = 2;
	
	private VillagerCompAbout villagerCompAbout;
	
	public GuiVillagerDialogAbout(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.hideCenterContent();
		this.villagerCompAbout = (VillagerCompAbout)this.entityVBVillager.getVillagerComponent(VillagerCompAbout.class);
		if(this.villagerCompAbout == null){ // the villager doesn't have component about
			this.hideCenterContent();
			this.setDialogString("Sorry, I don't have a about page....."); //this should never happen because every villager must have an about component!
			this.addDialogOptions(ButtonID_Back, 0, "Back");
		}
		else{
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompAbout);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		}
	}
	
	private void createDialogAbout(){
		this.clearAllDialogOptions();
		this.setDialogString("My name is " + this.entityVBVillager.getName());
		this.addDialogOptions(ButtonID_Story, 0, "Your story");
		this.addDialogOptions(ButtonID_CheckUpgrade, 1, "I want to upgrade you");
		this.addDialogOptions(ButtonID_OpenHours, 3, "Your open hours");
		this.addDialogOptions(ButtonID_Back, 2, "Back");
	}
	
	private void createDialogUpgrade(){
		this.clearAllDialogOptions();
		int btnIdx = 0;
		this.addDialogOptions(ButtonID_Upgrade, btnIdx++, "Upgrade");
		this.addDialogOptions(ButtonID_BackUpgrade, btnIdx++, "Back");
	}
	
	
	@Override
	public boolean updateWithVBCompResult(VBCompResult vbCompResult) {
		if(!super.updateWithVBCompResult(vbCompResult)){
			this.createDialogAbout();
			return false;
		}
		else{
			if(this.getCentercontentID() == ContentID_Upgrade && vbCompResult.vbResult == VBResult.SUCCESS){
				this.createDialogUpgrade();
			}
			return true;
		}
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
			this.drawCenteredString(this.fontRendererObj, "Villager Upgrading", this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);
			ItemStack[] requirements = this.entityVBVillager.getProfession().getNextLevelRequirements(this.entityVBVillager.getLevel());
			this.drawCenteredString(this.fontRendererObj, "Requirements:", this.boundCenterContent.getIntCenterX(), this.boundCenterContent.getIntY() + 24, 0xFFFFFF00);
			if(requirements != null){
				int dx = - 32 * requirements.length / 2;
				for(int i = requirements.length - 1;i>=0;i--){ // to prevent the tool tip from being under others...rendering it from right to left 
					if(this.drawItem(mx,my,this.boundCenterContent.getIntCenterX() + 6 + dx + i * 32, this.boundCenterContent.getIntY() + 36, requirements[i])){
						List texts = new ArrayList();
						texts.add(requirements[i].getDisplayName());
						this.setMouseHoverTexts(texts);
					}
				}
			}
			else{
				this.drawCenteredString(this.fontRendererObj, "Already reached the max level", this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntCenterY() - 8, 0xFFFFFFFF);
			}
		}
		else if(centerContentID == ContentID_OpenHours){
			this.drawCenteredString(this.fontRendererObj, "Open Hours", this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);
			String[] worktimes = this.entityVBVillager.getProfession().getTimeSchedule().getWorkTimeText();
			String[] weekdays = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
			//this.drawCenteredString(this.fontRendererObj, "--Hours--", fieldCompLeft + 100,fieldCompTop + 8, 0xFFFFFFEE);
			for(int i =0;i<worktimes.length;i++){
				int c = 0xFFEEEEEE;
				int today = VBDataTime.getDayInWeek();
				int prev = today == 0?6:today - 1; 
				int h =VBDataTime.getHourOfDay();
				if(i == today || i == prev){
					int result = this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNowResult();
					if(result == VillagerSchedule.YesToday && i ==today ||result == VillagerSchedule.YesYesterday && i == prev){
						c = 0xFF99FF99;
					}
					
					if(result == VillagerSchedule.No && i == today){
						c = 0xFFFF9999;
					}
				}
				
				this.fontRendererObj.drawString(weekdays[i], this.boundCenterContent.getIntCenterX() - 70,this.boundCenterContent.getIntY() + 24 + i * 12 , 0xFFFFFFAA);	
				this.fontRendererObj.drawString(worktimes[i], this.boundCenterContent.getIntCenterX() + 10,this.boundCenterContent.getIntY() + 24 + i * 12 , c);		
			}
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		switch(guiButton.id){
		case ButtonID_Story:
			this.showCenterContent(ContentID_Story);
			break;
		case ButtonID_CheckUpgrade:
			this.showCenterContent(ContentID_Upgrade);
			this.createDialogUpgrade();
			break;
		case ButtonID_OpenHours:
			this.showCenterContent(ContentID_OpenHours);
			break;
		case ButtonID_Upgrade:
			if( this.entityVBVillager.getProfession().getNextLevelRequirements(this.entityVBVillager.getLevel()) != null){
				//upgrade
				int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompAbout);
				if(compIdx < 0)
					System.out.println("Can not find the village component! idx < 0");
				else
					Action.send(ActionDoVillagerUpgrade.class, new Object[]{	this.entityVBVillager.getEntityId(),
																			compIdx, 
																			Minecraft.getMinecraft().thePlayer.getEntityId(),
																			null});
			}
			break;
		case ButtonID_BackUpgrade:
			this.hideCenterContent();
			this.createDialogAbout();
			break;
		case ButtonID_Back:
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
			break;
		}
	}
	
}
