package ckhbox.villagebox.client.renderer.throwable;

import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFactoryFlameBall implements IRenderFactory<EntityFlameBall>{

	@Override
	public Render<? super EntityFlameBall> createRenderFor(RenderManager manager) {
		return new RenderFlameBall(manager, Items.BLAZE_POWDER, Minecraft.getMinecraft().getRenderItem());
	}

}
