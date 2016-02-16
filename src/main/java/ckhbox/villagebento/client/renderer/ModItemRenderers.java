package ckhbox.villagebento.client.renderer;

import ckhbox.villagebento.client.renderer.villager.RenderFactoryVillager;
import ckhbox.villagebento.common.block.ModBlocks;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModItemRenderers {
	
	public static void init(){
		
		registerModel(ModItems.treasureHuntBookI, 0, "treasure_hunt_book_0");
		registerModel(ModItems.treasureHuntBookII, 0, "treasure_hunt_book_1");
		registerModel(ModItems.treasureHuntBookIII, 0, "treasure_hunt_book_2");
		registerModel(ModItems.bronzeCoin, 0, "bronze_coin");
		registerModel(ModItems.silverCoin, 0, "silver_coin");
		registerModel(ModItems.goldCoin, 0, "gold_coin");
		registerModel(ModItems.mail, 0, "mail");
		registerModel(ModItems.flameStaff, 0, "flame_staff");
		registerModel(ModItems.processedWoodPlank, 0, "processed_wood_plank");
		registerModel(ModItems.reinforcedIronIngot, 0, "reinforced_iron_ingot");
		
		registerModel(ModItems.cabbage, 0, "cabbage");
		registerModel(ModItems.riceplant, 0, "riceplant");
		registerModel(ModItems.chili, 0, "chili");
		registerModel(ModItems.corn, 0, "corn");
		registerModel(ModItems.soybean, 0, "soybean");
		
		registerModel(ModItems.cheese, 0, "cheese");
		registerModel(ModItems.mayonnaise, 0, "mayonnaise");
		registerModel(ModItems.ballOfWool, 0, "ball_of_wool");
		
		registerModel(ModItems.rice, 0, "rice");
		registerModel(ModItems.riceFlour, 0, "rice_flour");
		registerModel(ModItems.cookingOil, 0, "cooking_oil");
		registerModel(ModItems.soySauce, 0, "soy_sauce");
		
		registerModel(ModItems.grapeWine, 0, "grape_wine");
		registerModel(ModItems.cookingWine, 0, "cooking_wine");
		registerModel(ModItems.cocktail, 0, "cocktail");
		registerModel(ModItems.beer, 0, "beer");
		registerModel(ModItems.whisky, 0, "whisky");
		registerModel(ModItems.vodka, 0, "vodka");
		
		registerModel(ModItems.banana, 0, "banana");
		registerModel(ModItems.orange, 0, "orange");
		registerModel(ModItems.melon, 0, "melon");
		registerModel(ModItems.lemon, 0, "lemon");
		registerModel(ModItems.strawberry, 0, "strawberry");
		registerModel(ModItems.pineapple, 0, "pineapple");
		registerModel(ModItems.grape, 0, "grape");
	}

	private static void registerModel(Item item, int meta, String resource){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, meta, new ModelResourceLocation(PathHelper.full(resource), "inventory"));
	}
}
