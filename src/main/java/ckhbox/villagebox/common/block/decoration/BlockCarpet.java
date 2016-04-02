package ckhbox.villagebox.common.block.decoration;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCarpet extends Block{
	
	public BlockCarpet(String name)
	{
        super(Material.carpet);
        this.setUnlocalizedName(PathHelper.full(name));
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
        this.setCreativeTab(ModItems.tabVB);
        this.setHardness(0.1F);
        this.setStepSound(soundTypeCloth);
        this.setLightOpacity(0);
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
	
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.UP ? true : super.shouldSideBeRendered(worldIn, pos, side);
    }
	
}
