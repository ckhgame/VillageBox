package ckhbox.villagebox.common.item.armor;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemArmor extends net.minecraft.item.ItemArmor{

	public ItemArmor(String name,ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn) {
		super(material, renderIndex, equipmentSlotIn);
		this.setUnlocalizedName(PathHelper.full(name));
		this.setCreativeTab(ModItems.tabVB);
	}

}
