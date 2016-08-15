package ckhbox.villagebox.client.renderer;

import ckhbox.villagebox.client.renderer.painting.RenderFactoryPainting;
import ckhbox.villagebox.client.renderer.throwable.RenderFactoryFlameBall;
import ckhbox.villagebox.client.renderer.throwable.RenderFactoryLargeSnowBall;
import ckhbox.villagebox.client.renderer.villager.RenderFactoryVillager;
import ckhbox.villagebox.common.entity.painting.EntityPainting;
import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.entity.throwable.EntityLargeSnowBall;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModEntityRenderers {
	public static void init(){
		RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderFactoryVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameBall.class, new RenderFactoryFlameBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityLargeSnowBall.class, new RenderFactoryLargeSnowBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityPainting.class, new RenderFactoryPainting());
	}

}
