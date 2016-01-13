package com.ckhgame.villagebento.gui;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerAction;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerAction;

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
			this.setDialogString(StatCollector.translateToLocal("vbgui.dialogString.actionNoAction"));
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.actionBack"));
		}
		else if(!this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNow()){ // has component buy but is out of open hours now..
			this.hideCenterContent();
			this.setDialogString(StatCollector.translateToLocal("vbgui.dialogString.actionOutOpenHours"));
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
		this.setDialogString(StatCollector.translateToLocal("vbgui.dialogString.actionNextAction"));
		
		//options
		VillagerAction action;
		for(int i =0;i<this.villagerCompAction.getActionListSize();i++){
			action = this.villagerCompAction.getAction(i);
			boolean available = this.villagerCompAction.isActionAvailable(action);
			this.addDialogOptions(ButtonID_Action0 + i, i, StatCollector.translateToLocal(action.text),available, available?StatCollector.translateToLocal(action.info):(StatCollector.translateToLocal("vbgui.common.needLevel") + (action.minLevel + 1)));
		}
		this.addDialogOptions(ButtonID_Back, this.villagerCompAction.getActionListSize(), StatCollector.translateToLocal("vbgui.dialogOption.actionBack"));
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
			this.drawWrappedString(fontRendererObj, this.villagerCompAction.getTranslatedResultContent(), this.boundCenterContent.getIntX() + 8 , this.boundCenterContent.getIntY()  + 24, 0xFFDDDDDD, 240);
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		if(this.villagerCompAction != null){
			for(int i =0;i<this.villagerCompAction.getActionListSize();i++){
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
