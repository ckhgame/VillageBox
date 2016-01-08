package com.ckhgame.villagebento.gui;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerAction;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;

public class GuiVillagerDialogAction extends GuiVillagerDialog{

	private static final int ButtonID_Action0 = 0;
	private static final int ButtonID_Back = 100;
	private static final int ButtonID_BackFromResult = 101;
	
	private static final int ContentID_ActionResult = 0;
	
	private VillagerCompAction villagerCompAction;
	
	public GuiVillagerDialogAction(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.hideCenterContent();
		this.villagerCompAction = (VillagerCompAction)this.entityVBVillager.getVillagerComponent(VillagerCompAction.class);
		if(this.villagerCompAction == null){ // the villager doesn't have component action
			this.hideCenterContent();
			this.setDialogString("Sorry, I don't have any action...");
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.actionBack"));
		}
		else if(!this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNow()){ // has component buy but is out of open hours now..
			this.hideCenterContent();
			this.setDialogString("Sorry, It's out of my open hours now...");
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.actionBack"));
		}
		else{
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompAction);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		}
	}
	
	private void createDialogActions(){
		
		this.hideCenterContent();
		this.clearAllDialogOptions();
		this.setDialogString("What can I do for you?");
		
		//options
		int[] actionIdxList = this.villagerCompAction.actionIdxListCurrent;
		for(int i =0;i<actionIdxList.length;i++){
			this.addDialogOptions(ButtonID_Action0 + i, i, this.villagerCompAction.getAction(actionIdxList[i]).text);
		}
		this.addDialogOptions(ButtonID_Back, actionIdxList.length, StatCollector.translateToLocal("vbgui.dialogOption.actionBack"));
	}
	
	@Override
	public boolean updateWithVBCompResult(VBCompResult vbCompResult) {
		if(!super.updateWithVBCompResult(vbCompResult)){
			this.createDialogActions();
			return false;
		}
		else{
			this.showCenterContent(ContentID_ActionResult);
			this.addDialogOptions(ButtonID_BackFromResult, 0, StatCollector.translateToLocal("vbgui.dialogOption.actionBack"));
			return true;
		}
	}

	@Override
	protected void drawCenterContent(int centerContentID, int mx, int my, float f) {
		super.drawCenterContent(centerContentID, mx, my, f);
		if(centerContentID == ContentID_ActionResult){
			this.drawCenteredString(fontRendererObj, this.villagerCompAction.resultTitle, this.boundCenterContent.getIntCenterX(), this.boundCenterContent.getIntY()  + 8, 0xFFFFFF00);
			this.drawWrappedString(fontRendererObj, this.villagerCompAction.resultContent, this.boundCenterContent.getIntX() + 8 , this.boundCenterContent.getIntY()  + 24, 0xFFDDDDDD, 240);
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		if(this.villagerCompAction != null){
			int[] actionIdxList = this.villagerCompAction.actionIdxListCurrent;
			for(int i =0;i<actionIdxList.length;i++){
				if(guiButton.id == ButtonID_Action0 + i){
					int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompAction);
					if(compIdx < 0)
						System.out.println("Can not find the village component! idx < 0");
					else{
						Action.send(ActionDoVillagerAction.class, new Object[]{	this.entityVBVillager.getEntityId(),
								compIdx, 
								Minecraft.getMinecraft().thePlayer.getEntityId(),
								new Object[]{i}});
						this.clearAllDialogOptions();
					}
				}
			}
		}
		
		
		if(guiButton.id == ButtonID_Back){
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
		}
		else if(guiButton.id == ButtonID_BackFromResult){
			this.hideCenterContent();
			this.createDialogActions();
		}
	}
	
}
