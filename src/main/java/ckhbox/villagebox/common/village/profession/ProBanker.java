package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProBanker extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,64)},
				new ItemStack(ModItems.silverCoin,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,64)},
				new ItemStack(ModItems.goldCoin,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.bronzeCoin,64)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.goldCoin,1)},
				new ItemStack(ModItems.silverCoin,64)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("banker");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.banker");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.bronzeCoin,32)
		};
		
		this.upgradeToNextOptionClasses = null;
	}

	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(ModItems.silverCoin),
				new ItemStack(ModItems.goldCoin)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();	
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.DIAMOND,1)},
				new ItemStack[]{new ItemStack(ModItems.silverCoin,2)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.EMERALD,1)},
				new ItemStack[]{new ItemStack(ModItems.silverCoin,2)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.DIAMOND,1)},
				new ItemStack[]{new ItemStack(Items.ENDER_PEARL,1)}));
	}
}
