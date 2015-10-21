package com.ckhgame.villagebento.rendering;

import com.ckhgame.villagebento.entity.EntityVBVillager;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ModRenderers {
	
	public static final void init(){
		
	//	BlockVillageViewerRenderer.renderID = RenderingRegistry.getNextAvailableRenderId();
			
	//	RenderingRegistry.registerBlockHandler(new BlockVillageViewerRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityVBVillager.class, new RenderVBVillager());
	}
	
}
