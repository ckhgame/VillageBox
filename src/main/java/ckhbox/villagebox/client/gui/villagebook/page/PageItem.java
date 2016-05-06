package ckhbox.villagebox.client.gui.villagebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.villagebook.GuiVillageBook;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkPro;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkText;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.item.ItemStack;

public class PageItem extends Page{
	
	private ItemStack itemstack;
	private static int itemsPerPage = 30;
	
	public PageItem(GuiVillageBook guiVillageBook, ItemStack itemstack) {
		super(guiVillageBook, itemstack.getDisplayName());
		this.itemstack = itemstack;
	}

	@Override
	public void onInit() {
		
		//this.addLink(new LinkItem(this,this.itemstack.getItem(),null,null),top,1);
		int top = this.guiVillageBook.getContentTop() + 32;
		this.addLink(new LinkItem(this,this.itemstack,null,null),top,1);
		
		//related professions
		top += 32;
		List<Profession> relatedPros = this.guiVillageBook.villagebookData.findRelatedProByItem(this.itemstack);		
		for(int i =0;i<relatedPros.size();i++){
			Profession pro = relatedPros.get(i);
			this.addLink(new LinkPro(this,pro,">pro=" + pro.getRegID(),null),top + 12*i,1);
		}
		
		top = this.guiVillageBook.getContentTop() + this.guiVillageBook.getContentHeight() - 16;
		this.addLink(new LinkImg(this,this.guiVillageBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
	}
	
}
