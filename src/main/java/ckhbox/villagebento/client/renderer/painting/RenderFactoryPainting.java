package ckhbox.villagebento.client.renderer.painting;

import ckhbox.villagebento.common.entity.painting.EntityPainting;
import ckhbox.villagebento.common.entity.throwable.EntityFlameBall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityHanging;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFactoryPainting implements IRenderFactory<EntityPainting>{

	@Override
	public Render<? super EntityPainting> createRenderFor(RenderManager manager) {
		return new RenderPainting(manager);
	}

}
