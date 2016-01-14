package com.ckhgame.villagebento.renderer.gui;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.config.ConfigDev;
import com.ckhgame.villagebento.entity.animal.EntityVBAnimal;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.renderer.gui.element.GuiSprite;
import com.ckhgame.villagebento.renderer.gui.element.GuiSpriteAnim;
import com.ckhgame.villagebento.renderer.gui.element.GuiText;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGuiVillager extends RenderGuiLiving {
	
	private GuiText debugText;
	private GuiSpriteAnim emoji;
	
	private static final ResourceLocation texEmojiThinking = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_thinking.png");
	private static final ResourceLocation texEmojiLove = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_love.png");
	private static final ResourceLocation texEmojiSad = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_sad.png");
	private static final ResourceLocation texEmojiSleepy = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_sleepy.png");
	
	private static ResourceLocation[] emojis= new ResourceLocation[]{
			texEmojiThinking,
			texEmojiLove,
			texEmojiSad,
			texEmojiSleepy
	};
	
	
	
	@Override
	protected void update(EntityLiving entity){
		super.update(entity);
		this.update((EntityVBVillager)entity);
	}
	
	protected void update(EntityVBVillager entity){
		
		if(ConfigDev.VillagerDebugEnabled){
			debugText.text = entity.getDebugText();
		}
		
		if(entity.hasEmoji()){
			System.out.println(entity.getEmojiID());
			emoji.resource = emojis[entity.getEmojiID()];
		}else{
			emoji.resource = null;
		}
		
	}

	@Override
	protected void init() {    
		super.init();
		
		if(ConfigDev.VillagerDebugEnabled){
			debugText = this.addText(0, 20, "Debug Test", true, false);
		}
		emoji = this.addSpriteAnim(-6, 8, 12, 12, null,1.0F, 5);
	}
	
}
