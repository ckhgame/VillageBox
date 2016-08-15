package ckhbox.villagebox.client.renderer.throwable;

import ckhbox.villagebox.common.entity.throwable.EntityLargeSnowBall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFactoryLargeSnowBall implements IRenderFactory<EntityLargeSnowBall>{

	@Override
	public Render<? super EntityLargeSnowBall> createRenderFor(RenderManager manager) {
		return new RenderLargeSnowBall(manager, Items.SNOWBALL, Minecraft.getMinecraft().getRenderItem());
	}

}
