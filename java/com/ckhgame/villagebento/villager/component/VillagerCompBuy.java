package com.ckhgame.villagebento.villager.component;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompBuy;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VillagerCompBuy extends VillagerComponent {
	
	public VillagerCompBuy() {
		super(new GuiVillagerBuy());
		// TODO Auto-generated constructor stub
	}
	
	//------------Villager Buy List Generation-------------
	private class ItemBuy{
		public Item item;
		public int max;
		public int min;
		public int minLevel;
		public int meta;
	}
	
	private ArrayList<ItemBuy> buyListAll = new ArrayList<ItemBuy>();
	
	public void addItemBuy(Item item,int min,int max,int minLevel,int meta){
		ItemBuy itemBuy = new ItemBuy();
		itemBuy.item = item;
		itemBuy.min = min;
		itemBuy.max = max;
		itemBuy.minLevel = minLevel;
		itemBuy.meta = meta;
		buyListAll.add(itemBuy);
	}
	
	public void addItemBuy(Block block,int min,int max,int minLevel,int meta){
		addItemBuy(Item.getItemFromBlock(block),min,max,minLevel,meta);
	}
	
	public void addItemBuy(Block block,int min,int max,int minLevel){
		addItemBuy(Item.getItemFromBlock(block),min,max,minLevel,0);
	}
	
	public void addItemBuy(Item item,int min,int max,int minLevel){
		addItemBuy(item,min,max,minLevel,0);
	}
	
	public ItemStack[] generateBuyList(int currentLevel){
		ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
		Random rand = new Random();
		ItemStack itemStack;
		for(ItemBuy itemBuy : buyListAll){
			if(itemBuy.minLevel <= currentLevel){
				itemStacks.add(new ItemStack(itemBuy.item,rand.nextInt(itemBuy.max - itemBuy.min + 1) + itemBuy.min,itemBuy.meta));
			}
		}
		return (ItemStack[])itemStacks.toArray(new ItemStack[itemStacks.size()]);
	}

	@Override
	public DataVillagerComp getNewDataInstance() {
		return new DataVillagerCompBuy();
	}

}
