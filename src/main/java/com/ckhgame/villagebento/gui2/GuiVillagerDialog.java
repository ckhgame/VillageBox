package com.ckhgame.villagebento.gui2;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;

public class GuiVillagerDialog extends GuiScreen{

	protected GuiBoundary boundDialogBar;
	protected GuiBoundary boundPortrait;
	protected GuiBoundary boundCenterContent;
	
	private boolean hideCenterContent = false;
	private int centerContentID = -1;
	
	protected String dialogSource,dialogDisplay;
	
	protected EntityVBVillager entityVBVillager;
	
	public GuiVillagerDialog(EntityVBVillager entityVBVillager){
		this.entityVBVillager = entityVBVillager;
	}
	
	protected void initCenterContent(){
		
	}
	
	protected void drawCenterContent(int centerContentID){
		this.drawBoundaryBackground(this.boundCenterContent);
	}
	
	protected void showCenterContent(int id){
		this.centerContentID = id;
		this.hideCenterContent = false;
	}
	
	protected void hideCenterContent(){
		this.hideCenterContent = true;
	}
	
	protected void initDialogAndOptions(){
		
	}
	
	protected void clearAllDialogOptions(){
		this.buttonList.clear();
	}
	
	protected void addDialogOptions(int id, int idx, String text){
		String prefix = "> ";
		int maxCol = 3;
		int yOffset = 28;
		int lineHeight = 10;
		int x = this.boundDialogBar.getIntX() + (idx / maxCol) * this.boundDialogBar.getIntW() / 2;
		int y = this.boundDialogBar.getIntY() + yOffset + (idx % maxCol) * lineHeight;
		this.buttonList.add(new GuiTextButton(this.mc, id, x, y, prefix + text));
	}
	
	protected void setDialogString(String dialog){
		this.dialogSource = dialog;
		this.dialogDisplay = "";
	}
	
	protected void drawDialogBar(){
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
	
	//---------------------------------------------
	//methods inherits from GuiScreen
	//---------------------------------------------
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		this.drawDialogBar();
		if(!hideCenterContent){
			this.drawCenterContent(this.centerContentID);
		}
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}
	@Override
	public void initGui() {
		super.initGui();
		this.initBoundaries();
		this.initDialogAndOptions();
		this.initCenterContent();
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
	
}
