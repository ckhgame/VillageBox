package ckhbox.villagebox.common.item.book;

import java.util.List;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.gui.GuiIDs;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemTreasureBook extends Item{
	
	private int level;
	
	public ItemTreasureBook(int lvl){
		this.setUnlocalizedName(PathHelper.full("treasurebook" + lvl));
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
		this.level = lvl;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		if(!worldIn.isRemote){
			//increase treasure hunt level
			if(ExtendedPlayerProperties.get(playerIn).upgradeTreasureHuntLevelTo(this.level)){
				playerIn.playSound("random.levelup", 1.0F, 1.0F);
				playerIn.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.player.treasurelvlupgrade.success"),this.level));
				return null;
			}
			else{
				playerIn.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.player.treasurelvlupgrade.failed")));
				return itemStackIn;
			}
		}
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = StatCollector.translateToLocalFormatted(PathHelper.full("book.treasure.item.info"), this.level);
		tooltip.add(info);
	}
	
	
}
