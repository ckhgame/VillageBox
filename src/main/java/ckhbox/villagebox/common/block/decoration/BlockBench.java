package ckhbox.villagebox.common.block.decoration;

import java.util.List;

import ckhbox.villagebox.common.block.common.BlockFacing;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBench extends BlockFacing{
	
	private static final AxisAlignedBB BENCH_AABB_CN0 = new AxisAlignedBB(0.0F, 0.0F, 0.25F, 1.0F, 0.25F, 0.815F);
	private static final AxisAlignedBB BENCH_AABB_CN1 = new AxisAlignedBB(0.0F, 0.25F, 0.75F, 1.0F, 0.75F, 0.815F);
	private static final AxisAlignedBB BENCH_AABB_CE0 = new AxisAlignedBB(0.1875F, 0.0F, 0.0F, 0.75F, 0.25F, 1.0F);
	private static final AxisAlignedBB BENCH_AABB_CE1 = new AxisAlignedBB(0.1875F, 0.25F, 0.0F, 0.25F, 0.75F, 1.0F);
	private static final AxisAlignedBB BENCH_AABB_CS0 = new AxisAlignedBB(0.0F, 0.0F, 0.1875F, 1.0F, 0.25F, 0.75F);
	private static final AxisAlignedBB BENCH_AABB_CS1 = new AxisAlignedBB(0.0F, 0.25F, 0.1875F, 1.0F, 0.75F, 0.25F);
	private static final AxisAlignedBB BENCH_AABB_CW0 = new AxisAlignedBB(0.25F, 0.0F, 0.0F, 0.815F, 0.25F, 1.0F);
	private static final AxisAlignedBB BENCH_AABB_CW1 = new AxisAlignedBB(0.75F, 0.25F, 0.0F, 0.815F, 0.75F, 1.0F);
	
	private static final AxisAlignedBB BENCH_AABB_N = new AxisAlignedBB(0.0F, 0.0F, 0.25F, 1.0F, 0.75F, 0.815F);
	private static final AxisAlignedBB BENCH_AABB_E = new AxisAlignedBB(0.1875F, 0.0F, 0.0F, 0.75F, 0.75F, 1.0F);
	private static final AxisAlignedBB BENCH_AABB_S = new AxisAlignedBB(0.0F, 0.0F, 0.1875F, 1.0F, 0.75F, 0.75F);
	private static final AxisAlignedBB BENCH_AABB_W = new AxisAlignedBB(0.25F, 0.0F, 0.0F, 0.815F, 0.75F, 1.0F);
	
	public BlockBench(String name)
	{
        super(Material.WOOD);
        this.setUnlocalizedName(PathHelper.full(name));
        this.setCreativeTab(ModItems.tabVB);
        this.setHardness(2.5F);
        this.setSoundType(SoundType.WOOD);
    }
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB mask,
			List<AxisAlignedBB> list, Entity p_185477_6_) {
		EnumFacing facing = worldIn.getBlockState(pos).getValue(FACING);
		switch(facing){
		case NORTH:
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CN0);
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CN1);
			break;
		case EAST:
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CE0);
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CE1);			
			break;
		case SOUTH:
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CS0);
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CS1);
			break;
		case WEST:
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CW0);
			addCollisionBoxToList(pos, mask, list, BENCH_AABB_CW1);
			break;
		default:
			break;
		}	
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(FACING);
		switch(facing){
		case NORTH:return BENCH_AABB_N;
		case EAST:return BENCH_AABB_E;		
		case SOUTH:return BENCH_AABB_S;		
		case WEST:return BENCH_AABB_W;
		default:return null;
		}
	}
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
}
