package ckhbox.villagebento.client.renderer.villager;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFactoryVillager implements IRenderFactory<EntityVillager>{

	@Override
	public Render<? super EntityVillager> createRenderFor(RenderManager manager) {
		System.out.println("get renderer");
		return new RenderVillager(manager);
	}

}
