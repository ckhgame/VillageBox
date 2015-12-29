package com.ckhgame.villagebento.renderer.gui;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBAnimal;
import com.ckhgame.villagebento.renderer.gui.element.GuiSprite;
import com.ckhgame.villagebento.renderer.gui.element.GuiText;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGuiAnimal extends RenderGuiLiving{

	private static final ResourceLocation texHeart0 = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/heartAnimal0.png");
	private static final ResourceLocation texHeart1 = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/heartAnimal1.png");
	private static final ResourceLocation texHeart2 = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/heartAnimal2.png");
	private static final ResourceLocation texHeart3 = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/heartAnimal3.png");
	private static final ResourceLocation texHeart4 = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/heartAnimal4.png");
	
	private static final ResourceLocation texAnimHappy = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/animHappy.png");
	private static final ResourceLocation texAnimSad = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/animSad.png");
	private static final ResourceLocation texAnimSick = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/animSick.png");
	
	private ResourceLocation texProduct;
	private ResourceLocation texFood;
	
	private GuiSprite food,state,heart,products;
	
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
		products.isVisible = entity.hasProduct();
		
		int l = entity.getAnimLoveLevel();
		switch(l){
		case 0:heart.resource = texHeart0;break;
		case 1:heart.resource = texHeart1;break;
		case 2:heart.resource = texHeart2;break;
		case 3:heart.resource = texHeart3;break;
		case 4:heart.resource = texHeart4;break;
		}
		
		int s = entity.getAnimState();
		switch(s){
		case EntityVBAnimal.AnimStateHappy:state.resource = texAnimHappy;break;
		case EntityVBAnimal.AnimStateSad:state.resource = texAnimSad;break;
		case EntityVBAnimal.AnimStateSick:state.resource = texAnimSick;break;
		}
	}

	@Override
	protected void init() {    
		super.init();
		heart = this.addSprite(-12, 8, 8, 8, texHeart0);
		state = this.addSprite(-4, 8, 8, 8, texAnimHappy);
		products = this.addSprite(4, 8, 8, 8, texProduct);
	}
}
