package ckhbox.villagebento.common.village.trading;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class TradingRecipe {
	
	private ItemStack[] itemsInput = new ItemStack[4];
	private ItemStack itemOutput;
	
	public TradingRecipe(ItemStack[] inputs, ItemStack output){
		this.itemsInput = inputs;
		this.itemOutput = output;
	}
	
	public void setItemsInput(ItemStack[] items){
		if(items != null){
			//the part of items passed that is larger than size will be ignored
			int total = Math.min(this.itemsInput.length, items.length);
			for(int i =0;i<total;i++){
				this.itemsInput[i] = items[i];
			}
		}
	}
	
	public ItemStack[] getItemsInput(){
		return this.itemsInput;
	}
	
	public void setItemOutput(ItemStack item){
		this.itemOutput = item;
	}
	
	public ItemStack getItemOutput(){
		return this.itemOutput;
	}
	
	public boolean match(ItemStack[] items){
		return this.match(items, false);
	}
	
	public boolean trade(ItemStack[] items){
		return this.match(items,true);
	}
	
	private boolean match(ItemStack[] items, boolean isTrading){
		int[] tempStackSizes = null;
		if(isTrading){
			tempStackSizes = new int[items.length];
		}
		
		ArrayList<ItemStack> waitForMatching = new ArrayList<ItemStack>();
		for(int i = 0;i<this.itemsInput.length;i++){
			if(this.itemsInput[i] != null){
				waitForMatching.add(this.itemsInput[i]);
			}
		}
		
		boolean found;
		ItemStack item,target;
		for(int i =0;i<4;i++){
			//find item in inputs
			found = false;
			item = items[i];
			if(item == null)
				continue;
			for(int j = 0;j < waitForMatching.size();j++){
				target = waitForMatching.get(j);
				if(item.isItemEqual(target) && item.stackSize >= target.stackSize){
					found = true;
					if(isTrading){
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
		
		if(isTrading){
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
