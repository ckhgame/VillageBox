package com.ckhgame.villagebento.gui;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.misc.VBResult;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerStartWork;
import com.ckhgame.villagebento.network.action.ActionDoVillagerTakeWorkOutput;
import com.ckhgame.villagebento.network.action.ActionGetVillagerWork;
import com.ckhgame.villagebento.network.action.ActionGetVillagerWorkList;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;

public class GuiVillagerWork extends GuiVillager {
	
	private final int rowSize = 3;
	
	private boolean noData;
	
	//current work
	private String workPlayerName;
	private int workIdx;
	private int workHoursLeft;
	private ItemStack workOutput;
	private String workName;
	private String workRemark;
	
	private class Work{
		public int workIdx;
		public String name;
		public String remark;
		public int hours;
		public int price;
	}
	
	//all available works for the current level
	private Work[] workList;
	
	public void setWork(String playerName,int workIdx,int hoursLeft,ItemStack output){
		this.workPlayerName = playerName;
		this.workIdx = workIdx;
		this.workHoursLeft = hoursLeft;
		this.workOutput = output;
		System.out.println("SET WORK!! " + this.workPlayerName +","+ this.workIdx +","+ this.workHoursLeft +","+this.workOutput);
		
		if(this.workIdx >= 0){
			VillagerCompWork compWork = (VillagerCompWork)villager.findVillagerComponentByClass(VillagerCompWork.class);
			workName = compWork.getWorkName(workIdx);
			workRemark = compWork.getWorkRemark(workIdx);
		}
		
		noData = false;
	}
	
	public void setWorkList(int[] workListInt){
		
		VillagerCompWork compWork = (VillagerCompWork)villager.findVillagerComponentByClass(VillagerCompWork.class);
		for(int i : workListInt)
			System.out.println(i);
		workList = new Work[workListInt.length];
		Work work;
		for(int i =0;i<workList.length;i++){
			work = new Work();
			work.workIdx = workListInt[i];
			work.name = compWork.getWorkName(workListInt[i]);
			work.remark = compWork.getWorkRemark(workListInt[i]);
			work.hours = compWork.getWorkHours(workListInt[i]);
			work.price = compWork.getWorkPrice(workListInt[i]);
			workList[i] = work;
		}
	}
	
	//buttons
	public GuiButton[] buttonRows;
	public GuiButton buttonUp;
	public GuiButton buttonDown;
	public GuiButton buttonTake;
	
