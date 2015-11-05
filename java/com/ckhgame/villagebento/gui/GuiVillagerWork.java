package com.ckhgame.villagebento.gui;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.misc.ItemPrice;
import com.ckhgame.villagebento.misc.VBResult;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerSell;
import com.ckhgame.villagebento.network.action.ActionDoVillagerStartWork;
import com.ckhgame.villagebento.network.action.ActionDoVillagerTakeWorkOutput;
import com.ckhgame.villagebento.network.action.ActionGetVillagerSell;
import com.ckhgame.villagebento.network.action.ActionGetVillagerWork;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;

public class GuiVillagerWork extends GuiVillager {
	
	private final int rowSize = 3;
	
	private String workPlayerName;
	private int workIdx;
	private int workHoursLeft;
	private ItemStack workOutput;
	public void setWork(String playerName,int workIdx,int hoursLeft,ItemStack output){
		this.workPlayerName = playerName;
		this.workIdx = workIdx;
		this.workHoursLeft = hoursLeft;
		this.workOutput = output;
		System.out.println("SET WORK!! " + this.workPlayerName +","+ this.workIdx +","+ this.workHoursLeft +","+this.workOutput);
	}
	
	//buttons
	public GuiButton[] buttonRows;
	public GuiButton buttonUp;
	public GuiButton buttonDown;
	
	int currentIdx = 0;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Work";
	}

	private void drawItemRow(int left,int top, ItemStack itemStack, int price,int row){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//background
		drawRect(left - 2, top - 2, left + 160 + 2, top + 24 + 2, 0xFF888888);	
		drawRect(left, top, left + 160, top + 24, 0xFF666666);	
		if(itemStack != null){
			//item name
			fontRendererObj.drawString(itemStack.getDisplayName(), left + 28, top + 4, 0xFFFFFFFF,true);
			//item price and how many items left
			String priceAndNum = "price:" + price + ", want:" + itemStack.stackSize;
			fontRendererObj.drawString(priceAndNum, left + 28, top + 14, 0xFFFFFFDD,true);
			//item icon
			drawRect(left + 3, top + 3, left + 21, top + 21, 0xFF333333);
			drawRect(left + 4, top + 4, left + 20, top + 20, 0xFFFFFFFF);	
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left + 4, top + 4);
			
			if(!buttonRows[row].visible)
				buttonRows[row].visible = true;
		}
		else{
			if(buttonRows[row].visible)
				buttonRows[row].visible = false;
		}
		
	}
	
	@Override
	public void onDrawScreen() {

	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		Action.send(ActionGetVillagerWork.class, new Object[]{this.entityVillager.dataVillagerID});
		setChatContent("Can I help you?");
		
		buttonUp = new GuiButton(compStartButtonID++, fieldCompLeft + 170,fieldCompTop + 4,28,20,"new");
		buttonDown = new GuiButton(compStartButtonID++ + 1,fieldCompLeft + 170,fieldCompTop + 76,28,20,"get");
		this.buttonList.add(buttonUp);
		this.buttonList.add(buttonDown);
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		if(button.id == buttonUp.id){
			Action.send(ActionDoVillagerStartWork.class, new Object[]{	this.entityVillager.dataVillagerID,
																		Minecraft.getMinecraft().thePlayer.getEntityId(),
																		0});
		}
		else if(button.id == buttonDown.id){
			Action.send(ActionDoVillagerTakeWorkOutput.class, new Object[]{	this.entityVillager.dataVillagerID,
																			Minecraft.getMinecraft().thePlayer.getEntityId()});
		}
		
	}
	
	@Override
	public void updateWithData(int data) {
		if(data == VBResult.SUCCESS)
			setChatContent("Start working!");
		else if(data == VBResult.FAILED_WRONGNAME)
			setChatContent("It's not yours...");
		else if(data == VBResult.FAILED)
			setChatContent("I can't do that..");
	}
	
}
