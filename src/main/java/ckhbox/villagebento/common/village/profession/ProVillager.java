package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public abstract class ProVillager extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)},
				new ItemStack(Items.apple)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)},
				new ItemStack(Items.egg)));
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.villager");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = null;
		this.upgradeToNextOptionClasses = new Class[]{
				ProPeasant.class,
				ProGatherer.class,
				ProScholar.class
				};
	} 

}
