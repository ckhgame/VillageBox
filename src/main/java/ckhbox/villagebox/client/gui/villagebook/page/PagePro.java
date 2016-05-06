package ckhbox.villagebox.client.gui.villagebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.villagebook.GuiVillageBook;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkText;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class PagePro extends Page{
	
	private Profession pro;
	private static int itemsPerPage = 30;
	
	public PagePro(GuiVillageBook guiVillageBook, Profession pro) {
		super(guiVillageBook, pro.getDisplayName());
		this.pro = pro;
	}

	@Override
	public void onInit() {
		
		//this.addLink(new LinkItem(this,this.itemstack.getItem(),null,null),top,1);
		int top = this.guiVillageBook.getContentTop() + 90;
		String trading = "> " + StatCollector.translateToLocal(PathHelper.full("villageBook.tradingList"));
		this.addLink(new LinkText(this,trading,">trading=" + this.pro.getRegID() + ",0",null),top,1);
		
		top = this.guiVillageBook.getContentTop() + this.guiVillageBook.getContentHeight() - 16;
		this.addLink(new LinkImg(this,this.guiVillageBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
		
		int top = this.guiVillageBook.getContentTop() + 50;
		this.guiVillageBook.drawProEntity(this.guiVillageBook.getContentLeft() + 50, top, pro, true);
		this.guiVillageBook.drawProEntity(this.guiVillageBook.getContentLeft() + 90, top, pro, false);
		
		top+=10;
		String des = this.pro.getDescription();
		int left = this.guiVillageBook.getContentLeft() + (this.guiVillageBook.getContentWidth() - this.guiVillageBook.mc.fontRendererObj.getStringWidth(des)) / 2;
		this.guiVillageBook.mc.fontRendererObj.drawString(des, left, top, 0xFF888888, false);
	}
	
}
