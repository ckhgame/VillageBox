package ckhbox.villagebox.common.item.book;

import java.util.List;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.gui.GuiIDs;
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

public class ItemGuideBook extends Item{
	
	public ItemGuideBook(){
		this.setUnlocalizedName(PathHelper.full("guideBook"));
		this.setCreativeTab(ModItems.tabVB);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		if(!worldIn.isRemote){
			playerIn.openGui(VillageBoxMod.instance, GuiIDs.GuideBook, worldIn, 0, 0, 0);
		}
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
	
}
