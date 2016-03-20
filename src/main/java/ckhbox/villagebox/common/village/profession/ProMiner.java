package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProMiner extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.coal,8)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)},
				new ItemStack(Blocks.iron_ore,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,32)},
				new ItemStack(Blocks.gold_ore,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(Items.redstone,8)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,3)},
				new ItemStack(Items.diamond,1)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("miner");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.miner");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.iron_pickaxe),
				new ItemStack(Blocks.torch,12),
				new ItemStack(ModItems.silverCoin,2)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
}
