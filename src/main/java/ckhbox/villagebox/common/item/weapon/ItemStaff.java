package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemStaff extends Item
{	
	public ItemStaff()
    {
		this.setUnlocalizedName(PathHelper.full("staff"));
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("info.item.staff"));
		tooltip.add(info);
	}
    
}