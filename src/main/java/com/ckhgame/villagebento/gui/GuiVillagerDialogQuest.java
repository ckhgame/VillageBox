package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerCompleteQuest;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.village.ItemPrice;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;
import com.ckhgame.villagebento.villagercomponent.VillagerCompQuest;
import com.ckhgame.villagebento.villagercomponent.villagerquest.VillagerQuest;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiVillagerDialogQuest extends GuiVillagerDialog{

	private static final int ButtonID_Complete  = 0;
	private static final int ButtonID_Back = 1;
	
	private static final int ContentID_Quest = 0;
	
	private VillagerCompQuest villagerCompQuest;
	
	public GuiVillagerDialogQuest(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}
	
	@Override
	public void initDialog() {
		this.hideCenterContent();
		this.villagerCompQuest = (VillagerCompQuest)this.entityVBVillager.getVillagerComponent(VillagerCompQuest.class);
		if(villagerCompQuest == null){
			this.setDialogString("Sorry, I don't have any quest for you now..");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
		}
		else{
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompQuest);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		}
	}
	
	@Override
	public boolean updateWithVBCompResult(VBCompResult vbCompResult) {
		if(!super.updateWithVBCompResult(vbCompResult)){
			if(villagerCompQuest.getQuestListCurrent().size() < 1){
				this.setDialogString("Sorry, I don't have any quest for you now..");
				this.clearAllDialogOptions();
				this.addDialogOptions(ButtonID_Back, 0, "Back");
			}
			else{
				this.clearAllDialogOptions();
				this.setDialogString("Yes, I'm just looking someone to help me...");
				this.addDialogOptions(ButtonID_Complete, 0, "Complete the quest");
				this.addDialogOptions(ButtonID_Back, 1, "Back");
				this.showCenterContent(ContentID_Quest);
			}
			return false;
		}
		else{
			if(vbCompResult.vbResult == VBResult.SUCCESS){ //quest completed
				this.setDialogString("Thank you so much!");
				this.hideCenterContent();
				this.clearAllDialogOptions();
				this.addDialogOptions(ButtonID_Back, 0, "Back");
			}
			return true;
		}
	}

	private void createDialogQuest(){
		this.clearAllDialogOptions();
		if(villagerCompQuest == null || villagerCompQuest.getQuestListCurrent().size() < 1){
			this.setDialogString("Sorry, I don't have any quest for you now..");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
		}
		else{	
			this.setDialogString("Yes, I'm just looking someone to help me...");
			this.addDialogOptions(ButtonID_Complete, 0, "Complete the quest");
			this.addDialogOptions(ButtonID_Back, 1, "Back");
		}
	}

	@Override
	protected void drawCenterContent(int centerContentID, int mx, int my, float f) {
		super.drawCenterContent(centerContentID, mx, my, f);
		if(centerContentID == ContentID_Quest){
			VillagerQuest quest = this.villagerCompQuest.getQuestListCurrent().get(0);
			if(quest != null){
				//texts
				this.drawCenteredString(fontRendererObj, quest.title, this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);
				this.drawWrappedString(fontRendererObj, quest.description, this.boundCenterContent.getIntX() + 8,this.boundCenterContent.getIntY() + 24, 0xFFFFFFFF,240);	
				//needs
				this.fontRendererObj.drawString("Need:", this.boundCenterContent.getIntX() + 8,this.boundCenterContent.getIntY() + 80, 0xFFAAAAAA);
				if(this.drawItem(mx, my, this.boundCenterContent.getIntX() + 28,this.boundCenterContent.getIntY() + 100,quest.need)){
					List texts = new ArrayList();
					texts.add(quest.need.getDisplayName());
					this.setMouseHoverTexts(texts);
				}
				//rewards
				this.fontRendererObj.drawString("Reward:", this.boundCenterContent.getIntX() + 128,this.boundCenterContent.getIntY() + 80, 0xFFAAAAAA);
				if(this.drawItem(mx, my, this.boundCenterContent.getIntX() + 148,this.boundCenterContent.getIntY() + 100,quest.reward)){
					List texts = new ArrayList();
					texts.add(quest.reward.getDisplayName());
					this.setMouseHoverTexts(texts);
				}
			}
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		switch(guiButton.id){
		case ButtonID_Back:
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
			break;
		case ButtonID_Complete:
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompQuest);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else{
				VillagerQuest quest = this.villagerCompQuest.getQuestListCurrent().get(0);
				if(quest != null){
					Action.send(ActionDoVillagerCompleteQuest.class, new Object[]{	this.entityVBVillager.getEntityId(),
							compIdx, 
							Minecraft.getMinecraft().thePlayer.getEntityId(),
							new Object[]{quest.id}});
				}
			}
			break;
		}
	}
	
}
