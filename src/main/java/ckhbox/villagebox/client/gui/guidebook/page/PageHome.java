package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class PageHome extends Page{

	public PageHome(GuiGuideBook guiGuideBook) {
		super(guiGuideBook,"GuideBook");
	}

	@Override
	public void onInit() {
		this.addLink(new LinkText(this,"Items","itemlist=0",null),false);
		this.addLink(new LinkText(this,"Professions","prolist=0",null),false);
		this.addLink(new LinkText(this,"Beginner","beginner=",null),false);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
		int x = this.guiGuideBook.getContentLeft() + this.guiGuideBook.getContentWidth() / 2 - 25;
		int y = this.guiGuideBook.getContentTop() + 30;
		GlStateManager.disableLighting();
		this.guiGuideBook.drawTexture(x,y, 176, 0, 50, 50);
	}
	
}
