package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.item.ItemStack;

public class ProVintner extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.cookingWine)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.grape,1)},
				new ItemStack(ModItems.grapeWine)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.cocktail)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,5),
						new ItemStack(ModItems.riceplant,1)},
				new ItemStack(ModItems.beer)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.whisky)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.vodka)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("vintner");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.vintner");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.grape,5),
				new ItemStack(ModItems.riceplant,5),
				new ItemStack(ModItems.silverCoin,1)
		};
		
		this.upgradeToNextOptions = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(ModItems.grape),
				new ItemStack(ModItems.grapeWine)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
	}
	
}
