package ckhbox.villagebox.client.renderer.throwable;

import ckhbox.villagebox.client.model.villager.ModelVillager;
import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFlameBall extends RenderSnowball<EntityFlameBall>{

	public RenderFlameBall(RenderManager renderManagerIn, Item p_i46137_2_, RenderItem p_i46137_3_) {
		super(renderManagerIn, p_i46137_2_, p_i46137_3_);
	}

}
