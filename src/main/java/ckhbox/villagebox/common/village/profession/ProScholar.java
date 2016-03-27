package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProScholar extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)},
				new ItemStack(Items.book)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)},
				new ItemStack(Items.paper)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("scholar");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.scholar");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.book,1),
				new ItemStack(ModItems.silverCoin,1)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProBookseller.class,
				ProMage.class,
				ProPainter.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.book)
		};
	}

}
