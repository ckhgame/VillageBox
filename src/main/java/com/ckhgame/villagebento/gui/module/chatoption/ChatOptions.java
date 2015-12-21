package com.ckhgame.villagebento.gui.module.chatoption;

import java.util.ArrayList;
import java.util.List;

import com.ckhgame.villagebento.gui.module.GuiTextButton;

public class ChatOptions {
	
	private int id;
	private ArrayList<GuiTextButton> options = new ArrayList<GuiTextButton>();
	
	public int getID(){
		return this.id;
	}
	
	public ChatOptions(int id){
		this.id = id;
	}
	
	public void enable(List buttonList){
		for(GuiTextButton option : options)
			buttonList.add(option);
	}
	
	public void disable(List buttonList){
		for(GuiTextButton option : options)
			buttonList.remove(option);
	}
	
	public void addOption(GuiTextButton option){
		this.options.add(option);
	}
	
	public void clearAllOptions(){
		this.options.clear();
	}
}
