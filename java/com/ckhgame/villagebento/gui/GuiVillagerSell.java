package com.ckhgame.villagebento.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerSell;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.village.ItemPrice;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;

public class GuiVillagerSell extends GuiVillager {
	
	private final int rowSize = 3;
	
	//buttons
	public GuiButton[] buttonRows;
	public GuiButton buttonUp;
	public GuiButton buttonDown;
	
	private VillagerCompSell villagerCompSell;
	
	int currentIdx = 0;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Sell";
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
			drawRect(left + 4, top + 4, left + 20, top + 20, 0xFFAAAAAA);	
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
		ArrayList<ItemStack> sellList = this.villagerCompSell.itemListCurrent;
		ItemStack itemStack;
		int price;
		for(int i = 0;i<rowSize;i++){
			itemStack = (sellList == null || currentIdx + i >= sellList.size())? null : sellList.get(currentIdx + i);
			price = (itemStack == null?0:ItemPrice.getSellPrice(itemStack.getItem()));
			drawItemRow(fieldCompLeft + 4,fieldCompTop + 6 + 32 * i,itemStack,price,i);
		}
			
		
		//current row index
		GL11.glDisable(GL11.GL_LIGHTING);
		String idx = (sellList == null || sellList.size() == 0)?"0/0":(currentIdx + 1) + "/" + sellList.size();
		this.drawCenteredString(fontRendererObj, idx, fieldCompLeft + 184, fieldCompTop + 46, 0xFFFFFFFF);
	}

	@Override
	public void onInitGui() {
		setChatContent("What you want to sell?");
		currentIdx = 0;
		this.villagerCompSell = (VillagerCompSell)villagerComponent;
		
		//assign button ids
		buttonRows = new GuiButton[rowSize];
		for(int i = 0;i<rowSize;i++){
			buttonRows[i] = new GuiButton(compStartButtonID++,fieldCompLeft + 120,fieldCompTop + 8 + 32 * i,40,20,"Sell");
			this.buttonList.add(buttonRows[i]);
		}
		
		buttonUp = new GuiButton(compStartButtonID++, fieldCompLeft + 170,fieldCompTop + 4,28,20,"Prev");
		buttonDown = new GuiButton(compStartButtonID++ + 1,fieldCompLeft + 170,fieldCompTop + 76,28,20,"Next");
		this.buttonList.add(buttonUp);
		this.buttonList.add(buttonDown);
	}

	@Override
	public void onActionPerformed(GuiButton button) {

		ArrayList<ItemStack> sellList = this.villagerCompSell.itemListCurrent;
		
		if(button.id == buttonUp.id){
			currentIdx = Math.max(0, --currentIdx);
		}
		else if(button.id == buttonDown.id){
			int max = sellList == null?0:Math.max(0,sellList.size() - 1);
			currentIdx = Math.min(max, ++currentIdx);
		}
		
		for(int i = 0;i<rowSize;i++){
			if(button.id == buttonRows[i].id){
				int stackIdx = currentIdx + i;
				if(sellList != null && stackIdx >= 0 && stackIdx < sellList.size()){
					ItemStack itemSell = sellList.get(stackIdx).copy();
					itemSell.stackSize = 1;
					
					int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
					if(compIdx < 0)
						System.out.println("Can not find the village component! idx < 0");
					else
						Action.send(ActionDoVillagerSell.class, new Object[]{	this.entityVBVillager.getEntityId(),
																				compIdx, 
																				Minecraft.getMinecraft().thePlayer.getEntityId(),
																				new Object[]{itemSell}});
				}
			}
		}
		
	}

	@Override
	public void onSyncCompleted() {
		// TODO Auto-generated method stub
		
	}
	
}
