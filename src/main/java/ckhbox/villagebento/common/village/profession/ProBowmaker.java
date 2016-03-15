package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProBowmaker extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin, 25)},
				new ItemStack(ModItems.efficientBow,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)},
				new ItemStack(Items.arrow,20)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("bowmaker");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.bowmaker");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,10)
		};
		
		this.upgradeToNextOptions = null;
	}

}
