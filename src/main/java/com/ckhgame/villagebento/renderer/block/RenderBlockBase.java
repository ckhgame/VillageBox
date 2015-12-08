package com.ckhgame.villagebento.renderer.block;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.block.BlockCustom;
import com.ckhgame.villagebento.renderer.ModRenderers;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

public abstract class RenderBlockBase implements ISimpleBlockRenderingHandler {
	
	private int renderID;
	
	public RenderBlockBase(){
		renderID = RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public int getRenderId() {
		return renderID;
	}

	public abstract void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) ;

	public abstract boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,RenderBlocks renderer) ;

	public abstract boolean shouldRender3DInInventory(int modelId);
	
	

}
