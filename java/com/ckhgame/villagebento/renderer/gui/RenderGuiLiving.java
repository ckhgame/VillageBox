package com.ckhgame.villagebento.renderer.gui;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.renderer.gui.element.GuiSprite;
import com.ckhgame.villagebento.renderer.gui.element.GuiText;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGuiLiving extends RenderGui {

	private static final ResourceLocation hpBarTextures = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/hpbar.png");
	private static final ResourceLocation hpBarFillTextures = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/hpbarFill.png");
	
	protected GuiText hp;
	protected GuiSprite hpBarFill;

	@Override
	protected void update(Entity entity) {
		update((EntityLiving)entity);
	}
	
	protected void update(EntityLiving entity){
		hp.text = (int)entity.getHealth() + "/" + (int)entity.getMaxHealth();
		float p = entity.getHealth() / entity.getMaxHealth();
		hpBarFill.width = 32 * p;
		hpBarFill.umax = p;
	}

	@Override
	protected void init() {     
        this.addSprite(-16, 0, 32, 8, hpBarTextures);
        hpBarFill = this.addSprite(-16, 0, 32, 8, hpBarFillTextures);
        hp = this.addText(0, 0, "10/10", true,false);
	}
	
}
