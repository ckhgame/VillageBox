package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VBCompResult;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;

public abstract class GuiVillagerDialog extends GuiScreen{

	protected GuiBoundary boundDialogBar;
	protected GuiBoundary boundPortrait;
	protected GuiBoundary boundCenterContent;
	
	private boolean hideCenterContent = false;
	private int centerContentID = -1;
	
	protected String dialogSource = "";
	protected String dialogDisplay = "";
	
	protected List mouseHoverTexts;
	
	protected EntityVBVillager entityVBVillager;
	
	public GuiVillagerDialog(EntityVBVillager entityVBVillager){
		this.entityVBVillager = entityVBVillager;
	}

	protected void drawCenterContent(int centerContentID, int mx, int my, float f){
		this.drawBoundaryBackground(this.boundCenterContent);
	}
	
	protected void showCenterContent(int id){
		this.centerContentID = id;
		this.hideCenterContent = false;
	}
	
	protected void hideCenterContent(){
		this.hideCenterContent = true;
	}
	
	public int getCentercontentID(){
		return this.centerContentID;
	}
	
	protected void clearAllDialogOptions(){
		this.buttonList.clear();
	}
	
	protected void addDialogOptions(int id, int idx, String text){
		String prefix = "> ";
		int maxCol = 2;
		int yOffset = 28;
		int xOffset = 8;
		int lineHeight = 10;
		int x = this.boundDialogBar.getIntX()  + xOffset + (idx % maxCol) * this.boundDialogBar.getIntW() / 2;
		int y = this.boundDialogBar.getIntY() + yOffset + (idx / maxCol) * lineHeight;
		this.buttonList.add(new GuiTextButton(this.mc, id, x, y, prefix + text));
	}
	
	protected void setDialogString(String dialog){
		this.dialogSource = dialog;
		this.dialogDisplay = "";
	}
	
	protected void drawDialogBar(int mx, int my, float f){
		//portrait
		this.drawBoundaryBackground(this.boundPortrait);
		
		int pMargin = 4;
		this.drawVillagerHead(this.boundPortrait.getIntX() + pMargin,
												this.boundPortrait.getIntY() + pMargin,
												this.boundPortrait.getIntW() - pMargin * 2,
												this.boundPortrait.getIntH() - pMargin * 2);
				
		
		//dialogbar
		this.drawBoundaryBackground(this.boundDialogBar);
		
			String name = this.entityVBVillager.getName();
			String info ="Lv" + (this.entityVBVillager.getLevel() +1 ) + " " + this.entityVBVillager.getProfession().getProfessionName();
			
			int yOffset = 2;
			this.fontRendererObj.drawString(name, this.boundDialogBar.getIntX() + 4,this.boundDialogBar.getIntY() + yOffset, 0xFFFFFF00,true);
			this.fontRendererObj.drawString(info, this.boundDialogBar.getIntX() + 8 + this.fontRendererObj.getStringWidth(name), this.boundDialogBar.getIntY() + yOffset, 0xFFFFAA00,true);
			
			//dialog animation
			if(this.dialogDisplay.length() < this.dialogSource.length()){
				this.dialogDisplay = this.dialogSource.substring(0, this.dialogDisplay.length() + 1);
			}
			yOffset = 15;
			this.fontRendererObj.drawString(this.dialogDisplay, this.boundDialogBar.getIntX() + 8,this.boundDialogBar.getIntY() + yOffset, 0xFFFFFFEE,true);
	}
	
	protected void initBoundaries(){
		this.boundDialogBar = new GuiBoundary(this.width / 2 - 128, this.height - 64, 320, 64);
		this.boundPortrait = new GuiBoundary(this.width / 2 - 192, this.height - 64,64, 64);
		this.boundCenterContent = new GuiBoundary(this.width / 2 - 128, this.height / 2 - 96, 256, 128);
	}
	
	/**
	 * @return false means first time (used for initialization..)
	 */
	public boolean updateWithVBCompResult(VBCompResult vbCompResult){
		if(vbCompResult.chatContent != null && vbCompResult.chatContent != ""){
			this.setDialogString(vbCompResult.chatContent);
			return true;
		}
		return false;
	}
	
	public void clearMouseHoverTexts(){
		this.mouseHoverTexts = null;
	}
	
	public void drawMouseHoverTexts(int mx, int my){
		if(this.mouseHoverTexts != null){
			this.drawHoveringText(this.mouseHoverTexts, mx, my, this.fontRendererObj);
		}
	}
	
	public void setMouseHoverTexts(List texts){
		this.mouseHoverTexts = texts;
	}
	
	public abstract void initDialog();
	
	//---------------------------------------------
	//methods inherits from GuiScreen
	//---------------------------------------------
	@Override
	public void drawScreen(int mx, int my, float f) {
		this.clearMouseHoverTexts();
		this.drawDialogBar(mx,my,f);
		if(!hideCenterContent){
			this.drawCenterContent(this.centerContentID,mx, my, f);
		}
		super.drawScreen(mx, my, f);
		this.drawMouseHoverTexts(mx, my);
	}
	@Override
	public void initGui() {
		super.initGui();
		this.initBoundaries();
		this.initDialog();
	}
	@Override
	public void updateScreen() {
		super.updateScreen();
	}
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	//---------------------------------------------
	//helper functions
	//---------------------------------------------
	protected void drawBoundaryBackground(GuiBoundary bound){
		int left = bound.getIntX();
		int top = bound.getIntY();
		int width = bound.getIntW();
		int height = bound.getIntH();
		drawRect(left, top, left + width, top + height, 0xFF333333);
		drawRect(left + 1, top + 1, left + width - 1, top + height - 1, 0xFF111111);
		drawRect(left + 2, top + 2, left + width - 2, top + height - 2, 0xFF555555);
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
	
	protected void drawVillagerHead(int left, int top, int width, int height){
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
        
        if(this.dialogSource != null && this.dialogDisplay != null){
        	int lc = this.dialogSource.length();
            int lcd = this.dialogDisplay.length();
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
	
	/**
	 * 
	 * @return true: the mouse is currenly on the item
	 */
	protected boolean drawItem(int mx, int my, int x, int y, ItemStack itemStack){
		//item icon
		int left = x + 2;
		int top = y + 2;
		int w = 16;
		int h = 16;
		drawRect(left - 2, top - 2, left + w + 2, top + h + 2, 0xFF888888);
		drawRect(left - 1, top - 1, left + w + 1, top + h + 1, 0xFFCCCCCC);
		drawRect(left, top, left + w, top + h, 0xFFAAAAAA);	
		
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left, top);
		if(itemStack.getItem() == ModItems.itemVillageCurrency){
			String num = "x" + itemStack.getItemDamage();
			fontRendererObj.drawString(num, left + 20, top + 6, 0xFFFFFFFF);
		}
		else{
			String num = String.valueOf(itemStack.stackSize);
			itemRender.renderItemOverlayIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left, top, num);
		}
		
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		if(mx < left || my < top || mx > left + w || my > top + h)
			return false;
		
		return true;
	}

}
