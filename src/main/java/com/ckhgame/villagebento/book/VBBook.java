package com.ckhgame.villagebento.book;

import java.util.ArrayList;

public class VBBook {
	private String name;
	private ArrayList<VBBookPage> pages = new ArrayList<VBBookPage>();
	
	public VBBook(String name){
		this.name = name;
	}
	
	public void addPage(String title, String text, String pageTexture){
		this.pages.add(new VBBookPage(title, text,pageTexture));
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPageSize(){
		return this.pages.size();
	}
	
	public VBBookPage getPage(int idx){
		if(idx < 0 || idx >= this.pages.size()){
			return null;
		}
		else{
			return this.pages.get(idx);
		}
	}
}
