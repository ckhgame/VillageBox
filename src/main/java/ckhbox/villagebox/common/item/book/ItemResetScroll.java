package ckhbox.villagebox.common.item.book;

import java.util.List;

import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemResetScroll extends Item{
	
	public ItemResetScroll(){
		this.setUnlocalizedName(PathHelper.full("resetScroll"));
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(16);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("item.resetScroll.item.info"));
		tooltip.add(info);
	}
	
	
}
