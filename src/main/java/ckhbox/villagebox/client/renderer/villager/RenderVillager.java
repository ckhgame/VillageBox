package ckhbox.villagebox.client.renderer.villager;

import ckhbox.villagebox.client.model.villager.ModelVillager;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVillager extends RenderBiped<EntityVillager>{
	
	public RenderVillager(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelVillager(), 0.5F, 1.0F);
		this.addLayer(new LayerVillagerHeldItem(this));
	}

	@Override
	protected boolean canRenderName(EntityVillager entity) {
		if(entity.previewProfession != null)
			return false;
		else
			return super.canRenderName(entity);
	}

	@Override
	public void doRender(EntityVillager entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityVillager entity) {
		if(entity.previewProfession != null)
			return entity.previewProfession.getTexture(entity.isMale());
		else
			return entity.getProfession().getTexture(entity.isMale());
	}

	@Override
	protected void preRenderCallback(EntityVillager entitylivingbaseIn, float partialTickTime) {
		float f = 0.9375F;
        GlStateManager.scale(f, f, f);	
	}
	
	
	

}
