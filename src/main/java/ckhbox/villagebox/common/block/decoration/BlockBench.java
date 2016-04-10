package ckhbox.villagebox.common.block.decoration;

import java.util.List;

import ckhbox.villagebox.common.block.common.BlockFacing;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBench extends BlockFacing{
	
	public BlockBench(String name)
	{
        super(Material.wood);
        this.setUnlocalizedName(PathHelper.full(name));
        this.setCreativeTab(ModItems.tabVB);
        this.setHardness(2.5F);
        this.setStepSound(soundTypeWood);
    }
	
	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			List<AxisAlignedBB> list, Entity collidingEntity) {
		
		EnumFacing facing = worldIn.getBlockState(pos).getValue(FACING);
		switch(facing){
		case NORTH:
			this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 0.25F, 0.815F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			this.setBlockBounds(0.0F, 0.25F, 0.75F, 1.0F, 0.75F, 0.815F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			break;
		case EAST:
			this.setBlockBounds(0.1875F, 0.0F, 0.0F, 0.75F, 0.25F, 1.0F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			this.setBlockBounds(0.1875F, 0.25F, 0.0F, 0.25F, 0.75F, 1.0F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			
			break;
		case SOUTH:
			this.setBlockBounds(0.0F, 0.0F, 0.1875F, 1.0F, 0.25F, 0.75F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			this.setBlockBounds(0.0F, 0.25F, 0.1875F, 1.0F, 0.75F, 0.25F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			
			break;
		case WEST:
			this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.815F, 0.25F, 1.0F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			this.setBlockBounds(0.75F, 0.25F, 0.0F, 0.815F, 0.75F, 1.0F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			
			break;
		default:
			break;
		}		
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
		EnumFacing facing = worldIn.getBlockState(pos).getValue(FACING);
		switch(facing){
		case NORTH:
			this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 0.75F, 0.815F);
			break;
		case EAST:
			this.setBlockBounds(0.1875F, 0.0F, 0.0F, 0.75F, 0.75F, 1.0F);		
			break;
		case SOUTH:
			this.setBlockBounds(0.0F, 0.0F, 0.1875F, 1.0F, 0.75F, 0.75F);			
			break;
		case WEST:
			this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.815F, 0.75F, 1.0F);
			break;
		default:
			break;
		}		
    }



	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
    public boolean isFullCube()
    {
        return false;
    }
	
}
