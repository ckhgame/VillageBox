package ckhbox.villagebento.common.block.carpet;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;

public class BlockCarpet extends Block{
	
	public BlockCarpet(String name)
	{
        super(Material.carpet);
        this.setUnlocalizedName(PathHelper.full(name));
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
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
