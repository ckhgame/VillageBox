package com.ckhgame.villagebento.renderer;

import com.ckhgame.villagebento.entity.animal.EntityVBChicken;
import com.ckhgame.villagebento.entity.animal.EntityVBSheep;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ModRenderers {
	
	public static final void init(){
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVBVillager.class, new RenderVBVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityVBChicken.class, new RenderVBChicken());
		RenderingRegistry.registerEntityRenderingHandler(EntityVBSheep.class, new RenderVBSheep());
	}
	
}
