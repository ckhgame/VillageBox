package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
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
				new ItemStack(Items.string,10),
				new ItemStack(ModItems.silverCoin,12)
		};
		
		this.upgradeToNextOptions = null;
	}

}
