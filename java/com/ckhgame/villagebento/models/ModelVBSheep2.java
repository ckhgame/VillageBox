package com.ckhgame.villagebento.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelVBSheep2 extends ModelQuadruped
{
    public ModelVBSheep2()
    {
        super(12, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
        this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
    }
    
    
}