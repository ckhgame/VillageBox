package ckhbox.villagebox.client.gui.villagebook.page.link;

import java.util.List;

import ckhbox.villagebox.client.gui.villagebook.page.Page;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LinkItem extends Link{

	public ItemStack itemstack;
	
	public LinkItem(Page page, ItemStack itemstack, String link, List<String> tooltips){
		super(page,link,tooltips);
		this.itemstack = itemstack;
		this.width = 20;
		this.height = 20;
	}
	
	public void onDraw(int mouseX, int mouseY){
		this.page.guiVillageBook.drawItem(this.itemstack, this.left, this.top);
	}
	
	public void onDrawHover(int mouseX, int mouseY){
		this.page.guiVillageBook.drawItem(this.itemstack, this.left, this.top - 2);
	}
	
	public void onDrawToolTip(int mouseX, int mouseY){
		if(this.itemstack != null){
			this.page.guiVillageBook.renderToolTip(this.itemstack, mouseX, mouseY);
		}
	}
}
