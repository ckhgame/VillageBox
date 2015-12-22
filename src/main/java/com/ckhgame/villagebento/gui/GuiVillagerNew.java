package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.module.GuiTextButton;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;

public abstract class GuiVillagerNew extends GuiScreen {
	
	protected EntityVBVillager entityVBVillager;
	protected int buttonID;
	protected String chatContent = "......";
	protected String chatContentDisplay = "";
	
	//filed locations
	protected int fieldVillagerHeadLeft;
	protected int fieldVillagerHeadTop;
	protected int fieldChatLeft;
	protected int fieldChatTop;
	protected int fieldCompLeft;
	protected int fieldCompTop;
	
	//chat options (options list)
	public static final int OptionsList_Main = 0;
	public static final int OptionsList_Trade = 1;
	public static final int OptionsList_Back = 2;
	
	//chat options (buttons)
	public static final int Options_About = 0;
	public static final int Options_Trade = 1;
	public static final int Options_Buy = 2;
	public static final int Options_Sell = 3;
	public static final int Options_Work = 4;
	public static final int Options_Quest = 5;
	public static final int Options_Action = 6;
	public static final int Options_Back = 7;
	public static final int Options_Leave = 8;
	
	//mouse
	protected int mouseX,mouseY;
	
	protected int fieldVillagerHeadTopOffset = 0;
	
