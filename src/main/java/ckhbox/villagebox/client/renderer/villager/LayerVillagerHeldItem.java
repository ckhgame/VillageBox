package ckhbox.villagebox.client.renderer.villager;

import ckhbox.villagebox.common.entity.villager.EntityVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;

public class LayerVillagerHeldItem extends LayerHeldItem{
	
	public LayerVillagerHeldItem(RenderLiving<?> livingEntityRendererIn) {
		super(livingEntityRendererIn);
	}

	@Override
	public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float p_177141_2_, float p_177141_3_,
			float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		
		if(((EntityVillager)entitylivingbaseIn).previewProfession == null){ //items should not be displayed in preview/upgradingGui
			super.doRenderLayer(entitylivingbaseIn, p_177141_2_, p_177141_3_, partialTicks, p_177141_5_, p_177141_6_, p_177141_7_,
					scale);
		}
	}
	
	

}
