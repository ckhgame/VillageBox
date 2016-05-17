package ckhbox.villagebox.common.item.book;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemDismissalScroll extends Item{
	
	public ItemDismissalScroll(){
		this.setUnlocalizedName(PathHelper.full("dismissalScroll"));
		this.setCreativeTab(ModItems.tabVB);
		this.setMaxStackSize(16);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = StatCollector.translateToLocal(PathHelper.full("info.item.dismissalScroll.line0"));
		String info1 = StatCollector.translateToLocal(PathHelper.full("info.item.dismissalScroll.line1"));
		tooltip.add(info);
		tooltip.add(info1);
	}
	
	
}
