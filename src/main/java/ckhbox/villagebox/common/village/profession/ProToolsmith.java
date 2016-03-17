package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProToolsmith extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelAxe)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelPickaxe)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelHoe)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelShovel)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("toolsmith");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.toolsmith");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,15)
		};
		
		this.upgradeToNextOptions = null;
	}

}
