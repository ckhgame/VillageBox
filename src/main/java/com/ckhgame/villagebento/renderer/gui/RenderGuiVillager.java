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
	private static final ResourceLocation texEmojiLonely = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_lonely.png");
	private static final ResourceLocation texEmojiBeer = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_beer.png");
	private static final ResourceLocation texEmojiBread = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_bread.png");
	private static final ResourceLocation texEmojiConfused = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_confused.png");
	private static final ResourceLocation texEmojiCry = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_cry.png");
	private static final ResourceLocation texEmojiHappy = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_happy.png");
	private static final ResourceLocation texEmojiMusic = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_music.png");
	private static final ResourceLocation texEmojiPark = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_park.png");
	private static final ResourceLocation texEmojiSurprised = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_surprised.png");
	private static final ResourceLocation texEmojiCoin = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_coin.png");
	private static final ResourceLocation texEmojiDream = new ResourceLocation(Main.MODID + ":" + "textures/render/gui/emoji_dream.png");
	
	private static class EmojiInfo{
		public ResourceLocation resource;
		public int frameInterval;
		public int frameCount;
		public EmojiInfo(ResourceLocation resource, int frameInterval, int frameCount){
			this.resource = resource;
			this.frameInterval = frameInterval;
			this.frameCount = frameCount;
		}
	}
	
	private static EmojiInfo[] emojis= new EmojiInfo[]{
			new EmojiInfo(texEmojiThinking, 500, 5),
			new EmojiInfo(texEmojiLove, 500, 5),
			new EmojiInfo(texEmojiSad, 500, 5),
			new EmojiInfo(texEmojiSleepy, 500, 5),
			new EmojiInfo(texEmojiLonely, 500, 5),
			new EmojiInfo(texEmojiBeer, 500, 5),
			new EmojiInfo(texEmojiBread, 500, 5),
			new EmojiInfo(texEmojiConfused, 500, 5),
			new EmojiInfo(texEmojiCry, 500, 5),
			new EmojiInfo(texEmojiHappy, 500, 5),
			new EmojiInfo(texEmojiMusic, 500, 5),
			new EmojiInfo(texEmojiPark, 500, 5),
			new EmojiInfo(texEmojiSurprised, 500, 5),
			new EmojiInfo(texEmojiCoin, 500, 5),
			new EmojiInfo(texEmojiDream, 1500, 5),
			new EmojiInfo(texEmojiHappy, 500, 5)
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
			EmojiInfo emojiInfo = emojis[entity.getEmojiID()];
			emoji.resource = emojiInfo.resource;
			emoji.frameCount = emojiInfo.frameCount;
			emoji.frameInterval = emojiInfo.frameInterval;
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
		emoji = this.addSpriteAnim(-6, 8, 12, 12, null,500, 5);
	}
	
}
