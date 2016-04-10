package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class PageItemList extends Page{
	
	private int pageIdx;
	private static int itemsPerPage = 30;
	
	public PageItemList(GuiGuideBook guiGuideBook, int pageIdx) {
		super(guiGuideBook, StatCollector.translateToLocal(PathHelper.full("guideBook.itemList")));
		this.pageIdx = pageIdx;
	}

	@Override
	public void onInit() {		
		List<ItemStack> itemstacks = this.guiGuideBook.guidebookData.itemstacks;
		int from = pageIdx * itemsPerPage;
		int to = Math.min(itemstacks.size(), (pageIdx+1) * itemsPerPage);
		for(int i =from;i<to;i++){
			this.addLink(new LinkItem(this,itemstacks.get(i),">item=" + itemstacks.get(i).getUnlocalizedName(),null), false);
		}
		
		int top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 16;
		if(this.pageIdx > 0){
			this.addLink(new LinkImg(this, this.guiGuideBook.guiBookGuiTextures,208,0,0,16,16,16,"itemlist=" + (this.pageIdx - 1),null),top,0);
		}
		int pageCount = (itemstacks.size() - 1) / itemsPerPage + 1;
		if(this.pageIdx < pageCount - 1){
			this.addLink(new LinkImg(this,this.guiGuideBook.guiBookGuiTextures,192,0,0,16,16,16,"itemlist=" + (this.pageIdx + 1),null),top,2);
		}
		
		this.addLink(new LinkImg(this,this.guiGuideBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
