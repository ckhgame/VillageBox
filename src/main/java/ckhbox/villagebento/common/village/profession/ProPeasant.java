package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProPeasant extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.wheat,10)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.carrot,3)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.potato,3)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Blocks.pumpkin,1)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("peasant");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.peasant");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.bronzeCoin,20),
				new ItemStack(Items.iron_hoe,1)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProFlorist.class,
				ProOrchardist.class,
				ProRancher.class,
				ProFisherman.class,
				ProFarmer.class,
				ProCook.class
				};
	}

}
