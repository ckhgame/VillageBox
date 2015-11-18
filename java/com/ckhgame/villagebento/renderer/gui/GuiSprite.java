package com.ckhgame.villagebento.renderer.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GuiSprite extends GuiElement{

	public ResourceLocation resource;
	
	public GuiSprite(double x, double y, double w, double h,ResourceLocation resource) {
		super(x, y, w, h);
		this.resource = resource;
	}

	@Override
	public void renderFront() {
		Tessellator tessellator = Tessellator.instance;
		Minecraft.getMinecraft().renderEngine.bindTexture(resource);
    	tessellator.startDrawingQuads();
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	tessellator.addVertexWithUV(x, y, 0.0D,0.0D,0.0D);
		tessellator.addVertexWithUV(x, y + height, 0.0D,0.0D,1.0D);
		tessellator.addVertexWithUV(x + width, y + height, 0.0D,1.0D,1.0D);
		tessellator.addVertexWithUV(x + width, y, 0.0D,1.0D,0.0D);
		tessellator.draw();
	}

	@Override
	public void renderBack() {
		Tessellator tessellator = Tessellator.instance;
		Minecraft.getMinecraft().renderEngine.bindTexture(resource);
    	tessellator.startDrawingQuads();
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.3F);
    	tessellator.addVertexWithUV(x, y, 0.0D,0.0D,0.0D);
		tessellator.addVertexWithUV(x, y + height, 0.0D,0.0D,1.0D);
		tessellator.addVertexWithUV(x + width, y + height, 0.0D,1.0D,1.0D);
		tessellator.addVertexWithUV(x + width, y, 0.0D,1.0D,0.0D);
		tessellator.draw();
	}
	
}
