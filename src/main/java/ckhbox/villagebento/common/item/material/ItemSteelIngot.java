package ckhbox.villagebento.common.item.material;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSteelIngot extends Item{
	
	public ItemSteelIngot(){
		this.setUnlocalizedName(PathHelper.full("steelIngot"));
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(16);
	}
	
}
