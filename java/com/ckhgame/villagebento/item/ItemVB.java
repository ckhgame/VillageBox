package com.ckhgame.villagebento.item;

import java.util.List;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.gui.GuiDropCoins;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVB extends Item {
	
	private String info;
	
	public ItemVB(String name,String info, CreativeTabs tab){
		super();
		this.setUnlocalizedName(name);
		this.setTextureName(Main.MODID + ":" + name);
		this.setCreativeTab(tab);
		this.info = info;
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
		// TODO Auto-generated method stub
		if(info != null)
			list.add(info);
		super.addInformation(itemStack, p_77624_2_, list, p_77624_4_);
	}
	
}
