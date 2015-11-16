package com.ckhgame.villagebento.renderer;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBCow;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderVBCow extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation(Main.MODID + ":" + "textures/entity/animal/cow.png");

    public RenderVBCow()
    {
        super(new ModelCow(), 0.7F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityVBCow p_110775_1_)
    {
        return cowTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityVBCow)p_110775_1_);
    }
}