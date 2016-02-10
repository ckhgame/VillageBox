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
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		if(!worldIn.isRemote){
			
		}
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
	
}
