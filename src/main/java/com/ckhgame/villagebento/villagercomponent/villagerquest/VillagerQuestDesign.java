package com.ckhgame.villagebento.villagercomponent.villagerquest;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.tool.VBRandom;
import com.ckhgame.villagebento.util.village.HelperVillageCurrency;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

public class VillagerQuestDesign extends WeightedRandom.Item{
	private ArrayList<ItemStack> needs = new ArrayList<ItemStack>();
	private ArrayList<ItemStack> rewards = new ArrayList<ItemStack>();
	private String title;
	private String description;
	private int minLevel;
	
	public VillagerQuestDesign(String description, int minLevel,int weight){
		super(weight);
		this.title = "<empty>";
		this.description = description;
		this.minLevel = minLevel;
	}
	
	public VillagerQuestDesign(String title, String description, int minLevel,int weight){
		super(weight);
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
		if(item == ModItems.itemVillageCurrency)
			this.rewards.add(HelperVillageCurrency.create(meta));
		else
			this.needs.add(new ItemStack(item,num,meta));
		return this;
	}
	
	public VillagerQuestDesign addNeeds(Block block, int num, int meta){
		return this.addNeeds(Item.getItemFromBlock(block), num, meta);
	}
	
	public VillagerQuestDesign addRewards(Item item, int num, int meta){
		if(item == ModItems.itemVillageCurrency)
			this.rewards.add(HelperVillageCurrency.create(meta));
		else
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
