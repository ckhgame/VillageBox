package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemFireStaff extends Item
{	
	public ItemFireStaff()
    {
		this.setUnlocalizedName(PathHelper.full("fireStaff"));
        this.maxStackSize = 1;
        this.setMaxDamage(20);
        this.setCreativeTab(ModItems.tabVB);
    }
    
	 /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {    	
        if (!playerIn.capabilities.isCreativeMode)
        {
        	itemStackIn.damageItem(1, playerIn);
        	if(itemStackIn.getItemDamage() == 0){
        		itemStackIn = new ItemStack(ModItems.staff);
        	}
        }
        playerIn.swingArm(EnumHand.MAIN_HAND);
        playerIn.playSound(SoundEvents.entity_ghast_shoot, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        
        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(new EntityFlameBall(worldIn, playerIn));
        }
        
        return itemStackIn;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.translateToLocal(PathHelper.full("info.item.fireStaff"));
		tooltip.add(info);
	}
    
    
}