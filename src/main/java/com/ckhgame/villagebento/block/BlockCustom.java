package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.renderer.ModRenderers;
import com.ckhgame.villagebento.tileentity.TileEntityBlockCustom;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BlockCustom extends BlockContainer {

	private ModelBase model;
	private ResourceLocation texture;
	private TileEntityBlockCustom tileEntityBlockCustom;
	
	/**
	 * if model is null, the block will render as a standard block, else the custom rendering will be triggered...
	 * if mcTexture is null, a custom texture will be loaded based on the block name, else it will load the default mc texture for rendering
	 */
	protected BlockCustom(String name, ModelBase model, String mcTexture) {
		super(Material.wood);
		this.setBlockName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundTypeWood);
		this.model = model;
		if(this.model == null){
			if(mcTexture == null){
				this.setBlockTextureName(Main.MODID + ":" + name);
			}
			else{
				this.setBlockTextureName(mcTexture);	
			}
		}
		else{
			if(mcTexture == null){
				this.setBlockTextureName(Main.MODID + ":" + name);
				this.texture = new ResourceLocation(Main.MODID + ":" + "textures/blocks/" + name + ".png");
			}
			else{
				this.setBlockTextureName(mcTexture);	
				this.texture = new ResourceLocation("textures/blocks/" + mcTexture + ".png");
			}
		}
		
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		if(this.model != null){
			return  ModRenderers.renderBlockCustom.getRenderId();
		}
		else{
			return super.getRenderType();
		}
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		this.tileEntityBlockCustom = (this.model == null?null: new TileEntityBlockCustom());
		if(this.tileEntityBlockCustom != null){
			this.tileEntityBlockCustom.setModel(this.model);
			this.tileEntityBlockCustom.setTexture(this.texture);
		}
		return this.tileEntityBlockCustom;
	}
	
	public TileEntityBlockCustom getTileEntityBlockCustom(){
		return this.tileEntityBlockCustom;
	}
}
