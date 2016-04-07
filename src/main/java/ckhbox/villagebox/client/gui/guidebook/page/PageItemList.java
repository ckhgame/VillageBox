package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.item.ModItems;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.Item;

public class PageItemList extends Page{
	
	private int pageIdx;
	private static int itemsPerPage = 30;
	
	public PageItemList(GuiGuideBook guiGuideBook, int pageIdx) {
		super(guiGuideBook, "Item List");
		this.pageIdx = pageIdx;
	}

	@Override
	public void onInit() {
		Item[] items = this.guiGuideBook.guidebookData.mapItems.values().toArray(new Item[this.guiGuideBook.guidebookData.mapItems.size()]);
		
		int from = pageIdx * itemsPerPage;
		int to = Math.min(items.length, (pageIdx+1) * itemsPerPage);
		for(int i =from;i<to;i++){
			this.addLink(new LinkItem(this,items[i],"item=" + items[i].getUnlocalizedName(),null), false);
		}
		
		int top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 10;
		if(this.pageIdx > 0){
			this.addLink(new LinkText(this,"<--","itemlist=" + (this.pageIdx - 1),null),top,0);
		}
		int pageCount = (items.length - 1) / itemsPerPage + 1;
		if(this.pageIdx < pageCount - 1){
			this.addLink(new LinkText(this,"-->","itemlist=" + (this.pageIdx + 1),null),top,2);
		}
		
		this.addLink(new LinkText(this,"Back","home",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
