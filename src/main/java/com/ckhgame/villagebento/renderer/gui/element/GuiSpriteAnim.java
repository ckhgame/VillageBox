package com.ckhgame.villagebento.renderer.gui.element;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GuiSpriteAnim extends GuiSprite{

	private int frame;
	private int frameInterval;
	private int frameCount;
	
	public GuiSpriteAnim(double x, double y ,double w, double h,ResourceLocation resource, int frameInterval, int frameCount) {
		super(x, y, w, h, resource);
		this.frameInterval = Math.max(0,frameInterval);
		this.frameCount = Math.max(1, frameCount);
		this.frame = 0;
		this.refresh();
	}

	@Override
	public void update() {	
		int t = (int)(Minecraft.getSystemTime() % (frameInterval * frameCount));
		this.frame = t / frameInterval;
		this.refresh();
	}
	
	private void refresh(){
		float f = 1.0F / frameCount;
		this.umin = f * this.frame;
		this.umax = umin + f;
	}
	
}
