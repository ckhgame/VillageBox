package com.ckhgame.villagebento.villager.component;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;

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
	}
	
	private ArrayList<ItemBuy> buyListAll = new ArrayList<ItemBuy>();
	
	public void addItemBuy(Item item,int min,int max,int minLevel){
		ItemBuy itemBuy = new ItemBuy();
		itemBuy.item = item;
		itemBuy.min = min;
		itemBuy.max = max;
		itemBuy.minLevel = minLevel;
		buyListAll.add(itemBuy);
	}
	
	public ItemStack[] generateBuyList(int currentLevel){
		ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
		Random rand = new Random();
		for(ItemBuy itemBuy : buyListAll){
			if(itemBuy.minLevel <= currentLevel){
				itemStacks.add(new ItemStack(itemBuy.item,rand.nextInt(itemBuy.max - itemBuy.min + 1) + itemBuy.min));
			}
		}
		return (ItemStack[])itemStacks.toArray();
	}

	@Override
	public Class<? extends DataVillagerComp> getDataClass() {
		return DataVillagerComp.class;
	}

}
