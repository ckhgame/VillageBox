package com.ckhgame.villagebento.rendering;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class BlockVillageViewerRenderer implements ISimpleBlockRenderingHandler  {

	public static int renderID;
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub
		
		return RenderBlocks.getInstance().renderStandardBlock(block, x, y, z);
		
		//System.out.println("RRRRRRRRREEEEENNNDDDEEERRRRIIIIINNNGGG!!");
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return renderID;
	}
	

}
