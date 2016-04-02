package ckhbox.villagebox.common.item.tool;

import ckhbox.villagebox.common.item.ModItems;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe{

	public ItemPickaxe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(ModItems.tabVB);
	}

}
