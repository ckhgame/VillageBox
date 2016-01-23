package ckhbox.villagebento.client.renderer;

import ckhbox.villagebento.client.renderer.villager.RenderFactoryVillager;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModRenderers {
	public static void init(){
		RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderFactoryVillager());
	}
}
