package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProChef extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.porkRamen)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.beefNoodleSoup)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.noodleSoup)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.hambuger)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.congee)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.boiledFish)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.fries)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.mapoTofu)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.cornChips)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.roastedLamb)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.nigiri)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.udon)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("chef");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.chef");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,10)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
}
