package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProScholar extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(ModItems.treasureHuntBookI)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5)},
				new ItemStack(ModItems.treasureHuntBookII)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.goldCoin,1)},
				new ItemStack(ModItems.treasureHuntBookIII)));
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
				new ItemStack(Items.emerald,20)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProWizard.class,
				ProPainter.class,
				};
	}

}
