package com.ckhgame.villagebento.villager.component;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompSell;
import com.ckhgame.villagebento.gui.GuiVillagerSell;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VillagerCompSell extends VillagerComponent {
	
	public VillagerCompSell() {
		super(new GuiVillagerSell());
		// TODO Auto-generated constructor stub
	}
	
	//------------Villager Sell List Generation-------------
	private class ItemSell{
		public Item item;
		public int max;
		public int min;
		public int minLevel;
		public int meta;
	}
	
	private ArrayList<ItemSell> sellListAll = new ArrayList<ItemSell>();
	
	public void addItemSell(Item item,int min,int max,int minLevel,int meta){
		ItemSell itemSell = new ItemSell();
		itemSell.item = item;
		itemSell.min = min;
		itemSell.max = max;
		itemSell.minLevel = minLevel;
		itemSell.meta = meta;
		sellListAll.add(itemSell);
	}
	
	public void addItemSell(Block block,int min,int max,int minLevel,int meta){
		addItemSell(Item.getItemFromBlock(block),min,max,minLevel,meta);
	}
	
	public void addItemSell(Block block,int min,int max,int minLevel){
		addItemSell(Item.getItemFromBlock(block),min,max,minLevel,0);
	}
	
	public void addItemSell(Item item,int min,int max,int minLevel){
		addItemSell(item,min,max,minLevel,0);
	}
	
	public ItemStack[] generateSellList(int currentLevel){
		ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
		Random rand = new Random();
		ItemStack itemStack;
		for(ItemSell itemSell : sellListAll){
			if(itemSell.minLevel <= currentLevel){
				itemStacks.add(new ItemStack(itemSell.item,rand.nextInt(itemSell.max - itemSell.min + 1) + itemSell.min,itemSell.meta));
			}
		}
		return (ItemStack[])itemStacks.toArray(new ItemStack[itemStacks.size()]);
	}

	@Override
	public DataVillagerComp getNewDataInstance() {
		return new DataVillagerCompSell();
	}

}
