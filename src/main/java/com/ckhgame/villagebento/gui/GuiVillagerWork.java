package com.ckhgame.villagebento.gui;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerStartWork;
import com.ckhgame.villagebento.network.action.ActionDoVillagerTakeWorkOutput;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork.Work;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiVillagerWork extends GuiVillager {
	
	private final int rowSize = 2;
	
	private VillagerCompWork villagerCompWork;
	
	//buttons
	public GuiButton[] buttonRows;
	public GuiButton buttonUp;
	public GuiButton buttonDown;
	public GuiButton buttonTake;
	
	int currentIdx = 0;
	
	@Override
	public String getButtonText() {
		return "> Can you work for me?";
	}

	private void drawWorkRow(int left,int top, Work work,int row){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//background
		drawRect(left - 2, top - 2, left + 160 + 2, top + 40 + 2, 0xFF888888);	
		drawRect(left, top, left + 160, top + 40, 0xFF666666);	
		if(work != null){
			//item name
			fontRendererObj.drawString(work.name, left + 4, top + 4, 0xFFFFFFAA,true);
			fontRendererObj.drawString(work.remark, left + 4, top + 14, 0xFFDDDDDD);
			String priceAndHours = "price:" + work.price + ", hours:" + work.hours;
			fontRendererObj.drawString(priceAndHours, left + 4, top + 28, 0xFFFFFFDD,true);
			
			if(!buttonRows[row].visible)
				buttonRows[row].visible = true;
		}
		else{
			if(buttonRows[row].visible)
				buttonRows[row].visible = false;
		}
		
	}
	
	private void drawWaitingForTakingOutput(){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//set take button to visible
		buttonTake.visible = true;
		
		//set row buttons invisible
		for(int i = 0;i<rowSize;i++)
			buttonRows[i].visible = false;
		buttonUp.visible = false;
		buttonDown.visible = false;
		
		Work work = this.villagerCompWork.getWork(this.villagerCompWork.workIdx);
		
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
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), this.villagerCompWork.output, fieldCompLeft + 22, fieldCompTop + 42);

	}
	
	private void drawWaitingForNextWork(){
		
		buttonTake.visible = false;
		buttonUp.visible = true;
		buttonDown.visible = true;
		
		int[] workIdxList = this.villagerCompWork.workIdxListCurrent;
		Work work;
		for(int i = 0;i<rowSize;i++){
			work = (workIdxList == null || currentIdx + i >= workIdxList.length)? null : this.villagerCompWork.getWork(workIdxList[currentIdx + i]);
			drawWorkRow(fieldCompLeft + 4,fieldCompTop + 6 + 48 * i,work,i);
		}
	}
	
	private void drawIsWorking(){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//set row buttons invisible
		for(int i = 0;i<rowSize;i++)
			buttonRows[i].visible = false;
		buttonUp.visible = false;
		buttonDown.visible = false;
		buttonTake.visible = false;
		
		Work work = this.villagerCompWork.getWork(this.villagerCompWork.workIdx);
		
		this.drawCenteredString(fontRendererObj, "Is Working...", fieldCompLeft + 100, fieldCompTop + 12, 0xFFFFFF00);	
		this.drawCenteredString(fontRendererObj,work.name, fieldCompLeft + 100, fieldCompTop + 30, 0xFFFFFFEE);
		this.drawCenteredString(fontRendererObj,work.remark, fieldCompLeft + 100, fieldCompTop + 40, 0xFFAAAAAA);
		this.drawCenteredString(fontRendererObj,"Client: " + this.villagerCompWork.playerName, fieldCompLeft + 100, fieldCompTop + 60, 0xFFFFFFFF);
		this.drawCenteredString(fontRendererObj,"Hours Left: " + this.villagerCompWork.hoursLeft, fieldCompLeft + 100, fieldCompTop + 70, 0xFFFFFFFF);
	}
	
	@Override
	public void onDrawScreen() {
		
		if(false){ // no data
			for(int i = 0;i<rowSize;i++)
				buttonRows[i].visible = false;
			buttonUp.visible = false;
			buttonDown.visible = false;
			buttonTake.visible = false;
		}
		else if(this.villagerCompWork.workIdx >= 0 && this.villagerCompWork.hoursLeft > 0)
			drawIsWorking();
		else if(this.villagerCompWork.workIdx >= 0 && this.villagerCompWork.hoursLeft <= 0)
			drawWaitingForTakingOutput();
		else if(this.villagerCompWork.workIdx < 0)
			drawWaitingForNextWork();
		
	}

	@Override
	public void onInitGui() {
		setChatContent("Can I help you?");
		this.villagerCompWork = (VillagerCompWork)villagerComponent;
		currentIdx = 0;
		
		//assign button ids
		buttonRows = new GuiButton[rowSize];
		for(int i = 0;i<rowSize;i++){
			buttonRows[i] = new GuiButton(compStartButtonID++,fieldCompLeft + 120,fieldCompTop + 16 + 48 * i,40,20,"Start");
			this.buttonList.add(buttonRows[i]);
		}
		
		buttonTake = new GuiButton(compStartButtonID++, fieldCompLeft + 80,fieldCompTop + 70,40,20,"Take");
		this.buttonList.add(buttonTake);
		
		buttonUp = new GuiButton(compStartButtonID++, fieldCompLeft + 170,fieldCompTop + 4,28,20,"prev");
		buttonDown = new GuiButton(compStartButtonID++ + 1,fieldCompLeft + 170,fieldCompTop + 76,28,20,"next");
		this.buttonList.add(buttonUp);
		this.buttonList.add(buttonDown);
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		
		if(button.id == buttonUp.id){
			currentIdx = Math.max(0, --currentIdx);
		}
		else if(button.id == buttonDown.id){
			int max = this.villagerCompWork.workIdxListCurrent == null?0:Math.max(0,this.villagerCompWork.workIdxListCurrent.length - 1);
			currentIdx = Math.min(max, ++currentIdx);
		}
		else if(button.id == buttonTake.id){
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionDoVillagerTakeWorkOutput.class, new Object[]{	this.entityVBVillager.getEntityId(),
																		compIdx, 
																		Minecraft.getMinecraft().thePlayer.getEntityId(),
																		null});
		}
			
		for(int i = 0;i<rowSize;i++){
			if(button.id == buttonRows[i].id){
				int idx = currentIdx + i;
				if(this.villagerCompWork.workIdxListCurrent != null && idx >= 0 && idx < this.villagerCompWork.workIdxListCurrent.length){				
					int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
					if(compIdx < 0)
						System.out.println("Can not find the village component! idx < 0");
					else
						Action.send(ActionDoVillagerStartWork.class, new Object[]{	this.entityVBVillager.getEntityId(),
																				compIdx, 
																				Minecraft.getMinecraft().thePlayer.getEntityId(),
																				new Object[]{this.villagerCompWork.workIdxListCurrent[idx]}});
				}
			}
		}
		
	}

	@Override
	public void onSyncCompleted() {
		
	}
	
}
