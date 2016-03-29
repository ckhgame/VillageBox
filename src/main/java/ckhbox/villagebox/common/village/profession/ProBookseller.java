package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProBookseller extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,50)},
				new ItemStack(ModItems.treasureHuntBookI)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5)},
				new ItemStack(ModItems.treasureHuntBookII)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,30)},
				new ItemStack(ModItems.treasureHuntBookIII)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.resetScroll)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("bookseller");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.bookseller");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,1),
				new ItemStack(Items.book,10)
		};
		
		this.upgradeToNextOptionClasses = null;
	}

	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.book)
		};
	}
}
