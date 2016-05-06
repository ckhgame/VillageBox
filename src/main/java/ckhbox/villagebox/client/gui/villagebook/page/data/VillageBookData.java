package ckhbox.villagebox.client.gui.villagebook.page.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.village.profession.Profession;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VillageBookData{
	public List<ItemStack> itemstacks = new ArrayList<ItemStack>();
	public List<Profession> pros = new ArrayList<Profession>();
	public HashMap<String,ItemStack> mapNamesToItemStacks = new HashMap<String,ItemStack>();
	
	public VillageBookData(){
		this.generate();
	}
	
	public void generate(){
		//items
		this.itemstacks.clear();
		for (Item item : Item.itemRegistry){
            if (item == null){
                continue;
            }
            for (CreativeTabs tab : item.getCreativeTabs()){
                if (tab == ModItems.tabVB){
                	item.getSubItems(item, ModItems.tabVB, this.itemstacks);
                }
            }
        }
		this.mapNamesToItemStacks.clear();
		for(ItemStack itemstack : this.itemstacks){
			this.mapNamesToItemStacks.put(itemstack.getUnlocalizedName(), itemstack);
		}
		
		//professions
		this.pros = Profession.registry.getAll();
	}
	
	public List<Profession> findRelatedProByItem(ItemStack itemstack){
		List<Profession> list = new ArrayList<Profession>();
		for(Profession pro : this.pros){
			for(TradingRecipe recipe : pro.getTradingRecipeList()){
				if(recipe.getItemOutput().isItemEqual(itemstack)){
					list.add(pro);
					break;
				}
			}
		}
		return list;
	}
}
