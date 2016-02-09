package ckhbox.villagebento.common.item.gem;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGem extends Item{
	public ItemGem(String color){
		this.setUnlocalizedName(PathHelper.full(color + "Gem"));
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
}
