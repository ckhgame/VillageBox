package ckhbox.villagebox.common.util.helper;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class ItemStackHelper {
	public static boolean match(ItemStack[] items, ItemStack[] inputs, int size){
		return match(items, inputs, size, false);
	}
	
	public static boolean consume(ItemStack[] items, ItemStack[] inputs, int size){
		return match(items, inputs, size, true);
	}
	
	private static boolean match(ItemStack[] items,ItemStack[] inputs, int size, boolean consume){
		int[] tempStackSizes = null;
		if(consume){
			tempStackSizes = new int[items.length];
		}
		
		ArrayList<ItemStack> waitForMatching = new ArrayList<ItemStack>();
		for(int i = 0;i<inputs.length;i++){
			if(inputs[i] != null){
				waitForMatching.add(inputs[i]);
			}
		}
		
		boolean found;
		ItemStack item,target;
		for(int i =0;i<size;i++){
			//find item in inputs
			found = false;
			item = items[i];
			if(item == null)
				continue;
			for(int j = 0;j < waitForMatching.size();j++){
				target = waitForMatching.get(j);
				if(item.isItemEqual(target) && item.stackSize >= target.stackSize){
					found = true;
					if(consume){
						tempStackSizes[i] = item.stackSize - target.stackSize;
					}
					waitForMatching.remove(j);
					break;
				}
			}
			if(!found){
				return false;
			}
		}
		
		if(waitForMatching.size() > 0)
			return false;
		
		if(consume){
			for(int i =0;i<items.length;i++){
				if(items != null){
					if(tempStackSizes[i] == 0){
						items[i] = null;
					}
					else{
						items[i].stackSize = tempStackSizes[i];
					}
				}
			}
		}
		
		return true;
	}
}
