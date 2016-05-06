package ckhbox.villagebox.client.gui.villagebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.villagebook.GuiVillageBook;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkText;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class PageItemList extends Page{
	
	private int pageIdx;
	private static int itemsPerPage = 30;
	
	public PageItemList(GuiVillageBook guiVillageBook, int pageIdx) {
		super(guiVillageBook, StatCollector.translateToLocal(PathHelper.full("villageBook.itemList")));
		this.pageIdx = pageIdx;
	}

	@Override
	public void onInit() {		
		List<ItemStack> itemstacks = this.guiVillageBook.villagebookData.itemstacks;
		int from = pageIdx * itemsPerPage;
		int to = Math.min(itemstacks.size(), (pageIdx+1) * itemsPerPage);
		for(int i =from;i<to;i++){
			this.addLink(new LinkItem(this,itemstacks.get(i),">item=" + itemstacks.get(i).getUnlocalizedName(),null), false);
		}
		
		int top = this.guiVillageBook.getContentTop() + this.guiVillageBook.getContentHeight() - 16;
		if(this.pageIdx > 0){
			this.addLink(new LinkImg(this, this.guiVillageBook.guiBookGuiTextures,208,0,0,16,16,16,"itemlist=" + (this.pageIdx - 1),null),top,0);
		}
		int pageCount = (itemstacks.size() - 1) / itemsPerPage + 1;
		if(this.pageIdx < pageCount - 1){
			this.addLink(new LinkImg(this,this.guiVillageBook.guiBookGuiTextures,192,0,0,16,16,16,"itemlist=" + (this.pageIdx + 1),null),top,2);
		}
		
		this.addLink(new LinkImg(this,this.guiVillageBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
