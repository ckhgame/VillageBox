package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

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
		int top = this.guiGuideBook.getContentTop() + 90;
		String trading = "> " + StatCollector.translateToLocal(PathHelper.full("guideBook.tradingList"));
		this.addLink(new LinkText(this,trading,">trading=" + this.pro.getRegID() + ",0",null),top,1);
		
		top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 16;
		this.addLink(new LinkImg(this,this.guiGuideBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
		
		int top = this.guiGuideBook.getContentTop() + 50;
		this.guiGuideBook.drawProEntity(this.guiGuideBook.getContentLeft() + 50, top, pro, true);
		this.guiGuideBook.drawProEntity(this.guiGuideBook.getContentLeft() + 90, top, pro, false);
		
		top+=10;
		String des = this.pro.getDescription();
		int left = this.guiGuideBook.getContentLeft() + (this.guiGuideBook.getContentWidth() - this.guiGuideBook.mc.fontRendererObj.getStringWidth(des)) / 2;
		this.guiGuideBook.mc.fontRendererObj.drawString(des, left, top, 0xFF888888, false);
	}
	
}
