package ckhbox.villagebento.common.recipe;

import ckhbox.villagebento.common.block.ModBlocks;
import ckhbox.villagebento.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	
	public static void init(){
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.villageBook),new ItemStack(Items.book), new ItemStack(Items.emerald));
		for(int i =0;i<6;i++){
			GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.mailbox),new ItemStack(Items.paper), new ItemStack(Blocks.planks,1,i));
		}
		
	}
}
