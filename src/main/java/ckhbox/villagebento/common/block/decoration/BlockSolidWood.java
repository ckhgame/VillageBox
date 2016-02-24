package ckhbox.villagebento.common.block.decoration;

import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;

public class BlockSolidWood extends Block{
	
    public BlockSolidWood()
    {
        super(Material.wood);
        this.setUnlocalizedName(PathHelper.full("solidWood"));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
}
