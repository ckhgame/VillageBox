package com.ckhgame.villagebento.util.data;

import java.util.ArrayList;
import java.util.Random;

public class VillagerChat {
	
	private class ChatItem
	{
		public int minLevel;
		public String content;
	}
	
	private ArrayList<ChatItem> chatItems = new ArrayList<ChatItem>();
	
	public void add(int minLevel,String content){
		ChatItem item = new ChatItem();
		item.minLevel = minLevel;
		item.content = content;
		chatItems.add(item);
	}
	
	private ArrayList<ChatItem> getChatItemsByLevel(int level){
		ArrayList<ChatItem> results = new ArrayList<ChatItem>();
		for(ChatItem item : chatItems){
			if(item.minLevel <= level)
				results.add(item);
		}
		return results;
	}
	
	public String getRandom(int level){
		ArrayList<ChatItem> results = getChatItemsByLevel(level);
		if(results.size() == 0){
			return "Can not find any chat item :(";
		}
		
		Random rand = new Random();
		return results.get(rand.nextInt(results.size())).content;
	}
	
	private int getInOrderlastIdx = 0;
	public String getInOrder(int level){
		ArrayList<ChatItem> results = getChatItemsByLevel(level);
		if(results.size() == 0){
			return "Can not find any chat item :(";
		}
		
		if(getInOrderlastIdx >= results.size())
			getInOrderlastIdx = 0;
		return results.get(getInOrderlastIdx++).content;
	}
}
