package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StatCollector;

public class PageHome extends Page{

	public PageHome(GuiGuideBook guiGuideBook) {
		super(guiGuideBook,StatCollector.translateToLocal(PathHelper.full("guideBook.title")));
	}

	@Override
	public void onInit() {
		int top = this.guiGuideBook.getContentTop();
		this.addLink(new LinkText(this,"> " + StatCollector.translateToLocal(PathHelper.full("guideBook.itemList")),">itemlist=0",null),top + 80,1);
		this.addLink(new LinkText(this,"> " + StatCollector.translateToLocal(PathHelper.full("guideBook.professions")),">prolist=0",null),top + 100,1);
		this.addLink(new LinkText(this,"> " + StatCollector.translateToLocal(PathHelper.full("guideBook.tutorial")),">tutorial=",null),top + 120,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
		int x = this.guiGuideBook.getContentLeft() + this.guiGuideBook.getContentWidth() / 2 - 74;
		int y = this.guiGuideBook.getContentTop() + 20;
		GlStateManager.disableLighting();
		this.guiGuideBook.drawTexture(x,y, 0, 180, 148, 51);
	}
	
}
