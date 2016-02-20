package ckhbox.villagebento.common.item.painting;

import ckhbox.villagebento.common.entity.painting.EntityPainting;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemPainting extends Item{

    public ItemPainting()
    {
    	this.setUnlocalizedName(PathHelper.full("painting"));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (side == EnumFacing.DOWN)
        {
            return false;
        }
        else if (side == EnumFacing.UP)
        {
            return false;
        }
        else
        {
            BlockPos blockpos = pos.offset(side);

            if (!playerIn.canPlayerEdit(blockpos, side, stack))
            {
                return false;
            }
            else
            {
            	EntityPainting entitypainting = this.createEntity(worldIn, blockpos, side);

            	boolean b= entitypainting.onValidSurface();
                if (entitypainting != null && entitypainting.onValidSurface())
                {
                    if (!worldIn.isRemote)
                    {
                        worldIn.spawnEntityInWorld(entitypainting);
                    }

                    --stack.stackSize;
                }

                return true;
            }
        }
    }

    private EntityPainting createEntity(World worldIn, BlockPos pos, EnumFacing clickedSide)
    {
        return new EntityPainting(worldIn, pos, clickedSide);
    }
	
	

}
