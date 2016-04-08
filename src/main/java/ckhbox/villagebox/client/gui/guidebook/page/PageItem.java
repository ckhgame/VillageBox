package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.item.ItemStack;

public class PageItem extends Page{
	
	private ItemStack itemstack;
	private static int itemsPerPage = 30;
	
	public PageItem(GuiGuideBook guiGuideBook, ItemStack itemstack) {
		super(guiGuideBook, itemstack.getDisplayName());
		this.itemstack = itemstack;
	}

	@Override
	public void onInit() {
		
		//this.addLink(new LinkItem(this,this.itemstack.getItem(),null,null),top,1);
		int top = this.guiGuideBook.getContentTop() + 32;
		this.addLink(new LinkItem(this,this.itemstack,null,null),top,1);
		
		this.setFlowTop(this.guiGuideBook.getContentTop() + 64);
		//related professions
		List<Profession> relatedPros = this.guiGuideBook.guidebookData.findRelatedProByItem(this.itemstack);		
		for(Profession pro : relatedPros){
			this.addLink(new LinkText(this,pro.getDisplayName(),">pro=" + pro.getRegID(),null),false);
		}
		
		top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 10;
		this.addLink(new LinkText(this,"Back","back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
