package com.ckhgame.villagebento.renderer;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderVBVillager extends RenderBiped
{
	private static final ResourceLocation defaultTextures = new ResourceLocation("textures/entity/steve.png");
	
    /** Model of the villager. */
    protected ModelBiped villagerModel;

    public RenderVBVillager()
    {
        super(new ModelBiped(), 0.5F);
        this.villagerModel = (ModelBiped)this.mainModel;
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityVBVillager p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return super.shouldRenderPass(p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityVBVillager p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityVBVillager p)
    {
    	ResourceLocation t = p.getSkinTexture();
    	if(t == null)
    		t = defaultTextures;
    	return t;
    }

    protected void renderEquippedItems(EntityVBVillager p_77029_1_, float p_77029_2_)
    {
        super.renderEquippedItems(p_77029_1_, p_77029_2_);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityVBVillager p_77041_1_, float p_77041_2_)
    {
    	 float f1 = 0.9375F;

         if (p_77041_1_.getGrowingAge() < 0)
         {
             f1 = (float)((double)f1 * 0.5D);
             this.shadowSize = 0.25F;
         }
         else
         {
             this.shadowSize = 0.5F;
         }

         GL11.glScalef(f1, f1, f1);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityVBVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityVBVillager)p_77041_1_, p_77041_2_);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityVBVillager)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.renderEquippedItems((EntityVBVillager)p_77029_1_, p_77029_2_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityVBVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityVBVillager)p_110775_1_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityVBVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    
    @Override
	protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		// TODO Auto-generated method stub
		this.rotateCorpse((EntityVBVillager)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	protected void rotateCorpse(EntityVBVillager p, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {		
        if (p.isEntityAlive() && p.getSleeping())
        {
            GL11.glRotatef(p.getBedOrientationInDegrees(), 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(this.getDeathMaxRotation(p), 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0, -0.5F, -0.1F);
        }
        else
        {
            super.rotateCorpse(p, p_77043_2_, p_77043_3_, p_77043_4_);
        }
    }
	
	
	
	@Override
	protected void passSpecialRender(EntityLivingBase p_77033_1_, double p_77033_2_, double p_77033_4_,double p_77033_6_) {
		// TODO Auto-generated method stub
		super.passSpecialRender(p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_);
		
		String hpTxt = "[" + (int)p_77033_1_.getHealth() + "/" + (int)p_77033_1_.getMaxHealth() + "]";
		
		renderSpeName(p_77033_1_,hpTxt,0.2F,p_77033_2_, p_77033_4_, p_77033_6_,64);
		
	}

	protected void renderSpeName(Entity p_147906_1_, String p_147906_2_,float offsetY, double p_147906_3_, double p_147906_5_,double p_147906_7_, int p_147906_9_) {
		double d3 = p_147906_1_.getDistanceSqToEntity(this.renderManager.livingPlayer);

		if (d3 <= (double) (p_147906_9_ * p_147906_9_)) {
			FontRenderer fontrenderer = this.getFontRendererFromRenderManager();
			float f = 1.6F;
			float f1 = 0.016666668F * f;
			GL11.glPushMatrix();
			GL11.glTranslatef((float) p_147906_3_ + 0.0F, (float) p_147906_5_ + p_147906_1_.height + 0.5F + offsetY,
					(float) p_147906_7_);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(-f1, -f1, f1);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDepthMask(false);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			Tessellator tessellator = Tessellator.instance;
			byte b0 = 0;

			if (p_147906_2_.equals("deadmau5")) {
				b0 = -10;
			}

			GL11.glDisable(GL11.GL_TEXTURE_2D);
			tessellator.startDrawingQuads();
			int j = fontrenderer.getStringWidth(p_147906_2_) / 2;
			tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
			tessellator.addVertex((double) (-j - 1), (double) (-1 + b0), 0.0D);
			tessellator.addVertex((double) (-j - 1), (double) (8 + b0), 0.0D);
			tessellator.addVertex((double) (j + 1), (double) (8 + b0), 0.0D);
			tessellator.addVertex((double) (j + 1), (double) (-1 + b0), 0.0D);
			tessellator.draw();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			fontrenderer.drawString(p_147906_2_, -fontrenderer.getStringWidth(p_147906_2_) / 2, b0, 553648127);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(true);
			fontrenderer.drawString(p_147906_2_, -fontrenderer.getStringWidth(p_147906_2_) / 2, b0, -1);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
		}
	}
}