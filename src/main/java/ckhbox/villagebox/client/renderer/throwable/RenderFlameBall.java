package ckhbox.villagebox.client.renderer.throwable;

import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFlameBall extends RenderSnowball<EntityFlameBall>{

	public RenderFlameBall(RenderManager renderManagerIn, Item p_i46137_2_, RenderItem p_i46137_3_) {
		super(renderManagerIn, p_i46137_2_, p_i46137_3_);
	}

}
