package com.ckhgame.villagebento.renderer;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBCow;
import com.ckhgame.villagebento.renderer.gui.RenderGuiAnimal;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderVBCow extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation(Main.MODID + ":" + "textures/entity/animal/cow.png");
    private static final ResourceLocation textProduct = new ResourceLocation(Main.MODID + ":" + "textures/items/ItemVillageMilk.png");
    private static final ResourceLocation textFood = new ResourceLocation(Main.MODID + ":" + "textures/items/ItemCowFood.png");
    
    private RenderGuiAnimal renderGui;   
    
    public RenderVBCow()
    {
        super(new ModelCow(), 0.7F);
        renderGui = new RenderGuiAnimal(textProduct,textFood);
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
    
    @Override
	protected void passSpecialRender(EntityLivingBase p_77033_1_, double p_77033_2_, double p_77033_4_,double p_77033_6_) {
		// TODO Auto-generated method stub
		super.passSpecialRender(p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_);
		
		renderGui.render(p_77033_1_,p_77033_2_,p_77033_4_,p_77033_6_);
	}
}