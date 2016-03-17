package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProAlchemist extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(ModItems.steelIngot,10)},
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
				new ItemStack(ModItems.silverCoin,30)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
}
