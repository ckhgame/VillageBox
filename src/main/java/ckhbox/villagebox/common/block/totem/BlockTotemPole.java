package ckhbox.villagebox.common.block.totem;

import ckhbox.villagebox.common.block.common.BlockFacing;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.tileentity.totem.TileEntityTotem;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockTotemPole extends BlockFacing{
	
	public BlockTotemPole(String name) {
		super(Material.wood);
		this.setUnlocalizedName(PathHelper.full(name));
		this.setCreativeTab(ModItems.tabVB);
        this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
		this.setHardness(2.5F);
        this.setStepSound(soundTypeWood);
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
