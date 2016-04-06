package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.item.ModItems;
import net.minecraft.client.gui.GuiButton;

public class PageItemList extends Page{

	public PageItemList(GuiGuideBook guiGuideBook) {
		super(guiGuideBook);
	}

	@Override
	public void onInit() {
		this.addLink(new LinkText(this,"Home","home",null),false);
		this.addLink(new LinkItem(this,ModItems.appleCandy,"item:appleCandy",null), false);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
