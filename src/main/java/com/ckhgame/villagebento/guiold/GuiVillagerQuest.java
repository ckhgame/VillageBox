package com.ckhgame.villagebento.guiold;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerCompleteQuest;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompQuest;
import com.ckhgame.villagebento.villagercomponent.villagerquest.VillagerQuest;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class GuiVillagerQuest extends GuiVillager {
	
	private final int rowSize = 2;
	
	private VillagerCompQuest villagerCompQuest;
	
	//buttons
	public GuiButton[] buttonRows;
	public GuiButton buttonUp;
	public GuiButton buttonDown;
	
	public GuiButton buttonBack2;
	
	public GuiButton buttonBack1;
	public GuiButton buttonComplete;
	
	int currentIdx = 0;
	
	private int selectedIdx = 0;
	
	private boolean questCompleted = false;
	private boolean showQuestDetails = false;
	private boolean isActionSent = false;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "> Do you need my help?";
	}

	private void drawQuestRow(int left,int top, VillagerQuest quest,int row){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//background
		drawRect(left - 2, top - 2, left + 160 + 2, top + 40 + 2, 0xFF888888);	
		drawRect(left, top, left + 160, top + 40, 0xFF666666);	
		if(quest != null){
			//item name
			fontRendererObj.drawString(quest.title, left + 4, top + 8, 0xFFFFFFAA,true);
			fontRendererObj.drawString(quest.timeLeft + "H Left", left + 30, top + 20, 0xFFDDDDDD);
			
			if(!buttonRows[row].visible)
				buttonRows[row].visible = true;
		}
		else{
			if(buttonRows[row].visible)
				buttonRows[row].visible = false;
		}
		
	}
	
	private void drawQuestCompleted(){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		buttonBack2.visible = true;
		buttonBack1.visible = false;
		buttonComplete.visible = false;
		
		//set row buttons invisible
		for(int i = 0;i<rowSize;i++)
			buttonRows[i].visible = false;
		buttonUp.visible = false;
		buttonDown.visible = false;
		
		this.drawCenteredString(fontRendererObj, "Quest Completed!", fieldCompLeft + 100, fieldCompTop + 12, 0xFFFFFF00);	
		
/*		Work work = this.villagerCompWork.getWork(this.villagerCompWork.workIdx);
		
		this.drawCenteredString(fontRendererObj, "Work Completed!", fieldCompLeft + 100, fieldCompTop + 12, 0xFFFFFF00);	
		fontRendererObj.drawString(work.name, fieldCompLeft + 120, fieldCompTop + 26, 0xFFFFFFAA,true);
		fontRendererObj.drawString("Client: " + this.villagerCompWork.playerName, fieldCompLeft + 120, fieldCompTop + 40, 0xFFFFFFFF);
		fontRendererObj.drawString("Expire in: " + (ConfigVillager.WorkOutputExpirationHours + this.villagerCompWork.hoursLeft) + " h", fieldCompLeft + 120, fieldCompTop + 50, 0xFFFFFFFF,true);
	
		if(this.villagerCompWork.output != null){
			fontRendererObj.drawString(this.villagerCompWork.output.getDisplayName(), fieldCompLeft + 44, fieldCompTop + 40, 0xFFFFFFFF);
			fontRendererObj.drawString(" X " + this.villagerCompWork.output.stackSize, fieldCompLeft + 44, fieldCompTop + 50, 0xFFFFFFFF,true);
		}	
		fontRendererObj.drawString("Outputs:", fieldCompLeft + 12, fieldCompTop + 26, 0xFFFFFFAA,true);
		
		//item icon
		drawRect(fieldCompLeft + 18, fieldCompTop + 38, fieldCompLeft + 42, fieldCompTop + 62, 0xFF000000);
		drawRect(fieldCompLeft + 20, fieldCompTop + 40, fieldCompLeft + 40, fieldCompTop + 60, 0xFFFFFFFF);	
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), this.villagerCompWork.output, fieldCompLeft + 22, fieldCompTop + 42);*/

	}
	
	private void drawQuestList(){
		
		buttonBack2.visible = false;
		buttonBack1.visible = false;
		buttonComplete.visible = false;
		buttonUp.visible = true;
		buttonDown.visible = true;
		
		ArrayList<VillagerQuest> questListCurrent = this.villagerCompQuest.getQuestListCurrent();
		VillagerQuest quest;
		for(int i = 0;i<rowSize;i++){
			quest = (questListCurrent == null || currentIdx + i >= questListCurrent.size())? null : questListCurrent.get(i);
			drawQuestRow(fieldCompLeft + 4,fieldCompTop + 6 + 48 * i,quest,i);
		}
	}
	
	
	
	private void drawQuestDetails(){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//set row buttons invisible
		for(int i = 0;i<rowSize;i++)
			buttonRows[i].visible = false;
		buttonUp.visible = false;
		buttonDown.visible = false;
		buttonBack2.visible = false;
		buttonBack1.visible = true;
		buttonComplete.visible = true;
		
	//	Work work = this.villagerCompWork.getWork(this.villagerCompWork.workIdx);
		
		VillagerQuest quest = this.villagerCompQuest.getQuestListCurrent().get(this.selectedIdx);
		if(quest != null){
			//texts
			this.drawCenteredString(fontRendererObj, quest.title, fieldCompLeft + 100, fieldCompTop + 6, 0xFFFFFF00);
			this.drawWrappedString(fontRendererObj, quest.description, fieldCompLeft + 4, fieldCompTop + 16, 0xFFFFFFFF,192);	
			//needs
			this.fontRendererObj.drawString("Need:", fieldCompLeft + 90, fieldCompTop + 52, 0xFFFFFFFF);
			this.drawItem(fieldCompLeft + 130,fieldCompTop + 44,quest.need);
			//rewards
			this.fontRendererObj.drawString("Reward:", fieldCompLeft + 90, fieldCompTop + 76, 0xFFFFFFFF);
			this.drawItem(fieldCompLeft + 130,fieldCompTop + 68,quest.reward);
		}
	}
	
	@Override
	public void onDrawScreen() {		
		if(this.questCompleted){
			drawQuestCompleted();
		}
		else if(this.showQuestDetails){
			drawQuestDetails();
		}	
		else{
			drawQuestList();
		}
	}

	@Override
	public void onInitGui() {
		setChatContent("Could you do me a favor?");
		this.villagerCompQuest = (VillagerCompQuest)villagerComponent;
		currentIdx = 0;
		
		this.showListScreen();
		
		//assign button ids
		buttonRows = new GuiButton[rowSize];
		for(int i = 0;i<rowSize;i++){
			buttonRows[i] = new GuiButton(compStartButtonID++,fieldCompLeft + 120,fieldCompTop + 16 + 48 * i,40,20,"View");
			this.buttonList.add(buttonRows[i]);
		}
		
		//completed screen
		buttonBack2 = new GuiButton(compStartButtonID++, fieldCompLeft + 80,fieldCompTop + 70,40,20,"Back");
		this.buttonList.add(buttonBack2);
		
		//list screen
		buttonUp = new GuiButton(compStartButtonID++, fieldCompLeft + 170,fieldCompTop + 4,28,20,"prev");
		buttonDown = new GuiButton(compStartButtonID++,fieldCompLeft + 170,fieldCompTop + 76,28,20,"next");
		this.buttonList.add(buttonUp);
		this.buttonList.add(buttonDown);
		
		//details screen
		buttonComplete = new GuiButton(compStartButtonID++, fieldCompLeft + 14,fieldCompTop + 46,50,20,"Complete");
		buttonBack1 = new GuiButton(compStartButtonID++, fieldCompLeft + 14,fieldCompTop + 68,50,20,"Back");
		this.buttonList.add(buttonBack1);
		this.buttonList.add(buttonComplete);
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		
		if(button.id == buttonUp.id){
			currentIdx = Math.max(0, --currentIdx);
		}
		else if(button.id == buttonDown.id){
			int max = this.villagerCompQuest.getQuestListCurrent() == null?0:Math.max(0,this.villagerCompQuest.getQuestListCurrent().size() - 1);
			currentIdx = Math.min(max, ++currentIdx);
		}
		else if(button.id == buttonComplete.id){			
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else{
				VillagerQuest quest = this.villagerCompQuest.getQuestListCurrent().get(selectedIdx);
				if(quest != null){
					Action.send(ActionDoVillagerCompleteQuest.class, new Object[]{	this.entityVBVillager.getEntityId(),
							compIdx, 
							Minecraft.getMinecraft().thePlayer.getEntityId(),
							new Object[]{quest.id}});
				}
			}
		}
		else if(button.id == buttonBack1.id || button.id == buttonBack2.id){
			this.showListScreen();
		}
			
		for(int i = 0;i<rowSize;i++){
			if(button.id == buttonRows[i].id){
				int idx = currentIdx + i;
				if(this.villagerCompQuest.getQuestListCurrent() != null && idx >= 0 && idx < this.villagerCompQuest.getQuestListCurrent().size()){	
					
					this.selectedIdx = idx;
					this.showDetailsScreen();
				}
			}
		}
		
	}
	
	private void showCompletedScreen(){
		this.showQuestDetails = false;
		this.questCompleted = true;
	}
	
	private void showDetailsScreen(){
		this.showQuestDetails = true;
	}
	
	private void showListScreen(){
		this.showQuestDetails = false;
		this.questCompleted = false;
	}

	@Override
	public void onSyncCompleted() {
		
	}

	@Override
	public void updateWithVBCompResult(VBCompResult vbCompResult) {
		// TODO Auto-generated method stub
		super.updateWithVBCompResult(vbCompResult);
		
		if(this.showQuestDetails && VBResult.isSuccess(vbCompResult.vbResult)){
			//if the result is success, then we can move to the completed screen
			this.showCompletedScreen();
		}
	}
	
	
	
}
