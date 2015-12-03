package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.book.VBBook;
import com.ckhgame.villagebento.book.VBBookPage;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;

public class GuiVBBook extends GuiScreen {

	private GuiButton buttonPrevPage;
	private GuiButton buttonNextPage;
	private int pageIdx = 0;
	
	private VBBook book;
	public void setBook(VBBook book){
		this.book = book;
	}

	private VBBookPage getPage(){
		return  this.book.getPage(this.pageIdx);
	}
	
	private void drawFieldBackground(int left,int top,int width,int height){
		
		drawRect(left - 2, top - 2, left + width + 2, top + height + 2, 0xFF993333);
		drawRect(left - 1, top, left + width + 1, top + height, 0xFF111111);
		drawRect(left, top, left + width, top + height, 0xFFCCCCAA);
		drawRect(left + width / 2 - 2, top, left + width / 2 + 2, top + height, 0xFF999977);
	}
	

	
	protected void drawWrappedString(FontRenderer renderer, String text, int x, int y, int color, int wrap)
    {
        List<String> lines = renderer.listFormattedStringToWidth(text, wrap);
        for (int i = 0; i < lines.size(); i++)
            renderer.drawString(lines.get(i), x, y + (i * 9), color, false);
    }
	
	
	private void drawPageText(int left, int top, int width, int height){
		this.drawCenteredString(this.fontRendererObj, this.getPage().getTitle(), left + width / 2, top + 5, 0xFF000000);
		this.drawWrappedString(this.fontRendererObj, this.getPage().getText(), left, top + 20, 0xFF111111, width);
	}
	
	private void drawPageImage(int left, int top, int width, int height){

		this.mc.getTextureManager().bindTexture(getPage().getResouceLocation());
		
		int x = left;
		int y = top + 2;
		int w = width;
		
		int tw = GL11.glGetTexLevelParameteri(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH);
		int th = GL11.glGetTexLevelParameteri(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_HEIGHT);
		float aspect = th * 1.0F / tw;
		
		int h = (int)(aspect * w);
		
        GL11.glDisable(GL11.GL_BLEND);    
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)x, (double)(y + h), (double)this.zLevel, 0.0D, 1.0D);
        tessellator.addVertexWithUV((double)(x + w), (double)(y + h), (double)this.zLevel, 1.0D, 1.0D);
        tessellator.addVertexWithUV((double)(x + w), (double)y, (double)this.zLevel, 1.0D, 0.0D);
        tessellator.addVertexWithUV((double)x, (double)y, (double)this.zLevel, 0.0D, 0.0D);
        tessellator.draw();
        
        GL11.glEnable(GL11.GL_BLEND); 
		
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {	
		
		this.drawDefaultBackground();
		
		this.drawFieldBackground(this.width / 2 - 130, this.height / 2 - 90, 260, 160);
		
		//page number
		String pageNum1 = "- " + (this.pageIdx * 2 + 1) + " -";
		String pageNum2 = (this.pageIdx == this.book.getPageSize() - 1)?"- End - " : "- " + (this.pageIdx * 2 + 2) + " -";
		this.drawCenteredString(this.fontRendererObj, pageNum1, this.width /2 - 65,  this.height /2 + 55, 0xFF333311);
		this.drawCenteredString(this.fontRendererObj, pageNum2, this.width /2 + 65,  this.height /2 + 55, 0xFF333311);
		
		if(this.pageIdx % 2 == 0){
			this.drawPageText(this.width / 2 - 125, this.height /2 - 88, 120, 130);
			this.drawPageImage(this.width / 2 + 5, this.height /2 - 88, 120, 130);
		}
		else{
			this.drawPageImage(this.width / 2 - 125, this.height /2 - 88, 120, 130);
			this.drawPageText(this.width / 2 + 5, this.height /2 - 88, 120, 130);
		}
		
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);	
				
	}

	@Override
	protected void actionPerformed(GuiButton button) {

		//leave
		if(button.id == this.buttonPrevPage.id){
			if(pageIdx > 0){
				pageIdx--;
			}
		}
		else if(button.id == this.buttonNextPage.id){
			if(pageIdx < this.book.getPageSize() - 1)
			pageIdx++;
		}
        
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {
		super.initGui();
		this.pageIdx = 0;
		
		this.buttonList.clear();
		
		this.buttonPrevPage = new GuiButton(0,this.width/2 - 100,this.height/2 + 80, 40, 20,"<--");
		this.buttonList.add(this.buttonPrevPage);
		
		this.buttonNextPage = new GuiButton(1,this.width/2 + 60,this.height/2 + 80, 40, 20,"-->");
		this.buttonList.add(this.buttonNextPage);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
}
