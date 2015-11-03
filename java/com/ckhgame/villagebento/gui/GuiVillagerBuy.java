package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionGetVillagerName;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GuiVillagerBuy extends GuiVillager {
	
	private final int rowSize = 3;
	
	//buttons
	public GuiButton[] buttonRows;
	public GuiButton buttonUp;
	public GuiButton buttonDown;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Buy";
	}

	private void drawItemRow(int left,int top, ItemStack itemStack, int price){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//background
		drawRect(left - 2, top - 2, left + 160 + 2, top + 24 + 2, 0xFF888888);	
		drawRect(left, top, left + 160, top + 24, 0xFF666666);	
		//item name
		fontRendererObj.drawString(itemStack.getDisplayName(), left + 28, top + 4, 0xFFFFFFFF,true);
		//item price and how many items left
		String priceAndNum = "Price:" + price + ", left:" + itemStack.stackSize;
		fontRendererObj.drawString(priceAndNum, left + 28, top + 14, 0xFFFFFFDD,true);
		//item icon
		drawRect(left + 3, top + 3, left + 21, top + 21, 0xFF333333);
		drawRect(left + 4, top + 4, left + 20, top + 20, 0xFFFFFFFF);	
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left + 4, top + 4);
	}
	
	@Override
	public void onDrawScreen() {
		//this.drawWrappedString(this.fontRendererObj,"Nothing to trade with you now :(",this.width / 2 - 74,this.height /2 - 45,0xFFFFFFFF,188);
		ItemStack s = new ItemStack(Items.bed,20);
		for(int i = 0;i<rowSize;i++)
			drawItemRow(fieldCompLeft + 4,fieldCompTop + 6 + 32 * i,s, 100);
		
		//current row index
		GL11.glDisable(GL11.GL_LIGHTING);
		String idx = "2/10";
		this.drawCenteredString(fontRendererObj, idx, fieldCompLeft + 184, fieldCompTop + 46, 0xFFFFFFFF);
	}

	@Override
	public void onInitGui() {
		// TODO Auto-generated method stub
		Action.send(ActionGetVillagerName.class, new Object[]{this.entityVillager.dataVillagerID});
		setChatContent("What you want to buy?");
		
		//assign button ids
		buttonRows = new GuiButton[rowSize];
		for(int i = 0;i<rowSize;i++){
			buttonRows[i] = new GuiButton(compStartButtonID++,fieldCompLeft + 120,fieldCompTop + 8 + 32 * i,40,20,"Buy");
			this.buttonList.add(buttonRows[i]);
		}
		
		buttonUp = new GuiButton(compStartButtonID++, fieldCompLeft + 170,fieldCompTop + 4,28,20,"Prev");
		buttonDown = new GuiButton(compStartButtonID++ + 1,fieldCompLeft + 170,fieldCompTop + 76,28,20,"Next");
		this.buttonList.add(buttonUp);
		this.buttonList.add(buttonDown);
	}

	@Override
	public void onActionPerformed() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
