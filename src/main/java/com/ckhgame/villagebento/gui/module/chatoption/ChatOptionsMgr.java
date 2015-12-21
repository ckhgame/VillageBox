package com.ckhgame.villagebento.gui.module.chatoption;

import java.util.ArrayList;
import java.util.List;

public class ChatOptionsMgr {
	
	private ArrayList<ChatOptions> chatOptionsList = new ArrayList<ChatOptions>();
	private ChatOptions currentChatOptions = null;
	private List buttonList;
	
	public ChatOptionsMgr(List buttonList){
		this.buttonList = buttonList;
	}
	
	public void addChatOptions(ChatOptions chatOptions){
		this.chatOptionsList.add(chatOptions);
	}
	
	public void EnableChatOptionsByID(int id){
		if(this.currentChatOptions != null){
			this.currentChatOptions.disable(this.buttonList);
		}
		this.currentChatOptions = this.findChatOptionsByID(id);
		if(this.currentChatOptions != null){
			this.currentChatOptions.enable(this.buttonList);
		}
	}
	
	public ChatOptions findChatOptionsByID(int id){
		for(ChatOptions chatOptions : chatOptionsList){
			if(chatOptions.getID() == id)
				return chatOptions;
		}
		return null;
	}
}
