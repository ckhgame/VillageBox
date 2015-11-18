package com.ckhgame.villagebento.renderer.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGui {

	private RenderManager renderManager;
	private ArrayList<GuiElement> elements = new ArrayList<GuiElement>();
	private double x;
	private double y;
	private double width;
	private double height;
	
	public RenderGui(RenderManager renderManager){
		this.renderManager = renderManager;
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	private void addElement(GuiElement element){
		this.elements.add(element);
		//calculate new size of gui
		if(this.x > element.x) this.x = element.x;
		if(this.y > element.y) this.y = element.y;
		if(this.x + this.width < element.x + element.width) this.width = element.x + element.width - this.x;
		if(this.y + this.height < element.y + element.height) this.height = element.y + element.height - this.y;
	}
	
	public GuiText addText(double x,double y,String text,boolean center){
		GuiText guiText = new GuiText(x,y,renderManager.getFontRenderer(),text,center);
		addElement(guiText);
		return guiText;
	}
	
	public GuiSprite addSprite(double x,double y,double w,double h,ResourceLocation resource){
		GuiSprite guiSprite = new GuiSprite(x,y,w,h,resource);
		addElement(guiSprite);
		return guiSprite;
	}
	
	public void render(Entity entity,double gx,double gy,double gz){
		float f = 1.6F;
		float f1 = 0.016666668F * f;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)gx, (float)gy + entity.height + 0.7F, (float)gz);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(-f1, -f1, f1);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		Tessellator tessellator = Tessellator.instance;
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
		tessellator.addVertex(x, y, 0.0D);
		tessellator.addVertex(x, y + height, 0.0D);
		tessellator.addVertex(x + width, y + height, 0.0D);
		tessellator.addVertex(x + width, y, 0.0D);
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);	
		for(GuiElement element : this.elements)
			element.renderBack();	
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		for(GuiElement element : this.elements)
			element.renderFront();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}
}
