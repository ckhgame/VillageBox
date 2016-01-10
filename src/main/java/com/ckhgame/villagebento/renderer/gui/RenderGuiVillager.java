package com.ckhgame.villagebento.renderer.gui;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.config.ConfigDev;
import com.ckhgame.villagebento.entity.animal.EntityVBAnimal;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.renderer.gui.element.GuiSprite;
import com.ckhgame.villagebento.renderer.gui.element.GuiText;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGuiVillager extends RenderGuiLiving {
	
	private GuiText debugText;
	
	@Override
	protected void update(EntityLiving entity){
		super.update(entity);
		this.update((EntityVBVillager)entity);
	}
	
	protected void update(EntityVBVillager entity){
		
		if(ConfigDev.VillagerDebugEnabled){
			debugText.text = entity.getDebugText();
		}
	}

	@Override
	protected void init() {    
		super.init();
		
		if(ConfigDev.VillagerDebugEnabled){
			debugText = this.addText(0, 8, "Debug Test", true, false);
		}
	}
	
}
