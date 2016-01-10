package com.ckhgame.villagebento.block;

import java.util.Random;

import com.ckhgame.villagebento.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockTopSides extends Block
{
	private IIcon iconTop,iconSide;
	
    public BlockTopSides(String name)
    {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":"+name);
        this.setBlockName(name);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
    	iconTop = reg.registerIcon(this.getTextureName() + "_top");
    	iconSide = reg.registerIcon(this.getTextureName() + "_side");
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    		return p_149691_1_ != 1 && p_149691_1_ != 0 ? this.iconSide: this.iconTop;
    }
}