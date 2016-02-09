package ckhbox.villagebento.common.item.book;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVillageBook extends Item{
	public ItemVillageBook(){
		this.setUnlocalizedName(PathHelper.full("villageBook"));
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		if(!worldIn.isRemote){
			playerIn.openGui(VillageBentoMod.instance, GuiIDs.VillageBook, worldIn, 0, 0, 0);
		}
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
	
}
