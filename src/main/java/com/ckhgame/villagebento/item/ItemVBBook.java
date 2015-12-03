package com.ckhgame.villagebento.item;

import com.ckhgame.villagebento.book.VBBook;
import com.ckhgame.villagebento.book.VBBooks;
import com.ckhgame.villagebento.gui.GuiVBBook;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVBBook extends ItemVB {
	
	private String bookName;
	
	public ItemVBBook(String name,String info, CreativeTabs tab, String bookName){
		super(name,info,tab);
		this.bookName = bookName;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer p) {
		
		if(world.isRemote){
			//open book
			
			VBBook vbBook = VBBooks.getBook(this.bookName);
			if(vbBook != null && vbBook.getPageSize() > 0){
				GuiVBBook guiVBBook = new GuiVBBook();
				guiVBBook.setBook(vbBook);
				Minecraft.getMinecraft().displayGuiScreen(guiVBBook);
			}
		}
		
		return itemStack;
	}
	
}
