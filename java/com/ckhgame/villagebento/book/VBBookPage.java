package com.ckhgame.villagebento.book;

import com.ckhgame.villagebento.Main;

import net.minecraft.util.ResourceLocation;

public class VBBookPage {
	private String title;
	private String text;
	private ResourceLocation resourceLocation;
	
	public VBBookPage(String title, String text, String pageTexture){
		this.title = title;
		this.text = text;
		this.resourceLocation = new ResourceLocation(Main.MODID + ":" + "textures/books/"+pageTexture+".png");
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getText(){
		return this.text;
	}
	
	public ResourceLocation getResouceLocation(){
		return this.resourceLocation;
	}
}
