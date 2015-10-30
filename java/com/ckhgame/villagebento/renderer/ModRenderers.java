package com.ckhgame.villagebento.renderer;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ModRenderers {
	
	public static final void init(){
		
	//	BlockVillageViewerRenderer.renderID = RenderingRegistry.getNextAvailableRenderId();
			
	//	RenderingRegistry.registerBlockHandler(new BlockVillageViewerRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityVBVillager.class, new RenderVBVillager());
	}
	
}
