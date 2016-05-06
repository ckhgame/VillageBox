package ckhbox.villagebox.client.gui.villagebook.page.link;

import java.util.List;

import ckhbox.villagebox.client.gui.villagebook.page.Page;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.client.renderer.GlStateManager;

public class LinkPro extends Link{

	public Profession pro;
	
	public LinkPro(Page page, Profession pro, String link, List<String> tooltips){
		super(page,link,tooltips);
		this.pro = pro;
		this.width = this.mc.fontRendererObj.getStringWidth(this.pro.getDisplayName()) + 20;
		this.height = 16;
	}
	
	public void onDraw(int mouseX, int mouseY){
		GlStateManager.disableLighting();
		mc.fontRendererObj.drawString(this.pro.getDisplayName(), this.left + 18, this.top, 0xFF000000, false);
		this.page.guiVillageBook.drawProHead(this.left, this.top, pro, false);
		this.page.guiVillageBook.drawProHead(this.left + 8, this.top + 2, pro, true);
		GlStateManager.enableLighting();
	}
	
	public void onDrawHover(int mouseX, int mouseY){
		GlStateManager.disableLighting();
		mc.fontRendererObj.drawString(this.pro.getDisplayName(), this.left + 20, this.top, 0xFF555555, false);
		this.page.guiVillageBook.drawProHead(this.left, this.top + 2, pro, false);
		this.page.guiVillageBook.drawProHead(this.left + 8, this.top, pro, true);
		GlStateManager.enableLighting();
	}
}
