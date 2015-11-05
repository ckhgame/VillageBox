package com.ckhgame.villagebento.misc;

import java.util.HashMap;

import com.ckhgame.villagebento.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ItemPrice {
	
	
	public static void init(){
		register(Blocks.log,2);
		register(Blocks.log2,2);
		register(Blocks.cobblestone,2);
		
		register(Items.rotten_flesh,4);
		register(ModBlocks.blockArchitectsHome,250);
		register(ModBlocks.blockMiningHouse,100);
		register(ModBlocks.blockSmallBakery,70);
		register(ModBlocks.blockFishingStore,150);
		
		register(Items.bread,10);
		register(Items.wheat_seeds,2);
		
		register(Items.cooked_fished,10);
		register(Items.fishing_rod,50);
		register(Items.fish,6);
	}
	
	
	
	
	
	
	
	
	
	private static HashMap<Item,Integer> mapItemPrice = new HashMap<Item,Integer>();
	
	private static void register(Item item, int price){
		mapItemPrice.put(item, Math.max(0, price));
	}
	
	private static void register(Block block, int price){
		register(Item.getItemFromBlock(block),price);
	}
	
	public static int getPrice(Item item){
		if(mapItemPrice.containsKey(item))
			return mapItemPrice.get(item);
		else
			return 0;
	}
	
	public static int getPrice(Block block){
		return getPrice(Item.getItemFromBlock(block));
	}
	
	public static int getSellPrice(Item item){
		return (int)Math.ceil(getPrice(item) * 0.5);
	}
	
	public static int getSellPrice(Block block){
		return getSellPrice(Item.getItemFromBlock(block));
	}
	
	public static int getBuyPrice(Item item){
		return getPrice(item);
	}
	
	public static int getBuyPrice(Block block){
		return getBuyPrice(Item.getItemFromBlock(block));
	}
}
