package com.ckhgame.villagebento.renderer;

import com.ckhgame.villagebento.entity.animal.EntityVBChicken;
import com.ckhgame.villagebento.entity.animal.EntityVBCow;
import com.ckhgame.villagebento.entity.animal.EntityVBSheep;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.renderer.block.RenderBlockCustom;
import com.ckhgame.villagebento.renderer.tileentity.RendererTileEntityBlockCustom;
import com.ckhgame.villagebento.tileentity.TileEntityBlockCustom;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ModRenderers {
	
	public static RenderBlockCustom renderBlockCustom;
	
	public static final void init(){
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVBVillager.class, new RenderVBVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityVBChicken.class, new RenderVBChicken());
		RenderingRegistry.registerEntityRenderingHandler(EntityVBSheep.class, new RenderVBSheep());
		RenderingRegistry.registerEntityRenderingHandler(EntityVBCow.class, new RenderVBCow());

		renderBlockCustom = new  RenderBlockCustom();
		RenderingRegistry.registerBlockHandler(renderBlockCustom);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockCustom.class, new RendererTileEntityBlockCustom());
	}
	
}
