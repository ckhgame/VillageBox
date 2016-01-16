package com.ckhgame.villagebento.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockMeta extends Block{
	
	protected int subCount;
	protected IIcon[] icons;
	
	 protected BlockMeta(String unlocalizedName,String textureName, Material material, int subCount) {
	        super(material);
	        this.setBlockName(unlocalizedName);
	        this.setBlockTextureName(textureName);
	        this.subCount = subCount;
	    }

	    @Override
	    public void registerBlockIcons(IIconRegister reg) {
	    	this.icons = new IIcon[this.subCount];
	    	for(int i =0;i<this.subCount;i++){
	    		this.icons[i] = reg.registerIcon(this.getTextureName() + "_" + i);
	    	}
	    }
	    
	    @Override
	    public IIcon getIcon(int side, int meta) {
	    	if(meta >= this.subCount)
	    		meta = 0;
	    	return this.icons[meta];
	    }
	    
	    @Override
	    public int damageDropped(int meta) {
	        return meta;
	    }
	    
	    @Override
	    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	        for (int i = 0; i < this.subCount; i ++) {
	            list.add(new ItemStack(item, 1, i));
	        }
	    }
	    
	    
}
