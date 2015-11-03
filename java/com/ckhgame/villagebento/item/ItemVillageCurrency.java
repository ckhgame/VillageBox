package com.ckhgame.villagebento.item;

import java.util.List;

import com.ckhgame.villagebento.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVillageCurrency extends Item {
	public ItemVillageCurrency(){
		super();
		this.setUnlocalizedName("ItemVillageCurrency");
		this.setTextureName(Main.MODID + ":itemvillagecurrency");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.maxStackSize = 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer p) {
		
		return itemStack;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
		// TODO Auto-generated method stub
		list.add("Total:" + itemStack.getItemDamage());
		super.addInformation(itemStack, p_77624_2_, list, p_77624_4_);
	}
	
	
	
	
}
