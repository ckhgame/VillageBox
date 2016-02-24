package ckhbox.villagebento.common.block.decoration;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;

public class BlockTable extends Block{
	
	public BlockTable(String name)
	{
        super(Material.wood);
        this.setUnlocalizedName(PathHelper.full(name));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
	
	@Override
	public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	
}
