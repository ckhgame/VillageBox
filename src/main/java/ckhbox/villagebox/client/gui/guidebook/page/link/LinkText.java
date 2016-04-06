package ckhbox.villagebox.client.gui.guidebook.page.link;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.page.Page;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class LinkText extends Link{

	public String text;
	
	public LinkText(Page page, String text, String link, List<String> tooltips){
		super(page,link,tooltips);
		this.text = text;
		this.width = this.mc.fontRendererObj.getStringWidth(text);
		this.height = this.mc.fontRendererObj.FONT_HEIGHT;
	}
	
	public void onDraw(int mouseX, int mouseY){
		GlStateManager.disableLighting();
		mc.fontRendererObj.drawString(this.text, this.left, this.top, 0xFF000000, false);
		GlStateManager.enableLighting();
	}
	
	public void onDrawHover(int mouseX, int mouseY){
		GlStateManager.disableLighting();
		mc.fontRendererObj.drawString(this.text, this.left, this.top, 0xFF555555, false);
		GlStateManager.enableLighting();
	}
}
