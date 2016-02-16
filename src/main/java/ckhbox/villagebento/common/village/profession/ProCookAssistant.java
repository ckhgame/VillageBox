package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProCookAssistant extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10),new ItemStack(ModItems.soybean,3)},
				new ItemStack(ModItems.cookingOil)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10),new ItemStack(ModItems.riceplant,2)},
				new ItemStack(ModItems.rice)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10),new ItemStack(ModItems.riceplant,3)},
				new ItemStack(ModItems.riceFlour)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10),new ItemStack(ModItems.soybean,3)},
				new ItemStack(ModItems.soySauce)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("cookassistant");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.cookassistant");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,1),
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProGastronomist.class
				};
	}
	
}
