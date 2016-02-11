package ckhbox.villagebento.common.item.mail;

import java.util.List;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.client.gui.mail.GuiMail;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
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

public class ItemMail extends Item{
	
	public static final int MailType_Common = 0;
	public static final int MailType_NewVillagerMale = 1;
	public static final int MailType_NewVillagerFemale = 2;
	
	public ItemMail(){
		this.setUnlocalizedName(PathHelper.full("mail"));
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		if(!worldIn.isRemote){
			playerIn.openGui(VillageBentoMod.instance, GuiIDs.Mail, worldIn, 0, 0, 0);
		}
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = StatCollector.translateToLocalFormatted(PathHelper.full("mail.item.info"), getMailSender(stack));
		tooltip.add(info);
	}
	
	public static ItemStack generateMail(String sender, String content, int mailtype){
		ItemStack mail = new ItemStack(ModItems.mail);
		setMailSender(mail, sender);
		setMailContent(mail, content);
		setMailType(mail, mailtype);
		return mail;
	}
	
	private static boolean checkStack(ItemStack stack){
		if(stack.getItem() == ModItems.mail){
			if(!stack.hasTagCompound()){
				stack.setTagCompound(new NBTTagCompound());
			}
			return true;
		}
		return false;
	}
		
	
	public static void setMailContent(ItemStack stack, String content){
		if(checkStack(stack)){
			stack.getTagCompound().setString("content", content);
		}
	}
	
	public static void setMailSender(ItemStack stack, String sender){
		if(checkStack(stack)){
			stack.getTagCompound().setString("sender", sender);
		}
	}
	
	public static void setMailType(ItemStack stack, int mailType){
		if(checkStack(stack)){
			stack.getTagCompound().setInteger("mailtype", mailType);
		}
	}
	
	public static String getMailContent(ItemStack stack){
		if(checkStack(stack)){
			String content = stack.getTagCompound().getString("content");
			if(content != null && content != "") 
				return content;
		}
		return "unknown";
	}
	
	public static String getMailSender(ItemStack stack){
		if(checkStack(stack)){
			String sender = stack.getTagCompound().getString("sender");
			if(sender != null && sender != "") 
				return sender;
		}
		return "unknown";
	}
	
	public static int getMailType(ItemStack stack){
		if(checkStack(stack)){
			return stack.getTagCompound().getInteger("mailtype");
		}
		return MailType_Common;
	}
	
	
	
}
