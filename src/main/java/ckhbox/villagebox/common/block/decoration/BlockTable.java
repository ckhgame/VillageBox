package ckhbox.villagebox.common.block.decoration;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;

public class BlockTable extends Block{
	
	public BlockTable(String name)
	{
        super(Material.wood);
        this.setUnlocalizedName(PathHelper.full(name));
        this.setCreativeTab(ModItems.tabVB);
        this.setHardness(2.5F);
        this.setStepSound(SoundType.WOOD);
    }

	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
}
