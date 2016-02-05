package ckhbox.villagebento.client.renderer.villager;

import ckhbox.villagebento.client.model.villager.ModelVillager;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVillager extends RenderBiped<EntityVillager>{
	
	public RenderVillager(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelVillager(), 0.5F, 1.0F);
	}

	@Override
	public void doRender(EntityVillager entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityVillager entity) {
		if(entity.previewProfession != null)
			return entity.previewProfession.getTexture();
		else
			return entity.getProfession().getTexture();
	}
	
	

}
