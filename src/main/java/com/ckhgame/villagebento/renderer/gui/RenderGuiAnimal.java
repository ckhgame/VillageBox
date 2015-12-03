package com.ckhgame.villagebento.renderer.gui;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBAnimal;
import com.ckhgame.villagebento.renderer.gui.element.GuiSprite;
import com.ckhgame.villagebento.renderer.gui.element.GuiText;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGuiAnimal extends RenderGuiLiving{

	private static final ResourceLocation texHeart = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/heartAnimal.png");
	private static final ResourceLocation texAnimHappy = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/animHappy.png");
	private static final ResourceLocation texAnimNormal = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/animNormal.png");
	private static final ResourceLocation texAnimSick = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/animSick.png");
	private static final ResourceLocation texAnimDeadly = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/animDeadly.png");
	
	private ResourceLocation texProduct;
	private ResourceLocation texFood;
	
	private GuiText heart,products;
	private GuiSprite food,state;
	
	public RenderGuiAnimal(ResourceLocation textProduct,ResourceLocation textFood){
		this.texProduct = textProduct;
		this.texFood = textFood;
	}
	
	@Override
	protected void update(EntityLiving entity){
		super.update(entity);
		this.update((EntityVBAnimal)entity);
	}

	protected void update(EntityVBAnimal entity){
		heart.text = String.valueOf(entity.getAnimLoveLvl());
		products.text = entity.getAnimProducts() + "/" + entity.getAnimProductsMax();
		
		float f = entity.getAnimHungerPercent();
		food.height = 8.0D * f;
		food.vmin = 1.0D - f;
		
		int s = entity.getAnimState();
		switch(s){
		case EntityVBAnimal.AnimStateHappy:state.resource = texAnimHappy;break;
		case EntityVBAnimal.AnimStateNormal:state.resource = texAnimNormal;break;
		case EntityVBAnimal.AnimStateSick:state.resource = texAnimSick;break;
		case EntityVBAnimal.AnimStateDeadly:state.resource = texAnimDeadly;break;
		}
	}

	@Override
	protected void init() {    
		super.init();
		state = this.addSprite(-16, 8, 8, 8, texAnimHappy);
		this.addSprite(-8, 8, 8, 8, texHeart);
		this.addSprite(0, 8, 8, 8, texProduct);
		GuiSprite foodb = this.addSprite(8, 8, 8, 8, texFood);
		foodb.r = 0.5F;foodb.g = 0.5F;foodb.b = 0.5F;
		food = this.addSprite(8, 8, 8, 8, texFood);
		heart = this.addText(-4, 16, "1", true,true);
		products = this.addText(0, 16, "1/1", false,true);
	}
}
