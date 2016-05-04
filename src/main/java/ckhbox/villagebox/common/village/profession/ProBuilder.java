package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProBuilder extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.buildboxSmall)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,2)},
				new ItemStack(ModBlocks.buildboxMedium)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,4)},
				new ItemStack(ModBlocks.buildboxLarge)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,6)},
				new ItemStack(ModBlocks.buildboxExLarge)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("builder");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.builder");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Blocks.stonebrick,32),
				new ItemStack(Blocks.planks,32),
				new ItemStack(ModItems.silverCoin,2)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Blocks.planks),
				new ItemStack(Blocks.stonebrick)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();	
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.planks,32)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,16)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.cobblestone,32)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,16)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.glass,10)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
	}

}
