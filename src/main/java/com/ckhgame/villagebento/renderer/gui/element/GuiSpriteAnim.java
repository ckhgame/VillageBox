package com.ckhgame.villagebento.renderer.gui.element;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GuiSpriteAnim extends GuiSprite{

	private float timer;
	private int frame;
	private float frameInterval;
	private int frameCount;
	
	public GuiSpriteAnim(double x, double y ,double w, double h,ResourceLocation resource, float frameInterval, int frameCount) {
		super(x, y, w, h, resource);
		this.frameInterval = Math.max(0,frameInterval);
		this.frameCount = Math.max(1, frameCount);
		this.timer = 0.0F;
		this.frame = 0;
		this.refresh();
	}

	@Override
	public void update(float dt) {	
		timer += dt;
		if(timer > frameInterval){
			this.frame = (this.frame + 1) % this.frameCount;
			refresh();
			timer -= frameInterval;
		}
	}
	
	private void refresh(){
		float f = 1.0F / frameCount;
		this.umin = f * this.frame;
		this.umax = umin + f;
	}
	
}
