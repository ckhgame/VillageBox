package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public abstract class GuiVillager extends GuiScreen {

	public static boolean isWaitingForActionResult = true; 
	public static void ActionStart(){
		isWaitingForActionResult = true;
	}
	public static void ActionCompleted(){
		isWaitingForActionResult = false;
	}
	
	protected VillagerComponent villagerComponent;
	protected EntityVBVillager entityVillager;
	protected Villager villager;
	protected int buttonID;
	protected String chatContent = "......";
	protected String chatContentDisplay = "";
	
	//filed locations
	protected int fieldChatLeft;
	protected int fieldChatTop;
	protected int fieldCompLeft;
	protected int fieldCompTop;
	
	//component button id start
	protected int compStartButtonID = 100;
	
	protected void setChatContent(String chatContent){
		this.chatContent = chatContent;
		chatContentDisplay = "";
	}
	
	public void setVillageComponent(VillagerComponent villagerComponent){
		this.villagerComponent = villagerComponent;
	}
	
	public void setEntityVillager(EntityVBVillager entityVillager){
		this.entityVillager = entityVillager;
		this.villager = Villager.registry.get(this.entityVillager.profession);
	}
	
	protected void drawWrappedString(FontRenderer renderer, String drawing, int x, int y, int color, int wrap)
    {
        List<String> lines = renderer.listFormattedStringToWidth(drawing, wrap);
        for (int i = 0; i < lines.size(); i++)
            renderer.drawString(lines.get(i), x, y + (i * 9), color, false);
    }
	
	protected void drawRightedString(FontRenderer font, String text, int left, int top, int c)
    {
		font.drawStringWithShadow(text, left - font.getStringWidth(text), top, c);
    }
	
	private void drawFieldBackground(int left,int top,int width,int height){
		
		drawRect(left - 2, top - 2, left + width + 2, top + height + 2, 0xFF333333);
		drawRect(left - 1, top - 1, left + width + 1, top + height + 1, 0xFF111111);
		drawRect(left, top, left + width, top + height, 0xFF555555);
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		
		this.drawDefaultBackground();
		
		//GUI LAYOUT: Right Top Chat Field
		
		drawFieldBackground(fieldChatLeft,fieldChatTop,200,30);
		//display name and chat content
		String name = this.entityVillager.name + ":";

		this.fontRendererObj.drawString(name, fieldChatLeft + 1,fieldChatTop + 1, 0xFFFFFF00,true);
		
		//chat anim
		if(chatContentDisplay.length() < chatContent.length()){
			chatContentDisplay = chatContent.substring(0, chatContentDisplay.length() + 1);
		}
		this.fontRendererObj.drawString(chatContentDisplay, fieldChatLeft + 6,fieldChatTop + 13, 0xFFFFFFEE,true);
		
		//GUI LAYOUT: Right Top Component Field
		drawFieldBackground(fieldCompLeft,fieldCompTop,200,100);
		
		onDrawScreen();
		
		GL11.glDisable(GL11.GL_LIGHTING);
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);	
        GL11.glEnable(GL11.GL_LIGHTING);
	}

	@Override
	protected void actionPerformed(GuiButton button) {

		//leave
		if(button.id == 99999){
			this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
            return;
		}
		
		ArrayList<VillagerComponent> carr = villager.getVillagerComponents();
		for(VillagerComponent c : carr){
			if(c.getGui().buttonID == button.id){
				this.mc.displayGuiScreen(c.getGui());
				return;
			}
		}
		
        onActionPerformed(button);
        
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {
		// TODO Auto-generated method stub
		//this.
		this.buttonList.clear();
		int id = 0;
		int count = 0;
		GuiButton btn;
		ArrayList<VillagerComponent> carr = null;
		if(entityVillager != null){
			carr = villager.getVillagerComponents();
		}
		
		//GUI LAYOUT
		//left buttons field
		
		if(carr != null){
			for(VillagerComponent c : carr){
				c.getGui().buttonID = id++;
				btn = new GuiButton(c.getGui().buttonID, 
						this.width /2 - 130,this.height /2 - 50 + 20 * (count++),
						46,20,	
						c.getGui().getButtonText());
				if(c == villagerComponent)
					btn.enabled = false;
				this.buttonList.add(btn);
			}
		}

		//leave button
		this.buttonList.add(new GuiButton(99999, this.width /2 - 130,this.height /2 + 64,46,20,"Leave"));
		
		fieldChatLeft = this.width / 2 - 80;
		fieldChatTop = this.height /2 - 60;
		fieldCompLeft = this.width / 2 - 80;
		fieldCompTop = this.height /2 - 20;
		
		onInitGui();
		
		super.initGui();
	}

	@Override
	public boolean doesGuiPauseGame() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		super.updateScreen();
		
		//auto close gui screen when villager is far away from the player
		if(	this.entityVillager == null ||
			this.entityVillager.getSleeping() ||
			this.entityVillager.getDistanceSqToEntity(Minecraft.getMinecraft().thePlayer) > ConfigVillager.MaxInteractDistanceSq){
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
		
	}
	public abstract String getButtonText();
	public abstract void onDrawScreen();
	public abstract void onInitGui();
	public abstract void onActionPerformed(GuiButton button);
	public abstract void updateWithData(int data);
	
}
