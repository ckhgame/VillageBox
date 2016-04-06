package ckhbox.villagebox.client.gui.guidebook.page.link;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.page.Page;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LinkItem extends Link{

	public ItemStack item;
	
	public LinkItem(Page page, Item item, String link, List<String> tooltips){
		super(page,link,tooltips);
		this.item = new ItemStack(item);
		this.width = 20;
		this.height = 20;
	}
	
	public void onDraw(int mouseX, int mouseY){
		this.page.guiGuideBook.drawItem(this.item, this.left, this.top);
	}
	
	public void onDrawHover(int mouseX, int mouseY){
		this.onDraw(mouseX, mouseY);
	}
	
	public void onDrawToolTip(int mouseX, int mouseY){
		if(this.item != null){
			this.page.guiGuideBook.renderToolTip(this.item, mouseX, mouseY);
		}
	}
}
