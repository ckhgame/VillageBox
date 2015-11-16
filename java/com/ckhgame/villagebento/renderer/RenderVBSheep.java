package com.ckhgame.villagebento.renderer;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBSheep;
import com.ckhgame.villagebento.models.ModelVBSheep1;
import com.ckhgame.villagebento.models.ModelVBSheep2;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderVBSheep extends RenderLiving
{
    private static final ResourceLocation sheepTextures = new ResourceLocation(Main.MODID + ":" + "textures/entity/animal/sheep_fur.png");
    private static final ResourceLocation shearedSheepTextures = new ResourceLocation(Main.MODID + ":" + "textures/entity/animal/sheep.png");

    public RenderVBSheep()
    {
        super(new ModelVBSheep2(), 0.7F);
        this.setRenderPassModel(new ModelVBSheep1());
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityVBSheep entity, int p_77032_2_, float p_77032_3_)
    {
    	
        if (p_77032_2_ == 0 && entity.getAnimProducts() > 0)
        {
            this.bindTexture(sheepTextures);

            GL11.glColor3f(1.0F,1.0F,1.0F);

            return 1;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityVBSheep p_110775_1_)
    {
    	System.out.println("getget textrure");
        return shearedSheepTextures;
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityVBSheep)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityVBSheep)p_110775_1_);
    }
}