package ckhbox.villagebox.client.gui.guidebook.page;

import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.guidebook.page.link.LinkText;
import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.profession.ProVillager0;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class PageTutorial extends Page{
	
	private Profession expample;
	
	public PageTutorial(GuiGuideBook guiGuideBook) {
		super(guiGuideBook,StatCollector.translateToLocal(PathHelper.full("guideBook.tutorial")));
		expample = Profession.registry.get(ProVillager0.class);
	}

	@Override
	public void onInit() {	
		
		int top = this.guiGuideBook.getContentTop() + 16;
		int left = this.guiGuideBook.getContentLeft() + 20;
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.paper),null,null), top, left);
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.feather),null,null), top, left + 20);
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.dye),null,null), top, left + 40);
		this.addLinkAt(new LinkItem(this,new ItemStack(ModItems.invitation),null,null), top, left + 80);
		this.addLinkAt(new LinkImg(this, this.guiGuideBook.guiBookGuiTextures, 192,54,0,0,16,16,null,null), top, left + 60);
		this.addLinkAt(new LinkImg(this, this.guiGuideBook.guiBookGuiTextures, 176,54,0,0,16,16,null,null), top + 20, left + 80);
		
		top = this.guiGuideBook.getContentTop() + 56;
		left = this.guiGuideBook.getContentLeft() + 20;
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.paper),null,null), top, left + 20);
		this.addLinkAt(new LinkItem(this,new ItemStack(Blocks.planks),null,null), top, left + 40);
		this.addLinkAt(new LinkItem(this,new ItemStack(ModBlocks.mailbox),null,null), top, left + 80);
		this.addLinkAt(new LinkImg(this, this.guiGuideBook.guiBookGuiTextures, 192,54,0,0,16,16,null,null), top, left + 60);
		this.addLinkAt(new LinkImg(this, this.guiGuideBook.guiBookGuiTextures, 176,54,0,0,16,16,null,null), top + 20, left + 80);
		
		top = this.guiGuideBook.getContentTop() + 96;
		left = this.guiGuideBook.getContentLeft() + 20;
		this.addLinkAt(new LinkItem(this,new ItemStack(ModItems.mail),null,null), top, left + 80);
		this.addLinkAt(new LinkImg(this, this.guiGuideBook.guiBookGuiTextures, 208,54,0,0,16,16,null,null), top, left + 50);
		
		top = this.guiGuideBook.getContentTop() + this.guiGuideBook.getContentHeight() - 16;
		this.addLink(new LinkImg(this,this.guiGuideBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
		
		int top = this.guiGuideBook.getContentTop() + 120;
		int left = this.guiGuideBook.getContentLeft() + 20;
		this.guiGuideBook.drawProEntity(this.guiGuideBook.getContentLeft() + 50, top, this.expample, true);
	}
	
}
