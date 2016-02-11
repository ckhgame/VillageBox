package ckhbox.villagebento.common.item.material;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemReinforcedIronIngot extends Item{
	
	public ItemReinforcedIronIngot(){
		this.setUnlocalizedName(PathHelper.full("reinforcedIronIngot"));
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(16);
	}
	
}
