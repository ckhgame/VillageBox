package ckhbox.villagebox.common.item.common;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCoin extends Item{
	public ItemCoin(String color){
		this.setUnlocalizedName(PathHelper.full(color + "Coin"));
		this.setCreativeTab(ModItems.tabVB);
	}
}
