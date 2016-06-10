package ckhbox.villagebox.common.item.book;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.gui.GuiIDs;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemVillageBook extends Item{
	
	public ItemVillageBook(){
		this.setUnlocalizedName(PathHelper.full("villageBook"));
		this.setCreativeTab(ModItems.tabVB);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		
		if(!worldIn.isRemote){
			playerIn.openGui(VillageBoxMod.instance, GuiIDs.VillageBook, worldIn, 0, 0, 0);
		}
		
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
	
	
}
