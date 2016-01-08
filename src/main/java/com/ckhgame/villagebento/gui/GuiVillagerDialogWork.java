package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerAction;
import com.ckhgame.villagebento.network.action.ActionDoVillagerStartWork;
import com.ckhgame.villagebento.network.action.ActionDoVillagerTakeWorkOutput;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.village.ItemPrice;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork.Work;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;

public class GuiVillagerDialogWork extends GuiVillagerDialog{

	private static final int ButtonID_Work0 = 0;
	private static final int ButtonID_TakeResult = 100;
	private static final int ButtonID_Back = 101;
	
	private static final int ContentID_Working = 0;
	private static final int ContentID_WorkResult = 1;
	
	private VillagerCompWork villagerCompWork;
	
	public GuiVillagerDialogWork(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.hideCenterContent();
		this.villagerCompWork = (VillagerCompWork)this.entityVBVillager.getVillagerComponent(VillagerCompWork.class);
		if(this.villagerCompWork == null){ // the villager doesn't have component work
			this.hideCenterContent();
			this.setDialogString("Sorry, I don't have any work...");
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.workBack"));
		}
		else if(!this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNow()){ // has component buy but is out of open hours now..
			this.hideCenterContent();
			this.setDialogString("Sorry, It's out of my open hours now...");
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.workBack"));
		}
		else{
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompWork);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		}
	}
	
	private void createDialogWork(){
		
		if(this.villagerCompWork.workIdx >= 0 && this.villagerCompWork.hoursLeft > 0){ // is working
			this.showCenterContent(this.ContentID_Working);
			this.clearAllDialogOptions();
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.workBack"));
		}
		else if(this.villagerCompWork.workIdx >= 0 && this.villagerCompWork.hoursLeft <= 0){ // is waiting for taking
			this.showCenterContent(this.ContentID_WorkResult);
			this.clearAllDialogOptions();
			this.addDialogOptions(ButtonID_TakeResult, 0, StatCollector.translateToLocal("vbgui.dialogOption.workTakeResult"));
			this.addDialogOptions(ButtonID_Back, 1, StatCollector.translateToLocal("vbgui.dialogOption.workBack"));
		}
		else if(this.villagerCompWork.workIdx < 0){ //is open for new work
			this.hideCenterContent();
			this.clearAllDialogOptions();
			this.setDialogString("What can I do for you?");
			
			//options
			int[] workIdxList = this.villagerCompWork.workIdxListCurrent;
			Work work;
			for(int i =0;i<workIdxList.length;i++){
				work = this.villagerCompWork.getWork(workIdxList[i]);
				this.addDialogOptions(ButtonID_Work0 + i, i, work.name + "(" + work.price + " g)");
			}		

			this.addDialogOptions(ButtonID_Back, workIdxList.length, StatCollector.translateToLocal("vbgui.dialogOption.workBack"));
		}		
	}
	
	@Override
	public boolean updateWithVBCompResult(VBCompResult vbCompResult) {
		boolean b = super.updateWithVBCompResult(vbCompResult);
		this.createDialogWork();
		return b;
	}

	@Override
	protected void drawCenterContent(int centerContentID, int mx, int my, float f) {
		super.drawCenterContent(centerContentID, mx, my, f);
		if(centerContentID == ContentID_Working){
			Work work = this.villagerCompWork.getWork(this.villagerCompWork.workIdx);
			
			this.drawCenteredString(fontRendererObj, "Is Working...", this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);	
			this.drawCenteredString(fontRendererObj,work.name, this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 36, 0xFFFFFFEE);
			this.drawCenteredString(fontRendererObj,work.remark, this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 50, 0xFFAAAAAA);
			this.drawCenteredString(fontRendererObj,"Client: " + this.villagerCompWork.playerName,this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 64, 0xFFFFFFFF);
			this.drawCenteredString(fontRendererObj,"Hours Left: " + this.villagerCompWork.hoursLeft, this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 78, 0xFFFFFFFF);
		}
		else if(centerContentID == ContentID_WorkResult){
			Work work = this.villagerCompWork.getWork(this.villagerCompWork.workIdx);
			
			this.drawCenteredString(fontRendererObj, "Work Completed!", this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);	
			this.drawCenteredString(fontRendererObj, work.name,  this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 36, 0xFFFFFFAA);
			this.drawCenteredString(fontRendererObj,"Client: " + this.villagerCompWork.playerName,  this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 50, 0xFFFFFFFF);
			this.drawCenteredString(fontRendererObj,"Expire in: " + (ConfigVillager.WorkOutputExpirationHours + this.villagerCompWork.hoursLeft) + " h",  this.boundCenterContent.getIntCenterX(),  this.boundCenterContent.getIntY() + 64, 0xFFFFFFFF);
		
			if(this.villagerCompWork.output != null){
				if(this.drawItem(mx, my, this.boundCenterContent.getIntCenterX() - 12,  this.boundCenterContent.getIntY() + 78, this.villagerCompWork.output)){
					List texts = new ArrayList();
					texts.add(this.villagerCompWork.output.getDisplayName());
					this.setMouseHoverTexts(texts);
				}
			}	
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		if(this.villagerCompWork != null &&  this.villagerCompWork.workIdxListCurrent != null){
			int[] workIdxList = this.villagerCompWork.workIdxListCurrent;
			for(int i =0;i<workIdxList.length;i++){
				if(guiButton.id == ButtonID_Work0 + i){
					int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompWork);
					if(compIdx < 0)
						System.out.println("Can not find the village component! idx < 0");
					else{
						Action.send(ActionDoVillagerStartWork.class, new Object[]{	this.entityVBVillager.getEntityId(),
								compIdx, 
								Minecraft.getMinecraft().thePlayer.getEntityId(),
								new Object[]{this.villagerCompWork.workIdxListCurrent[i]}});
						this.clearAllDialogOptions();
					}
				}
			}
		}
		
		
		if(guiButton.id == ButtonID_Back){
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
		}
		else if(guiButton.id == ButtonID_TakeResult){
			this.hideCenterContent();
			this.clearAllDialogOptions();
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompWork);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionDoVillagerTakeWorkOutput.class, new Object[]{	this.entityVBVillager.getEntityId(),
																		compIdx, 
																		Minecraft.getMinecraft().thePlayer.getEntityId(),
																		null});
		}
	}
	
}
