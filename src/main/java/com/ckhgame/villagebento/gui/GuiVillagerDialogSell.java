package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerSell;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperPlayer;
import com.ckhgame.villagebento.util.village.ItemPrice;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;
import com.ckhgame.villagebento.villagercomponent.VillagerCompItemList.ItemRecord;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class GuiVillagerDialogSell extends GuiVillagerDialogGrid{

	private static final int ButtonID_Back = 0;
	
	private static final int ContentID_Sell = 0;
	
	private VillagerCompSell villagerCompSell;
	
	public GuiVillagerDialogSell(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.villagerCompSell = (VillagerCompSell)this.entityVBVillager.getVillagerComponent(VillagerCompSell.class);
		if(this.villagerCompSell == null){ // the villager doesn't have component sell
			this.hideCenterContent();
			this.setDialogString(StatCollector.translateToLocal("vbgui.dialogString.buyNoItem"));
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.sellBack"));
		}
		else if(!this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNow()){ // has component sell but is out of open hours now..
			this.hideCenterContent();
			this.setDialogString(StatCollector.translateToLocal("vbgui.dialogString.buyOutOpenHours"));
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.sellBack"));
		}
		else{  // send a packet to query the item list, the sell gui will display after receiving
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompSell);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		}
	}
	
	@Override
	public boolean updateWithVBCompResult(VBCompResult vbCompResult) {
		if(!super.updateWithVBCompResult(vbCompResult)){
			this.setDialogString(StatCollector.translateToLocal("vbgui.dialogString.buyWanttoSell"));
			this.addDialogOptions(ButtonID_Back, 0, StatCollector.translateToLocal("vbgui.dialogOption.sellBack"));
			this.showCenterContent(ContentID_Sell);
			return false;
		}
		else{
			if(VBResult.isSuccess(vbCompResult.vbResult)){
				this.playSound("random.orb");
			}
			else{
				this.playSound("random.bow");
			}
			return true;
		}
	}
	
	@Override
	protected void drawGridCell(int idx, int mx, int my, int x, int y) {
		if(idx < this.villagerCompSell.getItemList().size()){
			ItemRecord itemRecord = this.villagerCompSell.getItemList().get(idx);
			boolean available = this.villagerCompSell.isItemRecoardAvailable(itemRecord);
			boolean hover = this.drawItem(mx, my, x + 3, y + 3, itemRecord.itemStack,available?String.valueOf(HelperPlayer.getItemTotalInInventory(Minecraft.getMinecraft().thePlayer, itemRecord.itemStack)):" ",available);
			if(hover){
				List texts = new ArrayList();
				texts.add(itemRecord.itemStack.getDisplayName());
				if(this.villagerCompSell.isItemRecoardAvailable(itemRecord)){
					texts.add(ItemPrice.getSellPrice(itemRecord.itemStack.getItem()) + " G");
				}
				else{
					texts.add(StatCollector.translateToLocal("vbgui.common.needLevel") + (itemRecord.minLevel + 1));
				}
				this.setMouseHoverTexts(texts);
			}
		}
	}	
	
	@Override
	protected void onGridCellClicked(int idx) {
		if(idx < this.villagerCompSell.getItemList().size()){
			ItemRecord itemRecord = this.villagerCompSell.getItemList().get(idx);
			if(this.villagerCompSell.isItemRecoardAvailable(itemRecord)){
				ItemStack itemSell = itemRecord.itemStack.copy();
				itemSell.stackSize = this.isShiftKeyDown()?10:1;
	
				int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompSell);
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

	@Override
	protected void drawCenterContent(int centerContentID, int mx, int my, float f) {
		super.drawCenterContent(centerContentID, mx, my, f);
		if(centerContentID == ContentID_Sell){
			this.drawCenteredString(this.fontRendererObj, StatCollector.translateToLocal("vbgui.dialogSell.sellTitle") + this.entityVBVillager.getName(), this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);
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
