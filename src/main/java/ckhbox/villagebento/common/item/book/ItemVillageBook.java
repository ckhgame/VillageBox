package ckhbox.villagebento.common.item.book;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemVillageBook extends Item{
	public ItemVillageBook(){
		this.setUnlocalizedName(PathHelper.full("villageBook"));
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
}
