package ckhbox.villagebento.common.item.coin;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCoin extends Item{
	public ItemCoin(String color){
		this.setUnlocalizedName(PathHelper.full(color + "Coin"));
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
}
