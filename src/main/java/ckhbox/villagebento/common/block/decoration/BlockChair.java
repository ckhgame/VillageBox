package ckhbox.villagebento.common.block.decoration;

import ckhbox.villagebento.common.block.common.BlockFacing;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;

public class BlockChair extends BlockFacing{
	
	public BlockChair(String name)
	{
        super(Material.wood);
        this.setUnlocalizedName(PathHelper.full(name));
        this.setCreativeTab(CreativeTabs.tabDecorations);
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
