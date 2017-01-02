package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
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
	
    @Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {

    	if (!playerIn.capabilities.isCreativeMode)
        {
        	itemStackIn.damageItem(1, playerIn);
        	if(itemStackIn.getItemDamage() == 0){
        		itemStackIn = new ItemStack(ModItems.staff);
        	}
        }
    	
    	worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        
        if (!worldIn.isRemote)
        {
            EntityFlameBall flameball = new EntityFlameBall(worldIn, playerIn);
        	flameball.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntityInWorld(flameball);
        }
        
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    	
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("info.item.fireStaff"));
		tooltip.add(info);
	}
    
    
}