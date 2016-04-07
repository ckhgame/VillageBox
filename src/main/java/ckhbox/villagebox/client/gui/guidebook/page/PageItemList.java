package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import net.minecraft.item.ItemStack;

public class PageItemList extends Page{
	
	private int pageIdx;
	private static int itemsPerPage = 30;
	
	public PageItemList(GuiGuideBook guiGuideBook, int pageIdx) {
		super(guiGuideBook, "Item List");
		this.pageIdx = pageIdx;
	}

	@Override
	public void onInit() {		
		List<ItemStack> itemstacks = this.guiGuideBook.guidebookData.itemstacks;
		int from = pageIdx * itemsPerPage;
		int to = Math.min(itemstacks.size(), (pageIdx+1) * itemsPerPage);
		for(int i =from;i<to;i++){
			this.addLink(new LinkItem(this,itemstacks.get(i),"item=" + itemstacks.get(i).getUnlocalizedName(),null), false);
		}
		
		int top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 10;
		if(this.pageIdx > 0){
			this.addLink(new LinkText(this,"<--","itemlist=" + (this.pageIdx - 1),null),top,0);
		}
		int pageCount = (itemstacks.size() - 1) / itemsPerPage + 1;
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
