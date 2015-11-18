package com.ckhgame.villagebento.renderer.gui;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBAnimal;
import com.ckhgame.villagebento.renderer.gui.element.GuiSprite;
import com.ckhgame.villagebento.renderer.gui.element.GuiText;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGuiAnimal extends RenderGuiLiving{

	private static final ResourceLocation textHeart = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/heartAnimal.png");;
	private ResourceLocation textProduct;
	private ResourceLocation textFood;
	
	private GuiText heart,products;
	private GuiSprite food;
	
	public RenderGuiAnimal(ResourceLocation textProduct,ResourceLocation textFood){
		this.textProduct = textProduct;
		this.textFood = textFood;
	}
	
	@Override
	protected void update(EntityLiving entity){
		super.update(entity);
		this.update((EntityVBAnimal)entity);
	}

	protected void update(EntityVBAnimal entity){
		heart.text = String.valueOf(entity.getAnimLoveLvl());
		products.text = String.valueOf(entity.getAnimProducts());
		
		float f = entity.getAnimHungerPercent();
		food.height = 8.0D * f;
		food.vmin = 1.0D - f;
	}

	@Override
	protected void init() {    
		super.init();
		this.addSprite(-12, 8, 8, 8, textHeart);
		this.addSprite(-4, 8, 8, 8, textProduct);
		GuiSprite foodb = this.addSprite(4, 8, 8, 8, textFood);
		foodb.r = 0.5F;foodb.g = 0.5F;foodb.b = 0.5F;
		food = this.addSprite(4, 8, 8, 8, textFood);
		heart = this.addText(-8, 16, "1", true,true);
		products = this.addText(0, 16, "1", true,true);
	}
}
