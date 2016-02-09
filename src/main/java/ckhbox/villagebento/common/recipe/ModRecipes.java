package ckhbox.villagebento.common.recipe;

import ckhbox.villagebento.common.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	
	public static void init(){
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.villageBook),new ItemStack(Items.book), new ItemStack(Items.emerald));
		
	}
}
