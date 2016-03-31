package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemLightStaff extends Item
{		
	public ItemLightStaff()
    {
		this.setUnlocalizedName(PathHelper.full("lightStaff"));
        this.maxStackSize = 1;
        this.setMaxDamage(256);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
    
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("info.item.lightStaff"));
		tooltip.add(info);
	}
    
	
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        
        if (!block.isReplaceable(worldIn, pos))
        {
            pos = pos.offset(side);
        }

        if (!playerIn.canPlayerEdit(pos, side, stack))
        {
            return false;
        }
        else if (worldIn.canBlockBePlaced(Blocks.torch, pos, false, side, (Entity)null, stack))
        {
            IBlockState iblockstate1 = Blocks.torch.onBlockPlaced(worldIn, pos, side, hitX, hitY, hitZ, 0, playerIn);

            if (placeBlockAt(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ, iblockstate1))
            {
                worldIn.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), Blocks.torch.stepSound.getPlaceSound(), (Blocks.torch.stepSound.getVolume() + 1.0F) / 2.0F, Blocks.torch.stepSound.getFrequency() * 0.8F);
                
                this.damageStaff(playerIn, stack);
                
            }

            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState)
    {
        if (!world.setBlockState(pos, newState, 3)) return false;

        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.torch)
        {
        	 Blocks.torch.onBlockPlacedBy(world, pos, state, player, stack);
        }

        return true;
    }
	 
	 public void damageStaff(EntityPlayer player, ItemStack stack){
         if (!player.capabilities.isCreativeMode)
         {
         	stack.damageItem(1, player);
         	if(stack.getItemDamage() == 0){
         		player.setCurrentItemOrArmor(0, new ItemStack(ModItems.staff));
         	}
         }
	 }
}