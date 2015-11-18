package com.ckhgame.villagebento.renderer.gui;

import net.minecraft.client.gui.FontRenderer;

public class GuiText extends GuiElement{
	
	public String text;
	public FontRenderer fontRenderer;
	public boolean center;
	
	public GuiText(double x, double y, FontRenderer fontRenderer,String text,boolean center) {
		super(x, y, 0, 8);
		this.text = text;
		this.fontRenderer = fontRenderer;
		this.width = this.fontRenderer.getStringWidth(this.text);
		this.center = center;
		if(this.center)
			this.x -= this.width * 0.5D;
	}

	@Override
	public void renderFront() {
		fontRenderer.drawString(text, (int)x, (int)y, -1);
	}

	@Override
	public void renderBack() {
		fontRenderer.drawString(text, (int)x, (int)y, 553648127);
	}
}
