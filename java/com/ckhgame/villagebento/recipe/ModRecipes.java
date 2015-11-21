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
		
		
		//item hamburger
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHambuger), 
				   " A ",
				   "BCD",
				   " A ",
				   'A',Items.bread,
				   'B',ModItems.itemCabbage,
				   'C',ModItems.itemCheese,
				   'D',Items.porkchop);
		
		//item carrot cake
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCarrotCake, 1), 
				new Object[] { Items.carrot,Items.cake});
		
		//item wheat flour
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemWheatFlour, 1), 
				new Object[] { Items.wheat,Items.stick});
		
		//item pork ramen
		GameRegistry.addRecipe(new ItemStack(ModItems.itemPorkRamen), 
				" A ",
				" B ",
				" C ",
				'A',Items.water_bucket,
				'B',Items.porkchop,
				'C',ModItems.itemWheatFlour);
			
		//item beef udon
		GameRegistry.addRecipe(new ItemStack(ModItems.itemUdon), 
				" A ",
				" B ",
				" C ",
				'A',Items.water_bucket,
				'B',ModItems.itemSeaweed,
				'C',ModItems.itemWheatFlour);
		
		//item fries
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemFries, 1), 
				new Object[] { Items.potato,ModItems.itemOil});
		
		//item melon ice
		GameRegistry.addRecipe(new ItemStack(ModItems.itemMelonIce), 
				" A ",
				" B ",
				" C ",
				'A',ModItems.itemMayonaise,
				'B',Items.snowball,
				'C',Items.melon);		

		//item apple candy
		GameRegistry.addRecipe(new ItemStack(ModItems.itemAppleCandy), 
				" A ",
				" B ",
				" C ",
				'A',Items.sugar,
				'B',Items.apple,
				'C',Items.stick);
		
		//item cheese
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCheese, 1), 
				new Object[] { ModItems.itemVillageMilk,ModItems.itemVillageMilk,ModItems.itemVillageMilk});	
		
		//item salt
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemSalt, 1), 
				new Object[] { Items.water_bucket,ModItems.itemGauze});

		//item rice flour
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemRiceFlour, 1), 
				new Object[] {Items.stick,ModItems.itemRiceplant});
		
		//item noodle soup
		GameRegistry.addRecipe(new ItemStack(ModItems.itemNoodleSoup), 
				" A ",
				" B ",
				" C ",
				'A',ModItems.itemSalt,
				'B',Items.water_bucket,
				'C',ModItems.itemRiceFlour);
	
		//item congee
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCongee), 
				" A ",
				" B ",
				" C ",
				'A',ModItems.itemSalt,
				'B',Items.water_bucket,
				'C',ModItems.itemRice);
		
		//item nigiri
		GameRegistry.addRecipe(new ItemStack(ModItems.itemNigiri,2), 
				" A ",
				" B ",
				" C ",
				'A',ModItems.itemSalt,
				'B',new ItemStack(Items.fish),
				'C',ModItems.itemRice);
		
		//item soy sauce
		GameRegistry.addRecipe(new ItemStack(ModItems.itemSoySauce), 
				" A ",
				"B C",
				" D ",
				'A',ModItems.itemSalt,
				'B',Items.wheat,
				'C',Items.water_bucket,
				'D',ModItems.itemSoybeans);
		
		//item tofu
		GameRegistry.addRecipe(new ItemStack(ModItems.itemTofu), 
				" A ",
				" B ",
				" C ",
				'A',ModItems.itemSoybeans,
				'B',Items.water_bucket,
				'C',ModItems.itemGauze);
		
		//item Mapotoufu
		GameRegistry.addRecipe(new ItemStack(ModItems.itemMapoTofu), 
				"A B",
				"CDE",
				"F G",
				'A',ModItems.itemCookVine,
				'B',ModItems.itemOil,
				'C',ModItems.itemSoySauce,
				'D',ModItems.itemSalt,
				'E',ModItems.itemChili,
				'F',ModItems.itemTofu,
				'G',Items.porkchop);
		
		//item oil
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemOil, 1), 
				new Object[] { ModItems.itemCorn,ModItems.itemCorn,ModItems.itemCorn});	
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemOil, 1), 
				new Object[] { new ItemStack(Blocks.double_plant,0),new ItemStack(Blocks.double_plant,0),new ItemStack(Blocks.double_plant,0)});	
			
		
		//item bouquet steak
		GameRegistry.addRecipe(new ItemStack(ModItems.itemBouquetLamb), 
				" A ",
				" C ",
				" B ",
				'A',ModItems.itemOil,
				'B',Items.beef,
				'C',ModItems.itemCookVine);
		
		//item corn chips
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCornChips, 1), 
				new Object[] { ModItems.itemCorn,ModItems.itemOil});
		
		//item creamy corn
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCreamyCorn), 
				"A B",
				" C ",
				" D ",
				'A',ModItems.itemVillageMilk,
				'B',ModItems.itemCheese,
				'C',ModItems.itemCorn,
				'D',Items.stick);
		
		//item beef noodle soup
		GameRegistry.addRecipe(new ItemStack(ModItems.itemBeefNoodleSoup), 
				"A B",
				" C ",
				" D ",
				'A',ModItems.itemChili,
				'B',ModItems.itemOil,
				'C',Items.beef,
				'D',ModItems.itemNoodleSoup);
		
		//item beef boiled fish
		GameRegistry.addRecipe(new ItemStack(ModItems.itemBoiledFish), 
				" A ",
				"B C",
				" D ",
				'A',ModItems.itemChili,
				'B',ModItems.itemOil,
				'C',Items.water_bucket,
				'D',new ItemStack(Items.fish));
		
		//item grape wine
		GameRegistry.addRecipe(new ItemStack(ModItems.itemGrapeVine), 
				" A ",
				" B ",
				" C ",
				'A',Items.sugar,
				'B',ModItems.itemGrapes,
				'C',Items.glass_bottle);
		


	}
}
