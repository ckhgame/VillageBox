package ckhbox.villagebox.common.item.totem;

import java.util.List;

import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockWithInfo extends ItemBlock{

	public ItemBlockWithInfo(Block block) {
		super(block);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);	
		String n = stack.getItem().getUnlocalizedName();
		String info = I18n.format(PathHelper.full("info.tile." + n.substring(16, n.length())));
		tooltip.add(info);
	}
}
