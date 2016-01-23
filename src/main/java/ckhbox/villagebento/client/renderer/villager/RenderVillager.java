package ckhbox.villagebento.client.renderer.villager;

import ckhbox.villagebento.client.model.villager.ModelVillager;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderVillager extends RenderBiped<EntityVillager>{

	public RenderVillager(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelVillager(), 0.5F, 1.0F);
	}

	@Override
	public void doRender(EntityVillager entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		System.out.println("rendering");
	}
	
	

}
