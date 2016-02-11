package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProMiner extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.emerald,5)},
				new ItemStack(Items.coal,8)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.emerald,8)},
				new ItemStack(Blocks.iron_ore,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.emerald,32)},
				new ItemStack(Blocks.gold_block,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.emerald,10)},
				new ItemStack(Items.redstone,8)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.blueGem,2)},
				new ItemStack(Items.diamond,1)));
	}

	@Override
	protected void initAttributes() {
		this.maxEnegy = 100;
		this.maxProficiency = 200;
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
				new ItemStack(Items.emerald,10),
				new ItemStack(Items.iron_ingot,8)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProAdventurer.class,
				ProBombmaker.class
				};
	}
	
}
