package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProFisherman extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(ModItems.salt)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.seaweed)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)},
				new ItemStack(ModItems.shrimp)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)},
				new ItemStack(ModItems.crab)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("fisherman");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.fisherman");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.emerald,10),
				new ItemStack(Items.iron_ingot,8)
		};
		
		this.upgradeToNextOptions = null;
	}
	
}
