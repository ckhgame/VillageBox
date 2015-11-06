package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.misc.HelperString;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoDropCoins;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class GuiDropCoins extends GuiScreen {

	private enum DropState{
			Success,
			Waiting,
			InvalidInput,
			MoreThanOwn
	}
	
	private GuiTextField textField;
	private GuiButton buttonDrop;
	private DropState dropState;

	private void drawFieldBackground(int left,int top,int width,int height){
		
		drawRect(left - 2, top - 2, left + width + 2, top + height + 2, 0xFF333333);
		drawRect(left - 1, top - 1, left + width + 1, top + height + 1, 0xFF111111);
		drawRect(left, top, left + width, top + height, 0xFF555555);
	}
	
	int yOffset = 0;
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		
		this.drawDefaultBackground();
		
		if(yOffset < 0)
			yOffset += 1;
		
		//GUI LAYOUT: Right Top Chat Field
		drawFieldBackground(this.width/2 - 80,this.height/2 - 40,160,80);
		if(this.dropState == DropState.Waiting){
			this.drawCenteredString(this.fontRendererObj, "How much you want to drop?", this.width/2, this.height/2 - 30, 0xFFFFFFAA);
		}
		else if(this.dropState == DropState.InvalidInput){
			this.drawCenteredString(this.fontRendererObj,"Invalid Input!", this.width/2, this.height/2 - 30 + yOffset, 0xFFFFAAAA);
		}
		else if(this.dropState == DropState.MoreThanOwn){
			this.drawCenteredString(this.fontRendererObj,"It's too much!", this.width/2, this.height/2 - 30 + yOffset, 0xFFFFAAAA);
		}
		textField.drawTextBox();
		
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);	
	}

	
	
	@Override
	public void updateScreen() {
		
		this.textField.updateCursorCounter();
		
		super.updateScreen();
	}


	
	@Override
	protected void keyTyped(char p_73869_1_, int p_73869_2_) {

		if (this.textField.isFocused())
        {
            this.textField.textboxKeyTyped(p_73869_1_, p_73869_2_);
        }
		
		super.keyTyped(p_73869_1_, p_73869_2_);
	}

	private boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	@Override
	protected void actionPerformed(GuiButton button) {

		//leave
		if(button.id == buttonDrop.id){
			this.yOffset = -5;
			
			String t = this.textField.getText().trim();
			
			if(!HelperString.isInteger(t)){
				this.dropState = DropState.InvalidInput;
				return;
			}
			
			int num = Integer.parseInt(t);
			
			if(num <= 0){
				this.dropState = DropState.InvalidInput;
				return;
			}
			
			ItemStack itemStackCurrency = null;
			InventoryPlayer ip = Minecraft.getMinecraft().thePlayer.inventory;
			for (int i = 0; i < ip.mainInventory.length; ++i){
	            if (ip.mainInventory[i] != null && ip.mainInventory[i].getItem() == ModItems.itemVillageCurrency){
	            	itemStackCurrency = ip.mainInventory[i];
	            	break;
	            }
	        }
			
			if(itemStackCurrency == null || itemStackCurrency.getItemDamage() < num ){
				this.dropState = DropState.MoreThanOwn;
				return;
			}
			
			Action.send(ActionDoDropCoins.class, new Object[]{Minecraft.getMinecraft().thePlayer.getEntityId(),num});
			
			this.dropState = DropState.Success;
		}
        
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {
		
		dropState = DropState.Waiting;
		
		buttonDrop = new GuiButton(0,this.width/2 - 20,this.height/2 + 15, 40, 20,"Drop");
		this.buttonList.clear();
		this.buttonList.add(buttonDrop);
		
		textField = new GuiTextField(this.fontRendererObj,this.width/2 - 40,this.height/2 - 10, 80,20 );
		textField.setFocused(true);
		
		super.initGui();
	}

	@Override
	public boolean doesGuiPauseGame() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
