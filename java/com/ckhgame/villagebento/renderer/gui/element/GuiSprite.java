package com.ckhgame.villagebento.renderer.gui.element;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GuiSprite extends GuiElement{

	public ResourceLocation resource;
	public double umin = 0.0F;
	public double vmin = 0.0F;
	public double umax = 1.0F;
	public double vmax = 1.0F;
	public float r = 1.0F;
	public float g = 1.0F;
	public float b = 1.0F;
	
	
	public GuiSprite(double x, double y ,double w, double h,ResourceLocation resource) {
		super(x, y, w, h);
		this.resource = resource;
	}

	
	
	@Override
	public void renderFront() {
		Tessellator tessellator = Tessellator.instance;
		Minecraft.getMinecraft().renderEngine.bindTexture(resource);
    	tessellator.startDrawingQuads();
    	GL11.glColor4f(r, g, b, 1.0F);
    	tessellator.addVertexWithUV(x, -y-height, 0.0D,umin,vmin);
		tessellator.addVertexWithUV(x, -y, 0.0D,umin,vmax);
		tessellator.addVertexWithUV(x + width, -y, 0.0D,umax,vmax);
		tessellator.addVertexWithUV(x + width, -y - height, 0.0D,umax,vmin);
		tessellator.draw();
	}

	@Override
	public void renderBack() {
		Tessellator tessellator = Tessellator.instance;
		Minecraft.getMinecraft().renderEngine.bindTexture(resource);
    	tessellator.startDrawingQuads();
    	GL11.glColor4f(r, g, b, 0.3F);
    	tessellator.addVertexWithUV(x, -y-height, 0.0D,umin,vmin);
		tessellator.addVertexWithUV(x, -y, 0.0D,umin,vmax);
		tessellator.addVertexWithUV(x + width, -y, 0.0D,umax,vmax);
		tessellator.addVertexWithUV(x + width, -y - height, 0.0D,umax,vmin);
		tessellator.draw();
	}



	@Override
	public void renderBackground() {
		// TODO Auto-generated method stub
		
	}
	
}
