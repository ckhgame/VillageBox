package com.ckhgame.villagebento.util.data;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.tool.VBRandom;
import com.ckhgame.villagebento.util.village.HelperVillageCurrency;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

public class WRChestItem extends WeightedRandom.Item{
	
	public final Item item;
	public final int min;
	public final int max;
	public final int meta;

	public WRChestItem(int weight, Item item, int min, int max, int meta) {
		super(weight);
		this.item = item;
		this.min = min;
		this.max = max;
		this.meta = meta;
	}
	
	public WRChestItem(int weight, Item item, int min, int max) {
		super(weight);
		this.item = item;
		this.min = min;
		this.max = max;
		this.meta = 0;
	}
	
	public WRChestItem(int weight, Block block, int min, int max, int meta) {
		super(weight);
		this.item = Item.getItemFromBlock(block);
		this.min = min;
		this.max = max;
		this.meta = meta;
	}
	
	public WRChestItem(int weight, Block block, int min, int max) {
		super(weight);
		this.item = Item.getItemFromBlock(block);
		this.min = min;
		this.max = max;
		this.meta = 0;
	}
	
	public ItemStack getItemStack(){
		
		if(this.item == ModItems.itemVillageCurrency)
			return HelperVillageCurrency.create(this.meta);
		else if(min == max)
			return new ItemStack(this.item, this.min, this.meta);
		else
			return new ItemStack(this.item, this.min + VBRandom.getRand().nextInt(this.max - this.min),this.meta);
	}
	
}