	protected void setChatContent(String chatContent){
		this.chatContent = chatContent;
		chatContentDisplay = "";
		fieldVillagerHeadTopOffset = -4;
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
	
	protected boolean isMouseIn(int left, int top, int width, int height){
		if(	this.mouseX < left || 
			this.mouseX > left + width ||
			this.mouseY < top || 
			this.mouseY >= top + height){
			return false;
		}
		return true;
	}
	
	protected void drawItem(int left, int top, ItemStack itemStack){
		//item icon
		drawRect(left - 2, top - 2, left + 18, top + 18, 0xFF888888);
		drawRect(left - 1, top - 1, left + 17, top + 17, 0xFFCCCCCC);
		drawRect(left, top, left + 16, top + 16, 0xFFAAAAAA);	
		
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left, top);
		if(itemStack.getItem() == ModItems.itemVillageCurrency){
			String num = "x" + itemStack.getItemDamage();
			fontRendererObj.drawString(num, left + 16, top + 6, 0xFFFFFFFF);
		}
		else{
			String num = String.valueOf(itemStack.stackSize);
			itemRender.renderItemOverlayIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left, top, num);
		}
		
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);

		if(isMouseIn(left,top,16,16)){
			this.renderToolTip(itemStack, this.mouseX, this.mouseY);
		}
			
		GL11.glDisable(GL11.GL_LIGHTING);
	}
	
	private void drawFieldBackground(int left,int top,int width,int height){
		
		drawRect(left - 2, top - 2, left + width + 2, top + height + 2, 0xFF333333);
		drawRect(left - 1, top - 1, left + width + 1, top + height + 1, 0xFF111111);
		drawRect(left, top, left + width, top + height, 0xFF555555);
	}
	
	private void drawVillagerHead(int left, int top, int width, int height){
		this.mc.getTextureManager().bindTexture(this.entityVBVillager.getProfession().getSkin());
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		double u = 0.125D;
		double uw = 0.125D;
		double v = 0.25D;
		double vh = 0.25D;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(left), (double)(top + height), (double)this.zLevel, u, v + vh);
        tessellator.addVertexWithUV((double)(left + width), (double)(top + height), (double)this.zLevel, u + uw, v + vh);
        tessellator.addVertexWithUV((double)(left + width), (double)(top), (double)this.zLevel, u + uw, v);
        tessellator.addVertexWithUV((double)(left), (double)(top), (double)this.zLevel, u, v);
        tessellator.draw();
        
        //mouth
        
        if(chatContent != null && chatContentDisplay != null){
        	int lc = chatContent.length();
            int lcd = chatContentDisplay.length();
            if(lcd < lc - 5){
            	int d = lcd % 10;
            	if(d < 5){
                    GL11.glColor4f(0.5F, 0.2F, 0.2F, 1.0F);
                    double mx = left + 0.375D * width;
                    double my = top + 0.875D * height;
                    double mw = 0.25D * width;
                    double mh = 0.125D * height;
                    double z = (double)this.zLevel + 0.0001D;
                    
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glDisable(GL11.GL_TEXTURE_2D);        
                    tessellator.startDrawingQuads();
                    tessellator.addVertex(mx, my + mh, z);
                    tessellator.addVertex(mx + mw, my + mh, z);
                    tessellator.addVertex(mx + mw, my, z);
                    tessellator.addVertex(mx, my, z);
                    tessellator.draw();
                    GL11.glEnable(GL11.GL_TEXTURE_2D);
                    GL11.glDisable(GL11.GL_BLEND);
            	}
            }
        }
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		
		this.mouseX = p_73863_1_;
		this.mouseY = p_73863_2_;
		
		this.drawDefaultBackground();
		
		//GUI LAYOUT: Right Top Villager Head Field
		//head jump
		if(fieldVillagerHeadTopOffset < 0){
			fieldVillagerHeadTopOffset++;
		}
		drawFieldBackground(fieldVillagerHeadLeft,fieldVillagerHeadTop + fieldVillagerHeadTopOffset,64,64);
		drawVillagerHead(fieldVillagerHeadLeft + 8, fieldVillagerHeadTop + fieldVillagerHeadTopOffset + 8, 48, 48);
		
		//GUI LAYOUT: Right Top Chat Field
		
		drawFieldBackground(fieldChatLeft,fieldChatTop, 320, 64);
		//display name and chat content
		String name = this.entityVBVillager.getName();
		String info ="Lv" + (this.entityVBVillager.getLevel() +1 ) + " " + this.entityVBVillager.getProfession().getProfessionName();
		
		this.fontRendererObj.drawString(name, fieldChatLeft + 4,fieldChatTop + 2, 0xFFFFFF00,true);
		this.fontRendererObj.drawString(info, fieldChatLeft + 6 + this.fontRendererObj.getStringWidth(name), fieldChatTop + 2, 0xFFFFAA00,true);
		
		//chat anim
		if(chatContentDisplay.length() < chatContent.length()){
			chatContentDisplay = chatContent.substring(0, chatContentDisplay.length() + 1);
		}
		this.fontRendererObj.drawString(chatContentDisplay, fieldChatLeft + 8,fieldChatTop + 15, 0xFFFFFFEE,true);
		
		//GUI LAYOUT: Right Top Component Field
		drawFieldBackground(fieldCompLeft,fieldCompTop,200,150);
		
		//onDrawScreen();
		
		GL11.glDisable(GL11.GL_LIGHTING);
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);	
        GL11.glEnable(GL11.GL_LIGHTING);
	}

	@Override
	protected void actionPerformed(GuiButton button) {    
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {
		// TODO Auto-generated method stub

		fieldVillagerHeadLeft = this.width / 2 - 192;
		fieldVillagerHeadTop = this.height - 64;
		fieldChatLeft = this.width / 2 - 128;
		fieldChatTop = this.height - 64;
		fieldCompLeft = this.width / 2 - 100;
		fieldCompTop = this.height /2 - 100;
		
		//buttons
		this.buttonList.clear();
		
		super.initGui();
	}

	public void initChatOptionsList(){
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
		
		//auto close gui screen when villager is far away from the player
		if(	this.entityVBVillager == null ||
			this.entityVBVillager.isSleeping() ||
			this.entityVBVillager.getDistanceSqToEntity(Minecraft.getMinecraft().thePlayer) > ConfigVillager.MaxInteractDistanceSq){
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
	}
}