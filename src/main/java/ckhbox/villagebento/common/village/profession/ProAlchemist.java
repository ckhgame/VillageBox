package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.block.ModBlocks;
import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProAlchemist extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.alchemyPot)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("alchemist");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.alchemist");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.goldCoin,2)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
}
