package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProOrchardist extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.lemon)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.orange)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.banana)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.strawberry)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.melon)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.grape)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.pineapple)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("orchardist");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.orchardist");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,1),
				new ItemStack(Items.golden_shovel,1)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProVintner.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.golden_shovel)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
	}
}
