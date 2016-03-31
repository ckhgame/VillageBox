package ckhbox.villagebox.common.block.totem;

import ckhbox.villagebox.common.block.common.BlockFacing;
import ckhbox.villagebox.common.tileentity.totem.TileEntityTotem;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockTotem extends BlockFacing implements ITileEntityProvider{

	private Class<? extends TileEntityTotem> classTotem;
	
	public BlockTotem(String name, Class<? extends TileEntityTotem> classTotem) {
		super(Material.wood);
		this.setUnlocalizedName(PathHelper.full(name));
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.classTotem = classTotem;
        this.isBlockContainer = true;
        this.setblockboundsforitemrender();
	}
	
    public void setblockboundsforitemrender()
    {
        this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		try {
			return this.classTotem.newInstance();
		} catch (Exception e) {}
		return null;
	}
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }
    
	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }

}