	int currentIdx = 0;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Work";
	}

	private void drawWorkRow(int left,int top, Work work,int row){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//background
		drawRect(left - 2, top - 2, left + 160 + 2, top + 24 + 2, 0xFF888888);	
		drawRect(left, top, left + 160, top + 24, 0xFF666666);	
		if(work != null){
			//item name
			fontRendererObj.drawString(work.name, left + 4, top + 4, 0xFFFFFFAA,true);
			fontRendererObj.drawString(work.remark, left + 4, top + 14, 0xFFDDDDDD);
			
			this.drawRightedString(fontRendererObj, work.price + ", " + work.hours + "h", left + 112, top +4, 0xFFEEEEEE);
			
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
		
		
		this.drawCenteredString(fontRendererObj, "Work Completed!", fieldCompLeft + 100, fieldCompTop + 12, 0xFFFFFF00);	
		fontRendererObj.drawString(workName, fieldCompLeft + 120, fieldCompTop + 26, 0xFFFFFFAA,true);
		fontRendererObj.drawString("Client: " + workPlayerName, fieldCompLeft + 120, fieldCompTop + 40, 0xFFFFFFFF);
		fontRendererObj.drawString("Expire in: " + (ConfigVillager.WorkOutputExpirationHours + workHoursLeft) + " h", fieldCompLeft + 120, fieldCompTop + 50, 0xFFFFFFFF,true);
	
		if(workOutput != null){
			fontRendererObj.drawString(workOutput.getDisplayName(), fieldCompLeft + 44, fieldCompTop + 40, 0xFFFFFFFF);
			fontRendererObj.drawString(" X " + workOutput.stackSize, fieldCompLeft + 44, fieldCompTop + 50, 0xFFFFFFFF,true);
		}	
		fontRendererObj.drawString("Outputs:", fieldCompLeft + 12, fieldCompTop + 26, 0xFFFFFFAA,true);
		
		//item icon
		drawRect(fieldCompLeft + 18, fieldCompTop + 38, fieldCompLeft + 42, fieldCompTop + 62, 0xFF000000);
		drawRect(fieldCompLeft + 20, fieldCompTop + 40, fieldCompLeft + 40, fieldCompTop + 60, 0xFFFFFFFF);	
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), workOutput, fieldCompLeft + 22, fieldCompTop + 42);

	}
	
	private void drawWaitingForNextWork(){
		
		buttonTake.visible = false;
		buttonUp.visible = true;
		buttonDown.visible = true;
		
		
		Work work;
		for(int i = 0;i<rowSize;i++){
			work = (workList == null || currentIdx + i >= workList.length)? null : workList[currentIdx + i];
			drawWorkRow(fieldCompLeft + 4,fieldCompTop + 6 + 32 * i,work,i);
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
		
		this.drawCenteredString(fontRendererObj, "Is Working...", fieldCompLeft + 100, fieldCompTop + 12, 0xFFFFFF00);	
		this.drawCenteredString(fontRendererObj,workName, fieldCompLeft + 100, fieldCompTop + 30, 0xFFFFFFEE);
		this.drawCenteredString(fontRendererObj,workRemark, fieldCompLeft + 100, fieldCompTop + 40, 0xFFAAAAAA);
		this.drawCenteredString(fontRendererObj,"Client: " + workPlayerName, fieldCompLeft + 100, fieldCompTop + 60, 0xFFFFFFFF);
		this.drawCenteredString(fontRendererObj,"Hours Left: " + workHoursLeft, fieldCompLeft + 100, fieldCompTop + 70, 0xFFFFFFFF);
	}
	
	@Override
	public void onDrawScreen() {
		
		if(noData){
			for(int i = 0;i<rowSize;i++)
				buttonRows[i].visible = false;
			buttonUp.visible = false;
			buttonDown.visible = false;
			buttonTake.visible = false;
		}
		else if(workIdx >= 0 && workHoursLeft > 0)
			drawIsWorking();
		else if(workIdx >= 0 && workHoursLeft <= 0)
			drawWaitingForTakingOutput();
		else if(workIdx < 0)
			drawWaitingForNextWork();
		
	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		Action.send(ActionGetVillagerWork.class, new Object[]{this.entityVillager.dataVillagerID});
		Action.send(ActionGetVillagerWorkList.class, new Object[]{this.entityVillager.dataVillagerID});
		setChatContent("Can I help you?");
		
		//assign button ids
		buttonRows = new GuiButton[rowSize];
		for(int i = 0;i<rowSize;i++){
			buttonRows[i] = new GuiButton(compStartButtonID++,fieldCompLeft + 120,fieldCompTop + 8 + 32 * i,40,20,"Start");
			this.buttonList.add(buttonRows[i]);
		}
		
		buttonTake = new GuiButton(compStartButtonID++, fieldCompLeft + 80,fieldCompTop + 70,40,20,"Take");
		this.buttonList.add(buttonTake);
		
		buttonUp = new GuiButton(compStartButtonID++, fieldCompLeft + 170,fieldCompTop + 4,28,20,"prev");
		buttonDown = new GuiButton(compStartButtonID++ + 1,fieldCompLeft + 170,fieldCompTop + 76,28,20,"next");
		this.buttonList.add(buttonUp);
		this.buttonList.add(buttonDown);
		
		noData = true;
		workList = null;
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		
		if(button.id == buttonUp.id){
			currentIdx = Math.max(0, --currentIdx);
		}
		else if(button.id == buttonDown.id){
			int max = workList == null?0:Math.max(0,workList.length - 1);
			currentIdx = Math.min(max, ++currentIdx);
		}
		else if(button.id == buttonTake.id){
			Action.send(ActionDoVillagerTakeWorkOutput.class, new Object[]{	this.entityVillager.dataVillagerID,
			Minecraft.getMinecraft().thePlayer.getEntityId()});
		}
			
		for(int i = 0;i<rowSize;i++){
			if(button.id == buttonRows[i].id){
				int idx = currentIdx + i;
				if(workList != null && idx >= 0 && idx < workList.length){				
					Action.send(ActionDoVillagerStartWork.class, new Object[]{	this.entityVillager.dataVillagerID,
																				Minecraft.getMinecraft().thePlayer.getEntityId(),
																				workList[idx].workIdx});
				}
			}
		}
		
	}
	
	@Override
	public void updateWithData(int data) {
		if(data == VBResult.SUCCESS)
			setChatContent("Start working!");
		else if(data == VBResult.FAILED_WRONGNAME)
			setChatContent("It's not yours...");
		else if(data == VBResult.FAILED_UNAFFORDABLE)
			setChatContent("You don't have enough money...");
		else if(data == VBResult.FAILED)
			setChatContent("I can't do that..");
	}
	
}
