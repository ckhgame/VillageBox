package ckhbox.villagebox.client.gui.villagebook.page;

import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.client.gui.villagebook.GuiVillageBook;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkText;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StatCollector;

public class PageHome extends Page{

	public PageHome(GuiVillageBook guiVillageBook) {
		super(guiVillageBook,StatCollector.translateToLocal(PathHelper.full("villageBook.title")));
	}

	@Override
	public void onInit() {
		int top = this.guiVillageBook.getContentTop();
		//this.addLink(new LinkText(this,"> " + StatCollector.translateToLocal(PathHelper.full("villageBook.itemList")),">itemlist=0",null),top + 80,1);
		this.addLink(new LinkText(this,"> " + StatCollector.translateToLocal(PathHelper.full("villageBook.professions")),">prolist=0",null),top + 90,1);
		this.addLink(new LinkText(this,"> " + StatCollector.translateToLocal(PathHelper.full("villageBook.tutorial")),">tutorial=",null),top + 110,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
		int x = this.guiVillageBook.getContentLeft() + this.guiVillageBook.getContentWidth() / 2 - 74;
		int y = this.guiVillageBook.getContentTop() + 20;
		GlStateManager.disableLighting();
		this.guiVillageBook.drawTexture(x,y, 0, 180, 148, 51);
	}
	
}
