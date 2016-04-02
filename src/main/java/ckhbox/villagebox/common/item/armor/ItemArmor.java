package ckhbox.villagebox.common.item.armor;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;

public class ItemArmor extends net.minecraft.item.ItemArmor{

	public ItemArmor(String name,ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(PathHelper.full(name));
		this.setCreativeTab(ModItems.tabVB);
	}

}
