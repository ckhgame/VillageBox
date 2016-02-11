package ckhbox.villagebento.common.item.material;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemProcessedWoodPlank extends Item{
	
	public ItemProcessedWoodPlank(){
		this.setUnlocalizedName(PathHelper.full("processedWoodPlank"));
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(16);
	}
	
}
