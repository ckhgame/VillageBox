package com.ckhgame.villagebento.villagercomponent.villagerquest;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.util.tool.VBRandom;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VillagerQuestDesign {
	private ArrayList<ItemStack> needs = new ArrayList<ItemStack>();
	private ArrayList<ItemStack> rewards = new ArrayList<ItemStack>();
	private String title;
	private String description;
	private int minLevel;
	
	public VillagerQuestDesign(String description, int minLevel){
		this.title = "<empty>";
		this.description = description;
		this.minLevel = minLevel;
	}
	
	public VillagerQuestDesign(String title, String description, int minLevel){
		this.title = title;
		this.description = description;
		this.minLevel = minLevel;
	}
	
	public int getMinLevel(){
		return this.minLevel;
	}
	
	public ArrayList<ItemStack> getNeeds(){
		return this.needs;
	}
	
	public ArrayList<ItemStack> getRewards(){
		return this.rewards;
	}
	
	public VillagerQuestDesign addNeeds(Item item, int num, int meta){
		this.needs.add(new ItemStack(item,num,meta));
		return this;
	}
	
	public VillagerQuestDesign addNeeds(Block block, int num, int meta){
		return this.addNeeds(Item.getItemFromBlock(block), num, meta);
	}
	
	public VillagerQuestDesign addRewards(Item item, int num, int meta){
		this.rewards.add(new ItemStack(item,num,meta));
		return this;
	}
	
	public VillagerQuestDesign addRewards(Block block, int num, int meta){
		return this.addRewards(Item.getItemFromBlock(block), num, meta);
	}
	
	public VillagerQuest generateRandomQuest(int id){
		if(this.needs.size() == 0 || this.rewards.size() == 0){
			return null;
		}
		
		Random rand = VBRandom.getRand();
		VillagerQuest quest = new VillagerQuest(id,
												this.title,
												this.description,
												this.needs.get(rand.nextInt(this.needs.size())),
												this.rewards.get(rand.nextInt(this.rewards.size())));
		return quest;
	}
}
