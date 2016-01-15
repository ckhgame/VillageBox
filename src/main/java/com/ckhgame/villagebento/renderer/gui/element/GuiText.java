package com.ckhgame.villagebento.renderer.gui.element;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;

public class GuiText extends GuiElement {

	public String text;
	public FontRenderer fontRenderer;
	public boolean center;
	public boolean backgound;
	private double oriX;

	public GuiText(double x, double y, FontRenderer fontRenderer, String text, boolean center, boolean backgound) {
		super(x, y, 0, 8);
		this.text = text;
		this.fontRenderer = fontRenderer;
		this.center = center;
		this.backgound = backgound;
		this.oriX = x;
	}

	@Override
	public void renderFront() {
		fontRenderer.drawString(text, (int) x, (int) (-y - height), -1);
	}

	@Override
	public void renderBack() {

		this.width = this.fontRenderer.getStringWidth(this.text);
		if (this.center)
			this.x = this.oriX - this.width * 0.5D;
		else
			this.x = this.oriX;

		fontRenderer.drawString(text, (int) x, (int) (-y - height), 553648127);
	}

	@Override
	public void renderBackground() {

		if (!backgound)
			return;
		
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
		tessellator.addVertex(x, -y - height, 0.0D);
		tessellator.addVertex(x, -y, 0.0D);
		tessellator.addVertex(x + width, -y, 0.0D);
		tessellator.addVertex(x + width, -y - height, 0.0D);
		tessellator.draw();
		
	}
	
	@Override
	public void update() {		
	}
}
