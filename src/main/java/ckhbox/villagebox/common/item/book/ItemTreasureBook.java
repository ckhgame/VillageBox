package ckhbox.villagebox.common.item.book;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemTreasureBook extends Item{
	
	private int level;
	
	public ItemTreasureBook(int lvl){
		this.setUnlocalizedName(PathHelper.full("treasurebook" + lvl));
		this.setCreativeTab(ModItems.tabVB);
		this.setMaxStackSize(1);
		this.level = lvl;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		
		if(!worldIn.isRemote){
			//increase treasure hunt level
			if(ExtendedPlayerProperties.get(playerIn).upgradeTreasureHuntLevelTo(this.level)){
				playerIn.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.player.treasurelvlupgrade.success"),this.level));
				itemStackIn.stackSize -= 1;
				return new ActionResult(EnumActionResult.SUCCESS,itemStackIn);
			}
			else{
				playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.player.treasurelvlupgrade.failed")));
				return new ActionResult(EnumActionResult.FAIL,itemStackIn);
			}
		}
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.translateToLocalFormatted(PathHelper.full("book.treasure.item.info"), this.level);
		tooltip.add(info);
	}
	
	
}
