package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProPainter extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.painting)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("painter");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.painter");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin, 2),
				new ItemStack(Items.paper,64)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
}
