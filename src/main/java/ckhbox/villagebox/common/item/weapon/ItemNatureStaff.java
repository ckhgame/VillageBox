package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.World;

public class ItemNatureStaff extends Item
{	
	public ItemNatureStaff()
    {
		this.setUnlocalizedName(PathHelper.full("natureStaff"));
        this.maxStackSize = 1;
        this.setMaxDamage(40);
        this.setCreativeTab(ModItems.tabVB);
    }
    
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("info.item.natureStaff"));
		tooltip.add(info);
	}
    
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
        	int stacksize = stack.stackSize;
        	if (ItemDye.applyBonemeal(stack, worldIn, pos, playerIn))
            {
                if (!worldIn.isRemote)
                {
                	worldIn.playEvent(2005, pos, 0);
                    stack.stackSize = stacksize; // ItemDye.applyBonemeal consumes 1 item but we don't want it to happen.
                    this.damageStaff(playerIn, stack, hand);
                }

                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }
	 
	public void damageStaff(EntityPlayer player, ItemStack stack, EnumHand hand){
        if (!player.capabilities.isCreativeMode)
        {
        	stack.damageItem(1, player);
        	if(stack.getItemDamage() == 0){
        		player.setItemStackToSlot(hand == EnumHand.MAIN_HAND? EntityEquipmentSlot.MAINHAND : EntityEquipmentSlot.OFFHAND, new ItemStack(ModItems.staff));
        	}
        }
	 }   
}