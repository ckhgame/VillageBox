package com.ckhgame.villagebento.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.tileentity.TileEntityBlockCustom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class RendererTileEntityBlockCustom extends TileEntitySpecialRenderer{

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z,float f) {
		TileEntityBlockCustom tileEntityBlockCustom = (TileEntityBlockCustom)tileEntity;
		
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
        Minecraft.getMinecraft().renderEngine.bindTexture(tileEntityBlockCustom.getTexture());                       
        tileEntityBlockCustom.getModel().render(tileEntityBlockCustom.getTarget(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
	}

}
