package ckhbox.villagebox.common.config.jsonData;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import scala.collection.mutable.StringBuilder;

public class JsonHelper {
	
	//objectives & rewards item stack string format:
	//domain,itemID,amount,meta
	//example: minecraft,log,1,0 indicates a Vanillia Minecraft Oak Wood
	//the amount should be between 1 and 64
		
	
	public static ItemStack stringToItemStack(String text)
	{
		String[] arrs = text.split(",");
		return new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(arrs[0],arrs[1])),Integer.valueOf(arrs[2]),Integer.valueOf(arrs[3]));
	}
	
	public static ItemStack[] stringsToItemStacks(String[] texts)
	{
		if(texts == null || texts.length == 0) return null;
		
		ItemStack[] stacks = new ItemStack[texts.length];
		for(int i =0;i<stacks.length;i++)
			stacks[i] = stringToItemStack(texts[i]);
		return stacks;
	}
	
	public static String itemStackToString(ItemStack stack)
	{
		ResourceLocation location = Item.REGISTRY.getNameForObject(stack.getItem());
		return String.format("%s,%s,%d,%d", location.getResourceDomain(), location.getResourcePath(), stack.stackSize, stack.getItemDamage());
	}
	
	public static String[] itemStacksToStrings(ItemStack[] stacks)
	{
		if(stacks == null) return null;
		String[] texts = new String[stacks.length];
		for(int i =0;i<stacks.length;i++)
		{
			texts[i] = itemStackToString(stacks[i]);
		}
		return texts;
	}
}
