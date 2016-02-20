package ckhbox.villagebento.client.renderer;

import ckhbox.villagebento.client.renderer.painting.RenderFactoryPainting;
import ckhbox.villagebento.client.renderer.throwable.RenderFactoryFlameBall;
import ckhbox.villagebento.client.renderer.villager.RenderFactoryVillager;
import ckhbox.villagebento.common.entity.painting.EntityPainting;
import ckhbox.villagebento.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModEntityRenderers {
	public static void init(){
		RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderFactoryVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameBall.class, new RenderFactoryFlameBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityPainting.class, new RenderFactoryPainting());
	}

}
