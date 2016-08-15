package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.entity.throwable.EntityLargeSnowBall;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemWaterStaff extends Item
{	
	public ItemWaterStaff()
    {
		this.setUnlocalizedName(PathHelper.full("waterStaff"));
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

    	worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        
        if (!worldIn.isRemote)
        {
            EntityLargeSnowBall snowball = new EntityLargeSnowBall(worldIn, playerIn);
            snowball.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntityInWorld(snowball);
        }
        
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    	
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		String info = I18n.translateToLocal(PathHelper.full("info.item.waterStaff"));
		tooltip.add(info);
	}
    
    
}