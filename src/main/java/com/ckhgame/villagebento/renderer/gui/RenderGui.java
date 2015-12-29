package com.ckhgame.villagebento.renderer.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.renderer.gui.element.GuiElement;
import com.ckhgame.villagebento.renderer.gui.element.GuiSprite;
import com.ckhgame.villagebento.renderer.gui.element.GuiText;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public abstract class RenderGui {

	private RenderManager renderManager = null;
	private ArrayList<GuiElement> elements = null;
	
	private void addElement(GuiElement element){
		this.elements.add(element);
	}
	
	protected GuiText addText(double x,double y,String text,boolean center,boolean background){
		GuiText guiText = new GuiText(x,y,renderManager.getFontRenderer(),text,center,background);
		addElement(guiText);
		return guiText;
	}
	
	protected GuiSprite addSprite(double x,double y,double w,double h,ResourceLocation resource){
		GuiSprite guiSprite = new GuiSprite(x,y,w,h,resource);
		addElement(guiSprite);
		return guiSprite;
	}
	
	public void render(Entity entity,double gx,double gy,double gz){		
		
		if(this.elements == null){
			this.elements = new ArrayList<GuiElement>();
			this.renderManager = RenderManager.instance;
			this.init();
		}
		
		double d = entity.getDistanceSqToEntity(this.renderManager.livingPlayer);

		if (d > ConfigVillager.MaxRenderGuiDrawDistanceSq) 
			return;
		
		this.update(entity);
		
		float f = 1.6F;
		float f1 = 0.016666668F * f;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)gx, (float)gy + entity.height + 0.5F, (float)gz);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(-f1, -f1, f1);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		for(GuiElement element : this.elements)
			if(element.isVisible) element.renderBackground();
		GL11.glEnable(GL11.GL_TEXTURE_2D);	
		for(GuiElement element : this.elements){
			if(element.isVisible) element.renderBack();	
		}			
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glPushMatrix();
		for(GuiElement element : this.elements){
			GL11.glTranslatef(0,0,-0.01f);
			if(element.isVisible) element.renderFront();
		}
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}
	
	protected abstract void update(Entity entity);
	protected abstract void init();
}
