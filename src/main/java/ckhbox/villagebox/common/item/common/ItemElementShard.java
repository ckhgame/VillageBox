package ckhbox.villagebox.common.item.common;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemElementShard extends Item{

	public ItemElementShard(String element){
		this.setUnlocalizedName(PathHelper.full(element + "Shard"));
		this.setCreativeTab(ModItems.tabVB);
		this.setMaxStackSize(16);
	}
	
}
