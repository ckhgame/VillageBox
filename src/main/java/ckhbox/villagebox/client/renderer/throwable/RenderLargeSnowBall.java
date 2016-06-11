package ckhbox.villagebox.client.renderer.throwable;

import ckhbox.villagebox.common.entity.throwable.EntityLargeSnowBall;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLargeSnowBall extends RenderSnowball<EntityLargeSnowBall>{

	public RenderLargeSnowBall(RenderManager renderManagerIn, Item p_i46137_2_, RenderItem p_i46137_3_) {
		super(renderManagerIn, p_i46137_2_, p_i46137_3_);
	}

	@Override
	public void doRender(EntityLargeSnowBall entity, double x, double y, double z, float entityYaw,
			float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float)x, (float)y, (float)z);
		GlStateManager.scale(3.0D, 3.0D, 3.0D);
		GlStateManager.translate(-(float)x, -(float)y, -(float)z);
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		GlStateManager.popMatrix();
	}
	
	

}
