package com.ckhgame.villagebento.recipe;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
	public static void init(){
		//block village center
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockVillageCenter), 
				   "AAA",
				   "ABA",
				   "CCC",
				   'A',Blocks.log,
				   'B',Blocks.torch,
				   'C',Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockVillageCenter), 
				   "AAA",
				   "ABA",
				   "CCC",
				   'A',Blocks.log2,
				   'B',Blocks.torch,
				   'C',Blocks.cobblestone);
		
		
		//block village stick
		GameRegistry.addRecipe(new ItemStack(ModItems.itemVillageStick), 
				   " A ",
				   " B ",
				   " B ",
				   'A',ModBlocks.blockVillageCenter,
				   'B',Items.stick);
	}
}
