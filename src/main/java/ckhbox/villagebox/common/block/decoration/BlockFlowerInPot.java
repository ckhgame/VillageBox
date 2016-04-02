package ckhbox.villagebox.common.block.decoration;

import java.util.List;

import com.google.common.base.Predicate;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFlowerInPot extends Block{
	
	public BlockFlowerInPot(String name){
		super(Material.circuits);
		this.setUnlocalizedName(PathHelper.full(name));
		this.setCreativeTab(ModItems.tabVB);
		this.setBlockBoundsForItemRender();
		this.setStepSound(soundTypeStone);
	}
	
    public void setBlockBoundsForItemRender()
    {
        float f = 0.375F;
        float f1 = f / 2.0F;
        this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f, 0.5F + f1);
    }
    
    public int getRenderType()
    {
        return 3;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

}
