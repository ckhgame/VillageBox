package com.ckhgame.villagebento.guiold;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerBuy;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.village.ItemPrice;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class GuiVillagerBuy extends GuiVillager {
	
	private final int rowSize = 3;
	
	//buttons
	public GuiButton[] buttonRows;
	public GuiButton buttonUp;
	public GuiButton buttonDown;
	
	private VillagerCompBuy villagerCompBuy;
	
	int currentIdx = 0;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "> Do you have any thing to sell?";
	}
	
	private void drawItemRow(int left,int top, ItemStack itemStack, int price,int row){
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		//background
		drawRect(left - 2, top - 2, left + 160 + 2, top + 24 + 2, 0xFF888888);	
		drawRect(left, top, left + 160, top + 24, 0xFF666666);	
		if(itemStack != null){
			//item price and how many items left
			String textPrice = "price: " + price;
			fontRendererObj.drawString(textPrice, left + 28, top + 10, 0xFFFFFFDD,true);
			//item
			this.drawItem(left + 4, top + 4, itemStack);
			
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
		ArrayList<ItemStack> buyList = this.villagerCompBuy.itemListCurrent;
		ItemStack itemStack;
		int price;
		for(int i = 0;i<rowSize;i++){
			itemStack = (buyList == null || currentIdx + i >= buyList.size())? null : buyList.get(currentIdx + i);
			price = (itemStack == null?0:ItemPrice.getBuyPrice(itemStack.getItem()));
			drawItemRow(fieldCompLeft + 4,fieldCompTop + 6 + 32 * i,itemStack,price,i);
		}
			
		
		//current row index
		GL11.glDisable(GL11.GL_LIGHTING);
		String idx = (this.villagerComponent == null || buyList.size() == 0)?"0/0":(currentIdx + 1) + "/" + buyList.size();
		this.drawCenteredString(fontRendererObj, idx, fieldCompLeft + 184, fieldCompTop + 46, 0xFFFFFFFF);
	}

	@Override
	public void onInitGui() {
		setChatContent("What you want to buy?");
		currentIdx = 0;
		this.villagerCompBuy = (VillagerCompBuy)villagerComponent;
		
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
	public void onActionPerformed(GuiButton button) {

		ArrayList<ItemStack> buyList = this.villagerCompBuy.itemListCurrent;
		
		if(button.id == buttonUp.id){
			currentIdx = Math.max(0, --currentIdx);
		}
		else if(button.id == buttonDown.id){
			int max = buyList == null?0:Math.max(0,buyList.size() - 1);
			currentIdx = Math.min(max, ++currentIdx);
		}
		
		for(int i = 0;i<rowSize;i++){
			if(button.id == buttonRows[i].id){
				int stackIdx = currentIdx + i;
				if(buyList != null && stackIdx >= 0 && stackIdx < buyList.size()){
					ItemStack itemBuy = buyList.get(stackIdx).copy();
					itemBuy.stackSize = 1;

					int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
					if(compIdx < 0)
						System.out.println("Can not find the village component! idx < 0");
					else
						Action.send(ActionDoVillagerBuy.class, new Object[]{	this.entityVBVillager.getEntityId(),
																				compIdx, 
																				Minecraft.getMinecraft().thePlayer.getEntityId(),
																				new Object[]{itemBuy}});
				}
			}
		}
		
	}

	@Override
	public void onSyncCompleted() {
		// TODO Auto-generated method stub
		
	}
}
