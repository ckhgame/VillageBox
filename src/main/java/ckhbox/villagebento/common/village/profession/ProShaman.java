package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProShaman extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.sunStone)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.rainStone)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("shaman");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.shaman");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,25)
		};
		
		this.upgradeToNextOptionClasses = null;
	}

}
