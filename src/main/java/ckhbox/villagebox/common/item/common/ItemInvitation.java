package ckhbox.villagebox.common.item.common;

import java.util.List;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.client.gui.mail.GuiMail;
import ckhbox.villagebox.common.gui.GuiIDs;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInvitation extends Item{
	
	public ItemInvitation(){
		this.setUnlocalizedName(PathHelper.full("invitation"));
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = StatCollector.translateToLocal(PathHelper.full("invitation.item.info"));
		tooltip.add(info);
	}
}