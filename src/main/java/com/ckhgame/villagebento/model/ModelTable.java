package com.ckhgame.villagebento.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

@SideOnly(Side.CLIENT)
public class ModelTable extends ModelBase
{
    public ModelRenderer table;
    private static final String __OBFID = "CL_00000832";

    public ModelTable()
    {
    	this.table = new ModelRenderer(this, 0, 0).setTextureSize(16, 16);
    	this.table.addBox(4, 0, 4, 8, 1, 8);
    	this.table.addBox(6, 1, 6, 4, 14, 4);
    	this.table.addBox(0, 15, 0, 16, 1, 16);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {    	
        this.table.render(p_78088_7_);
    }
}