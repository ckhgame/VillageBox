package ckhbox.villagebox.client.gui.villagebook.page;

import java.util.ArrayList;
import java.util.List;

import ckhbox.villagebox.client.gui.villagebook.GuiVillageBook;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkText;
import ckhbox.villagebox.common.village.profession.Profession;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class PageTrading extends Page{
	
	private Profession pro;
	private int pageIdx;
	private static int itemsPerPage = 30;
	
	public PageTrading(GuiVillageBook guiVillageBook, Profession pro, int pageIdx) {
		super(guiVillageBook, I18n.format(pro.getUnloalizedDisplayName()));
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
		
		int top = this.guiVillageBook.getContentTop() + this.guiVillageBook.getContentHeight() - 16;
		if(this.pageIdx > 0){
			this.addLink(new LinkText(this,"<--","trading=" + this.pro.getRegID() + "," + (this.pageIdx - 1),null),top,0);
		}
		int pageCount = (itemstacks.size() - 1) / itemsPerPage + 1;
		if(this.pageIdx < pageCount - 1){
			this.addLink(new LinkText(this,"-->","trading="  + this.pro.getRegID() + "," + (this.pageIdx + 1),null),top,2);
		}
		
		this.addLink(new LinkImg(this,this.guiVillageBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
