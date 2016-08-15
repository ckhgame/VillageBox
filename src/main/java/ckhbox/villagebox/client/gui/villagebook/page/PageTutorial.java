package ckhbox.villagebox.client.gui.villagebook.page;

import ckhbox.villagebox.client.gui.villagebook.GuiVillageBook;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkImg;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkItem;
import ckhbox.villagebox.client.gui.villagebook.page.link.LinkText;
import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.profession.ProVillager0;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class PageTutorial extends Page{
	
	private Profession expample;
	
	public PageTutorial(GuiVillageBook guiVillageBook) {
		super(guiVillageBook,I18n.translateToLocal(PathHelper.full("villageBook.tutorial")));
		expample = Profession.registry.get(ProVillager0.class);
	}

	@Override
	public void onInit() {	
		
		int top = this.guiVillageBook.getContentTop() + 16;
		int left = this.guiVillageBook.getContentLeft() + 20;
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.paper),null,null), top, left);
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.feather),null,null), top, left + 20);
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.dye),null,null), top, left + 40);
		this.addLinkAt(new LinkItem(this,new ItemStack(ModItems.invitation),null,null), top, left + 80);
		this.addLinkAt(new LinkImg(this, this.guiVillageBook.guiBookGuiTextures, 192,54,0,0,16,16,null,null), top, left + 60);
		this.addLinkAt(new LinkImg(this, this.guiVillageBook.guiBookGuiTextures, 176,54,0,0,16,16,null,null), top + 20, left + 80);
		
		top = this.guiVillageBook.getContentTop() + 56;
		left = this.guiVillageBook.getContentLeft() + 20;
		this.addLinkAt(new LinkItem(this,new ItemStack(Items.paper),null,null), top, left + 20);
		this.addLinkAt(new LinkItem(this,new ItemStack(Blocks.planks),null,null), top, left + 40);
		this.addLinkAt(new LinkItem(this,new ItemStack(ModBlocks.mailbox),null,null), top, left + 80);
		this.addLinkAt(new LinkImg(this, this.guiVillageBook.guiBookGuiTextures, 192,54,0,0,16,16,null,null), top, left + 60);
		this.addLinkAt(new LinkImg(this, this.guiVillageBook.guiBookGuiTextures, 176,54,0,0,16,16,null,null), top + 20, left + 80);
		
		top = this.guiVillageBook.getContentTop() + 96;
		left = this.guiVillageBook.getContentLeft() + 20;
		this.addLinkAt(new LinkItem(this,new ItemStack(ModItems.mail),null,null), top, left + 80);
		this.addLinkAt(new LinkImg(this, this.guiVillageBook.guiBookGuiTextures, 208,54,0,0,16,16,null,null), top, left + 50);
		
		top = this.guiVillageBook.getContentTop() + this.guiVillageBook.getContentHeight() - 16;
		this.addLink(new LinkImg(this,this.guiVillageBook.guiBookGuiTextures,240,0,0,16,16,16,"back=",null),top,1);
	}

	@Override
	public void onDrawScreen(int mouseX, int mouseY) {
		super.onDrawScreen(mouseX, mouseY);
		
		int top = this.guiVillageBook.getContentTop() + 120;
		int left = this.guiVillageBook.getContentLeft() + 20;
		this.guiVillageBook.drawProEntity(this.guiVillageBook.getContentLeft() + 50, top, this.expample, true);
	}
	
}
