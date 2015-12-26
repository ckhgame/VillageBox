package com.ckhgame.villagebento.gui2;

import java.util.ArrayList;
import java.util.List;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerBuy;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.village.ItemPrice;
import com.ckhgame.villagebento.villagercomponent.VillagerCompBuy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;

public class GuiVillagerDialogBuy extends GuiVillagerDialogGrid{

	private static final int ButtonID_Back = 0;
	
	private static final int ContentID_Buy = 0;
	
	private VillagerCompBuy villagerCompBuy;
	
	public GuiVillagerDialogBuy(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.villagerCompBuy = (VillagerCompBuy)this.entityVBVillager.getVillagerComponent(VillagerCompBuy.class);
		if(this.villagerCompBuy == null){ // the villager doesn't have component buy
			this.hideCenterContent();
			this.setDialogString("Sorry, I have nothing to sell...");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
		}
		else if(!this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNow()){ // has component buy but is out of open hours now..
			this.hideCenterContent();
			this.setDialogString("Sorry, It's out of my open hours now...");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
		}
		else{  // send a packet to query the item list, the buy gui will display after receiving
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompBuy);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		}
	}
	
	@Override
	public boolean updateWithVBCompResult(VBCompResult vbCompResult) {
		if(!super.updateWithVBCompResult(vbCompResult)){
			this.setDialogString("What do you want to buy?");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
			this.showCenterContent(ContentID_Buy);
		}
		return false;
	}
	
	@Override
	protected void drawGridCell(int idx, int mx, int my, int x, int y) {
		if(idx < this.villagerCompBuy.itemListCurrent.size()){
			ItemStack itemStack = this.villagerCompBuy.itemListCurrent.get(idx);
			boolean hover = this.drawItem(mx, my, x + 3, y + 3, itemStack);
			if(hover){
				List texts = new ArrayList();
				texts.add(itemStack.getDisplayName());
				texts.add(ItemPrice.getBuyPrice(itemStack.getItem()) + " G");
				this.setMouseHoverTexts(texts);
			}
		}
	}	
	
	@Override
	protected void onGridCellClicked(int idx) {
		if(idx < this.villagerCompBuy.itemListCurrent.size()){
			ItemStack itemStack = this.villagerCompBuy.itemListCurrent.get(idx);
			System.out.println(itemStack.getDisplayName());
			
			ItemStack itemBuy = this.villagerCompBuy.itemListCurrent.get(idx).copy();
			itemBuy.stackSize = 1;

			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompBuy);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionDoVillagerBuy.class, new Object[]{	this.entityVBVillager.getEntityId(),
																		compIdx, 
																		Minecraft.getMinecraft().thePlayer.getEntityId(),
																		new Object[]{itemBuy}});
		}
	}

	@Override
	protected void drawCenterContent(int centerContentID, int mx, int my, float f) {
		super.drawCenterContent(centerContentID, mx, my, f);
		if(centerContentID == ContentID_Buy){
			this.drawCenteredString(this.fontRendererObj, "Buy items from " + this.entityVBVillager.getName(), this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);
			this.drawGrid(mx, my);
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		switch(guiButton.id){
		case ButtonID_Back:
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
			break;
		}
	}

	@Override
	protected void mouseClicked(int mx, int my, int button) {
		super.mouseClicked(mx, my, button);
		
		if(button == 1){ // right click
			this.gridCellMouseClick(mx, my);
		}
		
	}
	
}
