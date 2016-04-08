package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;
import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.village.profession.Profession;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.item.ItemStack;

public class PageTrading extends Page{
	
	private Profession pro;
	private int pageIdx;
	private static int itemsPerPage = 30;
	
	public PageTrading(GuiGuideBook guiGuideBook, Profession pro, int pageIdx) {
		super(guiGuideBook, pro.getDisplayName());
		this.pageIdx = pageIdx;
		this.pro = pro;
	}

	@Override
	public void onInit() {		
		List<ItemStack> itemstacks = new ArrayList<ItemStack>();
		if(this.pro.getTradingRecipeList() != null){
			for(TradingRecipe recipe : this.pro.getTradingRecipeList()){
				itemstacks.add(recipe.getItemOutput());
			}
		}
		
		int from = pageIdx * itemsPerPage;
		int to = Math.min(itemstacks.size(), (pageIdx+1) * itemsPerPage);
		for(int i =from;i<to;i++){
			this.addLink(new LinkItem(this,itemstacks.get(i),null,null), false);
		}
		
		int top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 10;
		if(this.pageIdx > 0){
			this.addLink(new LinkText(this,"<--","trading=" + this.pro.getRegID() + "," + (this.pageIdx - 1),null),top,0);
		}
		int pageCount = (itemstacks.size() - 1) / itemsPerPage + 1;
		if(this.pageIdx < pageCount - 1){
			this.addLink(new LinkText(this,"-->","trading="  + this.pro.getRegID() + "," + (this.pageIdx + 1),null),top,2);
		}
		
		this.addLink(new LinkText(this,"Back","back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
