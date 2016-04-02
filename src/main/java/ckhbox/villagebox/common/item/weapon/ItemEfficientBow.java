package ckhbox.villagebox.common.item.weapon;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.item.ItemBow;

public class ItemEfficientBow extends ItemBow{
	
	public ItemEfficientBow(){
		this.setUnlocalizedName(PathHelper.full("efficientBow"));	
		this.setCreativeTab(ModItems.tabVB);
	}
	
	
}
