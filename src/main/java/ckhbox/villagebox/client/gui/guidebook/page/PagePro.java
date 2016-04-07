package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.item.ItemStack;

public class PagePro extends Page{
	
	private Profession pro;
	private static int itemsPerPage = 30;
	
	public PagePro(GuiGuideBook guiGuideBook, Profession pro) {
		super(guiGuideBook, pro.getDisplayName());
		this.pro = pro;
	}

	@Override
	public void onInit() {
		
		//this.addLink(new LinkItem(this,this.itemstack.getItem(),null,null),top,1);
		int top = this.guiGuideBook.getContentTop() + 32;
		
		this.setFlowTop(this.guiGuideBook.getContentTop() + 64);
		String upgrade = "Upgrades";
		String trading = "Trading List";
		this.addLink(new LinkText(this,upgrade,"prou=" + this.pro.getRegID(),null),false);
		this.addLink(new LinkText(this,trading,"prot=" + this.pro.getRegID(),null),false);
		
		top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 10;
		this.addLink(new LinkText(this,"Back","prolist=0",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
